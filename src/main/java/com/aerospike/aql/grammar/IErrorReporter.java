package com.aerospike.aql.grammar;

public interface IErrorReporter {
	void reportError(int line, int charStart, int charEnd, String message);
}
