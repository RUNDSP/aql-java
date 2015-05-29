/* 
 * Copyright 2012-2015 Aerospike, Inc.
 *
 * Portions may be licensed to Aerospike, Inc. under one or more contributor
 * license agreements.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;


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
		testFileGeneration("UdfAll.aql", Language.JAVA);
	}
	@Test
	public void testUDFOnCluster() throws Exception {
		System.out.println("----- testUDFOnCluster -----");
		testFileExecution("UdfAll.aql");

	}

}
