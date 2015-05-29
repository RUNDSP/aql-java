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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AllSyntaxInteractive {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUdf() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Udf.aql" });
	}
	
	@Test
	public void testAdmin() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Admin.aql" });
	}
	
	@Test
	public void testPkTest() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/PkTest.aql" });
	}
	
	@Test
	public void testScan() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Scan.aql" });
	}
	
	@Test
	public void testSelect() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Select.aql" });
	}
	
	@Test
	public void testQueryFilter() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/QueryFilter.aql" });
	}

}
