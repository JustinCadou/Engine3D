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
package oolwre.image;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL30;
import oolwre.render.data.Texture;

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
	
	/**{@link Image} format used when creating a {@link Texture}.<br><br>
	 * {@link #RED}<br>
	 * {@link #GREEN}<br>
	 * {@link #BLUE}<br>
	 * {@link #ALPHA}<br>
	 * {@link #RED_INT}<br>
	 * {@link #BLUE_INT}<br>
	 * {@link #GREEN_INT}<br>
	 * {@link #ALPHA_INT}<br>
	 * {@link #RG}<br>
	 * {@link #RGB}<br>
	 * {@link #RGBA}<br>
	 * {@link #BGR}<br>
	 * {@link #BGRA}<br>
	 * {@link #RG_INT}<br>
	 * {@link #RGB_INT}<br>
	 * {@link #RGBA_INT}<br>
	 * {@link #BGR_INT}<br>
	 * {@link #BGRA_INT}<br>
	 * {@link #STENCIL_INDEX}<br>
	 * {@link #DEPTH_COMPONENT}<br>
	 * {@link #DEPTH_STENCIL}<br>
	 * {@link #LUMINANCE}<br>
	 * {@link #LUMINANCE_ALPHA}
	 */
	public static enum Format {
		RED(GL11.GL_RED),
		GREEN(GL11.GL_GREEN),
		BLUE(GL11.GL_BLUE),
		ALPHA(GL11.GL_ALPHA),
		RED_INT(GL30.GL_RED_INTEGER),
		BLUE_INT(GL30.GL_BLUE_INTEGER),
		GREEN_INT(GL30.GL_GREEN_INTEGER),
		ALPHA_INT(GL30.GL_ALPHA_INTEGER),
		RG(GL30.GL_RG),
		RGB(GL11.GL_RGB),
		RGBA(GL11.GL_RGBA),
		BGR(GL12.GL_BGR),
		BGRA(GL12.GL_BGRA),
		RG_INT(GL30.GL_RG_INTEGER),
		RGB_INT(GL30.GL_RGB_INTEGER),
		RGBA_INT(GL30.GL_RGBA_INTEGER),
		BGR_INT(GL30.GL_BGR_INTEGER),
		BGRA_INT(GL30.GL_BGRA_INTEGER),
		STENCIL_INDEX(GL11.GL_STENCIL_INDEX),
		DEPTH_COMPONENT(GL11.GL_DEPTH_COMPONENT),
		DEPTH_STENCIL(GL30.GL_DEPTH_STENCIL),
		LUMINANCE(GL11.GL_LUMINANCE),
		LUMINANCE_ALPHA(GL11.GL_LUMINANCE_ALPHA);
		
		private int value;
		
		Format(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static Format forGLValue(int glValue) {
			for (Format format : values()) {
				if (format.value == glValue) {
					return format;
				}
			}
			return null;
		}
	}
}
