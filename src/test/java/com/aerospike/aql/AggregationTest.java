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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;
import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.ResultCode;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.task.IndexTask;
import com.aerospike.client.task.RegisterTask;

public class AggregationTest {
	private static final int MAX_RECORDS = 100000;
	private static final String EVENT_ID_BIN = "eventid";
	private static final String TIME_BIN = "time";
	private static final String LIST_BIN = "interests";
	private static final String EVENT_ID_PREFIX = "Event:";
	private AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
	private GenericResult result;
	AQL aql2 = null;

	@Before 
	public void setup(){
		aql2 = new AQL(client, 20, ViewFormat.TABLE);
		result = null;
	}
	@Test
	public void testFlightAggregation() throws Exception {
		System.out.println("----- testFileAggregationSyntax -----");
		result = aql2.executeImmediate("AGGREGATE simple_aggregation.late_flights_by_airline() "
				+ "ON test.flights WHERE FL_DATE_BIN BETWEEN 1325404800 and 1325404800");
		assertTrue(result.resultCode == ResultCode.OK);
	}

	@Test
	public void testFileTop10() throws Exception {
		System.out.println("----- testFileTop10 -----");
		this.client = new AerospikeClient("172.28.128.6", 3000);
		//eventSetup();
		
		result = aql2.executeImmediate("AGGREGATE leaderboard.top(10) ON test.demo "
				+ "WHERE time BETWEEN 1444331150188 and 1444331152773");
		assertTrue(result.resultCode == ResultCode.OK);

	}
	String[] interests = {"cats", "dogs", "mice", "birds", "lizards"};
	Random rand = new Random();

	private void eventSetup(){
		/*
		 * Create index for query
		 * Index creation only needs to be done once and can be done using AQL or ASCLI also
		 */
		IndexTask it = this.client.createIndex(null, "test", "events", "top-10", TIME_BIN, IndexType.NUMERIC);
		it.waitTillComplete();
		/*
		 * Register UDF module
		 * Registration only needs to be done after a change in the UDF module.
		 */
		RegisterTask rt = this.client.register(null, "udf/leaderboard.lua", "leaderboard.lua", com.aerospike.client.Language.LUA);
		rt.waitTillComplete();
		for (int index = 1; index <= MAX_RECORDS; index++){
			String keyString = EVENT_ID_PREFIX + index;
			long now = System.currentTimeMillis();
			Key key = new Key("test", "events", keyString);
			Bin eventIdBin = new Bin(EVENT_ID_BIN, keyString);
			Bin eventTSBin = new Bin(TIME_BIN, now);
			Bin eventListBin = new Bin(LIST_BIN, getList());
			this.client.put(null, key, eventIdBin, eventTSBin, eventListBin);
			System.out.println("Created: " + keyString);
		}

	}
	private List<String> getList(){
		ArrayList<String> list = new ArrayList<String>();
		int limit = rand.nextInt(5);
		for (int i = 0; i < limit; i++){
			list.add(interests[rand.nextInt(limit)]);
		}
		return list;
	}

}
