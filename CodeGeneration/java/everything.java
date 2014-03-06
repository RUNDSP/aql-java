
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
		everything worker = new everything("127.0.0.1", 3000);
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
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1)
		key = new Key("test", "demo", Value.get("1")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(1)), new Bin("bn3", Value.get("1")), new Bin("bn4", Value.get(1))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2)
		key = new Key("test", "demo", Value.get("2")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(2)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2)
		key = new Key("test", "demo", Value.get("3")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(3)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2)
		key = new Key("test", "demo", Value.get("4")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(4)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2)
		key = new Key("test", "demo", Value.get("5")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(5)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2)
		key = new Key("test", "demo", Value.get("6")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(6)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2)
		key = new Key("test", "demo", Value.get("7")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(7)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2)
		key = new Key("test", "demo", Value.get("8")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(8)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2)
		key = new Key("test", "demo", Value.get("9")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(9)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2)
		key = new Key("test", "demo", Value.get("10")); 
		bins = new Bin[] {
			new Bin("bn2", Value.get(10)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2))
			};
		this.client.put(this.writePolicy, key, bins);
					
		// CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC
		this.client.createIndex(this.policy, "test", "demo", "index_bn2", "bn2", ("NUMERIC".equalsIgnoreCase("string")) ? IndexType.STRING : IndexType.NUMERIC);
						
		// CREATE INDEX index_bn3 ON test.demo (bn3) STRING
		this.client.createIndex(this.policy, "test", "demo", "index_bn3", "bn3", ("STRING".equalsIgnoreCase("string")) ? IndexType.STRING : IndexType.NUMERIC);
						
		// SELECT * FROM test.demo
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "demo", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				// TODO Add processing for each record
				
			}
		});




		// SELECT * FROM test.demo WHERE bn4 = 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.equal("bn4", Value.get(2)));
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				// TODO process the record
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT * FROM test.demo WHERE bn3 = '2'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.equal("bn3", Value.get("2")));
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				// TODO process the record
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT * FROM test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				// TODO process the record
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT * FROM test.demo WHERE PK = '10'
		key = new Key("test", "demo", Value.get("10"));
		record = client.get(this.policy, key);




		// SELECT bn2,bn3,bn4  FROM test.demo
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "demo", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				// TODO Add processing for each record
				
			}
		});




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 = 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.equal("bn4", Value.get(2)));
		stmt.setBinNames("bn2", "bn3", "bn4");
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				// TODO process the record
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn3 = '2'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.equal("bn3", Value.get("2")));
		stmt.setBinNames("bn2", "bn3", "bn4");
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				// TODO process the record
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
		stmt.setBinNames("bn2", "bn3", "bn4");
		// Execute the query
		recordSet = client.query(null, stmt);

		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				key = recordSet.getKey();
				record = recordSet.getRecord();
				
				// TODO process the record
				
			}
		}
		finally {
			recordSet.close();
		}




		// SELECT bn2,bn3,bn4  FROM test.demo WHERE PK = '10'
		key = new Key("test", "demo", Value.get("10"));
		record = client.get(this.policy, key);




		// SHOW NAMESPACES
		String nameSpacesString = Info.request(this.seedHost, this.port, "namespaces");
		String[] nameSpaces = nameSpacesString.split(";");
		System.out.println("Name spaces");
		for (String ns : nameSpaces){
			System.out.println("\t" + ns);
		}

		// show SETS
		String setsString = Info.request(this.seedHost, this.port, "sets");
		String[] sets = setsString.split(";");
		System.out.println("Sets");
		for (String s : sets){
			
			String[] setParts = s.split(":");
			for (String parts : setParts){
				System.out.println("\t" + parts);
			}
			System.out.println();
		}

		// sHoW BiNS
		String binsString = Info.request(this.seedHost, this.port, "bins");
		String[] binList = binsString.split(";");
		System.out.println("Bins");
		for (String s : binList){

			String[] binParts = s.split(":");
			for (String parts : binParts){
				System.out.println("\t" + parts);
			}
			System.out.println();
		}


		// SHOW SCAnS

		// shoW qUERIES
		String queriesString = Info.request(this.seedHost, this.port, "queries");
		String[] queryList = queriesString.split(";");
		System.out.println("Queries");
		for (String qs : queryList){
			System.out.println("\t" + qs);
		}

		// SHOW INDEXES test.demo
		String indexesString = Info.request(this.seedHost, this.port, "sindex");
		String[] indexes = indexesString.split(";");
		System.out.println("Indexes");
		for (String s : indexes){

			String[] indexParts = s.split(":");
			for (String parts : indexParts){
				System.out.println("\t" + parts);
			}
			System.out.println();
		}

		// DESC INDEX test index_bn2

		// DESC module bob
		System.out.println("Package: bob");
		String udfString = Info.request(this.seedHost, this.port, "udf-get:filename=bob");
		System.out.println(Base64.decode(udfString.getBytes(), 0, udfString.length()));

		// STAT INDEX test index_bn3

		// STAT QUERY

		// STAT SYSTEM

		// REGISTER module '/AerospikeAQLGrammar/TestData/example1-udf.lua'
		File udfFile = new File("'/AerospikeAQLGrammar/TestData/example1-udf.lua'");
		String path = udfFile.getPath();
		String name = udfFile.getName();
		this.client.register(null, 
			path, //client path
			name, //server path
			Language.LUA); //UDF language


		// SHOW modules
		String packagesString = Info.request(this.seedHost, this.port, "udf-list");
		String[] packagesList = packagesString.split(";");
		System.out.println("Packages");
		for (String pkg : packagesList){
			System.out.println("\t" + pkg);
		}

		// EXECUTE example-udf.foo('arg1','arg2',3) ON test.demo
		// TODO no Scan UDF API in Java

		// EXECUTE example-udf.foo('arg1','arg2',3) ON test.demo WHERE PK = '10'
		key = new Key("test", "demo", Value.get("10"));
		Object result = client.execute(this.policy, key, "example-udf", "foo" );

		// AGGREGATE example-udf.foo('arg1','arg2',3) ON test.demo WHERE bn3 = 'smith'
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.equal("bn3", Value.get("smith")));
		resultSet = client.queryAggregate(null, stmt, 
			"example-udf", "foo" , Value.get("arg1"), Value.get("arg2"), Value.get(3));
				
		try {
			int count = 0;
			
			while (resultSet.next()) {
				Object object = resultSet.getObject();
				// TODO process the result
				count++;
			}
			
			if (count == 0) {
				System.out.println("No records returned.");			
			}
		}
		finally {
			resultSet.close();
		}

						
		// AGGREGATE example-udf.foo('arg1','arg2',3) ON test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setIndexName("indexName");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
		resultSet = client.queryAggregate(null, stmt, 
			"example-udf", "foo" , Value.get("arg1"), Value.get("arg2"), Value.get(3));
				
		try {
			int count = 0;
			
			while (resultSet.next()) {
				Object object = resultSet.getObject();
				// TODO process the result
				count++;
			}
			
			if (count == 0) {
				System.out.println("No records returned.");			
			}
		}
		finally {
			resultSet.close();
		}

						
		// DrOp module example-udf.lua
		// TODO no java API to remove a package

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

		// SET USE_SMD true

		// SET USE_SMD false

		// SET LUA_USERPATH '/opt/citrusleaf/usr/udf/lua'

		// SET LUA_SYSPATH '/opt/citrusleaf/sys/udf/lua'

		// GET VERBOSE

		// GET ECHO

		// GET TIMEOUT
		System.out.println("Policy timeout: " + this.policy.timeout);
		System.out.println("Write policy timeout: " + this.writePolicy.timeout);

		// GET RECORD_TTL
		System.out.println("Write policy expiration: " + this.writePolicy.expiration);

		// GET VIEW

		// GET USE_SMD

		// GET LUA_USERPATH

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
		key = new Key("test", "demo", Value.get("1"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '2'
		key = new Key("test", "demo", Value.get("2"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '3'
		key = new Key("test", "demo", Value.get("3"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '4'
		key = new Key("test", "demo", Value.get("4"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '5'
		key = new Key("test", "demo", Value.get("5"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '6'
		key = new Key("test", "demo", Value.get("6"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '7'
		key = new Key("test", "demo", Value.get("7"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '8'
		key = new Key("test", "demo", Value.get("8"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '9'
		key = new Key("test", "demo", Value.get("9"));
		this.client.delete(this.writePolicy, key);

		// DELETE FROM test.demo WHERE PK = '10'
		key = new Key("test", "demo", Value.get("10"));
		this.client.delete(this.writePolicy, key);

		// DROP INDEX test.demo index_bn2
		this.client.dropIndex(this.policy, "test", "demo", "index_bn2");

		// DROP INDEX test.demo index_bn3
		this.client.dropIndex(this.policy, "test", "demo", "index_bn3");


	}
	
	protected void finalize() throws Throwable {
	    if (this.client != null) {
	        this.client.close();
	        this.client = null;
	    }
	}
}