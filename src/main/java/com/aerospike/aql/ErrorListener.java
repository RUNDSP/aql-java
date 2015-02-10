package com.aerospike.aql;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import com.aerospike.aql.grammar.IErrorReporter;


public class ErrorListener extends BaseErrorListener {
	
	private IErrorReporter reporter;

	public ErrorListener(IErrorReporter reporter) {
		this.reporter = reporter;
	}
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
		if (this.reporter != null){
			this.reporter.reportError(line, charPositionInLine, offendingSymbol.toString().length(), msg);
		}
	}
	

}
