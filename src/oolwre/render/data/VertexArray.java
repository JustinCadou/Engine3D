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
package oolwre.render.data;

import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.ARBVertexArrayObject;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLCapabilities;
import oolwre.CapabilityProvider;

/**The <code>VertexArray</code> class represents an OpenGL vertex array
 * object. An instance of this class can be obtained by using static
 * method {@link #create()}.
 */
public abstract class VertexArray {
	
	private static Map<Integer, VertexArray> arrays;
	
	static {
		arrays = new HashMap<>();
	}
	
	private int name;
	
	/**Constructs a {@link VertexArray} with the specified name.
	 * 
	 * @param name The name
	 */
	public VertexArray(int name) {
		this.name = name;
		arrays.put(name, this);
	}
	
	/**@return The name of this {@link VertexArray}.
	 */
	public final int getName() {
		return this.name;
	}
	
	/**Binds this {@link VertexArray}.
	 */
	public abstract void bind();
	
	/**Unbinds any {@link VertexArray}.
	 */
	public abstract void unbind();
	
	protected abstract void delete();
	
	/**Destroys this {@link VertexArray}.
	 */
	public final void destroy() {
		this.delete();
		arrays.remove(this.name);
		this.name = 0;
	}
	
	/**Creates a {@link VertexArray} using the supported extensions provided by
	 * <code>provider</code>. If none are, an {@link UnsupportedOperationException}
	 * is thrown.
	 * 
	 * @param provider The {@link CapabilityProvider}
	 * 
	 * @throws UnsupportedOperationException If no extension is supported to create
	 * a {@link VertexArray}
	 * 
	 * @return A newly created {@link VertexArray}
	 */
	public static VertexArray create(CapabilityProvider provider) {
		if (provider == null) {
			throw new NullPointerException("Capability provider is null!");
		}
		GLCapabilities caps = provider.getCapabilities();
		if (caps.OpenGL30) {
			return new GL30VertexArray();
		} else if (caps.GL_ARB_vertex_array_object) {
			return new ARBVertexArray();
		} else {
			throw new UnsupportedOperationException("There is no supported extension to create a vertex array!");
		}
	}
	
	/**Creates a {@link VertexArray} using the supported extensions provided by
	 * the current {@link Thread}'s {@link CapabilityProvider}. If none are, an
	 * {@link UnsupportedOperationException} is thrown. If no {@link CapabilityProvider}
	 * is found, a {@link NullPointerException} is thrown.
	 * 
	 * @throws UnsupportedOperationException If no extension is supported to
	 * create a {@link VertexArray}
	 * @throws NullPointerException If no {@link CapabilityProvider} is found
	 * on the current {@link Thread}
	 * 
	 * @return A newly created {@link VertexArray}
	 * 
	 * @see #create(CapabilityProvider)
	 */
	public static VertexArray create() {
		return create(CapabilityProvider.get());
	}
	
	private static class GL30VertexArray extends VertexArray {
		
		private static int genName() {
			return GL30.glGenVertexArrays();
		}
		
		public GL30VertexArray() {
			super(genName());
		}
		
		public void bind() {
			GL30.glBindVertexArray(this.getName());
		}
		
		public void unbind() {
			GL30.glBindVertexArray(0);
		}
		
		protected void delete() {
			GL30.glDeleteVertexArrays(this.getName());
		}
	}
	
	private static class ARBVertexArray extends VertexArray {
		
		private static int genName() {
			return ARBVertexArrayObject.glGenVertexArrays();
		}
		
		public ARBVertexArray() {
			super(genName());
		}
		
		public void bind() {
			ARBVertexArrayObject.glBindVertexArray(this.getName());
		}
		
		public void unbind() {
			ARBVertexArrayObject.glBindVertexArray(0);
		}
		
		protected void delete() {
			ARBVertexArrayObject.glDeleteVertexArrays(this.getName());
		}
	}
}
