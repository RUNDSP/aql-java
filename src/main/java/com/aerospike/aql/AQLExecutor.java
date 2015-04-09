package com.aerospike.aql;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.aql.grammar.AQLBaseListener;
import com.aerospike.aql.grammar.AQLParser;
import com.aerospike.aql.grammar.AQLParser.AggregateContext;
import com.aerospike.aql.grammar.AQLParser.BinContext;
import com.aerospike.aql.grammar.AQLParser.BinNameListContext;
import com.aerospike.aql.grammar.AQLParser.BinValueContext;
import com.aerospike.aql.grammar.AQLParser.ConnectContext;
import com.aerospike.aql.grammar.AQLParser.CreateContext;
import com.aerospike.aql.grammar.AQLParser.DeleteContext;
import com.aerospike.aql.grammar.AQLParser.DescContext;
import com.aerospike.aql.grammar.AQLParser.DisconnectContext;
import com.aerospike.aql.grammar.AQLParser.DropContext;
import com.aerospike.aql.grammar.AQLParser.EqualityFilterContext;
import com.aerospike.aql.grammar.AQLParser.ExecuteContext;
import com.aerospike.aql.grammar.AQLParser.FilterPredicateContext;
import com.aerospike.aql.grammar.AQLParser.GenerationPredicateContext;
import com.aerospike.aql.grammar.AQLParser.GetContext;
import com.aerospike.aql.grammar.AQLParser.GrantContext;
import com.aerospike.aql.grammar.AQLParser.HelpContext;
import com.aerospike.aql.grammar.AQLParser.InsertContext;
import com.aerospike.aql.grammar.AQLParser.IntegerValueContext;
import com.aerospike.aql.grammar.AQLParser.OperateContext;
import com.aerospike.aql.grammar.AQLParser.OperateFunctionContext;
import com.aerospike.aql.grammar.AQLParser.PrimaryKeyContext;
import com.aerospike.aql.grammar.AQLParser.PrintContext;
import com.aerospike.aql.grammar.AQLParser.PrivilegeContext;
import com.aerospike.aql.grammar.AQLParser.QuitContext;
import com.aerospike.aql.grammar.AQLParser.RangeFilterContext;
import com.aerospike.aql.grammar.AQLParser.RegisterContext;
import com.aerospike.aql.grammar.AQLParser.RemoveContext;
import com.aerospike.aql.grammar.AQLParser.RevokeContext;
import com.aerospike.aql.grammar.AQLParser.RoleContext;
import com.aerospike.aql.grammar.AQLParser.SelectContext;
import com.aerospike.aql.grammar.AQLParser.SetContext;
import com.aerospike.aql.grammar.AQLParser.ShowContext;
import com.aerospike.aql.grammar.AQLParser.StatContext;
import com.aerospike.aql.grammar.AQLParser.StatementContext;
import com.aerospike.aql.grammar.AQLParser.TextValueContext;
import com.aerospike.aql.grammar.AQLParser.UpdateContext;
import com.aerospike.aql.grammar.AQLParser.ValueContext;
import com.aerospike.aql.grammar.AQLParser.ValueListContext;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Info;
import com.aerospike.client.Key;
import com.aerospike.client.Language;
import com.aerospike.client.Operation;
import com.aerospike.client.Record;
import com.aerospike.client.Value;
import com.aerospike.client.admin.Privilege;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.lua.LuaConfig;
import com.aerospike.client.policy.AdminPolicy;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.GenerationPolicy;
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.RecordExistsAction;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.IndexCollectionType;
import com.aerospike.client.query.IndexType;
import com.aerospike.client.query.RecordSet;
import com.aerospike.client.query.ResultSet;
import com.aerospike.client.query.Statement;
import com.aerospike.client.task.IndexTask;
import com.aerospike.client.task.RegisterTask;

public class AQLExecutor extends AQLBaseListener {
	private AerospikeClient client = null;
	private ParseTreeProperty<Value> valueProperty = new ParseTreeProperty<Value>();
	private ParseTreeProperty<Key> keyProperty = new ParseTreeProperty<Key>();
	private ParseTreeProperty<Bin> binProperty = new ParseTreeProperty<Bin>();
	private ParseTreeProperty<List<Value>> valueListProperty = new ParseTreeProperty<List<Value>>();
	private ParseTreeProperty<List<String>> stringListProperty = new ParseTreeProperty<List<String>>();
	private ParseTreeProperty<String> stringProperty = new ParseTreeProperty<String>();
	private ParseTreeProperty<Integer> integerProperty = new ParseTreeProperty<Integer>();
	private ParseTreeProperty<Filter> filterProperty = new ParseTreeProperty<Filter>();
	private ParseTreeProperty<Operation> operationProperty = new ParseTreeProperty<Operation>();
	
	private IResultReporter results = null;
	private boolean verbose;
	private boolean echo;
	private String view;
	private String output;
	private AQLParser parser;
	private static Logger log = Logger.getLogger(AQLExecutor.class);
	private Object result = null;
	private AdminPolicy adminPolicy;
	private InfoPolicy infoPolicy;
	
	

	public AQLExecutor(AQLParser parser, AerospikeClient client, int timeout, IResultReporter reporter) {
		super();
		this.client = client;
		this.parser = parser;
		adminPolicy = new AdminPolicy();
		infoPolicy = new InfoPolicy();
		this.setTimeout(timeout);
		this.setResultsReporter(reporter);
		JSONParser jparser = new JSONParser();
		this.setTimeout(500); // default time out of 500 milliseconds
	}
 
	private void setResultsReporter(IResultReporter reporter) {
		if (reporter == null)
			try {
				this.results = new AQLConsole();
			} catch (IOException e) {
				throw new AQLException("Cannot create console", e);
			}
		else
			this.results = reporter;

	}

	private void setTimeout(int timeout){
		if (this.client!=null){
			this.client.readPolicyDefault.timeout = timeout;
			this.client.writePolicyDefault.timeout = timeout;
			this.client.queryPolicyDefault.timeout = timeout;
			this.client.scanPolicyDefault.timeout = timeout;
			this.client.batchPolicyDefault.timeout = timeout;
			this.adminPolicy.timeout = timeout;
			this.infoPolicy.timeout = timeout;
		}
	}
	@Override
	public void enterStatement(StatementContext ctx) {
		TokenStream tokens = parser.getTokenStream();
		String source = tokens.getText(ctx);
		log.debug("Statement source: " + source);
		echo(source);
	}
    
	@Override
	public void exitConnect(ConnectContext ctx) {
		try {
			
			String host = stripQuotes(ctx.hostName.getText());
			int port = Integer.parseInt(ctx.port.getText());
			ClientPolicy cPolicy = new ClientPolicy();
			if (ctx.timeout != null){
				cPolicy.timeout = Integer.parseInt(ctx.timeout.getText());
			}
			this.client = new AerospikeClient(cPolicy, host, port);
			if (this.client.isConnected())
				results.report("Connected to: " + host + ":" + port);
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
			results.report("Disconnected");
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitCreate(CreateContext ctx) {
		try {
			if (ctx.INDEX() != null){
				String indexName = ctx.index_name().getText();
				String namespace = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				String binName = ctx.binName.getText();
				IndexType type = (ctx.iType.getText().equalsIgnoreCase("STRING")) ? IndexType.STRING : IndexType.NUMERIC;
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
				IndexTask indexTask = client.createIndex(null, namespace, set, indexName, binName, type, collectionType);
				indexTask.waitTillComplete(10);
				results.report(String.format("OK, Index %s added", indexName));
			} else if (ctx.USER() != null) { // its a user
				String user = ctx.user().getText();
				String password = ctx.password().getText();
				List<String> roles = new ArrayList<String>();
				if (ctx.role() != null){
					roles.add(ctx.role().getText());
				} else if (ctx.roles().role().size() > 0){
					for (RoleContext role : ctx.roles().role()){
						roles.add(role.getText());
					}
				}
				client.createUser(adminPolicy, user, password, roles);
				results.report("Created user: " + user);
			} else if (ctx.ROLE() != null){
				String roleName = ctx.role().getText();
				List<Privilege> privileges = new ArrayList<Privilege>();
				for (PrivilegeContext priv : ctx.privilege()) {
					Privilege privilege = priv.priv;
					privileges.add(privilege);
				}
				client.createRole(adminPolicy, roleName, privileges);
				results.report("Created role: " + roleName);
			}
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
				client.dropIndex(null, namespace, set, indexName);
				results.report(String.format("Index %s deleted", indexName));
			} else if (ctx.MODULE() != null) {
				String module = ctx.moduleName().getText();
				String[] infoStrings = infoAll(infoPolicy, client, "udf-remove:filename=" + module);
				results.reportInfo(infoStrings, ";");
			} else if (ctx.SET() != null) {
				String namespace = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				String infoString = info(String.format("set-config:context=namespace;id=%s;set=%s;set-delete=true;", namespace, set));
				results.reportInfo(infoString, ";");
			} else if (ctx.USER() != null){
				String user = ctx.user().getText();
				client.dropUser(adminPolicy, user);
				results.report(String.format("User %s deleted", user));
			} else if (ctx.ROLE() != null){
				String role = ctx.role().getText();
				client.dropRole(adminPolicy, role);
				results.report(String.format("Role %s deleted", role));
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
			WritePolicy writePolicy = new WritePolicy();
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
			results.report("OK, 1 record affected");
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitUpdate(UpdateContext ctx) {
		try {
			WritePolicy writePolicy = new WritePolicy();
			writePolicy.timeout = this.client.writePolicyDefault.timeout;

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
			results.report("OK, 1 record affected");
		} catch (AerospikeException e){
			results.report(e);
		}
	}

	@Override
	public void exitDelete(DeleteContext ctx) {
		try {
			WritePolicy writePolicy = new WritePolicy();
			writePolicy.timeout = this.client.writePolicyDefault.timeout;
			Key key  = keyProperty.get(ctx.primaryKeyPredicate().primaryKey());
			if (ctx.generationPredicate() != null){
				int generation = Integer.parseInt(ctx.generationPredicate().INTLITERAL().getText());
				writePolicy.generation = generation;
				writePolicy.generationPolicy = GenerationPolicy.EXPECT_GEN_EQUAL;
			}
			if (client.delete(writePolicy, key))
				results.report("OK, 1 record affected");
			else
				results.report("Record not found");
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
					Record record = client.get(null, key, binNames);
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
					RecordSet recordSet = client.query(null, stmt);
					results.report(recordSet);
				}
			} else { // its a scan
				String ns = ctx.nameSet().namespaceName;
				String set = ctx.nameSet().setName;
				client.scanAll(null, ns, set, results, binNames);
				results.cancel();
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
				Object result = client.execute(null, key, module, function, arguments);
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

	@Override
	public void exitAggregate(AggregateContext ctx) {
		try {
			
			String namespace = ctx.nameSet().namespaceName;
			String set = ctx.nameSet().setName;
			Statement stmt = new Statement();
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
			stmt.setNamespace(namespace);
			stmt.setSetName(set);
			if (ctx.where() != null){
				Filter filter = filterProperty.get(ctx.where().predicate().filterPredicate());
				stmt.setFilters(filter);
			}
			ResultSet resultSet = client.queryAggregate(null, stmt, 
				module, function, arguments);
			results.report(resultSet);
			
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitOperate(OperateContext ctx) {
		try {
			
			Operation[] operations = new Operation[ctx.operateFunction().size()];
			int index = 0;
			for (OperateFunctionContext fn : ctx.operateFunction()){
				operations[index] = operationProperty.get(fn);
				index++;
			}
			Key key = keyProperty.get(ctx.primaryKeyPredicate().primaryKey());
			WritePolicy writePolicy = new WritePolicy();
			writePolicy.timeout = this.client.writePolicyDefault.timeout;

			if (ctx.generationPredicate() != null){
				int generation = Integer.parseInt(ctx.generationPredicate().INTLITERAL().getText());
				writePolicy.generation = generation;
				writePolicy.generationPolicy = GenerationPolicy.EXPECT_GEN_EQUAL;
			}
			Record record = client.operate(writePolicy, key, operations);
			results.report(record);
		} catch (AerospikeException e){
			results.report(e);
		}
	}

	@Override
	public void exitOperateFunction(OperateFunctionContext ctx) {
		String fn = ctx.getChild(0).getText();
		if (fn.equalsIgnoreCase("add")) {
			String bin = ctx.bin().getText();
			Value value = valueProperty.get(ctx.value());
			operationProperty.put(ctx, Operation.add(new Bin(bin, value)));
		} else if (fn.equalsIgnoreCase("put")){
			String bin = ctx.bin().getText();
			Value value = valueProperty.get(ctx.value());
			operationProperty.put(ctx, Operation.put(new Bin(bin, value)));
		} else if (fn.equalsIgnoreCase("append")){
			String bin = ctx.bin().getText();
			Value value = valueProperty.get(ctx.value());
			operationProperty.put(ctx, Operation.append(new Bin(bin, value)));
		} else if (fn.equalsIgnoreCase("prepend")){
			String bin = ctx.bin().getText();
			Value value = valueProperty.get(ctx.value());
			operationProperty.put(ctx, Operation.prepend(new Bin(bin, value)));
		} else if (fn.equalsIgnoreCase("get")){
			String bin = ctx.bin().getText();
			operationProperty.put(ctx, Operation.get(bin));
		} else if (fn.equalsIgnoreCase("touch")){
			operationProperty.put(ctx, Operation.touch());
		} else if (fn.equalsIgnoreCase("header")){ 
			operationProperty.put(ctx, Operation.getHeader());
		}
	}
	
	@Override
	public void exitShow(ShowContext ctx) {
		try {
			
			if (ctx.NAMESPACES() != null){
				String infoString = info("namespaces");
				String[] namespaceStrings = infoString.split(";");
				List<Map<String,String>> namespaces = new ArrayList<Map<String,String>>();
				for (String namespaceString : namespaceStrings){
					Map<String, String> ns = new HashMap<String, String>();
					ns.put("namespaces", namespaceString);
					namespaces.add(ns);
				}
				Map<String,Object>[] nsArray = new HashMap[namespaces.size()];
				namespaces.toArray(nsArray); 
				results.reportInfo(nsArray);

				//results.reportInfo(info("namespaces"), ";");
			}else if (ctx.INDEXES() != null){
				if (ctx.namespace_name() != null) {
					String nameSpace = ctx.namespace_name().getText();
					results.reportInfo(info("sindex/"+ nameSpace ), ";", ":", "=");
				} else {
					results.reportInfo(info("sindex"), ";", ":", "=");
				}
			}
			else if (ctx.MODULES() != null){
				// filename=redis.lua,hash=93eb0a1bc6085f112c5463d40d5d6fff72b3a4dc,type=LUA;filename=predicate.lua,hash=8206b02a88e306ea6acded648b9c65c0446c8579,type=LUA;filename=qualifiers.lua,hash=dddde723b5f98f99b367d629f45f9b43334da370,type=LUA;
				String infoString = info("udf-list");
				String[] moduleStrings = infoString.split(";");
				List<Map<String, Object>> modules = new ArrayList<Map<String,Object>>();
				for (String moduleString : moduleStrings){
					Map<String, Object> query = stringToMap(moduleString, ",", "=");
					modules.add(query);
				}
				Map<String, Object>[] moduleArray = new HashMap[modules.size()];
				modules.toArray(moduleArray); 
				results.reportInfo(moduleArray);
				//results.reportInfo(info("udf-list"), ";", ":", ",");
			} else if (ctx.BINS() != null){
				String infoString = info("bins");
				String[] namespaceStrings = infoString.split(";");
				List<Map<String, Object>> bins = new ArrayList<Map<String, Object>>();
				for (String namespaceString : namespaceStrings){
					String[] entries = namespaceString.split(",");
					String namespaceName = entries[0].substring(0, entries[0].indexOf(":"));
					String binQuota = entries[1].substring(entries[1].indexOf("=")+1);
					for (int index = 2; index < entries.length; index ++){
						Map<String, Object> bin = new HashMap<String, Object>();
						bin.put("quota", binQuota);
						bin.put("namespace", namespaceName);
						bin.put("bin", entries[index]);
						bins.add(bin);
					}
					
				}
				
				Map<String, Object>[] binsArray = new HashMap[bins.size()];
				bins.toArray(binsArray); 
				results.reportInfo(binsArray);

			} else if (ctx.SETS() != null){
				String infoString = info("sets");
				String[] setStrings = infoString.split(";");
				Map<String, Object>[] sets = new Map[setStrings.length];
				int index = 0;
				for (String setInfo : setStrings){
					Map<String, Object> set = stringToMap(setInfo, ":", "=");
					sets[index] = set;
					index++;
				}
				results.reportInfo(sets);
			} else if (ctx.QUERIES() != null){
				// module=query:trid=1421720214803098000:ns=test:set=demo:status=IN_PROGRESS:mem_usage=29715:run_time=14237301:recs_read=5048:net_io_bytes=130622:priority=10:indexname=shoe_size:
				String infoString = info("jobs:module=query");
				if (infoString !=null){
					String[] queryStrings = infoString.split(";");
					List<Map<String, Object>> queries = new ArrayList<Map<String, Object>>();
					for (String queryString : queryStrings){
						Map<String, Object> query = stringToMap(queryString, ":", "=");
						queries.add(query);
					}
					Map<String, Object>[] queryArray = new HashMap[queries.size()];
					queries.toArray(queryArray); 
					results.reportInfo(queryArray);
				} else {
					results.report("OK");
				}
			} else if (ctx.SCANS() != null){
				//results.reportInfo(info("jobs:module=scan"), ";");
				String infoString = info("jobs:module=scan");
				if (infoString != null){
				String[] scanStrings = infoString.split(";");
				List<Map<String, Object>> scans = new ArrayList<Map<String, Object>>();
				for (String scanString : scanStrings){
					Map<String, Object> query = stringToMap(scanString, ":", "=");
					scans.add(query);
				}
				Map<String, Object>[] queryArray = new HashMap[scans.size()];
				scans.toArray(queryArray); 
				results.reportInfo(queryArray);
				} else {
					results.report("No jobs found");
				}
			}
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	private Map<String, Object> stringToMap(String value, String seperator, String equator) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] entries = value.split(seperator);
		for (String entry : entries){
			String parts[] = entry.split(equator);
			map.put(parts[0], parts[1]);
		}
		return map;
	}

	@Override
	public void exitDesc(DescContext ctx) {
		try {
//			if (ctx.INDEX() != null) {
//				if (ctx.namespace_name() != null) {
//					String nameSpace = ctx.namespace_name().getText(); 
//					String indexName = ctx.index_name().getText();
//					results.reportInfo(info("sindex/"+ nameSpace + "/" + indexName), ";");
//				} else {
//					results.reportInfo(info("sindex"), ":");
//				}
//			} else { // Module
				String name = ctx.moduleName().getText();
				results.reportInfo(info(String.format("udf-get:filename=%s", name)), ";");
//			}
		} catch (AerospikeException e){
			results.report(e);
		}
	}
	
	@Override
	public void exitStat(StatContext ctx) {
		try {
			
			if (ctx.QUERY() != null) {
				results.reportInfo(info("query-stat"), ";");
			} else if (ctx.INDEX() != null) {
				String nameSpace = ctx.namespace_name().getText(); //TODO no clue how to do this
				String indexName = ctx.index_name().getText();
			} else { 
				// cluster_size=1;cluster_key=E137E0853288E5E;cluster_integrity=true;objects=10010;total-bytes-disk=5368709120;used-bytes-disk=2562816;free-pct-disk=99;total-bytes-memory=2147483648;used-bytes-memory=1413903;data-used-bytes-memory=357931;index-used-bytes-memory=640640;sindex-used-bytes-memory=415332;free-pct-memory=99;stat_read_reqs=4;stat_read_reqs_xdr=0;stat_read_success=0;stat_read_errs_notfound=4;stat_read_errs_other=0;stat_write_reqs=10055;stat_write_reqs_xdr=0;stat_write_success=10024;stat_write_errs=31;stat_xdr_pipe_writes=0;stat_xdr_pipe_miss=0;stat_delete_success=3;stat_rw_timeout=0;udf_read_reqs=0;udf_read_success=0;udf_read_errs_other=0;udf_write_reqs=0;udf_write_success=0;udf_write_err_others=0;udf_delete_reqs=0;udf_delete_success=0;udf_delete_err_others=0;udf_lua_errs=0;udf_scan_rec_reqs=0;udf_query_rec_reqs=0;udf_replica_writes=0;stat_proxy_reqs=0;stat_proxy_reqs_xdr=0;stat_proxy_success=0;stat_proxy_errs=0;stat_cluster_key_trans_to_proxy_retry=0;stat_cluster_key_transaction_reenqueue=0;stat_slow_trans_queue_push=0;stat_slow_trans_queue_pop=0;stat_slow_trans_queue_batch_pop=0;stat_cluster_key_regular_processed=0;stat_cluster_key_prole_retry=0;stat_cluster_key_err_ack_dup_trans_reenqueue=0;stat_cluster_key_partition_transaction_queue_count=0;stat_cluster_key_err_ack_rw_trans_reenqueue=0;stat_expired_objects=3;stat_evicted_objects=0;stat_deleted_set_objects=0;stat_evicted_set_objects=0;stat_evicted_objects_time=0;stat_zero_bin_records=0;stat_nsup_deletes_not_shipped=3;err_tsvc_requests=34;err_out_of_space=0;err_duplicate_proxy_request=0;err_rw_request_not_found=0;err_rw_pending_limit=0;err_rw_cant_put_unique=0;fabric_msgs_sent=0;fabric_msgs_rcvd=0;paxos_principal=BB976C89B270008;migrate_msgs_sent=0;migrate_msgs_recv=0;migrate_progress_send=0;migrate_progress_recv=0;migrate_num_incoming_accepted=0;migrate_num_incoming_refused=0;queue=0;transactions=81234;reaped_fds=0;tscan_initiate=8;tscan_pending=2;tscan_succeeded=6;tscan_aborted=0;batch_initiate=0;batch_queue=0;batch_tree_count=0;batch_timeout=0;batch_errors=0;info_queue=0;delete_queue=0;proxy_in_progress=0;proxy_initiate=0;proxy_action=0;proxy_retry=0;proxy_retry_q_full=0;proxy_unproxy=0;proxy_retry_same_dest=0;proxy_retry_new_dest=0;write_master=10055;write_prole=0;read_dup_prole=0;rw_err_dup_internal=0;rw_err_dup_cluster_key=0;rw_err_dup_send=0;rw_err_write_internal=0;rw_err_write_cluster_key=0;rw_err_write_send=0;rw_err_ack_internal=0;rw_err_ack_nomatch=0;rw_err_ack_badnode=0;client_connections=26;waiting_transactions=0;tree_count=0;record_refs=10010;record_locks=0;migrate_tx_objs=0;migrate_rx_objs=0;ongoing_write_reqs=0;err_storage_queue_full=0;partition_actual=4096;partition_replica=0;partition_desync=0;partition_absent=0;partition_object_count=10010;partition_ref_count=4096;system_free_mem_pct=87;sindex_ucgarbage_found=0;sindex_gc_locktimedout=0;sindex_gc_inactivity_dur=34440882;sindex_gc_activity_dur=15125;sindex_gc_list_creation_time=13831;sindex_gc_list_deletion_time=252;sindex_gc_objects_validated=4375760;sindex_gc_garbage_found=0;sindex_gc_garbage_cleaned=0;system_swapping=false;err_replica_null_node=0;err_replica_non_null_node=0;err_sync_copy_null_node=0;err_sync_copy_null_master=0;storage_defrag_corrupt_record=0;err_write_fail_prole_unknown=0;err_write_fail_prole_generation=0;err_write_fail_unknown=0;err_write_fail_key_exists=18;err_write_fail_generation=13;err_write_fail_generation_xdr=0;err_write_fail_bin_exists=0;err_write_fail_parameter=0;err_write_fail_incompatible_type=0;err_write_fail_noxdr=0;err_write_fail_prole_delete=0;err_write_fail_not_found=0;err_write_fail_key_mismatch=0;stat_duplicate_operation=0;uptime=34923;stat_write_errs_notfound=0;stat_write_errs_other=31;heartbeat_received_self=229426;heartbeat_received_foreign=0;query_reqs=43;query_success=30;query_fail=6;query_abort=0;query_avg_rec_count=272;query_short_queue_full=0;query_long_queue_full=0;query_short_running=14;query_long_running=25;query_tracked=8;query_agg=30;query_agg_success=21;query_agg_err=2;query_agg_abort=0;query_agg_avg_rec_count=41;query_lookups=9;query_lookup_success=9;query_lookup_err=0;query_lookup_abort=0;query_lookup_avg_rec_count=1043
				String infoString = info("statistics");
				String statsStrings[] = infoString.split(";");
				Map<String, Object> statsMap = new TreeMap<String, Object>();
				for (String statString : statsStrings){
					String[] parts = statString.split("=");
					statsMap.put(parts[0], parts[1]);
				}
				results.reportInfo(statsMap);
			}
		} catch (AerospikeException e){
			results.report(e);
		}
	}

	@Override
	public void exitSet(SetContext ctx) {

		if (ctx.TIMEOUT() != null) {
			int value = Integer.parseInt(ctx.timeOut.getText());
			setTimeout(value);
			results.report("Set timout to: " + value);
		} else if (ctx.VERBOSE() != null) {
			String value = ctx.verboseOn.getText();
			this.verbose = Boolean.parseBoolean(value);
			results.report("Set verbose to: " + verbose);
		} else if (ctx.ECHO() != null) {
			String value = ctx.echoOn.getText();
			this.echo = Boolean.parseBoolean(value);
			results.report("Set echo to: " + echo);
		} else if (ctx.TTL() != null) {
			int value = Integer.parseInt(ctx.ttl.getText());
			this.client.writePolicyDefault.expiration = value;
			results.report("Set TTL to: " + this.client.writePolicyDefault.expiration);
		} else if (ctx.OUTPUT() != null) {
			String value = ctx.viewType().getText();
			this.output = value;
			if (value.equalsIgnoreCase("json"))
				results.setViewFormat(ViewFormat.JSON);
			else if (value.equalsIgnoreCase("table"))
				results.setViewFormat(ViewFormat.TABLE);
			else
				results.setViewFormat(ViewFormat.TEXT);
			results.report("Set output to: " + this.output);
		} else if (ctx.LUA_USER_PATH() != null) { 
			String value = ctx.luaUserPath.getText();
			LuaConfig.SourceDirectory = stripQuotes(value);
			results.report("Set path to: " + LuaConfig.SourceDirectory);
		} else if (ctx.PASSWORD() != null){
			String password = ctx.password().getText();
			String user = ctx.user().getText();
			//TODO
			
					
		}
	}

	@Override
	public void exitGrant(GrantContext ctx) {
		List<String> roles = new ArrayList<String>();
		String user = null;
		if (ctx.ROLE() != null){
			roles.add(ctx.role().getText());
			user = ctx.user().getText();
			client.grantRoles(adminPolicy, user, roles);
		} else if (ctx.ROLES() != null){
			for (RoleContext role : ctx.roles().role()){
				roles.add(role.getText());
			}
			user = ctx.user().getText();
			client.grantRoles(adminPolicy, user, roles);
		} else if (ctx.PRIVILEGE() != null){
			//TODO
		} else if (ctx.PRIVILEGES() != null){
			//TODO
		}
		
	}
	
	@Override
	public void exitRevoke(RevokeContext ctx) {
		List<String> roles = new ArrayList<String>();
		if (ctx.ROLE() != null){
			roles.add(ctx.role().getText());
		} if (ctx.ROLES() != null){
			for (RoleContext role : ctx.roles().role()){
				roles.add(role.getText());
			}
		}
		String user = ctx.user().getText();
		client.revokeRoles(adminPolicy, user, roles);
	}
	
	@Override
	public void exitGet(GetContext ctx) {
		
		if (ctx.TIMEOUT() != null) {
			results.report("Timeout is: " + this.client.writePolicyDefault.timeout);
		} else if (ctx.VERBOSE() != null) {
			results.report("Verbose is: " + this.verbose);
		} else if (ctx.ECHO() != null) {
			results.report("Echo is: " + this.verbose);
		} else if (ctx.TTL() != null) {
			results.report("TTL is: " + this.client.writePolicyDefault.expiration);
		} else if (ctx.OUTPUT() != null) {
			results.report("Output is: " + this.output);
		} else {// if (ctx.LUA_USER_PATH() != null) { 
			results.report("Path is: " + LuaConfig.SourceDirectory.toString());
		} 
	}
	
	
	@Override
	public void exitQuit(QuitContext ctx) {
		
		results.report("Exiting AQL...");
		results.close();
		System.exit(0);
	}
	
	@Override
	public void exitHelp(HelpContext ctx)  {
		try {
			InputStream input = getClass().getResourceAsStream("/com/aerospike/aql/commands.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line).append("\n");
			}
			results.report(out.toString());
		} catch (IOException e) {
			log.error("Cannot read commant.txt", e);
		}
	}
	
	@Override
	public void exitPrint(PrintContext ctx) {
		
		String value = stripQuotes(ctx.STRINGLITERAL().getText());
		results.report(value);
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

	private String info(String infoString) {
		if (client != null && client.isConnected()){
			String answer = Info.request(infoPolicy, client.getNodes()[0], infoString);
			log.debug(answer);
			return answer;
		} else {
			return "Client not connected";
		}
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
		String keyText = ctx.key.getText();
		String namespace = ctx.nameSpace;
		String set = ctx.setName;
		Value value = makeValue(keyText);
		Key key = new Key(namespace, set, value);
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
		String svalue = stripQuotes(ctx.getText());
		Value value;
		if (svalue.startsWith("JSON[")) {// make a list
			JSONArray jObject = (JSONArray) JSONValue.parse(svalue.substring(4));
			value = Value.get(jObject);
		} else if (svalue.startsWith("JSON{")){// make a map
			JSONObject jObject = (JSONObject) JSONValue.parse(svalue.substring(4));
			value = Value.get(jObject);
		} else {
			value = Value.get(svalue);
		}
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
	
	private void echo(String source){
		if (this.echo)
			results.report(source);
	}

}
