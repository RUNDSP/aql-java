package com.aerospike.aql;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHelp() {
		AQLrun.main(new String[]{"--help"});

	}

}
