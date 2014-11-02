// Generated from AQL.g4 by ANTLR 4.3

package com.aerospike.aql.v2.grammar;
import java.util.Set;
import java.util.HashSet;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, TRUE=19, FALSE=20, CONNECT=21, DISCONNECT=22, DESC=23, 
		INSERT=24, SELECT=25, DELETE=26, CREATE=27, INDEX=28, EXECUTE=29, WHERE=30, 
		SHOW=31, DROP=32, INDEXES=33, VALUES=34, SET=35, GET=36, MODULE=37, ON=38, 
		OPERATE=39, OUTPUT=40, PACKAGES=41, INTO=42, FUNCTION=43, FROM=44, BY=45, 
		AND=46, BETWEEN=47, RUN=48, STAT=49, QUERY=50, SCAN=51, TIMEOUT=52, QUIT=53, 
		EXIT=54, KILL=55, KILL_QUERY=56, KILL_SCAN=57, PK=58, STRING=59, NUMERIC=60, 
		EQ=61, STAR=62, REGISTER=63, REMOVE=64, AGGREGATE=65, MODULES=66, NAMESPACES=67, 
		SETS=68, BINS=69, SCANS=70, QUERIES=71, SYSTEM=72, ORDER=73, PRINT=74, 
		UPDATE=75, VERBOSE=76, ECHO=77, TTL=78, VIEW=79, USE_SMD=80, LUA_USER_PATH=81, 
		LUA_SYSTEM_PATH=82, IDENTIFIER=83, STRINGLITERAL=84, FLOATLITERAL=85, 
		INTLITERAL=86, HEXLITERAL=87, NEWLINE=88, WS=89, COMMENT=90;
	public static final String[] tokenNames = {
		"<INVALID>", "'add'", "'q'", "'nosql'", "'so'", "'touch'", "'lua'", "'table'", 
		"'prepend'", "'help'", "'header'", "'('", "'put'", "')'", "'generation'", 
		"'append'", "','", "'json'", "'.'", "'true'", "'false'", "'connect'", 
		"'disconnect'", "'desc'", "'insert'", "'select'", "'delete'", "'create'", 
		"'index'", "'execute'", "'where'", "'show'", "'drop'", "'indexes'", "'values'", 
		"'set'", "'get'", "'module'", "'on'", "'operate'", "'output'", "'packages'", 
		"'into'", "'function'", "'from'", "'by'", "'and'", "'between'", "'run'", 
		"'stat'", "'query'", "'scan'", "'timeout'", "'quit'", "'exit'", "'kill'", 
		"'kill_query'", "'kill_scan'", "'pk'", "'string'", "'numeric'", "'='", 
		"'*'", "'register'", "'remove'", "'aggregate'", "'modules'", "'namespaces'", 
		"'sets'", "'bins'", "'scans'", "'queries'", "'system'", "'order'", "'print'", 
		"'update'", "'verbose'", "'echo'", "'ttl'", "'view'", "'use_smd'", "'lua_userpath'", 
		"'lua_syspath'", "IDENTIFIER", "STRINGLITERAL", "FLOATLITERAL", "INTLITERAL", 
		"HEXLITERAL", "NEWLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_aql = 0, RULE_statements = 1, RULE_statement = 2, RULE_connect = 3, 
		RULE_disconnect = 4, RULE_create = 5, RULE_drop = 6, RULE_remove = 7, 
		RULE_operate = 8, RULE_insert = 9, RULE_update = 10, RULE_updateBinList = 11, 
		RULE_delete = 12, RULE_select = 13, RULE_where = 14, RULE_operateFunction = 15, 
		RULE_nameSet = 16, RULE_register = 17, RULE_execute = 18, RULE_aggregate = 19, 
		RULE_moduleFunction = 20, RULE_binNameList = 21, RULE_valueList = 22, 
		RULE_predicate = 23, RULE_primaryKeyPredicate = 24, RULE_generationPredicate = 25, 
		RULE_filterPredicate = 26, RULE_equalityFilter = 27, RULE_binValue = 28, 
		RULE_rangeFilter = 29, RULE_show = 30, RULE_desc = 31, RULE_stat = 32, 
		RULE_set = 33, RULE_get = 34, RULE_viewType = 35, RULE_run = 36, RULE_print = 37, 
		RULE_kill = 38, RULE_kill_query = 39, RULE_kill_scan = 40, RULE_quit = 41, 
		RULE_help = 42, RULE_primaryKey = 43, RULE_package_name = 44, RULE_index_name = 45, 
		RULE_namespace_name = 46, RULE_set_name = 47, RULE_bin = 48, RULE_value = 49, 
		RULE_textValue = 50, RULE_integerValue = 51, RULE_booleanLiteral = 52, 
		RULE_moduleName = 53, RULE_filePath = 54;
	public static final String[] ruleNames = {
		"aql", "statements", "statement", "connect", "disconnect", "create", "drop", 
		"remove", "operate", "insert", "update", "updateBinList", "delete", "select", 
		"where", "operateFunction", "nameSet", "register", "execute", "aggregate", 
		"moduleFunction", "binNameList", "valueList", "predicate", "primaryKeyPredicate", 
		"generationPredicate", "filterPredicate", "equalityFilter", "binValue", 
		"rangeFilter", "show", "desc", "stat", "set", "get", "viewType", "run", 
		"print", "kill", "kill_query", "kill_scan", "quit", "help", "primaryKey", 
		"package_name", "index_name", "namespace_name", "set_name", "bin", "value", 
		"textValue", "integerValue", "booleanLiteral", "moduleName", "filePath"
	};

	@Override
	public String getGrammarFileName() { return "AQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	public enum VariableDefinition {
		CLIENT, 
		RECORD, 
		RECORD_SET, 
		RESULT_SET, 
		CLIENT_POLICY,
		WRITE_POLICY, 
		READ_POLICY,
		QUERY_POLICY,
		SCAN_POLICY,
		INFO_POLICY,
		STMT,
		UDF_FILE,
		REGISTER_TASK,
		INDEX_TASK,
		INFO_STRING;
	}

	public Set<VariableDefinition> definitions = new HashSet<VariableDefinition>();

	public AQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AqlContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AQLParser.EOF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public AqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterAql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitAql(this);
		}
	}

	public final AqlContext aql() throws RecognitionException {
		AqlContext _localctx = new AqlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_aql);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); statements();
			setState(111); match(EOF);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__9) | (1L << CONNECT) | (1L << DISCONNECT) | (1L << DESC) | (1L << INSERT) | (1L << SELECT) | (1L << DELETE) | (1L << CREATE) | (1L << EXECUTE) | (1L << SHOW) | (1L << DROP) | (1L << SET) | (1L << GET) | (1L << OPERATE) | (1L << RUN) | (1L << STAT) | (1L << QUIT) | (1L << EXIT) | (1L << KILL) | (1L << REGISTER))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (REMOVE - 64)) | (1L << (AGGREGATE - 64)) | (1L << (PRINT - 64)) | (1L << (UPDATE - 64)))) != 0)) {
				{
				{
				setState(113); statement();
				}
				}
				setState(118);
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

	public static class StatementContext extends ParserRuleContext {
		public String source;
		public String nameSpace;
		public String setName;
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public KillContext kill() {
			return getRuleContext(KillContext.class,0);
		}
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ExecuteContext execute() {
			return getRuleContext(ExecuteContext.class,0);
		}
		public RunContext run() {
			return getRuleContext(RunContext.class,0);
		}
		public QuitContext quit() {
			return getRuleContext(QuitContext.class,0);
		}
		public RemoveContext remove() {
			return getRuleContext(RemoveContext.class,0);
		}
		public GetContext get() {
			return getRuleContext(GetContext.class,0);
		}
		public DescContext desc() {
			return getRuleContext(DescContext.class,0);
		}
		public HelpContext help() {
			return getRuleContext(HelpContext.class,0);
		}
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public DisconnectContext disconnect() {
			return getRuleContext(DisconnectContext.class,0);
		}
		public OperateContext operate() {
			return getRuleContext(OperateContext.class,0);
		}
		public ConnectContext connect() {
			return getRuleContext(ConnectContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public DropContext drop() {
			return getRuleContext(DropContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(142);
			switch (_input.LA(1)) {
			case CONNECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); connect();
				}
				break;
			case DISCONNECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); disconnect();
				}
				break;
			case CREATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); create();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 4);
				{
				setState(122); drop();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(123); remove();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 6);
				{
				setState(124); insert();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 7);
				{
				setState(125); update();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 8);
				{
				setState(126); delete();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 9);
				{
				setState(127); select();
				}
				break;
			case REGISTER:
				enterOuterAlt(_localctx, 10);
				{
				setState(128); register();
				}
				break;
			case EXECUTE:
				enterOuterAlt(_localctx, 11);
				{
				setState(129); execute();
				}
				break;
			case AGGREGATE:
				enterOuterAlt(_localctx, 12);
				{
				setState(130); aggregate();
				}
				break;
			case OPERATE:
				enterOuterAlt(_localctx, 13);
				{
				setState(131); operate();
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 14);
				{
				setState(132); show();
				}
				break;
			case DESC:
				enterOuterAlt(_localctx, 15);
				{
				setState(133); desc();
				}
				break;
			case STAT:
				enterOuterAlt(_localctx, 16);
				{
				setState(134); stat();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 17);
				{
				setState(135); set();
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 18);
				{
				setState(136); get();
				}
				break;
			case RUN:
				enterOuterAlt(_localctx, 19);
				{
				setState(137); run();
				}
				break;
			case KILL:
				enterOuterAlt(_localctx, 20);
				{
				setState(138); kill();
				}
				break;
			case T__16:
			case QUIT:
			case EXIT:
				enterOuterAlt(_localctx, 21);
				{
				setState(139); quit();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 22);
				{
				setState(140); help();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 23);
				{
				setState(141); print();
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

	public static class ConnectContext extends ParserRuleContext {
		public Token hostName;
		public Token port;
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public TerminalNode CONNECT() { return getToken(AQLParser.CONNECT, 0); }
		public ConnectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterConnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitConnect(this);
		}
	}

	public final ConnectContext connect() throws RecognitionException {
		ConnectContext _localctx = new ConnectContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_connect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(CONNECT);
			setState(145); ((ConnectContext)_localctx).hostName = match(STRINGLITERAL);
			setState(146); ((ConnectContext)_localctx).port = match(INTLITERAL);

					definitions.add(VariableDefinition.CLIENT);
				
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

	public static class DisconnectContext extends ParserRuleContext {
		public TerminalNode DISCONNECT() { return getToken(AQLParser.DISCONNECT, 0); }
		public DisconnectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disconnect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDisconnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDisconnect(this);
		}
	}

	public final DisconnectContext disconnect() throws RecognitionException {
		DisconnectContext _localctx = new DisconnectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_disconnect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); match(DISCONNECT);
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

	public static class CreateContext extends ParserRuleContext {
		public BinContext binName;
		public Token iType;
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode ON() { return getToken(AQLParser.ON, 0); }
		public TerminalNode NUMERIC() { return getToken(AQLParser.NUMERIC, 0); }
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode STRING() { return getToken(AQLParser.STRING, 0); }
		public TerminalNode CREATE() { return getToken(AQLParser.CREATE, 0); }
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitCreate(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_create);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(CREATE);
			setState(152); match(INDEX);
			setState(153); index_name();
			setState(154); match(ON);
			setState(155); nameSet();
			setState(156); match(T__7);
			setState(157); ((CreateContext)_localctx).binName = bin();
			setState(158); match(T__5);
			setState(159);
			((CreateContext)_localctx).iType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NUMERIC) ) {
				((CreateContext)_localctx).iType = (Token)_errHandler.recoverInline(this);
			}
			consume();

			  	definitions.add(VariableDefinition.WRITE_POLICY);
			  	definitions.add(VariableDefinition.INDEX_TASK);
				
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

	public static class DropContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public ModuleNameContext moduleName() {
			return getRuleContext(ModuleNameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode DROP() { return getToken(AQLParser.DROP, 0); }
		public TerminalNode MODULE() { return getToken(AQLParser.MODULE, 0); }
		public TerminalNode SET() { return getToken(AQLParser.SET, 0); }
		public DropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDrop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDrop(this);
		}
	}

	public final DropContext drop() throws RecognitionException {
		DropContext _localctx = new DropContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_drop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(DROP);
			setState(171);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(163); match(INDEX);
				setState(164); nameSet();
				setState(165); index_name();
				}
				break;
			case MODULE:
				{
				setState(167); match(MODULE);
				setState(168); moduleName();
				}
				break;
			case SET:
				{
				setState(169); match(SET);
				setState(170); nameSet();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RemoveContext extends ParserRuleContext {
		public ModuleNameContext moduleName() {
			return getRuleContext(ModuleNameContext.class,0);
		}
		public TerminalNode REMOVE() { return getToken(AQLParser.REMOVE, 0); }
		public TerminalNode MODULE() { return getToken(AQLParser.MODULE, 0); }
		public RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRemove(this);
		}
	}

	public final RemoveContext remove() throws RecognitionException {
		RemoveContext _localctx = new RemoveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_remove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(REMOVE);
			setState(174); match(MODULE);
			setState(175); moduleName();
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

	public static class OperateContext extends ParserRuleContext {
		public List<OperateFunctionContext> operateFunction() {
			return getRuleContexts(OperateFunctionContext.class);
		}
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode ON() { return getToken(AQLParser.ON, 0); }
		public PrimaryKeyPredicateContext primaryKeyPredicate() {
			return getRuleContext(PrimaryKeyPredicateContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(AQLParser.WHERE, 0); }
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode OPERATE() { return getToken(AQLParser.OPERATE, 0); }
		public OperateFunctionContext operateFunction(int i) {
			return getRuleContext(OperateFunctionContext.class,i);
		}
		public GenerationPredicateContext generationPredicate() {
			return getRuleContext(GenerationPredicateContext.class,0);
		}
		public OperateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterOperate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitOperate(this);
		}
	}

	public final OperateContext operate() throws RecognitionException {
		OperateContext _localctx = new OperateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(OPERATE);
			setState(178); operateFunction();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(179); match(T__2);
				setState(180); operateFunction();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186); match(ON);
			setState(187); nameSet();
			setState(188); match(WHERE);
			setState(189); primaryKeyPredicate();
			setState(192);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(190); match(AND);
				setState(191); generationPredicate();
				}
			}


				  	definitions.add(VariableDefinition.WRITE_POLICY);
				  	definitions.add(VariableDefinition.READ_POLICY);
				  	definitions.add(VariableDefinition.RECORD);
				
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

	public static class InsertContext extends ParserRuleContext {
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(AQLParser.VALUES, 0); }
		public PrimaryKeyContext primaryKey() {
			return getRuleContext(PrimaryKeyContext.class,0);
		}
		public BinNameListContext binNameList() {
			return getRuleContext(BinNameListContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(AQLParser.INSERT, 0); }
		public TerminalNode PK() { return getToken(AQLParser.PK, 0); }
		public TerminalNode INTO() { return getToken(AQLParser.INTO, 0); }
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitInsert(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(INSERT);
			setState(197); match(INTO);
			setState(198); nameSet();
			setState(199); match(T__7);
			setState(200); match(PK);
			{
			setState(201); match(T__2);
			setState(202); binNameList();
			}
			setState(204); match(T__5);
			setState(205); match(VALUES);
			setState(206); match(T__7);
			setState(207); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
			{
			setState(208); match(T__2);
			setState(209); valueList();
			}
			setState(211); match(T__5);

					definitions.add(VariableDefinition.WRITE_POLICY);
				
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

	public static class UpdateContext extends ParserRuleContext {
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public UpdateBinListContext updateBinList() {
			return getRuleContext(UpdateBinListContext.class,0);
		}
		public TerminalNode UPDATE() { return getToken(AQLParser.UPDATE, 0); }
		public PrimaryKeyPredicateContext primaryKeyPredicate() {
			return getRuleContext(PrimaryKeyPredicateContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(AQLParser.WHERE, 0); }
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode SET() { return getToken(AQLParser.SET, 0); }
		public GenerationPredicateContext generationPredicate() {
			return getRuleContext(GenerationPredicateContext.class,0);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitUpdate(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(UPDATE);
			setState(215); nameSet();
			setState(216); match(SET);
			setState(217); updateBinList();
			setState(218); match(WHERE);
			setState(219); primaryKeyPredicate();
			setState(222);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(220); match(AND);
				setState(221); generationPredicate();
				}
			}


					definitions.add(VariableDefinition.WRITE_POLICY);
				
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

	public static class UpdateBinListContext extends ParserRuleContext {
		public List<BinValueContext> binValue() {
			return getRuleContexts(BinValueContext.class);
		}
		public BinValueContext binValue(int i) {
			return getRuleContext(BinValueContext.class,i);
		}
		public UpdateBinListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateBinList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterUpdateBinList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitUpdateBinList(this);
		}
	}

	public final UpdateBinListContext updateBinList() throws RecognitionException {
		UpdateBinListContext _localctx = new UpdateBinListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_updateBinList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); binValue();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(227); match(T__2);
				setState(228); binValue();
				}
				}
				setState(233);
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

	public static class DeleteContext extends ParserRuleContext {
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(AQLParser.DELETE, 0); }
		public PrimaryKeyPredicateContext primaryKeyPredicate() {
			return getRuleContext(PrimaryKeyPredicateContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(AQLParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(AQLParser.FROM, 0); }
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDelete(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_delete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(DELETE);
			setState(235); match(FROM);
			setState(236); nameSet();
			setState(237); match(WHERE);
			setState(238); primaryKeyPredicate();

				definitions.add(VariableDefinition.WRITE_POLICY);
				
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

	public static class SelectContext extends ParserRuleContext {
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public BinNameListContext binNameList() {
			return getRuleContext(BinNameListContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public TerminalNode FROM() { return getToken(AQLParser.FROM, 0); }
		public TerminalNode SELECT() { return getToken(AQLParser.SELECT, 0); }
		public TerminalNode STAR() { return getToken(AQLParser.STAR, 0); }
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSelect(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(SELECT);
			setState(244);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(242); match(STAR);
				}
				break;
			case IDENTIFIER:
				{
				setState(243); binNameList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(246); match(FROM);
			setState(247); nameSet();
			setState(249);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(248); where();
				}
			}


				definitions.add(VariableDefinition.READ_POLICY);
				definitions.add(VariableDefinition.SCAN_POLICY);
				definitions.add(VariableDefinition.RECORD);
				definitions.add(VariableDefinition.STMT);
				
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

	public static class WhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(AQLParser.WHERE, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitWhere(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(WHERE);
			setState(254); predicate();
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

	public static class OperateFunctionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public OperateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operateFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterOperateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitOperateFunction(this);
		}
	}

	public final OperateFunctionContext operateFunction() throws RecognitionException {
		OperateFunctionContext _localctx = new OperateFunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operateFunction);
		int _la;
		try {
			setState(293);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(256); match(T__17);
				setState(257); match(T__7);
				setState(258); bin();
				setState(259); match(T__2);
				setState(260); value();
				setState(261); match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(263); match(T__6);
				setState(264); match(T__7);
				setState(265); bin();
				setState(266); match(T__2);
				setState(267); value();
				setState(268); match(T__5);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(270); match(T__3);
				setState(271); match(T__7);
				setState(272); bin();
				setState(273); match(T__2);
				setState(274); value();
				setState(275); match(T__5);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(277); match(T__10);
				setState(278); match(T__7);
				setState(279); bin();
				setState(280); match(T__2);
				setState(281); value();
				setState(282); match(T__5);
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 5);
				{
				setState(284); match(GET);
				setState(289);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(285); match(T__7);
					setState(286); bin();
					setState(287); match(T__5);
					}
				}

				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(291); match(T__13);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(292); match(T__8);
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

	public static class NameSetContext extends ParserRuleContext {
		public String namespaceName;
		public String setName;
		public Namespace_nameContext namespace_name;
		public Set_nameContext set_name;
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
		public Set_nameContext set_name() {
			return getRuleContext(Set_nameContext.class,0);
		}
		public NameSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNameSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNameSet(this);
		}
	}

	public final NameSetContext nameSet() throws RecognitionException {
		NameSetContext _localctx = new NameSetContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nameSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); ((NameSetContext)_localctx).namespace_name = namespace_name();
			((NameSetContext)_localctx).namespaceName =  (((NameSetContext)_localctx).namespace_name!=null?_input.getText(((NameSetContext)_localctx).namespace_name.start,((NameSetContext)_localctx).namespace_name.stop):null);
			setState(301);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(297); match(T__0);
				setState(298); ((NameSetContext)_localctx).set_name = set_name();
				((NameSetContext)_localctx).setName =  (((NameSetContext)_localctx).set_name!=null?_input.getText(((NameSetContext)_localctx).set_name.start,((NameSetContext)_localctx).set_name.stop):null);
				}
			}

			}

				((StatementContext)getInvokingContext(2)).nameSpace =  _localctx.namespaceName;
				((StatementContext)getInvokingContext(2)).setName =  _localctx.setName;

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

	public static class RegisterContext extends ParserRuleContext {
		public FilePathContext filepath;
		public FilePathContext filePath() {
			return getRuleContext(FilePathContext.class,0);
		}
		public TerminalNode REGISTER() { return getToken(AQLParser.REGISTER, 0); }
		public TerminalNode MODULE() { return getToken(AQLParser.MODULE, 0); }
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRegister(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRegister(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); match(REGISTER);
			setState(304); match(MODULE);
			setState(305); ((RegisterContext)_localctx).filepath = filePath();

				definitions.add(VariableDefinition.READ_POLICY);
				definitions.add(VariableDefinition.REGISTER_TASK);
				definitions.add(VariableDefinition.UDF_FILE);
				
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

	public static class ExecuteContext extends ParserRuleContext {
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode ON() { return getToken(AQLParser.ON, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public ModuleFunctionContext moduleFunction() {
			return getRuleContext(ModuleFunctionContext.class,0);
		}
		public TerminalNode EXECUTE() { return getToken(AQLParser.EXECUTE, 0); }
		public ExecuteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterExecute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitExecute(this);
		}
	}

	public final ExecuteContext execute() throws RecognitionException {
		ExecuteContext _localctx = new ExecuteContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(EXECUTE);
			setState(309); moduleFunction();
			setState(310); match(T__7);
			setState(312);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL || _la==INTLITERAL) {
				{
				setState(311); valueList();
				}
			}

			setState(314); match(T__5);
			setState(315); match(ON);
			setState(316); nameSet();
			setState(318);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(317); where();
				}
			}


				definitions.add(VariableDefinition.READ_POLICY);
				
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

	public static class AggregateContext extends ParserRuleContext {
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode ON() { return getToken(AQLParser.ON, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public TerminalNode AGGREGATE() { return getToken(AQLParser.AGGREGATE, 0); }
		public ModuleFunctionContext moduleFunction() {
			return getRuleContext(ModuleFunctionContext.class,0);
		}
		public AggregateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterAggregate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitAggregate(this);
		}
	}

	public final AggregateContext aggregate() throws RecognitionException {
		AggregateContext _localctx = new AggregateContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_aggregate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(AGGREGATE);
			setState(323); moduleFunction();
			setState(329);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(324); match(T__7);
				setState(326);
				_la = _input.LA(1);
				if (_la==STRINGLITERAL || _la==INTLITERAL) {
					{
					setState(325); valueList();
					}
				}

				setState(328); match(T__5);
				}
			}

			setState(331); match(ON);
			setState(332); nameSet();
			setState(334);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(333); where();
				}
			}


				definitions.add(VariableDefinition.QUERY_POLICY);
				definitions.add(VariableDefinition.RESULT_SET);
				definitions.add(VariableDefinition.STMT);
				
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

	public static class ModuleFunctionContext extends ParserRuleContext {
		public Token packageName;
		public Token functionName;
		public TerminalNode IDENTIFIER(int i) {
			return getToken(AQLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(AQLParser.IDENTIFIER); }
		public ModuleFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterModuleFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitModuleFunction(this);
		}
	}

	public final ModuleFunctionContext moduleFunction() throws RecognitionException {
		ModuleFunctionContext _localctx = new ModuleFunctionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_moduleFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); ((ModuleFunctionContext)_localctx).packageName = match(IDENTIFIER);
			setState(339); match(T__0);
			setState(340); ((ModuleFunctionContext)_localctx).functionName = match(IDENTIFIER);
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

	public static class BinNameListContext extends ParserRuleContext {
		public List<BinContext> bin() {
			return getRuleContexts(BinContext.class);
		}
		public BinContext bin(int i) {
			return getRuleContext(BinContext.class,i);
		}
		public BinNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBinNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBinNameList(this);
		}
	}

	public final BinNameListContext binNameList() throws RecognitionException {
		BinNameListContext _localctx = new BinNameListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_binNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342); bin();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(343); match(T__2);
				setState(344); bin();
				}
				}
				setState(349);
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

	public static class ValueListContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitValueList(this);
		}
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); value();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(351); match(T__2);
				setState(352); value();
				}
				}
				setState(357);
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

	public static class PredicateContext extends ParserRuleContext {
		public FilterPredicateContext filterPredicate() {
			return getRuleContext(FilterPredicateContext.class,0);
		}
		public PrimaryKeyPredicateContext primaryKeyPredicate() {
			return getRuleContext(PrimaryKeyPredicateContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			switch (_input.LA(1)) {
			case PK:
				{
				setState(358); primaryKeyPredicate();
				}
				break;
			case IDENTIFIER:
				{
				setState(359); filterPredicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PrimaryKeyPredicateContext extends ParserRuleContext {
		public PrimaryKeyContext primaryKey() {
			return getRuleContext(PrimaryKeyContext.class,0);
		}
		public TerminalNode EQ() { return getToken(AQLParser.EQ, 0); }
		public TerminalNode PK() { return getToken(AQLParser.PK, 0); }
		public PrimaryKeyPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryKeyPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPrimaryKeyPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPrimaryKeyPredicate(this);
		}
	}

	public final PrimaryKeyPredicateContext primaryKeyPredicate() throws RecognitionException {
		PrimaryKeyPredicateContext _localctx = new PrimaryKeyPredicateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_primaryKeyPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362); match(PK);
			setState(363); match(EQ);
			setState(364); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
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

	public static class GenerationPredicateContext extends ParserRuleContext {
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode EQ() { return getToken(AQLParser.EQ, 0); }
		public GenerationPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generationPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterGenerationPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitGenerationPredicate(this);
		}
	}

	public final GenerationPredicateContext generationPredicate() throws RecognitionException {
		GenerationPredicateContext _localctx = new GenerationPredicateContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_generationPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); match(T__4);
			setState(367); match(EQ);
			setState(368); match(INTLITERAL);
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

	public static class FilterPredicateContext extends ParserRuleContext {
		public EqualityFilterContext equalityFilter() {
			return getRuleContext(EqualityFilterContext.class,0);
		}
		public RangeFilterContext rangeFilter() {
			return getRuleContext(RangeFilterContext.class,0);
		}
		public FilterPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterFilterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitFilterPredicate(this);
		}
	}

	public final FilterPredicateContext filterPredicate() throws RecognitionException {
		FilterPredicateContext _localctx = new FilterPredicateContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_filterPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(370); equalityFilter();
				}
				break;

			case 2:
				{
				setState(371); rangeFilter();
				}
				break;
			}

				definitions.add(VariableDefinition.QUERY_POLICY);
				definitions.add(VariableDefinition.RECORD_SET);
				
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

	public static class EqualityFilterContext extends ParserRuleContext {
		public BinValueContext binValue() {
			return getRuleContext(BinValueContext.class,0);
		}
		public EqualityFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterEqualityFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitEqualityFilter(this);
		}
	}

	public final EqualityFilterContext equalityFilter() throws RecognitionException {
		EqualityFilterContext _localctx = new EqualityFilterContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_equalityFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376); binValue();
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

	public static class BinValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public TerminalNode EQ() { return getToken(AQLParser.EQ, 0); }
		public BinValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBinValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBinValue(this);
		}
	}

	public final BinValueContext binValue() throws RecognitionException {
		BinValueContext _localctx = new BinValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_binValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); bin();
			setState(379); match(EQ);
			setState(380); value();
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

	public static class RangeFilterContext extends ParserRuleContext {
		public IntegerValueContext low;
		public IntegerValueContext high;
		public IntegerValueContext integerValue(int i) {
			return getRuleContext(IntegerValueContext.class,i);
		}
		public TerminalNode BETWEEN() { return getToken(AQLParser.BETWEEN, 0); }
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public List<IntegerValueContext> integerValue() {
			return getRuleContexts(IntegerValueContext.class);
		}
		public RangeFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRangeFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRangeFilter(this);
		}
	}

	public final RangeFilterContext rangeFilter() throws RecognitionException {
		RangeFilterContext _localctx = new RangeFilterContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_rangeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382); bin();
			setState(383); match(BETWEEN);
			setState(384); ((RangeFilterContext)_localctx).low = integerValue();
			setState(385); match(AND);
			setState(386); ((RangeFilterContext)_localctx).high = integerValue();
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

	public static class ShowContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(AQLParser.SHOW, 0); }
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode QUERIES() { return getToken(AQLParser.QUERIES, 0); }
		public TerminalNode NAMESPACES() { return getToken(AQLParser.NAMESPACES, 0); }
		public TerminalNode SETS() { return getToken(AQLParser.SETS, 0); }
		public TerminalNode SCANS() { return getToken(AQLParser.SCANS, 0); }
		public TerminalNode MODULES() { return getToken(AQLParser.MODULES, 0); }
		public TerminalNode BINS() { return getToken(AQLParser.BINS, 0); }
		public TerminalNode INDEXES() { return getToken(AQLParser.INDEXES, 0); }
		public ShowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterShow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitShow(this);
		}
	}

	public final ShowContext show() throws RecognitionException {
		ShowContext _localctx = new ShowContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_show);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); match(SHOW);
			setState(399);
			switch (_input.LA(1)) {
			case INDEXES:
				{
				setState(389); match(INDEXES);
				setState(391);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(390); nameSet();
					}
				}

				}
				break;
			case SCANS:
				{
				setState(393); match(SCANS);
				}
				break;
			case NAMESPACES:
				{
				setState(394); match(NAMESPACES);
				}
				break;
			case SETS:
				{
				setState(395); match(SETS);
				}
				break;
			case BINS:
				{
				setState(396); match(BINS);
				}
				break;
			case QUERIES:
				{
				setState(397); match(QUERIES);
				}
				break;
			case MODULES:
				{
				setState(398); match(MODULES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

				definitions.add(VariableDefinition.INFO_POLICY);
				definitions.add(VariableDefinition.INFO_STRING);
				
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

	public static class DescContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public ModuleNameContext moduleName() {
			return getRuleContext(ModuleNameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode DESC() { return getToken(AQLParser.DESC, 0); }
		public TerminalNode MODULE() { return getToken(AQLParser.MODULE, 0); }
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
		public DescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDesc(this);
		}
	}

	public final DescContext desc() throws RecognitionException {
		DescContext _localctx = new DescContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403); match(DESC);
			setState(410);
			switch (_input.LA(1)) {
			case MODULE:
				{
				setState(404); match(MODULE);
				setState(405); moduleName();
				}
				break;
			case INDEX:
				{
				setState(406); match(INDEX);
				setState(407); namespace_name();
				setState(408); index_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

				definitions.add(VariableDefinition.INFO_POLICY);
				definitions.add(VariableDefinition.INFO_STRING);
				
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public TerminalNode STAT() { return getToken(AQLParser.STAT, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode QUERY() { return getToken(AQLParser.QUERY, 0); }
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
		public TerminalNode SYSTEM() { return getToken(AQLParser.SYSTEM, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414); match(STAT);
			setState(421);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(415); match(INDEX);
				setState(416); namespace_name();
				setState(417); index_name();
				}
				break;
			case QUERY:
				{
				setState(419); match(QUERY);
				}
				break;
			case SYSTEM:
				{
				setState(420); match(SYSTEM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

				definitions.add(VariableDefinition.INFO_POLICY);
				definitions.add(VariableDefinition.INFO_STRING);
				
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

	public static class SetContext extends ParserRuleContext {
		public Token timeOut;
		public BooleanLiteralContext verboseOn;
		public BooleanLiteralContext echoOn;
		public Token ttl;
		public Token luaUserPath;
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode TTL() { return getToken(AQLParser.TTL, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public TerminalNode ECHO() { return getToken(AQLParser.ECHO, 0); }
		public ViewTypeContext viewType() {
			return getRuleContext(ViewTypeContext.class,0);
		}
		public TerminalNode LUA_USER_PATH() { return getToken(AQLParser.LUA_USER_PATH, 0); }
		public TerminalNode OUTPUT() { return getToken(AQLParser.OUTPUT, 0); }
		public TerminalNode VIEW() { return getToken(AQLParser.VIEW, 0); }
		public TerminalNode VERBOSE() { return getToken(AQLParser.VERBOSE, 0); }
		public TerminalNode TIMEOUT() { return getToken(AQLParser.TIMEOUT, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode SET() { return getToken(AQLParser.SET, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSet(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425); match(SET);
			setState(440);
			switch (_input.LA(1)) {
			case TIMEOUT:
				{
				setState(426); match(TIMEOUT);
				setState(427); ((SetContext)_localctx).timeOut = match(INTLITERAL);
				}
				break;
			case VERBOSE:
				{
				setState(428); match(VERBOSE);
				setState(429); ((SetContext)_localctx).verboseOn = booleanLiteral();
				}
				break;
			case ECHO:
				{
				setState(430); match(ECHO);
				setState(431); ((SetContext)_localctx).echoOn = booleanLiteral();
				}
				break;
			case TTL:
				{
				setState(432); match(TTL);
				setState(433); ((SetContext)_localctx).ttl = match(INTLITERAL);
				}
				break;
			case VIEW:
				{
				setState(434); match(VIEW);
				setState(435); viewType();
				}
				break;
			case OUTPUT:
				{
				setState(436); match(OUTPUT);
				setState(437); viewType();
				}
				break;
			case LUA_USER_PATH:
				{
				setState(438); match(LUA_USER_PATH);
				setState(439); ((SetContext)_localctx).luaUserPath = match(STRINGLITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class GetContext extends ParserRuleContext {
		public TerminalNode TTL() { return getToken(AQLParser.TTL, 0); }
		public TerminalNode ECHO() { return getToken(AQLParser.ECHO, 0); }
		public TerminalNode LUA_USER_PATH() { return getToken(AQLParser.LUA_USER_PATH, 0); }
		public TerminalNode OUTPUT() { return getToken(AQLParser.OUTPUT, 0); }
		public TerminalNode VIEW() { return getToken(AQLParser.VIEW, 0); }
		public TerminalNode VERBOSE() { return getToken(AQLParser.VERBOSE, 0); }
		public TerminalNode TIMEOUT() { return getToken(AQLParser.TIMEOUT, 0); }
		public TerminalNode GET() { return getToken(AQLParser.GET, 0); }
		public GetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitGet(this);
		}
	}

	public final GetContext get() throws RecognitionException {
		GetContext _localctx = new GetContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_get);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442); match(GET);
			setState(443);
			_la = _input.LA(1);
			if ( !(((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (OUTPUT - 40)) | (1L << (TIMEOUT - 40)) | (1L << (VERBOSE - 40)) | (1L << (ECHO - 40)) | (1L << (TTL - 40)) | (1L << (VIEW - 40)) | (1L << (LUA_USER_PATH - 40)))) != 0)) ) {
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

	public static class ViewTypeContext extends ParserRuleContext {
		public ViewTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterViewType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitViewType(this);
		}
	}

	public final ViewTypeContext viewType() throws RecognitionException {
		ViewTypeContext _localctx = new ViewTypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_viewType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__12) | (1L << T__11) | (1L << T__1))) != 0)) ) {
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

	public static class RunContext extends ParserRuleContext {
		public TerminalNode RUN() { return getToken(AQLParser.RUN, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRun(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447); match(RUN);
			setState(448); match(STRINGLITERAL);
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(AQLParser.PRINT, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450); match(PRINT);
			setState(452);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL) {
				{
				setState(451); match(STRINGLITERAL);
				}
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

	public static class KillContext extends ParserRuleContext {
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode SCAN() { return getToken(AQLParser.SCAN, 0); }
		public TerminalNode QUERY() { return getToken(AQLParser.QUERY, 0); }
		public TerminalNode KILL() { return getToken(AQLParser.KILL, 0); }
		public KillContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kill; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterKill(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitKill(this);
		}
	}

	public final KillContext kill() throws RecognitionException {
		KillContext _localctx = new KillContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_kill);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454); match(KILL);
			setState(455);
			_la = _input.LA(1);
			if ( !(_la==QUERY || _la==SCAN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(456); match(INTLITERAL);
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

	public static class Kill_queryContext extends ParserRuleContext {
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode KILL_QUERY() { return getToken(AQLParser.KILL_QUERY, 0); }
		public Kill_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kill_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterKill_query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitKill_query(this);
		}
	}

	public final Kill_queryContext kill_query() throws RecognitionException {
		Kill_queryContext _localctx = new Kill_queryContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_kill_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458); match(KILL_QUERY);
			setState(459); match(INTLITERAL);
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

	public static class Kill_scanContext extends ParserRuleContext {
		public TerminalNode KILL_SCAN() { return getToken(AQLParser.KILL_SCAN, 0); }
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public Kill_scanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kill_scan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterKill_scan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitKill_scan(this);
		}
	}

	public final Kill_scanContext kill_scan() throws RecognitionException {
		Kill_scanContext _localctx = new Kill_scanContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_kill_scan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461); match(KILL_SCAN);
			setState(462); match(INTLITERAL);
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

	public static class QuitContext extends ParserRuleContext {
		public TerminalNode QUIT() { return getToken(AQLParser.QUIT, 0); }
		public TerminalNode EXIT() { return getToken(AQLParser.EXIT, 0); }
		public QuitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterQuit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitQuit(this);
		}
	}

	public final QuitContext quit() throws RecognitionException {
		QuitContext _localctx = new QuitContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_quit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << QUIT) | (1L << EXIT))) != 0)) ) {
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

	public static class HelpContext extends ParserRuleContext {
		public HelpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_help; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterHelp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitHelp(this);
		}
	}

	public final HelpContext help() throws RecognitionException {
		HelpContext _localctx = new HelpContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_help);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); match(T__9);
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

	public static class PrimaryKeyContext extends ParserRuleContext {
		public String nameSpace;
		public String setName;
		public Token key;
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public PrimaryKeyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PrimaryKeyContext(ParserRuleContext parent, int invokingState, String nameSpace, String setName) {
			super(parent, invokingState);
			this.nameSpace = nameSpace;
			this.setName = setName;
		}
		@Override public int getRuleIndex() { return RULE_primaryKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPrimaryKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPrimaryKey(this);
		}
	}

	public final PrimaryKeyContext primaryKey(String nameSpace,String setName) throws RecognitionException {
		PrimaryKeyContext _localctx = new PrimaryKeyContext(_ctx, getState(), nameSpace, setName);
		enterRule(_localctx, 86, RULE_primaryKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			((PrimaryKeyContext)_localctx).key = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==STRINGLITERAL || _la==INTLITERAL) ) {
				((PrimaryKeyContext)_localctx).key = (Token)_errHandler.recoverInline(this);
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

	public static class Package_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public Package_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPackage_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPackage_name(this);
		}
	}

	public final Package_nameContext package_name() throws RecognitionException {
		Package_nameContext _localctx = new Package_nameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_package_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470); match(IDENTIFIER);
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

	public static class Index_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitIndex_name(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); match(IDENTIFIER);
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

	public static class Namespace_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public Namespace_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNamespace_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNamespace_name(this);
		}
	}

	public final Namespace_nameContext namespace_name() throws RecognitionException {
		Namespace_nameContext _localctx = new Namespace_nameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_namespace_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); match(IDENTIFIER);
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

	public static class Set_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public Set_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSet_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSet_name(this);
		}
	}

	public final Set_nameContext set_name() throws RecognitionException {
		Set_nameContext _localctx = new Set_nameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_set_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476); match(IDENTIFIER);
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

	public static class BinContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public BinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBin(this);
		}
	}

	public final BinContext bin() throws RecognitionException {
		BinContext _localctx = new BinContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_bin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478); match(IDENTIFIER);
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
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public TextValueContext textValue() {
			return getRuleContext(TextValueContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_value);
		try {
			setState(482);
			switch (_input.LA(1)) {
			case INTLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(480); integerValue();
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(481); textValue();
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

	public static class TextValueContext extends ParserRuleContext {
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public TextValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterTextValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitTextValue(this);
		}
	}

	public final TextValueContext textValue() throws RecognitionException {
		TextValueContext _localctx = new TextValueContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_textValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484); match(STRINGLITERAL);
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

	public static class IntegerValueContext extends ParserRuleContext {
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public IntegerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitIntegerValue(this);
		}
	}

	public final IntegerValueContext integerValue() throws RecognitionException {
		IntegerValueContext _localctx = new IntegerValueContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_integerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486); match(INTLITERAL);
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(AQLParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(AQLParser.TRUE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
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

	public static class ModuleNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public ModuleNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterModuleName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitModuleName(this);
		}
	}

	public final ModuleNameContext moduleName() throws RecognitionException {
		ModuleNameContext _localctx = new ModuleNameContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_moduleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490); match(IDENTIFIER);
			setState(491); match(T__0);
			setState(492);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__12) ) {
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

	public static class FilePathContext extends ParserRuleContext {
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public FilePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterFilePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitFilePath(this);
		}
	}

	public final FilePathContext filePath() throws RecognitionException {
		FilePathContext _localctx = new FilePathContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_filePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494); match(STRINGLITERAL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\\\u01f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\3\7\3u\n\3\f\3\16"+
		"\3x\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0091\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00ae\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00b8\n"+
		"\n\f\n\16\n\u00bb\13\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c3\n\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e1\n\f\3\f\3"+
		"\f\3\r\3\r\3\r\7\r\u00e8\n\r\f\r\16\r\u00eb\13\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\5\17\u00f7\n\17\3\17\3\17\3\17\5\17\u00fc"+
		"\n\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0124\n\21"+
		"\3\21\3\21\5\21\u0128\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0130\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u013b\n\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0141\n\24\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0149"+
		"\n\25\3\25\5\25\u014c\n\25\3\25\3\25\3\25\5\25\u0151\n\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u015c\n\27\f\27\16\27\u015f\13"+
		"\27\3\30\3\30\3\30\7\30\u0164\n\30\f\30\16\30\u0167\13\30\3\31\3\31\5"+
		"\31\u016b\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\5\34"+
		"\u0177\n\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \5 \u018a\n \3 \3 \3 \3 \3 \3 \5 \u0192\n \3 \3 \3"+
		"!\3!\3!\3!\3!\3!\3!\5!\u019d\n!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\""+
		"\u01a8\n\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01bb"+
		"\n#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\5\'\u01c7\n\'\3(\3(\3(\3(\3)\3)\3"+
		")\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\5\63\u01e5\n\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67"+
		"\3\67\38\38\38\2\29\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjln\2\n\3\2=>\6\2**\66\66NQSS\5\2\5"+
		"\5\b\t\23\23\3\2\64\65\4\2\4\4\678\4\2VVXX\3\2\25\26\4\2\6\6\b\b\u01fd"+
		"\2p\3\2\2\2\4v\3\2\2\2\6\u0090\3\2\2\2\b\u0092\3\2\2\2\n\u0097\3\2\2\2"+
		"\f\u0099\3\2\2\2\16\u00a4\3\2\2\2\20\u00af\3\2\2\2\22\u00b3\3\2\2\2\24"+
		"\u00c6\3\2\2\2\26\u00d8\3\2\2\2\30\u00e4\3\2\2\2\32\u00ec\3\2\2\2\34\u00f3"+
		"\3\2\2\2\36\u00ff\3\2\2\2 \u0127\3\2\2\2\"\u0129\3\2\2\2$\u0131\3\2\2"+
		"\2&\u0136\3\2\2\2(\u0144\3\2\2\2*\u0154\3\2\2\2,\u0158\3\2\2\2.\u0160"+
		"\3\2\2\2\60\u016a\3\2\2\2\62\u016c\3\2\2\2\64\u0170\3\2\2\2\66\u0176\3"+
		"\2\2\28\u017a\3\2\2\2:\u017c\3\2\2\2<\u0180\3\2\2\2>\u0186\3\2\2\2@\u0195"+
		"\3\2\2\2B\u01a0\3\2\2\2D\u01ab\3\2\2\2F\u01bc\3\2\2\2H\u01bf\3\2\2\2J"+
		"\u01c1\3\2\2\2L\u01c4\3\2\2\2N\u01c8\3\2\2\2P\u01cc\3\2\2\2R\u01cf\3\2"+
		"\2\2T\u01d2\3\2\2\2V\u01d4\3\2\2\2X\u01d6\3\2\2\2Z\u01d8\3\2\2\2\\\u01da"+
		"\3\2\2\2^\u01dc\3\2\2\2`\u01de\3\2\2\2b\u01e0\3\2\2\2d\u01e4\3\2\2\2f"+
		"\u01e6\3\2\2\2h\u01e8\3\2\2\2j\u01ea\3\2\2\2l\u01ec\3\2\2\2n\u01f0\3\2"+
		"\2\2pq\5\4\3\2qr\7\2\2\3r\3\3\2\2\2su\5\6\4\2ts\3\2\2\2ux\3\2\2\2vt\3"+
		"\2\2\2vw\3\2\2\2w\5\3\2\2\2xv\3\2\2\2y\u0091\5\b\5\2z\u0091\5\n\6\2{\u0091"+
		"\5\f\7\2|\u0091\5\16\b\2}\u0091\5\20\t\2~\u0091\5\24\13\2\177\u0091\5"+
		"\26\f\2\u0080\u0091\5\32\16\2\u0081\u0091\5\34\17\2\u0082\u0091\5$\23"+
		"\2\u0083\u0091\5&\24\2\u0084\u0091\5(\25\2\u0085\u0091\5\22\n\2\u0086"+
		"\u0091\5> \2\u0087\u0091\5@!\2\u0088\u0091\5B\"\2\u0089\u0091\5D#\2\u008a"+
		"\u0091\5F$\2\u008b\u0091\5J&\2\u008c\u0091\5N(\2\u008d\u0091\5T+\2\u008e"+
		"\u0091\5V,\2\u008f\u0091\5L\'\2\u0090y\3\2\2\2\u0090z\3\2\2\2\u0090{\3"+
		"\2\2\2\u0090|\3\2\2\2\u0090}\3\2\2\2\u0090~\3\2\2\2\u0090\177\3\2\2\2"+
		"\u0090\u0080\3\2\2\2\u0090\u0081\3\2\2\2\u0090\u0082\3\2\2\2\u0090\u0083"+
		"\3\2\2\2\u0090\u0084\3\2\2\2\u0090\u0085\3\2\2\2\u0090\u0086\3\2\2\2\u0090"+
		"\u0087\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0089\3\2\2\2\u0090\u008a\3\2"+
		"\2\2\u0090\u008b\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\7\3\2\2\2\u0092\u0093\7\27\2"+
		"\2\u0093\u0094\7V\2\2\u0094\u0095\7X\2\2\u0095\u0096\b\5\1\2\u0096\t\3"+
		"\2\2\2\u0097\u0098\7\30\2\2\u0098\13\3\2\2\2\u0099\u009a\7\35\2\2\u009a"+
		"\u009b\7\36\2\2\u009b\u009c\5\\/\2\u009c\u009d\7(\2\2\u009d\u009e\5\""+
		"\22\2\u009e\u009f\7\r\2\2\u009f\u00a0\5b\62\2\u00a0\u00a1\7\17\2\2\u00a1"+
		"\u00a2\t\2\2\2\u00a2\u00a3\b\7\1\2\u00a3\r\3\2\2\2\u00a4\u00ad\7\"\2\2"+
		"\u00a5\u00a6\7\36\2\2\u00a6\u00a7\5\"\22\2\u00a7\u00a8\5\\/\2\u00a8\u00ae"+
		"\3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa\u00ae\5l\67\2\u00ab\u00ac\7%\2\2\u00ac"+
		"\u00ae\5\"\22\2\u00ad\u00a5\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00ab\3"+
		"\2\2\2\u00ae\17\3\2\2\2\u00af\u00b0\7B\2\2\u00b0\u00b1\7\'\2\2\u00b1\u00b2"+
		"\5l\67\2\u00b2\21\3\2\2\2\u00b3\u00b4\7)\2\2\u00b4\u00b9\5 \21\2\u00b5"+
		"\u00b6\7\22\2\2\u00b6\u00b8\5 \21\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3"+
		"\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bc\u00bd\7(\2\2\u00bd\u00be\5\"\22\2\u00be\u00bf\7 "+
		"\2\2\u00bf\u00c2\5\62\32\2\u00c0\u00c1\7\60\2\2\u00c1\u00c3\5\64\33\2"+
		"\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5"+
		"\b\n\1\2\u00c5\23\3\2\2\2\u00c6\u00c7\7\32\2\2\u00c7\u00c8\7,\2\2\u00c8"+
		"\u00c9\5\"\22\2\u00c9\u00ca\7\r\2\2\u00ca\u00cb\7<\2\2\u00cb\u00cc\7\22"+
		"\2\2\u00cc\u00cd\5,\27\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7\17\2\2\u00cf"+
		"\u00d0\7$\2\2\u00d0\u00d1\7\r\2\2\u00d1\u00d2\5X-\2\u00d2\u00d3\7\22\2"+
		"\2\u00d3\u00d4\5.\30\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\17\2\2\u00d6"+
		"\u00d7\b\13\1\2\u00d7\25\3\2\2\2\u00d8\u00d9\7M\2\2\u00d9\u00da\5\"\22"+
		"\2\u00da\u00db\7%\2\2\u00db\u00dc\5\30\r\2\u00dc\u00dd\7 \2\2\u00dd\u00e0"+
		"\5\62\32\2\u00de\u00df\7\60\2\2\u00df\u00e1\5\64\33\2\u00e0\u00de\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\f\1\2\u00e3"+
		"\27\3\2\2\2\u00e4\u00e9\5:\36\2\u00e5\u00e6\7\22\2\2\u00e6\u00e8\5:\36"+
		"\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\31\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7\34\2\2\u00ed"+
		"\u00ee\7.\2\2\u00ee\u00ef\5\"\22\2\u00ef\u00f0\7 \2\2\u00f0\u00f1\5\62"+
		"\32\2\u00f1\u00f2\b\16\1\2\u00f2\33\3\2\2\2\u00f3\u00f6\7\33\2\2\u00f4"+
		"\u00f7\7@\2\2\u00f5\u00f7\5,\27\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\7.\2\2\u00f9\u00fb\5\"\22\2\u00fa"+
		"\u00fc\5\36\20\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3"+
		"\2\2\2\u00fd\u00fe\b\17\1\2\u00fe\35\3\2\2\2\u00ff\u0100\7 \2\2\u0100"+
		"\u0101\5\60\31\2\u0101\37\3\2\2\2\u0102\u0103\7\3\2\2\u0103\u0104\7\r"+
		"\2\2\u0104\u0105\5b\62\2\u0105\u0106\7\22\2\2\u0106\u0107\5d\63\2\u0107"+
		"\u0108\7\17\2\2\u0108\u0128\3\2\2\2\u0109\u010a\7\16\2\2\u010a\u010b\7"+
		"\r\2\2\u010b\u010c\5b\62\2\u010c\u010d\7\22\2\2\u010d\u010e\5d\63\2\u010e"+
		"\u010f\7\17\2\2\u010f\u0128\3\2\2\2\u0110\u0111\7\21\2\2\u0111\u0112\7"+
		"\r\2\2\u0112\u0113\5b\62\2\u0113\u0114\7\22\2\2\u0114\u0115\5d\63\2\u0115"+
		"\u0116\7\17\2\2\u0116\u0128\3\2\2\2\u0117\u0118\7\n\2\2\u0118\u0119\7"+
		"\r\2\2\u0119\u011a\5b\62\2\u011a\u011b\7\22\2\2\u011b\u011c\5d\63\2\u011c"+
		"\u011d\7\17\2\2\u011d\u0128\3\2\2\2\u011e\u0123\7&\2\2\u011f\u0120\7\r"+
		"\2\2\u0120\u0121\5b\62\2\u0121\u0122\7\17\2\2\u0122\u0124\3\2\2\2\u0123"+
		"\u011f\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0128\3\2\2\2\u0125\u0128\7\7"+
		"\2\2\u0126\u0128\7\f\2\2\u0127\u0102\3\2\2\2\u0127\u0109\3\2\2\2\u0127"+
		"\u0110\3\2\2\2\u0127\u0117\3\2\2\2\u0127\u011e\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0127\u0126\3\2\2\2\u0128!\3\2\2\2\u0129\u012a\5^\60\2\u012a\u012f"+
		"\b\22\1\2\u012b\u012c\7\24\2\2\u012c\u012d\5`\61\2\u012d\u012e\b\22\1"+
		"\2\u012e\u0130\3\2\2\2\u012f\u012b\3\2\2\2\u012f\u0130\3\2\2\2\u0130#"+
		"\3\2\2\2\u0131\u0132\7A\2\2\u0132\u0133\7\'\2\2\u0133\u0134\5n8\2\u0134"+
		"\u0135\b\23\1\2\u0135%\3\2\2\2\u0136\u0137\7\37\2\2\u0137\u0138\5*\26"+
		"\2\u0138\u013a\7\r\2\2\u0139\u013b\5.\30\2\u013a\u0139\3\2\2\2\u013a\u013b"+
		"\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\7\17\2\2\u013d\u013e\7(\2\2\u013e"+
		"\u0140\5\"\22\2\u013f\u0141\5\36\20\2\u0140\u013f\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\b\24\1\2\u0143\'\3\2\2\2\u0144"+
		"\u0145\7C\2\2\u0145\u014b\5*\26\2\u0146\u0148\7\r\2\2\u0147\u0149\5.\30"+
		"\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c"+
		"\7\17\2\2\u014b\u0146\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2"+
		"\u014d\u014e\7(\2\2\u014e\u0150\5\"\22\2\u014f\u0151\5\36\20\2\u0150\u014f"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\b\25\1\2"+
		"\u0153)\3\2\2\2\u0154\u0155\7U\2\2\u0155\u0156\7\24\2\2\u0156\u0157\7"+
		"U\2\2\u0157+\3\2\2\2\u0158\u015d\5b\62\2\u0159\u015a\7\22\2\2\u015a\u015c"+
		"\5b\62\2\u015b\u0159\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e-\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0165\5d\63\2"+
		"\u0161\u0162\7\22\2\2\u0162\u0164\5d\63\2\u0163\u0161\3\2\2\2\u0164\u0167"+
		"\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166/\3\2\2\2\u0167"+
		"\u0165\3\2\2\2\u0168\u016b\5\62\32\2\u0169\u016b\5\66\34\2\u016a\u0168"+
		"\3\2\2\2\u016a\u0169\3\2\2\2\u016b\61\3\2\2\2\u016c\u016d\7<\2\2\u016d"+
		"\u016e\7?\2\2\u016e\u016f\5X-\2\u016f\63\3\2\2\2\u0170\u0171\7\20\2\2"+
		"\u0171\u0172\7?\2\2\u0172\u0173\7X\2\2\u0173\65\3\2\2\2\u0174\u0177\5"+
		"8\35\2\u0175\u0177\5<\37\2\u0176\u0174\3\2\2\2\u0176\u0175\3\2\2\2\u0177"+
		"\u0178\3\2\2\2\u0178\u0179\b\34\1\2\u0179\67\3\2\2\2\u017a\u017b\5:\36"+
		"\2\u017b9\3\2\2\2\u017c\u017d\5b\62\2\u017d\u017e\7?\2\2\u017e\u017f\5"+
		"d\63\2\u017f;\3\2\2\2\u0180\u0181\5b\62\2\u0181\u0182\7\61\2\2\u0182\u0183"+
		"\5h\65\2\u0183\u0184\7\60\2\2\u0184\u0185\5h\65\2\u0185=\3\2\2\2\u0186"+
		"\u0191\7!\2\2\u0187\u0189\7#\2\2\u0188\u018a\5\"\22\2\u0189\u0188\3\2"+
		"\2\2\u0189\u018a\3\2\2\2\u018a\u0192\3\2\2\2\u018b\u0192\7H\2\2\u018c"+
		"\u0192\7E\2\2\u018d\u0192\7F\2\2\u018e\u0192\7G\2\2\u018f\u0192\7I\2\2"+
		"\u0190\u0192\7D\2\2\u0191\u0187\3\2\2\2\u0191\u018b\3\2\2\2\u0191\u018c"+
		"\3\2\2\2\u0191\u018d\3\2\2\2\u0191\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0191"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\b \1\2\u0194?\3\2\2\2\u0195"+
		"\u019c\7\31\2\2\u0196\u0197\7\'\2\2\u0197\u019d\5l\67\2\u0198\u0199\7"+
		"\36\2\2\u0199\u019a\5^\60\2\u019a\u019b\5\\/\2\u019b\u019d\3\2\2\2\u019c"+
		"\u0196\3\2\2\2\u019c\u0198\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\b!"+
		"\1\2\u019fA\3\2\2\2\u01a0\u01a7\7\63\2\2\u01a1\u01a2\7\36\2\2\u01a2\u01a3"+
		"\5^\60\2\u01a3\u01a4\5\\/\2\u01a4\u01a8\3\2\2\2\u01a5\u01a8\7\64\2\2\u01a6"+
		"\u01a8\7J\2\2\u01a7\u01a1\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\b\"\1\2\u01aaC\3\2\2\2\u01ab\u01ba"+
		"\7%\2\2\u01ac\u01ad\7\66\2\2\u01ad\u01bb\7X\2\2\u01ae\u01af\7N\2\2\u01af"+
		"\u01bb\5j\66\2\u01b0\u01b1\7O\2\2\u01b1\u01bb\5j\66\2\u01b2\u01b3\7P\2"+
		"\2\u01b3\u01bb\7X\2\2\u01b4\u01b5\7Q\2\2\u01b5\u01bb\5H%\2\u01b6\u01b7"+
		"\7*\2\2\u01b7\u01bb\5H%\2\u01b8\u01b9\7S\2\2\u01b9\u01bb\7V\2\2\u01ba"+
		"\u01ac\3\2\2\2\u01ba\u01ae\3\2\2\2\u01ba\u01b0\3\2\2\2\u01ba\u01b2\3\2"+
		"\2\2\u01ba\u01b4\3\2\2\2\u01ba\u01b6\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb"+
		"E\3\2\2\2\u01bc\u01bd\7&\2\2\u01bd\u01be\t\3\2\2\u01beG\3\2\2\2\u01bf"+
		"\u01c0\t\4\2\2\u01c0I\3\2\2\2\u01c1\u01c2\7\62\2\2\u01c2\u01c3\7V\2\2"+
		"\u01c3K\3\2\2\2\u01c4\u01c6\7L\2\2\u01c5\u01c7\7V\2\2\u01c6\u01c5\3\2"+
		"\2\2\u01c6\u01c7\3\2\2\2\u01c7M\3\2\2\2\u01c8\u01c9\79\2\2\u01c9\u01ca"+
		"\t\5\2\2\u01ca\u01cb\7X\2\2\u01cbO\3\2\2\2\u01cc\u01cd\7:\2\2\u01cd\u01ce"+
		"\7X\2\2\u01ceQ\3\2\2\2\u01cf\u01d0\7;\2\2\u01d0\u01d1\7X\2\2\u01d1S\3"+
		"\2\2\2\u01d2\u01d3\t\6\2\2\u01d3U\3\2\2\2\u01d4\u01d5\7\13\2\2\u01d5W"+
		"\3\2\2\2\u01d6\u01d7\t\7\2\2\u01d7Y\3\2\2\2\u01d8\u01d9\7U\2\2\u01d9["+
		"\3\2\2\2\u01da\u01db\7U\2\2\u01db]\3\2\2\2\u01dc\u01dd\7U\2\2\u01dd_\3"+
		"\2\2\2\u01de\u01df\7U\2\2\u01dfa\3\2\2\2\u01e0\u01e1\7U\2\2\u01e1c\3\2"+
		"\2\2\u01e2\u01e5\5h\65\2\u01e3\u01e5\5f\64\2\u01e4\u01e2\3\2\2\2\u01e4"+
		"\u01e3\3\2\2\2\u01e5e\3\2\2\2\u01e6\u01e7\7V\2\2\u01e7g\3\2\2\2\u01e8"+
		"\u01e9\7X\2\2\u01e9i\3\2\2\2\u01ea\u01eb\t\b\2\2\u01ebk\3\2\2\2\u01ec"+
		"\u01ed\7U\2\2\u01ed\u01ee\7\24\2\2\u01ee\u01ef\t\t\2\2\u01efm\3\2\2\2"+
		"\u01f0\u01f1\7V\2\2\u01f1o\3\2\2\2\36v\u0090\u00ad\u00b9\u00c2\u00e0\u00e9"+
		"\u00f6\u00fb\u0123\u0127\u012f\u013a\u0140\u0148\u014b\u0150\u015d\u0165"+
		"\u016a\u0176\u0189\u0191\u019c\u01a7\u01ba\u01c6\u01e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}