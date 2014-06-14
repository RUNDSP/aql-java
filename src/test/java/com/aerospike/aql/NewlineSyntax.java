package com.aerospike.aql;

import org.junit.Test;


public class NewlineSyntax extends AQLTest{
	@Test
	public void newlineSyntaxStringSyntax() throws Exception {
		System.out.println("----- newlineSyntaxStringSyntax -----");
		testStringSyntax("# cats\n" +
				"INSERT INTO test.demo\n" +
				"	(PK, bn2, bn3, bn4)\n" + 
				"		VALUES\n" + 
				"			('3', 3, '2', 2)\n");
	}
	@Test
	public void newlineSyntaxFileSyntax() throws Exception {
		System.out.println("----- newlineSyntaxFileSyntax -----");
		testFileSyntax("Newline.aql");
	}
	@Test
	public void newlineSyntaxStringGenerationJava() throws Exception {
		System.out.println("----- newlineSyntaxStringGenerationJava -----");
		String result = testStringGeneration("INSERT INTO test.demo 	(PK, bn2, bn3, bn4) 		VALUES 			('3', 3, '2', 2)\n" +
				"INSERT INTO test.demo\n" +
				"	(PK, bn2, bn3, bn4)\n" + 
				"		VALUES\n" + 
				"			('3', 3, '2', 2)\n", AQL.Language.JAVA);
		System.out.println(result);
	}
	@Test
	public void newlineSyntaxFileGenerationJava() throws Exception {
		System.out.println("----- newlineSyntaxFileGenerationJava -----");
		testFileGeneration("Newline.aql", AQL.Language.JAVA);
	}

}
