package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;


public class AllSyntax extends AQLTest{

	@Test
	public void allSyntaxFileSyntax() throws Exception {
		System.out.println("----- allSyntaxFileSyntax -----");
		testFileSyntax("everything.aql");
	}
	@Test
	public void allSyntaxFileGenerationJava() throws Exception {
		System.out.println("----- allSyntaxFileGenerationJava -----");
		testFileGeneration("everything.aql", Language.JAVA);
	}
	@Test
	public void allSyntaxFileGenerationCsharp() throws Exception {
		System.out.println("----- allSyntaxFileGenerationCsharp -----");
		testFileGeneration("everything.aql", Language.CSHARP);
	}
	@Test
	public void allSyntaxFileGenerationGo() throws Exception {
		System.out.println("----- allSyntaxFileGenerationC -----");
		testFileGeneration("everything.aql", Language.GO);
	}


}
