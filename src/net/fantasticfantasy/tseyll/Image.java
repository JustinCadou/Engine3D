package net.fantasticfantasy.tseyll;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

public class Image {
	
	private FloatBuffer pixels;
	protected Format format;
	protected final int width;
	protected final int height;
	private final int size;
	
	public Image(int width, int height, Format format) {
		this.size = width * height * format.compSize;
		this.pixels = BufferUtils.createFloatBuffer(this.size);
		this.format = format;
		this.width = width;
		this.height = height;
		this.fillInEmptyImage();
	}
	
	public void setPixelColorValue(int x, int y, float... data) {
		if (x < 0 || x >= this.width) {
			throw new IndexOutOfBoundsException("x (" + x + ") is out of bounds (0 - " + this.width + ")");
		} else if (y < 0 || y >= this.height) {
			throw new IndexOutOfBoundsException("y (" + y + ") is out of bounds (0 - " + this.height + ")");
		} else if (data.length != this.size) {
			throw new IllegalArgumentException("Data length does not match comp size (" + data.length + " != " + this.size + ")");
		}
		this.pixels.put(x + (y * this.width), data[0]);
	}
	
	private void fillInEmptyImage() {
		for (int i = 0; i < this.size; i++) {
			this.pixels.put(0);
		}
	}
	
	public static enum Format {
		RGB(3),
		RGBA(4),
		ARGB(4),
		GRAYSCALE(1);
		
		private int compSize;
		
		Format(int compSize) {
			this.compSize = compSize;
		}
	}
}
