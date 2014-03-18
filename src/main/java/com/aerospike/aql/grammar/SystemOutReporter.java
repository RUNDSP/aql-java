package com.aerospike.aql.grammar;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
import com.aerospike.client.command.Buffer;
import com.aerospike.client.query.RecordSet;

public class SystemOutReporter implements IResultReporter {

	public SystemOutReporter() {
	}

	@Override
	public void report(String message) {
		System.out.println(message);

	}

	@Override
	public void report(Record record) {
		System.out.print("Record found: ");
		if (record != null){
			for (String binName :record.bins.keySet()){
				String result = (String)record.getValue(binName);
				System.out.print(" bin="+binName +" value="+ result);
			}
		}
		System.out.println();

	}

	@Override
	public void report(RecordSet recordSet) {
		try {
			int count = 0;
			while (recordSet.next()) {
				Key key = recordSet.getKey();
				Record record = recordSet.getRecord();
				System.out.print("Record found: ns=" + key.namespace 
						+" set="+key.setName+" key="+Buffer.bytesToHexString(key.digest));
				for (String binName :record.bins.keySet()){
					String result = (String)record.getValue(binName);
					System.out.print(" bin="+binName +" value="+ result);
				}
				System.out.println();
				count++;
			}
			if (count == 0) {
				System.out.println("No records returned.");			
			}
		} catch (AerospikeException e) {
			e.printStackTrace();
		} finally {
			if (recordSet != null) {
				recordSet.close();
			}

		}
	}

	@Override
	public void report(Level level, String message) {
		switch (level){
		case DEBUG:
			System.out.println("DEBUG: " + message);
			break;
		case ERROR:
			System.err.println("ERROR: " + message);
			break;
		case WARN:
			System.out.println("WARN: " + message);
			break;
		case INFO:
			System.out.println("INFO: " + message);
			break;
		}
		
	}

	@Override
	public void report(String message, boolean clear) {
		this.report(message);
		
	}

	@Override
	public void report(Level level, String message, boolean clear) {
		this.report(level, message);
		
	}

	@Override
	public void report(Record record, boolean clear) {
		this.report(record);
		
	}

	@Override
	public void report(RecordSet recordSet, boolean clear) {
		this.report(recordSet);
		
	}

}
