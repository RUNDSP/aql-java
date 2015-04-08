package com.aerospike.aql;


@SuppressWarnings("serial")
public class AQLException extends RuntimeException {

	public AQLException(String message, Throwable e) {
		super(message, e);
	}

	public AQLException(String message) {
		super (message);
	}

}
