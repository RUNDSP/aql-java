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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecognitionTests {

	@Test
	public void testMapKeys() {
		AQL aql2 = new AQL();
		aql2.compile("CREATE MAPKEYS INDEX index_on_mapkeys ON test.demo (amap) string");
		assertEquals(aql2.getErrorCount(), 0);
		aql2.compile("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}')");
		assertEquals(aql2.getErrorCount(), 0);
		aql2.compile("select * in mapkeys from test.demo where amap = 'first'");
		assertEquals(aql2.getErrorCount(), 0);
	}
	@Test
	public void testListKeys() {
		AQL aql2 = new AQL();
		aql2.compile("CREATE LIST INDEX index_on_list_numeric ON test.demo (alist) numeric");
		aql2.compile("INSERT INTO test.demo (PK, bn2, bn3, bn4, alist) VALUES ('test-select-list2', 5, '2', 2, 'JSON[12,43,67,123,765, 25,100,9,562,345,7856,2]')");
		aql2.compile("select *  in list from test.demo where alist between 100 and 1000");
	}

}
