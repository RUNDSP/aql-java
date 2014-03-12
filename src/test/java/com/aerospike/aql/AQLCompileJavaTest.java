package com.aerospike.aql;

import org.junit.Test;


public class AQLCompileJavaTest {
	public static final String HOST = "P3";
	public static final String PORT = "3000";
	@Test
	public void testPrimaryKey() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/PkTest.aql", "-o", "src/output/PkTest.java", "-l", "JAVA"});

	}

	@Test
	public void testScan() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Scan.aql", "-o", "src/output/Scan.java", "-l", "JAVA"});

	}
	
	@Test
	public void testSelect() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Select.aql", "-o", "src/output/Select.java", "-l", "JAVA"});

	}
	@Test
	public void testAdmin() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Admin.aql", "-o", "src/output/Admin.java", "-l", "JAVA"});

	}
	@Test
	public void testUdf() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Udf.aql", "-o", "src/output/Udf.java", "-l", "JAVA"});
		//AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Udf.aql", "-o", "src/output/Udf.c", "-l", "C"});

	}
	@Test
	public void testFilter() throws Exception {
		//AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/FilterExample.aql", "-o", "src/output/FilterExample.java", "-l", "JAVA"});
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/QueryFilter.aql", "-o", "src/output/QueryFilter.java", "-l", "JAVA"});

	}
	@Test
	public void testExample1() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Example1.aql", "-o", "src/output/Example1.java", "-l", "JAVA"});

	}
	@Test
	public void testExample2() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Example2.aql", "-o", "src/output/Example2.java", "-l", "JAVA"});

	}
}
