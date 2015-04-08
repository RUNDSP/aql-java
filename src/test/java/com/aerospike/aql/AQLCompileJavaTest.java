package com.aerospike.aql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;


public class AQLCompileJavaTest {
	public static final String HOST = "P3";
	public static final String PORT = "3000";

	@Test
	public void testMapKeys() {
		AQL aql2 = new AQL();
		ParseTree tree = aql2.compile("CREATE MAPKEYS INDEX index_on_mapkeys ON test.demo (amap) string");
		assertNotNull(tree);
		assertEquals(aql2.getErrors(), 0);
		tree = aql2.compile("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}')");
		assertNotNull(tree);
		assertEquals(aql2.getErrors(), 0);
		tree = aql2.compile("select * in mapkeys from test.demo where amap = 'first'");
		assertNotNull(tree);
		assertEquals(aql2.getErrors(), 0);
	}
	@Test
	public void testListKeys() {
		AQL aql2 = new AQL();
		ParseTree tree = aql2.compile("CREATE LIST INDEX index_on_list_numeric ON test.demo (alist) numeric");
		assertNotNull(tree);
		assertEquals(aql2.getErrors(), 0);
		tree = aql2.compile("INSERT INTO test.demo (PK, bn2, bn3, bn4, alist) VALUES ('test-select-list2', 5, '2', 2, 'JSON[12,43,67,123,765, 25,100,9,562,345,7856,2]')");
		assertNotNull(tree);
		assertEquals(aql2.getErrors(), 0);
		tree = aql2.compile("select *  in list from test.demo where alist between 100 and 1000");
		assertNotNull(tree);
		assertEquals(aql2.getErrors(), 0);
	}

	@Test
	public void testCats() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/cats.aql", "-o", "src/output/Cats.java", "-l", "JAVA"});

	}
	@Test
	public void testNewline() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/Newline.aql", "-o", "src/output/Newline.java", "-l", "JAVA"});

	}
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
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/UdfAll.aql", "-o", "src/output/UdfAll.java", "-l", "JAVA"});
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
	@Test
	public void testLMap() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/LMap.aql", "-o", "src/output/LMap.java", "-l", "JAVA"});

	}
	@Test
	public void testSelectPK() throws Exception {
		AQLrun.main(new String[]{"-h", HOST , "-p", PORT, "-c", "src/test/resources/SelectPK.aql", "-o", "src/output/SelectPK.java", "-l", "JAVA"});

	}
}
