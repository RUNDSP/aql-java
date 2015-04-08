package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;

public class ScanTest extends AQLTest{
	@Test
	public void scanFileSyntax() throws Exception {
		System.out.println("----- scanFileSyntax -----");
		testFileSyntax("Scan.aql");
	}
	@Test
	public void scanFileGeneration() throws Exception {
		System.out.println("----- scanFileGeneration -----");
		testFileGeneration("Scan.aql", Language.JAVA);
	}
	@Test
	public void scanFileExecution() throws Exception {
		System.out.println("----- scanFileExecution -----");
		testFileExecution("localhost", 3000, "Scan.aql");
	}

}
