package oolwre.data.buffer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.ARBIndirectParameters;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL42;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GL44;

/**The <code>VertexBufferObject</code> class represents an OpenGL Buffer.<br>
 * <br>
 * <a href="https://www.khronos.org/opengl/wiki/Buffer_Object">
 * Reference Page</a>
 */
public class VertexBufferObject {
	
	private static final int BUFFER_USAGE_BASE = 35040;
	
	protected int name;
	protected BufferType type;
	
	/**Constructs a {@link VertexBufferObject} of the specified
	 * {@link BufferType}.
	 * 
	 * @param type - The {@link BufferType}
	 */
	public VertexBufferObject(BufferType type) {
		this.name = GL15.glGenBuffers();
		this.type = type;
	}
	
	/**Returns the OpenGL name of this {@link VertexBufferObject}.
	 * 
	 * @return The name
	 */
	public final int getName() {
		return this.name;
	}
	
	/**Creates and initialize this {@link VertexBufferObject}'s data store.<br>
	 * <b>NOTE</b>: Always remember to {@link #bind() bind} this buffer 
	 * <i>before</i> invoking any method that targets it.<br><br>
	 * <b>See</b> {@link GL15#glBufferData(int, ByteBuffer, int) glBufferData()}
	 * 
	 * @param data - The data that will be copied into the data store for
	 * initialization, or <code>null</code> if no data is to be copied
	 * @param accessFrequency - The {@link BufferAccessFrequency}
	 * @param accessNature - The {@link BufferAccessNature}
	 * 
	 * @throws NullPointerException If <code>accessFrequency</code> or
	 * <code>accessNature</code> is <code>null</code>
	 */
	public void bufferData(ByteBuffer data, BufferAccessFrequency accessFrequency, BufferAccessNature accessNature) {
		GL15.glBufferData(this.type.value, data, glBufferUsageValue(accessFrequency, accessNature));
	}
	
	/**Creates and initialize this {@link VertexBufferObject}'s data store.<br>
	 * <b>NOTE</b>: Always remember to {@link #bind() bind} this buffer 
	 * <i>before</i> invoking any method that targets it.<br><br>
	 * <b>See</b> {@link GL15#glBufferData(int, ShortBuffer, int) glBufferData()}
	 * 
	 * @param data - The data that will be copied into the data store for
	 * initialization, or <code>null</code> if no data is to be copied
	 * @param accessFrequency - The {@link BufferAccessFrequency}
	 * @param accessNature - The {@link BufferAccessNature}
	 * 
	 * @throws NullPointerException If <code>accessFrequency</code> or
	 * <code>accessNature</code> is <code>null</code>
	 */
	public void bufferData(ShortBuffer data, BufferAccessFrequency accessFrequency, BufferAccessNature accessNature) {
		GL15.glBufferData(this.type.value, data, glBufferUsageValue(accessFrequency, accessNature));
	}
	
	/**Creates and initialize this {@link VertexBufferObject}'s data store.<br>
	 * <b>NOTE</b>: Always remember to {@link #bind() bind} this buffer 
	 * <i>before</i> invoking any method that targets it.<br><br>
	 * <b>See</b> {@link GL15#glBufferData(int, IntBuffer, int) glBufferData()}
	 * 
	 * @param data - The data that will be copied into the data store for
	 * initialization, or <code>null</code> if no data is to be copied
	 * @param accessFrequency - The {@link BufferAccessFrequency}
	 * @param accessNature - The {@link BufferAccessNature}
	 * 
	 * @throws NullPointerException If <code>accessFrequency</code> or
	 * <code>accessNature</code> is <code>null</code>
	 */
	public void bufferData(IntBuffer data, BufferAccessFrequency accessFrequency, BufferAccessNature accessNature) {
		GL15.glBufferData(this.type.value, data, glBufferUsageValue(accessFrequency, accessNature));
	}
	
	/**Creates and initialize this {@link VertexBufferObject}'s data store.<br>
	 * <b>NOTE</b>: Always remember to {@link #bind() bind} this buffer 
	 * <i>before</i> invoking any method that targets it.<br><br>
	 * <b>See</b> {@link GL15#glBufferData(int, FloatBuffer, int) glBufferData()}
	 * 
	 * @param data - The data that will be copied into the data store for
	 * initialization, or <code>null</code> if no data is to be copied
	 * @param accessFrequency - The {@link BufferAccessFrequency}
	 * @param accessNature - The {@link BufferAccessNature}
	 * 
	 * @throws NullPointerException If <code>accessFrequency</code> or
	 * <code>accessNature</code> is <code>null</code>
	 */
	public void bufferData(FloatBuffer data, BufferAccessFrequency accessFrequency, BufferAccessNature accessNature) {
		GL15.glBufferData(this.type.value, data, glBufferUsageValue(accessFrequency, accessNature));
	}
	
	/**Creates and initialize this {@link VertexBufferObject}'s data store.<br>
	 * <b>NOTE</b>: Always remember to {@link #bind() bind} this buffer 
	 * <i>before</i> invoking any method that targets it.<br><br>
	 * <b>See</b> {@link GL15#glBufferData(int, DoubleBuffer, int) glBufferData()}
	 * 
	 * @param data - The data that will be copied into the data store for
	 * initialization, or <code>null</code> if no data is to be copied
	 * @param accessFrequency - The {@link BufferAccessFrequency}
	 * @param accessNature - The {@link BufferAccessNature}
	 * 
	 * @throws NullPointerException If <code>accessFrequency</code> or
	 * <code>accessNature</code> is <code>null</code>
	 */
	public void bufferData(DoubleBuffer data, BufferAccessFrequency accessFrequency, BufferAccessNature accessNature) {
		GL15.glBufferData(this.type.value, data, glBufferUsageValue(accessFrequency, accessNature));
	}
	
	/**Creates the data store of this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL44#glBufferStorage(int, ByteBuffer, int)
	 * glBufferStorage()}
	 * 
	 * @param data - The data that should be used to initialize the
	 * {@link VertexBufferObject}'s data store, or <code>null</code>
	 * @param flags - Describes the intended usage of the {@link VertexBufferObject}'s
	 * data store
	 */
	public void bufferStorage(ByteBuffer data, BufferStorageFlag... flags) {
		int flgs = 0;
		for (BufferStorageFlag flag : flags) {
			flgs = flgs | flag.value;
		}
		GL44.glBufferStorage(this.type.value, data, flgs);
	}
	
	/**Creates the data store of this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL44#glBufferStorage(int, ShortBuffer, int)
	 * glBufferStorage()}
	 * 
	 * @param data - The data that should be used to initialize the
	 * {@link VertexBufferObject}'s data store, or <code>null</code>
	 * @param flags - Describes the intended usage of the {@link VertexBufferObject}'s
	 * data store
	 */
	public void bufferStorage(ShortBuffer data, BufferStorageFlag... flags) {
		int flgs = 0;
		for (BufferStorageFlag flag : flags) {
			flgs = flgs | flag.value;
		}
		GL44.glBufferStorage(this.type.value, data, flgs);
	}
	
	/**Creates the data store of this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL44#glBufferStorage(int, IntBuffer, int)
	 * glBufferStorage()}
	 * 
	 * @param data - The data that should be used to initialize the
	 * {@link VertexBufferObject}'s data store, or <code>null</code>
	 * @param flags - Describes the intended usage of the {@link VertexBufferObject}'s
	 * data store
	 */
	public void bufferStorage(IntBuffer data, BufferStorageFlag... flags) {
		int flgs = 0;
		for (BufferStorageFlag flag : flags) {
			flgs = flgs | flag.value;
		}
		GL44.glBufferStorage(this.type.value, data, flgs);
	}
	
	/**Creates the data store of this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL44#glBufferStorage(int, FloatBuffer, int)
	 * glBufferStorage()}
	 * 
	 * @param data - The data that should be used to initialize the
	 * {@link VertexBufferObject}'s data store, or <code>null</code>
	 * @param flags - Describes the intended usage of the {@link VertexBufferObject}'s
	 * data store
	 */
	public void bufferStorage(FloatBuffer data, BufferStorageFlag... flags) {
		int flgs = 0;
		for (BufferStorageFlag flag : flags) {
			flgs = flgs | flag.value;
		}
		GL44.glBufferStorage(this.type.value, data, flgs);
	}
	
	/**Creates the data store of this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL44#glBufferStorage(int, DoubleBuffer, int)
	 * glBufferStorage()}
	 * 
	 * @param data - The data that should be used to initialize the
	 * {@link VertexBufferObject}'s data store, or <code>null</code>
	 * @param flags - Describes the intended usage of the {@link VertexBufferObject}'s
	 * data store
	 */
	public void bufferStorage(DoubleBuffer data, BufferStorageFlag... flags) {
		int flgs = 0;
		for (BufferStorageFlag flag : flags) {
			flgs = flgs | flag.value;
		}
		GL44.glBufferStorage(this.type.value, data, flgs);
	}
	
	/**Creates the data store of this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL44#glBufferStorage(int, DoubleBuffer, int)
	 * glBufferStorage()}
	 * 
	 * @param size - The size of the data to store in machine unit
	 * @param flags - Describes the intended usage of the {@link VertexBufferObject}'s
	 * data store
	 */
	public void bufferStorage(long size, BufferStorageFlag... flags) {
		int flgs = 0;
		for (BufferStorageFlag flag : flags) {
			flgs = flgs | flag.value;
		}
		GL44.glBufferStorage(this.type.value, size, flgs);
	}
	
	/**Updates a subset of this {@link VertexBufferObject} data store.<br><br>
	 * <b>See</b> {@link GL15#glBufferSubData(int, long, ByteBuffer)
	 * glBufferSubData()}
	 * 
	 * @param data - The new data that will be copied into the data store
	 * @param off - The offset into the {@link VertexBufferObject}'s data store
	 * where data replacement will begin, measured in bytes
	 */
	public void bufferSubData(ByteBuffer data, long off) {
		GL15.glBufferSubData(this.type.value, off, data);
	}
	
	/**Updates a subset of this {@link VertexBufferObject} data store.<br><br>
	 * <b>See</b> {@link GL15#glBufferSubData(int, long, ShortBuffer)
	 * glBufferSubData()}
	 * 
	 * @param data - The new data that will be copied into the data store
	 * @param off - The offset into the {@link VertexBufferObject}'s data store
	 * where data replacement will begin, measured in bytes
	 */
	public void bufferSubData(ShortBuffer data, long off) {
		GL15.glBufferSubData(this.type.value, off, data);
	}
	
	/**Updates a subset of this {@link VertexBufferObject} data store.<br><br>
	 * <b>See</b> {@link GL15#glBufferSubData(int, long, IntBuffer)
	 * glBufferSubData()}
	 * 
	 * @param data - The new data that will be copied into the data store
	 * @param off - The offset into the {@link VertexBufferObject}'s data store
	 * where data replacement will begin, measured in bytes
	 */
	public void bufferSubData(IntBuffer data, long off) {
		GL15.glBufferSubData(this.type.value, off, data);
	}
	
	/**Updates a subset of this {@link VertexBufferObject} data store.<br><br>
	 * <b>See</b> {@link GL15#glBufferSubData(int, long, FloatBuffer)
	 * glBufferSubData()}
	 * 
	 * @param data - The new data that will be copied into the data store
	 * @param off - The offset into the {@link VertexBufferObject}'s data store
	 * where data replacement will begin, measured in bytes
	 */
	public void bufferSubData(FloatBuffer data, long off) {
		GL15.glBufferSubData(this.type.value, off, data);
	}
	
	/**Updates a subset of this {@link VertexBufferObject} data store.<br><br>
	 * <b>See</b> {@link GL15#glBufferSubData(int, long, DoubleBuffer)
	 * glBufferSubData()}
	 * 
	 * @param data - The new data that will be copied into the data store
	 * @param off - The offset into the {@link VertexBufferObject}'s data store
	 * where data replacement will begin, measured in bytes
	 */
	public void bufferSubData(DoubleBuffer data, long off) {
		GL15.glBufferSubData(this.type.value, off, data);
	}
	
	/**Queries a subset of a {@link VertexBufferObject}'s data store.<br><br>
	 * <b>See</b> {@link GL15#glGetBufferSubData(int, long, ByteBuffer)
	 * glGetBufferSubData()}
	 * 
	 * @param dest - The buffer where to store the data
	 * @param off - The offset into the {@link VertexBufferObject}'s data
	 * store from which data will be queried, measured in bytes
	 */
	public void getBufferSubData(ByteBuffer dest, long off) {
		GL15.glGetBufferSubData(this.type.value, off, dest);
	}
	
	/**Queries a subset of a {@link VertexBufferObject}'s data store.<br><br>
	 * <b>See</b> {@link GL15#glGetBufferSubData(int, long, ShortBuffer)
	 * glGetBufferSubData()}
	 * 
	 * @param dest - The buffer where to store the data
	 * @param off - The offset into the {@link VertexBufferObject}'s data
	 * store from which data will be queried, measured in bytes
	 */
	public void getBufferSubData(ShortBuffer dest, long off) {
		GL15.glGetBufferSubData(this.type.value, off, dest);
	}
	
	/**Queries a subset of a {@link VertexBufferObject}'s data store.<br><br>
	 * <b>See</b> {@link GL15#glGetBufferSubData(int, long, IntBuffer)
	 * glGetBufferSubData()}
	 * 
	 * @param dest - The buffer where to store the data
	 * @param off - The offset into the {@link VertexBufferObject}'s data
	 * store from which data will be queried, measured in bytes
	 */
	public void getBufferSubData(IntBuffer dest, long off) {
		GL15.glGetBufferSubData(this.type.value, off, dest);
	}
	
	/**Queries a subset of a {@link VertexBufferObject}'s data store.<br><br>
	 * <b>See</b> {@link GL15#glGetBufferSubData(int, long, FloatBuffer)
	 * glGetBufferSubData()}
	 * 
	 * @param dest - The buffer where to store the data
	 * @param off - The offset into the {@link VertexBufferObject}'s data
	 * store from which data will be queried, measured in bytes
	 */
	public void getBufferSubData(FloatBuffer dest, long off) {
		GL15.glGetBufferSubData(this.type.value, off, dest);
	}
	
	/**Queries a subset of a {@link VertexBufferObject}'s data store.<br><br>
	 * <b>See</b> {@link GL15#glGetBufferSubData(int, long, DoubleBuffer)
	 * glGetBufferSubData()}
	 * 
	 * @param dest - The buffer where to store the data
	 * @param off - The offset into the {@link VertexBufferObject}'s data
	 * store from which data will be queried, measured in bytes
	 */
	public void getBufferSubData(DoubleBuffer dest, long off) {
		GL15.glGetBufferSubData(this.type.value, off, dest);
	}
	
	/**Binds this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL15#glBindBuffer(int, int) glBindBuffer()}
	 */
	public void bind() {
		GL15.glBindBuffer(this.type.value, this.name);
	}
	
	/**Unbinds this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL15#glBindBuffer(int, int) glBindBuffer()}
	 */
	public void unbind() {
		GL15.glBindBuffer(this.type.value, 0);
	}
	
	/**Destroys this {@link VertexBufferObject}.<br><br>
	 * <b>See</b> {@link GL15#glDeleteBuffers(int) glDeleteBuffers()}
	 */
	public void destroy() {
		GL15.glDeleteBuffers(this.name);
		this.name = 0;
	}
	
	/**Returns the OpenGL Enum value associated with the specified parameters*/
	protected static int glBufferUsageValue(BufferAccessFrequency accessFrequency, BufferAccessNature accessNature) {
		return BUFFER_USAGE_BASE + accessFrequency.off + accessNature.off;
	}
	
	/**Buffer type<br><br>
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
	 * {@link #PARAMETER_ARB}
	 */
	public static enum BufferType {
		
		/**OpenGL 1.5 {@link GL15#GL_ARRAY_BUFFER GL_ARRAY_BUFFER}*/
		ARRAY(GL15.GL_ARRAY_BUFFER),
		
		/**OpenGL 1.5 {@link GL15#GL_ELEMENT_ARRAY_BUFFER GL_ELEMENT_ARRAY_BUFFER}*/
		ELEMENT_ARRAY(GL15.GL_ELEMENT_ARRAY_BUFFER),
		
		/**OpenGL 2.1 {@link GL21#GL_PIXEL_PACK_BUFFER GL_PIXEL_PACK_BUFFER}*/
		PIXEL_PACK(GL21.GL_PIXEL_PACK_BUFFER),
		
		/**OpenGL 2.1 {@link GL21#GL_PIXEL_UNPACK_BUFFER GL_PIXEL_UNPACK_BUFFER}*/
		PIXEL_UNPACK(GL21.GL_PIXEL_UNPACK_BUFFER),
		
		/**OpenGL 3.0 {@link GL30#GL_TRANSFORM_FEEDBACK_BUFFER GL_TRANSFORM_FEEDBACK_BUFFER}*/
		TRANSFORM_FEEDBACK(GL30.GL_TRANSFORM_FEEDBACK_BUFFER),
		
		/**OpenGL 3.1 {@link GL31#GL_UNIFORM_BUFFER GL_UNIFORM_BUFFER}*/
		UNIFORM(GL31.GL_UNIFORM_BUFFER),
		
		/**OpenGL 3.1 {@link GL31#GL_TEXTURE_BUFFER GL_TEXTURE_BUFFER}*/
		TEXTURE(GL31.GL_TEXTURE_BUFFER),
		
		/**OpenGL 3.1 {@link GL31#GL_COPY_READ_BUFFER GL_COPY_READ_BUFFER}*/
		COPY_READ(GL31.GL_COPY_READ_BUFFER),
		
		/**OpenGL 3.1 {@link GL31#GL_COPY_WRITE_BUFFER GL_COPY_WRITE_BUFFER}*/
		COPY_WRITE(GL31.GL_COPY_WRITE_BUFFER),
		
		/**OpenGL 4.0 {@link GL40#GL_DRAW_INDIRECT_BUFFER GL_DRAW_INDIRECT_BUFFER}*/
		DRAW_INDIRECT(GL40.GL_DRAW_INDIRECT_BUFFER),
		
		/**OpenGL 4.2 {@link GL42#GL_ATOMIC_COUNTER_BUFFER GL_ATOMIC_COUNTER_BUFFER}*/
		ATOMIC_COUNTER(GL42.GL_ATOMIC_COUNTER_BUFFER),
		
		/**OpenGL 4.3 {@link GL43#GL_DISPATCH_INDIRECT_BUFFER GL_DISPATCH_INDIRECT_BUFFER}*/
		DISPATCH_INDIRECT(GL43.GL_DISPATCH_INDIRECT_BUFFER),
		
		/**OpenGL 4.3 {@link GL43#GL_SHADER_STORAGE_BUFFER GL_SHADER_STORAGE_BUFFER}*/
		SHADER_STORAGE(GL43.GL_SHADER_STORAGE_BUFFER),
		
		/**ARB Indirect Parameters {@link ARBIndirectParameters#GL_PARAMETER_BUFFER_ARB GL_PARAMETER_BUFFER_ARB}*/
		PARAMETER_ARB(ARBIndirectParameters.GL_PARAMETER_BUFFER_ARB);
		
		private int value;
		
		BufferType(int value) {
			this.value = value;
		}
		
		/**Returns the {@link BufferType} associated with the specified Open GL value,
		 * or <code>null</code> if none match.
		 * 
		 * @param glValue - The Open GL value
		 * 
		 * @return The {@link BufferType} associated with <code>glValue</code>
		 */
		public static BufferType forGLValue(int glValue) {
			for (BufferType type : values()) {
				if (type.value == glValue) {
					return type;
				}
			}
			return null;
		}
	}
	
	/**Buffer access frequency<br><br>
	 * {@link #STREAM}<br>
	 * {@link #STATIC}<br>
	 * {@link #DYNAMIC}
	 */
	public static enum BufferAccessFrequency {
		STREAM(0),
		STATIC(4),
		DYNAMIC(8);
		
		private int off;
		
		BufferAccessFrequency(int off) {
			this.off = off;
		}
	}
	
	/**Buffer access nature<br><br>
	 * {@link #DRAW}<br>
	 * {@link #READ}<br>
	 * {@link #COPY}
	 */
	public static enum BufferAccessNature {
		DRAW(0),
		READ(1),
		COPY(2);
		
		private int off;
		
		BufferAccessNature(int off) {
			this.off = off;
		}
	}
	
	/**Buffer storage flags<br><br>
	 * {@link #DYNAMIC_STORAGE}<br>
	 * {@link #MAP_READ}<br>
	 * {@link #MAP_WRITE}<br>
	 * {@link #MAP_PERSISTENT}<br>
	 * {@link #MAP_COHERENT}<br>
	 * {@link #CLIENT_STORAGE}
	 */
	public static enum BufferStorageFlag {
		
		/**OpenGL 4.4 {@link GL44#GL_DYNAMIC_STORAGE_BIT GL_DYNAMIC_STORAGE_BIT}*/
		DYNAMIC_STORAGE(GL44.GL_DYNAMIC_STORAGE_BIT),
		
		/**OpenGL 3.0 {@link GL30#GL_MAP_READ_BIT GL_MAP_READ_BIT}*/
		MAP_READ(GL30.GL_MAP_READ_BIT),
		
		/**OpenGL 3.0 {@link GL30#GL_MAP_WRITE_BIT GL_MAP_WRITE_BIT}*/
		MAP_WRITE(GL30.GL_MAP_WRITE_BIT),
		
		/**OpenGL 4.4 {@link GL44#GL_MAP_PERSISTENT_BIT GL_MAP_PERSISTENT_BIT}*/
		MAP_PERSISTENT(GL44.GL_MAP_PERSISTENT_BIT),
		
		/**OpenGL 4.4 {@link GL44#GL_MAP_COHERENT_BIT GL_MAP_COHERENT_BIT}*/
		MAP_COHERENT(GL44.GL_MAP_COHERENT_BIT),
		
		/**OpenGL 4.4 {@link GL44#GL_CLIENT_STORAGE_BIT GL_CLIENT_STORAGE_BIT}*/
		CLIENT_STORAGE(GL44.GL_CLIENT_STORAGE_BIT);
		
		private int value;
		
		BufferStorageFlag(int value) {
			this.value = value;
		}
	}
}
