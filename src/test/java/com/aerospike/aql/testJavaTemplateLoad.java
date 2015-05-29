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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class testJavaTemplateLoad {
	private STGroup templates = new STGroupFile(getClass().getResource("AS_Java.stg"), null, '<', '>');
 
	@Test
	public void testJsonObjectValue() {
		ST st = templates.getInstanceOf("jsonObjectValue");
		assertNotNull(st);
		st = templates.getInstanceOf("jsonObjectValue");
		assertNotNull(st);
		st = templates.getInstanceOf("jsonObjectValue");
		assertNotNull(st);
	}
	@Test
	public void testJsonArrayValue() {
		ST st = templates.getInstanceOf("jsonArrayValue");
		assertNotNull(st);
		st = templates.getInstanceOf("jsonArrayValue");
		assertNotNull(st);
		st = templates.getInstanceOf("jsonArrayValue");
		assertNotNull(st);
	}
}
