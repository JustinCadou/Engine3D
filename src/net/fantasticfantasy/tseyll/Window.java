package net.fantasticfantasy.tseyll;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;

public class Window {
	
	/**Used for disable some fields like {@link #setSizeLimits(int, int, int, int)
	 * setSizeLimits} and {@link #setAspectRatio(int, int) setAspectRatio}
	 */
	public static final int DONT_CARE = GLFW.GLFW_DONT_CARE;
	
	protected WindowHints hints;
	protected long name;
	
	private CharSequence title;
	private WindowIcon icon;
	private Cursor cursor;
	private boolean fullscreen;
	private boolean visible;
	
	/**The {@link Window} windowed mode size*/
	private int wwidth, wheight;
	private int width, height;
	private int x, y;
	
	/**The {@link Window} size limits*/
	private int minW, minH, maxW, maxH;
	
	/**The {@link Window} aspect ratio*/
	private int aspectRatioNum, aspectRatioDenum;
	
	/**The {@link WindowEventsHandler}*/
	private WindowEventsHandler eventsHandler;
	
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
		this.eventsHandler = new WindowEventsHandler(this);
		int[] qx = new int[1];
		int[] qy = new int[1];
		GLFW.glfwGetWindowPos(this.name, qx, qy);
		this.x = qx[0];
		this.y = qy[0];
		this.visible = hints.visible == WindowHints.Boolean.TRUE ? true : false;
		this.cursor = new Cursor(this);
		this.hints = hints;
	}
	
	/**Returns the {@link GLFW} name of this {@link Window}.
	 * 
	 * @return The GLFW name of this Window
	 */
	public final long getName() {
		return this.name;
	}
	
	/**Sets the title of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowTitle(long, CharSequence) glfwSetWindowTitle()}
	 * 
	 * @param title - The new title
	 */
	public void setTitle(CharSequence title) {
		this.check();
		GLFW.glfwSetWindowTitle(this.name, title);
		this.title = title;
	}
	
	/**Sets the title of the {@link Window} using the bytes in <code>title</code>.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowTitle(long, ByteBuffer) glfwSetWindowTitle()}
	 * 
	 * @param title - The new title
	 */
	public void setTitle(ByteBuffer title) {
		this.check();
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
	
	/**Sets whether or not the {@link Window} should be visible.<br><br>
	 * <b>See</b> {@link GLFW#glfwShowWindow(long) glfwShowWindow()}<br>
	 * <b>See</b> {@link GLFW#glfwHideWindow(long) glfwHideWindow()}
	 * 
	 * @param visible - The new visibility
	 */
	public void setVisible(boolean visible) {
		this.check();
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
		this.check();
		GLFW.glfwIconifyWindow(this.name);
	}
	
	/**Maximizes the {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwMaximizeWindow(long) glfwMaximizeWindow()}
	 */
	public void maximize() {
		this.check();
		if (this.fullscreen) {
			return;
		}
		GLFW.glfwMaximizeWindow(this.name);
	}
	
	/**Restores the {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwRestoreWindow(long) glfwRestoreWindow()}
	 */
	public void restore() {
		this.check();
		GLFW.glfwRestoreWindow(this.name);
	}
	
	/**Sets the <code>x</code> coordinate of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowPos(long, int, int) glfwSetWindowPos()}
	 * 
	 * @param x - The new <code>x</code> coordinate
	 */
	public void setX(int x) {
		this.check();
		this.x = x;
		this.updatePosAndSize();
	}
	
	/**Sets the <code>y</code> coordinate of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowPos(long, int, int) glfwSetWindowPos()}
	 * 
	 * @param y - The new <code>y</code> coordinate
	 */
	public void setY(int y) {
		this.check();
		this.y = y;
		this.updatePosAndSize();
	}
	
	/**Sets the position of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowPos(long, int, int) glfwSetWindowPos()}
	 * 
	 * @param x - The new <code>x</code> coordinate
	 * @param y - The new <code>y</code> coordinate
	 */
	public void setPosition(int x, int y) {
		this.check();
		this.x = x;
		this.y = y;
		this.updatePosAndSize();
	}
	
	/**Sets the <code>width</code> of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowSize(long, int, int) glfwSetWindowSize()}
	 * 
	 * @param width - The new <code>width</code>
	 */
	public void setWidth(int width) {
		this.check();
		this.wwidth = width;
		this.updatePosAndSize();
	}

	/**Sets the <code>height</code> of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowSize(long, int, int) glfwSetWindowSize()}
	 * 
	 * @param width - The new <code>height</code>
	 */
	public void setHeight(int height) {
		this.check();
		this.wheight = height;
		this.updatePosAndSize();
	}
	
	/**Sets the size of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowSize(long, int, int) glfwSetWindowSize()}
	 * 
	 * @param width - The new <code>width</code>
	 * @param height - The new <code>height</code>
	 */
	public void setSize(int width, int height) {
		this.check();
		this.wwidth = width;
		this.wheight = height;
		this.updatePosAndSize();
	}
	
	/**Sets the position and size of the {@link Window}.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowPos(long, int, int) glfwSetWindowPos()}<br>
	 * <b>See</b> {@link GLFW#glfwSetWindowSize(long, int, int) glfwSetWindowSize()}<br>
	 * 
	 * @param x - The new <code>x</code> coordinate
	 * @param y - The new <code>y</code> coordinate
	 * @param width - The new <code>width</code>
	 * @param height - The new <code>height</code>
	 */
	public void setBounds(int x, int y, int width, int height) {
		this.check();
		this.x = x;
		this.y = y;
		this.wwidth = width;
		this.wheight = height;
		this.updatePosAndSize();
	}
	
	/**Sets the {@link Window} size limits to the specified parameters.<br>
	 * Put {@link #DONT_CARE} on fields to disable.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowSizeLimits(long, int, int, int, int)
	 * glfwSetWindowSizeLimits()}
	 * 
	 * @param minW - The minimum {@link Window} width
	 * @param minH - The minimum {@link Window} height
	 * @param maxW - The maximum {@link Window} width
	 * @param maxH - The maximum {@link Window} height
	 */
	public void setSizeLimits(int minW, int minH, int maxW, int maxH) {
		this.check();
		this.checkSizeLimits(minW, minH, maxW, maxH);
		GLFW.glfwSetWindowSizeLimits(this.name, minW, minH, maxW, maxH);
		this.minW = minW;
		this.minH = minH;
		this.maxW = maxW;
		this.maxH = maxH;
	}
	
	/**Sets the {@link Window} aspect ratio to the specified parameters.<br>
	 * Put {@link #DONT_CARE} on <i>EVERY</i> fields to disable.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowAspectRatio(long, int, int)
	 * glfwSetWindowAspectRatio()}
	 * 
	 * @param num - The numerator
	 * @param denum - The denominator
	 */
	public void setAspectRatio(int num, int denum) {
		this.check();
		this.checkAspectRatio(num, denum);
		GLFW.glfwSetWindowAspectRatio(this.name, num, denum);
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
	
	public void setIcon(WindowIcon icon) {
		this.check();
		GLFWImage.Buffer buffer = icon.toBuffer();
		GLFW.glfwSetWindowIcon(this.name, buffer);
		this.icon = icon;
	}
	
	/**Requests the user's attention on this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwRequestWindowAttention(long) glfwRequestWindowAttention()}
	 */
	public void requestUserAttention() {
		this.check();
		GLFW.glfwRequestWindowAttention(this.name);
	}
	
	/**Sets the should close status of the {@link Window} to <code>b</code>.<br><br>
	 * <b>See</b> {@link GLFW#glfwSetWindowShouldClose(long, boolean)
	 * glfwSetWindowShouldClose()}
	 * 
	 * @param b - The new should close status
	 */
	public void setShouldClose(boolean b) {
		this.check();
		GLFW.glfwSetWindowShouldClose(this.name, b);
	}
	
	/**Sets the user-defined pointer of this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwSetWindowUserPointer(long, long) glfwSetWindowUserPointer()}
	 * 
	 * @param pointer - The user-defined pointer
	 */
	public void setUserPointer(long pointer) {
		this.check();
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
		this.check();
		return GLFW.glfwGetWindowAttrib(this.name, GLFW.GLFW_ICONIFIED) == GLFW.GLFW_TRUE;
	}
	
	/**Returns whether or not the {@link Window} is maximized.<br>
	 * This can be set whether by calling {@link #maximize()} or if
	 * the user maximized the {@link Window}.
	 * 
	 * @return Whether or not the window is maximized
	 */
	public boolean isMaximized() {
		this.check();
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
	
	/**Returns the {@link WindowIcon} of the {@link Window}.
	 * 
	 * @return The icon
	 */
	public WindowIcon getIcon() {
		return this.icon;
	}
	
	/**Returns the {@link Cursor} of the {@link Window}.
	 * 
	 * @return The cursor
	 */
	public Cursor getCursor() {
		return this.cursor;
	}
	
	/**Queries the {@link Window} position and size.<br>
	 * Put <code>null</code> on a field you don't want to query.
	 * 
	 * @param x - The {@link IntBuffer} where to store <code>x</code>,
	 * or <code>null</code> to ignore
	 * @param y - The {@link IntBuffer} where to store <code>y</code>,
	 * or <code>null</code> to ignore
	 * @param width - The {@link IntBuffer} where to store <code>width</code>,
	 * or <code>null</code> to ignore
	 * @param height - The {@link IntBuffer} where to store <code>height</code>,
	 * or <code>null</code> to ignore
	 */
	public void queryBounds(IntBuffer x, IntBuffer y, IntBuffer width, IntBuffer height) {
		this.check();
		if (x != null) {
			x.put(this.getX());
		}
		if (y != null) {
			y.put(this.getY());
		}
		if (width != null) {
			width.put(this.width);
		}
		if (height != null) {
			height.put(this.height);
		}
	}
	
	/**Queries the {@link Window} position and size.<br>
	 * Put <code>null</code> on a field you don't want to query.
	 * 
	 * @param x - The <code>int[]</code> where to store <code>x</code>,
	 * or <code>null</code> to ignore
	 * @param y - The <code>int[]</code> where to store <code>y</code>,
	 * or <code>null</code> to ignore
	 * @param width - The <code>int[]</code> where to store <code>width</code>,
	 * or <code>null</code> to ignore
	 * @param height - The <code>int[]</code> where to store <code>height</code>,
	 * or <code>null</code> to ignore
	 */
	public void queryBounds(int[] x, int[] y, int[] width, int[] height) {
		this.check();
		if (x != null) {
			x[0] = this.getX();
		}
		if (y != null) {
			y[0] = this.getY();
		}
		if (width != null) {
			width[0] = this.width;
		}
		if (height != null) {
			height[0] = this.height;
		}
	}
	
	/**Queries the {@link Window} size limits.<br>
	 * Put <code>null</code> on a field you don't want to query.
	 * 
	 * @param minW - The {@link IntBuffer} where to store <code>minW</code>,
	 * or <code>null</code> to ignore
	 * @param minH - The {@link IntBuffer} where to store <code>minH</code>,
	 * or <code>null</code> to ignore
	 * @param maxW - The {@link IntBuffer} where to store <code>maxW</code>,
	 * or <code>null</code> to ignore
	 * @param maxH - The {@link IntBuffer} where to store <code>maxH</code>,
	 * or <code>null</code> to ignore
	 */
	public void querySizeLimits(IntBuffer minW, IntBuffer minH, IntBuffer maxW, IntBuffer maxH) {
		this.check();
		if (minW != null) {
			minW.put(this.minW);
		}
		if (minH != null) {
			minH.put(this.minH);
		}
		if (maxW != null) {
			maxW.put(this.maxW);
		}
		if (maxH != null) {
			maxH.put(this.maxH);
		}
	}
	
	/**Queries the {@link Window} size limits.<br>
	 * Put <code>null</code> on a field you don't want to query.
	 * 
	 * @param minW - The <code>int[]</code> where to store <code>minW</code>,
	 * or <code>null</code> to ignore
	 * @param minH - The <code>int[]</code> where to store <code>minH</code>,
	 * or <code>null</code> to ignore
	 * @param maxW - The <code>int[]</code> where to store <code>maxW</code>,
	 * or <code>null</code> to ignore
	 * @param maxH - The <code>int[]</code> where to store <code>maxH</code>,
	 * or <code>null</code> to ignore
	 */
	public void querySizeLimits(int[] minW, int[] minH, int[] maxW, int[] maxH) {
		this.check();
		if (minW != null) {
			minW[0] = this.minW;
		}
		if (minH != null) {
			minH[0] = this.minH;
		}
		if (maxW != null) {
			maxW[0] = this.maxW;
		}
		if (maxH != null) {
			maxH[0] = this.maxH;
		}
	}
	
	/**Queries the {@link Window} aspect ratio limit.<br>
	 * Put <code>null</code> on a field you don't want to query.
	 * 
	 * @param num - The {@link IntBuffer} where to store <code>num</code>,
	 * or <code>null</code> to ignore
	 * @param denum - The {@link IntBuffer} where to store <code>denum</code>,
	 * or <code>null</code> to ignore
	 */
	public void queryAspectRatio(IntBuffer num, IntBuffer denum) {
		this.check();
		if (num != null) {
			num.put(this.aspectRatioNum);
		}
		if (denum != null) {
			denum.put(this.aspectRatioDenum);
		}
	}

	/**Queries the {@link Window} aspect ratio limit.<br>
	 * Put <code>null</code> on a field you don't want to query.
	 * 
	 * @param num - The <code>int[]</code> where to store <code>num</code>,
	 * or <code>null</code> to ignore
	 * @param denum - The <code>int[]</code> where to store <code>denum</code>,
	 * or <code>null</code> to ignore
	 */
	public void queryAspectRatio(int[] num, int[] denum) {
		this.check();
		if (num != null) {
			num[0] = this.aspectRatioNum;
		}
		if (denum != null) {
			denum[0] = this.aspectRatioDenum;
		}
	}
	
	/**Returns whether or not the {@link Window} has the input focus.
	 * 
	 * @return Whether or not the window has focus
	 */
	public boolean hasFocus() {
		this.check();
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
		this.check();
		return GLFW.glfwWindowShouldClose(this.name);
	}
	
	/**Returns the user-defined pointer of this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwGetWindowUserPointer(long) glfwGetWindowUserPointer()}
	 * 
	 * @return The user-defined pointer
	 */
	public long getUserPointer() {
		this.check();
		return GLFW.glfwGetWindowUserPointer(this.name);
	}
	
	/**Returns this {@link Window}'s events handler.
	 * 
	 * @return The {@link WindowEventsHandler}
	 */
	public WindowEventsHandler getEventsHandler() {
		return this.eventsHandler;
	}
	
	/**Sets this {@link Window} to fullscreen mode.
	 */
	public void setFullscreenMode() {
		this.check();
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
		this.check();
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
		this.check();
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
		this.check();
		GLFW.glfwSwapBuffers(this.name);
	}

	/**Sets the buffers swapping interval.<br>
	 * <b>See</b> {@link GLFW#glfwSwapInterval(int) glfwSwapInterval()}
	 */
	public void swapInterval(int interval) {
		GLFW.glfwSwapInterval(interval);
	}
	
	/**Destroys this {@link Window}.<br>
	 * <b>See</b> {@link GLFW#glfwDestroyWindow(long) glfwDestroyWindow()}
	 */
	public void destroy() {
		this.check();
		GLFW.glfwDestroyWindow(this.name);
		this.name = 0;
	}
	
	/**Returns whether or not this {@link Window} is destroyed.
	 * 
	 * @return Whether or not this window is destroyed
	 */
	public boolean isDestroyed() {
		return this.name == 0;
	}
	
	/**Sets the system's clipboard content.<br>
	 * <b>See</b> {@link GLFW#glfwSetClipboardString(long, CharSequence) glfwSetClipboardString()}
	 * 
	 * @param data - The {@link CharSequence} to be copied to the system's clipboard
	 */
	public void setClipboardString(CharSequence data) {
		this.check();
		GLFW.glfwSetClipboardString(this.name, data);
	}
	
	/**Sets the system's clipboard content.<br>
	 * <b>See</b> {@link GLFW#glfwSetClipboardString(long, ByteBuffer) glfwSetClipboardString()}
	 * 
	 * @param data - The {@link ByteBuffer} to be copied to the system's clipboard
	 */
	public void setClipboardString(ByteBuffer data) {
		this.check();
		GLFW.glfwSetClipboardString(this.name, data);
	}
	
	/**Returns the system's clipboard content.<br>
	 * <b>See</b> {@link GLFW#glfwGetClipboardString(long) glfwGetClipboardString()}
	 * 
	 * @return The clipboard {@link String}
	 */
	public String getClipboardString() {
		this.check();
		return GLFW.glfwGetClipboardString(this.name);
	}
	
	/**Returns a {@link String} representation of this {@link Window}.
	 */
	public String toString() {
		return this.getClass().getName() + "{name=" + this.name + ",title=" + this.title + "}";
	}
	
	private void updatePosAndSize() {
		if (this.fullscreen) {
			return;
		}
		this.checkBounds(this.x, this.y, this.wwidth, this.wheight);
		GLFW.glfwSetWindowPos(this.name, this.x, this.y);
		GLFW.glfwSetWindowSize(this.name, this.wwidth, this.wheight);
		this.width = this.wwidth;
		this.height = this.wheight;
	}
	
	private void check() {
		if (this.isDestroyed()) {
			throw new NullPointerException("Window is destroyed");
		}
	}
	
	private void checkBounds(int x, int y, int width, int height) {
		if (x < 0) {
			throw new IllegalArgumentException("'x' < 0 (" + x + ")");
		} else if (y < 0) {
			throw new IllegalArgumentException("'y' < 0 (" + y + ")");
		} else if (width < 0) {
			throw new IllegalArgumentException("'x' < 0 (" + width + ")");
		} else if (height < 0) {
			throw new IllegalArgumentException("'x' < 0 (" + height + ")");
		}
	}
	
	private void checkSizeLimits(int minW, int minH, int maxW, int maxH) {
		if (minW < DONT_CARE) {
			throw new IllegalArgumentException("'minW' < 0 (" + minW + ")");
		} else if (minH < DONT_CARE) {
			throw new IllegalArgumentException("'minH' < 0 (" + minH + ")");
		} else if (maxW < minW && maxW != DONT_CARE) {
			throw new IllegalArgumentException("'maxW' (" + maxW + ") < 'minW' (" + minW + ")");
		} else if (maxH < minH && maxH != DONT_CARE) {
			throw new IllegalArgumentException("'maxH' (" + maxH + ") < 'minH' (" + minH + ")");
		}
	}
	
	private void checkAspectRatio(int num, int denum) {
		if (num <= 0 && num != DONT_CARE) {
			throw new IllegalArgumentException("'num' <= 0 (" + num + ")");
		} else if (denum <= 0 && denum != DONT_CARE) {
			throw new IllegalArgumentException("'denum' <= 0 (" + denum + ")");
		}
	}
}
