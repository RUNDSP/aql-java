package com.aerospike.aql;

import org.junit.Test;

public class AggregationTest extends AQLTest{
	@Test
	public void testFileAggregationSyntax() throws Exception {
		System.out.println("----- testFileAggregationSyntax -----");
		testFileSyntax("LateFlights.aql");
	}

	@Test
	public void testAdminFile() throws Exception {
		System.out.println("----- testAdminFile -----");
		testFileGeneration("LateFlights.aql", AQL.Language.JAVA);
			
	}

}
