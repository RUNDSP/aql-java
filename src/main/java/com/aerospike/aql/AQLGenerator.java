package com.aerospike.aql;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.apache.log4j.Logger;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import com.aerospike.aql.grammar.AQLBaseListener;
import com.aerospike.aql.grammar.AQLParser;
import com.aerospike.aql.grammar.AQLParser.AggregateContext;
import com.aerospike.aql.grammar.AQLParser.BinContext;
import com.aerospike.aql.grammar.AQLParser.BinValueContext;
import com.aerospike.aql.grammar.AQLParser.ConnectContext;
import com.aerospike.aql.grammar.AQLParser.CreateContext;
import com.aerospike.aql.grammar.AQLParser.DeleteContext;
import com.aerospike.aql.grammar.AQLParser.DescContext;
import com.aerospike.aql.grammar.AQLParser.DisconnectContext;
import com.aerospike.aql.grammar.AQLParser.DropContext;
import com.aerospike.aql.grammar.AQLParser.EqualityFilterContext;
import com.aerospike.aql.grammar.AQLParser.ExecuteContext;
import com.aerospike.aql.grammar.AQLParser.GenerationPredicateContext;
import com.aerospike.aql.grammar.AQLParser.GetContext;
import com.aerospike.aql.grammar.AQLParser.InsertContext;
import com.aerospike.aql.grammar.AQLParser.IntegerValueContext;
import com.aerospike.aql.grammar.AQLParser.KillContext;
import com.aerospike.aql.grammar.AQLParser.OperateContext;
import com.aerospike.aql.grammar.AQLParser.OperateFunctionContext;
import com.aerospike.aql.grammar.AQLParser.PrimaryKeyContext;
import com.aerospike.aql.grammar.AQLParser.PrintContext;
import com.aerospike.aql.grammar.AQLParser.RangeFilterContext;
import com.aerospike.aql.grammar.AQLParser.RegisterContext;
import com.aerospike.aql.grammar.AQLParser.RemoveContext;
import com.aerospike.aql.grammar.AQLParser.RoleContext;
import com.aerospike.aql.grammar.AQLParser.SelectContext;
import com.aerospike.aql.grammar.AQLParser.SetContext;
import com.aerospike.aql.grammar.AQLParser.ShowContext;
import com.aerospike.aql.grammar.AQLParser.StatContext;
import com.aerospike.aql.grammar.AQLParser.StatementContext;
import com.aerospike.aql.grammar.AQLParser.StatementsContext;
import com.aerospike.aql.grammar.AQLParser.TextValueContext;
import com.aerospike.aql.grammar.AQLParser.UpdateContext;
import com.aerospike.aql.grammar.AQLParser.ValueContext;
import com.aerospike.aql.grammar.AQLParser.VariableDefinition;
import com.aerospike.client.query.IndexCollectionType;


public class AQLGenerator extends AQLBaseListener {

	private STGroup templates ;
	private Language generationLanguage;
	private AQLParser parser;
	private StatementContext currentStatement = null;
	private ParseTreeProperty<ST> code = new ParseTreeProperty<ST>();
	private String name;
	private String host;
	private int port;
	private Pattern quotefixer = Pattern.compile("\"");

	public enum Language {
		C, CSHARP, JAVA, PYTHON, GO, PHP, NODE, RUBY;
	}
	private static Logger log = Logger.getLogger(AQLGenerator.class);


	public AQLGenerator(AQLParser parser, String name, String host, int port, Language language) {
		super();
		this.parser = parser;
		this.name = name;
		this.host = host;
		this.port = port;
		setGenerationLanguage(language);
	}
	@Override
	public void exitAql(com.aerospike.aql.grammar.AQLParser.AqlContext ctx) {
		ST st = getTemplateFor("aqlFile");
		st.add("statements", code.get(ctx.statements()));
		st.add("className", this.name);
		st.add("host", this.host);
		st.add("port", this.port);
		putCode(ctx, st);
	}

	@Override
	public void exitStatements(StatementsContext ctx) {
		ST st = getTemplateFor("statements");
		for (VariableDefinition var : parser.definitions){
			st.add("variables", templatForVariable(var));
		}
		for (ParseTree statementCtx : ctx.children) {
			st.add("statementList", code.get(statementCtx));
		}
		putCode(ctx, st);
	}


	@Override
	public void enterStatement(StatementContext ctx) {
		TokenStream tokens = parser.getTokenStream();
		String source = tokens.getText(ctx);
		log.debug("Statement source: " + source);
		ctx.source = source;
	}

	@Override
	public void exitStatement(StatementContext ctx) {
		code.put(ctx, code.get(ctx.getChild(0)));
	}

	@Override
	public void exitConnect(ConnectContext ctx) {
		ST st = getTemplateFor("connect");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("host", stripQuotes(ctx.hostName.getText()));
		st.add("port", ctx.port.getText());
		putCode(ctx, st);
	}

	@Override
	public void exitDisconnect(DisconnectContext ctx) {
		ST st = getTemplateFor("disconnect");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		putCode(ctx, st);
	}

	@Override
	public void exitCreate(CreateContext ctx) {
		if (ctx.INDEX() != null){
			ST st = getTemplateFor("create");
			st.add("source", ((StatementContext)ctx.getParent()).source);
			st.add("indexName", ctx.index_name().getText());
			st.add("nameSpace", ctx.nameSet().namespace_name().getText());
			st.add("setName", ctx.nameSet().set_name().getText());
			st.add("type", ctx.iType.getText().toUpperCase());
			st.add("binName", ctx.binName.getText());
			IndexCollectionType collectionType;
			if (ctx.LIST() != null){
				collectionType = IndexCollectionType.LIST;
			} else if (ctx.MAPKEYS() != null){
				collectionType = IndexCollectionType.MAPKEYS;
			} else if (ctx.MAPVALUES() != null) {
				collectionType = IndexCollectionType.MAPVALUES;
			} else {
				collectionType = IndexCollectionType.DEFAULT;
			}
			st.add("collectionType", collectionType.toString());
			putCode(ctx, st);
		} else { //it's a user
			ST st = getTemplateFor("createUser");
			st.add("source", ((StatementContext)ctx.getParent()).source);
			st.add("user", ctx.user().getText());
			st.add("password", ctx.password().getText());
			List<String> roles = new ArrayList<String>();
			if (ctx.role() != null){
				roles.add(ctx.role().getText());
			} else if (ctx.roles().role().size() > 0){
				for (RoleContext role : ctx.roles().role()){
					roles.add(role.getText());
				}
			}
			st.add("roles", roles);
			putCode(ctx, st);
		}
	}

	@Override
	public void exitExecute(ExecuteContext ctx) {
		ST st = getTemplateFor("execute");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		if (ctx.where() != null)
			st.add("key", code.get(ctx.where().predicate().primaryKeyPredicate().primaryKey()));
		else {
			st.add("nameSpace", ctx.nameSet().namespace_name().getText());
			st.add("setName", ctx.nameSet().set_name().getText());
		}
		st.add("module", ctx.moduleFunction().packageName.getText());
		st.add("udf", ctx.moduleFunction().functionName.getText());
		if (ctx.valueList() != null){
			for (ParseTree value : ctx.valueList().children){
				st.add("arguments", code.get(value));
			}
		} else {
			st.add("arguments", null);
		}
		putCode(ctx, st);
	}
	@Override
	public void exitRegister(RegisterContext ctx) {
		ST st = getTemplateFor("register");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("path", ctx.MODULE().getText());
		putCode(ctx, st);
	}

	@Override
	public void exitDrop(DropContext ctx) {
		ST st = null;
		if (ctx.MODULE() != null) {
			removeModule(ctx, ((StatementContext)ctx.getParent()).source, ctx.moduleName().getText());
		} else {
			if (ctx.INDEX() != null){
				st = getTemplateFor("dropIndex");
				st.add("indexName", ctx.index_name().getText());
				st.add("nameSpace", ctx.nameSet().namespaceName);
				st.add("setName", ctx.nameSet().setName);
			} else if (ctx.SET() != null) {
				st = getTemplateFor("deleteSet");
				st.add("nameSpace", ctx.nameSet().namespaceName);
				st.add("setName", ctx.nameSet().setName);
			} else if (ctx.USER() != null){
				st = getTemplateFor("dropUser");
				String user = ctx.user().getText();
				st.add("user", user);
			}
			st.add("source", ((StatementContext)ctx.getParent()).source);
			putCode(ctx, st);}
	}

	@Override
	public void exitRemove(RemoveContext ctx) {
		removeModule(ctx, ((StatementContext)ctx.getParent()).source, ctx.MODULE().getText());
	}

	private void removeModule(ParseTree ctx, String source, String module){
		ST st = getTemplateFor("removeModule");
		st.add("source", source);
		st.add("module", module);
		putCode(ctx, st);

	}

	@Override
	public void exitSelect(SelectContext ctx) {
		ST st = null;
		String ns = ctx.nameSet().namespaceName;
		String set = ctx.nameSet().setName;
		if (ctx.where() != null){
			if (ctx.where().predicate().primaryKeyPredicate() != null){
				// its a get
				st = getTemplateFor("get");
				st.add("key", code.get(ctx.where().predicate().primaryKeyPredicate().primaryKey()));
			} else { //its a query
				st = getTemplateFor("query");
				st.add("nameSpace", ns);
				st.add("setName", set);
				st.add("where", code.get(ctx.where().predicate().filterPredicate()));
			}
		} else { // its a scan
			st = getTemplateFor("scan");
			st.add("nameSpace", ns);
			st.add("setName", set);
		}
		if (ctx.binNameList() != null){
			for (BinContext value : ctx.binNameList().bin()){
				st.add("binNames", value.getText());
			}
		}
		st.add("source", ((StatementContext)ctx.getParent()).source);
		putCode(ctx, st);
	}

	@Override
	public void exitAggregate(AggregateContext ctx) {
		ST st = getTemplateFor("aggregate");
		String ns = ctx.nameSet().namespaceName;
		String set = ctx.nameSet().setName;
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("nameSpace", ns);
		st.add("setName", set);
		st.add("package", ctx.moduleFunction().packageName.getText());
		st.add("function", ctx.moduleFunction().functionName.getText());
		if (ctx.where() != null)
			st.add("where", code.get(ctx.where().predicate().filterPredicate()));
		putCode(ctx, st);
	}

	@Override
	public void exitOperate(OperateContext ctx) {
		ST st = getTemplateFor("operateStatement");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		for (OperateFunctionContext fn : ctx.operateFunction()){
			st.add("operations", code.get(fn));
		}
		st.add("key", code.get(ctx.primaryKeyPredicate().primaryKey()));
		st.add("generation", code.get(ctx.generationPredicate()));
		putCode(ctx, st);
	}

	@Override
	public void exitOperateFunction(OperateFunctionContext ctx) {
		ST st = getTemplateFor("operateFunction");
		st.add("functionName", ctx.getChild(0).getText());
		st.add("bin", ctx.bin().getText());
		st.add("value", code.get(ctx.value()));
		putCode(ctx, st);
	}

	@Override
	public void exitInsert(InsertContext ctx) {
		ST st = getTemplateFor("insertStmt");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("primaryKey", code.get(ctx.primaryKey()));
		for (BinContext value : ctx.binNameList().bin()){
			st.add("binNames", value.getText());
		}
		for (ParseTree value : ctx.valueList().value()){
			st.add("values", code.get(value));
		}
		putCode(ctx, st);
	}

	@Override
	public void exitUpdate(UpdateContext ctx) {
		ST st = getTemplateFor("updateStmt");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("primaryKey", code.get(ctx.primaryKeyPredicate().primaryKey()));
		st.add("generation", code.get(ctx.generationPredicate()));
		for (BinValueContext value : ctx.updateList().binValue()){
			st.add("binList", code.get(value));
		}
		if (ctx.updateList().ttlValue() != null){
			st.add("ttl", ctx.updateList().ttlValue().integerValue().getText());
		}
		putCode(ctx, st);
	}

	@Override
	public void exitBinValue(BinValueContext ctx) {
		ST st = getTemplateFor("binValue");
		st.add("binName", ctx.bin().getText());
		st.add("binValue", code.get(ctx.value()));
		putCode(ctx, st);
	}

	@Override
	public void exitDelete(DeleteContext ctx) {
		ST st = getTemplateFor("deleteStmt");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("primaryKey", code.get(ctx.primaryKeyPredicate().primaryKey()));
		putCode(ctx, st);
	}

	@Override
	public void exitShow(ShowContext ctx) {
		ST st = null;
		if (ctx.NAMESPACES() != null)
			st = getTemplateFor("showNamespaces");
		else if (ctx.INDEXES() != null){
			st = getTemplateFor("showIndexes"); 
			if (ctx.nameSet() != null) {
				st.add("nameSpace", ctx.nameSet().namespaceName);
				st.add("setName", ctx.nameSet().setName);
			}
		}
		else if (ctx.MODULES() != null)
			st = getTemplateFor("showModules");
		else if (ctx.BINS() != null)
			st = getTemplateFor("showBins");
		else if (ctx.SETS() != null)
			st = getTemplateFor("showSets");
		else if (ctx.QUERIES() != null)
			st = getTemplateFor("showQueries");
		else if (ctx.SCANS() != null)
			st = getTemplateFor("showScans");
		else if (ctx.USER() != null){
			st = getTemplateFor("showUser");
			String user = ctx.user().getText();
			st.add("user", user);
		} else if (ctx.USERS() != null)
			st = getTemplateFor("showUsers");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		putCode(ctx, st);
	}

	@Override
	public void exitDesc(DescContext ctx) {
		ST st = null;
		if (ctx.INDEX() != null) {
			st = getTemplateFor("descIndex");
			st.add("nameSpace", ctx.namespace_name().getText());
			st.add("indexName", ctx.index_name().getText());
		} else { // Module
			st = getTemplateFor("descModule");
			st.add("name", ctx.moduleName().getText());
		}
		st.add("source", ((StatementContext)ctx.getParent()).source);

		putCode(ctx, st);
	}

	@Override
	public void exitStat(StatContext ctx) {
		ST st = null;
		if (ctx.QUERY() != null) {
			st = getTemplateFor("statQuery");
		} else if (ctx.INDEX() != null) {
			st = getTemplateFor("statIndex");
			st.add("nameSpace", ctx.namespace_name().getText());
			st.add("indexName", ctx.index_name().getText());
		} else { 
			st = getTemplateFor("statSystem");
		}
		st.add("source", ((StatementContext)ctx.getParent()).source);

		putCode(ctx, st);
	}

	@Override
	public void exitSet(SetContext ctx) {
		ST st = null;
		if (ctx.TIMEOUT() != null) {
			st = getTemplateFor("setTimeOut");
			st.add("value", ctx.timeOut.getText());
		} else if (ctx.VERBOSE() != null) {
			st = getTemplateFor("setVerbose");
			st.add("value", ctx.verboseOn.getText());
		} else if (ctx.ECHO() != null) {
			st = getTemplateFor("setEcho");
			st.add("value", ctx.echoOn.getText());
		} else if (ctx.TTL() != null) {
			st = getTemplateFor("setTTL");
			st.add("value", ctx.ttl.getText());
		} else if (ctx.OUTPUT() != null) {
			st = getTemplateFor("setView");
			st.add("type", ctx.viewType().getText());
		} else if (ctx.LUA_USER_PATH() != null) { 
			st = getTemplateFor("setUserPath");
			st.add("value", ctx.luaUserPath.getText());
		} else if (ctx.PASSWORD() != null){
			st = getTemplateFor("setUserPassword");
			st.add("user", ctx.user().getText());
			st.add("password", ctx.password().getText());
		}
		st.add("source", ((StatementContext)ctx.getParent()).source);
		putCode(ctx, st);
	}

	@Override
	public void exitGet(GetContext ctx) {
		ST st = null;
		if (ctx.TIMEOUT() != null) {
			st = getTemplateFor("getTimeout");
		} else if (ctx.VERBOSE() != null) {
			st = getTemplateFor("getVerbose");
		} else if (ctx.ECHO() != null) {
			st = getTemplateFor("getEcho");
		} else if (ctx.TTL() != null) {
			st = getTemplateFor("getTTL");
		} else if (ctx.OUTPUT() != null) {
			st = getTemplateFor("getView");
		} else {// if (ctx.LUA_USER_PATH() != null) { 
			st = getTemplateFor("getUserPath");
		} 
		st.add("source", ((StatementContext)ctx.getParent()).source);
		putCode(ctx, st);
	}

	@Override
	public void exitKill(KillContext ctx) {
		ST st = null;
		if (ctx.QUERY() != null)
			st = getTemplateFor("killQuery");
		else // its a scan
			st = getTemplateFor("killScan");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("id", ctx.INTLITERAL().getText());
		putCode(ctx, st);
	}


	@Override
	public void exitPrint(PrintContext ctx) {
		ST st = getTemplateFor("print");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		if (ctx.STRINGLITERAL() != null)
			st.add("value", stripQuotes(ctx.STRINGLITERAL().getText()));
		else 
			st.add("value", "");
		putCode(ctx, st);
	}

	@Override
	public void exitValue(ValueContext ctx) {
		putCode(ctx, code.get(ctx.getChild(0)));
	}

	@Override
	public void exitIntegerValue(IntegerValueContext ctx) {
		ST st = getTemplateFor("value");
		st.add("value", ctx.getText());
		putCode(ctx, st);
	}
	@Override
	public void exitTextValue(TextValueContext ctx) {
		String svalue = stripQuotes(ctx.getText());
		ST st;
		if (svalue.startsWith("JSON[")) {// make a list
			st = getTemplateFor("jsonArrayValue");
			st.add("value", escapeJsonString(svalue.substring(4)));
		} else if (svalue.startsWith("JSON{")){// make a map
			st = getTemplateFor("jsonObjectValue");
			st.add("value", escapeJsonString(svalue.substring(4)));
		} else { // assume its a string
			st = getTemplateFor("stringValue");
			st.add("value", svalue);
		}
		putCode(ctx, st);
	}
	private String escapeJsonString(String json){
		
		String escapedString = quotefixer.matcher(json).replaceAll("\\\\\""); //json.replaceAll("\"", "\\\"");
		return escapedString;
	}
	@Override
	public void exitPrimaryKey(PrimaryKeyContext ctx) {
		ST st = getTemplateFor("primaryKey");
		st.add("namespace", ctx.nameSpace);
		st.add("set", ctx.setName);
		String key = ctx.key.getText();
		if (key.charAt(0)=='\''){
			key = stripQuotes(key);
			ST keyst = getTemplateFor("primaryKeyString");
			keyst.add("key", key);
			key = keyst.render();
		} else { // its numeric
			ST keyst = getTemplateFor("primaryKeyNumeric");
			keyst.add("key", key);
			key = keyst.render();
		}
		st.add("key", key);
		putCode(ctx, st);
	}

	@Override
	public void exitEqualityFilter(EqualityFilterContext ctx) {
		ST st = getTemplateFor("filterEquals");
		st.add("bin", ctx.binValue().bin().getText());
		st.add("value", code.get(ctx.binValue().value()));
		putCode(ctx, st);
	}

	@Override
	public void exitRangeFilter(RangeFilterContext ctx) {
		ST st = getTemplateFor("filterRange");
		st.add("bin", ctx.bin().getText());
		st.add("low", code.get(ctx.low));
		st.add("high", code.get(ctx.high));
		putCode(ctx, st);
	}

	@Override
	public void exitGenerationPredicate(GenerationPredicateContext ctx) {
		ST st = getTemplateFor("generationPredicate");
		st.add("generation", ctx.INTLITERAL().toString());
		putCode(ctx, st);
	}


	private void putCode(ParseTree ctx, ST st){
		log.debug("Rendered: " + st.render());
		code.put(ctx, st);
	}

	public ST getST(ParseTree ctx){
		return code.get(ctx);
	}
	private ST getTemplateFor(String name){
		ST st = templates.getInstanceOf(name);
		if (currentStatement != null)
			st.add("source", currentStatement.source);
		return st;
	}
	private ST templatForVariable(VariableDefinition var){
		ST st = null;

		switch (var){
		case QUERY_POLICY:
			st = templates.getInstanceOf("queryPolicy");
			break;
		case READ_POLICY:	
			st = templates.getInstanceOf("readPolicy");
			break;
		case RECORD:
			st = templates.getInstanceOf("record");
			break;
		case RECORD_SET:
			st = templates.getInstanceOf("recordSet");
			break;
		case RESULT_SET:
			st = templates.getInstanceOf("resultSet");
			break;
		case SCAN_POLICY:
			st = templates.getInstanceOf("scanPolicy");
			break;
		case WRITE_POLICY:
			st = templates.getInstanceOf("writePolicy");
			break;
		case INFO_POLICY:
			st = templates.getInstanceOf("infoPolicy");
			break;
		case ADMIN_POLICY:
			st = templates.getInstanceOf("adminPolicy");
			break;
		case STMT:
			st = templates.getInstanceOf("stmt");
			break;
		case UDF_FILE:
			st = templates.getInstanceOf("udfFile");
			break;
		case INDEX_TASK:
			st = templates.getInstanceOf("indexTask");
			break;
		case REGISTER_TASK:
			st = templates.getInstanceOf("registerTask");
			break;
		case INFO_STRING:
			st = templates.getInstanceOf("infoMessage");
			break;

		}
		return st;
	}

	private void setGenerationLanguage(Language generationLanguage) {
		this.generationLanguage = generationLanguage;
		templates = new STGroupFile(getTemplateURL(generationLanguage), null, '<', '>');
	}

	public Language getGenerationLanguage() {
		return generationLanguage;
	}

	private URL getTemplateURL(Language language){
		URL url = null;

		switch (language){
		case CSHARP:
			url = getClass().getResource("AS_C_Sharp.stg");
			break;
		case C:
			url = getClass().getResource("AS_C.stg");
			break;
		case PYTHON:
			url = getClass().getResource("AS_Python.stg");
			break;
		case GO:
			url = getClass().getResource("AS_Go.stg");
			break;
		case PHP:
			url = getClass().getResource("AS_PHP.stg");
			break;
		case NODE:
			url = getClass().getResource("AS_Node.stg");
			break;
		case RUBY:
			url = getClass().getResource("AS_Ruby.stg");
			break;
		default:
			url = getClass().getResource("AS_Java.stg");
			break;
		}
		return url;
	}

	public static String stripQuotes(String inputString) {
		if ( inputString==null || inputString.charAt(0)!='\'' ) return inputString;
		return inputString.substring(1, inputString.length() - 1);
	}
	public static String getStackTrace(Throwable throwable) {
		StringWriter sw = new StringWriter();
		throwable.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

}
