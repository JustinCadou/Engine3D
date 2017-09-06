package net.fantasticfantasy.tseyll;

import java.nio.ByteBuffer;
import org.lwjgl.glfw.GLFW;

public class Window {
	
	protected WindowHints hints;
	protected long name;
	
	private CharSequence title;
	private boolean fullscreen;
	private boolean visible;
	private int wwidth;
	private int wheight;
	private int width;
	private int height;
	private int x;
	private int y;
	
	/**Constructs a new {@link Window} with the specified
	 * {@link WindowHints} and {@link Monitor}.
	 * 
	 * @param hints - The hints to create the window and
	 * its context
	 * @param monitor - The monitor to be covered by the
	 * window, or {@link Monitor#NULL} for windowed mode
	 */
	public Window(WindowHints hints, Monitor monitor) {
		if (monitor.name != 0) {
			hints.setRequiredColorBits(monitor);
		}
		hints.makeActive();
		this.fullscreen = monitor.name != 0;
		this.wwidth = 640;
		this.wheight = 480;
		this.width = monitor.name == 0 ? this.wwidth : monitor.width;
		this.height = monitor.name == 0 ? this.wheight : monitor.height;
		this.name = GLFW.glfwCreateWindow(this.width, this.height, "Tseyll Window", monitor.name, 0);
		int[] qx = new int[1];
		int[] qy = new int[1];
		GLFW.glfwGetWindowPos(this.name, qx, qy);
		this.x = qx[0];
		this.y = qy[0];
		this.visible = hints.visible == WindowHints.Boolean.TRUE ? true : false;
		this.hints = hints;
	}
	
	/**Sets the title of the {@link Window}.
	 * 
	 * @param title - The new title
	 */
	public void setTitle(CharSequence title) {
		GLFW.glfwSetWindowTitle(this.name, title);
		this.title = title;
	}
	
	/**Sets the title of the {@link Window} using the bytes
	 * in <code>title</code>.
	 * 
	 * @param title - The new title
	 */
	public void setTitle(ByteBuffer title) {
		GLFW.glfwSetWindowTitle(this.name, title);
		byte[] chars = new byte[title.remaining()];
		title.get(chars);
		char[] cs = new char[chars.length];
		int i = 0;
		for (byte b : chars) {
			cs[i++] = (char) b;
		}
		this.title = new String(chars);
	}
	
	/**Sets whether or not the {@link Window} should be visible.
	 * 
	 * @param visible - The new visibility
	 */
	public void setVisible(boolean visible) {
		if (this.fullscreen) {
			return;
		}
		if (visible) {
			GLFW.glfwShowWindow(this.name);
		} else {
			GLFW.glfwHideWindow(this.name);
		}
		this.visible = visible;
	}
	
	/**Iconifies the {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwIconifyWindow(long) glfwIconifyWindow()}
	 */
	public void iconify() {
		GLFW.glfwIconifyWindow(this.name);
	}
	
	/**Maximizes the {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwMaximizeWindow(long) glfwMaximizeWindow()}
	 */
	public void maximize() {
		if (this.fullscreen) {
			return;
		}
		GLFW.glfwMaximizeWindow(this.name);
	}
	
	/**Restores the {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwRestoreWindow(long) glfwRestoreWindow()}
	 */
	public void restore() {
		GLFW.glfwRestoreWindow(this.name);
	}
	
	/**Sets the <code>x</code> coordinate of the {@link Window}.
	 * 
	 * @param x - The new <code>x</code> coordinate
	 */
	public void setX(int x) {
		this.x = x;
		this.updatePosAndSize();
	}
	
	/**Sets the <code>y</code> coordinate of the {@link Window}.
	 * 
	 * @param y - The new <code>y</code> coordinate
	 */
	public void setY(int y) {
		this.y = y;
		this.updatePosAndSize();
	}
	
	/**Sets the position of the {@link Window}.
	 * 
	 * @param x - The new <code>x</code> coordinate
	 * @param y - The new <code>y</code> coordinate
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		this.updatePosAndSize();
	}
	
	/**Sets the <code>width</code> of the {@link Window}
	 * 
	 * @param width - The new <code>width</code>
	 */
	public void setWidth(int width) {
		this.wwidth = width;
		this.updatePosAndSize();
	}

	/**Sets the <code>height</code> of the {@link Window}
	 * 
	 * @param width - The new <code>height</code>
	 */
	public void setHeight(int height) {
		this.wheight = height;
		this.updatePosAndSize();
	}
	
	/**Sets the size of the {@link Window}
	 * 
	 * @param width - The new <code>width</code>
	 * @param height - The new <code>height</code>
	 */
	public void setSize(int width, int height) {
		this.wwidth = width;
		this.wheight = height;
		this.updatePosAndSize();
	}
	
	/**Sets the position and size of the {@link Window}.
	 * 
	 * @param x - The new <code>x</code> coordinate
	 * @param y - The new <code>y</code> coordinate
	 * @param width - The new <code>width</code>
	 * @param height - The new <code>height</code>
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.wwidth = width;
		this.wheight = height;
		this.updatePosAndSize();
	}
	
	/**Sets the focus to this {@link Window} and brings it to the front.
	 * <br><br><b>DO NOT use this function to steal focus</b>, as this can be
	 * extremely disruptive!<br>This method should only be used if you are
	 * absolutely certain that this is what the user wants.<br>
	 * {@link #requestUserAttention()} should be used instead.<br><br>
	 * <b>See</b> {@link GLFW#glfwFocusWindow(long) glfwFocusWindow()}
	 * 
	 * @param focused
	 */
	public void setFocused(boolean focused) {
		GLFW.glfwFocusWindow(this.name);
	}
	
	/**Requests the user's attention on this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwRequestWindowAttention(long) glfwRequestWindowAttention()}
	 */
	public void requestUserAttention() {
		GLFW.glfwRequestWindowAttention(this.name);
	}
	
	/**Sets the should close status of the {@link Window} to <code>b</code>.
	 * 
	 * @param b - The new should close status
	 */
	public void setShouldClose(boolean b) {
		GLFW.glfwSetWindowShouldClose(this.name, b);
	}
	
	/**Sets the user-defined pointer of this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwSetWindowUserPointer(long, long) glfwSetWindowUserPointer()}
	 * 
	 * @param pointer - The user-defined pointer
	 */
	public void setUserPointer(long pointer) {
		GLFW.glfwSetWindowUserPointer(this.name, pointer);
	}
	
	/**Returns this {@link Window}'s title.
	 * 
	 * @return The window title
	 */
	public CharSequence getTitle() {
		return this.title;
	}
	
	/**Returns whether or not the {@link Window} is visible.<br>
	 * Always return <code>true</code> if in fullscreen mode.
	 * 
	 * @return Whether or not the window is visible
	 */
	public boolean isVisible() {
		return this.visible;
	}
	
	/**Returns whether or not the {@link Window} is iconified.<br>
	 * This can be set whether by calling {@link #iconify()} or if
	 * the user iconified the {@link Window}.
	 * 
	 * @return Whether or not the window is iconified
	 */
	public boolean isInconified() {
		return GLFW.glfwGetWindowAttrib(this.name, GLFW.GLFW_ICONIFIED) == GLFW.GLFW_TRUE;
	}
	
	/**Returns whether or not the {@link Window} is maximized.<br>
	 * This can be set whether by calling {@link #maximize()} or if
	 * the user maximized the {@link Window}.
	 * 
	 * @return Whether or not the window is maximized
	 */
	public boolean isMaximized() {
		return GLFW.glfwGetWindowAttrib(this.name, GLFW.GLFW_MAXIMIZED) == GLFW.GLFW_TRUE;
	}
	
	/**Returns whether or not the {@link Window} is restored.<br>
	 * This returns <code>true</code> if, and only if,
	 * {@link #isFullscreenMode()}, {@link #isInconified()} and
	 * {@link #isMaximized()} returns all <code>false</code>.
	 * 
	 * @return Whether or not the window is restored
	 */
	public boolean isRestored() {
		return !this.fullscreen && !this.isInconified() && !this.isMaximized();
	}
	
	/**Returns the <code>x</code> coordinate of the {@link Window}
	 * when in windowed mode.
	 * 
	 * @return The <code>x</code> coordinate
	 */
	public int getWindowedX() {
		return this.x;
	}
	
	/**Returns the <code>y</code> coordinate of the {@link Window}
	 * when in windowed mode.
	 * 
	 * @return The <code>y</code> coordinate
	 */
	public int getWindowedY() {
		return this.y;
	}
	
	/**Returns the <code>x</code> coordinate of the {@link Window}.<br>
	 * Returns <code>x</code> if in windowed mode, 0 otherwise.
	 * 
	 * @return The <code>x</code> coordinate
	 */
	public int getX() {
		return this.fullscreen ? 0 : this.x;
	}
	
	/**Returns the <code>y</code> coordinate of the {@link Window}.<br>
	 * Returns <code>y</code> if in windowed mode, 0 otherwise.
	 * 
	 * @return The <code>y</code> coordinate
	 */
	public int getY() {
		return this.fullscreen ? 0 : this.y;
	}
	
	/**Returns the <code>width</code> of the {@link Window} when in
	 * windowed mode.
	 * 
	 * @return The <code>width</code>
	 */
	public int getWindowedWidth() {
		return this.wwidth;
	}
	
	/**Returns the <code>height</code> of the {@link Window} when in
	 * windowed mode.
	 * 
	 * @return The <code>height</code>
	 */
	public int getWindowedHeight() {
		return this.wheight;
	}
	
	/**Returns the <code>width</code> of the {@link Window}.<br>
	 * This will return the monitor's <code>width</code> if in
	 * fullscreen mode, or the {@link Window}'s otherwise.
	 * 
	 * @return The <code>width</code>
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**Returns the <code>height</code> of the {@link Window}.<br>
	 * This will return the monitor's <code>height</code> if in
	 * fullscreen mode, or the {@link Window}'s otherwise.
	 * 
	 * @return The <code>height</code>
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**Returns whether or not the {@link Window} has the input focus.
	 * 
	 * @return Whether or not the window has focus
	 */
	public boolean hasFocus() {
		return GLFW.glfwGetWindowAttrib(this.name, GLFW.GLFW_FOCUSED) == GLFW.GLFW_TRUE;
	}
	
	/**Returns whether or not this {@link Window} should close.<br>
	 * This can be set whether by calling {@link #setShouldClose(boolean)}
	 * or if the user attempts to close this {@link Window} in any way.<br>
	 * <b>See</b> {@link GLFW#glfwWindowShouldClose(long) glfwWindowShouldClose()}
	 * 
	 * @return Whether or not the window should close
	 */
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(this.name);
	}
	
	/**Returns the user-defined pointer of this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwGetWindowUserPointer(long) glfwGetWindowUserPointer()}
	 * 
	 * @return The user-defined pointer
	 */
	public long getUserPointer() {
		return GLFW.glfwGetWindowUserPointer(this.name);
	}
	
	/**Sets this {@link Window} to fullscreen mode.
	 */
	public void setFullscreenMode() {
		if (this.fullscreen) {
			return;
		}
		this.setVisible(true);
		Monitor m = Monitor.getPrimaryMonitor();
		GLFW.glfwSetWindowMonitor(this.name, m.name, 0, 0, m.width, m.height, WindowHints.DONT_CARE);
		this.width = m.width;
		this.height = m.height;
		this.fullscreen = true;
	}
	
	/**Sets this {@link Window} to windowed mode.
	 */
	public void setWindowedMode() {
		if (!this.fullscreen) {
			return;
		}
		GLFW.glfwSetWindowMonitor(this.name, Monitor.NULL.name, this.x, this.y, this.wwidth, this.wheight, WindowHints.DONT_CARE);
		this.width = this.wwidth;
		this.height = this.wheight;
		this.fullscreen = false;
	}
	
	/**Returns whether or not the {@link Window} is in fullscreen mode.
	 * 
	 * @return Whether the window is in fullscreen mode
	 */
	public boolean isFullscreenMode() {
		return this.fullscreen;
	}
	
	/**Makes this {@link Window}'s context current<br>
	 * <b>See</b> {@link GLFW#glfwMakeContextCurrent(long) glfwMakeContextCurrent()}
	 * 
	 */
	public void makeContextCurrent() {
		GLFW.glfwMakeContextCurrent(this.name);
	}
	
	/**Processes all pending events.<br>
	 * <b>See</b> {@link GLFW#glfwPollEvents() glfwPollEvents()}
	 */
	public void pollEvents() {
		GLFW.glfwPollEvents();
	}
	
	/**Posts an empty event from the current thread to the main thread event queue.<br>
	 * <b>See</b> {@link GLFW#glfwPostEmptyEvent() glfwPostEmptyEvent()}
	 */
	public void postEmptyEvent() {
		GLFW.glfwPostEmptyEvent();
	}
	
	/**Swap the {@link Window}'s buffers.<br>
	 * <b>See</b> {@link GLFW#glfwSwapBuffers(long) glfwSwapBuffers()}
	 */
	public void swapBuffers() {
		GLFW.glfwSwapBuffers(this.name);
	}

	/**Sets the buffers swapping interval.<br>
	 * <b>See</b> {@link GLFW#glfwSwapInterval(int) glfwSwapInterval()}
	 */
	public void swapInterval(int interval) {
		GLFW.glfwSwapInterval(interval);
	}
	
	/**Sets the system's clipboard content.<br>
	 * <b>See</b> {@link GLFW#glfwSetClipboardString(long, CharSequence) glfwSetClipboardString()}
	 * 
	 * @param data - The {@link CharSequence} to be copied to the system's clipboard
	 */
	public void setClipboardString(CharSequence data) {
		GLFW.glfwSetClipboardString(this.name, data);
	}
	
	/**Sets the system's clipboard content.<br>
	 * <b>See</b> {@link GLFW#glfwSetClipboardString(long, ByteBuffer) glfwSetClipboardString()}
	 * 
	 * @param data - The {@link ByteBuffer} to be copied to the system's clipboard
	 */
	public void setClipboardString(ByteBuffer data) {
		GLFW.glfwSetClipboardString(this.name, data);
	}
	
	/**Returns the system's clipboard content.<br>
	 * <b>See</b> {@link GLFW#glfwGetClipboardString(long) glfwGetClipboardString()}
	 * 
	 * @return The clipboard {@link String}
	 */
	public String getClipboardString() {
		return GLFW.glfwGetClipboardString(this.name);
	}
	
	/**Returns a {@link String} representation of this {@link Window}.
	 */
	public String toString() {
		return "net.fantasticfantasy.engine3d.Window{name=" + this.name + ",title=" + this.title + "}";
	}
	
	private void updatePosAndSize() {
		if (this.fullscreen) {
			return;
		}
		GLFW.glfwSetWindowPos(this.name, this.x, this.y);
		GLFW.glfwSetWindowSize(this.name, this.wwidth, this.wheight);
		this.width = this.wwidth;
		this.height = this.wheight;
	}
}
