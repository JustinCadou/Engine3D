package net.fantasticfantasy.tseyll.image;

import java.nio.Buffer;

public abstract class Image {
	
	protected int width;
	protected int height;
	
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public abstract Buffer getBuffer();
}
