package com.aerospike.aql.v2;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.aerospike.aql.v2.grammar.AQLBaseListener;
import com.aerospike.aql.v2.grammar.AQLParser.PrintContext;
import com.aerospike.aql.v2.grammar.AQLParser.ShowContext;
import com.aerospike.aql.v2.grammar.AQLParser.StatementsContext;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Info;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.InfoPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;

public class AQLExecutor extends AQLBaseListener {
	private AerospikeClient client = null;
	private ClientPolicy cPolicy = null;
	private InfoPolicy infoPolicy = null;
	private Policy policy = null;
	private WritePolicy writePolicy = null;
	private QueryPolicy queryPolicy = null;
	private ScanPolicy scanPolicy = null;
	
	private static final String AEROSPIKE_CLIENT_IS_NULL = "Aerospike client is null or not connected";
	private static Logger log = Logger.getLogger(AQLExecutor.class);
	
	

	public AQLExecutor(AerospikeClient client, int timeout) {
		super();
		this.client = client;
		this.cPolicy = new ClientPolicy();
		this.cPolicy.timeout = timeout;
		this.infoPolicy = new InfoPolicy();
		this.infoPolicy.timeout = timeout;
	}
 
	@Override
	public void exitShow(ShowContext ctx) {
		if (this.client != null && this.client.isConnected()){
		if (ctx.NAMESPACES() != null)
			printInfo(info("namespaces"));
		else if (ctx.INDEXES() != null)
			printInfo(info("sindex-describe")); //TODO namespace and set
		else if (ctx.MODULES() != null)
			printInfo(info("udf-list"));
		else if (ctx.BINS() != null)
			printInfo(info("bins"));
		else if (ctx.SETS() != null)
			printInfo(info("sets"));
		else if (ctx.QUERIES() != null)
			printInfo(info("jobs:module=query"));
		else if (ctx.SCANS() != null)
			printInfo(info("jobs:module=scan"));
		} else {
			throw new AQLException(AEROSPIKE_CLIENT_IS_NULL);
		}
	}

    @Override
    public void exitStatements(StatementsContext ctx) {
		if (this.client != null && this.client.isConnected()){
			//TODO
		} else {
			throw new AQLException(AEROSPIKE_CLIENT_IS_NULL);
		}

    }
    @Override
    public void exitPrint(PrintContext ctx) {
		if (this.client != null && this.client.isConnected()){
			System.out.println(stripQuotes(ctx.STRINGLITERAL().getText()));
		} else {
			throw new AQLException(AEROSPIKE_CLIENT_IS_NULL);
		}
    }
    
	private String info(String command){
		if (this.client != null && this.client.isConnected()){
			Node nodes[] = this.client.getNodes();
			return Info.request(this.infoPolicy, nodes[0],  command);
		} else {
			throw new AQLException(AEROSPIKE_CLIENT_IS_NULL);
		}
	}
    
    
	private String[] infoAll(String command){
		Node nodes[] = this.client.getNodes();
		String[] infoStrings = new String[nodes.length];
		int index = 0;
		for (Node node : nodes){
			infoStrings[index] = Info.request(this.infoPolicy, node,  command);
			index++;
		}
		return infoStrings;
	}
	private void printInfo(String infoString){
		System.out.println(infoString);
	}
	private void printInfo(String[] infoStrings){
		for (String infoString : infoStrings){
			printInfo(infoString);
		}
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
