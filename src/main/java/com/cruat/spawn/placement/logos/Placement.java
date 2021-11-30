package com.cruat.spawn.placement.logos;

public class Placement {

	private final int id;
	private final int x;
	private final int y;

	public Placement(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getHumanReadable() {
		return String.format("{%d, %d, %d}", id, y * 16, x * 16);
	}
}
