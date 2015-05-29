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
