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

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;
import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;

public class OperateGenerationTest {
	AQL aql2 = null;
	@Before
	public void setUp() throws Exception {
		aql2 = new AQL();
	}

	@Test
	public void testJavaGenerateOperateJava() throws Exception {
		File inputFile = new File("src/test/resources/Operate.aql");
		File outputFile = new File("CodeGeneration/Java/Operate.java");
		aql2.generate(inputFile, outputFile, Language.JAVA);
	}

	@Test
	public void testJavaGenerateOperateGo() throws Exception {
		File inputFile = new File("src/test/resources/Operate.aql");
		File outputFile = new File("CodeGeneration/go/Operate.go");
		aql2.generate(inputFile, outputFile, Language.GO);
	}

	@Test
	public void testJavaGenerateOperateCsharp() throws Exception {
		File inputFile = new File("src/test/resources/Operate.aql");
		File outputFile = new File("CodeGeneration/csharp/Operate.cd");
		aql2.generate(inputFile, outputFile, Language.CSHARP);
	}

}
