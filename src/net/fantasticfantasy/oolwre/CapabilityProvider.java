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
package net.fantasticfantasy.oolwre;

import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

/**The <code>CapabilityProvider</code> class is used to provide the
 * OpenGL capabilities in order to prevent application from crashing
 * at native level.
 */
public class CapabilityProvider {
	
	private static Map<Thread, CapabilityProvider> threads;
	
	static {
		threads = new HashMap<>();
	}
	
	private GLCapabilities caps;
	private Thread thread;
	
	private boolean[] openGL;
	
	private CapabilityProvider(GLCapabilities caps, Thread thread) {
		this.caps = caps;
		this.thread = thread;
		threads.put(thread, this);
	}
	
	/**Gets the {@link GLCapabilities} associated with this {@link CapabilityProvider}.
	 * 
	 * @return The {@link GLCapabilities}
	 */
	public GLCapabilities getCapabilities() {
		return this.caps;
	}
	
	/**Returns whether the OpenGL <code>version</code> is supported.
	 * 
	 * @param version The OpenGL version to be checked
	 * 
	 * @return Whether or not <code>version</code> is supported
	 */
	public boolean isOpenGLVersionSupported(int version) {
		if (version < 10 || version >= this.openGL.length) {
			throw new IllegalArgumentException("version (" + version + ") < 10 || >= " + this.openGL.length);
		}
		return this.openGL[version];
	}
	
	public void destroy() {
		threads.remove(this.thread);
	}
	
	/**Returns the {@link CapabilityProvider} attached to <code>thread</code>.
	 * 
	 * @param thread The {@link Thread}
	 * 
	 * @return The {@link CapabilityProvider} attached, or <code>null</code>
	 */
	public static CapabilityProvider get(Thread thread) {
		return threads.get(thread);
	}
	
	/**Returns the current {@link Thread}'s {@link CapabilityProvider}.
	 * 
	 * @return The current {@link CapabilityProvider}
	 */
	public static CapabilityProvider get() {
		return threads.get(Thread.currentThread());
	}
	
	/**Creates a {@link CapabilityProvider} if there was none on the current
	 * {@link Thread}. Returns {@link #get()} otherwise.
	 * 
	 * @param forwardCompat Whether or not OpenGL should be forward compatible
	 * 
	 * @return The current {@link Thread}'s {@link CapabilityProvider}
	 */
	public static CapabilityProvider create(boolean forwardCompat) {
		Thread thread = Thread.currentThread();
		if (threads.containsKey(thread)) {
			return threads.get(thread);
		}
		GLCapabilities caps = GL.createCapabilities(forwardCompat);
		boolean[] openGL = new boolean[46];
		try {
			openGL[11] = caps.OpenGL11;
			openGL[12] = caps.OpenGL12;
			openGL[13] = caps.OpenGL13;
			openGL[14] = caps.OpenGL14;
			openGL[15] = caps.OpenGL15;
			openGL[20] = caps.OpenGL20;
			openGL[21] = caps.OpenGL21;
			openGL[30] = caps.OpenGL30;
			openGL[31] = caps.OpenGL31;
			openGL[32] = caps.OpenGL32;
			openGL[33] = caps.OpenGL33;
			openGL[40] = caps.OpenGL40;
			openGL[41] = caps.OpenGL41;
			openGL[42] = caps.OpenGL42;
			openGL[43] = caps.OpenGL43;
			openGL[44] = caps.OpenGL44;
			openGL[45] = caps.OpenGL45;
		} catch (NoSuchFieldError e) {
			/// Safety ///
			//Used if user has a lower LWJGL that does not have that much fields
		}
		CapabilityProvider provider = new CapabilityProvider(caps, thread);
		provider.openGL = openGL;
		return provider;
	}
}
