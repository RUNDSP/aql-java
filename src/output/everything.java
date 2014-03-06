
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
import com.aerospike.client.lua.LuaConfig;

public class everything {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public everything(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		everything worker = new everything("192.168.51.188", 3000);
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
		// select * from test.people where pk = 'toby'
		record = client.get(this.policy, new Key("test", "people", Value.get("toby")));
		System.out.println("Record: " + record);



		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1")), 
			new Bin("bn2", Value.get(1)),
			new Bin("bn3", Value.get("1")),
			new Bin("bn4", Value.get(1))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2")), 
			new Bin("bn2", Value.get(2)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("3")), 
			new Bin("bn2", Value.get(3)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("4")), 
			new Bin("bn2", Value.get(4)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("5")), 
			new Bin("bn2", Value.get(5)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("6")), 
			new Bin("bn2", Value.get(6)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("7")), 
			new Bin("bn2", Value.get(7)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("8")), 
			new Bin("bn2", Value.get(8)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("9")), 
			new Bin("bn2", Value.get(9)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("10")), 
			new Bin("bn2", Value.get(10)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC
		indexTask = this.client.createIndex(this.policy, "test", "demo", "index_bn2", "bn2", IndexType.NUMERIC);
		indexTask.waitTillComplete();
						
		// CREATE INDEX index_bn3 ON test.demo (bn3) STRING
		indexTask = this.client.createIndex(this.policy, "test", "demo", "index_bn3", "bn3", IndexType.STRING);
		indexTask.waitTillComplete();
						
		// SELECT * FROM test.demo
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "demo", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





		// SELECT * FROM test.demo WHERE bn4 = 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.equal("bn4", Value.get(2)));
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




		// SELECT * FROM test.demo WHERE bn3 = '2'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.equal("bn3", Value.get("2")));
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




		// SELECT * FROM test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
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




		// SELECT * FROM test.demo WHERE PK = '10'
		record = client.get(this.policy, new Key("test", "demo", Value.get("10")));
		System.out.println("Record: " + record);



		// SELECT bn2,bn3,bn4  FROM test.demo
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "demo", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





		// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 = 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.equal("bn4", Value.get(2)));
		stmt.setBinNames("bn2", "bn3", "bn4");
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




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn3 = '2'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.equal("bn3", Value.get("2")));
		stmt.setBinNames("bn2", "bn3", "bn4");
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




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
		stmt.setBinNames("bn2", "bn3", "bn4");
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




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE PK = '10'
		record = client.get(this.policy, new Key("test", "demo", Value.get("10")));
		System.out.println("Record: " + record);



		// SHOW NAMESPACES
		printInfo("Name Spaces", Info.request(this.seedHost, this.port, "namespaces"));

		// show SETS
		printInfo("Sets", Info.request(this.seedHost, this.port, "sets"));

		// sHoW BiNS
		printInfo("Bins", Info.request(this.seedHost, this.port, "bins"));


		// SHOW SCAnS
		printInfo("Scans", Info.request(this.seedHost, this.port, "jobs:module=scan"));

		// shoW qUERIES
		printInfo("Queries", Info.request(this.seedHost, this.port, "jobs:module=query"));


		// SHOW INDEXES test.demo
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// DESC INDEX test index_bn2
		printInfo("Describe Index", Info.request(this.seedHost, this.port, "sindex-describe"));

		// DESC module bob.lua
		System.out.println("Module: bob.lua");
		String udfString = Info.request(this.seedHost, this.port, "udf-get:filename=bob.lua");
		String[] udfparts = udfString.split(";");
		System.out.println(new String(Base64.decode(udfparts[2].getBytes(), 8, udfparts[2].length()-2)));

		// REGISTER module '/AerospikeAQLGrammar/TestData/example1-udf.lua'
		udfFile = new File("/AerospikeAQLGrammar/TestData/example1-udf.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		// SHOW modules
		printInfo("Packages", Info.request(this.seedHost, this.port, "udf-list"));

		// EXECUTE example-udf.foo('arg1','arg2',3) ON test.demo
		// TODO no Scan UDF API in Java

		// EXECUTE example-udf.foo('arg1','arg2',3) ON test.demo WHERE PK = '10'
		Object result = client.execute(this.policy, 
			new Key("test", "demo", Value.get("10")), 
			"example-udf", "foo" );
		System.out.println("UDF result: " + result);

		// AGGREGATE example-udf.foo('arg1','arg2',3) ON test.demo WHERE bn3 = 'smith'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.equal("bn3", Value.get("smith")));
		resultSet = client.queryAggregate(null, stmt, 
			"example-udf", "foo" , Value.get("arg1"), Value.get("arg2"), Value.get(3));
				
		try {
			int count = 0;
			
			while (resultSet.next()) {
				Object object = resultSet.getObject();
				System.out.println("Result: " + object);
				count++;
			}
			
			if (count == 0) {
				System.out.println("No results returned.");			
			}
		}
		finally {
			resultSet.close();
		}

						
		// AGGREGATE example-udf.foo('arg1','arg2',3) ON test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
		resultSet = client.queryAggregate(null, stmt, 
			"example-udf", "foo" , Value.get("arg1"), Value.get("arg2"), Value.get(3));
				
		try {
			int count = 0;
			
			while (resultSet.next()) {
				Object object = resultSet.getObject();
				System.out.println("Result: " + object);
				count++;
			}
			
			if (count == 0) {
				System.out.println("No results returned.");			
			}
		}
		finally {
			resultSet.close();
		}

						
		// DrOp module example-udf.lua
		System.out.println("Drop module example-udf.lua: " + Info.request(this.seedHost, this.port, "udf-remove:filename=example-udf.lua"));

		// PRINT 'text_string'
		System.out.println("text_string");

		// SET VERBOSE true

		// SET VERBOSE false

		// SET ECHO true

		// SET ECHO false

		// SET TIMEOUT 150
		this.policy.timeout = 150;
		this.writePolicy.timeout = 150;

		// SET RECORD_TTL 0
		this.writePolicy.expiration = 0;

		// SET VIEW TABLE

		// SET VIEW JSON

		// cats
		LuaConfig.SourceDirectory = "mice"; 

		// SET LUA_SYSPATH '/opt/citrusleaf/sys/udf/lua'

		// GET VERBOSE

		// GET ECHO

		// GET TIMEOUT
		System.out.println("Policy timeout: " + this.policy.timeout);
		System.out.println("Write policy timeout: " + this.writePolicy.timeout);

		// GET RECORD_TTL
		System.out.println("Write policy expiration: " + this.writePolicy.expiration);

		// GET VIEW

		// GET LUA_USERPATH
		System.out.println("Lua source directory: " + LuaConfig.SourceDirectory);

		// GET LUA_SYSPATH

		// KILL_QUERY 12345
		Info.request(this.seedHost, this.port, "query-kill=12345");

		// KILL_SCAN 54321
		Info.request(this.seedHost, this.port, "scan-kill=54321");

		// KILL QUERY 12345
		Info.request(this.seedHost, this.port, "query-kill=12345");

		// KILL SCAN 54321
		Info.request(this.seedHost, this.port, "scan-kill=54321");

		// RUN 'filename'
		System.out.println("Run file: " + "filename");

		// DELETE FROM test.demo WHERE PK = '1'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("1")));

		// DELETE FROM test.demo WHERE PK = '2'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("2")));

		// DELETE FROM test.demo WHERE PK = '3'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("3")));

		// DELETE FROM test.demo WHERE PK = '4'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("4")));

		// DELETE FROM test.demo WHERE PK = '5'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("5")));

		// DELETE FROM test.demo WHERE PK = '6'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("6")));

		// DELETE FROM test.demo WHERE PK = '7'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("7")));

		// DELETE FROM test.demo WHERE PK = '8'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("8")));

		// DELETE FROM test.demo WHERE PK = '9'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("9")));

		// DELETE FROM test.demo WHERE PK = '10'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("10")));

		// DROP INDEX test.demo index_bn2
		this.client.dropIndex(this.policy, "test", "demo", "index_bn2");

		// DROP INDEX test.demo index_bn3
		this.client.dropIndex(this.policy, "test", "demo", "index_bn3");


		
		// Total AQL statements: 77
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
}