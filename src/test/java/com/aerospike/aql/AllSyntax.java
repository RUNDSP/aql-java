package com.aerospike.aql;

import org.junit.Test;


public class AllSyntax extends AQLTest{

	@Test
	public void allSyntaxFileSyntax() throws Exception {
		System.out.println("----- allSyntaxFileSyntax -----");
		testFileSyntax("everything.aql");
	}
	@Test
	public void allSyntaxFileGenerationJava() throws Exception {
		System.out.println("----- allSyntaxFileGenerationJava -----");
		testFileGeneration("everything.aql", AQL.Language.JAVA);
	}
	@Test
	public void allSyntaxFileGenerationC() throws Exception {
		System.out.println("----- allSyntaxFileGenerationC -----");
		testFileGeneration("everything.aql", AQL.Language.C);
	}
	@Test
	public void allSyntaxFileGenerationPython() throws Exception {
		System.out.println("----- allSyntaxFileGenerationC -----");
		testFileGeneration("everything.aql", AQL.Language.PYTHON);
	}


}
