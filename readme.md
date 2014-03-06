#Portable AQL
Aerospike [AQL](https://docs.aerospike.com/pages/viewpage.action?pageId=3807532) is a utility that executes Aerospike Query Language. Like the other Aerospike utilities, it is Linux only.

[Portable AQL](https://github.com/aerospike/portable-aql) is a utility written in Java so it can run where ever Java can run. It will execut in one of following modes:
 1. Translate - translates the AQL to a runnable Java/C/C# application with the correct Aerospike API calls
 2. Interactive - executes the AQL, using the Java API, as it is interpreted.
 
All the classes that make up this utility are packaged into a JAR. This makes them available to any other application that wants to use them. 


##How
ANTLR 3 is used as the parser, and Java. (ANTLR can also generate in C, C# and a bunch of other languages)
There are 3 grammars:
* AQLast - checks syntax and generates an Abstract Syntax Tree (AST)
* AQLCodeGenerator - This a tree walker that walks the AST and generates code (Java, C, C#) based using ANTLR StringTemplates.
* AQLExecutor - This is a tree walker that walks the AST and executes the statements using the Java API

##Build
The code can be built with Maven. 
	
	mvn clean install

##Dependencies
* Aerospike Java client 3.0.20
* Apache commons cli 1.2
* Log4j 1.2.14
* ANTLR 3.4


##Status
 1. Java generation - complete
 2. C generation - partial
 3. C# - just started
 4. Execution - complete, but untested
 5. Java version of the existing AQL utility (platform independent) - started

##Future dreaming
It would be easy to add something like this to the Aerospike APIs:
```java
PreparedStatement - ps = client.prepare(“select * from test.cats where pk = ’27’”);
ResultSet rs = client.execute(ps);
```

## Usage
The packaged Jar can be run with the following:
```
java -jar aerospike-aql-<version>.jar -h 192.168.21.150 -p 3000 -c test/resources/PkTest.aql -o output/PkTest.java -l JAVA
```	
Where:
```	
-c,--compile <arg>    AQL file name to compile
-h,--host <arg>       Server hostname (default: localhost)
-l,--language <arg>   Target language, supported languages: C, CSHARP and JAVA. Only valid with -c
	                      option
-n,--namespace <arg>  Namespace (default: test)
-o,--output <arg>     Output file name. Only valid with -c option
-p,--port <arg>       Server port (default: 3000)
-s,--set <arg>        Set name. Use 'empty' for empty set (default: demoset)
-u,--usage            Print usage.
```
##Diferences with official AQL

|Linux AQL        |Java AQL           |
|-----------------|-------------------|
|Print \<some text\>|Print '\<some text\>'|

