
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
import java.io.UnsupportedEncodingException;

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
import com.aerospike.client.lua.LuaConfig;
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

}

aqlFile throws AerospikeException
	: aqlStatement+ 
	;
	
	
aqlStatement throws AerospikeException
	: {reportStatement($aqlStatement.text);} create 
	| {reportStatement($aqlStatement.text);} drop   
	| {reportStatement($aqlStatement.text);} insert 
	| {reportStatement($aqlStatement.text);} delete 
	| {reportStatement($aqlStatement.text);} select 
	| {reportStatement($aqlStatement.text);} registerPackage 
	| {reportStatement($aqlStatement.text);} execute 
	| {reportStatement($aqlStatement.text);} aggregate 
	| {reportStatement($aqlStatement.text);} show   
	| {reportStatement($aqlStatement.text);} desc   
	| {reportStatement($aqlStatement.text);} stat  
	| {reportStatement($aqlStatement.text);} set    
	| {reportStatement($aqlStatement.text);} get    
	| {reportStatement($aqlStatement.text);} run    
	| {reportStatement($aqlStatement.text);} kill_query 
	| {reportStatement($aqlStatement.text);} kill_scan 
	| {reportStatement($aqlStatement.text);} quit   
	| {reportStatement($aqlStatement.text);} help   
  | {reportStatement($aqlStatement.text);} print  
	;

/*
DDL:
	CREATE INDEX indexname ON namespace[.setname] (binname) NUMERIC|STRING
	DROP INDEX namespace[.setname] indexname
Indexing commands
*/
create throws AerospikeException
	: ^(CREATE index_name nameSet bin indexType)
		{createIndex( $nameSet.nameSpace, $nameSet.setName, $index_name.text, $bin.text, $indexType.text);}
	;

drop  throws AerospikeException
	: ^(DROP 
	  (
	    ^(INDEX index_name ins=nameSet)	{ dropIndex($index_name.text, $ins.nameSpace, $ins.setName);}
	  | ^(MODULE moduleName)  { removePackage($moduleName.text);}
	  | ^(SET sns=nameSet) {dropSet($sns.nameSpace, $sns.setName);}
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
	: ^(INSERT nameSet primaryKey binNames=binNameList binValues=valueList) 
		{ insertRecord($nameSet.nameSpace, $nameSet.setName, $primaryKey.value, binNames, binValues);}
	;
//	DELETE FROM namespace[.setname] WHERE PK = 'x'
delete throws AerospikeException
	: ^(DELETE ns=nameSet pk=primaryKey)
	{ deleteRecord($ns.nameSpace, $ns.setName, $pk.value);}
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
select throws AerospikeException scope {String nameSpace; String setName; String key; Filter filter;} 
	: ^(SELECT_ALL from) {selectRecord($select::nameSpace, $select::setName, null, $select::key, null);}
	| ^(SELECT_EXPLICIT binNames=binNameList from) {selectRecord($select::nameSpace, $select::setName, binNames, $select::key, $select::filter);}
	;
	

from  
	: ^(FROM nameSet {$select::nameSpace = $nameSet.nameSpace; $select::setName = $nameSet.setName; } 
		(^(WHERE expressions[$nameSet.nameSpace, $nameSet.setName] {$select::filter = $expressions.fil;}))?) 
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
	{ registerPackage($p.text); }
	;
// REMOVE PACKAGE pkgname.extension	
removePackage throws AerospikeException
	: ^(REMOVE IDENTIFIER)
      { removePackage($IDENTIFIER.text);}
	;
//		EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
//		EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'	
execute throws AerospikeException
	: ^(EXECUTE nameSet packageFunction primaryKey? valueList?)
		{
		
	// TODO Execute with query - AKA scan UDF
	
		executeRecordUDF($packageFunction.packageName, $packageFunction.functionName, 
		  $nameSet.nameSpace, $nameSet.setName, 
		  $primaryKey.value, $valueList.list);
		}
	
	;

//	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
//	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
aggregate throws AerospikeException
	: ^(AGGREGATE nameSet packageFunction expressions[$nameSet.nameSpace, $nameSet.setName] valueList?)
	{
	executeAggregation($nameSet.nameSpace, $nameSet.setName, $packageFunction.packageName, $packageFunction.functionName, $valueList.list, $expressions.fil);
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
	: ^(SHOW INDEXES nameSet) {showIndexes();}
	|	^(SHOW MODULES) 	{showPackages();}	
	| ^(SHOW NAMESPACES)	{ showNameSpaces(); }
	| ^(SHOW SETS) { showSets(); }
	| ^(SHOW BINS) { showBins();}					
	| ^(SHOW SCANS)		{ showScans(); }     
	| ^(SHOW QUERIES)	{ showQueries();}			
	;
	
//	DESC INDEX namespace indexname
//	DESC PACKAGE pkgname.extension
desc throws AerospikeException
	: ^(DESC ^(MODULE moduleName)) { describeModule($moduleName.text);	}
	| ^(DESC ^(INDEX namespace_name index_name)) {describeIndex($namespace_name.text, $index_name.text);}
	;
	
//	STAT INDEX namespace indexname
//	STAT QUERY
//	STAT SYSTEM
stat throws AerospikeException
	: ^(STAT ^(INDEX namespace_name index_name))
	|	^(STAT QUERY) {printInfo("Query statistics", info("query-stat"));}
	|	^(STAT SYSTEM) {printInfo("Statistics", info("Statistics"));}
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
	: ^(SET ^(TIMEOUT timeOut=INTLITERAL)) 
	{
	this.policy.timeout = Integer.parseInt($timeOut.text);
	this.writePolicy.timeout = Integer.parseInt($timeOut.text);
	}
	| ^(SET ^(VERBOSE verboseOn=booleanLiteral))
	| ^(SET ^(ECHO echoOn=booleanLiteral))
	| ^(SET ^(RECORD_TTL ttl=INTLITERAL)) {this.writePolicy.expiration = Integer.parseInt($ttl.text);}
	| ^(SET ^(VIEW viewType))
	| ^(SET ^(LUA_USER_PATH luaUserPath=STRINGLITERAL)) {LuaConfig.SourceDirectory = removeQuotes($luaUserPath.text); }
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
	| ^(GET RECORD_TTL) {this.resultReporter.report("Write policy expiration: " + this.writePolicy.expiration);}	
	| ^(GET VIEW)							
	| ^(GET LUA_USER_PATH)	{this.resultReporter.report("Lua source directory: " + LuaConfig.SourceDirectory);}	
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
	: 'help' {printHelp();}
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
moduleName returns [String value]
  : ident=IDENTIFIER '.' 
  ('lua' {$value = $ident.text + ".lua";}
  |'so'  {$value = $ident.text + ".so";}
  )
  ;

