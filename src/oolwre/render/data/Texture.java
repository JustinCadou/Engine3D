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

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.ARBTextureBufferObject;
import org.lwjgl.opengl.ARBTextureCubeMap;
import org.lwjgl.opengl.ARBTextureCubeMapArray;
import org.lwjgl.opengl.ARBTextureMultisample;
import org.lwjgl.opengl.ARBTextureRectangle;
import org.lwjgl.opengl.EXTTextureArray;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GLCapabilities;
import oolwre.CapabilityProvider;
import oolwre.image.Image;

public abstract class Texture {
	
	public static final int MIN_MAG_FILTER_LINEAR = GL11.GL_LINEAR;
	public static final int MIN_MAG_FILTER_NEAREST = GL11.GL_NEAREST;
	public static final int WRAP_S_T_CLAMP = GL11.GL_CLAMP;
	public static final int WRAP_S_T_RESCALE_NORMAL = GL12.GL_RESCALE_NORMAL;
	
	private static Map<Integer, Texture> textures;
	
	static {
		textures = new HashMap<>();
	}
	
	private int name;
	
	public Texture(int name) {
		this.name = name;
		textures.put(name, this);
	}
	
	public final int getName() {
		return this.name;
	}
	
	public abstract void parameteri(Target target, Parameter param, int value);
	
	public abstract void parameteriv(Target target, Parameter param, int[] value);
	
	public abstract void parameteriv(Target target, Parameter param, IntBuffer value);
	
	public abstract void parameterf(Target target, Parameter param, float value);
	
	public abstract void parameterfv(Target target, Parameter param, float[] value);
	
	public abstract void parameterfv(Target target, Parameter param, FloatBuffer value);
	
	public abstract void texImage1D(Target target, int level, Format format, int width, int border,
			Image.Format imgFormat, Type type, ByteBuffer pixels);
	
	public abstract void texImage1D(Target target, int level, Format format, int width, int border,
			Image.Format imgFormat, Type type, ShortBuffer pixels);
	
	public abstract void texImage1D(Target target, int level, Format format, int width, int border,
			Image.Format imgFormat, Type type, IntBuffer pixels);
	
	public abstract void texImage1D(Target target, int level, Format format, int width, int border,
			Image.Format imgFormat, Type type, FloatBuffer pixels);
	
	public abstract void texImage1D(Target target, int level, Format format, int width, int border,
			Image.Format imgFormat, Type type, DoubleBuffer pixels);
	
	public abstract void texImage2D(Target target, int level, Format format, int width, int height,
			int border, Image.Format imgFormat, Type type, ByteBuffer pixels);
	
	public abstract void texImage2D(Target target, int level, Format format, int width, int height,
			int border, Image.Format imgFormat, Type type, ShortBuffer pixels);
	
	public abstract void texImage2D(Target target, int level, Format format, int width, int height,
			int border, Image.Format imgFormat, Type type, IntBuffer pixels);
	
	public abstract void texImage2D(Target target, int level, Format format, int width, int height,
			int border, Image.Format imgFormat, Type type, FloatBuffer pixels);
	
	public abstract void texImage2D(Target target, int level, Format format, int width, int height,
			int border, Image.Format imgFormat, Type type, DoubleBuffer pixels);
	
	public abstract void bind(Target target);
	
	public abstract void unbind(Target target);
	
	protected abstract void delete();
	
	public final void destroy() {
		this.delete();
		textures.remove(this.name);
		this.name = 0;
	}
	
	public static Texture create(CapabilityProvider provider) {
		if (provider == null) {
			throw new NullPointerException("Capability provider is null!");
		}
		GLCapabilities caps = provider.getCapabilities();
		if (caps.OpenGL11) {
			int name = GL11Texture.genName();
			return new GL11Texture(name);
		} else {
			throw new UnsupportedOperationException("There is no extension supported to create a texture!");
		}
	}
	
	public static Texture create() {
		return create(CapabilityProvider.get());
	}
	
	private static class GL11Texture extends Texture {
		
		public static int genName() {
			return GL11.glGenTextures();
		}
		
		public GL11Texture(int name) {
			super(name);
		}
		
		public void parameteri(Target target, Parameter param, int value) {
			GL11.glTexParameteri(target.value, param.value, value);
		}
		
		public void parameteriv(Target target, Parameter param, int[] value) {
			GL11.glTexParameteriv(target.value, param.value, value);
		}
		
		public void parameteriv(Target target, Parameter param, IntBuffer value) {
			GL11.glTexParameteriv(target.value, param.value, value);
		}
		
		public void parameterf(Target target, Parameter param, float value) {
			GL11.glTexParameterf(target.value, param.value, value);
		}
		
		public void parameterfv(Target target, Parameter param, float[] value) {
			GL11.glTexParameterfv(target.value, param.value, value);
		}
		
		public void parameterfv(Target target, Parameter param, FloatBuffer value) {
			GL11.glTexParameterfv(target.value, param.value, value);
		}

		public void texImage1D(Target target, int level, Format format, int width, int border,
				Image.Format imgFormat, Type type, ByteBuffer pixels) {
			GL11.glTexImage1D(target.value, level, format.value, width, border, imgFormat.glValue(),
					type.glValue(), pixels);
		}

		public void texImage1D(Target target, int level, Format format, int width, int border,
				Image.Format imgFormat, Type type, ShortBuffer pixels) {
			GL11.glTexImage1D(target.value, level, format.value, width, border, imgFormat.glValue(),
					type.glValue(), pixels);
		}

		public void texImage1D(Target target, int level, Format format, int width, int border,
				Image.Format imgFormat, Type type, IntBuffer pixels) {
			GL11.glTexImage1D(target.value, level, format.value, width, border, imgFormat.glValue(),
					type.glValue(), pixels);
		}

		public void texImage1D(Target target, int level, Format format, int width, int border,
				Image.Format imgFormat, Type type, FloatBuffer pixels) {
			GL11.glTexImage1D(target.value, level, format.value, width, border, imgFormat.glValue(),
					type.glValue(), pixels);
		}

		public void texImage1D(Target target, int level, Format format, int width, int border,
				Image.Format imgFormat, Type type, DoubleBuffer pixels) {
			GL11.glTexImage1D(target.value, level, format.value, width, border, imgFormat.glValue(),
					type.glValue(), pixels);
		}

		public void texImage2D(Target target, int level, Format format, int width, int height, int border,
				Image.Format imgFormat, Type type, ByteBuffer pixels) {
			GL11.glTexImage2D(target.value, level, format.value, width, height, border,
					imgFormat.glValue(), type.glValue(), pixels);
		}

		public void texImage2D(Target target, int level, Format format, int width, int height, int border,
				Image.Format imgFormat, Type type, ShortBuffer pixels) {
			GL11.glTexImage2D(target.value, level, format.value, width, height, border,
					imgFormat.glValue(), type.glValue(), pixels);
		}

		public void texImage2D(Target target, int level, Format format, int width, int height, int border,
				Image.Format imgFormat, Type type, IntBuffer pixels) {
			GL11.glTexImage2D(target.value, level, format.value, width, height, border,
					imgFormat.glValue(), type.glValue(), pixels);
		}

		public void texImage2D(Target target, int level, Format format, int width, int height, int border,
				Image.Format imgFormat, Type type, FloatBuffer pixels) {
			GL11.glTexImage2D(target.value, level, format.value, width, height, border,
					imgFormat.glValue(), type.glValue(), pixels);
		}

		public void texImage2D(Target target, int level, Format format, int width, int height, int border,
				Image.Format imgFormat, Type type, DoubleBuffer pixels) {
			GL11.glTexImage2D(target.value, level, format.value, width, height, border,
					imgFormat.glValue(), type.glValue(), pixels);
		}

		public void bind(Target target) {
			GL11.glBindTexture(target.value, this.getName());
		}

		public void unbind(Target target) {
			GL11.glBindTexture(target.value, 0);
		}

		protected void delete() {
			GL11.glDeleteTextures(this.getName());
		}
	}
	
	public static enum Target {
		
		TEXTURE_1D(GL11.GL_TEXTURE_1D),
		TEXTURE_1D_ARRAY(EXTTextureArray.GL_TEXTURE_1D_ARRAY_EXT),
		TEXTURE_2D(GL11.GL_TEXTURE_2D),
		TEXTURE_2D_ARRAY(EXTTextureArray.GL_TEXTURE_2D_ARRAY_EXT),
		TEXTURE_2D_MULTISAMPLE(ARBTextureMultisample.GL_TEXTURE_2D_MULTISAMPLE),
		TEXTURE_2D_MULTISAMPLE_ARRAY(ARBTextureMultisample.GL_TEXTURE_2D_MULTISAMPLE_ARRAY),
		TEXTURE_3D(GL12.GL_TEXTURE_3D),
		TEXTURE_RECTANLE(ARBTextureRectangle.GL_TEXTURE_RECTANGLE_ARB),
		TEXTURE_CUBE_MAP(ARBTextureCubeMap.GL_TEXTURE_CUBE_MAP_ARB),
		TEXTURE_CUBE_MAP_ARRAY(ARBTextureCubeMapArray.GL_TEXTURE_CUBE_MAP_ARRAY_ARB),
		TEXTURE_BUFFER(ARBTextureBufferObject.GL_TEXTURE_BUFFER_ARB);
		
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
	
	public static enum Parameter {
		
		MIN_FILTER(GL11.GL_TEXTURE_MIN_FILTER),
		MAG_FILTER(GL11.GL_TEXTURE_MAG_FILTER),
		WRAP_S(GL11.GL_TEXTURE_WRAP_S),
		WRAP_T(GL11.GL_TEXTURE_WRAP_T),
		BORDER_COLOR(GL11.GL_TEXTURE_BORDER_COLOR),
		PRIORITY(GL11.GL_TEXTURE_PRIORITY);
		
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
	
	public static enum Format {
		RGB(GL11.GL_RGB),
		RGBA(GL11.GL_RGBA),
		DEPTH_COMPONENT(GL11.GL_DEPTH_COMPONENT);
		
		private int value;
		
		Format(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static Format forGlValue(int val) {
			for (Format format : values()) {
				if (format.value == val) {
					return format;
				}
			}
			return null;
		}
	}
}
