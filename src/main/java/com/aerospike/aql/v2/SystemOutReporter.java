package com.aerospike.aql.v2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.aerospike.aql.v2.grammar.IErrorReporter;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
import com.aerospike.client.util.Util;

public class SystemOutReporter implements IResultReporter, IErrorReporter {
	boolean cancelled = false;
	int errors = 0;
	private ViewFormat format = ViewFormat.TEXT;
	
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
			switch (this.format) {
			case JSON:
				break;
			case TABLE:
				break;
			default: //TEXT:

				System.out.print("Record: ");
				if (key != null){
					System.out.print(key.toString() + " ");
				}
				for (String binName :record.bins.keySet()){
					String result = record.getValue(binName).toString();
					System.out.print(" bin="+binName +" value="+ result);
				}
				System.out.println();
				break;
			}
		}
	}
	@Override
	public void report(Record record) {
		report(null, record);

	}

	@Override
	public void report(RecordSet recordSet) {
		switch (this.format) {
		case JSON:
			break;
		case TABLE:
			break;
		default: //TEXT:

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
			break;
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
		if (infoString == null || infoString.isEmpty())
			return;
		if ( seperators == null || seperators.length == 0 ){
			System.out.println(infoString);
			return;
		}
		
		if (seperators.length == 3 ){
			Map<String, Map<String, String>> result = makeElementMap(infoString, seperators[0], seperators[1], seperators[2], "=");
			switch (this.format) {
			case JSON:
				break;
			case TABLE:
				break;
			default: //TEXT:
				System.out.println(result);
				break;
			}
			
			return;
		}
		if (seperators.length == 1 ){
			Map<String, String> result = makeValueMap(infoString, seperators[0], "=");
			switch (this.format) {
			case JSON:
				break;
			case TABLE:
				break;
			default: //TEXT:
				System.out.println(result);
			}
			return;
		}
		
		System.out.println("WFT:"+infoString);
	}
	
	private Map<String, Map<String, String>> makeElementMap(String input, String elementSeperator, String keySeperator, String valueSeperator, String equator){
		Map<String, Map<String, String>> result = new HashMap<String, Map<String,String>>();
			String[] parts = input.split(elementSeperator);
			for (String element : parts){
				String[] chunks = element.split(keySeperator);
				String key = chunks[0];
				Map<String, String> value = makeValueMap(chunks[1], valueSeperator, equator);
				result.put(key, value);
			}
		return result;
	}
	
	private Map<String, String> makeValueMap(String input, String seperator, String equator){
		Map<String, String> result = new HashMap<String, String>();
		String[] parts = input.split(seperator);
		for (String element : parts){
			String[] chunks = element.split(equator);
			result.put(chunks[0], (chunks.length ==2) ? chunks[1] : chunks[0]);
		}
		return result;
	}
	
//	private String[] nameValueParts(String[] parts, boolean headerRow){
//		String[] nvs = new String[parts.length];
//		for (int i = 0; i < parts.length; i++) {
//			String[] nv = parts[i].split("=");
//			if (headerRow){
//				nvs[i] = nv[0];
//			} else if (nv.length > 1){
//				nvs[i] = nv[1];
//			}
//		}
//		return nvs;
//	}

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
		switch (this.format) {
		case JSON:
			break;
		case TABLE:
			break;
		default: //TEXT:
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
			break;
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

	@Override
	public void setViewFormat(ViewFormat format) {
		this.format = format;
	}
}
