// Generated from AQL.g4 by ANTLR 4.3

package com.aerospike.aql.grammar;
import java.util.Set;
import java.util.HashSet;
import com.aerospike.client.admin.Privilege;
import com.aerospike.client.admin.PrivilegeCode;

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
		T__21=1, T__20=2, T__19=3, T__18=4, T__17=5, T__16=6, T__15=7, T__14=8, 
		T__13=9, T__12=10, T__11=11, T__10=12, T__9=13, T__8=14, T__7=15, T__6=16, 
		T__5=17, T__4=18, T__3=19, T__2=20, T__1=21, T__0=22, TRUE=23, FALSE=24, 
		CONNECT=25, DISCONNECT=26, DESC=27, INSERT=28, SELECT=29, DELETE=30, CREATE=31, 
		INDEX=32, EXECUTE=33, WHERE=34, SHOW=35, DROP=36, INDEXES=37, VALUES=38, 
		SET=39, GET=40, MODULE=41, ON=42, OPERATE=43, OUTPUT=44, PRIVILEGE=45, 
		PRIVILEGES=46, INTO=47, FUNCTION=48, FROM=49, BY=50, AND=51, BETWEEN=52, 
		RUN=53, STAT=54, QUERY=55, SCAN=56, TIMEOUT=57, QUIT=58, EXIT=59, KILL=60, 
		KILL_QUERY=61, KILL_SCAN=62, PK=63, STRING=64, NUMERIC=65, EQ=66, IN=67, 
		LIST=68, MAPKEYS=69, MAPVALUES=70, STAR=71, REGISTER=72, REMOVE=73, AGGREGATE=74, 
		MODULES=75, NAMESPACES=76, SETS=77, BINS=78, SCANS=79, QUERIES=80, SYSTEM=81, 
		ORDER=82, PRINT=83, UPDATE=84, VERBOSE=85, ECHO=86, TTL=87, USE_SMD=88, 
		LUA_USER_PATH=89, LUA_SYSTEM_PATH=90, ADD=91, PUT=92, APPEND=93, PREPEND=94, 
		TOUCH=95, HEADER=96, LLIST=97, LSTACK=98, LSET=99, LMAP=100, USER=101, 
		USERS=102, PASSWORD=103, ROLE=104, ROLES=105, GRANT=106, REVOKE=107, TO=108, 
		FAIL_ON_CLUSTER_CHANGE=109, REPAIR=110, FOR=111, IDENTIFIER=112, STRINGLITERAL=113, 
		FLOATLITERAL=114, INTLITERAL=115, HEXLITERAL=116, NEWLINE=117, WS=118, 
		COMMENT=119;
	public static final String[] tokenNames = {
		"<INVALID>", "'user-admin'", "'read-write'", "'q'", "'size'", "'('", "'get_config'", 
		"'generation'", "','", "'json'", "'.'", "'find'", "'nosql'", "'get_capacity'", 
		"'destroy'", "'sys-admin'", "'so'", "'read-write-udf'", "'lua'", "'table'", 
		"'help'", "'read'", "')'", "'true'", "'false'", "'connect'", "'disconnect'", 
		"'desc'", "'insert'", "'select'", "'delete'", "'create'", "'index'", "'execute'", 
		"'where'", "'show'", "'drop'", "'indexes'", "'values'", "'set'", "'get'", 
		"'module'", "'on'", "'operate'", "'output'", "'privilege'", "'privileges'", 
		"'into'", "'function'", "'from'", "'by'", "'and'", "'between'", "'run'", 
		"'stat'", "'query'", "'scan'", "'timeout'", "'quit'", "'exit'", "'kill'", 
		"'kill_query'", "'kill_scan'", "'pk'", "'string'", "'numeric'", "'='", 
		"'in'", "'list'", "'mapkeys'", "'mapvalues'", "'*'", "'register'", "'remove'", 
		"'aggregate'", "'modules'", "'namespaces'", "'sets'", "'bins'", "'scans'", 
		"'queries'", "'system'", "'order'", "'print'", "'update'", "'verbose'", 
		"'echo'", "'ttl'", "'use_smd'", "'lua_userpath'", "'lua_syspath'", "'add'", 
		"'put'", "'append'", "'prepend'", "'touch'", "'header'", "'llist'", "'lstack'", 
		"'lset'", "'lmap'", "'user'", "'users'", "'password'", "'role'", "'roles'", 
		"'grant'", "'revoke'", "'to'", "'FAIL_ON_CLUSTER_CHANGE'", "'repair'", 
		"'for'", "IDENTIFIER", "STRINGLITERAL", "FLOATLITERAL", "INTLITERAL", 
		"HEXLITERAL", "NEWLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_aql = 0, RULE_statements = 1, RULE_statement = 2, RULE_connect = 3, 
		RULE_disconnect = 4, RULE_create = 5, RULE_drop = 6, RULE_repair = 7, 
		RULE_grant = 8, RULE_revoke = 9, RULE_user = 10, RULE_password = 11, RULE_roles = 12, 
		RULE_role = 13, RULE_privilege = 14, RULE_remove = 15, RULE_operate = 16, 
		RULE_insert = 17, RULE_update = 18, RULE_updateList = 19, RULE_delete = 20, 
		RULE_select = 21, RULE_collectionType = 22, RULE_where = 23, RULE_operateFunction = 24, 
		RULE_nameSet = 25, RULE_register = 26, RULE_execute = 27, RULE_aggregate = 28, 
		RULE_moduleFunction = 29, RULE_binNameList = 30, RULE_valueList = 31, 
		RULE_predicate = 32, RULE_primaryKeyPredicate = 33, RULE_generationPredicate = 34, 
		RULE_filterPredicate = 35, RULE_equalityFilter = 36, RULE_ttlValue = 37, 
		RULE_binValue = 38, RULE_rangeFilter = 39, RULE_show = 40, RULE_desc = 41, 
		RULE_stat = 42, RULE_set = 43, RULE_get = 44, RULE_viewType = 45, RULE_run = 46, 
		RULE_print = 47, RULE_kill = 48, RULE_kill_query = 49, RULE_kill_scan = 50, 
		RULE_quit = 51, RULE_help = 52, RULE_primaryKey = 53, RULE_package_name = 54, 
		RULE_index_name = 55, RULE_namespace_name = 56, RULE_set_name = 57, RULE_bin = 58, 
		RULE_dotPath = 59, RULE_value = 60, RULE_textValue = 61, RULE_integerValue = 62, 
		RULE_booleanLiteral = 63, RULE_moduleName = 64, RULE_filePath = 65;
	public static final String[] ruleNames = {
		"aql", "statements", "statement", "connect", "disconnect", "create", "drop", 
		"repair", "grant", "revoke", "user", "password", "roles", "role", "privilege", 
		"remove", "operate", "insert", "update", "updateList", "delete", "select", 
		"collectionType", "where", "operateFunction", "nameSet", "register", "execute", 
		"aggregate", "moduleFunction", "binNameList", "valueList", "predicate", 
		"primaryKeyPredicate", "generationPredicate", "filterPredicate", "equalityFilter", 
		"ttlValue", "binValue", "rangeFilter", "show", "desc", "stat", "set", 
		"get", "viewType", "run", "print", "kill", "kill_query", "kill_scan", 
		"quit", "help", "primaryKey", "package_name", "index_name", "namespace_name", 
		"set_name", "bin", "dotPath", "value", "textValue", "integerValue", "booleanLiteral", 
		"moduleName", "filePath"
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
			setState(132); statements();
			setState(133); match(EOF);
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
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__2) | (1L << CONNECT) | (1L << DISCONNECT) | (1L << DESC) | (1L << INSERT) | (1L << SELECT) | (1L << DELETE) | (1L << CREATE) | (1L << EXECUTE) | (1L << SHOW) | (1L << DROP) | (1L << SET) | (1L << GET) | (1L << OPERATE) | (1L << PRIVILEGE) | (1L << PRIVILEGES) | (1L << RUN) | (1L << STAT) | (1L << QUIT) | (1L << EXIT) | (1L << KILL))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (REGISTER - 72)) | (1L << (REMOVE - 72)) | (1L << (AGGREGATE - 72)) | (1L << (PRINT - 72)) | (1L << (UPDATE - 72)) | (1L << (GRANT - 72)) | (1L << (REVOKE - 72)) | (1L << (REPAIR - 72)))) != 0)) {
				{
				{
				setState(135); statement();
				}
				}
				setState(140);
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
			setState(167);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); connect();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); disconnect();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143); create();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144); drop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(145); repair();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146); grant();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147); revoke();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148); remove();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(149); insert();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(150); update();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(151); delete();
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(152); select();
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(153); register();
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(154); execute();
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(155); aggregate();
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(156); operate();
				}
				break;

			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(157); show();
				}
				break;

			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(158); desc();
				}
				break;

			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(159); stat();
				}
				break;

			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(160); set();
				}
				break;

			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(161); get();
				}
				break;

			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(162); run();
				}
				break;

			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(163); kill();
				}
				break;

			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(164); quit();
				}
				break;

			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(165); help();
				}
				break;

			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(166); print();
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
			setState(169); match(CONNECT);
			setState(170); ((ConnectContext)_localctx).hostName = match(STRINGLITERAL);
			setState(171); ((ConnectContext)_localctx).port = match(INTLITERAL);
			setState(173);
			_la = _input.LA(1);
			if (_la==INTLITERAL) {
				{
				setState(172); ((ConnectContext)_localctx).timeout = match(INTLITERAL);
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
			setState(175); match(DISCONNECT);
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
		public List<PrivilegeContext> privilege() {
			return getRuleContexts(PrivilegeContext.class);
		}
		public TerminalNode MAPVALUES() { return getToken(AQLParser.MAPVALUES, 0); }
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
		public TerminalNode LIST() { return getToken(AQLParser.LIST, 0); }
		public BinContext bin() {
			return getRuleContext(BinContext.class,0);
		}
		public TerminalNode PRIVILEGE() { return getToken(AQLParser.PRIVILEGE, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode PRIVILEGES() { return getToken(AQLParser.PRIVILEGES, 0); }
		public PrivilegeContext privilege(int i) {
			return getRuleContext(PrivilegeContext.class,i);
		}
		public TerminalNode MAPKEYS() { return getToken(AQLParser.MAPKEYS, 0); }
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
			setState(177); match(CREATE);
			setState(220);
			switch (_input.LA(1)) {
			case INDEX:
			case LIST:
			case MAPKEYS:
			case MAPVALUES:
				{
				setState(179);
				_la = _input.LA(1);
				if (((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LIST - 68)) | (1L << (MAPKEYS - 68)) | (1L << (MAPVALUES - 68)))) != 0)) {
					{
					setState(178);
					_la = _input.LA(1);
					if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LIST - 68)) | (1L << (MAPKEYS - 68)) | (1L << (MAPVALUES - 68)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(181); match(INDEX);
				setState(182); index_name();
				setState(183); match(ON);
				setState(184); nameSet();
				definitions.add(VariableDefinition.WRITE_POLICY);
				setState(186); match(T__17);
				setState(187); ((CreateContext)_localctx).binName = bin();
				setState(188); match(T__0);
				setState(189);
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
				setState(192); match(USER);
				setState(193); user();
				setState(194); match(PASSWORD);
				setState(195); password();
				setState(205);
				switch (_input.LA(1)) {
				case ROLE:
					{
					setState(196); match(ROLE);
					setState(197); role();
					}
					break;
				case ROLES:
					{
					setState(198); match(ROLES);
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDENTIFIER) {
						{
						{
						setState(199); roles();
						}
						}
						setState(204);
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
			case ROLE:
				{
				setState(209); match(ROLE);
				setState(210); role();
				setState(211);
				_la = _input.LA(1);
				if ( !(_la==PRIVILEGE || _la==PRIVILEGES) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__7) | (1L << T__5) | (1L << T__1))) != 0)) {
					{
					{
					setState(212); privilege();
					}
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class DropContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(AQLParser.INDEX, 0); }
		public NameSetContext nameSet() {
			return getRuleContext(NameSetContext.class,0);
		}
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
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
		public TerminalNode ROLE() { return getToken(AQLParser.ROLE, 0); }
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
			setState(222); match(DROP);
			setState(239);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(223); match(INDEX);
				setState(224); nameSet();
				setState(225); index_name();
				}
				break;
			case MODULE:
				{
				setState(227); match(MODULE);
				setState(228); moduleName();
				}
				break;
			case SET:
				{
				setState(229); match(SET);
				setState(230); nameSet();
				}
				break;
			case USER:
				{
				setState(231); match(USER);
				setState(232); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
				}
				break;
			case ROLE:
				{
				setState(235); match(ROLE);
				setState(236); role();
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
			setState(241); match(REPAIR);
			setState(242); match(INDEX);
			setState(243); index_name();
			setState(244); match(ON);
			setState(245); nameSet();
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
		public List<PrivilegeContext> privilege() {
			return getRuleContexts(PrivilegeContext.class);
		}
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public TerminalNode PRIVILEGE() { return getToken(AQLParser.PRIVILEGE, 0); }
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode PRIVILEGES() { return getToken(AQLParser.PRIVILEGES, 0); }
		public PrivilegeContext privilege(int i) {
			return getRuleContext(PrivilegeContext.class,i);
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
		int _la;
		try {
			setState(271);
			switch (_input.LA(1)) {
			case GRANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(247); match(GRANT);
				setState(252);
				switch (_input.LA(1)) {
				case ROLES:
					{
					setState(248); match(ROLES);
					setState(249); roles();
					}
					break;
				case ROLE:
					{
					setState(250); match(ROLE);
					setState(251); role();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(254); match(TO);
				setState(255); user();
				}
				break;
			case PRIVILEGE:
			case PRIVILEGES:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				switch (_input.LA(1)) {
				case PRIVILEGE:
					{
					setState(257); match(PRIVILEGE);
					setState(258); privilege();
					}
					break;
				case PRIVILEGES:
					{
					setState(259); match(PRIVILEGES);
					setState(261); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(260); privilege();
						}
						}
						setState(263); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__7) | (1L << T__5) | (1L << T__1))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(267); match(TO);
				setState(268); role();
				definitions.add(VariableDefinition.ADMIN_POLICY);
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

	public static class RevokeContext extends ParserRuleContext {
		public TerminalNode ROLES() { return getToken(AQLParser.ROLES, 0); }
		public List<PrivilegeContext> privilege() {
			return getRuleContexts(PrivilegeContext.class);
		}
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
		}
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public TerminalNode PRIVILEGE() { return getToken(AQLParser.PRIVILEGE, 0); }
		public UserContext user() {
			return getRuleContext(UserContext.class,0);
		}
		public TerminalNode PRIVILEGES() { return getToken(AQLParser.PRIVILEGES, 0); }
		public PrivilegeContext privilege(int i) {
			return getRuleContext(PrivilegeContext.class,i);
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
		int _la;
		try {
			setState(297);
			switch (_input.LA(1)) {
			case REVOKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(273); match(REVOKE);
				setState(278);
				switch (_input.LA(1)) {
				case ROLES:
					{
					setState(274); match(ROLES);
					setState(275); roles();
					}
					break;
				case ROLE:
					{
					setState(276); match(ROLE);
					setState(277); role();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(280); match(FROM);
				setState(281); user();
				}
				break;
			case PRIVILEGE:
			case PRIVILEGES:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				switch (_input.LA(1)) {
				case PRIVILEGE:
					{
					setState(283); match(PRIVILEGE);
					setState(284); privilege();
					}
					break;
				case PRIVILEGES:
					{
					setState(285); match(PRIVILEGES);
					setState(287); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(286); privilege();
						}
						}
						setState(289); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__20) | (1L << T__7) | (1L << T__5) | (1L << T__1))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(293); match(FROM);
				setState(294); role();
				definitions.add(VariableDefinition.ADMIN_POLICY);
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
			setState(299); match(IDENTIFIER);
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
			setState(301); match(IDENTIFIER);
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
			setState(303); role();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(304); match(T__14);
				setState(305); role();
				}
				}
				setState(310);
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
		public TerminalNode IDENTIFIER() { return getToken(AQLParser.IDENTIFIER, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); match(IDENTIFIER);
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

	public static class PrivilegeContext extends ParserRuleContext {
		public com.aerospike.client.admin.Privilege priv;
		public NameSetContext nameSet;
		public List<NameSetContext> nameSet() {
			return getRuleContexts(NameSetContext.class);
		}
		public NameSetContext nameSet(int i) {
			return getRuleContext(NameSetContext.class,i);
		}
		public PrivilegeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_privilege; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPrivilege(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPrivilege(this);
		}
	}

	public final PrivilegeContext privilege() throws RecognitionException {
		PrivilegeContext _localctx = new PrivilegeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_privilege);
		((PrivilegeContext)_localctx).priv =  new Privilege();
		int _la;
		try {
			setState(339);
			switch (_input.LA(1)) {
			case T__20:
			case T__5:
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(313); match(T__1);

								_localctx.priv.code = PrivilegeCode.READ;
							
					}
					break;
				case T__20:
					{
					setState(315); match(T__20);
					setState(318);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(316); match(T__12);
						setState(317); ((PrivilegeContext)_localctx).nameSet = nameSet();
						}
						break;
					}

								_localctx.priv.code = PrivilegeCode.READ_WRITE;
							
					}
					break;
				case T__5:
					{
					setState(321); match(T__5);
					setState(324);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(322); match(T__12);
						setState(323); ((PrivilegeContext)_localctx).nameSet = nameSet();
						}
						break;
					}

								_localctx.priv.code = PrivilegeCode.READ_WRITE_UDF;
							
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(333);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(329); match(T__12);
					setState(330); ((PrivilegeContext)_localctx).nameSet = nameSet();

								_localctx.priv.namespace = ((PrivilegeContext)_localctx).nameSet.namespaceName;
								_localctx.priv.setName = ((PrivilegeContext)_localctx).nameSet.setName;
							
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(335); match(T__7);

							_localctx.priv.code = PrivilegeCode.READ_WRITE_UDF;
						
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(337); match(T__21);

							_localctx.priv.code = PrivilegeCode.READ_WRITE_UDF;
						
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
		enterRule(_localctx, 30, RULE_remove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341); match(REMOVE);
			setState(342); match(MODULE);
			setState(343); moduleName();
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
		enterRule(_localctx, 32, RULE_operate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); match(OPERATE);
			setState(346); operateFunction();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(347); match(T__14);
				setState(348); operateFunction();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354); match(ON);
			setState(355); nameSet();
			setState(356); match(WHERE);
			setState(357); primaryKeyPredicate();
			setState(360);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(358); match(AND);
				setState(359); generationPredicate();
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
		public BinNameListContext binNameList() {
			return getRuleContext(BinNameListContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(AQLParser.VALUES, 0); }
		public PrimaryKeyContext primaryKey() {
			return getRuleContext(PrimaryKeyContext.class,0);
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
		enterRule(_localctx, 34, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); match(INSERT);
			setState(365); match(INTO);
			setState(366); nameSet();
			setState(367); match(T__17);
			setState(368); match(PK);
			setState(369); match(T__14);
			setState(370); binNameList();
			setState(371); match(T__0);
			setState(372); match(VALUES);
			setState(373); match(T__17);
			setState(374); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
			setState(375); match(T__14);
			setState(376); valueList();
			setState(377); match(T__0);

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
		enterRule(_localctx, 36, RULE_update);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); match(UPDATE);
			setState(381); nameSet();
			setState(382); match(SET);
			setState(383); updateList();
			setState(384); match(WHERE);
			setState(385); primaryKeyPredicate();
			setState(388);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(386); match(AND);
				setState(387); generationPredicate();
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
		enterRule(_localctx, 38, RULE_updateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			switch (_input.LA(1)) {
			case TTL:
				{
				setState(392); ttlValue();
				}
				break;
			case IDENTIFIER:
				{
				setState(393); binValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(396); match(T__14);
				setState(397); binValue();
				}
				}
				setState(402);
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
		enterRule(_localctx, 40, RULE_delete);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403); match(DELETE);
			setState(404); match(FROM);
			setState(405); nameSet();
			setState(406); match(WHERE);
			setState(407); primaryKeyPredicate();
			setState(410);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(408); match(AND);
				setState(409); generationPredicate();
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
		enterRule(_localctx, 42, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414); match(SELECT);
			setState(417);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(415); match(STAR);
				}
				break;
			case TTL:
			case IDENTIFIER:
				{
				setState(416); binNameList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(421);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(419); match(IN);
				setState(420); collectionType();
				}
			}

			setState(423); match(FROM);
			setState(424); nameSet();
			setState(426);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(425); where();
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
		enterRule(_localctx, 44, RULE_collectionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (LIST - 68)) | (1L << (MAPKEYS - 68)) | (1L << (MAPVALUES - 68)))) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432); match(WHERE);
			setState(433); predicate();
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
		enterRule(_localctx, 48, RULE_operateFunction);
		int _la;
		try {
			setState(472);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(435); match(ADD);
				setState(436); match(T__17);
				setState(437); bin();
				setState(438); match(T__14);
				setState(439); value();
				setState(440); match(T__0);
				}
				break;
			case PUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(442); match(PUT);
				setState(443); match(T__17);
				setState(444); bin();
				setState(445); match(T__14);
				setState(446); value();
				setState(447); match(T__0);
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 3);
				{
				setState(449); match(APPEND);
				setState(450); match(T__17);
				setState(451); bin();
				setState(452); match(T__14);
				setState(453); value();
				setState(454); match(T__0);
				}
				break;
			case PREPEND:
				enterOuterAlt(_localctx, 4);
				{
				setState(456); match(PREPEND);
				setState(457); match(T__17);
				setState(458); bin();
				setState(459); match(T__14);
				setState(460); value();
				setState(461); match(T__0);
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 5);
				{
				setState(463); match(GET);
				setState(468);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(464); match(T__17);
					setState(465); bin();
					setState(466); match(T__0);
					}
				}

				}
				break;
			case TOUCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(470); match(TOUCH);
				}
				break;
			case HEADER:
				enterOuterAlt(_localctx, 7);
				{
				setState(471); match(HEADER);
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
		enterRule(_localctx, 50, RULE_nameSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); ((NameSetContext)_localctx).namespace_name = namespace_name();
			((NameSetContext)_localctx).namespaceName =  (((NameSetContext)_localctx).namespace_name!=null?_input.getText(((NameSetContext)_localctx).namespace_name.start,((NameSetContext)_localctx).namespace_name.stop):null);
			setState(480);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(476); match(T__12);
				setState(477); ((NameSetContext)_localctx).set_name = set_name();
				((NameSetContext)_localctx).setName =  (((NameSetContext)_localctx).set_name!=null?_input.getText(((NameSetContext)_localctx).set_name.start,((NameSetContext)_localctx).set_name.stop):null);
				}
				break;
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
		enterRule(_localctx, 52, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482); match(REGISTER);
			setState(483); match(MODULE);
			setState(484); ((RegisterContext)_localctx).filepath = filePath();

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
		enterRule(_localctx, 54, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487); match(EXECUTE);
			setState(488); moduleFunction();
			setState(489); match(T__17);
			setState(491);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL || _la==INTLITERAL) {
				{
				setState(490); valueList();
				}
			}

			setState(493); match(T__0);
			setState(494); match(ON);
			setState(495); nameSet();
			setState(497);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(496); where();
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
		public CollectionTypeContext collectionType() {
			return getRuleContext(CollectionTypeContext.class,0);
		}
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
		public TerminalNode IN() { return getToken(AQLParser.IN, 0); }
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
		enterRule(_localctx, 56, RULE_aggregate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501); match(AGGREGATE);
			setState(502); moduleFunction();
			setState(508);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(503); match(T__17);
				setState(505);
				_la = _input.LA(1);
				if (_la==STRINGLITERAL || _la==INTLITERAL) {
					{
					setState(504); valueList();
					}
				}

				setState(507); match(T__0);
				}
			}

			setState(510); match(ON);
			setState(511); nameSet();
			setState(514);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(512); match(IN);
				setState(513); collectionType();
				}
			}

			setState(517);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(516); where();
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
		enterRule(_localctx, 58, RULE_moduleFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			((ModuleFunctionContext)_localctx).packageName = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (LLIST - 97)) | (1L << (LMAP - 97)) | (1L << (IDENTIFIER - 97)))) != 0)) ) {
				((ModuleFunctionContext)_localctx).packageName = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(522); match(T__12);
			setState(523);
			((ModuleFunctionContext)_localctx).functionName = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__16) | (1L << T__11) | (1L << T__9) | (1L << T__8) | (1L << GET) | (1L << SCAN))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (REMOVE - 73)) | (1L << (ADD - 73)) | (1L << (PUT - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) ) {
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
		enterRule(_localctx, 60, RULE_binNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			switch (_input.LA(1)) {
			case TTL:
				{
				setState(525); match(TTL);
				}
				break;
			case IDENTIFIER:
				{
				setState(526); bin();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(529); match(T__14);
				setState(530); bin();
				}
				}
				setState(535);
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
		enterRule(_localctx, 62, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); value();
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(537); match(T__14);
				setState(538); value();
				}
				}
				setState(543);
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
		enterRule(_localctx, 64, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			switch (_input.LA(1)) {
			case PK:
				{
				setState(544); primaryKeyPredicate();
				}
				break;
			case IDENTIFIER:
				{
				setState(545); filterPredicate();
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
		enterRule(_localctx, 66, RULE_primaryKeyPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548); match(PK);
			setState(549); match(EQ);
			setState(550); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
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
		enterRule(_localctx, 68, RULE_generationPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552); match(T__15);
			setState(553); match(EQ);
			setState(554); match(INTLITERAL);
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
		enterRule(_localctx, 70, RULE_filterPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(556); equalityFilter();
				}
				break;

			case 2:
				{
				setState(557); rangeFilter();
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
		enterRule(_localctx, 72, RULE_equalityFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562); binValue();
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
		enterRule(_localctx, 74, RULE_ttlValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564); match(TTL);
			setState(565); match(EQ);
			setState(566); integerValue();
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
		enterRule(_localctx, 76, RULE_binValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568); bin();
			setState(569); match(EQ);
			setState(570); value();
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
		enterRule(_localctx, 78, RULE_rangeFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572); bin();
			setState(573); match(BETWEEN);
			setState(574); ((RangeFilterContext)_localctx).low = integerValue();
			setState(575); match(AND);
			setState(576); ((RangeFilterContext)_localctx).high = integerValue();
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
		enterRule(_localctx, 80, RULE_show);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578); match(SHOW);
			setState(595);
			switch (_input.LA(1)) {
			case INDEXES:
				{
				setState(579); match(INDEXES);
				setState(581);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(580); nameSet();
					}
				}

				}
				break;
			case SCANS:
				{
				setState(583); match(SCANS);
				}
				break;
			case NAMESPACES:
				{
				setState(584); match(NAMESPACES);
				}
				break;
			case SETS:
				{
				setState(585); match(SETS);
				}
				break;
			case BINS:
				{
				setState(586); match(BINS);
				}
				break;
			case QUERIES:
				{
				setState(587); match(QUERIES);
				}
				break;
			case MODULES:
				{
				setState(588); match(MODULES);
				}
				break;
			case USER:
				{
				setState(589); match(USER);
				setState(590); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
				}
				break;
			case USERS:
				{
				setState(593); match(USERS);
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
		enterRule(_localctx, 82, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599); match(DESC);
			setState(606);
			switch (_input.LA(1)) {
			case MODULE:
				{
				setState(600); match(MODULE);
				setState(601); moduleName();
				}
				break;
			case INDEX:
				{
				setState(602); match(INDEX);
				setState(603); namespace_name();
				setState(604); index_name();
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
		enterRule(_localctx, 84, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610); match(STAT);
			setState(617);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(611); match(INDEX);
				setState(612); namespace_name();
				setState(613); index_name();
				}
				break;
			case QUERY:
				{
				setState(615); match(QUERY);
				}
				break;
			case SYSTEM:
				{
				setState(616); match(SYSTEM);
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
		enterRule(_localctx, 86, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621); match(SET);
			setState(642);
			switch (_input.LA(1)) {
			case TIMEOUT:
				{
				setState(622); match(TIMEOUT);
				setState(623); ((SetContext)_localctx).timeOut = match(INTLITERAL);
				definitions.add(VariableDefinition.READ_POLICY);definitions.add(VariableDefinition.WRITE_POLICY);
				}
				break;
			case VERBOSE:
				{
				setState(625); match(VERBOSE);
				setState(626); ((SetContext)_localctx).verboseOn = booleanLiteral();
				}
				break;
			case ECHO:
				{
				setState(627); match(ECHO);
				setState(628); ((SetContext)_localctx).echoOn = booleanLiteral();
				}
				break;
			case TTL:
				{
				setState(629); match(TTL);
				setState(630); ((SetContext)_localctx).ttl = match(INTLITERAL);
				}
				break;
			case OUTPUT:
				{
				setState(631); match(OUTPUT);
				setState(632); viewType();
				}
				break;
			case LUA_USER_PATH:
				{
				setState(633); match(LUA_USER_PATH);
				setState(634); ((SetContext)_localctx).luaUserPath = match(STRINGLITERAL);
				}
				break;
			case FAIL_ON_CLUSTER_CHANGE:
				{
				setState(635); match(FAIL_ON_CLUSTER_CHANGE);
				}
				break;
			case PASSWORD:
				{
				setState(636); match(PASSWORD);
				setState(637); password();
				setState(638); match(FOR);
				setState(639); user();
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
		enterRule(_localctx, 88, RULE_get);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644); match(GET);
			setState(645);
			_la = _input.LA(1);
			if ( !(_la==OUTPUT || _la==TIMEOUT || ((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (VERBOSE - 85)) | (1L << (ECHO - 85)) | (1L << (TTL - 85)) | (1L << (LUA_USER_PATH - 85)) | (1L << (FAIL_ON_CLUSTER_CHANGE - 85)))) != 0)) ) {
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
		enterRule(_localctx, 90, RULE_viewType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__10) | (1L << T__4) | (1L << T__3))) != 0)) ) {
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
		enterRule(_localctx, 92, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649); match(RUN);
			setState(650); match(STRINGLITERAL);
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
		enterRule(_localctx, 94, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652); match(PRINT);
			setState(654);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL) {
				{
				setState(653); match(STRINGLITERAL);
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
		enterRule(_localctx, 96, RULE_kill);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656); match(KILL);
			setState(657);
			_la = _input.LA(1);
			if ( !(_la==QUERY || _la==SCAN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(658); match(INTLITERAL);
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
		enterRule(_localctx, 98, RULE_kill_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660); match(KILL_QUERY);
			setState(661); match(INTLITERAL);
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
		enterRule(_localctx, 100, RULE_kill_scan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663); match(KILL_SCAN);
			setState(664); match(INTLITERAL);
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
		enterRule(_localctx, 102, RULE_quit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << QUIT) | (1L << EXIT))) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_help);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668); match(T__2);
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
		enterRule(_localctx, 106, RULE_primaryKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
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
		enterRule(_localctx, 108, RULE_package_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672); match(IDENTIFIER);
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
		enterRule(_localctx, 110, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674); match(IDENTIFIER);
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
		enterRule(_localctx, 112, RULE_namespace_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676); match(IDENTIFIER);
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
		enterRule(_localctx, 114, RULE_set_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678); ((Set_nameContext)_localctx).setName = match(IDENTIFIER);

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
		enterRule(_localctx, 116, RULE_bin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681); ((BinContext)_localctx).binName = match(IDENTIFIER);

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

	public static class DotPathContext extends ParserRuleContext {
		public Token path;
		public TerminalNode IDENTIFIER(int i) {
			return getToken(AQLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(AQLParser.IDENTIFIER); }
		public DotPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDotPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDotPath(this);
		}
	}

	public final DotPathContext dotPath() throws RecognitionException {
		DotPathContext _localctx = new DotPathContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_dotPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684); ((DotPathContext)_localctx).path = match(IDENTIFIER);
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(685); match(T__12);
				setState(686); ((DotPathContext)_localctx).path = match(IDENTIFIER);
				}
				}
				setState(691);
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
		enterRule(_localctx, 120, RULE_value);
		try {
			setState(694);
			switch (_input.LA(1)) {
			case INTLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(692); integerValue();
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(693); textValue();
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
		enterRule(_localctx, 122, RULE_textValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696); match(STRINGLITERAL);
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
		enterRule(_localctx, 124, RULE_integerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698); match(INTLITERAL);
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
		enterRule(_localctx, 126, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
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
		enterRule(_localctx, 128, RULE_moduleName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702); match(IDENTIFIER);
			setState(703); match(T__12);
			setState(704);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__4) ) {
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
		enterRule(_localctx, 130, RULE_filePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706); match(STRINGLITERAL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3y\u02c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\3\7\3\u008b\n\3\f\3"+
		"\16\3\u008e\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00aa\n\4\3\5\3"+
		"\5\3\5\3\5\5\5\u00b0\n\5\3\6\3\6\3\7\3\7\5\7\u00b6\n\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00cb"+
		"\n\7\f\7\16\7\u00ce\13\7\5\7\u00d0\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00d8"+
		"\n\7\f\7\16\7\u00db\13\7\3\7\3\7\5\7\u00df\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00f2\n\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00ff\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\6\n\u0108\n\n\r\n\16\n\u0109\5\n\u010c\n\n\3\n\3\n\3\n\3\n\5\n\u0112"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u0119\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\6\13\u0122\n\13\r\13\16\13\u0123\5\13\u0126\n\13\3\13\3\13"+
		"\3\13\3\13\5\13\u012c\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u0135\n"+
		"\16\f\16\16\16\u0138\13\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u0141"+
		"\n\20\3\20\3\20\3\20\3\20\5\20\u0147\n\20\3\20\5\20\u014a\n\20\3\20\3"+
		"\20\3\20\3\20\5\20\u0150\n\20\3\20\3\20\3\20\3\20\5\20\u0156\n\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u0160\n\22\f\22\16\22\u0163\13"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u016b\n\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0187\n\24\3\24\3\24\3\25"+
		"\3\25\5\25\u018d\n\25\3\25\3\25\7\25\u0191\n\25\f\25\16\25\u0194\13\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u019d\n\26\3\26\3\26\3\27\3\27"+
		"\3\27\5\27\u01a4\n\27\3\27\3\27\5\27\u01a8\n\27\3\27\3\27\3\27\5\27\u01ad"+
		"\n\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u01d7\n\32\3\32\3\32\5\32\u01db\n\32\3\33\3\33\3\33\3\33\3\33\3\33\5"+
		"\33\u01e3\n\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u01ee"+
		"\n\35\3\35\3\35\3\35\3\35\5\35\u01f4\n\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\5\36\u01fc\n\36\3\36\5\36\u01ff\n\36\3\36\3\36\3\36\3\36\5\36\u0205\n"+
		"\36\3\36\5\36\u0208\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \5 \u0212"+
		"\n \3 \3 \7 \u0216\n \f \16 \u0219\13 \3!\3!\3!\7!\u021e\n!\f!\16!\u0221"+
		"\13!\3\"\3\"\5\"\u0225\n\"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\5%\u0231\n%\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\5*\u0248"+
		"\n*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0256\n*\3*\3*\3+\3+\3+\3+"+
		"\3+\3+\3+\5+\u0261\n+\3+\3+\3,\3,\3,\3,\3,\3,\3,\5,\u026c\n,\3,\3,\3-"+
		"\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0285"+
		"\n-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\5\61\u0291\n\61\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\7=\u02b2\n=\f=\16=\u02b5"+
		"\13=\3>\3>\5>\u02b9\n>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3B\3C\3C\3C\2\2D\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\2\16\3\2FH\3\2BC\3\2/\60\5"+
		"\2ccffrr\13\2\6\6\b\b\r\r\17\20**::KK]^rr\7\2..;;WY[[oo\5\2\13\13\16\16"+
		"\24\25\3\29:\4\2\5\5<=\4\2ssuu\3\2\31\32\4\2\22\22\24\24\u02eb\2\u0086"+
		"\3\2\2\2\4\u008c\3\2\2\2\6\u00a9\3\2\2\2\b\u00ab\3\2\2\2\n\u00b1\3\2\2"+
		"\2\f\u00b3\3\2\2\2\16\u00e0\3\2\2\2\20\u00f3\3\2\2\2\22\u0111\3\2\2\2"+
		"\24\u012b\3\2\2\2\26\u012d\3\2\2\2\30\u012f\3\2\2\2\32\u0131\3\2\2\2\34"+
		"\u0139\3\2\2\2\36\u0155\3\2\2\2 \u0157\3\2\2\2\"\u015b\3\2\2\2$\u016e"+
		"\3\2\2\2&\u017e\3\2\2\2(\u018c\3\2\2\2*\u0195\3\2\2\2,\u01a0\3\2\2\2."+
		"\u01b0\3\2\2\2\60\u01b2\3\2\2\2\62\u01da\3\2\2\2\64\u01dc\3\2\2\2\66\u01e4"+
		"\3\2\2\28\u01e9\3\2\2\2:\u01f7\3\2\2\2<\u020b\3\2\2\2>\u0211\3\2\2\2@"+
		"\u021a\3\2\2\2B\u0224\3\2\2\2D\u0226\3\2\2\2F\u022a\3\2\2\2H\u0230\3\2"+
		"\2\2J\u0234\3\2\2\2L\u0236\3\2\2\2N\u023a\3\2\2\2P\u023e\3\2\2\2R\u0244"+
		"\3\2\2\2T\u0259\3\2\2\2V\u0264\3\2\2\2X\u026f\3\2\2\2Z\u0286\3\2\2\2\\"+
		"\u0289\3\2\2\2^\u028b\3\2\2\2`\u028e\3\2\2\2b\u0292\3\2\2\2d\u0296\3\2"+
		"\2\2f\u0299\3\2\2\2h\u029c\3\2\2\2j\u029e\3\2\2\2l\u02a0\3\2\2\2n\u02a2"+
		"\3\2\2\2p\u02a4\3\2\2\2r\u02a6\3\2\2\2t\u02a8\3\2\2\2v\u02ab\3\2\2\2x"+
		"\u02ae\3\2\2\2z\u02b8\3\2\2\2|\u02ba\3\2\2\2~\u02bc\3\2\2\2\u0080\u02be"+
		"\3\2\2\2\u0082\u02c0\3\2\2\2\u0084\u02c4\3\2\2\2\u0086\u0087\5\4\3\2\u0087"+
		"\u0088\7\2\2\3\u0088\3\3\2\2\2\u0089\u008b\5\6\4\2\u008a\u0089\3\2\2\2"+
		"\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\5\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008f\u00aa\5\b\5\2\u0090\u00aa\5\n\6\2\u0091"+
		"\u00aa\5\f\7\2\u0092\u00aa\5\16\b\2\u0093\u00aa\5\20\t\2\u0094\u00aa\5"+
		"\22\n\2\u0095\u00aa\5\24\13\2\u0096\u00aa\5 \21\2\u0097\u00aa\5$\23\2"+
		"\u0098\u00aa\5&\24\2\u0099\u00aa\5*\26\2\u009a\u00aa\5,\27\2\u009b\u00aa"+
		"\5\66\34\2\u009c\u00aa\58\35\2\u009d\u00aa\5:\36\2\u009e\u00aa\5\"\22"+
		"\2\u009f\u00aa\5R*\2\u00a0\u00aa\5T+\2\u00a1\u00aa\5V,\2\u00a2\u00aa\5"+
		"X-\2\u00a3\u00aa\5Z.\2\u00a4\u00aa\5^\60\2\u00a5\u00aa\5b\62\2\u00a6\u00aa"+
		"\5h\65\2\u00a7\u00aa\5j\66\2\u00a8\u00aa\5`\61\2\u00a9\u008f\3\2\2\2\u00a9"+
		"\u0090\3\2\2\2\u00a9\u0091\3\2\2\2\u00a9\u0092\3\2\2\2\u00a9\u0093\3\2"+
		"\2\2\u00a9\u0094\3\2\2\2\u00a9\u0095\3\2\2\2\u00a9\u0096\3\2\2\2\u00a9"+
		"\u0097\3\2\2\2\u00a9\u0098\3\2\2\2\u00a9\u0099\3\2\2\2\u00a9\u009a\3\2"+
		"\2\2\u00a9\u009b\3\2\2\2\u00a9\u009c\3\2\2\2\u00a9\u009d\3\2\2\2\u00a9"+
		"\u009e\3\2\2\2\u00a9\u009f\3\2\2\2\u00a9\u00a0\3\2\2\2\u00a9\u00a1\3\2"+
		"\2\2\u00a9\u00a2\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9\u00a4\3\2\2\2\u00a9"+
		"\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2"+
		"\2\2\u00aa\7\3\2\2\2\u00ab\u00ac\7\33\2\2\u00ac\u00ad\7s\2\2\u00ad\u00af"+
		"\7u\2\2\u00ae\u00b0\7u\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\t\3\2\2\2\u00b1\u00b2\7\34\2\2\u00b2\13\3\2\2\2\u00b3\u00de\7!\2\2\u00b4"+
		"\u00b6\t\2\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\7\"\2\2\u00b8\u00b9\5p9\2\u00b9\u00ba\7,\2\2\u00ba\u00bb"+
		"\5\64\33\2\u00bb\u00bc\b\7\1\2\u00bc\u00bd\7\7\2\2\u00bd\u00be\5v<\2\u00be"+
		"\u00bf\7\30\2\2\u00bf\u00c0\t\3\2\2\u00c0\u00c1\b\7\1\2\u00c1\u00df\3"+
		"\2\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\5\26\f\2\u00c4\u00c5\7i\2\2\u00c5"+
		"\u00cf\5\30\r\2\u00c6\u00c7\7j\2\2\u00c7\u00d0\5\34\17\2\u00c8\u00cc\7"+
		"k\2\2\u00c9\u00cb\5\32\16\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00c6\3\2\2\2\u00cf\u00c8\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\b\7\1\2\u00d2\u00df\3\2\2\2\u00d3\u00d4\7j\2\2\u00d4\u00d5\5\34"+
		"\17\2\u00d5\u00d9\t\4\2\2\u00d6\u00d8\5\36\20\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2"+
		"\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\b\7\1\2\u00dd\u00df\3\2\2\2\u00de"+
		"\u00b5\3\2\2\2\u00de\u00c2\3\2\2\2\u00de\u00d3\3\2\2\2\u00df\r\3\2\2\2"+
		"\u00e0\u00f1\7&\2\2\u00e1\u00e2\7\"\2\2\u00e2\u00e3\5\64\33\2\u00e3\u00e4"+
		"\5p9\2\u00e4\u00f2\3\2\2\2\u00e5\u00e6\7+\2\2\u00e6\u00f2\5\u0082B\2\u00e7"+
		"\u00e8\7)\2\2\u00e8\u00f2\5\64\33\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\5\26"+
		"\f\2\u00eb\u00ec\b\b\1\2\u00ec\u00f2\3\2\2\2\u00ed\u00ee\7j\2\2\u00ee"+
		"\u00ef\5\34\17\2\u00ef\u00f0\b\b\1\2\u00f0\u00f2\3\2\2\2\u00f1\u00e1\3"+
		"\2\2\2\u00f1\u00e5\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f1\u00e9\3\2\2\2\u00f1"+
		"\u00ed\3\2\2\2\u00f2\17\3\2\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7\"\2\2"+
		"\u00f5\u00f6\5p9\2\u00f6\u00f7\7,\2\2\u00f7\u00f8\5\64\33\2\u00f8\21\3"+
		"\2\2\2\u00f9\u00fe\7l\2\2\u00fa\u00fb\7k\2\2\u00fb\u00ff\5\32\16\2\u00fc"+
		"\u00fd\7j\2\2\u00fd\u00ff\5\34\17\2\u00fe\u00fa\3\2\2\2\u00fe\u00fc\3"+
		"\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7n\2\2\u0101\u0102\5\26\f\2\u0102"+
		"\u0112\3\2\2\2\u0103\u0104\7/\2\2\u0104\u010c\5\36\20\2\u0105\u0107\7"+
		"\60\2\2\u0106\u0108\5\36\20\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2"+
		"\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0103"+
		"\3\2\2\2\u010b\u0105\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7n\2\2\u010e"+
		"\u010f\5\34\17\2\u010f\u0110\b\n\1\2\u0110\u0112\3\2\2\2\u0111\u00f9\3"+
		"\2\2\2\u0111\u010b\3\2\2\2\u0112\23\3\2\2\2\u0113\u0118\7m\2\2\u0114\u0115"+
		"\7k\2\2\u0115\u0119\5\32\16\2\u0116\u0117\7j\2\2\u0117\u0119\5\34\17\2"+
		"\u0118\u0114\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b"+
		"\7\63\2\2\u011b\u011c\5\26\f\2\u011c\u012c\3\2\2\2\u011d\u011e\7/\2\2"+
		"\u011e\u0126\5\36\20\2\u011f\u0121\7\60\2\2\u0120\u0122\5\36\20\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0126\3\2\2\2\u0125\u011d\3\2\2\2\u0125\u011f\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\7\63\2\2\u0128\u0129\5\34\17\2\u0129\u012a"+
		"\b\13\1\2\u012a\u012c\3\2\2\2\u012b\u0113\3\2\2\2\u012b\u0125\3\2\2\2"+
		"\u012c\25\3\2\2\2\u012d\u012e\7r\2\2\u012e\27\3\2\2\2\u012f\u0130\7r\2"+
		"\2\u0130\31\3\2\2\2\u0131\u0136\5\34\17\2\u0132\u0133\7\n\2\2\u0133\u0135"+
		"\5\34\17\2\u0134\u0132\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2"+
		"\u0136\u0137\3\2\2\2\u0137\33\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a"+
		"\7r\2\2\u013a\35\3\2\2\2\u013b\u013c\7\27\2\2\u013c\u014a\b\20\1\2\u013d"+
		"\u0140\7\4\2\2\u013e\u013f\7\f\2\2\u013f\u0141\5\64\33\2\u0140\u013e\3"+
		"\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u014a\b\20\1\2\u0143"+
		"\u0146\7\23\2\2\u0144\u0145\7\f\2\2\u0145\u0147\5\64\33\2\u0146\u0144"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\b\20\1\2"+
		"\u0149\u013b\3\2\2\2\u0149\u013d\3\2\2\2\u0149\u0143\3\2\2\2\u014a\u014f"+
		"\3\2\2\2\u014b\u014c\7\f\2\2\u014c\u014d\5\64\33\2\u014d\u014e\b\20\1"+
		"\2\u014e\u0150\3\2\2\2\u014f\u014b\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0156"+
		"\3\2\2\2\u0151\u0152\7\21\2\2\u0152\u0156\b\20\1\2\u0153\u0154\7\3\2\2"+
		"\u0154\u0156\b\20\1\2\u0155\u0149\3\2\2\2\u0155\u0151\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0156\37\3\2\2\2\u0157\u0158\7K\2\2\u0158\u0159\7+\2\2\u0159"+
		"\u015a\5\u0082B\2\u015a!\3\2\2\2\u015b\u015c\7-\2\2\u015c\u0161\5\62\32"+
		"\2\u015d\u015e\7\n\2\2\u015e\u0160\5\62\32\2\u015f\u015d\3\2\2\2\u0160"+
		"\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7,\2\2\u0165\u0166\5\64\33\2\u0166"+
		"\u0167\7$\2\2\u0167\u016a\5D#\2\u0168\u0169\7\65\2\2\u0169\u016b\5F$\2"+
		"\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d"+
		"\b\22\1\2\u016d#\3\2\2\2\u016e\u016f\7\36\2\2\u016f\u0170\7\61\2\2\u0170"+
		"\u0171\5\64\33\2\u0171\u0172\7\7\2\2\u0172\u0173\7A\2\2\u0173\u0174\7"+
		"\n\2\2\u0174\u0175\5> \2\u0175\u0176\7\30\2\2\u0176\u0177\7(\2\2\u0177"+
		"\u0178\7\7\2\2\u0178\u0179\5l\67\2\u0179\u017a\7\n\2\2\u017a\u017b\5@"+
		"!\2\u017b\u017c\7\30\2\2\u017c\u017d\b\23\1\2\u017d%\3\2\2\2\u017e\u017f"+
		"\7V\2\2\u017f\u0180\5\64\33\2\u0180\u0181\7)\2\2\u0181\u0182\5(\25\2\u0182"+
		"\u0183\7$\2\2\u0183\u0186\5D#\2\u0184\u0185\7\65\2\2\u0185\u0187\5F$\2"+
		"\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189"+
		"\b\24\1\2\u0189\'\3\2\2\2\u018a\u018d\5L\'\2\u018b\u018d\5N(\2\u018c\u018a"+
		"\3\2\2\2\u018c\u018b\3\2\2\2\u018d\u0192\3\2\2\2\u018e\u018f\7\n\2\2\u018f"+
		"\u0191\5N(\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2"+
		"\2\u0192\u0193\3\2\2\2\u0193)\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196"+
		"\7 \2\2\u0196\u0197\7\63\2\2\u0197\u0198\5\64\33\2\u0198\u0199\7$\2\2"+
		"\u0199\u019c\5D#\2\u019a\u019b\7\65\2\2\u019b\u019d\5F$\2\u019c\u019a"+
		"\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\b\26\1\2"+
		"\u019f+\3\2\2\2\u01a0\u01a3\7\37\2\2\u01a1\u01a4\7I\2\2\u01a2\u01a4\5"+
		"> \2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5"+
		"\u01a6\7E\2\2\u01a6\u01a8\5.\30\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\7\63\2\2\u01aa\u01ac\5\64\33\2\u01ab"+
		"\u01ad\5\60\31\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3"+
		"\2\2\2\u01ae\u01af\b\27\1\2\u01af-\3\2\2\2\u01b0\u01b1\t\2\2\2\u01b1/"+
		"\3\2\2\2\u01b2\u01b3\7$\2\2\u01b3\u01b4\5B\"\2\u01b4\61\3\2\2\2\u01b5"+
		"\u01b6\7]\2\2\u01b6\u01b7\7\7\2\2\u01b7\u01b8\5v<\2\u01b8\u01b9\7\n\2"+
		"\2\u01b9\u01ba\5z>\2\u01ba\u01bb\7\30\2\2\u01bb\u01db\3\2\2\2\u01bc\u01bd"+
		"\7^\2\2\u01bd\u01be\7\7\2\2\u01be\u01bf\5v<\2\u01bf\u01c0\7\n\2\2\u01c0"+
		"\u01c1\5z>\2\u01c1\u01c2\7\30\2\2\u01c2\u01db\3\2\2\2\u01c3\u01c4\7_\2"+
		"\2\u01c4\u01c5\7\7\2\2\u01c5\u01c6\5v<\2\u01c6\u01c7\7\n\2\2\u01c7\u01c8"+
		"\5z>\2\u01c8\u01c9\7\30\2\2\u01c9\u01db\3\2\2\2\u01ca\u01cb\7`\2\2\u01cb"+
		"\u01cc\7\7\2\2\u01cc\u01cd\5v<\2\u01cd\u01ce\7\n\2\2\u01ce\u01cf\5z>\2"+
		"\u01cf\u01d0\7\30\2\2\u01d0\u01db\3\2\2\2\u01d1\u01d6\7*\2\2\u01d2\u01d3"+
		"\7\7\2\2\u01d3\u01d4\5v<\2\u01d4\u01d5\7\30\2\2\u01d5\u01d7\3\2\2\2\u01d6"+
		"\u01d2\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01db\3\2\2\2\u01d8\u01db\7a"+
		"\2\2\u01d9\u01db\7b\2\2\u01da\u01b5\3\2\2\2\u01da\u01bc\3\2\2\2\u01da"+
		"\u01c3\3\2\2\2\u01da\u01ca\3\2\2\2\u01da\u01d1\3\2\2\2\u01da\u01d8\3\2"+
		"\2\2\u01da\u01d9\3\2\2\2\u01db\63\3\2\2\2\u01dc\u01dd\5r:\2\u01dd\u01e2"+
		"\b\33\1\2\u01de\u01df\7\f\2\2\u01df\u01e0\5t;\2\u01e0\u01e1\b\33\1\2\u01e1"+
		"\u01e3\3\2\2\2\u01e2\u01de\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\65\3\2\2"+
		"\2\u01e4\u01e5\7J\2\2\u01e5\u01e6\7+\2\2\u01e6\u01e7\5\u0084C\2\u01e7"+
		"\u01e8\b\34\1\2\u01e8\67\3\2\2\2\u01e9\u01ea\7#\2\2\u01ea\u01eb\5<\37"+
		"\2\u01eb\u01ed\7\7\2\2\u01ec\u01ee\5@!\2\u01ed\u01ec\3\2\2\2\u01ed\u01ee"+
		"\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\7\30\2\2\u01f0\u01f1\7,\2\2\u01f1"+
		"\u01f3\5\64\33\2\u01f2\u01f4\5\60\31\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4"+
		"\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6\b\35\1\2\u01f69\3\2\2\2\u01f7"+
		"\u01f8\7L\2\2\u01f8\u01fe\5<\37\2\u01f9\u01fb\7\7\2\2\u01fa\u01fc\5@!"+
		"\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01ff"+
		"\7\30\2\2\u01fe\u01f9\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2"+
		"\u0200\u0201\7,\2\2\u0201\u0204\5\64\33\2\u0202\u0203\7E\2\2\u0203\u0205"+
		"\5.\30\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206"+
		"\u0208\5\60\31\2\u0207\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3"+
		"\2\2\2\u0209\u020a\b\36\1\2\u020a;\3\2\2\2\u020b\u020c\t\5\2\2\u020c\u020d"+
		"\7\f\2\2\u020d\u020e\t\6\2\2\u020e=\3\2\2\2\u020f\u0212\7Y\2\2\u0210\u0212"+
		"\5v<\2\u0211\u020f\3\2\2\2\u0211\u0210\3\2\2\2\u0212\u0217\3\2\2\2\u0213"+
		"\u0214\7\n\2\2\u0214\u0216\5v<\2\u0215\u0213\3\2\2\2\u0216\u0219\3\2\2"+
		"\2\u0217\u0215\3\2\2\2\u0217\u0218\3\2\2\2\u0218?\3\2\2\2\u0219\u0217"+
		"\3\2\2\2\u021a\u021f\5z>\2\u021b\u021c\7\n\2\2\u021c\u021e\5z>\2\u021d"+
		"\u021b\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2"+
		"\2\2\u0220A\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0225\5D#\2\u0223\u0225"+
		"\5H%\2\u0224\u0222\3\2\2\2\u0224\u0223\3\2\2\2\u0225C\3\2\2\2\u0226\u0227"+
		"\7A\2\2\u0227\u0228\7D\2\2\u0228\u0229\5l\67\2\u0229E\3\2\2\2\u022a\u022b"+
		"\7\t\2\2\u022b\u022c\7D\2\2\u022c\u022d\7u\2\2\u022dG\3\2\2\2\u022e\u0231"+
		"\5J&\2\u022f\u0231\5P)\2\u0230\u022e\3\2\2\2\u0230\u022f\3\2\2\2\u0231"+
		"\u0232\3\2\2\2\u0232\u0233\b%\1\2\u0233I\3\2\2\2\u0234\u0235\5N(\2\u0235"+
		"K\3\2\2\2\u0236\u0237\7Y\2\2\u0237\u0238\7D\2\2\u0238\u0239\5~@\2\u0239"+
		"M\3\2\2\2\u023a\u023b\5v<\2\u023b\u023c\7D\2\2\u023c\u023d\5z>\2\u023d"+
		"O\3\2\2\2\u023e\u023f\5v<\2\u023f\u0240\7\66\2\2\u0240\u0241\5~@\2\u0241"+
		"\u0242\7\65\2\2\u0242\u0243\5~@\2\u0243Q\3\2\2\2\u0244\u0255\7%\2\2\u0245"+
		"\u0247\7\'\2\2\u0246\u0248\5\64\33\2\u0247\u0246\3\2\2\2\u0247\u0248\3"+
		"\2\2\2\u0248\u0256\3\2\2\2\u0249\u0256\7Q\2\2\u024a\u0256\7N\2\2\u024b"+
		"\u0256\7O\2\2\u024c\u0256\7P\2\2\u024d\u0256\7R\2\2\u024e\u0256\7M\2\2"+
		"\u024f\u0250\7g\2\2\u0250\u0251\5\26\f\2\u0251\u0252\b*\1\2\u0252\u0256"+
		"\3\2\2\2\u0253\u0254\7h\2\2\u0254\u0256\b*\1\2\u0255\u0245\3\2\2\2\u0255"+
		"\u0249\3\2\2\2\u0255\u024a\3\2\2\2\u0255\u024b\3\2\2\2\u0255\u024c\3\2"+
		"\2\2\u0255\u024d\3\2\2\2\u0255\u024e\3\2\2\2\u0255\u024f\3\2\2\2\u0255"+
		"\u0253\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\b*\1\2\u0258S\3\2\2\2\u0259"+
		"\u0260\7\35\2\2\u025a\u025b\7+\2\2\u025b\u0261\5\u0082B\2\u025c\u025d"+
		"\7\"\2\2\u025d\u025e\5r:\2\u025e\u025f\5p9\2\u025f\u0261\3\2\2\2\u0260"+
		"\u025a\3\2\2\2\u0260\u025c\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0263\b+"+
		"\1\2\u0263U\3\2\2\2\u0264\u026b\78\2\2\u0265\u0266\7\"\2\2\u0266\u0267"+
		"\5r:\2\u0267\u0268\5p9\2\u0268\u026c\3\2\2\2\u0269\u026c\79\2\2\u026a"+
		"\u026c\7S\2\2\u026b\u0265\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026a\3\2"+
		"\2\2\u026c\u026d\3\2\2\2\u026d\u026e\b,\1\2\u026eW\3\2\2\2\u026f\u0284"+
		"\7)\2\2\u0270\u0271\7;\2\2\u0271\u0272\7u\2\2\u0272\u0285\b-\1\2\u0273"+
		"\u0274\7W\2\2\u0274\u0285\5\u0080A\2\u0275\u0276\7X\2\2\u0276\u0285\5"+
		"\u0080A\2\u0277\u0278\7Y\2\2\u0278\u0285\7u\2\2\u0279\u027a\7.\2\2\u027a"+
		"\u0285\5\\/\2\u027b\u027c\7[\2\2\u027c\u0285\7s\2\2\u027d\u0285\7o\2\2"+
		"\u027e\u027f\7i\2\2\u027f\u0280\5\30\r\2\u0280\u0281\7q\2\2\u0281\u0282"+
		"\5\26\f\2\u0282\u0283\b-\1\2\u0283\u0285\3\2\2\2\u0284\u0270\3\2\2\2\u0284"+
		"\u0273\3\2\2\2\u0284\u0275\3\2\2\2\u0284\u0277\3\2\2\2\u0284\u0279\3\2"+
		"\2\2\u0284\u027b\3\2\2\2\u0284\u027d\3\2\2\2\u0284\u027e\3\2\2\2\u0285"+
		"Y\3\2\2\2\u0286\u0287\7*\2\2\u0287\u0288\t\7\2\2\u0288[\3\2\2\2\u0289"+
		"\u028a\t\b\2\2\u028a]\3\2\2\2\u028b\u028c\7\67\2\2\u028c\u028d\7s\2\2"+
		"\u028d_\3\2\2\2\u028e\u0290\7U\2\2\u028f\u0291\7s\2\2\u0290\u028f\3\2"+
		"\2\2\u0290\u0291\3\2\2\2\u0291a\3\2\2\2\u0292\u0293\7>\2\2\u0293\u0294"+
		"\t\t\2\2\u0294\u0295\7u\2\2\u0295c\3\2\2\2\u0296\u0297\7?\2\2\u0297\u0298"+
		"\7u\2\2\u0298e\3\2\2\2\u0299\u029a\7@\2\2\u029a\u029b\7u\2\2\u029bg\3"+
		"\2\2\2\u029c\u029d\t\n\2\2\u029di\3\2\2\2\u029e\u029f\7\26\2\2\u029fk"+
		"\3\2\2\2\u02a0\u02a1\t\13\2\2\u02a1m\3\2\2\2\u02a2\u02a3\7r\2\2\u02a3"+
		"o\3\2\2\2\u02a4\u02a5\7r\2\2\u02a5q\3\2\2\2\u02a6\u02a7\7r\2\2\u02a7s"+
		"\3\2\2\2\u02a8\u02a9\7r\2\2\u02a9\u02aa\b;\1\2\u02aau\3\2\2\2\u02ab\u02ac"+
		"\7r\2\2\u02ac\u02ad\b<\1\2\u02adw\3\2\2\2\u02ae\u02b3\7r\2\2\u02af\u02b0"+
		"\7\f\2\2\u02b0\u02b2\7r\2\2\u02b1\u02af\3\2\2\2\u02b2\u02b5\3\2\2\2\u02b3"+
		"\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4y\3\2\2\2\u02b5\u02b3\3\2\2\2"+
		"\u02b6\u02b9\5~@\2\u02b7\u02b9\5|?\2\u02b8\u02b6\3\2\2\2\u02b8\u02b7\3"+
		"\2\2\2\u02b9{\3\2\2\2\u02ba\u02bb\7s\2\2\u02bb}\3\2\2\2\u02bc\u02bd\7"+
		"u\2\2\u02bd\177\3\2\2\2\u02be\u02bf\t\f\2\2\u02bf\u0081\3\2\2\2\u02c0"+
		"\u02c1\7r\2\2\u02c1\u02c2\7\f\2\2\u02c2\u02c3\t\r\2\2\u02c3\u0083\3\2"+
		"\2\2\u02c4\u02c5\7s\2\2\u02c5\u0085\3\2\2\28\u008c\u00a9\u00af\u00b5\u00cc"+
		"\u00cf\u00d9\u00de\u00f1\u00fe\u0109\u010b\u0111\u0118\u0123\u0125\u012b"+
		"\u0136\u0140\u0146\u0149\u014f\u0155\u0161\u016a\u0186\u018c\u0192\u019c"+
		"\u01a3\u01a7\u01ac\u01d6\u01da\u01e2\u01ed\u01f3\u01fb\u01fe\u0204\u0207"+
		"\u0211\u0217\u021f\u0224\u0230\u0247\u0255\u0260\u026b\u0284\u0290\u02b3"+
		"\u02b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}