package com.cruat.spawn.placement.logos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Parses a CSV file.
 * 
 * @author Aelphaeis
 *
 */
public class InputParser implements AutoCloseable {

	private final InputStream inStream;

	public InputParser(File file) throws FileNotFoundException {
		this(new FileInputStream(file));
	}

	public InputParser(InputStream stream) {
		this.inStream = stream;

	}

	public int[][] getContent() {
		InputStreamReader inStreamReader = new InputStreamReader(inStream);
		BufferedReader reader = new BufferedReader(inStreamReader);
		return reader.lines()
				.map(p -> p.split(","))
				.map(p -> Arrays.stream(p)
						.mapToInt(Integer::parseInt)
						.toArray())
				.collect(Collectors.toList())
				.toArray(new int[0][0]);
	}

	@Override
	public void close() throws IOException {
		this.inStream.close();
	}
}
