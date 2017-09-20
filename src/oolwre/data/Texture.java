package oolwre.data;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL32;
import oolwre.image.Image;
import oolwre.image.SafeImage;
import oolwre.image.UnsafeImageException;

public class Texture {
	
	private int name;
	private Type type;
	private Format format;
	
	public Texture(Type type, Format format) {
		this.name = GL11.glGenTextures();
		this.type = type;
		this.format = format;
	}
	
	/**Returns the {@link Texture}'s name
	 * 
	 * @return The name
	 */
	public int getName() {
		return this.name;
	}
	
	/**Returns the {@link Texture}'s {@link Type}.
	 * 
	 * @return The type
	 */
	public Type getType() {
		return this.type;
	}
	
	/**Returns the {@link Texture}'s {@link Format}.
	 * 
	 * @return The format
	 */
	public Format getFormat() {
		return this.format;
	}
	
	/**Specifies a 1-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage1D(int, int, int, int, int, int, int, ByteBuffer)
	 * glTexImage1D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The 1D texel width
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage1D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int border, ByteBuffer pixels) {
		GL11.glTexImage1D(this.type.value, levelOfDetails, this.format.glValue(), width,
				border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 1-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage1D(int, int, int, int, int, int, int, ShortBuffer)
	 * glTexImage1D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The 1D texel width
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage1D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int border, ShortBuffer pixels) {
		GL11.glTexImage1D(this.type.value, levelOfDetails, this.format.glValue(), width,
				border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 1-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage1D(int, int, int, int, int, int, int, IntBuffer)
	 * glTexImage1D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The 1D texel width
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage1D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int border, IntBuffer pixels) {
		GL11.glTexImage1D(this.type.value, levelOfDetails, this.format.glValue(), width,
				border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 1-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage1D(int, int, int, int, int, int, int, FloatBuffer)
	 * glTexImage1D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The 1D texel width
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage1D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int border, FloatBuffer pixels) {
		GL11.glTexImage1D(this.type.value, levelOfDetails, this.format.glValue(), width,
				border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 1-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage1D(int, int, int, int, int, int, int, DoubleBuffer)
	 * glTexImage1D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The 1D texel width
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage1D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int border, DoubleBuffer pixels) {
		GL11.glTexImage1D(this.type.value, levelOfDetails, this.format.glValue(), width,
				border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 2-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage2D(int, int, int, int, int, int, int, int, ByteBuffer)
	 * glTexImage2D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The texel width
	 * @param height - The texel height
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage2D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int height, int border, ByteBuffer pixels) {
		GL11.glTexImage2D(this.type.value, levelOfDetails, this.format.glValue(), width,
				height, border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 2-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage2D(int, int, int, int, int, int, int, int, ShortBuffer)
	 * glTexImage2D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The texel width
	 * @param height - The texel height
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage2D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int height, int border, ShortBuffer pixels) {
		GL11.glTexImage2D(this.type.value, levelOfDetails, this.format.glValue(), width,
				height, border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 2-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage2D(int, int, int, int, int, int, int, int, IntBuffer)
	 * glTexImage2D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The texel width
	 * @param height - The texel height
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage2D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int height, int border, IntBuffer pixels) {
		GL11.glTexImage2D(this.type.value, levelOfDetails, this.format.glValue(), width,
				height, border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 2-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage2D(int, int, int, int, int, int, int, int, FloatBuffer)
	 * glTexImage2D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The texel width
	 * @param height - The texel height
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage2D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int height, int border, FloatBuffer pixels) {
		GL11.glTexImage2D(this.type.value, levelOfDetails, this.format.glValue(), width,
				height, border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 2-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage2D(int, int, int, int, int, int, int, int, DoubleBuffer)
	 * glTexImage2D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param width - The texel width
	 * @param height - The texel height
	 * @param border - The texture border
	 * @param pixels - The texel data
	 */
	public void texImage2D(Image.Format imgFormat, ValueType dataType, int levelOfDetails,
			int width, int height, int border, DoubleBuffer pixels) {
		GL11.glTexImage2D(this.type.value, levelOfDetails, this.format.glValue(), width,
				height, border, imgFormat.glValue(), dataType.glValue(), pixels);
	}
	
	/**Specifies a 2-dimensional texture image<br><br>
	 * <b>See</b> {@link GL11#glTexImage2D(int, int, int, int, int, int, int, int, ByteBuffer)
	 * glTexImage2D()}
	 * 
	 * @param imgFormat - The texel {@link Image.Format}
	 * @param dataType - The texel {@link ValueType}
	 * @param levelOfDetails - The level-of-detail number
	 * @param border - The texture border
	 * @param src - The texel data
	 * 
	 * @throws UnsafeImageException As specified by {@link Image#toSafeImage()}
	 */
	public void texImage2D(Image.Format imgFormat, ValueType dataType, int levelOfDetails, int border,
			Image src) throws UnsafeImageException {
		SafeImage image = src.toSafeImage();
		GL11.glTexImage2D(this.type.value, levelOfDetails, this.format.glValue(), src.getWidth(),
				src.getHeight(), border, imgFormat.glValue(), dataType.glValue(), image.getBuffer());
	}
	
	/**Binds this {@link Texture}.<br><br>
	 * <b>See</b> {@link GL11#glBindTexture(int, int) glBindTexture()}
	 */
	public void bind() {
		GL11.glBindTexture(this.type.value, this.name);
	}
	
	/**Unbinds this {@link Texture}.<br><br>
	 * <b>See</b> {@link GL11#glBindTexture(int, int) glBindTexture()}
	 */
	public void unbind() {
		GL11.glBindTexture(this.type.value, 0);
	}
	
	/**Destroys this {@link Texture}.<br><br>
	 * <b>See</b> {@link GL11#glDeleteTextures(int) glDeleteTextures()}
	 */
	public void destroy() {
		GL11.glDeleteTextures(this.name);
		this.name = 0;
	}
	
	public static enum Type {
		
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
		
		Type(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static Type forGLValue(int value) {
			for (Type type : values()) {
				if (type.value == value) {
					return type;
				}
			}
			return null;
		}
	}
	
	public static enum Format {
		R(GL11.GL_RED);
		
		private int value;
		
		Format(int value) {
			this.value = value;
		}
		
		public int glValue() {
			return this.value;
		}
		
		public static Format forGLValue(int glValue) {
			for (Format format: values()) {
				if (format.value == glValue) {
					return format;
				}
			}
			return null;
		}
	}
}
