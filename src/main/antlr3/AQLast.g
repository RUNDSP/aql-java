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
grammar AQLast;
options {
    language=Java;
    backtrack=true;
    memoize=true;
    output=AST;
    ASTLabelType=AQLTree;
}
tokens {
// imaginary nodes	
SELECT_ALL;
SELECT_EXPLICIT;
NAMESET;
FILTERS;
BIN_NAMES;
VALUES;
// real nodes
DESC
	= 'desc'
	;
INSERT
	= 'insert'
	;
SELECT
	= 'select'
	;
DELETE
	= 'delete'
	;
CREATE
	= 'create'
	;
INDEX
	= 'index'
	;
EXECUTE
	= 'execute'
	;
WHERE
	= 'where'
	;
SHOW
	= 'show'
	;
DROP
	= 'drop'
	;
INDEXES
 	=	'indexes'
	;
VALUES
	= 'values'
	;
SET
	=	'set'
	;
GET
	=	'get'
	;
MODULE
	= 'module'
	;
ON
	=	'on'
	;
OUTPUT
  = 'output'
  ;
PACKAGES
  = 'packages'
  ;
INTO
	= 'into'
	;
FROM
	= 'from'
	;
BY
	= 'by'
	;
AND
	= 'and'
	;
BETWEEN
	= 'between'
	;
RUN
	= 'run'
	;
STAT
	= 'stat'
	;
QUERY
	= 'query'
	;
SCAN
	= 'scan'
	;
TIMEOUT
	= 'timeout'
	;
QUIT
	= 'quit'
	;
EXIT
	= 'exit'
	;
KILL
	= 'kill'
	;
KILL_QUERY
	= 'kill_query'
	;
KILL_SCAN
	= 'kill_scan'
	;
PK 
	= 'pk'
	;
STRING
	= 'string'
	;
NUMERIC
	= 'numeric'
	;
	
EQ
	= '='
	;

STAR
	= '*'
	;
REGISTER 
	= 'register'
	;
REMOVE
	= 'remove'
	;
AGGREGATE
	= 'aggregate'
	;
MODULES
	= 'modules'
	;
NAMESPACES
	=	'namespaces'
	;
SETS
	=	'sets'
	;
BINS
	= 'bins'
	;
SCANS
	= 'scans'
	;
QUERIES
	=	'queries'
	;
SYSTEM
	= 'system'
	;
ORDER
	= 'order'
	;
PRINT
	= 'print'
	;
VERBOSE = 'verbose'; 
ECHO 		= 'echo'; 
RECORD_TTL = 'record_ttl'; 
VIEW 		= 'view'; 
USE_SMD	= 'use_smd'; 
LUA_USER_PATH = 'lua_userpath'; 
LUA_SYSTEM_PATH = 'lua_syspath'; 	
}
@header {
package com.aerospike.aql.grammar;
}
@members {
  private IErrorReporter errorReporter = null;
  private IResultReporter resultReporter = new SystemOutReporter();
   
  public void setErrorReporter(IErrorReporter errorReporter) {
      this.errorReporter = errorReporter;
  }
  public void setResultReporter(IResultReporter resultReporter) {
	  if (resultReporter != null)
	      this.resultReporter = resultReporter;
  }

  public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        super.displayRecognitionError(tokenNames, e);
        
	  		if (errorReporter != null) {
	  			//String hdr = getErrorHeader(e);
	  			String msg = getErrorMessage(e, tokenNames);
	  			int line = e.line;
    	  	int charStart = e.charPositionInLine;
    	  	int charEnd = charStart + e.token.getText().length();
	  			errorReporter.reportError(line, charStart, charEnd, msg);
	  		}
    }
    
}
@lexer::header {
package com.aerospike.aql.grammar;
}
/**
A whole asqu file
*/
aqlFile 
	:  aqlStatements EOF
	;
aqlStatements
  : aqlStatement*
  ;
/**
The supported asql statements
*/	
aqlStatement 
	: create 
	| drop 
	| remove
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
	| kill
	| quit
	| help
	| print
	;

/**
CREATE INDEX indexname ON namespace[.setname] (binname) NUMERIC|STRING
*/
create 
@after{$create.tree.source = $create.text;}
	: CREATE INDEX index_name ON nameSet
		'(' binName=bin ')' indexType 
		-> ^(CREATE index_name nameSet bin indexType)
	;
	
/**
DROP INDEX namespace[.setname] indexname
DROP MODULE modulename.extension 
*/
drop 
@after{$drop.tree.source = $drop.text;}
	: DROP (
	    INDEX nameSet index_name -> ^(DROP ^(INDEX index_name nameSet))
	| MODULE moduleName -> ^(DROP ^(MODULE moduleName))
	| SET nameSet -> ^(DROP ^(SET nameSet))
	)
	
	;
	
remove
@after{$remove.tree.source = $remove.text;}
  : REMOVE MODULE moduleName -> ^(DROP ^(MODULE moduleName))
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
/**	
INSERT INTO namespace[.setname] (PK,binnames,,,) VALUES ('pk',nnn,'xxx',,)
*/
insert 
@after{$insert.tree.source = $insert.text;}
	: INSERT INTO nameSet '(' PK (',' binNameList) ')'
		VALUES '(' primaryKey (',' valueList) ')' 
		-> ^(INSERT nameSet primaryKey binNameList valueList)
		
	;
/**
DELETE FROM namespace[.setname] WHERE PK = 'x'
*/
delete 
@after{$delete.tree.source = $delete.text;}
	: DELETE FROM nameSet WHERE PK '=' primaryKey 
		-> ^(DELETE nameSet primaryKey)
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
@after{$select.tree.source = $select.text;}
	: SELECT 
	( STAR  from -> ^(SELECT_ALL from) 
	| binNameList from -> ^(SELECT_EXPLICIT binNameList from)) 
	;
	
	
from
	: FROM nameSet (WHERE expressions)? 
		-> ^(FROM nameSet (^(WHERE expressions))?) 
	;

expressions 
	: PK '=' value -> ^(PK value )
	| filter+ -> ^(FILTERS filter)
		
	;
	
filter 
	: bin '=' value -> ^(EQ bin value)
	| b2=bin BETWEEN low=INTLITERAL AND high=INTLITERAL -> ^(BETWEEN $b2 $low $high)
	;

nameSet 
	: namespace_name ('.' set_name)?
		-> ^(NAMESET namespace_name set_name?)
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
registerPackage
@after{$registerPackage.tree.source = $registerPackage.text;}
	: REGISTER MODULE filepath=filePath
		-> ^(REGISTER $filepath)
	;

/**
EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname]
EXECUTE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE PK = 'X'	
*/
execute // TODO optional where clause
@after{$execute.tree.source = $execute.text;}
	: EXECUTE moduleFunction '(' valueList? ')'
		ON nameSet (WHERE PK '=' primaryKey)? 
		-> ^(EXECUTE nameSet moduleFunction primaryKey? valueList? )
	;

/**
AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin = nnn
AGGREGATE pkgname.funcname(arg1,arg2,,) ON namespace[.setname] WHERE bin BETWEEN nnn AND mmm
*/
aggregate
@after{$aggregate.tree.source = $aggregate.text;}
	: AGGREGATE moduleFunction '(' valueList? ')' ON nameSet WHERE expressions
		-> ^(AGGREGATE nameSet moduleFunction expressions valueList?)
	;

moduleFunction
	: packageName=IDENTIFIER '.' functionName=IDENTIFIER
	;
	
binNameList 
	: bin (',' bin)* -> ^(BIN_NAMES bin+)
	;
	
valueList 
	:  value (',' value )* -> ^(VALUES value+)
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
@after{$show.tree.source = $show.text;}
	: SHOW 
	( INDEXES nameSet? 
		-> ^(SHOW INDEXES nameSet?)
	| MODULES
		-> ^(SHOW MODULES)
	| NAMESPACES
		-> ^(SHOW NAMESPACES)
	| SETS
		-> ^(SHOW SETS)
	| BINS
		-> ^(SHOW BINS)
	| SCANS
		-> ^(SHOW SCANS)
	| QUERIES
		-> ^(SHOW QUERIES)
  | PACKAGES
    -> ^(SHOW PACKAGES)
	)
	;
	
/**
DESC INDEX namespace indexname
DESC MODULE pkgname.extension
*/
desc 
@after{$desc.tree.source = $desc.text;}
	: DESC 
		(
		MODULE moduleName -> ^(DESC ^(MODULE moduleName))
		| INDEX namespace_name index_name -> ^(DESC ^(INDEX namespace_name index_name))
		) 
	;
	
/**
STAT INDEX namespace indexname
STAT QUERY
STAT SYSTEM
*/
stat
@after{$stat.tree.source = $stat.text;}
	: STAT
	(INDEX namespace_name index_name -> ^(STAT ^(INDEX namespace_name index_name))
	|	QUERY -> ^(STAT QUERY)
	|	SYSTEM -> ^(STAT SYSTEM)
	)
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
@after{$set.tree.source = $set.text;}
	: SET 
	(TIMEOUT timeOut=INTLITERAL 							-> ^(SET ^(TIMEOUT $timeOut))
	| VERBOSE verboseOn=booleanLiteral 						-> ^(SET ^(VERBOSE $verboseOn))
	| ECHO echoOn=booleanLiteral 							-> ^(SET ^(ECHO $echoOn))
	| RECORD_TTL ttl=INTLITERAL		 						-> ^(SET ^(RECORD_TTL $ttl))
	| VIEW viewType 										         -> ^(SET ^(VIEW viewType))
  | OUTPUT viewType                              -> ^(SET ^(OUTPUT viewType))
	| LUA_USER_PATH luaUserPath=STRINGLITERAL		  -> ^(SET ^(LUA_USER_PATH $luaUserPath))
	| LUA_SYSTEM_PATH luaSysPath=STRINGLITERAL				-> ^(SET ^(LUA_SYSTEM_PATH $luaSysPath))
	)
	;
get
@after{$get.tree.source = $get.text;}
	: GET 
	( TIMEOUT  				-> ^(GET TIMEOUT) 
	| VERBOSE 				-> ^(GET VERBOSE)
	| ECHO						-> ^(GET ECHO)
	| RECORD_TTL 			-> ^(GET RECORD_TTL)
	| VIEW						-> ^(GET VIEW)
  | OUTPUT          -> ^(GET OUTPUT)
	| LUA_USER_PATH 	-> ^(GET LUA_USER_PATH)
	| LUA_SYSTEM_PATH -> ^(GET LUA_SYSTEM_PATH)
	)
	;

viewType
	: 'json'|'table'|'nosql'|'lua'
	;


/**
RUN 'filename' 	(Each line in the file contains an asql command)
*/
run
@after{$run.tree.source = $run.text;}
	: RUN STRINGLITERAL -> ^(RUN STRINGLITERAL)
	;
/**
PRINT text_string
*/
print
@after{$print.tree.source = $print.text;}
	: PRINT STRINGLITERAL? -> ^(PRINT STRINGLITERAL?) 
	;

kill 
@after{$kill.tree.source = $kill.text;}
	:	KILL
	( QUERY INTLITERAL -> ^(KILL_QUERY INTLITERAL)
	| SCAN INTLITERAL -> ^(KILL_SCAN INTLITERAL)
	)
	;

	
/**
KILL_QUERY transaction_id
*/
kill_query 
@after{$kill_query.tree.source = $kill_query.text;}
	:	KILL_QUERY INTLITERAL -> ^(KILL_QUERY INTLITERAL)
	;

/**	
KILL_SCAN scan_id
*/
kill_scan
@after{$kill_scan.tree.source = $kill_scan.text;}
	:	KILL_SCAN INTLITERAL -> ^(KILL_SCAN INTLITERAL)
	;

/**
QUIT|EXIT|Q	
*/
quit
@after{$quit.tree.source = $quit.text;}
	: QUIT 
	| EXIT
	| 'q'
	;
/**
HELP
*/
help
@after{$help.tree.source = $help.text;}
	: 'help'
	;

primaryKey
	: key=STRINGLITERAL -> ^(PK $key)
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
	
value
	: STRINGLITERAL
	| INTLITERAL
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

/********************************************************************************************
                  Lexer section
*********************************************************************************************/
TRUE
	: 'true'
	;
FALSE
	: 'false'
	;

	
WS  
    :   (
             ' '
        |    '\r'
        |    '\t'
        |    '\u000C'
        |    NL
        ) {$channel = HIDDEN;}
    ;
    
/**
# text_string - comment in script, line skipped.
*/
COMMENT
    :   '#' .* NL {$channel = HIDDEN;}
    ;   

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
    :   ('+'|'-')? IntegerNumber 
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
NL
  : '\r\n' 
  | '\n'
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
//fragment NEWLINE   : '\r' '\n' | '\n' | '\r';
fragment EscapeSequence 
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\''|'\\')         
    ;