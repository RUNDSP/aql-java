
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

public class Scan {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public Scan(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		Scan worker = new Scan("192.168.51.197", 3000);
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
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('101', 101, '11', 11)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("101")), 
			new Bin("bn2", Value.get(101)),
			new Bin("bn3", Value.get("11")),
			new Bin("bn4", Value.get(11))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('102', 102, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("102")), 
			new Bin("bn2", Value.get(102)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('103', 103, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("103")), 
			new Bin("bn2", Value.get(103)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('104', 104, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("104")), 
			new Bin("bn2", Value.get(104)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('105', 105, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("105")), 
			new Bin("bn2", Value.get(105)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('106', 106, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("106")), 
			new Bin("bn2", Value.get(106)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('107', 107, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("107")), 
			new Bin("bn2", Value.get(107)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('108', 108, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("108")), 
			new Bin("bn2", Value.get(108)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('109', 109, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("109")), 
			new Bin("bn2", Value.get(109)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('110', 110, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("110")), 
			new Bin("bn2", Value.get(110)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('111', 111, '12', 12)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("111")), 
			new Bin("bn2", Value.get(111)),
			new Bin("bn3", Value.get("12")),
			new Bin("bn4", Value.get(12))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('112', 112, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("112")), 
			new Bin("bn2", Value.get(112)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('113', 113, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("113")), 
			new Bin("bn2", Value.get(113)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('114', 114, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("114")), 
			new Bin("bn2", Value.get(114)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('115', 115, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("115")), 
			new Bin("bn2", Value.get(115)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('116', 116, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("116")), 
			new Bin("bn2", Value.get(116)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('117', 117, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("117")), 
			new Bin("bn2", Value.get(117)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('118', 118, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("118")), 
			new Bin("bn2", Value.get(118)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('119', 119, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("119")), 
			new Bin("bn2", Value.get(119)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('120', 120, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("120")), 
			new Bin("bn2", Value.get(120)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('121', 121, '13', 13)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("121")), 
			new Bin("bn2", Value.get(121)),
			new Bin("bn3", Value.get("13")),
			new Bin("bn4", Value.get(13))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('122', 122, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("122")), 
			new Bin("bn2", Value.get(122)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('123', 123, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("123")), 
			new Bin("bn2", Value.get(123)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('124', 124, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("124")), 
			new Bin("bn2", Value.get(124)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('125', 125, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("125")), 
			new Bin("bn2", Value.get(125)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('126', 126, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("126")), 
			new Bin("bn2", Value.get(126)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('127', 127, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("127")), 
			new Bin("bn2", Value.get(127)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('128', 128, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("128")), 
			new Bin("bn2", Value.get(128)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('129', 129, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("129")), 
			new Bin("bn2", Value.get(129)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('130', 130, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("130")), 
			new Bin("bn2", Value.get(130)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('131', 131, '14', 14)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("131")), 
			new Bin("bn2", Value.get(131)),
			new Bin("bn3", Value.get("14")),
			new Bin("bn4", Value.get(14))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('132', 132, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("132")), 
			new Bin("bn2", Value.get(132)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('133', 133, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("133")), 
			new Bin("bn2", Value.get(133)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('134', 134, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("134")), 
			new Bin("bn2", Value.get(134)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('135', 135, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("135")), 
			new Bin("bn2", Value.get(135)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('136', 136, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("136")), 
			new Bin("bn2", Value.get(136)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('137', 137, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("137")), 
			new Bin("bn2", Value.get(137)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('138', 138, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("138")), 
			new Bin("bn2", Value.get(138)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('139', 139, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("139")), 
			new Bin("bn2", Value.get(139)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('140', 140, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("140")), 
			new Bin("bn2", Value.get(140)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('141', 141, '15', 15)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("141")), 
			new Bin("bn2", Value.get(141)),
			new Bin("bn3", Value.get("15")),
			new Bin("bn4", Value.get(15))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('142', 142, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("142")), 
			new Bin("bn2", Value.get(142)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('143', 143, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("143")), 
			new Bin("bn2", Value.get(143)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('144', 144, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("144")), 
			new Bin("bn2", Value.get(144)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('145', 145, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("145")), 
			new Bin("bn2", Value.get(145)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('146', 146, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("146")), 
			new Bin("bn2", Value.get(146)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('147', 147, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("147")), 
			new Bin("bn2", Value.get(147)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('148', 148, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("148")), 
			new Bin("bn2", Value.get(148)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('149', 149, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("149")), 
			new Bin("bn2", Value.get(149)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('150', 150, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("150")), 
			new Bin("bn2", Value.get(150)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('151', 151, '16', 16)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("151")), 
			new Bin("bn2", Value.get(151)),
			new Bin("bn3", Value.get("16")),
			new Bin("bn4", Value.get(16))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('152', 152, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("152")), 
			new Bin("bn2", Value.get(152)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('153', 153, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("153")), 
			new Bin("bn2", Value.get(153)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('154', 154, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("154")), 
			new Bin("bn2", Value.get(154)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('155', 155, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("155")), 
			new Bin("bn2", Value.get(155)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('156', 156, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("156")), 
			new Bin("bn2", Value.get(156)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('157', 157, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("157")), 
			new Bin("bn2", Value.get(157)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('158', 158, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("158")), 
			new Bin("bn2", Value.get(158)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('159', 159, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("159")), 
			new Bin("bn2", Value.get(159)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('160', 160, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("160")), 
			new Bin("bn2", Value.get(160)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('161', 161, '17', 17)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("161")), 
			new Bin("bn2", Value.get(161)),
			new Bin("bn3", Value.get("17")),
			new Bin("bn4", Value.get(17))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('162', 162, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("162")), 
			new Bin("bn2", Value.get(162)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('163', 163, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("163")), 
			new Bin("bn2", Value.get(163)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('164', 164, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("164")), 
			new Bin("bn2", Value.get(164)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('165', 165, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("165")), 
			new Bin("bn2", Value.get(165)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('166', 166, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("166")), 
			new Bin("bn2", Value.get(166)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('167', 167, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("167")), 
			new Bin("bn2", Value.get(167)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('168', 168, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("168")), 
			new Bin("bn2", Value.get(168)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('169', 169, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("169")), 
			new Bin("bn2", Value.get(169)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('170', 170, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("170")), 
			new Bin("bn2", Value.get(170)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('171', 171, '18', 18)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("171")), 
			new Bin("bn2", Value.get(171)),
			new Bin("bn3", Value.get("18")),
			new Bin("bn4", Value.get(18))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('172', 172, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("172")), 
			new Bin("bn2", Value.get(172)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('173', 173, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("173")), 
			new Bin("bn2", Value.get(173)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('174', 174, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("174")), 
			new Bin("bn2", Value.get(174)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('175', 175, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("175")), 
			new Bin("bn2", Value.get(175)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('176', 176, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("176")), 
			new Bin("bn2", Value.get(176)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('177', 177, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("177")), 
			new Bin("bn2", Value.get(177)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('178', 178, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("178")), 
			new Bin("bn2", Value.get(178)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('179', 179, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("179")), 
			new Bin("bn2", Value.get(179)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('180', 180, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("180")), 
			new Bin("bn2", Value.get(180)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('181', 181, '19', 19)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("181")), 
			new Bin("bn2", Value.get(181)),
			new Bin("bn3", Value.get("19")),
			new Bin("bn4", Value.get(19))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('182', 182, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("182")), 
			new Bin("bn2", Value.get(182)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('183', 183, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("183")), 
			new Bin("bn2", Value.get(183)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('184', 184, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("184")), 
			new Bin("bn2", Value.get(184)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('185', 185, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("185")), 
			new Bin("bn2", Value.get(185)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('186', 186, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("186")), 
			new Bin("bn2", Value.get(186)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('187', 187, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("187")), 
			new Bin("bn2", Value.get(187)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('188', 188, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("188")), 
			new Bin("bn2", Value.get(188)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('189', 189, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("189")), 
			new Bin("bn2", Value.get(189)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('190', 190, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("190")), 
			new Bin("bn2", Value.get(190)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('191', 191, '20', 20)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("191")), 
			new Bin("bn2", Value.get(191)),
			new Bin("bn3", Value.get("20")),
			new Bin("bn4", Value.get(20))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('192', 192, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("192")), 
			new Bin("bn2", Value.get(192)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('193', 193, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("193")), 
			new Bin("bn2", Value.get(193)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('194', 194, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("194")), 
			new Bin("bn2", Value.get(194)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('195', 195, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("195")), 
			new Bin("bn2", Value.get(195)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('196', 196, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("196")), 
			new Bin("bn2", Value.get(196)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('197', 197, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("197")), 
			new Bin("bn2", Value.get(197)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('198', 198, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("198")), 
			new Bin("bn2", Value.get(198)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('199', 199, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("199")), 
			new Bin("bn2", Value.get(199)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('200', 200, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("200")), 
			new Bin("bn2", Value.get(200)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('201', 201, '21', 21)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("201")), 
			new Bin("bn2", Value.get(201)),
			new Bin("bn3", Value.get("21")),
			new Bin("bn4", Value.get(21))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('202', 202, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("202")), 
			new Bin("bn2", Value.get(202)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('203', 203, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("203")), 
			new Bin("bn2", Value.get(203)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('204', 204, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("204")), 
			new Bin("bn2", Value.get(204)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('205', 205, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("205")), 
			new Bin("bn2", Value.get(205)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('206', 206, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("206")), 
			new Bin("bn2", Value.get(206)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('207', 207, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("207")), 
			new Bin("bn2", Value.get(207)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('208', 208, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("208")), 
			new Bin("bn2", Value.get(208)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('209', 209, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("209")), 
			new Bin("bn2", Value.get(209)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('210', 210, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("210")), 
			new Bin("bn2", Value.get(210)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('211', 211, '22', 22)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("211")), 
			new Bin("bn2", Value.get(211)),
			new Bin("bn3", Value.get("22")),
			new Bin("bn4", Value.get(22))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('212', 212, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("212")), 
			new Bin("bn2", Value.get(212)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('213', 213, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("213")), 
			new Bin("bn2", Value.get(213)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('214', 214, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("214")), 
			new Bin("bn2", Value.get(214)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('215', 215, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("215")), 
			new Bin("bn2", Value.get(215)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('216', 216, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("216")), 
			new Bin("bn2", Value.get(216)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('217', 217, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("217")), 
			new Bin("bn2", Value.get(217)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('218', 218, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("218")), 
			new Bin("bn2", Value.get(218)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('219', 219, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("219")), 
			new Bin("bn2", Value.get(219)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('220', 220, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("220")), 
			new Bin("bn2", Value.get(220)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('221', 221, '23', 23)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("221")), 
			new Bin("bn2", Value.get(221)),
			new Bin("bn3", Value.get("23")),
			new Bin("bn4", Value.get(23))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('222', 222, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("222")), 
			new Bin("bn2", Value.get(222)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('223', 223, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("223")), 
			new Bin("bn2", Value.get(223)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('224', 224, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("224")), 
			new Bin("bn2", Value.get(224)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('225', 225, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("225")), 
			new Bin("bn2", Value.get(225)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('226', 226, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("226")), 
			new Bin("bn2", Value.get(226)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('227', 227, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("227")), 
			new Bin("bn2", Value.get(227)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('228', 228, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("228")), 
			new Bin("bn2", Value.get(228)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('229', 229, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("229")), 
			new Bin("bn2", Value.get(229)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('230', 230, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("230")), 
			new Bin("bn2", Value.get(230)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('231', 231, '24', 24)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("231")), 
			new Bin("bn2", Value.get(231)),
			new Bin("bn3", Value.get("24")),
			new Bin("bn4", Value.get(24))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('232', 232, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("232")), 
			new Bin("bn2", Value.get(232)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('233', 233, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("233")), 
			new Bin("bn2", Value.get(233)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('234', 234, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("234")), 
			new Bin("bn2", Value.get(234)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('235', 235, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("235")), 
			new Bin("bn2", Value.get(235)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('236', 236, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("236")), 
			new Bin("bn2", Value.get(236)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('237', 237, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("237")), 
			new Bin("bn2", Value.get(237)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('238', 238, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("238")), 
			new Bin("bn2", Value.get(238)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('239', 239, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("239")), 
			new Bin("bn2", Value.get(239)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('240', 240, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("240")), 
			new Bin("bn2", Value.get(240)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('241', 241, '25', 25)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("241")), 
			new Bin("bn2", Value.get(241)),
			new Bin("bn3", Value.get("25")),
			new Bin("bn4", Value.get(25))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('242', 242, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("242")), 
			new Bin("bn2", Value.get(242)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('243', 243, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("243")), 
			new Bin("bn2", Value.get(243)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('244', 244, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("244")), 
			new Bin("bn2", Value.get(244)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('245', 245, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("245")), 
			new Bin("bn2", Value.get(245)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('246', 246, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("246")), 
			new Bin("bn2", Value.get(246)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('247', 247, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("247")), 
			new Bin("bn2", Value.get(247)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('248', 248, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("248")), 
			new Bin("bn2", Value.get(248)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('249', 249, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("249")), 
			new Bin("bn2", Value.get(249)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('250', 250, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("250")), 
			new Bin("bn2", Value.get(250)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('251', 251, '26', 26)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("251")), 
			new Bin("bn2", Value.get(251)),
			new Bin("bn3", Value.get("26")),
			new Bin("bn4", Value.get(26))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('252', 252, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("252")), 
			new Bin("bn2", Value.get(252)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('253', 253, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("253")), 
			new Bin("bn2", Value.get(253)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('254', 254, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("254")), 
			new Bin("bn2", Value.get(254)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('255', 255, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("255")), 
			new Bin("bn2", Value.get(255)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('256', 256, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("256")), 
			new Bin("bn2", Value.get(256)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('257', 257, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("257")), 
			new Bin("bn2", Value.get(257)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('258', 258, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("258")), 
			new Bin("bn2", Value.get(258)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('259', 259, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("259")), 
			new Bin("bn2", Value.get(259)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('260', 260, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("260")), 
			new Bin("bn2", Value.get(260)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('261', 261, '27', 27)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("261")), 
			new Bin("bn2", Value.get(261)),
			new Bin("bn3", Value.get("27")),
			new Bin("bn4", Value.get(27))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('262', 262, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("262")), 
			new Bin("bn2", Value.get(262)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('263', 263, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("263")), 
			new Bin("bn2", Value.get(263)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('264', 264, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("264")), 
			new Bin("bn2", Value.get(264)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('265', 265, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("265")), 
			new Bin("bn2", Value.get(265)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('266', 266, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("266")), 
			new Bin("bn2", Value.get(266)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('267', 267, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("267")), 
			new Bin("bn2", Value.get(267)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('268', 268, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("268")), 
			new Bin("bn2", Value.get(268)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('269', 269, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("269")), 
			new Bin("bn2", Value.get(269)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('270', 270, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("270")), 
			new Bin("bn2", Value.get(270)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('271', 271, '28', 28)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("271")), 
			new Bin("bn2", Value.get(271)),
			new Bin("bn3", Value.get("28")),
			new Bin("bn4", Value.get(28))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('272', 272, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("272")), 
			new Bin("bn2", Value.get(272)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('273', 273, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("273")), 
			new Bin("bn2", Value.get(273)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('274', 274, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("274")), 
			new Bin("bn2", Value.get(274)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('275', 275, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("275")), 
			new Bin("bn2", Value.get(275)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('276', 276, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("276")), 
			new Bin("bn2", Value.get(276)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('277', 277, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("277")), 
			new Bin("bn2", Value.get(277)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('278', 278, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("278")), 
			new Bin("bn2", Value.get(278)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('279', 279, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("279")), 
			new Bin("bn2", Value.get(279)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('280', 280, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("280")), 
			new Bin("bn2", Value.get(280)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('281', 281, '29', 29)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("281")), 
			new Bin("bn2", Value.get(281)),
			new Bin("bn3", Value.get("29")),
			new Bin("bn4", Value.get(29))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('282', 282, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("282")), 
			new Bin("bn2", Value.get(282)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('283', 283, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("283")), 
			new Bin("bn2", Value.get(283)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('284', 284, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("284")), 
			new Bin("bn2", Value.get(284)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('285', 285, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("285")), 
			new Bin("bn2", Value.get(285)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('286', 286, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("286")), 
			new Bin("bn2", Value.get(286)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('287', 287, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("287")), 
			new Bin("bn2", Value.get(287)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('288', 288, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("288")), 
			new Bin("bn2", Value.get(288)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('289', 289, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("289")), 
			new Bin("bn2", Value.get(289)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('290', 290, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("290")), 
			new Bin("bn2", Value.get(290)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('291', 291, '30', 30)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("291")), 
			new Bin("bn2", Value.get(291)),
			new Bin("bn3", Value.get("30")),
			new Bin("bn4", Value.get(30))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('292', 292, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("292")), 
			new Bin("bn2", Value.get(292)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('293', 293, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("293")), 
			new Bin("bn2", Value.get(293)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('294', 294, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("294")), 
			new Bin("bn2", Value.get(294)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('295', 295, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("295")), 
			new Bin("bn2", Value.get(295)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('296', 296, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("296")), 
			new Bin("bn2", Value.get(296)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('297', 297, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("297")), 
			new Bin("bn2", Value.get(297)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('298', 298, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("298")), 
			new Bin("bn2", Value.get(298)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('299', 299, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("299")), 
			new Bin("bn2", Value.get(299)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('300', 300, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("300")), 
			new Bin("bn2", Value.get(300)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('301', 301, '31', 31)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("301")), 
			new Bin("bn2", Value.get(301)),
			new Bin("bn3", Value.get("31")),
			new Bin("bn4", Value.get(31))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('302', 302, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("302")), 
			new Bin("bn2", Value.get(302)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('303', 303, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("303")), 
			new Bin("bn2", Value.get(303)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('304', 304, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("304")), 
			new Bin("bn2", Value.get(304)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('305', 305, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("305")), 
			new Bin("bn2", Value.get(305)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('306', 306, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("306")), 
			new Bin("bn2", Value.get(306)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('307', 307, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("307")), 
			new Bin("bn2", Value.get(307)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('308', 308, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("308")), 
			new Bin("bn2", Value.get(308)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('309', 309, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("309")), 
			new Bin("bn2", Value.get(309)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('310', 310, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("310")), 
			new Bin("bn2", Value.get(310)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('311', 311, '32', 32)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("311")), 
			new Bin("bn2", Value.get(311)),
			new Bin("bn3", Value.get("32")),
			new Bin("bn4", Value.get(32))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('312', 312, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("312")), 
			new Bin("bn2", Value.get(312)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('313', 313, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("313")), 
			new Bin("bn2", Value.get(313)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('314', 314, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("314")), 
			new Bin("bn2", Value.get(314)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('315', 315, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("315")), 
			new Bin("bn2", Value.get(315)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('316', 316, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("316")), 
			new Bin("bn2", Value.get(316)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('317', 317, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("317")), 
			new Bin("bn2", Value.get(317)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('318', 318, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("318")), 
			new Bin("bn2", Value.get(318)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('319', 319, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("319")), 
			new Bin("bn2", Value.get(319)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('320', 320, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("320")), 
			new Bin("bn2", Value.get(320)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('321', 321, '33', 33)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("321")), 
			new Bin("bn2", Value.get(321)),
			new Bin("bn3", Value.get("33")),
			new Bin("bn4", Value.get(33))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('322', 322, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("322")), 
			new Bin("bn2", Value.get(322)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('323', 323, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("323")), 
			new Bin("bn2", Value.get(323)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('324', 324, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("324")), 
			new Bin("bn2", Value.get(324)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('325', 325, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("325")), 
			new Bin("bn2", Value.get(325)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('326', 326, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("326")), 
			new Bin("bn2", Value.get(326)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('327', 327, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("327")), 
			new Bin("bn2", Value.get(327)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('328', 328, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("328")), 
			new Bin("bn2", Value.get(328)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('329', 329, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("329")), 
			new Bin("bn2", Value.get(329)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('330', 330, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("330")), 
			new Bin("bn2", Value.get(330)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('331', 331, '34', 34)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("331")), 
			new Bin("bn2", Value.get(331)),
			new Bin("bn3", Value.get("34")),
			new Bin("bn4", Value.get(34))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('332', 332, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("332")), 
			new Bin("bn2", Value.get(332)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('333', 333, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("333")), 
			new Bin("bn2", Value.get(333)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('334', 334, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("334")), 
			new Bin("bn2", Value.get(334)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('335', 335, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("335")), 
			new Bin("bn2", Value.get(335)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('336', 336, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("336")), 
			new Bin("bn2", Value.get(336)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('337', 337, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("337")), 
			new Bin("bn2", Value.get(337)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('338', 338, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("338")), 
			new Bin("bn2", Value.get(338)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('339', 339, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("339")), 
			new Bin("bn2", Value.get(339)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('340', 340, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("340")), 
			new Bin("bn2", Value.get(340)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('341', 341, '35', 35)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("341")), 
			new Bin("bn2", Value.get(341)),
			new Bin("bn3", Value.get("35")),
			new Bin("bn4", Value.get(35))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('342', 342, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("342")), 
			new Bin("bn2", Value.get(342)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('343', 343, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("343")), 
			new Bin("bn2", Value.get(343)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('344', 344, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("344")), 
			new Bin("bn2", Value.get(344)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('345', 345, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("345")), 
			new Bin("bn2", Value.get(345)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('346', 346, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("346")), 
			new Bin("bn2", Value.get(346)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('347', 347, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("347")), 
			new Bin("bn2", Value.get(347)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('348', 348, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("348")), 
			new Bin("bn2", Value.get(348)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('349', 349, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("349")), 
			new Bin("bn2", Value.get(349)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('350', 350, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("350")), 
			new Bin("bn2", Value.get(350)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('351', 351, '36', 36)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("351")), 
			new Bin("bn2", Value.get(351)),
			new Bin("bn3", Value.get("36")),
			new Bin("bn4", Value.get(36))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('352', 352, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("352")), 
			new Bin("bn2", Value.get(352)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('353', 353, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("353")), 
			new Bin("bn2", Value.get(353)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('354', 354, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("354")), 
			new Bin("bn2", Value.get(354)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('355', 355, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("355")), 
			new Bin("bn2", Value.get(355)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('356', 356, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("356")), 
			new Bin("bn2", Value.get(356)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('357', 357, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("357")), 
			new Bin("bn2", Value.get(357)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('358', 358, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("358")), 
			new Bin("bn2", Value.get(358)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('359', 359, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("359")), 
			new Bin("bn2", Value.get(359)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('360', 360, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("360")), 
			new Bin("bn2", Value.get(360)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('361', 361, '37', 37)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("361")), 
			new Bin("bn2", Value.get(361)),
			new Bin("bn3", Value.get("37")),
			new Bin("bn4", Value.get(37))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('362', 362, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("362")), 
			new Bin("bn2", Value.get(362)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('363', 363, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("363")), 
			new Bin("bn2", Value.get(363)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('364', 364, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("364")), 
			new Bin("bn2", Value.get(364)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('365', 365, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("365")), 
			new Bin("bn2", Value.get(365)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('366', 366, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("366")), 
			new Bin("bn2", Value.get(366)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('367', 367, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("367")), 
			new Bin("bn2", Value.get(367)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('368', 368, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("368")), 
			new Bin("bn2", Value.get(368)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('369', 369, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("369")), 
			new Bin("bn2", Value.get(369)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('370', 370, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("370")), 
			new Bin("bn2", Value.get(370)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('371', 371, '38', 38)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("371")), 
			new Bin("bn2", Value.get(371)),
			new Bin("bn3", Value.get("38")),
			new Bin("bn4", Value.get(38))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('372', 372, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("372")), 
			new Bin("bn2", Value.get(372)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('373', 373, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("373")), 
			new Bin("bn2", Value.get(373)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('374', 374, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("374")), 
			new Bin("bn2", Value.get(374)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('375', 375, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("375")), 
			new Bin("bn2", Value.get(375)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('376', 376, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("376")), 
			new Bin("bn2", Value.get(376)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('377', 377, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("377")), 
			new Bin("bn2", Value.get(377)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('378', 378, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("378")), 
			new Bin("bn2", Value.get(378)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('379', 379, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("379")), 
			new Bin("bn2", Value.get(379)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('380', 380, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("380")), 
			new Bin("bn2", Value.get(380)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('381', 381, '39', 39)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("381")), 
			new Bin("bn2", Value.get(381)),
			new Bin("bn3", Value.get("39")),
			new Bin("bn4", Value.get(39))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('382', 382, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("382")), 
			new Bin("bn2", Value.get(382)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('383', 383, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("383")), 
			new Bin("bn2", Value.get(383)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('384', 384, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("384")), 
			new Bin("bn2", Value.get(384)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('385', 385, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("385")), 
			new Bin("bn2", Value.get(385)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('386', 386, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("386")), 
			new Bin("bn2", Value.get(386)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('387', 387, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("387")), 
			new Bin("bn2", Value.get(387)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('388', 388, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("388")), 
			new Bin("bn2", Value.get(388)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('389', 389, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("389")), 
			new Bin("bn2", Value.get(389)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('390', 390, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("390")), 
			new Bin("bn2", Value.get(390)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('391', 391, '40', 40)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("391")), 
			new Bin("bn2", Value.get(391)),
			new Bin("bn3", Value.get("40")),
			new Bin("bn4", Value.get(40))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('392', 392, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("392")), 
			new Bin("bn2", Value.get(392)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('393', 393, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("393")), 
			new Bin("bn2", Value.get(393)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('394', 394, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("394")), 
			new Bin("bn2", Value.get(394)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('395', 395, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("395")), 
			new Bin("bn2", Value.get(395)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('396', 396, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("396")), 
			new Bin("bn2", Value.get(396)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('397', 397, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("397")), 
			new Bin("bn2", Value.get(397)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('398', 398, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("398")), 
			new Bin("bn2", Value.get(398)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('399', 399, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("399")), 
			new Bin("bn2", Value.get(399)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('400', 400, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("400")), 
			new Bin("bn2", Value.get(400)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('401', 401, '41', 41)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("401")), 
			new Bin("bn2", Value.get(401)),
			new Bin("bn3", Value.get("41")),
			new Bin("bn4", Value.get(41))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('402', 402, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("402")), 
			new Bin("bn2", Value.get(402)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('403', 403, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("403")), 
			new Bin("bn2", Value.get(403)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('404', 404, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("404")), 
			new Bin("bn2", Value.get(404)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('405', 405, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("405")), 
			new Bin("bn2", Value.get(405)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('406', 406, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("406")), 
			new Bin("bn2", Value.get(406)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('407', 407, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("407")), 
			new Bin("bn2", Value.get(407)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('408', 408, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("408")), 
			new Bin("bn2", Value.get(408)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('409', 409, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("409")), 
			new Bin("bn2", Value.get(409)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('410', 410, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("410")), 
			new Bin("bn2", Value.get(410)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('411', 411, '42', 42)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("411")), 
			new Bin("bn2", Value.get(411)),
			new Bin("bn3", Value.get("42")),
			new Bin("bn4", Value.get(42))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('412', 412, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("412")), 
			new Bin("bn2", Value.get(412)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('413', 413, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("413")), 
			new Bin("bn2", Value.get(413)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('414', 414, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("414")), 
			new Bin("bn2", Value.get(414)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('415', 415, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("415")), 
			new Bin("bn2", Value.get(415)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('416', 416, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("416")), 
			new Bin("bn2", Value.get(416)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('417', 417, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("417")), 
			new Bin("bn2", Value.get(417)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('418', 418, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("418")), 
			new Bin("bn2", Value.get(418)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('419', 419, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("419")), 
			new Bin("bn2", Value.get(419)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('420', 420, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("420")), 
			new Bin("bn2", Value.get(420)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('421', 421, '43', 43)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("421")), 
			new Bin("bn2", Value.get(421)),
			new Bin("bn3", Value.get("43")),
			new Bin("bn4", Value.get(43))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('422', 422, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("422")), 
			new Bin("bn2", Value.get(422)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('423', 423, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("423")), 
			new Bin("bn2", Value.get(423)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('424', 424, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("424")), 
			new Bin("bn2", Value.get(424)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('425', 425, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("425")), 
			new Bin("bn2", Value.get(425)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('426', 426, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("426")), 
			new Bin("bn2", Value.get(426)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('427', 427, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("427")), 
			new Bin("bn2", Value.get(427)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('428', 428, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("428")), 
			new Bin("bn2", Value.get(428)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('429', 429, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("429")), 
			new Bin("bn2", Value.get(429)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('430', 430, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("430")), 
			new Bin("bn2", Value.get(430)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('431', 431, '44', 44)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("431")), 
			new Bin("bn2", Value.get(431)),
			new Bin("bn3", Value.get("44")),
			new Bin("bn4", Value.get(44))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('432', 432, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("432")), 
			new Bin("bn2", Value.get(432)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('433', 433, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("433")), 
			new Bin("bn2", Value.get(433)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('434', 434, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("434")), 
			new Bin("bn2", Value.get(434)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('435', 435, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("435")), 
			new Bin("bn2", Value.get(435)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('436', 436, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("436")), 
			new Bin("bn2", Value.get(436)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('437', 437, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("437")), 
			new Bin("bn2", Value.get(437)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('438', 438, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("438")), 
			new Bin("bn2", Value.get(438)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('439', 439, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("439")), 
			new Bin("bn2", Value.get(439)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('440', 440, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("440")), 
			new Bin("bn2", Value.get(440)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('441', 441, '45', 45)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("441")), 
			new Bin("bn2", Value.get(441)),
			new Bin("bn3", Value.get("45")),
			new Bin("bn4", Value.get(45))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('442', 442, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("442")), 
			new Bin("bn2", Value.get(442)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('443', 443, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("443")), 
			new Bin("bn2", Value.get(443)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('444', 444, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("444")), 
			new Bin("bn2", Value.get(444)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('445', 445, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("445")), 
			new Bin("bn2", Value.get(445)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('446', 446, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("446")), 
			new Bin("bn2", Value.get(446)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('447', 447, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("447")), 
			new Bin("bn2", Value.get(447)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('448', 448, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("448")), 
			new Bin("bn2", Value.get(448)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('449', 449, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("449")), 
			new Bin("bn2", Value.get(449)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('450', 450, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("450")), 
			new Bin("bn2", Value.get(450)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('451', 451, '46', 46)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("451")), 
			new Bin("bn2", Value.get(451)),
			new Bin("bn3", Value.get("46")),
			new Bin("bn4", Value.get(46))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('452', 452, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("452")), 
			new Bin("bn2", Value.get(452)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('453', 453, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("453")), 
			new Bin("bn2", Value.get(453)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('454', 454, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("454")), 
			new Bin("bn2", Value.get(454)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('455', 455, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("455")), 
			new Bin("bn2", Value.get(455)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('456', 456, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("456")), 
			new Bin("bn2", Value.get(456)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('457', 457, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("457")), 
			new Bin("bn2", Value.get(457)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('458', 458, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("458")), 
			new Bin("bn2", Value.get(458)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('459', 459, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("459")), 
			new Bin("bn2", Value.get(459)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('460', 460, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("460")), 
			new Bin("bn2", Value.get(460)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('461', 461, '47', 47)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("461")), 
			new Bin("bn2", Value.get(461)),
			new Bin("bn3", Value.get("47")),
			new Bin("bn4", Value.get(47))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('462', 462, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("462")), 
			new Bin("bn2", Value.get(462)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('463', 463, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("463")), 
			new Bin("bn2", Value.get(463)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('464', 464, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("464")), 
			new Bin("bn2", Value.get(464)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('465', 465, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("465")), 
			new Bin("bn2", Value.get(465)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('466', 466, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("466")), 
			new Bin("bn2", Value.get(466)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('467', 467, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("467")), 
			new Bin("bn2", Value.get(467)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('468', 468, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("468")), 
			new Bin("bn2", Value.get(468)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('469', 469, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("469")), 
			new Bin("bn2", Value.get(469)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('470', 470, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("470")), 
			new Bin("bn2", Value.get(470)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('471', 471, '48', 48)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("471")), 
			new Bin("bn2", Value.get(471)),
			new Bin("bn3", Value.get("48")),
			new Bin("bn4", Value.get(48))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('472', 472, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("472")), 
			new Bin("bn2", Value.get(472)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('473', 473, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("473")), 
			new Bin("bn2", Value.get(473)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('474', 474, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("474")), 
			new Bin("bn2", Value.get(474)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('475', 475, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("475")), 
			new Bin("bn2", Value.get(475)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('476', 476, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("476")), 
			new Bin("bn2", Value.get(476)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('477', 477, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("477")), 
			new Bin("bn2", Value.get(477)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('478', 478, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("478")), 
			new Bin("bn2", Value.get(478)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('479', 479, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("479")), 
			new Bin("bn2", Value.get(479)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('480', 480, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("480")), 
			new Bin("bn2", Value.get(480)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('481', 481, '49', 49)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("481")), 
			new Bin("bn2", Value.get(481)),
			new Bin("bn3", Value.get("49")),
			new Bin("bn4", Value.get(49))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('482', 482, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("482")), 
			new Bin("bn2", Value.get(482)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('483', 483, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("483")), 
			new Bin("bn2", Value.get(483)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('484', 484, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("484")), 
			new Bin("bn2", Value.get(484)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('485', 485, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("485")), 
			new Bin("bn2", Value.get(485)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('486', 486, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("486")), 
			new Bin("bn2", Value.get(486)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('487', 487, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("487")), 
			new Bin("bn2", Value.get(487)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('488', 488, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("488")), 
			new Bin("bn2", Value.get(488)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('489', 489, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("489")), 
			new Bin("bn2", Value.get(489)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('490', 490, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("490")), 
			new Bin("bn2", Value.get(490)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('491', 491, '50', 50)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("491")), 
			new Bin("bn2", Value.get(491)),
			new Bin("bn3", Value.get("50")),
			new Bin("bn4", Value.get(50))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('492', 492, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("492")), 
			new Bin("bn2", Value.get(492)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('493', 493, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("493")), 
			new Bin("bn2", Value.get(493)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('494', 494, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("494")), 
			new Bin("bn2", Value.get(494)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('495', 495, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("495")), 
			new Bin("bn2", Value.get(495)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('496', 496, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("496")), 
			new Bin("bn2", Value.get(496)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('497', 497, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("497")), 
			new Bin("bn2", Value.get(497)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('498', 498, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("498")), 
			new Bin("bn2", Value.get(498)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('499', 499, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("499")), 
			new Bin("bn2", Value.get(499)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('500', 500, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("500")), 
			new Bin("bn2", Value.get(500)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// select * from test.demo
		scanPolicy = new ScanPolicy();
		this.client.scanAll(scanPolicy, "test", "demo", new ScanCallback() {
					
			@Override
			public void scanCallback(Key key, Record record) throws AerospikeException {
				System.out.println("Record: " + record);
				
			}
		});





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

		// delete from test.demo where pk = '101'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("101")));

		// delete from test.demo where pk = '102'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("102")));

		// delete from test.demo where pk = '103'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("103")));

		// delete from test.demo where pk = '104'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("104")));

		// delete from test.demo where pk = '105'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("105")));

		// delete from test.demo where pk = '106'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("106")));

		// delete from test.demo where pk = '107'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("107")));

		// delete from test.demo where pk = '108'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("108")));

		// delete from test.demo where pk = '109'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("109")));

		// delete from test.demo where pk = '110'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("110")));

		// delete from test.demo where pk = '111'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("111")));

		// delete from test.demo where pk = '112'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("112")));

		// delete from test.demo where pk = '113'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("113")));

		// delete from test.demo where pk = '114'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("114")));

		// delete from test.demo where pk = '115'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("115")));

		// delete from test.demo where pk = '116'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("116")));

		// delete from test.demo where pk = '117'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("117")));

		// delete from test.demo where pk = '118'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("118")));

		// delete from test.demo where pk = '119'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("119")));

		// delete from test.demo where pk = '120'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("120")));

		// delete from test.demo where pk = '121'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("121")));

		// delete from test.demo where pk = '122'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("122")));

		// delete from test.demo where pk = '123'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("123")));

		// delete from test.demo where pk = '124'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("124")));

		// delete from test.demo where pk = '125'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("125")));

		// delete from test.demo where pk = '126'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("126")));

		// delete from test.demo where pk = '127'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("127")));

		// delete from test.demo where pk = '128'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("128")));

		// delete from test.demo where pk = '129'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("129")));

		// delete from test.demo where pk = '130'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("130")));

		// delete from test.demo where pk = '131'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("131")));

		// delete from test.demo where pk = '132'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("132")));

		// delete from test.demo where pk = '133'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("133")));

		// delete from test.demo where pk = '134'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("134")));

		// delete from test.demo where pk = '135'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("135")));

		// delete from test.demo where pk = '136'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("136")));

		// delete from test.demo where pk = '137'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("137")));

		// delete from test.demo where pk = '138'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("138")));

		// delete from test.demo where pk = '139'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("139")));

		// delete from test.demo where pk = '140'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("140")));

		// delete from test.demo where pk = '141'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("141")));

		// delete from test.demo where pk = '142'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("142")));

		// delete from test.demo where pk = '143'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("143")));

		// delete from test.demo where pk = '144'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("144")));

		// delete from test.demo where pk = '145'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("145")));

		// delete from test.demo where pk = '146'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("146")));

		// delete from test.demo where pk = '147'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("147")));

		// delete from test.demo where pk = '148'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("148")));

		// delete from test.demo where pk = '149'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("149")));

		// delete from test.demo where pk = '150'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("150")));

		// delete from test.demo where pk = '151'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("151")));

		// delete from test.demo where pk = '152'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("152")));

		// delete from test.demo where pk = '153'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("153")));

		// delete from test.demo where pk = '154'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("154")));

		// delete from test.demo where pk = '155'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("155")));

		// delete from test.demo where pk = '156'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("156")));

		// delete from test.demo where pk = '157'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("157")));

		// delete from test.demo where pk = '158'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("158")));

		// delete from test.demo where pk = '159'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("159")));

		// delete from test.demo where pk = '160'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("160")));

		// delete from test.demo where pk = '161'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("161")));

		// delete from test.demo where pk = '162'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("162")));

		// delete from test.demo where pk = '163'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("163")));

		// delete from test.demo where pk = '164'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("164")));

		// delete from test.demo where pk = '165'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("165")));

		// delete from test.demo where pk = '166'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("166")));

		// delete from test.demo where pk = '167'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("167")));

		// delete from test.demo where pk = '168'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("168")));

		// delete from test.demo where pk = '169'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("169")));

		// delete from test.demo where pk = '170'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("170")));

		// delete from test.demo where pk = '171'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("171")));

		// delete from test.demo where pk = '172'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("172")));

		// delete from test.demo where pk = '173'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("173")));

		// delete from test.demo where pk = '174'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("174")));

		// delete from test.demo where pk = '175'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("175")));

		// delete from test.demo where pk = '176'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("176")));

		// delete from test.demo where pk = '177'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("177")));

		// delete from test.demo where pk = '178'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("178")));

		// delete from test.demo where pk = '179'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("179")));

		// delete from test.demo where pk = '180'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("180")));

		// delete from test.demo where pk = '181'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("181")));

		// delete from test.demo where pk = '182'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("182")));

		// delete from test.demo where pk = '183'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("183")));

		// delete from test.demo where pk = '184'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("184")));

		// delete from test.demo where pk = '185'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("185")));

		// delete from test.demo where pk = '186'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("186")));

		// delete from test.demo where pk = '187'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("187")));

		// delete from test.demo where pk = '188'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("188")));

		// delete from test.demo where pk = '189'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("189")));

		// delete from test.demo where pk = '190'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("190")));

		// delete from test.demo where pk = '191'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("191")));

		// delete from test.demo where pk = '192'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("192")));

		// delete from test.demo where pk = '193'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("193")));

		// delete from test.demo where pk = '194'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("194")));

		// delete from test.demo where pk = '195'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("195")));

		// delete from test.demo where pk = '196'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("196")));

		// delete from test.demo where pk = '197'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("197")));

		// delete from test.demo where pk = '198'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("198")));

		// delete from test.demo where pk = '199'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("199")));

		// delete from test.demo where pk = '200'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("200")));

		// delete from test.demo where pk = '201'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("201")));

		// delete from test.demo where pk = '202'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("202")));

		// delete from test.demo where pk = '203'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("203")));

		// delete from test.demo where pk = '204'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("204")));

		// delete from test.demo where pk = '205'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("205")));

		// delete from test.demo where pk = '206'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("206")));

		// delete from test.demo where pk = '207'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("207")));

		// delete from test.demo where pk = '208'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("208")));

		// delete from test.demo where pk = '209'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("209")));

		// delete from test.demo where pk = '210'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("210")));

		// delete from test.demo where pk = '211'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("211")));

		// delete from test.demo where pk = '212'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("212")));

		// delete from test.demo where pk = '213'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("213")));

		// delete from test.demo where pk = '214'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("214")));

		// delete from test.demo where pk = '215'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("215")));

		// delete from test.demo where pk = '216'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("216")));

		// delete from test.demo where pk = '217'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("217")));

		// delete from test.demo where pk = '218'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("218")));

		// delete from test.demo where pk = '219'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("219")));

		// delete from test.demo where pk = '220'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("220")));

		// delete from test.demo where pk = '221'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("221")));

		// delete from test.demo where pk = '222'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("222")));

		// delete from test.demo where pk = '223'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("223")));

		// delete from test.demo where pk = '224'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("224")));

		// delete from test.demo where pk = '225'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("225")));

		// delete from test.demo where pk = '226'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("226")));

		// delete from test.demo where pk = '227'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("227")));

		// delete from test.demo where pk = '228'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("228")));

		// delete from test.demo where pk = '229'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("229")));

		// delete from test.demo where pk = '230'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("230")));

		// delete from test.demo where pk = '231'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("231")));

		// delete from test.demo where pk = '232'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("232")));

		// delete from test.demo where pk = '233'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("233")));

		// delete from test.demo where pk = '234'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("234")));

		// delete from test.demo where pk = '235'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("235")));

		// delete from test.demo where pk = '236'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("236")));

		// delete from test.demo where pk = '237'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("237")));

		// delete from test.demo where pk = '238'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("238")));

		// delete from test.demo where pk = '239'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("239")));

		// delete from test.demo where pk = '240'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("240")));

		// delete from test.demo where pk = '241'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("241")));

		// delete from test.demo where pk = '242'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("242")));

		// delete from test.demo where pk = '243'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("243")));

		// delete from test.demo where pk = '244'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("244")));

		// delete from test.demo where pk = '245'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("245")));

		// delete from test.demo where pk = '246'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("246")));

		// delete from test.demo where pk = '247'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("247")));

		// delete from test.demo where pk = '248'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("248")));

		// delete from test.demo where pk = '249'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("249")));

		// delete from test.demo where pk = '250'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("250")));

		// delete from test.demo where pk = '251'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("251")));

		// delete from test.demo where pk = '252'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("252")));

		// delete from test.demo where pk = '253'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("253")));

		// delete from test.demo where pk = '254'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("254")));

		// delete from test.demo where pk = '255'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("255")));

		// delete from test.demo where pk = '256'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("256")));

		// delete from test.demo where pk = '257'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("257")));

		// delete from test.demo where pk = '258'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("258")));

		// delete from test.demo where pk = '259'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("259")));

		// delete from test.demo where pk = '260'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("260")));

		// delete from test.demo where pk = '261'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("261")));

		// delete from test.demo where pk = '262'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("262")));

		// delete from test.demo where pk = '263'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("263")));

		// delete from test.demo where pk = '264'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("264")));

		// delete from test.demo where pk = '265'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("265")));

		// delete from test.demo where pk = '266'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("266")));

		// delete from test.demo where pk = '267'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("267")));

		// delete from test.demo where pk = '268'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("268")));

		// delete from test.demo where pk = '269'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("269")));

		// delete from test.demo where pk = '270'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("270")));

		// delete from test.demo where pk = '271'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("271")));

		// delete from test.demo where pk = '272'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("272")));

		// delete from test.demo where pk = '273'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("273")));

		// delete from test.demo where pk = '274'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("274")));

		// delete from test.demo where pk = '275'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("275")));

		// delete from test.demo where pk = '276'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("276")));

		// delete from test.demo where pk = '277'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("277")));

		// delete from test.demo where pk = '278'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("278")));

		// delete from test.demo where pk = '279'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("279")));

		// delete from test.demo where pk = '280'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("280")));

		// delete from test.demo where pk = '281'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("281")));

		// delete from test.demo where pk = '282'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("282")));

		// delete from test.demo where pk = '283'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("283")));

		// delete from test.demo where pk = '284'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("284")));

		// delete from test.demo where pk = '285'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("285")));

		// delete from test.demo where pk = '286'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("286")));

		// delete from test.demo where pk = '287'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("287")));

		// delete from test.demo where pk = '288'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("288")));

		// delete from test.demo where pk = '289'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("289")));

		// delete from test.demo where pk = '290'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("290")));

		// delete from test.demo where pk = '291'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("291")));

		// delete from test.demo where pk = '292'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("292")));

		// delete from test.demo where pk = '293'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("293")));

		// delete from test.demo where pk = '294'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("294")));

		// delete from test.demo where pk = '295'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("295")));

		// delete from test.demo where pk = '296'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("296")));

		// delete from test.demo where pk = '297'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("297")));

		// delete from test.demo where pk = '298'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("298")));

		// delete from test.demo where pk = '299'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("299")));

		// delete from test.demo where pk = '300'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("300")));

		// delete from test.demo where pk = '301'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("301")));

		// delete from test.demo where pk = '302'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("302")));

		// delete from test.demo where pk = '303'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("303")));

		// delete from test.demo where pk = '304'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("304")));

		// delete from test.demo where pk = '305'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("305")));

		// delete from test.demo where pk = '306'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("306")));

		// delete from test.demo where pk = '307'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("307")));

		// delete from test.demo where pk = '308'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("308")));

		// delete from test.demo where pk = '309'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("309")));

		// delete from test.demo where pk = '310'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("310")));

		// delete from test.demo where pk = '311'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("311")));

		// delete from test.demo where pk = '312'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("312")));

		// delete from test.demo where pk = '313'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("313")));

		// delete from test.demo where pk = '314'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("314")));

		// delete from test.demo where pk = '315'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("315")));

		// delete from test.demo where pk = '316'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("316")));

		// delete from test.demo where pk = '317'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("317")));

		// delete from test.demo where pk = '318'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("318")));

		// delete from test.demo where pk = '319'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("319")));

		// delete from test.demo where pk = '320'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("320")));

		// delete from test.demo where pk = '321'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("321")));

		// delete from test.demo where pk = '322'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("322")));

		// delete from test.demo where pk = '323'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("323")));

		// delete from test.demo where pk = '324'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("324")));

		// delete from test.demo where pk = '325'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("325")));

		// delete from test.demo where pk = '326'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("326")));

		// delete from test.demo where pk = '327'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("327")));

		// delete from test.demo where pk = '328'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("328")));

		// delete from test.demo where pk = '329'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("329")));

		// delete from test.demo where pk = '330'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("330")));

		// delete from test.demo where pk = '331'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("331")));

		// delete from test.demo where pk = '332'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("332")));

		// delete from test.demo where pk = '333'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("333")));

		// delete from test.demo where pk = '334'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("334")));

		// delete from test.demo where pk = '335'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("335")));

		// delete from test.demo where pk = '336'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("336")));

		// delete from test.demo where pk = '337'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("337")));

		// delete from test.demo where pk = '338'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("338")));

		// delete from test.demo where pk = '339'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("339")));

		// delete from test.demo where pk = '340'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("340")));

		// delete from test.demo where pk = '341'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("341")));

		// delete from test.demo where pk = '342'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("342")));

		// delete from test.demo where pk = '343'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("343")));

		// delete from test.demo where pk = '344'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("344")));

		// delete from test.demo where pk = '345'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("345")));

		// delete from test.demo where pk = '346'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("346")));

		// delete from test.demo where pk = '347'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("347")));

		// delete from test.demo where pk = '348'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("348")));

		// delete from test.demo where pk = '349'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("349")));

		// delete from test.demo where pk = '350'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("350")));

		// delete from test.demo where pk = '351'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("351")));

		// delete from test.demo where pk = '352'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("352")));

		// delete from test.demo where pk = '353'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("353")));

		// delete from test.demo where pk = '354'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("354")));

		// delete from test.demo where pk = '355'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("355")));

		// delete from test.demo where pk = '356'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("356")));

		// delete from test.demo where pk = '357'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("357")));

		// delete from test.demo where pk = '358'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("358")));

		// delete from test.demo where pk = '359'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("359")));

		// delete from test.demo where pk = '360'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("360")));

		// delete from test.demo where pk = '361'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("361")));

		// delete from test.demo where pk = '362'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("362")));

		// delete from test.demo where pk = '363'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("363")));

		// delete from test.demo where pk = '364'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("364")));

		// delete from test.demo where pk = '365'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("365")));

		// delete from test.demo where pk = '366'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("366")));

		// delete from test.demo where pk = '367'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("367")));

		// delete from test.demo where pk = '368'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("368")));

		// delete from test.demo where pk = '369'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("369")));

		// delete from test.demo where pk = '370'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("370")));

		// delete from test.demo where pk = '371'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("371")));

		// delete from test.demo where pk = '372'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("372")));

		// delete from test.demo where pk = '373'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("373")));

		// delete from test.demo where pk = '374'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("374")));

		// delete from test.demo where pk = '375'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("375")));

		// delete from test.demo where pk = '376'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("376")));

		// delete from test.demo where pk = '377'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("377")));

		// delete from test.demo where pk = '378'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("378")));

		// delete from test.demo where pk = '379'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("379")));

		// delete from test.demo where pk = '380'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("380")));

		// delete from test.demo where pk = '381'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("381")));

		// delete from test.demo where pk = '382'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("382")));

		// delete from test.demo where pk = '383'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("383")));

		// delete from test.demo where pk = '384'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("384")));

		// delete from test.demo where pk = '385'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("385")));

		// delete from test.demo where pk = '386'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("386")));

		// delete from test.demo where pk = '387'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("387")));

		// delete from test.demo where pk = '388'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("388")));

		// delete from test.demo where pk = '389'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("389")));

		// delete from test.demo where pk = '390'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("390")));

		// delete from test.demo where pk = '391'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("391")));

		// delete from test.demo where pk = '392'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("392")));

		// delete from test.demo where pk = '393'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("393")));

		// delete from test.demo where pk = '394'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("394")));

		// delete from test.demo where pk = '395'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("395")));

		// delete from test.demo where pk = '396'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("396")));

		// delete from test.demo where pk = '397'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("397")));

		// delete from test.demo where pk = '398'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("398")));

		// delete from test.demo where pk = '399'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("399")));

		// delete from test.demo where pk = '400'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("400")));

		// delete from test.demo where pk = '401'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("401")));

		// delete from test.demo where pk = '402'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("402")));

		// delete from test.demo where pk = '403'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("403")));

		// delete from test.demo where pk = '404'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("404")));

		// delete from test.demo where pk = '405'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("405")));

		// delete from test.demo where pk = '406'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("406")));

		// delete from test.demo where pk = '407'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("407")));

		// delete from test.demo where pk = '408'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("408")));

		// delete from test.demo where pk = '409'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("409")));

		// delete from test.demo where pk = '410'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("410")));

		// delete from test.demo where pk = '411'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("411")));

		// delete from test.demo where pk = '412'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("412")));

		// delete from test.demo where pk = '413'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("413")));

		// delete from test.demo where pk = '414'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("414")));

		// delete from test.demo where pk = '415'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("415")));

		// delete from test.demo where pk = '416'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("416")));

		// delete from test.demo where pk = '417'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("417")));

		// delete from test.demo where pk = '418'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("418")));

		// delete from test.demo where pk = '419'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("419")));

		// delete from test.demo where pk = '420'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("420")));

		// delete from test.demo where pk = '421'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("421")));

		// delete from test.demo where pk = '422'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("422")));

		// delete from test.demo where pk = '423'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("423")));

		// delete from test.demo where pk = '424'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("424")));

		// delete from test.demo where pk = '425'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("425")));

		// delete from test.demo where pk = '426'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("426")));

		// delete from test.demo where pk = '427'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("427")));

		// delete from test.demo where pk = '428'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("428")));

		// delete from test.demo where pk = '429'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("429")));

		// delete from test.demo where pk = '430'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("430")));

		// delete from test.demo where pk = '431'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("431")));

		// delete from test.demo where pk = '432'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("432")));

		// delete from test.demo where pk = '433'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("433")));

		// delete from test.demo where pk = '434'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("434")));

		// delete from test.demo where pk = '435'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("435")));

		// delete from test.demo where pk = '436'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("436")));

		// delete from test.demo where pk = '437'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("437")));

		// delete from test.demo where pk = '438'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("438")));

		// delete from test.demo where pk = '439'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("439")));

		// delete from test.demo where pk = '440'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("440")));

		// delete from test.demo where pk = '441'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("441")));

		// delete from test.demo where pk = '442'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("442")));

		// delete from test.demo where pk = '443'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("443")));

		// delete from test.demo where pk = '444'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("444")));

		// delete from test.demo where pk = '445'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("445")));

		// delete from test.demo where pk = '446'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("446")));

		// delete from test.demo where pk = '447'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("447")));

		// delete from test.demo where pk = '448'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("448")));

		// delete from test.demo where pk = '449'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("449")));

		// delete from test.demo where pk = '450'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("450")));

		// delete from test.demo where pk = '451'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("451")));

		// delete from test.demo where pk = '452'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("452")));

		// delete from test.demo where pk = '453'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("453")));

		// delete from test.demo where pk = '454'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("454")));

		// delete from test.demo where pk = '455'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("455")));

		// delete from test.demo where pk = '456'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("456")));

		// delete from test.demo where pk = '457'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("457")));

		// delete from test.demo where pk = '458'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("458")));

		// delete from test.demo where pk = '459'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("459")));

		// delete from test.demo where pk = '460'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("460")));

		// delete from test.demo where pk = '461'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("461")));

		// delete from test.demo where pk = '462'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("462")));

		// delete from test.demo where pk = '463'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("463")));

		// delete from test.demo where pk = '464'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("464")));

		// delete from test.demo where pk = '465'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("465")));

		// delete from test.demo where pk = '466'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("466")));

		// delete from test.demo where pk = '467'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("467")));

		// delete from test.demo where pk = '468'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("468")));

		// delete from test.demo where pk = '469'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("469")));

		// delete from test.demo where pk = '470'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("470")));

		// delete from test.demo where pk = '471'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("471")));

		// delete from test.demo where pk = '472'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("472")));

		// delete from test.demo where pk = '473'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("473")));

		// delete from test.demo where pk = '474'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("474")));

		// delete from test.demo where pk = '475'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("475")));

		// delete from test.demo where pk = '476'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("476")));

		// delete from test.demo where pk = '477'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("477")));

		// delete from test.demo where pk = '478'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("478")));

		// delete from test.demo where pk = '479'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("479")));

		// delete from test.demo where pk = '480'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("480")));

		// delete from test.demo where pk = '481'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("481")));

		// delete from test.demo where pk = '482'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("482")));

		// delete from test.demo where pk = '483'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("483")));

		// delete from test.demo where pk = '484'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("484")));

		// delete from test.demo where pk = '485'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("485")));

		// delete from test.demo where pk = '486'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("486")));

		// delete from test.demo where pk = '487'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("487")));

		// delete from test.demo where pk = '488'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("488")));

		// delete from test.demo where pk = '489'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("489")));

		// delete from test.demo where pk = '490'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("490")));

		// delete from test.demo where pk = '491'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("491")));

		// delete from test.demo where pk = '492'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("492")));

		// delete from test.demo where pk = '493'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("493")));

		// delete from test.demo where pk = '494'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("494")));

		// delete from test.demo where pk = '495'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("495")));

		// delete from test.demo where pk = '496'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("496")));

		// delete from test.demo where pk = '497'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("497")));

		// delete from test.demo where pk = '498'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("498")));

		// delete from test.demo where pk = '499'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("499")));

		// delete from test.demo where pk = '500'
		this.client.delete(this.writePolicy, 
			new Key("test", "demo", Value.get("500")));


		
		// Total AQL statements: 1001
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