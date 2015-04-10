package com.aerospike.aql;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;

public class AQLatApiTest {
	private AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
	private AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		GenericResult result = aql2.executeImmediate("select * from test.users where PK = 'user100'");
		System.out.println(result.record);
	}

}
