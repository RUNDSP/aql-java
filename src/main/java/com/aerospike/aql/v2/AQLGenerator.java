package com.aerospike.aql.v2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.apache.log4j.Logger;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import com.aerospike.aql.v2.grammar.AQLBaseListener;
import com.aerospike.aql.v2.grammar.AQLParser;
import com.aerospike.aql.v2.grammar.AQLParser.BinContext;
import com.aerospike.aql.v2.grammar.AQLParser.BinValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.CreateContext;
import com.aerospike.aql.v2.grammar.AQLParser.DeleteContext;
import com.aerospike.aql.v2.grammar.AQLParser.DescContext;
import com.aerospike.aql.v2.grammar.AQLParser.DropContext;
import com.aerospike.aql.v2.grammar.AQLParser.ExecuteContext;
import com.aerospike.aql.v2.grammar.AQLParser.GenerationPredicateContext;
import com.aerospike.aql.v2.grammar.AQLParser.InsertContext;
import com.aerospike.aql.v2.grammar.AQLParser.IntegerValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.KillContext;
import com.aerospike.aql.v2.grammar.AQLParser.OperateContext;
import com.aerospike.aql.v2.grammar.AQLParser.OperateFunctionContext;
import com.aerospike.aql.v2.grammar.AQLParser.PrimaryKeyContext;
import com.aerospike.aql.v2.grammar.AQLParser.PrintContext;
import com.aerospike.aql.v2.grammar.AQLParser.RegisterContext;
import com.aerospike.aql.v2.grammar.AQLParser.RemoveContext;
import com.aerospike.aql.v2.grammar.AQLParser.ShowContext;
import com.aerospike.aql.v2.grammar.AQLParser.StatContext;
import com.aerospike.aql.v2.grammar.AQLParser.StatementContext;
import com.aerospike.aql.v2.grammar.AQLParser.StatementsContext;
import com.aerospike.aql.v2.grammar.AQLParser.TextValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.UpdateContext;
import com.aerospike.aql.v2.grammar.AQLParser.ValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.VariableDefinition;


public class AQLGenerator extends AQLBaseListener {

	private STGroup templates ;
	private Language generationLanguage;
	private AQLParser parser;
	private StatementContext currentStatement = null;
	private ParseTreeProperty<ST> code = new ParseTreeProperty<ST>();
	private String name;
	private String host;
	private int port;

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
	public void exitAql(com.aerospike.aql.v2.grammar.AQLParser.AqlContext ctx) {
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
	public void exitCreate(CreateContext ctx) {
		ST st = getTemplateFor("create");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("indexName", ctx.index_name().getText());
		st.add("nameSpace", ctx.nameSet().namespace_name().getText());
		st.add("setName", ctx.nameSet().set_name().getText());
		st.add("type", ctx.iType.getText().toUpperCase());
		st.add("binName", ctx.binName.getText());
		putCode(ctx, st);
	}

	@Override
	public void exitExecute(ExecuteContext ctx) {
		ST st = getTemplateFor("execute");
		st.add("source", ((StatementContext)ctx.getParent()).source);
		st.add("nameSpace", ctx.nameSet().namespace_name().getText());
		st.add("setName", ctx.nameSet().set_name().getText());
		st.add("key", code.get(ctx.where()));
		st.add("module", ctx.moduleFunction().packageName);
		st.add("udf", ctx.moduleFunction().functionName);
		for (ParseTree value : ctx.valueList().children){
			st.add("arguments", code.get(value));
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
			} else {// it's a set 
				st = getTemplateFor("deleteSet");
				st.add("nameSpace", ctx.nameSet().namespaceName);
				st.add("setName", ctx.nameSet().setName);
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
		for (BinValueContext value : ctx.updateBinList().binValue()){
			st.add("binList", code.get(value));
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
		else if (ctx.INDEXES() != null)
			st = getTemplateFor("showIndexes"); //TODO namespace and set
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
		st.add("value", stripQuotes(ctx.STRINGLITERAL().getText()));
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
		ST st = getTemplateFor("stringValue");
		st.add("value", stripQuotes(ctx.getText()));
		putCode(ctx, st);
	}
	@Override
	public void exitPrimaryKey(PrimaryKeyContext ctx) {
		ST st = getTemplateFor("primaryKey");
		st.add("namespace", ctx.nameSpace);
		st.add("set", ctx.setName);
		st.add("key", stripQuotes(ctx.key.getText()));
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
		case CLIENT:
			st = templates.getInstanceOf("client");
			st.add("host", this.host);
			st.add("port", this.port);
			break;
		case CLIENT_POLICY:
			st = templates.getInstanceOf("clientPolicy");
			break;
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
			st = templates.getInstanceOf("infoString");
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
