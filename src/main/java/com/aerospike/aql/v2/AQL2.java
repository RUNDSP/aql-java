
package com.aerospike.aql.v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.aerospike.aql.v2.AQLGenerator.Language;
import com.aerospike.aql.v2.grammar.AQLLexer;
import com.aerospike.aql.v2.grammar.AQLParser;
import com.aerospike.aql.v2.grammar.IErrorReporter;
import com.aerospike.aql.v2.grammar.NoCaseFileStream;
import com.aerospike.aql.v2.grammar.NoCaseInputStream;
import com.aerospike.client.AerospikeClient;

public class AQL2 {
	public enum WalkerAction {
		EXECUTE, GENERATE;
	}

	private static Logger log = Logger.getLogger(AQL2.class);
	private ParseTreeWalker walker = new ParseTreeWalker();
	private AerospikeClient client;
	private int timeout;
	private Language generationLanguage;
	private String fileExtension;
	private IErrorReporter errorReporter = null;
	private IResultReporter resultReporter = new AQLConsole();


	public AQL2() {
		super();
	}

	public AQL2(AerospikeClient client, int timeout){
		this();
		this.client = client;
		this.timeout = timeout;
	}

	private CommonTokenStream getTokenStream(ANTLRInputStream is){
		AQLLexer lexer = new AQLLexer(is);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return tokens;
	}

	private ParseTree compile(CommonTokenStream tokens){
		AQLParser parser = new AQLParser(tokens);
		ParseTree tree = parser.aql();
		return tree;
	}
	/**
	 * Syntax checks a file containing AQL
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public ParseTree compile(File file) throws IOException{
		log.debug("Compiling file: " + file.toString());
		CommonTokenStream tokens = getTokenStream(new NoCaseFileStream(file));
		return compile(tokens);
	}
	/**
	 * Syntax checks an AQL string
	 * @param aqlString
	 * @return
	 */
	public ParseTree compile(String aqlString) {
		log.debug("Compiling string: " + aqlString);
		CommonTokenStream tokens = getTokenStream(new NoCaseInputStream(aqlString));
		return compile(tokens);
	}

	private AQLExecutor execute(CommonTokenStream tokens, AQLExecutor executor){
		AQLParser parser = new AQLParser(tokens);
		ParseTree tree = parser.aql();
		if (executor == null)
			executor = new AQLExecutor(parser, this.client, this.timeout);
		walker.walk(executor, tree);
		return executor;
	}
	/**
	 * Execute the contents of an AQL file.
	 * The file will be compiled and executed using
	 * the Aerospike client supplied in the constructor
	 * @param file
	 */
	public AQLExecutor execute(File file, AQLExecutor executor) throws IOException{
		log.debug("Executing file: " + file.toString());
		CommonTokenStream tokens = getTokenStream(new NoCaseFileStream(file));
		return execute(tokens, executor);
	}
	/**
	 * Execute an AQL string.
	 * The string will be compiled and executed using
	 * the Aerospike client supplied in the constructor
	 * @param aqlString
	 */
	public AQLExecutor execute(String aqlString, AQLExecutor executor) {
		log.debug("Executing string: " + aqlString);
		CommonTokenStream tokens = getTokenStream(new NoCaseInputStream(aqlString));
		return execute(tokens, executor);
	}

	private String generate(CommonTokenStream tokens, Language language, String name){
		boolean runnable = name != null;
		/*
		 * runnable is true, generated code will include a main method/function
		 */
		setGenerationLanguage(language);
		AQLParser parser = new AQLParser(tokens);
		AQLGenerator generator = new AQLGenerator(parser, name, "127.0.0.1", 3000, language);
		ParseTree tree = (runnable) ? parser.aql() : parser.statements();
		walker.walk(generator, tree);
		String code = generator.getST(tree).render();
		log.debug("Generated code:\n" + code);
		return code;
	}
	/**
	 * Generate the contents of an AQL file.
	 * The contents of the file will produce API calls 
	 * @param file
	 */
	public void generate(File inputFile, File outputFile, Language language) throws IOException{
		log.debug("Generating file: " + inputFile.toString());
		String name = outputFile.getName();
		name = name.substring(0, name.lastIndexOf('.'));
		CommonTokenStream tokens = getTokenStream(new NoCaseFileStream(inputFile));
		String code = generate(tokens, language, name);
		FileWriter fw = new FileWriter(outputFile);
		fw.write(code);
		fw.close();
	}
	/**
	 * Generate an AQL string.
	 * The generated string will produce API calls 
	 * @param aqlString
	 */
	public String generate(String aqlString, Language language) {
		log.debug("Generating string: " + aqlString);
		CommonTokenStream tokens = getTokenStream(new NoCaseInputStream(aqlString));
		return generate(tokens, language, null);
	}

	/**
	 * Sets the generation language
	 * Valid values are: JAVA, C, CSHARP, PYTHON, GO, PHP, NODE, RUBY
	 * The default is JAVA
	 * @param generationLanguage
	 */
	public void setGenerationLanguage(Language generationLanguage) {
		this.generationLanguage = generationLanguage;
		switch (this.generationLanguage) {
		case JAVA:
			this.fileExtension = ".java";
			break;
		case C:
			this.fileExtension = ".c";
			break;
		case CSHARP:
			this.fileExtension = ".csharp";
			break;
		case GO:
			this.fileExtension = ".go";
			break;
		case PYTHON:
			this.fileExtension = ".py";
			break;
		case PHP:
			this.fileExtension = ".php";
			break;
		case NODE:
			this.fileExtension = ".js";
			break;
		case RUBY:
			this.fileExtension = ".ruby";
			break;
		}
	}


	public void setErrorReporter(IErrorReporter errorReporter) {
		this.errorReporter = errorReporter;
	}
	public void setResultReporter(IResultReporter resultReporter) {
		if (resultReporter != null)
			this.resultReporter = resultReporter;
	}

	public void interpret() {
		AQLConsole console = (AQLConsole) this.resultReporter;
		AQLExecutor executor = null;
		while (true){
			console.print("AQL> ");
			String input = console.readLine();
			executor = execute(input, executor);
		}
		
	}


}
