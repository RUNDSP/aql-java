package com.aerospike.aql.grammar;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
/**
 * This class extends CommonTree include the original source 
 * @author peter
 *
 */
public class AQLTree extends CommonTree {
	
	protected String source;

	public AQLTree() {
		super();
	}

	public AQLTree(CommonTree node) {
		super(node);
	}

	public AQLTree(Token t) {
		super(t);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
}
