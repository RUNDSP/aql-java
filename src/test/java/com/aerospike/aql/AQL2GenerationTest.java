package com.aerospike.aql;
import java.io.File;

import org.junit.Test;

import com.aerospike.aql.v2.AQL2;
import com.aerospike.aql.v2.AQLGenerator.Language;

public class AQL2GenerationTest {
	
	@Test
	public void testJavaGenerateCreateIndex() throws Exception {
		AQL2 aql2 = new AQL2();
		aql2.generate("create InDeX bob On test.demo (shoe) NUMerIC", Language.JAVA);
	}
	
	@Test
	public void testJavaGenerateShowBins() throws Exception {
		AQL2 aql2 = new AQL2();
		aql2.generate("show bins", Language.JAVA);
	}
	
	@Test
	public void testJavaGenerateShowModules() throws Exception {
		AQL2 aql2 = new AQL2();
		aql2.generate("show modules", Language.JAVA);
	}
	@Test
	public void testJavaGeneratePrint() throws Exception {
		AQL2 aql2 = new AQL2();
		aql2.generate("print 'hello there'", Language.JAVA);
	}

	@Test
	public void testJavaGenerateUpdate() throws Exception {
		AQL2 aql2 = new AQL2();
		String code = aql2.generate("operate add(cat, 23), get(cat) on test.demo where pk = 9989\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989 and generation = 20967", Language.JAVA);
		System.out.println(code);
	}
	@Test
	public void testJavaGenerateOperate() throws Exception {
		AQL2 aql2 = new AQL2();
		aql2.generate("update test.cats SET bob = 23, sue = 'abc' where pk = '1234'\n"
				+ "update test.cats SET bob = 23, sue = 'abc' where pk = '1234' and generation = 98765", Language.JAVA);
	}
	@Test
	public void testJavaGenerate() throws Exception {
		AQL2 aql2 = new AQL2();
		String java = aql2.generate("insert into test.demo (PK, cats, dogs, count) values (123, 'yes', 'no', 107)\n"
				+ "update test.cats SET bob = 23, sue = 'abc' where pk = '1234'\n"
				+ "delete from test.cats where pk = '1234'\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989 and generation = 20967", Language.JAVA);
		//System.out.println(java);
	}

	@Test
	public void testJavaGenarateFile() throws Exception{
		AQL2 aql2 = new AQL2();
		File inputFile = new File("src/test/resources/Everything.aql");
		File outputFile = new File("CodeGeneration/Java/Everything.java");
		aql2.generate(inputFile, outputFile, Language.JAVA);
	}

}
