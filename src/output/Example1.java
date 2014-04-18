
import gnu.crypto.util.Base64;

import java.io.File;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Info;
import com.aerospike.client.Key;
import com.aerospike.client.Language;
import com.aerospike.client.Record;
import com.aerospike.client.ScanCallback;
import com.aerospike.client.Value;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.RegisterTask;
import com.aerospike.client.task.IndexTask;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.lua.LuaConfig;

public class Example1 {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public Example1(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		Example1 worker = new Example1("P3", 3000);
		worker.run();
	}
	public void run() throws AerospikeException {
		Bin[] bins = null;
		Key key = null; 
		ScanPolicy scanPolicy = null;
		Record record = null;
		RecordSet recordSet = null;
		ResultSet resultSet = null;
		Statement stmt = null;	
		File udfFile = null;
		RegisterTask task =	null;
		IndexTask indexTask = null;
		LuaConfig.SourceDirectory = "udf"; // change this to match your UDF directory 
		String udfString;
		String[] udfparts;
		// SET ECHO true

		// SET RECORD_TTL 100
		this.writePolicy.expiration = 100;

		// PRINT '>>> Set record time to live to 100 seconds.'
		System.out.println(">>> Set record time to live to 100 seconds.");

		// CREATE INDEX numindex ON test.newtest (b) NUMERIC
		indexTask = this.client.createIndex(this.policy, "test", "newtest", "numindex", "b", IndexType.NUMERIC);
		indexTask.waitTillComplete();
						
		// CREATE INDEX strindex ON test.newtest (c) STRING
		indexTask = this.client.createIndex(this.policy, "test", "newtest", "strindex", "c", IndexType.STRING);
		indexTask.waitTillComplete();
						
		// PRINT '>>> Add 11 records to the database.'
		System.out.println(">>> Add 11 records to the database.");

		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec1',5,3,'bac')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec1")), 
			new Bin("a", Value.get(5)),
			new Bin("b", Value.get(3)),
			new Bin("c", Value.get("bac"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec2',3,3,'kkc')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec2")), 
			new Bin("a", Value.get(3)),
			new Bin("b", Value.get(3)),
			new Bin("c", Value.get("kkc"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec3',5,8,'bcj')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec3")), 
			new Bin("a", Value.get(5)),
			new Bin("b", Value.get(8)),
			new Bin("c", Value.get("bcj"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec4',3,7,'bbh')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec4")), 
			new Bin("a", Value.get(3)),
			new Bin("b", Value.get(7)),
			new Bin("c", Value.get("bbh"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec5',1,3,'akl')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec5")), 
			new Bin("a", Value.get(1)),
			new Bin("b", Value.get(3)),
			new Bin("c", Value.get("akl"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec6',6,4,'adc')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec6")), 
			new Bin("a", Value.get(6)),
			new Bin("b", Value.get(4)),
			new Bin("c", Value.get("adc"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec7',9,1,'auc')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec7")), 
			new Bin("a", Value.get(9)),
			new Bin("b", Value.get(1)),
			new Bin("c", Value.get("auc"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec8',2,9,'adc')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec8")), 
			new Bin("a", Value.get(2)),
			new Bin("b", Value.get(9)),
			new Bin("c", Value.get("adc"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec9',5,3,'lnm')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec9")), 
			new Bin("a", Value.get(5)),
			new Bin("b", Value.get(3)),
			new Bin("c", Value.get("lnm"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec10',2,3,'mnm')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec10")), 
			new Bin("a", Value.get(2)),
			new Bin("b", Value.get(3)),
			new Bin("c", Value.get("mnm"))
			);
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec11',0,0,'xxx')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec11")), 
			new Bin("a", Value.get(0)),
			new Bin("b", Value.get(0)),
			new Bin("c", Value.get("xxx"))
			);
					
		// SELECT * FROM test.newtest
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "newtest", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





		// PRINT '>>> Should return 11 records.'
		System.out.println(">>> Should return 11 records.");

		// DELETE FROM test.newtest WHERE PK = 'rec11'
		this.client.delete(this.writePolicy, 
			new Key("test", "newtest", Value.get("rec11")));

		// SELECT * FROM test.newtest
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "newtest", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





		// PRINT '>>> Deleted one record, should now return only 10 records.'
		System.out.println(">>> Deleted one record, should now return only 10 records.");

		// SELECT a FROM test.newtest
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "newtest", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





		// SELECT b,c FROM test.newtest
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "newtest", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





		// SELECT * FROM test.newtest WHERE b = 3
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("newtest");
		stmt.setFilters(Filter.equal("b", Value.get(3)));
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				System.out.println("Record: " + record);
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT * FROM test.newtest WHERE c = 'adc'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("newtest");
		stmt.setFilters(Filter.equal("c", Value.get("adc")));
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				System.out.println("Record: " + record);
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT * FROM test.newtest WHERE b BETWEEN 0 AND 4
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("newtest");
		stmt.setFilters(Filter.range("b", Value.get(0), Value.get(4)));
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				System.out.println("Record: " + record);
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT * FROM test.newtest WHERE PK = 'rec10'
		record = client.get(this.policy, new Key("test", "newtest", Value.get("rec10")));System.out.println("Record: " + record);



		// SELECT * FROM test.newtest WHERE PK = 'rec11'
		record = client.get(this.policy, new Key("test", "newtest", Value.get("rec11")));System.out.println("Record: " + record);



		// PRINT '>>> We deleted rec11, so this should FAIL.'
		System.out.println(">>> We deleted rec11, so this should FAIL.");

		// PRINT '+++++++++++++++++++++++++++++++++++++++++++'
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

		// PRINT '>>> Test USER DEFINED FUNCTIONS'
		System.out.println(">>> Test USER DEFINED FUNCTIONS");

		// PRINT
		System.out.println();

		// REGISTER MODULE 'src/test/resources/example1-udf.lua'
		udfFile = new File("src/test/resources/example1-udf.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		// EXECUTE example1-udf.foo() ON test.newtest WHERE PK='rec1'
		Object result = client.execute(this.policy, 
			new Key("test", "newtest", Value.get("rec1")), 
			"example1-udf", "foo" );
		System.out.println("UDF result: " + result);

		// PRINT
		System.out.println();

		// PRINT '>>> Must return numeric 5'
		System.out.println(">>> Must return numeric 5");

		// EXECUTE example1-udf.foo() ON test.newtest
		// TODO no Scan UDF API in Java

		// PRINT '>>> This will launch a scan job and return'
		System.out.println(">>> This will launch a scan job and return");

		// PRINT '>>> Test Admin Calls'
		System.out.println(">>> Test Admin Calls");

		// PRINT
		System.out.println();

		// SHOW NAMESPACES
		printInfo("Name Spaces", Info.request(this.seedHost, this.port, "namespaces"));

		// SHOW SETS
		printInfo("Sets", Info.request(this.seedHost, this.port, "sets"));

		// SHOW BINS
		printInfo("Bins", Info.request(this.seedHost, this.port, "bins"));


		// SHOW QUERIES
		printInfo("Queries", Info.request(this.seedHost, this.port, "jobs:module=query"));


		// SHOW MODULES
		printInfo("Packages", Info.request(this.seedHost, this.port, "udf-list"));

		// SHOW INDEXES
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// SHOW INDEXES test
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// SHOW INDEXES test.newtest
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// DESC INDEX test strindex
		printInfo("Describe Index", Info.request(this.seedHost, this.port, "sindex-describe"));

		// DESC MODULE example1-udf.lua
		System.out.println("Module: example1-udf.lua");
		udfString = Info.request(this.seedHost, this.port, "udf-get:filename=example1-udf.lua");
		udfparts = udfString.split(";");
		System.out.println(new String(Base64.decode(udfparts[2].getBytes(), 8, udfparts[2].length()-2)));

		// REMOVE MODULE example1-udf.lua
		System.out.println("Drop module example1-udf.lua: " + Info.request(this.seedHost, this.port, "udf-remove:filename=example1-udf.lua"));

		// STAT SYSTEM
		printInfo("Statistics", Info.request(this.seedHost, this.port, "Statistics"));

		// STAT QUERY
		printInfo("Query statistics", Info.request(this.seedHost, this.port, "query-stat"));

		// STAT INDEX test numindex

		// PRINT
		System.out.println();

		// SHOW MODULES
		printInfo("Packages", Info.request(this.seedHost, this.port, "udf-list"));

		// SET ECHO false


		
		// Total AQL statements: 58
	}
	
	protected void finalize() throws Throwable {
	    if (this.client != null) {
	        this.client.close();
	        this.client = null;
	    }
	}
	protected void printInfo(String title, String infoString){
		String[] outerParts = infoString.split(";");
		System.out.println(title);
		for (String s : outerParts){

			String[] innerParts = s.split(":");
			for (String parts : innerParts){
				System.out.println("\t" + parts);
			}
			System.out.println();
		}
		
	}
	protected String infoAll(String cmd) throws AerospikeException{
		Node[] nodes = client.getNodes();
		StringBuilder results = new StringBuilder();
		for (Node node : nodes){
			results.append(Info.request(node.getHost().name, node.getHost().port, cmd)).append("\n");
		}
		return results.toString();
	}
}