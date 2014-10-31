package com.aerospike.aql.v2.grammar;
/**
 * This interface is a generic error reporter. It reports
 * the location of an error and an error message
 * @author peter
 *
 */
public interface IErrorReporter {
	void reportError(int line, int charStart, int charEnd, String message);
	int getErrors();
}
