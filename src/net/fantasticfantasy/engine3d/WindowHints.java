package net.fantasticfantasy.engine3d;

import org.lwjgl.glfw.GLFW;

/**{@link Window} creation hints.<br>
 * <a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
 */
public final class WindowHints {
	
	/** Boolean values<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int FALSE = GLFW.GLFW_FALSE,
			TRUE = GLFW.GLFW_TRUE;
	
	/** Dont care value<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int DONT_CARE = GLFW.GLFW_DONT_CARE;
	
	/** Client API<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int OPENGL_API = GLFW.GLFW_OPENGL_API,
			OPENGL_ES_API = GLFW.GLFW_OPENGL_ES_API,
			NO_API = GLFW.GLFW_NO_API;
	
	/** Context creation API<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int NATIVE_CONTEXT_API = GLFW.GLFW_NATIVE_CONTEXT_API,
			EGL_CONTEXT_API = GLFW.GLFW_EGL_CONTEXT_API;
	
	/** OpenGL profile<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int OPENGL_ANY_PROFILE = GLFW.GLFW_OPENGL_ANY_PROFILE,
			OPENGL_COMPAT_PROFILE = GLFW.GLFW_OPENGL_COMPAT_PROFILE,
			OPENGL_CORE_PROFILE = GLFW.GLFW_OPENGL_CORE_PROFILE;
	
	/** Context robustness<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int NO_ROBUSTNESS = GLFW.GLFW_NO_ROBUSTNESS,
			NO_RESET_NOTIFICATION = GLFW.GLFW_NO_RESET_NOTIFICATION,
			LOSE_CONTEXT_ON_RESET = GLFW.GLFW_LOSE_CONTEXT_ON_RESET;
	
	/** Context release behavior<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public static final int ANY_RELEASE_BEHAVIOR = GLFW.GLFW_ANY_RELEASE_BEHAVIOR,
			RELEASE_BEHAVIOR_FLUSH = GLFW.GLFW_RELEASE_BEHAVIOR_FLUSH,
			RELEASE_BEHAVIOR_NONE = GLFW.GLFW_RELEASE_BEHAVIOR_NONE;
	
	/**Specify if window should be resizable <i>by the user</i><br>
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int resizable = TRUE;
	
	/** Specify if window should be decorated<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int decorated = TRUE;
	
	/** Specify if window should be visible on creation<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int visible = TRUE;
	
	/**Specify if window should be focused on creation<br>
	 * <b>Ignored</b> if {@link WindowHints#visible visible} is {@link WindowHints#FALSE FALSE}<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int focused = TRUE;
	
	/**Specify if window should automatically iconify on lost focus<br> 
	 * <b>Ignored</b> for windowed windows <i>(no monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int autoIconify = TRUE;
	
	/**Specify if window should float over all other windows <i>(always-on-top)</i><br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int floating = FALSE;
	
	/**Specify if window should be maximized on creation<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int maximized = FALSE;
	
	/**Specify the desired bit depth of the red bits component of the default framebuffer<br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int redBits = 8;
	
	/**Specify the desired bit depth of the green bits component of the default framebuffer<br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int greenBits = 8;
	
	/**Specify the desired bit depth of the blue bits component of the default framebuffer<br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int blueBits = 8;
	
	/**Specify the desired bit depth of the alpha bits component of the default framebuffer<br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int alphaBits = 8;
	
	/**Specify the desired bit depth of the depth bits component of the default framebuffer<br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int depthBits = 24;
	
	/**Specify the desired bit depth of the stencil bits component of the default framebuffer<br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int stencilBits = 8;
	
	/**Specify the desired number of samples to use for multisampling<br>
	 * <b>Values:</b> 1 to {@link Integer#MAX_VALUE},<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0 to disable multisampling,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int samples = 0;
	
	/**Specify the desired refresh rate for fullscreen windows<br> 
	 * <b>Ignored</b> for windowed windows <i>(no monitor specified)</i><br>
	 * <b>Values:</b> 0 to {@link Integer#MAX_VALUE}, or {@link #DONT_CARE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int refreshRate = DONT_CARE;
	
	/**Specify if stereoscopic rendering should be used or not<br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int stereo = FALSE;
	
	/**Specify if the framebuffer should be sRGB capable<br>
	 * <b>Values:</b> {@link WindowHints#TRUE TRUE} or {@link WindowHints#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int sRGBCapable = FALSE;
	
	/**Specify if the framebuffer should be double buffered<br>
	 * <b>Values:</b> {@link #TRUE} or {@link #FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int doublebuffer = TRUE;
	
	/**Specify the desired client API<br> context creation API to use to create the context<br>
	 * <b>Values:</b> {@link #OPENGL_API}, {@link #OPENGL_ES_API}, or {@link #NO_API}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int clientAPI = OPENGL_API;
	
	/**Specify the context creation API to use to create the context<br>
	 * <b>Values:</b> {@link #NATIVE_CONTEXT_API} or {@link #EGL_CONTEXT_API}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int contextCreationAPI = NATIVE_CONTEXT_API;

	/**Specify the client API major version that the created context must be compatible with<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int contextVersionMajor = 1;

	/**Specify the client API minor version that the created context must be compatible with<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int contextVersionMinor = 0;
	
	/**Specify if the OpenGL context should be forward-compatible<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link #TRUE} or {@link #FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int openGLForwardCompat = FALSE;
	
	/**Specify if the OpenGL context should be a debug context<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link #TRUE} or {@link #FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int openGLDebugContext = FALSE;
	
	/**Specify the OpenGL context profile<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link #OPENGL_ANY_PROFILE}, {@link #OPENGL_CORE_PROFILE}, or {@link #OPENGL_COMPAT_PROFILE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int openGLProfile = OPENGL_ANY_PROFILE;
	
	/**Specify the OpenGL context robustness strategy<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link #NO_ROBUSTNESS}, {@link #NO_RESET_NOTIFICATION}, or {@link #LOSE_CONTEXT_ON_RESET}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int contextRobustness = NO_ROBUSTNESS;
	
	/**Specify the OpenGL context release behavior<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link #ANY_RELEASE_BEHAVIOR}, {@link #RELEASE_BEHAVIOR_FLUSH}, or {@link #RELEASE_BEHAVIOR_NONE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public int contextReleaseBehavior = ANY_RELEASE_BEHAVIOR;
	
	/**Constructor<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public WindowHints() {}
	
	/**Sets the color bits to the <code>monitor</code>'s color bits
	 * 
	 * @param monitor - The {@link Monitor}
	 */
	public void setRequiredColorBits(Monitor monitor) {
		this.redBits = monitor.redBits;
		this.greenBits = monitor.greenBits;
		this.blueBits = monitor.blueBits;
	}
	
	/**Makes this {@link WindowHints} active.<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	protected void makeActive() {
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, this.resizable);
		GLFW.glfwWindowHint(GLFW.GLFW_DECORATED, this.decorated);
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, this.visible);
		GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, this.focused);
		GLFW.glfwWindowHint(GLFW.GLFW_AUTO_ICONIFY, this.autoIconify);
		GLFW.glfwWindowHint(GLFW.GLFW_FLOATING, this.floating);
		GLFW.glfwWindowHint(GLFW.GLFW_MAXIMIZED, this.maximized);
		GLFW.glfwWindowHint(GLFW.GLFW_RED_BITS, this.redBits);
		GLFW.glfwWindowHint(GLFW.GLFW_GREEN_BITS, this.greenBits);
		GLFW.glfwWindowHint(GLFW.GLFW_BLUE_BITS, this.blueBits);
		GLFW.glfwWindowHint(GLFW.GLFW_ALPHA_BITS, this.alphaBits);
		GLFW.glfwWindowHint(GLFW.GLFW_DEPTH_BITS, this.depthBits);
		GLFW.glfwWindowHint(GLFW.GLFW_STENCIL_BITS, this.stencilBits);
		GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, this.samples);
		GLFW.glfwWindowHint(GLFW.GLFW_REFRESH_RATE, this.refreshRate);
		GLFW.glfwWindowHint(GLFW.GLFW_STEREO, this.stereo);
		GLFW.glfwWindowHint(GLFW.GLFW_SRGB_CAPABLE, this.sRGBCapable);
		GLFW.glfwWindowHint(GLFW.GLFW_DOUBLEBUFFER, this.doublebuffer);
		GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, this.clientAPI);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_CREATION_API, this.contextCreationAPI);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, this.contextVersionMajor);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, this.contextVersionMinor);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, this.openGLForwardCompat);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT, this.openGLDebugContext);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, this.openGLProfile);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_ROBUSTNESS, this.contextRobustness);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_RELEASE_BEHAVIOR, this.contextReleaseBehavior);
	}
}
