package com.aerospike.aql;

import org.junit.Test;


public class AQLCompileGoTest {
	public static final String HOST = "127.0.0.1";
	public static final String PORT = "3000";
	@Test
	public void testNewline() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Newline.aql", "-o", "src/output/Newline.go", "-l", "GO"});

	}
	@Test
	public void testPrimaryKey() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/PkTest.aql", "-o", "src/output/PkTest.go", "-l", "GO"});

	}

	@Test
	public void testScan() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Scan.aql", "-o", "src/output/Scan.go", "-l", "GO"});

	}
	
	@Test
	public void testSelect() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Select.aql", "-o", "src/output/Select.go", "-l", "GO"});

	}
	@Test
	public void testAdmin() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Admin.aql", "-o", "src/output/Admin.go", "-l", "GO"});

	}
	@Test
	public void testUdf() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/UdfAll.aql", "-o", "src/output/UdfAll.go", "-l", "GO"});

	}
	@Test
	public void testFilter() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/QueryFilter.aql", "-o", "src/output/QueryFilter.go", "-l", "GO"});

	}
	@Test
	public void testExample1() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Example1.aql", "-o", "src/output/Example1.go", "-l", "GO"});

	}
	@Test
	public void testExample2() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Example2.aql", "-o", "src/output/Example2.go", "-l", "GO"});

	}
	@Test
	public void testLMap() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/LMap.aql", "-o", "src/output/LMap.go", "-l", "GO"});

	}
	@Test
	public void testSelectPK() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/SelectPK.aql", "-o", "src/output/SelectPK.go", "-l", "GO"});

	}
}
