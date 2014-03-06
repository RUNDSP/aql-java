group as_c;
aqlFile(className, statements, host, port) ::= <<
//==========================================================
// Includes
//

#include \<stdbool.h\>
#include \<stddef.h\>
#include \<stdint.h\>
#include \<stdlib.h\>

#include \<aerospike/aerospike.h\>
#include \<aerospike/aerospike_key.h\>
#include \<aerospike/aerospike_query.h\>
#include \<aerospike/as_error.h\>
#include \<aerospike/as_key.h\>
#include \<aerospike/as_query.h\>
#include \<aerospike/as_record.h\>
#include \<aerospike/as_status.h\>
#include \<aerospike/as_val.h\>



//==========================================================
// Constants
//

const char DEFAULT_HOST[] = "<host>";
const int DEFAULT_PORT = <port>;


int
main(int argc, char* argv[]) // Main routing for <className>
{

	aerospike as;
	as_query query;
	as_error err;
	char namespace[MAX_NAMESPACE_SIZE];
	char set[MAX_SET_SIZE];
	as_key key;
	as_record rec;
	
	// Start with default configuration.
	as_config cfg;
	as_config_init(&cfg);

	// Must provide host and port. Example must have called example_get_opts()!
	cfg.hosts[0].addr = g_host;
	cfg.hosts[0].port = g_port;


	// Connect to the Aerospike database cluster. Assume this is the first thing
	// done, so it's ok to exit on failure.
	if (aerospike_connect(aerospike_init(&as, &cfg), &err) != AEROSPIKE_OK) {
		LOG("aerospike_connect() returned %d - %s", err.code, err.message);
		aerospike_destroy(&as);
		exit(-1);
	}

	<statements>

	// Cleanup and disconnect from the database cluster.
	cleanup(&as);

	return 0;
}

//==========================================================
// Query Callback
//

bool
query_cb(const as_val* p_val, void* udata)
{
	if (! p_val) {
		LOG("query callback returned null - query is complete");
		return true;
	}

	// The query didn't use a UDF, so the as_val object should be an as_record.
	LOG("query callback returned record:");
	
	// TODO process the record here

	// Caller's responsibility to destroy as_val returned.
	as_val_destroy(p_val);

	return true;
}

//==========================================================
// Scan Callback
//
bool scan_cb(const as_val * val, void * udata) {
    as_record * rec = as_record_fromval(val);
    if ( !rec ) return false;
    fprintf("record contains %d bins", as_record_numbins(rec));
    return true;
}

//==========================================================
// Info Callback
//
bool info_cb(const as_error * err, const char * node, char * res, void * udata) {
    // handle response
    free(res);
    res = NULL;
}
//==========================================================
// Read UDF file
//
int read_file (char * filename, byte **content, uint32_t * content_len) {
    fprintf(stderr, "Opening package file %s\n", filename); 
    FILE *fptr = fopen(filename,"r");
    if (!fptr) {
        fprintf(stderr, "error: cannot open script file %s : %s\n",filename,strerror(errno)); 
        return(-1);
    }
    int max_script_len = 1048576;
    byte *script_code = malloc(max_script_len);
    if (script_code == NULL) {
        fprintf(stderr, "error: malloc failed"); 
        return(-1);
	}    
	
	byte *script_ptr = script_code;
	int b_read = fread(script_ptr,1,512,fptr);
	int b_tot = 0;
	while (b_read) {
		b_tot      += b_read;
		script_ptr += b_read;
		b_read      = fread(script_ptr,1,512,fptr);
	}			
	script_code[b_tot] = 0;
    fclose(fptr);
    *content = script_code;
    *content_len = b_tot; 
	return 0;
}

>>

statement(stmt) ::= <<
<stmt>

>>

insertStmt(source, nameSpace, setName, primaryKey, binNames, values) ::= <<
// <source>
as_record_inita(&rec, <length(binNames)>);
as_key_init_int64(&key, "<nameSpace>", "<setName>", <primaryKey>);
<binNames,values:{z,vv|as_record_set_int64(&rec, "<z>", <vv>);<\n>}>
if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
	LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
}
			
>>
deleteStmt(source, nameSpace, setName, primaryKey) ::= <<
// <source>
as_key_init_int64(&key, "<nameSpace>", "<setName>", <primaryKey>);
aerospike_key_remove(&as, &err, NULL, &key);

>>

select(source, nameSpace, setName, binNames, as, where, key, orderBy) ::= <<
// <source>
<if(key)>
as_key_init_int64(&key, "<nameSpace>", "<setName>", <key>);
if (aerospike_key_get(&as, &err, NULL, &key, &rec) !=
		AEROSPIKE_ERR_RECORD_NOT_FOUND) {
	LOG("aerospike_key_get() returned %d - %s, expected "
			"AEROSPIKE_ERR_RECORD_NOT_FOUND", err.code, err.message);
	as_record_destroy(p_rec);
	example_cleanup(&as);
}
<elseif(where)>
<where>
<if(binNames)>
as_query_select_init(&query, <length(binNames)>);
<binNames:{b|as_query_select(&scan, "<b>");
}>
<endif>
if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
		AEROSPIKE_OK) {
	LOG("aerospike_query_foreach() returned %d - %s", err.code,
			err.message);
	as_query_destroy(&query);
	cleanup(&as);
}
LOG("query executed");
as_query_destroy(&query);
<else>
as_scan scan;
as_scan_init(&scan, "<nameSpace>", "<setName>");
as_scan_select_inita(&scan, <length(binNames)>);
<binNames:{b|as_scan_select(&scan, "<b>");
}>
if ( aerospike_scan_foreach(&as, &err, NULL, &scan, scan_cb, NULL) != AEROSPIKE_OK ) {
    fprintf(stderr, "error(%d) %s at [%s:%d]", err.code, err.message, err.file, err.line);
}
s_scan_destroy(&scan);
<endif>
<as>

>>



aggregate(source, nameSpace, setName, 
				package, function,  
				arguments, where) ::= <<
// <source>
<where>

<package>
<function>
<if(arguments)><arguments:{qq|, Value.get(<qq>)}><endif>
		
>>


create(source, indexName, nameSpace, setName, binName, type) ::= <<
// <source>
<if(type)>
if (aerospike_index_integer_create(&as, &err, NULL, "<nameSpace>", "<setName>",
		"<binName>", "<indexName>") != AEROSPIKE_OK) {
	LOG("aerospike_index_integer_create() returned %d - %s", err.code,
			err.message);
	return false;
}
<else>
if (aerospike_index_string_create(&as, &err, NULL, "<nameSpace>", "<setName>",
		"<binName>", "<indexName>") != AEROSPIKE_OK) {
	LOG("aerospike_index_integer_create() returned %d - %s", err.code,
			err.message);
	return false;
<endif>

usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.
				
>>

drop(source, indexName, nameSpace, setName) ::= <<
// <source>
aerospike_index_remove(&as, &err, NULL, "<nameSpace>", "<indexName>");
usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.

>>

showIndex(source, nameSpace, setName) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "sindex", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

statIndex(source, nameSpace, indexName) ::= <<
// <source>

>>

register(source, path) ::= <<
// <source>
int rc = 0;
as_bytes content;
uint32_t content_len = 0;
as_bytes_init(&content);

rc = read_file("<path>", &content, &content_len); 	   

if ( rc == 0 ) {
	as_bytes udf_content;
	as_bytes_init_wrap(&udf_content, content, content_len, true /*is_malloc*/);  // want to re-use content

	rc = citrusleaf_udf_put(asc, basename(filename), &udf_content, AS_UDF_LUA, &error);
	if ( rc != 0 ) {
		fprintf(stderr, "error: unable to upload module: %s\n", filename); 
		fprintf(stderr, "error: (%d) %s\n", rc, error); 
		free(error);
		error = NULL;
	}
	else {
		fprintf(stderr, "info: module uploaded: %s\n",filename); 
	}
	
	as_bytes_destroy(&udf_content);
}
else {   
	fprintf(stderr, "error: unable to read module: %s\n", filename);
}

>>

remove(source, package) ::= <<
// <source>

>>

execute(source, nameSpace, setName, key, package, udf, arguments) ::= <<
// <source>
<if(key)>
<nameSpace>
<setName>
<key>
<package>
<udf>
<arguments>


<else>
// Scan UDF 
<nameSpace>
<setName>
<package>
<udf>
<arguments>
<endif>

>>

wherePK(value) ::= <<
<value>

>>

whereFilter(nameSpace, setName, filters, binNames) ::= <<
as_query query;
as_query_init(&query, "<nameSpace>", "<setName>");
<if(binNames)>
<first(binNames):{z|"<z>"}><rest(binNames):{x|, "<x>"}>
<endif>
<if(filters)>
as_query_where_inita(&query, <length(filters)>);
<filters:{f|as_query_where(&query, <f>);<\n>}>
<endif>
>>

orderBy(list) ::= <<
<list>
>>

ascend(bin) ::= <<
<bin> ASC
>>

descend(bin) ::= <<
<bin> DESC
>>

setTimeOut(source, value) ::= <<
// <source>

>>
 
setVerbose(source, value) ::= <<
// <source>

>>

setEcho(source, value) ::= <<
// <source>

>>

setTTL(source, value) ::= <<
// <source>

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
// <source>

>>
getVerbose(source) ::= <<
// <source>

>>
getEcho(source) ::= <<
// <source>

>>
getTTL(source) ::= <<
// <source>

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
"<bin>", integer_equals(<value>)
>>

filterRange(bin, low, high) ::= <<
"<bin>", integer_range(<low>, <high>)
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
if ( aerospike_info_foreach(&as, &err, NULL, "namespaces", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

showSets(source) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "sets", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

showBins(source) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "bins", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

showScans(source) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "scans", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

showQueries(source) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "queries", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

descIndex(source, nameSpace, indexName) ::= <<
// <source>

>>


descPackage(source, name) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "udf-get:filename=<name>", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

killQuery(source, id) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "query-kill=<id>", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>

killScan(source, id) ::= <<
// <source>
if ( aerospike_info_foreach(&as, &err, NULL, "scan-kill=<id>", info_cb, NULL) != AEROSPIKE_OK ) {
    // handle error
}

>>
run(source, fileName) ::= <<
// <source>
printf(stderr, "Run file: <source>\n");

>>
print(source, value) ::= <<
// <source>
fprintf(stderr, "<value>\n");

>>