package com.cruat.spawn.placement.logos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputWriter implements AutoCloseable {

	private static final String FMT = "const short Spawns [%d][3] = {%s};";
	private final OutputStream stream;

	public OutputWriter(File file) throws FileNotFoundException {
		this(new FileOutputStream(file));
	}

	public OutputWriter(OutputStream outStream) {
		this.stream = Objects.requireNonNull(outStream);
	}

	public void writePlacements(List<Placement> placements) throws IOException {
		String body = placements.stream()
				.map(Placement::getHumanReadable)
				.collect(Collectors.joining(", "));

		String output = String.format(FMT, placements.size(), body);

		OutputStreamWriter writer = new OutputStreamWriter(stream);
		writer.write(output);
		writer.flush();
	}

	@Override
	public void close() throws IOException {
		this.stream.close();
	}
}
