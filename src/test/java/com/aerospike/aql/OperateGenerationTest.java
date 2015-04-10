package com.aerospike.aql;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;
import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;

public class OperateGenerationTest {
	AQL aql2 = null;
	@Before
	public void setUp() throws Exception {
		aql2 = new AQL();
	}

	@Test
	public void testJavaGenerateOperateJava() throws Exception {
		File inputFile = new File("src/test/resources/Operate.aql");
		File outputFile = new File("CodeGeneration/Java/Operate.java");
		aql2.generate(inputFile, outputFile, Language.JAVA);
	}

	@Test
	public void testJavaGenerateOperateGo() throws Exception {
		File inputFile = new File("src/test/resources/Operate.aql");
		File outputFile = new File("CodeGeneration/go/Operate.go");
		aql2.generate(inputFile, outputFile, Language.GO);
	}

	@Test
	public void testJavaGenerateOperateCsharp() throws Exception {
		File inputFile = new File("src/test/resources/Operate.aql");
		File outputFile = new File("CodeGeneration/csharp/Operate.cd");
		aql2.generate(inputFile, outputFile, Language.CSHARP);
	}

}
