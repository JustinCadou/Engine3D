package oolwre.render.data;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
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
	
	private int name;
	
	public Texture(int name) {
		this.name = name;
	}
	
	public final int getName() {
		return this.name;
	}
	
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
