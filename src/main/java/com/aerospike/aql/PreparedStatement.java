package com.aerospike.aql;

import com.aerospike.aql.grammar.AQLastParser.aqlFile_return;
import com.aerospike.aql.grammar.AQLastParser.aqlStatements_return;
import com.aerospike.client.query.Statement;

public class PreparedStatement {
	Statement statement;
	aqlFile_return ast;
	public PreparedStatement(aqlFile_return ast) {
		super();
		this.ast = ast;
	}
	public Statement getStatement() {
		return statement;
	}
	public aqlFile_return getAst() {
		return ast;
	}
	
	
}


