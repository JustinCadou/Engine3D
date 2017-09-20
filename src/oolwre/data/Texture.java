package oolwre.data;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL41;
import org.lwjgl.opengl.GL42;
import org.lwjgl.opengl.GL43;
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
	
	/**{@link Texture} type<br><br>
	 * {@link #TEXTURE_1D}<br>
	 * {@link #TEXTURE_2D}<br>
	 * {@link #TEXTURE_3D}<br>
	 * {@link #TEXTURE_RECTANGLE}<br>
	 * {@link #TEXTURE_BUFFER}<br>
	 * {@link #TEXTURE_CUBE_MAP}<br>
	 * {@link #TEXTURE_1D_ARRAY}<br>
	 * {@link #TEXTURE_2D_ARRAY}<br>
	 * {@link #TEXTURE_2D_MULTISAMPLE}<br>
	 * {@link #TEXTURE_2D_MULTISAMPLE_ARRAY}
	 */
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
	
	/**{@link Texture} format<br><br>
	 * {@link #R}<br>
	 * {@link #RG}<br>
	 * {@link #RGB}<br>
	 * {@link #RGBA}<br><br>
	 * {@link #R8}<br>
	 * {@link #R8_SNORM}<br>
	 * {@link #R8I}<br>
	 * {@link #R8UI}<br>
	 * {@link #R16}<br>
	 * {@link #R16_SNORM}<br>
	 * {@link #R16F}<br>
	 * {@link #R16I}<br>
	 * {@link #R16UI}<br>
	 * {@link #R32F}<br>
	 * {@link #R32I}<br>
	 * {@link #R32UI}<br><br>
	 * {@link #RG8}<br>
	 * {@link #RG8_SNORM}<br>
	 * {@link #RG8I}<br>
	 * {@link #RG8UI}<br>
	 * {@link #RG16}<br>
	 * {@link #RG16_SNORM}<br>
	 * {@link #RG16F}<br>
	 * {@link #RG16I}<br>
	 * {@link #RG16UI}<br>
	 * {@link #RG32F}<br>
	 * {@link #RG32I}<br>
	 * {@link #RG32UI}<br><br>
	 * {@link #RGB4}<br>
	 * {@link #RGB5}<br>
	 * {@link #RGB8}<br>
	 * {@link #RGB8_SNORM}<br>
	 * {@link #RGB8I}<br>
	 * {@link #RGB8UI}<br>
	 * {@link #RGB10}<br>
	 * {@link #RGB12}<br>
	 * {@link #RGB16}<br>
	 * {@link #RGB16_SNORM}<br>
	 * {@link #RGB16F}<br>
	 * {@link #RGB16I}<br>
	 * {@link #RGB16UI}<br>
	 * {@link #RGB32F}<br>
	 * {@link #RGB32I}<br>
	 * {@link #RGB32UI}<br>
	 * {@link #RGB565}<br>
	 * {@link #R3_G3_B2}<br>
	 * {@link #R11F_G11F_B10F}<br><br>
	 * {@link #RGBA2}<br>
	 * {@link #RGBA4}<br>
	 * {@link #RGBA8}<br>
	 * {@link #RGBA8_SNORM}<br>
	 * {@link #RGBA8I}<br>
	 * {@link #RGBA8UI}<br>
	 * {@link #RGBA12}<br>
	 * {@link #RGBA16}<br>
	 * {@link #RGBA16_SNORM}<br>
	 * {@link #RGBA16F}<br>
	 * {@link #RGBA16I}<br>
	 * {@link #RGBA16UI}<br>
	 * {@link #RGBA32F}<br>
	 * {@link #RGBA32I}<br>
	 * {@link #RGBA32UI}<br>
	 * {@link #RGB5_A1}<br>
	 * {@link #RGB10_A2}<br>
	 * {@link #RGB10_A2UI}<br>
	 * {@link #RGB9_E5}<br><br>
	 * {@link #SRGB8}<br>
	 * {@link #SRGB8_APLHA8}<br><br>
	 * {@link #DEPTH_COMPONENT}<br>
	 * {@link #DEPTH_COMPONENT16}<br>
	 * {@link #DEPTH_COMPONENT24}<br>
	 * {@link #DEPTH_COMPONENT32}<br>
	 * {@link #DEPTH_COMPONENT32F}<br>
	 * {@link #DEPTH24_STENCIL8}<br>
	 * {@link #DEPTH32F_STENCIL8}<br>
	 * {@link #DEPTH_STENCIL}<br><br>
	 * {@link #COMPRESSED_R}<br>
	 * {@link #COMPRESSED_R_RGTC1}<br>
	 * {@link #COMPRESSED_R_SIGNED_RGTC1}<br>
	 * {@link #COMPRESSED_R11_EAC}<br>
	 * {@link #COMPRESSED_R11_SIGNED_EAC}<br>
	 * {@link #COMPRESSED_RG}<br>
	 * {@link #COMPRESSED_RG_RGTC2}<br>
	 * {@link #COMPRESSED_RG_SIGNED_RGTC2}<br>
	 * {@link #COMPRESSED_RG11_EAC}<br>
	 * {@link #COMPRESSED_RG11_SIGNED_EAC}<br>
	 * {@link #COMPRESSED_RGB}<br>
	 * {@link #COMPRESSED_RGB_BPTC_SIGNED_FLOAT}<br>
	 * {@link #COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT}<br>
	 * {@link #COMPRESSED_RGB8_ETC2}<br>
	 * {@link #COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2}<br>
	 * {@link #COMPRESSED_RGBA}<br>
	 * {@link #COMPRESSED_RGBA_BPTC_UNORM}<br>
	 * {@link #COMPRESSED_RGBA8_ETC2_EAC}<br>
	 * {@link #COMPRESSED_SRGB}<br>
	 * {@link #COMPRESSED_SRGB8_ETC2}<br>
	 * {@link #COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2}<br>
	 * {@link #COMPRESSED_SRGB_ALPHA}<br>
	 * {@link #COMPRESSED_SRGB_ALPHA_BPTC_UNORM}<br>
	 * {@link #COMPRESSED_SRGB8_ALPHA8_ETC2_EAC}
	 */
	public static enum Format {
		R(GL11.GL_RED),
		RG(GL30.GL_RG),
		RGB(GL11.GL_RGB),
		RGBA(GL11.GL_RGBA),
		R8(GL30.GL_R8),
		R8_SNORM(GL31.GL_R8_SNORM),
		R8I(GL30.GL_R8I),
		R8UI(GL30.GL_R8UI),
		R16(GL30.GL_R16),
		R16_SNORM(GL31.GL_R16_SNORM),
		R16F(GL30.GL_R16F),
		R16I(GL30.GL_R16I),
		R16UI(GL30.GL_R16UI),
		R32F(GL30.GL_R32F),
		R32I(GL30.GL_R32I),
		R32UI(GL30.GL_R32UI),
		RG8(GL30.GL_RG8),
		RG8_SNORM(GL31.GL_RG8_SNORM),
		RG8I(GL30.GL_RG8I),
		RG8UI(GL30.GL_RG8UI),
		RG16(GL30.GL_RG16),
		RG16_SNORM(GL31.GL_RG8_SNORM),
		RG16F(GL30.GL_RG16F),
		RG16I(GL30.GL_RG16I),
		RG16UI(GL30.GL_RG16UI),
		RG32F(GL30.GL_RG32F),
		RG32I(GL30.GL_RG32I),
		RG32UI(GL30.GL_RG32UI),
		RGB4(GL11.GL_RGB4),
		RGB5(GL11.GL_RGB5),
		RGB8(GL11.GL_RGB8),
		RGB8_SNORM(GL31.GL_RGB8_SNORM),
		RGB8I(GL30.GL_RGB8I),
		RGB8UI(GL30.GL_RGB8UI),
		RGB10(GL11.GL_RGB10),
		RGB12(GL11.GL_RGB12),
		RGB16(GL11.GL_RGB16),
		RGB16_SNORM(GL31.GL_RGB16_SNORM),
		RGB16F(GL30.GL_RGB16F),
		RGB16I(GL30.GL_RGB16I),
		RGB16UI(GL30.GL_RGB16UI),
		RGB32F(GL30.GL_RGB32F),
		RGB32I(GL30.GL_RGB32I),
		RGB32UI(GL30.GL_RGB32UI),
		RGB565(GL41.GL_RGB565),
		R3_G3_B2(GL11.GL_R3_G3_B2),
		R11F_G11F_B10F(GL30.GL_R11F_G11F_B10F),
		RGBA2(GL11.GL_RGBA2),
		RGBA4(GL11.GL_RGBA4),
		RGBA8(GL11.GL_RGBA8),
		RGBA8_SNORM(GL31.GL_RGBA8_SNORM),
		RGBA8I(GL30.GL_RGBA8I),
		RGBA8UI(GL30.GL_RGBA8UI),
		RGBA12(GL11.GL_RGBA12),
		RGBA16(GL11.GL_RGBA16),
		RGBA16_SNORM(GL31.GL_RGBA16_SNORM),
		RGBA16F(GL30.GL_RGBA16F),
		RGBA16I(GL30.GL_RGBA16I),
		RGBA16UI(GL30.GL_RGBA16UI),
		RGBA32F(GL30.GL_RGBA32F),
		RGBA32I(GL30.GL_RGBA32I),
		RGBA32UI(GL30.GL_RGBA32UI),
		RGB5_A1(GL11.GL_RGB5_A1),
		RGB10_A2(GL11.GL_RGB10_A2),
		RGB10_A2UI(GL33.GL_RGB10_A2UI),
		RGB9_E5(GL30.GL_RGB9_E5),
		SRGB8(GL21.GL_SRGB8),
		SRGB8_APLHA8(GL21.GL_SRGB8_ALPHA8),
		DEPTH_COMPONENT(GL11.GL_DEPTH_COMPONENT),
		DEPTH_COMPONENT16(GL14.GL_DEPTH_COMPONENT16),
		DEPTH_COMPONENT24(GL14.GL_DEPTH_COMPONENT24),
		DEPTH_COMPONENT32(GL14.GL_DEPTH_COMPONENT32),
		DEPTH_COMPONENT32F(GL30.GL_DEPTH_COMPONENT32F),
		DEPTH24_STENCIL8(GL30.GL_DEPTH24_STENCIL8),
		DEPTH32F_STENCIL8(GL30.GL_DEPTH32F_STENCIL8),
		DEPTH_STENCIL(GL30.GL_DEPTH_STENCIL),
		COMPRESSED_R(GL30.GL_COMPRESSED_RED),
		COMPRESSED_R_RGTC1(GL30.GL_COMPRESSED_RED_RGTC1),
		COMPRESSED_R_SIGNED_RGTC1(GL30.GL_COMPRESSED_SIGNED_RED_RGTC1),
		COMPRESSED_R11_EAC(GL43.GL_COMPRESSED_R11_EAC),
		COMPRESSED_R11_SIGNED_EAC(GL43.GL_COMPRESSED_SIGNED_R11_EAC),
		COMPRESSED_RG(GL30.GL_COMPRESSED_RG),
		COMPRESSED_RG_RGTC2(GL30.GL_COMPRESSED_RG_RGTC2),
		COMPRESSED_RG_SIGNED_RGTC2(GL30.GL_COMPRESSED_SIGNED_RG_RGTC2),
		COMPRESSED_RG11_EAC(GL43.GL_COMPRESSED_RG11_EAC),
		COMPRESSED_RG11_SIGNED_EAC(GL43.GL_COMPRESSED_SIGNED_RG11_EAC),
		COMPRESSED_RGB(GL13.GL_COMPRESSED_RGB),
		COMPRESSED_RGB_BPTC_SIGNED_FLOAT(GL42.GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT),
		COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT(GL42.GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT),
		COMPRESSED_RGB8_ETC2(GL43.GL_COMPRESSED_RGB8_ETC2),
		COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2(GL43.GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2),
		COMPRESSED_RGBA(GL13.GL_COMPRESSED_RGBA),
		COMPRESSED_RGBA_BPTC_UNORM(GL42.GL_COMPRESSED_RGBA_BPTC_UNORM),
		COMPRESSED_RGBA8_ETC2_EAC(GL43.GL_COMPRESSED_RGBA8_ETC2_EAC),
		COMPRESSED_SRGB(GL21.GL_COMPRESSED_SRGB),
		COMPRESSED_SRGB8_ETC2(GL43.GL_COMPRESSED_SRGB8_ETC2),
		COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2(GL43.GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2),
		COMPRESSED_SRGB_ALPHA(GL21.GL_COMPRESSED_SRGB_ALPHA),
		COMPRESSED_SRGB_ALPHA_BPTC_UNORM(GL42.GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM),
		COMPRESSED_SRGB8_ALPHA8_ETC2_EAC(GL43.GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC);
		
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
