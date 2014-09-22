package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.grammar.SystemOutReporter;
import com.aerospike.client.AerospikeClient;

public class PreparedStatementTests {
	@Test
	public void testShow() throws Exception {
		SystemOutReporter rep = new SystemOutReporter();
		AQL aql = new AQL(new AerospikeClient("127.0.0.1", 3000));
		PreparedStatement statement = aql.prepare("select * from test.demo", rep, rep);
		aql.execute(statement, rep, rep);

	}

}
