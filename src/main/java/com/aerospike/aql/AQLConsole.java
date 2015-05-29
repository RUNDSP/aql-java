/* 
 * Copyright 2012-2015 Aerospike, Inc.
 *
 * Portions may be licensed to Aerospike, Inc. under one or more contributor
 * license agreements.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.aerospike.aql;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import jline.console.ConsoleReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.aerospike.aql.grammar.IErrorReporter;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
import com.aerospike.client.ScanCallback;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;

public class AQLConsole implements IResultReporter, IErrorReporter, ScanCallback{
	private static final int MAX_RECORDS = 100;
	boolean cancelled = false;
	int errors = 0;
	private ViewFormat format = ViewFormat.TABLE;
	ConsoleReader console;
	Object lastResult = null;
	enum Orientation { VERTICAL, HORIZONTAL };
	int recordCount = 0;
	private TreeMap<String, Integer> binList;
	private ArrayList<Record> recordList;
	private JSONArray jsonRecordList;
	private List<String> errorList = new ArrayList<String>();
	
	public ViewFormat getViewFormat() {
		return format;
	}


	public AQLConsole() throws IOException {
		console = new ConsoleReader();
		console.setPrompt("aql2> ");
	}

	public AQLConsole(ViewFormat viewFormat) throws IOException  {
		this();
		setViewFormat(viewFormat);
	}

	public void printf(String message, Object... args){
		try {
			console.print(String.format(message, args));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void print(String message){
		try {
			console.print(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void println(){
		try {
			console.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(Object object){
		try {
			console.println(object.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(String message, Object... args){
		try {
			console.println(String.format(message, args));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String readLine(){
		String line = null;
		try {
			while ((line = console.readLine()) != null) {
				return line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void report(String message) {
		println(message);

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
				println(recordJSON(record).toString(4));
				break;
			case TABLE:
				List<Record> recordList = new ArrayList<Record>();
				Map<String, Integer> binList = new TreeMap<String, Integer>();
				recordList.add(record);
				makeFieldMap(binList, record);
				printTableRecordList(recordList, binList);
				break;
			default: //TEXT:

				print("Record: ");
				if (key != null){
					print(key.toString() + " ");
				}
				for (String binName :record.bins.keySet()){
					String result = record.getValue(binName).toString();
					print(" bin="+binName +" value="+ result);
				}
				println();
				break;
			}
		} else {
			println("Record not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject recordJSON(Record record){
		JSONObject jObject = new JSONObject(record.bins);
		jObject.put("generation", record.generation);
		jObject.put("expiration", record.expiration);
		return jObject;
	}

	@SuppressWarnings("unchecked")
	private JSONObject keyJSON(Key key){
		JSONObject jKey = new JSONObject();
		jKey.put("namespace", key.namespace);
		jKey.put("set",key.setName);
		jKey.put("key", key.userKey);
		return jKey;
	}

	@Override
	public void report(Record record) {
		report(null, record);

	}

	@Override
	@SuppressWarnings("unchecked")
	public void report(RecordSet recordSet) {
		switch (this.format) {
		case JSON:
			try {
				int count = 0;
				JSONArray recordList = new JSONArray();
				while (recordSet.next()) {
					Key key = recordSet.getKey();
					JSONObject jrecord = recordJSON(recordSet.getRecord());
					JSONObject jKey = keyJSON(key);
					JSONObject jrow = new JSONObject();
					jrow.put("key", jKey);
					jrow.put("record", jrecord);
					recordList.put(jrow);
					count ++;
				}
				if (count == 0) {
					println("No records returned.");			
				} else {
					println(recordList.toString(4));
				}
			} catch (AerospikeException e) {
				e.printStackTrace();
			} finally {
				if (recordSet != null) {
					recordSet.close();
				}

			}
			break;
		case TABLE:
			try {
				int count = 0;
				List<Record> recordList = new ArrayList<Record>();
				Map<String, Integer> binList = new TreeMap<String, Integer>();
				while (recordSet.next()) {
					Record record = recordSet.getRecord();
					recordList.add(record);
					makeFieldMap(binList, record);
					count ++;
					if (count % 50 == 0){
						printTableRecordList(recordList, binList);
						recordList.clear();
					}
				}
				if (recordList.size() > 0){
					printTableRecordList(recordList, binList);
				}
			} catch (AerospikeException e) {
				e.printStackTrace();
			} finally {
				if (recordSet != null) {
					recordSet.close();
				}
			}
			break;
		default: //TEXT:

			try {
				int count = 0;
				while (recordSet.next()) {
					Key key = recordSet.getKey();
					Record record = recordSet.getRecord();
					print("Record: " + key.toString());
					for (String binName :record.bins.keySet()){
						String result = record.getValue(binName).toString();
						print(" bin="+binName +" value="+ result);
					}
					println();
					count++;
				}
				if (count == 0) {
					println("No records returned.");			
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
	
	private Map<String, Integer> makeFieldMap(Map<String, Integer> fieldMap, Record record ){
		if (fieldMap == null)
			fieldMap = new TreeMap<String, Integer>();
		Set<String> bins = record.bins.keySet();
		for (String bin : bins){
			Integer size = fieldMap.get(bin);
			Integer binValueSize = record.getValue(bin).toString().length();
			Integer binNameSize = bin.length();
			Integer fieldSize = Math.max(binNameSize, binValueSize);
			if (!fieldMap.containsKey(bin) || (size < fieldSize)) {
				fieldMap.put(bin, fieldSize);
			} 
		}
		return fieldMap;
	}
	private Map<String, Integer> makeFieldMap(Map<String, Integer> fieldMap,
			Map<String, Object> elements) {
		return this.makeFieldMap(fieldMap, elements, Orientation.HORIZONTAL);
	}
	private Map<String, Integer> makeFieldMap(Map<String, Integer> fieldMap,
			Map<String, Object> elements, Orientation orientation) {
		if (fieldMap == null)
			fieldMap = new TreeMap<String, Integer>();
		switch(orientation){
		case HORIZONTAL:
			Set<String> hfields = elements.keySet();
			for (String field : hfields){
				Integer size = fieldMap.get(field);
				Integer fieldValueSize = elements.get(field).toString().length();
				Integer fieldNameSize = field.length();
				Integer fieldSize = Math.max(fieldNameSize, fieldValueSize);
				if (!fieldMap.containsKey(field) || (size < fieldSize)) {
					fieldMap.put(field, fieldSize);
				} 
			}
			break;
		case VERTICAL:
			fieldMap.put("name", 0);
			fieldMap.put("value", 0);
			Set<String> vfields = elements.keySet();
			for (String field : vfields){
				Integer fieldNameSize = Math.max("name".length(), elements.get(field).toString().length());
				Integer fieldValueSize = field.length();
				Integer fieldSize = Math.max(fieldNameSize, fieldValueSize);
				fieldMap.put("name", fieldNameSize);
				fieldMap.put("value", fieldSize);
			}
			break;
		}
		return fieldMap;
	}

	private void printTableRecordList(List<Record> recordList, Map<String, Integer> fieldMap){
		printTableHeader(fieldMap);
		for (Record record : recordList){	
			printTableEntry(record, fieldMap);
		}
		printTableSeperator(fieldMap);
	}	
	
	private void printTableHeader(Map<String, Integer> fieldMap){
		Set<Entry<String, Integer>> fields = fieldMap.entrySet();
		printTableSeperator(fieldMap);
		print("|");
		for (Entry<String, Integer> bin : fields){
			print(" ");
			printField(bin.getKey(), bin.getValue());
			print(" |");
		}
		println();
		printTableSeperator(fieldMap);
	}
	
	private void printTableEntry(Record record, Map<String, Integer> fieldMap){
		Set<Entry<String, Integer>> fields = fieldMap.entrySet();
		print("|");
		for (Entry<String, Integer> field : fields){
			print(" ");
			String fieldname = field.getKey();
			Object value = record.getValue(fieldname);
			printField((value==null)?"":value.toString(), field.getValue());
			print(" |");
		}
		println();
	}
	
	private void printTableEntry(Map<String, Object> element,
			Map<String, Integer> fieldMap) {
		Set<Entry<String, Integer>> fields = fieldMap.entrySet();
		print("|");
		for (Entry<String, Integer> field : fields){
			print(" ");
			String elementString = (String) element.get(field.getKey());
			printField((elementString==null)?"":elementString, field.getValue());
			print(" |");
		}
		println();
		
	}
	
	private void printField(String value, int width){
		print(value);
		for (int i = value.length(); i < width; i++ )
			print(" ");
	}
	
	private void printTableSeperator(Map<String, Integer> fieldMap){
		Set<Entry<String, Integer>> fields = fieldMap.entrySet();
		print("+");
		for (Entry<String, Integer> field : fields){
			print("-");
			for (int i = 0; i < field.getValue(); i++)
				print("-");
			print("-+");
		}
		println();
	}
	
	@Override
	public void report(Level level, String message) {
		switch (level){
		case DEBUG:
			println("DEBUG: " + message);
			break;
		case ERROR:
			System.err.println("ERROR: " + message);
			break;
		case WARN:
			println("WARN: " + message);
			break;
		case INFO:
			println("INFO: " + message);
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
	public void reportInfo(Map<String, Object>[] infoElements) {
		switch (this.format){
		case JSON:
			JSONArray jsonList = new JSONArray();
			for (Map<String, Object> element : infoElements){
				JSONObject jsonElement = new JSONObject(element);
				jsonList.put(jsonElement);
			}
			println(jsonList.toString(4));
			break;
		case TABLE:
			Map<String, Integer> fieldMap = null;
			for (Map<String, Object> element : infoElements){
				fieldMap = makeFieldMap(fieldMap, element);
			}
			printTableHeader(fieldMap);
			for (Map<String, Object> element : infoElements){
				printTableEntry(element, fieldMap);
			}
			printTableSeperator(fieldMap);
			break;
		default:
			println(infoElements.toString());
			break;
		}

	}
	
	@Override
	public void reportInfo(Map<String, Object> infoElements) {
		switch (this.format){
		case JSON:
			JSONObject jsonElement = new JSONObject(infoElements);
			println(jsonElement.toString(4));
			break;
		case TABLE:
			Map<String, Integer> fieldMap = null;
			for (Entry<String, Object> element : infoElements.entrySet()){
				fieldMap = makeFieldMap(fieldMap, statEntryToMap(element));
			}
			printTableHeader(fieldMap);
			for (Entry<String, Object> element : infoElements.entrySet()){
				printTableEntry(statEntryToMap(element), fieldMap);
			}
			printTableSeperator(fieldMap);
			break;
		default:
			println(infoElements.toString());
			break;
		}
	}

	private Map<String, Object> entryToMap(Entry<String, Object> entry){
		Map<String, Object> newElement = new TreeMap<String, Object>();
		newElement.put(entry.getKey(), entry.getValue());
		return newElement;
	}
	private Map<String, Object> statEntryToMap(Entry<String, Object> entry){
		Map<String, Object> newElement = new TreeMap<String, Object>();
		newElement.put("Name", entry.getKey());
		newElement.put("Value", entry.getValue().toString());
		return newElement;
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
			println(infoString);
			return;
		}
		List<Map<String, Object>> elementList = null;
		switch (seperators.length){
		case 3:
			switch (this.format) {
			case JSON:
				elementList = makeElementList(infoString, seperators[0], seperators[1], seperators[2]);
				println(formatJson(elementList));
				break;
			case TABLE:
				elementList = makeElementList(infoString, seperators[0], seperators[1], seperators[2]);
				printTableInfo(elementList);
				break;
			default: //TEXT:
				println(infoString);
				break;
			}

			return;
		case 2:
			switch (this.format) {
			case JSON:
				Map<String, Object> jsonresult = makeValueMap(infoString, seperators[0], "=");
				println(formatJson(jsonresult));
				break;
			case TABLE:
				Map<String, Object> result = makeValueMap(infoString, seperators[0], seperators[1]);
				printTableMap(result, Orientation.VERTICAL);
				break;
			default: //TEXT:
				println(infoString);
			}
			return;
		case 1:
			switch (this.format) {
			case JSON:
				Map<String, Object> jsonresult = makeValueMap(infoString, seperators[0], "=");
				println(formatJson(jsonresult));
				break;
			case TABLE:
				Map<String, Object> result = makeValueMap(infoString, seperators[0], "=");
				printTableMap(result);
				break;
			default: //TEXT:
				println(infoString);
			}
			return;
		default:
			println("WFT:"+infoString);
		}

	}
	
	private void printTableInfo(List<Map<String, Object>> infoList){
		Map<String, Integer> fieldMap = null;
		for (Map<String, Object> entry : infoList){
			fieldMap = makeFieldMap(fieldMap, entry);
		}
		printTableHeader(fieldMap);
		for (Map<String, Object> entry : infoList){
			printTableEntry(entry, fieldMap);
		}
		printTableSeperator(fieldMap);

	}
	private void printTableMap(Map<String, Object> infoMap){
		this.printTableMap(infoMap, Orientation.HORIZONTAL);
	}
	private void printTableMap(Map<String, Object> infoMap, Orientation orientation){
		Map<String, Integer> fieldMap = new TreeMap<String, Integer>();
		makeFieldMap(fieldMap, infoMap, orientation);
		printTableHeader(fieldMap);
		printTableEntry(infoMap, fieldMap);
		printTableSeperator(fieldMap);
	}	

	private void printTableMapList(Map<String, Map<String, Object>> infoMap){
		Map<String, Integer> fieldMap = new TreeMap<String, Integer>();
		Set<String> keys = infoMap.keySet();
		for (String element : keys){
			makeFieldMap(fieldMap, infoMap.get(element));
		}
		printTableHeader(fieldMap);
		for (String element : keys){
			printTableEntry(infoMap.get(element), fieldMap);
		}
		printTableSeperator(fieldMap);
	}	

	
	private List<Map<String, Object>> makeElementList(String input, String elementSeperator, String keySeperator, String valueSeperator){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String[] parts = input.split(elementSeperator);
		for (String element : parts){
			Map<String, Object> elementMap = makeValueMap(element, keySeperator, valueSeperator);
			result.add(elementMap);
		}
		return result;
	}

	private Map<String, Map<String, Object>> makeElementMap(String input, String elementSeperator, String keySeperator, String valueSeperator, String equator){
		Map<String, Map<String, Object>> result = new TreeMap<String, Map<String, Object>>();
		String[] parts = input.split(elementSeperator);
		for (String element : parts){
			String[] chunks = element.split(keySeperator);
			String key = chunks[0];
			if (chunks.length >1){
				Map<String, Object> value = makeValueMap(chunks[1], valueSeperator, equator);
				result.put(key, value);
			} else {
				result.put(key, null);
			}
		}
		return result;
	}
	
	private Map<String, Object> makeValueMap(String input, String seperator, String equator){
		Map<String, Object> result = new TreeMap<String, Object>();
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
		if (this.recordCount > 0){
			switch (this.format) {
			case JSON:
				jsonFooter();
				break;
			case TABLE:
				tableFooter();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
		
	}

	@Override
	public void reportError(int line, AerospikeException e) {
		errors++;
		String message = String.format("Error on line: %d, Aerospike %s", line, e.getMessage());
		this.errorList.add(message);
		println(message);
		
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
					println(String.format("Result %d: %s", count, object.toString()));
				}
				if (count == 0) {
					println("No results returned.");			
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
	
	private String formatJson(Object json){
		if (json instanceof List){
			JSONArray jArray = new JSONArray();
			jArray.put((Collection) json);
			return jArray.toString(4);
		} else if (json instanceof Map){
			JSONObject jObject = new JSONObject((Map) json);
			return jObject.toString(4);
		} else {
			return null;
		}
		
	}

	@Override
	public void reportError(int line, int charStart, int charEnd, String message) {
		String errorMessage = String.format("Error on line %d, at %d: %s", line, charStart, message);
		this.errorList.add(errorMessage);
		this.report(errorMessage);
		this.errors++;
	}
	@Override
	public void reportError(int line, String message) {
		String errorMessage = String.format("Error on line %d: %s", line, message);
		this.errorList.add(errorMessage);
		this.report(errorMessage);
		this.errors++;
	}

	@Override
	public int getErrorCount() {
		return this.errors;
	}

	@Override
	public void close() {
		try {
			console.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void jsonHeader(){
		if (recordCount == 0){
			// Print header and initialize containers
			jsonRecordList = new JSONArray();
			binList = new TreeMap<String, Integer>();
		}

	}
	private void tableHeader(){
		if (recordCount == 0){
			// Print header and initialize containers
			recordList = new ArrayList<Record>();
			binList = new TreeMap<String, Integer>();
		}
	}
	private void jsonFooter(){
		if (recordCount == MAX_RECORDS || this.cancelled){
			println(jsonRecordList.toString(4));
//			jsonRecordList.clear();
			recordCount = 0;
		}
	}
	private void tableFooter(){
		if (recordCount == MAX_RECORDS || this.cancelled){
			printTableRecordList(recordList, binList);
			recordList.clear();
			recordCount = 0;
		}
	}
	@Override
	public void scanCallback(Key key, Record record) throws AerospikeException {
		switch (this.format) {
		case JSON:
			jsonHeader();
			JSONObject jrecord = recordJSON(record);
			JSONObject jKey = keyJSON(key);
			JSONObject jrow = new JSONObject();
			jrow.put("key", jKey);
			jrow.put("record", jrecord);
			jsonRecordList.put(jrow);
			recordCount ++;
			jsonFooter();
			break;
		case TABLE:
			tableHeader();
			recordList.add(record);
			makeFieldMap(binList, record);
			recordCount ++;
			tableFooter();
			break;
		default: //TEXT:

			print("Record: " + key.toString());
			for (String binName :record.bins.keySet()){
				String result = record.getValue(binName).toString();
				print(" bin="+binName +" value="+ result);
			}
			println();
			break;
		}
	}


	@Override
	public void report(boolean flag, String message) {
		println(message + ((flag)?"OK":"failed"));
		
	}


	@Override
	public List<String> getErrorList() {
		return this.errorList;
	}








}
