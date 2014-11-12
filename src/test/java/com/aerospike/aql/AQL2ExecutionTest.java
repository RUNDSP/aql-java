package com.aerospike.aql;
import java.io.File;

import org.junit.Test;

import com.aerospike.aql.v2.AQL2;
import com.aerospike.aql.v2.AQLGenerator.Language;
import com.aerospike.client.AerospikeClient;

public class AQL2ExecutionTest {
	
	
	@Test
	public void testJavaExecuteShowBins() throws Exception {
		AQL2 aql2 = new AQL2(new AerospikeClient("127.0.0.1", 3000), 20);
		aql2.execute("show bins");
	}
	@Test
	public void testJavaExecuteShowModules() throws Exception {
		AQL2 aql2 = new AQL2(new AerospikeClient("127.0.0.1", 3000), 20);
		aql2.execute("show modules");
	}
	@Test
	public void testJavaExecutePrint() throws Exception {
		AQL2 aql2 = new AQL2(new AerospikeClient("127.0.0.1", 3000), 20);
		aql2.execute("print 'hello there'");
	}
	@Test
	public void testExecuteFileEverything() throws Exception {
		AQL2 aql2 = new AQL2();
		File inputFile = new File("src/test/resources/Everything.aql");
		aql2.execute(inputFile);
		
	}

}
