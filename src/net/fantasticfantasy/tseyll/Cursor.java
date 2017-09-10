package net.fantasticfantasy.tseyll;

import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import net.fantasticfantasy.tseyll.image.Image;
import net.fantasticfantasy.tseyll.util.convert.ImageConverts;

/**The <code>Cursor</code> class represents the user
 * cursor. It is used to change its appearance
 * and position.
 */
public final class Cursor {
	
	protected Window owner;
	protected long name;
	protected Image image;
	private int xhot, yhot;
	
	/**Constructor*/
	protected Cursor(Window owner) {
		this.owner = owner;
		this.name = GLFW.glfwCreateStandardCursor(GLFW.GLFW_ARROW_CURSOR);
		GLFW.glfwSetCursor(this.owner.name, this.name);
	}
	
	/**Sets the <code>x</code> coordinate of the
	 * {@link Cursor} position.
	 * 
	 * @param x - The <code>x</code> coord
	 */
	public void setX(int x) {
		this.setPosition(x, this.getY());
	}

	/**Sets the <code>y</code> coordinate of the
	 * {@link Cursor} position.
	 * 
	 * @param y - The <code>y</code> coord
	 */
	public void setY(int y) {
		this.setPosition(this.getX(), y);
	}
	
	/**Sets the {@link Cursor} position to the specified
	 * location.<br>
	 * <b>See</b> {@link GLFW#glfwSetCursorPos(long, double, double)
	 * glfwSetCursorPos()}
	 * 
	 * @param x - The <code>x</code> coord
	 * @param y - The <code>y</code> coord
	 */
	public void setPosition(int x, int y) {
		GLFW.glfwSetCursorPos(this.owner.name, x, y);
	}
	
	/**Creates a new {@link Cursor} appearance with the specified parameters.
	 * 
	 * @param image - The new image
	 * @param xhot - The hotspot's <code>x</code> coord
	 * @param yhot - The hotspot's <code>y</code> coord
	 */
	public void setCursorAppearance(Image image, int xhot, int yhot) {
		this.image = image;
		this.xhot = xhot;
		this.yhot = yhot;
		this.updateCursor();
	}
	
	/**Sets the appearance of the {@link Cursor} using
	 * an {@link Image}.<br><br>
	 * <b>Note:</b> This will only work when the cursor
	 * is hover the {@link Window}!<br><br>
	 * <b>See</b> {@link GLFW#glfwCreateCursor(org.lwjgl.glfw.GLFWImage,
	 * int, int) glfwCreateCursor()}
	 * 
	 * @param image - The new image
	 */
	public void setImage(Image image) {
		this.image = image;
		this.updateCursor();
	}
	
	/**Sets the {@link Cursor}'s hotspot.<br>
	 * <b>See</b> {@link GLFW#glfwCreateCursor(org.lwjgl.glfw.GLFWImage,
	 * int, int) glfwCreateCursor()}
	 * 
	 * @param x - The hotspot's <code>x</code> coord
	 * @param y - The hotspot's <code>y</code> coord
	 */
	public void setHotspot(int x, int y) {
		this.xhot = x;
		this.yhot = y;
		this.updateCursor();
	}

	/**Sets the {@link Cursor}'s hotspot.<br>
	 * <b>See</b> {@link GLFW#glfwCreateCursor(org.lwjgl.glfw.GLFWImage,
	 * int, int) glfwCreateCursor()}
	 * 
	 * @param x - The hotspot's <code>x</code> coord
	 */
	public void setHotspotX(int x) {
		this.xhot = x;
		this.updateCursor();
	}
	
	/**Sets the {@link Cursor}'s hotspot.<br>
	 * <b>See</b> {@link GLFW#glfwCreateCursor(org.lwjgl.glfw.GLFWImage,
	 * int, int) glfwCreateCursor()}
	 * 
	 * @param y - The hotspot's <code>y</code> coord
	 */
	public void setHotspotY(int y) {
		this.yhot = y;
		this.updateCursor();
	}
	
	/**Queries the current position of the {@link Cursor}.
	 * 
	 * @param x - Where to store <code>x</code>, or
	 * <code>null</code> to ignore
	 * @param y - Where to store <code>y</code>, or
	 * <code>null</code> to ignore
	 */
	public void queryPosition(IntBuffer x, IntBuffer y) {
		double[] qx = new double[1], qy = new double[1];
		GLFW.glfwGetCursorPos(this.owner.name, qx, qy);
		if (x != null) {
			x.put((int) qx[0]);
		}
		if (y != null) {
			y.put((int) qy[0]);
		}
	}

	/**Queries the current position of the {@link Cursor}.
	 * 
	 * @param x - Where to store <code>x</code>, or
	 * <code>null</code> to ignore
	 * @param y - Where to store <code>y</code>, or
	 * <code>null</code> to ignore
	 */
	public void queryPosition(int[] x, int[] y) {
		double[] qx = new double[1], qy = new double[1];
		GLFW.glfwGetCursorPos(this.owner.name, qx, qy);
		if (x != null) {
			x[0] = (int) qx[0];
		}
		if (y != null) {
			y[0] = (int) qy[0];
		}
	}
	
	/**Queries <code>x</code> and returns it.
	 * 
	 * @return x
	 */
	public int getX() {
		int[] x = new int[1];
		this.queryPosition(x, null);
		return x[0];
	}
	
	/**Queries <code>y</code> and returns it.
	 * 
	 * @return y
	 */
	public int getY() {
		int[] y = new int[1];
		this.queryPosition(null, y);
		return y[0];
	}
	
	/**Returns the appearance of the {@link Cursor}.
	 * 
	 * @return The cursor's {@link Image}.
	 */
	public Image getImage() {
		return this.image;
	}
	
	/**Queries the hotspot of the {@link Cursor}.
	 * 
	 * @param x - Where to store <code>xhot</code>, or
	 * <code>null</code> to ignore
	 * @param y - Where to store <code>yhot</code>, or
	 * <code>null</code> to ignore
	 */
	public void queryHotspot(IntBuffer x, IntBuffer y) {
		if (x != null) {
			x.put(this.xhot);
		}
		if (y != null) {
			y.put(this.yhot);
		}
	}

	/**Queries the hotspot of the {@link Cursor}.
	 * 
	 * @param x - Where to store <code>xhot</code>, or
	 * <code>null</code> to ignore
	 * @param y - Where to store <code>yhot</code>, or
	 * <code>null</code> to ignore
	 */
	public void queryHotspot(int[] x, int[] y) {
		if (x != null) {
			x[0] = this.xhot;
		}
		if (y != null) {
			y[0] = this.yhot;
		}
	}
	
	/**Returns the <code>x</code> coord of the {@link Cursor}'s
	 * hotspot.
	 * 
	 * @return The hotspot's <code>x</code> coord
	 */
	public int getHotspotX() {
		return this.xhot;
	}
	
	/**Returns the <code>y</code> coord of the {@link Cursor}'s
	 * hotspot.
	 * 
	 * @return The hotspot's <code>y</code> coord
	 */
	public int getHotspotY() {
		return this.yhot;
	}
	
	private void updateCursor() {
		GLFW.glfwDestroyCursor(this.name);
		GLFWImage gimg = ImageConverts.toGLFWImage(this.image);
		this.name = GLFW.glfwCreateCursor(gimg, this.xhot, this.yhot);
		GLFW.glfwSetCursor(this.owner.name, this.name);
	}
}
