package oolwre.data;

import org.lwjgl.opengl.GL30;

/**The <code>VertexArrayObject</code> class represents an OpenGL Vertex Array.<br><br>
 * <a href="https://www.khronos.org/opengl/wiki/Vertex_Specification#Vertex_Array_Object">
 * Reference Page</a>
 */
public class VertexArrayObject {
	
	private int name;
	
	/**Constructs a {@link VertexArrayObject}*/
	public VertexArrayObject() {
		this.name = GL30.glGenVertexArrays();
	}
	
	/**Returns the OpenGL name of this {@link VertexArrayObject}.
	 * 
	 * @return The name
	 */
	public int getName() {
		return this.name;
	}
	
	/**Binds this {@link VertexArrayObject}.<br><br>
	 * <b>See</b> {@link GL30#glBindVertexArray(int) glBindVertexArray()}
	 */
	public void bind() {
		GL30.glBindVertexArray(this.name);
	}
	
	/**Unbinds this {@link VertexArrayObject}.<br><br>
	 * <b>See</b> {@link GL30#glBindVertexArray(int) glBindVertexArray()}
	 */
	public void unbind() {
		GL30.glBindVertexArray(0);
	}
	
	/**Destroys this {@link VertexArrayObject}.<br><br>
	 * <b>See</b> {@link GL30#glDeleteVertexArrays(int) glDeleteVertexArrays()}
	 */
	public void destroy() {
		GL30.glDeleteVertexArrays(this.name);
		this.name = 0;
	}
}
