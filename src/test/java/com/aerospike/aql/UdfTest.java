package com.aerospike.aql;

import org.junit.Test;


public class UdfTest extends AQLTest{
	
	public UdfTest(){
		super();
		this.seedNode = "192.168.180.140";
	}


	@Test
	public void testUDFString() throws Exception {
		System.out.println("----- testUDFString -----");
		testStringSyntax("execute test.example_lua('b1','v1','a','newfoo') on test.demo where PK='1'");
	}
	@Test
	public void testRegisterUDFString() throws Exception {
		System.out.println("----- testRegisterUDFString -----");
		testStringSyntax("REGISTER module 'src/test/resources/example1.lua'");
	}
	@Test
	public void testShowModulesString() throws Exception {
		System.out.println("----- testShowModulesString -----");
		testStringSyntax("SHOW modules");
	}
	@Test
	public void testDescModuleString() throws Exception {
		System.out.println("----- testDescModuleString -----");
		testStringSyntax("desc module example1.lua");
	}
	@Test
	public void testDropModuleString() throws Exception {
		System.out.println("----- testDropModuleString -----");
		testStringSyntax("drop module example1.lua");
	}
	@Test
	public void testUDFFile() throws Exception {
		System.out.println("----- testUDFFile -----");
		testFileSyntax("UdfAll.aql");
	}
	@Test
	public void testUDFFileGeneration() throws Exception {
		System.out.println("----- testUDFFileGeneration -----");
		testFileGeneration("UdfAll.aql", AQL.Language.JAVA);
	}
	@Test
	public void testUDFOnCluster() throws Exception {
		System.out.println("----- testUDFOnCluster -----");
		testFileExecution("UdfAll.aql");

	}

}
