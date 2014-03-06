package com.aerospike.aql;

import org.junit.Test;


public class AQLCompileAllTest {
	public static final String HOST = "192.168.51.188";
	public static final String PORT = "3000";

	@Test
	public void testJavaAll() throws Exception {
		AQLrun.main(new String[]{"-h", HOST, "-p", PORT, "-c", "src/test/resources/everything.aql", "-o", "src/output/everything.java", "-l", "JAVA"});
	}
	@Test
	public void testCAll() throws Exception {
		AQLrun.main(new String[]{"-h", HOST, "-p", PORT, "-c", "src/test/resources/everything.aql", "-o", "src/output/everything.c", "-l", "C"});
	}
	@Test
	public void testCSharpAll() throws Exception {
		AQLrun.main(new String[]{"-h", HOST, "-p", PORT, "-c", "src/test/resources/everything.aql", "-o", "src/output/everything.cs", "-l", "CSHARP"});
	}

}
