// Generated from ASinfo.g4 by ANTLR 4.3

package com.aerospike.aql.v2.grammar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ASinfoParser}.
 */
public interface ASinfoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ASinfoParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(@NotNull ASinfoParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASinfoParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(@NotNull ASinfoParser.ResultContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASinfoParser#nameValue}.
	 * @param ctx the parse tree
	 */
	void enterNameValue(@NotNull ASinfoParser.NameValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASinfoParser#nameValue}.
	 * @param ctx the parse tree
	 */
	void exitNameValue(@NotNull ASinfoParser.NameValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASinfoParser#outerElement}.
	 * @param ctx the parse tree
	 */
	void enterOuterElement(@NotNull ASinfoParser.OuterElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASinfoParser#outerElement}.
	 * @param ctx the parse tree
	 */
	void exitOuterElement(@NotNull ASinfoParser.OuterElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASinfoParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull ASinfoParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASinfoParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull ASinfoParser.BoolContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASinfoParser#innerElement}.
	 * @param ctx the parse tree
	 */
	void enterInnerElement(@NotNull ASinfoParser.InnerElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASinfoParser#innerElement}.
	 * @param ctx the parse tree
	 */
	void exitInnerElement(@NotNull ASinfoParser.InnerElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link ASinfoParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ASinfoParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ASinfoParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ASinfoParser.ValueContext ctx);
}