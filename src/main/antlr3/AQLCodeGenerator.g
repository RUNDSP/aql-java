
tree grammar AQLCodeGenerator;

options {
		backtrack = true; 
		tokenVocab = AQLast;
		ASTLabelType=AQLTree;
		output=template;
}

@treeparser::header {
package com.aerospike.aql.grammar;
}


aqlFile [String fileName, String host, String portString]
	: stmts+=aqlStatement* -> aqlFile(className={$fileName}, statements={$stmts}, host={$host}, port={$portString})
	;
	
aqlStatement 
	: create	-> statement(stmt={$create.st})
	| drop		-> statement(stmt={$drop.st})
	| insert	-> statement(stmt={$insert.st})
	| delete	-> statement(stmt={$delete.st})
	| select -> statement(stmt={$select.st})
	| registerPackage -> statement(stmt={$registerPackage.st})
	| execute -> statement(stmt={$execute.st})
	| aggregate -> statement(stmt={$aggregate.st})
	| show -> statement(stmt={$show.st})
	| desc -> statement(stmt={$desc.st})
	| stat -> statement(stmt={$stat.st})
	| set -> statement(stmt={$set.st})
	| get -> statement(stmt={$get.st})
	| run -> statement(stmt={$run.st})
	| kill_query -> statement(stmt={$kill_query.st})
	| kill_scan -> statement(stmt={$kill_scan.st})
	| quit -> statement(stmt={$quit.st})
	| help -> statement(stmt={$help.st})
  | print -> statement(stmt={$print.st})
	;

/*
DDL:
	CREATE INDEX indexname ON namespace[.setname] (binname) NUMERIC|STRING
	DROP INDEX namespace[.setname] indexname
Indexing commands
*/
create 
	: ^(CREATE index_name nameSet bin indexType)
	
		-> create(source={$CREATE.source}, indexName={$index_name.text}, nameSpace={$nameSet.nameSpace}, setName={$nameSet.setName}, binName={$bin.name}, type={$indexType.text})
	;

drop 
	: ^(DROP 
	(
	  ^(INDEX index_name ins=nameSet) -> drop(source={$DROP.source}, indexName={$index_name.text}, nameSpace={$ins.nameSpace}, setName={$ins.setName})
		| ^(MODULE moduleName) -> remove(source={$DROP.source}, package={$moduleName.text})
		| ^(SET sns=nameSet) ->deleteSet(source={$DROP.source}, namespace={$sns.nameSpace}, set={$sns.setName})
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
insert 
	: ^(INSERT nameSet primaryKey bn=binNameList v=valueList) 
		-> insertStmt(source={$INSERT.source}, nameSpace={$nameSet.nameSpace}, setName={$nameSet.setName}, 
				primaryKey={$primaryKey.value}, binNames={$bn.bins}, values={$v.values})
	;
//	DELETE FROM namespace[.setname] WHERE PK = 'x'
delete 
	: ^(DELETE nameSet primaryKey)
		-> deleteStmt(source={$DELETE.source}, nameSpace={$nameSet.nameSpace}, setName={$nameSet.setName}, primaryKey={$primaryKey.value})
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
		-> select(source={$SELECT_ALL.source}, nameSpace={$select::nameSpace}, setName={$select::setName}, where={$from.where}, key={$select::key})
	| ^(SELECT_EXPLICIT bn=binNameList from) 
		-> select(source={$SELECT_EXPLICIT.source}, nameSpace={$select::nameSpace}, setName={$select::setName}, binNames={$bn.bins}, where={$from.where}, key={$select::key}, orderBy = {$from.orderBy})
	;
	

from returns [StringTemplate where, StringTemplate orderBy]
	: ^(FROM nameSet {$select::nameSpace = $nameSet.nameSpace; $select::setName = $nameSet.setName; } 
		(^(WHERE expressions[$select::nameSpace, $select::setName] {$where = $expressions.st;}))?
		(^(ORDER orderby {$orderBy = $orderby.st;}))?
		) 
	;

orderby
	: list+=order+ -> orderBy(list={$list})
	;

order
	: ^(ASC bin) -> ascend(bin = {$bin.name})
	| ^(DESC bin) -> descend(bin = {$bin.name})
	;

expressions [String nameSpace, String setName]
	: ^(PK value {$select::key = $value.text;}) -> wherePK(value={$value.text})
	| ^(FILTERS list+=filter) -> whereFilter(nameSpace={$nameSpace}, setName={$setName}, filters={$list})
	;
filter 
	: ^(EQ bin value) ->filterEquals(bin={$bin.name}, value={$value.text})
	| ^(BETWEEN b2=bin low=INTLITERAL high=INTLITERAL) ->filterRange(bin={$bin.name}, low={$low.text}, high={$high.text})
  | ^(BETWEEN b2=bin lowF=function highF=function) ->filterRangeFunction(bin={$bin.name}, low={$low.text}, high={$high.text})
	;

function
  : ^(FUNCTION id=IDENTIFIER value) -> function(name={$id}, value={$value.text})
  ;
binNameList returns [List<String> bins]
@init {
	retval.bins = new ArrayList<String>();
}
	: ^(BIN_NAMES (bin {retval.bins.add($bin.name);})+) 
	;

valueList returns [List<String> values]
@init {
	retval.values = new ArrayList<String>();
}
	: ^(VALUES (value {retval.values.add($value.text);})+)
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
registerPackage
	: ^(REGISTER path=STRINGLITERAL)
		-> register(source={$REGISTER.source}, path={$path.text.substring(1, $path.text.length()-1)})
	;

//		EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
//		EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'	
execute // TODO optional where clause
	: ^(EXECUTE nameSet packageFunction primaryKey? valueList?)
		-> execute(source={$EXECUTE.source}, nameSpace={$nameSet.nameSpace}, setName={$nameSet.setName}, key={$primaryKey.value},
					package={$packageFunction.packageName}, udf={$packageFunction.functionName}, values={$valueList.st})	
	;

//	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
//	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
aggregate
	: ^(AGGREGATE nameSet  
				packageFunction expressions[$nameSet.nameSpace, $nameSet.setName] valueList?)
		-> aggregate(source={$AGGREGATE.source}, nameSpace={$nameSet.nameSpace}, setName={$nameSet.setName}, 
				package={$packageFunction.packageName}, function={$packageFunction.functionName},  
				arguments={$valueList.values}, where={$expressions.st})
	;
	

packageFunction returns [String packageName, String functionName]
	: p=IDENTIFIER '.' f=(IDENTIFIER|SCAN|GET|REMOVE)
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

//	SHOW PACKAGES
//	SHOW NAMESPACES|SETS|BINS
//	SHOW SCANS|QUERIES
//	SHOW INDEXES [namespace[.set]]
show 
	: ^(SHOW INDEXES nameSet?) -> showIndex(source={$SHOW.source}, nameSpace = {$nameSet.nameSpace}, setName = {$nameSet.setName})
	|	^(SHOW MODULES) 				-> showPackages(source={$SHOW.source})
  | ^(SHOW PACKAGES)         -> showPackages(source={$SHOW.source})
	| ^(SHOW NAMESPACES)			-> showNamespaces(source={$SHOW.source})
	| ^(SHOW SETS)						-> showSets(source={$SHOW.source})
	| ^(SHOW BINS)						-> showBins(source={$SHOW.source})
	| ^(SHOW SCANS)						-> showScans(source={$SHOW.source})
	| ^(SHOW QUERIES)					-> showQueries(source={$SHOW.source})
	;
	
//	DESC INDEX namespace indexname
//	DESC PACKAGE pkgname.extension
desc 
	: ^(DESC ^(MODULE moduleName))
		-> descPackage(source={$DESC.source}, name = {$moduleName.text})
	| ^(DESC ^(INDEX namespace_name index_name))
		-> descIndex(source={$DESC.source}, nameSpace = {$namespace_name.text}, indexName = {$index_name.text})
	;
	
//	STAT INDEX namespace indexname
//	STAT QUERY
//	STAT SYSTEM
stat
	: ^(STAT ^(INDEX namespace_name index_name))
		-> statIndex(source={$STAT.source}, nameSpace = {$namespace_name.text}, indexName = {$index_name.text})
	|	^(STAT QUERY)
		-> statQuery(source={$STAT.source})
	|	^(STAT SYSTEM)
		-> statSystem(source={$STAT.source})
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
	SET|GET VIEW JSON|TABLE [default at startup - TABLE]
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
		-> setTimeOut(source={$SET.source}, value={$timeOut.text})
	| ^(SET ^(VERBOSE verboseOn=booleanLiteral))
		-> setVerbose(source={$SET.source}, value={$verboseOn.text})
	| ^(SET ^(ECHO echoOn=booleanLiteral)) 
		-> setEcho(source={$SET.source}, value={$echoOn.text})
	| ^(SET ^(RECORD_TTL ttl=INTLITERAL))
		-> setTTL(source={$SET.source}, value={$ttl.text})
	| ^(SET ^(VIEW viewType))
		-> setView(source={$SET.source}, type={$viewType.text})
	| ^(SET ^(LUA_USER_PATH luaUserPath=STRINGLITERAL))
		-> setUserPath(source={$SET.source}, value={$luaUserPath.text.substring(1, $luaUserPath.text.length()-1)})
	| ^(SET ^(LUA_SYSTEM_PATH luaSysPath=STRINGLITERAL))
		-> setSystemPath(source={$SET.source}, value={$luaSysPath.text})
	;
get
	: ^(GET TIMEOUT)  				-> getTimeout(source={$GET.source})
	| ^(GET VERBOSE)					-> getVerbose(source={$GET.source})
	| ^(GET ECHO)							-> getEcho(source={$GET.source})
	| ^(GET RECORD_TTL)				-> getTTL(source={$GET.source})
	| ^(GET VIEW)							-> getView(source={$GET.source})
	| ^(GET LUA_USER_PATH)		-> getUserPath(source={$GET.source})
	| ^(GET LUA_SYSTEM_PATH)	-> getSystemPath(source={$GET.source})
	;



//	RUN 'filename' 	(Each line in the file contains an asql command)
run
	: ^(RUN STRINGLITERAL)
		-> run(source={$RUN.source}, fileName = {$STRINGLITERAL.text.replace("'","\"")})
	;
print
	: ^(PRINT STRINGLITERAL?) 
		-> print(source={$PRINT.source}, value = {($STRINGLITERAL.text == null)?"":$STRINGLITERAL.text.replace("'","\"")})
	;

//		KILL_QUERY transaction_id
kill_query 
	:	^(KILL_QUERY INTLITERAL)
		-> killQuery(source={$KILL_QUERY.source}, id = {$INTLITERAL.text})
	;

//	KILL_SCAN scan_id
kill_scan
	:	^(KILL_SCAN INTLITERAL)
		-> killScan(source={$KILL_SCAN.source}, id = {$INTLITERAL.text})
	;

// 	QUIT|EXIT|Q	
quit
	: QUIT 
	| EXIT
	| 'q'
	;
help
	: 'help'
	;

viewType
	: 'json'|'table'
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
	
value returns [String text]
	: STRINGLITERAL {$text = $STRINGLITERAL.text.replace("'", "\"");} // Kludge
	| INTLITERAL {$text = $INTLITERAL.text;}
	;

booleanLiteral
		: TRUE
		| FALSE
		;
moduleName returns [String text]
  : ident=IDENTIFIER '.' 
  ('lua' {$text = $ident.text + ".lua";}
  |'so'  {$text = $ident.text + ".so";}
  )
  ;

