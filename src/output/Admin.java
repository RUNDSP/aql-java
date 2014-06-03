
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

public class Admin {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public Admin(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public Admin(Host[] hosts) throws AerospikeException{
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
		Admin worker = new Admin(hosts);
		*/
		Admin worker = new Admin("P3", 3000);
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


		// SHOW packages
		printInfo("Packages", Info.request(this.seedHost, this.port, "udf-list"));

		// SHOW INDEXES test.demo
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// DESC INDEX test index_bn2
		printInfo("Describe Index", Info.request(this.seedHost, this.port, "sindex-describe"));

		// STAT INDEX test index_bn3

		// STAT QUERY
		printInfo("Query statistics", Info.request(this.seedHost, this.port, "query-stat"));

		// STAT SYSTEM
		printInfo("Statistics", Info.request(this.seedHost, this.port, "statistics"));

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

		// SET LUA_USERPATH '/opt/citrusleaf/usr/udf/lua'
		LuaConfig.SourceDirectory = "/opt/citrusleaf/usr/udf/lua"; 

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


		
		// Total AQL statements: 29
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