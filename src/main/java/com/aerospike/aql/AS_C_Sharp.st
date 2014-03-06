group as_java;
aqlFile(className, statements, host, port) ::= <<
using System;
using Aerospike.Client;

namespace Aerospike.Generation
{
	public class <className>
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
	
				<statements>
				
			}
			finally
			{
				client.Close();
			}
		}
 	}
}
 
>>

statement(stmt) ::= <<
<stmt>

>>

insertStmt(source, nameSpace, setName, primaryKey, binNames, values) ::= <<
// <source>
key = new Key("<nameSpace>", "<setName>", Value.get(<primaryKey>)); 
client.Put(writePolicy, key, 
	<first(binNames),first(values):{z,vv|new Bin("<z>", Value.get(<vv>))}><rest(binNames),rest(values):{z,vv|,
new Bin("<z>", Value.get(<vv>))}
>);
  
>>

deleteStmt(source, nameSpace, setName, primaryKey) ::= <<
// <source>
<nameSpace>
<setName>
<primaryKey>

>>

select(source, nameSpace, setName, binNames, as, where, key, orderBy) ::= <<
// <source>


>>



aggregate(source, nameSpace, setName, 
        package, function,  
        arguments, where) ::= <<
// <source>

        
>>





create(source, indexName, nameSpace, setName, binName, type) ::= <<
// <source>
        
>>

drop(source, indexName, nameSpace, setName) ::= <<
// <source>

>>

showIndex(source, nameSpace, setName) ::= <<
// <source>

>>

statIndex(source, nameSpace, indexName) ::= <<
// <source>

>>

register(source, path) ::= <<
// <source>


>>

remove(source, package) ::= <<
// <source>
// TODO no java API to remove a package

>>

execute(source, nameSpace, setName, key, package, udf, arguments) ::= <<
// <source>

>>

wherePK(value) ::= <<
new Key(<value>);
>>

whereFilter(nameSpace, setName, filters, binNames) ::= <<

>>

orderBy(list) ::= <<
//Ordeby not supported <list>
>>

ascend(bin) ::= <<
<bin> ASC
>>

descend(bin) ::= <<
<bin> DESC
>>

setTimeOut(source, value) ::= <<
// <source>
this.policy.timeout = <value>;
this.writePolicy.timeout = <value>;

>>
 
setVerbose(source, value) ::= <<
// <source>

>>

setEcho(source, value) ::= <<
// <source>

>>

setTTL(source, value) ::= <<
// <source>
this.writePolicy.expiration = <value>;

>>

setView(source, type) ::= <<
// <source>

>>

useSmd(source, value) ::= <<
// <source>

>>

setUserPath(source, value) ::= <<
// <source>

>>

setSystemPath(source, value) ::= <<
// <source>

>>

getTimeout(source) ::= <<
// <source>
System.out.println("Policy timeout: " + this.policy.timeout);
System.out.println("Write policy timeout: " + this.writePolicy.timeout);

>>
getVerbose(source) ::= <<
// <source>

>>
getEcho(source) ::= <<
// <source>

>>
getTTL(source) ::= <<
// <source>
System.out.println("Write policy expiration: " + this.writePolicy.expiration);

>>
getView(source) ::= <<
// <source>

>>
getUseSMD(source) ::= <<
// <source>

>>
getUserPath(source) ::= <<
// <source>

>>
getSystemPath(source) ::= <<
// <source>

>>

statQuery(source) ::= <<
// <source>

>>

statSystem(source) ::= <<
// <source>

>>


filterEquals(bin, value) ::= <<
Filter.equal("<bin>", Value.get(<value>))
>>

filterRange(bin, low, high) ::= <<
Filter.range("<bin>", Value.get(<low>), Value.get(<high>))
>>

valueText(value) ::= <<
<value>
>>

stringValueText(value) ::= <<
"<value>"
>>

showPackages(source) ::= <<
// <source>
String packagesString = Info.request(this.seedHost, this.port, "udf-list");
String[] packagesList = packagesString.split(";");
System.out.println("Packages");
for (String pkg : packagesList){
  System.out.println("\t" + pkg);
}

>>

showNamespaces(source) ::= <<
// <source>
String nameSpacesString = Info.request(this.seedHost, this.port, "namespaces");
String[] nameSpaces = nameSpacesString.split(";");
System.out.println("Name spaces");
for (String ns : nameSpaces){
  System.out.println("\t" + ns);
}

>>

showSets(source) ::= <<
// <source>
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

>>

showBins(source) ::= <<
// <source>
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


>>

showScans(source) ::= <<
// <source>

>>

showQueries(source) ::= <<
// <source>
String queriesString = Info.request(this.seedHost, this.port, "queries");
String[] queryList = queriesString.split(";");
System.out.println("Queries");
for (String qs : queryList){
  System.out.println("\t" + qs);
}

>>

descIndex(source, nameSpace, indexName) ::= <<
// <source>

>>


descPackage(source, name) ::= <<
// <source>
System.out.println("Package: <name>");
String udfString = Info.request(this.seedHost, this.port, "udf-get:filename=<name>");
System.out.println(Base64.decode(udfString.getBytes(), 0, udfString.length()));

>>

killQuery(source, id) ::= <<
// <source>
Info.request(this.seedHost, this.port, "query-kill=<id>");

>>

killScan(source, id) ::= <<
// <source>
Info.request(this.seedHost, this.port, "scan-kill=<id>");

>>

run(source, fileName) ::= <<
// <source>
System.out.println("Run file: " + <fileName>);

>>
print(source, value) ::= <<
// <source>
System.out.println(<value>);

>>