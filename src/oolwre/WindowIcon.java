/*Copyright (c) 2017 Fantastic Fantasy All rights reserved.
 *
 * Permission to use, copy, modify and/or redistribute in source or binary form
 * is hereby granted, free of charge, subject to the following conditions:
 *
 * - Redistribution of source code shall include the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form shall include the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * - Neither the name Object Oriented Lightweight Render Engine nor the names
 *  of its contributors may be used to endorse or promote products derived
 *  from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
