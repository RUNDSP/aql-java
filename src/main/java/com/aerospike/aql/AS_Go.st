group as_go;
aqlFile(className, statements, host, port) ::= <<
package main

import (
	"flag"
	"fmt"
	. "github.com/aerospike/aerospike-client-go"
	"math/rand"
	"time"
	"os"
	"strings"
	"bufio"
)


const APP_VERSION = "1.0"

// The flag package provides a default help printer via -h switch
var versionFlag *bool = flag.Bool("v", false, "Print the version number.")

func panicOnError(err error) {
	if err != nil {
		fmt.Printf("Aerospike error: %d", err)
		panic(err)
	}
}

func main() {
	// Establish connection to Aerospike server
	client, err := NewClient("127.0.0.1", 3000)
	panicOnError(err)
	defer client.Close()
	
	writePolicy := NewWritePolicy(0, 0) //generation, expiration
	readPolicy := NewPolicy()
	infoPolicy := NewInfoPolicy()
	queryPolicy := NewQueryPolicy()
	
	// AQL statements - start
			
	<statements>
			
	// AQL statements - finish, total: <length(statements)>
	
}
>>

statement(stmt) ::= <<
<stmt>

>>

insertStmt(source, nameSpace, setName, primaryKey, binNames, values) ::= <<
// <source>
key := NewKey("<nameSpace>", "<setName>", <primaryKey>)
err := client.PutBins(writePolicy, key, <first(binNames),first(values):{name,value|NewBin("<name>", <value>)}><rest(binNames),rest(values):{name,value|, NewBin("<name>", <value>)}>)
panicOnError(err)
			
>>


binList(binNames, values) ::= <<
<first(binNames),first(values):{name,value|NewBin("<name>", <value>)}><rest(binNames),rest(values):{name,value|, NewBin("<name>", <value>)}>
>>

deleteStmt(source, nameSpace, setName, primaryKey) ::= <<
// <source> 
key := NewKey("<nameSpace>", "<setName>", <primaryKey>)
existed, err := client.Delete(writePolicy, key)
panicOnError(err)

>>

select(source, nameSpace, setName, binNames, as, where, key) ::= <<
// <source>
<if(key)>
key := NewKey("<nameSpace>", "<setName>", <key>)
<if(binNames)>
record, err := client.Get(policy, key, <first(binNames):{b|"<b>"}><rest(binNames):{b|, "<b>"}>)
panicOnError(err)
<else>
record, err := client.Get(policy, key)
panicOnError(err)
<endif>

fmt.Printf("Record: %v\n", record)
<elseif(where)>
<where>
<if(binNames)>
stmt := NewStatement("<nameSpace>", "<setName>", <first(binNames):{b|"<b>"}><rest(binNames):{b|, "<b>"}>);
<endif>

// Execute the query
recordset, err := client.Query(queryPolicy, stmt)
panicOnError(err)
// Process the record set
L:
for {
	select {
	case rec, chanOpen := \<-recordset.Records:
		if !chanOpen {
			break L
		}
		fmt.Println(rec)
	case err := \<-recordset.Errors:
		panicOnError(err)
		}
	}
}
recordset.Close()

<else>
records, err := client.ScanAll(scanPolicy, "<nameSpace>", "<setName>"<if(binNames)>, <first(binNames):{z|"<z>"}><rest(binNames):{x|, "<x>"}><endif>)
panicOnError(err)
for element := range records.Records {
	fmt.Println(element)
}

<endif>
<as>

>>

aggregate(source, nameSpace, setName, 
				package, function,  
				arguments, where) ::= <<
// <source> 

<if(where)>
<where>



<else>

<endif>

				
>>


create(source, indexName, nameSpace, setName, binName, type) ::= <<
// <source>

				
>>

drop(source, indexName, nameSpace, setName) ::= <<
// <source>
err := client.DropIndex(writePolicy, "<nameSpace>", "<setName>", "<indexName>")
panicOnError(err)


>>

showIndex(source, nameSpace, setName) ::= <<
// <source>
conn, err := client.Cluster.Nodes[0].GetConnection(10)
if infoMap, err := RequestInfo(conn, "sindex"); err != nil {
	log.Fatalln(err.Error())
} else {
	cnt := 1
	for k, v := range infoMap {
		log.Printf("%d :  %s\n     %s\n\n", cnt, k, v)
		cnt++
	}
}


>>

statIndex(source, nameSpace, indexName) ::= <<
// <source>

>>

register(source, path) ::= <<
// <source>
regTask, err := client.RegisterUDFFromFile(nil, "<path>", "<path>", LUA)
panicOnError(err)
// wait until UDF is created
for {
	if err := \<-regTask.OnComplete(); err == nil {
		break
	}
}

>>

remove(source, package) ::= <<
// <source>
conn, err := client.Cluster.Nodes[0].GetConnection(10)
if infoMap, err := RequestInfo(conn, "udf-remove:filename=<package>"); err != nil {
	log.Fatalln(err.Error())
} else {
	cnt := 1
	for k, v := range infoMap {
		log.Printf("%d :  %s\n     %s\n\n", cnt, k, v)
		cnt++
	}
}

>>

deleteSet(source, namespace, set)::= <<
// <source>
conn, err := client.Cluster.Nodes[0].GetConnection(10)
if infoMap, err := RequestInfo(conn, "set-config:context=namespace;id=<namespace>;set=<set>;set-delete=true;"); err != nil {
	log.Fatalln(err.Error())
} else {
	cnt := 1
	for k, v := range infoMap {
		log.Printf("%d :  %s\n     %s\n\n", cnt, k, v)
		cnt++
	}
}


>>

execute(source, nameSpace, setName, key, package, udf, arguments) ::= <<
// <source>
// <nameSpace>, <setName>, <key>, <package>, <udf>, <arguments>
<if(key)>


<else>


// Process the record set


<endif>

>>

wherePK(value) ::= <<
NewKey(<value>);
>>

whereFilter(nameSpace, setName, filters, binNames) ::= <<
stmt := NewStatement("<nameSpace>", "<setName>"<if(binNames)>, <first(binNames):{z|"<z>"}><rest(binNames):{x|, "<x>"}><endif>)
<if(filters)>
stmt.AddFilter(<first(filters):{f|<f>}><rest(filters):{f|, <f>}>);
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
// <source>
writePolicy.timeout = <value>
readPolicy.timeout = <value>
infoPolicy.timeout = <value>
queryPolicy.timeout = <value>

>>
 
setVerbose(source, value) ::= <<
// <source>

>>

setEcho(source, value) ::= <<
// <source>

>>

setTTL(source, value) ::= <<
// <source>
writePolicy.expirary = <value>

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
fmt.Printf("TTL: %d\n", readPolicy.timeout)


>>
getVerbose(source) ::= <<
// <source>

>>
getEcho(source) ::= <<
// <source>

>>
getTTL(source) ::= <<
// <source>
fmt.Printf("TTL: %d\n", writePolicy.expirary)

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
NewEqualityFilter("<bin>", <value>)
>>

filterRange(bin, low, high) ::= <<
NewRangeFilter("<bin>", <low>, <high>)
>>

valueText(value) ::= <<
<value>
>>

stringValueText(value) ::= <<
"<value>"
>>

showPackages(source) ::= <<
// <source>


>>

showNamespaces(source) ::= <<
// <source>


>>

showSets(source) ::= <<
// <source>


>>

showBins(source) ::= <<
// <source>



>>

showScans(source) ::= <<
// <source>


>>

showQueries(source) ::= <<
// <source>



>>

descIndex(source, nameSpace, indexName) ::= <<
// <source>


>>


descPackage(source, name) ::= <<
// <source>
print("Module: <name>");
udfString = Info.request(this.seedHost, this.port, "udf-get:filename=<name>");
udfparts = udfString.split(";");
print(new String(Base64.decode(udfparts[2].getBytes(), 8, udfparts[2].length()-2)));

>>

killQuery(source, id) ::= <<
// <source>


>>

killScan(source, id) ::= <<
// <source>


>>

run(source, fileName) ::= <<
// <source>


>>
print(source, value) ::= <<
// <source>


>>