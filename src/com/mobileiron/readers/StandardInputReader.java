package com.mobileiron.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInputReader implements InputReader {

	BufferedReader reader;
	
	public StandardInputReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public String readData() throws IOException {
		String line="";
		if((line = reader.readLine()) != null)
				return line;
		return null;
	}

	@Override
	public Boolean hasMoreData() throws IOException {
		return reader.ready();
	}

}
