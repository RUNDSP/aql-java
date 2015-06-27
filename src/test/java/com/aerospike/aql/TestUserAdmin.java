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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.ResultCode;
import com.aerospike.aql.*;

public class TestUserAdmin {
	
	AQL aql2 = null;

	@Before
	public void setUp() throws Exception {
		aql2 = new AQL(new AerospikeClient("127.0.0.1", 3000), 1000, ViewFormat.TABLE);
		aql2.setResultsReporter(null);
	}

	//@Test
	public void testAllInSequence() {
	   aql2.execute("CREATE ROLE god PRIVILEGES sys-admin.test.demo");
	   aql2.execute("SHOW ROLE god");
	   aql2.execute("CREATE ROLE pleb PRIVILEGES read.test.demo");
	   aql2.execute("show roles");
	   aql2.execute("CREATE USER bob PASSWORD bob ROLE god");
	   aql2.execute("CREATE USER bill PASSWORD bill ROLE god");
	   aql2.execute("SHOW USERS");
	   aql2.execute("SET PASSWORD cats FOR bill");
       aql2.execute("GRANT ROLE god, pleb TO bill");
	   aql2.execute("SHOW USER bill");
       aql2.execute("revoke ROLE god from bill");
	   aql2.execute("SHOW USER bill");
	   aql2.execute("DROP USER bill");
	   aql2.execute("SHOW USERS");
       aql2.execute("GRANT ROLE god, pleb TO bill");
       aql2.execute("DROP ROLE pleb");
	   aql2.execute("show roles");
//       GRANT PRIVILEGE[S] <priv1[.ns1[.set1]]>,<priv2[.ns2[.set2]]>... TO <role>
//       REVOKE PRIVILEGE[S] <priv1[.ns1[.set1]]>,<priv2[.ns2[.set2]]>... FROM <role>
	}
	//@Test
	public void testCreateAdminRole(){
		GenericResult result = aql2.executeImmediate("CREATE ROLE god PRIVILEGES sys-admin");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	//@Test
	public void testCreatePlebRole(){
		GenericResult result = aql2.executeImmediate("CREATE ROLE pleb PRIVILEGES read.test.demo");
		assertTrue(result.resultCode == ResultCode.OK);
	}
}
