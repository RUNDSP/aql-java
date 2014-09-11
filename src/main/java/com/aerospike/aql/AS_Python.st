group as_python;
aqlFile(className, statements, host, port) ::= <<
import aerospike
from aerospike import predicates as p

# callback function will print the records as they are read
def print_result((key, metadata, record)):
    print(key, metadata, record)
    
# function to print the results from an Info call
def print_info(title, items):
	print(title + ":")
	
	for node,(err,res) in items:
		if res != None:
			res = res.strip()
			if len(res) > 0:
				entries = res.split(';')
				if len(entries) > 1:
					print("{0}:".format(node))
					for entry in entries:
						entry = entry.strip()
						if len(entry) > 0:
							count = 0
							for field in entry.split(','):
								(name,value) = field.split('=')
								if count > 0:
									print("      {0}: {1}".format(name, value))
								else:
									print("    - {0}: {1}".format(name, value))
								count += 1
				else:
					print("{0}: {1}".format(node, res))

config = {
    hosts: [
        ( '127.0.0.1', 3000 )
    ],
    policies: {
        timeout: 1000 # seconds
    }
}
try:
	client = aerospike.client(config)
	client.connect()
			
	# AQL statements - start
			
	<statements>
			
	# AQL statements - finish, total: <length(statements)>
	
	# Close Connection to Cluster
	client.close()
except Exception as e:
	print("error: {0}".format(e), file=sys.stderr)
	exitCode = 2
	
sys.exit(exitCode)
>>

statement(stmt) ::= <<
<stmt>

>>

insertStmt(source, nameSpace, setName, primaryKey, binNames, values) ::= <<
# <source>
key = (<nameSpace>, <setName>, <primaryKey>)
rec = { <first(binNames),first(values):{z,vv|'<z>':	<vv>}><rest(binNames),rest(values):{z,vv|, '<z>': <vv>}> }
client.put(key, rec)
			
>>

deleteStmt(source, nameSpace, setName, primaryKey) ::= <<
# <source> 
key = (<nameSpace>, <setName>, <primaryKey>)
client.remove(key)

>>

select(source, nameSpace, setName, binNames, as, where, key) ::= <<
# <source>
<if(key)>
key = (<nameSpace>, <setName>, <key>)
<if(binNames)>
(key, metadata, record) = client.get(key, <first(binNames):{b|"<b>"}><rest(binNames):{b|, "<b>"}>)
<else>
(key, metadata, record) = client.get(key)
<endif>

print "Record: " + record
<elseif(where)>
query = client.query('<nameSpace>', '<setName>')
<where>
<if(binNames)>
query.select(<first(binNames):{b|"<b>"}><rest(binNames):{b|, '<b>'}>)
<else>
query.select()
<endif>

query.foreach(print_result)

<else>
scan = client.scan(<nameSpace>, <setName>)
scan.foreach(print_result)

<endif>
<as>


>>

aggregate(source, nameSpace, setName, 
				package, function,  
				arguments, where) ::= <<
# <source> 
query = client.query( <nameSpace>, <setName> )
query.select()
<if(where)>
<where>



<else>

<endif>
query.apply('<package>', '<function>' <if(arguments)><arguments:{qq|, <qq>}><endif>)
query.foreach(print_result)
				
>>


create(source, indexName, nameSpace, setName, binName, type) ::= <<
# <source>
indexTask = this.client.createIndex(this.policy, "<nameSpace>", "<setName>", "<indexName>", "<binName>", IndexType.<type>);
indexTask.waitTillComplete();
				
>>

drop(source, indexName, nameSpace, setName) ::= <<
# <source>
this.client.dropIndex(this.policy, "<nameSpace>", "<setName>", "<indexName>");

>>

showIndex(source, nameSpace, setName) ::= <<
# <source>
print_info("Indexes", client.info("sindex").items());

>>

statIndex(source, nameSpace, indexName) ::= <<
# <source>

>>

register(source, path) ::= <<
# <source>
udfFile = new File("<path>");
task = this.client.register(null, 
	udfFile.getPath(), 
	udfFile.getName(), 
	Language.LUA); 
task.waitTillComplete();

>>

remove(source, package) ::= <<
# <source>
print("Drop module <package>: " + client.info('udf-remove:filename=<package>'))

>>

deleteSet(source, namespace, set)::= <<
# <source>
print_info("Drop set", client.info("set-config:context=namespace;id=<namespace>;set=<set>;set-delete=true;").items());

>>

execute(source, nameSpace, setName, key, package, udf, arguments) ::= <<
# <source>
// <nameSpace>, <setName>, <key>, <package>, <udf>, <arguments>
<if(key)>
key = (<nameSpace>, <setName>, <key>)
client.apply(key, '<package>', '<udf>' <if(arguments)><first(arguments):{z|, <z>}><rest(arguments):{x|, <x>}><endif> );
print("UDF result: " + result);

<else>
stmt = new Statement();
stmt.setNamespace("<nameSpace>");
stmt.setSetName("<setName>");
recordSet = client.query(null, stmt);

// Process the record set
try {
	while (recordSet != null && recordSet.next()) {
		key = recordSet.getKey();
		record = recordSet.getRecord();
		
		print("Record: " + record);
		
	}
}
finally {
	recordSet.close();
}

<endif>

>>

wherePK(value) ::= <<
new Key(<value>);
>>

whereFilter(nameSpace, setName, filters, binNames) ::= <<
<if(binNames)>
stmt.setBinNames(<first(binNames):{z|'<z>"}><rest(binNames):{x|, '<x>'}>);
<endif>
<if(filters)>
query.where(<first(filters):{f|<f>}><rest(filters):{f|, <f>}>)
<endif>

>>

orderBy(list) ::= <<
#Ordeby not supported <list>
>>

ascend(bin) ::= <<
<bin> ASC
>>

descend(bin) ::= <<
<bin> DESC
>>

setTimeOut(source, value) ::= <<
# <source>
this.policy.timeout = <value>;
this.writePolicy.timeout = <value>;

>>
 
setVerbose(source, value) ::= <<
# <source>

>>

setEcho(source, value) ::= <<
# <source>

>>

setTTL(source, value) ::= <<
# <source>
this.writePolicy.expiration = <value>;

>>

setView(source, type) ::= <<
# <source>

>>

useSmd(source, value) ::= <<
# <source>

>>

setUserPath(source, value) ::= <<
# <source>
LuaConfig.SourceDirectory = "<value>"; 

>>

setSystemPath(source, value) ::= <<
# <source>

>>

getTimeout(source) ::= <<
# <source>
print("Policy timeout: " + this.policy.timeout);
print("Write policy timeout: " + this.writePolicy.timeout);

>>
getVerbose(source) ::= <<
# <source>

>>
getEcho(source) ::= <<
# <source>

>>
getTTL(source) ::= <<
# <source>
print("Write policy expiration: " + this.writePolicy.expiration);

>>
getView(source) ::= <<
# <source>

>>
getUseSMD(source) ::= <<
# <source>

>>
getUserPath(source) ::= <<
# <source>
print("Lua source directory: " + LuaConfig.SourceDirectory);

>>
getSystemPath(source) ::= <<
# <source>

>>

statQuery(source) ::= <<
# <source>
print_info("Query stats", client.info("query-stat").items());

>>

statSystem(source) ::= <<
# <source>
print_info("Statistics", client.info("statistics").items());

>>


filterEquals(bin, value) ::= <<
p.equals('<bin>', <value>)
>>

filterRange(bin, low, high) ::= <<
p.between('<bin>', <low>, <high>)
>>

valueText(value) ::= <<
<value>
>>

stringValueText(value) ::= <<
"<value>"
>>

showPackages(source) ::= <<
# <source>
print_info("Packages", client.info("udf-list").items());

>>

showNamespaces(source) ::= <<
# <source>
print_info("Namespaces", client.info("namespaces").items());

>>

showSets(source) ::= <<
# <source>
print_info("Sets", client.info("sets").items());

>>

showBins(source) ::= <<
# <source>
print_info("Bins", client.info("bins").items());


>>

showScans(source) ::= <<
# <source>
print_info("Scans", client.info("jobs:module=scan").items());

>>

showQueries(source) ::= <<
# <source>
print_info("Queries", client.info("jobs:module=query").items());


>>

descIndex(source, nameSpace, indexName) ::= <<
# <source>
print_info("Indexes", client.info("sindex-describe").items());

>>


descPackage(source, name) ::= <<
# <source>
print("Module: <name>");
udfString = Info.request(this.seedHost, this.port, "udf-get:filename=<name>");
udfparts = udfString.split(";");
print(new String(Base64.decode(udfparts[2].getBytes(), 8, udfparts[2].length()-2)));

>>

killQuery(source, id) ::= <<
# <source>
print_info("Indexes", client.info("query-kill=<id>").items());

>>

killScan(source, id) ::= <<
# <source>
print_info("Indexes", client.info("scan-kill=<id>").items());

>>

run(source, fileName) ::= <<
# <source>
print("Run file: " + <fileName>);

>>
print(source, value) ::= <<
# <source>
print(<value>);

>>