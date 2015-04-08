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
