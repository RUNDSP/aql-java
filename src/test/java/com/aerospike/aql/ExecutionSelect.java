package com.aerospike.aql;

import org.junit.Test;

public class ExecutionSelect extends AQLTest {

	public ExecutionSelect() {
		super();
		seedNode = "P3";

	}

	@Test
	public void testSelectOnCluster() throws Exception {
		System.out.println("----- testSelectOnCluster -----");
		testFileExecution("Select.aql");
	}

}
