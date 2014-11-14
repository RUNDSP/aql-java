package com.aerospike.aql.grammar;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;

public class NoCaseFileStream extends ANTLRFileStream {
    public NoCaseFileStream(String fileName) throws IOException {
        super(fileName, null);
    }

    public NoCaseFileStream(String fileName, String encoding)
    throws IOException {
        super(fileName, encoding);
    }


    public NoCaseFileStream(File source) throws IOException {
    	super(source.getAbsolutePath());
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
