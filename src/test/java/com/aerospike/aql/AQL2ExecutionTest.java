package com.aerospike.aql;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.ResultCode;
import com.aerospike.client.query.RecordSet;

public class AQL2ExecutionTest {
	private AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
	
	@Test
	public void testGetKeyWords() throws Exception {
		List<String> words = AQL.getKeyWords();
		System.out.println("AQL Key words...");
		for (String word : words){
			System.out.println("\t"+ word);
		}
	}
	@Test
	public void testExecuteInsertMap() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("delete from test.demo where pk = 'test-select-map'");
		aql2.execute("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}')");
		aql2.execute("select * from test.demo where pk = 'test-select-map'");
	}
	@Test
	public void testExecuteInsertList() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("delete from test.demo where pk = 'test-select-list'");
		aql2.execute("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-list', 5, '2', 2, 'JSON[{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}]')");
		aql2.execute("select * from test.demo where pk = 'test-select-list'");
	}

	@Test
	public void testJavaExecuteSelectOne() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		AQLExecutor ex = aql2.execute("delete from test.demo where pk = 'test-select'");
		aql2.execute("INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('test-select', 5, '2', 2)", ex);
		aql2.execute("select * from test.demo where pk = 'test-select'", ex);
	}
	@Test
	public void testJavaExecuteSelectRange() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		GenericResult result = aql2.go("delete from test.demo where pk = 'test-select-1'");
		result = aql2.go("delete from test.demo where pk = 'test-select-2'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("delete from test.demo where pk = 'test-select-3'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("drop index test.demo index_bn2");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('test-select-1', 5, '2', 2)");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('test-select-2', 6, '2', 2)");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('test-select-3', 7, '2', 2)");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("select * from test.demo where bn2 between 5 and 7");
		assertTrue(result.resultCode == ResultCode.OK);
		int count = 0;
		while (result.recordSet.next()){
			count++;
		}
		result.recordSet.close();
		assertTrue(count >= 3);
	}
	//@Test
	public void testJavaExecuteCreateMapKeysIndex() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		GenericResult result = aql2.go("CREATE MAPKEYS INDEX index_on_mapkeys ON test.demo (amap) string");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	//@Test
	public void testJavaExecuteCreateMapValuesIndex() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		GenericResult result = aql2.go("CREATE MAPVALUES INDEX index_on_valuess ON test.demo (amap) string");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	//@Test
	public void testJavaExecuteCreateListIndex() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		GenericResult result = aql2.go("CREATE LIST INDEX index_on_list_numeric ON test.demo (alist) numeric");
		assertTrue(result.resultCode == ResultCode.OK);
		
	}
	//@Test
	public void testJavaExecuteSelectMapKeys() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		GenericResult result = aql2.go("delete from test.demo where pk = 'test-select-list2'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("CREATE MAPKEYS INDEX index_on_mapkeys ON test.demo (amap) string");
		assertTrue(result.resultCode == ResultCode.OK);
		aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}')");
		result = aql2.go("select * in mapkeys from test.demo where amap = 'first'");
		RecordSet recSet = result.recordSet;
		while (recSet.next()){
			System.out.println(recSet.getRecord());
		}
	}
	
	//@Test
	public void testJavaExecuteSelectList() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		GenericResult result = aql2.go("delete from test.demo where pk = 'test-select-mapkeys2'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("CREATE LIST INDEX index_on_list_numeric ON test.demo (alist) numeric");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4, alist) VALUES ('test-select-list2', 5, '2', 2, 'JSON[12,43,67,123,765, 25,100,9,562,345,7856,2]')");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("select *  in list from test.demo where alist between 100 and 1000");
		assertTrue(result.resultCode == ResultCode.OK);
		RecordSet recSet = result.recordSet;
		while (recSet.next()){
			System.out.println(recSet.getRecord());
		}
	}
	
	@Test
	public void testJavaExecuteSelectAll() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("select * from test.demo");
	}
	@Test
	public void testJavaExecuteShowBins() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show bins");
	}
	@Test
	public void testJavaExecuteShowModules() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show modules");
	}
	@Test
	public void testJavaExecuteShowNamespace() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show namespaces");
	}
	@Test
	public void testJavaExecuteShowSets() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show sets");
	}
	@Test
	public void testJavaExecuteShowScans() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show scans");
	}
	@Test
	public void testJavaExecuteShowQueries() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show Queries");
	}
	@Test
	public void testJavaExecuteShowIndexes2() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("show InDexes");
	}
	@Test
	public void testJavaExecuteDescIndexe() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("desc InDex test index_bn2");
	}
	@Test
	public void testJavaExecuteStatQuery() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("stat query");
	}
	@Test
	public void testJavaExecuteStatSystem() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("stat system");
	}
	@Test
	public void testJavaExecutePrint() throws Exception {
		AQL aql2 = new AQL(client, 20, ViewFormat.TABLE);
		aql2.execute("print 'hello there'");
	}

	@Test
	public void testExecuteFileEverything() throws Exception {
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Everything.aql");
		aql2.execute(inputFile);
		
	}

}
