
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

public class Example2 {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public Example2(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		Example2 worker = new Example2("192.168.51.197", 3000);
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
		// SET ECHO false

		// SET RECORD_TTL 100
		this.writePolicy.expiration = 100;

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
					
		// INSERT INTO test.newtest (PK,a,b,c) VALUES ('rec11',4,3,'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx')
		this.client.put(this.writePolicy, new Key("test", "newtest", Value.get("rec11")), 
			new Bin("a", Value.get(4)),
			new Bin("b", Value.get(3)),
			new Bin("c", Value.get("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"))
			);
					
		// REGISTER MODULE 'src/test/resources//example2.lua'
		udfFile = new File("src/test/resources//example2.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		// AGGREGATE example2.sum_even_a() ON test.newtest WHERE b = 3
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("newtest");
		stmt.setFilters(Filter.equal("b", Value.get(3)));
		resultSet = client.queryAggregate(null, stmt, 
			"example2", "sum_even_a" );
				
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

						

		
		// Total AQL statements: 18
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