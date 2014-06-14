package com.aerospike.aql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

import junit.framework.Assert;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

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
import com.aerospike.aql.grammar.NoCaseStringStream;
import com.aerospike.aql.grammar.SystemOutReporter;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Log;
import com.aerospike.client.Record;
import com.aerospike.client.Log.Level;
import com.aerospike.client.query.RecordSet;

public class AQLTest {
	public static final int JAVA = 1;
	public static final int C = 2;
	public static final int NONE = 0;

	protected String seedNode = "127.0.0.1";
	protected int port = 3000; 
	protected int stType = NONE;

	protected StringTemplateGroup group = null;
	private CommonTokenStream tokenStream;
	private AQLastLexer lexer;
	private AQLastParser parser;
	private String workingDir;
	private String templatePath;
	private String testDataPath;
	private AerospikeClient client;
	protected SystemOutReporter reporter = new SystemOutReporter();

	public AQLTest() {
		workingDir = System.getProperty("user.dir");
		templatePath = workingDir + "/Templates/";
		testDataPath = workingDir + "/TestData/";
		String seedHost = System.getenv("seedHost");
		String port = System.getenv("port");
		if (seedHost != null)
			this.seedNode = seedHost;
		if (port != null)
			this.port = Integer.parseInt(port);
		System.out.printf("Host: %s, Port: %d\n", this.seedNode, this.port);
	}

	public void setSeedNode(String seedNode, int port){
		this.seedNode = seedNode;
		this.port = port;
		System.out.printf("Host: %s, Port: %d\n", this.seedNode, this.port);
	}
	
	protected File findFile(String name){
		URL url = this.getClass().getClassLoader().getResource(name);
		return new File(url.getPath());
	}

	protected AQLastParser getFileParser(File file) throws Exception{
		CharStream stream = new NoCaseFileStream(file);
		getParser(stream);
		return this.parser;
	}
	protected AQLastParser getFileParser(String name) throws Exception{
		CharStream stream = new NoCaseFileStream(findFile( name ));
		getParser(stream);
		return this.parser;
	}
	protected AQLastParser getStringParser(String source) throws Exception{
		CharStream stream = new NoCaseStringStream(source);
		getParser(stream);
		return this.parser;
	}

	private AQLastParser getParser(CharStream stream){
		this.lexer = new AQLastLexer(stream);
		this.tokenStream = new CommonTokenStream(lexer);
		this.parser = new AQLastParser(tokenStream);
		this.parser.setTreeAdaptor(new AQLTreeAdaptor());
		this.parser.setErrorReporter(this.reporter);
		return this.parser;
	}




	protected void testFileGeneration(String name, AQL.Language stType) throws Exception{
		String extension = null;
		String langDir = null;
		switch(stType){
		case JAVA:
			extension = ".java";
			langDir = "java/";
			break;
		case C:
			extension = ".c";
			langDir = "c/";
			break;
		default:
			throw new Exception("Invalid Template Type. Myst be JAVA or C");
		}
		File dir = new File(workingDir +"/CodeGeneration/" + langDir);
		if (!dir.exists())
			dir.mkdirs();
		// if file doesnt exists, then create it
		String outFileName = name.substring(0, name.lastIndexOf(".")) + extension;
		File file = new File(workingDir +"/CodeGeneration/" + langDir + outFileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		URL url = getClass().getResource("/"+name);
		File sourceFile = new File(url.getFile());
		System.out.println(sourceFile.exists());
		AQL aql = new AQL();
		aql.compileAndGenerate(sourceFile, file, stType, this.seedNode, this.port);
	}

	
	private void mkDirs(File root, String[] dirs, int depth) {
		if (depth == 0) return;
		for (String s : dirs) {
			File subdir = new File(root, s);
			subdir.mkdir();
			mkDirs(subdir, dirs, depth - 1);
		}
	}
	
	protected void testFileSyntax(String name) throws Exception{
		AQL aql = new AQL();
		aqlFile_return result = aql.compile(findFile( name ), reporter, reporter);
//		CommonTree tree = (CommonTree) result.getTree();
//		System.out.println(tree.toStringTree());


	}
	
	protected void testStringGeneration(String source, AQL.Language language) throws Exception{
		AQL aql = new AQL();
		aql.compileAndGenerateString(source, "TestModule", language, this.seedNode, String.valueOf(this.port));

	}

	protected void testStringSyntax(String source) throws Exception{
		AQL aql = new AQL();
		aqlStatements_return result = aql.compile(source, 
				reporter, 
				reporter);
//		CommonTree tree = (CommonTree) result.getTree();
//		System.out.println(tree.toStringTree());
	}

	
	protected void testFileExecution(String seedNode, int port, String fileName) throws Exception{
		setSeedNode(seedNode, port);
		testFileExecution(fileName);
	}
	
	protected void testFileExecution(String fileName) throws Exception{
		if (this.client == null)
			this.client = new AerospikeClient(this.seedNode, this.port);
		getFileParser(fileName);
		com.aerospike.aql.grammar.AQLastParser.aqlFile_return result =  this.parser.aqlFile();
		if (this.parser.getNumberOfSyntaxErrors() == 0){
			CommonTree tree = (CommonTree) result.getTree();
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
			nodes.setTokenStream(this.tokenStream);
			AQLExecutor walker = new AQLExecutor(nodes, this.client);
			walker.setResultReporter(new SystemOutReporter());
			walker.aqlFile();
			checkErrors(walker);

		} else {
			Assert.fail();
		}

	}
	
	public void checkErrors(AQLastParser parser){
		if (parser.getNumberOfSyntaxErrors() > 0) {
			Assert.fail();
		}
	}

	public void checkErrors(AQLExecutor walker){
		if (walker.getNumberOfSyntaxErrors() > 0) {
			Assert.fail();
		}
	}

	public void checkErrors(AQLCodeGenerator walker){
		if (walker.getNumberOfSyntaxErrors() > 0) {
			Assert.fail();
		}
	}
	public void checkErrors(IErrorReporter reporter){
		if (reporter.getErrors() > 0) {
			Assert.fail();
		}
	}

}
