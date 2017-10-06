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
package net.fantasticfantasy.oolwre.render.data.shader;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.ARBInstancedArrays;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.ARBVertexProgram;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.EXTGPUShader4;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL41;
import org.lwjgl.opengl.GL42;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.MemoryUtil;
import net.fantasticfantasy.oolwre.CapabilityProvider;

public abstract class Program {
	
	private static Map<Integer, Program> programs;
	
	static {
		programs = new HashMap<>();
	}
	
	private int name;
	
	public Program(int name) {
		this.name = name;
		programs.put(name, this);
	}
	
	public final int getName() {
		return this.name;
	}
	
	public abstract int geti(Parameter param);
	
	public abstract void getiv(Parameter param, int[] params);
	
	public abstract void getiv(Parameter param, IntBuffer params);
	
	public abstract String getInfoLog();
	
	public abstract String getInfoLog(int maxLength);
	
	public abstract void getInfoLog(int[] length, ByteBuffer infoLog);
	
	public abstract void getInfoLog(IntBuffer length, ByteBuffer infoLog);
	
	public abstract int getUniformLocation(CharSequence name);
	
	public abstract int getUniformLocation(ByteBuffer name);
	
	public abstract void bindAttribLocation(int index, CharSequence attribName);
	
	public abstract void bindAttribLocation(int index, ByteBuffer attribName);
	
	public abstract String getActiveAttrib(int index, IntBuffer size, IntBuffer type);
	
	public abstract String getActiveAttrib(int index, int maxLength, IntBuffer size, IntBuffer type);
	
	public abstract void getActiveAttrib(int index, int[] length, int[] size, int[] type, ByteBuffer name);
	
	public abstract void getActiveAttrib(int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name);
	
	public abstract String getActiveUniform(int index, IntBuffer size, IntBuffer type);
	
	public abstract String getActiveUniform(int index, int maxLength, IntBuffer size, IntBuffer type);
	
	public abstract void getActiveUniform(int index, int[] length, int[] size, int[] type, ByteBuffer name);
	
	public abstract void getActiveUniform(int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name);
	
	public abstract int getAttribLocation(CharSequence name);
	
	public abstract int getAttribLocation(ByteBuffer name);
	
	public abstract float getUniformf(int location);
	
	public abstract void getUniformfv(int location, float[] value);
	
	public abstract void getUniformfv(int location, FloatBuffer value);
	
	public abstract int getUniformi(int location);
	
	public abstract void getUniformiv(int location, int[] value);
	
	public abstract void getUniformiv(int location, IntBuffer value);
	
	public abstract void link();
	
	public abstract void validate();
	
	public abstract void attach(Shader shader);
	
	public abstract void detach(Shader shader);
	
	public abstract void getAttachedShaderNames(int[] count, int[] shaders);
	
	public abstract void getAttachedShaderNames(IntBuffer count, IntBuffer shaders);
	
	public final Shader[] getAttachedShaders(int maxCount) {
		IntBuffer count = MemoryUtil.memAllocInt(1);
		IntBuffer shaders = MemoryUtil.memAllocInt(maxCount);
		this.getAttachedShaderNames(count, shaders);
		count.flip();
		Shader[] attached = new Shader[count.get()];
		shaders.flip();
		for (int i = 0; i < attached.length; i++) {
			attached[i] = Shader.getShaderByName(shaders.get());
		}
		MemoryUtil.memFree(count);
		MemoryUtil.memFree(shaders);
		return attached;
	}
	
	public abstract void enable();
	
	public abstract void disable();
	
	protected abstract void delete();
	
	public final void destroy() {
		this.delete();
		programs.remove(this.name);
		this.name = 0;
	}
	
	public static Program getProgramByName(int name) {
		return programs.get(name);
	}
	
	public static Program create(CapabilityProvider provider) {
		if (provider == null) {
			throw new NullPointerException("Capability provider is null!");
		}
		GLCapabilities caps = provider.getCapabilities();
		if (caps.OpenGL20) {
			int name = GL20Program.genName();
			return new GL20Program(name);
		} else if (caps.GL_ARB_shader_objects && caps.GL_ARB_vertex_shader) {
			int name = ARBProgram.genName();
			return new ARBProgram(name);
		} else {
			throw new UnsupportedOperationException("There is no supported extension to create a Program!");
		}
	}
	
	public static Program create() {
		return create(CapabilityProvider.get());
	}
	
	private static class GL20Program extends Program {
		
		public static int genName() {
			return GL20.glCreateProgram();
		}
		
		public GL20Program(int name) {
			super(name);
		}

		public int geti(Parameter param) {
			return GL20.glGetProgrami(this.getName(), param.value);
		}

		public void getiv(Parameter param, int[] params) {
			GL20.glGetProgramiv(this.getName(), param.value, params);
		}

		public void getiv(Parameter param, IntBuffer params) {
			GL20.glGetProgramiv(this.getName(), param.value, params);
		}

		public String getInfoLog() {
			return GL20.glGetProgramInfoLog(this.getName());
		}

		public String getInfoLog(int maxLength) {
			return GL20.glGetProgramInfoLog(this.getName(), maxLength);
		}

		public void getInfoLog(int[] length, ByteBuffer infoLog) {
			GL20.glGetProgramInfoLog(this.getName(), length, infoLog);
		}

		public void getInfoLog(IntBuffer length, ByteBuffer infoLog) {
			GL20.glGetProgramInfoLog(this.getName(), length, infoLog);
		}

		public int getUniformLocation(CharSequence name) {
			return GL20.glGetUniformLocation(this.getName(), name);
		}

		public int getUniformLocation(ByteBuffer name) {
			return GL20.glGetUniformLocation(this.getName(), name);
		}

		public void bindAttribLocation(int index, CharSequence attribName) {
			GL20.glBindAttribLocation(this.getName(), index, attribName);
		}

		public void bindAttribLocation(int index, ByteBuffer attribName) {
			GL20.glBindAttribLocation(this.getName(), index, attribName);
		}

		public String getActiveAttrib(int index, IntBuffer size, IntBuffer type) {
			return GL20.glGetActiveAttrib(this.getName(), index, size, type);
		}

		public String getActiveAttrib(int index, int maxLength, IntBuffer size, IntBuffer type) {
			return GL20.glGetActiveAttrib(this.getName(), index, maxLength, size, type);
		}

		public void getActiveAttrib(int index, int[] length, int[] size, int[] type, ByteBuffer name) {
			GL20.glGetActiveAttrib(this.getName(), index, length, size, type, name);
		}

		public void getActiveAttrib(int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
			GL20.glGetActiveAttrib(this.getName(), index, length, size, type, name);
		}

		public String getActiveUniform(int index, IntBuffer size, IntBuffer type) {
			return GL20.glGetActiveUniform(this.getName(), index, size, type);
		}

		public String getActiveUniform(int index, int maxLength, IntBuffer size, IntBuffer type) {
			return GL20.glGetActiveUniform(this.getName(), index, maxLength, size, type);
		}

		public void getActiveUniform(int index, int[] length, int[] size, int[] type, ByteBuffer name) {
			GL20.glGetActiveUniform(this.getName(), index, length, size, type, name);
		}

		public void getActiveUniform(int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
			GL20.glGetActiveUniform(this.getName(), index, length, size, type, name);
		}

		public int getAttribLocation(CharSequence name) {
			return GL20.glGetAttribLocation(this.getName(), name);
		}

		public int getAttribLocation(ByteBuffer name) {
			return GL20.glGetAttribLocation(this.getName(), name);
		}

		public float getUniformf(int location) {
			return GL20.glGetUniformf(this.getName(), location);
		}

		public void getUniformfv(int location, float[] value) {
			GL20.glGetUniformfv(this.getName(), location, value);
		}

		public void getUniformfv(int location, FloatBuffer value) {
			GL20.glGetUniformfv(this.getName(), location, value);
		}

		public int getUniformi(int location) {
			return GL20.glGetUniformi(this.getName(), location);
		}

		public void getUniformiv(int location, int[] value) {
			GL20.glGetUniformiv(this.getName(), location, value);
		}

		public void getUniformiv(int location, IntBuffer value) {
			GL20.glGetUniformiv(this.getName(), location, value);
		}

		public void link() {
			GL20.glLinkProgram(this.getName());
		}

		public void validate() {
			GL20.glValidateProgram(this.getName());
		}

		public void attach(Shader shader) {
			GL20.glAttachShader(this.getName(), shader.getName());
		}

		public void detach(Shader shader) {
			GL20.glDetachShader(this.getName(), shader.getName());
		}

		public void getAttachedShaderNames(int[] count, int[] shaders) {
			GL20.glGetAttachedShaders(this.getName(), count, shaders);
		}

		public void getAttachedShaderNames(IntBuffer count, IntBuffer shaders) {
			GL20.glGetAttachedShaders(this.getName(), count, shaders);
		}

		public void enable() {
			GL20.glUseProgram(this.getName());
		}

		public void disable() {
			GL20.glUseProgram(0);
		}

		protected void delete() {
			GL20.glDeleteProgram(this.getName());
		}
	}
	
	private static class ARBProgram extends Program {
		
		public static int genName() {
			return ARBShaderObjects.glCreateProgramObjectARB();
		}
		
		public ARBProgram(int name) {
			super(name);
		}

		public int geti(Parameter param) {
			return ARBShaderObjects.glGetObjectParameteriARB(this.getName(), param.value);
		}

		public void getiv(Parameter param, int[] params) {
			ARBShaderObjects.glGetObjectParameterivARB(this.getName(), param.value, params);
		}

		public void getiv(Parameter param, IntBuffer params) {
			ARBShaderObjects.glGetObjectParameterivARB(this.getName(), param.value, params);
		}

		public String getInfoLog() {
			return ARBShaderObjects.glGetInfoLogARB(this.getName());
		}

		public String getInfoLog(int maxLength) {
			return ARBShaderObjects.glGetInfoLogARB(this.getName(), maxLength);
		}

		public void getInfoLog(int[] length, ByteBuffer infoLog) {
			ARBShaderObjects.glGetInfoLogARB(this.getName(), length, infoLog);
		}

		public void getInfoLog(IntBuffer length, ByteBuffer infoLog) {
			ARBShaderObjects.glGetInfoLogARB(this.getName(), length, infoLog);
		}
		
		public int getUniformLocation(CharSequence name) {
			return ARBShaderObjects.glGetUniformLocationARB(this.getName(), name);
		}

		public int getUniformLocation(ByteBuffer name) {
			return ARBShaderObjects.glGetUniformLocationARB(this.getName(), name);
		}

		public void bindAttribLocation(int index, CharSequence attribName) {
			ARBVertexShader.glBindAttribLocationARB(this.getName(), index, attribName);
		}

		public void bindAttribLocation(int index, ByteBuffer attribName) {
			ARBVertexShader.glBindAttribLocationARB(this.getName(), index, attribName);
		}

		public String getActiveAttrib(int index, IntBuffer size, IntBuffer type) {
			return ARBVertexShader.glGetActiveAttribARB(this.getName(), index, size, type);
		}

		public String getActiveAttrib(int index, int maxLength, IntBuffer size, IntBuffer type) {
			return ARBVertexShader.glGetActiveAttribARB(this.getName(), index, maxLength, size, type);
		}

		public void getActiveAttrib(int index, int[] length, int[] size, int[] type, ByteBuffer name) {
			ARBVertexShader.glGetActiveAttribARB(this.getName(), index, length, size, type, name);
		}

		public void getActiveAttrib(int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
			ARBVertexShader.glGetActiveAttribARB(this.getName(), index, length, size, type, name);
		}

		public String getActiveUniform(int index, IntBuffer size, IntBuffer type) {
			return ARBShaderObjects.glGetActiveUniformARB(this.getName(), index, size, type);
		}

		public String getActiveUniform(int index, int maxLength, IntBuffer size, IntBuffer type) {
			return ARBShaderObjects.glGetActiveUniformARB(this.getName(), index, maxLength, size, type);
		}

		public void getActiveUniform(int index, int[] length, int[] size, int[] type, ByteBuffer name) {
			ARBShaderObjects.glGetActiveUniformARB(this.getName(), index, length, size, type, name);
		}

		public void getActiveUniform(int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
			ARBShaderObjects.glGetActiveUniformARB(this.getName(), index, length, size, type, name);
		}

		public int getAttribLocation(CharSequence name) {
			return ARBVertexShader.glGetAttribLocationARB(this.getName(), name);
		}

		public int getAttribLocation(ByteBuffer name) {
			return ARBVertexShader.glGetAttribLocationARB(this.getName(), name);
		}

		public float getUniformf(int location) {
			return ARBShaderObjects.glGetUniformfARB(this.getName(), location);
		}

		public void getUniformfv(int location, float[] value) {
			ARBShaderObjects.glGetUniformfvARB(this.getName(), location, value);
		}

		public void getUniformfv(int location, FloatBuffer value) {
			ARBShaderObjects.glGetUniformfvARB(this.getName(), location, value);
		}

		public int getUniformi(int location) {
			return ARBShaderObjects.glGetUniformiARB(this.getName(), location);
		}

		public void getUniformiv(int location, int[] value) {
			ARBShaderObjects.glGetUniformivARB(this.getName(), location, value);
		}

		public void getUniformiv(int location, IntBuffer value) {
			ARBShaderObjects.glGetUniformivARB(this.getName(), location, value);
		}

		public void link() {
			ARBShaderObjects.glLinkProgramARB(this.getName());
		}

		public void validate() {
			ARBShaderObjects.glValidateProgramARB(this.getName());
		}

		public void attach(Shader shader) {
			ARBShaderObjects.glAttachObjectARB(this.getName(), shader.getName());
		}

		public void detach(Shader shader) {
			ARBShaderObjects.glDetachObjectARB(this.getName(), shader.getName());
		}

		public void getAttachedShaderNames(int[] count, int[] shaders) {
			ARBShaderObjects.glGetAttachedObjectsARB(this.getName(), count, shaders);
		}

		public void getAttachedShaderNames(IntBuffer count, IntBuffer shaders) {
			ARBShaderObjects.glGetAttachedObjectsARB(this.getName(), count, shaders);
		}

		public void enable() {
			ARBShaderObjects.glUseProgramObjectARB(this.getName());
		}

		public void disable() {
			ARBShaderObjects.glUseProgramObjectARB(0);
		}

		protected void delete() {
			ARBShaderObjects.glDeleteObjectARB(this.getName());
		}
	}
	
	/**{@link Program} parameters name<br><br>
	 * {@link #DELETE_STATUS}<br>
	 * {@link #LINK_STATUS}<br>
	 * {@link #VALIDATE_STATUS}<br>
	 * {@link #INFO_LOG_LENGTH}<br>
	 * {@link #ATTACHED_SHADERS}<br>
	 * {@link #ACTIVE_ATTRIBUTES}<br>
	 * {@link #ACTIVE_ATTRIBUTE_MAX_LENGTH}<br>
	 * {@link #ACTIVE_UNIFORMS}<br>
	 * {@link #ACTIVE_UNIFORM_MAX_LENGTH}<br>
	 * {@link #TRANSFORM_FEEDBACK_BUFFER_MODE}<br>
	 * {@link #TRANSFORM_FEEDBACK_VARYINGS}<br>
	 * {@link #TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH}<br>
	 * {@link #ACTIVE_UNIFORM_BLOCKS}<br>
	 * {@link #ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH}<br>
	 * {@link #GEOMETRY_VERTICES_OUT}<br>
	 * {@link #GEOMETRY_INPUT_TYPE}<br>
	 * {@link #GEOMETRY_OUTPUT_TYPE}<br>
	 * {@link #PROGRAM_BINARY_LENGTH}<br>
	 * {@link #ACTIVE_ATOMIC_COUNTER_BUFFERS}<br>
	 * {@link #COMPUTE_WORK_GROUP_SIZE}
	 */
	public static enum Parameter {
		
		DELETE_STATUS(GL20.GL_DELETE_STATUS),
		LINK_STATUS(GL20.GL_LINK_STATUS),
		VALIDATE_STATUS(GL20.GL_VALIDATE_STATUS),
		INFO_LOG_LENGTH(GL20.GL_INFO_LOG_LENGTH),
		ATTACHED_SHADERS(GL20.GL_ATTACHED_SHADERS),
		ACTIVE_ATTRIBUTES(GL20.GL_ACTIVE_ATTRIBUTES),
		ACTIVE_ATTRIBUTE_MAX_LENGTH(GL20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH),
		ACTIVE_UNIFORMS(GL20.GL_ACTIVE_UNIFORMS),
		ACTIVE_UNIFORM_MAX_LENGTH(GL20.GL_ACTIVE_UNIFORM_MAX_LENGTH),
		TRANSFORM_FEEDBACK_BUFFER_MODE(GL30.GL_TRANSFORM_FEEDBACK_BUFFER_MODE),
		TRANSFORM_FEEDBACK_VARYINGS(GL30.GL_TRANSFORM_FEEDBACK_VARYINGS),
		TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH(GL30.GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH),
		ACTIVE_UNIFORM_BLOCKS(GL31.GL_ACTIVE_UNIFORM_BLOCKS),
		ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH(GL31.GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH),
		GEOMETRY_VERTICES_OUT(GL32.GL_GEOMETRY_VERTICES_OUT),
		GEOMETRY_INPUT_TYPE(GL32.GL_GEOMETRY_INPUT_TYPE),
		GEOMETRY_OUTPUT_TYPE(GL32.GL_GEOMETRY_OUTPUT_TYPE),
		PROGRAM_BINARY_LENGTH(GL41.GL_PROGRAM_BINARY_LENGTH),
		ACTIVE_ATOMIC_COUNTER_BUFFERS(GL42.GL_ACTIVE_ATOMIC_COUNTER_BUFFERS),
		COMPUTE_WORK_GROUP_SIZE(GL43.GL_COMPUTE_WORK_GROUP_SIZE);
		
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
	
	/**Vertex attrib parameters<br><br>
	 * {@link #VERTEX_ATTRIB_ARRAY_BUFFER_BINDING}<br>
	 * {@link #VERTEX_ATTRIB_ARRAY_ENABLED}<br>
	 * {@link #VERTEX_ATTRIB_ARRAY_SIZE}<br>
	 * {@link #VERTEX_ATTRIB_ARRAY_STRIDE}<br>
	 * {@link #VERTEX_ATTRIB_ARRAY_NORMALIZED}<br>
	 * {@link #VERTEX_ATTRIB_ARRAY_INTEGER}<br>
	 * {@link #VERTEX_ATTRIB_ARRAY_DIVISOR}<br>
	 * {@link #CURRENT_VERTEX_ATTRIB}
	 */
	public static enum VertexAttribParameter {
		
		/**{@link ARBVertexBufferObject ARB_vertex_buffer_object} {@link ARBVertexBufferObject
		 * #GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB}
		 * and<br>{@link GL15 OpenGL 1.5} {@link GL15#GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING
		 * GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING}
		 */
		VERTEX_ATTRIB_ARRAY_BUFFER_BINDING(ARBVertexBufferObject.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB),
		
		/**{@link ARBVertexProgram ARB_vertex_program} {@link ARBVertexProgram
		 * #GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB}
		 * and<br>{@link GL20 OpenGL 2.0} {@link GL20#GL_VERTEX_ATTRIB_ARRAY_ENABLED
		 * GL_VERTEX_ATTRIB_ARRAY_ENABLED}
		 */
		VERTEX_ATTRIB_ARRAY_ENABLED(ARBVertexProgram.GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB),
		
		/**{@link ARBVertexProgram ARB_vertex_program} {@link ARBVertexProgram
		 * #GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB}
		 * and<br>{@link GL20 OpenGL 2.0} {@link GL20#GL_VERTEX_ATTRIB_ARRAY_SIZE
		 * GL_VERTEX_ATTRIB_ARRAY_SIZE}
		 */
		VERTEX_ATTRIB_ARRAY_SIZE(ARBVertexProgram.GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB),
		
		/**{@link ARBVertexProgram ARB_vertex_program} {@link ARBVertexProgram
		 * #GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB}
		 * and<br>{@link GL20 OpenGL 2.0} {@link GL20#GL_VERTEX_ATTRIB_ARRAY_STRIDE
		 * GL_VERTEX_ATTRIB_ARRAY_STRIDE}
		 */
		VERTEX_ATTRIB_ARRAY_STRIDE(ARBVertexProgram.GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB),
		
		/**{@link ARBVertexProgram ARB_vertex_program} {@link ARBVertexProgram
		 * #GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB}
		 * and<br>{@link GL20 OpenGL 2.0} {@link GL20#GL_VERTEX_ATTRIB_ARRAY_NORMALIZED
		 * GL_VERTEX_ATTRIB_ARRAY_NORMALIZED}
		 */
		VERTEX_ATTRIB_ARRAY_NORMALIZED(ARBVertexProgram.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB),
		
		/**{@link EXTGPUShader4 EXT_gpu_shader4} {@link EXTGPUShader4
		 * #GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT}
		 * and<br>{@link GL30 OpenGL 3.0} {@link GL30#GL_VERTEX_ATTRIB_ARRAY_INTEGER
		 * GL_VERTEX_ATTRIB_ARRAY_INTEGER}
		 */
		VERTEX_ATTRIB_ARRAY_INTEGER(EXTGPUShader4.GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT),
		
		/**{@link ARBInstancedArrays ARB_instanced_arrays} {@link ARBInstancedArrays
		 * #GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB}
		 * and<br>{@link GL33 OpenGL 3.3} {@link GL33#GL_VERTEX_ATTRIB_ARRAY_DIVISOR
		 * GL_VERTEX_ATTRIB_ARRAY_DIVISOR}
		 */
		VERTEX_ATTRIB_ARRAY_DIVISOR(ARBInstancedArrays.GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB),
		
		/**{@link ARBVertexProgram ARB_vertex_program} {@link ARBVertexProgram
		 * #GL_CURRENT_VERTEX_ATTRIB_ARB GL_CURRENT_VERTEX_ATTRIB_ARB} and<br>
		 * {@link GL20 OpenGL 2.0} {@link GL20#GL_CURRENT_VERTEX_ATTRIB
		 * GL_CURRENT_VERTEX_ATTRIB}
		 */
		CURRENT_VERTEX_ATTRIB(ARBVertexProgram.GL_CURRENT_VERTEX_ATTRIB_ARB);
		
		private int value;
		
		VertexAttribParameter(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
	}
}
