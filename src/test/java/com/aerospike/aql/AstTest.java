package com.aerospike.aql;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.CommonToken;
import org.junit.Test;

import com.aerospike.aql.grammar.AQLTree;
import com.aerospike.aql.grammar.AQLastParser.aqlFile_return;

public class AstTest {

	@Test
	public void tokenTest() throws IOException {
		File file = new File("src/test/resources/Insert.aql");
		AQL aql = new AQL();
		aqlFile_return ast = aql.compile(file, null, null);
		Object token = AQLTree.findTokenByOffset((AQLTree)ast.getTree(), 9, 4);
		if (token != null){
			String text  = ((CommonToken)token).getText();
			System.out.println(text);
		}
	}

}
