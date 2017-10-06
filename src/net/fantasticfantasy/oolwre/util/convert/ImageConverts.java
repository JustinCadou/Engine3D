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
package net.fantasticfantasy.oolwre.util.convert;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.glfw.GLFWImage;
import net.fantasticfantasy.oolwre.image.Image;

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
