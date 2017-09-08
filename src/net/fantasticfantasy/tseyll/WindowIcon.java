package net.fantasticfantasy.tseyll;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.glfw.GLFWImage;
import net.fantasticfantasy.tseyll.image.Image;
import net.fantasticfantasy.tseyll.util.convert.ImageConverts;

public class WindowIcon {
	
	private Map<Integer, Image> images;
	private int count;
	
	public WindowIcon(Image... images) {
		this.images = new HashMap<>();
		for (Image image : images) {
			this.addImage(image);
		}
	}
	
	public void addImage(Image image) {
		this.checkImageDimensions(image);
		this.images.put(image.getWidth(), image);
		this.count++;
	}
	
	protected GLFWImage.Buffer toBuffer() {
		GLFWImage.Buffer buffer = GLFWImage.malloc(this.count);
		Collection<Image> values = this.images.values();
		for (Image image : values) {
			buffer.put(ImageConverts.toGLFWImage(image));
		}
		buffer.position(0);
		return buffer;
	}
	
	private void checkImageDimensions(Image image) {
		if (image.getWidth() != image.getHeight()) {
			throw new IllegalArgumentException("Image width (" + image.getWidth() +
					") != Image height (" + image.getHeight() + ")");
		}
	}
}
