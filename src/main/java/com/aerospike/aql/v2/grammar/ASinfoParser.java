// Generated from ASinfo.g4 by ANTLR 4.3

package com.aerospike.aql.v2.grammar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ASinfoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, SEMICOLON=2, EQ=3, TRUE=4, FALSE=5, INTEGER=6, IDENTIFIER=7;
	public static final String[] tokenNames = {
		"<INVALID>", "':'", "';'", "'='", "'true'", "'false'", "INTEGER", "IDENTIFIER"
	};
	public static final int
		RULE_result = 0, RULE_outerElement = 1, RULE_innerElement = 2, RULE_nameValue = 3, 
		RULE_value = 4, RULE_bool = 5;
	public static final String[] ruleNames = {
		"result", "outerElement", "innerElement", "nameValue", "value", "bool"
	};

	@Override
	public String getGrammarFileName() { return "ASinfo.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ASinfoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ResultContext extends ParserRuleContext {
		public List<TerminalNode> SEMICOLON() { return getTokens(ASinfoParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ASinfoParser.SEMICOLON, i);
		}
		public List<OuterElementContext> outerElement() {
			return getRuleContexts(OuterElementContext.class);
		}
		public OuterElementContext outerElement(int i) {
			return getRuleContext(OuterElementContext.class,i);
		}
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_result);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); outerElement();
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(13); match(SEMICOLON);
				setState(14); outerElement();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OuterElementContext extends ParserRuleContext {
		public TerminalNode COLON(int i) {
			return getToken(ASinfoParser.COLON, i);
		}
		public List<TerminalNode> COLON() { return getTokens(ASinfoParser.COLON); }
		public List<InnerElementContext> innerElement() {
			return getRuleContexts(InnerElementContext.class);
		}
		public InnerElementContext innerElement(int i) {
			return getRuleContext(InnerElementContext.class,i);
		}
		public OuterElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).enterOuterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).exitOuterElement(this);
		}
	}

	public final OuterElementContext outerElement() throws RecognitionException {
		OuterElementContext _localctx = new OuterElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_outerElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); innerElement();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON) {
				{
				{
				setState(21); match(COLON);
				setState(22); innerElement();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerElementContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NameValueContext nameValue() {
			return getRuleContext(NameValueContext.class,0);
		}
		public InnerElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).enterInnerElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).exitInnerElement(this);
		}
	}

	public final InnerElementContext innerElement() throws RecognitionException {
		InnerElementContext _localctx = new InnerElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_innerElement);
		try {
			setState(30);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); nameValue();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameValueContext extends ParserRuleContext {
		public Token name;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ASinfoParser.EQ, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ASinfoParser.IDENTIFIER, 0); }
		public NameValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).enterNameValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).exitNameValue(this);
		}
	}

	public final NameValueContext nameValue() throws RecognitionException {
		NameValueContext _localctx = new NameValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nameValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); ((NameValueContext)_localctx).name = match(IDENTIFIER);
			setState(33); match(EQ);
			setState(34); value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ASinfoParser.INTEGER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ASinfoParser.IDENTIFIER, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(39);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); match(IDENTIFIER);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); match(INTEGER);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(38); bool();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(ASinfoParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(ASinfoParser.TRUE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ASinfoListener ) ((ASinfoListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t.\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\3\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\4\3\4\5\4!\n\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\5\6*\n\6\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\3\3\2\6"+
		"\7,\2\16\3\2\2\2\4\26\3\2\2\2\6 \3\2\2\2\b\"\3\2\2\2\n)\3\2\2\2\f+\3\2"+
		"\2\2\16\23\5\4\3\2\17\20\7\4\2\2\20\22\5\4\3\2\21\17\3\2\2\2\22\25\3\2"+
		"\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\23\3\2\2\2\26\33\5\6"+
		"\4\2\27\30\7\3\2\2\30\32\5\6\4\2\31\27\3\2\2\2\32\35\3\2\2\2\33\31\3\2"+
		"\2\2\33\34\3\2\2\2\34\5\3\2\2\2\35\33\3\2\2\2\36!\5\b\5\2\37!\5\n\6\2"+
		" \36\3\2\2\2 \37\3\2\2\2!\7\3\2\2\2\"#\7\t\2\2#$\7\5\2\2$%\5\n\6\2%\t"+
		"\3\2\2\2&*\7\t\2\2\'*\7\b\2\2(*\5\f\7\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2"+
		"*\13\3\2\2\2+,\t\2\2\2,\r\3\2\2\2\6\23\33 )";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}