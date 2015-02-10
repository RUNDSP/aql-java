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

public class Admin {

	public Admin() {
		super();
	}

	public static void main(String[] args) {
		Admin worker = new Admin();
		worker.run();
	}
	public void run()  {
		// Variables for statements
		ClientPolicy clientPolicy;
		AerospikeClient client;

		Policy policy = new Policy();
		WritePolicy writePolicy = new WritePolicy();
		InfoPolicy infoPolicy = new InfoPolicy();


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
		/* SHOW NAMESPACES */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "namespaces");
		/* show SETS */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "sets");
		/* sHoW BiNS */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "bins");
		/* SHOW SCAnS */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "jobs:module=scan");
		/* shoW qUERIES */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "jobs:module=query");
		/* SHOW modules */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "udf-list");
		/* SHOW INDEXES */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "indexes");
		/* STAT INDEX test index_bn3 */
		/* STAT QUERY */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "query-stat");
		/* STAT SYSTEM */
		infoResult = Info.request(infoPolicy, client.getNodes()[0], "statistics");
		/* PRINT 'text_string' */
		System.out.println("text_string");
		/* SET VERBOSE true */
		/* SET VERBOSE false */
		/* SET ECHO true */
		/* SET ECHO false */
		/* SET TIMEOUT 150 */
		clientPolicy.timeout = 150;
		policy.timeout = 150;
		writePolicy.timeout = 150;
		/* SET OUTPUT TABLE */
		/* SET output JSON */
		/* SET LUA_USERPATH '/opt/citrusleaf/usr/udf/lua' */
		LuaConfig.SourceDirectory = "'/opt/citrusleaf/usr/udf/lua'"; 
		/* GET VERBOSE */
		/* GET ECHO */
		/* GET TIMEOUT */
		System.out.println("Policy timeout: " + policy.timeout);
		System.out.println("Write policy timeout: " + writePolicy.timeout);
		/* GET output */
		/* GET LUA_USERPATH */
		System.out.println("Lua source directory: " + LuaConfig.SourceDirectory);

		// AQL statements - finish, total: 25

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
