package com.aerospike.aql.v2;


@SuppressWarnings("serial")
public class AQLException extends RuntimeException {

	public AQLException(String message, Throwable e) {
		super(message, e);
	}

	public AQLException(String message) {
		super (message);
	}

}
