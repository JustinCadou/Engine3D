package oolwre.image;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;

/**An <code>Image</code> represents an abstract
 * image that contains width, height and data.
 * 
 * @see {@link SafeImage}
 * @see {@link #toSafeImage()}
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
	
	/**Returns a {@link SafeImage} containing the exact same data.<br>
	 * Will return <code>this</code> if already a {@link SafeImage}.
	 * 
	 * @return <code>this</code> as a {@link SafeImage}.
	 * 
	 * @throws UnsafeImageException If <code>this</code> is not safe<br>
	 * <code>&nbsp;</code>({@link #getBuffer()} does not returns a {@link ByteBuffer})
	 * @throws NullPointerException If {@link #getBuffer()} returns <code>null</code>
	 */
	public final SafeImage toSafeImage() throws UnsafeImageException {
		if (this instanceof SafeImage) {
			return (SafeImage) this;
		}
		Buffer buffer = this.getBuffer();
		if (buffer == null) {
			throw new NullPointerException("Buffer is null!");
		} else if (buffer instanceof ByteBuffer) {
			return SafeImage.fromSafeSource(this);
		} else {
			throw new UnsafeImageException(buffer);
		}
	}
	
	/**Returns the {@link Buffer} containing the pixel
	 * data of the {@link Image}.
	 * 
	 * @return The {@link Buffer} containing the data,
	 * <i>really</i> more preferably a {@link ByteBuffer}.
	 */
	public abstract Buffer getBuffer();
	
	public static enum Format {
		R(GL11.GL_RED);
		
		private int value;
		
		Format(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
	}
}
