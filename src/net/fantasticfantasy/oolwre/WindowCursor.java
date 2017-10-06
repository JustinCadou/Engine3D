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
package net.fantasticfantasy.oolwre;

import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import net.fantasticfantasy.oolwre.image.Image;
import net.fantasticfantasy.oolwre.util.convert.ImageConverts;

/**The <code>Cursor</code> class represents the user
 * cursor. It is used to change its appearance
 * and position.
 */
public final class WindowCursor {
	
	protected Window owner;
	protected long name;
	protected Image image;
	private int xhot, yhot;
	
	/**Constructor*/
	protected WindowCursor(Window owner) {
		this.owner = owner;
		this.name = GLFW.glfwCreateStandardCursor(GLFW.GLFW_ARROW_CURSOR);
		GLFW.glfwSetCursor(this.owner.name, this.name);
	}
	
	/**Sets the <code>x</code> coordinate of the
	 * {@link WindowCursor} position.
	 * 
	 * @param x - The <code>x</code> coord
	 */
	public void setX(int x) {
		this.setPosition(x, this.getY());
	}

	/**Sets the <code>y</code> coordinate of the
	 * {@link WindowCursor} position.
	 * 
	 * @param y - The <code>y</code> coord
	 */
	public void setY(int y) {
		this.setPosition(this.getX(), y);
	}
	
	/**Sets the {@link WindowCursor} position to the specified
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
	
	/**Creates a new {@link WindowCursor} appearance with the specified parameters.
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
	
	/**Sets the appearance of the {@link WindowCursor} using
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
	
	/**Sets the {@link WindowCursor}'s hotspot.<br>
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

	/**Sets the {@link WindowCursor}'s hotspot.<br>
	 * <b>See</b> {@link GLFW#glfwCreateCursor(org.lwjgl.glfw.GLFWImage,
	 * int, int) glfwCreateCursor()}
	 * 
	 * @param x - The hotspot's <code>x</code> coord
	 */
	public void setHotspotX(int x) {
		this.xhot = x;
		this.updateCursor();
	}
	
	/**Sets the {@link WindowCursor}'s hotspot.<br>
	 * <b>See</b> {@link GLFW#glfwCreateCursor(org.lwjgl.glfw.GLFWImage,
	 * int, int) glfwCreateCursor()}
	 * 
	 * @param y - The hotspot's <code>y</code> coord
	 */
	public void setHotspotY(int y) {
		this.yhot = y;
		this.updateCursor();
	}
	
	/**Sets the {@link WindowCursor} input {@link Mode} of the owner {@link Window}.
	 * 
	 * @param mode - The cursor {@link Mode}
	 */
	public void setInputMode(Mode mode) {
		GLFW.glfwSetInputMode(this.owner.name, GLFW.GLFW_CURSOR, mode.value);
	}
	
	/**Queries the current position of the {@link WindowCursor}.
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

	/**Queries the current position of the {@link WindowCursor}.
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
	
	/**Returns the appearance of the {@link WindowCursor}.
	 * 
	 * @return The cursor's {@link Image}.
	 */
	public Image getImage() {
		return this.image;
	}
	
	/**Queries the hotspot of the {@link WindowCursor}.
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

	/**Queries the hotspot of the {@link WindowCursor}.
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
	
	/**Returns the <code>x</code> coord of the {@link WindowCursor}'s
	 * hotspot.
	 * 
	 * @return The hotspot's <code>x</code> coord
	 */
	public int getHotspotX() {
		return this.xhot;
	}
	
	/**Returns the <code>y</code> coord of the {@link WindowCursor}'s
	 * hotspot.
	 * 
	 * @return The hotspot's <code>y</code> coord
	 */
	public int getHotspotY() {
		return this.yhot;
	}
	
	/**Returns the current {@link WindowCursor} input {@link Mode}
	 * of the owner {@link Window}.
	 * 
	 * @return The cursor {@link Mode}
	 */
	public Mode getInputMode() {
		return Mode.forValue(GLFW.glfwGetInputMode(this.owner.name, GLFW.GLFW_CURSOR));
	}
	
	private void updateCursor() {
		GLFW.glfwDestroyCursor(this.name);
		GLFWImage gimg = ImageConverts.toGLFWImage(this.image);
		this.name = GLFW.glfwCreateCursor(gimg, this.xhot, this.yhot);
		GLFW.glfwSetCursor(this.owner.name, this.name);
	}
	
	/**The cursor input mode<br><br>
	 * {@link #NORMAL}<br>
	 * {@link #HIDDEN}<br>
	 * {@link #DISABLED}
	 */
	public static enum Mode {
		
		/**Represents {@link GLFW#GLFW_CURSOR_NORMAL GLFW_CURSOR_NORMAL}*/
		NORMAL(GLFW.GLFW_CURSOR_NORMAL),
		
		/**Represents {@link GLFW#GLFW_CURSOR_HIDDEN GLFW_CURSOR_HIDDEN}*/
		HIDDEN(GLFW.GLFW_CURSOR_HIDDEN),
		
		/**Represents {@link GLFW#GLFW_CURSOR_DISABLED GLFW_CURSOR_DISABLED}*/
		DISABLED(GLFW.GLFW_CURSOR_DISABLED);
		
		private int value;
		
		Mode(int value) {
			this.value = value;
		}
		
		/**Returns the {@link GLFW} value of this <code>enum</code>.
		 * 
		 * @return - The value
		 */
		public int getValue() {
			return this.value;
		}
		
		public static Mode forValue(int value) {
			for (Mode mode : values()) {
				if (mode.value == value) {
					return mode;
				}
			}
			return null;
		}
	}
}
