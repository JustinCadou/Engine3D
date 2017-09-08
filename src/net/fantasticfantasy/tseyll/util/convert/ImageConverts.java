package net.fantasticfantasy.tseyll.util.convert;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.glfw.GLFWImage;
import net.fantasticfantasy.tseyll.image.Image;

/**The <code>ImageConverts</code> class is used to convert images
 * from different libraries.
 */
public class ImageConverts {
	
	/**@STATIC_MODULE_CLASS*/
	private ImageConverts() {}
	
	/**Converts a <code>Tseyll</code> {@link Image} to a {@link GLFWImage}.
	 * 
	 * @param image - The {@link Image} to be converted
	 * 
	 * @return The {@link GLFWImage} result
	 */
	public static GLFWImage toGLFWImage(Image image) {
		GLFWImage glfwimage = GLFWImage.create();
		Buffer buffer = image.getBuffer();
		if (!(buffer instanceof ByteBuffer)) {
			throw new IllegalArgumentException("Image java.nio.Buffer must be of type java.nio.ByteBuffer" +
					" in order to be converted (Got " + buffer.getClass().getName() + " instead)");
		}
		buffer.flip();
		glfwimage.set(image.getWidth(), image.getHeight(), (ByteBuffer) buffer);
		return glfwimage;
	}
}
