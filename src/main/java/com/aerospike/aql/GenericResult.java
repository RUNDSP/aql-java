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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
import com.aerospike.client.ResultCode;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;

public class GenericResult implements IResultReporter {

	public String message;
	public Key key;
	public Record record;
	public RecordSet recordSet;
	public ResultSet resultSet;
	public int resultCode;
	public Object object;
	public String infoMessage;
	public String[] inforMessages;
	public List<Record> scanList;
	public boolean flag;
	public Map<String, Object>[] infoResults;
	public Map<String, Object> statsMap;

	@Override
	public void report(String message) {
		this.message = message;

	}

//	@Override
//	public void report(AerospikeException e) {
//		this.resultCode = e.getResultCode();
//		this.message = e.getMessage();
//		throw e;
//	}

	@Override
	public void report(Level level, String message) {
		this.message = message;

	}

	@Override
	public void report(Record record) {
		this.record = record;
		if (record == null)
			this.resultCode = ResultCode.KEY_NOT_FOUND_ERROR;

	}

	@Override
	public void report(Key key, Record record) {
		this.key = key;
		this.record = record;
		if (record == null)
			this.resultCode = ResultCode.KEY_NOT_FOUND_ERROR;

	}

	@Override
	public void report(RecordSet recordSet) {
		this.recordSet = recordSet;

	}

	@Override
	public void report(ResultSet resultSet) {
		this.resultSet = resultSet;

	}

	@Override
	public void report(String message, boolean clear) {
		report(message);

	}

	@Override
	public void report(Level level, String message, boolean clear) {
		report(message);

	}

	@Override
	public void report(Record record, boolean clear) {
		report(record);

	}

	@Override
	public void report(Key key, Record record, boolean clear) {
		report(key, record);

	}

	@Override
	public void report(RecordSet recordSet, boolean clear) {
		report(recordSet);

	}

	@Override
	public void report(ResultSet resultSet, boolean clear) {
		report(resultSet);

	}

	@Override
	public void reportInfo(String inforMessage, String... seperators) {
		this.infoMessage = inforMessage;

	}

	@Override
	public void reportInfo(String inforMessage, boolean clear,
			String... seperators) {
		reportInfo(inforMessage, seperators);

	}

	@Override
	public void reportInfo(String[] inforMessages, String... seperators) {
		this.inforMessages = inforMessages;

	}

	@Override
	public void reportInfo(String[] inforMessages, boolean clear,
			String... seperators) {
		this.inforMessages = inforMessages;

	}

	@Override
	public void cancel() {
		

	}

	@Override
	public boolean isCancelled() {
		
		return false;
	}

	@Override
	public void setViewFormat(ViewFormat format) {
		

	}

	@Override
	public void reportInfo(Map<String, Object>[] infoResults) {
		this.infoResults = infoResults;
		
	}

	public String getMessage() {
		return message;
	}

	public Record getRecord() {
		return record;
	}

	public RecordSet getRecordSet() {
		return recordSet;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public int getResultCode() {
		return resultCode;
	}

	public Object getObject() {
		return object;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public String[] getInforMessages() {
		return inforMessages;
	}

	@Override
	public void close() {
		if (this.recordSet != null)
			this.recordSet.close();
		if (this.resultSet != null)
			this.resultSet.close();
		if (this.scanList != null){
			this.scanList.clear();
			this.scanList = null;
		}
		this.flag = false;
		this.infoMessage = null;
		this.infoResults = null;
		this.inforMessages = null;
		this.message = null;
		this.record = null;
		this.resultCode = -1;
	}

	@Override
	public void scanCallback(Key key, Record record) throws AerospikeException {
		if (this.scanList == null)
			this.scanList = new  ArrayList<Record>();
		this.scanList.add(record);
		
	}

	@Override
	public ViewFormat getViewFormat() {
		return ViewFormat.TEXT;
	}

	@Override
	public void reportInfo(Map<String, Object> statsMap) {
		this.statsMap = statsMap;

	}
	@Override
	public void report(boolean flag, String message) {
		this.flag = flag;
		this.message = message;


	}		

}
