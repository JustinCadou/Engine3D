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
package net.fantasticfantasy.oolwre.render.data;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.ARBBufferStorage;
import org.lwjgl.opengl.ARBComputeShader;
import org.lwjgl.opengl.ARBCopyBuffer;
import org.lwjgl.opengl.ARBDrawIndirect;
import org.lwjgl.opengl.ARBIndirectParameters;
import org.lwjgl.opengl.ARBPixelBufferObject;
import org.lwjgl.opengl.ARBShaderAtomicCounters;
import org.lwjgl.opengl.ARBShaderStorageBufferObject;
import org.lwjgl.opengl.ARBTextureBufferObject;
import org.lwjgl.opengl.ARBUniformBufferObject;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.EXTTransformFeedback;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLCapabilities;
import net.fantasticfantasy.oolwre.CapabilityProvider;

/**The <code>BufferObject</code> class represents an OpenGL buffer object.
 */
public abstract class BufferObject {
	
	private static final int BUFFER_USAGE_BASE = 0x88e0;
	protected static final int GET_POINTER_PNAME_VAL = ARBVertexBufferObject.GL_BUFFER_MAP_POINTER_ARB;
	
	private static Map<Integer, BufferObject> buffers;
	
	static {
		buffers = new HashMap<>();
	}
	
	private int name;
	
	public BufferObject(int name) {
		this.name = name;
		buffers.put(name, this);
	}
	
	public final int getName() {
		return this.name;
	}
	
	public abstract int getParameteri(Target target, Parameter param);
	
	public abstract void getParameteriv(Target target, Parameter param, int[] params);
	
	public abstract void getParameteriv(Target target, Parameter param, IntBuffer params);
	
	public abstract void bufferData(Target target, ByteBuffer data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, ShortBuffer data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, short[] data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, IntBuffer data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, int[] data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, FloatBuffer data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, float[] data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, DoubleBuffer data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferData(Target target, double[] data, BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature);
	
	public abstract void bufferSubData(Target target, long offset, ByteBuffer data);
	
	public abstract void bufferSubData(Target target, long offset, ShortBuffer data);
	
	public abstract void bufferSubData(Target target, long offset, short[] data);
	
	public abstract void bufferSubData(Target target, long offset, IntBuffer data);
	
	public abstract void bufferSubData(Target target, long offset, int[] data);
	
	public abstract void bufferSubData(Target target, long offset, FloatBuffer data);
	
	public abstract void bufferSubData(Target target, long offset, float[] data);
	
	public abstract void bufferSubData(Target target, long offset, DoubleBuffer data);
	
	public abstract void bufferSubData(Target target, long offset, double[] data);
	
	public abstract void getBufferSubData(Target target, long offset, ByteBuffer data);
	
	public abstract void getBufferSubData(Target target, long offset, ShortBuffer data);
	
	public abstract void getBufferSubData(Target target, long offset, short[] data);
	
	public abstract void getBufferSubData(Target target, long offset, IntBuffer data);
	
	public abstract void getBufferSubData(Target target, long offset, int[] data);
	
	public abstract void getBufferSubData(Target target, long offset, FloatBuffer data);
	
	public abstract void getBufferSubData(Target target, long offset, float[] data);
	
	public abstract void getBufferSubData(Target target, long offset, DoubleBuffer data);
	
	public abstract void getBufferSubData(Target target, long offset, double[] data);
	
	public abstract ByteBuffer mapBuffer(Target target, BufferMappingAccess access);
	
	public abstract ByteBuffer mapBuffer(Target target, BufferMappingAccess access, ByteBuffer oldBuffer);
	
	public abstract ByteBuffer mapBuffer(Target target, BufferMappingAccess access, long length,
			ByteBuffer oldBuffer);
	
	public abstract boolean unmapBuffer(Target target);
	
	public abstract long getMapPointer(Target target);
	
	public abstract void getMapPointerv(Target target, PointerBuffer buffer);
	
	public abstract void bind(Target target);
	
	public abstract void unbind(Target target);
	
	protected abstract void delete();
	
	public final void destroy() {
		this.delete();
		buffers.remove(this.name);
		this.name = 0;
	}
	
	public static int glBufferUsageValueForParams(BufferAccessFrequency accessFrequency,
			BufferAccessNature accessNature) {
		return BUFFER_USAGE_BASE + accessFrequency.off + accessNature.off;
	}
	
	public static BufferObject create(CapabilityProvider provider) {
		if (provider == null) {
			throw new NullPointerException("Capability provider is null!");
		}
		GLCapabilities caps = provider.getCapabilities();
		if (caps.OpenGL20) {
			return new GL20Buffer();
		} else if (caps.GL_ARB_vertex_buffer_object) {
			return new ARBBuffer();
		} else {
			throw new UnsupportedOperationException("There is no supported extension to create a BufferObject!");
		}
	}
	
	private static class GL20Buffer extends BufferObject {

		public GL20Buffer() {
			super(GL15.glGenBuffers());
		}

		public int getParameteri(Target target, Parameter param) {
			return GL15.glGetBufferParameteri(target.value, param.value);
		}

		public void getParameteriv(Target target, Parameter param, int[] params) {
			GL15.glGetBufferParameteriv(target.value, param.value, params);
		}

		public void getParameteriv(Target target, Parameter param, IntBuffer params) {
			GL15.glGetBufferParameteriv(target.value, param.value, params);
		}

		public void bufferData(Target target, ByteBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}
		
		public void bufferData(Target target, ShortBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, short[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, IntBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, int[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, FloatBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, float[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, DoubleBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferData(Target target, double[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			GL15.glBufferData(target.value, data, usage);
		}

		public void bufferSubData(Target target, long offset, ByteBuffer data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, ShortBuffer data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, short[] data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, IntBuffer data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, int[] data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, FloatBuffer data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, float[] data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, DoubleBuffer data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, double[] data) {
			GL15.glBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, ByteBuffer data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, ShortBuffer data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, short[] data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, IntBuffer data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, int[] data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, FloatBuffer data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, float[] data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, DoubleBuffer data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, double[] data) {
			GL15.glGetBufferSubData(target.value, offset, data);
		}

		public ByteBuffer mapBuffer(Target target, BufferMappingAccess access) {
			return GL15.glMapBuffer(target.value, access.value);
		}

		public ByteBuffer mapBuffer(Target target, BufferMappingAccess access, ByteBuffer oldBuffer) {
			return GL15.glMapBuffer(target.value, access.value, oldBuffer);
		}

		public ByteBuffer mapBuffer(Target target, BufferMappingAccess access, long length, ByteBuffer oldBuffer) {
			return GL15.glMapBuffer(target.value, access.value, length, oldBuffer);
		}

		public boolean unmapBuffer(Target target) {
			return GL15.glUnmapBuffer(target.value);
		}

		public long getMapPointer(Target target) {
			return GL15.glGetBufferPointer(target.value, GET_POINTER_PNAME_VAL);
		}

		public void getMapPointerv(Target target, PointerBuffer buffer) {
			GL15.glGetBufferPointerv(target.value, BufferObject.GET_POINTER_PNAME_VAL, buffer);
		}

		public void bind(Target target) {
			GL15.glBindBuffer(target.value, this.getName());
		}

		public void unbind(Target target) {
			GL15.glBindBuffer(target.value, 0);
		}

		protected void delete() {
			GL15.glDeleteBuffers(this.getName());
		}
	}
	
	private static class ARBBuffer extends BufferObject {
		
		public ARBBuffer() {
			super(ARBVertexBufferObject.glGenBuffersARB());
		}

		public int getParameteri(Target target, Parameter param) {
			return ARBVertexBufferObject.glGetBufferParameteriARB(target.value, param.value);
		}

		public void getParameteriv(Target target, Parameter param, int[] params) {
			ARBVertexBufferObject.glGetBufferParameterivARB(target.value, param.value, params);
		}

		public void getParameteriv(Target target, Parameter param, IntBuffer params) {
			ARBVertexBufferObject.glGetBufferParameterivARB(target.value, param.value, params);
		}

		public void bufferData(Target target, ByteBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, ShortBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, short[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, IntBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, int[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, FloatBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, float[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, DoubleBuffer data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferData(Target target, double[] data, BufferAccessFrequency accessFrequency,
				BufferAccessNature accessNature) {
			int usage = glBufferUsageValueForParams(accessFrequency, accessNature);
			ARBVertexBufferObject.glBufferDataARB(target.value, data, usage);
		}

		public void bufferSubData(Target target, long offset, ByteBuffer data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, ShortBuffer data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, short[] data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, IntBuffer data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, int[] data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, FloatBuffer data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, float[] data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, DoubleBuffer data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void bufferSubData(Target target, long offset, double[] data) {
			ARBVertexBufferObject.glBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, ByteBuffer data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, ShortBuffer data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, short[] data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, IntBuffer data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, int[] data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, FloatBuffer data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, float[] data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, DoubleBuffer data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public void getBufferSubData(Target target, long offset, double[] data) {
			ARBVertexBufferObject.glGetBufferSubDataARB(target.value, offset, data);
		}

		public ByteBuffer mapBuffer(Target target, BufferMappingAccess access) {
			return ARBVertexBufferObject.glMapBufferARB(target.value, access.value);
		}

		public ByteBuffer mapBuffer(Target target, BufferMappingAccess access, ByteBuffer oldBuffer) {
			return ARBVertexBufferObject.glMapBufferARB(target.value, access.value, oldBuffer);
		}

		public ByteBuffer mapBuffer(Target target, BufferMappingAccess access, long length, ByteBuffer oldBuffer) {
			return ARBVertexBufferObject.glMapBufferARB(target.value, access.value, length, oldBuffer);
		}

		public boolean unmapBuffer(Target target) {
			return ARBVertexBufferObject.glUnmapBufferARB(target.value);
		}

		public long getMapPointer(Target target) {
			return ARBVertexBufferObject.glGetBufferPointerARB(target.value, GET_POINTER_PNAME_VAL);
		}

		public void getMapPointerv(Target target, PointerBuffer buffer) {
			ARBVertexBufferObject.glGetBufferPointervARB(target.value, GET_POINTER_PNAME_VAL, buffer);
		}

		public void bind(Target target) {
			ARBVertexBufferObject.glBindBufferARB(target.value, this.getName());
		}

		public void unbind(Target target) {
			ARBVertexBufferObject.glBindBufferARB(target.value, 0);
		}

		protected void delete() {
			ARBVertexBufferObject.glDeleteBuffersARB(this.getName());
		}
	}
	
	/**Bind buffer target.<br><br>
	 * {@link #ARRAY}<br>
	 * {@link #ELEMENT_ARRAY}<br>
	 * {@link #PIXEL_PACK}<br>
	 * {@link #PIXEL_UNPACK}<br>
	 * {@link #TRANSFORM_FEEDBACK}<br>
	 * {@link #UNIFORM}<br>
	 * {@link #TEXTURE}<br>
	 * {@link #COPY_READ}<br>
	 * {@link #COPY_WRITE}<br>
	 * {@link #DRAW_INDIRECT}<br>
	 * {@link #ATOMIC_COUNTER}<br>
	 * {@link #DISPATCH_INDIRECT}<br>
	 * {@link #SHADER_STORAGE}<br>
	 * {@link #PARAMETER}
	 */
	public static enum Target {
		
		ARRAY(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB),
		ELEMENT_ARRAY(ARBVertexBufferObject.GL_ELEMENT_ARRAY_BUFFER_ARB),
		PIXEL_PACK(ARBPixelBufferObject.GL_PIXEL_PACK_BUFFER_ARB),
		PIXEL_UNPACK(ARBPixelBufferObject.GL_PIXEL_UNPACK_BUFFER_ARB),
		TRANSFORM_FEEDBACK(EXTTransformFeedback.GL_TRANSFORM_FEEDBACK_BUFFER_EXT),
		UNIFORM(ARBUniformBufferObject.GL_UNIFORM_BUFFER),
		TEXTURE(ARBTextureBufferObject.GL_TEXTURE_BUFFER_ARB),
		COPY_READ(ARBCopyBuffer.GL_COPY_READ_BUFFER),
		COPY_WRITE(ARBCopyBuffer.GL_COPY_WRITE_BUFFER),
		DRAW_INDIRECT(ARBDrawIndirect.GL_DRAW_INDIRECT_BUFFER),
		ATOMIC_COUNTER(ARBShaderAtomicCounters.GL_ATOMIC_COUNTER_BUFFER),
		DISPATCH_INDIRECT(ARBComputeShader.GL_DISPATCH_INDIRECT_BUFFER),
		SHADER_STORAGE(ARBShaderStorageBufferObject.GL_SHADER_STORAGE_BUFFER),
		PARAMETER(ARBIndirectParameters.GL_PARAMETER_BUFFER_ARB);
		
		private int value;
		
		Target(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static Target forGlValue(int val) {
			for (Target target : values()) {
				if (target.value == val) {
					return target;
				}
			}
			return null;
		}
	}
	
	/**Get buffer parameters.<br><br>
	 * {@link #SIZE}<br>
	 * {@link #USAGE}<br>
	 * {@link #ACCESS}<br>
	 * {@link #MAPPED}<br>
	 * {@link #ACCESS_FLAGS}<br>
	 * {@link #MAP_LENGTH}<br>
	 * {@link #MAP_OFFSET}<br>
	 * {@link #IMMUTABLE_STORAGE}<br>
	 * {@link #STORAGE_FLAGS}
	 */
	public static enum Parameter {
		
		SIZE(ARBVertexBufferObject.GL_BUFFER_SIZE_ARB),
		USAGE(ARBVertexBufferObject.GL_BUFFER_USAGE_ARB),
		ACCESS(ARBVertexBufferObject.GL_BUFFER_ACCESS_ARB),
		MAPPED(ARBVertexBufferObject.GL_BUFFER_MAPPED_ARB),
		ACCESS_FLAGS(GL30.GL_BUFFER_ACCESS_FLAGS),
		MAP_LENGTH(GL30.GL_BUFFER_MAP_LENGTH),
		MAP_OFFSET(GL30.GL_BUFFER_MAP_OFFSET),
		IMMUTABLE_STORAGE(ARBBufferStorage.GL_BUFFER_IMMUTABLE_STORAGE),
		STORAGE_FLAGS(ARBBufferStorage.GL_BUFFER_STORAGE_FLAGS);
		
		private int value;
		
		Parameter(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static Parameter forGlValue(int val) {
			for (Parameter param : values()) {
				if (param.value == val) {
					return param;
				}
			}
			return null;
		}
	}
	
	/**Buffer access frequency.<br><br>
	 * {@link #STREAM}<br>
	 * {@link #STATIC}<br>
	 * {@link #DYNAMIC}
	 * 
	 * @see BufferObject#glBufferUsageValueForParams(BufferAccessFrequency,
	 *  BufferAccessNature) glBufferUsageValueForParams(...)
	 */
	public static enum BufferAccessFrequency {
		
		STREAM(0),
		STATIC(4),
		DYNAMIC(7);
		
		private int off;
		
		BufferAccessFrequency(int off) {
			this.off = off;
		}
		
		public static BufferAccessFrequency forGlValue(int val) {
			val -= BUFFER_USAGE_BASE;
			if (val < 0) {
				return null;
			} else if (val < 4) {
				return STREAM;
			} else if (val < 7) {
				return STATIC;
			} else if (val < 10) {
				return DYNAMIC;
			}
			return null;
		}
	}
	
	/**Buffer access nature.<br><br>
	 * {@link #DRAW}<br>
	 * {@link #READ}<br>
	 * {@link #COPY}
	 * 
	 * @see BufferObject#glBufferUsageValueForParams(BufferAccessFrequency,
	 *  BufferAccessNature) glBufferUsageValueForParams(...)
	 */
	public static enum BufferAccessNature {
		
		DRAW(0),
		READ(1),
		COPY(2);
		
		private int off;
		
		BufferAccessNature(int off) {
			this.off = off;
		}
		
		public static BufferAccessNature forGlValue(int val) {
			BufferAccessFrequency baf = BufferAccessFrequency.forGlValue(val);
			if (baf == null) {
				return null;
			}
			val -= BUFFER_USAGE_BASE - baf.off;
			if (val < 0) {
				return null;
			}
			for (BufferAccessNature ban : values()) {
				if (ban.off == val) {
					return ban;
				}
			}
			return null;
		}
	}
	
	/**Buffer mapping access.<br><br>
	 * {@link #READ_ONLY}<br>
	 * {@link #WRITE_ONLY}<br>
	 * {@link #READ_WRITE}
	 */
	public static enum BufferMappingAccess {
		
		READ_ONLY(ARBVertexBufferObject.GL_READ_ONLY_ARB),
		WRITE_ONLY(ARBVertexBufferObject.GL_WRITE_ONLY_ARB),
		READ_WRITE(ARBVertexBufferObject.GL_READ_WRITE_ARB);
		
		private int value;
		
		BufferMappingAccess(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static BufferMappingAccess forGlValue(int val) {
			for (BufferMappingAccess bma : values()) {
				if (bma.value == val) {
					return bma;
				}
			}
			return null;
		}
	}
}
