package oolwre.image;

import java.nio.ByteBuffer;

/**A <code>SafeImage</code> is an {@link Image} that is safe to be used
 * outside of the <code>image</code> package.
 * 
 * @see {@link Image#toSafeImage()}
 */
public abstract class SafeImage extends Image {
	
	/* (non-Javadoc)
	 * @see oolwre.image.Image#Image(int, int)
	 */
	public SafeImage(int width, int height) {
		super(width, height);
	}
	
	/* (non-Javadoc)
	 * @see oolwre.image.Image#getBuffer()
	 */
	public abstract ByteBuffer getBuffer();
	
	/**Generates a {@link SafeImage} from <code>img</code>.
	 * 
	 * @param img - The source {@link Image}.
	 * 
	 * @return A {@link SafeImage}
	 */
	static SafeImage fromSafeSource(Image img) {
		return new SafeImage(img.width, img.height) {
			public ByteBuffer getBuffer() {
				return (ByteBuffer) img.getBuffer();
			}
		};
	}
}
