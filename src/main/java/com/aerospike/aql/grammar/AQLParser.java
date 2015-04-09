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
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		TRUE=25, FALSE=26, CONNECT=27, DISCONNECT=28, DESC=29, INSERT=30, SELECT=31, 
		DELETE=32, CREATE=33, INDEX=34, EXECUTE=35, WHERE=36, SHOW=37, DROP=38, 
		INDEXES=39, VALUES=40, SET=41, GET=42, MODULE=43, ON=44, OPERATE=45, OUTPUT=46, 
		PRIVILEGE=47, PRIVILEGES=48, INTO=49, FUNCTION=50, FROM=51, BY=52, AND=53, 
		BETWEEN=54, RUN=55, STAT=56, QUERY=57, SCAN=58, TIMEOUT=59, QUIT=60, EXIT=61, 
		KILL=62, KILL_QUERY=63, KILL_SCAN=64, PK=65, STRING=66, NUMERIC=67, IN=68, 
		LIST=69, MAPKEYS=70, MAPVALUES=71, REGISTER=72, REMOVE=73, AGGREGATE=74, 
		MODULES=75, NAMESPACES=76, SETS=77, BINS=78, SCANS=79, QUERIES=80, SYSTEM=81, 
		ORDER=82, PRINT=83, UPDATE=84, VERBOSE=85, ECHO=86, TTL=87, USE_SMD=88, 
		LUA_USER_PATH=89, LUA_SYSTEM_PATH=90, ADD=91, PUT=92, APPEND=93, PREPEND=94, 
		TOUCH=95, HEADER=96, LLIST=97, LSTACK=98, LSET=99, LMAP=100, USER=101, 
		USERS=102, PASSWORD=103, ROLE=104, ROLES=105, GRANT=106, REVOKE=107, TO=108, 
		FAIL_ON_CLUSTER_CHANGE=109, REPAIR=110, FOR=111, IDENTIFIER=112, STRINGLITERAL=113, 
		FLOATLITERAL=114, INTLITERAL=115, HEXLITERAL=116, NEWLINE=117, WS=118, 
		COMMENT=119;
	public static final String[] tokenNames = {
		"<INVALID>", "'user-admin'", "'read-write'", "'q'", "'='", "'size'", "'('", 
		"'get_config'", "'generation'", "'*'", "','", "'json'", "'.'", "'find'", 
		"'nosql'", "'get_capacity'", "'destroy'", "'sys-admin'", "'so'", "'read-write-udf'", 
		"'lua'", "'table'", "'help'", "'read'", "')'", "'true'", "'false'", "'connect'", 
		"'disconnect'", "'desc'", "'insert'", "'select'", "'delete'", "'create'", 
		"'index'", "'execute'", "'where'", "'show'", "'drop'", "'indexes'", "'values'", 
		"'set'", "'get'", "'module'", "'on'", "'operate'", "'output'", "'privilege'", 
		"'privileges'", "'into'", "'function'", "'from'", "'by'", "'and'", "'between'", 
		"'run'", "'stat'", "'query'", "'scan'", "'timeout'", "'quit'", "'exit'", 
		"'kill'", "'kill_query'", "'kill_scan'", "'pk'", "'string'", "'numeric'", 
		"'in'", "'list'", "'mapkeys'", "'mapvalues'", "'register'", "'remove'", 
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
		RULE_select = 21, RULE_aggregate = 22, RULE_collectionType = 23, RULE_where = 24, 
		RULE_operateFunction = 25, RULE_nameSet = 26, RULE_register = 27, RULE_execute = 28, 
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
		"aggregate", "collectionType", "where", "operateFunction", "nameSet", 
		"register", "execute", "moduleFunction", "binNameList", "valueList", "predicate", 
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__2) | (1L << CONNECT) | (1L << DISCONNECT) | (1L << DESC) | (1L << INSERT) | (1L << SELECT) | (1L << DELETE) | (1L << CREATE) | (1L << EXECUTE) | (1L << SHOW) | (1L << DROP) | (1L << SET) | (1L << GET) | (1L << OPERATE) | (1L << PRIVILEGE) | (1L << PRIVILEGES) | (1L << RUN) | (1L << STAT) | (1L << QUIT) | (1L << EXIT) | (1L << KILL))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (REGISTER - 72)) | (1L << (REMOVE - 72)) | (1L << (AGGREGATE - 72)) | (1L << (PRINT - 72)) | (1L << (UPDATE - 72)) | (1L << (GRANT - 72)) | (1L << (REVOKE - 72)) | (1L << (REPAIR - 72)))) != 0)) {
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
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public ConnectContext connect() {
			return getRuleContext(ConnectContext.class,0);
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
				setState(141); insert();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); update();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143); delete();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144); select();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(145); execute();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146); operate();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147); aggregate();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148); connect();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(149); disconnect();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(150); create();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(151); drop();
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(152); repair();
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(153); grant();
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(154); revoke();
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(155); remove();
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(156); register();
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
		public RolesContext roles() {
			return getRuleContext(RolesContext.class,0);
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
			setState(215);
			switch (_input.LA(1)) {
			case INDEX:
			case LIST:
			case MAPKEYS:
			case MAPVALUES:
				{
				setState(179);
				_la = _input.LA(1);
				if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LIST - 69)) | (1L << (MAPKEYS - 69)) | (1L << (MAPVALUES - 69)))) != 0)) {
					{
					setState(178);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LIST - 69)) | (1L << (MAPKEYS - 69)) | (1L << (MAPVALUES - 69)))) != 0)) ) {
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
				setState(186); match(T__18);
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
				setState(200);
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
					setState(199); roles();
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
				setState(204); match(ROLE);
				setState(205); role();
				setState(206);
				_la = _input.LA(1);
				if ( !(_la==PRIVILEGE || _la==PRIVILEGES) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__22) | (1L << T__7) | (1L << T__5) | (1L << T__1))) != 0)) {
					{
					{
					setState(207); privilege();
					}
					}
					setState(212);
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
			setState(217); match(DROP);
			setState(234);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(218); match(INDEX);
				setState(219); nameSet();
				setState(220); index_name();
				}
				break;
			case MODULE:
				{
				setState(222); match(MODULE);
				setState(223); moduleName();
				}
				break;
			case SET:
				{
				setState(224); match(SET);
				setState(225); nameSet();
				}
				break;
			case USER:
				{
				setState(226); match(USER);
				setState(227); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
				}
				break;
			case ROLE:
				{
				setState(230); match(ROLE);
				setState(231); role();
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
			setState(236); match(REPAIR);
			setState(237); match(INDEX);
			setState(238); index_name();
			setState(239); match(ON);
			setState(240); nameSet();
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
			setState(266);
			switch (_input.LA(1)) {
			case GRANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(242); match(GRANT);
				setState(247);
				switch (_input.LA(1)) {
				case ROLES:
					{
					setState(243); match(ROLES);
					setState(244); roles();
					}
					break;
				case ROLE:
					{
					setState(245); match(ROLE);
					setState(246); role();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(249); match(TO);
				setState(250); user();
				}
				break;
			case PRIVILEGE:
			case PRIVILEGES:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				switch (_input.LA(1)) {
				case PRIVILEGE:
					{
					setState(252); match(PRIVILEGE);
					setState(253); privilege();
					}
					break;
				case PRIVILEGES:
					{
					setState(254); match(PRIVILEGES);
					setState(256); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(255); privilege();
						}
						}
						setState(258); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__22) | (1L << T__7) | (1L << T__5) | (1L << T__1))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(262); match(TO);
				setState(263); role();
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
			setState(292);
			switch (_input.LA(1)) {
			case REVOKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(268); match(REVOKE);
				setState(273);
				switch (_input.LA(1)) {
				case ROLES:
					{
					setState(269); match(ROLES);
					setState(270); roles();
					}
					break;
				case ROLE:
					{
					setState(271); match(ROLE);
					setState(272); role();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(275); match(FROM);
				setState(276); user();
				}
				break;
			case PRIVILEGE:
			case PRIVILEGES:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				switch (_input.LA(1)) {
				case PRIVILEGE:
					{
					setState(278); match(PRIVILEGE);
					setState(279); privilege();
					}
					break;
				case PRIVILEGES:
					{
					setState(280); match(PRIVILEGES);
					setState(282); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(281); privilege();
						}
						}
						setState(284); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__22) | (1L << T__7) | (1L << T__5) | (1L << T__1))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(288); match(FROM);
				setState(289); role();
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
			setState(294); match(IDENTIFIER);
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
			setState(296); match(IDENTIFIER);
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
			setState(298); role();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(299); match(T__14);
				setState(300); role();
				}
				}
				setState(305);
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
		public PrivilegeContext privilege() {
			return getRuleContext(PrivilegeContext.class,0);
		}
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
			setState(308);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(306); match(IDENTIFIER);
				}
				break;
			case T__23:
			case T__22:
			case T__7:
			case T__5:
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(307); privilege();
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
			setState(336);
			switch (_input.LA(1)) {
			case T__22:
			case T__5:
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(310); match(T__1);

								_localctx.priv.code = PrivilegeCode.READ;
							
					}
					break;
				case T__22:
					{
					setState(312); match(T__22);
					setState(315);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						setState(313); match(T__12);
						setState(314); ((PrivilegeContext)_localctx).nameSet = nameSet();
						}
						break;
					}

								_localctx.priv.code = PrivilegeCode.READ_WRITE;
							
					}
					break;
				case T__5:
					{
					setState(318); match(T__5);
					setState(321);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(319); match(T__12);
						setState(320); ((PrivilegeContext)_localctx).nameSet = nameSet();
						}
						break;
					}

								_localctx.priv.code = PrivilegeCode.READ_WRITE_UDF;
							
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(330);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(326); match(T__12);
					setState(327); ((PrivilegeContext)_localctx).nameSet = nameSet();

								_localctx.priv.namespace = ((PrivilegeContext)_localctx).nameSet.namespaceName;
								_localctx.priv.setName = ((PrivilegeContext)_localctx).nameSet.setName;
							
					}
				}

				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(332); match(T__7);

							_localctx.priv.code = PrivilegeCode.READ_WRITE_UDF;
						
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(334); match(T__23);

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
			setState(338); match(REMOVE);
			setState(339); match(MODULE);
			setState(340); moduleName();
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
			setState(342); match(OPERATE);
			setState(343); operateFunction();
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(344); match(T__14);
				setState(345); operateFunction();
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(351); match(ON);
			setState(352); nameSet();
			setState(353); match(WHERE);
			setState(354); primaryKeyPredicate();
			setState(357);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(355); match(AND);
				setState(356); generationPredicate();
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
			setState(361); match(INSERT);
			setState(362); match(INTO);
			setState(363); nameSet();
			setState(364); match(T__18);
			setState(365); match(PK);
			setState(366); match(T__14);
			setState(367); binNameList();
			setState(368); match(T__0);
			setState(369); match(VALUES);
			setState(370); match(T__18);
			setState(371); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
			setState(372); match(T__14);
			setState(373); valueList();
			setState(374); match(T__0);

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
			setState(377); match(UPDATE);
			setState(378); nameSet();
			setState(381);
			_la = _input.LA(1);
			if (_la==SET) {
				{
				setState(379); match(SET);
				setState(380); updateList();
				}
			}

			setState(383); match(WHERE);
			setState(384); primaryKeyPredicate();
			setState(387);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(385); match(AND);
				setState(386); generationPredicate();
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
			setState(393);
			switch (_input.LA(1)) {
			case TTL:
				{
				setState(391); ttlValue();
				}
				break;
			case IDENTIFIER:
				{
				setState(392); binValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(395); match(T__14);
				setState(396); binValue();
				}
				}
				setState(401);
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
			setState(402); match(DELETE);
			setState(403); match(FROM);
			setState(404); nameSet();
			setState(411);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(405); match(WHERE);
				setState(406); primaryKeyPredicate();
				setState(409);
				_la = _input.LA(1);
				if (_la==AND) {
					{
					setState(407); match(AND);
					setState(408); generationPredicate();
					}
				}

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
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public BinNameListContext binNameList() {
			return getRuleContext(BinNameListContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public TerminalNode FROM() { return getToken(AQLParser.FROM, 0); }
		public TerminalNode SELECT() { return getToken(AQLParser.SELECT, 0); }
		public ModuleFunctionContext moduleFunction() {
			return getRuleContext(ModuleFunctionContext.class,0);
		}
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
			setState(415); match(SELECT);
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(416); match(T__15);

					definitions.add(VariableDefinition.RECORD);
					
				}
				break;

			case 2:
				{
				setState(418); binNameList();

					definitions.add(VariableDefinition.RECORD);
					
				}
				break;

			case 3:
				{
				setState(421); moduleFunction();
				setState(427);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(422); match(T__18);
					setState(424);
					_la = _input.LA(1);
					if (_la==STRINGLITERAL || _la==INTLITERAL) {
						{
						setState(423); valueList();
						}
					}

					setState(426); match(T__0);
					}
				}


					definitions.add(VariableDefinition.RESULT_SET);
					
				}
				break;
			}
			setState(435);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(433); match(IN);
				setState(434); collectionType();
				}
			}

			setState(437); match(FROM);
			setState(438); nameSet();
			setState(440);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(439); where();
				}
			}


				definitions.add(VariableDefinition.QUERY_POLICY);
				definitions.add(VariableDefinition.READ_POLICY);
				definitions.add(VariableDefinition.SCAN_POLICY);
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
		enterRule(_localctx, 44, RULE_aggregate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444); match(AGGREGATE);
			setState(445); moduleFunction();
			setState(451);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(446); match(T__18);
				setState(448);
				_la = _input.LA(1);
				if (_la==STRINGLITERAL || _la==INTLITERAL) {
					{
					setState(447); valueList();
					}
				}

				setState(450); match(T__0);
				}
			}

			setState(453); match(ON);
			setState(454); nameSet();
			setState(457);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(455); match(IN);
				setState(456); collectionType();
				}
			}

			setState(460);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(459); where();
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
		enterRule(_localctx, 46, RULE_collectionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (LIST - 69)) | (1L << (MAPKEYS - 69)) | (1L << (MAPVALUES - 69)))) != 0)) ) {
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
		enterRule(_localctx, 48, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); match(WHERE);
			setState(467); predicate();
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
		enterRule(_localctx, 50, RULE_operateFunction);
		int _la;
		try {
			setState(506);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(469); match(ADD);
				setState(470); match(T__18);
				setState(471); bin();
				setState(472); match(T__14);
				setState(473); value();
				setState(474); match(T__0);
				}
				break;
			case PUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(476); match(PUT);
				setState(477); match(T__18);
				setState(478); bin();
				setState(479); match(T__14);
				setState(480); value();
				setState(481); match(T__0);
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 3);
				{
				setState(483); match(APPEND);
				setState(484); match(T__18);
				setState(485); bin();
				setState(486); match(T__14);
				setState(487); value();
				setState(488); match(T__0);
				}
				break;
			case PREPEND:
				enterOuterAlt(_localctx, 4);
				{
				setState(490); match(PREPEND);
				setState(491); match(T__18);
				setState(492); bin();
				setState(493); match(T__14);
				setState(494); value();
				setState(495); match(T__0);
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 5);
				{
				setState(497); match(GET);
				setState(502);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(498); match(T__18);
					setState(499); bin();
					setState(500); match(T__0);
					}
				}

				}
				break;
			case TOUCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(504); match(TOUCH);
				}
				break;
			case HEADER:
				enterOuterAlt(_localctx, 7);
				{
				setState(505); match(HEADER);
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
		enterRule(_localctx, 52, RULE_nameSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508); ((NameSetContext)_localctx).namespace_name = namespace_name();
			((NameSetContext)_localctx).namespaceName =  (((NameSetContext)_localctx).namespace_name!=null?_input.getText(((NameSetContext)_localctx).namespace_name.start,((NameSetContext)_localctx).namespace_name.stop):null);
			setState(514);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(510); match(T__12);
				setState(511); ((NameSetContext)_localctx).set_name = set_name();
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
		enterRule(_localctx, 54, RULE_register);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516); match(REGISTER);
			setState(517); match(MODULE);
			setState(518); ((RegisterContext)_localctx).filepath = filePath();

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
		enterRule(_localctx, 56, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521); match(EXECUTE);
			setState(522); moduleFunction();
			setState(523); match(T__18);
			setState(525);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL || _la==INTLITERAL) {
				{
				setState(524); valueList();
				}
			}

			setState(527); match(T__0);
			setState(528); match(ON);
			setState(529); nameSet();
			setState(531);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(530); where();
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
			setState(535);
			((ModuleFunctionContext)_localctx).packageName = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (LLIST - 97)) | (1L << (LMAP - 97)) | (1L << (IDENTIFIER - 97)))) != 0)) ) {
				((ModuleFunctionContext)_localctx).packageName = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(536); match(T__12);
			setState(537);
			((ModuleFunctionContext)_localctx).functionName = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__17) | (1L << T__11) | (1L << T__9) | (1L << T__8) | (1L << GET) | (1L << SCAN))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (REMOVE - 73)) | (1L << (ADD - 73)) | (1L << (PUT - 73)) | (1L << (IDENTIFIER - 73)))) != 0)) ) {
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
			setState(541);
			switch (_input.LA(1)) {
			case TTL:
				{
				setState(539); match(TTL);
				}
				break;
			case IDENTIFIER:
				{
				setState(540); bin();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(543); match(T__14);
				setState(544); bin();
				}
				}
				setState(549);
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
			setState(550); value();
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(551); match(T__14);
				setState(552); value();
				}
				}
				setState(557);
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
			setState(560);
			switch (_input.LA(1)) {
			case PK:
				{
				setState(558); primaryKeyPredicate();
				}
				break;
			case IDENTIFIER:
				{
				setState(559); filterPredicate();
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
			setState(562); match(PK);
			setState(563); match(T__20);
			setState(564); primaryKey(((StatementContext)getInvokingContext(2)).nameSpace, ((StatementContext)getInvokingContext(2)).setName);
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
			setState(566); match(T__16);
			setState(567); match(T__20);
			setState(568); match(INTLITERAL);
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
			setState(572);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(570); equalityFilter();
				}
				break;

			case 2:
				{
				setState(571); rangeFilter();
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
			setState(576); binValue();
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
			setState(578); match(TTL);
			setState(579); match(T__20);
			setState(580); integerValue();
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
			setState(582); bin();
			setState(583); match(T__20);
			setState(584); value();
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
			setState(586); bin();
			setState(587); match(BETWEEN);
			setState(588); ((RangeFilterContext)_localctx).low = integerValue();
			setState(589); match(AND);
			setState(590); ((RangeFilterContext)_localctx).high = integerValue();
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
		public Namespace_nameContext namespace_name() {
			return getRuleContext(Namespace_nameContext.class,0);
		}
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
			setState(592); match(SHOW);
			setState(609);
			switch (_input.LA(1)) {
			case INDEXES:
				{
				setState(593); match(INDEXES);
				setState(595);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(594); namespace_name();
					}
				}

				}
				break;
			case SCANS:
				{
				setState(597); match(SCANS);
				}
				break;
			case NAMESPACES:
				{
				setState(598); match(NAMESPACES);
				}
				break;
			case SETS:
				{
				setState(599); match(SETS);
				}
				break;
			case BINS:
				{
				setState(600); match(BINS);
				}
				break;
			case QUERIES:
				{
				setState(601); match(QUERIES);
				}
				break;
			case MODULES:
				{
				setState(602); match(MODULES);
				}
				break;
			case USER:
				{
				setState(603); match(USER);
				setState(604); user();
				definitions.add(VariableDefinition.ADMIN_POLICY);
				}
				break;
			case USERS:
				{
				setState(607); match(USERS);
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
		public ModuleNameContext moduleName() {
			return getRuleContext(ModuleNameContext.class,0);
		}
		public TerminalNode DESC() { return getToken(AQLParser.DESC, 0); }
		public TerminalNode MODULE() { return getToken(AQLParser.MODULE, 0); }
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
			setState(613); match(DESC);
			setState(614); match(MODULE);
			setState(615); moduleName();

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
			setState(618); match(STAT);
			setState(625);
			switch (_input.LA(1)) {
			case INDEX:
				{
				setState(619); match(INDEX);
				setState(620); namespace_name();
				setState(621); index_name();
				}
				break;
			case QUERY:
				{
				setState(623); match(QUERY);
				}
				break;
			case SYSTEM:
				{
				setState(624); match(SYSTEM);
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
			setState(629); match(SET);
			setState(650);
			switch (_input.LA(1)) {
			case TIMEOUT:
				{
				setState(630); match(TIMEOUT);
				setState(631); ((SetContext)_localctx).timeOut = match(INTLITERAL);
				definitions.add(VariableDefinition.READ_POLICY);definitions.add(VariableDefinition.WRITE_POLICY);
				}
				break;
			case VERBOSE:
				{
				setState(633); match(VERBOSE);
				setState(634); ((SetContext)_localctx).verboseOn = booleanLiteral();
				}
				break;
			case ECHO:
				{
				setState(635); match(ECHO);
				setState(636); ((SetContext)_localctx).echoOn = booleanLiteral();
				}
				break;
			case TTL:
				{
				setState(637); match(TTL);
				setState(638); ((SetContext)_localctx).ttl = match(INTLITERAL);
				}
				break;
			case OUTPUT:
				{
				setState(639); match(OUTPUT);
				setState(640); viewType();
				}
				break;
			case LUA_USER_PATH:
				{
				setState(641); match(LUA_USER_PATH);
				setState(642); ((SetContext)_localctx).luaUserPath = match(STRINGLITERAL);
				}
				break;
			case FAIL_ON_CLUSTER_CHANGE:
				{
				setState(643); match(FAIL_ON_CLUSTER_CHANGE);
				}
				break;
			case PASSWORD:
				{
				setState(644); match(PASSWORD);
				setState(645); password();
				setState(646); match(FOR);
				setState(647); user();
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
			setState(652); match(GET);
			setState(653);
			_la = _input.LA(1);
			if ( !(((((_la - 46)) & ~0x3f) == 0 && ((1L << (_la - 46)) & ((1L << (OUTPUT - 46)) | (1L << (TIMEOUT - 46)) | (1L << (VERBOSE - 46)) | (1L << (ECHO - 46)) | (1L << (TTL - 46)) | (1L << (LUA_USER_PATH - 46)) | (1L << (FAIL_ON_CLUSTER_CHANGE - 46)))) != 0)) ) {
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
			setState(655);
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
			setState(657); match(RUN);
			setState(658); match(STRINGLITERAL);
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
			setState(660); match(PRINT);
			setState(662);
			_la = _input.LA(1);
			if (_la==STRINGLITERAL) {
				{
				setState(661); match(STRINGLITERAL);
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
			setState(664); match(KILL);
			setState(665);
			_la = _input.LA(1);
			if ( !(_la==QUERY || _la==SCAN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(666); match(INTLITERAL);
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
			setState(668); match(KILL_QUERY);
			setState(669); match(INTLITERAL);
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
			setState(671); match(KILL_SCAN);
			setState(672); match(INTLITERAL);
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
			setState(674);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << QUIT) | (1L << EXIT))) != 0)) ) {
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
			setState(676); match(T__2);
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
			setState(678);
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
			setState(680); match(IDENTIFIER);
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
			setState(682); match(IDENTIFIER);
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
			setState(684); match(IDENTIFIER);
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
			setState(686); ((Set_nameContext)_localctx).setName = match(IDENTIFIER);

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
			setState(689); ((BinContext)_localctx).binName = match(IDENTIFIER);

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
			setState(692); ((DotPathContext)_localctx).path = match(IDENTIFIER);
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(693); match(T__12);
				setState(694); ((DotPathContext)_localctx).path = match(IDENTIFIER);
				}
				}
				setState(699);
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
			setState(702);
			switch (_input.LA(1)) {
			case INTLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(700); integerValue();
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(701); textValue();
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
			setState(704); match(STRINGLITERAL);
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
			setState(706); match(INTLITERAL);
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
			setState(708);
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
			setState(710); match(IDENTIFIER);
			setState(711); match(T__12);
			setState(712);
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
			setState(714); match(STRINGLITERAL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3y\u02cf\4\2\t\2\4"+
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
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00cb"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00d3\n\7\f\7\16\7\u00d6\13\7\3\7\3\7"+
		"\5\7\u00da\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00ed\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00fa\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u0103\n\n\r\n\16\n\u0104"+
		"\5\n\u0107\n\n\3\n\3\n\3\n\3\n\5\n\u010d\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0114\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u011d\n\13\r"+
		"\13\16\13\u011e\5\13\u0121\n\13\3\13\3\13\3\13\3\13\5\13\u0127\n\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u0130\n\16\f\16\16\16\u0133\13\16\3"+
		"\17\3\17\5\17\u0137\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u013e\n\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0144\n\20\3\20\5\20\u0147\n\20\3\20\3\20\3\20\3"+
		"\20\5\20\u014d\n\20\3\20\3\20\3\20\3\20\5\20\u0153\n\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\7\22\u015d\n\22\f\22\16\22\u0160\13\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0168\n\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\5\24\u0180\n\24\3\24\3\24\3\24\3\24\5\24\u0186\n\24\3\24\3"+
		"\24\3\25\3\25\5\25\u018c\n\25\3\25\3\25\7\25\u0190\n\25\f\25\16\25\u0193"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u019c\n\26\5\26\u019e\n"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01ab"+
		"\n\27\3\27\5\27\u01ae\n\27\3\27\3\27\5\27\u01b2\n\27\3\27\3\27\5\27\u01b6"+
		"\n\27\3\27\3\27\3\27\5\27\u01bb\n\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30"+
		"\u01c3\n\30\3\30\5\30\u01c6\n\30\3\30\3\30\3\30\3\30\5\30\u01cc\n\30\3"+
		"\30\5\30\u01cf\n\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u01f9\n\33\3\33\3\33\5\33\u01fd\n\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\5\34\u0205\n\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\5\36\u0210\n\36\3\36\3\36\3\36\3\36\5\36\u0216\n\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3 \3 \5 \u0220\n \3 \3 \7 \u0224\n \f \16 \u0227\13"+
		" \3!\3!\3!\7!\u022c\n!\f!\16!\u022f\13!\3\"\3\"\5\"\u0233\n\"\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3%\3%\5%\u023f\n%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\5*\u0256\n*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\5*\u0264\n*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\5,\u0274"+
		"\n,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\5-\u028d\n-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\5\61\u0299\n\61"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\7=\u02ba\n=\f"+
		"=\16=\u02bd\13=\3>\3>\5>\u02c1\n>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3B\3C\3C"+
		"\3C\2\2D\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\2\16\3\2GI\3\2"+
		"DE\3\2\61\62\5\2ccffrr\13\2\7\7\t\t\17\17\21\22,,<<KK]^rr\7\2\60\60=="+
		"WY[[oo\5\2\r\r\20\20\26\27\3\2;<\4\2\5\5>?\4\2ssuu\3\2\33\34\4\2\24\24"+
		"\26\26\u02f7\2\u0086\3\2\2\2\4\u008c\3\2\2\2\6\u00a9\3\2\2\2\b\u00ab\3"+
		"\2\2\2\n\u00b1\3\2\2\2\f\u00b3\3\2\2\2\16\u00db\3\2\2\2\20\u00ee\3\2\2"+
		"\2\22\u010c\3\2\2\2\24\u0126\3\2\2\2\26\u0128\3\2\2\2\30\u012a\3\2\2\2"+
		"\32\u012c\3\2\2\2\34\u0136\3\2\2\2\36\u0152\3\2\2\2 \u0154\3\2\2\2\"\u0158"+
		"\3\2\2\2$\u016b\3\2\2\2&\u017b\3\2\2\2(\u018b\3\2\2\2*\u0194\3\2\2\2,"+
		"\u01a1\3\2\2\2.\u01be\3\2\2\2\60\u01d2\3\2\2\2\62\u01d4\3\2\2\2\64\u01fc"+
		"\3\2\2\2\66\u01fe\3\2\2\28\u0206\3\2\2\2:\u020b\3\2\2\2<\u0219\3\2\2\2"+
		">\u021f\3\2\2\2@\u0228\3\2\2\2B\u0232\3\2\2\2D\u0234\3\2\2\2F\u0238\3"+
		"\2\2\2H\u023e\3\2\2\2J\u0242\3\2\2\2L\u0244\3\2\2\2N\u0248\3\2\2\2P\u024c"+
		"\3\2\2\2R\u0252\3\2\2\2T\u0267\3\2\2\2V\u026c\3\2\2\2X\u0277\3\2\2\2Z"+
		"\u028e\3\2\2\2\\\u0291\3\2\2\2^\u0293\3\2\2\2`\u0296\3\2\2\2b\u029a\3"+
		"\2\2\2d\u029e\3\2\2\2f\u02a1\3\2\2\2h\u02a4\3\2\2\2j\u02a6\3\2\2\2l\u02a8"+
		"\3\2\2\2n\u02aa\3\2\2\2p\u02ac\3\2\2\2r\u02ae\3\2\2\2t\u02b0\3\2\2\2v"+
		"\u02b3\3\2\2\2x\u02b6\3\2\2\2z\u02c0\3\2\2\2|\u02c2\3\2\2\2~\u02c4\3\2"+
		"\2\2\u0080\u02c6\3\2\2\2\u0082\u02c8\3\2\2\2\u0084\u02cc\3\2\2\2\u0086"+
		"\u0087\5\4\3\2\u0087\u0088\7\2\2\3\u0088\3\3\2\2\2\u0089\u008b\5\6\4\2"+
		"\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\5\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u00aa\5$\23\2\u0090"+
		"\u00aa\5&\24\2\u0091\u00aa\5*\26\2\u0092\u00aa\5,\27\2\u0093\u00aa\5:"+
		"\36\2\u0094\u00aa\5\"\22\2\u0095\u00aa\5.\30\2\u0096\u00aa\5\b\5\2\u0097"+
		"\u00aa\5\n\6\2\u0098\u00aa\5\f\7\2\u0099\u00aa\5\16\b\2\u009a\u00aa\5"+
		"\20\t\2\u009b\u00aa\5\22\n\2\u009c\u00aa\5\24\13\2\u009d\u00aa\5 \21\2"+
		"\u009e\u00aa\58\35\2\u009f\u00aa\5R*\2\u00a0\u00aa\5T+\2\u00a1\u00aa\5"+
		"V,\2\u00a2\u00aa\5X-\2\u00a3\u00aa\5Z.\2\u00a4\u00aa\5^\60\2\u00a5\u00aa"+
		"\5b\62\2\u00a6\u00aa\5h\65\2\u00a7\u00aa\5j\66\2\u00a8\u00aa\5`\61\2\u00a9"+
		"\u008f\3\2\2\2\u00a9\u0090\3\2\2\2\u00a9\u0091\3\2\2\2\u00a9\u0092\3\2"+
		"\2\2\u00a9\u0093\3\2\2\2\u00a9\u0094\3\2\2\2\u00a9\u0095\3\2\2\2\u00a9"+
		"\u0096\3\2\2\2\u00a9\u0097\3\2\2\2\u00a9\u0098\3\2\2\2\u00a9\u0099\3\2"+
		"\2\2\u00a9\u009a\3\2\2\2\u00a9\u009b\3\2\2\2\u00a9\u009c\3\2\2\2\u00a9"+
		"\u009d\3\2\2\2\u00a9\u009e\3\2\2\2\u00a9\u009f\3\2\2\2\u00a9\u00a0\3\2"+
		"\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a2\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9"+
		"\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00a8\3\2\2\2\u00aa\7\3\2\2\2\u00ab\u00ac\7\35\2\2\u00ac\u00ad"+
		"\7s\2\2\u00ad\u00af\7u\2\2\u00ae\u00b0\7u\2\2\u00af\u00ae\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\t\3\2\2\2\u00b1\u00b2\7\36\2\2\u00b2\13\3\2\2\2\u00b3"+
		"\u00d9\7#\2\2\u00b4\u00b6\t\2\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\5p9\2\u00b9\u00ba"+
		"\7.\2\2\u00ba\u00bb\5\66\34\2\u00bb\u00bc\b\7\1\2\u00bc\u00bd\7\b\2\2"+
		"\u00bd\u00be\5v<\2\u00be\u00bf\7\32\2\2\u00bf\u00c0\t\3\2\2\u00c0\u00c1"+
		"\b\7\1\2\u00c1\u00da\3\2\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\5\26\f\2\u00c4"+
		"\u00c5\7i\2\2\u00c5\u00ca\5\30\r\2\u00c6\u00c7\7j\2\2\u00c7\u00cb\5\34"+
		"\17\2\u00c8\u00c9\7k\2\2\u00c9\u00cb\5\32\16\2\u00ca\u00c6\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\7\1\2\u00cd\u00da\3\2"+
		"\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\5\34\17\2\u00d0\u00d4\t\4\2\2\u00d1"+
		"\u00d3\5\36\20\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3"+
		"\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d8\b\7\1\2\u00d8\u00da\3\2\2\2\u00d9\u00b5\3\2\2\2\u00d9\u00c2\3\2"+
		"\2\2\u00d9\u00ce\3\2\2\2\u00da\r\3\2\2\2\u00db\u00ec\7(\2\2\u00dc\u00dd"+
		"\7$\2\2\u00dd\u00de\5\66\34\2\u00de\u00df\5p9\2\u00df\u00ed\3\2\2\2\u00e0"+
		"\u00e1\7-\2\2\u00e1\u00ed\5\u0082B\2\u00e2\u00e3\7+\2\2\u00e3\u00ed\5"+
		"\66\34\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\5\26\f\2\u00e6\u00e7\b\b\1\2\u00e7"+
		"\u00ed\3\2\2\2\u00e8\u00e9\7j\2\2\u00e9\u00ea\5\34\17\2\u00ea\u00eb\b"+
		"\b\1\2\u00eb\u00ed\3\2\2\2\u00ec\u00dc\3\2\2\2\u00ec\u00e0\3\2\2\2\u00ec"+
		"\u00e2\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ed\17\3\2\2"+
		"\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7$\2\2\u00f0\u00f1\5p9\2\u00f1\u00f2"+
		"\7.\2\2\u00f2\u00f3\5\66\34\2\u00f3\21\3\2\2\2\u00f4\u00f9\7l\2\2\u00f5"+
		"\u00f6\7k\2\2\u00f6\u00fa\5\32\16\2\u00f7\u00f8\7j\2\2\u00f8\u00fa\5\34"+
		"\17\2\u00f9\u00f5\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fc\7n\2\2\u00fc\u00fd\5\26\f\2\u00fd\u010d\3\2\2\2\u00fe\u00ff\7\61"+
		"\2\2\u00ff\u0107\5\36\20\2\u0100\u0102\7\62\2\2\u0101\u0103\5\36\20\2"+
		"\u0102\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u00fe\3\2\2\2\u0106\u0100\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\7n\2\2\u0109\u010a\5\34\17\2\u010a\u010b\b"+
		"\n\1\2\u010b\u010d\3\2\2\2\u010c\u00f4\3\2\2\2\u010c\u0106\3\2\2\2\u010d"+
		"\23\3\2\2\2\u010e\u0113\7m\2\2\u010f\u0110\7k\2\2\u0110\u0114\5\32\16"+
		"\2\u0111\u0112\7j\2\2\u0112\u0114\5\34\17\2\u0113\u010f\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7\65\2\2\u0116\u0117\5"+
		"\26\f\2\u0117\u0127\3\2\2\2\u0118\u0119\7\61\2\2\u0119\u0121\5\36\20\2"+
		"\u011a\u011c\7\62\2\2\u011b\u011d\5\36\20\2\u011c\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2"+
		"\2\2\u0120\u0118\3\2\2\2\u0120\u011a\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\7\65\2\2\u0123\u0124\5\34\17\2\u0124\u0125\b\13\1\2\u0125\u0127"+
		"\3\2\2\2\u0126\u010e\3\2\2\2\u0126\u0120\3\2\2\2\u0127\25\3\2\2\2\u0128"+
		"\u0129\7r\2\2\u0129\27\3\2\2\2\u012a\u012b\7r\2\2\u012b\31\3\2\2\2\u012c"+
		"\u0131\5\34\17\2\u012d\u012e\7\f\2\2\u012e\u0130\5\34\17\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\33\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0137\7r\2\2\u0135\u0137\5\36\20"+
		"\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137\35\3\2\2\2\u0138\u0139"+
		"\7\31\2\2\u0139\u0147\b\20\1\2\u013a\u013d\7\4\2\2\u013b\u013c\7\16\2"+
		"\2\u013c\u013e\5\66\34\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0147\b\20\1\2\u0140\u0143\7\25\2\2\u0141\u0142\7"+
		"\16\2\2\u0142\u0144\5\66\34\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2"+
		"\u0144\u0145\3\2\2\2\u0145\u0147\b\20\1\2\u0146\u0138\3\2\2\2\u0146\u013a"+
		"\3\2\2\2\u0146\u0140\3\2\2\2\u0147\u014c\3\2\2\2\u0148\u0149\7\16\2\2"+
		"\u0149\u014a\5\66\34\2\u014a\u014b\b\20\1\2\u014b\u014d\3\2\2\2\u014c"+
		"\u0148\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0153\3\2\2\2\u014e\u014f\7\23"+
		"\2\2\u014f\u0153\b\20\1\2\u0150\u0151\7\3\2\2\u0151\u0153\b\20\1\2\u0152"+
		"\u0146\3\2\2\2\u0152\u014e\3\2\2\2\u0152\u0150\3\2\2\2\u0153\37\3\2\2"+
		"\2\u0154\u0155\7K\2\2\u0155\u0156\7-\2\2\u0156\u0157\5\u0082B\2\u0157"+
		"!\3\2\2\2\u0158\u0159\7/\2\2\u0159\u015e\5\64\33\2\u015a\u015b\7\f\2\2"+
		"\u015b\u015d\5\64\33\2\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161"+
		"\u0162\7.\2\2\u0162\u0163\5\66\34\2\u0163\u0164\7&\2\2\u0164\u0167\5D"+
		"#\2\u0165\u0166\7\67\2\2\u0166\u0168\5F$\2\u0167\u0165\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\b\22\1\2\u016a#\3\2\2\2\u016b"+
		"\u016c\7 \2\2\u016c\u016d\7\63\2\2\u016d\u016e\5\66\34\2\u016e\u016f\7"+
		"\b\2\2\u016f\u0170\7C\2\2\u0170\u0171\7\f\2\2\u0171\u0172\5> \2\u0172"+
		"\u0173\7\32\2\2\u0173\u0174\7*\2\2\u0174\u0175\7\b\2\2\u0175\u0176\5l"+
		"\67\2\u0176\u0177\7\f\2\2\u0177\u0178\5@!\2\u0178\u0179\7\32\2\2\u0179"+
		"\u017a\b\23\1\2\u017a%\3\2\2\2\u017b\u017c\7V\2\2\u017c\u017f\5\66\34"+
		"\2\u017d\u017e\7+\2\2\u017e\u0180\5(\25\2\u017f\u017d\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\7&\2\2\u0182\u0185\5D#\2\u0183"+
		"\u0184\7\67\2\2\u0184\u0186\5F$\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u0187\u0188\b\24\1\2\u0188\'\3\2\2\2\u0189\u018c"+
		"\5L\'\2\u018a\u018c\5N(\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c"+
		"\u0191\3\2\2\2\u018d\u018e\7\f\2\2\u018e\u0190\5N(\2\u018f\u018d\3\2\2"+
		"\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192)"+
		"\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\7\"\2\2\u0195\u0196\7\65\2\2"+
		"\u0196\u019d\5\66\34\2\u0197\u0198\7&\2\2\u0198\u019b\5D#\2\u0199\u019a"+
		"\7\67\2\2\u019a\u019c\5F$\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019e\3\2\2\2\u019d\u0197\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2"+
		"\2\2\u019f\u01a0\b\26\1\2\u01a0+\3\2\2\2\u01a1\u01b1\7!\2\2\u01a2\u01a3"+
		"\7\13\2\2\u01a3\u01b2\b\27\1\2\u01a4\u01a5\5> \2\u01a5\u01a6\b\27\1\2"+
		"\u01a6\u01b2\3\2\2\2\u01a7\u01ad\5<\37\2\u01a8\u01aa\7\b\2\2\u01a9\u01ab"+
		"\5@!\2\u01aa\u01a9\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac"+
		"\u01ae\7\32\2\2\u01ad\u01a8\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3"+
		"\2\2\2\u01af\u01b0\b\27\1\2\u01b0\u01b2\3\2\2\2\u01b1\u01a2\3\2\2\2\u01b1"+
		"\u01a4\3\2\2\2\u01b1\u01a7\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b4\7F"+
		"\2\2\u01b4\u01b6\5\60\31\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b8\7\65\2\2\u01b8\u01ba\5\66\34\2\u01b9\u01bb"+
		"\5\62\32\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2"+
		"\u01bc\u01bd\b\27\1\2\u01bd-\3\2\2\2\u01be\u01bf\7L\2\2\u01bf\u01c5\5"+
		"<\37\2\u01c0\u01c2\7\b\2\2\u01c1\u01c3\5@!\2\u01c2\u01c1\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\7\32\2\2\u01c5\u01c0\3"+
		"\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\7.\2\2\u01c8"+
		"\u01cb\5\66\34\2\u01c9\u01ca\7F\2\2\u01ca\u01cc\5\60\31\2\u01cb\u01c9"+
		"\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ce\3\2\2\2\u01cd\u01cf\5\62\32\2"+
		"\u01ce\u01cd\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1"+
		"\b\30\1\2\u01d1/\3\2\2\2\u01d2\u01d3\t\2\2\2\u01d3\61\3\2\2\2\u01d4\u01d5"+
		"\7&\2\2\u01d5\u01d6\5B\"\2\u01d6\63\3\2\2\2\u01d7\u01d8\7]\2\2\u01d8\u01d9"+
		"\7\b\2\2\u01d9\u01da\5v<\2\u01da\u01db\7\f\2\2\u01db\u01dc\5z>\2\u01dc"+
		"\u01dd\7\32\2\2\u01dd\u01fd\3\2\2\2\u01de\u01df\7^\2\2\u01df\u01e0\7\b"+
		"\2\2\u01e0\u01e1\5v<\2\u01e1\u01e2\7\f\2\2\u01e2\u01e3\5z>\2\u01e3\u01e4"+
		"\7\32\2\2\u01e4\u01fd\3\2\2\2\u01e5\u01e6\7_\2\2\u01e6\u01e7\7\b\2\2\u01e7"+
		"\u01e8\5v<\2\u01e8\u01e9\7\f\2\2\u01e9\u01ea\5z>\2\u01ea\u01eb\7\32\2"+
		"\2\u01eb\u01fd\3\2\2\2\u01ec\u01ed\7`\2\2\u01ed\u01ee\7\b\2\2\u01ee\u01ef"+
		"\5v<\2\u01ef\u01f0\7\f\2\2\u01f0\u01f1\5z>\2\u01f1\u01f2\7\32\2\2\u01f2"+
		"\u01fd\3\2\2\2\u01f3\u01f8\7,\2\2\u01f4\u01f5\7\b\2\2\u01f5\u01f6\5v<"+
		"\2\u01f6\u01f7\7\32\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f4\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fd\3\2\2\2\u01fa\u01fd\7a\2\2\u01fb\u01fd\7b\2"+
		"\2\u01fc\u01d7\3\2\2\2\u01fc\u01de\3\2\2\2\u01fc\u01e5\3\2\2\2\u01fc\u01ec"+
		"\3\2\2\2\u01fc\u01f3\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fb\3\2\2\2\u01fd"+
		"\65\3\2\2\2\u01fe\u01ff\5r:\2\u01ff\u0204\b\34\1\2\u0200\u0201\7\16\2"+
		"\2\u0201\u0202\5t;\2\u0202\u0203\b\34\1\2\u0203\u0205\3\2\2\2\u0204\u0200"+
		"\3\2\2\2\u0204\u0205\3\2\2\2\u0205\67\3\2\2\2\u0206\u0207\7J\2\2\u0207"+
		"\u0208\7-\2\2\u0208\u0209\5\u0084C\2\u0209\u020a\b\35\1\2\u020a9\3\2\2"+
		"\2\u020b\u020c\7%\2\2\u020c\u020d\5<\37\2\u020d\u020f\7\b\2\2\u020e\u0210"+
		"\5@!\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\3\2\2\2\u0211"+
		"\u0212\7\32\2\2\u0212\u0213\7.\2\2\u0213\u0215\5\66\34\2\u0214\u0216\5"+
		"\62\32\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u0218\b\36\1\2\u0218;\3\2\2\2\u0219\u021a\t\5\2\2\u021a\u021b\7\16\2"+
		"\2\u021b\u021c\t\6\2\2\u021c=\3\2\2\2\u021d\u0220\7Y\2\2\u021e\u0220\5"+
		"v<\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220\u0225\3\2\2\2\u0221"+
		"\u0222\7\f\2\2\u0222\u0224\5v<\2\u0223\u0221\3\2\2\2\u0224\u0227\3\2\2"+
		"\2\u0225\u0223\3\2\2\2\u0225\u0226\3\2\2\2\u0226?\3\2\2\2\u0227\u0225"+
		"\3\2\2\2\u0228\u022d\5z>\2\u0229\u022a\7\f\2\2\u022a\u022c\5z>\2\u022b"+
		"\u0229\3\2\2\2\u022c\u022f\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2"+
		"\2\2\u022eA\3\2\2\2\u022f\u022d\3\2\2\2\u0230\u0233\5D#\2\u0231\u0233"+
		"\5H%\2\u0232\u0230\3\2\2\2\u0232\u0231\3\2\2\2\u0233C\3\2\2\2\u0234\u0235"+
		"\7C\2\2\u0235\u0236\7\6\2\2\u0236\u0237\5l\67\2\u0237E\3\2\2\2\u0238\u0239"+
		"\7\n\2\2\u0239\u023a\7\6\2\2\u023a\u023b\7u\2\2\u023bG\3\2\2\2\u023c\u023f"+
		"\5J&\2\u023d\u023f\5P)\2\u023e\u023c\3\2\2\2\u023e\u023d\3\2\2\2\u023f"+
		"\u0240\3\2\2\2\u0240\u0241\b%\1\2\u0241I\3\2\2\2\u0242\u0243\5N(\2\u0243"+
		"K\3\2\2\2\u0244\u0245\7Y\2\2\u0245\u0246\7\6\2\2\u0246\u0247\5~@\2\u0247"+
		"M\3\2\2\2\u0248\u0249\5v<\2\u0249\u024a\7\6\2\2\u024a\u024b\5z>\2\u024b"+
		"O\3\2\2\2\u024c\u024d\5v<\2\u024d\u024e\78\2\2\u024e\u024f\5~@\2\u024f"+
		"\u0250\7\67\2\2\u0250\u0251\5~@\2\u0251Q\3\2\2\2\u0252\u0263\7\'\2\2\u0253"+
		"\u0255\7)\2\2\u0254\u0256\5r:\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2"+
		"\2\u0256\u0264\3\2\2\2\u0257\u0264\7Q\2\2\u0258\u0264\7N\2\2\u0259\u0264"+
		"\7O\2\2\u025a\u0264\7P\2\2\u025b\u0264\7R\2\2\u025c\u0264\7M\2\2\u025d"+
		"\u025e\7g\2\2\u025e\u025f\5\26\f\2\u025f\u0260\b*\1\2\u0260\u0264\3\2"+
		"\2\2\u0261\u0262\7h\2\2\u0262\u0264\b*\1\2\u0263\u0253\3\2\2\2\u0263\u0257"+
		"\3\2\2\2\u0263\u0258\3\2\2\2\u0263\u0259\3\2\2\2\u0263\u025a\3\2\2\2\u0263"+
		"\u025b\3\2\2\2\u0263\u025c\3\2\2\2\u0263\u025d\3\2\2\2\u0263\u0261\3\2"+
		"\2\2\u0264\u0265\3\2\2\2\u0265\u0266\b*\1\2\u0266S\3\2\2\2\u0267\u0268"+
		"\7\37\2\2\u0268\u0269\7-\2\2\u0269\u026a\5\u0082B\2\u026a\u026b\b+\1\2"+
		"\u026bU\3\2\2\2\u026c\u0273\7:\2\2\u026d\u026e\7$\2\2\u026e\u026f\5r:"+
		"\2\u026f\u0270\5p9\2\u0270\u0274\3\2\2\2\u0271\u0274\7;\2\2\u0272\u0274"+
		"\7S\2\2\u0273\u026d\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0272\3\2\2\2\u0274"+
		"\u0275\3\2\2\2\u0275\u0276\b,\1\2\u0276W\3\2\2\2\u0277\u028c\7+\2\2\u0278"+
		"\u0279\7=\2\2\u0279\u027a\7u\2\2\u027a\u028d\b-\1\2\u027b\u027c\7W\2\2"+
		"\u027c\u028d\5\u0080A\2\u027d\u027e\7X\2\2\u027e\u028d\5\u0080A\2\u027f"+
		"\u0280\7Y\2\2\u0280\u028d\7u\2\2\u0281\u0282\7\60\2\2\u0282\u028d\5\\"+
		"/\2\u0283\u0284\7[\2\2\u0284\u028d\7s\2\2\u0285\u028d\7o\2\2\u0286\u0287"+
		"\7i\2\2\u0287\u0288\5\30\r\2\u0288\u0289\7q\2\2\u0289\u028a\5\26\f\2\u028a"+
		"\u028b\b-\1\2\u028b\u028d\3\2\2\2\u028c\u0278\3\2\2\2\u028c\u027b\3\2"+
		"\2\2\u028c\u027d\3\2\2\2\u028c\u027f\3\2\2\2\u028c\u0281\3\2\2\2\u028c"+
		"\u0283\3\2\2\2\u028c\u0285\3\2\2\2\u028c\u0286\3\2\2\2\u028dY\3\2\2\2"+
		"\u028e\u028f\7,\2\2\u028f\u0290\t\7\2\2\u0290[\3\2\2\2\u0291\u0292\t\b"+
		"\2\2\u0292]\3\2\2\2\u0293\u0294\79\2\2\u0294\u0295\7s\2\2\u0295_\3\2\2"+
		"\2\u0296\u0298\7U\2\2\u0297\u0299\7s\2\2\u0298\u0297\3\2\2\2\u0298\u0299"+
		"\3\2\2\2\u0299a\3\2\2\2\u029a\u029b\7@\2\2\u029b\u029c\t\t\2\2\u029c\u029d"+
		"\7u\2\2\u029dc\3\2\2\2\u029e\u029f\7A\2\2\u029f\u02a0\7u\2\2\u02a0e\3"+
		"\2\2\2\u02a1\u02a2\7B\2\2\u02a2\u02a3\7u\2\2\u02a3g\3\2\2\2\u02a4\u02a5"+
		"\t\n\2\2\u02a5i\3\2\2\2\u02a6\u02a7\7\30\2\2\u02a7k\3\2\2\2\u02a8\u02a9"+
		"\t\13\2\2\u02a9m\3\2\2\2\u02aa\u02ab\7r\2\2\u02abo\3\2\2\2\u02ac\u02ad"+
		"\7r\2\2\u02adq\3\2\2\2\u02ae\u02af\7r\2\2\u02afs\3\2\2\2\u02b0\u02b1\7"+
		"r\2\2\u02b1\u02b2\b;\1\2\u02b2u\3\2\2\2\u02b3\u02b4\7r\2\2\u02b4\u02b5"+
		"\b<\1\2\u02b5w\3\2\2\2\u02b6\u02bb\7r\2\2\u02b7\u02b8\7\16\2\2\u02b8\u02ba"+
		"\7r\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb"+
		"\u02bc\3\2\2\2\u02bcy\3\2\2\2\u02bd\u02bb\3\2\2\2\u02be\u02c1\5~@\2\u02bf"+
		"\u02c1\5|?\2\u02c0\u02be\3\2\2\2\u02c0\u02bf\3\2\2\2\u02c1{\3\2\2\2\u02c2"+
		"\u02c3\7s\2\2\u02c3}\3\2\2\2\u02c4\u02c5\7u\2\2\u02c5\177\3\2\2\2\u02c6"+
		"\u02c7\t\f\2\2\u02c7\u0081\3\2\2\2\u02c8\u02c9\7r\2\2\u02c9\u02ca\7\16"+
		"\2\2\u02ca\u02cb\t\r\2\2\u02cb\u0083\3\2\2\2\u02cc\u02cd\7s\2\2\u02cd"+
		"\u0085\3\2\2\2;\u008c\u00a9\u00af\u00b5\u00ca\u00d4\u00d9\u00ec\u00f9"+
		"\u0104\u0106\u010c\u0113\u011e\u0120\u0126\u0131\u0136\u013d\u0143\u0146"+
		"\u014c\u0152\u015e\u0167\u017f\u0185\u018b\u0191\u019b\u019d\u01aa\u01ad"+
		"\u01b1\u01b5\u01ba\u01c2\u01c5\u01cb\u01ce\u01f8\u01fc\u0204\u020f\u0215"+
		"\u021f\u0225\u022d\u0232\u023e\u0255\u0263\u0273\u028c\u0298\u02bb\u02c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}