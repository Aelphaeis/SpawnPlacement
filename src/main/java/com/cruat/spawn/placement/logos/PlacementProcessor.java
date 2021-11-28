package com.cruat.spawn.placement.logos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlacementProcessor {

	private final int[][] placements;

	public PlacementProcessor(int[][] placements) {
		Objects.requireNonNull(placements);

		if (placements.length == 0) {
			String err = "Input Array is empty";
			throw new IllegalArgumentException(err);
		}

		int expectedHeight = placements[0].length;
		for (int x = 0; x < placements.length; x++) {
			if (placements[x].length != expectedHeight) {
				String err = new StringBuilder()
						.append("Expected perfect rectangle; however,")
						.append("the row index ")
						.append(x)
						.append(" has a length of ")
						.append(placements[x].length)
						.append("when we expected a length of ")
						.append(expectedHeight)
						.append(". This length is resolved from the length")
						.append(" of the first row.")
						.toString();
				throw new IllegalArgumentException(err);
			}
		}

		this.placements = placements;
	}

	public List<Placement> process() {
		List<Placement> result = new ArrayList<>();
		for (int y = 0; y < placements[0].length; y++) {
			for (int x = 0; x < placements.length; x++) {
				if (placements[x][y] != 0) {
					int id = placements[x][y];
					result.add(new Placement(id, x, y));
				}
			}
		}
		return result;
	}
}
