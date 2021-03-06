/* 
 * Copyright 2012-2015 Aerospike, Inc.
 *
 * Portions may be licensed to Aerospike, Inc. under one or more contributor
 * license agreements.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.aerospike.aql;

import java.io.File;
import java.net.URL;

import org.antlr.runtime.CommonTokenStream;

import com.aerospike.aql.AQLGenerator.Language;
import com.aerospike.aql.IResultReporter.ViewFormat;
import com.aerospike.client.AerospikeClient;

public class AQLTest {
	public static final int JAVA = 1;
	public static final int C = 2;
	public static final int NONE = 0;

	protected String seedNode = "127.0.0.1";
	protected int port = 3000; 
	protected int stType = NONE;

	//protected StringTemplateGroup group = null;
	protected CommonTokenStream tokenStream;
	protected String workingDir;
	protected String templatePath;
	protected String testDataPath;
	protected AerospikeClient client;

	public AQLTest() {
		workingDir = System.getProperty("user.dir");
		templatePath = workingDir + "/Templates/";
		testDataPath = workingDir + "/TestData/";
		String seedHost = System.getenv("seedHost");
		String port = System.getenv("port");
		if (seedHost != null)
			this.seedNode = seedHost;
		if (port != null)
			this.port = Integer.parseInt(port);
		System.out.printf("Host: %s, Port: %d\n", this.seedNode, this.port);
	}

	public void setSeedNode(String seedNode, int port){
		this.seedNode = seedNode;
		this.port = port;
		System.out.printf("Host: %s, Port: %d\n", this.seedNode, this.port);
	}
	
	protected File findFile(String name){
		URL url = this.getClass().getClassLoader().getResource(name);
		return new File(url.getPath());
	}


	protected void testFileGeneration(String name, Language stType) throws Exception{
		String extension = null;
		String langDir = null;
		switch(stType){
		case PYTHON:
			extension = ".py";
			langDir = "python/";
			break;
		case PHP:
			extension = ".php";
			langDir = "php/";
			break;
		case GO:
			extension = ".go";
			langDir = "go/";
			break;
		case NODE:
			extension = ".js";
			langDir = "node/";
			break;
		case JAVA:
			extension = ".java";
			langDir = "java/";
			break;
		case CSHARP:
			extension = ".cs";
			langDir = "cs/";
			break;
		default:
			throw new Exception("Invalid Template Type. Myst be PYTHON, JAVA or C");
		}
		File dir = new File(workingDir +"/CodeGeneration/" + langDir);
		if (!dir.exists())
			dir.mkdirs();
		// if file doesnt exists, then create it
		String outFileName = name.substring(0, name.lastIndexOf(".")) + extension;
		File file = new File(workingDir +"/CodeGeneration/" + langDir + outFileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		//URL url = getClass().getResource("/"+name);
		File sourceFile = findFile(name);
		System.out.println(sourceFile.exists());
		AQL aql = new AQL();
		aql.generate(sourceFile, file, stType);
	}

	
	private void mkDirs(File root, String[] dirs, int depth) {
		if (depth == 0) return;
		for (String s : dirs) {
			File subdir = new File(root, s);
			subdir.mkdir();
			mkDirs(subdir, dirs, depth - 1);
		}
	}
	
	protected void testFileSyntax(String name) throws Exception{
		AQL aql = new AQL();
		aql.compile(findFile(name));
	}
	
	protected String testStringGeneration(String source, Language language) throws Exception{
		AQL aql = new AQL();
		String result = aql.generate(source, language);
		return result;
	}

	protected void testStringSyntax(String source) throws Exception{
		AQL aql = new AQL();
		aql.compile(source);
	}

	
	protected void testFileExecution(String seedNode, int port, String fileName) throws Exception{
		setSeedNode(seedNode, port);
		testFileExecution(fileName);
	}
	
	protected void testFileExecution(String fileName) throws Exception{
		if (this.client == null)
			this.client = new AerospikeClient(this.seedNode, this.port);
		AQL aql = new AQL(client, 20, ViewFormat.TABLE);
		aql.execute(findFile(fileName));
	}
}
