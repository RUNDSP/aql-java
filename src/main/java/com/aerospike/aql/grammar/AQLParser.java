// Generated from AQL.g4 by ANTLR 4.3

package com.aerospike.aql.grammar;
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
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, TRUE=22, FALSE=23, CONNECT=24, 
		DISCONNECT=25, DESC=26, INSERT=27, SELECT=28, DELETE=29, CREATE=30, INDEX=31, 
		EXECUTE=32, WHERE=33, SHOW=34, DROP=35, INDEXES=36, VALUES=37, SET=38, 
		GET=39, MODULE=40, ON=41, OPERATE=42, OUTPUT=43, PACKAGES=44, INTO=45, 
		FUNCTION=46, FROM=47, BY=48, AND=49, BETWEEN=50, RUN=51, STAT=52, QUERY=53, 
		SCAN=54, TIMEOUT=55, QUIT=56, EXIT=57, KILL=58, KILL_QUERY=59, KILL_SCAN=60, 
		PK=61, STRING=62, NUMERIC=63, EQ=64, IN=65, LIST=66, MAPKEYS=67, MAPVALUES=68, 
		STAR=69, REGISTER=70, REMOVE=71, AGGREGATE=72, MODULES=73, NAMESPACES=74, 
		SETS=75, BINS=76, SCANS=77, QUERIES=78, SYSTEM=79, ORDER=80, PRINT=81, 
		UPDATE=82, VERBOSE=83, ECHO=84, TTL=85, USE_SMD=86, LUA_USER_PATH=87, 
		LUA_SYSTEM_PATH=88, ADD=89, PUT=90, APPEND=91, PREPEND=92, TOUCH=93, HEADER=94, 
		LLIST=95, LSTACK=96, LSET=97, LMAP=98, USER=99, USERS=100, PASSWORD=101, 
		ROLE=102, ROLES=103, GRANT=104, REVOKE=105, TO=106, FAIL_ON_CLUSTER_CHANGE=107, 
		REPAIR=108, FOR=109, IDENTIFIER=110, STRINGLITERAL=111, FLOATLITERAL=112, 
		INTLITERAL=113, HEXLITERAL=114, NEWLINE=115, WS=116, COMMENT=117;
	public static final String[] tokenNames = {
		"<INVALID>", "'user-admin'", "'read-write'", "'q'", "'find'", "'nosql'", 
		"'get_capacity'", "'destroy'", "'sys-admin'", "'so'", "'lua'", "'size'", 
		"'table'", "'help'", "'read'", "'('", "'get_config'", "')'", "'generation'", 
		"','", "'json'", "'.'", "'true'", "'false'", "'connect'", "'disconnect'", 
		"'desc'", "'insert'", "'select'", "'delete'", "'create'", "'index'", "'execute'", 
		"'where'", "'show'", "'drop'", "'indexes'", "'values'", "'set'", "'get'", 
		"'module'", "'on'", "'operate'", "'output'", "'packages'", "'into'", "'function'", 
		"'from'", "'by'", "'and'", "'between'", "'run'", "'stat'", "'query'", 
		"'scan'", "'timeout'", "'quit'", "'exit'", "'kill'", "'kill_query'", "'kill_scan'", 
		"'pk'", "'string'", "'numeric'", "'='", "'in'", "'list'", "'mapkeys'", 
		"'mapvalues'", "'*'", "'register'", "'remove'", "'aggregate'", "'modules'", 
		"'namespaces'", "'sets'", "'bins'", "'scans'", "'queries'", "'system'", 
		"'order'", "'print'", "'update'", "'verbose'", "'echo'", "'ttl'", "'use_smd'", 
		"'lua_userpath'", "'lua_syspath'", "'add'", "'put'", "'append'", "'prepend'", 
		"'touch'", "'header'", "'llist'", "'lstack'", "'lset'", "'lmap'", "'user'", 
		"'users'", "'password'", "'role'", "'roles'", "'grant'", "'revoke'", "'to'", 
		"'FAIL_ON_CLUSTER_CHANGE'", "'repair'", "'for'", "IDENTIFIER", "STRINGLITERAL", 
		"FLOATLITERAL", "INTLITERAL", "HEXLITERAL", "NEWLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_aql = 0, RULE_statements = 1, RULE_statement = 2, RULE_connect = 3, 
		RULE_disconnect = 4, RULE_create = 5, RULE_drop = 6, RULE_repair = 7, 
		RULE_grant = 8, RULE_revoke = 9, RULE_user = 10, RULE_password = 11, RULE_roles = 12, 
		RULE_role = 13, RULE_remove = 14, RULE_operate = 15, RULE_insert = 16, 
		RULE_update = 17, RULE_updateList = 18, RULE_delete = 19, RULE_select = 20, 
		RULE_collectionType = 21, RULE_where = 22, RULE_operateFunction = 23, 
		RULE_nameSet = 24, RULE_register = 25, RULE_execute = 26, RULE_aggregate = 27, 
		RULE_moduleFunction = 28, RULE_binNameList = 29, RULE_valueList = 30, 
		RULE_predicate = 31, RULE_primaryKeyPredicate = 32, RULE_generationPredicate = 33, 
		RULE_filterPredicate = 34, RULE_equalityFilter = 35, RULE_ttlValue = 36, 
		RULE_binValue = 37, RULE_rangeFilter = 38, RULE_show = 39, RULE_desc = 40, 
		RULE_stat = 41, RULE_set = 42, RULE_get = 43, RULE_viewType = 44, RULE_run = 45, 
		RULE_print = 46, RULE_kill = 47, RULE_kill_query = 48, RULE_kill_scan = 49, 
		RULE_quit = 50, RULE_help = 51, RULE_primaryKey = 52, RULE_package_name = 53, 
		RULE_index_name = 54, RULE_namespace_name = 55, RULE_set_name = 56, RULE_bin = 57, 
		RULE_value = 58, RULE_textValue = 59, RULE_integerValue = 60, RULE_booleanLiteral = 61, 
		RULE_moduleName = 62, RULE_filePath = 63;
	public static final String[] ruleNames = {
		"aql", "statements", "statement", "connect", "disconnect", "create", "drop", 
		"repair", "grant", "revoke", "user", "password", "roles", "role", "remove", 
		"operate", "insert", "update", "updateList", "delete", "select", "collectionType", 
		"where", "operateFunction", "nameSet", "register", "execute", "aggregate", 
		"moduleFunction", "binNameList", "valueList", "predicate", "primaryKeyPredicate", 
		"generationPredicate", "filterPredicate", "equalityFilter", "ttlValue", 
		"binValue", "rangeFilter", "show", "desc", "stat", "set", "get", "viewType", 
		"run", "print", "kill", "kill_query", "kill_scan", "quit", "help", "primaryKey", 
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
		RECORD, 
		RECORD_SET, 
		RESULT_SET, 
		WRITE_POLICY, 
		READ_POLICY,
		QUERY_POLICY,
		SCAN_POLICY,
		INFO_POLICY,
		STMT,
		UDF_FILE,
		REGISTER_TASK,
		INDEX_TASK,
		INFO_STRING,
		ADMIN_POLICY;
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
			setState(128); statements();
			setState(129); match(EOF);
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
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__8) | (1L << CONNECT) | (1L << DISCONNECT) | (1L << DESC) | (1L << INSERT) | (1L << SELECT) | (1L << DELETE) | (1L << CREATE) | (1L << EXECUTE) | (1L << SHOW) | (1L << DROP) | (1L << SET) | (1L << GET) | (1L << OPERATE) | (1L << RUN) | (1L << STAT) | (1L << QUIT) | (1L << EXIT) | (1L << KILL))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (REGISTER - 70)) | (1L << (REMOVE - 70)) | (1L << (AGGREGATE - 70)) | (1L << (PRINT - 70)) | (1L << (UPDATE - 70)) | (1L << (GRANT - 70)) | (1L << (REVOKE - 70)) | (1L << (REPAIR - 70)))) != 0)) {
				{
				{
				setState(131); statement();
				}
				}
				setState(136);
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
		public GrantContext grant() {
			return getRuleContext(GrantContext.class,0);
		}
		public ShowContext show() {
			return getRuleContext(ShowContext.class,0);
		}
		public AggregateContext aggregate() {
			return getRuleContext(AggregateContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public ExecuteContext execute() {
			return getRuleContext(ExecuteContext.class,0);
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
		public DisconnectContext disconnect() {
			return getRuleContext(DisconnectContext.class,0);
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
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public KillContext kill() {
			return getRuleContext(KillContext.class,0);
		}
		public RevokeContext revoke() {
			return getRuleContext(RevokeContext.class,0);
		}
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public RunContext run() {
			return getRuleContext(RunContext.class,0);
		}
		public HelpContext help() {
			return getRuleContext(HelpContext.class,0);
		}
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public RepairContext repair() {
			return getRuleContext(RepairContext.class,0);
		}
		public OperateContext operate() {
			return getRuleContext(OperateContext.class,0);
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
			setState(163);
			switch (_input.LA(1)) {
			case CONNECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); connect();
				}
				break;
			case DISCONNECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); disconnect();
				}
				break;
			case CREATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(139); create();
				}
				break;
			case DROP:
				enterOuterAlt(_localctx, 4);
				{
				setState(140); drop();
				}
				break;
			case REPAIR:
				enterOuterAlt(_localctx, 5);
				{
				setState(141); repair();
				}
				break;
			case GRANT:
				enterOuterAlt(_localctx, 6);
				{
				setState(142); grant();
				}
				break;
			case REVOKE:
				enterOuterAlt(_localctx, 7);
				{
				setState(143); revoke();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 8);
				{
				setState(144); remove();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 9);
				{
				setState(145); insert();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 10);
				{
				setState(146); update();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 11);
				{
				setState(147); delete();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 12);
				{
				setState(148); select();
				}
				break;
			case REGISTER:
				enterOuterAlt(_localctx, 13);
				{
				setState(149); register();
				}
				break;
			case EXECUTE:
				enterOuterAlt(_localctx, 14);
				{
				setState(150); execute();
				}
				break;
			case AGGREGATE:
				enterOuterAlt(_localctx, 15);
				{
				setState(151); aggregate();
				}
				break;
			case OPERATE:
				enterOuterAlt(_localctx, 16);
				{
				setState(152); operate();
				}
				break;
			case SHOW:
				enterOuterAlt(_localctx, 17);
				{
				setState(153); show();
				}
				break;
			case DESC:
				enterOuterAlt(_localctx, 18);
				{
				setState(154); desc();
				}
				break;
			case STAT:
				enterOuterAlt(_localctx, 19);
				{
				setState(155); stat();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 20);
				{
				setState(156); set();
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 21);
				{
				setState(157); get();
				}
				break;
			case RUN:
				enterOuterAlt(_localctx, 22);
				{
				setState(158); run();
				}
				break;
			case KILL:
				enterOuterAlt(_localctx, 23);
				{
				setState(159); kill();
				}
				break;
			case T__18:
			case QUIT:
			case EXIT:
				enterOuterAlt(_localctx, 24);
				{
				setState(160); quit();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 25);
				{
				setState(161); help();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 26);
				{
				setState(162); print();
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
		public Token timeout;
		public List<TerminalNode> INTLITERAL() { return getTokens(AQLParser.INTLITERAL); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public TerminalNode CONNECT() { return getToken(AQLParser.CONNECT, 0); }
		public TerminalNode INTLITERAL(int i) {
			return getToken(AQLParser.INTLITERAL, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(CONNECT);
			setState(166); ((ConnectContext)_localctx).hostName = match(STRINGLITERAL);
			setState(167); ((ConnectContext)_localctx).port = match(INTLITERAL);
			setState(169);
			_la = _input.LA(1);
			if (_la==INTLITERAL) {
				{
				setState(168); ((ConnectContext)_localctx).timeout = match(INTLITERAL);
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
			setState(171); match(DISCONNECT);
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
		public List<RolesContext> roles() {
			return getRuleContexts(RolesContext.class);
		}
		public TerminalNode ON() { return getToken(AQLParser.ON, 0); }
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public PasswordContext password() {
			return getRuleContext(PasswordContext.class,0);
		}
		public TerminalNode STRING() { return getToken(AQLParser.STRING, 0); }
		public TerminalNode USER() { return getToken(AQLParser.USER, 0); }
		public TerminalNode PASSWORD() { return getToken(AQLParser.PASSWORD, 0); }
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public TerminalNode ROLES() { return getToken(AQLParser.ROLES, 0); }
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode NUMERIC() { return getToken(AQLParser.NUMERIC, 0); }
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(AQLParser.CREATE, 0); }
		public TerminalNode ROLE() { return getToken(AQLParser.ROLE, 0); }
		public RolesContext roles(int i) {
			return getRuleContext(RolesContext.class,i);
		}
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
			setState(173); match(CREATE);
			setState(201);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(174); match(INDEX);
				setState(175); index_name();
				setState(176); match(ON);
				setState(177); nameSet();
				setState(178); match(T__6);
				setState(179); ((CreateContext)_localctx).binName = bin();
				setState(180); match(T__4);
				setState(181);
				((CreateContext)_localctx).iType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==NUMERIC) ) {
					((CreateContext)_localctx).iType = (Token)_errHandler.recoverInline(this);
				}
				consume();
				definitions.add(VariableDefinition.INDEX_TASK);
				}
				break;
			case USER:
				{
				setState(184); match(USER);
				setState(185); user();
				setState(186); match(PASSWORD);
				setState(187); password();
				setState(197);
				switch (_input.LA(1)) {
				case ROLE:
					{
					setState(188); match(ROLE);
					setState(189); role();
					}
					break;
				case ROLES:
					{
					setState(190); match(ROLES);
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__19) | (1L << T__13) | (1L << T__7))) != 0)) {
						{
						{
						setState(191); roles();
						}
						}
						setState(196);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				definitions.add(VariableDefinition.ADMIN_POLICY);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode DROP() { return getToken(AQLParser.DROP, 0); }
		public TerminalNode MODULE() { return getToken(AQLParser.MODULE, 0); }
		public TerminalNode SET() { return getToken(AQLParser.SET, 0); }
		public TerminalNode USER() { return getToken(AQLParser.USER, 0); }
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
			setState(205); match(DROP);
			setState(218);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(206); match(INDEX);
				setState(207); nameSet();
				setState(208); index_name();
				}
				break;
			case MODULE:
				{
				setState(210); match(MODULE);
				setState(211); moduleName();
				}
				break;
			case SET:
				{
				setState(212); match(SET);
				setState(213); nameSet();
				}
				break;
			case USER:
				{
				setState(214); match(USER);
				setState(215); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
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

	public static class RepairContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public TerminalNode ON() { return getToken(AQLParser.ON, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode REPAIR() { return getToken(AQLParser.REPAIR, 0); }
		public RepairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRepair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRepair(this);
		}
	}

	public final RepairContext repair() throws RecognitionException {
		RepairContext _localctx = new RepairContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_repair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(REPAIR);
			setState(221); match(INDEX);
			setState(222); index_name();
			setState(223); match(ON);
			setState(224); nameSet();
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

	public static class GrantContext extends ParserRuleContext {
		public TerminalNode ROLES() { return getToken(AQLParser.ROLES, 0); }
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode TO() { return getToken(AQLParser.TO, 0); }
		public TerminalNode ROLE() { return getToken(AQLParser.ROLE, 0); }
		public TerminalNode GRANT() { return getToken(AQLParser.GRANT, 0); }
		public GrantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterGrant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitGrant(this);
		}
	}

	public final GrantContext grant() throws RecognitionException {
		GrantContext _localctx = new GrantContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_grant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(GRANT);
			setState(231);
			switch (_input.LA(1)) {
			case ROLES:
				{
				setState(227); match(ROLES);
				setState(228); roles();
				}
				break;
			case ROLE:
				{
				setState(229); match(ROLE);
				setState(230); role();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(233); match(TO);
			setState(234); user();
			definitions.add(VariableDefinition.ADMIN_POLICY);
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

	public static class RevokeContext extends ParserRuleContext {
		public TerminalNode ROLES() { return getToken(AQLParser.ROLES, 0); }
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode FROM() { return getToken(AQLParser.FROM, 0); }
		public TerminalNode REVOKE() { return getToken(AQLParser.REVOKE, 0); }
		public TerminalNode ROLE() { return getToken(AQLParser.ROLE, 0); }
		public RevokeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_revoke; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRevoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRevoke(this);
		}
	}

	public final RevokeContext revoke() throws RecognitionException {
		RevokeContext _localctx = new RevokeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_revoke);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(REVOKE);
			setState(242);
			switch (_input.LA(1)) {
			case ROLES:
				{
				setState(238); match(ROLES);
				setState(239); roles();
				}
				break;
			case ROLE:
				{
				setState(240); match(ROLE);
				setState(241); role();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(244); match(FROM);
			setState(245); user();
			definitions.add(VariableDefinition.ADMIN_POLICY);
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

	public static class UserContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public UserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_user; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterUser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitUser(this);
		}
	}

	public final UserContext user() throws RecognitionException {
		UserContext _localctx = new UserContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_user);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248); match(IDENTIFIER);
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

	public static class PasswordContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
		public PasswordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_password; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPassword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPassword(this);
		}
	}

	public final PasswordContext password() throws RecognitionException {
		PasswordContext _localctx = new PasswordContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_password);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250); match(IDENTIFIER);
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

	public static class RolesContext extends ParserRuleContext {
		public List<RoleContext> role() {
			return getRuleContexts(RoleContext.class);
		}
		public RoleContext role(int i) {
			return getRuleContext(RoleContext.class,i);
		}
		public RolesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roles; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRoles(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRoles(this);
		}
	}

	public final RolesContext roles() throws RecognitionException {
		RolesContext _localctx = new RolesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_roles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); role();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(253); match(T__2);
				setState(254); role();
				}
				}
				setState(259);
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

	public static class RoleContext extends ParserRuleContext {
		public RoleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRole(this);
		}
	}

	public final RoleContext role() throws RecognitionException {
		RoleContext _localctx = new RoleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_role);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__19) | (1L << T__13) | (1L << T__7))) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_remove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(REMOVE);
			setState(263); match(MODULE);
			setState(264); moduleName();
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
		enterRule(_localctx, 30, RULE_operate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(OPERATE);
			setState(267); operateFunction();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(268); match(T__2);
				setState(269); operateFunction();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(275); match(ON);
			setState(276); nameSet();
			setState(277); match(WHERE);
			setState(278); primaryKeyPredicate();
			setState(281);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(279); match(AND);
				setState(280); generationPredicate();
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
		enterRule(_localctx, 32, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(INSERT);
			setState(286); match(INTO);
			setState(287); nameSet();
			setState(288); match(T__6);
			setState(289); match(PK);
			{
			setState(290); match(T__2);
			setState(291); binNameList();
			}
			setState(293); match(T__4);
			setState(294); match(VALUES);
			setState(295); match(T__6);
			setState(296); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
			{
			setState(297); match(T__2);
			setState(298); valueList();
			}
			setState(300); match(T__4);

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
		public UpdateListContext updateList() {
			return getRuleContext(UpdateListContext.class,0);
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
		enterRule(_localctx, 34, RULE_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); match(UPDATE);
			setState(304); nameSet();
			setState(305); match(SET);
			setState(306); updateList();
			setState(307); match(WHERE);
			setState(308); primaryKeyPredicate();
			setState(311);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(309); match(AND);
				setState(310); generationPredicate();
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

	public static class UpdateListContext extends ParserRuleContext {
		public TtlValueContext ttlValue() {
			return getRuleContext(TtlValueContext.class,0);
		}
		public List<BinValueContext> binValue() {
			return getRuleContexts(BinValueContext.class);
		}
		public BinValueContext binValue(int i) {
			return getRuleContext(BinValueContext.class,i);
		}
		public UpdateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterUpdateList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitUpdateList(this);
		}
	}

	public final UpdateListContext updateList() throws RecognitionException {
		UpdateListContext _localctx = new UpdateListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_updateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			switch (_input.LA(1)) {
			case TTL:
				{
				setState(315); ttlValue();
				}
				break;
			case IDENTIFIER:
				{
				setState(316); binValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(319); match(T__2);
				setState(320); binValue();
				}
				}
				setState(325);
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
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public TerminalNode FROM() { return getToken(AQLParser.FROM, 0); }
		public GenerationPredicateContext generationPredicate() {
			return getRuleContext(GenerationPredicateContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_delete);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); match(DELETE);
			setState(327); match(FROM);
			setState(328); nameSet();
			setState(329); match(WHERE);
			setState(330); primaryKeyPredicate();
			setState(333);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(331); match(AND);
				setState(332); generationPredicate();
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

	public static class SelectContext extends ParserRuleContext {
		public CollectionTypeContext collectionType() {
			return getRuleContext(CollectionTypeContext.class,0);
		}
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
		public TerminalNode IN() { return getToken(AQLParser.IN, 0); }
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
		enterRule(_localctx, 40, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); match(SELECT);
			setState(340);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(338); match(STAR);
				}
				break;
			case TTL:
			case IDENTIFIER:
				{
				setState(339); binNameList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(344);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(342); match(IN);
				setState(343); collectionType();
				}
			}

			setState(346); match(FROM);
			setState(347); nameSet();
			setState(349);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(348); where();
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

	public static class CollectionTypeContext extends ParserRuleContext {
		public TerminalNode MAPVALUES() { return getToken(AQLParser.MAPVALUES, 0); }
		public TerminalNode LIST() { return getToken(AQLParser.LIST, 0); }
		public TerminalNode MAPKEYS() { return getToken(AQLParser.MAPKEYS, 0); }
		public CollectionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterCollectionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitCollectionType(this);
		}
	}

	public final CollectionTypeContext collectionType() throws RecognitionException {
		CollectionTypeContext _localctx = new CollectionTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_collectionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LIST - 66)) | (1L << (MAPKEYS - 66)) | (1L << (MAPVALUES - 66)))) != 0)) ) {
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
		enterRule(_localctx, 44, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355); match(WHERE);
			setState(356); predicate();
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
		public TerminalNode PREPEND() { return getToken(AQLParser.PREPEND, 0); }
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public TerminalNode ADD() { return getToken(AQLParser.ADD, 0); }
		public TerminalNode PUT() { return getToken(AQLParser.PUT, 0); }
		public TerminalNode TOUCH() { return getToken(AQLParser.TOUCH, 0); }
		public TerminalNode APPEND() { return getToken(AQLParser.APPEND, 0); }
		public TerminalNode GET() { return getToken(AQLParser.GET, 0); }
		public TerminalNode HEADER() { return getToken(AQLParser.HEADER, 0); }
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
		enterRule(_localctx, 46, RULE_operateFunction);
		int _la;
		try {
			setState(395);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(358); match(ADD);
				setState(359); match(T__6);
				setState(360); bin();
				setState(361); match(T__2);
				setState(362); value();
				setState(363); match(T__4);
				}
				break;
			case PUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(365); match(PUT);
				setState(366); match(T__6);
				setState(367); bin();
				setState(368); match(T__2);
				setState(369); value();
				setState(370); match(T__4);
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 3);
				{
				setState(372); match(APPEND);
				setState(373); match(T__6);
				setState(374); bin();
				setState(375); match(T__2);
				setState(376); value();
				setState(377); match(T__4);
				}
				break;
			case PREPEND:
				enterOuterAlt(_localctx, 4);
				{
				setState(379); match(PREPEND);
				setState(380); match(T__6);
				setState(381); bin();
				setState(382); match(T__2);
				setState(383); value();
				setState(384); match(T__4);
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 5);
				{
				setState(386); match(GET);
				setState(391);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(387); match(T__6);
					setState(388); bin();
					setState(389); match(T__4);
					}
				}

				}
				break;
			case TOUCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(393); match(TOUCH);
				}
				break;
			case HEADER:
				enterOuterAlt(_localctx, 7);
				{
				setState(394); match(HEADER);
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
		enterRule(_localctx, 48, RULE_nameSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); ((NameSetContext)_localctx).namespace_name = namespace_name();
			((NameSetContext)_localctx).namespaceName =  (((NameSetContext)_localctx).namespace_name!=null?_input.getText(((NameSetContext)_localctx).namespace_name.start,((NameSetContext)_localctx).namespace_name.stop):null);
			setState(403);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(399); match(T__0);
				setState(400); ((NameSetContext)_localctx).set_name = set_name();
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
		enterRule(_localctx, 50, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405); match(REGISTER);
			setState(406); match(MODULE);
			setState(407); ((RegisterContext)_localctx).filepath = filePath();

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
		enterRule(_localctx, 52, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); match(EXECUTE);
			setState(411); moduleFunction();
			setState(412); match(T__6);
			setState(414);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL || _la==INTLITERAL) {
				{
				setState(413); valueList();
				}
			}

			setState(416); match(T__4);
			setState(417); match(ON);
			setState(418); nameSet();
			setState(420);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(419); where();
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
		enterRule(_localctx, 54, RULE_aggregate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); match(AGGREGATE);
			setState(425); moduleFunction();
			setState(431);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(426); match(T__6);
				setState(428);
				_la = _input.LA(1);
				if (_la==STRINGLITERAL || _la==INTLITERAL) {
					{
					setState(427); valueList();
					}
				}

				setState(430); match(T__4);
				}
			}

			setState(433); match(ON);
			setState(434); nameSet();
			setState(436);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(435); where();
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
		public TerminalNode LLIST() { return getToken(AQLParser.LLIST, 0); }
		public TerminalNode SCAN() { return getToken(AQLParser.SCAN, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(AQLParser.IDENTIFIER, i);
		}
		public TerminalNode ADD() { return getToken(AQLParser.ADD, 0); }
		public TerminalNode LMAP() { return getToken(AQLParser.LMAP, 0); }
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
		enterRule(_localctx, 56, RULE_moduleFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			((ModuleFunctionContext)_localctx).packageName = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (LLIST - 95)) | (1L << (LMAP - 95)) | (1L << (IDENTIFIER - 95)))) != 0)) ) {
				((ModuleFunctionContext)_localctx).packageName = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(441); match(T__0);
			setState(442);
			((ModuleFunctionContext)_localctx).functionName = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__15) | (1L << T__14) | (1L << T__10) | (1L << T__5) | (1L << GET) | (1L << SCAN))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (REMOVE - 71)) | (1L << (ADD - 71)) | (1L << (PUT - 71)) | (1L << (IDENTIFIER - 71)))) != 0)) ) {
				((ModuleFunctionContext)_localctx).functionName = (Token)_errHandler.recoverInline(this);
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

	public static class BinNameListContext extends ParserRuleContext {
		public TerminalNode TTL() { return getToken(AQLParser.TTL, 0); }
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
		enterRule(_localctx, 58, RULE_binNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			switch (_input.LA(1)) {
			case TTL:
				{
				setState(444); match(TTL);
				}
				break;
			case IDENTIFIER:
				{
				setState(445); bin();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(448); match(T__2);
				setState(449); bin();
				}
				}
				setState(454);
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
		enterRule(_localctx, 60, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455); value();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(456); match(T__2);
				setState(457); value();
				}
				}
				setState(462);
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
		enterRule(_localctx, 62, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			switch (_input.LA(1)) {
			case PK:
				{
				setState(463); primaryKeyPredicate();
				}
				break;
			case IDENTIFIER:
				{
				setState(464); filterPredicate();
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
		enterRule(_localctx, 64, RULE_primaryKeyPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); match(PK);
			setState(468); match(EQ);
			setState(469); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
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
		enterRule(_localctx, 66, RULE_generationPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); match(T__3);
			setState(472); match(EQ);
			setState(473); match(INTLITERAL);
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
		enterRule(_localctx, 68, RULE_filterPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(475); equalityFilter();
				}
				break;

			case 2:
				{
				setState(476); rangeFilter();
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
		enterRule(_localctx, 70, RULE_equalityFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); binValue();
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

	public static class TtlValueContext extends ParserRuleContext {
		public TerminalNode TTL() { return getToken(AQLParser.TTL, 0); }
		public TerminalNode EQ() { return getToken(AQLParser.EQ, 0); }
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class,0);
		}
		public TtlValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ttlValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterTtlValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitTtlValue(this);
		}
	}

	public final TtlValueContext ttlValue() throws RecognitionException {
		TtlValueContext _localctx = new TtlValueContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_ttlValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483); match(TTL);
			setState(484); match(EQ);
			setState(485); integerValue();
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
		enterRule(_localctx, 74, RULE_binValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487); bin();
			setState(488); match(EQ);
			setState(489); value();
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
		enterRule(_localctx, 76, RULE_rangeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491); bin();
			setState(492); match(BETWEEN);
			setState(493); ((RangeFilterContext)_localctx).low = integerValue();
			setState(494); match(AND);
			setState(495); ((RangeFilterContext)_localctx).high = integerValue();
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
		public TerminalNode USERS() { return getToken(AQLParser.USERS, 0); }
		public TerminalNode SETS() { return getToken(AQLParser.SETS, 0); }
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode SCANS() { return getToken(AQLParser.SCANS, 0); }
		public TerminalNode MODULES() { return getToken(AQLParser.MODULES, 0); }
		public TerminalNode BINS() { return getToken(AQLParser.BINS, 0); }
		public TerminalNode USER() { return getToken(AQLParser.USER, 0); }
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
		enterRule(_localctx, 78, RULE_show);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497); match(SHOW);
			setState(514);
			switch (_input.LA(1)) {
			case INDEXES:
				{
				setState(498); match(INDEXES);
				setState(500);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(499); nameSet();
					}
				}

				}
				break;
			case SCANS:
				{
				setState(502); match(SCANS);
				}
				break;
			case NAMESPACES:
				{
				setState(503); match(NAMESPACES);
				}
				break;
			case SETS:
				{
				setState(504); match(SETS);
				}
				break;
			case BINS:
				{
				setState(505); match(BINS);
				}
				break;
			case QUERIES:
				{
				setState(506); match(QUERIES);
				}
				break;
			case MODULES:
				{
				setState(507); match(MODULES);
				}
				break;
			case USER:
				{
				setState(508); match(USER);
				setState(509); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
				}
				break;
			case USERS:
				{
				setState(512); match(USERS);
				definitions.add(VariableDefinition.ADMIN_POLICY);
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
		enterRule(_localctx, 80, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518); match(DESC);
			setState(525);
			switch (_input.LA(1)) {
			case MODULE:
				{
				setState(519); match(MODULE);
				setState(520); moduleName();
				}
				break;
			case INDEX:
				{
				setState(521); match(INDEX);
				setState(522); namespace_name();
				setState(523); index_name();
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
		enterRule(_localctx, 82, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); match(STAT);
			setState(536);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(530); match(INDEX);
				setState(531); namespace_name();
				setState(532); index_name();
				}
				break;
			case QUERY:
				{
				setState(534); match(QUERY);
				}
				break;
			case SYSTEM:
				{
				setState(535); match(SYSTEM);
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
		public TerminalNode TTL() { return getToken(AQLParser.TTL, 0); }
		public TerminalNode ECHO() { return getToken(AQLParser.ECHO, 0); }
		public ViewTypeContext viewType() {
			return getRuleContext(ViewTypeContext.class,0);
		}
		public TerminalNode FAIL_ON_CLUSTER_CHANGE() { return getToken(AQLParser.FAIL_ON_CLUSTER_CHANGE, 0); }
		public PasswordContext password() {
			return getRuleContext(PasswordContext.class,0);
		}
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode LUA_USER_PATH() { return getToken(AQLParser.LUA_USER_PATH, 0); }
		public TerminalNode FOR() { return getToken(AQLParser.FOR, 0); }
		public TerminalNode PASSWORD() { return getToken(AQLParser.PASSWORD, 0); }
		public TerminalNode INTLITERAL() { return getToken(AQLParser.INTLITERAL, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(AQLParser.STRINGLITERAL, 0); }
		public TerminalNode OUTPUT() { return getToken(AQLParser.OUTPUT, 0); }
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
		enterRule(_localctx, 84, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540); match(SET);
			setState(561);
			switch (_input.LA(1)) {
			case TIMEOUT:
				{
				setState(541); match(TIMEOUT);
				setState(542); ((SetContext)_localctx).timeOut = match(INTLITERAL);
				definitions.add(VariableDefinition.READ_POLICY);definitions.add(VariableDefinition.WRITE_POLICY);
				}
				break;
			case VERBOSE:
				{
				setState(544); match(VERBOSE);
				setState(545); ((SetContext)_localctx).verboseOn = booleanLiteral();
				}
				break;
			case ECHO:
				{
				setState(546); match(ECHO);
				setState(547); ((SetContext)_localctx).echoOn = booleanLiteral();
				}
				break;
			case TTL:
				{
				setState(548); match(TTL);
				setState(549); ((SetContext)_localctx).ttl = match(INTLITERAL);
				}
				break;
			case OUTPUT:
				{
				setState(550); match(OUTPUT);
				setState(551); viewType();
				}
				break;
			case LUA_USER_PATH:
				{
				setState(552); match(LUA_USER_PATH);
				setState(553); ((SetContext)_localctx).luaUserPath = match(STRINGLITERAL);
				}
				break;
			case FAIL_ON_CLUSTER_CHANGE:
				{
				setState(554); match(FAIL_ON_CLUSTER_CHANGE);
				}
				break;
			case PASSWORD:
				{
				setState(555); match(PASSWORD);
				setState(556); password();
				setState(557); match(FOR);
				setState(558); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
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
		public TerminalNode FAIL_ON_CLUSTER_CHANGE() { return getToken(AQLParser.FAIL_ON_CLUSTER_CHANGE, 0); }
		public TerminalNode LUA_USER_PATH() { return getToken(AQLParser.LUA_USER_PATH, 0); }
		public TerminalNode OUTPUT() { return getToken(AQLParser.OUTPUT, 0); }
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
		enterRule(_localctx, 86, RULE_get);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563); match(GET);
			setState(564);
			_la = _input.LA(1);
			if ( !(_la==OUTPUT || _la==TIMEOUT || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (VERBOSE - 83)) | (1L << (ECHO - 83)) | (1L << (TTL - 83)) | (1L << (LUA_USER_PATH - 83)) | (1L << (FAIL_ON_CLUSTER_CHANGE - 83)))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_viewType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__11) | (1L << T__9) | (1L << T__1))) != 0)) ) {
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
		enterRule(_localctx, 90, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568); match(RUN);
			setState(569); match(STRINGLITERAL);
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
		enterRule(_localctx, 92, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571); match(PRINT);
			setState(573);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL) {
				{
				setState(572); match(STRINGLITERAL);
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
		enterRule(_localctx, 94, RULE_kill);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575); match(KILL);
			setState(576);
			_la = _input.LA(1);
			if ( !(_la==QUERY || _la==SCAN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(577); match(INTLITERAL);
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
		enterRule(_localctx, 96, RULE_kill_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579); match(KILL_QUERY);
			setState(580); match(INTLITERAL);
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
		enterRule(_localctx, 98, RULE_kill_scan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582); match(KILL_SCAN);
			setState(583); match(INTLITERAL);
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
		enterRule(_localctx, 100, RULE_quit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << QUIT) | (1L << EXIT))) != 0)) ) {
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
		enterRule(_localctx, 102, RULE_help);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587); match(T__8);
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
		enterRule(_localctx, 104, RULE_primaryKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
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
		enterRule(_localctx, 106, RULE_package_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591); match(IDENTIFIER);
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
		enterRule(_localctx, 108, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593); match(IDENTIFIER);
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
		enterRule(_localctx, 110, RULE_namespace_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595); match(IDENTIFIER);
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
		public Token setName;
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
		enterRule(_localctx, 112, RULE_set_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597); ((Set_nameContext)_localctx).setName = match(IDENTIFIER);

					if ((((Set_nameContext)_localctx).setName!=null?((Set_nameContext)_localctx).setName.getText():null).length() > 63) notifyErrorListeners("Set name exceeds 63 characters");
				
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
		public Token binName;
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
		enterRule(_localctx, 114, RULE_bin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600); ((BinContext)_localctx).binName = match(IDENTIFIER);

					if ((((BinContext)_localctx).binName!=null?((BinContext)_localctx).binName.getText():null).length() > 14) notifyErrorListeners("Bin name exceeds 14 characters");
				
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
		enterRule(_localctx, 116, RULE_value);
		try {
			setState(605);
			switch (_input.LA(1)) {
			case INTLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(603); integerValue();
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(604); textValue();
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
		enterRule(_localctx, 118, RULE_textValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607); match(STRINGLITERAL);
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
		enterRule(_localctx, 120, RULE_integerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609); match(INTLITERAL);
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
		enterRule(_localctx, 122, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
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
		enterRule(_localctx, 124, RULE_moduleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613); match(IDENTIFIER);
			setState(614); match(T__0);
			setState(615);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__11) ) {
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
		enterRule(_localctx, 126, RULE_filePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617); match(STRINGLITERAL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3w\u026e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\3\7\3\u0087\n\3\f\3\16\3\u008a"+
		"\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00a6\n\4\3\5\3\5\3\5\3\5"+
		"\5\5\u00ac\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00c3\n\7\f\7\16\7\u00c6\13\7\5\7\u00c8"+
		"\n\7\3\7\3\7\5\7\u00cc\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u00dd\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u00ea\n\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00f5"+
		"\n\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u0102\n"+
		"\16\f\16\16\16\u0105\13\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\7\21\u0111\n\21\f\21\16\21\u0114\13\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u011c\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u013a\n\23\3\23\3\23\3\24\3\24\5\24\u0140\n"+
		"\24\3\24\3\24\7\24\u0144\n\24\f\24\16\24\u0147\13\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u0150\n\25\3\25\3\25\3\26\3\26\3\26\5\26\u0157"+
		"\n\26\3\26\3\26\5\26\u015b\n\26\3\26\3\26\3\26\5\26\u0160\n\26\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u018a\n\31"+
		"\3\31\3\31\5\31\u018e\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0196\n"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u01a1\n\34\3\34"+
		"\3\34\3\34\3\34\5\34\u01a7\n\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u01af"+
		"\n\35\3\35\5\35\u01b2\n\35\3\35\3\35\3\35\5\35\u01b7\n\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\5\37\u01c1\n\37\3\37\3\37\7\37\u01c5\n\37"+
		"\f\37\16\37\u01c8\13\37\3 \3 \3 \7 \u01cd\n \f \16 \u01d0\13 \3!\3!\5"+
		"!\u01d4\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\5$\u01e0\n$\3$\3$\3%\3%\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\5)\u01f7\n)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0205\n)\3)\3)\3*\3*\3*\3*\3*\3*\3"+
		"*\5*\u0210\n*\3*\3*\3+\3+\3+\3+\3+\3+\3+\5+\u021b\n+\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0234\n,\3-\3"+
		"-\3-\3.\3.\3/\3/\3/\3\60\3\60\5\60\u0240\n\60\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3:\3;\3;\3;\3<\3<\5<\u0260\n<\3=\3=\3>\3>\3?\3?\3@\3@\3"+
		"@\3@\3A\3A\3A\2\2B\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\2\16\3\2@A\5\2\3"+
		"\4\n\n\20\20\3\2DF\5\2aaddpp\13\2\6\6\b\t\r\r\22\22))88II[\\pp\7\2--9"+
		"9UWYYmm\6\2\7\7\f\f\16\16\26\26\3\2\678\4\2\5\5:;\4\2qqss\3\2\30\31\3"+
		"\2\13\f\u0281\2\u0082\3\2\2\2\4\u0088\3\2\2\2\6\u00a5\3\2\2\2\b\u00a7"+
		"\3\2\2\2\n\u00ad\3\2\2\2\f\u00af\3\2\2\2\16\u00cf\3\2\2\2\20\u00de\3\2"+
		"\2\2\22\u00e4\3\2\2\2\24\u00ef\3\2\2\2\26\u00fa\3\2\2\2\30\u00fc\3\2\2"+
		"\2\32\u00fe\3\2\2\2\34\u0106\3\2\2\2\36\u0108\3\2\2\2 \u010c\3\2\2\2\""+
		"\u011f\3\2\2\2$\u0131\3\2\2\2&\u013f\3\2\2\2(\u0148\3\2\2\2*\u0153\3\2"+
		"\2\2,\u0163\3\2\2\2.\u0165\3\2\2\2\60\u018d\3\2\2\2\62\u018f\3\2\2\2\64"+
		"\u0197\3\2\2\2\66\u019c\3\2\2\28\u01aa\3\2\2\2:\u01ba\3\2\2\2<\u01c0\3"+
		"\2\2\2>\u01c9\3\2\2\2@\u01d3\3\2\2\2B\u01d5\3\2\2\2D\u01d9\3\2\2\2F\u01df"+
		"\3\2\2\2H\u01e3\3\2\2\2J\u01e5\3\2\2\2L\u01e9\3\2\2\2N\u01ed\3\2\2\2P"+
		"\u01f3\3\2\2\2R\u0208\3\2\2\2T\u0213\3\2\2\2V\u021e\3\2\2\2X\u0235\3\2"+
		"\2\2Z\u0238\3\2\2\2\\\u023a\3\2\2\2^\u023d\3\2\2\2`\u0241\3\2\2\2b\u0245"+
		"\3\2\2\2d\u0248\3\2\2\2f\u024b\3\2\2\2h\u024d\3\2\2\2j\u024f\3\2\2\2l"+
		"\u0251\3\2\2\2n\u0253\3\2\2\2p\u0255\3\2\2\2r\u0257\3\2\2\2t\u025a\3\2"+
		"\2\2v\u025f\3\2\2\2x\u0261\3\2\2\2z\u0263\3\2\2\2|\u0265\3\2\2\2~\u0267"+
		"\3\2\2\2\u0080\u026b\3\2\2\2\u0082\u0083\5\4\3\2\u0083\u0084\7\2\2\3\u0084"+
		"\3\3\2\2\2\u0085\u0087\5\6\4\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2"+
		"\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\5\3\2\2\2\u008a\u0088\3"+
		"\2\2\2\u008b\u00a6\5\b\5\2\u008c\u00a6\5\n\6\2\u008d\u00a6\5\f\7\2\u008e"+
		"\u00a6\5\16\b\2\u008f\u00a6\5\20\t\2\u0090\u00a6\5\22\n\2\u0091\u00a6"+
		"\5\24\13\2\u0092\u00a6\5\36\20\2\u0093\u00a6\5\"\22\2\u0094\u00a6\5$\23"+
		"\2\u0095\u00a6\5(\25\2\u0096\u00a6\5*\26\2\u0097\u00a6\5\64\33\2\u0098"+
		"\u00a6\5\66\34\2\u0099\u00a6\58\35\2\u009a\u00a6\5 \21\2\u009b\u00a6\5"+
		"P)\2\u009c\u00a6\5R*\2\u009d\u00a6\5T+\2\u009e\u00a6\5V,\2\u009f\u00a6"+
		"\5X-\2\u00a0\u00a6\5\\/\2\u00a1\u00a6\5`\61\2\u00a2\u00a6\5f\64\2\u00a3"+
		"\u00a6\5h\65\2\u00a4\u00a6\5^\60\2\u00a5\u008b\3\2\2\2\u00a5\u008c\3\2"+
		"\2\2\u00a5\u008d\3\2\2\2\u00a5\u008e\3\2\2\2\u00a5\u008f\3\2\2\2\u00a5"+
		"\u0090\3\2\2\2\u00a5\u0091\3\2\2\2\u00a5\u0092\3\2\2\2\u00a5\u0093\3\2"+
		"\2\2\u00a5\u0094\3\2\2\2\u00a5\u0095\3\2\2\2\u00a5\u0096\3\2\2\2\u00a5"+
		"\u0097\3\2\2\2\u00a5\u0098\3\2\2\2\u00a5\u0099\3\2\2\2\u00a5\u009a\3\2"+
		"\2\2\u00a5\u009b\3\2\2\2\u00a5\u009c\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5"+
		"\u009e\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2"+
		"\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\7\3\2\2\2\u00a7\u00a8\7\32\2\2\u00a8\u00a9\7q\2\2\u00a9\u00ab\7s\2\2"+
		"\u00aa\u00ac\7s\2\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\t\3"+
		"\2\2\2\u00ad\u00ae\7\33\2\2\u00ae\13\3\2\2\2\u00af\u00cb\7 \2\2\u00b0"+
		"\u00b1\7!\2\2\u00b1\u00b2\5n8\2\u00b2\u00b3\7+\2\2\u00b3\u00b4\5\62\32"+
		"\2\u00b4\u00b5\7\21\2\2\u00b5\u00b6\5t;\2\u00b6\u00b7\7\23\2\2\u00b7\u00b8"+
		"\t\2\2\2\u00b8\u00b9\b\7\1\2\u00b9\u00cc\3\2\2\2\u00ba\u00bb\7e\2\2\u00bb"+
		"\u00bc\5\26\f\2\u00bc\u00bd\7g\2\2\u00bd\u00c7\5\30\r\2\u00be\u00bf\7"+
		"h\2\2\u00bf\u00c8\5\34\17\2\u00c0\u00c4\7i\2\2\u00c1\u00c3\5\32\16\2\u00c2"+
		"\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00be\3\2\2\2\u00c7"+
		"\u00c0\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\7\1\2\u00ca\u00cc\3\2"+
		"\2\2\u00cb\u00b0\3\2\2\2\u00cb\u00ba\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\b\7\1\2\u00ce\r\3\2\2\2\u00cf\u00dc\7%\2\2\u00d0\u00d1\7!\2\2\u00d1"+
		"\u00d2\5\62\32\2\u00d2\u00d3\5n8\2\u00d3\u00dd\3\2\2\2\u00d4\u00d5\7*"+
		"\2\2\u00d5\u00dd\5~@\2\u00d6\u00d7\7(\2\2\u00d7\u00dd\5\62\32\2\u00d8"+
		"\u00d9\7e\2\2\u00d9\u00da\5\26\f\2\u00da\u00db\b\b\1\2\u00db\u00dd\3\2"+
		"\2\2\u00dc\u00d0\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc"+
		"\u00d8\3\2\2\2\u00dd\17\3\2\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7!\2\2"+
		"\u00e0\u00e1\5n8\2\u00e1\u00e2\7+\2\2\u00e2\u00e3\5\62\32\2\u00e3\21\3"+
		"\2\2\2\u00e4\u00e9\7j\2\2\u00e5\u00e6\7i\2\2\u00e6\u00ea\5\32\16\2\u00e7"+
		"\u00e8\7h\2\2\u00e8\u00ea\5\34\17\2\u00e9\u00e5\3\2\2\2\u00e9\u00e7\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\7l\2\2\u00ec\u00ed\5\26\f\2\u00ed"+
		"\u00ee\b\n\1\2\u00ee\23\3\2\2\2\u00ef\u00f4\7k\2\2\u00f0\u00f1\7i\2\2"+
		"\u00f1\u00f5\5\32\16\2\u00f2\u00f3\7h\2\2\u00f3\u00f5\5\34\17\2\u00f4"+
		"\u00f0\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\61"+
		"\2\2\u00f7\u00f8\5\26\f\2\u00f8\u00f9\b\13\1\2\u00f9\25\3\2\2\2\u00fa"+
		"\u00fb\7p\2\2\u00fb\27\3\2\2\2\u00fc\u00fd\7p\2\2\u00fd\31\3\2\2\2\u00fe"+
		"\u0103\5\34\17\2\u00ff\u0100\7\25\2\2\u0100\u0102\5\34\17\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\33\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\t\3\2\2\u0107\35\3\2\2\2\u0108"+
		"\u0109\7I\2\2\u0109\u010a\7*\2\2\u010a\u010b\5~@\2\u010b\37\3\2\2\2\u010c"+
		"\u010d\7,\2\2\u010d\u0112\5\60\31\2\u010e\u010f\7\25\2\2\u010f\u0111\5"+
		"\60\31\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\7+"+
		"\2\2\u0116\u0117\5\62\32\2\u0117\u0118\7#\2\2\u0118\u011b\5B\"\2\u0119"+
		"\u011a\7\63\2\2\u011a\u011c\5D#\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\b\21\1\2\u011e!\3\2\2\2\u011f\u0120"+
		"\7\35\2\2\u0120\u0121\7/\2\2\u0121\u0122\5\62\32\2\u0122\u0123\7\21\2"+
		"\2\u0123\u0124\7?\2\2\u0124\u0125\7\25\2\2\u0125\u0126\5<\37\2\u0126\u0127"+
		"\3\2\2\2\u0127\u0128\7\23\2\2\u0128\u0129\7\'\2\2\u0129\u012a\7\21\2\2"+
		"\u012a\u012b\5j\66\2\u012b\u012c\7\25\2\2\u012c\u012d\5> \2\u012d\u012e"+
		"\3\2\2\2\u012e\u012f\7\23\2\2\u012f\u0130\b\22\1\2\u0130#\3\2\2\2\u0131"+
		"\u0132\7T\2\2\u0132\u0133\5\62\32\2\u0133\u0134\7(\2\2\u0134\u0135\5&"+
		"\24\2\u0135\u0136\7#\2\2\u0136\u0139\5B\"\2\u0137\u0138\7\63\2\2\u0138"+
		"\u013a\5D#\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2"+
		"\2\u013b\u013c\b\23\1\2\u013c%\3\2\2\2\u013d\u0140\5J&\2\u013e\u0140\5"+
		"L\'\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140\u0145\3\2\2\2\u0141"+
		"\u0142\7\25\2\2\u0142\u0144\5L\'\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2"+
		"\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\'\3\2\2\2\u0147\u0145"+
		"\3\2\2\2\u0148\u0149\7\37\2\2\u0149\u014a\7\61\2\2\u014a\u014b\5\62\32"+
		"\2\u014b\u014c\7#\2\2\u014c\u014f\5B\"\2\u014d\u014e\7\63\2\2\u014e\u0150"+
		"\5D#\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151"+
		"\u0152\b\25\1\2\u0152)\3\2\2\2\u0153\u0156\7\36\2\2\u0154\u0157\7G\2\2"+
		"\u0155\u0157\5<\37\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\u015a"+
		"\3\2\2\2\u0158\u0159\7C\2\2\u0159\u015b\5,\27\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\7\61\2\2\u015d\u015f\5"+
		"\62\32\2\u015e\u0160\5.\30\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u0162\b\26\1\2\u0162+\3\2\2\2\u0163\u0164\t\4\2\2"+
		"\u0164-\3\2\2\2\u0165\u0166\7#\2\2\u0166\u0167\5@!\2\u0167/\3\2\2\2\u0168"+
		"\u0169\7[\2\2\u0169\u016a\7\21\2\2\u016a\u016b\5t;\2\u016b\u016c\7\25"+
		"\2\2\u016c\u016d\5v<\2\u016d\u016e\7\23\2\2\u016e\u018e\3\2\2\2\u016f"+
		"\u0170\7\\\2\2\u0170\u0171\7\21\2\2\u0171\u0172\5t;\2\u0172\u0173\7\25"+
		"\2\2\u0173\u0174\5v<\2\u0174\u0175\7\23\2\2\u0175\u018e\3\2\2\2\u0176"+
		"\u0177\7]\2\2\u0177\u0178\7\21\2\2\u0178\u0179\5t;\2\u0179\u017a\7\25"+
		"\2\2\u017a\u017b\5v<\2\u017b\u017c\7\23\2\2\u017c\u018e\3\2\2\2\u017d"+
		"\u017e\7^\2\2\u017e\u017f\7\21\2\2\u017f\u0180\5t;\2\u0180\u0181\7\25"+
		"\2\2\u0181\u0182\5v<\2\u0182\u0183\7\23\2\2\u0183\u018e\3\2\2\2\u0184"+
		"\u0189\7)\2\2\u0185\u0186\7\21\2\2\u0186\u0187\5t;\2\u0187\u0188\7\23"+
		"\2\2\u0188\u018a\3\2\2\2\u0189\u0185\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u018e\3\2\2\2\u018b\u018e\7_\2\2\u018c\u018e\7`\2\2\u018d\u0168\3\2\2"+
		"\2\u018d\u016f\3\2\2\2\u018d\u0176\3\2\2\2\u018d\u017d\3\2\2\2\u018d\u0184"+
		"\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018c\3\2\2\2\u018e\61\3\2\2\2\u018f"+
		"\u0190\5p9\2\u0190\u0195\b\32\1\2\u0191\u0192\7\27\2\2\u0192\u0193\5r"+
		":\2\u0193\u0194\b\32\1\2\u0194\u0196\3\2\2\2\u0195\u0191\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\63\3\2\2\2\u0197\u0198\7H\2\2\u0198\u0199\7*\2\2"+
		"\u0199\u019a\5\u0080A\2\u019a\u019b\b\33\1\2\u019b\65\3\2\2\2\u019c\u019d"+
		"\7\"\2\2\u019d\u019e\5:\36\2\u019e\u01a0\7\21\2\2\u019f\u01a1\5> \2\u01a0"+
		"\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\23"+
		"\2\2\u01a3\u01a4\7+\2\2\u01a4\u01a6\5\62\32\2\u01a5\u01a7\5.\30\2\u01a6"+
		"\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\b\34"+
		"\1\2\u01a9\67\3\2\2\2\u01aa\u01ab\7J\2\2\u01ab\u01b1\5:\36\2\u01ac\u01ae"+
		"\7\21\2\2\u01ad\u01af\5> \2\u01ae\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01b2\7\23\2\2\u01b1\u01ac\3\2\2\2\u01b1\u01b2\3"+
		"\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\7+\2\2\u01b4\u01b6\5\62\32\2\u01b5"+
		"\u01b7\5.\30\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\3\2"+
		"\2\2\u01b8\u01b9\b\35\1\2\u01b99\3\2\2\2\u01ba\u01bb\t\5\2\2\u01bb\u01bc"+
		"\7\27\2\2\u01bc\u01bd\t\6\2\2\u01bd;\3\2\2\2\u01be\u01c1\7W\2\2\u01bf"+
		"\u01c1\5t;\2\u01c0\u01be\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c6\3\2\2"+
		"\2\u01c2\u01c3\7\25\2\2\u01c3\u01c5\5t;\2\u01c4\u01c2\3\2\2\2\u01c5\u01c8"+
		"\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7=\3\2\2\2\u01c8"+
		"\u01c6\3\2\2\2\u01c9\u01ce\5v<\2\u01ca\u01cb\7\25\2\2\u01cb\u01cd\5v<"+
		"\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf"+
		"\3\2\2\2\u01cf?\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d4\5B\"\2\u01d2\u01d4"+
		"\5F$\2\u01d3\u01d1\3\2\2\2\u01d3\u01d2\3\2\2\2\u01d4A\3\2\2\2\u01d5\u01d6"+
		"\7?\2\2\u01d6\u01d7\7B\2\2\u01d7\u01d8\5j\66\2\u01d8C\3\2\2\2\u01d9\u01da"+
		"\7\24\2\2\u01da\u01db\7B\2\2\u01db\u01dc\7s\2\2\u01dcE\3\2\2\2\u01dd\u01e0"+
		"\5H%\2\u01de\u01e0\5N(\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1\u01e2\b$\1\2\u01e2G\3\2\2\2\u01e3\u01e4\5L\'\2\u01e4"+
		"I\3\2\2\2\u01e5\u01e6\7W\2\2\u01e6\u01e7\7B\2\2\u01e7\u01e8\5z>\2\u01e8"+
		"K\3\2\2\2\u01e9\u01ea\5t;\2\u01ea\u01eb\7B\2\2\u01eb\u01ec\5v<\2\u01ec"+
		"M\3\2\2\2\u01ed\u01ee\5t;\2\u01ee\u01ef\7\64\2\2\u01ef\u01f0\5z>\2\u01f0"+
		"\u01f1\7\63\2\2\u01f1\u01f2\5z>\2\u01f2O\3\2\2\2\u01f3\u0204\7$\2\2\u01f4"+
		"\u01f6\7&\2\2\u01f5\u01f7\5\62\32\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3"+
		"\2\2\2\u01f7\u0205\3\2\2\2\u01f8\u0205\7O\2\2\u01f9\u0205\7L\2\2\u01fa"+
		"\u0205\7M\2\2\u01fb\u0205\7N\2\2\u01fc\u0205\7P\2\2\u01fd\u0205\7K\2\2"+
		"\u01fe\u01ff\7e\2\2\u01ff\u0200\5\26\f\2\u0200\u0201\b)\1\2\u0201\u0205"+
		"\3\2\2\2\u0202\u0203\7f\2\2\u0203\u0205\b)\1\2\u0204\u01f4\3\2\2\2\u0204"+
		"\u01f8\3\2\2\2\u0204\u01f9\3\2\2\2\u0204\u01fa\3\2\2\2\u0204\u01fb\3\2"+
		"\2\2\u0204\u01fc\3\2\2\2\u0204\u01fd\3\2\2\2\u0204\u01fe\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\b)\1\2\u0207Q\3\2\2\2\u0208"+
		"\u020f\7\34\2\2\u0209\u020a\7*\2\2\u020a\u0210\5~@\2\u020b\u020c\7!\2"+
		"\2\u020c\u020d\5p9\2\u020d\u020e\5n8\2\u020e\u0210\3\2\2\2\u020f\u0209"+
		"\3\2\2\2\u020f\u020b\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0212\b*\1\2\u0212"+
		"S\3\2\2\2\u0213\u021a\7\66\2\2\u0214\u0215\7!\2\2\u0215\u0216\5p9\2\u0216"+
		"\u0217\5n8\2\u0217\u021b\3\2\2\2\u0218\u021b\7\67\2\2\u0219\u021b\7Q\2"+
		"\2\u021a\u0214\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u0219\3\2\2\2\u021b\u021c"+
		"\3\2\2\2\u021c\u021d\b+\1\2\u021dU\3\2\2\2\u021e\u0233\7(\2\2\u021f\u0220"+
		"\79\2\2\u0220\u0221\7s\2\2\u0221\u0234\b,\1\2\u0222\u0223\7U\2\2\u0223"+
		"\u0234\5|?\2\u0224\u0225\7V\2\2\u0225\u0234\5|?\2\u0226\u0227\7W\2\2\u0227"+
		"\u0234\7s\2\2\u0228\u0229\7-\2\2\u0229\u0234\5Z.\2\u022a\u022b\7Y\2\2"+
		"\u022b\u0234\7q\2\2\u022c\u0234\7m\2\2\u022d\u022e\7g\2\2\u022e\u022f"+
		"\5\30\r\2\u022f\u0230\7o\2\2\u0230\u0231\5\26\f\2\u0231\u0232\b,\1\2\u0232"+
		"\u0234\3\2\2\2\u0233\u021f\3\2\2\2\u0233\u0222\3\2\2\2\u0233\u0224\3\2"+
		"\2\2\u0233\u0226\3\2\2\2\u0233\u0228\3\2\2\2\u0233\u022a\3\2\2\2\u0233"+
		"\u022c\3\2\2\2\u0233\u022d\3\2\2\2\u0234W\3\2\2\2\u0235\u0236\7)\2\2\u0236"+
		"\u0237\t\7\2\2\u0237Y\3\2\2\2\u0238\u0239\t\b\2\2\u0239[\3\2\2\2\u023a"+
		"\u023b\7\65\2\2\u023b\u023c\7q\2\2\u023c]\3\2\2\2\u023d\u023f\7S\2\2\u023e"+
		"\u0240\7q\2\2\u023f\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240_\3\2\2\2\u0241"+
		"\u0242\7<\2\2\u0242\u0243\t\t\2\2\u0243\u0244\7s\2\2\u0244a\3\2\2\2\u0245"+
		"\u0246\7=\2\2\u0246\u0247\7s\2\2\u0247c\3\2\2\2\u0248\u0249\7>\2\2\u0249"+
		"\u024a\7s\2\2\u024ae\3\2\2\2\u024b\u024c\t\n\2\2\u024cg\3\2\2\2\u024d"+
		"\u024e\7\17\2\2\u024ei\3\2\2\2\u024f\u0250\t\13\2\2\u0250k\3\2\2\2\u0251"+
		"\u0252\7p\2\2\u0252m\3\2\2\2\u0253\u0254\7p\2\2\u0254o\3\2\2\2\u0255\u0256"+
		"\7p\2\2\u0256q\3\2\2\2\u0257\u0258\7p\2\2\u0258\u0259\b:\1\2\u0259s\3"+
		"\2\2\2\u025a\u025b\7p\2\2\u025b\u025c\b;\1\2\u025cu\3\2\2\2\u025d\u0260"+
		"\5z>\2\u025e\u0260\5x=\2\u025f\u025d\3\2\2\2\u025f\u025e\3\2\2\2\u0260"+
		"w\3\2\2\2\u0261\u0262\7q\2\2\u0262y\3\2\2\2\u0263\u0264\7s\2\2\u0264{"+
		"\3\2\2\2\u0265\u0266\t\f\2\2\u0266}\3\2\2\2\u0267\u0268\7p\2\2\u0268\u0269"+
		"\7\27\2\2\u0269\u026a\t\r\2\2\u026a\177\3\2\2\2\u026b\u026c\7q\2\2\u026c"+
		"\u0081\3\2\2\2)\u0088\u00a5\u00ab\u00c4\u00c7\u00cb\u00dc\u00e9\u00f4"+
		"\u0103\u0112\u011b\u0139\u013f\u0145\u014f\u0156\u015a\u015f\u0189\u018d"+
		"\u0195\u01a0\u01a6\u01ae\u01b1\u01b6\u01c0\u01c6\u01ce\u01d3\u01df\u01f6"+
		"\u0204\u020f\u021a\u0233\u023f\u025f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}