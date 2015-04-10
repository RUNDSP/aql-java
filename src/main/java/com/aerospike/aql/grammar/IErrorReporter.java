package com.aerospike.aql.grammar;

import java.util.List;

import com.aerospike.client.AerospikeException;

/**
 * This interface is a generic error reporter. It reports
 * the location of an error and an error message
 * @author peter
 *
 */
public interface IErrorReporter {
	void reportError(int line, int charStart, int charEnd, String message);
	void reportError(int line, String message);
	void reportError(int line, AerospikeException e);
	int getErrorCount();
	List<String> getErrorList();
}
