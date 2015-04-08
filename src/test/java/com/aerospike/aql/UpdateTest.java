package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;

public class UpdateTest extends AQLTest{
	@Test
	public void uopdateFileSyntax() throws Exception {
		System.out.println("----- uupdateFileSyntax -----");
		testFileSyntax("Update.aql");
	}
	@Test
	public void touchStringTTLGeneration() throws Exception {
		System.out.println("----- touchStringTTLGeneration -----");
		System.out.println(testStringGeneration("update test.cats SET ttl = 3000 where pk = '1234' and generation = 98765", Language.JAVA));
	}
	@Test
	public void updateStringTTLGeneration() throws Exception {
		System.out.println("----- updateStringTTLGeneration -----");
		System.out.println(testStringGeneration("update test.cats SET ttl = 3000, bob = 23, sue = 'abc' where pk = '1234' and generation = 98765", Language.JAVA));
	}
	@Test
	public void updateFileGeneration() throws Exception {
		System.out.println("----- updateFileGeneration -----");
		testFileGeneration("Update.aql", Language.JAVA);
	}
	@Test
	public void updateFileExecution() throws Exception {
		System.out.println("----- updateFileExecution -----");
		testFileExecution("localhost", 3000, "Update.aql");
	}

}
