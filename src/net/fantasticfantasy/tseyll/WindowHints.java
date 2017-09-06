package net.fantasticfantasy.tseyll;

import org.lwjgl.glfw.GLFW;

/**{@link Window} creation hints.<br>
 * <a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
 */
public final class WindowHints {
	
	/**Represents {@link GLFW#GLFW_DONT_CARE GLFW_DONT_CARE}*/
	public static final int DONT_CARE = GLFW.GLFW_DONT_CARE;
	
	/**Specify if window should be resizable <i>by the user</i><br>
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean resizable = Boolean.TRUE;
	
	/** Specify if window should be decorated<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean decorated = Boolean.TRUE;
	
	/** Specify if window should be visible on creation<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean visible = Boolean.TRUE;
	
	/**Specify if window should be focused on creation<br>
	 * <b>Ignored</b> if {@link WindowHints#visible visible} is {@link Boolean#FALSE FALSE}<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean focused = Boolean.TRUE;
	
	/**Specify if window should automatically iconify on lost focus<br> 
	 * <b>Ignored</b> for windowed windows <i>(no monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean autoIconify = Boolean.TRUE;
	
	/**Specify if window should float over all other windows <i>(always-on-top)</i><br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean floating = Boolean.FALSE;
	
	/**Specify if window should be maximized on creation<br> 
	 * <b>Ignored</b> for fullscreen windows <i>(monitor specified)</i><br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean maximized = Boolean.FALSE;
	
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
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean stereo = Boolean.FALSE;
	
	/**Specify if the framebuffer should be sRGB capable<br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean sRGBCapable = Boolean.FALSE;
	
	/**Specify if the framebuffer should be double buffered<br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean doublebuffer = Boolean.TRUE;
	
	/**Specify the desired client API<br> context creation API to use to create the context<br>
	 * <b>Values:</b> {@link ClientAPI} <code>enum</code><br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public ClientAPI clientAPI = ClientAPI.OPEN_GL;
	
	/**Specify the context creation API to use to create the context<br>
	 * <b>Values:</b> {@link ContextCreationAPI} <code>enum</code><br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public ContextCreationAPI contextCreationAPI = ContextCreationAPI.NATIVE;

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
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean openGLForwardCompat = Boolean.FALSE;
	
	/**Specify if the OpenGL context should be a debug context<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link Boolean#TRUE TRUE} or {@link Boolean#FALSE FALSE}<br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public Boolean openGLDebugContext = Boolean.FALSE;
	
	/**Specify the OpenGL context profile<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link OpenGLProfile} <code>enum</code><br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public OpenGLProfile openGLProfile = OpenGLProfile.ANY_PROFILE;
	
	/**Specify the OpenGL context robustness strategy<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link ContextRobustness} <code>enum</code><br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public ContextRobustness contextRobustness = ContextRobustness.NO_ROBUSTNESS;
	
	/**Specify the OpenGL context release behavior<br>
	 * <b>Ignored</b> if OpenGL ES API is requested<br>
	 * <b>Values:</b> {@link ContextReleaseBehavior} <code>enum</code><br>
	 *<a href="http://www.glfw.org/docs/3.1/window.html">Reference page</a>
	 */
	public ContextReleaseBehavior contextReleaseBehavior = ContextReleaseBehavior.ANY;
	
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
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, this.resizable.value);
		GLFW.glfwWindowHint(GLFW.GLFW_DECORATED, this.decorated.value);
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, this.visible.value);
		GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, this.focused.value);
		GLFW.glfwWindowHint(GLFW.GLFW_AUTO_ICONIFY, this.autoIconify.value);
		GLFW.glfwWindowHint(GLFW.GLFW_FLOATING, this.floating.value);
		GLFW.glfwWindowHint(GLFW.GLFW_MAXIMIZED, this.maximized.value);
		GLFW.glfwWindowHint(GLFW.GLFW_RED_BITS, this.redBits);
		GLFW.glfwWindowHint(GLFW.GLFW_GREEN_BITS, this.greenBits);
		GLFW.glfwWindowHint(GLFW.GLFW_BLUE_BITS, this.blueBits);
		GLFW.glfwWindowHint(GLFW.GLFW_ALPHA_BITS, this.alphaBits);
		GLFW.glfwWindowHint(GLFW.GLFW_DEPTH_BITS, this.depthBits);
		GLFW.glfwWindowHint(GLFW.GLFW_STENCIL_BITS, this.stencilBits);
		GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, this.samples);
		GLFW.glfwWindowHint(GLFW.GLFW_REFRESH_RATE, this.refreshRate);
		GLFW.glfwWindowHint(GLFW.GLFW_STEREO, this.stereo.value);
		GLFW.glfwWindowHint(GLFW.GLFW_SRGB_CAPABLE, this.sRGBCapable.value);
		GLFW.glfwWindowHint(GLFW.GLFW_DOUBLEBUFFER, this.doublebuffer.value);
		GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, this.clientAPI.value);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_CREATION_API, this.contextCreationAPI.value);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, this.contextVersionMajor);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, this.contextVersionMinor);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, this.openGLForwardCompat.value);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT, this.openGLDebugContext.value);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, this.openGLProfile.value);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_ROBUSTNESS, this.contextRobustness.value);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_RELEASE_BEHAVIOR, this.contextReleaseBehavior.value);
	}
	
	/**Boolean values<br><br>
	 * {@link #TRUE}<br>
	 * {@link #FALSE}
	 */
	public static enum Boolean {
		
		/**Represents {@link GLFW#GLFW_TRUE GLFW_TRUE}*/
		TRUE(GLFW.GLFW_TRUE),
		
		/**Represents {@link GLFW#GLFW_FALSE GLFW_FALSE}*/
		FALSE(GLFW.GLFW_FALSE);
		
		private int value;
		
		Boolean(int value) {
			this.value = value;
		}
	}
	
	/**Client APIs<br><br>
	 * {@link #OPEN_GL}<br>
	 * {@link #OPEN_GL_ES}<br>
	 * {@link #NONE}
	 */
	public static enum ClientAPI {
		
		/**Represents {@link GLFW#GLFW_OPENGL_API GLFW_OPENGL_API}*/
		OPEN_GL(GLFW.GLFW_OPENGL_API),
		
		/**Represents {@link GLFW#GLFW_OPENGL_ES_API GLFW_OPENGL_ES_API}*/
		OPEN_GL_ES(GLFW.GLFW_OPENGL_ES_API),
		
		/**Represents {@link GLFW#GLFW_NO_API GLFW_NO_API}*/
		NONE(GLFW.GLFW_NO_API);
		
		private int value;
		
		ClientAPI(int value) {
			this.value = value;
		}
	}
	
	/**OpenGL Context Creation APIs<br><br>
	 * {@link #NATIVE}<br>
	 * {@link #EGL}
	 */
	public static enum ContextCreationAPI {
		
		/**Represents {@link GLFW#GLFW_NATIVE_CONTEXT_API GLFW_NATIVE_CONTEXT_API}*/
		NATIVE(GLFW.GLFW_NATIVE_CONTEXT_API),
		
		/**Represents {@link GLFW#GLFW_EGL_CONTEXT_API GLFW_EGL_CONTEXT_API}*/
		EGL(GLFW.GLFW_EGL_CONTEXT_API);
		
		private int value;
		
		ContextCreationAPI(int value) {
			this.value = value;
		}
	}
	
	/**Open GL Profiles<br><br>
	 * {@link #ANY_PROFILE}<br>
	 * {@link #CORE_PROFILE}<br>
	 * {@link #COMPAT_PROFILE}
	 */
	public static enum OpenGLProfile {
		
		/**Represents {@link GLFW#GLFW_OPENGL_ANY_PROFILE GLFW_OPENGL_ANY_PROFILE}*/
		ANY_PROFILE(GLFW.GLFW_OPENGL_ANY_PROFILE),

		/**Represents {@link GLFW#GLFW_OPENGL_CORE_PROFILE GLFW_OPENGL_CORE_PROFILE}*/
		CORE_PROFILE(GLFW.GLFW_OPENGL_CORE_PROFILE),

		/**Represents {@link GLFW#GLFW_OPENGL_COMPAT_PROFILE GLFW_OPENGL_COMPAT_PROFILE}*/
		COMPAT_PROFILE(GLFW.GLFW_OPENGL_COMPAT_PROFILE);
		
		private int value;
		
		OpenGLProfile(int value) {
			this.value = value;
		}
	}
	
	/**Context Robustness Values<br><br>
	 * {@link #NO_ROBUSTNESS}<br>
	 * {@link #NO_RESET_NOTIFICATION}<br>
	 * {@link #LOSE_CONTEXT_ON_RESET}
	 */
	public static enum ContextRobustness {
		
		/**Represents {@link GLFW#GLFW_NO_ROBUSTNESS GLFW_NO_ROBUSTNESS}*/
		NO_ROBUSTNESS(GLFW.GLFW_NO_ROBUSTNESS),
		
		/**Represents {@link GLFW#GLFW_NO_RESET_NOTIFICATION GLFW_NO_RESET_NOTIFICATION}*/
		NO_RESET_NOTIFICATION(GLFW.GLFW_NO_RESET_NOTIFICATION),
		
		/**Represents {@link GLFW#GLFW_LOSE_CONTEXT_ON_RESET GLFW_LOSE_CONTEXT_ON_RESET}*/
		LOSE_CONTEXT_ON_RESET(GLFW.GLFW_LOSE_CONTEXT_ON_RESET);
		
		private int value;
		
		ContextRobustness(int value) {
			this.value = value;
		}
	}
	
	/**Context Release Behavior Values<br><br>
	 * {@link #ANY}<br>
	 * {@link #FLUSH}<br>
	 * {@link #NONE}
	 */
	public static enum ContextReleaseBehavior {
		
		/**Represents {@link GLFW#GLFW_ANY_RELEASE_BEHAVIOR GLFW_ANY_RELEASE_BEHAVIOR}*/
		ANY(GLFW.GLFW_ANY_RELEASE_BEHAVIOR),
		
		/**Represents {@link GLFW#GLFW_RELEASE_BEHAVIOR_FLUSH GLFW_RELEASE_BEHAVIOR_FLUSH}*/
		FLUSH(GLFW.GLFW_RELEASE_BEHAVIOR_FLUSH),
		
		/**Represents {@link GLFW#GLFW_RELEASE_BEHAVIOR_NONE GLFW_RELEASE_BEHAVIOR_NONE}*/
		NONE(GLFW.GLFW_RELEASE_BEHAVIOR_NONE);
		
		private int value;
		
		ContextReleaseBehavior(int value) {
			this.value = value;
		}
	}
}
