
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

public class Udf {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public Udf(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		Udf worker = new Udf("192.168.51.197", 3000);
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
		// cats
		LuaConfig.SourceDirectory = "mice"; 

		// CREATE INDEX index_bn4 ON test.demo (bn4) NUMERIC
		indexTask = this.client.createIndex(this.policy, "test", "demo", "index_bn4", "bn4", IndexType.NUMERIC);
		indexTask.waitTillComplete();
						
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
					
		// REGISTER module 'src/test/resources/example1.lua'
		udfFile = new File("src/test/resources/example1.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		// REGISTER module 'src/test/resources/sum_example.lua'
		udfFile = new File("src/test/resources/sum_example.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		// REGISTER module 'src/test/resources/average_example.lua'
		udfFile = new File("src/test/resources/average_example.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		// SHOW modules
		printInfo("Packages", Info.request(this.seedHost, this.port, "udf-list"));

		// desc module example1.lua
		System.out.println("Module: example1.lua");
		String udfString = Info.request(this.seedHost, this.port, "udf-get:filename=example1.lua");
		String[] udfparts = udfString.split(";");
		System.out.println(new String(Base64.decode(udfparts[2].getBytes(), 8, udfparts[2].length()-2)));

		// EXECUTE example1.foo('arg1','arg2',3) ON test.demo WHERE PK = '1'
		Object result = client.execute(this.policy, 
			new Key("test", "demo", Value.get("1")), 
			"example1", "foo" );
		System.out.println("UDF result: " + result);

		// drop module example1.lua
		System.out.println("Drop module example1.lua: " + Info.request(this.seedHost, this.port, "udf-remove:filename=example1.lua"));

		// AGGREGATE sum_example.sum_single_bin('bn4') ON test.demo WHERE bn4 BETWEEN 1 AND 2
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters(Filter.range("bn4", Value.get(1), Value.get(2)));
		resultSet = client.queryAggregate(null, stmt, 
			"sum_example", "sum_single_bin" , Value.get("bn4"));
				
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


		
		// Total AQL statements: 30
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