using System;
using Aerospike.Client;

namespace Aerospike.Generation
{
	public class everything
	{
		static void Main(string[] args)
	    {
	        // Display the number of command line arguments:
	        System.Console.WriteLine(args.Length);
			try
			{
				ClientPolicy policy = new ClientPolicy();
				WritePolicy writePolicy = new writePolicy();
				AerospikeClient client = new AerospikeClient(policy, "127.0.0.1", 3000);
				Key key = null;
	
				// select * from test.people where pk = 'toby'


				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1)
				key = new Key("test", "demo", Value.get("1")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(1)),
					new Bin("bn3", Value.get("1")),
					new Bin("bn4", Value.get(1)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2)
				key = new Key("test", "demo", Value.get("2")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(2)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2)
				key = new Key("test", "demo", Value.get("3")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(3)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2)
				key = new Key("test", "demo", Value.get("4")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(4)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2)
				key = new Key("test", "demo", Value.get("5")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(5)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2)
				key = new Key("test", "demo", Value.get("6")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(6)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2)
				key = new Key("test", "demo", Value.get("7")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(7)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2)
				key = new Key("test", "demo", Value.get("8")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(8)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2)
				key = new Key("test", "demo", Value.get("9")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(9)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2)
				key = new Key("test", "demo", Value.get("10")); 
				client.Put(writePolicy, key, 
					new Bin("bn2", Value.get(10)),
					new Bin("bn3", Value.get("2")),
					new Bin("bn4", Value.get(2)));
				  
				// CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC
				        
				// CREATE INDEX index_bn3 ON test.demo (bn3) STRING
				        
				// SELECT * FROM test.demo


				// SELECT * FROM test.demo WHERE bn4 = 2


				// SELECT * FROM test.demo WHERE bn3 = '2'


				// SELECT * FROM test.demo WHERE bn4 BETWEEN 1 AND 2


				// SELECT * FROM test.demo WHERE PK = '10'


				// SELECT bn2,bn3,bn4  FROM test.demo


				// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 = 2


				// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn3 = '2'


				// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 BETWEEN 1 AND 2


				// SELECT bn2,bn3,bn4  FROM test.demo WHERE PK = '10'


				// REGISTER module 'src/test/resources/example1.lua'


				// REGISTER module 'src/test/resources/sum_example.lua'


				// REGISTER module 'src/test/resources/average_example.lua'


				// SHOW modules
				String packagesString = Info.request(this.seedHost, this.port, "udf-list");
				String[] packagesList = packagesString.split(";");
				System.out.println("Packages");
				for (String pkg : packagesList){
				  System.out.println("\t" + pkg);
				}

				// desc module example1.lua
				System.out.println("Package: example1.lua");
				String udfString = Info.request(this.seedHost, this.port, "udf-get:filename=example1.lua");
				System.out.println(Base64.decode(udfString.getBytes(), 0, udfString.length()));

				// desc module average_example.lua
				System.out.println("Package: average_example.lua");
				String udfString = Info.request(this.seedHost, this.port, "udf-get:filename=average_example.lua");
				System.out.println(Base64.decode(udfString.getBytes(), 0, udfString.length()));

				// EXECUTE example1.foo('arg1','arg2',3) ON test.demo WHERE PK = '1'

				// drop module example1.lua
				// TODO no java API to remove a package

				// AGGREGATE sum_example.sum_single_bin('bn4') ON test.demo WHERE bn4 BETWEEN 1 AND 2

				        
				// SHOW NAMESPACES
				String nameSpacesString = Info.request(this.seedHost, this.port, "namespaces");
				String[] nameSpaces = nameSpacesString.split(";");
				System.out.println("Name spaces");
				for (String ns : nameSpaces){
				  System.out.println("\t" + ns);
				}

				// show SETS
				String setsString = Info.request(this.seedHost, this.port, "sets");
				String[] sets = setsString.split(";");
				System.out.println("Sets");
				for (String s : sets){
				  
				  String[] setParts = s.split(":");
				  for (String parts : setParts){
				    System.out.println("\t" + parts);
				  }
				  System.out.println();
				}

				// sHoW BiNS
				String binsString = Info.request(this.seedHost, this.port, "bins");
				String[] binList = binsString.split(";");
				System.out.println("Bins");
				for (String s : binList){

				  String[] binParts = s.split(":");
				  for (String parts : binParts){
				    System.out.println("\t" + parts);
				  }
				  System.out.println();
				}


				// SHOW SCAnS

				// shoW qUERIES
				String queriesString = Info.request(this.seedHost, this.port, "queries");
				String[] queryList = queriesString.split(";");
				System.out.println("Queries");
				for (String qs : queryList){
				  System.out.println("\t" + qs);
				}

				// SHOW INDEXES test.demo

				// DESC INDEX test index_bn2

				// STAT INDEX test index_bn3

				// STAT QUERY

				// STAT SYSTEM

				// PRINT 'text_string'
				System.out.println("text_string");

				// SET VERBOSE true

				// SET VERBOSE false

				// SET ECHO true

				// SET ECHO false

				// SET TIMEOUT 1500
				this.policy.timeout = 1500;
				this.writePolicy.timeout = 1500;

				// SET RECORD_TTL 0
				this.writePolicy.expiration = 0;

				// SET VIEW TABLE

				// SET VIEW JSON

				// SET LUA_USERPATH '/opt/citrusleaf/usr/udf/lua'

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

				// GET LUA_SYSPATH

				// DELETE FROM test.demo WHERE PK = '1'
				test
				demo
				"1"

				// DELETE FROM test.demo WHERE PK = '2'
				test
				demo
				"2"

				// DELETE FROM test.demo WHERE PK = '3'
				test
				demo
				"3"

				// DELETE FROM test.demo WHERE PK = '4'
				test
				demo
				"4"

				// DELETE FROM test.demo WHERE PK = '5'
				test
				demo
				"5"

				// DELETE FROM test.demo WHERE PK = '6'
				test
				demo
				"6"

				// DELETE FROM test.demo WHERE PK = '7'
				test
				demo
				"7"

				// DELETE FROM test.demo WHERE PK = '8'
				test
				demo
				"8"

				// DELETE FROM test.demo WHERE PK = '9'
				test
				demo
				"9"

				// DELETE FROM test.demo WHERE PK = '10'
				test
				demo
				"10"

				// DROP INDEX test.demo index_bn2

				// DROP INDEX test.demo index_bn3


				
			}
			finally
			{
				client.Close();
			}
		}
 	}
}
 