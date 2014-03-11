#AQL implemented in Java
Aerospike [AQL](https://docs.aerospike.com/pages/viewpage.action?pageId=3807532) is a utility that executes Aerospike Query Language. Like the other Aerospike utilities, it is Linux only.

[AQL implemented in Java](https://github.com/aerospike/aql-java) is a utility written in Java so it can run where ever Java can run. It will execut in one of following modes:
 1. Translate - translates the AQL to a runnable Java/C/C# application with the correct Aerospike API calls
 2. Interactive - executes the AQL, using the Java API, as it is interpreted.
 
All the classes that make up this utility are packaged into a JAR. This makes them available to any other application that wants to use them. 


##How
[ANTLR 3](http://www.antlr3.org/) is used as the parser generator, and Java is the implementation language. (ANTLR can also generate parsers in C, C# and a bunch of other languages)
There are 3 grammars that generate parsers:
* AQLast - checks syntax and generates an Abstract Syntax Tree (AST)
* AQLCodeGenerator - This a tree walker that walks the AST and generates code (Java, C, C#) based using [ANTLR StringTemplates](http://www.stringtemplate.org/).
* AQLExecutor - This is a tree walker that walks the AST and executes the statements using the Java API
 
###Code generation
Gode generation is achieved using [StringTemplates](http://www.stringtemplate.org/). There is a StringTemplate for each target language, these are:
* AS_C_Sharp.st - for C#
* AS_C.st - for C
* AS_Java.st - for Java

The templates are located in the same directory as AQL.java at: src/main/java/com/aerospike/aql. The AQL class expects them to be there, so don't move them!


##Why
Developers work on many platforms. Most developers are use SQL and AQL will be very familiar to them. A quick way to learn Aerospike and get a prototype up and running is to:
 1. Write an AQL script interact with Aerospike matching the use case.
 2. Use Portable AQL to test the AQL starements interactively
 3. Use Portable AQL to generate a runnable application in Java, C or C#
 4. Take the generated code and include it in the "real" application
 
##Build
The code can be built with Maven. 
	
	mvn clean package

##Dependencies
* Aerospike Java client 3.0.22
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
java -jar aql-3.0.0-jar-with-dependencies.jar -h 192.168.21.150 -p 3000 -c test/resources/PkTest.aql -o output/PkTest.java -l JAVA
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

|Offical AQL        |Java AQL           |
|-----------------|-------------------|
|Print \<some text\>|Print '\<some text\>'|

