package com.aerospike.aql.grammar;

import java.util.HashMap;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Info;
import com.aerospike.client.cluster.Node;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;

/**
 * This class is a tree parser that can execute operations on an aerospike cluster
 * @author peter
 *
 */
public class ExecutorParser extends TreeParser{

	enum ViewType {
		JSON,
		TABLE
	}
	protected AerospikeClient client;
	protected IErrorReporter errorReporter;
	protected IResultReporter resultReporter;
	protected Policy policy;
	protected WritePolicy writePolicy;
	public ViewType viewType;

	public ExecutorParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public ExecutorParser(TreeNodeStream input) {
		super(input);
	}
	public ExecutorParser(TreeNodeStream input, AerospikeClient client) {
		this(input);
		this.client = client;
		this.policy = new Policy();
		this.policy.timeout = 0;
		this.writePolicy = new WritePolicy();
	}

	public ExecutorParser(TreeNodeStream input, RecognizerSharedState state, AerospikeClient client) {
		this(input, state);
		this.client = client;
		this.policy = new Policy();
		this.policy.timeout = 0;
		this.writePolicy = new WritePolicy();
	}

	protected Node randomNode(){
		if (isConnected())
			return client.getNodes()[0];
		else
			return null;
	}

	protected boolean isConnected(){
		return (this.client != null && this.client.isConnected());
	}

	protected HashMap<String, String> info(String... cmds) throws AerospikeException{
		Node node = randomNode();
		if (node != null)
			return Info.request(node.getHost().name, node.getHost().port, cmds);
		return null;
	}
	protected String info(String cmd) throws AerospikeException{
		Node node = randomNode();
		if (node != null) {
			return Info.request(node.getHost().name, node.getHost().port, cmd);
		}
		return null;
	}
	protected void printInfo(String title, String infoString){
		String[] outerParts = infoString.split(";");
		System.out.println(title);
		for (String s : outerParts){

			String[] innerParts = s.split(":");
			for (String parts : innerParts){
				System.out.println("\t" + parts);
			}
			System.out.println();
		}
		
	}

	public IErrorReporter getErrorReporter() {
		return errorReporter;
	}


	public void setErrorReporter(IErrorReporter errorReporter) {
		this.errorReporter = errorReporter;
	}

	public IResultReporter getResultReporter() {
		return resultReporter;
	}

	public void setResultReporter(IResultReporter resultReporter) {
		this.resultReporter = resultReporter;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (isConnected())
			this.client.close();
	}

}
