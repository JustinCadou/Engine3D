package net.fantasticfantasy.engine3d.image;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

public class ColoredImage extends Image {
	
	private FloatBuffer buffer;
	private int compCount;
	private final int size;
	
	public ColoredImage(int width, int height, int compCount) {
		if (width < 0) {
			throw new IllegalArgumentException("width < 0 (" + width + ")");
		} else if (height < 0) {
			throw new IllegalArgumentException("height < 0 (" + height + ")");
		} else if (compCount <= 0) {
			throw new IllegalArgumentException("compCount <= 0 (" + compCount + ")");
		}
		this.width = width;
		this.height = height;
		this.compCount = compCount;
		this.size = width * height * compCount;
		this.buffer = BufferUtils.createFloatBuffer(this.size);
		this.fillEmptyImage();
	}
	
	private void fillEmptyImage() {
		for (int i = 0; i < this.size; i++) {
			this.buffer.put(0);
		}
	}
	
	public float[] getColorValue(int x, int y) {
		this.check(x, y);
		float[] res = new float[this.compCount];
		this.buffer.position((x + (y * this.width)) * this.compCount);
		for (int i = 0; i < this.compCount; i++) {
			res[i] = this.buffer.get();
		}
		return res;
	}
	
	public int getComponentCount() {
		return this.compCount;
	}
	
	public FloatBuffer getBuffer() {
		return this.buffer;
	}
	
	private void check(int x, int y) {
		if (x < 0 || x >= this.width) {
			throw new IllegalArgumentException("x (" + x + ") < 0 || x >= width (" + this.width + ")");
		}
		if (y < 0 || y >= this.height) {
			throw new IllegalArgumentException("y (" + y + ") < 0 || y >= height (" + this.height + ")");
		}
	}
}
