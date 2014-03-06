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

const char DEFAULT_HOST[] = "127.0.0.1";
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
	if (aerospike_connect(aerospike_init(p_as, &cfg), &err) != AEROSPIKE_OK) {
		LOG("aerospike_connect() returned %d - %s", err.code, err.message);
		aerospike_destroy(p_as);
		exit(-1);
	}

	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('1', 1, '1', 1)
	as_key_init_int64(&key, "test", "demo", "1");
	as_record_set_int64(&rec, "bn2", 1);
	as_record_set_int64(&rec, "bn3", "1");
	as_record_set_int64(&rec, "bn4", 1);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('2', 2, '2', 2)
	as_key_init_int64(&key, "test", "demo", "2");
	as_record_set_int64(&rec, "bn2", 2);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('3', 3, '2', 2)
	as_key_init_int64(&key, "test", "demo", "3");
	as_record_set_int64(&rec, "bn2", 3);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('4', 4, '2', 2)
	as_key_init_int64(&key, "test", "demo", "4");
	as_record_set_int64(&rec, "bn2", 4);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('5', 5, '2', 2)
	as_key_init_int64(&key, "test", "demo", "5");
	as_record_set_int64(&rec, "bn2", 5);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('6', 6, '2', 2)
	as_key_init_int64(&key, "test", "demo", "6");
	as_record_set_int64(&rec, "bn2", 6);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('7', 7, '2', 2)
	as_key_init_int64(&key, "test", "demo", "7");
	as_record_set_int64(&rec, "bn2", 7);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('8', 8, '2', 2)
	as_key_init_int64(&key, "test", "demo", "8");
	as_record_set_int64(&rec, "bn2", 8);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('9', 9, '2', 2)
	as_key_init_int64(&key, "test", "demo", "9");
	as_record_set_int64(&rec, "bn2", 9);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// INSERT INTO test.demo (PK, bn2, bn3, bn4) VALUES ('10', 10, '2', 2)
	as_key_init_int64(&key, "test", "demo", "10");
	as_record_set_int64(&rec, "bn2", 10);
	as_record_set_int64(&rec, "bn3", "2");
	as_record_set_int64(&rec, "bn4", 2);


	// Write a record to the database.
	if (aerospike_key_put(p_as, &err, NULL, &key, &rec) != AEROSPIKE_OK) {
		LOG("aerospike_key_put() returned %d - %s", err.code, err.message);
		return false;
	}
				
	// CREATE INDEX index_bn2 ON test.demo (bn2) NUMERIC
	if (aerospike_index_integer_create(p_as, &err, NULL, "test", "demo",
			"bn2", "index_bn2") != AEROSPIKE_OK) {
		LOG("aerospike_index_integer_create() returned %d - %s", err.code,
				err.message);
		return false;
	}
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.
					
	// CREATE INDEX index_bn3 ON test.demo (bn3) STRING
	if (aerospike_index_integer_create(p_as, &err, NULL, "test", "demo",
			"bn3", "index_bn3") != AEROSPIKE_OK) {
		LOG("aerospike_index_integer_create() returned %d - %s", err.code,
				err.message);
		return false;
	}
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.
					
	// SELECT * FROM test.demo

	test
	demo




	// SELECT * FROM test.demo WHERE bn4 = 2

	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_equals(2));

	// Execute the query. This call blocks - callbacks are made in the scope of
	// this call.
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
		exit(-1);
	}

	LOG("query executed");

	as_query_destroy(&query);




	// SELECT * FROM test.demo WHERE bn3 = '2'

	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn3", integer_equals("2"));

	// Execute the query. This call blocks - callbacks are made in the scope of
	// this call.
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
		exit(-1);
	}

	LOG("query executed");

	as_query_destroy(&query);




	// SELECT * FROM test.demo WHERE bn4 BETWEEN 1 AND 2

	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_range(1, 2));

	// Execute the query. This call blocks - callbacks are made in the scope of
	// this call.
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
		exit(-1);
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
		exit(-1);
	}





	// SELECT bn2,bn3,bn4  FROM test.demo

	test
	demo




	// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 = 2

	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_equals(2));

	"bn2", "bn3", "bn4"
	// Execute the query. This call blocks - callbacks are made in the scope of
	// this call.
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
		exit(-1);
	}

	LOG("query executed");

	as_query_destroy(&query);




	// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn3 = '2'

	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn3", integer_equals("2"));

	"bn2", "bn3", "bn4"
	// Execute the query. This call blocks - callbacks are made in the scope of
	// this call.
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
		exit(-1);
	}

	LOG("query executed");

	as_query_destroy(&query);




	// SELECT bn2,bn3,bn4  FROM test.demo WHERE bn4 BETWEEN 1 AND 2

	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_range(1, 2));

	"bn2", "bn3", "bn4"
	// Execute the query. This call blocks - callbacks are made in the scope of
	// this call.
	if (aerospike_query_foreach(&as, &err, NULL, &query, query_cb, NULL) !=
			AEROSPIKE_OK) {
		LOG("aerospike_query_foreach() returned %d - %s", err.code,
				err.message);
		as_query_destroy(&query);
		cleanup(&as);
		exit(-1);
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
		exit(-1);
	}





	// SHOW NAMESPACES

	// show SETS

	// sHoW BiNS

	// SHOW SCAnS

	// shoW qUERIES

	// SHOW INDEXES test.demo
	String indexesString = Info.request(this.seedHost, this.port, "sindex");
	String[] indexes = indexesString.split(";");
	System.out.println("Indexes");
	for (String s : indexes){

		String[] indexParts = s.split(":");
		for (String parts : indexParts){
			System.out.println("\t" + parts);
		}
		System.out.println();
	}

	// DESC INDEX test index_bn2

	// DESC module bob

	// STAT INDEX test index_bn3

	// STAT QUERY

	// STAT SYSTEM

	// REGISTER module '/AerospikeAQLGrammar/TestData/example1-udf.lua'
	'/AerospikeAQLGrammar/TestData/example1-udf.lua'


	// SHOW modules

	// EXECUTE example-udf.foo('arg1','arg2',3) ON test.demo
	// Scan UDF 
	test
	demo
	example-udf
	foo

	// EXECUTE example-udf.foo('arg1','arg2',3) ON test.demo WHERE PK = '10'
	test
	demo
	"10"
	example-udf
	foo


	// AGGREGATE example-udf.foo('arg1','arg2',3) ON test.demo WHERE bn3 = 'smith'
	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn3", integer_equals("smith"));


	example-udf
	foo
	, Value.get("arg1"), Value.get("arg2"), Value.get(3)
			
	// AGGREGATE example-udf.foo('arg1','arg2',3) ON test.demo WHERE bn4 BETWEEN 1 AND 2
	// Create an as_query object.
	as_query query;
	as_query_init(&query, "test", "demo");

	as_query_where_inita(&query, 1);
	as_query_where(&query, "bn4", integer_range(1, 2));


	example-udf
	foo
	, Value.get("arg1"), Value.get("arg2"), Value.get(3)
			
	// DrOp module example-udf.lua

	// PRINT 'text_string'


	// SET VERBOSE true

	// SET VERBOSE false

	// SET ECHO true

	// SET ECHO false

	// SET TIMEOUT 150

	// SET RECORD_TTL 0

	// SET VIEW TABLE

	// SET VIEW JSON

	// SET USE_SMD true

	// SET USE_SMD false

	// SET LUA_USERPATH '/opt/citrusleaf/usr/udf/lua'

	// SET LUA_SYSPATH '/opt/citrusleaf/sys/udf/lua'

	// GET VERBOSE

	// GET ECHO

	// GET TIMEOUT

	// GET RECORD_TTL

	// GET VIEW

	// GET USE_SMD

	// GET LUA_USERPATH

	// GET LUA_SYSPATH

	// KILL_QUERY 12345

	// KILL_SCAN 54321

	// KILL QUERY 12345

	// KILL SCAN 54321

	// RUN 'filename'

	// DELETE FROM test.demo WHERE PK = '1'
	as_key_init_int64(&key, "test", "demo", "1");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '2'
	as_key_init_int64(&key, "test", "demo", "2");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '3'
	as_key_init_int64(&key, "test", "demo", "3");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '4'
	as_key_init_int64(&key, "test", "demo", "4");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '5'
	as_key_init_int64(&key, "test", "demo", "5");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '6'
	as_key_init_int64(&key, "test", "demo", "6");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '7'
	as_key_init_int64(&key, "test", "demo", "7");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '8'
	as_key_init_int64(&key, "test", "demo", "8");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '9'
	as_key_init_int64(&key, "test", "demo", "9");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DELETE FROM test.demo WHERE PK = '10'
	as_key_init_int64(&key, "test", "demo", "10");
	aerospike_key_remove(p_as, &err, NULL, &key);

	// DROP INDEX test.demo index_bn2
	aerospike_index_remove(p_as, &err, NULL, "test", "index_bn2");
	usleep(100 * 1000); // Wait for the system metadata to spread to all nodes.

	// DROP INDEX test.demo index_bn3
	aerospike_index_remove(p_as, &err, NULL, "test", "index_bn3");
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

