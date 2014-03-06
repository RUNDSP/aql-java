
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

public class INSERT {
	private AerospikeClient client;
	private String seedHost;
	private int port = 3000;
	private Policy policy;
	private WritePolicy writePolicy;

	public INSERT(String seedHost, int port) throws AerospikeException{
		this.policy = new Policy();
		this.writePolicy = new WritePolicy();
		this.seedHost = seedHost;
		this.port = port;
		this.client = new AerospikeClient(seedHost, port);
		
	}

	public static void main(String[] args) throws AerospikeException{
		INSERT worker = new INSERT("127.0.0.1", 3000);
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
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('501', 501, '51', 51)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("501")), 
			new Bin("bn2", Value.get(501)),
			new Bin("bn3", Value.get("51")),
			new Bin("bn4", Value.get(51))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('502', 502, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("502")), 
			new Bin("bn2", Value.get(502)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('503', 503, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("503")), 
			new Bin("bn2", Value.get(503)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('504', 504, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("504")), 
			new Bin("bn2", Value.get(504)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('505', 505, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("505")), 
			new Bin("bn2", Value.get(505)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('506', 506, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("506")), 
			new Bin("bn2", Value.get(506)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('507', 507, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("507")), 
			new Bin("bn2", Value.get(507)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('508', 508, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("508")), 
			new Bin("bn2", Value.get(508)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('509', 509, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("509")), 
			new Bin("bn2", Value.get(509)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('510', 510, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("510")), 
			new Bin("bn2", Value.get(510)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('511', 511, '52', 52)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("511")), 
			new Bin("bn2", Value.get(511)),
			new Bin("bn3", Value.get("52")),
			new Bin("bn4", Value.get(52))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('512', 512, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("512")), 
			new Bin("bn2", Value.get(512)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('513', 513, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("513")), 
			new Bin("bn2", Value.get(513)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('514', 514, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("514")), 
			new Bin("bn2", Value.get(514)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('515', 515, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("515")), 
			new Bin("bn2", Value.get(515)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('516', 516, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("516")), 
			new Bin("bn2", Value.get(516)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('517', 517, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("517")), 
			new Bin("bn2", Value.get(517)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('518', 518, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("518")), 
			new Bin("bn2", Value.get(518)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('519', 519, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("519")), 
			new Bin("bn2", Value.get(519)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('520', 520, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("520")), 
			new Bin("bn2", Value.get(520)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('521', 521, '53', 53)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("521")), 
			new Bin("bn2", Value.get(521)),
			new Bin("bn3", Value.get("53")),
			new Bin("bn4", Value.get(53))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('522', 522, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("522")), 
			new Bin("bn2", Value.get(522)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('523', 523, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("523")), 
			new Bin("bn2", Value.get(523)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('524', 524, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("524")), 
			new Bin("bn2", Value.get(524)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('525', 525, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("525")), 
			new Bin("bn2", Value.get(525)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('526', 526, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("526")), 
			new Bin("bn2", Value.get(526)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('527', 527, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("527")), 
			new Bin("bn2", Value.get(527)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('528', 528, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("528")), 
			new Bin("bn2", Value.get(528)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('529', 529, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("529")), 
			new Bin("bn2", Value.get(529)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('530', 530, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("530")), 
			new Bin("bn2", Value.get(530)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('531', 531, '54', 54)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("531")), 
			new Bin("bn2", Value.get(531)),
			new Bin("bn3", Value.get("54")),
			new Bin("bn4", Value.get(54))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('532', 532, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("532")), 
			new Bin("bn2", Value.get(532)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('533', 533, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("533")), 
			new Bin("bn2", Value.get(533)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('534', 534, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("534")), 
			new Bin("bn2", Value.get(534)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('535', 535, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("535")), 
			new Bin("bn2", Value.get(535)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('536', 536, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("536")), 
			new Bin("bn2", Value.get(536)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('537', 537, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("537")), 
			new Bin("bn2", Value.get(537)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('538', 538, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("538")), 
			new Bin("bn2", Value.get(538)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('539', 539, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("539")), 
			new Bin("bn2", Value.get(539)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('540', 540, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("540")), 
			new Bin("bn2", Value.get(540)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('541', 541, '55', 55)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("541")), 
			new Bin("bn2", Value.get(541)),
			new Bin("bn3", Value.get("55")),
			new Bin("bn4", Value.get(55))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('542', 542, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("542")), 
			new Bin("bn2", Value.get(542)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('543', 543, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("543")), 
			new Bin("bn2", Value.get(543)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('544', 544, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("544")), 
			new Bin("bn2", Value.get(544)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('545', 545, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("545")), 
			new Bin("bn2", Value.get(545)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('546', 546, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("546")), 
			new Bin("bn2", Value.get(546)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('547', 547, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("547")), 
			new Bin("bn2", Value.get(547)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('548', 548, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("548")), 
			new Bin("bn2", Value.get(548)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('549', 549, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("549")), 
			new Bin("bn2", Value.get(549)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('550', 550, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("550")), 
			new Bin("bn2", Value.get(550)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('551', 551, '56', 56)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("551")), 
			new Bin("bn2", Value.get(551)),
			new Bin("bn3", Value.get("56")),
			new Bin("bn4", Value.get(56))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('552', 552, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("552")), 
			new Bin("bn2", Value.get(552)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('553', 553, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("553")), 
			new Bin("bn2", Value.get(553)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('554', 554, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("554")), 
			new Bin("bn2", Value.get(554)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('555', 555, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("555")), 
			new Bin("bn2", Value.get(555)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('556', 556, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("556")), 
			new Bin("bn2", Value.get(556)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('557', 557, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("557")), 
			new Bin("bn2", Value.get(557)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('558', 558, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("558")), 
			new Bin("bn2", Value.get(558)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('559', 559, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("559")), 
			new Bin("bn2", Value.get(559)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('560', 560, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("560")), 
			new Bin("bn2", Value.get(560)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('561', 561, '57', 57)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("561")), 
			new Bin("bn2", Value.get(561)),
			new Bin("bn3", Value.get("57")),
			new Bin("bn4", Value.get(57))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('562', 562, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("562")), 
			new Bin("bn2", Value.get(562)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('563', 563, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("563")), 
			new Bin("bn2", Value.get(563)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('564', 564, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("564")), 
			new Bin("bn2", Value.get(564)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('565', 565, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("565")), 
			new Bin("bn2", Value.get(565)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('566', 566, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("566")), 
			new Bin("bn2", Value.get(566)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('567', 567, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("567")), 
			new Bin("bn2", Value.get(567)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('568', 568, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("568")), 
			new Bin("bn2", Value.get(568)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('569', 569, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("569")), 
			new Bin("bn2", Value.get(569)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('570', 570, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("570")), 
			new Bin("bn2", Value.get(570)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('571', 571, '58', 58)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("571")), 
			new Bin("bn2", Value.get(571)),
			new Bin("bn3", Value.get("58")),
			new Bin("bn4", Value.get(58))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('572', 572, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("572")), 
			new Bin("bn2", Value.get(572)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('573', 573, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("573")), 
			new Bin("bn2", Value.get(573)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('574', 574, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("574")), 
			new Bin("bn2", Value.get(574)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('575', 575, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("575")), 
			new Bin("bn2", Value.get(575)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('576', 576, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("576")), 
			new Bin("bn2", Value.get(576)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('577', 577, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("577")), 
			new Bin("bn2", Value.get(577)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('578', 578, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("578")), 
			new Bin("bn2", Value.get(578)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('579', 579, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("579")), 
			new Bin("bn2", Value.get(579)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('580', 580, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("580")), 
			new Bin("bn2", Value.get(580)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('581', 581, '59', 59)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("581")), 
			new Bin("bn2", Value.get(581)),
			new Bin("bn3", Value.get("59")),
			new Bin("bn4", Value.get(59))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('582', 582, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("582")), 
			new Bin("bn2", Value.get(582)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('583', 583, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("583")), 
			new Bin("bn2", Value.get(583)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('584', 584, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("584")), 
			new Bin("bn2", Value.get(584)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('585', 585, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("585")), 
			new Bin("bn2", Value.get(585)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('586', 586, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("586")), 
			new Bin("bn2", Value.get(586)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('587', 587, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("587")), 
			new Bin("bn2", Value.get(587)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('588', 588, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("588")), 
			new Bin("bn2", Value.get(588)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('589', 589, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("589")), 
			new Bin("bn2", Value.get(589)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('590', 590, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("590")), 
			new Bin("bn2", Value.get(590)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('591', 591, '60', 60)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("591")), 
			new Bin("bn2", Value.get(591)),
			new Bin("bn3", Value.get("60")),
			new Bin("bn4", Value.get(60))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('592', 592, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("592")), 
			new Bin("bn2", Value.get(592)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('593', 593, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("593")), 
			new Bin("bn2", Value.get(593)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('594', 594, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("594")), 
			new Bin("bn2", Value.get(594)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('595', 595, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("595")), 
			new Bin("bn2", Value.get(595)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('596', 596, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("596")), 
			new Bin("bn2", Value.get(596)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('597', 597, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("597")), 
			new Bin("bn2", Value.get(597)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('598', 598, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("598")), 
			new Bin("bn2", Value.get(598)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('599', 599, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("599")), 
			new Bin("bn2", Value.get(599)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('600', 600, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("600")), 
			new Bin("bn2", Value.get(600)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('601', 601, '61', 61)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("601")), 
			new Bin("bn2", Value.get(601)),
			new Bin("bn3", Value.get("61")),
			new Bin("bn4", Value.get(61))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('602', 602, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("602")), 
			new Bin("bn2", Value.get(602)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('603', 603, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("603")), 
			new Bin("bn2", Value.get(603)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('604', 604, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("604")), 
			new Bin("bn2", Value.get(604)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('605', 605, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("605")), 
			new Bin("bn2", Value.get(605)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('606', 606, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("606")), 
			new Bin("bn2", Value.get(606)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('607', 607, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("607")), 
			new Bin("bn2", Value.get(607)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('608', 608, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("608")), 
			new Bin("bn2", Value.get(608)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('609', 609, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("609")), 
			new Bin("bn2", Value.get(609)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('610', 610, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("610")), 
			new Bin("bn2", Value.get(610)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('611', 611, '62', 62)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("611")), 
			new Bin("bn2", Value.get(611)),
			new Bin("bn3", Value.get("62")),
			new Bin("bn4", Value.get(62))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('612', 612, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("612")), 
			new Bin("bn2", Value.get(612)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('613', 613, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("613")), 
			new Bin("bn2", Value.get(613)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('614', 614, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("614")), 
			new Bin("bn2", Value.get(614)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('615', 615, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("615")), 
			new Bin("bn2", Value.get(615)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('616', 616, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("616")), 
			new Bin("bn2", Value.get(616)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('617', 617, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("617")), 
			new Bin("bn2", Value.get(617)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('618', 618, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("618")), 
			new Bin("bn2", Value.get(618)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('619', 619, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("619")), 
			new Bin("bn2", Value.get(619)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('620', 620, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("620")), 
			new Bin("bn2", Value.get(620)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('621', 621, '63', 63)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("621")), 
			new Bin("bn2", Value.get(621)),
			new Bin("bn3", Value.get("63")),
			new Bin("bn4", Value.get(63))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('622', 622, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("622")), 
			new Bin("bn2", Value.get(622)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('623', 623, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("623")), 
			new Bin("bn2", Value.get(623)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('624', 624, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("624")), 
			new Bin("bn2", Value.get(624)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('625', 625, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("625")), 
			new Bin("bn2", Value.get(625)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('626', 626, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("626")), 
			new Bin("bn2", Value.get(626)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('627', 627, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("627")), 
			new Bin("bn2", Value.get(627)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('628', 628, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("628")), 
			new Bin("bn2", Value.get(628)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('629', 629, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("629")), 
			new Bin("bn2", Value.get(629)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('630', 630, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("630")), 
			new Bin("bn2", Value.get(630)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('631', 631, '64', 64)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("631")), 
			new Bin("bn2", Value.get(631)),
			new Bin("bn3", Value.get("64")),
			new Bin("bn4", Value.get(64))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('632', 632, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("632")), 
			new Bin("bn2", Value.get(632)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('633', 633, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("633")), 
			new Bin("bn2", Value.get(633)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('634', 634, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("634")), 
			new Bin("bn2", Value.get(634)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('635', 635, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("635")), 
			new Bin("bn2", Value.get(635)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('636', 636, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("636")), 
			new Bin("bn2", Value.get(636)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('637', 637, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("637")), 
			new Bin("bn2", Value.get(637)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('638', 638, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("638")), 
			new Bin("bn2", Value.get(638)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('639', 639, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("639")), 
			new Bin("bn2", Value.get(639)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('640', 640, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("640")), 
			new Bin("bn2", Value.get(640)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('641', 641, '65', 65)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("641")), 
			new Bin("bn2", Value.get(641)),
			new Bin("bn3", Value.get("65")),
			new Bin("bn4", Value.get(65))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('642', 642, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("642")), 
			new Bin("bn2", Value.get(642)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('643', 643, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("643")), 
			new Bin("bn2", Value.get(643)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('644', 644, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("644")), 
			new Bin("bn2", Value.get(644)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('645', 645, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("645")), 
			new Bin("bn2", Value.get(645)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('646', 646, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("646")), 
			new Bin("bn2", Value.get(646)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('647', 647, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("647")), 
			new Bin("bn2", Value.get(647)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('648', 648, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("648")), 
			new Bin("bn2", Value.get(648)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('649', 649, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("649")), 
			new Bin("bn2", Value.get(649)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('650', 650, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("650")), 
			new Bin("bn2", Value.get(650)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('651', 651, '66', 66)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("651")), 
			new Bin("bn2", Value.get(651)),
			new Bin("bn3", Value.get("66")),
			new Bin("bn4", Value.get(66))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('652', 652, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("652")), 
			new Bin("bn2", Value.get(652)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('653', 653, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("653")), 
			new Bin("bn2", Value.get(653)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('654', 654, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("654")), 
			new Bin("bn2", Value.get(654)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('655', 655, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("655")), 
			new Bin("bn2", Value.get(655)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('656', 656, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("656")), 
			new Bin("bn2", Value.get(656)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('657', 657, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("657")), 
			new Bin("bn2", Value.get(657)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('658', 658, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("658")), 
			new Bin("bn2", Value.get(658)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('659', 659, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("659")), 
			new Bin("bn2", Value.get(659)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('660', 660, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("660")), 
			new Bin("bn2", Value.get(660)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('661', 661, '67', 67)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("661")), 
			new Bin("bn2", Value.get(661)),
			new Bin("bn3", Value.get("67")),
			new Bin("bn4", Value.get(67))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('662', 662, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("662")), 
			new Bin("bn2", Value.get(662)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('663', 663, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("663")), 
			new Bin("bn2", Value.get(663)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('664', 664, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("664")), 
			new Bin("bn2", Value.get(664)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('665', 665, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("665")), 
			new Bin("bn2", Value.get(665)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('666', 666, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("666")), 
			new Bin("bn2", Value.get(666)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('667', 667, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("667")), 
			new Bin("bn2", Value.get(667)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('668', 668, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("668")), 
			new Bin("bn2", Value.get(668)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('669', 669, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("669")), 
			new Bin("bn2", Value.get(669)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('670', 670, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("670")), 
			new Bin("bn2", Value.get(670)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('671', 671, '68', 68)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("671")), 
			new Bin("bn2", Value.get(671)),
			new Bin("bn3", Value.get("68")),
			new Bin("bn4", Value.get(68))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('672', 672, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("672")), 
			new Bin("bn2", Value.get(672)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('673', 673, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("673")), 
			new Bin("bn2", Value.get(673)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('674', 674, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("674")), 
			new Bin("bn2", Value.get(674)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('675', 675, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("675")), 
			new Bin("bn2", Value.get(675)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('676', 676, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("676")), 
			new Bin("bn2", Value.get(676)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('677', 677, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("677")), 
			new Bin("bn2", Value.get(677)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('678', 678, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("678")), 
			new Bin("bn2", Value.get(678)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('679', 679, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("679")), 
			new Bin("bn2", Value.get(679)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('680', 680, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("680")), 
			new Bin("bn2", Value.get(680)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('681', 681, '69', 69)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("681")), 
			new Bin("bn2", Value.get(681)),
			new Bin("bn3", Value.get("69")),
			new Bin("bn4", Value.get(69))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('682', 682, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("682")), 
			new Bin("bn2", Value.get(682)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('683', 683, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("683")), 
			new Bin("bn2", Value.get(683)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('684', 684, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("684")), 
			new Bin("bn2", Value.get(684)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('685', 685, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("685")), 
			new Bin("bn2", Value.get(685)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('686', 686, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("686")), 
			new Bin("bn2", Value.get(686)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('687', 687, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("687")), 
			new Bin("bn2", Value.get(687)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('688', 688, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("688")), 
			new Bin("bn2", Value.get(688)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('689', 689, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("689")), 
			new Bin("bn2", Value.get(689)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('690', 690, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("690")), 
			new Bin("bn2", Value.get(690)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('691', 691, '70', 70)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("691")), 
			new Bin("bn2", Value.get(691)),
			new Bin("bn3", Value.get("70")),
			new Bin("bn4", Value.get(70))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('692', 692, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("692")), 
			new Bin("bn2", Value.get(692)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('693', 693, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("693")), 
			new Bin("bn2", Value.get(693)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('694', 694, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("694")), 
			new Bin("bn2", Value.get(694)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('695', 695, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("695")), 
			new Bin("bn2", Value.get(695)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('696', 696, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("696")), 
			new Bin("bn2", Value.get(696)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('697', 697, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("697")), 
			new Bin("bn2", Value.get(697)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('698', 698, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("698")), 
			new Bin("bn2", Value.get(698)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('699', 699, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("699")), 
			new Bin("bn2", Value.get(699)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('700', 700, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("700")), 
			new Bin("bn2", Value.get(700)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('701', 701, '71', 71)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("701")), 
			new Bin("bn2", Value.get(701)),
			new Bin("bn3", Value.get("71")),
			new Bin("bn4", Value.get(71))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('702', 702, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("702")), 
			new Bin("bn2", Value.get(702)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('703', 703, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("703")), 
			new Bin("bn2", Value.get(703)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('704', 704, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("704")), 
			new Bin("bn2", Value.get(704)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('705', 705, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("705")), 
			new Bin("bn2", Value.get(705)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('706', 706, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("706")), 
			new Bin("bn2", Value.get(706)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('707', 707, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("707")), 
			new Bin("bn2", Value.get(707)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('708', 708, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("708")), 
			new Bin("bn2", Value.get(708)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('709', 709, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("709")), 
			new Bin("bn2", Value.get(709)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('710', 710, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("710")), 
			new Bin("bn2", Value.get(710)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('711', 711, '72', 72)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("711")), 
			new Bin("bn2", Value.get(711)),
			new Bin("bn3", Value.get("72")),
			new Bin("bn4", Value.get(72))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('712', 712, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("712")), 
			new Bin("bn2", Value.get(712)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('713', 713, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("713")), 
			new Bin("bn2", Value.get(713)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('714', 714, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("714")), 
			new Bin("bn2", Value.get(714)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('715', 715, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("715")), 
			new Bin("bn2", Value.get(715)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('716', 716, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("716")), 
			new Bin("bn2", Value.get(716)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('717', 717, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("717")), 
			new Bin("bn2", Value.get(717)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('718', 718, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("718")), 
			new Bin("bn2", Value.get(718)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('719', 719, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("719")), 
			new Bin("bn2", Value.get(719)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('720', 720, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("720")), 
			new Bin("bn2", Value.get(720)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('721', 721, '73', 73)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("721")), 
			new Bin("bn2", Value.get(721)),
			new Bin("bn3", Value.get("73")),
			new Bin("bn4", Value.get(73))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('722', 722, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("722")), 
			new Bin("bn2", Value.get(722)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('723', 723, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("723")), 
			new Bin("bn2", Value.get(723)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('724', 724, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("724")), 
			new Bin("bn2", Value.get(724)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('725', 725, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("725")), 
			new Bin("bn2", Value.get(725)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('726', 726, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("726")), 
			new Bin("bn2", Value.get(726)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('727', 727, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("727")), 
			new Bin("bn2", Value.get(727)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('728', 728, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("728")), 
			new Bin("bn2", Value.get(728)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('729', 729, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("729")), 
			new Bin("bn2", Value.get(729)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('730', 730, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("730")), 
			new Bin("bn2", Value.get(730)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('731', 731, '74', 74)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("731")), 
			new Bin("bn2", Value.get(731)),
			new Bin("bn3", Value.get("74")),
			new Bin("bn4", Value.get(74))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('732', 732, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("732")), 
			new Bin("bn2", Value.get(732)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('733', 733, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("733")), 
			new Bin("bn2", Value.get(733)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('734', 734, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("734")), 
			new Bin("bn2", Value.get(734)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('735', 735, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("735")), 
			new Bin("bn2", Value.get(735)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('736', 736, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("736")), 
			new Bin("bn2", Value.get(736)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('737', 737, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("737")), 
			new Bin("bn2", Value.get(737)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('738', 738, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("738")), 
			new Bin("bn2", Value.get(738)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('739', 739, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("739")), 
			new Bin("bn2", Value.get(739)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('740', 740, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("740")), 
			new Bin("bn2", Value.get(740)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('741', 741, '75', 75)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("741")), 
			new Bin("bn2", Value.get(741)),
			new Bin("bn3", Value.get("75")),
			new Bin("bn4", Value.get(75))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('742', 742, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("742")), 
			new Bin("bn2", Value.get(742)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('743', 743, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("743")), 
			new Bin("bn2", Value.get(743)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('744', 744, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("744")), 
			new Bin("bn2", Value.get(744)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('745', 745, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("745")), 
			new Bin("bn2", Value.get(745)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('746', 746, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("746")), 
			new Bin("bn2", Value.get(746)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('747', 747, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("747")), 
			new Bin("bn2", Value.get(747)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('748', 748, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("748")), 
			new Bin("bn2", Value.get(748)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('749', 749, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("749")), 
			new Bin("bn2", Value.get(749)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('750', 750, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("750")), 
			new Bin("bn2", Value.get(750)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('751', 751, '76', 76)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("751")), 
			new Bin("bn2", Value.get(751)),
			new Bin("bn3", Value.get("76")),
			new Bin("bn4", Value.get(76))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('752', 752, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("752")), 
			new Bin("bn2", Value.get(752)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('753', 753, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("753")), 
			new Bin("bn2", Value.get(753)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('754', 754, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("754")), 
			new Bin("bn2", Value.get(754)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('755', 755, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("755")), 
			new Bin("bn2", Value.get(755)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('756', 756, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("756")), 
			new Bin("bn2", Value.get(756)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('757', 757, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("757")), 
			new Bin("bn2", Value.get(757)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('758', 758, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("758")), 
			new Bin("bn2", Value.get(758)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('759', 759, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("759")), 
			new Bin("bn2", Value.get(759)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('760', 760, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("760")), 
			new Bin("bn2", Value.get(760)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('761', 761, '77', 77)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("761")), 
			new Bin("bn2", Value.get(761)),
			new Bin("bn3", Value.get("77")),
			new Bin("bn4", Value.get(77))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('762', 762, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("762")), 
			new Bin("bn2", Value.get(762)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('763', 763, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("763")), 
			new Bin("bn2", Value.get(763)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('764', 764, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("764")), 
			new Bin("bn2", Value.get(764)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('765', 765, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("765")), 
			new Bin("bn2", Value.get(765)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('766', 766, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("766")), 
			new Bin("bn2", Value.get(766)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('767', 767, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("767")), 
			new Bin("bn2", Value.get(767)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('768', 768, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("768")), 
			new Bin("bn2", Value.get(768)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('769', 769, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("769")), 
			new Bin("bn2", Value.get(769)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('770', 770, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("770")), 
			new Bin("bn2", Value.get(770)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('771', 771, '78', 78)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("771")), 
			new Bin("bn2", Value.get(771)),
			new Bin("bn3", Value.get("78")),
			new Bin("bn4", Value.get(78))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('772', 772, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("772")), 
			new Bin("bn2", Value.get(772)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('773', 773, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("773")), 
			new Bin("bn2", Value.get(773)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('774', 774, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("774")), 
			new Bin("bn2", Value.get(774)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('775', 775, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("775")), 
			new Bin("bn2", Value.get(775)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('776', 776, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("776")), 
			new Bin("bn2", Value.get(776)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('777', 777, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("777")), 
			new Bin("bn2", Value.get(777)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('778', 778, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("778")), 
			new Bin("bn2", Value.get(778)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('779', 779, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("779")), 
			new Bin("bn2", Value.get(779)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('780', 780, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("780")), 
			new Bin("bn2", Value.get(780)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('781', 781, '79', 79)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("781")), 
			new Bin("bn2", Value.get(781)),
			new Bin("bn3", Value.get("79")),
			new Bin("bn4", Value.get(79))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('782', 782, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("782")), 
			new Bin("bn2", Value.get(782)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('783', 783, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("783")), 
			new Bin("bn2", Value.get(783)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('784', 784, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("784")), 
			new Bin("bn2", Value.get(784)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('785', 785, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("785")), 
			new Bin("bn2", Value.get(785)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('786', 786, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("786")), 
			new Bin("bn2", Value.get(786)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('787', 787, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("787")), 
			new Bin("bn2", Value.get(787)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('788', 788, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("788")), 
			new Bin("bn2", Value.get(788)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('789', 789, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("789")), 
			new Bin("bn2", Value.get(789)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('790', 790, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("790")), 
			new Bin("bn2", Value.get(790)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('791', 791, '80', 80)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("791")), 
			new Bin("bn2", Value.get(791)),
			new Bin("bn3", Value.get("80")),
			new Bin("bn4", Value.get(80))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('792', 792, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("792")), 
			new Bin("bn2", Value.get(792)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('793', 793, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("793")), 
			new Bin("bn2", Value.get(793)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('794', 794, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("794")), 
			new Bin("bn2", Value.get(794)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('795', 795, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("795")), 
			new Bin("bn2", Value.get(795)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('796', 796, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("796")), 
			new Bin("bn2", Value.get(796)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('797', 797, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("797")), 
			new Bin("bn2", Value.get(797)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('798', 798, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("798")), 
			new Bin("bn2", Value.get(798)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('799', 799, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("799")), 
			new Bin("bn2", Value.get(799)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('800', 800, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("800")), 
			new Bin("bn2", Value.get(800)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('801', 801, '81', 81)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("801")), 
			new Bin("bn2", Value.get(801)),
			new Bin("bn3", Value.get("81")),
			new Bin("bn4", Value.get(81))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('802', 802, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("802")), 
			new Bin("bn2", Value.get(802)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('803', 803, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("803")), 
			new Bin("bn2", Value.get(803)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('804', 804, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("804")), 
			new Bin("bn2", Value.get(804)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('805', 805, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("805")), 
			new Bin("bn2", Value.get(805)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('806', 806, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("806")), 
			new Bin("bn2", Value.get(806)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('807', 807, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("807")), 
			new Bin("bn2", Value.get(807)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('808', 808, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("808")), 
			new Bin("bn2", Value.get(808)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('809', 809, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("809")), 
			new Bin("bn2", Value.get(809)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('810', 810, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("810")), 
			new Bin("bn2", Value.get(810)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('811', 811, '82', 82)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("811")), 
			new Bin("bn2", Value.get(811)),
			new Bin("bn3", Value.get("82")),
			new Bin("bn4", Value.get(82))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('812', 812, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("812")), 
			new Bin("bn2", Value.get(812)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('813', 813, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("813")), 
			new Bin("bn2", Value.get(813)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('814', 814, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("814")), 
			new Bin("bn2", Value.get(814)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('815', 815, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("815")), 
			new Bin("bn2", Value.get(815)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('816', 816, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("816")), 
			new Bin("bn2", Value.get(816)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('817', 817, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("817")), 
			new Bin("bn2", Value.get(817)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('818', 818, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("818")), 
			new Bin("bn2", Value.get(818)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('819', 819, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("819")), 
			new Bin("bn2", Value.get(819)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('820', 820, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("820")), 
			new Bin("bn2", Value.get(820)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('821', 821, '83', 83)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("821")), 
			new Bin("bn2", Value.get(821)),
			new Bin("bn3", Value.get("83")),
			new Bin("bn4", Value.get(83))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('822', 822, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("822")), 
			new Bin("bn2", Value.get(822)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('823', 823, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("823")), 
			new Bin("bn2", Value.get(823)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('824', 824, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("824")), 
			new Bin("bn2", Value.get(824)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('825', 825, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("825")), 
			new Bin("bn2", Value.get(825)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('826', 826, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("826")), 
			new Bin("bn2", Value.get(826)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('827', 827, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("827")), 
			new Bin("bn2", Value.get(827)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('828', 828, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("828")), 
			new Bin("bn2", Value.get(828)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('829', 829, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("829")), 
			new Bin("bn2", Value.get(829)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('830', 830, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("830")), 
			new Bin("bn2", Value.get(830)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('831', 831, '84', 84)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("831")), 
			new Bin("bn2", Value.get(831)),
			new Bin("bn3", Value.get("84")),
			new Bin("bn4", Value.get(84))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('832', 832, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("832")), 
			new Bin("bn2", Value.get(832)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('833', 833, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("833")), 
			new Bin("bn2", Value.get(833)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('834', 834, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("834")), 
			new Bin("bn2", Value.get(834)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('835', 835, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("835")), 
			new Bin("bn2", Value.get(835)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('836', 836, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("836")), 
			new Bin("bn2", Value.get(836)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('837', 837, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("837")), 
			new Bin("bn2", Value.get(837)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('838', 838, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("838")), 
			new Bin("bn2", Value.get(838)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('839', 839, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("839")), 
			new Bin("bn2", Value.get(839)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('840', 840, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("840")), 
			new Bin("bn2", Value.get(840)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('841', 841, '85', 85)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("841")), 
			new Bin("bn2", Value.get(841)),
			new Bin("bn3", Value.get("85")),
			new Bin("bn4", Value.get(85))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('842', 842, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("842")), 
			new Bin("bn2", Value.get(842)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('843', 843, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("843")), 
			new Bin("bn2", Value.get(843)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('844', 844, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("844")), 
			new Bin("bn2", Value.get(844)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('845', 845, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("845")), 
			new Bin("bn2", Value.get(845)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('846', 846, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("846")), 
			new Bin("bn2", Value.get(846)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('847', 847, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("847")), 
			new Bin("bn2", Value.get(847)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('848', 848, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("848")), 
			new Bin("bn2", Value.get(848)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('849', 849, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("849")), 
			new Bin("bn2", Value.get(849)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('850', 850, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("850")), 
			new Bin("bn2", Value.get(850)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('851', 851, '86', 86)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("851")), 
			new Bin("bn2", Value.get(851)),
			new Bin("bn3", Value.get("86")),
			new Bin("bn4", Value.get(86))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('852', 852, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("852")), 
			new Bin("bn2", Value.get(852)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('853', 853, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("853")), 
			new Bin("bn2", Value.get(853)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('854', 854, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("854")), 
			new Bin("bn2", Value.get(854)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('855', 855, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("855")), 
			new Bin("bn2", Value.get(855)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('856', 856, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("856")), 
			new Bin("bn2", Value.get(856)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('857', 857, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("857")), 
			new Bin("bn2", Value.get(857)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('858', 858, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("858")), 
			new Bin("bn2", Value.get(858)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('859', 859, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("859")), 
			new Bin("bn2", Value.get(859)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('860', 860, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("860")), 
			new Bin("bn2", Value.get(860)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('861', 861, '87', 87)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("861")), 
			new Bin("bn2", Value.get(861)),
			new Bin("bn3", Value.get("87")),
			new Bin("bn4", Value.get(87))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('862', 862, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("862")), 
			new Bin("bn2", Value.get(862)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('863', 863, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("863")), 
			new Bin("bn2", Value.get(863)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('864', 864, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("864")), 
			new Bin("bn2", Value.get(864)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('865', 865, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("865")), 
			new Bin("bn2", Value.get(865)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('866', 866, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("866")), 
			new Bin("bn2", Value.get(866)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('867', 867, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("867")), 
			new Bin("bn2", Value.get(867)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('868', 868, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("868")), 
			new Bin("bn2", Value.get(868)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('869', 869, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("869")), 
			new Bin("bn2", Value.get(869)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('870', 870, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("870")), 
			new Bin("bn2", Value.get(870)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('871', 871, '88', 88)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("871")), 
			new Bin("bn2", Value.get(871)),
			new Bin("bn3", Value.get("88")),
			new Bin("bn4", Value.get(88))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('872', 872, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("872")), 
			new Bin("bn2", Value.get(872)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('873', 873, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("873")), 
			new Bin("bn2", Value.get(873)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('874', 874, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("874")), 
			new Bin("bn2", Value.get(874)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('875', 875, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("875")), 
			new Bin("bn2", Value.get(875)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('876', 876, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("876")), 
			new Bin("bn2", Value.get(876)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('877', 877, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("877")), 
			new Bin("bn2", Value.get(877)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('878', 878, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("878")), 
			new Bin("bn2", Value.get(878)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('879', 879, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("879")), 
			new Bin("bn2", Value.get(879)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('880', 880, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("880")), 
			new Bin("bn2", Value.get(880)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('881', 881, '89', 89)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("881")), 
			new Bin("bn2", Value.get(881)),
			new Bin("bn3", Value.get("89")),
			new Bin("bn4", Value.get(89))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('882', 882, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("882")), 
			new Bin("bn2", Value.get(882)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('883', 883, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("883")), 
			new Bin("bn2", Value.get(883)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('884', 884, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("884")), 
			new Bin("bn2", Value.get(884)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('885', 885, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("885")), 
			new Bin("bn2", Value.get(885)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('886', 886, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("886")), 
			new Bin("bn2", Value.get(886)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('887', 887, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("887")), 
			new Bin("bn2", Value.get(887)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('888', 888, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("888")), 
			new Bin("bn2", Value.get(888)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('889', 889, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("889")), 
			new Bin("bn2", Value.get(889)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('890', 890, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("890")), 
			new Bin("bn2", Value.get(890)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('891', 891, '90', 90)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("891")), 
			new Bin("bn2", Value.get(891)),
			new Bin("bn3", Value.get("90")),
			new Bin("bn4", Value.get(90))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('892', 892, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("892")), 
			new Bin("bn2", Value.get(892)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('893', 893, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("893")), 
			new Bin("bn2", Value.get(893)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('894', 894, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("894")), 
			new Bin("bn2", Value.get(894)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('895', 895, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("895")), 
			new Bin("bn2", Value.get(895)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('896', 896, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("896")), 
			new Bin("bn2", Value.get(896)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('897', 897, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("897")), 
			new Bin("bn2", Value.get(897)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('898', 898, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("898")), 
			new Bin("bn2", Value.get(898)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('899', 899, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("899")), 
			new Bin("bn2", Value.get(899)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('900', 900, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("900")), 
			new Bin("bn2", Value.get(900)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('901', 901, '91', 91)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("901")), 
			new Bin("bn2", Value.get(901)),
			new Bin("bn3", Value.get("91")),
			new Bin("bn4", Value.get(91))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('902', 902, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("902")), 
			new Bin("bn2", Value.get(902)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('903', 903, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("903")), 
			new Bin("bn2", Value.get(903)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('904', 904, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("904")), 
			new Bin("bn2", Value.get(904)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('905', 905, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("905")), 
			new Bin("bn2", Value.get(905)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('906', 906, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("906")), 
			new Bin("bn2", Value.get(906)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('907', 907, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("907")), 
			new Bin("bn2", Value.get(907)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('908', 908, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("908")), 
			new Bin("bn2", Value.get(908)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('909', 909, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("909")), 
			new Bin("bn2", Value.get(909)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('910', 910, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("910")), 
			new Bin("bn2", Value.get(910)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('911', 911, '92', 92)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("911")), 
			new Bin("bn2", Value.get(911)),
			new Bin("bn3", Value.get("92")),
			new Bin("bn4", Value.get(92))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('912', 912, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("912")), 
			new Bin("bn2", Value.get(912)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('913', 913, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("913")), 
			new Bin("bn2", Value.get(913)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('914', 914, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("914")), 
			new Bin("bn2", Value.get(914)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('915', 915, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("915")), 
			new Bin("bn2", Value.get(915)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('916', 916, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("916")), 
			new Bin("bn2", Value.get(916)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('917', 917, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("917")), 
			new Bin("bn2", Value.get(917)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('918', 918, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("918")), 
			new Bin("bn2", Value.get(918)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('919', 919, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("919")), 
			new Bin("bn2", Value.get(919)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('920', 920, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("920")), 
			new Bin("bn2", Value.get(920)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('921', 921, '93', 93)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("921")), 
			new Bin("bn2", Value.get(921)),
			new Bin("bn3", Value.get("93")),
			new Bin("bn4", Value.get(93))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('922', 922, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("922")), 
			new Bin("bn2", Value.get(922)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('923', 923, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("923")), 
			new Bin("bn2", Value.get(923)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('924', 924, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("924")), 
			new Bin("bn2", Value.get(924)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('925', 925, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("925")), 
			new Bin("bn2", Value.get(925)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('926', 926, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("926")), 
			new Bin("bn2", Value.get(926)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('927', 927, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("927")), 
			new Bin("bn2", Value.get(927)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('928', 928, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("928")), 
			new Bin("bn2", Value.get(928)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('929', 929, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("929")), 
			new Bin("bn2", Value.get(929)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('930', 930, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("930")), 
			new Bin("bn2", Value.get(930)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('931', 931, '94', 94)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("931")), 
			new Bin("bn2", Value.get(931)),
			new Bin("bn3", Value.get("94")),
			new Bin("bn4", Value.get(94))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('932', 932, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("932")), 
			new Bin("bn2", Value.get(932)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('933', 933, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("933")), 
			new Bin("bn2", Value.get(933)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('934', 934, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("934")), 
			new Bin("bn2", Value.get(934)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('935', 935, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("935")), 
			new Bin("bn2", Value.get(935)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('936', 936, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("936")), 
			new Bin("bn2", Value.get(936)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('937', 937, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("937")), 
			new Bin("bn2", Value.get(937)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('938', 938, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("938")), 
			new Bin("bn2", Value.get(938)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('939', 939, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("939")), 
			new Bin("bn2", Value.get(939)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('940', 940, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("940")), 
			new Bin("bn2", Value.get(940)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('941', 941, '95', 95)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("941")), 
			new Bin("bn2", Value.get(941)),
			new Bin("bn3", Value.get("95")),
			new Bin("bn4", Value.get(95))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('942', 942, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("942")), 
			new Bin("bn2", Value.get(942)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('943', 943, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("943")), 
			new Bin("bn2", Value.get(943)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('944', 944, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("944")), 
			new Bin("bn2", Value.get(944)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('945', 945, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("945")), 
			new Bin("bn2", Value.get(945)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('946', 946, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("946")), 
			new Bin("bn2", Value.get(946)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('947', 947, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("947")), 
			new Bin("bn2", Value.get(947)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('948', 948, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("948")), 
			new Bin("bn2", Value.get(948)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('949', 949, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("949")), 
			new Bin("bn2", Value.get(949)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('950', 950, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("950")), 
			new Bin("bn2", Value.get(950)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('951', 951, '96', 96)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("951")), 
			new Bin("bn2", Value.get(951)),
			new Bin("bn3", Value.get("96")),
			new Bin("bn4", Value.get(96))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('952', 952, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("952")), 
			new Bin("bn2", Value.get(952)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('953', 953, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("953")), 
			new Bin("bn2", Value.get(953)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('954', 954, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("954")), 
			new Bin("bn2", Value.get(954)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('955', 955, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("955")), 
			new Bin("bn2", Value.get(955)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('956', 956, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("956")), 
			new Bin("bn2", Value.get(956)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('957', 957, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("957")), 
			new Bin("bn2", Value.get(957)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('958', 958, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("958")), 
			new Bin("bn2", Value.get(958)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('959', 959, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("959")), 
			new Bin("bn2", Value.get(959)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('960', 960, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("960")), 
			new Bin("bn2", Value.get(960)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('961', 961, '97', 97)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("961")), 
			new Bin("bn2", Value.get(961)),
			new Bin("bn3", Value.get("97")),
			new Bin("bn4", Value.get(97))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('962', 962, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("962")), 
			new Bin("bn2", Value.get(962)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('963', 963, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("963")), 
			new Bin("bn2", Value.get(963)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('964', 964, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("964")), 
			new Bin("bn2", Value.get(964)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('965', 965, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("965")), 
			new Bin("bn2", Value.get(965)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('966', 966, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("966")), 
			new Bin("bn2", Value.get(966)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('967', 967, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("967")), 
			new Bin("bn2", Value.get(967)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('968', 968, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("968")), 
			new Bin("bn2", Value.get(968)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('969', 969, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("969")), 
			new Bin("bn2", Value.get(969)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('970', 970, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("970")), 
			new Bin("bn2", Value.get(970)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('971', 971, '98', 98)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("971")), 
			new Bin("bn2", Value.get(971)),
			new Bin("bn3", Value.get("98")),
			new Bin("bn4", Value.get(98))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('972', 972, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("972")), 
			new Bin("bn2", Value.get(972)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('973', 973, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("973")), 
			new Bin("bn2", Value.get(973)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('974', 974, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("974")), 
			new Bin("bn2", Value.get(974)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('975', 975, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("975")), 
			new Bin("bn2", Value.get(975)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('976', 976, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("976")), 
			new Bin("bn2", Value.get(976)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('977', 977, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("977")), 
			new Bin("bn2", Value.get(977)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('978', 978, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("978")), 
			new Bin("bn2", Value.get(978)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('979', 979, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("979")), 
			new Bin("bn2", Value.get(979)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('980', 980, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("980")), 
			new Bin("bn2", Value.get(980)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('981', 981, '99', 99)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("981")), 
			new Bin("bn2", Value.get(981)),
			new Bin("bn3", Value.get("99")),
			new Bin("bn4", Value.get(99))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('982', 982, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("982")), 
			new Bin("bn2", Value.get(982)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('983', 983, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("983")), 
			new Bin("bn2", Value.get(983)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('984', 984, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("984")), 
			new Bin("bn2", Value.get(984)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('985', 985, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("985")), 
			new Bin("bn2", Value.get(985)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('986', 986, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("986")), 
			new Bin("bn2", Value.get(986)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('987', 987, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("987")), 
			new Bin("bn2", Value.get(987)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('988', 988, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("988")), 
			new Bin("bn2", Value.get(988)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('989', 989, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("989")), 
			new Bin("bn2", Value.get(989)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('990', 990, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("990")), 
			new Bin("bn2", Value.get(990)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('991', 991, '100', 100)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("991")), 
			new Bin("bn2", Value.get(991)),
			new Bin("bn3", Value.get("100")),
			new Bin("bn4", Value.get(100))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('992', 992, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("992")), 
			new Bin("bn2", Value.get(992)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('993', 993, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("993")), 
			new Bin("bn2", Value.get(993)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('994', 994, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("994")), 
			new Bin("bn2", Value.get(994)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('995', 995, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("995")), 
			new Bin("bn2", Value.get(995)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('996', 996, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("996")), 
			new Bin("bn2", Value.get(996)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('997', 997, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("997")), 
			new Bin("bn2", Value.get(997)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('998', 998, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("998")), 
			new Bin("bn2", Value.get(998)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('999', 999, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("999")), 
			new Bin("bn2", Value.get(999)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1000', 1000, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1000")), 
			new Bin("bn2", Value.get(1000)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1001', 1001, '101', 101)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1001")), 
			new Bin("bn2", Value.get(1001)),
			new Bin("bn3", Value.get("101")),
			new Bin("bn4", Value.get(101))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1002', 1002, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1002")), 
			new Bin("bn2", Value.get(1002)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1003', 1003, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1003")), 
			new Bin("bn2", Value.get(1003)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1004', 1004, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1004")), 
			new Bin("bn2", Value.get(1004)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1005', 1005, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1005")), 
			new Bin("bn2", Value.get(1005)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1006', 1006, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1006")), 
			new Bin("bn2", Value.get(1006)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1007', 1007, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1007")), 
			new Bin("bn2", Value.get(1007)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1008', 1008, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1008")), 
			new Bin("bn2", Value.get(1008)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1009', 1009, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1009")), 
			new Bin("bn2", Value.get(1009)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1010', 1010, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1010")), 
			new Bin("bn2", Value.get(1010)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1011', 1011, '102', 102)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1011")), 
			new Bin("bn2", Value.get(1011)),
			new Bin("bn3", Value.get("102")),
			new Bin("bn4", Value.get(102))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1012', 1012, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1012")), 
			new Bin("bn2", Value.get(1012)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1013', 1013, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1013")), 
			new Bin("bn2", Value.get(1013)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1014', 1014, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1014")), 
			new Bin("bn2", Value.get(1014)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1015', 1015, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1015")), 
			new Bin("bn2", Value.get(1015)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1016', 1016, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1016")), 
			new Bin("bn2", Value.get(1016)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1017', 1017, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1017")), 
			new Bin("bn2", Value.get(1017)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1018', 1018, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1018")), 
			new Bin("bn2", Value.get(1018)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1019', 1019, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1019")), 
			new Bin("bn2", Value.get(1019)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1020', 1020, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1020")), 
			new Bin("bn2", Value.get(1020)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1021', 1021, '103', 103)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1021")), 
			new Bin("bn2", Value.get(1021)),
			new Bin("bn3", Value.get("103")),
			new Bin("bn4", Value.get(103))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1022', 1022, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1022")), 
			new Bin("bn2", Value.get(1022)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1023', 1023, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1023")), 
			new Bin("bn2", Value.get(1023)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1024', 1024, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1024")), 
			new Bin("bn2", Value.get(1024)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1025', 1025, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1025")), 
			new Bin("bn2", Value.get(1025)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1026', 1026, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1026")), 
			new Bin("bn2", Value.get(1026)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1027', 1027, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1027")), 
			new Bin("bn2", Value.get(1027)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1028', 1028, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1028")), 
			new Bin("bn2", Value.get(1028)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1029', 1029, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1029")), 
			new Bin("bn2", Value.get(1029)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1030', 1030, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1030")), 
			new Bin("bn2", Value.get(1030)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1031', 1031, '104', 104)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1031")), 
			new Bin("bn2", Value.get(1031)),
			new Bin("bn3", Value.get("104")),
			new Bin("bn4", Value.get(104))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1032', 1032, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1032")), 
			new Bin("bn2", Value.get(1032)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1033', 1033, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1033")), 
			new Bin("bn2", Value.get(1033)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1034', 1034, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1034")), 
			new Bin("bn2", Value.get(1034)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1035', 1035, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1035")), 
			new Bin("bn2", Value.get(1035)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1036', 1036, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1036")), 
			new Bin("bn2", Value.get(1036)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1037', 1037, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1037")), 
			new Bin("bn2", Value.get(1037)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1038', 1038, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1038")), 
			new Bin("bn2", Value.get(1038)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1039', 1039, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1039")), 
			new Bin("bn2", Value.get(1039)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1040', 1040, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1040")), 
			new Bin("bn2", Value.get(1040)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1041', 1041, '105', 105)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1041")), 
			new Bin("bn2", Value.get(1041)),
			new Bin("bn3", Value.get("105")),
			new Bin("bn4", Value.get(105))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1042', 1042, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1042")), 
			new Bin("bn2", Value.get(1042)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1043', 1043, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1043")), 
			new Bin("bn2", Value.get(1043)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1044', 1044, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1044")), 
			new Bin("bn2", Value.get(1044)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1045', 1045, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1045")), 
			new Bin("bn2", Value.get(1045)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1046', 1046, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1046")), 
			new Bin("bn2", Value.get(1046)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1047', 1047, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1047")), 
			new Bin("bn2", Value.get(1047)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1048', 1048, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1048")), 
			new Bin("bn2", Value.get(1048)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1049', 1049, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1049")), 
			new Bin("bn2", Value.get(1049)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1050', 1050, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1050")), 
			new Bin("bn2", Value.get(1050)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1051', 1051, '106', 106)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1051")), 
			new Bin("bn2", Value.get(1051)),
			new Bin("bn3", Value.get("106")),
			new Bin("bn4", Value.get(106))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1052', 1052, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1052")), 
			new Bin("bn2", Value.get(1052)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1053', 1053, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1053")), 
			new Bin("bn2", Value.get(1053)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1054', 1054, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1054")), 
			new Bin("bn2", Value.get(1054)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1055', 1055, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1055")), 
			new Bin("bn2", Value.get(1055)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1056', 1056, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1056")), 
			new Bin("bn2", Value.get(1056)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1057', 1057, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1057")), 
			new Bin("bn2", Value.get(1057)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1058', 1058, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1058")), 
			new Bin("bn2", Value.get(1058)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1059', 1059, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1059")), 
			new Bin("bn2", Value.get(1059)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1060', 1060, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1060")), 
			new Bin("bn2", Value.get(1060)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1061', 1061, '107', 107)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1061")), 
			new Bin("bn2", Value.get(1061)),
			new Bin("bn3", Value.get("107")),
			new Bin("bn4", Value.get(107))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1062', 1062, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1062")), 
			new Bin("bn2", Value.get(1062)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1063', 1063, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1063")), 
			new Bin("bn2", Value.get(1063)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1064', 1064, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1064")), 
			new Bin("bn2", Value.get(1064)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1065', 1065, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1065")), 
			new Bin("bn2", Value.get(1065)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1066', 1066, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1066")), 
			new Bin("bn2", Value.get(1066)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1067', 1067, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1067")), 
			new Bin("bn2", Value.get(1067)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1068', 1068, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1068")), 
			new Bin("bn2", Value.get(1068)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1069', 1069, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1069")), 
			new Bin("bn2", Value.get(1069)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1070', 1070, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1070")), 
			new Bin("bn2", Value.get(1070)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1071', 1071, '108', 108)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1071")), 
			new Bin("bn2", Value.get(1071)),
			new Bin("bn3", Value.get("108")),
			new Bin("bn4", Value.get(108))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1072', 1072, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1072")), 
			new Bin("bn2", Value.get(1072)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1073', 1073, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1073")), 
			new Bin("bn2", Value.get(1073)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1074', 1074, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1074")), 
			new Bin("bn2", Value.get(1074)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1075', 1075, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1075")), 
			new Bin("bn2", Value.get(1075)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1076', 1076, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1076")), 
			new Bin("bn2", Value.get(1076)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1077', 1077, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1077")), 
			new Bin("bn2", Value.get(1077)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1078', 1078, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1078")), 
			new Bin("bn2", Value.get(1078)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1079', 1079, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1079")), 
			new Bin("bn2", Value.get(1079)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1080', 1080, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1080")), 
			new Bin("bn2", Value.get(1080)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1081', 1081, '109', 109)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1081")), 
			new Bin("bn2", Value.get(1081)),
			new Bin("bn3", Value.get("109")),
			new Bin("bn4", Value.get(109))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1082', 1082, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1082")), 
			new Bin("bn2", Value.get(1082)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1083', 1083, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1083")), 
			new Bin("bn2", Value.get(1083)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1084', 1084, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1084")), 
			new Bin("bn2", Value.get(1084)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1085', 1085, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1085")), 
			new Bin("bn2", Value.get(1085)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1086', 1086, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1086")), 
			new Bin("bn2", Value.get(1086)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1087', 1087, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1087")), 
			new Bin("bn2", Value.get(1087)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1088', 1088, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1088")), 
			new Bin("bn2", Value.get(1088)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1089', 1089, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1089")), 
			new Bin("bn2", Value.get(1089)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1090', 1090, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1090")), 
			new Bin("bn2", Value.get(1090)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1091', 1091, '110', 110)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1091")), 
			new Bin("bn2", Value.get(1091)),
			new Bin("bn3", Value.get("110")),
			new Bin("bn4", Value.get(110))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1092', 1092, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1092")), 
			new Bin("bn2", Value.get(1092)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1093', 1093, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1093")), 
			new Bin("bn2", Value.get(1093)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1094', 1094, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1094")), 
			new Bin("bn2", Value.get(1094)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1095', 1095, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1095")), 
			new Bin("bn2", Value.get(1095)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1096', 1096, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1096")), 
			new Bin("bn2", Value.get(1096)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1097', 1097, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1097")), 
			new Bin("bn2", Value.get(1097)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1098', 1098, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1098")), 
			new Bin("bn2", Value.get(1098)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1099', 1099, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1099")), 
			new Bin("bn2", Value.get(1099)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1100', 1100, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1100")), 
			new Bin("bn2", Value.get(1100)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1101', 1101, '111', 111)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1101")), 
			new Bin("bn2", Value.get(1101)),
			new Bin("bn3", Value.get("111")),
			new Bin("bn4", Value.get(111))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1102', 1102, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1102")), 
			new Bin("bn2", Value.get(1102)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1103', 1103, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1103")), 
			new Bin("bn2", Value.get(1103)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1104', 1104, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1104")), 
			new Bin("bn2", Value.get(1104)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1105', 1105, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1105")), 
			new Bin("bn2", Value.get(1105)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1106', 1106, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1106")), 
			new Bin("bn2", Value.get(1106)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1107', 1107, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1107")), 
			new Bin("bn2", Value.get(1107)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1108', 1108, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1108")), 
			new Bin("bn2", Value.get(1108)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1109', 1109, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1109")), 
			new Bin("bn2", Value.get(1109)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1110', 1110, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1110")), 
			new Bin("bn2", Value.get(1110)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1111', 1111, '112', 112)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1111")), 
			new Bin("bn2", Value.get(1111)),
			new Bin("bn3", Value.get("112")),
			new Bin("bn4", Value.get(112))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1112', 1112, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1112")), 
			new Bin("bn2", Value.get(1112)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1113', 1113, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1113")), 
			new Bin("bn2", Value.get(1113)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1114', 1114, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1114")), 
			new Bin("bn2", Value.get(1114)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1115', 1115, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1115")), 
			new Bin("bn2", Value.get(1115)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1116', 1116, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1116")), 
			new Bin("bn2", Value.get(1116)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1117', 1117, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1117")), 
			new Bin("bn2", Value.get(1117)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1118', 1118, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1118")), 
			new Bin("bn2", Value.get(1118)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1119', 1119, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1119")), 
			new Bin("bn2", Value.get(1119)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1120', 1120, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1120")), 
			new Bin("bn2", Value.get(1120)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1121', 1121, '113', 113)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1121")), 
			new Bin("bn2", Value.get(1121)),
			new Bin("bn3", Value.get("113")),
			new Bin("bn4", Value.get(113))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1122', 1122, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1122")), 
			new Bin("bn2", Value.get(1122)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1123', 1123, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1123")), 
			new Bin("bn2", Value.get(1123)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1124', 1124, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1124")), 
			new Bin("bn2", Value.get(1124)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1125', 1125, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1125")), 
			new Bin("bn2", Value.get(1125)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1126', 1126, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1126")), 
			new Bin("bn2", Value.get(1126)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1127', 1127, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1127")), 
			new Bin("bn2", Value.get(1127)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1128', 1128, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1128")), 
			new Bin("bn2", Value.get(1128)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1129', 1129, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1129")), 
			new Bin("bn2", Value.get(1129)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1130', 1130, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1130")), 
			new Bin("bn2", Value.get(1130)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1131', 1131, '114', 114)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1131")), 
			new Bin("bn2", Value.get(1131)),
			new Bin("bn3", Value.get("114")),
			new Bin("bn4", Value.get(114))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1132', 1132, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1132")), 
			new Bin("bn2", Value.get(1132)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1133', 1133, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1133")), 
			new Bin("bn2", Value.get(1133)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1134', 1134, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1134")), 
			new Bin("bn2", Value.get(1134)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1135', 1135, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1135")), 
			new Bin("bn2", Value.get(1135)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1136', 1136, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1136")), 
			new Bin("bn2", Value.get(1136)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1137', 1137, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1137")), 
			new Bin("bn2", Value.get(1137)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1138', 1138, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1138")), 
			new Bin("bn2", Value.get(1138)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1139', 1139, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1139")), 
			new Bin("bn2", Value.get(1139)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1140', 1140, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1140")), 
			new Bin("bn2", Value.get(1140)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1141', 1141, '115', 115)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1141")), 
			new Bin("bn2", Value.get(1141)),
			new Bin("bn3", Value.get("115")),
			new Bin("bn4", Value.get(115))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1142', 1142, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1142")), 
			new Bin("bn2", Value.get(1142)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1143', 1143, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1143")), 
			new Bin("bn2", Value.get(1143)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1144', 1144, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1144")), 
			new Bin("bn2", Value.get(1144)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1145', 1145, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1145")), 
			new Bin("bn2", Value.get(1145)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1146', 1146, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1146")), 
			new Bin("bn2", Value.get(1146)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1147', 1147, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1147")), 
			new Bin("bn2", Value.get(1147)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1148', 1148, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1148")), 
			new Bin("bn2", Value.get(1148)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1149', 1149, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1149")), 
			new Bin("bn2", Value.get(1149)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1150', 1150, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1150")), 
			new Bin("bn2", Value.get(1150)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1151', 1151, '116', 116)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1151")), 
			new Bin("bn2", Value.get(1151)),
			new Bin("bn3", Value.get("116")),
			new Bin("bn4", Value.get(116))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1152', 1152, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1152")), 
			new Bin("bn2", Value.get(1152)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1153', 1153, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1153")), 
			new Bin("bn2", Value.get(1153)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1154', 1154, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1154")), 
			new Bin("bn2", Value.get(1154)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1155', 1155, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1155")), 
			new Bin("bn2", Value.get(1155)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1156', 1156, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1156")), 
			new Bin("bn2", Value.get(1156)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1157', 1157, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1157")), 
			new Bin("bn2", Value.get(1157)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1158', 1158, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1158")), 
			new Bin("bn2", Value.get(1158)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1159', 1159, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1159")), 
			new Bin("bn2", Value.get(1159)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1160', 1160, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1160")), 
			new Bin("bn2", Value.get(1160)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1161', 1161, '117', 117)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1161")), 
			new Bin("bn2", Value.get(1161)),
			new Bin("bn3", Value.get("117")),
			new Bin("bn4", Value.get(117))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1162', 1162, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1162")), 
			new Bin("bn2", Value.get(1162)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1163', 1163, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1163")), 
			new Bin("bn2", Value.get(1163)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1164', 1164, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1164")), 
			new Bin("bn2", Value.get(1164)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1165', 1165, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1165")), 
			new Bin("bn2", Value.get(1165)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1166', 1166, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1166")), 
			new Bin("bn2", Value.get(1166)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1167', 1167, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1167")), 
			new Bin("bn2", Value.get(1167)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1168', 1168, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1168")), 
			new Bin("bn2", Value.get(1168)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1169', 1169, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1169")), 
			new Bin("bn2", Value.get(1169)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1170', 1170, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1170")), 
			new Bin("bn2", Value.get(1170)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1171', 1171, '118', 118)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1171")), 
			new Bin("bn2", Value.get(1171)),
			new Bin("bn3", Value.get("118")),
			new Bin("bn4", Value.get(118))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1172', 1172, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1172")), 
			new Bin("bn2", Value.get(1172)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1173', 1173, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1173")), 
			new Bin("bn2", Value.get(1173)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1174', 1174, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1174")), 
			new Bin("bn2", Value.get(1174)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1175', 1175, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1175")), 
			new Bin("bn2", Value.get(1175)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1176', 1176, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1176")), 
			new Bin("bn2", Value.get(1176)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1177', 1177, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1177")), 
			new Bin("bn2", Value.get(1177)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1178', 1178, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1178")), 
			new Bin("bn2", Value.get(1178)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1179', 1179, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1179")), 
			new Bin("bn2", Value.get(1179)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1180', 1180, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1180")), 
			new Bin("bn2", Value.get(1180)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1181', 1181, '119', 119)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1181")), 
			new Bin("bn2", Value.get(1181)),
			new Bin("bn3", Value.get("119")),
			new Bin("bn4", Value.get(119))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1182', 1182, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1182")), 
			new Bin("bn2", Value.get(1182)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1183', 1183, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1183")), 
			new Bin("bn2", Value.get(1183)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1184', 1184, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1184")), 
			new Bin("bn2", Value.get(1184)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1185', 1185, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1185")), 
			new Bin("bn2", Value.get(1185)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1186', 1186, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1186")), 
			new Bin("bn2", Value.get(1186)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1187', 1187, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1187")), 
			new Bin("bn2", Value.get(1187)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1188', 1188, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1188")), 
			new Bin("bn2", Value.get(1188)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1189', 1189, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1189")), 
			new Bin("bn2", Value.get(1189)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1190', 1190, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1190")), 
			new Bin("bn2", Value.get(1190)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1191', 1191, '120', 120)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1191")), 
			new Bin("bn2", Value.get(1191)),
			new Bin("bn3", Value.get("120")),
			new Bin("bn4", Value.get(120))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1192', 1192, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1192")), 
			new Bin("bn2", Value.get(1192)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1193', 1193, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1193")), 
			new Bin("bn2", Value.get(1193)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1194', 1194, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1194")), 
			new Bin("bn2", Value.get(1194)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1195', 1195, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1195")), 
			new Bin("bn2", Value.get(1195)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1196', 1196, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1196")), 
			new Bin("bn2", Value.get(1196)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1197', 1197, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1197")), 
			new Bin("bn2", Value.get(1197)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1198', 1198, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1198")), 
			new Bin("bn2", Value.get(1198)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1199', 1199, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1199")), 
			new Bin("bn2", Value.get(1199)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1200', 1200, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1200")), 
			new Bin("bn2", Value.get(1200)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1201', 1201, '121', 121)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1201")), 
			new Bin("bn2", Value.get(1201)),
			new Bin("bn3", Value.get("121")),
			new Bin("bn4", Value.get(121))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1202', 1202, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1202")), 
			new Bin("bn2", Value.get(1202)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1203', 1203, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1203")), 
			new Bin("bn2", Value.get(1203)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1204', 1204, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1204")), 
			new Bin("bn2", Value.get(1204)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1205', 1205, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1205")), 
			new Bin("bn2", Value.get(1205)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1206', 1206, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1206")), 
			new Bin("bn2", Value.get(1206)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1207', 1207, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1207")), 
			new Bin("bn2", Value.get(1207)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1208', 1208, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1208")), 
			new Bin("bn2", Value.get(1208)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1209', 1209, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1209")), 
			new Bin("bn2", Value.get(1209)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1210', 1210, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1210")), 
			new Bin("bn2", Value.get(1210)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1211', 1211, '122', 122)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1211")), 
			new Bin("bn2", Value.get(1211)),
			new Bin("bn3", Value.get("122")),
			new Bin("bn4", Value.get(122))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1212', 1212, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1212")), 
			new Bin("bn2", Value.get(1212)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1213', 1213, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1213")), 
			new Bin("bn2", Value.get(1213)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1214', 1214, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1214")), 
			new Bin("bn2", Value.get(1214)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1215', 1215, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1215")), 
			new Bin("bn2", Value.get(1215)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1216', 1216, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1216")), 
			new Bin("bn2", Value.get(1216)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1217', 1217, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1217")), 
			new Bin("bn2", Value.get(1217)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1218', 1218, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1218")), 
			new Bin("bn2", Value.get(1218)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1219', 1219, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1219")), 
			new Bin("bn2", Value.get(1219)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1220', 1220, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1220")), 
			new Bin("bn2", Value.get(1220)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1221', 1221, '123', 123)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1221")), 
			new Bin("bn2", Value.get(1221)),
			new Bin("bn3", Value.get("123")),
			new Bin("bn4", Value.get(123))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1222', 1222, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1222")), 
			new Bin("bn2", Value.get(1222)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1223', 1223, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1223")), 
			new Bin("bn2", Value.get(1223)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1224', 1224, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1224")), 
			new Bin("bn2", Value.get(1224)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1225', 1225, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1225")), 
			new Bin("bn2", Value.get(1225)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1226', 1226, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1226")), 
			new Bin("bn2", Value.get(1226)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1227', 1227, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1227")), 
			new Bin("bn2", Value.get(1227)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1228', 1228, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1228")), 
			new Bin("bn2", Value.get(1228)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1229', 1229, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1229")), 
			new Bin("bn2", Value.get(1229)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1230', 1230, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1230")), 
			new Bin("bn2", Value.get(1230)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1231', 1231, '124', 124)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1231")), 
			new Bin("bn2", Value.get(1231)),
			new Bin("bn3", Value.get("124")),
			new Bin("bn4", Value.get(124))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1232', 1232, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1232")), 
			new Bin("bn2", Value.get(1232)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1233', 1233, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1233")), 
			new Bin("bn2", Value.get(1233)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1234', 1234, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1234")), 
			new Bin("bn2", Value.get(1234)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1235', 1235, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1235")), 
			new Bin("bn2", Value.get(1235)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1236', 1236, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1236")), 
			new Bin("bn2", Value.get(1236)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1237', 1237, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1237")), 
			new Bin("bn2", Value.get(1237)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1238', 1238, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1238")), 
			new Bin("bn2", Value.get(1238)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1239', 1239, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1239")), 
			new Bin("bn2", Value.get(1239)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1240', 1240, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1240")), 
			new Bin("bn2", Value.get(1240)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1241', 1241, '125', 125)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1241")), 
			new Bin("bn2", Value.get(1241)),
			new Bin("bn3", Value.get("125")),
			new Bin("bn4", Value.get(125))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1242', 1242, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1242")), 
			new Bin("bn2", Value.get(1242)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1243', 1243, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1243")), 
			new Bin("bn2", Value.get(1243)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1244', 1244, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1244")), 
			new Bin("bn2", Value.get(1244)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1245', 1245, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1245")), 
			new Bin("bn2", Value.get(1245)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1246', 1246, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1246")), 
			new Bin("bn2", Value.get(1246)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1247', 1247, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1247")), 
			new Bin("bn2", Value.get(1247)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1248', 1248, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1248")), 
			new Bin("bn2", Value.get(1248)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1249', 1249, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1249")), 
			new Bin("bn2", Value.get(1249)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1250', 1250, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1250")), 
			new Bin("bn2", Value.get(1250)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1251', 1251, '126', 126)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1251")), 
			new Bin("bn2", Value.get(1251)),
			new Bin("bn3", Value.get("126")),
			new Bin("bn4", Value.get(126))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1252', 1252, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1252")), 
			new Bin("bn2", Value.get(1252)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1253', 1253, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1253")), 
			new Bin("bn2", Value.get(1253)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1254', 1254, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1254")), 
			new Bin("bn2", Value.get(1254)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1255', 1255, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1255")), 
			new Bin("bn2", Value.get(1255)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1256', 1256, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1256")), 
			new Bin("bn2", Value.get(1256)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1257', 1257, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1257")), 
			new Bin("bn2", Value.get(1257)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1258', 1258, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1258")), 
			new Bin("bn2", Value.get(1258)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1259', 1259, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1259")), 
			new Bin("bn2", Value.get(1259)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1260', 1260, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1260")), 
			new Bin("bn2", Value.get(1260)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1261', 1261, '127', 127)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1261")), 
			new Bin("bn2", Value.get(1261)),
			new Bin("bn3", Value.get("127")),
			new Bin("bn4", Value.get(127))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1262', 1262, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1262")), 
			new Bin("bn2", Value.get(1262)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1263', 1263, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1263")), 
			new Bin("bn2", Value.get(1263)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1264', 1264, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1264")), 
			new Bin("bn2", Value.get(1264)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1265', 1265, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1265")), 
			new Bin("bn2", Value.get(1265)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1266', 1266, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1266")), 
			new Bin("bn2", Value.get(1266)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1267', 1267, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1267")), 
			new Bin("bn2", Value.get(1267)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1268', 1268, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1268")), 
			new Bin("bn2", Value.get(1268)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1269', 1269, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1269")), 
			new Bin("bn2", Value.get(1269)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1270', 1270, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1270")), 
			new Bin("bn2", Value.get(1270)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1271', 1271, '128', 128)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1271")), 
			new Bin("bn2", Value.get(1271)),
			new Bin("bn3", Value.get("128")),
			new Bin("bn4", Value.get(128))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1272', 1272, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1272")), 
			new Bin("bn2", Value.get(1272)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1273', 1273, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1273")), 
			new Bin("bn2", Value.get(1273)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1274', 1274, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1274")), 
			new Bin("bn2", Value.get(1274)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1275', 1275, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1275")), 
			new Bin("bn2", Value.get(1275)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1276', 1276, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1276")), 
			new Bin("bn2", Value.get(1276)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1277', 1277, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1277")), 
			new Bin("bn2", Value.get(1277)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1278', 1278, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1278")), 
			new Bin("bn2", Value.get(1278)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1279', 1279, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1279")), 
			new Bin("bn2", Value.get(1279)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1280', 1280, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1280")), 
			new Bin("bn2", Value.get(1280)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1281', 1281, '129', 129)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1281")), 
			new Bin("bn2", Value.get(1281)),
			new Bin("bn3", Value.get("129")),
			new Bin("bn4", Value.get(129))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1282', 1282, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1282")), 
			new Bin("bn2", Value.get(1282)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1283', 1283, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1283")), 
			new Bin("bn2", Value.get(1283)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1284', 1284, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1284")), 
			new Bin("bn2", Value.get(1284)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1285', 1285, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1285")), 
			new Bin("bn2", Value.get(1285)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1286', 1286, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1286")), 
			new Bin("bn2", Value.get(1286)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1287', 1287, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1287")), 
			new Bin("bn2", Value.get(1287)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1288', 1288, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1288")), 
			new Bin("bn2", Value.get(1288)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1289', 1289, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1289")), 
			new Bin("bn2", Value.get(1289)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1290', 1290, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1290")), 
			new Bin("bn2", Value.get(1290)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1291', 1291, '130', 130)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1291")), 
			new Bin("bn2", Value.get(1291)),
			new Bin("bn3", Value.get("130")),
			new Bin("bn4", Value.get(130))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1292', 1292, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1292")), 
			new Bin("bn2", Value.get(1292)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1293', 1293, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1293")), 
			new Bin("bn2", Value.get(1293)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1294', 1294, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1294")), 
			new Bin("bn2", Value.get(1294)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1295', 1295, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1295")), 
			new Bin("bn2", Value.get(1295)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1296', 1296, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1296")), 
			new Bin("bn2", Value.get(1296)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1297', 1297, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1297")), 
			new Bin("bn2", Value.get(1297)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1298', 1298, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1298")), 
			new Bin("bn2", Value.get(1298)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1299', 1299, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1299")), 
			new Bin("bn2", Value.get(1299)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1300', 1300, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1300")), 
			new Bin("bn2", Value.get(1300)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1301', 1301, '131', 131)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1301")), 
			new Bin("bn2", Value.get(1301)),
			new Bin("bn3", Value.get("131")),
			new Bin("bn4", Value.get(131))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1302', 1302, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1302")), 
			new Bin("bn2", Value.get(1302)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1303', 1303, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1303")), 
			new Bin("bn2", Value.get(1303)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1304', 1304, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1304")), 
			new Bin("bn2", Value.get(1304)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1305', 1305, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1305")), 
			new Bin("bn2", Value.get(1305)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1306', 1306, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1306")), 
			new Bin("bn2", Value.get(1306)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1307', 1307, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1307")), 
			new Bin("bn2", Value.get(1307)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1308', 1308, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1308")), 
			new Bin("bn2", Value.get(1308)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1309', 1309, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1309")), 
			new Bin("bn2", Value.get(1309)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1310', 1310, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1310")), 
			new Bin("bn2", Value.get(1310)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1311', 1311, '132', 132)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1311")), 
			new Bin("bn2", Value.get(1311)),
			new Bin("bn3", Value.get("132")),
			new Bin("bn4", Value.get(132))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1312', 1312, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1312")), 
			new Bin("bn2", Value.get(1312)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1313', 1313, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1313")), 
			new Bin("bn2", Value.get(1313)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1314', 1314, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1314")), 
			new Bin("bn2", Value.get(1314)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1315', 1315, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1315")), 
			new Bin("bn2", Value.get(1315)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1316', 1316, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1316")), 
			new Bin("bn2", Value.get(1316)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1317', 1317, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1317")), 
			new Bin("bn2", Value.get(1317)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1318', 1318, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1318")), 
			new Bin("bn2", Value.get(1318)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1319', 1319, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1319")), 
			new Bin("bn2", Value.get(1319)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1320', 1320, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1320")), 
			new Bin("bn2", Value.get(1320)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1321', 1321, '133', 133)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1321")), 
			new Bin("bn2", Value.get(1321)),
			new Bin("bn3", Value.get("133")),
			new Bin("bn4", Value.get(133))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1322', 1322, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1322")), 
			new Bin("bn2", Value.get(1322)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1323', 1323, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1323")), 
			new Bin("bn2", Value.get(1323)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1324', 1324, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1324")), 
			new Bin("bn2", Value.get(1324)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1325', 1325, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1325")), 
			new Bin("bn2", Value.get(1325)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1326', 1326, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1326")), 
			new Bin("bn2", Value.get(1326)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1327', 1327, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1327")), 
			new Bin("bn2", Value.get(1327)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1328', 1328, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1328")), 
			new Bin("bn2", Value.get(1328)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1329', 1329, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1329")), 
			new Bin("bn2", Value.get(1329)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1330', 1330, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1330")), 
			new Bin("bn2", Value.get(1330)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1331', 1331, '134', 134)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1331")), 
			new Bin("bn2", Value.get(1331)),
			new Bin("bn3", Value.get("134")),
			new Bin("bn4", Value.get(134))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1332', 1332, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1332")), 
			new Bin("bn2", Value.get(1332)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1333', 1333, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1333")), 
			new Bin("bn2", Value.get(1333)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1334', 1334, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1334")), 
			new Bin("bn2", Value.get(1334)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1335', 1335, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1335")), 
			new Bin("bn2", Value.get(1335)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1336', 1336, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1336")), 
			new Bin("bn2", Value.get(1336)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1337', 1337, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1337")), 
			new Bin("bn2", Value.get(1337)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1338', 1338, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1338")), 
			new Bin("bn2", Value.get(1338)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1339', 1339, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1339")), 
			new Bin("bn2", Value.get(1339)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1340', 1340, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1340")), 
			new Bin("bn2", Value.get(1340)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1341', 1341, '135', 135)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1341")), 
			new Bin("bn2", Value.get(1341)),
			new Bin("bn3", Value.get("135")),
			new Bin("bn4", Value.get(135))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1342', 1342, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1342")), 
			new Bin("bn2", Value.get(1342)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1343', 1343, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1343")), 
			new Bin("bn2", Value.get(1343)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1344', 1344, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1344")), 
			new Bin("bn2", Value.get(1344)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1345', 1345, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1345")), 
			new Bin("bn2", Value.get(1345)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1346', 1346, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1346")), 
			new Bin("bn2", Value.get(1346)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1347', 1347, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1347")), 
			new Bin("bn2", Value.get(1347)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1348', 1348, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1348")), 
			new Bin("bn2", Value.get(1348)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1349', 1349, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1349")), 
			new Bin("bn2", Value.get(1349)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1350', 1350, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1350")), 
			new Bin("bn2", Value.get(1350)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1351', 1351, '136', 136)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1351")), 
			new Bin("bn2", Value.get(1351)),
			new Bin("bn3", Value.get("136")),
			new Bin("bn4", Value.get(136))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1352', 1352, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1352")), 
			new Bin("bn2", Value.get(1352)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1353', 1353, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1353")), 
			new Bin("bn2", Value.get(1353)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1354', 1354, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1354")), 
			new Bin("bn2", Value.get(1354)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1355', 1355, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1355")), 
			new Bin("bn2", Value.get(1355)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1356', 1356, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1356")), 
			new Bin("bn2", Value.get(1356)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1357', 1357, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1357")), 
			new Bin("bn2", Value.get(1357)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1358', 1358, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1358")), 
			new Bin("bn2", Value.get(1358)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1359', 1359, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1359")), 
			new Bin("bn2", Value.get(1359)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1360', 1360, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1360")), 
			new Bin("bn2", Value.get(1360)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1361', 1361, '137', 137)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1361")), 
			new Bin("bn2", Value.get(1361)),
			new Bin("bn3", Value.get("137")),
			new Bin("bn4", Value.get(137))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1362', 1362, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1362")), 
			new Bin("bn2", Value.get(1362)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1363', 1363, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1363")), 
			new Bin("bn2", Value.get(1363)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1364', 1364, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1364")), 
			new Bin("bn2", Value.get(1364)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1365', 1365, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1365")), 
			new Bin("bn2", Value.get(1365)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1366', 1366, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1366")), 
			new Bin("bn2", Value.get(1366)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1367', 1367, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1367")), 
			new Bin("bn2", Value.get(1367)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1368', 1368, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1368")), 
			new Bin("bn2", Value.get(1368)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1369', 1369, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1369")), 
			new Bin("bn2", Value.get(1369)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1370', 1370, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1370")), 
			new Bin("bn2", Value.get(1370)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1371', 1371, '138', 138)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1371")), 
			new Bin("bn2", Value.get(1371)),
			new Bin("bn3", Value.get("138")),
			new Bin("bn4", Value.get(138))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1372', 1372, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1372")), 
			new Bin("bn2", Value.get(1372)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1373', 1373, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1373")), 
			new Bin("bn2", Value.get(1373)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1374', 1374, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1374")), 
			new Bin("bn2", Value.get(1374)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1375', 1375, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1375")), 
			new Bin("bn2", Value.get(1375)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1376', 1376, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1376")), 
			new Bin("bn2", Value.get(1376)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1377', 1377, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1377")), 
			new Bin("bn2", Value.get(1377)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1378', 1378, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1378")), 
			new Bin("bn2", Value.get(1378)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1379', 1379, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1379")), 
			new Bin("bn2", Value.get(1379)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1380', 1380, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1380")), 
			new Bin("bn2", Value.get(1380)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1381', 1381, '139', 139)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1381")), 
			new Bin("bn2", Value.get(1381)),
			new Bin("bn3", Value.get("139")),
			new Bin("bn4", Value.get(139))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1382', 1382, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1382")), 
			new Bin("bn2", Value.get(1382)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1383', 1383, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1383")), 
			new Bin("bn2", Value.get(1383)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1384', 1384, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1384")), 
			new Bin("bn2", Value.get(1384)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1385', 1385, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1385")), 
			new Bin("bn2", Value.get(1385)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1386', 1386, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1386")), 
			new Bin("bn2", Value.get(1386)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1387', 1387, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1387")), 
			new Bin("bn2", Value.get(1387)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1388', 1388, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1388")), 
			new Bin("bn2", Value.get(1388)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1389', 1389, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1389")), 
			new Bin("bn2", Value.get(1389)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1390', 1390, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1390")), 
			new Bin("bn2", Value.get(1390)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1391', 1391, '140', 140)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1391")), 
			new Bin("bn2", Value.get(1391)),
			new Bin("bn3", Value.get("140")),
			new Bin("bn4", Value.get(140))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1392', 1392, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1392")), 
			new Bin("bn2", Value.get(1392)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1393', 1393, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1393")), 
			new Bin("bn2", Value.get(1393)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1394', 1394, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1394")), 
			new Bin("bn2", Value.get(1394)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1395', 1395, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1395")), 
			new Bin("bn2", Value.get(1395)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1396', 1396, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1396")), 
			new Bin("bn2", Value.get(1396)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1397', 1397, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1397")), 
			new Bin("bn2", Value.get(1397)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1398', 1398, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1398")), 
			new Bin("bn2", Value.get(1398)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1399', 1399, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1399")), 
			new Bin("bn2", Value.get(1399)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1400', 1400, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1400")), 
			new Bin("bn2", Value.get(1400)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1401', 1401, '141', 141)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1401")), 
			new Bin("bn2", Value.get(1401)),
			new Bin("bn3", Value.get("141")),
			new Bin("bn4", Value.get(141))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1402', 1402, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1402")), 
			new Bin("bn2", Value.get(1402)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1403', 1403, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1403")), 
			new Bin("bn2", Value.get(1403)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1404', 1404, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1404")), 
			new Bin("bn2", Value.get(1404)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1405', 1405, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1405")), 
			new Bin("bn2", Value.get(1405)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1406', 1406, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1406")), 
			new Bin("bn2", Value.get(1406)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1407', 1407, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1407")), 
			new Bin("bn2", Value.get(1407)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1408', 1408, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1408")), 
			new Bin("bn2", Value.get(1408)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1409', 1409, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1409")), 
			new Bin("bn2", Value.get(1409)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1410', 1410, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1410")), 
			new Bin("bn2", Value.get(1410)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1411', 1411, '142', 142)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1411")), 
			new Bin("bn2", Value.get(1411)),
			new Bin("bn3", Value.get("142")),
			new Bin("bn4", Value.get(142))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1412', 1412, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1412")), 
			new Bin("bn2", Value.get(1412)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1413', 1413, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1413")), 
			new Bin("bn2", Value.get(1413)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1414', 1414, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1414")), 
			new Bin("bn2", Value.get(1414)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1415', 1415, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1415")), 
			new Bin("bn2", Value.get(1415)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1416', 1416, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1416")), 
			new Bin("bn2", Value.get(1416)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1417', 1417, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1417")), 
			new Bin("bn2", Value.get(1417)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1418', 1418, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1418")), 
			new Bin("bn2", Value.get(1418)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1419', 1419, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1419")), 
			new Bin("bn2", Value.get(1419)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1420', 1420, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1420")), 
			new Bin("bn2", Value.get(1420)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1421', 1421, '143', 143)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1421")), 
			new Bin("bn2", Value.get(1421)),
			new Bin("bn3", Value.get("143")),
			new Bin("bn4", Value.get(143))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1422', 1422, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1422")), 
			new Bin("bn2", Value.get(1422)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1423', 1423, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1423")), 
			new Bin("bn2", Value.get(1423)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1424', 1424, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1424")), 
			new Bin("bn2", Value.get(1424)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1425', 1425, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1425")), 
			new Bin("bn2", Value.get(1425)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1426', 1426, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1426")), 
			new Bin("bn2", Value.get(1426)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1427', 1427, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1427")), 
			new Bin("bn2", Value.get(1427)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1428', 1428, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1428")), 
			new Bin("bn2", Value.get(1428)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1429', 1429, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1429")), 
			new Bin("bn2", Value.get(1429)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1430', 1430, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1430")), 
			new Bin("bn2", Value.get(1430)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1431', 1431, '144', 144)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1431")), 
			new Bin("bn2", Value.get(1431)),
			new Bin("bn3", Value.get("144")),
			new Bin("bn4", Value.get(144))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1432', 1432, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1432")), 
			new Bin("bn2", Value.get(1432)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1433', 1433, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1433")), 
			new Bin("bn2", Value.get(1433)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1434', 1434, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1434")), 
			new Bin("bn2", Value.get(1434)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1435', 1435, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1435")), 
			new Bin("bn2", Value.get(1435)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1436', 1436, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1436")), 
			new Bin("bn2", Value.get(1436)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1437', 1437, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1437")), 
			new Bin("bn2", Value.get(1437)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1438', 1438, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1438")), 
			new Bin("bn2", Value.get(1438)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1439', 1439, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1439")), 
			new Bin("bn2", Value.get(1439)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1440', 1440, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1440")), 
			new Bin("bn2", Value.get(1440)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1441', 1441, '145', 145)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1441")), 
			new Bin("bn2", Value.get(1441)),
			new Bin("bn3", Value.get("145")),
			new Bin("bn4", Value.get(145))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1442', 1442, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1442")), 
			new Bin("bn2", Value.get(1442)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1443', 1443, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1443")), 
			new Bin("bn2", Value.get(1443)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1444', 1444, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1444")), 
			new Bin("bn2", Value.get(1444)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1445', 1445, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1445")), 
			new Bin("bn2", Value.get(1445)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1446', 1446, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1446")), 
			new Bin("bn2", Value.get(1446)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1447', 1447, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1447")), 
			new Bin("bn2", Value.get(1447)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1448', 1448, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1448")), 
			new Bin("bn2", Value.get(1448)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1449', 1449, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1449")), 
			new Bin("bn2", Value.get(1449)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1450', 1450, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1450")), 
			new Bin("bn2", Value.get(1450)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1451', 1451, '146', 146)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1451")), 
			new Bin("bn2", Value.get(1451)),
			new Bin("bn3", Value.get("146")),
			new Bin("bn4", Value.get(146))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1452', 1452, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1452")), 
			new Bin("bn2", Value.get(1452)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1453', 1453, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1453")), 
			new Bin("bn2", Value.get(1453)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1454', 1454, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1454")), 
			new Bin("bn2", Value.get(1454)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1455', 1455, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1455")), 
			new Bin("bn2", Value.get(1455)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1456', 1456, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1456")), 
			new Bin("bn2", Value.get(1456)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1457', 1457, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1457")), 
			new Bin("bn2", Value.get(1457)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1458', 1458, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1458")), 
			new Bin("bn2", Value.get(1458)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1459', 1459, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1459")), 
			new Bin("bn2", Value.get(1459)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1460', 1460, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1460")), 
			new Bin("bn2", Value.get(1460)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1461', 1461, '147', 147)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1461")), 
			new Bin("bn2", Value.get(1461)),
			new Bin("bn3", Value.get("147")),
			new Bin("bn4", Value.get(147))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1462', 1462, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1462")), 
			new Bin("bn2", Value.get(1462)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1463', 1463, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1463")), 
			new Bin("bn2", Value.get(1463)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1464', 1464, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1464")), 
			new Bin("bn2", Value.get(1464)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1465', 1465, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1465")), 
			new Bin("bn2", Value.get(1465)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1466', 1466, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1466")), 
			new Bin("bn2", Value.get(1466)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1467', 1467, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1467")), 
			new Bin("bn2", Value.get(1467)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1468', 1468, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1468")), 
			new Bin("bn2", Value.get(1468)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1469', 1469, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1469")), 
			new Bin("bn2", Value.get(1469)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1470', 1470, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1470")), 
			new Bin("bn2", Value.get(1470)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1471', 1471, '148', 148)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1471")), 
			new Bin("bn2", Value.get(1471)),
			new Bin("bn3", Value.get("148")),
			new Bin("bn4", Value.get(148))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1472', 1472, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1472")), 
			new Bin("bn2", Value.get(1472)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1473', 1473, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1473")), 
			new Bin("bn2", Value.get(1473)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1474', 1474, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1474")), 
			new Bin("bn2", Value.get(1474)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1475', 1475, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1475")), 
			new Bin("bn2", Value.get(1475)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1476', 1476, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1476")), 
			new Bin("bn2", Value.get(1476)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1477', 1477, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1477")), 
			new Bin("bn2", Value.get(1477)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1478', 1478, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1478")), 
			new Bin("bn2", Value.get(1478)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1479', 1479, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1479")), 
			new Bin("bn2", Value.get(1479)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1480', 1480, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1480")), 
			new Bin("bn2", Value.get(1480)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1481', 1481, '149', 149)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1481")), 
			new Bin("bn2", Value.get(1481)),
			new Bin("bn3", Value.get("149")),
			new Bin("bn4", Value.get(149))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1482', 1482, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1482")), 
			new Bin("bn2", Value.get(1482)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1483', 1483, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1483")), 
			new Bin("bn2", Value.get(1483)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1484', 1484, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1484")), 
			new Bin("bn2", Value.get(1484)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1485', 1485, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1485")), 
			new Bin("bn2", Value.get(1485)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1486', 1486, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1486")), 
			new Bin("bn2", Value.get(1486)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1487', 1487, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1487")), 
			new Bin("bn2", Value.get(1487)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1488', 1488, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1488")), 
			new Bin("bn2", Value.get(1488)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1489', 1489, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1489")), 
			new Bin("bn2", Value.get(1489)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1490', 1490, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1490")), 
			new Bin("bn2", Value.get(1490)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1491', 1491, '150', 150)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1491")), 
			new Bin("bn2", Value.get(1491)),
			new Bin("bn3", Value.get("150")),
			new Bin("bn4", Value.get(150))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1492', 1492, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1492")), 
			new Bin("bn2", Value.get(1492)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1493', 1493, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1493")), 
			new Bin("bn2", Value.get(1493)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1494', 1494, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1494")), 
			new Bin("bn2", Value.get(1494)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1495', 1495, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1495")), 
			new Bin("bn2", Value.get(1495)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1496', 1496, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1496")), 
			new Bin("bn2", Value.get(1496)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1497', 1497, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1497")), 
			new Bin("bn2", Value.get(1497)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1498', 1498, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1498")), 
			new Bin("bn2", Value.get(1498)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1499', 1499, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1499")), 
			new Bin("bn2", Value.get(1499)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1500', 1500, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1500")), 
			new Bin("bn2", Value.get(1500)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1501', 1501, '151', 151)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1501")), 
			new Bin("bn2", Value.get(1501)),
			new Bin("bn3", Value.get("151")),
			new Bin("bn4", Value.get(151))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1502', 1502, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1502")), 
			new Bin("bn2", Value.get(1502)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1503', 1503, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1503")), 
			new Bin("bn2", Value.get(1503)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1504', 1504, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1504")), 
			new Bin("bn2", Value.get(1504)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1505', 1505, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1505")), 
			new Bin("bn2", Value.get(1505)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1506', 1506, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1506")), 
			new Bin("bn2", Value.get(1506)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1507', 1507, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1507")), 
			new Bin("bn2", Value.get(1507)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1508', 1508, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1508")), 
			new Bin("bn2", Value.get(1508)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1509', 1509, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1509")), 
			new Bin("bn2", Value.get(1509)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1510', 1510, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1510")), 
			new Bin("bn2", Value.get(1510)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1511', 1511, '152', 152)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1511")), 
			new Bin("bn2", Value.get(1511)),
			new Bin("bn3", Value.get("152")),
			new Bin("bn4", Value.get(152))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1512', 1512, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1512")), 
			new Bin("bn2", Value.get(1512)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1513', 1513, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1513")), 
			new Bin("bn2", Value.get(1513)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1514', 1514, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1514")), 
			new Bin("bn2", Value.get(1514)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1515', 1515, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1515")), 
			new Bin("bn2", Value.get(1515)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1516', 1516, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1516")), 
			new Bin("bn2", Value.get(1516)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1517', 1517, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1517")), 
			new Bin("bn2", Value.get(1517)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1518', 1518, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1518")), 
			new Bin("bn2", Value.get(1518)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1519', 1519, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1519")), 
			new Bin("bn2", Value.get(1519)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1520', 1520, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1520")), 
			new Bin("bn2", Value.get(1520)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1521', 1521, '153', 153)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1521")), 
			new Bin("bn2", Value.get(1521)),
			new Bin("bn3", Value.get("153")),
			new Bin("bn4", Value.get(153))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1522', 1522, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1522")), 
			new Bin("bn2", Value.get(1522)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1523', 1523, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1523")), 
			new Bin("bn2", Value.get(1523)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1524', 1524, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1524")), 
			new Bin("bn2", Value.get(1524)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1525', 1525, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1525")), 
			new Bin("bn2", Value.get(1525)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1526', 1526, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1526")), 
			new Bin("bn2", Value.get(1526)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1527', 1527, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1527")), 
			new Bin("bn2", Value.get(1527)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1528', 1528, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1528")), 
			new Bin("bn2", Value.get(1528)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1529', 1529, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1529")), 
			new Bin("bn2", Value.get(1529)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1530', 1530, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1530")), 
			new Bin("bn2", Value.get(1530)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1531', 1531, '154', 154)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1531")), 
			new Bin("bn2", Value.get(1531)),
			new Bin("bn3", Value.get("154")),
			new Bin("bn4", Value.get(154))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1532', 1532, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1532")), 
			new Bin("bn2", Value.get(1532)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1533', 1533, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1533")), 
			new Bin("bn2", Value.get(1533)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1534', 1534, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1534")), 
			new Bin("bn2", Value.get(1534)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1535', 1535, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1535")), 
			new Bin("bn2", Value.get(1535)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1536', 1536, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1536")), 
			new Bin("bn2", Value.get(1536)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1537', 1537, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1537")), 
			new Bin("bn2", Value.get(1537)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1538', 1538, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1538")), 
			new Bin("bn2", Value.get(1538)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1539', 1539, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1539")), 
			new Bin("bn2", Value.get(1539)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1540', 1540, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1540")), 
			new Bin("bn2", Value.get(1540)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1541', 1541, '155', 155)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1541")), 
			new Bin("bn2", Value.get(1541)),
			new Bin("bn3", Value.get("155")),
			new Bin("bn4", Value.get(155))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1542', 1542, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1542")), 
			new Bin("bn2", Value.get(1542)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1543', 1543, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1543")), 
			new Bin("bn2", Value.get(1543)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1544', 1544, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1544")), 
			new Bin("bn2", Value.get(1544)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1545', 1545, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1545")), 
			new Bin("bn2", Value.get(1545)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1546', 1546, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1546")), 
			new Bin("bn2", Value.get(1546)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1547', 1547, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1547")), 
			new Bin("bn2", Value.get(1547)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1548', 1548, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1548")), 
			new Bin("bn2", Value.get(1548)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1549', 1549, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1549")), 
			new Bin("bn2", Value.get(1549)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1550', 1550, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1550")), 
			new Bin("bn2", Value.get(1550)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1551', 1551, '156', 156)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1551")), 
			new Bin("bn2", Value.get(1551)),
			new Bin("bn3", Value.get("156")),
			new Bin("bn4", Value.get(156))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1552', 1552, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1552")), 
			new Bin("bn2", Value.get(1552)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1553', 1553, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1553")), 
			new Bin("bn2", Value.get(1553)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1554', 1554, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1554")), 
			new Bin("bn2", Value.get(1554)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1555', 1555, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1555")), 
			new Bin("bn2", Value.get(1555)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1556', 1556, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1556")), 
			new Bin("bn2", Value.get(1556)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1557', 1557, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1557")), 
			new Bin("bn2", Value.get(1557)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1558', 1558, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1558")), 
			new Bin("bn2", Value.get(1558)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1559', 1559, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1559")), 
			new Bin("bn2", Value.get(1559)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1560', 1560, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1560")), 
			new Bin("bn2", Value.get(1560)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1561', 1561, '157', 157)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1561")), 
			new Bin("bn2", Value.get(1561)),
			new Bin("bn3", Value.get("157")),
			new Bin("bn4", Value.get(157))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1562', 1562, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1562")), 
			new Bin("bn2", Value.get(1562)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1563', 1563, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1563")), 
			new Bin("bn2", Value.get(1563)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1564', 1564, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1564")), 
			new Bin("bn2", Value.get(1564)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1565', 1565, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1565")), 
			new Bin("bn2", Value.get(1565)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1566', 1566, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1566")), 
			new Bin("bn2", Value.get(1566)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1567', 1567, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1567")), 
			new Bin("bn2", Value.get(1567)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1568', 1568, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1568")), 
			new Bin("bn2", Value.get(1568)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1569', 1569, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1569")), 
			new Bin("bn2", Value.get(1569)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1570', 1570, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1570")), 
			new Bin("bn2", Value.get(1570)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1571', 1571, '158', 158)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1571")), 
			new Bin("bn2", Value.get(1571)),
			new Bin("bn3", Value.get("158")),
			new Bin("bn4", Value.get(158))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1572', 1572, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1572")), 
			new Bin("bn2", Value.get(1572)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1573', 1573, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1573")), 
			new Bin("bn2", Value.get(1573)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1574', 1574, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1574")), 
			new Bin("bn2", Value.get(1574)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1575', 1575, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1575")), 
			new Bin("bn2", Value.get(1575)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1576', 1576, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1576")), 
			new Bin("bn2", Value.get(1576)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1577', 1577, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1577")), 
			new Bin("bn2", Value.get(1577)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1578', 1578, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1578")), 
			new Bin("bn2", Value.get(1578)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1579', 1579, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1579")), 
			new Bin("bn2", Value.get(1579)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1580', 1580, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1580")), 
			new Bin("bn2", Value.get(1580)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1581', 1581, '159', 159)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1581")), 
			new Bin("bn2", Value.get(1581)),
			new Bin("bn3", Value.get("159")),
			new Bin("bn4", Value.get(159))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1582', 1582, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1582")), 
			new Bin("bn2", Value.get(1582)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1583', 1583, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1583")), 
			new Bin("bn2", Value.get(1583)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1584', 1584, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1584")), 
			new Bin("bn2", Value.get(1584)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1585', 1585, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1585")), 
			new Bin("bn2", Value.get(1585)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1586', 1586, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1586")), 
			new Bin("bn2", Value.get(1586)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1587', 1587, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1587")), 
			new Bin("bn2", Value.get(1587)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1588', 1588, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1588")), 
			new Bin("bn2", Value.get(1588)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1589', 1589, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1589")), 
			new Bin("bn2", Value.get(1589)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1590', 1590, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1590")), 
			new Bin("bn2", Value.get(1590)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1591', 1591, '160', 160)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1591")), 
			new Bin("bn2", Value.get(1591)),
			new Bin("bn3", Value.get("160")),
			new Bin("bn4", Value.get(160))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1592', 1592, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1592")), 
			new Bin("bn2", Value.get(1592)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1593', 1593, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1593")), 
			new Bin("bn2", Value.get(1593)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1594', 1594, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1594")), 
			new Bin("bn2", Value.get(1594)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1595', 1595, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1595")), 
			new Bin("bn2", Value.get(1595)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1596', 1596, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1596")), 
			new Bin("bn2", Value.get(1596)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1597', 1597, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1597")), 
			new Bin("bn2", Value.get(1597)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1598', 1598, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1598")), 
			new Bin("bn2", Value.get(1598)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1599', 1599, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1599")), 
			new Bin("bn2", Value.get(1599)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1600', 1600, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1600")), 
			new Bin("bn2", Value.get(1600)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1601', 1601, '161', 161)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1601")), 
			new Bin("bn2", Value.get(1601)),
			new Bin("bn3", Value.get("161")),
			new Bin("bn4", Value.get(161))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1602', 1602, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1602")), 
			new Bin("bn2", Value.get(1602)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1603', 1603, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1603")), 
			new Bin("bn2", Value.get(1603)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1604', 1604, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1604")), 
			new Bin("bn2", Value.get(1604)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1605', 1605, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1605")), 
			new Bin("bn2", Value.get(1605)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1606', 1606, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1606")), 
			new Bin("bn2", Value.get(1606)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1607', 1607, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1607")), 
			new Bin("bn2", Value.get(1607)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1608', 1608, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1608")), 
			new Bin("bn2", Value.get(1608)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1609', 1609, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1609")), 
			new Bin("bn2", Value.get(1609)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1610', 1610, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1610")), 
			new Bin("bn2", Value.get(1610)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1611', 1611, '162', 162)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1611")), 
			new Bin("bn2", Value.get(1611)),
			new Bin("bn3", Value.get("162")),
			new Bin("bn4", Value.get(162))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1612', 1612, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1612")), 
			new Bin("bn2", Value.get(1612)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1613', 1613, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1613")), 
			new Bin("bn2", Value.get(1613)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1614', 1614, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1614")), 
			new Bin("bn2", Value.get(1614)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1615', 1615, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1615")), 
			new Bin("bn2", Value.get(1615)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1616', 1616, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1616")), 
			new Bin("bn2", Value.get(1616)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1617', 1617, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1617")), 
			new Bin("bn2", Value.get(1617)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1618', 1618, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1618")), 
			new Bin("bn2", Value.get(1618)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1619', 1619, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1619")), 
			new Bin("bn2", Value.get(1619)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1620', 1620, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1620")), 
			new Bin("bn2", Value.get(1620)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1621', 1621, '163', 163)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1621")), 
			new Bin("bn2", Value.get(1621)),
			new Bin("bn3", Value.get("163")),
			new Bin("bn4", Value.get(163))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1622', 1622, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1622")), 
			new Bin("bn2", Value.get(1622)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1623', 1623, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1623")), 
			new Bin("bn2", Value.get(1623)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1624', 1624, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1624")), 
			new Bin("bn2", Value.get(1624)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1625', 1625, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1625")), 
			new Bin("bn2", Value.get(1625)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1626', 1626, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1626")), 
			new Bin("bn2", Value.get(1626)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1627', 1627, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1627")), 
			new Bin("bn2", Value.get(1627)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1628', 1628, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1628")), 
			new Bin("bn2", Value.get(1628)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1629', 1629, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1629")), 
			new Bin("bn2", Value.get(1629)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1630', 1630, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1630")), 
			new Bin("bn2", Value.get(1630)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1631', 1631, '164', 164)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1631")), 
			new Bin("bn2", Value.get(1631)),
			new Bin("bn3", Value.get("164")),
			new Bin("bn4", Value.get(164))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1632', 1632, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1632")), 
			new Bin("bn2", Value.get(1632)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1633', 1633, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1633")), 
			new Bin("bn2", Value.get(1633)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1634', 1634, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1634")), 
			new Bin("bn2", Value.get(1634)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1635', 1635, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1635")), 
			new Bin("bn2", Value.get(1635)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1636', 1636, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1636")), 
			new Bin("bn2", Value.get(1636)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1637', 1637, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1637")), 
			new Bin("bn2", Value.get(1637)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1638', 1638, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1638")), 
			new Bin("bn2", Value.get(1638)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1639', 1639, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1639")), 
			new Bin("bn2", Value.get(1639)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1640', 1640, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1640")), 
			new Bin("bn2", Value.get(1640)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1641', 1641, '165', 165)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1641")), 
			new Bin("bn2", Value.get(1641)),
			new Bin("bn3", Value.get("165")),
			new Bin("bn4", Value.get(165))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1642', 1642, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1642")), 
			new Bin("bn2", Value.get(1642)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1643', 1643, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1643")), 
			new Bin("bn2", Value.get(1643)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1644', 1644, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1644")), 
			new Bin("bn2", Value.get(1644)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1645', 1645, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1645")), 
			new Bin("bn2", Value.get(1645)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1646', 1646, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1646")), 
			new Bin("bn2", Value.get(1646)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1647', 1647, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1647")), 
			new Bin("bn2", Value.get(1647)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1648', 1648, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1648")), 
			new Bin("bn2", Value.get(1648)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1649', 1649, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1649")), 
			new Bin("bn2", Value.get(1649)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1650', 1650, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1650")), 
			new Bin("bn2", Value.get(1650)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1651', 1651, '166', 166)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1651")), 
			new Bin("bn2", Value.get(1651)),
			new Bin("bn3", Value.get("166")),
			new Bin("bn4", Value.get(166))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1652', 1652, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1652")), 
			new Bin("bn2", Value.get(1652)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1653', 1653, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1653")), 
			new Bin("bn2", Value.get(1653)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1654', 1654, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1654")), 
			new Bin("bn2", Value.get(1654)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1655', 1655, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1655")), 
			new Bin("bn2", Value.get(1655)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1656', 1656, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1656")), 
			new Bin("bn2", Value.get(1656)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1657', 1657, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1657")), 
			new Bin("bn2", Value.get(1657)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1658', 1658, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1658")), 
			new Bin("bn2", Value.get(1658)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1659', 1659, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1659")), 
			new Bin("bn2", Value.get(1659)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1660', 1660, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1660")), 
			new Bin("bn2", Value.get(1660)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1661', 1661, '167', 167)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1661")), 
			new Bin("bn2", Value.get(1661)),
			new Bin("bn3", Value.get("167")),
			new Bin("bn4", Value.get(167))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1662', 1662, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1662")), 
			new Bin("bn2", Value.get(1662)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1663', 1663, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1663")), 
			new Bin("bn2", Value.get(1663)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1664', 1664, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1664")), 
			new Bin("bn2", Value.get(1664)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1665', 1665, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1665")), 
			new Bin("bn2", Value.get(1665)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1666', 1666, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1666")), 
			new Bin("bn2", Value.get(1666)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1667', 1667, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1667")), 
			new Bin("bn2", Value.get(1667)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1668', 1668, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1668")), 
			new Bin("bn2", Value.get(1668)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1669', 1669, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1669")), 
			new Bin("bn2", Value.get(1669)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1670', 1670, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1670")), 
			new Bin("bn2", Value.get(1670)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1671', 1671, '168', 168)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1671")), 
			new Bin("bn2", Value.get(1671)),
			new Bin("bn3", Value.get("168")),
			new Bin("bn4", Value.get(168))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1672', 1672, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1672")), 
			new Bin("bn2", Value.get(1672)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1673', 1673, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1673")), 
			new Bin("bn2", Value.get(1673)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1674', 1674, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1674")), 
			new Bin("bn2", Value.get(1674)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1675', 1675, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1675")), 
			new Bin("bn2", Value.get(1675)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1676', 1676, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1676")), 
			new Bin("bn2", Value.get(1676)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1677', 1677, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1677")), 
			new Bin("bn2", Value.get(1677)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1678', 1678, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1678")), 
			new Bin("bn2", Value.get(1678)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1679', 1679, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1679")), 
			new Bin("bn2", Value.get(1679)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1680', 1680, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1680")), 
			new Bin("bn2", Value.get(1680)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1681', 1681, '169', 169)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1681")), 
			new Bin("bn2", Value.get(1681)),
			new Bin("bn3", Value.get("169")),
			new Bin("bn4", Value.get(169))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1682', 1682, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1682")), 
			new Bin("bn2", Value.get(1682)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1683', 1683, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1683")), 
			new Bin("bn2", Value.get(1683)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1684', 1684, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1684")), 
			new Bin("bn2", Value.get(1684)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1685', 1685, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1685")), 
			new Bin("bn2", Value.get(1685)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1686', 1686, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1686")), 
			new Bin("bn2", Value.get(1686)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1687', 1687, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1687")), 
			new Bin("bn2", Value.get(1687)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1688', 1688, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1688")), 
			new Bin("bn2", Value.get(1688)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1689', 1689, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1689")), 
			new Bin("bn2", Value.get(1689)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1690', 1690, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1690")), 
			new Bin("bn2", Value.get(1690)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1691', 1691, '170', 170)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1691")), 
			new Bin("bn2", Value.get(1691)),
			new Bin("bn3", Value.get("170")),
			new Bin("bn4", Value.get(170))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1692', 1692, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1692")), 
			new Bin("bn2", Value.get(1692)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1693', 1693, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1693")), 
			new Bin("bn2", Value.get(1693)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1694', 1694, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1694")), 
			new Bin("bn2", Value.get(1694)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1695', 1695, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1695")), 
			new Bin("bn2", Value.get(1695)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1696', 1696, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1696")), 
			new Bin("bn2", Value.get(1696)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1697', 1697, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1697")), 
			new Bin("bn2", Value.get(1697)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1698', 1698, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1698")), 
			new Bin("bn2", Value.get(1698)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1699', 1699, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1699")), 
			new Bin("bn2", Value.get(1699)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1700', 1700, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1700")), 
			new Bin("bn2", Value.get(1700)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1701', 1701, '171', 171)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1701")), 
			new Bin("bn2", Value.get(1701)),
			new Bin("bn3", Value.get("171")),
			new Bin("bn4", Value.get(171))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1702', 1702, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1702")), 
			new Bin("bn2", Value.get(1702)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1703', 1703, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1703")), 
			new Bin("bn2", Value.get(1703)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1704', 1704, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1704")), 
			new Bin("bn2", Value.get(1704)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1705', 1705, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1705")), 
			new Bin("bn2", Value.get(1705)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1706', 1706, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1706")), 
			new Bin("bn2", Value.get(1706)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1707', 1707, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1707")), 
			new Bin("bn2", Value.get(1707)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1708', 1708, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1708")), 
			new Bin("bn2", Value.get(1708)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1709', 1709, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1709")), 
			new Bin("bn2", Value.get(1709)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1710', 1710, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1710")), 
			new Bin("bn2", Value.get(1710)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1711', 1711, '172', 172)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1711")), 
			new Bin("bn2", Value.get(1711)),
			new Bin("bn3", Value.get("172")),
			new Bin("bn4", Value.get(172))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1712', 1712, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1712")), 
			new Bin("bn2", Value.get(1712)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1713', 1713, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1713")), 
			new Bin("bn2", Value.get(1713)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1714', 1714, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1714")), 
			new Bin("bn2", Value.get(1714)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1715', 1715, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1715")), 
			new Bin("bn2", Value.get(1715)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1716', 1716, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1716")), 
			new Bin("bn2", Value.get(1716)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1717', 1717, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1717")), 
			new Bin("bn2", Value.get(1717)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1718', 1718, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1718")), 
			new Bin("bn2", Value.get(1718)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1719', 1719, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1719")), 
			new Bin("bn2", Value.get(1719)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1720', 1720, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1720")), 
			new Bin("bn2", Value.get(1720)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1721', 1721, '173', 173)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1721")), 
			new Bin("bn2", Value.get(1721)),
			new Bin("bn3", Value.get("173")),
			new Bin("bn4", Value.get(173))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1722', 1722, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1722")), 
			new Bin("bn2", Value.get(1722)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1723', 1723, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1723")), 
			new Bin("bn2", Value.get(1723)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1724', 1724, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1724")), 
			new Bin("bn2", Value.get(1724)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1725', 1725, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1725")), 
			new Bin("bn2", Value.get(1725)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1726', 1726, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1726")), 
			new Bin("bn2", Value.get(1726)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1727', 1727, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1727")), 
			new Bin("bn2", Value.get(1727)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1728', 1728, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1728")), 
			new Bin("bn2", Value.get(1728)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1729', 1729, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1729")), 
			new Bin("bn2", Value.get(1729)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1730', 1730, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1730")), 
			new Bin("bn2", Value.get(1730)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1731', 1731, '174', 174)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1731")), 
			new Bin("bn2", Value.get(1731)),
			new Bin("bn3", Value.get("174")),
			new Bin("bn4", Value.get(174))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1732', 1732, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1732")), 
			new Bin("bn2", Value.get(1732)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1733', 1733, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1733")), 
			new Bin("bn2", Value.get(1733)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1734', 1734, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1734")), 
			new Bin("bn2", Value.get(1734)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1735', 1735, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1735")), 
			new Bin("bn2", Value.get(1735)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1736', 1736, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1736")), 
			new Bin("bn2", Value.get(1736)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1737', 1737, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1737")), 
			new Bin("bn2", Value.get(1737)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1738', 1738, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1738")), 
			new Bin("bn2", Value.get(1738)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1739', 1739, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1739")), 
			new Bin("bn2", Value.get(1739)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1740', 1740, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1740")), 
			new Bin("bn2", Value.get(1740)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1741', 1741, '175', 175)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1741")), 
			new Bin("bn2", Value.get(1741)),
			new Bin("bn3", Value.get("175")),
			new Bin("bn4", Value.get(175))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1742', 1742, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1742")), 
			new Bin("bn2", Value.get(1742)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1743', 1743, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1743")), 
			new Bin("bn2", Value.get(1743)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1744', 1744, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1744")), 
			new Bin("bn2", Value.get(1744)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1745', 1745, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1745")), 
			new Bin("bn2", Value.get(1745)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1746', 1746, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1746")), 
			new Bin("bn2", Value.get(1746)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1747', 1747, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1747")), 
			new Bin("bn2", Value.get(1747)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1748', 1748, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1748")), 
			new Bin("bn2", Value.get(1748)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1749', 1749, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1749")), 
			new Bin("bn2", Value.get(1749)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1750', 1750, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1750")), 
			new Bin("bn2", Value.get(1750)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1751', 1751, '176', 176)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1751")), 
			new Bin("bn2", Value.get(1751)),
			new Bin("bn3", Value.get("176")),
			new Bin("bn4", Value.get(176))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1752', 1752, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1752")), 
			new Bin("bn2", Value.get(1752)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1753', 1753, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1753")), 
			new Bin("bn2", Value.get(1753)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1754', 1754, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1754")), 
			new Bin("bn2", Value.get(1754)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1755', 1755, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1755")), 
			new Bin("bn2", Value.get(1755)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1756', 1756, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1756")), 
			new Bin("bn2", Value.get(1756)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1757', 1757, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1757")), 
			new Bin("bn2", Value.get(1757)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1758', 1758, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1758")), 
			new Bin("bn2", Value.get(1758)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1759', 1759, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1759")), 
			new Bin("bn2", Value.get(1759)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1760', 1760, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1760")), 
			new Bin("bn2", Value.get(1760)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1761', 1761, '177', 177)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1761")), 
			new Bin("bn2", Value.get(1761)),
			new Bin("bn3", Value.get("177")),
			new Bin("bn4", Value.get(177))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1762', 1762, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1762")), 
			new Bin("bn2", Value.get(1762)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1763', 1763, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1763")), 
			new Bin("bn2", Value.get(1763)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1764', 1764, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1764")), 
			new Bin("bn2", Value.get(1764)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1765', 1765, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1765")), 
			new Bin("bn2", Value.get(1765)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1766', 1766, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1766")), 
			new Bin("bn2", Value.get(1766)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1767', 1767, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1767")), 
			new Bin("bn2", Value.get(1767)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1768', 1768, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1768")), 
			new Bin("bn2", Value.get(1768)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1769', 1769, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1769")), 
			new Bin("bn2", Value.get(1769)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1770', 1770, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1770")), 
			new Bin("bn2", Value.get(1770)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1771', 1771, '178', 178)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1771")), 
			new Bin("bn2", Value.get(1771)),
			new Bin("bn3", Value.get("178")),
			new Bin("bn4", Value.get(178))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1772', 1772, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1772")), 
			new Bin("bn2", Value.get(1772)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1773', 1773, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1773")), 
			new Bin("bn2", Value.get(1773)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1774', 1774, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1774")), 
			new Bin("bn2", Value.get(1774)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1775', 1775, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1775")), 
			new Bin("bn2", Value.get(1775)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1776', 1776, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1776")), 
			new Bin("bn2", Value.get(1776)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1777', 1777, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1777")), 
			new Bin("bn2", Value.get(1777)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1778', 1778, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1778")), 
			new Bin("bn2", Value.get(1778)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1779', 1779, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1779")), 
			new Bin("bn2", Value.get(1779)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1780', 1780, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1780")), 
			new Bin("bn2", Value.get(1780)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1781', 1781, '179', 179)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1781")), 
			new Bin("bn2", Value.get(1781)),
			new Bin("bn3", Value.get("179")),
			new Bin("bn4", Value.get(179))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1782', 1782, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1782")), 
			new Bin("bn2", Value.get(1782)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1783', 1783, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1783")), 
			new Bin("bn2", Value.get(1783)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1784', 1784, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1784")), 
			new Bin("bn2", Value.get(1784)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1785', 1785, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1785")), 
			new Bin("bn2", Value.get(1785)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1786', 1786, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1786")), 
			new Bin("bn2", Value.get(1786)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1787', 1787, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1787")), 
			new Bin("bn2", Value.get(1787)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1788', 1788, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1788")), 
			new Bin("bn2", Value.get(1788)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1789', 1789, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1789")), 
			new Bin("bn2", Value.get(1789)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1790', 1790, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1790")), 
			new Bin("bn2", Value.get(1790)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1791', 1791, '180', 180)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1791")), 
			new Bin("bn2", Value.get(1791)),
			new Bin("bn3", Value.get("180")),
			new Bin("bn4", Value.get(180))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1792', 1792, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1792")), 
			new Bin("bn2", Value.get(1792)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1793', 1793, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1793")), 
			new Bin("bn2", Value.get(1793)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1794', 1794, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1794")), 
			new Bin("bn2", Value.get(1794)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1795', 1795, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1795")), 
			new Bin("bn2", Value.get(1795)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1796', 1796, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1796")), 
			new Bin("bn2", Value.get(1796)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1797', 1797, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1797")), 
			new Bin("bn2", Value.get(1797)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1798', 1798, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1798")), 
			new Bin("bn2", Value.get(1798)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1799', 1799, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1799")), 
			new Bin("bn2", Value.get(1799)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1800', 1800, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1800")), 
			new Bin("bn2", Value.get(1800)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1801', 1801, '181', 181)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1801")), 
			new Bin("bn2", Value.get(1801)),
			new Bin("bn3", Value.get("181")),
			new Bin("bn4", Value.get(181))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1802', 1802, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1802")), 
			new Bin("bn2", Value.get(1802)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1803', 1803, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1803")), 
			new Bin("bn2", Value.get(1803)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1804', 1804, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1804")), 
			new Bin("bn2", Value.get(1804)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1805', 1805, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1805")), 
			new Bin("bn2", Value.get(1805)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1806', 1806, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1806")), 
			new Bin("bn2", Value.get(1806)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1807', 1807, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1807")), 
			new Bin("bn2", Value.get(1807)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1808', 1808, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1808")), 
			new Bin("bn2", Value.get(1808)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1809', 1809, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1809")), 
			new Bin("bn2", Value.get(1809)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1810', 1810, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1810")), 
			new Bin("bn2", Value.get(1810)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1811', 1811, '182', 182)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1811")), 
			new Bin("bn2", Value.get(1811)),
			new Bin("bn3", Value.get("182")),
			new Bin("bn4", Value.get(182))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1812', 1812, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1812")), 
			new Bin("bn2", Value.get(1812)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1813', 1813, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1813")), 
			new Bin("bn2", Value.get(1813)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1814', 1814, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1814")), 
			new Bin("bn2", Value.get(1814)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1815', 1815, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1815")), 
			new Bin("bn2", Value.get(1815)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1816', 1816, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1816")), 
			new Bin("bn2", Value.get(1816)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1817', 1817, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1817")), 
			new Bin("bn2", Value.get(1817)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1818', 1818, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1818")), 
			new Bin("bn2", Value.get(1818)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1819', 1819, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1819")), 
			new Bin("bn2", Value.get(1819)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1820', 1820, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1820")), 
			new Bin("bn2", Value.get(1820)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1821', 1821, '183', 183)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1821")), 
			new Bin("bn2", Value.get(1821)),
			new Bin("bn3", Value.get("183")),
			new Bin("bn4", Value.get(183))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1822', 1822, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1822")), 
			new Bin("bn2", Value.get(1822)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1823', 1823, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1823")), 
			new Bin("bn2", Value.get(1823)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1824', 1824, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1824")), 
			new Bin("bn2", Value.get(1824)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1825', 1825, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1825")), 
			new Bin("bn2", Value.get(1825)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1826', 1826, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1826")), 
			new Bin("bn2", Value.get(1826)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1827', 1827, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1827")), 
			new Bin("bn2", Value.get(1827)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1828', 1828, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1828")), 
			new Bin("bn2", Value.get(1828)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1829', 1829, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1829")), 
			new Bin("bn2", Value.get(1829)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1830', 1830, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1830")), 
			new Bin("bn2", Value.get(1830)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1831', 1831, '184', 184)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1831")), 
			new Bin("bn2", Value.get(1831)),
			new Bin("bn3", Value.get("184")),
			new Bin("bn4", Value.get(184))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1832', 1832, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1832")), 
			new Bin("bn2", Value.get(1832)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1833', 1833, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1833")), 
			new Bin("bn2", Value.get(1833)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1834', 1834, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1834")), 
			new Bin("bn2", Value.get(1834)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1835', 1835, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1835")), 
			new Bin("bn2", Value.get(1835)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1836', 1836, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1836")), 
			new Bin("bn2", Value.get(1836)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1837', 1837, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1837")), 
			new Bin("bn2", Value.get(1837)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1838', 1838, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1838")), 
			new Bin("bn2", Value.get(1838)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1839', 1839, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1839")), 
			new Bin("bn2", Value.get(1839)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1840', 1840, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1840")), 
			new Bin("bn2", Value.get(1840)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1841', 1841, '185', 185)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1841")), 
			new Bin("bn2", Value.get(1841)),
			new Bin("bn3", Value.get("185")),
			new Bin("bn4", Value.get(185))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1842', 1842, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1842")), 
			new Bin("bn2", Value.get(1842)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1843', 1843, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1843")), 
			new Bin("bn2", Value.get(1843)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1844', 1844, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1844")), 
			new Bin("bn2", Value.get(1844)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1845', 1845, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1845")), 
			new Bin("bn2", Value.get(1845)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1846', 1846, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1846")), 
			new Bin("bn2", Value.get(1846)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1847', 1847, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1847")), 
			new Bin("bn2", Value.get(1847)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1848', 1848, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1848")), 
			new Bin("bn2", Value.get(1848)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1849', 1849, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1849")), 
			new Bin("bn2", Value.get(1849)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1850', 1850, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1850")), 
			new Bin("bn2", Value.get(1850)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1851', 1851, '186', 186)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1851")), 
			new Bin("bn2", Value.get(1851)),
			new Bin("bn3", Value.get("186")),
			new Bin("bn4", Value.get(186))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1852', 1852, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1852")), 
			new Bin("bn2", Value.get(1852)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1853', 1853, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1853")), 
			new Bin("bn2", Value.get(1853)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1854', 1854, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1854")), 
			new Bin("bn2", Value.get(1854)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1855', 1855, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1855")), 
			new Bin("bn2", Value.get(1855)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1856', 1856, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1856")), 
			new Bin("bn2", Value.get(1856)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1857', 1857, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1857")), 
			new Bin("bn2", Value.get(1857)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1858', 1858, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1858")), 
			new Bin("bn2", Value.get(1858)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1859', 1859, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1859")), 
			new Bin("bn2", Value.get(1859)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1860', 1860, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1860")), 
			new Bin("bn2", Value.get(1860)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1861', 1861, '187', 187)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1861")), 
			new Bin("bn2", Value.get(1861)),
			new Bin("bn3", Value.get("187")),
			new Bin("bn4", Value.get(187))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1862', 1862, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1862")), 
			new Bin("bn2", Value.get(1862)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1863', 1863, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1863")), 
			new Bin("bn2", Value.get(1863)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1864', 1864, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1864")), 
			new Bin("bn2", Value.get(1864)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1865', 1865, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1865")), 
			new Bin("bn2", Value.get(1865)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1866', 1866, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1866")), 
			new Bin("bn2", Value.get(1866)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1867', 1867, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1867")), 
			new Bin("bn2", Value.get(1867)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1868', 1868, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1868")), 
			new Bin("bn2", Value.get(1868)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1869', 1869, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1869")), 
			new Bin("bn2", Value.get(1869)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1870', 1870, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1870")), 
			new Bin("bn2", Value.get(1870)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1871', 1871, '188', 188)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1871")), 
			new Bin("bn2", Value.get(1871)),
			new Bin("bn3", Value.get("188")),
			new Bin("bn4", Value.get(188))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1872', 1872, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1872")), 
			new Bin("bn2", Value.get(1872)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1873', 1873, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1873")), 
			new Bin("bn2", Value.get(1873)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1874', 1874, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1874")), 
			new Bin("bn2", Value.get(1874)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1875', 1875, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1875")), 
			new Bin("bn2", Value.get(1875)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1876', 1876, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1876")), 
			new Bin("bn2", Value.get(1876)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1877', 1877, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1877")), 
			new Bin("bn2", Value.get(1877)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1878', 1878, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1878")), 
			new Bin("bn2", Value.get(1878)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1879', 1879, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1879")), 
			new Bin("bn2", Value.get(1879)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1880', 1880, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1880")), 
			new Bin("bn2", Value.get(1880)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1881', 1881, '189', 189)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1881")), 
			new Bin("bn2", Value.get(1881)),
			new Bin("bn3", Value.get("189")),
			new Bin("bn4", Value.get(189))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1882', 1882, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1882")), 
			new Bin("bn2", Value.get(1882)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1883', 1883, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1883")), 
			new Bin("bn2", Value.get(1883)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1884', 1884, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1884")), 
			new Bin("bn2", Value.get(1884)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1885', 1885, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1885")), 
			new Bin("bn2", Value.get(1885)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1886', 1886, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1886")), 
			new Bin("bn2", Value.get(1886)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1887', 1887, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1887")), 
			new Bin("bn2", Value.get(1887)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1888', 1888, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1888")), 
			new Bin("bn2", Value.get(1888)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1889', 1889, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1889")), 
			new Bin("bn2", Value.get(1889)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1890', 1890, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1890")), 
			new Bin("bn2", Value.get(1890)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1891', 1891, '190', 190)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1891")), 
			new Bin("bn2", Value.get(1891)),
			new Bin("bn3", Value.get("190")),
			new Bin("bn4", Value.get(190))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1892', 1892, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1892")), 
			new Bin("bn2", Value.get(1892)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1893', 1893, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1893")), 
			new Bin("bn2", Value.get(1893)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1894', 1894, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1894")), 
			new Bin("bn2", Value.get(1894)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1895', 1895, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1895")), 
			new Bin("bn2", Value.get(1895)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1896', 1896, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1896")), 
			new Bin("bn2", Value.get(1896)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1897', 1897, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1897")), 
			new Bin("bn2", Value.get(1897)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1898', 1898, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1898")), 
			new Bin("bn2", Value.get(1898)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1899', 1899, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1899")), 
			new Bin("bn2", Value.get(1899)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1900', 1900, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1900")), 
			new Bin("bn2", Value.get(1900)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1901', 1901, '191', 191)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1901")), 
			new Bin("bn2", Value.get(1901)),
			new Bin("bn3", Value.get("191")),
			new Bin("bn4", Value.get(191))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1902', 1902, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1902")), 
			new Bin("bn2", Value.get(1902)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1903', 1903, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1903")), 
			new Bin("bn2", Value.get(1903)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1904', 1904, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1904")), 
			new Bin("bn2", Value.get(1904)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1905', 1905, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1905")), 
			new Bin("bn2", Value.get(1905)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1906', 1906, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1906")), 
			new Bin("bn2", Value.get(1906)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1907', 1907, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1907")), 
			new Bin("bn2", Value.get(1907)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1908', 1908, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1908")), 
			new Bin("bn2", Value.get(1908)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1909', 1909, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1909")), 
			new Bin("bn2", Value.get(1909)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1910', 1910, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1910")), 
			new Bin("bn2", Value.get(1910)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1911', 1911, '192', 192)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1911")), 
			new Bin("bn2", Value.get(1911)),
			new Bin("bn3", Value.get("192")),
			new Bin("bn4", Value.get(192))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1912', 1912, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1912")), 
			new Bin("bn2", Value.get(1912)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1913', 1913, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1913")), 
			new Bin("bn2", Value.get(1913)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1914', 1914, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1914")), 
			new Bin("bn2", Value.get(1914)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1915', 1915, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1915")), 
			new Bin("bn2", Value.get(1915)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1916', 1916, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1916")), 
			new Bin("bn2", Value.get(1916)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1917', 1917, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1917")), 
			new Bin("bn2", Value.get(1917)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1918', 1918, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1918")), 
			new Bin("bn2", Value.get(1918)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1919', 1919, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1919")), 
			new Bin("bn2", Value.get(1919)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1920', 1920, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1920")), 
			new Bin("bn2", Value.get(1920)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1921', 1921, '193', 193)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1921")), 
			new Bin("bn2", Value.get(1921)),
			new Bin("bn3", Value.get("193")),
			new Bin("bn4", Value.get(193))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1922', 1922, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1922")), 
			new Bin("bn2", Value.get(1922)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1923', 1923, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1923")), 
			new Bin("bn2", Value.get(1923)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1924', 1924, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1924")), 
			new Bin("bn2", Value.get(1924)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1925', 1925, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1925")), 
			new Bin("bn2", Value.get(1925)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1926', 1926, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1926")), 
			new Bin("bn2", Value.get(1926)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1927', 1927, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1927")), 
			new Bin("bn2", Value.get(1927)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1928', 1928, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1928")), 
			new Bin("bn2", Value.get(1928)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1929', 1929, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1929")), 
			new Bin("bn2", Value.get(1929)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1930', 1930, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1930")), 
			new Bin("bn2", Value.get(1930)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1931', 1931, '194', 194)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1931")), 
			new Bin("bn2", Value.get(1931)),
			new Bin("bn3", Value.get("194")),
			new Bin("bn4", Value.get(194))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1932', 1932, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1932")), 
			new Bin("bn2", Value.get(1932)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1933', 1933, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1933")), 
			new Bin("bn2", Value.get(1933)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1934', 1934, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1934")), 
			new Bin("bn2", Value.get(1934)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1935', 1935, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1935")), 
			new Bin("bn2", Value.get(1935)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1936', 1936, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1936")), 
			new Bin("bn2", Value.get(1936)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1937', 1937, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1937")), 
			new Bin("bn2", Value.get(1937)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1938', 1938, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1938")), 
			new Bin("bn2", Value.get(1938)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1939', 1939, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1939")), 
			new Bin("bn2", Value.get(1939)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1940', 1940, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1940")), 
			new Bin("bn2", Value.get(1940)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1941', 1941, '195', 195)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1941")), 
			new Bin("bn2", Value.get(1941)),
			new Bin("bn3", Value.get("195")),
			new Bin("bn4", Value.get(195))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1942', 1942, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1942")), 
			new Bin("bn2", Value.get(1942)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1943', 1943, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1943")), 
			new Bin("bn2", Value.get(1943)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1944', 1944, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1944")), 
			new Bin("bn2", Value.get(1944)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1945', 1945, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1945")), 
			new Bin("bn2", Value.get(1945)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1946', 1946, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1946")), 
			new Bin("bn2", Value.get(1946)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1947', 1947, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1947")), 
			new Bin("bn2", Value.get(1947)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1948', 1948, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1948")), 
			new Bin("bn2", Value.get(1948)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1949', 1949, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1949")), 
			new Bin("bn2", Value.get(1949)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1950', 1950, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1950")), 
			new Bin("bn2", Value.get(1950)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1951', 1951, '196', 196)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1951")), 
			new Bin("bn2", Value.get(1951)),
			new Bin("bn3", Value.get("196")),
			new Bin("bn4", Value.get(196))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1952', 1952, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1952")), 
			new Bin("bn2", Value.get(1952)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1953', 1953, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1953")), 
			new Bin("bn2", Value.get(1953)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1954', 1954, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1954")), 
			new Bin("bn2", Value.get(1954)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1955', 1955, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1955")), 
			new Bin("bn2", Value.get(1955)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1956', 1956, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1956")), 
			new Bin("bn2", Value.get(1956)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1957', 1957, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1957")), 
			new Bin("bn2", Value.get(1957)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1958', 1958, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1958")), 
			new Bin("bn2", Value.get(1958)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1959', 1959, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1959")), 
			new Bin("bn2", Value.get(1959)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1960', 1960, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1960")), 
			new Bin("bn2", Value.get(1960)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1961', 1961, '197', 197)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1961")), 
			new Bin("bn2", Value.get(1961)),
			new Bin("bn3", Value.get("197")),
			new Bin("bn4", Value.get(197))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1962', 1962, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1962")), 
			new Bin("bn2", Value.get(1962)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1963', 1963, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1963")), 
			new Bin("bn2", Value.get(1963)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1964', 1964, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1964")), 
			new Bin("bn2", Value.get(1964)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1965', 1965, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1965")), 
			new Bin("bn2", Value.get(1965)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1966', 1966, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1966")), 
			new Bin("bn2", Value.get(1966)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1967', 1967, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1967")), 
			new Bin("bn2", Value.get(1967)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1968', 1968, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1968")), 
			new Bin("bn2", Value.get(1968)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1969', 1969, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1969")), 
			new Bin("bn2", Value.get(1969)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1970', 1970, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1970")), 
			new Bin("bn2", Value.get(1970)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1971', 1971, '198', 198)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1971")), 
			new Bin("bn2", Value.get(1971)),
			new Bin("bn3", Value.get("198")),
			new Bin("bn4", Value.get(198))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1972', 1972, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1972")), 
			new Bin("bn2", Value.get(1972)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1973', 1973, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1973")), 
			new Bin("bn2", Value.get(1973)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1974', 1974, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1974")), 
			new Bin("bn2", Value.get(1974)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1975', 1975, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1975")), 
			new Bin("bn2", Value.get(1975)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1976', 1976, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1976")), 
			new Bin("bn2", Value.get(1976)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1977', 1977, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1977")), 
			new Bin("bn2", Value.get(1977)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1978', 1978, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1978")), 
			new Bin("bn2", Value.get(1978)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1979', 1979, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1979")), 
			new Bin("bn2", Value.get(1979)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1980', 1980, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1980")), 
			new Bin("bn2", Value.get(1980)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1981', 1981, '199', 199)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1981")), 
			new Bin("bn2", Value.get(1981)),
			new Bin("bn3", Value.get("199")),
			new Bin("bn4", Value.get(199))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1982', 1982, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1982")), 
			new Bin("bn2", Value.get(1982)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1983', 1983, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1983")), 
			new Bin("bn2", Value.get(1983)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1984', 1984, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1984")), 
			new Bin("bn2", Value.get(1984)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1985', 1985, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1985")), 
			new Bin("bn2", Value.get(1985)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1986', 1986, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1986")), 
			new Bin("bn2", Value.get(1986)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1987', 1987, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1987")), 
			new Bin("bn2", Value.get(1987)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1988', 1988, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1988")), 
			new Bin("bn2", Value.get(1988)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1989', 1989, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1989")), 
			new Bin("bn2", Value.get(1989)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1990', 1990, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1990")), 
			new Bin("bn2", Value.get(1990)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1991', 1991, '200', 200)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1991")), 
			new Bin("bn2", Value.get(1991)),
			new Bin("bn3", Value.get("200")),
			new Bin("bn4", Value.get(200))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1992', 1992, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1992")), 
			new Bin("bn2", Value.get(1992)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1993', 1993, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1993")), 
			new Bin("bn2", Value.get(1993)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1994', 1994, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1994")), 
			new Bin("bn2", Value.get(1994)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1995', 1995, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1995")), 
			new Bin("bn2", Value.get(1995)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1996', 1996, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1996")), 
			new Bin("bn2", Value.get(1996)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1997', 1997, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1997")), 
			new Bin("bn2", Value.get(1997)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1998', 1998, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1998")), 
			new Bin("bn2", Value.get(1998)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1999', 1999, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("1999")), 
			new Bin("bn2", Value.get(1999)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2000', 2000, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2000")), 
			new Bin("bn2", Value.get(2000)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2001', 2001, '201', 201)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2001")), 
			new Bin("bn2", Value.get(2001)),
			new Bin("bn3", Value.get("201")),
			new Bin("bn4", Value.get(201))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2002', 2002, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2002")), 
			new Bin("bn2", Value.get(2002)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2003', 2003, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2003")), 
			new Bin("bn2", Value.get(2003)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2004', 2004, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2004")), 
			new Bin("bn2", Value.get(2004)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2005', 2005, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2005")), 
			new Bin("bn2", Value.get(2005)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2006', 2006, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2006")), 
			new Bin("bn2", Value.get(2006)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2007', 2007, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2007")), 
			new Bin("bn2", Value.get(2007)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2008', 2008, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2008")), 
			new Bin("bn2", Value.get(2008)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2009', 2009, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2009")), 
			new Bin("bn2", Value.get(2009)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2010', 2010, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2010")), 
			new Bin("bn2", Value.get(2010)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2011', 2011, '202', 202)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2011")), 
			new Bin("bn2", Value.get(2011)),
			new Bin("bn3", Value.get("202")),
			new Bin("bn4", Value.get(202))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2012', 2012, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2012")), 
			new Bin("bn2", Value.get(2012)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2013', 2013, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2013")), 
			new Bin("bn2", Value.get(2013)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2014', 2014, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2014")), 
			new Bin("bn2", Value.get(2014)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2015', 2015, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2015")), 
			new Bin("bn2", Value.get(2015)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2016', 2016, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2016")), 
			new Bin("bn2", Value.get(2016)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2017', 2017, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2017")), 
			new Bin("bn2", Value.get(2017)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2018', 2018, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2018")), 
			new Bin("bn2", Value.get(2018)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2019', 2019, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2019")), 
			new Bin("bn2", Value.get(2019)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2020', 2020, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2020")), 
			new Bin("bn2", Value.get(2020)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2021', 2021, '203', 203)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2021")), 
			new Bin("bn2", Value.get(2021)),
			new Bin("bn3", Value.get("203")),
			new Bin("bn4", Value.get(203))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2022', 2022, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2022")), 
			new Bin("bn2", Value.get(2022)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2023', 2023, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2023")), 
			new Bin("bn2", Value.get(2023)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2024', 2024, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2024")), 
			new Bin("bn2", Value.get(2024)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2025', 2025, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2025")), 
			new Bin("bn2", Value.get(2025)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2026', 2026, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2026")), 
			new Bin("bn2", Value.get(2026)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2027', 2027, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2027")), 
			new Bin("bn2", Value.get(2027)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2028', 2028, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2028")), 
			new Bin("bn2", Value.get(2028)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2029', 2029, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2029")), 
			new Bin("bn2", Value.get(2029)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2030', 2030, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2030")), 
			new Bin("bn2", Value.get(2030)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2031', 2031, '204', 204)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2031")), 
			new Bin("bn2", Value.get(2031)),
			new Bin("bn3", Value.get("204")),
			new Bin("bn4", Value.get(204))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2032', 2032, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2032")), 
			new Bin("bn2", Value.get(2032)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2033', 2033, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2033")), 
			new Bin("bn2", Value.get(2033)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2034', 2034, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2034")), 
			new Bin("bn2", Value.get(2034)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2035', 2035, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2035")), 
			new Bin("bn2", Value.get(2035)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2036', 2036, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2036")), 
			new Bin("bn2", Value.get(2036)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2037', 2037, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2037")), 
			new Bin("bn2", Value.get(2037)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2038', 2038, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2038")), 
			new Bin("bn2", Value.get(2038)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2039', 2039, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2039")), 
			new Bin("bn2", Value.get(2039)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2040', 2040, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2040")), 
			new Bin("bn2", Value.get(2040)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2041', 2041, '205', 205)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2041")), 
			new Bin("bn2", Value.get(2041)),
			new Bin("bn3", Value.get("205")),
			new Bin("bn4", Value.get(205))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2042', 2042, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2042")), 
			new Bin("bn2", Value.get(2042)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2043', 2043, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2043")), 
			new Bin("bn2", Value.get(2043)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2044', 2044, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2044")), 
			new Bin("bn2", Value.get(2044)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2045', 2045, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2045")), 
			new Bin("bn2", Value.get(2045)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2046', 2046, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2046")), 
			new Bin("bn2", Value.get(2046)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2047', 2047, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2047")), 
			new Bin("bn2", Value.get(2047)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2048', 2048, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2048")), 
			new Bin("bn2", Value.get(2048)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2049', 2049, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2049")), 
			new Bin("bn2", Value.get(2049)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2050', 2050, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2050")), 
			new Bin("bn2", Value.get(2050)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2051', 2051, '206', 206)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2051")), 
			new Bin("bn2", Value.get(2051)),
			new Bin("bn3", Value.get("206")),
			new Bin("bn4", Value.get(206))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2052', 2052, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2052")), 
			new Bin("bn2", Value.get(2052)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2053', 2053, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2053")), 
			new Bin("bn2", Value.get(2053)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2054', 2054, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2054")), 
			new Bin("bn2", Value.get(2054)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2055', 2055, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2055")), 
			new Bin("bn2", Value.get(2055)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2056', 2056, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2056")), 
			new Bin("bn2", Value.get(2056)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2057', 2057, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2057")), 
			new Bin("bn2", Value.get(2057)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2058', 2058, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2058")), 
			new Bin("bn2", Value.get(2058)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2059', 2059, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2059")), 
			new Bin("bn2", Value.get(2059)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2060', 2060, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2060")), 
			new Bin("bn2", Value.get(2060)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2061', 2061, '207', 207)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2061")), 
			new Bin("bn2", Value.get(2061)),
			new Bin("bn3", Value.get("207")),
			new Bin("bn4", Value.get(207))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2062', 2062, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2062")), 
			new Bin("bn2", Value.get(2062)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2063', 2063, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2063")), 
			new Bin("bn2", Value.get(2063)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2064', 2064, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2064")), 
			new Bin("bn2", Value.get(2064)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2065', 2065, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2065")), 
			new Bin("bn2", Value.get(2065)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2066', 2066, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2066")), 
			new Bin("bn2", Value.get(2066)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2067', 2067, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2067")), 
			new Bin("bn2", Value.get(2067)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2068', 2068, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2068")), 
			new Bin("bn2", Value.get(2068)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2069', 2069, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2069")), 
			new Bin("bn2", Value.get(2069)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2070', 2070, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2070")), 
			new Bin("bn2", Value.get(2070)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2071', 2071, '208', 208)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2071")), 
			new Bin("bn2", Value.get(2071)),
			new Bin("bn3", Value.get("208")),
			new Bin("bn4", Value.get(208))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2072', 2072, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2072")), 
			new Bin("bn2", Value.get(2072)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2073', 2073, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2073")), 
			new Bin("bn2", Value.get(2073)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2074', 2074, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2074")), 
			new Bin("bn2", Value.get(2074)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2075', 2075, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2075")), 
			new Bin("bn2", Value.get(2075)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2076', 2076, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2076")), 
			new Bin("bn2", Value.get(2076)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2077', 2077, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2077")), 
			new Bin("bn2", Value.get(2077)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2078', 2078, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2078")), 
			new Bin("bn2", Value.get(2078)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2079', 2079, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2079")), 
			new Bin("bn2", Value.get(2079)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2080', 2080, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2080")), 
			new Bin("bn2", Value.get(2080)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2081', 2081, '209', 209)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2081")), 
			new Bin("bn2", Value.get(2081)),
			new Bin("bn3", Value.get("209")),
			new Bin("bn4", Value.get(209))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2082', 2082, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2082")), 
			new Bin("bn2", Value.get(2082)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2083', 2083, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2083")), 
			new Bin("bn2", Value.get(2083)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2084', 2084, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2084")), 
			new Bin("bn2", Value.get(2084)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2085', 2085, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2085")), 
			new Bin("bn2", Value.get(2085)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2086', 2086, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2086")), 
			new Bin("bn2", Value.get(2086)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2087', 2087, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2087")), 
			new Bin("bn2", Value.get(2087)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2088', 2088, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2088")), 
			new Bin("bn2", Value.get(2088)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2089', 2089, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2089")), 
			new Bin("bn2", Value.get(2089)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2090', 2090, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2090")), 
			new Bin("bn2", Value.get(2090)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2091', 2091, '210', 210)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2091")), 
			new Bin("bn2", Value.get(2091)),
			new Bin("bn3", Value.get("210")),
			new Bin("bn4", Value.get(210))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2092', 2092, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2092")), 
			new Bin("bn2", Value.get(2092)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2093', 2093, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2093")), 
			new Bin("bn2", Value.get(2093)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2094', 2094, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2094")), 
			new Bin("bn2", Value.get(2094)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2095', 2095, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2095")), 
			new Bin("bn2", Value.get(2095)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2096', 2096, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2096")), 
			new Bin("bn2", Value.get(2096)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2097', 2097, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2097")), 
			new Bin("bn2", Value.get(2097)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2098', 2098, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2098")), 
			new Bin("bn2", Value.get(2098)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2099', 2099, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2099")), 
			new Bin("bn2", Value.get(2099)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2100', 2100, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2100")), 
			new Bin("bn2", Value.get(2100)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2101', 2101, '211', 211)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2101")), 
			new Bin("bn2", Value.get(2101)),
			new Bin("bn3", Value.get("211")),
			new Bin("bn4", Value.get(211))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2102', 2102, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2102")), 
			new Bin("bn2", Value.get(2102)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2103', 2103, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2103")), 
			new Bin("bn2", Value.get(2103)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2104', 2104, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2104")), 
			new Bin("bn2", Value.get(2104)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2105', 2105, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2105")), 
			new Bin("bn2", Value.get(2105)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2106', 2106, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2106")), 
			new Bin("bn2", Value.get(2106)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2107', 2107, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2107")), 
			new Bin("bn2", Value.get(2107)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2108', 2108, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2108")), 
			new Bin("bn2", Value.get(2108)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2109', 2109, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2109")), 
			new Bin("bn2", Value.get(2109)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2110', 2110, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2110")), 
			new Bin("bn2", Value.get(2110)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2111', 2111, '212', 212)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2111")), 
			new Bin("bn2", Value.get(2111)),
			new Bin("bn3", Value.get("212")),
			new Bin("bn4", Value.get(212))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2112', 2112, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2112")), 
			new Bin("bn2", Value.get(2112)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2113', 2113, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2113")), 
			new Bin("bn2", Value.get(2113)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2114', 2114, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2114")), 
			new Bin("bn2", Value.get(2114)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2115', 2115, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2115")), 
			new Bin("bn2", Value.get(2115)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2116', 2116, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2116")), 
			new Bin("bn2", Value.get(2116)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2117', 2117, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2117")), 
			new Bin("bn2", Value.get(2117)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2118', 2118, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2118")), 
			new Bin("bn2", Value.get(2118)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2119', 2119, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2119")), 
			new Bin("bn2", Value.get(2119)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2120', 2120, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2120")), 
			new Bin("bn2", Value.get(2120)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2121', 2121, '213', 213)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2121")), 
			new Bin("bn2", Value.get(2121)),
			new Bin("bn3", Value.get("213")),
			new Bin("bn4", Value.get(213))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2122', 2122, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2122")), 
			new Bin("bn2", Value.get(2122)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2123', 2123, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2123")), 
			new Bin("bn2", Value.get(2123)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2124', 2124, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2124")), 
			new Bin("bn2", Value.get(2124)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2125', 2125, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2125")), 
			new Bin("bn2", Value.get(2125)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2126', 2126, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2126")), 
			new Bin("bn2", Value.get(2126)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2127', 2127, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2127")), 
			new Bin("bn2", Value.get(2127)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2128', 2128, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2128")), 
			new Bin("bn2", Value.get(2128)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2129', 2129, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2129")), 
			new Bin("bn2", Value.get(2129)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2130', 2130, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2130")), 
			new Bin("bn2", Value.get(2130)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2131', 2131, '214', 214)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2131")), 
			new Bin("bn2", Value.get(2131)),
			new Bin("bn3", Value.get("214")),
			new Bin("bn4", Value.get(214))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2132', 2132, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2132")), 
			new Bin("bn2", Value.get(2132)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2133', 2133, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2133")), 
			new Bin("bn2", Value.get(2133)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2134', 2134, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2134")), 
			new Bin("bn2", Value.get(2134)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2135', 2135, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2135")), 
			new Bin("bn2", Value.get(2135)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2136', 2136, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2136")), 
			new Bin("bn2", Value.get(2136)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2137', 2137, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2137")), 
			new Bin("bn2", Value.get(2137)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2138', 2138, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2138")), 
			new Bin("bn2", Value.get(2138)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2139', 2139, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2139")), 
			new Bin("bn2", Value.get(2139)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2140', 2140, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2140")), 
			new Bin("bn2", Value.get(2140)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2141', 2141, '215', 215)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2141")), 
			new Bin("bn2", Value.get(2141)),
			new Bin("bn3", Value.get("215")),
			new Bin("bn4", Value.get(215))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2142', 2142, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2142")), 
			new Bin("bn2", Value.get(2142)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2143', 2143, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2143")), 
			new Bin("bn2", Value.get(2143)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2144', 2144, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2144")), 
			new Bin("bn2", Value.get(2144)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2145', 2145, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2145")), 
			new Bin("bn2", Value.get(2145)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2146', 2146, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2146")), 
			new Bin("bn2", Value.get(2146)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2147', 2147, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2147")), 
			new Bin("bn2", Value.get(2147)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2148', 2148, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2148")), 
			new Bin("bn2", Value.get(2148)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2149', 2149, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2149")), 
			new Bin("bn2", Value.get(2149)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2150', 2150, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2150")), 
			new Bin("bn2", Value.get(2150)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2151', 2151, '216', 216)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2151")), 
			new Bin("bn2", Value.get(2151)),
			new Bin("bn3", Value.get("216")),
			new Bin("bn4", Value.get(216))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2152', 2152, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2152")), 
			new Bin("bn2", Value.get(2152)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2153', 2153, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2153")), 
			new Bin("bn2", Value.get(2153)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2154', 2154, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2154")), 
			new Bin("bn2", Value.get(2154)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2155', 2155, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2155")), 
			new Bin("bn2", Value.get(2155)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2156', 2156, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2156")), 
			new Bin("bn2", Value.get(2156)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2157', 2157, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2157")), 
			new Bin("bn2", Value.get(2157)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2158', 2158, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2158")), 
			new Bin("bn2", Value.get(2158)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2159', 2159, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2159")), 
			new Bin("bn2", Value.get(2159)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2160', 2160, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2160")), 
			new Bin("bn2", Value.get(2160)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2161', 2161, '217', 217)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2161")), 
			new Bin("bn2", Value.get(2161)),
			new Bin("bn3", Value.get("217")),
			new Bin("bn4", Value.get(217))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2162', 2162, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2162")), 
			new Bin("bn2", Value.get(2162)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2163', 2163, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2163")), 
			new Bin("bn2", Value.get(2163)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2164', 2164, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2164")), 
			new Bin("bn2", Value.get(2164)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2165', 2165, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2165")), 
			new Bin("bn2", Value.get(2165)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2166', 2166, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2166")), 
			new Bin("bn2", Value.get(2166)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2167', 2167, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2167")), 
			new Bin("bn2", Value.get(2167)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2168', 2168, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2168")), 
			new Bin("bn2", Value.get(2168)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2169', 2169, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2169")), 
			new Bin("bn2", Value.get(2169)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2170', 2170, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2170")), 
			new Bin("bn2", Value.get(2170)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2171', 2171, '218', 218)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2171")), 
			new Bin("bn2", Value.get(2171)),
			new Bin("bn3", Value.get("218")),
			new Bin("bn4", Value.get(218))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2172', 2172, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2172")), 
			new Bin("bn2", Value.get(2172)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2173', 2173, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2173")), 
			new Bin("bn2", Value.get(2173)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2174', 2174, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2174")), 
			new Bin("bn2", Value.get(2174)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2175', 2175, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2175")), 
			new Bin("bn2", Value.get(2175)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2176', 2176, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2176")), 
			new Bin("bn2", Value.get(2176)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2177', 2177, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2177")), 
			new Bin("bn2", Value.get(2177)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2178', 2178, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2178")), 
			new Bin("bn2", Value.get(2178)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2179', 2179, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2179")), 
			new Bin("bn2", Value.get(2179)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2180', 2180, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2180")), 
			new Bin("bn2", Value.get(2180)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2181', 2181, '219', 219)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2181")), 
			new Bin("bn2", Value.get(2181)),
			new Bin("bn3", Value.get("219")),
			new Bin("bn4", Value.get(219))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2182', 2182, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2182")), 
			new Bin("bn2", Value.get(2182)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2183', 2183, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2183")), 
			new Bin("bn2", Value.get(2183)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2184', 2184, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2184")), 
			new Bin("bn2", Value.get(2184)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2185', 2185, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2185")), 
			new Bin("bn2", Value.get(2185)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2186', 2186, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2186")), 
			new Bin("bn2", Value.get(2186)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2187', 2187, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2187")), 
			new Bin("bn2", Value.get(2187)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2188', 2188, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2188")), 
			new Bin("bn2", Value.get(2188)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2189', 2189, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2189")), 
			new Bin("bn2", Value.get(2189)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2190', 2190, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2190")), 
			new Bin("bn2", Value.get(2190)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2191', 2191, '220', 220)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2191")), 
			new Bin("bn2", Value.get(2191)),
			new Bin("bn3", Value.get("220")),
			new Bin("bn4", Value.get(220))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2192', 2192, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2192")), 
			new Bin("bn2", Value.get(2192)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2193', 2193, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2193")), 
			new Bin("bn2", Value.get(2193)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2194', 2194, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2194")), 
			new Bin("bn2", Value.get(2194)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2195', 2195, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2195")), 
			new Bin("bn2", Value.get(2195)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2196', 2196, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2196")), 
			new Bin("bn2", Value.get(2196)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2197', 2197, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2197")), 
			new Bin("bn2", Value.get(2197)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2198', 2198, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2198")), 
			new Bin("bn2", Value.get(2198)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2199', 2199, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2199")), 
			new Bin("bn2", Value.get(2199)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2200', 2200, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2200")), 
			new Bin("bn2", Value.get(2200)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2201', 2201, '221', 221)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2201")), 
			new Bin("bn2", Value.get(2201)),
			new Bin("bn3", Value.get("221")),
			new Bin("bn4", Value.get(221))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2202', 2202, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2202")), 
			new Bin("bn2", Value.get(2202)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2203', 2203, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2203")), 
			new Bin("bn2", Value.get(2203)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2204', 2204, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2204")), 
			new Bin("bn2", Value.get(2204)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2205', 2205, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2205")), 
			new Bin("bn2", Value.get(2205)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2206', 2206, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2206")), 
			new Bin("bn2", Value.get(2206)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2207', 2207, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2207")), 
			new Bin("bn2", Value.get(2207)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2208', 2208, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2208")), 
			new Bin("bn2", Value.get(2208)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2209', 2209, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2209")), 
			new Bin("bn2", Value.get(2209)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2210', 2210, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2210")), 
			new Bin("bn2", Value.get(2210)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2211', 2211, '222', 222)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2211")), 
			new Bin("bn2", Value.get(2211)),
			new Bin("bn3", Value.get("222")),
			new Bin("bn4", Value.get(222))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2212', 2212, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2212")), 
			new Bin("bn2", Value.get(2212)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2213', 2213, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2213")), 
			new Bin("bn2", Value.get(2213)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2214', 2214, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2214")), 
			new Bin("bn2", Value.get(2214)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2215', 2215, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2215")), 
			new Bin("bn2", Value.get(2215)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2216', 2216, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2216")), 
			new Bin("bn2", Value.get(2216)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2217', 2217, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2217")), 
			new Bin("bn2", Value.get(2217)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2218', 2218, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2218")), 
			new Bin("bn2", Value.get(2218)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2219', 2219, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2219")), 
			new Bin("bn2", Value.get(2219)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2220', 2220, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2220")), 
			new Bin("bn2", Value.get(2220)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2221', 2221, '223', 223)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2221")), 
			new Bin("bn2", Value.get(2221)),
			new Bin("bn3", Value.get("223")),
			new Bin("bn4", Value.get(223))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2222', 2222, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2222")), 
			new Bin("bn2", Value.get(2222)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2223', 2223, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2223")), 
			new Bin("bn2", Value.get(2223)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2224', 2224, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2224")), 
			new Bin("bn2", Value.get(2224)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2225', 2225, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2225")), 
			new Bin("bn2", Value.get(2225)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2226', 2226, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2226")), 
			new Bin("bn2", Value.get(2226)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2227', 2227, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2227")), 
			new Bin("bn2", Value.get(2227)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2228', 2228, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2228")), 
			new Bin("bn2", Value.get(2228)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2229', 2229, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2229")), 
			new Bin("bn2", Value.get(2229)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2230', 2230, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2230")), 
			new Bin("bn2", Value.get(2230)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2231', 2231, '224', 224)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2231")), 
			new Bin("bn2", Value.get(2231)),
			new Bin("bn3", Value.get("224")),
			new Bin("bn4", Value.get(224))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2232', 2232, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2232")), 
			new Bin("bn2", Value.get(2232)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2233', 2233, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2233")), 
			new Bin("bn2", Value.get(2233)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2234', 2234, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2234")), 
			new Bin("bn2", Value.get(2234)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2235', 2235, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2235")), 
			new Bin("bn2", Value.get(2235)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2236', 2236, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2236")), 
			new Bin("bn2", Value.get(2236)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2237', 2237, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2237")), 
			new Bin("bn2", Value.get(2237)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2238', 2238, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2238")), 
			new Bin("bn2", Value.get(2238)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2239', 2239, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2239")), 
			new Bin("bn2", Value.get(2239)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2240', 2240, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2240")), 
			new Bin("bn2", Value.get(2240)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2241', 2241, '225', 225)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2241")), 
			new Bin("bn2", Value.get(2241)),
			new Bin("bn3", Value.get("225")),
			new Bin("bn4", Value.get(225))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2242', 2242, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2242")), 
			new Bin("bn2", Value.get(2242)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2243', 2243, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2243")), 
			new Bin("bn2", Value.get(2243)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2244', 2244, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2244")), 
			new Bin("bn2", Value.get(2244)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2245', 2245, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2245")), 
			new Bin("bn2", Value.get(2245)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2246', 2246, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2246")), 
			new Bin("bn2", Value.get(2246)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2247', 2247, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2247")), 
			new Bin("bn2", Value.get(2247)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2248', 2248, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2248")), 
			new Bin("bn2", Value.get(2248)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2249', 2249, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2249")), 
			new Bin("bn2", Value.get(2249)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2250', 2250, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2250")), 
			new Bin("bn2", Value.get(2250)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2251', 2251, '226', 226)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2251")), 
			new Bin("bn2", Value.get(2251)),
			new Bin("bn3", Value.get("226")),
			new Bin("bn4", Value.get(226))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2252', 2252, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2252")), 
			new Bin("bn2", Value.get(2252)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2253', 2253, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2253")), 
			new Bin("bn2", Value.get(2253)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2254', 2254, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2254")), 
			new Bin("bn2", Value.get(2254)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2255', 2255, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2255")), 
			new Bin("bn2", Value.get(2255)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2256', 2256, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2256")), 
			new Bin("bn2", Value.get(2256)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2257', 2257, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2257")), 
			new Bin("bn2", Value.get(2257)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2258', 2258, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2258")), 
			new Bin("bn2", Value.get(2258)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2259', 2259, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2259")), 
			new Bin("bn2", Value.get(2259)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2260', 2260, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2260")), 
			new Bin("bn2", Value.get(2260)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2261', 2261, '227', 227)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2261")), 
			new Bin("bn2", Value.get(2261)),
			new Bin("bn3", Value.get("227")),
			new Bin("bn4", Value.get(227))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2262', 2262, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2262")), 
			new Bin("bn2", Value.get(2262)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2263', 2263, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2263")), 
			new Bin("bn2", Value.get(2263)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2264', 2264, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2264")), 
			new Bin("bn2", Value.get(2264)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2265', 2265, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2265")), 
			new Bin("bn2", Value.get(2265)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2266', 2266, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2266")), 
			new Bin("bn2", Value.get(2266)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2267', 2267, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2267")), 
			new Bin("bn2", Value.get(2267)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2268', 2268, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2268")), 
			new Bin("bn2", Value.get(2268)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2269', 2269, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2269")), 
			new Bin("bn2", Value.get(2269)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2270', 2270, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2270")), 
			new Bin("bn2", Value.get(2270)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2271', 2271, '228', 228)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2271")), 
			new Bin("bn2", Value.get(2271)),
			new Bin("bn3", Value.get("228")),
			new Bin("bn4", Value.get(228))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2272', 2272, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2272")), 
			new Bin("bn2", Value.get(2272)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2273', 2273, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2273")), 
			new Bin("bn2", Value.get(2273)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2274', 2274, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2274")), 
			new Bin("bn2", Value.get(2274)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2275', 2275, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2275")), 
			new Bin("bn2", Value.get(2275)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2276', 2276, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2276")), 
			new Bin("bn2", Value.get(2276)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2277', 2277, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2277")), 
			new Bin("bn2", Value.get(2277)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2278', 2278, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2278")), 
			new Bin("bn2", Value.get(2278)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2279', 2279, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2279")), 
			new Bin("bn2", Value.get(2279)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2280', 2280, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2280")), 
			new Bin("bn2", Value.get(2280)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2281', 2281, '229', 229)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2281")), 
			new Bin("bn2", Value.get(2281)),
			new Bin("bn3", Value.get("229")),
			new Bin("bn4", Value.get(229))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2282', 2282, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2282")), 
			new Bin("bn2", Value.get(2282)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2283', 2283, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2283")), 
			new Bin("bn2", Value.get(2283)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2284', 2284, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2284")), 
			new Bin("bn2", Value.get(2284)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2285', 2285, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2285")), 
			new Bin("bn2", Value.get(2285)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2286', 2286, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2286")), 
			new Bin("bn2", Value.get(2286)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2287', 2287, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2287")), 
			new Bin("bn2", Value.get(2287)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2288', 2288, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2288")), 
			new Bin("bn2", Value.get(2288)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2289', 2289, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2289")), 
			new Bin("bn2", Value.get(2289)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2290', 2290, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2290")), 
			new Bin("bn2", Value.get(2290)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2291', 2291, '230', 230)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2291")), 
			new Bin("bn2", Value.get(2291)),
			new Bin("bn3", Value.get("230")),
			new Bin("bn4", Value.get(230))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2292', 2292, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2292")), 
			new Bin("bn2", Value.get(2292)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2293', 2293, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2293")), 
			new Bin("bn2", Value.get(2293)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2294', 2294, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2294")), 
			new Bin("bn2", Value.get(2294)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2295', 2295, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2295")), 
			new Bin("bn2", Value.get(2295)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2296', 2296, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2296")), 
			new Bin("bn2", Value.get(2296)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2297', 2297, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2297")), 
			new Bin("bn2", Value.get(2297)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2298', 2298, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2298")), 
			new Bin("bn2", Value.get(2298)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2299', 2299, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2299")), 
			new Bin("bn2", Value.get(2299)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2300', 2300, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2300")), 
			new Bin("bn2", Value.get(2300)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2301', 2301, '231', 231)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2301")), 
			new Bin("bn2", Value.get(2301)),
			new Bin("bn3", Value.get("231")),
			new Bin("bn4", Value.get(231))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2302', 2302, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2302")), 
			new Bin("bn2", Value.get(2302)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2303', 2303, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2303")), 
			new Bin("bn2", Value.get(2303)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2304', 2304, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2304")), 
			new Bin("bn2", Value.get(2304)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2305', 2305, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2305")), 
			new Bin("bn2", Value.get(2305)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2306', 2306, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2306")), 
			new Bin("bn2", Value.get(2306)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2307', 2307, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2307")), 
			new Bin("bn2", Value.get(2307)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2308', 2308, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2308")), 
			new Bin("bn2", Value.get(2308)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2309', 2309, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2309")), 
			new Bin("bn2", Value.get(2309)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2310', 2310, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2310")), 
			new Bin("bn2", Value.get(2310)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2311', 2311, '232', 232)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2311")), 
			new Bin("bn2", Value.get(2311)),
			new Bin("bn3", Value.get("232")),
			new Bin("bn4", Value.get(232))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2312', 2312, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2312")), 
			new Bin("bn2", Value.get(2312)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2313', 2313, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2313")), 
			new Bin("bn2", Value.get(2313)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2314', 2314, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2314")), 
			new Bin("bn2", Value.get(2314)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2315', 2315, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2315")), 
			new Bin("bn2", Value.get(2315)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2316', 2316, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2316")), 
			new Bin("bn2", Value.get(2316)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2317', 2317, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2317")), 
			new Bin("bn2", Value.get(2317)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2318', 2318, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2318")), 
			new Bin("bn2", Value.get(2318)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2319', 2319, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2319")), 
			new Bin("bn2", Value.get(2319)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2320', 2320, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2320")), 
			new Bin("bn2", Value.get(2320)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2321', 2321, '233', 233)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2321")), 
			new Bin("bn2", Value.get(2321)),
			new Bin("bn3", Value.get("233")),
			new Bin("bn4", Value.get(233))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2322', 2322, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2322")), 
			new Bin("bn2", Value.get(2322)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2323', 2323, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2323")), 
			new Bin("bn2", Value.get(2323)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2324', 2324, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2324")), 
			new Bin("bn2", Value.get(2324)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2325', 2325, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2325")), 
			new Bin("bn2", Value.get(2325)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2326', 2326, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2326")), 
			new Bin("bn2", Value.get(2326)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2327', 2327, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2327")), 
			new Bin("bn2", Value.get(2327)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2328', 2328, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2328")), 
			new Bin("bn2", Value.get(2328)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2329', 2329, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2329")), 
			new Bin("bn2", Value.get(2329)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2330', 2330, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2330")), 
			new Bin("bn2", Value.get(2330)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2331', 2331, '234', 234)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2331")), 
			new Bin("bn2", Value.get(2331)),
			new Bin("bn3", Value.get("234")),
			new Bin("bn4", Value.get(234))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2332', 2332, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2332")), 
			new Bin("bn2", Value.get(2332)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2333', 2333, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2333")), 
			new Bin("bn2", Value.get(2333)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2334', 2334, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2334")), 
			new Bin("bn2", Value.get(2334)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2335', 2335, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2335")), 
			new Bin("bn2", Value.get(2335)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2336', 2336, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2336")), 
			new Bin("bn2", Value.get(2336)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2337', 2337, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2337")), 
			new Bin("bn2", Value.get(2337)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2338', 2338, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2338")), 
			new Bin("bn2", Value.get(2338)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2339', 2339, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2339")), 
			new Bin("bn2", Value.get(2339)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2340', 2340, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2340")), 
			new Bin("bn2", Value.get(2340)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2341', 2341, '235', 235)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2341")), 
			new Bin("bn2", Value.get(2341)),
			new Bin("bn3", Value.get("235")),
			new Bin("bn4", Value.get(235))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2342', 2342, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2342")), 
			new Bin("bn2", Value.get(2342)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2343', 2343, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2343")), 
			new Bin("bn2", Value.get(2343)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2344', 2344, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2344")), 
			new Bin("bn2", Value.get(2344)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2345', 2345, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2345")), 
			new Bin("bn2", Value.get(2345)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2346', 2346, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2346")), 
			new Bin("bn2", Value.get(2346)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2347', 2347, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2347")), 
			new Bin("bn2", Value.get(2347)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2348', 2348, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2348")), 
			new Bin("bn2", Value.get(2348)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2349', 2349, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2349")), 
			new Bin("bn2", Value.get(2349)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2350', 2350, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2350")), 
			new Bin("bn2", Value.get(2350)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2351', 2351, '236', 236)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2351")), 
			new Bin("bn2", Value.get(2351)),
			new Bin("bn3", Value.get("236")),
			new Bin("bn4", Value.get(236))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2352', 2352, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2352")), 
			new Bin("bn2", Value.get(2352)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2353', 2353, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2353")), 
			new Bin("bn2", Value.get(2353)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2354', 2354, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2354")), 
			new Bin("bn2", Value.get(2354)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2355', 2355, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2355")), 
			new Bin("bn2", Value.get(2355)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2356', 2356, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2356")), 
			new Bin("bn2", Value.get(2356)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2357', 2357, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2357")), 
			new Bin("bn2", Value.get(2357)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2358', 2358, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2358")), 
			new Bin("bn2", Value.get(2358)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2359', 2359, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2359")), 
			new Bin("bn2", Value.get(2359)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2360', 2360, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2360")), 
			new Bin("bn2", Value.get(2360)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2361', 2361, '237', 237)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2361")), 
			new Bin("bn2", Value.get(2361)),
			new Bin("bn3", Value.get("237")),
			new Bin("bn4", Value.get(237))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2362', 2362, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2362")), 
			new Bin("bn2", Value.get(2362)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2363', 2363, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2363")), 
			new Bin("bn2", Value.get(2363)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2364', 2364, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2364")), 
			new Bin("bn2", Value.get(2364)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2365', 2365, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2365")), 
			new Bin("bn2", Value.get(2365)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2366', 2366, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2366")), 
			new Bin("bn2", Value.get(2366)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2367', 2367, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2367")), 
			new Bin("bn2", Value.get(2367)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2368', 2368, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2368")), 
			new Bin("bn2", Value.get(2368)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2369', 2369, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2369")), 
			new Bin("bn2", Value.get(2369)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2370', 2370, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2370")), 
			new Bin("bn2", Value.get(2370)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2371', 2371, '238', 238)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2371")), 
			new Bin("bn2", Value.get(2371)),
			new Bin("bn3", Value.get("238")),
			new Bin("bn4", Value.get(238))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2372', 2372, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2372")), 
			new Bin("bn2", Value.get(2372)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2373', 2373, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2373")), 
			new Bin("bn2", Value.get(2373)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2374', 2374, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2374")), 
			new Bin("bn2", Value.get(2374)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2375', 2375, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2375")), 
			new Bin("bn2", Value.get(2375)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2376', 2376, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2376")), 
			new Bin("bn2", Value.get(2376)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2377', 2377, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2377")), 
			new Bin("bn2", Value.get(2377)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2378', 2378, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2378")), 
			new Bin("bn2", Value.get(2378)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2379', 2379, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2379")), 
			new Bin("bn2", Value.get(2379)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2380', 2380, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2380")), 
			new Bin("bn2", Value.get(2380)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2381', 2381, '239', 239)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2381")), 
			new Bin("bn2", Value.get(2381)),
			new Bin("bn3", Value.get("239")),
			new Bin("bn4", Value.get(239))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2382', 2382, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2382")), 
			new Bin("bn2", Value.get(2382)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2383', 2383, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2383")), 
			new Bin("bn2", Value.get(2383)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2384', 2384, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2384")), 
			new Bin("bn2", Value.get(2384)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2385', 2385, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2385")), 
			new Bin("bn2", Value.get(2385)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2386', 2386, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2386")), 
			new Bin("bn2", Value.get(2386)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2387', 2387, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2387")), 
			new Bin("bn2", Value.get(2387)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2388', 2388, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2388")), 
			new Bin("bn2", Value.get(2388)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2389', 2389, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2389")), 
			new Bin("bn2", Value.get(2389)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2390', 2390, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2390")), 
			new Bin("bn2", Value.get(2390)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2391', 2391, '240', 240)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2391")), 
			new Bin("bn2", Value.get(2391)),
			new Bin("bn3", Value.get("240")),
			new Bin("bn4", Value.get(240))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2392', 2392, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2392")), 
			new Bin("bn2", Value.get(2392)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2393', 2393, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2393")), 
			new Bin("bn2", Value.get(2393)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2394', 2394, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2394")), 
			new Bin("bn2", Value.get(2394)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2395', 2395, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2395")), 
			new Bin("bn2", Value.get(2395)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2396', 2396, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2396")), 
			new Bin("bn2", Value.get(2396)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2397', 2397, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2397")), 
			new Bin("bn2", Value.get(2397)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2398', 2398, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2398")), 
			new Bin("bn2", Value.get(2398)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2399', 2399, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2399")), 
			new Bin("bn2", Value.get(2399)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2400', 2400, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2400")), 
			new Bin("bn2", Value.get(2400)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2401', 2401, '241', 241)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2401")), 
			new Bin("bn2", Value.get(2401)),
			new Bin("bn3", Value.get("241")),
			new Bin("bn4", Value.get(241))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2402', 2402, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2402")), 
			new Bin("bn2", Value.get(2402)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2403', 2403, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2403")), 
			new Bin("bn2", Value.get(2403)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2404', 2404, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2404")), 
			new Bin("bn2", Value.get(2404)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2405', 2405, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2405")), 
			new Bin("bn2", Value.get(2405)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2406', 2406, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2406")), 
			new Bin("bn2", Value.get(2406)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2407', 2407, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2407")), 
			new Bin("bn2", Value.get(2407)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2408', 2408, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2408")), 
			new Bin("bn2", Value.get(2408)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2409', 2409, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2409")), 
			new Bin("bn2", Value.get(2409)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2410', 2410, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2410")), 
			new Bin("bn2", Value.get(2410)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2411', 2411, '242', 242)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2411")), 
			new Bin("bn2", Value.get(2411)),
			new Bin("bn3", Value.get("242")),
			new Bin("bn4", Value.get(242))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2412', 2412, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2412")), 
			new Bin("bn2", Value.get(2412)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2413', 2413, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2413")), 
			new Bin("bn2", Value.get(2413)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2414', 2414, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2414")), 
			new Bin("bn2", Value.get(2414)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2415', 2415, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2415")), 
			new Bin("bn2", Value.get(2415)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2416', 2416, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2416")), 
			new Bin("bn2", Value.get(2416)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2417', 2417, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2417")), 
			new Bin("bn2", Value.get(2417)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2418', 2418, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2418")), 
			new Bin("bn2", Value.get(2418)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2419', 2419, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2419")), 
			new Bin("bn2", Value.get(2419)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2420', 2420, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2420")), 
			new Bin("bn2", Value.get(2420)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2421', 2421, '243', 243)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2421")), 
			new Bin("bn2", Value.get(2421)),
			new Bin("bn3", Value.get("243")),
			new Bin("bn4", Value.get(243))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2422', 2422, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2422")), 
			new Bin("bn2", Value.get(2422)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2423', 2423, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2423")), 
			new Bin("bn2", Value.get(2423)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2424', 2424, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2424")), 
			new Bin("bn2", Value.get(2424)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2425', 2425, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2425")), 
			new Bin("bn2", Value.get(2425)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2426', 2426, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2426")), 
			new Bin("bn2", Value.get(2426)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2427', 2427, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2427")), 
			new Bin("bn2", Value.get(2427)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2428', 2428, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2428")), 
			new Bin("bn2", Value.get(2428)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2429', 2429, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2429")), 
			new Bin("bn2", Value.get(2429)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2430', 2430, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2430")), 
			new Bin("bn2", Value.get(2430)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2431', 2431, '244', 244)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2431")), 
			new Bin("bn2", Value.get(2431)),
			new Bin("bn3", Value.get("244")),
			new Bin("bn4", Value.get(244))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2432', 2432, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2432")), 
			new Bin("bn2", Value.get(2432)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2433', 2433, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2433")), 
			new Bin("bn2", Value.get(2433)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2434', 2434, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2434")), 
			new Bin("bn2", Value.get(2434)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2435', 2435, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2435")), 
			new Bin("bn2", Value.get(2435)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2436', 2436, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2436")), 
			new Bin("bn2", Value.get(2436)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2437', 2437, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2437")), 
			new Bin("bn2", Value.get(2437)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2438', 2438, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2438")), 
			new Bin("bn2", Value.get(2438)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2439', 2439, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2439")), 
			new Bin("bn2", Value.get(2439)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2440', 2440, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2440")), 
			new Bin("bn2", Value.get(2440)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2441', 2441, '245', 245)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2441")), 
			new Bin("bn2", Value.get(2441)),
			new Bin("bn3", Value.get("245")),
			new Bin("bn4", Value.get(245))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2442', 2442, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2442")), 
			new Bin("bn2", Value.get(2442)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2443', 2443, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2443")), 
			new Bin("bn2", Value.get(2443)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2444', 2444, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2444")), 
			new Bin("bn2", Value.get(2444)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2445', 2445, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2445")), 
			new Bin("bn2", Value.get(2445)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2446', 2446, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2446")), 
			new Bin("bn2", Value.get(2446)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2447', 2447, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2447")), 
			new Bin("bn2", Value.get(2447)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2448', 2448, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2448")), 
			new Bin("bn2", Value.get(2448)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2449', 2449, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2449")), 
			new Bin("bn2", Value.get(2449)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2450', 2450, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2450")), 
			new Bin("bn2", Value.get(2450)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2451', 2451, '246', 246)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2451")), 
			new Bin("bn2", Value.get(2451)),
			new Bin("bn3", Value.get("246")),
			new Bin("bn4", Value.get(246))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2452', 2452, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2452")), 
			new Bin("bn2", Value.get(2452)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2453', 2453, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2453")), 
			new Bin("bn2", Value.get(2453)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2454', 2454, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2454")), 
			new Bin("bn2", Value.get(2454)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2455', 2455, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2455")), 
			new Bin("bn2", Value.get(2455)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2456', 2456, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2456")), 
			new Bin("bn2", Value.get(2456)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2457', 2457, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2457")), 
			new Bin("bn2", Value.get(2457)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2458', 2458, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2458")), 
			new Bin("bn2", Value.get(2458)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2459', 2459, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2459")), 
			new Bin("bn2", Value.get(2459)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2460', 2460, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2460")), 
			new Bin("bn2", Value.get(2460)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2461', 2461, '247', 247)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2461")), 
			new Bin("bn2", Value.get(2461)),
			new Bin("bn3", Value.get("247")),
			new Bin("bn4", Value.get(247))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2462', 2462, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2462")), 
			new Bin("bn2", Value.get(2462)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2463', 2463, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2463")), 
			new Bin("bn2", Value.get(2463)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2464', 2464, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2464")), 
			new Bin("bn2", Value.get(2464)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2465', 2465, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2465")), 
			new Bin("bn2", Value.get(2465)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2466', 2466, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2466")), 
			new Bin("bn2", Value.get(2466)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2467', 2467, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2467")), 
			new Bin("bn2", Value.get(2467)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2468', 2468, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2468")), 
			new Bin("bn2", Value.get(2468)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2469', 2469, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2469")), 
			new Bin("bn2", Value.get(2469)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2470', 2470, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2470")), 
			new Bin("bn2", Value.get(2470)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2471', 2471, '248', 248)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2471")), 
			new Bin("bn2", Value.get(2471)),
			new Bin("bn3", Value.get("248")),
			new Bin("bn4", Value.get(248))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2472', 2472, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2472")), 
			new Bin("bn2", Value.get(2472)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2473', 2473, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2473")), 
			new Bin("bn2", Value.get(2473)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2474', 2474, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2474")), 
			new Bin("bn2", Value.get(2474)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2475', 2475, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2475")), 
			new Bin("bn2", Value.get(2475)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2476', 2476, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2476")), 
			new Bin("bn2", Value.get(2476)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2477', 2477, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2477")), 
			new Bin("bn2", Value.get(2477)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2478', 2478, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2478")), 
			new Bin("bn2", Value.get(2478)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2479', 2479, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2479")), 
			new Bin("bn2", Value.get(2479)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2480', 2480, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2480")), 
			new Bin("bn2", Value.get(2480)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2481', 2481, '249', 249)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2481")), 
			new Bin("bn2", Value.get(2481)),
			new Bin("bn3", Value.get("249")),
			new Bin("bn4", Value.get(249))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2482', 2482, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2482")), 
			new Bin("bn2", Value.get(2482)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2483', 2483, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2483")), 
			new Bin("bn2", Value.get(2483)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2484', 2484, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2484")), 
			new Bin("bn2", Value.get(2484)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2485', 2485, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2485")), 
			new Bin("bn2", Value.get(2485)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2486', 2486, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2486")), 
			new Bin("bn2", Value.get(2486)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2487', 2487, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2487")), 
			new Bin("bn2", Value.get(2487)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2488', 2488, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2488")), 
			new Bin("bn2", Value.get(2488)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2489', 2489, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2489")), 
			new Bin("bn2", Value.get(2489)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2490', 2490, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2490")), 
			new Bin("bn2", Value.get(2490)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2491', 2491, '250', 250)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2491")), 
			new Bin("bn2", Value.get(2491)),
			new Bin("bn3", Value.get("250")),
			new Bin("bn4", Value.get(250))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2492', 2492, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2492")), 
			new Bin("bn2", Value.get(2492)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2493', 2493, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2493")), 
			new Bin("bn2", Value.get(2493)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2494', 2494, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2494")), 
			new Bin("bn2", Value.get(2494)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2495', 2495, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2495")), 
			new Bin("bn2", Value.get(2495)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2496', 2496, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2496")), 
			new Bin("bn2", Value.get(2496)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2497', 2497, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2497")), 
			new Bin("bn2", Value.get(2497)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2498', 2498, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2498")), 
			new Bin("bn2", Value.get(2498)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					
		// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2499', 2499, '251', 251)
		this.client.put(this.writePolicy, new Key("test", "demo", Value.get("2499")), 
			new Bin("bn2", Value.get(2499)),
			new Bin("bn3", Value.get("251")),
			new Bin("bn4", Value.get(251))
			);
					

		
		// Total AQL statements: 2499
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