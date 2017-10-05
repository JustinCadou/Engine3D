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
package oolwre.render.data.shader;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.opengl.ARBGeometryShader4;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBTessellationShader;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GLCapabilities;
import oolwre.CapabilityProvider;

public abstract class Shader {
	
	private static Map<Integer, Shader> shaders;
	
	static {
		shaders = new HashMap<>();
	}
	
	private int name;
	protected final Type type;
	
	/**Constructs an {@link Object} of type {@link Shader} handling the specified
	 * open GL shader object instance.
	 * 
	 * @param name - The name of the open GL shader
	 * @param type - The shader {@link Type} (optional)
	 */
	public Shader(int name, Type type) {
		this.name = name;
		shaders.put(name, this);
		this.type = type;
	}
	
	public final int getName() {
		return this.name;
	}
	
	public final Type getType() {
		return this.type;
	}
	
	public abstract int geti(Parameter param);
	
	public abstract void getiv(Parameter param, int[] params);
	
	public abstract void getiv(Parameter param, IntBuffer params);
	
	public abstract String getInfoLog();
	
	public abstract String getInfoLog(int maxLength);
	
	public abstract void getInfoLog(int[] length, ByteBuffer log);
	
	public abstract void getInfoLog(IntBuffer length, ByteBuffer log);
	
	public abstract String getSource();
	
	public abstract String getSource(int maxLength);
	
	public abstract void getSource(int[] length, ByteBuffer source);
	
	public abstract void getSource(IntBuffer length, ByteBuffer source);
	
	public abstract void shaderSource(CharSequence source);
	
	public abstract void shaderSource(CharSequence... sources);
	
	public abstract void shaderSource(PointerBuffer strings, int[] length);
	
	public abstract void shaderSource(PointerBuffer strings, IntBuffer length);
	
	public abstract void compile();
	
	protected abstract void delete();
	
	public final void destroy() {
		this.delete();
		shaders.remove(this.name);
		this.name = 0;
	}
	
	/**Creates a {@link Shader} of the specified {@link Type} using the specified
	 * {@link CapabilityProvider}.
	 * 
	 * @param provider - The {@link CapabilityProvider}
	 * @param type - The {@link Shader} {@link Type}
	 * 
	 * @throws UnsupportedOperationException If there is no supported extension
	 * to create a {@link Shader}
	 * 
	 * @return A newly created {@link Shader} instance
	 */
	public static Shader create(CapabilityProvider provider, Type type) {
		if (provider == null) {
			throw new NullPointerException("Capability provider is null!");
		}
		GLCapabilities caps = provider.getCapabilities();
		if (caps.OpenGL20) {
			int name = GL20Shader.genName(type);
			return new GL20Shader(name, type);
		} else if (caps.GL_ARB_shader_objects) {
			int name = ARBShader.genName(type);
			return new ARBShader(name, type);
		} else {
			throw new UnsupportedOperationException("There is no supported extension to create a Shader!");
		}
	}
	
	/**Creates a {@link Shader} of the specified {@link Type} using the current
	 * {@link Thread}'s {@link CapabilityProvider}.
	 * 
	 * @param type - The {@link Shader} {@link Type}
	 * 
	 * @throws UnsupportedOperationException If there is no supported extension
	 * to create a {@link Shader}
	 * 
	 * @return A newly created {@link Shader} instance
	 */
	public static Shader create(Type type) {
		return create(CapabilityProvider.get(), type);
	}
	
	public static Shader getShaderByName(int name) {
		return shaders.get(name);
	}
	
	private static class GL20Shader extends Shader {
		
		public static int genName(Type type) {
			return GL20.glCreateShader(type.value);
		}
		
		public GL20Shader(int name, Type type) {
			super(name, type);
		}
		
		public int geti(Parameter param) {
			return GL20.glGetShaderi(this.getName(), param.value);
		}
		
		public void getiv(Parameter param, int[] params) {
			GL20.glGetShaderiv(this.getName(), param.value, params);
		}
		
		public void getiv(Parameter param, IntBuffer params) {
			GL20.glGetShaderiv(this.getName(), param.value, params);
		}
		
		public String getInfoLog() {
			return GL20.glGetShaderInfoLog(this.getName());
		}
		
		public String getInfoLog(int maxLength) {
			return GL20.glGetShaderInfoLog(this.getName(), maxLength);
		}
		
		public void getInfoLog(int[] length, ByteBuffer log) {
			GL20.glGetShaderInfoLog(this.getName(), length, log);
		}
		
		public void getInfoLog(IntBuffer length, ByteBuffer log) {
			GL20.glGetShaderInfoLog(this.getName(), length, log);
		}
		
		public String getSource() {
			return GL20.glGetShaderSource(this.getName());
		}
		
		public String getSource(int maxLength) {
			return GL20.glGetShaderSource(this.getName(), maxLength);
		}
		
		public void getSource(int[] length, ByteBuffer source) {
			GL20.glGetShaderSource(this.getName(), length, source);
		}
		
		public void getSource(IntBuffer length, ByteBuffer source) {
			GL20.glGetShaderSource(this.getName(), length, source);
		}
		
		public void shaderSource(CharSequence source) {
			GL20.glShaderSource(this.getName(), source);
		}
		
		public void shaderSource(CharSequence... sources) {
			GL20.glShaderSource(this.getName(), sources);
		}
		
		public void shaderSource(PointerBuffer strings, int[] length) {
			GL20.glShaderSource(this.getName(), strings, length);
		}
		
		public void shaderSource(PointerBuffer strings, IntBuffer length) {
			GL20.glShaderSource(this.getName(), strings, length);
		}
		
		public void compile() {
			GL20.glCompileShader(this.getName());
		}
		
		protected void delete() {
			GL20.glDeleteShader(this.getName());
		}
	}
	
	private static class ARBShader extends Shader {
		
		public static int genName(Type type) {
			return ARBShaderObjects.glCreateShaderObjectARB(type.value);
		}
		
		public ARBShader(int name, Type type) {
			super(name, type);
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
		
		public void getInfoLog(int[] length, ByteBuffer log) {
			ARBShaderObjects.glGetInfoLogARB(this.getName(), length, log);
		}
		
		public void getInfoLog(IntBuffer length, ByteBuffer log) {
			ARBShaderObjects.glGetInfoLogARB(this.getName(), length, log);
		}
		
		public String getSource() {
			return ARBShaderObjects.glGetShaderSourceARB(this.getName());
		}
		
		public String getSource(int maxLength) {
			return ARBShaderObjects.glGetShaderSourceARB(this.getName(), maxLength);
		}
		
		public void getSource(int[] length, ByteBuffer source) {
			ARBShaderObjects.glGetShaderSourceARB(this.getName(), length, source);
		}
		
		public void getSource(IntBuffer length, ByteBuffer source) {
			ARBShaderObjects.glGetShaderSourceARB(this.getName(), length, source);
		}
		
		public void shaderSource(CharSequence source) {
			ARBShaderObjects.glShaderSourceARB(this.getName(), source);
		}
		
		public void shaderSource(CharSequence... sources) {
			ARBShaderObjects.glShaderSourceARB(this.getName(), sources);
		}
		
		public void shaderSource(PointerBuffer string, int[] length) {
			ARBShaderObjects.glShaderSourceARB(this.getName(), string, length);
		}
		
		public void shaderSource(PointerBuffer string, IntBuffer length) {
			ARBShaderObjects.glShaderSourceARB(this.getName(), string, length);
		}
		
		public void compile() {
			ARBShaderObjects.glCompileShaderARB(this.getName());
		}
		
		public void delete() {
			ARBShaderObjects.glDeleteObjectARB(this.getName());
		}
	}
	
	/**The possible {@link Shader} type.<br><br>
	 * {@link #VERTEX}<br>
	 * {@link #FRAGMENT}<br>
	 * {@link #GEOMETRY}<br>
	 * {@link #TESS_CONTROL}<br>
	 * {@link #TESS_EVALUATION}
	 */
	public static enum Type {
		
		/**{@link ARBVertexShader ARB_vertex_shader} {@link ARBVertexShader
		 * #GL_VERTEX_SHADER_ARB GL_VERTEX_SHADER_ARB} and<br>{@link GL20
		 * OpenGL 2.0} {@link GL20#GL_VERTEX_SHADER GL_VERTEX_SHADER}
		 */
		VERTEX(ARBVertexShader.GL_VERTEX_SHADER_ARB),
		
		/**{@link ARBFragmentShader ARB_fragment_shader} {@link ARBFragmentShader
		 * #GL_FRAGMENT_SHADER_ARB GL_FRAGMENT_SHADER_ARB} and<br>{@link GL20
		 * OpenGL 2.0} {@link GL20#GL_FRAGMENT_SHADER GL_FRAGMENT_SHADER}
		 */
		FRAGMENT(ARBFragmentShader.GL_FRAGMENT_SHADER_ARB),
		
		/**{@link ARBGeometryShader4 ARB_geometry_shader4} {@link ARBGeometryShader4
		 * #GL_GEOMETRY_SHADER_ARB GL_GEOMETRY_SHADER_ARB} and<br>{@link GL32
		 * OpenGL 3.2} {@link GL32#GL_GEOMETRY_SHADER GL_GEOMETRY_SHADER}
		 */
		GEOMETRY(ARBGeometryShader4.GL_GEOMETRY_SHADER_ARB),
		
		/**{@link ARBTessellationShader ARB_tessellation_shader} {@link
		 * ARBTessellationShader#GL_TESS_CONTROL_SHADER GL_TESS_CONTROL_SHADER} 
		 * and<br>{@link GL40 OpenGL 4.0} {@link GL40#GL_TESS_CONTROL_SHADER
		 * GL_TESS_CONTROL_SHADER}
		 */
		TESS_CONTROL(ARBTessellationShader.GL_TESS_CONTROL_SHADER),
		
		/**{@link ARBTessellationShader ARB_tessellation_shader} {@link
		 * ARBTessellationShader#GL_TESS_EVALUATION_SHADER GL_TESS_EVALUATION_SHADER} 
		 * and<br>{@link GL40 OpenGL 4.0} {@link GL40#GL_TESS_EVALUATION_SHADER
		 * GL_TESS_EVALUATION_SHADER}
		 */
		TESS_EVALUATION(ARBTessellationShader.GL_TESS_EVALUATION_SHADER);
		
		private int value;
		
		Type(int value) {
			this.value = value;
		}
		
		/** Returns the GLEnum value represented by the {@link Type} */
		public int glValue() {
			return this.value;
		}
		
		/** Returns the {@link Type} represented by the GLEnum value */
		public static Type forGlValue(int glValue) {
			for (Type type : values()) {
				if (type.value == glValue) {
					return type;
				}
			}
			return null;
		}
	}
	
	/**{@link Shader} parameters name<br><br>
	 * {@link #TYPE}<br>
	 * {@link #DELETE_STATUS}<br>
	 * {@link #COMPILE_STATUS}<br>
	 * {@link #INFO_LOG_LENGTH}<br>
	 * {@link #SHADER_SOURCE_LENGTH}
	 */
	public static enum Parameter {
		
		/**{@link ARBShaderObjects ARB_shader_objects} {@link ARBShaderObjects
		 * #GL_OBJECT_SUBTYPE_ARB GL_OBJECT_SUBTYPE_ARB} and<br>{@link GL20
		 * OpenGL 2.0} {@link GL20#GL_SHADER_TYPE GL_SHADER_TYPE}
		 */
		TYPE(ARBShaderObjects.GL_OBJECT_SUBTYPE_ARB),
		
		/**{@link ARBShaderObjects ARB_shader_objects} {@link ARBShaderObjects
		 * #GL_OBJECT_DELETE_STATUS_ARB GL_OBJECT_DELETE_STATUS_ARB} and<br>
		 * {@link GL20 OpenGL 2.0} {@link GL20#GL_DELETE_STATUS GL_DELETE_STATUS}
		 */
		DELETE_STATUS(ARBShaderObjects.GL_OBJECT_DELETE_STATUS_ARB),
		
		/**{@link ARBShaderObjects ARB_shader_objects} {@link ARBShaderObjects
		 * #GL_OBJECT_COMPILE_STATUS_ARB GL_OBJECT_COMPILE_STATUS_ARB} and<br>
		 * {@link GL20 OpenGL 2.0} {@link GL20#GL_COMPILE_STATUS GL_COMPILE_STATUS}
		 */
		COMPILE_STATUS(ARBShaderObjects.GL_OBJECT_COMPILE_STATUS_ARB),
		
		/**{@link ARBShaderObjects ARB_shader_objects} {@link ARBShaderObjects
		 * #GL_OBJECT_INFO_LOG_LENGTH_ARB GL_OBJECT_INFO_LOG_LENGTH_ARB} and<br>
		 * {@link GL20 OpenGL 2.0} {@link GL20#GL_INFO_LOG_LENGTH
		 * GL_INFO_LOG_LENGTH}
		 */
		INFO_LOG_LENGTH(ARBShaderObjects.GL_OBJECT_INFO_LOG_LENGTH_ARB),
		
		/**{@link ARBShaderObjects ARB_shader_objects} {@link ARBShaderObjects
		 * #GL_OBJECT_SHADER_SOURCE_LENGTH_ARB GL_OBJECT_SHADER_SOURCE_LENGTH_ARB}
		 * and<br> {@link GL20 OpenGL 2.0} {@link GL20#GL_SHADER_SOURCE_LENGTH
		 * GL_SHADER_SOURCE_LENGTH}
		 */
		SHADER_SOURCE_LENGTH(ARBShaderObjects.GL_OBJECT_SHADER_SOURCE_LENGTH_ARB);
		
		private int value;
		
		Parameter(int value) {
			this.value = value;
		}
		
		/**Returns the GL value associated with the {@link Parameter}.
		 */
		public int glValue() {
			return this.value;
		}
		
		/**Returns the {@link Parameter} associated with the GL value.
		 * 
		 * @param val - The GL value
		 */
		public static Parameter forGlValue(int val) {
			for (Parameter param : values()) {
				if (param.value == val) {
					return param;
				}
			}
			return null;
		}
	}
}
