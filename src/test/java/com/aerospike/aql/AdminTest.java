package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;


public class AdminTest extends AQLTest {

	public AdminTest() {
		super();
	}
	@Test
	public void testFileAdminSyntax() throws Exception {
		System.out.println("----- testFileAdminSyntax -----");
		testFileSyntax("Admin.aql");
	}

	@Test
	public void testAdminFile() throws Exception {
		System.out.println("----- testAdminFile -----");
		testFileGeneration("Admin.aql", Language.JAVA);
			
	}

	@Test
	public void testAdminOnCluster() throws Exception {
		System.out.println("----- testAdminOnCluster -----");
		testFileExecution("Admin.aql");
	}

}
