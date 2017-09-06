package net.fantasticfantasy.engine3d;

import org.lwjgl.glfw.GLFW;

/**The main class of the Engine3D library.
 */
public class Engine3D {
	
	/**@STATIC_MODULE_CLASS*/
	private Engine3D() {}
	
	private static boolean init;
	
	/**Initializes Engine3D and the required libraries.
	 * 
	 * @throws InitializationException - If any error occurs
	 * while initializing
	 */
	public static void init() throws InitializationException {
		if (init) {
			throw new IllegalStateException("Engine3D is already initialized!");
		}
		if (!GLFW.glfwInit()) {
			throw new InitializationException("Could not initialize GLFW!");
		}
		init = true;
	}
	
	/**Terminates the execution of Engine3D and the libraries
	 * initialized on the invocation of {@link #init()}.
	 */
	public static void terminate() {
		if (!init) {
			throw new IllegalStateException("Engine3D is not initialized!");
		}
		init = false;
	}
	
	public static class Libraries {
		
		public static final LibraryInfo ENGINE_3D = engine3D();
		
		/**@STATIC_MODULE_CLASS*/
		private Libraries() {}
		
		private static LibraryInfo engine3D() {
			return new LibraryInfo("Engine 3D", version, attributes);
		}
	}
}
