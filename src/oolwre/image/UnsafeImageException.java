package oolwre.image;

import java.nio.Buffer;

/**An <code>UnsafeImageException</code> is thrown when attempting to
 * create a {@link SafeImage} from an unsafe {@link Image}.
 */
public final class UnsafeImageException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**Constructor
	 * 
	 * @param unsafeBuffer - The {@link Buffer} returned from
	 * the unsafe {@link Image}
	 */
	public UnsafeImageException(Buffer unsafeBuffer) {
		super("Image Buffer was of type " + unsafeBuffer.getClass().getName() + " instead of ByteBuffer!");
	}
}
