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

public class Scan {


	public Scan() throws AerospikeException{
		super();
	}

	public static void main(String[] args) throws AerospikeException{
		Scan worker = new Scan();
		worker.run();
	}
	public void run() throws AerospikeException {
		// Variables for statements

		Policy policy = new Policy();
		WritePolicy writePolicy = new WritePolicy();
		ResultSet resultSet = null;
		QueryPolicy queryPolicy = new QueryPolicy();
		ScanPolicy scanPolicy = new ScanPolicy();
		Statement stmt = new Statement();
		Record record = null;
		RegisterTask task =	null;
		File udfFile = null;

		// AQL statements - start

		/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 1), 
			new Bin("bn2", Value.get(1)), new Bin("bn3", Value.get("1")), new Bin("bn4", Value.get(1)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 2), 
			new Bin("bn2", Value.get(2)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 3), 
			new Bin("bn2", Value.get(3)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 4), 
			new Bin("bn2", Value.get(4)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 5), 
			new Bin("bn2", Value.get(5)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 6), 
			new Bin("bn2", Value.get(6)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 7), 
			new Bin("bn2", Value.get(7)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 8), 
			new Bin("bn2", Value.get(8)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 9), 
			new Bin("bn2", Value.get(9)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 10), 
			new Bin("bn2", Value.get(10)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('11', 11, '2', 2) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 11), 
			new Bin("bn2", Value.get(11)), new Bin("bn3", Value.get("2")), new Bin("bn4", Value.get(2)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('12', 12, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 12), 
			new Bin("bn2", Value.get(12)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('13', 13, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 13), 
			new Bin("bn2", Value.get(13)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('14', 14, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 14), 
			new Bin("bn2", Value.get(14)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('15', 15, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 15), 
			new Bin("bn2", Value.get(15)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('16', 16, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 16), 
			new Bin("bn2", Value.get(16)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('17', 17, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 17), 
			new Bin("bn2", Value.get(17)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('18', 18, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 18), 
			new Bin("bn2", Value.get(18)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('19', 19, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 19), 
			new Bin("bn2", Value.get(19)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('20', 20, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 20), 
			new Bin("bn2", Value.get(20)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('21', 21, '3', 3) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 21), 
			new Bin("bn2", Value.get(21)), new Bin("bn3", Value.get("3")), new Bin("bn4", Value.get(3)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('22', 22, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 22), 
			new Bin("bn2", Value.get(22)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('23', 23, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 23), 
			new Bin("bn2", Value.get(23)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('24', 24, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 24), 
			new Bin("bn2", Value.get(24)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('25', 25, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 25), 
			new Bin("bn2", Value.get(25)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('26', 26, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 26), 
			new Bin("bn2", Value.get(26)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('27', 27, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 27), 
			new Bin("bn2", Value.get(27)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('28', 28, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 28), 
			new Bin("bn2", Value.get(28)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('29', 29, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 29), 
			new Bin("bn2", Value.get(29)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('30', 30, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 30), 
			new Bin("bn2", Value.get(30)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('31', 31, '4', 4) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 31), 
			new Bin("bn2", Value.get(31)), new Bin("bn3", Value.get("4")), new Bin("bn4", Value.get(4)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('32', 32, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 32), 
			new Bin("bn2", Value.get(32)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('33', 33, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 33), 
			new Bin("bn2", Value.get(33)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('34', 34, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 34), 
			new Bin("bn2", Value.get(34)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('35', 35, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 35), 
			new Bin("bn2", Value.get(35)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('36', 36, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 36), 
			new Bin("bn2", Value.get(36)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('37', 37, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 37), 
			new Bin("bn2", Value.get(37)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('38', 38, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 38), 
			new Bin("bn2", Value.get(38)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('39', 39, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 39), 
			new Bin("bn2", Value.get(39)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('40', 40, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 40), 
			new Bin("bn2", Value.get(40)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('41', 41, '5', 5) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 41), 
			new Bin("bn2", Value.get(41)), new Bin("bn3", Value.get("5")), new Bin("bn4", Value.get(5)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('42', 42, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 42), 
			new Bin("bn2", Value.get(42)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('43', 43, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 43), 
			new Bin("bn2", Value.get(43)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('44', 44, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 44), 
			new Bin("bn2", Value.get(44)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('45', 45, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 45), 
			new Bin("bn2", Value.get(45)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('46', 46, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 46), 
			new Bin("bn2", Value.get(46)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('47', 47, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 47), 
			new Bin("bn2", Value.get(47)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('48', 48, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 48), 
			new Bin("bn2", Value.get(48)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('49', 49, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 49), 
			new Bin("bn2", Value.get(49)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('50', 50, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 50), 
			new Bin("bn2", Value.get(50)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('51', 51, '6', 6) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 51), 
			new Bin("bn2", Value.get(51)), new Bin("bn3", Value.get("6")), new Bin("bn4", Value.get(6)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('52', 52, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 52), 
			new Bin("bn2", Value.get(52)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('53', 53, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 53), 
			new Bin("bn2", Value.get(53)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('54', 54, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 54), 
			new Bin("bn2", Value.get(54)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('55', 55, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 55), 
			new Bin("bn2", Value.get(55)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('56', 56, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 56), 
			new Bin("bn2", Value.get(56)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('57', 57, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 57), 
			new Bin("bn2", Value.get(57)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('58', 58, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 58), 
			new Bin("bn2", Value.get(58)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('59', 59, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 59), 
			new Bin("bn2", Value.get(59)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('60', 60, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 60), 
			new Bin("bn2", Value.get(60)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('61', 61, '7', 7) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 61), 
			new Bin("bn2", Value.get(61)), new Bin("bn3", Value.get("7")), new Bin("bn4", Value.get(7)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('62', 62, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 62), 
			new Bin("bn2", Value.get(62)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('63', 63, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 63), 
			new Bin("bn2", Value.get(63)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('64', 64, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 64), 
			new Bin("bn2", Value.get(64)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('65', 65, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 65), 
			new Bin("bn2", Value.get(65)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('66', 66, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 66), 
			new Bin("bn2", Value.get(66)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('67', 67, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 67), 
			new Bin("bn2", Value.get(67)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('68', 68, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 68), 
			new Bin("bn2", Value.get(68)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('69', 69, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 69), 
			new Bin("bn2", Value.get(69)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('70', 70, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 70), 
			new Bin("bn2", Value.get(70)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('71', 71, '8', 8) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 71), 
			new Bin("bn2", Value.get(71)), new Bin("bn3", Value.get("8")), new Bin("bn4", Value.get(8)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('72', 72, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 72), 
			new Bin("bn2", Value.get(72)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('73', 73, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 73), 
			new Bin("bn2", Value.get(73)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('74', 74, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 74), 
			new Bin("bn2", Value.get(74)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('75', 75, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 75), 
			new Bin("bn2", Value.get(75)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('76', 76, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 76), 
			new Bin("bn2", Value.get(76)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('77', 77, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 77), 
			new Bin("bn2", Value.get(77)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('78', 78, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 78), 
			new Bin("bn2", Value.get(78)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('79', 79, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 79), 
			new Bin("bn2", Value.get(79)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('80', 80, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 80), 
			new Bin("bn2", Value.get(80)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('81', 81, '9', 9) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 81), 
			new Bin("bn2", Value.get(81)), new Bin("bn3", Value.get("9")), new Bin("bn4", Value.get(9)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('82', 82, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 82), 
			new Bin("bn2", Value.get(82)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('83', 83, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 83), 
			new Bin("bn2", Value.get(83)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('84', 84, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 84), 
			new Bin("bn2", Value.get(84)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('85', 85, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 85), 
			new Bin("bn2", Value.get(85)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('86', 86, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 86), 
			new Bin("bn2", Value.get(86)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('87', 87, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 87), 
			new Bin("bn2", Value.get(87)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('88', 88, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 88), 
			new Bin("bn2", Value.get(88)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('89', 89, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 89), 
			new Bin("bn2", Value.get(89)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('90', 90, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 90), 
			new Bin("bn2", Value.get(90)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('91', 91, '10', 10) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 91), 
			new Bin("bn2", Value.get(91)), new Bin("bn3", Value.get("10")), new Bin("bn4", Value.get(10)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('92', 92, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 92), 
			new Bin("bn2", Value.get(92)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('93', 93, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 93), 
			new Bin("bn2", Value.get(93)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('94', 94, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 94), 
			new Bin("bn2", Value.get(94)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('95', 95, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 95), 
			new Bin("bn2", Value.get(95)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('96', 96, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 96), 
			new Bin("bn2", Value.get(96)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('97', 97, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 97), 
			new Bin("bn2", Value.get(97)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('98', 98, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 98), 
			new Bin("bn2", Value.get(98)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('99', 99, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 99), 
			new Bin("bn2", Value.get(99)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('100', 100, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 100), 
			new Bin("bn2", Value.get(100)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('101', 101, '11', 11) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 101), 
			new Bin("bn2", Value.get(101)), new Bin("bn3", Value.get("11")), new Bin("bn4", Value.get(11)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('102', 102, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 102), 
			new Bin("bn2", Value.get(102)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('103', 103, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 103), 
			new Bin("bn2", Value.get(103)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('104', 104, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 104), 
			new Bin("bn2", Value.get(104)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('105', 105, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 105), 
			new Bin("bn2", Value.get(105)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('106', 106, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 106), 
			new Bin("bn2", Value.get(106)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('107', 107, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 107), 
			new Bin("bn2", Value.get(107)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('108', 108, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 108), 
			new Bin("bn2", Value.get(108)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('109', 109, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 109), 
			new Bin("bn2", Value.get(109)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('110', 110, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 110), 
			new Bin("bn2", Value.get(110)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('111', 111, '12', 12) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 111), 
			new Bin("bn2", Value.get(111)), new Bin("bn3", Value.get("12")), new Bin("bn4", Value.get(12)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('112', 112, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 112), 
			new Bin("bn2", Value.get(112)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('113', 113, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 113), 
			new Bin("bn2", Value.get(113)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('114', 114, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 114), 
			new Bin("bn2", Value.get(114)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('115', 115, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 115), 
			new Bin("bn2", Value.get(115)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('116', 116, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 116), 
			new Bin("bn2", Value.get(116)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('117', 117, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 117), 
			new Bin("bn2", Value.get(117)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('118', 118, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 118), 
			new Bin("bn2", Value.get(118)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('119', 119, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 119), 
			new Bin("bn2", Value.get(119)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('120', 120, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 120), 
			new Bin("bn2", Value.get(120)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('121', 121, '13', 13) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 121), 
			new Bin("bn2", Value.get(121)), new Bin("bn3", Value.get("13")), new Bin("bn4", Value.get(13)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('122', 122, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 122), 
			new Bin("bn2", Value.get(122)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('123', 123, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 123), 
			new Bin("bn2", Value.get(123)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('124', 124, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 124), 
			new Bin("bn2", Value.get(124)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('125', 125, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 125), 
			new Bin("bn2", Value.get(125)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('126', 126, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 126), 
			new Bin("bn2", Value.get(126)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('127', 127, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 127), 
			new Bin("bn2", Value.get(127)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('128', 128, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 128), 
			new Bin("bn2", Value.get(128)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('129', 129, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 129), 
			new Bin("bn2", Value.get(129)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('130', 130, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 130), 
			new Bin("bn2", Value.get(130)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('131', 131, '14', 14) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 131), 
			new Bin("bn2", Value.get(131)), new Bin("bn3", Value.get("14")), new Bin("bn4", Value.get(14)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('132', 132, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 132), 
			new Bin("bn2", Value.get(132)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('133', 133, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 133), 
			new Bin("bn2", Value.get(133)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('134', 134, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 134), 
			new Bin("bn2", Value.get(134)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('135', 135, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 135), 
			new Bin("bn2", Value.get(135)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('136', 136, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 136), 
			new Bin("bn2", Value.get(136)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('137', 137, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 137), 
			new Bin("bn2", Value.get(137)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('138', 138, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 138), 
			new Bin("bn2", Value.get(138)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('139', 139, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 139), 
			new Bin("bn2", Value.get(139)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('140', 140, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 140), 
			new Bin("bn2", Value.get(140)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('141', 141, '15', 15) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 141), 
			new Bin("bn2", Value.get(141)), new Bin("bn3", Value.get("15")), new Bin("bn4", Value.get(15)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('142', 142, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 142), 
			new Bin("bn2", Value.get(142)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('143', 143, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 143), 
			new Bin("bn2", Value.get(143)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('144', 144, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 144), 
			new Bin("bn2", Value.get(144)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('145', 145, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 145), 
			new Bin("bn2", Value.get(145)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('146', 146, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 146), 
			new Bin("bn2", Value.get(146)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('147', 147, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 147), 
			new Bin("bn2", Value.get(147)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('148', 148, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 148), 
			new Bin("bn2", Value.get(148)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('149', 149, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 149), 
			new Bin("bn2", Value.get(149)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('150', 150, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 150), 
			new Bin("bn2", Value.get(150)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('151', 151, '16', 16) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 151), 
			new Bin("bn2", Value.get(151)), new Bin("bn3", Value.get("16")), new Bin("bn4", Value.get(16)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('152', 152, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 152), 
			new Bin("bn2", Value.get(152)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('153', 153, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 153), 
			new Bin("bn2", Value.get(153)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('154', 154, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 154), 
			new Bin("bn2", Value.get(154)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('155', 155, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 155), 
			new Bin("bn2", Value.get(155)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('156', 156, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 156), 
			new Bin("bn2", Value.get(156)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('157', 157, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 157), 
			new Bin("bn2", Value.get(157)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('158', 158, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 158), 
			new Bin("bn2", Value.get(158)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('159', 159, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 159), 
			new Bin("bn2", Value.get(159)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('160', 160, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 160), 
			new Bin("bn2", Value.get(160)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('161', 161, '17', 17) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 161), 
			new Bin("bn2", Value.get(161)), new Bin("bn3", Value.get("17")), new Bin("bn4", Value.get(17)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('162', 162, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 162), 
			new Bin("bn2", Value.get(162)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('163', 163, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 163), 
			new Bin("bn2", Value.get(163)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('164', 164, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 164), 
			new Bin("bn2", Value.get(164)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('165', 165, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 165), 
			new Bin("bn2", Value.get(165)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('166', 166, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 166), 
			new Bin("bn2", Value.get(166)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('167', 167, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 167), 
			new Bin("bn2", Value.get(167)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('168', 168, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 168), 
			new Bin("bn2", Value.get(168)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('169', 169, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 169), 
			new Bin("bn2", Value.get(169)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('170', 170, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 170), 
			new Bin("bn2", Value.get(170)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('171', 171, '18', 18) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 171), 
			new Bin("bn2", Value.get(171)), new Bin("bn3", Value.get("18")), new Bin("bn4", Value.get(18)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('172', 172, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 172), 
			new Bin("bn2", Value.get(172)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('173', 173, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 173), 
			new Bin("bn2", Value.get(173)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('174', 174, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 174), 
			new Bin("bn2", Value.get(174)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('175', 175, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 175), 
			new Bin("bn2", Value.get(175)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('176', 176, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 176), 
			new Bin("bn2", Value.get(176)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('177', 177, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 177), 
			new Bin("bn2", Value.get(177)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('178', 178, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 178), 
			new Bin("bn2", Value.get(178)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('179', 179, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 179), 
			new Bin("bn2", Value.get(179)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('180', 180, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 180), 
			new Bin("bn2", Value.get(180)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('181', 181, '19', 19) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 181), 
			new Bin("bn2", Value.get(181)), new Bin("bn3", Value.get("19")), new Bin("bn4", Value.get(19)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('182', 182, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 182), 
			new Bin("bn2", Value.get(182)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('183', 183, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 183), 
			new Bin("bn2", Value.get(183)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('184', 184, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 184), 
			new Bin("bn2", Value.get(184)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('185', 185, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 185), 
			new Bin("bn2", Value.get(185)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('186', 186, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 186), 
			new Bin("bn2", Value.get(186)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('187', 187, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 187), 
			new Bin("bn2", Value.get(187)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('188', 188, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 188), 
			new Bin("bn2", Value.get(188)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('189', 189, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 189), 
			new Bin("bn2", Value.get(189)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('190', 190, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 190), 
			new Bin("bn2", Value.get(190)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('191', 191, '20', 20) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 191), 
			new Bin("bn2", Value.get(191)), new Bin("bn3", Value.get("20")), new Bin("bn4", Value.get(20)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('192', 192, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 192), 
			new Bin("bn2", Value.get(192)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('193', 193, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 193), 
			new Bin("bn2", Value.get(193)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('194', 194, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 194), 
			new Bin("bn2", Value.get(194)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('195', 195, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 195), 
			new Bin("bn2", Value.get(195)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('196', 196, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 196), 
			new Bin("bn2", Value.get(196)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('197', 197, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 197), 
			new Bin("bn2", Value.get(197)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('198', 198, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 198), 
			new Bin("bn2", Value.get(198)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('199', 199, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 199), 
			new Bin("bn2", Value.get(199)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('200', 200, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 200), 
			new Bin("bn2", Value.get(200)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('201', 201, '21', 21) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 201), 
			new Bin("bn2", Value.get(201)), new Bin("bn3", Value.get("21")), new Bin("bn4", Value.get(21)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('202', 202, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 202), 
			new Bin("bn2", Value.get(202)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('203', 203, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 203), 
			new Bin("bn2", Value.get(203)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('204', 204, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 204), 
			new Bin("bn2", Value.get(204)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('205', 205, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 205), 
			new Bin("bn2", Value.get(205)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('206', 206, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 206), 
			new Bin("bn2", Value.get(206)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('207', 207, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 207), 
			new Bin("bn2", Value.get(207)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('208', 208, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 208), 
			new Bin("bn2", Value.get(208)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('209', 209, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 209), 
			new Bin("bn2", Value.get(209)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('210', 210, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 210), 
			new Bin("bn2", Value.get(210)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('211', 211, '22', 22) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 211), 
			new Bin("bn2", Value.get(211)), new Bin("bn3", Value.get("22")), new Bin("bn4", Value.get(22)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('212', 212, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 212), 
			new Bin("bn2", Value.get(212)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('213', 213, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 213), 
			new Bin("bn2", Value.get(213)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('214', 214, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 214), 
			new Bin("bn2", Value.get(214)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('215', 215, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 215), 
			new Bin("bn2", Value.get(215)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('216', 216, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 216), 
			new Bin("bn2", Value.get(216)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('217', 217, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 217), 
			new Bin("bn2", Value.get(217)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('218', 218, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 218), 
			new Bin("bn2", Value.get(218)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('219', 219, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 219), 
			new Bin("bn2", Value.get(219)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('220', 220, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 220), 
			new Bin("bn2", Value.get(220)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('221', 221, '23', 23) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 221), 
			new Bin("bn2", Value.get(221)), new Bin("bn3", Value.get("23")), new Bin("bn4", Value.get(23)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('222', 222, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 222), 
			new Bin("bn2", Value.get(222)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('223', 223, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 223), 
			new Bin("bn2", Value.get(223)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('224', 224, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 224), 
			new Bin("bn2", Value.get(224)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('225', 225, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 225), 
			new Bin("bn2", Value.get(225)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('226', 226, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 226), 
			new Bin("bn2", Value.get(226)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('227', 227, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 227), 
			new Bin("bn2", Value.get(227)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('228', 228, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 228), 
			new Bin("bn2", Value.get(228)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('229', 229, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 229), 
			new Bin("bn2", Value.get(229)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('230', 230, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 230), 
			new Bin("bn2", Value.get(230)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('231', 231, '24', 24) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 231), 
			new Bin("bn2", Value.get(231)), new Bin("bn3", Value.get("24")), new Bin("bn4", Value.get(24)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('232', 232, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 232), 
			new Bin("bn2", Value.get(232)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('233', 233, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 233), 
			new Bin("bn2", Value.get(233)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('234', 234, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 234), 
			new Bin("bn2", Value.get(234)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('235', 235, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 235), 
			new Bin("bn2", Value.get(235)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('236', 236, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 236), 
			new Bin("bn2", Value.get(236)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('237', 237, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 237), 
			new Bin("bn2", Value.get(237)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('238', 238, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 238), 
			new Bin("bn2", Value.get(238)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('239', 239, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 239), 
			new Bin("bn2", Value.get(239)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('240', 240, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 240), 
			new Bin("bn2", Value.get(240)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('241', 241, '25', 25) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 241), 
			new Bin("bn2", Value.get(241)), new Bin("bn3", Value.get("25")), new Bin("bn4", Value.get(25)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('242', 242, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 242), 
			new Bin("bn2", Value.get(242)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('243', 243, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 243), 
			new Bin("bn2", Value.get(243)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('244', 244, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 244), 
			new Bin("bn2", Value.get(244)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('245', 245, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 245), 
			new Bin("bn2", Value.get(245)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('246', 246, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 246), 
			new Bin("bn2", Value.get(246)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('247', 247, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 247), 
			new Bin("bn2", Value.get(247)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('248', 248, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 248), 
			new Bin("bn2", Value.get(248)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('249', 249, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 249), 
			new Bin("bn2", Value.get(249)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('250', 250, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 250), 
			new Bin("bn2", Value.get(250)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('251', 251, '26', 26) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 251), 
			new Bin("bn2", Value.get(251)), new Bin("bn3", Value.get("26")), new Bin("bn4", Value.get(26)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('252', 252, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 252), 
			new Bin("bn2", Value.get(252)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('253', 253, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 253), 
			new Bin("bn2", Value.get(253)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('254', 254, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 254), 
			new Bin("bn2", Value.get(254)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('255', 255, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 255), 
			new Bin("bn2", Value.get(255)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('256', 256, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 256), 
			new Bin("bn2", Value.get(256)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('257', 257, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 257), 
			new Bin("bn2", Value.get(257)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('258', 258, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 258), 
			new Bin("bn2", Value.get(258)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('259', 259, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 259), 
			new Bin("bn2", Value.get(259)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('260', 260, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 260), 
			new Bin("bn2", Value.get(260)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('261', 261, '27', 27) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 261), 
			new Bin("bn2", Value.get(261)), new Bin("bn3", Value.get("27")), new Bin("bn4", Value.get(27)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('262', 262, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 262), 
			new Bin("bn2", Value.get(262)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('263', 263, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 263), 
			new Bin("bn2", Value.get(263)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('264', 264, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 264), 
			new Bin("bn2", Value.get(264)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('265', 265, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 265), 
			new Bin("bn2", Value.get(265)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('266', 266, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 266), 
			new Bin("bn2", Value.get(266)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('267', 267, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 267), 
			new Bin("bn2", Value.get(267)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('268', 268, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 268), 
			new Bin("bn2", Value.get(268)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('269', 269, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 269), 
			new Bin("bn2", Value.get(269)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('270', 270, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 270), 
			new Bin("bn2", Value.get(270)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('271', 271, '28', 28) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 271), 
			new Bin("bn2", Value.get(271)), new Bin("bn3", Value.get("28")), new Bin("bn4", Value.get(28)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('272', 272, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 272), 
			new Bin("bn2", Value.get(272)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('273', 273, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 273), 
			new Bin("bn2", Value.get(273)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('274', 274, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 274), 
			new Bin("bn2", Value.get(274)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('275', 275, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 275), 
			new Bin("bn2", Value.get(275)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('276', 276, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 276), 
			new Bin("bn2", Value.get(276)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('277', 277, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 277), 
			new Bin("bn2", Value.get(277)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('278', 278, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 278), 
			new Bin("bn2", Value.get(278)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('279', 279, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 279), 
			new Bin("bn2", Value.get(279)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('280', 280, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 280), 
			new Bin("bn2", Value.get(280)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('281', 281, '29', 29) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 281), 
			new Bin("bn2", Value.get(281)), new Bin("bn3", Value.get("29")), new Bin("bn4", Value.get(29)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('282', 282, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 282), 
			new Bin("bn2", Value.get(282)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('283', 283, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 283), 
			new Bin("bn2", Value.get(283)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('284', 284, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 284), 
			new Bin("bn2", Value.get(284)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('285', 285, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 285), 
			new Bin("bn2", Value.get(285)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('286', 286, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 286), 
			new Bin("bn2", Value.get(286)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('287', 287, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 287), 
			new Bin("bn2", Value.get(287)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('288', 288, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 288), 
			new Bin("bn2", Value.get(288)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('289', 289, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 289), 
			new Bin("bn2", Value.get(289)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('290', 290, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 290), 
			new Bin("bn2", Value.get(290)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('291', 291, '30', 30) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 291), 
			new Bin("bn2", Value.get(291)), new Bin("bn3", Value.get("30")), new Bin("bn4", Value.get(30)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('292', 292, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 292), 
			new Bin("bn2", Value.get(292)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('293', 293, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 293), 
			new Bin("bn2", Value.get(293)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('294', 294, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 294), 
			new Bin("bn2", Value.get(294)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('295', 295, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 295), 
			new Bin("bn2", Value.get(295)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('296', 296, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 296), 
			new Bin("bn2", Value.get(296)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('297', 297, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 297), 
			new Bin("bn2", Value.get(297)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('298', 298, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 298), 
			new Bin("bn2", Value.get(298)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('299', 299, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 299), 
			new Bin("bn2", Value.get(299)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('300', 300, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 300), 
			new Bin("bn2", Value.get(300)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('301', 301, '31', 31) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 301), 
			new Bin("bn2", Value.get(301)), new Bin("bn3", Value.get("31")), new Bin("bn4", Value.get(31)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('302', 302, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 302), 
			new Bin("bn2", Value.get(302)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('303', 303, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 303), 
			new Bin("bn2", Value.get(303)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('304', 304, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 304), 
			new Bin("bn2", Value.get(304)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('305', 305, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 305), 
			new Bin("bn2", Value.get(305)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('306', 306, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 306), 
			new Bin("bn2", Value.get(306)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('307', 307, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 307), 
			new Bin("bn2", Value.get(307)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('308', 308, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 308), 
			new Bin("bn2", Value.get(308)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('309', 309, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 309), 
			new Bin("bn2", Value.get(309)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('310', 310, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 310), 
			new Bin("bn2", Value.get(310)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('311', 311, '32', 32) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 311), 
			new Bin("bn2", Value.get(311)), new Bin("bn3", Value.get("32")), new Bin("bn4", Value.get(32)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('312', 312, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 312), 
			new Bin("bn2", Value.get(312)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('313', 313, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 313), 
			new Bin("bn2", Value.get(313)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('314', 314, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 314), 
			new Bin("bn2", Value.get(314)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('315', 315, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 315), 
			new Bin("bn2", Value.get(315)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('316', 316, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 316), 
			new Bin("bn2", Value.get(316)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('317', 317, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 317), 
			new Bin("bn2", Value.get(317)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('318', 318, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 318), 
			new Bin("bn2", Value.get(318)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('319', 319, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 319), 
			new Bin("bn2", Value.get(319)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('320', 320, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 320), 
			new Bin("bn2", Value.get(320)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('321', 321, '33', 33) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 321), 
			new Bin("bn2", Value.get(321)), new Bin("bn3", Value.get("33")), new Bin("bn4", Value.get(33)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('322', 322, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 322), 
			new Bin("bn2", Value.get(322)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('323', 323, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 323), 
			new Bin("bn2", Value.get(323)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('324', 324, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 324), 
			new Bin("bn2", Value.get(324)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('325', 325, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 325), 
			new Bin("bn2", Value.get(325)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('326', 326, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 326), 
			new Bin("bn2", Value.get(326)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('327', 327, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 327), 
			new Bin("bn2", Value.get(327)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('328', 328, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 328), 
			new Bin("bn2", Value.get(328)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('329', 329, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 329), 
			new Bin("bn2", Value.get(329)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('330', 330, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 330), 
			new Bin("bn2", Value.get(330)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('331', 331, '34', 34) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 331), 
			new Bin("bn2", Value.get(331)), new Bin("bn3", Value.get("34")), new Bin("bn4", Value.get(34)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('332', 332, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 332), 
			new Bin("bn2", Value.get(332)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('333', 333, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 333), 
			new Bin("bn2", Value.get(333)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('334', 334, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 334), 
			new Bin("bn2", Value.get(334)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('335', 335, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 335), 
			new Bin("bn2", Value.get(335)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('336', 336, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 336), 
			new Bin("bn2", Value.get(336)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('337', 337, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 337), 
			new Bin("bn2", Value.get(337)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('338', 338, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 338), 
			new Bin("bn2", Value.get(338)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('339', 339, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 339), 
			new Bin("bn2", Value.get(339)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('340', 340, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 340), 
			new Bin("bn2", Value.get(340)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('341', 341, '35', 35) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 341), 
			new Bin("bn2", Value.get(341)), new Bin("bn3", Value.get("35")), new Bin("bn4", Value.get(35)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('342', 342, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 342), 
			new Bin("bn2", Value.get(342)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('343', 343, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 343), 
			new Bin("bn2", Value.get(343)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('344', 344, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 344), 
			new Bin("bn2", Value.get(344)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('345', 345, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 345), 
			new Bin("bn2", Value.get(345)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('346', 346, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 346), 
			new Bin("bn2", Value.get(346)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('347', 347, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 347), 
			new Bin("bn2", Value.get(347)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('348', 348, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 348), 
			new Bin("bn2", Value.get(348)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('349', 349, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 349), 
			new Bin("bn2", Value.get(349)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('350', 350, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 350), 
			new Bin("bn2", Value.get(350)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('351', 351, '36', 36) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 351), 
			new Bin("bn2", Value.get(351)), new Bin("bn3", Value.get("36")), new Bin("bn4", Value.get(36)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('352', 352, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 352), 
			new Bin("bn2", Value.get(352)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('353', 353, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 353), 
			new Bin("bn2", Value.get(353)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('354', 354, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 354), 
			new Bin("bn2", Value.get(354)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('355', 355, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 355), 
			new Bin("bn2", Value.get(355)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('356', 356, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 356), 
			new Bin("bn2", Value.get(356)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('357', 357, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 357), 
			new Bin("bn2", Value.get(357)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('358', 358, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 358), 
			new Bin("bn2", Value.get(358)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('359', 359, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 359), 
			new Bin("bn2", Value.get(359)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('360', 360, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 360), 
			new Bin("bn2", Value.get(360)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('361', 361, '37', 37) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 361), 
			new Bin("bn2", Value.get(361)), new Bin("bn3", Value.get("37")), new Bin("bn4", Value.get(37)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('362', 362, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 362), 
			new Bin("bn2", Value.get(362)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('363', 363, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 363), 
			new Bin("bn2", Value.get(363)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('364', 364, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 364), 
			new Bin("bn2", Value.get(364)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('365', 365, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 365), 
			new Bin("bn2", Value.get(365)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('366', 366, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 366), 
			new Bin("bn2", Value.get(366)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('367', 367, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 367), 
			new Bin("bn2", Value.get(367)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('368', 368, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 368), 
			new Bin("bn2", Value.get(368)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('369', 369, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 369), 
			new Bin("bn2", Value.get(369)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('370', 370, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 370), 
			new Bin("bn2", Value.get(370)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('371', 371, '38', 38) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 371), 
			new Bin("bn2", Value.get(371)), new Bin("bn3", Value.get("38")), new Bin("bn4", Value.get(38)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('372', 372, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 372), 
			new Bin("bn2", Value.get(372)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('373', 373, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 373), 
			new Bin("bn2", Value.get(373)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('374', 374, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 374), 
			new Bin("bn2", Value.get(374)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('375', 375, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 375), 
			new Bin("bn2", Value.get(375)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('376', 376, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 376), 
			new Bin("bn2", Value.get(376)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('377', 377, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 377), 
			new Bin("bn2", Value.get(377)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('378', 378, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 378), 
			new Bin("bn2", Value.get(378)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('379', 379, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 379), 
			new Bin("bn2", Value.get(379)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('380', 380, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 380), 
			new Bin("bn2", Value.get(380)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('381', 381, '39', 39) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 381), 
			new Bin("bn2", Value.get(381)), new Bin("bn3", Value.get("39")), new Bin("bn4", Value.get(39)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('382', 382, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 382), 
			new Bin("bn2", Value.get(382)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('383', 383, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 383), 
			new Bin("bn2", Value.get(383)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('384', 384, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 384), 
			new Bin("bn2", Value.get(384)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('385', 385, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 385), 
			new Bin("bn2", Value.get(385)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('386', 386, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 386), 
			new Bin("bn2", Value.get(386)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('387', 387, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 387), 
			new Bin("bn2", Value.get(387)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('388', 388, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 388), 
			new Bin("bn2", Value.get(388)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('389', 389, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 389), 
			new Bin("bn2", Value.get(389)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('390', 390, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 390), 
			new Bin("bn2", Value.get(390)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('391', 391, '40', 40) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 391), 
			new Bin("bn2", Value.get(391)), new Bin("bn3", Value.get("40")), new Bin("bn4", Value.get(40)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('392', 392, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 392), 
			new Bin("bn2", Value.get(392)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('393', 393, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 393), 
			new Bin("bn2", Value.get(393)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('394', 394, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 394), 
			new Bin("bn2", Value.get(394)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('395', 395, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 395), 
			new Bin("bn2", Value.get(395)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('396', 396, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 396), 
			new Bin("bn2", Value.get(396)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('397', 397, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 397), 
			new Bin("bn2", Value.get(397)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('398', 398, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 398), 
			new Bin("bn2", Value.get(398)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('399', 399, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 399), 
			new Bin("bn2", Value.get(399)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('400', 400, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 400), 
			new Bin("bn2", Value.get(400)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('401', 401, '41', 41) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 401), 
			new Bin("bn2", Value.get(401)), new Bin("bn3", Value.get("41")), new Bin("bn4", Value.get(41)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('402', 402, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 402), 
			new Bin("bn2", Value.get(402)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('403', 403, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 403), 
			new Bin("bn2", Value.get(403)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('404', 404, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 404), 
			new Bin("bn2", Value.get(404)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('405', 405, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 405), 
			new Bin("bn2", Value.get(405)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('406', 406, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 406), 
			new Bin("bn2", Value.get(406)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('407', 407, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 407), 
			new Bin("bn2", Value.get(407)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('408', 408, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 408), 
			new Bin("bn2", Value.get(408)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('409', 409, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 409), 
			new Bin("bn2", Value.get(409)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('410', 410, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 410), 
			new Bin("bn2", Value.get(410)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('411', 411, '42', 42) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 411), 
			new Bin("bn2", Value.get(411)), new Bin("bn3", Value.get("42")), new Bin("bn4", Value.get(42)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('412', 412, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 412), 
			new Bin("bn2", Value.get(412)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('413', 413, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 413), 
			new Bin("bn2", Value.get(413)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('414', 414, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 414), 
			new Bin("bn2", Value.get(414)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('415', 415, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 415), 
			new Bin("bn2", Value.get(415)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('416', 416, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 416), 
			new Bin("bn2", Value.get(416)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('417', 417, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 417), 
			new Bin("bn2", Value.get(417)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('418', 418, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 418), 
			new Bin("bn2", Value.get(418)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('419', 419, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 419), 
			new Bin("bn2", Value.get(419)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('420', 420, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 420), 
			new Bin("bn2", Value.get(420)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('421', 421, '43', 43) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 421), 
			new Bin("bn2", Value.get(421)), new Bin("bn3", Value.get("43")), new Bin("bn4", Value.get(43)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('422', 422, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 422), 
			new Bin("bn2", Value.get(422)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('423', 423, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 423), 
			new Bin("bn2", Value.get(423)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('424', 424, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 424), 
			new Bin("bn2", Value.get(424)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('425', 425, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 425), 
			new Bin("bn2", Value.get(425)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('426', 426, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 426), 
			new Bin("bn2", Value.get(426)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('427', 427, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 427), 
			new Bin("bn2", Value.get(427)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('428', 428, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 428), 
			new Bin("bn2", Value.get(428)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('429', 429, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 429), 
			new Bin("bn2", Value.get(429)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('430', 430, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 430), 
			new Bin("bn2", Value.get(430)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('431', 431, '44', 44) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 431), 
			new Bin("bn2", Value.get(431)), new Bin("bn3", Value.get("44")), new Bin("bn4", Value.get(44)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('432', 432, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 432), 
			new Bin("bn2", Value.get(432)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('433', 433, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 433), 
			new Bin("bn2", Value.get(433)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('434', 434, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 434), 
			new Bin("bn2", Value.get(434)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('435', 435, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 435), 
			new Bin("bn2", Value.get(435)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('436', 436, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 436), 
			new Bin("bn2", Value.get(436)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('437', 437, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 437), 
			new Bin("bn2", Value.get(437)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('438', 438, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 438), 
			new Bin("bn2", Value.get(438)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('439', 439, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 439), 
			new Bin("bn2", Value.get(439)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('440', 440, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 440), 
			new Bin("bn2", Value.get(440)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('441', 441, '45', 45) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 441), 
			new Bin("bn2", Value.get(441)), new Bin("bn3", Value.get("45")), new Bin("bn4", Value.get(45)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('442', 442, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 442), 
			new Bin("bn2", Value.get(442)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('443', 443, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 443), 
			new Bin("bn2", Value.get(443)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('444', 444, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 444), 
			new Bin("bn2", Value.get(444)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('445', 445, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 445), 
			new Bin("bn2", Value.get(445)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('446', 446, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 446), 
			new Bin("bn2", Value.get(446)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('447', 447, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 447), 
			new Bin("bn2", Value.get(447)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('448', 448, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 448), 
			new Bin("bn2", Value.get(448)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('449', 449, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 449), 
			new Bin("bn2", Value.get(449)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('450', 450, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 450), 
			new Bin("bn2", Value.get(450)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('451', 451, '46', 46) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 451), 
			new Bin("bn2", Value.get(451)), new Bin("bn3", Value.get("46")), new Bin("bn4", Value.get(46)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('452', 452, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 452), 
			new Bin("bn2", Value.get(452)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('453', 453, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 453), 
			new Bin("bn2", Value.get(453)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('454', 454, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 454), 
			new Bin("bn2", Value.get(454)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('455', 455, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 455), 
			new Bin("bn2", Value.get(455)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('456', 456, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 456), 
			new Bin("bn2", Value.get(456)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('457', 457, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 457), 
			new Bin("bn2", Value.get(457)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('458', 458, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 458), 
			new Bin("bn2", Value.get(458)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('459', 459, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 459), 
			new Bin("bn2", Value.get(459)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('460', 460, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 460), 
			new Bin("bn2", Value.get(460)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('461', 461, '47', 47) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 461), 
			new Bin("bn2", Value.get(461)), new Bin("bn3", Value.get("47")), new Bin("bn4", Value.get(47)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('462', 462, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 462), 
			new Bin("bn2", Value.get(462)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('463', 463, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 463), 
			new Bin("bn2", Value.get(463)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('464', 464, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 464), 
			new Bin("bn2", Value.get(464)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('465', 465, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 465), 
			new Bin("bn2", Value.get(465)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('466', 466, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 466), 
			new Bin("bn2", Value.get(466)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('467', 467, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 467), 
			new Bin("bn2", Value.get(467)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('468', 468, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 468), 
			new Bin("bn2", Value.get(468)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('469', 469, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 469), 
			new Bin("bn2", Value.get(469)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('470', 470, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 470), 
			new Bin("bn2", Value.get(470)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('471', 471, '48', 48) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 471), 
			new Bin("bn2", Value.get(471)), new Bin("bn3", Value.get("48")), new Bin("bn4", Value.get(48)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('472', 472, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 472), 
			new Bin("bn2", Value.get(472)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('473', 473, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 473), 
			new Bin("bn2", Value.get(473)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('474', 474, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 474), 
			new Bin("bn2", Value.get(474)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('475', 475, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 475), 
			new Bin("bn2", Value.get(475)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('476', 476, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 476), 
			new Bin("bn2", Value.get(476)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('477', 477, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 477), 
			new Bin("bn2", Value.get(477)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('478', 478, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 478), 
			new Bin("bn2", Value.get(478)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('479', 479, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 479), 
			new Bin("bn2", Value.get(479)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('480', 480, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 480), 
			new Bin("bn2", Value.get(480)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('481', 481, '49', 49) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 481), 
			new Bin("bn2", Value.get(481)), new Bin("bn3", Value.get("49")), new Bin("bn4", Value.get(49)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('482', 482, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 482), 
			new Bin("bn2", Value.get(482)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('483', 483, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 483), 
			new Bin("bn2", Value.get(483)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('484', 484, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 484), 
			new Bin("bn2", Value.get(484)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('485', 485, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 485), 
			new Bin("bn2", Value.get(485)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('486', 486, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 486), 
			new Bin("bn2", Value.get(486)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('487', 487, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 487), 
			new Bin("bn2", Value.get(487)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('488', 488, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 488), 
			new Bin("bn2", Value.get(488)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('489', 489, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 489), 
			new Bin("bn2", Value.get(489)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('490', 490, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 490), 
			new Bin("bn2", Value.get(490)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('491', 491, '50', 50) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 491), 
			new Bin("bn2", Value.get(491)), new Bin("bn3", Value.get("50")), new Bin("bn4", Value.get(50)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('492', 492, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 492), 
			new Bin("bn2", Value.get(492)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('493', 493, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 493), 
			new Bin("bn2", Value.get(493)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('494', 494, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 494), 
			new Bin("bn2", Value.get(494)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('495', 495, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 495), 
			new Bin("bn2", Value.get(495)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('496', 496, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 496), 
			new Bin("bn2", Value.get(496)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('497', 497, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 497), 
			new Bin("bn2", Value.get(497)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('498', 498, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 498), 
			new Bin("bn2", Value.get(498)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('499', 499, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 499), 
			new Bin("bn2", Value.get(499)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('500', 500, '51', 51) */
		writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
		client.put(writePolicy, new Key("test", "demo", 500), 
			new Bin("bn2", Value.get(500)), new Bin("bn3", Value.get("51")), new Bin("bn4", Value.get(51)));
					/* select * from test.demo */
		client.scanAll(scanPolicy, "test", "demo", new ScanCallback() {
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Key: " + key);
				System.out.println("Record: " + record);
			}
		});
		/* REGISTER module 'src/test/resources/scanudf.lua' */
		udfFile = new File("module");
		task = client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete(10);
		/* aggregate scanudf.range(200,300) on test.demo */
		stmt = new Statement();
		stmt.setNamespace("test");
		stmt.setSetName("demo");
		stmt.setFilters();
		resultSet = client.queryAggregate(null, stmt, 
			"scanudf", "range" );
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
						/* delete from test.demo where pk = '1' */
		client.delete(writePolicy, new Key("test", "demo", 1));
		/* DELETE from test.demo WHERE PK = '2' */
		client.delete(writePolicy, new Key("test", "demo", 2));
		/* delete from test.demo where pk = '3' */
		client.delete(writePolicy, new Key("test", "demo", 3));
		/* delete from test.demo where pk = '4' */
		client.delete(writePolicy, new Key("test", "demo", 4));
		/* delete from test.demo where pk = '5' */
		client.delete(writePolicy, new Key("test", "demo", 5));
		/* delete from test.demo where pk = '6' */
		client.delete(writePolicy, new Key("test", "demo", 6));
		/* delete from test.demo where pk = '7' */
		client.delete(writePolicy, new Key("test", "demo", 7));
		/* delete from test.demo where pk = '8' */
		client.delete(writePolicy, new Key("test", "demo", 8));
		/* delete from test.demo where pk = '9' */
		client.delete(writePolicy, new Key("test", "demo", 9));
		/* delete from test.demo where pk = '10' */
		client.delete(writePolicy, new Key("test", "demo", 10));
		/* delete from test.demo where pk = '11' */
		client.delete(writePolicy, new Key("test", "demo", 11));
		/* delete from test.demo where pk = '12' */
		client.delete(writePolicy, new Key("test", "demo", 12));
		/* delete from test.demo where pk = '13' */
		client.delete(writePolicy, new Key("test", "demo", 13));
		/* delete from test.demo where pk = '14' */
		client.delete(writePolicy, new Key("test", "demo", 14));
		/* delete from test.demo where pk = '15' */
		client.delete(writePolicy, new Key("test", "demo", 15));
		/* delete from test.demo where pk = '16' */
		client.delete(writePolicy, new Key("test", "demo", 16));
		/* delete from test.demo where pk = '17' */
		client.delete(writePolicy, new Key("test", "demo", 17));
		/* delete from test.demo where pk = '18' */
		client.delete(writePolicy, new Key("test", "demo", 18));
		/* delete from test.demo where pk = '19' */
		client.delete(writePolicy, new Key("test", "demo", 19));
		/* delete from test.demo where pk = '20' */
		client.delete(writePolicy, new Key("test", "demo", 20));
		/* delete from test.demo where pk = '21' */
		client.delete(writePolicy, new Key("test", "demo", 21));
		/* delete from test.demo where pk = '22' */
		client.delete(writePolicy, new Key("test", "demo", 22));
		/* delete from test.demo where pk = '23' */
		client.delete(writePolicy, new Key("test", "demo", 23));
		/* delete from test.demo where pk = '24' */
		client.delete(writePolicy, new Key("test", "demo", 24));
		/* delete from test.demo where pk = '25' */
		client.delete(writePolicy, new Key("test", "demo", 25));
		/* delete from test.demo where pk = '26' */
		client.delete(writePolicy, new Key("test", "demo", 26));
		/* delete from test.demo where pk = '27' */
		client.delete(writePolicy, new Key("test", "demo", 27));
		/* delete from test.demo where pk = '28' */
		client.delete(writePolicy, new Key("test", "demo", 28));
		/* delete from test.demo where pk = '29' */
		client.delete(writePolicy, new Key("test", "demo", 29));
		/* delete from test.demo where pk = '30' */
		client.delete(writePolicy, new Key("test", "demo", 30));
		/* delete from test.demo where pk = '31' */
		client.delete(writePolicy, new Key("test", "demo", 31));
		/* delete from test.demo where pk = '32' */
		client.delete(writePolicy, new Key("test", "demo", 32));
		/* delete from test.demo where pk = '33' */
		client.delete(writePolicy, new Key("test", "demo", 33));
		/* delete from test.demo where pk = '34' */
		client.delete(writePolicy, new Key("test", "demo", 34));
		/* delete from test.demo where pk = '35' */
		client.delete(writePolicy, new Key("test", "demo", 35));
		/* delete from test.demo where pk = '36' */
		client.delete(writePolicy, new Key("test", "demo", 36));
		/* delete from test.demo where pk = '37' */
		client.delete(writePolicy, new Key("test", "demo", 37));
		/* delete from test.demo where pk = '38' */
		client.delete(writePolicy, new Key("test", "demo", 38));
		/* delete from test.demo where pk = '39' */
		client.delete(writePolicy, new Key("test", "demo", 39));
		/* delete from test.demo where pk = '40' */
		client.delete(writePolicy, new Key("test", "demo", 40));
		/* delete from test.demo where pk = '41' */
		client.delete(writePolicy, new Key("test", "demo", 41));
		/* delete from test.demo where pk = '42' */
		client.delete(writePolicy, new Key("test", "demo", 42));
		/* delete from test.demo where pk = '43' */
		client.delete(writePolicy, new Key("test", "demo", 43));
		/* delete from test.demo where pk = '44' */
		client.delete(writePolicy, new Key("test", "demo", 44));
		/* delete from test.demo where pk = '45' */
		client.delete(writePolicy, new Key("test", "demo", 45));
		/* delete from test.demo where pk = '46' */
		client.delete(writePolicy, new Key("test", "demo", 46));
		/* delete from test.demo where pk = '47' */
		client.delete(writePolicy, new Key("test", "demo", 47));
		/* delete from test.demo where pk = '48' */
		client.delete(writePolicy, new Key("test", "demo", 48));
		/* delete from test.demo where pk = '49' */
		client.delete(writePolicy, new Key("test", "demo", 49));
		/* delete from test.demo where pk = '50' */
		client.delete(writePolicy, new Key("test", "demo", 50));
		/* delete from test.demo where pk = '51' */
		client.delete(writePolicy, new Key("test", "demo", 51));
		/* delete from test.demo where pk = '52' */
		client.delete(writePolicy, new Key("test", "demo", 52));
		/* delete from test.demo where pk = '53' */
		client.delete(writePolicy, new Key("test", "demo", 53));
		/* delete from test.demo where pk = '54' */
		client.delete(writePolicy, new Key("test", "demo", 54));
		/* delete from test.demo where pk = '55' */
		client.delete(writePolicy, new Key("test", "demo", 55));
		/* delete from test.demo where pk = '56' */
		client.delete(writePolicy, new Key("test", "demo", 56));
		/* delete from test.demo where pk = '57' */
		client.delete(writePolicy, new Key("test", "demo", 57));
		/* delete from test.demo where pk = '58' */
		client.delete(writePolicy, new Key("test", "demo", 58));
		/* delete from test.demo where pk = '59' */
		client.delete(writePolicy, new Key("test", "demo", 59));
		/* delete from test.demo where pk = '60' */
		client.delete(writePolicy, new Key("test", "demo", 60));
		/* delete from test.demo where pk = '61' */
		client.delete(writePolicy, new Key("test", "demo", 61));
		/* delete from test.demo where pk = '62' */
		client.delete(writePolicy, new Key("test", "demo", 62));
		/* delete from test.demo where pk = '63' */
		client.delete(writePolicy, new Key("test", "demo", 63));
		/* delete from test.demo where pk = '64' */
		client.delete(writePolicy, new Key("test", "demo", 64));
		/* delete from test.demo where pk = '65' */
		client.delete(writePolicy, new Key("test", "demo", 65));
		/* delete from test.demo where pk = '66' */
		client.delete(writePolicy, new Key("test", "demo", 66));
		/* delete from test.demo where pk = '67' */
		client.delete(writePolicy, new Key("test", "demo", 67));
		/* delete from test.demo where pk = '68' */
		client.delete(writePolicy, new Key("test", "demo", 68));
		/* delete from test.demo where pk = '69' */
		client.delete(writePolicy, new Key("test", "demo", 69));
		/* delete from test.demo where pk = '70' */
		client.delete(writePolicy, new Key("test", "demo", 70));
		/* delete from test.demo where pk = '71' */
		client.delete(writePolicy, new Key("test", "demo", 71));
		/* delete from test.demo where pk = '72' */
		client.delete(writePolicy, new Key("test", "demo", 72));
		/* delete from test.demo where pk = '73' */
		client.delete(writePolicy, new Key("test", "demo", 73));
		/* delete from test.demo where pk = '74' */
		client.delete(writePolicy, new Key("test", "demo", 74));
		/* delete from test.demo where pk = '75' */
		client.delete(writePolicy, new Key("test", "demo", 75));
		/* delete from test.demo where pk = '76' */
		client.delete(writePolicy, new Key("test", "demo", 76));
		/* delete from test.demo where pk = '77' */
		client.delete(writePolicy, new Key("test", "demo", 77));
		/* delete from test.demo where pk = '78' */
		client.delete(writePolicy, new Key("test", "demo", 78));
		/* delete from test.demo where pk = '79' */
		client.delete(writePolicy, new Key("test", "demo", 79));
		/* delete from test.demo where pk = '80' */
		client.delete(writePolicy, new Key("test", "demo", 80));
		/* delete from test.demo where pk = '81' */
		client.delete(writePolicy, new Key("test", "demo", 81));
		/* delete from test.demo where pk = '82' */
		client.delete(writePolicy, new Key("test", "demo", 82));
		/* delete from test.demo where pk = '83' */
		client.delete(writePolicy, new Key("test", "demo", 83));
		/* delete from test.demo where pk = '84' */
		client.delete(writePolicy, new Key("test", "demo", 84));
		/* delete from test.demo where pk = '85' */
		client.delete(writePolicy, new Key("test", "demo", 85));
		/* delete from test.demo where pk = '86' */
		client.delete(writePolicy, new Key("test", "demo", 86));
		/* delete from test.demo where pk = '87' */
		client.delete(writePolicy, new Key("test", "demo", 87));
		/* delete from test.demo where pk = '88' */
		client.delete(writePolicy, new Key("test", "demo", 88));
		/* delete from test.demo where pk = '89' */
		client.delete(writePolicy, new Key("test", "demo", 89));
		/* delete from test.demo where pk = '90' */
		client.delete(writePolicy, new Key("test", "demo", 90));
		/* delete from test.demo where pk = '91' */
		client.delete(writePolicy, new Key("test", "demo", 91));
		/* delete from test.demo where pk = '92' */
		client.delete(writePolicy, new Key("test", "demo", 92));
		/* delete from test.demo where pk = '93' */
		client.delete(writePolicy, new Key("test", "demo", 93));
		/* delete from test.demo where pk = '94' */
		client.delete(writePolicy, new Key("test", "demo", 94));
		/* delete from test.demo where pk = '95' */
		client.delete(writePolicy, new Key("test", "demo", 95));
		/* delete from test.demo where pk = '96' */
		client.delete(writePolicy, new Key("test", "demo", 96));
		/* delete from test.demo where pk = '97' */
		client.delete(writePolicy, new Key("test", "demo", 97));
		/* delete from test.demo where pk = '98' */
		client.delete(writePolicy, new Key("test", "demo", 98));
		/* delete from test.demo where pk = '99' */
		client.delete(writePolicy, new Key("test", "demo", 99));
		/* delete from test.demo where pk = '100' */
		client.delete(writePolicy, new Key("test", "demo", 100));
		/* delete from test.demo where pk = '101' */
		client.delete(writePolicy, new Key("test", "demo", 101));
		/* delete from test.demo where pk = '102' */
		client.delete(writePolicy, new Key("test", "demo", 102));
		/* delete from test.demo where pk = '103' */
		client.delete(writePolicy, new Key("test", "demo", 103));
		/* delete from test.demo where pk = '104' */
		client.delete(writePolicy, new Key("test", "demo", 104));
		/* delete from test.demo where pk = '105' */
		client.delete(writePolicy, new Key("test", "demo", 105));
		/* delete from test.demo where pk = '106' */
		client.delete(writePolicy, new Key("test", "demo", 106));
		/* delete from test.demo where pk = '107' */
		client.delete(writePolicy, new Key("test", "demo", 107));
		/* delete from test.demo where pk = '108' */
		client.delete(writePolicy, new Key("test", "demo", 108));
		/* delete from test.demo where pk = '109' */
		client.delete(writePolicy, new Key("test", "demo", 109));
		/* delete from test.demo where pk = '110' */
		client.delete(writePolicy, new Key("test", "demo", 110));
		/* delete from test.demo where pk = '111' */
		client.delete(writePolicy, new Key("test", "demo", 111));
		/* delete from test.demo where pk = '112' */
		client.delete(writePolicy, new Key("test", "demo", 112));
		/* delete from test.demo where pk = '113' */
		client.delete(writePolicy, new Key("test", "demo", 113));
		/* delete from test.demo where pk = '114' */
		client.delete(writePolicy, new Key("test", "demo", 114));
		/* delete from test.demo where pk = '115' */
		client.delete(writePolicy, new Key("test", "demo", 115));
		/* delete from test.demo where pk = '116' */
		client.delete(writePolicy, new Key("test", "demo", 116));
		/* delete from test.demo where pk = '117' */
		client.delete(writePolicy, new Key("test", "demo", 117));
		/* delete from test.demo where pk = '118' */
		client.delete(writePolicy, new Key("test", "demo", 118));
		/* delete from test.demo where pk = '119' */
		client.delete(writePolicy, new Key("test", "demo", 119));
		/* delete from test.demo where pk = '120' */
		client.delete(writePolicy, new Key("test", "demo", 120));
		/* delete from test.demo where pk = '121' */
		client.delete(writePolicy, new Key("test", "demo", 121));
		/* delete from test.demo where pk = '122' */
		client.delete(writePolicy, new Key("test", "demo", 122));
		/* delete from test.demo where pk = '123' */
		client.delete(writePolicy, new Key("test", "demo", 123));
		/* delete from test.demo where pk = '124' */
		client.delete(writePolicy, new Key("test", "demo", 124));
		/* delete from test.demo where pk = '125' */
		client.delete(writePolicy, new Key("test", "demo", 125));
		/* delete from test.demo where pk = '126' */
		client.delete(writePolicy, new Key("test", "demo", 126));
		/* delete from test.demo where pk = '127' */
		client.delete(writePolicy, new Key("test", "demo", 127));
		/* delete from test.demo where pk = '128' */
		client.delete(writePolicy, new Key("test", "demo", 128));
		/* delete from test.demo where pk = '129' */
		client.delete(writePolicy, new Key("test", "demo", 129));
		/* delete from test.demo where pk = '130' */
		client.delete(writePolicy, new Key("test", "demo", 130));
		/* delete from test.demo where pk = '131' */
		client.delete(writePolicy, new Key("test", "demo", 131));
		/* delete from test.demo where pk = '132' */
		client.delete(writePolicy, new Key("test", "demo", 132));
		/* delete from test.demo where pk = '133' */
		client.delete(writePolicy, new Key("test", "demo", 133));
		/* delete from test.demo where pk = '134' */
		client.delete(writePolicy, new Key("test", "demo", 134));
		/* delete from test.demo where pk = '135' */
		client.delete(writePolicy, new Key("test", "demo", 135));
		/* delete from test.demo where pk = '136' */
		client.delete(writePolicy, new Key("test", "demo", 136));
		/* delete from test.demo where pk = '137' */
		client.delete(writePolicy, new Key("test", "demo", 137));
		/* delete from test.demo where pk = '138' */
		client.delete(writePolicy, new Key("test", "demo", 138));
		/* delete from test.demo where pk = '139' */
		client.delete(writePolicy, new Key("test", "demo", 139));
		/* delete from test.demo where pk = '140' */
		client.delete(writePolicy, new Key("test", "demo", 140));
		/* delete from test.demo where pk = '141' */
		client.delete(writePolicy, new Key("test", "demo", 141));
		/* delete from test.demo where pk = '142' */
		client.delete(writePolicy, new Key("test", "demo", 142));
		/* delete from test.demo where pk = '143' */
		client.delete(writePolicy, new Key("test", "demo", 143));
		/* delete from test.demo where pk = '144' */
		client.delete(writePolicy, new Key("test", "demo", 144));
		/* delete from test.demo where pk = '145' */
		client.delete(writePolicy, new Key("test", "demo", 145));
		/* delete from test.demo where pk = '146' */
		client.delete(writePolicy, new Key("test", "demo", 146));
		/* delete from test.demo where pk = '147' */
		client.delete(writePolicy, new Key("test", "demo", 147));
		/* delete from test.demo where pk = '148' */
		client.delete(writePolicy, new Key("test", "demo", 148));
		/* delete from test.demo where pk = '149' */
		client.delete(writePolicy, new Key("test", "demo", 149));
		/* delete from test.demo where pk = '150' */
		client.delete(writePolicy, new Key("test", "demo", 150));
		/* delete from test.demo where pk = '151' */
		client.delete(writePolicy, new Key("test", "demo", 151));
		/* delete from test.demo where pk = '152' */
		client.delete(writePolicy, new Key("test", "demo", 152));
		/* delete from test.demo where pk = '153' */
		client.delete(writePolicy, new Key("test", "demo", 153));
		/* delete from test.demo where pk = '154' */
		client.delete(writePolicy, new Key("test", "demo", 154));
		/* delete from test.demo where pk = '155' */
		client.delete(writePolicy, new Key("test", "demo", 155));
		/* delete from test.demo where pk = '156' */
		client.delete(writePolicy, new Key("test", "demo", 156));
		/* delete from test.demo where pk = '157' */
		client.delete(writePolicy, new Key("test", "demo", 157));
		/* delete from test.demo where pk = '158' */
		client.delete(writePolicy, new Key("test", "demo", 158));
		/* delete from test.demo where pk = '159' */
		client.delete(writePolicy, new Key("test", "demo", 159));
		/* delete from test.demo where pk = '160' */
		client.delete(writePolicy, new Key("test", "demo", 160));
		/* delete from test.demo where pk = '161' */
		client.delete(writePolicy, new Key("test", "demo", 161));
		/* delete from test.demo where pk = '162' */
		client.delete(writePolicy, new Key("test", "demo", 162));
		/* delete from test.demo where pk = '163' */
		client.delete(writePolicy, new Key("test", "demo", 163));
		/* delete from test.demo where pk = '164' */
		client.delete(writePolicy, new Key("test", "demo", 164));
		/* delete from test.demo where pk = '165' */
		client.delete(writePolicy, new Key("test", "demo", 165));
		/* delete from test.demo where pk = '166' */
		client.delete(writePolicy, new Key("test", "demo", 166));
		/* delete from test.demo where pk = '167' */
		client.delete(writePolicy, new Key("test", "demo", 167));
		/* delete from test.demo where pk = '168' */
		client.delete(writePolicy, new Key("test", "demo", 168));
		/* delete from test.demo where pk = '169' */
		client.delete(writePolicy, new Key("test", "demo", 169));
		/* delete from test.demo where pk = '170' */
		client.delete(writePolicy, new Key("test", "demo", 170));
		/* delete from test.demo where pk = '171' */
		client.delete(writePolicy, new Key("test", "demo", 171));
		/* delete from test.demo where pk = '172' */
		client.delete(writePolicy, new Key("test", "demo", 172));
		/* delete from test.demo where pk = '173' */
		client.delete(writePolicy, new Key("test", "demo", 173));
		/* delete from test.demo where pk = '174' */
		client.delete(writePolicy, new Key("test", "demo", 174));
		/* delete from test.demo where pk = '175' */
		client.delete(writePolicy, new Key("test", "demo", 175));
		/* delete from test.demo where pk = '176' */
		client.delete(writePolicy, new Key("test", "demo", 176));
		/* delete from test.demo where pk = '177' */
		client.delete(writePolicy, new Key("test", "demo", 177));
		/* delete from test.demo where pk = '178' */
		client.delete(writePolicy, new Key("test", "demo", 178));
		/* delete from test.demo where pk = '179' */
		client.delete(writePolicy, new Key("test", "demo", 179));
		/* delete from test.demo where pk = '180' */
		client.delete(writePolicy, new Key("test", "demo", 180));
		/* delete from test.demo where pk = '181' */
		client.delete(writePolicy, new Key("test", "demo", 181));
		/* delete from test.demo where pk = '182' */
		client.delete(writePolicy, new Key("test", "demo", 182));
		/* delete from test.demo where pk = '183' */
		client.delete(writePolicy, new Key("test", "demo", 183));
		/* delete from test.demo where pk = '184' */
		client.delete(writePolicy, new Key("test", "demo", 184));
		/* delete from test.demo where pk = '185' */
		client.delete(writePolicy, new Key("test", "demo", 185));
		/* delete from test.demo where pk = '186' */
		client.delete(writePolicy, new Key("test", "demo", 186));
		/* delete from test.demo where pk = '187' */
		client.delete(writePolicy, new Key("test", "demo", 187));
		/* delete from test.demo where pk = '188' */
		client.delete(writePolicy, new Key("test", "demo", 188));
		/* delete from test.demo where pk = '189' */
		client.delete(writePolicy, new Key("test", "demo", 189));
		/* delete from test.demo where pk = '190' */
		client.delete(writePolicy, new Key("test", "demo", 190));
		/* delete from test.demo where pk = '191' */
		client.delete(writePolicy, new Key("test", "demo", 191));
		/* delete from test.demo where pk = '192' */
		client.delete(writePolicy, new Key("test", "demo", 192));
		/* delete from test.demo where pk = '193' */
		client.delete(writePolicy, new Key("test", "demo", 193));
		/* delete from test.demo where pk = '194' */
		client.delete(writePolicy, new Key("test", "demo", 194));
		/* delete from test.demo where pk = '195' */
		client.delete(writePolicy, new Key("test", "demo", 195));
		/* delete from test.demo where pk = '196' */
		client.delete(writePolicy, new Key("test", "demo", 196));
		/* delete from test.demo where pk = '197' */
		client.delete(writePolicy, new Key("test", "demo", 197));
		/* delete from test.demo where pk = '198' */
		client.delete(writePolicy, new Key("test", "demo", 198));
		/* delete from test.demo where pk = '199' */
		client.delete(writePolicy, new Key("test", "demo", 199));
		/* delete from test.demo where pk = '200' */
		client.delete(writePolicy, new Key("test", "demo", 200));
		/* delete from test.demo where pk = '201' */
		client.delete(writePolicy, new Key("test", "demo", 201));
		/* delete from test.demo where pk = '202' */
		client.delete(writePolicy, new Key("test", "demo", 202));
		/* delete from test.demo where pk = '203' */
		client.delete(writePolicy, new Key("test", "demo", 203));
		/* delete from test.demo where pk = '204' */
		client.delete(writePolicy, new Key("test", "demo", 204));
		/* delete from test.demo where pk = '205' */
		client.delete(writePolicy, new Key("test", "demo", 205));
		/* delete from test.demo where pk = '206' */
		client.delete(writePolicy, new Key("test", "demo", 206));
		/* delete from test.demo where pk = '207' */
		client.delete(writePolicy, new Key("test", "demo", 207));
		/* delete from test.demo where pk = '208' */
		client.delete(writePolicy, new Key("test", "demo", 208));
		/* delete from test.demo where pk = '209' */
		client.delete(writePolicy, new Key("test", "demo", 209));
		/* delete from test.demo where pk = '210' */
		client.delete(writePolicy, new Key("test", "demo", 210));
		/* delete from test.demo where pk = '211' */
		client.delete(writePolicy, new Key("test", "demo", 211));
		/* delete from test.demo where pk = '212' */
		client.delete(writePolicy, new Key("test", "demo", 212));
		/* delete from test.demo where pk = '213' */
		client.delete(writePolicy, new Key("test", "demo", 213));
		/* delete from test.demo where pk = '214' */
		client.delete(writePolicy, new Key("test", "demo", 214));
		/* delete from test.demo where pk = '215' */
		client.delete(writePolicy, new Key("test", "demo", 215));
		/* delete from test.demo where pk = '216' */
		client.delete(writePolicy, new Key("test", "demo", 216));
		/* delete from test.demo where pk = '217' */
		client.delete(writePolicy, new Key("test", "demo", 217));
		/* delete from test.demo where pk = '218' */
		client.delete(writePolicy, new Key("test", "demo", 218));
		/* delete from test.demo where pk = '219' */
		client.delete(writePolicy, new Key("test", "demo", 219));
		/* delete from test.demo where pk = '220' */
		client.delete(writePolicy, new Key("test", "demo", 220));
		/* delete from test.demo where pk = '221' */
		client.delete(writePolicy, new Key("test", "demo", 221));
		/* delete from test.demo where pk = '222' */
		client.delete(writePolicy, new Key("test", "demo", 222));
		/* delete from test.demo where pk = '223' */
		client.delete(writePolicy, new Key("test", "demo", 223));
		/* delete from test.demo where pk = '224' */
		client.delete(writePolicy, new Key("test", "demo", 224));
		/* delete from test.demo where pk = '225' */
		client.delete(writePolicy, new Key("test", "demo", 225));
		/* delete from test.demo where pk = '226' */
		client.delete(writePolicy, new Key("test", "demo", 226));
		/* delete from test.demo where pk = '227' */
		client.delete(writePolicy, new Key("test", "demo", 227));
		/* delete from test.demo where pk = '228' */
		client.delete(writePolicy, new Key("test", "demo", 228));
		/* delete from test.demo where pk = '229' */
		client.delete(writePolicy, new Key("test", "demo", 229));
		/* delete from test.demo where pk = '230' */
		client.delete(writePolicy, new Key("test", "demo", 230));
		/* delete from test.demo where pk = '231' */
		client.delete(writePolicy, new Key("test", "demo", 231));
		/* delete from test.demo where pk = '232' */
		client.delete(writePolicy, new Key("test", "demo", 232));
		/* delete from test.demo where pk = '233' */
		client.delete(writePolicy, new Key("test", "demo", 233));
		/* delete from test.demo where pk = '234' */
		client.delete(writePolicy, new Key("test", "demo", 234));
		/* delete from test.demo where pk = '235' */
		client.delete(writePolicy, new Key("test", "demo", 235));
		/* delete from test.demo where pk = '236' */
		client.delete(writePolicy, new Key("test", "demo", 236));
		/* delete from test.demo where pk = '237' */
		client.delete(writePolicy, new Key("test", "demo", 237));
		/* delete from test.demo where pk = '238' */
		client.delete(writePolicy, new Key("test", "demo", 238));
		/* delete from test.demo where pk = '239' */
		client.delete(writePolicy, new Key("test", "demo", 239));
		/* delete from test.demo where pk = '240' */
		client.delete(writePolicy, new Key("test", "demo", 240));
		/* delete from test.demo where pk = '241' */
		client.delete(writePolicy, new Key("test", "demo", 241));
		/* delete from test.demo where pk = '242' */
		client.delete(writePolicy, new Key("test", "demo", 242));
		/* delete from test.demo where pk = '243' */
		client.delete(writePolicy, new Key("test", "demo", 243));
		/* delete from test.demo where pk = '244' */
		client.delete(writePolicy, new Key("test", "demo", 244));
		/* delete from test.demo where pk = '245' */
		client.delete(writePolicy, new Key("test", "demo", 245));
		/* delete from test.demo where pk = '246' */
		client.delete(writePolicy, new Key("test", "demo", 246));
		/* delete from test.demo where pk = '247' */
		client.delete(writePolicy, new Key("test", "demo", 247));
		/* delete from test.demo where pk = '248' */
		client.delete(writePolicy, new Key("test", "demo", 248));
		/* delete from test.demo where pk = '249' */
		client.delete(writePolicy, new Key("test", "demo", 249));
		/* delete from test.demo where pk = '250' */
		client.delete(writePolicy, new Key("test", "demo", 250));
		/* delete from test.demo where pk = '251' */
		client.delete(writePolicy, new Key("test", "demo", 251));
		/* delete from test.demo where pk = '252' */
		client.delete(writePolicy, new Key("test", "demo", 252));
		/* delete from test.demo where pk = '253' */
		client.delete(writePolicy, new Key("test", "demo", 253));
		/* delete from test.demo where pk = '254' */
		client.delete(writePolicy, new Key("test", "demo", 254));
		/* delete from test.demo where pk = '255' */
		client.delete(writePolicy, new Key("test", "demo", 255));
		/* delete from test.demo where pk = '256' */
		client.delete(writePolicy, new Key("test", "demo", 256));
		/* delete from test.demo where pk = '257' */
		client.delete(writePolicy, new Key("test", "demo", 257));
		/* delete from test.demo where pk = '258' */
		client.delete(writePolicy, new Key("test", "demo", 258));
		/* delete from test.demo where pk = '259' */
		client.delete(writePolicy, new Key("test", "demo", 259));
		/* delete from test.demo where pk = '260' */
		client.delete(writePolicy, new Key("test", "demo", 260));
		/* delete from test.demo where pk = '261' */
		client.delete(writePolicy, new Key("test", "demo", 261));
		/* delete from test.demo where pk = '262' */
		client.delete(writePolicy, new Key("test", "demo", 262));
		/* delete from test.demo where pk = '263' */
		client.delete(writePolicy, new Key("test", "demo", 263));
		/* delete from test.demo where pk = '264' */
		client.delete(writePolicy, new Key("test", "demo", 264));
		/* delete from test.demo where pk = '265' */
		client.delete(writePolicy, new Key("test", "demo", 265));
		/* delete from test.demo where pk = '266' */
		client.delete(writePolicy, new Key("test", "demo", 266));
		/* delete from test.demo where pk = '267' */
		client.delete(writePolicy, new Key("test", "demo", 267));
		/* delete from test.demo where pk = '268' */
		client.delete(writePolicy, new Key("test", "demo", 268));
		/* delete from test.demo where pk = '269' */
		client.delete(writePolicy, new Key("test", "demo", 269));
		/* delete from test.demo where pk = '270' */
		client.delete(writePolicy, new Key("test", "demo", 270));
		/* delete from test.demo where pk = '271' */
		client.delete(writePolicy, new Key("test", "demo", 271));
		/* delete from test.demo where pk = '272' */
		client.delete(writePolicy, new Key("test", "demo", 272));
		/* delete from test.demo where pk = '273' */
		client.delete(writePolicy, new Key("test", "demo", 273));
		/* delete from test.demo where pk = '274' */
		client.delete(writePolicy, new Key("test", "demo", 274));
		/* delete from test.demo where pk = '275' */
		client.delete(writePolicy, new Key("test", "demo", 275));
		/* delete from test.demo where pk = '276' */
		client.delete(writePolicy, new Key("test", "demo", 276));
		/* delete from test.demo where pk = '277' */
		client.delete(writePolicy, new Key("test", "demo", 277));
		/* delete from test.demo where pk = '278' */
		client.delete(writePolicy, new Key("test", "demo", 278));
		/* delete from test.demo where pk = '279' */
		client.delete(writePolicy, new Key("test", "demo", 279));
		/* delete from test.demo where pk = '280' */
		client.delete(writePolicy, new Key("test", "demo", 280));
		/* delete from test.demo where pk = '281' */
		client.delete(writePolicy, new Key("test", "demo", 281));
		/* delete from test.demo where pk = '282' */
		client.delete(writePolicy, new Key("test", "demo", 282));
		/* delete from test.demo where pk = '283' */
		client.delete(writePolicy, new Key("test", "demo", 283));
		/* delete from test.demo where pk = '284' */
		client.delete(writePolicy, new Key("test", "demo", 284));
		/* delete from test.demo where pk = '285' */
		client.delete(writePolicy, new Key("test", "demo", 285));
		/* delete from test.demo where pk = '286' */
		client.delete(writePolicy, new Key("test", "demo", 286));
		/* delete from test.demo where pk = '287' */
		client.delete(writePolicy, new Key("test", "demo", 287));
		/* delete from test.demo where pk = '288' */
		client.delete(writePolicy, new Key("test", "demo", 288));
		/* delete from test.demo where pk = '289' */
		client.delete(writePolicy, new Key("test", "demo", 289));
		/* delete from test.demo where pk = '290' */
		client.delete(writePolicy, new Key("test", "demo", 290));
		/* delete from test.demo where pk = '291' */
		client.delete(writePolicy, new Key("test", "demo", 291));
		/* delete from test.demo where pk = '292' */
		client.delete(writePolicy, new Key("test", "demo", 292));
		/* delete from test.demo where pk = '293' */
		client.delete(writePolicy, new Key("test", "demo", 293));
		/* delete from test.demo where pk = '294' */
		client.delete(writePolicy, new Key("test", "demo", 294));
		/* delete from test.demo where pk = '295' */
		client.delete(writePolicy, new Key("test", "demo", 295));
		/* delete from test.demo where pk = '296' */
		client.delete(writePolicy, new Key("test", "demo", 296));
		/* delete from test.demo where pk = '297' */
		client.delete(writePolicy, new Key("test", "demo", 297));
		/* delete from test.demo where pk = '298' */
		client.delete(writePolicy, new Key("test", "demo", 298));
		/* delete from test.demo where pk = '299' */
		client.delete(writePolicy, new Key("test", "demo", 299));
		/* delete from test.demo where pk = '300' */
		client.delete(writePolicy, new Key("test", "demo", 300));
		/* delete from test.demo where pk = '301' */
		client.delete(writePolicy, new Key("test", "demo", 301));
		/* delete from test.demo where pk = '302' */
		client.delete(writePolicy, new Key("test", "demo", 302));
		/* delete from test.demo where pk = '303' */
		client.delete(writePolicy, new Key("test", "demo", 303));
		/* delete from test.demo where pk = '304' */
		client.delete(writePolicy, new Key("test", "demo", 304));
		/* delete from test.demo where pk = '305' */
		client.delete(writePolicy, new Key("test", "demo", 305));
		/* delete from test.demo where pk = '306' */
		client.delete(writePolicy, new Key("test", "demo", 306));
		/* delete from test.demo where pk = '307' */
		client.delete(writePolicy, new Key("test", "demo", 307));
		/* delete from test.demo where pk = '308' */
		client.delete(writePolicy, new Key("test", "demo", 308));
		/* delete from test.demo where pk = '309' */
		client.delete(writePolicy, new Key("test", "demo", 309));
		/* delete from test.demo where pk = '310' */
		client.delete(writePolicy, new Key("test", "demo", 310));
		/* delete from test.demo where pk = '311' */
		client.delete(writePolicy, new Key("test", "demo", 311));
		/* delete from test.demo where pk = '312' */
		client.delete(writePolicy, new Key("test", "demo", 312));
		/* delete from test.demo where pk = '313' */
		client.delete(writePolicy, new Key("test", "demo", 313));
		/* delete from test.demo where pk = '314' */
		client.delete(writePolicy, new Key("test", "demo", 314));
		/* delete from test.demo where pk = '315' */
		client.delete(writePolicy, new Key("test", "demo", 315));
		/* delete from test.demo where pk = '316' */
		client.delete(writePolicy, new Key("test", "demo", 316));
		/* delete from test.demo where pk = '317' */
		client.delete(writePolicy, new Key("test", "demo", 317));
		/* delete from test.demo where pk = '318' */
		client.delete(writePolicy, new Key("test", "demo", 318));
		/* delete from test.demo where pk = '319' */
		client.delete(writePolicy, new Key("test", "demo", 319));
		/* delete from test.demo where pk = '320' */
		client.delete(writePolicy, new Key("test", "demo", 320));
		/* delete from test.demo where pk = '321' */
		client.delete(writePolicy, new Key("test", "demo", 321));
		/* delete from test.demo where pk = '322' */
		client.delete(writePolicy, new Key("test", "demo", 322));
		/* delete from test.demo where pk = '323' */
		client.delete(writePolicy, new Key("test", "demo", 323));
		/* delete from test.demo where pk = '324' */
		client.delete(writePolicy, new Key("test", "demo", 324));
		/* delete from test.demo where pk = '325' */
		client.delete(writePolicy, new Key("test", "demo", 325));
		/* delete from test.demo where pk = '326' */
		client.delete(writePolicy, new Key("test", "demo", 326));
		/* delete from test.demo where pk = '327' */
		client.delete(writePolicy, new Key("test", "demo", 327));
		/* delete from test.demo where pk = '328' */
		client.delete(writePolicy, new Key("test", "demo", 328));
		/* delete from test.demo where pk = '329' */
		client.delete(writePolicy, new Key("test", "demo", 329));
		/* delete from test.demo where pk = '330' */
		client.delete(writePolicy, new Key("test", "demo", 330));
		/* delete from test.demo where pk = '331' */
		client.delete(writePolicy, new Key("test", "demo", 331));
		/* delete from test.demo where pk = '332' */
		client.delete(writePolicy, new Key("test", "demo", 332));
		/* delete from test.demo where pk = '333' */
		client.delete(writePolicy, new Key("test", "demo", 333));
		/* delete from test.demo where pk = '334' */
		client.delete(writePolicy, new Key("test", "demo", 334));
		/* delete from test.demo where pk = '335' */
		client.delete(writePolicy, new Key("test", "demo", 335));
		/* delete from test.demo where pk = '336' */
		client.delete(writePolicy, new Key("test", "demo", 336));
		/* delete from test.demo where pk = '337' */
		client.delete(writePolicy, new Key("test", "demo", 337));
		/* delete from test.demo where pk = '338' */
		client.delete(writePolicy, new Key("test", "demo", 338));
		/* delete from test.demo where pk = '339' */
		client.delete(writePolicy, new Key("test", "demo", 339));
		/* delete from test.demo where pk = '340' */
		client.delete(writePolicy, new Key("test", "demo", 340));
		/* delete from test.demo where pk = '341' */
		client.delete(writePolicy, new Key("test", "demo", 341));
		/* delete from test.demo where pk = '342' */
		client.delete(writePolicy, new Key("test", "demo", 342));
		/* delete from test.demo where pk = '343' */
		client.delete(writePolicy, new Key("test", "demo", 343));
		/* delete from test.demo where pk = '344' */
		client.delete(writePolicy, new Key("test", "demo", 344));
		/* delete from test.demo where pk = '345' */
		client.delete(writePolicy, new Key("test", "demo", 345));
		/* delete from test.demo where pk = '346' */
		client.delete(writePolicy, new Key("test", "demo", 346));
		/* delete from test.demo where pk = '347' */
		client.delete(writePolicy, new Key("test", "demo", 347));
		/* delete from test.demo where pk = '348' */
		client.delete(writePolicy, new Key("test", "demo", 348));
		/* delete from test.demo where pk = '349' */
		client.delete(writePolicy, new Key("test", "demo", 349));
		/* delete from test.demo where pk = '350' */
		client.delete(writePolicy, new Key("test", "demo", 350));
		/* delete from test.demo where pk = '351' */
		client.delete(writePolicy, new Key("test", "demo", 351));
		/* delete from test.demo where pk = '352' */
		client.delete(writePolicy, new Key("test", "demo", 352));
		/* delete from test.demo where pk = '353' */
		client.delete(writePolicy, new Key("test", "demo", 353));
		/* delete from test.demo where pk = '354' */
		client.delete(writePolicy, new Key("test", "demo", 354));
		/* delete from test.demo where pk = '355' */
		client.delete(writePolicy, new Key("test", "demo", 355));
		/* delete from test.demo where pk = '356' */
		client.delete(writePolicy, new Key("test", "demo", 356));
		/* delete from test.demo where pk = '357' */
		client.delete(writePolicy, new Key("test", "demo", 357));
		/* delete from test.demo where pk = '358' */
		client.delete(writePolicy, new Key("test", "demo", 358));
		/* delete from test.demo where pk = '359' */
		client.delete(writePolicy, new Key("test", "demo", 359));
		/* delete from test.demo where pk = '360' */
		client.delete(writePolicy, new Key("test", "demo", 360));
		/* delete from test.demo where pk = '361' */
		client.delete(writePolicy, new Key("test", "demo", 361));
		/* delete from test.demo where pk = '362' */
		client.delete(writePolicy, new Key("test", "demo", 362));
		/* delete from test.demo where pk = '363' */
		client.delete(writePolicy, new Key("test", "demo", 363));
		/* delete from test.demo where pk = '364' */
		client.delete(writePolicy, new Key("test", "demo", 364));
		/* delete from test.demo where pk = '365' */
		client.delete(writePolicy, new Key("test", "demo", 365));
		/* delete from test.demo where pk = '366' */
		client.delete(writePolicy, new Key("test", "demo", 366));
		/* delete from test.demo where pk = '367' */
		client.delete(writePolicy, new Key("test", "demo", 367));
		/* delete from test.demo where pk = '368' */
		client.delete(writePolicy, new Key("test", "demo", 368));
		/* delete from test.demo where pk = '369' */
		client.delete(writePolicy, new Key("test", "demo", 369));
		/* delete from test.demo where pk = '370' */
		client.delete(writePolicy, new Key("test", "demo", 370));
		/* delete from test.demo where pk = '371' */
		client.delete(writePolicy, new Key("test", "demo", 371));
		/* delete from test.demo where pk = '372' */
		client.delete(writePolicy, new Key("test", "demo", 372));
		/* delete from test.demo where pk = '373' */
		client.delete(writePolicy, new Key("test", "demo", 373));
		/* delete from test.demo where pk = '374' */
		client.delete(writePolicy, new Key("test", "demo", 374));
		/* delete from test.demo where pk = '375' */
		client.delete(writePolicy, new Key("test", "demo", 375));
		/* delete from test.demo where pk = '376' */
		client.delete(writePolicy, new Key("test", "demo", 376));
		/* delete from test.demo where pk = '377' */
		client.delete(writePolicy, new Key("test", "demo", 377));
		/* delete from test.demo where pk = '378' */
		client.delete(writePolicy, new Key("test", "demo", 378));
		/* delete from test.demo where pk = '379' */
		client.delete(writePolicy, new Key("test", "demo", 379));
		/* delete from test.demo where pk = '380' */
		client.delete(writePolicy, new Key("test", "demo", 380));
		/* delete from test.demo where pk = '381' */
		client.delete(writePolicy, new Key("test", "demo", 381));
		/* delete from test.demo where pk = '382' */
		client.delete(writePolicy, new Key("test", "demo", 382));
		/* delete from test.demo where pk = '383' */
		client.delete(writePolicy, new Key("test", "demo", 383));
		/* delete from test.demo where pk = '384' */
		client.delete(writePolicy, new Key("test", "demo", 384));
		/* delete from test.demo where pk = '385' */
		client.delete(writePolicy, new Key("test", "demo", 385));
		/* delete from test.demo where pk = '386' */
		client.delete(writePolicy, new Key("test", "demo", 386));
		/* delete from test.demo where pk = '387' */
		client.delete(writePolicy, new Key("test", "demo", 387));
		/* delete from test.demo where pk = '388' */
		client.delete(writePolicy, new Key("test", "demo", 388));
		/* delete from test.demo where pk = '389' */
		client.delete(writePolicy, new Key("test", "demo", 389));
		/* delete from test.demo where pk = '390' */
		client.delete(writePolicy, new Key("test", "demo", 390));
		/* delete from test.demo where pk = '391' */
		client.delete(writePolicy, new Key("test", "demo", 391));
		/* delete from test.demo where pk = '392' */
		client.delete(writePolicy, new Key("test", "demo", 392));
		/* delete from test.demo where pk = '393' */
		client.delete(writePolicy, new Key("test", "demo", 393));
		/* delete from test.demo where pk = '394' */
		client.delete(writePolicy, new Key("test", "demo", 394));
		/* delete from test.demo where pk = '395' */
		client.delete(writePolicy, new Key("test", "demo", 395));
		/* delete from test.demo where pk = '396' */
		client.delete(writePolicy, new Key("test", "demo", 396));
		/* delete from test.demo where pk = '397' */
		client.delete(writePolicy, new Key("test", "demo", 397));
		/* delete from test.demo where pk = '398' */
		client.delete(writePolicy, new Key("test", "demo", 398));
		/* delete from test.demo where pk = '399' */
		client.delete(writePolicy, new Key("test", "demo", 399));
		/* delete from test.demo where pk = '400' */
		client.delete(writePolicy, new Key("test", "demo", 400));
		/* delete from test.demo where pk = '401' */
		client.delete(writePolicy, new Key("test", "demo", 401));
		/* delete from test.demo where pk = '402' */
		client.delete(writePolicy, new Key("test", "demo", 402));
		/* delete from test.demo where pk = '403' */
		client.delete(writePolicy, new Key("test", "demo", 403));
		/* delete from test.demo where pk = '404' */
		client.delete(writePolicy, new Key("test", "demo", 404));
		/* delete from test.demo where pk = '405' */
		client.delete(writePolicy, new Key("test", "demo", 405));
		/* delete from test.demo where pk = '406' */
		client.delete(writePolicy, new Key("test", "demo", 406));
		/* delete from test.demo where pk = '407' */
		client.delete(writePolicy, new Key("test", "demo", 407));
		/* delete from test.demo where pk = '408' */
		client.delete(writePolicy, new Key("test", "demo", 408));
		/* delete from test.demo where pk = '409' */
		client.delete(writePolicy, new Key("test", "demo", 409));
		/* delete from test.demo where pk = '410' */
		client.delete(writePolicy, new Key("test", "demo", 410));
		/* delete from test.demo where pk = '411' */
		client.delete(writePolicy, new Key("test", "demo", 411));
		/* delete from test.demo where pk = '412' */
		client.delete(writePolicy, new Key("test", "demo", 412));
		/* delete from test.demo where pk = '413' */
		client.delete(writePolicy, new Key("test", "demo", 413));
		/* delete from test.demo where pk = '414' */
		client.delete(writePolicy, new Key("test", "demo", 414));
		/* delete from test.demo where pk = '415' */
		client.delete(writePolicy, new Key("test", "demo", 415));
		/* delete from test.demo where pk = '416' */
		client.delete(writePolicy, new Key("test", "demo", 416));
		/* delete from test.demo where pk = '417' */
		client.delete(writePolicy, new Key("test", "demo", 417));
		/* delete from test.demo where pk = '418' */
		client.delete(writePolicy, new Key("test", "demo", 418));
		/* delete from test.demo where pk = '419' */
		client.delete(writePolicy, new Key("test", "demo", 419));
		/* delete from test.demo where pk = '420' */
		client.delete(writePolicy, new Key("test", "demo", 420));
		/* delete from test.demo where pk = '421' */
		client.delete(writePolicy, new Key("test", "demo", 421));
		/* delete from test.demo where pk = '422' */
		client.delete(writePolicy, new Key("test", "demo", 422));
		/* delete from test.demo where pk = '423' */
		client.delete(writePolicy, new Key("test", "demo", 423));
		/* delete from test.demo where pk = '424' */
		client.delete(writePolicy, new Key("test", "demo", 424));
		/* delete from test.demo where pk = '425' */
		client.delete(writePolicy, new Key("test", "demo", 425));
		/* delete from test.demo where pk = '426' */
		client.delete(writePolicy, new Key("test", "demo", 426));
		/* delete from test.demo where pk = '427' */
		client.delete(writePolicy, new Key("test", "demo", 427));
		/* delete from test.demo where pk = '428' */
		client.delete(writePolicy, new Key("test", "demo", 428));
		/* delete from test.demo where pk = '429' */
		client.delete(writePolicy, new Key("test", "demo", 429));
		/* delete from test.demo where pk = '430' */
		client.delete(writePolicy, new Key("test", "demo", 430));
		/* delete from test.demo where pk = '431' */
		client.delete(writePolicy, new Key("test", "demo", 431));
		/* delete from test.demo where pk = '432' */
		client.delete(writePolicy, new Key("test", "demo", 432));
		/* delete from test.demo where pk = '433' */
		client.delete(writePolicy, new Key("test", "demo", 433));
		/* delete from test.demo where pk = '434' */
		client.delete(writePolicy, new Key("test", "demo", 434));
		/* delete from test.demo where pk = '435' */
		client.delete(writePolicy, new Key("test", "demo", 435));
		/* delete from test.demo where pk = '436' */
		client.delete(writePolicy, new Key("test", "demo", 436));
		/* delete from test.demo where pk = '437' */
		client.delete(writePolicy, new Key("test", "demo", 437));
		/* delete from test.demo where pk = '438' */
		client.delete(writePolicy, new Key("test", "demo", 438));
		/* delete from test.demo where pk = '439' */
		client.delete(writePolicy, new Key("test", "demo", 439));
		/* delete from test.demo where pk = '440' */
		client.delete(writePolicy, new Key("test", "demo", 440));
		/* delete from test.demo where pk = '441' */
		client.delete(writePolicy, new Key("test", "demo", 441));
		/* delete from test.demo where pk = '442' */
		client.delete(writePolicy, new Key("test", "demo", 442));
		/* delete from test.demo where pk = '443' */
		client.delete(writePolicy, new Key("test", "demo", 443));
		/* delete from test.demo where pk = '444' */
		client.delete(writePolicy, new Key("test", "demo", 444));
		/* delete from test.demo where pk = '445' */
		client.delete(writePolicy, new Key("test", "demo", 445));
		/* delete from test.demo where pk = '446' */
		client.delete(writePolicy, new Key("test", "demo", 446));
		/* delete from test.demo where pk = '447' */
		client.delete(writePolicy, new Key("test", "demo", 447));
		/* delete from test.demo where pk = '448' */
		client.delete(writePolicy, new Key("test", "demo", 448));
		/* delete from test.demo where pk = '449' */
		client.delete(writePolicy, new Key("test", "demo", 449));
		/* delete from test.demo where pk = '450' */
		client.delete(writePolicy, new Key("test", "demo", 450));
		/* delete from test.demo where pk = '451' */
		client.delete(writePolicy, new Key("test", "demo", 451));
		/* delete from test.demo where pk = '452' */
		client.delete(writePolicy, new Key("test", "demo", 452));
		/* delete from test.demo where pk = '453' */
		client.delete(writePolicy, new Key("test", "demo", 453));
		/* delete from test.demo where pk = '454' */
		client.delete(writePolicy, new Key("test", "demo", 454));
		/* delete from test.demo where pk = '455' */
		client.delete(writePolicy, new Key("test", "demo", 455));
		/* delete from test.demo where pk = '456' */
		client.delete(writePolicy, new Key("test", "demo", 456));
		/* delete from test.demo where pk = '457' */
		client.delete(writePolicy, new Key("test", "demo", 457));
		/* delete from test.demo where pk = '458' */
		client.delete(writePolicy, new Key("test", "demo", 458));
		/* delete from test.demo where pk = '459' */
		client.delete(writePolicy, new Key("test", "demo", 459));
		/* delete from test.demo where pk = '460' */
		client.delete(writePolicy, new Key("test", "demo", 460));
		/* delete from test.demo where pk = '461' */
		client.delete(writePolicy, new Key("test", "demo", 461));
		/* delete from test.demo where pk = '462' */
		client.delete(writePolicy, new Key("test", "demo", 462));
		/* delete from test.demo where pk = '463' */
		client.delete(writePolicy, new Key("test", "demo", 463));
		/* delete from test.demo where pk = '464' */
		client.delete(writePolicy, new Key("test", "demo", 464));
		/* delete from test.demo where pk = '465' */
		client.delete(writePolicy, new Key("test", "demo", 465));
		/* delete from test.demo where pk = '466' */
		client.delete(writePolicy, new Key("test", "demo", 466));
		/* delete from test.demo where pk = '467' */
		client.delete(writePolicy, new Key("test", "demo", 467));
		/* delete from test.demo where pk = '468' */
		client.delete(writePolicy, new Key("test", "demo", 468));
		/* delete from test.demo where pk = '469' */
		client.delete(writePolicy, new Key("test", "demo", 469));
		/* delete from test.demo where pk = '470' */
		client.delete(writePolicy, new Key("test", "demo", 470));
		/* delete from test.demo where pk = '471' */
		client.delete(writePolicy, new Key("test", "demo", 471));
		/* delete from test.demo where pk = '472' */
		client.delete(writePolicy, new Key("test", "demo", 472));
		/* delete from test.demo where pk = '473' */
		client.delete(writePolicy, new Key("test", "demo", 473));
		/* delete from test.demo where pk = '474' */
		client.delete(writePolicy, new Key("test", "demo", 474));
		/* delete from test.demo where pk = '475' */
		client.delete(writePolicy, new Key("test", "demo", 475));
		/* delete from test.demo where pk = '476' */
		client.delete(writePolicy, new Key("test", "demo", 476));
		/* delete from test.demo where pk = '477' */
		client.delete(writePolicy, new Key("test", "demo", 477));
		/* delete from test.demo where pk = '478' */
		client.delete(writePolicy, new Key("test", "demo", 478));
		/* delete from test.demo where pk = '479' */
		client.delete(writePolicy, new Key("test", "demo", 479));
		/* delete from test.demo where pk = '480' */
		client.delete(writePolicy, new Key("test", "demo", 480));
		/* delete from test.demo where pk = '481' */
		client.delete(writePolicy, new Key("test", "demo", 481));
		/* delete from test.demo where pk = '482' */
		client.delete(writePolicy, new Key("test", "demo", 482));
		/* delete from test.demo where pk = '483' */
		client.delete(writePolicy, new Key("test", "demo", 483));
		/* delete from test.demo where pk = '484' */
		client.delete(writePolicy, new Key("test", "demo", 484));
		/* delete from test.demo where pk = '485' */
		client.delete(writePolicy, new Key("test", "demo", 485));
		/* delete from test.demo where pk = '486' */
		client.delete(writePolicy, new Key("test", "demo", 486));
		/* delete from test.demo where pk = '487' */
		client.delete(writePolicy, new Key("test", "demo", 487));
		/* delete from test.demo where pk = '488' */
		client.delete(writePolicy, new Key("test", "demo", 488));
		/* delete from test.demo where pk = '489' */
		client.delete(writePolicy, new Key("test", "demo", 489));
		/* delete from test.demo where pk = '490' */
		client.delete(writePolicy, new Key("test", "demo", 490));
		/* delete from test.demo where pk = '491' */
		client.delete(writePolicy, new Key("test", "demo", 491));
		/* delete from test.demo where pk = '492' */
		client.delete(writePolicy, new Key("test", "demo", 492));
		/* delete from test.demo where pk = '493' */
		client.delete(writePolicy, new Key("test", "demo", 493));
		/* delete from test.demo where pk = '494' */
		client.delete(writePolicy, new Key("test", "demo", 494));
		/* delete from test.demo where pk = '495' */
		client.delete(writePolicy, new Key("test", "demo", 495));
		/* delete from test.demo where pk = '496' */
		client.delete(writePolicy, new Key("test", "demo", 496));
		/* delete from test.demo where pk = '497' */
		client.delete(writePolicy, new Key("test", "demo", 497));
		/* delete from test.demo where pk = '498' */
		client.delete(writePolicy, new Key("test", "demo", 498));
		/* delete from test.demo where pk = '499' */
		client.delete(writePolicy, new Key("test", "demo", 499));
		/* delete from test.demo where pk = '500' */
		client.delete(writePolicy, new Key("test", "demo", 500));

		// AQL statements - finish, total: 1003

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
