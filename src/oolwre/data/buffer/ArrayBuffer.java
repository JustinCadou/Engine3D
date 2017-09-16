package oolwre.data.buffer;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.GL20;

import oolwre.render.RenderManager.ValueType;

/**The <code>ArrayBuffer</code> class represents a
 * {@link VertexBufferObject} of {@link BufferType}
 * {@link VertexBufferObject.BufferType#ARRAY ARRAY}.
 */
public class ArrayBuffer extends VertexBufferObject {
	
	/**Constructs a new {@link VertexBufferObject} of type
	 * {@link VertexBufferObject.BufferType#ARRAY ARRAY}.
	 */
	public ArrayBuffer() {
		super(VertexBufferObject.BufferType.ARRAY);
	}
	
	/**Specifies the location and organization of this {@link ArrayBuffer}.<br><br>
	 * <b>See</b> {@link GL20#glVertexAttribPointer(int, int, int, boolean, int, ByteBuffer)
	 * glVertexAttribPointer()}
	 * 
	 * @param index - The index of the generic vertex attribute to be modified
	 * @param size - The number of values per vertex of this {@link ArrayBuffer}
	 * @param type - The {@link ValueType} of each component of this {@link ArrayBuffer}
	 * @param normalized whether fixed-point data values should be normalized or
	 * converted directly as fixed-point values when they are accessed
	 * @param stride - The byte offset between consecutive generic vertex attributes
	 * @param pointer - The vertex attribute data or the offset of the first component
	 * of the first generic vertex attribute in the data store of the {@link ArrayBuffer}
	 */
	public void vertexAttribPointer(int index, int size, ValueType type, boolean normalized, int stride, ByteBuffer pointer) {
		GL20.glVertexAttribPointer(index, size, type.glValue(), normalized, stride, pointer);
	}
	
	/**Specifies the location and organization of this {@link ArrayBuffer}.<br><br>
	 * <b>See</b> {@link GL20#glVertexAttribPointer(int, int, int, boolean, int, ShortBuffer)
	 * glVertexAttribPointer()}
	 * 
	 * @param index - The index of the generic vertex attribute to be modified
	 * @param size - The number of values per vertex of this {@link ArrayBuffer}
	 * @param type - The {@link ValueType} of each component of this {@link ArrayBuffer}
	 * @param normalized whether fixed-point data values should be normalized or
	 * converted directly as fixed-point values when they are accessed
	 * @param stride - The byte offset between consecutive generic vertex attributes
	 * @param pointer - The vertex attribute data or the offset of the first component
	 * of the first generic vertex attribute in the data store of the {@link ArrayBuffer}
	 */
	public void vertexAttribPointer(int index, int size, ValueType type, boolean normalized, int stride, ShortBuffer pointer) {
		GL20.glVertexAttribPointer(index, size, type.glValue(), normalized, stride, pointer);
	}
	
	/**Specifies the location and organization of this {@link ArrayBuffer}.<br><br>
	 * <b>See</b> {@link GL20#glVertexAttribPointer(int, int, int, boolean, int, IntBuffer)
	 * glVertexAttribPointer()}
	 * 
	 * @param index - The index of the generic vertex attribute to be modified
	 * @param size - The number of values per vertex of this {@link ArrayBuffer}
	 * @param type - The {@link ValueType} of each component of this {@link ArrayBuffer}
	 * @param normalized whether fixed-point data values should be normalized or
	 * converted directly as fixed-point values when they are accessed
	 * @param stride - The byte offset between consecutive generic vertex attributes
	 * @param pointer - The vertex attribute data or the offset of the first component
	 * of the first generic vertex attribute in the data store of the {@link ArrayBuffer}
	 */
	public void vertexAttribPointer(int index, int size, ValueType type, boolean normalized, int stride, IntBuffer pointer) {
		GL20.glVertexAttribPointer(index, size, type.glValue(), normalized, stride, pointer);
	}
	
	/**Specifies the location and organization of this {@link ArrayBuffer}.<br><br>
	 * <b>See</b> {@link GL20#glVertexAttribPointer(int, int, int, boolean, int, FloatBuffer)
	 * glVertexAttribPointer()}
	 * 
	 * @param index - The index of the generic vertex attribute to be modified
	 * @param size - The number of values per vertex of this {@link ArrayBuffer}
	 * @param type - The {@link ValueType} of each component of this {@link ArrayBuffer}
	 * @param normalized whether fixed-point data values should be normalized or
	 * converted directly as fixed-point values when they are accessed
	 * @param stride - The byte offset between consecutive generic vertex attributes
	 * @param pointer - The vertex attribute data or the offset of the first component
	 * of the first generic vertex attribute in the data store of the {@link ArrayBuffer}
	 */
	public void vertexAttribPointer(int index, int size, ValueType type, boolean normalized, int stride, FloatBuffer pointer) {
		GL20.glVertexAttribPointer(index, size, type.glValue(), normalized, stride, pointer);
	}
	
	/**Specifies the location and organization of this {@link ArrayBuffer}.<br><br>
	 * <b>See</b> {@link GL20#glVertexAttribPointer(int, int, int, boolean, int, long)
	 * glVertexAttribPointer()}
	 * 
	 * @param index - The index of the generic vertex attribute to be modified
	 * @param size - The number of values per vertex of this {@link ArrayBuffer}
	 * @param type - The {@link ValueType} of each component of this {@link ArrayBuffer}
	 * @param normalized whether fixed-point data values should be normalized or
	 * converted directly as fixed-point values when they are accessed
	 * @param stride - The byte offset between consecutive generic vertex attributes
	 * @param pointer - The vertex attribute data or the offset of the first component
	 * of the first generic vertex attribute in the data store of the {@link ArrayBuffer}
	 */
	public void vertexAttribPointer(int index, int size, ValueType type, boolean normalized, int stride, long pointer) {
		GL20.glVertexAttribPointer(index, size, type.glValue(), normalized, stride, pointer);
	}
}
