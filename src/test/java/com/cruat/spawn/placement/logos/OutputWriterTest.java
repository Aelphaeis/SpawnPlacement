package com.cruat.spawn.placement.logos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OutputWriterTest {

	@Test
	public void writePlacements_placementsWritten() throws IOException {
		List<Placement> placements = new ArrayList<>();
		placements.add(new Placement(2, 1, 0));
		placements.add(new Placement(1, 0, 1));
		placements.add(new Placement(3, 1, 1));

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try (OutputWriter writer = new OutputWriter(outStream)) {
			writer.writePlacements(placements);
			outStream.writeTo(System.out);
		}
	}
}
