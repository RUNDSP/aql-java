package com.aerospike.aql.v2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.apache.log4j.Logger;

import com.aerospike.aql.v2.grammar.AQLBaseListener;
import com.aerospike.aql.v2.grammar.AQLParser.BinContext;
import com.aerospike.aql.v2.grammar.AQLParser.BinNameListContext;
import com.aerospike.aql.v2.grammar.AQLParser.BinValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.ConnectContext;
import com.aerospike.aql.v2.grammar.AQLParser.CreateContext;
import com.aerospike.aql.v2.grammar.AQLParser.DeleteContext;
import com.aerospike.aql.v2.grammar.AQLParser.DisconnectContext;
import com.aerospike.aql.v2.grammar.AQLParser.DropContext;
import com.aerospike.aql.v2.grammar.AQLParser.EqualityFilterContext;
import com.aerospike.aql.v2.grammar.AQLParser.ExecuteContext;
import com.aerospike.aql.v2.grammar.AQLParser.FilterPredicateContext;
import com.aerospike.aql.v2.grammar.AQLParser.GenerationPredicateContext;
import com.aerospike.aql.v2.grammar.AQLParser.InsertContext;
import com.aerospike.aql.v2.grammar.AQLParser.IntegerValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.PrimaryKeyContext;
import com.aerospike.aql.v2.grammar.AQLParser.RangeFilterContext;
import com.aerospike.aql.v2.grammar.AQLParser.RegisterContext;
import com.aerospike.aql.v2.grammar.AQLParser.RemoveContext;
import com.aerospike.aql.v2.grammar.AQLParser.SelectContext;
import com.aerospike.aql.v2.grammar.AQLParser.TextValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.UpdateContext;
import com.aerospike.aql.v2.grammar.AQLParser.ValueContext;
import com.aerospike.aql.v2.grammar.AQLParser.ValueListContext;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Info;
import com.aerospike.client.Key;
import com.aerospike.client.Language;
import com.aerospike.client.Record;
import com.aerospike.client.ScanCallback;
import com.aerospike.client.Value;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.GenerationPolicy;
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.IndexTask;
import com.aerospike.client.task.RegisterTask;

public class AQLExecutor extends AQLBaseListener {
	private AerospikeClient client = null;
	private ClientPolicy cPolicy = null;
	private InfoPolicy infoPolicy = null;
	private Policy policy = null;
	private WritePolicy writePolicy = null;
	private QueryPolicy queryPolicy = null;
	private ScanPolicy scanPolicy = null;
	private ParseTreeProperty<Value> valueProperty = new ParseTreeProperty<Value>();
	private ParseTreeProperty<Key> keyProperty = new ParseTreeProperty<Key>();
	private ParseTreeProperty<Bin> binProperty = new ParseTreeProperty<Bin>();
	private ParseTreeProperty<List<Value>> valueListProperty = new ParseTreeProperty<List<Value>>();
	private ParseTreeProperty<List<String>> stringListProperty = new ParseTreeProperty<List<String>>();
	private ParseTreeProperty<String> stringProperty = new ParseTreeProperty<String>();
	private ParseTreeProperty<Integer> integerProperty = new ParseTreeProperty<Integer>();
	private ParseTreeProperty<Filter> filterProperty = new ParseTreeProperty<Filter>();
	
	private IResultReporter results = null;
	private static Logger log = Logger.getLogger(AQLExecutor.class);
	
	

	public AQLExecutor(AerospikeClient client, int timeout) {
		super();
		this.client = client;
		this.policy = new Policy();
		this.cPolicy = new ClientPolicy();
		this.infoPolicy = new InfoPolicy();
		this.writePolicy = new WritePolicy();
		this.queryPolicy = new QueryPolicy();
		this.scanPolicy = new ScanPolicy();
		this.setTimeout(timeout);
		this.setResultsReporter(null);
	}
 
	private void setResultsReporter(IResultReporter reporter) {
		if (reporter == null)
			this.results = new SystemOutReporter();
		else
			this.results = reporter;
		
	}

	private void setTimeout(int timeout){
		this.policy.timeout = timeout;
		this.cPolicy.timeout = timeout;
		this.writePolicy.timeout = timeout;
		this.queryPolicy.timeout = timeout;
		this.scanPolicy.timeout = timeout;
		this.infoPolicy.timeout = timeout;
	}
    
	@Override
	public void exitConnect(ConnectContext ctx) {
		try {
			String host = stripQuotes(ctx.hostName.getText());
			int port = Integer.parseInt(ctx.port.getText());
			this.client = new AerospikeClient(this.cPolicy, host, port);
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitDisconnect(DisconnectContext ctx) {
		try {
			if (this.client != null && this.client.isConnected())
				this.client.close();
			this.client = null;
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitCreate(CreateContext ctx) {
		try {
			String indexName = ctx.index_name().getText();
			String namespace = ctx.nameSet().namespaceName;
			String set = ctx.nameSet().setName;
			String binName = ctx.binName.getText();
			IndexType type = (ctx.iType.getText().equalsIgnoreCase("STRING")) ? IndexType.STRING : IndexType.NUMERIC;
			IndexTask indexTask = client.createIndex(policy, namespace, set, indexName, binName, type);
			indexTask.waitTillComplete(10);
			results.report(String.format("Index %s created", indexName));
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitDrop(DropContext ctx) {
		try {
			if (ctx.INDEX() != null) {
				String indexName = ctx.index_name().getText();
				String namespace = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				client.dropIndex(policy, namespace, set, indexName);
				results.report(String.format("Index %s deleted", indexName));
			} else if (ctx.MODULE() != null) {
				String module = ctx.moduleName().getText();
				String[] infoStrings = infoAll(infoPolicy, client, "udf-remove:filename=" + module);
				results.reportInfo(infoStrings, ";");
			} else {
				String namespace = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				String infoString = info(infoPolicy, client, String.format("set-config:context=namespace;id=%s;set=%s;set-delete=true;", namespace, set));
				results.reportInfo(infoString, ";");
			}
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitRemove(RemoveContext ctx) {
		try {
		String module = ctx.moduleName().getText();
		String[] infoStrings = infoAll(infoPolicy, client, "udf-remove:filename=" + module);
		results.reportInfo(infoStrings, ";");
		} catch (AerospikeException e) {
			results.report(e);
		}
	}

	@Override
	public void exitInsert(InsertContext ctx) {
		try {
			Key key = keyProperty.get(ctx.primaryKey());
			List<Value> values = valueListProperty.get(ctx.valueList());
			List<String> binNames = stringListProperty.get(ctx.binNameList());
			Bin[] bins = new Bin[binNames.size()];
			int index = 0;
			for (String name : binNames){
				if (name.equalsIgnoreCase("ttl")){
					writePolicy.expiration = values.get(index).toInteger();
				} else {
					bins[index] = new Bin(name, values.get(index));
				}
				index++;
			}
			writePolicy.recordExistsAction = RecordExistsAction.CREATE_ONLY;
			client.put(writePolicy, key, bins);
			results.report(String.format("Created: %s", key.toString()));
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitUpdate(UpdateContext ctx) {
		try {
			Key key  = keyProperty.get(ctx.primaryKeyPredicate().primaryKey());
			if (ctx.generationPredicate() != null){
				int generation = Integer.parseInt(ctx.generationPredicate().INTLITERAL().getText());
				setGeneration(writePolicy, generation);
			}
			if (ctx.updateList().ttlValue() != null){
				int ttl = Integer.parseInt(ctx.updateList().ttlValue().integerValue().INTLITERAL().getText());
				writePolicy.expiration = ttl;
			}
			writePolicy.recordExistsAction = RecordExistsAction.UPDATE;
			if (ctx.updateList().binValue() != null){
				Bin[] binList = new Bin[ctx.updateList().binValue().size()];
				int index = 0;
				for (BinValueContext value : ctx.updateList().binValue()){
					binList[index] = binProperty.get(value);
					index++;
				}
				client.put(writePolicy, key, binList);
			} else {
				// its a touch
				client.touch(writePolicy, key);
			}
			results.report(String.format("Updated: %s", key.toString()));
		} catch (AerospikeException e){
			results.report(e);
		}
	}

	@Override
	public void exitDelete(DeleteContext ctx) {
		try {
		Key key  = keyProperty.get(ctx.primaryKeyPredicate().primaryKey());
		if (ctx.generationPredicate() != null){
			int generation = Integer.parseInt(ctx.generationPredicate().INTLITERAL().getText());
			setGeneration(writePolicy, generation);
		}
		client.delete(writePolicy, key);
		results.report(String.format("Deleted: %s", key.toString()));
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitSelect(SelectContext ctx) {
		try {
			String[] binNames = null;
			if (ctx.binNameList() != null){
				List<String> names = stringListProperty.get(ctx.binNameList());
				binNames = new String[names.size()];
				int index = 0;
				for (String binName : names){
					binNames[index] = binName;
					index++;
				}
			}
			if (ctx.where() != null){
				if (ctx.where().predicate().primaryKeyPredicate() != null){
					// its a get
					Key key = keyProperty.get(ctx.where().predicate().primaryKeyPredicate().primaryKey());
					Record record = client.get(policy, key, binNames);
					results.report(key, record);
				} else { //its a query
					String ns = ctx.nameSet().namespaceName;
					String set = ctx.nameSet().setName;
					Filter filter = filterProperty.get(ctx.where().predicate().filterPredicate());
					Statement stmt = new Statement();
					stmt.setNamespace(ns);
					stmt.setSetName(set);
					stmt.setFilters(filter);
					stmt.setBinNames(binNames);
					RecordSet recordSet = client.query(queryPolicy, stmt);
					results.report(recordSet);
				}
			} else { // its a scan
				String ns = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				client.scanAll(scanPolicy, ns, set, new ScanCallback() {

					@Override
					public void scanCallback(Key key, Record record) throws AerospikeException {
						results.report(key, record);
					}
				}, binNames);
			}
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitRegister(RegisterContext ctx) {
		try {
		String filepath = ctx.filepath.getText();
		File udfFile = new File(filepath);
		RegisterTask task = client.register(null, 
			udfFile.getPath(), 
			udfFile.getName(), 
			Language.LUA); 
		task.waitTillComplete(10);
		results.report("Registered module: " + filepath);
		} catch (AerospikeException e){
			results.report(e);
		}
	}

	@Override
	public void exitExecute(ExecuteContext ctx) {
		try {
			String module = ctx.moduleFunction().packageName.getText();
			String function = ctx.moduleFunction().functionName.getText();
			Value[] arguments = null;
			if (ctx.valueList() != null){
				List<Value> values = valueListProperty.get(ctx.valueList());
				arguments = new Value[values.size()];
				int index = 0;
				for (Value value : values){
					arguments[index] = value;
					index++;
				}
			}
			if (ctx.where() != null) { // execute udf
				Key key  = keyProperty.get(ctx.where().predicate().primaryKeyPredicate().primaryKey());
				Object result = client.execute(policy, key, module, function, arguments);
				results.report(result.toString());
			} else { //scan UDF
				String namespace = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				Statement stmt = new Statement();
				stmt.setNamespace(namespace);
				stmt.setSetName(set);
				ResultSet resultSet = client.queryAggregate(null, stmt, module, function, arguments);
				results.report(resultSet);
			}
		} catch (AerospikeException e){
			results.report(e);
		}
	}

	private void setGeneration(WritePolicy writePolicy, int generation) {
		writePolicy.generation = generation;
		writePolicy.generationPolicy = GenerationPolicy.EXPECT_GEN_EQUAL;
	}
			
	private String[] infoAll(InfoPolicy infoPolicy, AerospikeClient client,
			String infoString) {
		String[] messages = new String[client.getNodes().length];
		int index = 0;
		for (Node node : client.getNodes()){
			messages[index] = Info.request(infoPolicy, node, infoString);
		}
		return messages;
	}

	private String info(InfoPolicy infoPolicy, AerospikeClient client,
			String infoString) {
			String answer = Info.request(infoPolicy, client.getNodes()[0], infoString);
			log.debug(answer);
			return answer;
	}

	@Override
	public void exitFilterPredicate(FilterPredicateContext ctx) {
		filterProperty.put(ctx, filterProperty.get(ctx.getChild(0)));
	}
	
	@Override
	public void exitEqualityFilter(EqualityFilterContext ctx) {
		String binName = ctx.binValue().bin().getText();
		Value value = makeValue(ctx.binValue().value().getText());
		filterProperty.put(ctx, Filter.equal(binName, value));
	}
	
	@Override
	public void exitRangeFilter(RangeFilterContext ctx) {
		long low = Long.parseLong(ctx.low.getText());
		long high = Long.parseLong(ctx.low.getText());
		String binName = ctx.bin().getText();
		filterProperty.put(ctx, Filter.range(binName, low, high));
	}
	
	@Override
	public void exitGenerationPredicate(GenerationPredicateContext ctx) {
		int generation = Integer.parseInt(ctx.INTLITERAL().getText());
		integerProperty.put(ctx, generation);
	}
	
	@Override
	public void exitBinNameList(BinNameListContext ctx) {
		List<String> binNames = new ArrayList<String>();
		for (BinContext bin : ctx.bin()){
			binNames.add(bin.getText());
		}
		this.stringListProperty.put(ctx, binNames);
	}
	
	@Override
	public void exitBinValue(BinValueContext ctx) {
		String name = ctx.bin().getText();
		Value value = valueProperty.get(ctx.value());
		binProperty.put(ctx, new Bin(name, value));
	}
	
	@Override
	public void exitValueList(ValueListContext ctx) {
		List<Value> valueList = new ArrayList<Value>();
		for (ValueContext valCtx :ctx.value()){
			valueList.add(this.valueProperty.get(valCtx));
		}
		this.valueListProperty.put(ctx, valueList);
	}
	@Override
	public void exitPrimaryKey(PrimaryKeyContext ctx) {
		Key key = new Key(ctx.nameSpace, ctx.setName, makeValue(ctx.key.getText()));
		this.keyProperty.put(ctx, key);
	}
	
	@Override
	public void exitValue(ValueContext ctx) {
		this.valueProperty.put(ctx, this.valueProperty.get(ctx.getChild(0)));
	}
	@Override
	public void exitIntegerValue(IntegerValueContext ctx) {
		Value value = Value.get(makeValue(ctx.getText()));
		this.valueProperty.put(ctx, value);
	}
	@Override
	public void exitTextValue(TextValueContext ctx) {
		Value value = Value.get(makeValue(ctx.getText()));
		this.valueProperty.put(ctx, value);
	}
	private Value makeValue(String valueText){
		try {
			long lvalue = Long.parseLong(valueText);
			return Value.get(lvalue);
		} catch (NumberFormatException e){
			//its a string
		}
		String svalue = stripQuotes(valueText);
		return Value.get(svalue);
	}
	
	public static String stripQuotes(String inputString) {
        if ( inputString==null || inputString.charAt(0)!='\'' ) return inputString;
        return inputString.substring(1, inputString.length() - 1);
    }

}
