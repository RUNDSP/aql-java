package com.aerospike.aql;

import org.junit.Test;

public class LMapSyntax extends AQLTest{

	@Test
	public void allLMapFileSyntax() throws Exception {
		System.out.println("----- allSyntaxFileSyntax -----");
		testFileSyntax("lmap.aql");
	}
}
