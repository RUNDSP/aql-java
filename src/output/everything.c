//==========================================================
// Includes
//

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdlib.h>

#include <aerospike/aerospike.h>
#include <aerospike/aerospike_key.h>
#include <aerospike/aerospike_query.h>
#include <aerospike/as_error.h>
#include <aerospike/as_key.h>
#include <aerospike/as_query.h>
#include <aerospike/as_record.h>
#include <aerospike/as_status.h>
#include <aerospike/as_val.h>



//==========================================================
// Constants
//

const char DEFAULT_HOST[] = "192.168.51.188";
const int DEFAULT_PORT = 3000;


int
main(int argc, char* argv[]) // Main routing for everything
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

	// select * from test.people where pk = 'toby'
	as_key_init_int64(&key, "test", "people", "toby");
	if (aerospike_key_get(&as, &err, NULL, &key, &rec) !=
			AEROSPIKE_ERR_RECORD_NOT_FOUND) {
		LOG("aerospike_key_get() returned %d - %s, expected "
				"AEROSPIKE_ERR_RECORD_NOT_FOUND", err.code, err.message);
		as_record_destroy(p_rec);
		example_cleanup(&as);
	}


	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "1");
	as_record_set_int64(&rec, "bn2", 1);
	as_record_set_int64(&rec, "bn3", "1");
	as_record_set_int64(&rec, "bn4", 1);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "2");
	as_record_set_int64(&rec, "bn2", 2);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "3");
	as_record_set_int64(&rec, "bn2", 3);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "4");
	as_record_set_int64(&rec, "bn2", 4);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "5");
	as_record_set_int64(&rec, "bn2", 5);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "6");
	as_record_set_int64(&rec, "bn2", 6);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "7");
	as_record_set_int64(&rec, "bn2", 7);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "8");
	as_record_set_int64(&rec, "bn2", 8);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "9");
	as_record_set_int64(&rec, "bn2", 9);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2)
	as_record_inita(&rec, 3);
	as_key_init_int64(&key, "test", "demo", "10");
	as_record_set_int64(&rec, "bn2", 10);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);

	if (aerospike_key_put(&as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
	}
				
	// CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC
	if (aerospike_index_integer_create(&as, &err, NULL, "test", "demo",
			"bn2", "index_bn2") != AEROSPIKE_OK) {
		LOG("aerospike_index_integer_create() returned %d - %s", err.code,
				err.message);
		return false;
	}
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.
					
	// CREATE INDEX index_bn3 ON test.demo (bn3) STRING
	if (aerospike_index_integer_create(&as, &err, NULL, "test", "demo",
			"bn3", "index_bn3") != AEROSPIKE_OK) {
		LOG("aerospike_index_integer_create() returned %d - %s", err.code,
				err.message);
		return false;
	}
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.
					
	// SELECT * FROM test.demo
	as_scan scan;
	as_scan_init(&scan, "test", "demo");
	as_scan_select_inita(&scan, 0);
	if ( aerospike_scan_foreach(&as, &err, NULL, &scan, scan_cb, NULL) != AEROSPIKE_OK ) {
	    fprintf(stderr, "error(%d) %s at [%s:%d]", err.code, err.message, err.file, err.line);
	}
	s_scan_destroy(&scan);

	// SELECT * FROM test.demo WHERE bn4 = 2
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_equals(2));

	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
	}
	LOG("query executed");
	as_query_destroy(&query);

	// SELECT * FROM test.demo WHERE bn3 = '2'
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn3", integer_equals("2"));

	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
	}
	LOG("query executed");
	as_query_destroy(&query);

	// SELECT * FROM test.demo WHERE bn4 BETWEEN 1 AND 2
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_range(1, 2));

	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
	}
	LOG("query executed");
	as_query_destroy(&query);

	// SELECT * FROM test.demo WHERE PK = '10'
	as_key_init_int64(&key, "test", "demo", "10");
	if (aerospike_key_get(&as, &err, NULL, &key, &rec) !=
			AEROSPIKE_ERR_RECORD_NOT_FOUND) {
		LOG("aerospike_key_get() returned %d - %s, expected "
				"AEROSPIKE_ERR_RECORD_NOT_FOUND", err.code, err.message);
		as_record_destroy(p_rec);
		example_cleanup(&as);
	}


	// SELECT bn2,bn3,bn4  FROM test.demo
	as_scan scan;
	as_scan_init(&scan, "test", "demo");
	as_scan_select_inita(&scan, 3);
	as_scan_select(&scan, "bn2");
	as_scan_select(&scan, "bn3");
	as_scan_select(&scan, "bn4");

	if ( aerospike_scan_foreach(&as, &err, NULL, &scan, scan_cb, NULL) != AEROSPIKE_OK ) {
	    fprintf(stderr, "error(%d) %s at [%s:%d]", err.code, err.message, err.file, err.line);
	}
	s_scan_destroy(&scan);

	// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 = 2
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_equals(2));

	as_query_select_init(&query, 3);
	as_query_select(&scan, "bn2");
	as_query_select(&scan, "bn3");
	as_query_select(&scan, "bn4");
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
	}
	LOG("query executed");
	as_query_destroy(&query);

	// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn3 = '2'
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn3", integer_equals("2"));

	as_query_select_init(&query, 3);
	as_query_select(&scan, "bn2");
	as_query_select(&scan, "bn3");
	as_query_select(&scan, "bn4");
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
	}
	LOG("query executed");
	as_query_destroy(&query);

	// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 BETWEEN 1 AND 2
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_range(1, 2));

	as_query_select_init(&query, 3);
	as_query_select(&scan, "bn2");
	as_query_select(&scan, "bn3");
	as_query_select(&scan, "bn4");
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
	}
	LOG("query executed");
	as_query_destroy(&query);

	// SELECT bn2,bn3,bn4  FROM test.demo WHERE PK = '10'
	as_key_init_int64(&key, "test", "demo", "10");
	if (aerospike_key_get(&as, &err, NULL, &key, &rec) !=
			AEROSPIKE_ERR_RECORD_NOT_FOUND) {
		LOG("aerospike_key_get() returned %d - %s, expected "
				"AEROSPIKE_ERR_RECORD_NOT_FOUND", err.code, err.message);
		as_record_destroy(p_rec);
		example_cleanup(&as);
	}


	// REGISTER module 'src/test/resources/example1.lua'
	int rc = 0;
	as_bytes content;
	uint32_t content_len = 0;
	as_bytes_init(&content);

	rc = read_file("src/test/resources/example1.lua", &content, &content_len); 	   

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

	// REGISTER module 'src/test/resources/sum_example.lua'
	int rc = 0;
	as_bytes content;
	uint32_t content_len = 0;
	as_bytes_init(&content);

	rc = read_file("src/test/resources/sum_example.lua", &content, &content_len); 	   

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

	// REGISTER module 'src/test/resources/average_example.lua'
	int rc = 0;
	as_bytes content;
	uint32_t content_len = 0;
	as_bytes_init(&content);

	rc = read_file("src/test/resources/average_example.lua", &content, &content_len); 	   

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

	// SHOW modules

	// desc module example1.lua
	if ( aerospike_info_foreach(&as, &err, NULL, "udf-get:filename=example1.lua", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// desc module average_example.lua
	if ( aerospike_info_foreach(&as, &err, NULL, "udf-get:filename=average_example.lua", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// EXECUTE example1.foo('arg1','arg2',3) ON test.demo WHERE PK = '1'
	test
	demo
	"1"
	example1
	foo


	// drop module example1.lua

	// AGGREGATE sum_example.sum_single_bin('bn4') ON test.demo WHERE bn4 BETWEEN 1 AND 2
	as_query query;
	as_query_init(&query, "test", "demo");
	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_range(1, 2));


	sum_example
	sum_single_bin
	, Value.get("bn4")
			
	// SHOW NAMESPACES
	if ( aerospike_info_foreach(&as, &err, NULL, "namespaces", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// show SETS
	if ( aerospike_info_foreach(&as, &err, NULL, "sets", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// sHoW BiNS
	if ( aerospike_info_foreach(&as, &err, NULL, "bins", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// SHOW SCAnS
	if ( aerospike_info_foreach(&as, &err, NULL, "scans", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// shoW qUERIES
	if ( aerospike_info_foreach(&as, &err, NULL, "queries", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// SHOW INDEXES test.demo
	if ( aerospike_info_foreach(&as, &err, NULL, "sindex", info_cb, NULL) != AEROSPIKE_OK ) {
	    // handle error
	}

	// DESC INDEX test index_bn2

	// STAT INDEX test index_bn3

	// STAT QUERY

	// STAT SYSTEM

	// PRINT 'text_string'
	fprintf(stderr, ""text_string"\n");

	// SET VERBOSE true

	// SET VERBOSE false

	// SET ECHO true

	// SET ECHO false

	// SET TIMEOUT 1500

	// SET RECORD_TTL 0

	// SET VIEW TABLE

	// SET VIEW JSON

	// SET LUA_USERPATH '/opt/citrusleaf/usr/udf/lua'

	// SET LUA_SYSPATH '/opt/citrusleaf/sys/udf/lua'

	// GET VERBOSE

	// GET ECHO

	// GET TIMEOUT

	// GET RECORD_TTL

	// GET VIEW

	// GET LUA_USERPATH

	// GET LUA_SYSPATH

	// DELETE FROM test.demo WHERE PK = '1'
	as_key_init_int64(&key, "test", "demo", "1");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '2'
	as_key_init_int64(&key, "test", "demo", "2");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '3'
	as_key_init_int64(&key, "test", "demo", "3");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '4'
	as_key_init_int64(&key, "test", "demo", "4");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '5'
	as_key_init_int64(&key, "test", "demo", "5");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '6'
	as_key_init_int64(&key, "test", "demo", "6");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '7'
	as_key_init_int64(&key, "test", "demo", "7");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '8'
	as_key_init_int64(&key, "test", "demo", "8");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '9'
	as_key_init_int64(&key, "test", "demo", "9");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '10'
	as_key_init_int64(&key, "test", "demo", "10");
	aerospike_key_remove(&as, &err, NULL, &key);

	// DROP INDEX test.demo index_bn2
	aerospike_index_remove(&as, &err, NULL, "test", "index_bn2");
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.

	// DROP INDEX test.demo index_bn3
	aerospike_index_remove(&as, &err, NULL, "test", "index_bn3");
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.



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
