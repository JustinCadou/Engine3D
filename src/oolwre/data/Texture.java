package oolwre.data;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL32;

public class Texture {
	
	private int name;
	private TextureType type;
	
	public Texture(TextureType type) {
		this.name = GL11.glGenTextures();
		this.type = type;
	}
	
	public int getName() {
		return this.name;
	}
	
	public TextureType getType() {
		return this.type;
	}
	
	public void bind() {
		GL11.glBindTexture(this.type.value, this.name);
	}
	
	public void unbind() {
		GL11.glBindTexture(this.type.value, 0);
	}
	
	public void destroy() {
		GL11.glDeleteTextures(this.name);
		this.name = 0;
	}
	
	public static enum TextureType {
		
		TEXTURE_1D(GL11.GL_TEXTURE_1D),
		TEXTURE_2D(GL11.GL_TEXTURE_2D),
		TEXTURE_3D(GL12.GL_TEXTURE_3D),
		TEXTURE_RECTANGLE(GL31.GL_TEXTURE_RECTANGLE),
		TEXTURE_BUFFER(GL31.GL_TEXTURE_BUFFER),
		TEXTURE_CUBE_MAP(GL13.GL_TEXTURE_CUBE_MAP),
		TEXTURE_1D_ARRAY(GL30.GL_TEXTURE_1D_ARRAY),
		TEXTURE_2D_ARRAY(GL30.GL_TEXTURE_2D_ARRAY),
		TEXTURE_2D_MULTISAMPLE(GL32.GL_TEXTURE_2D_MULTISAMPLE),
		TEXTURE_2D_MULTISAMPLE_ARRAY(GL32.GL_TEXTURE_2D_MULTISAMPLE_ARRAY);
		
		private int value;
		
		TextureType(int value) {
			this.value = value;
		}
		
		public static TextureType forGLValue(int value) {
			for (TextureType type : values()) {
				if (type.value == value) {
					return type;
				}
			}
			return null;
		}
	}
}
