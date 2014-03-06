package com.aerospike.aql.grammar;

import com.aerospike.client.Record;
import com.aerospike.client.Log.Level;
import com.aerospike.client.query.RecordSet;

public interface IResultReporter {
	public void report(String message);
	public void report(Level level, String message);
	public void report(Record record);
	public void report(RecordSet recordSet);
}
