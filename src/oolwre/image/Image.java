package oolwre.image;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**An <code>Image</code> represents an abstract
 * image that contains width, height and data.
 */
public abstract class Image {
	
	protected int width;
	protected int height;
	
	/**Constructor
	 * 
	 * @param width - The width
	 * @param height - The height
	 */
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	/**Returns this {@link Image}'s width.
	 * 
	 * @return The width
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**Returns this {@link Image}'s height
	 * 
	 * @return The height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**Returns the {@link Buffer} containing the pixel
	 * data of the {@link Image}.
	 * 
	 * @return The {@link Buffer} containing the data,
	 * more preferably a {@link ByteBuffer}.
	 */
	public abstract Buffer getBuffer();
}
