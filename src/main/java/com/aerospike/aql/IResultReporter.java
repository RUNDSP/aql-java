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

import java.io.Closeable;
import java.util.Map;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Log.Level;
import com.aerospike.client.Record;
import com.aerospike.client.ScanCallback;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
/**
 * This interface is used to report results to
 * the calling application
 * @author peter
 *
 */
public interface IResultReporter extends Closeable, ScanCallback{
	enum ViewFormat {
		JSON,
		TABLE,
		TEXT
	}
	public void report(String message);
	public void report(boolean flag, String message);
	public void report(Level level, String message);
	public void report(Record record);
	public void report(Key key, Record record);
	public void report(RecordSet recordSet);
	public void report(ResultSet resultSet);
	public void report(String message, boolean clear);
	public void report(Level level, String message, boolean clear);
	public void report(Record record, boolean clear);
	public void report(Key key, Record record, boolean clear);
	public void report(RecordSet recordSet, boolean clear);
	public void report(ResultSet resultSet, boolean clear);
	public void reportInfo(Map<String, Object>[] ifoResults);
	public void reportInfo(Map<String, Object> statsMap);
	public void reportInfo(String inforMessage, String...seperators);
	public void reportInfo(String inforMessage, boolean clear, String...seperators);
	public void reportInfo(String[] inforMessages, String...seperators);
	public void reportInfo(String[] inforMessages, boolean clear, String...seperators);
	public void cancel();
	public boolean isCancelled();
	public void setViewFormat(ViewFormat format);
	public void close();
	public ViewFormat getViewFormat();
}
