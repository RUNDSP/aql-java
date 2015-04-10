package com.aerospike.aql;
import java.io.File;
import java.util.List;

import org.junit.Test;

import com.aerospike.aql.AQLGenerator.Language;

public class AQL2GenerationTest {
	
	@Test
	public void testJavaGenerationCreateMapKeysINdex() throws Exception {
		AQL aql2 = new AQL();
		String code = aql2.generate("CREATE MAPKEYS INDEX index_on_mapkeys ON test.demo (amap) string", Language.JAVA);
		System.out.println(code);
	}
	@Test
	public void testJavaGenerationInsertMap() throws Exception {
		AQL aql2 = new AQL();
		String code = aql2.generate("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}')", Language.JAVA);
		System.out.println(code);
	}
	@Test
	public void testJavaGenerationSelectMapKeys() throws Exception {
		AQL aql2 = new AQL();
		String code = aql2.generate("select * in mapkeys from test.demo where amap = 'first'", Language.JAVA);
		System.out.println(code);
	}
	@Test
	public void testJavaExecuteInsertMap() throws Exception {
		AQL aql2 = new AQL();
		String code = aql2.generate("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"key\": 1}')", Language.JAVA);
		System.out.println(code);
	}
	@Test
	public void testJavaExecuteInsertList() throws Exception {
		AQL aql2 = new AQL();
		String code = aql2.generate("select * from test.demo where pk = 'test-select-list'", Language.JAVA);
		System.out.println(code);
	}
	@Test
	public void testKeyWords() throws Exception {
		AQL aql2 = new AQL();
		List<String> keyWords = aql2.getKeyWords();
		for (String keyWord : keyWords){
			System.out.println(keyWord);
		}
	}
	@Test
	public void testJavaGenerateCreateIndex() throws Exception {
		AQL aql2 = new AQL();
		aql2.generate("create InDeX bob On test.demo (shoe) NUMerIC", Language.JAVA);
	}
	
	@Test
	public void testJavaGenerateShowBins() throws Exception {
		AQL aql2 = new AQL();
		aql2.generate("show bins", Language.JAVA);
	}
	
	@Test
	public void testJavaGenerateShowModules() throws Exception {
		AQL aql2 = new AQL();
		aql2.generate("show modules", Language.JAVA);
	}
	@Test
	public void testJavaGeneratePrint() throws Exception {
		AQL aql2 = new AQL();
		aql2.generate("print 'hello there'", Language.JAVA);
	}

	@Test
	public void testJavaGenerateOperate() throws Exception {
		AQL aql2 = new AQL();
		String code = aql2.generate("operate add(cat, 23), get(cat) on test.demo where pk = 9989\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989 and generation = 20967", Language.JAVA);
		System.out.println(code);
		code = aql2.generate("operate add(cat, 23), get(cat) on test.demo where pk = 9989\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989 and generation = 20967", Language.GO);
		System.out.println(code);
	}
	@Test
	public void testJavaGenerateUpdate() throws Exception {
		AQL aql2 = new AQL();
		aql2.generate("update test.cats SET bob = 23, sue = 'abc' where pk = '1234'\n"
				+ "update test.cats SET bob = 23, sue = 'abc' where pk = '1234' and generation = 98765", Language.JAVA);
	}
	@Test
	public void testJavaGenerate() throws Exception {
		AQL aql2 = new AQL();
		String java = aql2.generate("insert into test.demo (PK, cats, dogs, count) values (123, 'yes', 'no', 107)\n"
				+ "update test.cats SET bob = 23, sue = 'abc' where pk = '1234'\n"
				+ "delete from test.cats where pk = '1234'\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989\n"
				+ "operate add(cat, 23), get(cat) on test.demo where pk = 9989 and generation = 20967", Language.JAVA);
		//System.out.println(java);
	}

	@Test
	public void testJavaGenarateFile() throws Exception{
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Everything.aql");
		File outputFile = new File("CodeGeneration/Java/Everything.java");
		aql2.generate(inputFile, outputFile, Language.JAVA);
	}
	@Test
	public void testGoGenarateFile() throws Exception{
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Everything.aql");
		File outputFile = new File("CodeGeneration/Go/Everything.go");
		aql2.generate(inputFile, outputFile, Language.GO);
	}
	@Test
	public void testCsharpGenarateFile() throws Exception{
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Everything.aql");
		File outputFile = new File("CodeGeneration/csharp/Everything.cs");
		aql2.generate(inputFile, outputFile, Language.CSHARP);
	}

}
