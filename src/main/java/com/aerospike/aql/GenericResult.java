package com.aerospike.aql;

import java.util.Map;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
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

	@Override
	public void report(String message) {
		this.message = message;

	}

	@Override
	public void report(AerospikeException e) {
		this.resultCode = e.getResultCode();
		this.message = e.getMessage();
		throw e;
	}

	@Override
	public void report(Level level, String message) {
		this.message = message;

	}

	@Override
	public void report(Record record) {
		this.record = record;

	}

	@Override
	public void report(Key key, Record record) {
		this.key = key;
		this.record = record;

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
	public void reportInfo(Map<String, String>[] ifoResults) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void scanCallback(Key key, Record record) throws AerospikeException {
		// TODO Auto-generated method stub
		
	}


}
