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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;
import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;

public class OperateExecutionTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testJavaGenerateOperateJava() throws Exception {
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Operate.aql");
		aql2.execute(inputFile);
		int errors = aql2.getErrorCount();
		if (errors > 0){
			List<String> errorList = aql2.getErrorList();
			System.out.println("\nErrors: " + errors);
			for (String error : errorList){
				System.out.println("\t" + error);
			}
		}
		assertTrue(errors == 0);
	}


}
