package com.aerospike.aql;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;

public class UserTest extends AQLTest{
	@Test
	public void userFileSyntax() throws Exception {
		System.out.println("----- userFileSyntax -----");
		testFileSyntax("User.aql");
	}
	//@Test
	public void userFileGeneration() throws Exception {
		System.out.println("----- userFileGeneration -----");
		testFileGeneration("User.aql", Language.JAVA);
	}
	//@Test
	public void userFileExecution() throws Exception {
		System.out.println("----- userFileExecution -----");
		testFileExecution("localhost", 3000, "User.aql");
	}

}
