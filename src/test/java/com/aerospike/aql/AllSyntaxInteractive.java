package com.aerospike.aql;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AllSyntaxInteractive {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUdf() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Udf.aql" });
	}
	
	@Test
	public void testAdmin() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Admin.aql" });
	}
	
	@Test
	public void testPkTest() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/PkTest.aql" });
	}
	
	@Test
	public void testScan() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Scan.aql" });
	}
	
	@Test
	public void testSelect() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/Select.aql" });
	}
	
	@Test
	public void testQueryFilter() {
		AQLrun.main(new String[]{"-h", "P3", "-p", "3000", "-f", "src/test/resources/QueryFilter.aql" });
	}

}
