#AQL implemented in Java
Aerospike [AQL](https://docs.aerospike.com/pages/viewpage.action?pageId=3807532) is a utility that executes Aerospike Query Language. Like the other Aerospike utilities, it is Linux only. It is does not exercise Aerospikes advanced capabilities.

AQL2 is written in Java, so it will run anywhere where Java will run.

[AQL2 is written in Java](https://github.com/aerospike/aql-java), so it will run anywhere where Java will run.] is a utility written in Java so it can run where ever Java can run. It will execute in one of following modes:

 1. Translate - translates the AQL to a runnable Java application with the correct Aerospike API calls
 2. Interactive - executes the AQL, using the Java API, as it is interpreted.
 3. Embedded into your application to use AQL as you interface to Aerospike. 
 
All the classes that make up this utility are packaged into a JAR. This makes them available to any other application that wants to use them. 


##How
[ANTLR 4](http://www.antlr4.org/) is used as the parser generator, and Java is the implementation language. (ANTLR can also generate parsers in C, C# and a many other languages)
The grammar that generates the parser is AQL.g4. The generated parser uses a tree listener and implements actions based on the recognition events in the parse tree. There are 2 Tree listeners:

* `AQLExecutor` - Executes the AQL statements on a live cluster. 
* `AQLGenerator` - Generates code (Java) based using [ANTLR StringTemplates](http://www.stringtemplate.org/).

 
###Code generation
code generation is achieved using [StringTemplates](http://www.stringtemplate.org/). There is a StringTemplate for each target language, these are:

* AS_Go.stg - for Go
* AS_Java.stg - for Java
* AS_C_Sharp.stg - for C#

The templates are located in the same directory as AQL.java at: src/main/java/com/aerospike/aql. The AQL class expects them to be there, so don't move them!


##Why
Developers work on many platforms. Most developers are use SQL and AQL will be very familiar to them. A quick way to learn Aerospike and get a prototype up and running is to:

 1. Write an AQL script interact with Aerospike matching the use case.
 2. Use Portable AQL to test the AQL statements interactively
 3. Use Portable AQL to generate a runnable application in Java, C or C#
 4. Take the generated code and include it in the "real" application
 
##Build
The code can be built with Maven. 
```bash	
	mvn clean package
```
##Dependencies

* Aerospike Java client 3.1.00
* Apache commons cli 1.2
* Log4j 1.2.17
* ANTLR 4.x


##Status
 1. Java generation - complete
 2. Go generation - partial
 3. C# generation - complete
 4. Execution - complete
 5. API calls - limited testing
```

## Usage
The packaged Jar can be run with the following:

```bash
java -jar aql2-2.0.0-jar-full.jar -h localhost -p 3000 -c test/resources/PkTest.aql -o output/PkTest.java -l JAVA
```	

Where:
```	
-c,--compile <arg>    AQL file name to compile
-h,--host <arg>       Server hostname (default: localhost)
-l,--language <arg>   Target language, supported languages: Go and JAVA. Only valid with -c
	                      option
-n,--namespace <arg>  Namespace (default: test)
-o,--output <arg>     Output file name. Only valid with -c option
-p,--port <arg>       Server port (default: 3000)
-s,--set <arg>        Set name. Use 'empty' for empty set (default: demoset)
-u,--usage            Print usage.
```

