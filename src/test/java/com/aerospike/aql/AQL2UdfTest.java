package com.aerospike.aql;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.ResultCode;

public class AQL2UdfTest {

	private AerospikeClient client = new AerospikeClient("172.28.128.6", 3000);
	private GenericResult result;
	AQL aql2 = null;

	@Before 
	public void setup(){
		aql2 = new AQL(client, 20, ViewFormat.TABLE);
		result = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		for (int x = 0; x < 500; x++){
			Key key = new Key("test", "scanudf", "thing-"+x);
			this.client.put(null, key, new Bin("num", x + 100));
		}
		result = aql2.executeImmediate("set LUA_USERPATH 'user_udf'\n"
				+ "EXECUTE scanudf.time(0, 7500) ON test.scanudf");
		assertTrue(result.resultCode == ResultCode.OK);

	}

}
