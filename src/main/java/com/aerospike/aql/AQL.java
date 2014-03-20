
package com.aerospike.aql;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;

import com.aerospike.aql.grammar.AQLCodeGenerator;
import com.aerospike.aql.grammar.AQLExecutor;
import com.aerospike.aql.grammar.AQLTreeAdaptor;
import com.aerospike.aql.grammar.AQLastLexer;
import com.aerospike.aql.grammar.AQLastParser;
import com.aerospike.aql.grammar.AQLastParser.aqlFile_return;
import com.aerospike.aql.grammar.AQLastParser.aqlStatements_return;
import com.aerospike.aql.grammar.IErrorReporter;
import com.aerospike.aql.grammar.IResultReporter;
import com.aerospike.aql.grammar.NoCaseFileStream;
import com.aerospike.aql.grammar.NoCaseInputStream;
import com.aerospike.aql.grammar.NoCaseStringStream;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;

public class AQL {
	public enum Language {
		C, CSHARP, JAVA;
	}

	private static Logger log = Logger.getLogger(AQL.class);

	private CommonTokenStream tokenStream;
	private AQLastLexer lexer;
	private AQLastParser parser;
	private StringTemplateGroup group;
	private AerospikeClient client = null;

	public AQL(){
		super();
	}

	public AQL(AerospikeClient client){
		this();
		this.client = client;
	}

	protected AQLastParser getFileParser(File file) throws IOException {
		CharStream stream = new NoCaseFileStream(file);
		getParser(stream);
		return this.parser;
	}
	protected AQLastParser getStringParser(String source) throws Exception{
		CharStream stream = new NoCaseStringStream(source);
		getParser(stream);
		return this.parser;
	}
	protected AQLastParser getStreamParser(InputStream inputStream) throws Exception{
		CharStream stream = new NoCaseInputStream(inputStream);
		getParser(stream);
		return this.parser;
	}
	protected AQLastParser getParser(CharStream stream){
		this.lexer = new AQLastLexer(stream);
		this.tokenStream = new CommonTokenStream(lexer);
		this.parser = new AQLastParser(tokenStream);
		this.parser.setTreeAdaptor(new AQLTreeAdaptor());
		this.parser.setErrorReporter(new IErrorReporter() {

			@Override
			public void reportError(int line, int charStart, int charEnd, String message) {
				log.error(line+":"+charStart+" "+message);
			}
		});
		return this.parser;
	}

	public void compile(File sqlFile, IErrorReporter reporter, IResultReporter resultReporter) throws IOException{
		CharStream stream = new NoCaseFileStream(sqlFile);
		AQLastLexer lexer = new AQLastLexer(stream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		AQLastParser parser = new AQLastParser(tokenStream);
		parser.setTreeAdaptor(new AQLTreeAdaptor());
		parser.setErrorReporter(reporter);
		parser.setResultReporter(resultReporter);
		try {
			parser.aqlFile();
		} catch (RecognitionException e) {
			reporter.reportError(e.line, e.charPositionInLine, e.charPositionInLine+e.token.getText().length(), e.getMessage());
		}
	}


	public void compileAndGenerate(File sqlFile, File outputDirectory,
			Language language, String host, int port) throws Exception {
		compileAndGenerate(sqlFile, outputDirectory,
				language, host, String.valueOf(port));

	}
	public String compileAndGenerateString(File inputFile, Language language, String host, String portString) throws Exception{
		URL url = null;
		String outputString = null;
		String moduleName = moduleFromFile(inputFile.getName());
		com.aerospike.aql.grammar.AQLastParser.aqlFile_return result =  getFileParser(inputFile).aqlFile();
		switch (language){
		case CSHARP:
			url = getClass().getResource("AS_C_Sharp.st");
			break;
		case C:
			url = getClass().getResource("AS_C.st");
			break;
		default:
			url = getClass().getResource("AS_Java.st");
			break;
		}

		this.group = new StringTemplateGroup(new InputStreamReader(url.openStream()));
		outputString = parseAndWalk(parser, result, moduleName, host, portString);
		return outputString;
	}
	public String compileAndGenerateString(String inputString, String moduleName, Language language, String host, String portString) throws Exception{
		URL url = null;
		String outputString = null;

		switch (language){
		case CSHARP:
			url = getClass().getResource("AS_C_Sharp.st");
			break;
		case C:
			url = getClass().getResource("AS_C.st");
			break;
		default:
			url = getClass().getResource("AS_Java.st");
			break;
		}

		this.group = new StringTemplateGroup(new InputStreamReader(url.openStream()));
		com.aerospike.aql.grammar.AQLastParser.aqlFile_return result =  getStringParser(inputString).aqlFile();
		outputString = parseAndWalk(parser, result, moduleName, host, portString);
		return outputString;
	}
	private String parseAndWalk(AQLastParser parser, com.aerospike.aql.grammar.AQLastParser.aqlFile_return result, String moduleName, String host, String portString) throws RecognitionException{
		String outputString = null;
		if (parser.getNumberOfSyntaxErrors() == 0){
			CommonTree tree = (CommonTree) result.getTree();
			log.debug("AST tree:");
			log.debug(tree.toStringTree());
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(this.tokenStream);
			AQLCodeGenerator walker = new AQLCodeGenerator(nodes);
			walker.setTemplateLib(this.group);
			com.aerospike.aql.grammar.AQLCodeGenerator.aqlFile_return returnValue = walker.aqlFile(moduleName, host, portString);
			log.debug("Walked tree:");
			log.debug(result.toString());
			StringTemplate st = (StringTemplate)returnValue.getTemplate();
			outputString = st.toString();
			if (walker.getNumberOfSyntaxErrors() > 0) {
				outputString = "Errors in AST tree";
				log.error(outputString);
			}

		} else {
			outputString = "Syntax errors: " + this.parser.getNumberOfSyntaxErrors();
			log.error(outputString);
		}		
		return outputString;
	}
	public void compileAndGenerate(File inputfile, File outputFile, Language language, String host, String portString) throws Exception{
		getFileParser(inputfile);
		String moduleName = moduleFromFile(inputfile.getName());
		String outputFileName = "output";
		String extension = null;
		switch (language){
		case CSHARP:
			extension = ".cs";
			break;
		case C:
			extension = ".c";
			break;
		default:
			extension = ".java";
			break;
		}

		if (outputFile == null){
			outputFileName = moduleName + extension;
			outputFile = new File(outputFileName);
		} if (outputFile.isDirectory()){
			outputFile = new File(outputFile.getAbsolutePath() + "/" + moduleName + extension);
		}

		String content = compileAndGenerateString(inputfile, language, host, portString);

		if (!outputFile.exists()){
			outputFile.createNewFile();
		}

		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();	

	}
	private String moduleFromFile(String fileName){
		String moduleName = fileName;
		if (moduleName.contains(".")){
			moduleName = moduleName.substring(0, moduleName.lastIndexOf("."));
		}
		return moduleName;
	}
	
	public void execute(File file, IResultReporter resultReporter, IErrorReporter errorReporter) {
		if (this.client == null){
			if (resultReporter != null)
				resultReporter.report("Aerospike client is null");
			else
				log.error("Aerospike client is null");
			return;
		}
		if (file == null){
			if (resultReporter != null)
				resultReporter.report("Error: No input file");
			else
				log.error("Error: No input file");
			return;
		}
		if (!file.exists()){
			if (resultReporter != null)
				resultReporter.report("Error: Input file does not exist");
			else
				log.error("Error: Input file does not exist");
			return;
		}
		try{
			AQLastParser astParser = getFileParser(file);
			aqlFile_return result = astParser.aqlFile();
			if (astParser.getNumberOfSyntaxErrors() == 0){
				CommonTree tree = (CommonTree) result.getTree();
				if (tree == null)
					return;
				log.debug("AST tree:");
				log.debug(tree.toStringTree());
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				nodes.setTokenStream(this.tokenStream);
				AQLExecutor walker = new AQLExecutor(nodes, this.client);
				walker.setErrorReporter(errorReporter);
				walker.aqlFile();
				if (walker.getNumberOfSyntaxErrors() > 0) {
					log.error("Errors in AST tree: " + walker.getNumberOfSyntaxErrors());
				}

			} else {
				log.error("Syntax errors: " + this.parser.getNumberOfSyntaxErrors());
			}
		} catch (IOException e){
			resultReporter.report(e.getMessage());
			log.error(e.getMessage(), e);
		} catch (RecognitionException e) {
			resultReporter.report(e.getMessage());
			log.error(e.getMessage(), e);
		} catch (AerospikeException e) {
			resultReporter.report(e.getMessage());
			log.error(e.getMessage(), e);
		}
	}
	public void interpret(InputStream in) throws Exception{

		//  interactive
		System.out.print("aql > ");

		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String commandline = null;

		try {
			while (true){
				commandline = br.readLine();
				if (commandline == null || commandline.isEmpty())
					continue;
				log.debug(commandline);
				getStringParser(commandline);
				try {
					aqlStatements_return result =  this.parser.aqlStatements();
					if (this.parser.getNumberOfSyntaxErrors() == 0){
						CommonTree tree = (CommonTree) result.getTree();
						if (tree == null)
							continue;
						log.debug("AST tree:");
						log.debug(tree.toStringTree());
						CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
						nodes.setTokenStream(this.tokenStream);
						AQLExecutor walker = new AQLExecutor(nodes, this.client);
						walker.setErrorReporter(new IErrorReporter() {

							@Override
							public void reportError(int line, int charStart, int charEnd, String message) {
								log.error(line+":"+charStart+" "+message);
							}
						});
						walker.aqlStatement();
						if (walker.getNumberOfSyntaxErrors() > 0) {
							log.error("Errors in AST tree: " + walker.getNumberOfSyntaxErrors());
						}

					} else {
						log.error("Syntax errors: " + this.parser.getNumberOfSyntaxErrors());
					}
				} catch (AerospikeException ae){
					log.error("Aerospike error: " + ae.getMessage());
					log.debug(ae.getMessage(), ae);
				}
				System.out.print("aql > ");
			}
		} catch (IOException ioe) {
			log.error("Error processing command: " + commandline, ioe);
			System.exit(1);
		}

	}

}
