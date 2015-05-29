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

public class UpdateTest extends AQLTest{
	@Test
	public void uopdateFileSyntax() throws Exception {
		System.out.println("----- uupdateFileSyntax -----");
		testFileSyntax("Update.aql");
	}
	@Test
	public void touchStringTTLGeneration() throws Exception {
		System.out.println("----- touchStringTTLGeneration -----");
		System.out.println(testStringGeneration("update test.cats SET ttl = 3000 where pk = '1234' and generation = 98765", Language.JAVA));
	}
	@Test
	public void updateStringTTLGeneration() throws Exception {
		System.out.println("----- updateStringTTLGeneration -----");
		System.out.println(testStringGeneration("update test.cats SET ttl = 3000, bob = 23, sue = 'abc' where pk = '1234' and generation = 98765", Language.JAVA));
	}
	@Test
	public void updateFileGeneration() throws Exception {
		System.out.println("----- updateFileGeneration -----");
		testFileGeneration("Update.aql", Language.JAVA);
	}
	@Test
	public void updateFileExecution() throws Exception {
		System.out.println("----- updateFileExecution -----");
		testFileExecution("localhost", 3000, "Update.aql");
	}

}
