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
package com.aerospike.aql.grammar;

import java.util.List;

import com.aerospike.client.AerospikeException;

/**
 * This interface is a generic error reporter. It reports
 * the location of an error and an error message
 * @author peter
 *
 */
public interface IErrorReporter {
	void reportError(int line, int charStart, int charEnd, String message);
	void reportError(int line, String message);
	void reportError(int line, AerospikeException e);
	int getErrorCount();
	List<String> getErrorList();
}
