package com.aerospike.aql;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.ResultCode;
import com.aerospike.client.query.RecordSet;

public class AQL2ExecutionTest {
	private AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
	private GenericResult result;
	AQL aql2 = null;
	
	@Before 
	public void setup(){
		aql2 = new AQL(client, 20, ViewFormat.TABLE);
		result = null;
	}
	@Test
	public void testGetKeyWords() throws Exception {
		List<String> words = AQL.getKeyWords();
		System.out.println("AQL Key words...");
		assertTrue(words.size() == 95);
	}
	@Test
	public void testExecuteInsertMap() throws Exception {
		
		System.out.println("Insert Map...");
		result = aql2.go("delete from test.demo where pk = 'test-select-map'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-map', 5, '2', 2, 'JSON{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}')");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("select * from test.demo where pk = 'test-select-map'");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testExecuteInsertList() throws Exception {
		System.out.println("Insert List...");
		result = aql2.go("delete from test.demo where pk = 'test-select-list'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4, amap) VALUES ('test-select-list', 5, '2', 2, 'JSON[{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}]')");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("select * from test.demo where pk = 'test-select-list'");
		assertTrue(result.resultCode == ResultCode.OK);
	}

	@Test
	public void testJavaExecuteSelectOne() throws Exception {
		System.out.println("Select One...");
		result = aql2.go("delete from test.demo where pk = 'test-select'");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('test-select', 5, '2', 2)");
		assertTrue(result.resultCode == ResultCode.OK);
		result = aql2.go("select * from test.demo where pk = 'test-select'");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteSelectRange() throws Exception {
		System.out.println("Select Range...");
		result = aql2.go("delete from test.demo where pk = 'test-select-1'");
		assertTrue(result.resultCode == ResultCode.OK);
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
		System.out.println("Select All...");
		result = aql2.go("select * from test.demo");
		assertTrue(result.resultCode == ResultCode.OK);
		assertTrue(result.scanList.size() > 0);
		result.close();
	}
	@Test
	public void testJavaExecuteShowBins() throws Exception {
		System.out.println("Show Bins...");
		result = aql2.go("show bins");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteShowModules() throws Exception {
		System.out.println("Show Modules...");
		result = aql2.go("show modules");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteShowNamespace() throws Exception {
		System.out.println("Show Namespaces...");
		result = aql2.go("show namespaces");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteShowSets() throws Exception {
		System.out.println("Show Sets...");
		result = aql2.go("show sets");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteShowScans() throws Exception {
		System.out.println("Show Scans...");
		result = aql2.go("show scans");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteShowQueries() throws Exception {
		System.out.println("Show Queries...");
		result = aql2.go("show Queries");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteShowIndexes2() throws Exception {
		System.out.println("Show Indexes...");
		result = aql2.go("show InDexes");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteDescIndexe() throws Exception {
		System.out.println("Desc Index...");
		result = aql2.go("desc InDex test index_bn2");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteStatQuery() throws Exception {
		System.out.println("Stat query...");
		result = aql2.go("stat query");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecuteStatSystem() throws Exception {
		System.out.println("Stat system...");
		result = aql2.go("stat system");
		assertTrue(result.resultCode == ResultCode.OK);
	}
	@Test
	public void testJavaExecutePrint() throws Exception {
		result = aql2.go("print 'hello there'");
		assertTrue(result.resultCode == ResultCode.OK);
	}

	@Test
	public void testExecuteFileEverything() throws Exception {
		AQL aql2 = new AQL();
		File inputFile = new File("src/test/resources/Everything.aql");
		aql2.execute(inputFile);
		int errors = aql2.getErrors();
		System.out.println("Errors: " + errors);
		assertTrue(errors == 0);
		
	}

}
