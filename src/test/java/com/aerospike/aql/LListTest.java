package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;

public class LListTest extends AQLTest{
	@Test
	public void allLListFileSyntax() throws Exception {
		System.out.println("----- allLListFileSyntax -----");
		testFileSyntax("LList.aql");
	}
	@Test
	public void allLListFileGeneration() throws Exception {
		System.out.println("----- allLListFileGeneration -----");
		testFileGeneration("LList.aql", Language.JAVA);
	}
	@Test
	public void allLListFileExecution() throws Exception {
		System.out.println("----- allLListFileExecution -----");
		testFileExecution("P3", 3000, "LList.aql");
	}
	
}
