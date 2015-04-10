package com.aerospike.aql;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;
import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;

public class OperateExecutionTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testJavaGenerateOperateJava() throws Exception {
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Operate.aql");
		aql2.execute(inputFile);
		int errors = aql2.getErrorCount();
		if (errors > 0){
			List<String> errorList = aql2.getErrorList();
			System.out.println("\nErrors: " + errors);
			for (String error : errorList){
				System.out.println("\t" + error);
			}
		}
		assertTrue(errors == 0);
	}


}
