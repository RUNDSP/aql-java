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
import com.aerospike.client.Operation;
import com.aerospike.client.ScanCallback;
import com.aerospike.client.Value;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.GenerationPolicy;
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
import com.aerospike.client.policy.AdminPolicy;

public class QueryFilter {

	public QueryFilter() {
		super();
	}

	public static void main(String[] args) {
		QueryFilter worker = new QueryFilter();
		worker.run();
	}
	public void run()  {
		// Variables for statements
		ClientPolicy clientPolicy;
		AerospikeClient client;

		Statement stmt = new Statement();
		RegisterTask task =	null;
		ScanPolicy scanPolicy = new ScanPolicy();
		RecordSet recordSet = null;
		QueryPolicy queryPolicy = new QueryPolicy();
		IndexTask indexTask = null;
		Policy policy = new Policy();
		Record record = null;
		WritePolicy writePolicy = new WritePolicy();
		File udfFile = null;
		ResultSet resultSet = null;


		// AQL statements - start
		/* connect '127.0.0.1' 3000 */
		/*
		Host[] hosts = new Host[] {new Host("a.host", 3000),
									new Host("another.host", 3000),
									new Host("and.another.host", 300)};
		client = new AerospikeClient(clientPolicy, hosts);
		*/
		clientPolicy = new ClientPolicy();
		client = new AerospikeClient(clientPolicy, "127.0.0.1", 3000);
		/* print 'register udf/filter_example.lua' */
		System.out.println("register udf/filter_example.lua");
		/* REGISTER module 'udf/filter_example.lua' */
		udfFile = new File("module");
		task = client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete(10);
		/* print 'create index profileindex' */
		System.out.println("create index profileindex");
		/* CREATE INDEX profileindex ON test.profile (username) STRING */
		indexTask = client.createIndex(policy, "test", "profile", "profileindex", "username", IndexType.STRING);
		indexTask.waitTillComplete(10);
						/* print 'add records' */
		System.out.println("add records");
		/* insert into test.profile (PK, username, password) values ('1', 'Charlie', 'cpass') */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "profile", "1"), 
			new Bin("username", Value.get("Charlie")), new Bin("password", Value.get("cpass")));
					/* insert into test.profile (PK, username, password) values ('2', 'Bill', 'hknfpkj') */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "profile", "2"), 
			new Bin("username", Value.get("Bill")), new Bin("password", Value.get("hknfpkj")));
					/* insert into test.profile (PK, username, password) values ('3', 'Doug', 'dj6554') */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "profile", "3"), 
			new Bin("username", Value.get("Doug")), new Bin("password", Value.get("dj6554")));
					/* insert into test.profile (PK, username, password) values ('4', 'Mary', 'ghjks') */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "profile", "4"), 
			new Bin("username", Value.get("Mary")), new Bin("password", Value.get("ghjks")));
					/* insert into test.profile (PK, username, password) values ('5', 'Julie', 'zzxzxvv') */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "profile", "5"), 
			new Bin("username", Value.get("Julie")), new Bin("password", Value.get("zzxzxvv")));
					/* print 'query on username' */
		System.out.println("query on username");
		/* select * from test.profile where username = 'mary' */
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("profile");
		stmt.setFilters();
		// Execute the query
		recordSet = client.query(queryPolicy, stmt);
		// Process the record set
		try {
			while (recordSet != null && recordSet.next()) {
				Key key = recordSet.getKey();
				record = recordSet.getRecord();
				System.out.println("Key: " + key);
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
		stmt.setFilters();
		resultSet = client.queryAggregate(null, stmt, 
			"filter_example", "profile_filter" );
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
						
		// AQL statements - finish, total: 15

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
	protected String infoAll(AerospikeClient client, String cmd) throws AerospikeException{
		Node[] nodes = client.getNodes();
		StringBuilder results = new StringBuilder();
		for (Node node : nodes){
			results.append(Info.request(node.getHost().name, node.getHost().port, cmd)).append("\n");
		}
		return results.toString();
	}
}
