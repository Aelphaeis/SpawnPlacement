package com.cruat.spawn.placement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.cruat.spawn.placement.logos.InputParser;
import com.cruat.spawn.placement.logos.OutputWriter;
import com.cruat.spawn.placement.logos.Placement;
import com.cruat.spawn.placement.logos.PlacementProcessor;

public class Program {

	public static void main(String[] args) throws IOException {
		String inFile = args[1];
		String outFile = args[2];

		int[][] content;
		try (InputParser parser = new InputParser(new File(inFile))) {
			content = parser.getContent();
		}
		
		PlacementProcessor processor = new PlacementProcessor(content);
		List<Placement> placements = processor.process();
		
		try(OutputWriter writer = new OutputWriter(new File(outFile))){
			writer.writePlacements(placements);
		}
	}
}