
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

public class Select {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public Select(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		Select worker = new Select("192.168.51.197", 3000);
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
		// CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC
		indexTask = this.client.createIndex(this.policy, "test", "demo", "index_bn2", "bn2", IndexType.NUMERIC);
		indexTask.waitTillComplete();
						
		// CREATE INDEX index_bn3 ON test.demo (bn3) STRING
		indexTask = this.client.createIndex(this.policy, "test", "demo", "index_bn3", "bn3", IndexType.STRING);
		indexTask.waitTillComplete();
						
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
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('11', 11, '2', 2)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("11")), 
			new Bin("bn2", Value.get(11)),
			new Bin("bn3", Value.get("2")),
			new Bin("bn4", Value.get(2))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('12', 12, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("12")), 
			new Bin("bn2", Value.get(12)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('13', 13, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("13")), 
			new Bin("bn2", Value.get(13)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('14', 14, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("14")), 
			new Bin("bn2", Value.get(14)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('15', 15, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("15")), 
			new Bin("bn2", Value.get(15)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('16', 16, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("16")), 
			new Bin("bn2", Value.get(16)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('17', 17, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("17")), 
			new Bin("bn2", Value.get(17)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('18', 18, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("18")), 
			new Bin("bn2", Value.get(18)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('19', 19, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("19")), 
			new Bin("bn2", Value.get(19)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('20', 20, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("20")), 
			new Bin("bn2", Value.get(20)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('21', 21, '3', 3)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("21")), 
			new Bin("bn2", Value.get(21)),
			new Bin("bn3", Value.get("3")),
			new Bin("bn4", Value.get(3))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('22', 22, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("22")), 
			new Bin("bn2", Value.get(22)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('23', 23, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("23")), 
			new Bin("bn2", Value.get(23)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('24', 24, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("24")), 
			new Bin("bn2", Value.get(24)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('25', 25, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("25")), 
			new Bin("bn2", Value.get(25)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('26', 26, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("26")), 
			new Bin("bn2", Value.get(26)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('27', 27, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("27")), 
			new Bin("bn2", Value.get(27)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('28', 28, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("28")), 
			new Bin("bn2", Value.get(28)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('29', 29, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("29")), 
			new Bin("bn2", Value.get(29)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('30', 30, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("30")), 
			new Bin("bn2", Value.get(30)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('31', 31, '4', 4)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("31")), 
			new Bin("bn2", Value.get(31)),
			new Bin("bn3", Value.get("4")),
			new Bin("bn4", Value.get(4))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('32', 32, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("32")), 
			new Bin("bn2", Value.get(32)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('33', 33, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("33")), 
			new Bin("bn2", Value.get(33)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('34', 34, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("34")), 
			new Bin("bn2", Value.get(34)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('35', 35, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("35")), 
			new Bin("bn2", Value.get(35)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('36', 36, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("36")), 
			new Bin("bn2", Value.get(36)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('37', 37, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("37")), 
			new Bin("bn2", Value.get(37)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('38', 38, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("38")), 
			new Bin("bn2", Value.get(38)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('39', 39, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("39")), 
			new Bin("bn2", Value.get(39)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('40', 40, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("40")), 
			new Bin("bn2", Value.get(40)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('41', 41, '5', 5)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("41")), 
			new Bin("bn2", Value.get(41)),
			new Bin("bn3", Value.get("5")),
			new Bin("bn4", Value.get(5))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('42', 42, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("42")), 
			new Bin("bn2", Value.get(42)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('43', 43, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("43")), 
			new Bin("bn2", Value.get(43)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('44', 44, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("44")), 
			new Bin("bn2", Value.get(44)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('45', 45, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("45")), 
			new Bin("bn2", Value.get(45)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('46', 46, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("46")), 
			new Bin("bn2", Value.get(46)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('47', 47, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("47")), 
			new Bin("bn2", Value.get(47)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('48', 48, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("48")), 
			new Bin("bn2", Value.get(48)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('49', 49, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("49")), 
			new Bin("bn2", Value.get(49)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('50', 50, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("50")), 
			new Bin("bn2", Value.get(50)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('51', 51, '6', 6)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("51")), 
			new Bin("bn2", Value.get(51)),
			new Bin("bn3", Value.get("6")),
			new Bin("bn4", Value.get(6))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('52', 52, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("52")), 
			new Bin("bn2", Value.get(52)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('53', 53, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("53")), 
			new Bin("bn2", Value.get(53)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('54', 54, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("54")), 
			new Bin("bn2", Value.get(54)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('55', 55, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("55")), 
			new Bin("bn2", Value.get(55)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('56', 56, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("56")), 
			new Bin("bn2", Value.get(56)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('57', 57, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("57")), 
			new Bin("bn2", Value.get(57)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('58', 58, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("58")), 
			new Bin("bn2", Value.get(58)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('59', 59, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("59")), 
			new Bin("bn2", Value.get(59)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('60', 60, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("60")), 
			new Bin("bn2", Value.get(60)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('61', 61, '7', 7)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("61")), 
			new Bin("bn2", Value.get(61)),
			new Bin("bn3", Value.get("7")),
			new Bin("bn4", Value.get(7))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('62', 62, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("62")), 
			new Bin("bn2", Value.get(62)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('63', 63, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("63")), 
			new Bin("bn2", Value.get(63)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('64', 64, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("64")), 
			new Bin("bn2", Value.get(64)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('65', 65, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("65")), 
			new Bin("bn2", Value.get(65)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('66', 66, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("66")), 
			new Bin("bn2", Value.get(66)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('67', 67, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("67")), 
			new Bin("bn2", Value.get(67)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('68', 68, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("68")), 
			new Bin("bn2", Value.get(68)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('69', 69, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("69")), 
			new Bin("bn2", Value.get(69)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('70', 70, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("70")), 
			new Bin("bn2", Value.get(70)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('71', 71, '8', 8)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("71")), 
			new Bin("bn2", Value.get(71)),
			new Bin("bn3", Value.get("8")),
			new Bin("bn4", Value.get(8))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('72', 72, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("72")), 
			new Bin("bn2", Value.get(72)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('73', 73, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("73")), 
			new Bin("bn2", Value.get(73)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('74', 74, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("74")), 
			new Bin("bn2", Value.get(74)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('75', 75, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("75")), 
			new Bin("bn2", Value.get(75)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('76', 76, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("76")), 
			new Bin("bn2", Value.get(76)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('77', 77, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("77")), 
			new Bin("bn2", Value.get(77)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('78', 78, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("78")), 
			new Bin("bn2", Value.get(78)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('79', 79, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("79")), 
			new Bin("bn2", Value.get(79)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('80', 80, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("80")), 
			new Bin("bn2", Value.get(80)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('81', 81, '9', 9)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("81")), 
			new Bin("bn2", Value.get(81)),
			new Bin("bn3", Value.get("9")),
			new Bin("bn4", Value.get(9))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('82', 82, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("82")), 
			new Bin("bn2", Value.get(82)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('83', 83, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("83")), 
			new Bin("bn2", Value.get(83)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('84', 84, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("84")), 
			new Bin("bn2", Value.get(84)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('85', 85, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("85")), 
			new Bin("bn2", Value.get(85)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('86', 86, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("86")), 
			new Bin("bn2", Value.get(86)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('87', 87, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("87")), 
			new Bin("bn2", Value.get(87)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('88', 88, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("88")), 
			new Bin("bn2", Value.get(88)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('89', 89, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("89")), 
			new Bin("bn2", Value.get(89)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('90', 90, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("90")), 
			new Bin("bn2", Value.get(90)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('91', 91, '10', 10)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("91")), 
			new Bin("bn2", Value.get(91)),
			new Bin("bn3", Value.get("10")),
			new Bin("bn4", Value.get(10))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('92', 92, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("92")), 
			new Bin("bn2", Value.get(92)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('93', 93, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("93")), 
			new Bin("bn2", Value.get(93)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('94', 94, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("94")), 
			new Bin("bn2", Value.get(94)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('95', 95, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("95")), 
			new Bin("bn2", Value.get(95)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('96', 96, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("96")), 
			new Bin("bn2", Value.get(96)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('97', 97, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("97")), 
			new Bin("bn2", Value.get(97)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('98', 98, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("98")), 
			new Bin("bn2", Value.get(98)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('99', 99, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("99")), 
			new Bin("bn2", Value.get(99)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('100', 100, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("100")), 
			new Bin("bn2", Value.get(100)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
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




		// show Indexes test.index_bn2
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// show Indexes test.index_bn3
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// show Indexes test.index_bn4
		printInfo("Indexes", Info.request(this.seedHost, this.port, "sindex"));

		// delete from test.demo where pk = '1'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("1")));

		// DELETE from test.demo WHERE PK = '2'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("2")));

		// delete from test.demo where pk = '3'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("3")));

		// delete from test.demo where pk = '4'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("4")));

		// delete from test.demo where pk = '5'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("5")));

		// delete from test.demo where pk = '6'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("6")));

		// delete from test.demo where pk = '7'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("7")));

		// delete from test.demo where pk = '8'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("8")));

		// delete from test.demo where pk = '9'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("9")));

		// delete from test.demo where pk = '10'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("10")));

		// delete from test.demo where pk = '11'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("11")));

		// delete from test.demo where pk = '12'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("12")));

		// delete from test.demo where pk = '13'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("13")));

		// delete from test.demo where pk = '14'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("14")));

		// delete from test.demo where pk = '15'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("15")));

		// delete from test.demo where pk = '16'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("16")));

		// delete from test.demo where pk = '17'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("17")));

		// delete from test.demo where pk = '18'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("18")));

		// delete from test.demo where pk = '19'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("19")));

		// delete from test.demo where pk = '20'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("20")));

		// delete from test.demo where pk = '21'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("21")));

		// delete from test.demo where pk = '22'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("22")));

		// delete from test.demo where pk = '23'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("23")));

		// delete from test.demo where pk = '24'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("24")));

		// delete from test.demo where pk = '25'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("25")));

		// delete from test.demo where pk = '26'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("26")));

		// delete from test.demo where pk = '27'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("27")));

		// delete from test.demo where pk = '28'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("28")));

		// delete from test.demo where pk = '29'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("29")));

		// delete from test.demo where pk = '30'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("30")));

		// delete from test.demo where pk = '31'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("31")));

		// delete from test.demo where pk = '32'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("32")));

		// delete from test.demo where pk = '33'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("33")));

		// delete from test.demo where pk = '34'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("34")));

		// delete from test.demo where pk = '35'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("35")));

		// delete from test.demo where pk = '36'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("36")));

		// delete from test.demo where pk = '37'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("37")));

		// delete from test.demo where pk = '38'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("38")));

		// delete from test.demo where pk = '39'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("39")));

		// delete from test.demo where pk = '40'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("40")));

		// delete from test.demo where pk = '41'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("41")));

		// delete from test.demo where pk = '42'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("42")));

		// delete from test.demo where pk = '43'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("43")));

		// delete from test.demo where pk = '44'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("44")));

		// delete from test.demo where pk = '45'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("45")));

		// delete from test.demo where pk = '46'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("46")));

		// delete from test.demo where pk = '47'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("47")));

		// delete from test.demo where pk = '48'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("48")));

		// delete from test.demo where pk = '49'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("49")));

		// delete from test.demo where pk = '50'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("50")));

		// delete from test.demo where pk = '51'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("51")));

		// delete from test.demo where pk = '52'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("52")));

		// delete from test.demo where pk = '53'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("53")));

		// delete from test.demo where pk = '54'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("54")));

		// delete from test.demo where pk = '55'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("55")));

		// delete from test.demo where pk = '56'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("56")));

		// delete from test.demo where pk = '57'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("57")));

		// delete from test.demo where pk = '58'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("58")));

		// delete from test.demo where pk = '59'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("59")));

		// delete from test.demo where pk = '60'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("60")));

		// delete from test.demo where pk = '61'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("61")));

		// delete from test.demo where pk = '62'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("62")));

		// delete from test.demo where pk = '63'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("63")));

		// delete from test.demo where pk = '64'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("64")));

		// delete from test.demo where pk = '65'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("65")));

		// delete from test.demo where pk = '66'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("66")));

		// delete from test.demo where pk = '67'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("67")));

		// delete from test.demo where pk = '68'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("68")));

		// delete from test.demo where pk = '69'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("69")));

		// delete from test.demo where pk = '70'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("70")));

		// delete from test.demo where pk = '71'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("71")));

		// delete from test.demo where pk = '72'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("72")));

		// delete from test.demo where pk = '73'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("73")));

		// delete from test.demo where pk = '74'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("74")));

		// delete from test.demo where pk = '75'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("75")));

		// delete from test.demo where pk = '76'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("76")));

		// delete from test.demo where pk = '77'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("77")));

		// delete from test.demo where pk = '78'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("78")));

		// delete from test.demo where pk = '79'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("79")));

		// delete from test.demo where pk = '80'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("80")));

		// delete from test.demo where pk = '81'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("81")));

		// delete from test.demo where pk = '82'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("82")));

		// delete from test.demo where pk = '83'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("83")));

		// delete from test.demo where pk = '84'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("84")));

		// delete from test.demo where pk = '85'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("85")));

		// delete from test.demo where pk = '86'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("86")));

		// delete from test.demo where pk = '87'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("87")));

		// delete from test.demo where pk = '88'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("88")));

		// delete from test.demo where pk = '89'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("89")));

		// delete from test.demo where pk = '90'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("90")));

		// delete from test.demo where pk = '91'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("91")));

		// delete from test.demo where pk = '92'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("92")));

		// delete from test.demo where pk = '93'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("93")));

		// delete from test.demo where pk = '94'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("94")));

		// delete from test.demo where pk = '95'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("95")));

		// delete from test.demo where pk = '96'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("96")));

		// delete from test.demo where pk = '97'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("97")));

		// delete from test.demo where pk = '98'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("98")));

		// delete from test.demo where pk = '99'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("99")));

		// delete from test.demo where pk = '100'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("100")));

		// DROP INDEX test.demo index_bn2
		this.client.dropIndex(this.policy, "test", "demo", "index_bn2");

		// DROP INDEX test.demo index_bn3
		this.client.dropIndex(this.policy, "test", "demo", "index_bn3");

		// DROP INDEX test.demo index_bn4
		this.client.dropIndex(this.policy, "test", "demo", "index_bn4");


		
		// Total AQL statements: 216
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