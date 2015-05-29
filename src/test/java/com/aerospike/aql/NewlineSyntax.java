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
				"			('3', 3, '2', 2)\n", Language.JAVA);
		System.out.println(result);
	}
	@Test
	public void newlineSyntaxFileGenerationJava() throws Exception {
		System.out.println("----- newlineSyntaxFileGenerationJava -----");
		testFileGeneration("Newline.aql", Language.JAVA);
	}

}
