package com.cruat.spawn.placement.logos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class PlacementProcessorTest {

	@Test
	public void process_validPlacements_correctPlacementOrder() {
		int[] top = new int[] { 1, 2 };
		int[] bot = new int[] { 3, 4 };

		int[][] placements = new int[][] { top, bot };
		
		PlacementProcessor processor = new PlacementProcessor(placements);
		List<Placement> processed = processor.process();

		assertThat(processed.size(), equalTo(4));
		assertThat(processed.get(0).getHumanReadable(), equalTo("{1, 0, 0}"));
		assertThat(processed.get(1).getHumanReadable(), equalTo("{3, 16, 0}"));
		assertThat(processed.get(2).getHumanReadable(), equalTo("{2, 0, 16}"));
		assertThat(processed.get(3).getHumanReadable(), equalTo("{4, 16, 16}"));
	}
	
	@Test
	public void process_validPlacements_zeroOmitted() {
		int[] top = new int[] { 0, 1 };
		int[] bot = new int[] { 2, 3 };

		int[][] placements = new int[][] { top, bot };
		
		PlacementProcessor processor = new PlacementProcessor(placements);
		List<Placement> processed = processor.process();

		assertThat(processed.size(), equalTo(3));
		assertThat(processed.get(0).getHumanReadable(), equalTo("{2, 16, 0}"));
		assertThat(processed.get(1).getHumanReadable(), equalTo("{1, 0, 16}"));
		assertThat(processed.get(2).getHumanReadable(), equalTo("{3, 16, 16}"));
	}
}
