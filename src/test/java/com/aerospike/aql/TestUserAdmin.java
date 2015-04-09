package com.aerospike.aql;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.ResultCode;

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
		GenericResult result = aql2.go("CREATE ROLE god PRIVILEGES sys-admin");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	//@Test
	public void testCreatePlebRole(){
		GenericResult result = aql2.go("CREATE ROLE pleb PRIVILEGES read.test.demo");
		assertTrue(result.resultCode == ResultCode.OK);
	}
}
