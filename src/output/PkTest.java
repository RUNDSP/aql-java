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

public class PkTest {

	public PkTest() {
		super();
	}

	public static void main(String[] args) {
		PkTest worker = new PkTest();
		worker.run();
	}
	public void run()  {
		// Variables for statements
		ClientPolicy clientPolicy;
		AerospikeClient client;

		Record record = null;
		Policy policy = new Policy();
		ScanPolicy scanPolicy = new ScanPolicy();
		Statement stmt = new Statement();
		WritePolicy writePolicy = new WritePolicy();


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
		/* select * from test.demo where pk = 'tpby' */
		record = client.get(policy, new Key("test", "demo", "tpby"));
		/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "1"), 
			new Bin("bn2", Value.get(1)), new Bin("bn3", Value.get("1")), new Bin("bn4", Value.get(1)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "2"), 
			new Bin("bn2", Value.get(2)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "3"), 
			new Bin("bn2", Value.get(3)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "4"), 
			new Bin("bn2", Value.get(4)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "5"), 
			new Bin("bn2", Value.get(5)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "6"), 
			new Bin("bn2", Value.get(6)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "7"), 
			new Bin("bn2", Value.get(7)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "8"), 
			new Bin("bn2", Value.get(8)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "9"), 
			new Bin("bn2", Value.get(9)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", "10"), 
			new Bin("bn2", Value.get(10)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* SELECT * FROM test.demo WHERE pk = '1' */
		record = client.get(policy, new Key("test", "demo", "1"));
		/* SELECT bn2, bn3, bn4 FROM test.demo WHERE pk = '2' */
		record = client.get(policy, new Key("test", "demo", "2"), "bn2", "bn3", "bn4");
		/* SELECT * FROM test.demo WHERE pk = '3' */
		record = client.get(policy, new Key("test", "demo", "3"));
		/* SELECT bn2, bn3, bn4 FROM test.demo WHERE pk = '4' */
		record = client.get(policy, new Key("test", "demo", "4"), "bn2", "bn3", "bn4");
		/* SELECT * FROM test.demo WHERE pk = '5' */
		record = client.get(policy, new Key("test", "demo", "5"));
		/* SELECT bn2, bn3, bn4 FROM test.demo WHERE pk = '6' */
		record = client.get(policy, new Key("test", "demo", "6"), "bn2", "bn3", "bn4");
		/* SELECT * FROM test.demo WHERE pk = '7' */
		record = client.get(policy, new Key("test", "demo", "7"));
		/* SELECT bn2, bn3 FROM test.demo WHERE pk = '8' */
		record = client.get(policy, new Key("test", "demo", "8"), "bn2", "bn3");
		/* SELECT * FROM test.demo WHERE pk = '9' */
		record = client.get(policy, new Key("test", "demo", "9"));
		/* SELECT bn2 FROM test.demo WHERE pk = '10' */
		record = client.get(policy, new Key("test", "demo", "10"), "bn2");
		/* DELETE FROM test.demo WHERE PK = '1' */
		client.delete(writePolicy, new Key("test", "demo", "1"));
		/* DELETE FROM test.demo WHERE PK = '2' */
		client.delete(writePolicy, new Key("test", "demo", "2"));
		/* DELETE FROM test.demo WHERE PK = '3' */
		client.delete(writePolicy, new Key("test", "demo", "3"));
		/* DELETE FROM test.demo WHERE PK = '4' */
		client.delete(writePolicy, new Key("test", "demo", "4"));
		/* DELETE FROM test.demo WHERE PK = '5' */
		client.delete(writePolicy, new Key("test", "demo", "5"));
		/* DELETE FROM test.demo WHERE PK = '6' */
		client.delete(writePolicy, new Key("test", "demo", "6"));
		/* DELETE FROM test.demo WHERE PK = '7' */
		client.delete(writePolicy, new Key("test", "demo", "7"));
		/* DELETE FROM test.demo WHERE PK = '8' */
		client.delete(writePolicy, new Key("test", "demo", "8"));
		/* DELETE FROM test.demo WHERE PK = '9' */
		client.delete(writePolicy, new Key("test", "demo", "9"));
		/* DELETE FROM test.demo WHERE PK = '10' */
		client.delete(writePolicy, new Key("test", "demo", "10"));

		// AQL statements - finish, total: 32

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
