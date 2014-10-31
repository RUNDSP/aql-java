package com.aerospike.aql.v2.grammar;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;

public class NoCaseInputStream extends ANTLRInputStream {
	
	

	public NoCaseInputStream(InputStream input) throws IOException {
		super(input);
	}


	public NoCaseInputStream() {
		super();
	}


	public NoCaseInputStream(char[] data, int numberOfActualCharsInArray) {
		super(data, numberOfActualCharsInArray);
	}


	public NoCaseInputStream(InputStream input, int initialSize,
			int readChunkSize) throws IOException {
		super(input, initialSize, readChunkSize);
	}


	public NoCaseInputStream(InputStream input, int initialSize)
			throws IOException {
		super(input, initialSize);
	}


	public NoCaseInputStream(Reader r, int initialSize, int readChunkSize)
			throws IOException {
		super(r, initialSize, readChunkSize);
	}


	public NoCaseInputStream(Reader r, int initialSize) throws IOException {
		super(r, initialSize);
	}


	public NoCaseInputStream(Reader r) throws IOException {
		super(r);
	}


	public NoCaseInputStream(String input) {
		super(input);
	}


	public int LA(int i) {
        if ( i==0 ) {
            return 0; // undefined
        }
        if ( i<0 ) {
            i++; // e.g., translate LA(-1) to use offset 0
        }

        if ( (p+i-1) >= n ) {

            return CharStream.EOF;
        }
        return Character.toLowerCase(data[p+i-1]);
    }

}
