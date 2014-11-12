/*
COMMANDS
    
    DDL
        CREATE INDEX <index> ON <ns>[.<set>] (<bin>) NUMERIC|STRING
        DROP INDEX <ns>[.<set>] <index>
        
            <ns> is the namespace for the index.
            <set> is the set name for the index.
            <index> is the name of the index.
        
        Examples:
        
            CREATE INDEX idx_foo ON test.demo (foo) NUMERIC
            DROP INDEX test.demo idx_foo
        
    DML
        INSERT INTO <ns>[.<set>] (PK, <bins>) VALUES (<key>, <values>)
        DELETE FROM <ns>[.<set>] WHERE PK = <key>
        
            <ns> is the namespace for the record.
            <set> is the set name for the record.
            <key> is the record's primary key.
            <key> is the record's primary key.
            <bins> is a comma-separated list of bin names.
            <values> is comma-separated list of bin values.
        
        Examples:
        
            INSERT INTO test.demo (PK, foo, bar) VALUES ('key1', 123, 'abc')
            DELETE FROM test.demo WHERE PK = 'key1'
        
    QUERY
        SELECT <bins> FROM <ns>[.<set>]
        SELECT <bins> FROM <ns>[.<set>] WHERE <bin> = <value>
        SELECT <bins> FROM <ns>[.<set>] WHERE <bin> BETWEEN <lower> AND <upper>
        SELECT <bins> FROM <ns>[.<set>] WHERE PK = <key>
        
            <ns> is the namespace for the records to be queried.
            <set> is the set name for the record to be queried.
            <key> is the record's primary key.
            <bin> is the name of a bin.
            <value> is the value of a bin.
            <bins> can be either a wildcard (*) or a comma-separated list of bin names.
            <lower> is the lower bound for a numeric range query.
            <upper> is the lower bound for a numeric range query.
        
        Examples:
        
            SELECT * FROM test.demo
            SELECT * FROM test.demo WHERE PK = 'key1'
            SELECT foo, bar FROM test.demo WHERE PK = 'key1'
            SELECT foo, bar FROM test.demo WHERE foo = 123
            SELECT foo, bar FROM test.demo WHERE foo BETWEEN 0 AND 999
        
    MANAGE UDFS
        REGISTER MODULE <filepath>
        SHOW MODULES
        REMOVE MODULE <filename>
        DESC MODULE <filename>
        
            <filepath> is file path to the UDF module.
            <filename> is file name of the UDF module.
        
        Examples:
        
            REGISTER MODULE ~/test.lua
            SHOW MODULES
            DESC MODULE test.lua
            REMOVE MODULE test.lua
        
    INVOKING UDFS
        EXECUTE <module>.<function>(<args>) ON <ns>[.<set>]
        EXECUTE <module>.<function>(<args>) ON <ns>[.<set>] WHERE PK = <key>
        AGGREGATE <module>.<function>(<args>) ON <ns>[.<set>] WHERE <bin> = <value>
        AGGREGATE <module>.<function>(<args>) ON <ns>[.<set>] WHERE <bin> BETWEEN <lower> AND <upper>
        
            <module> is UDF module containing the function to invoke.
            <function> is UDF to invoke.
            <args> is a comma-separated list of argument values for the UDF.
            <ns> is the namespace for the records to be queried.
            <set> is the set name for the record to be queried.
            <key> is the record's primary key.
            <bin> is the name of a bin.
            <value> is the value of a bin.
            <lower> is the lower bound for a numeric range query.
            <upper> is the lower bound for a numeric range query.
        
        Examples:
        
            EXECUTE myudfs.udf1(2) ON test.demo
            EXECUTE myudfs.udf1(2) ON test.demo WHERE PK = 'key1'
            AGGREGATE myudfs.udf2(2) ON test.demo WHERE foo = 123
            AGGREGATE myudfs.udf2(2) ON test.demo WHERE foo BETWEEN 0 AND 999
        
    INFO
        SHOW NAMESPACES | SETS | BINS | INDEXES
        SHOW SCANS | QUERIES
        STAT NAMESPACE <ns> | INDEX <ns> <indexname>
        STAT SYSTEM
        
    JOB MANAGEMENT
        KILL_QUERY <transaction_id>
        KILL_SCAN <scan_id>
        
    SETTINGS
        TIMEOUT        (time in ms)  
        RECORD_TTL     (time in ms)  
        VERBOSE        (true | false)
        ECHO           (true | false)
        OUTPUT         (table | json) 
        LUA_USERPATH   <path>
        LUA_SYSPATH    <path>
        
        To get the value of a setting, run:
          
            aql> GET <setting>
          
        To set the value of a setting, run:
          
            aql> SET <setting> <value>
          
    OTHER
        RUN <filepath>
        HELP
        QUIT|EXIT|Q

*/
grammar AQL;
options {
    language=Java;
}
//tokens {
//// imaginary nodes	
//SELECT_ALL,
//SELECT_EXPLICIT,
//NAMESET,
//FILTERS,
//BIN_NAMES
//}
@header {
package com.aerospike.aql.v2.grammar;
import java.util.Set;
import java.util.HashSet;
}

@members {
public enum VariableDefinition {
	CLIENT, 
	RECORD, 
	RECORD_SET, 
	RESULT_SET, 
	CLIENT_POLICY,
	WRITE_POLICY, 
	READ_POLICY,
	QUERY_POLICY,
	SCAN_POLICY,
	INFO_POLICY,
	STMT,
	UDF_FILE,
	REGISTER_TASK,
	INDEX_TASK,
	INFO_STRING;
}

public Set<VariableDefinition> definitions = new HashSet<VariableDefinition>();
}
/**
A whole qql file
*/
aql 
	:  statements EOF
	;
statements
  : statement* 
  ;
/**
The supported aql statements
*/	
statement 
locals [String source, String nameSpace, String setName]
	: connect //generator exec
	| disconnect //generator exec
	| create //generator exec
	| drop  //generator exec
	| remove //generator exec
	| insert //generator exec
	| update //generator exec
	| delete //generator exec
	| select //generator exec
	| register //generator exec
	| execute //generator 
	| aggregate //generator 
	| operate //generator 
	| show //generator 
	| desc //generator 
	| stat //generator 
	| set //generator
	| get //generator
	| run //generator
	| kill //generator 
	| quit 
	| help 
	| print //generator 
	;

connect
	: CONNECT hostName=STRINGLITERAL port=INTLITERAL
	{
		definitions.add(VariableDefinition.CLIENT);
	}
	;
	
disconnect
	: DISCONNECT
	;


/**
CREATE INDEX indexname ON namespace[.setname] (binname) NUMERIC|STRING
*/
create
	: 
	CREATE INDEX index_name ON nameSet
		'(' binName=bin ')' iType=(NUMERIC | STRING)
	{
  	definitions.add(VariableDefinition.WRITE_POLICY);
  	definitions.add(VariableDefinition.INDEX_TASK);
	} 
		
	;
	
/**
DROP INDEX namespace[.setname] indexname
DROP MODULE modulename.extension 
*/
drop 
	: DROP (
	    INDEX nameSet index_name 
	| MODULE moduleName 
	| SET nameSet 
	)
	
	;
	
remove 
  : REMOVE MODULE moduleName 
  ;

operate 
	: OPERATE operateFunction (',' operateFunction)* ON nameSet WHERE primaryKeyPredicate (AND generationPredicate)?
	{
	  	definitions.add(VariableDefinition.WRITE_POLICY);
	  	definitions.add(VariableDefinition.READ_POLICY);
	  	definitions.add(VariableDefinition.RECORD);
	} 
	;
	
/*
DML:
	INSERT INTO namespace[.setname] (PK,binnames,,,) VALUES ('pk',nnn,'xxx',,)
	DELETE FROM namespace[.setname] WHERE PK = 'x'

*/
/**	
INSERT INTO namespace[.setname] (PK,binnames,,,) VALUES ('pk',nnn,'xxx',,)
*/
insert 
	: INSERT INTO nameSet '(' PK (',' binNameList) ')'
		VALUES '(' primaryKey[$statement::nameSpace, $statement::setName] (',' valueList) ')' 
	{
		definitions.add(VariableDefinition.WRITE_POLICY);
	}  	
		
	;
/**
 * UPDATE <name space>[.<set name>] SET <bin name> = <value>, ... WHERE PK = <value> [AND generation = <value>]
 */	
update 
	: UPDATE nameSet SET updateList
		WHERE primaryKeyPredicate (AND generationPredicate)?
	{
		definitions.add(VariableDefinition.WRITE_POLICY);
	}  	
	;
	
updateList
	: (ttlValue | binValue) (',' binValue)*
	;

/**
DELETE FROM namespace[.setname] WHERE PK = 'x'
*/
delete 
	: DELETE FROM nameSet WHERE primaryKeyPredicate (AND generationPredicate)?
	{
	definitions.add(VariableDefinition.WRITE_POLICY);
	}  	
	;
/**
	SELECT *|bin,,,  FROM namespace[.setname]
	SELECT *|bin,,,  FROM namespace[.setname] ORDER BY xxx
	SELECT *|bin,,,  FROM namespace[.setname] WHERE bin = nnn
	SELECT *|bin,,,  FROM namespace[.setname] WHERE bin = 'xxx'
	SELECT *|bin,,,  FROM namespace[.setname] WHERE bin BETWEEN nnn AND mmm
	SELECT *|bin,,,  FROM namespace[.setname] WHERE PK = 'x'
	Note:SELECT...WHERE bin ... needs an INDEX on bin. Use CREATE INDEX first.
*/	
select 
	: SELECT 
	( STAR  
	| binNameList) FROM nameSet where? 
	{
	definitions.add(VariableDefinition.READ_POLICY);
	definitions.add(VariableDefinition.SCAN_POLICY);
	definitions.add(VariableDefinition.RECORD);
	definitions.add(VariableDefinition.STMT);
	}  	
	;
	

where
	: WHERE predicate
	;

	
operateFunction
	: 'add' '(' bin ',' value ')'
	| 'put' '(' bin ',' value ')'
	| 'append' '(' bin ',' value ')'
	| 'prepend' '(' bin ',' value ')'
	| 'get' ('(' bin ')')?
	| 'touch'
	| 'header'
	;
	
nameSet 
locals [String namespaceName, String setName]
@after{
	$statement::nameSpace = $namespaceName;
	$statement::setName = $setName;
}
	: namespace_name {$namespaceName = $namespace_name.text;}
	('.' set_name {$setName = $set_name.text;})?
	
	;

/*
UDF:
	REGISTER MODULE 'filepath'
	REMOVE MODULE pkgname.extension
	EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
	EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'
	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
	AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
UDF
*/
// clinfo -v udf-list
// clinfo -v udf-get:filename=<filename> --> Base64 encoded

/**
REGISTER MODULE 'filepath'
*/
register 
	: REGISTER MODULE filepath=filePath
	{
	definitions.add(VariableDefinition.READ_POLICY);
	definitions.add(VariableDefinition.REGISTER_TASK);
	definitions.add(VariableDefinition.UDF_FILE);
	}  	
	;

/**
EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'	
*/
execute // TODO optional where clause
	: EXECUTE moduleFunction '(' valueList? ')'
		ON nameSet (where)? 
	{
	definitions.add(VariableDefinition.READ_POLICY);
	}  	
	;

/**
AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
*/
aggregate 
	: AGGREGATE moduleFunction ('(' (valueList)? ')')? ON nameSet (where)?
	{
	definitions.add(VariableDefinition.QUERY_POLICY);
	definitions.add(VariableDefinition.RESULT_SET);
	definitions.add(VariableDefinition.STMT);
	}  	
	;

moduleFunction
	: packageName=IDENTIFIER '.' functionName=IDENTIFIER
	;
	
binNameList 
	: (TTL|bin) (',' bin)* 
	;
	
valueList 
	:  value (',' value )* 
	;
	
predicate
	: (primaryKeyPredicate | filterPredicate)
	;

primaryKeyPredicate
	: PK EQ primaryKey[$statement::nameSpace, $statement::setName]
	;

generationPredicate
	: 'generation' EQ INTLITERAL
	;	
	
filterPredicate
	: (equalityFilter | rangeFilter)
	{
	definitions.add(VariableDefinition.QUERY_POLICY);
	definitions.add(VariableDefinition.RECORD_SET);
	}  	
	;

equalityFilter 
	: binValue
	;
	
ttlValue
	: TTL EQ integerValue
	;
	
binValue
	: bin EQ value
	;
	
rangeFilter
	: bin BETWEEN low=integerValue AND high=integerValue
	;
		
/*
INFO:
	SHOW MODULES
	SHOW NAMESPACES|SETS|BINS
	SHOW SCANS|QUERIES
	SHOW INDEXES [namespace[.set]]
	DESC INDEX namespace indexname
	DESC MODULE pkgname.extension
	STAT INDEX namespace indexname
	STAT QUERY
	STAT SYSTEM
*/

/**
SHOW MODULES
SHOW NAMESPACES|SETS|BINS
SHOW SCANS|QUERIES
SHOW INDEXES [namespace[.set]]
*/
show 
	: SHOW 
	( INDEXES nameSet? 
	| SCANS
	| NAMESPACES
	| SETS
	| BINS
	| QUERIES
	| MODULES
	)
	{
	definitions.add(VariableDefinition.INFO_POLICY);
	definitions.add(VariableDefinition.INFO_STRING);
	}
	;
	
/**
DESC INDEX namespace indexname
DESC MODULE pkgname.extension
*/
desc 
	: DESC 
		(
		MODULE moduleName 
		| INDEX namespace_name index_name 
		) 
	{
	definitions.add(VariableDefinition.INFO_POLICY);
	definitions.add(VariableDefinition.INFO_STRING);
	}
	;
	
/**
STAT INDEX namespace indexname
STAT QUERY
STAT SYSTEM
*/
stat 
	: STAT
	(INDEX namespace_name index_name 
	|	QUERY 
	|	SYSTEM 
	)
	{
	definitions.add(VariableDefinition.INFO_POLICY);
	definitions.add(VariableDefinition.INFO_STRING);
	}
	;
/*
ADMIN:
	# text_string - comment in script, line skipped.
	

	NOTE: Do not specify value with GET. eg: SET ECHO true, GET ECHO
	Note: These are client side paths for lua files.

	KILL_QUERY transaction_id
	KILL_SCAN scan_id
	RUN 'filename' 	(Each line in the file contains an asql command)
	HELP
	QUIT|EXIT|Q
*/

/*

Settings
  SET|GET VIEW JSON|TABLE [default at startup - TABLE] @@
  SET|GET VERBOSE true|false [default false]
  SET|GET ECHO true|false [default false]
  SET|GET TIMEOUT timeout_ms [default 1000]
  SET|GET RECORD_TTL record_ttl_sec [default 0 - never expire]
  SET|GET LUA_USERPATH 'path' [default /opt/citrusleaf/usr/udf/lua]
  SET|GET LUA_SYSPATH 'path' [default /opt/citrusleaf/sys/udf/lua]

*/
set 
	: SET 
	(TIMEOUT timeOut=INTLITERAL 							
	| VERBOSE verboseOn=booleanLiteral 						
	| ECHO echoOn=booleanLiteral 							
	| TTL ttl=INTLITERAL		 						
	| VIEW viewType 										       
  	| OUTPUT viewType                             
	| LUA_USER_PATH luaUserPath=STRINGLITERAL	
	)
	;
get 
	: GET 
	( TIMEOUT  		 
	| VERBOSE 		
	| ECHO			
	| TTL 	
	| VIEW			
    | OUTPUT         
	| LUA_USER_PATH 	
	)
	;

viewType
	: 'json'|'table'|'nosql'|'lua'
	;


/**
RUN 'filename' 	(Each line in the file contains an asql command)
*/
run 
	: RUN STRINGLITERAL 
	;
/**
PRINT text_string
*/
print 
	: PRINT STRINGLITERAL? 
	;

kill 
	:	KILL ( QUERY | SCAN ) INTLITERAL
	;

	
/**
KILL_QUERY transaction_id
*/
kill_query 
	:	KILL_QUERY INTLITERAL 
	;

/**	
KILL_SCAN scan_id
*/
kill_scan 
	:	KILL_SCAN INTLITERAL 
	;

/**
QUIT|EXIT|Q	
*/
quit 
	: QUIT 
	| EXIT
	| 'q'
	;
/**
HELP
*/
help 
	: 'help'
	;

primaryKey [String nameSpace, String setName]
	: key=(STRINGLITERAL | INTLITERAL)
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
	
bin
	: IDENTIFIER
	;
	
value //Generate
	: integerValue | textValue
	;
textValue //Generate
	: STRINGLITERAL
	;
integerValue //Generate
	: INTLITERAL
	;
booleanLiteral
		: TRUE
		| FALSE
		;
moduleName
  : IDENTIFIER '.' ('lua'|'so')
  ;

filePath
  : STRINGLITERAL
//  : '/'? IDENTIFIER ('/' IDENTIFIER)* ('.' IDENTIFIER)?
//  | '\\'? IDENTIFIER ('\\' IDENTIFIER)* ('.' IDENTIFIER)?
  ;
TRUE
	: 'true'
	;
FALSE
	: 'false'
	;

// real nodes
CONNECT: 'connect';
DISCONNECT: 'disconnect';
DESC: 'desc';
INSERT: 'insert';
SELECT: 'select';
DELETE
	: 'delete'
	;
CREATE
	: 'create'
	;
INDEX
	: 'index'
	;
EXECUTE
	: 'execute'
	;
WHERE
	: 'where'
	;
SHOW
	: 'show'
	;
DROP
	: 'drop'
	;
INDEXES
 	:	'indexes'
	;
VALUES
	: 'values'
	;
SET
	:	'set'
	;
GET
	:	'get'
	;
MODULE
	: 'module'
	;
ON
	:	'on'
	;
OPERATE
	: 'operate'
	;
OUTPUT
  	: 'output'
  	;
PACKAGES
  : 'packages'
  ;
INTO
	: 'into'
	;
FUNCTION
  : 'function'
  ;
FROM
	: 'from'
	;
BY
	: 'by'
	;
AND
	: 'and'
	;
BETWEEN
	: 'between'
	;
RUN
	: 'run'
	;
STAT
	: 'stat'
	;
QUERY
	: 'query'
	;
SCAN
	: 'scan'
	;
TIMEOUT
	: 'timeout'
	;
QUIT
	: 'quit'
	;
EXIT
	: 'exit'
	;
KILL
	: 'kill'
	;
KILL_QUERY
	: 'kill_query'
	;
KILL_SCAN
	: 'kill_scan'
	;
PK 
	: 'pk'
	;
STRING
	: 'string'
	;
NUMERIC
	: 'numeric'
	;
	
EQ
	: '='
	;

STAR
	: '*'
	;
REGISTER 
	: 'register'
	;
REMOVE
	: 'remove'
	;
AGGREGATE
	: 'aggregate'
	;
MODULES
	: 'modules'
	;
NAMESPACES
	:	'namespaces'
	;
SETS
	:	'sets'
	;
BINS
	: 'bins'
	;
SCANS
	: 'scans'
	;
QUERIES
	:	'queries'
	;
SYSTEM
	: 'system'
	;
ORDER
	: 'order'
	;
PRINT : 'print';
UPDATE : 'update';
VERBOSE : 'verbose'; 
ECHO 		: 'echo'; 
TTL : 'ttl'; 
VIEW 		: 'view'; 
USE_SMD	: 'use_smd'; 
LUA_USER_PATH : 'lua_userpath'; 
LUA_SYSTEM_PATH : 'lua_syspath'; 	




IDENTIFIER : ( LETTER | UNDERSCORE )( LETTER| DIGIT | UNDERSCORE | HYPHEN)*;

    
/**
Single quote delimited string 
e.g. 'cats' or 'cat\'s'
*/
STRINGLITERAL
    :   '\''
    ( EscapeSequence | ~('\\'|'\'') )* 
    '\''
    ; 
	
FLOATLITERAL
  : ('+'|'-')? IntegerNumber '.' IntegerNumber?
  ;
   
INTLITERAL
    :   ('+'|'-')? IntegerNumber 'L'?
    ;
    
HEXLITERAL
  : HexPrefix HexDigit HexDigit
  ;

//PATHSEGMENT
//  : (LETTER | DIGIT | '.' | '_')+
//  ;


fragment
IntegerNumber
    :   '0' 
    |   '1'..'9' ('0'..'9')*    
    |   '0' ('0'..'7')+         
    ;
  
fragment
HexPrefix
    :   '\\x' | '\\X'
    ;
        
fragment HexDigit
    :   (DIGIT|'a'..'f'|'A'..'F')
    ;
   
fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment UNDERSCORE : '_';
fragment HYPHEN : '-';
fragment SEMICOLON : ';';
fragment EscapeSequence 
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\''|'\\')         
    ;
NEWLINE: '\r'? '\n' -> channel(HIDDEN);     // return newlines to parser (end-statement signal)

WS: [ \r\t\u000C\n]+ -> channel(HIDDEN);

/**
# text_string - comment in script, line skipped.
*/
COMMENT
    :   '#' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
	;    	
