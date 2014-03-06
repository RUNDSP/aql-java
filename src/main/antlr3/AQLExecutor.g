
tree grammar AQLExecutor;

options {
		backtrack = true; 
		tokenVocab = AQLast;
		ASTLabelType = CommonTree;
		language = Java;
		superClass = ExecutorParser;
}

@treeparser::header {
package com.aerospike.aql.grammar;

import gnu.crypto.util.Base64;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.aerospike.aql.grammar.NoCaseFileStream;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Info;
import com.aerospike.client.Key;
import com.aerospike.client.Language;
import com.aerospike.client.Record;
import com.aerospike.client.Value;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.RegisterTask;
}
@treeparser::members {
public AQLExecutor(TreeNodeStream input, AerospikeClient client) {
	super(input, client);
}

protected String removeQuotes(String source){
	String target = source.substring(1, source.length()-1);
	return target;
}
}

aqlFile throws AerospikeException
	: aqlStatement+ 
	;
	
	
aqlStatement throws AerospikeException
	: create	
	| drop		
	| insert	
	| delete	
	| select 
	| registerPackage 
	| execute 
	| aggregate 
	| show 
	| desc 
	| stat 
	| set 
	| get 
	| run 
	| kill_query 
	| kill_scan 
	| quit 
	| help 
  | print 
	;

/*
DDL:
	CREATE INDEX indexname ON namespace[.setname] (binname) NUMERIC|STRING
	DROP INDEX namespace[.setname] indexname
Indexing commands
*/
create throws AerospikeException
	: ^(CREATE index_name nameSet bin indexType)
		{
		if (isConnected()) {
      	String type = $indexType.text;
      	long start_time = System.nanoTime();
				this.client.createIndex(policy, $nameSet.nameSpace, $nameSet.setName, $index_name.text, $bin.text, (type.equalsIgnoreCase("string")) ? IndexType.STRING : IndexType.NUMERIC);
				long end_time = System.nanoTime();
				double difference = (end_time-start_time)/1000000.0;
				this.resultReporter.report("Index " + $nameSet.nameSpace + "." + $nameSet.setName + "." + $index_name.text + " - created in " + difference + "ms");
		}	
		}
	;

drop  throws AerospikeException
	: ^(DROP 
	  (
	    ^(INDEX index_name nameSet)
			{
			if (isConnected()) {
					this.client.dropIndex(policy, $nameSet.nameSpace, $nameSet.setName, $index_name.text);
					this.resultReporter.report("Index " + $nameSet.nameSpace + "." + $nameSet.setName + "." + $index_name.text + " - dropped");
			}	
			}
	  | ^(MODULE moduleName) 
	    {
	    Node node = this.client.getNodes()[0];
	    String msg = Info.request(node, "udf-remove:filename=" + $moduleName.text);
	    if (msg.contains("error")){
	      this.resultReporter.report("Could not delete module: " +  $moduleName.text);
	    } else {
	      this.resultReporter.report("Delete module: " +  $moduleName.text);
	    }
	    }
	  ))
 	;
	
indexType
	: NUMERIC
	| STRING
	;

/*
DML:
	INSERT INTO namespace[.setname] (PK,binnames,,,) VALUES ('pk',nnn,'xxx',,)
	DELETE FROM namespace[.setname] WHERE PK = 'x'

*/
//	INSERT INTO namespace[.setname] (PK,binnames,,,) VALUES ('pk',nnn,'xxx',,)
insert throws AerospikeException
	: ^(INSERT nameSet primaryKey bn=binNameList v=valueList) 
		{
      	String nameSpace = $nameSet.nameSpace;
      	String set = $nameSet.setName;
      	String keyValue = $primaryKey.value;
				List<Bin> bins = new ArrayList<Bin>();
				Key key = new Key(nameSpace, set, keyValue);
				StringBuilder sb = new StringBuilder();
				sb.append("Insert: ");
				sb.append(keyValue);
				int item = 0;
				for (String binName : $bn.bins){
						Bin bin = new Bin(binName, $v.list.get(item));
						bins.add(bin);
						sb.append(" ").append(bin.name).append(":").append(bin.value).append(":").append(bin.value.getClass());
					item++;
				}
      	long start_time = System.nanoTime();
				client.put(this.writePolicy, key, bins.toArray(new Bin[0]));			
				long end_time = System.nanoTime();
				double difference = (end_time-start_time)/1000000.0;
				sb.append(" - Success in ");
				sb.append(difference);
				sb.append("ms");
				this.resultReporter.report(sb.toString());

		}
	;
//	DELETE FROM namespace[.setname] WHERE PK = 'x'
delete throws AerospikeException
	: ^(DELETE ns=nameSet pk=primaryKey)
	{
				Key key = new Key($ns.nameSpace, $ns.setName, $pk.value);
				this.client.delete(this.writePolicy, key);
	}
	;
/*
QUERY:
	SELECT *|bin,,, [AS(,,,)] FROM namespace[.setname]
	SELECT *|bin,,, [AS(,,,)] FROM namespace[.setname] ORDER BY xxx, ASC|DESC [,yyy,ASC|DESC]
	SELECT *|bin,,, [AS(,,,)] FROM namespace[.setname] WHERE bin = nnn
	SELECT *|bin,,, [AS(,,,)] FROM namespace[.setname] WHERE bin = 'xxx'
	SELECT *|bin,,, [AS(,,,)] FROM namespace[.setname] WHERE bin BETWEEN nnn AND mmm
	SELECT *|bin,,, [AS(,,,)] FROM namespace[.setname] WHERE PK = 'x'
	Note:SELECT...WHERE bin ... needs an INDEX on bin. Use CREATE INDEX first.
*/	
select scope {String nameSpace; String setName; String key;}
	: ^(SELECT_ALL from)
	| ^(SELECT_EXPLICIT bn=binNameList from) 
	;
	

from  
	: ^(FROM nameSet {$select::nameSpace = $nameSet.nameSpace; $select::setName = $nameSet.setName; } 
		(^(WHERE expressions[$nameSet.nameSpace, $nameSet.setName] ))?) 
	;
orderby
	: order+ 
	;

order
	: ^(ASC bin) 
	| ^(DESC bin) 
	;

expressions [String nameSpace, String setName] returns [Filter fil]
	: ^(PK value {$select::key = $value.text;}) 
	| ^(FILTERS filter {$fil = $filter.filter;}) 
	;
filter returns [Filter filter]
	: ^(EQ bin value) {$filter = Filter.equal($bin.name, $value.asValue);}
	| ^(BETWEEN b2=bin low=INTLITERAL high=INTLITERAL)  {$filter = Filter.range($bin.name, Value.get(Integer.parseInt($low.text)), Value.get(Integer.parseInt($high.text)));}
	;

binNameList returns [List<String> bins]
@init {
	bins = new ArrayList<String>();
}
	: ^(BIN_NAMES (bin {bins.add($bin.text);})+) 
	;

valueList returns [List<Value> list]
@init {
	list = new ArrayList<Value>();
}
	: ^(VALUES (value {list.add($value.asValue);})+)
	;


nameSet returns [String nameSpace, String setName] 
	: ^(NAMESET namespace_name {$nameSpace=$namespace_name.text;} set_name? {$setName=$set_name.text;})
	;

/*
UDF:
	REGISTER PACKAGE 'filepath'
	REMOVE PACKAGE pkgname.extension
	EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
	EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'
	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
UDF
*/


// REGISTER PACKAGE 'filepath'
registerPackage throws AerospikeException
	: ^(REGISTER p=STRINGLITERAL)
	{
			File udfFile = new File(removeQuotes($p.text));
      RegisterTask task = this.client.register(null, 
      		udfFile.getPath(), //client path
      		udfFile.getName(), //server path
      		Language.LUA); //UDF language
      task.waitTillComplete();
	}
	;
// REMOVE PACKAGE pkgname.extension	
removePackage throws AerospikeException
	: ^(REMOVE IDENTIFIER)
      {
      Node node = this.client.getNodes()[0];
      String msg = Info.request(node, "udf-remove:filename=" + $IDENTIFIER.text);
      if (msg.contains("error")){
        this.resultReporter.report("Could not delete module: " +  $IDENTIFIER.text);
      } else {
        this.resultReporter.report("Delete module: " +  $IDENTIFIER.text);
      }
      }
	;
//		EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
//		EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'	
execute throws AerospikeException
	: ^(EXECUTE nameSet packageFunction primaryKey? valueList?)
		{
	// TODO Execute with query
				Key key = new Key($nameSet.nameSpace, $nameSet.setName, $primaryKey.value);
				List<Value> values = $valueList.list;
				int item = 0;
				Object result = client.execute(this.policy, key, 
					$packageFunction.packageName, 
					$packageFunction.functionName, 
					values.toArray(new Value[values.size()]));
				this.resultReporter.report(result.toString());
		}
	
	;

//	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
//	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
aggregate throws AerospikeException
	: ^(AGGREGATE nameSet packageFunction expressions[$nameSet.nameSpace, $nameSet.setName] valueList?)
	{
	  List<Value> values = $valueList.list;
	  Statement stmt = new Statement();
    stmt.setNamespace($nameSet.nameSpace);
    stmt.setSetName($nameSet.setName);
    stmt.setFilters($expressions.fil);
    ResultSet resultSet = client.queryAggregate(null, stmt, 
      $packageFunction.packageName, 
      $packageFunction.functionName, 
      values.toArray(new Value[values.size()]));
        
    try {
      int count = 0;
      
      while (resultSet.next()) {
        Object object = resultSet.getObject();
        this.resultReporter.report("Result: " + object);
        count++;
      }
      
      if (count == 0) {
        this.resultReporter.report("No results returned.");     
      }
    }
    finally {
      resultSet.close();
    }
	
	}
	;
	

packageFunction returns [String packageName, String functionName]
	: p=IDENTIFIER '.' f=IDENTIFIER
	{$packageName = $p.text; $functionName = $f.text;}
	;
	
/*
INFO:
	SHOW PACKAGES
	SHOW NAMESPACES|SETS|BINS
	SHOW SCANS|QUERIES
	SHOW INDEXES [namespace[.set]]
	DESC INDEX namespace indexname
	DESC PACKAGE pkgname.extension
	STAT INDEX namespace indexname
	STAT QUERY
	STAT SYSTEM
*/

//	SHOW MODULES
//	SHOW NAMESPACES|SETS|BINS
//	SHOW SCANS|QUERIES
//	SHOW INDEXES [namespace[.set]]
show throws AerospikeException
	: ^(SHOW INDEXES nameSet)
	{
			String indexesString = info("sindex");
			printInfo("Indexes:", indexesString);
	}
	|	^(SHOW MODULES) 		
	{
		String packagesString = info("udf-list");
		printInfo("Modules:", packagesString);
	}		
	| ^(SHOW NAMESPACES)	
	{
		String nameSpacesString = info("namespaces");
		printInfo("Name spaces:", nameSpacesString);
	}
	| ^(SHOW SETS)	
	{
	String setsString = info("sets");
	printInfo("Sets:", setsString);
	}					
	| ^(SHOW BINS)	
	{
		String binsString = info("bins");
		printInfo("Bins:", binsString);
	}					
	| ^(SHOW SCANS)					
	| ^(SHOW QUERIES)	
	{
	String queriesString = info("queries");
	printInfo("Queries:", queriesString);
	}			
	;
	
//	DESC INDEX namespace indexname
//	DESC PACKAGE pkgname.extension
desc throws AerospikeException
	: ^(DESC ^(PACKAGE moduleName))
	{
	this.resultReporter.report("Package: " + $moduleName.text);
	String udfString = info("udf-get:filename=" + $moduleName.text);
	this.resultReporter.report(Base64.decode(udfString.getBytes(), 0, udfString.length()).toString());
	
	}
	| ^(DESC ^(INDEX namespace_name index_name))
	;
	
//	STAT INDEX namespace indexname
//	STAT QUERY
//	STAT SYSTEM
stat
	: ^(STAT ^(INDEX namespace_name index_name))
	|	^(STAT QUERY)
	|	^(STAT SYSTEM)
	;
/*
ADMIN:
	# text_string - comment in script, line skipped.
	PRINT text_string

	NOTE: Do not specify value with GET. eg: SET ECHO true, GET ECHO
	SET|GET VERBOSE true|false [default false]
	SET|GET ECHO true|false [default false]
	SET|GET TIMEOUT timeout_ms [default 1000]
	SET|GET RECORD_TTL record_ttl_sec [default 0 - never expire]
	SET|GET VIEW JSON|TABLE|NOSQL|LUA [default at startup - TABLE]
	SET|GET LUA_USERPATH 'path' [default /opt/citrusleaf/usr/udf/lua]
	SET|GET LUA_SYSPATH 'path' [default /opt/citrusleaf/sys/udf/lua]
	Note: These are client side paths for lua files.

	KILL_QUERY transaction_id
	KILL_SCAN scan_id
	RUN 'filename' 	(Each line in the file contains an asql command)
	HELP
	QUIT|EXIT|Q
*/


set
	: ^(SET ^(TIMEOUT timeOut=INTLITERAL)) {this.policy.timeout = Integer.parseInt($timeOut.text);this.writePolicy.timeout = Integer.parseInt($timeOut.text);}
	| ^(SET ^(VERBOSE verboseOn=booleanLiteral))
	| ^(SET ^(ECHO echoOn=booleanLiteral))
	| ^(SET ^(RECORD_TTL ttl=INTLITERAL)) {this.writePolicy.expiration = Integer.parseInt($ttl.text);}
	| ^(SET ^(VIEW viewType))
	| ^(SET ^(LUA_USER_PATH luaUserPath=STRINGLITERAL))
	| ^(SET ^(LUA_SYSTEM_PATH luaSysPath=STRINGLITERAL))
	;
get
	: ^(GET TIMEOUT)
	{
	this.resultReporter.report("Policy timeout: " + this.policy.timeout);
	this.resultReporter.report("Write policy timeout: " + this.writePolicy.timeout);
	}
	| ^(GET VERBOSE)					
	| ^(GET ECHO)							
	| ^(GET RECORD_TTL) {this.resultReporter.report(Integer.toString(this.writePolicy.expiration));}	
	| ^(GET VIEW)							
	| ^(GET LUA_USER_PATH)		
	| ^(GET LUA_SYSTEM_PATH)	
	;



//	RUN 'filename' 	(Each line in the file contains an asql command)
run
	: ^(RUN STRINGLITERAL)
	;
print
	: ^(PRINT STRINGLITERAL?) 
	{
	this.resultReporter.report(removeQuotes($STRINGLITERAL.text));
	}
	;
//		KILL_QUERY transaction_id
kill_query throws AerospikeException
	:	^(KILL_QUERY INTLITERAL)
	{
	info("query-kill="+$INTLITERAL.text);
	}
	;

//	KILL_SCAN scan_id
kill_scan throws AerospikeException
	:	^(KILL_SCAN INTLITERAL)
	{
	info("scan-kill="+$INTLITERAL.text);
	}
	;

// 	QUIT|EXIT|Q	
quit
	: QUIT 
	| EXIT
	| 'q'
	{
	System.exit(0);
	}
	;
help
	: 'help'
	;
	
viewType
	: 'json' {this.viewType = ExecutorParser.ViewType.JSON;}
	|'table' {this.viewType = ExecutorParser.ViewType.TABLE;}
	;


primaryKey returns [String value]
	: ^(PK STRINGLITERAL) {$value = $STRINGLITERAL.text.replace("'","\"");}
	;
	
package_name
	: IDENTIFIER
	;


index_name
	: IDENTIFIER
	;
	
namespace_name
	: IDENTIFIER
	;
		
set_name
	: IDENTIFIER
	;
	
bin returns [String name]
	: ident=IDENTIFIER
		{$name = $ident.text;}
	;
	
value returns [Value asValue]
	: STRINGLITERAL {$asValue = Value.get($STRINGLITERAL.text.replace("'", ""));} // Kludge
	| INTLITERAL {$asValue = Value.get(Long.parseLong($INTLITERAL.text));}
	;

booleanLiteral
		: TRUE
		| FALSE
		;
moduleName
  : IDENTIFIER '.' ('lua'|'so')
  ;

