package oolwre;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.glfw.GLFWImage;

import oolwre.image.Image;
import oolwre.util.convert.ImageConverts;

/**The <code>WindowIcon</code> class represents
 * {@link Window} application icon with various
 * sizes. The OS will automatically choose the
 * image that fits the most.
 */
public class WindowIcon {
	
	private Map<Integer, Image> images;
	private int count;
	
	/**Constructs a {@link WindowIcon} with the specified images.
	 * 
	 * @param images - The images
	 */
	public WindowIcon(Image... images) {
		this.images = new HashMap<>();
		for (Image image : images) {
			this.addImage(image);
		}
	}
	
	/**Adds the {@link Image} to the {@link WindowIcon}.<br>
	 * This will override any {@link Image} that had the same
	 * size.
	 * 
	 * @param image - The image to be added
	 * 
	 * @return The last {@link Image} with the same size as
	 * the argument, or <code>null</code> if none before
	 */
	public Image addImage(Image image) {
		this.checkImageDimensions(image);
		Image last = this.images.get(image.getWidth());
		this.images.put(image.getWidth(), image);
		if (last == null) {
			this.count++;
		}
		return last;
	}
	
	/**Removes the {@link Image} from the {@link WindowIcon}.
	 * 
	 * @param image - The image to be removed
	 * 
	 * @return Whether or not an {@link Image} was removed
	 */
	public boolean removeImage(Image image) {
		Image last = this.images.get(image.getWidth());
		if (last == image) {
			this.images.remove(image.getWidth());
			this.count--;
			return true;
		}
		return false;
	}
	
	/**Removes the {@link Image} of size <code>size</code>
	 * from the {@link WindowIcon}.
	 * 
	 * @param size - The size of the image to be removed
	 * 
	 * @return Whether or not an {@link Image} was removed
	 */
	public boolean removeImageOfSize(int size) {
		if (this.images.containsKey(size)) {
			this.images.remove(size);
			this.count--;
			return true;
		}
		return false;
	}
	
	/**Returns the current {@link Image} count.
	 * 
	 * @return The image count
	 */
	public int getImageCount() {
		return this.count;
	}
	
	/**Returns a {@link GLFWImage}.{@link GLFWImage.Buffer Buffer}
	 * containing all the images from the {@link WindowIcon}.
	 * 
	 * @return A buffer of images
	 */
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
