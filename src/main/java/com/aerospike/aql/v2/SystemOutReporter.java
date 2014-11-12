package com.aerospike.aql.v2;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.aerospike.aql.v2.grammar.IErrorReporter;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;

public class SystemOutReporter implements IResultReporter, IErrorReporter {
	boolean cancelled = false;
	int errors = 0;
	
	public SystemOutReporter() {
	}

	@Override
	public void report(String message) {
		System.out.println(message);

	}

	@Override
	public void report(Key key, Record record, boolean clear) {
		report(key, record);
		
	}
	@Override
	public void report(Key key, Record record) {
		if (record != null){
			System.out.print("Record: ");
			if (key != null){
				System.out.print(key.toString() + " ");
			}
			for (String binName :record.bins.keySet()){
				String result = record.getValue(binName).toString();
				System.out.print(" bin="+binName +" value="+ result);
			}
			System.out.println();
		}
	}
	@Override
	public void report(Record record) {
		report(null, record);

	}

	@Override
	public void report(RecordSet recordSet) {
		try {
			int count = 0;
			while (recordSet.next()) {
				Key key = recordSet.getKey();
				Record record = recordSet.getRecord();
				System.out.print("Record: " + key.toString());
				for (String binName :record.bins.keySet()){
					String result = record.getValue(binName).toString();
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

	@Override
	public void reportInfo(String inforMessage, String... seperators) {
		reportInfo(inforMessage, false, seperators);

	}

	@Override
	public void reportInfo(String inforMessage, boolean clear,
			String... seperators) {
		printInfo(inforMessage, seperators);
	}
	protected void printInfo(String infoString, String... seperators){
		if (infoString == null || infoString.isEmpty() || seperators == null )
			return;
		if (seperators.length >= 1){
			String[] outerParts = infoString.split(seperators[0]);
			String rowFormat = null;
			for (int i = 0; i < outerParts.length; i++){
				if (seperators.length >= 2){
					String[] innerParts = outerParts[i].split(seperators[1]);
					if (i == 0){
						StringBuffer sb = new StringBuffer("| ");
						for (int j = 0; j < innerParts.length; j++){
							sb.append("%").append(innerParts[j].length()).append("s | ");
						}
						rowFormat = sb.toString();
						System.out.println(String.format(rowFormat, nameValueParts(innerParts, true)));
					}
					System.out.println(String.format(rowFormat, nameValueParts(innerParts, false)));
				}
			}
		}
	}
	private String[] nameValueParts(String[] parts, boolean headerRow){
		String[] nvs = new String[parts.length];
		for (int i = 0; i < parts.length; i++) {
			String[] nv = parts[i].split("=");
			if (headerRow){
				nvs[i] = nv[0];
			} else if (nv.length > 1){
				nvs[i] = nv[1];
			}
		}
		return nvs;
	}

	@Override
	public void cancel() {
		this.cancelled = true;
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
		
	}

	@Override
	public void reportError(int line, int charStart, int charEnd, String message) {
		this.errors++;
		System.out.println(String.format("Error on Line: %d at %d, %s", line, charStart, message));
	}

	public int getErrors() {
		return errors;
	}

	@Override
	public void report(AerospikeException e) {
		System.out.println(String.format("Aerospike %s", e.getMessage()));
		//e.printStackTrace();
		
	}

	@Override
	public void report(ResultSet resultSet) {
		this.report(resultSet, false);
		
	}

	@Override
	public void report(ResultSet resultSet, boolean clear) {
		try {
			int count = 0;
			while (resultSet.next()) {
				Object object = resultSet.getObject();
				count++;
				System.out.println(String.format("Result %d: %s", count, object.toString()));
			}
			if (count == 0) {
				System.out.println("No results returned.");			
			}
		}
		finally {
			resultSet.close();
		}
	}

	@Override
	public void reportInfo(String[] inforMessages, String... seperators) {
		this.reportInfo(inforMessages, false, seperators);
		
	}

	@Override
	public void reportInfo(String[] inforMessages, boolean clear,
			String... seperators) {
		for (String message : inforMessages){
			this.printInfo(message, seperators);
		}
		
	}

	public String getStackTrace(Throwable throwable) {
		StringWriter sw = new StringWriter();
		throwable.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}


}
