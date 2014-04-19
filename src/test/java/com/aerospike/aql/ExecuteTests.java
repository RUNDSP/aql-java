package com.aerospike.aql;

import org.junit.Test;

public class ExecuteTests {
	public static final String HOST = "P3";
	public static final String PORT = "3000";

	@Test
	public void testShow() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-f", "src/test/resources/Admin.aql"});

	}

}
