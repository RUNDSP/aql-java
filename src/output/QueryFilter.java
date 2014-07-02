
import gnu.crypto.util.Base64;

import java.io.File;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Host;
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
import com.aerospike.client.policy.ClientPolicy;

public class QueryFilter {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public QueryFilter(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public QueryFilter(Host[] hosts) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = hosts[0].name;
		this.port = hosts[0].port;
		this.client = new AerospikeClient(new ClientPolicy(), hosts);
		
	}

	public static void main(String[] args) throws AerospikeException{
		/*
		Host[] hosts = new Host[] {new Host("a.host", 3000),
									new Host("another.host", 3000),
									new Host("and.another.host", 300)};
		QueryFilter worker = new QueryFilter(hosts);
		*/
		QueryFilter worker = new QueryFilter("P3", 3000);
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
		Object result;
		LuaConfig.SourceDirectory = "udf"; // change this to match your UDF directory 
		String udfString;
		String[] udfparts;
		
		// AQL statements - start
		
		/* print 'register udf/filter_example.lua' */
		System.out.println("register udf/filter_example.lua");

		/* REGISTER module 'udf/filter_example.lua' */
		udfFile = new File("udf/filter_example.lua");
		task = this.client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete();

		/* print 'create index profileindex' */
		System.out.println("create index profileindex");

		/* CREATE INDEX profileindex ON test.profile (username) STRING */
		indexTask = this.client.createIndex(this.policy, "test", "profile", "profileindex", "username", IndexType.STRING);
		indexTask.waitTillComplete();
						
		/* print 'add records' */
		System.out.println("add records");

		/* insert into test.profile (PK, username, password) values ('1', 'Charlie', 'cpass') */
		this.client.put(this.writePolicy, new Key("test", "profile", Value.get("1")), 
			new Bin("username", Value.get("Charlie")),
			new Bin("password", Value.get("cpass"))
			);
					
		/* insert into test.profile (PK, username, password) values ('2', 'Bill', 'hknfpkj') */
		this.client.put(this.writePolicy, new Key("test", "profile", Value.get("2")), 
			new Bin("username", Value.get("Bill")),
			new Bin("password", Value.get("hknfpkj"))
			);
					
		/* insert into test.profile (PK, username, password) values ('3', 'Doug', 'dj6554') */
		this.client.put(this.writePolicy, new Key("test", "profile", Value.get("3")), 
			new Bin("username", Value.get("Doug")),
			new Bin("password", Value.get("dj6554"))
			);
					
		/* insert into test.profile (PK, username, password) values ('4', 'Mary', 'ghjks') */
		this.client.put(this.writePolicy, new Key("test", "profile", Value.get("4")), 
			new Bin("username", Value.get("Mary")),
			new Bin("password", Value.get("ghjks"))
			);
					
		/* insert into test.profile (PK, username, password) values ('5', 'Julie', 'zzxzxvv') */
		this.client.put(this.writePolicy, new Key("test", "profile", Value.get("5")), 
			new Bin("username", Value.get("Julie")),
			new Bin("password", Value.get("zzxzxvv"))
			);
					
		/* print 'query on username' */
		System.out.println("query on username");

		/* select * from test.profile where username = 'mary' */
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("profile");
		stmt.setFilters(Filter.equal("username", Value.get("mary")));
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




		/* print 'query for Mary' */
		System.out.println("query for Mary");

		/* aggregate filter_example.profile_filter('ghjks') on test.profile where username = 'Mary' */
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("profile");
		stmt.setFilters(Filter.equal("username", Value.get("Mary")));
		resultSet = client.queryAggregate(null, stmt, 
			"filter_example", "profile_filter" , Value.get("ghjks"));
				
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

						

		
		// AQL statements - finish, total: 14
	}
	
	protected void finalize() throws Throwable {
	    if (this.client != null) {
	        this.client.close();
	        this.client = null;
	    }
	}
	protected void printInfo(String title, String infoString){
		if (infoString == null){
			System.out.println("Null info string");
			return;
		}
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
