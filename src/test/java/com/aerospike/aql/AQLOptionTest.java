package com.aerospike.aql;

import org.junit.Test;


public class AQLOptionTest {
	public static final String HOST = "192.168.51.188";
	public static final String PORT = "3000";

	@Test
	public void usageTest() {
		AQLrun.main(new String[]{"-h", HOST, "-p", PORT, "-u"});
	}

	//@Test
	public void noInputFileTest() {
		AQLrun.main(new String[]{"-h", HOST, "-p", PORT, "-u", "-c"});
	}
}
