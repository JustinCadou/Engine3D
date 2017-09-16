package oolwre;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;

/**The main class of the OOLWRE library.
 */
public class OOLWRE {
	
	/**@STATIC_MODULE_CLASS*/
	private OOLWRE() {}
	
	/**Whether or not {@link OOLWRE} is initialized
	 */
	private static boolean init;
	
	/**Initializes {@link OOLWRE} and the required libraries.
	 * 
	 * @throws InitializationException - If any error occurs
	 * while initializing
	 */
	public static void init() throws InitializationException {
		if (init) {
			throw new IllegalStateException("OOLWRE is already initialized!");
		}
		if (!GLFW.glfwInit()) {
			throw new InitializationException("Could not initialize GLFW!");
		}
		Monitor.init();
		init = true;
	}
	
	/**Terminates the execution of {@link OOLWRE} and the libraries
	 * initialized on the invocation of {@link #init()}.
	 */
	public static void terminate() {
		if (!init) {
			throw new IllegalStateException("OOLWRE is not initialized!");
		}
		GLFW.glfwTerminate();
		init = false;
	}
	
	/**<b>O</b>bject-<b>O</b>riented <b>L</b>ight<b> W</b>eight
	 * <b>R</b>ender <b>E</b>ngine
	 * 
	 * @return <code>OOLWRE</code> acronym meaning
	 */
	public static final String getTseyllMeaning() {
		return "Object-Oriented Light Weight Render Engine";
	}
	
	/**Contains all the libraries used by {@link OOLWRE}
	 */
	public static class Libraries {
		
		/**The {@link OOLWRE} library*/
		public static final LibraryInfo oolwre = oolwre();
		
		/**The <code>LWJGL</code> library*/
		public static final LibraryInfo lwjgl = lwjgl();
		
		/**The {@link GLFW} library*/
		public static final LibraryInfo glfw = glfw();
		
		/**@STATIC_MODULE_CLASS*/
		private Libraries() {}
		
		private static LibraryInfo oolwre() {
			LibraryInfo.Version version = new LibraryInfo.Version(0, 0, 0, 5);
			return new LibraryInfo("OOLWRE", version, "java-8");
		}
		
		private static LibraryInfo lwjgl() {
			LibraryInfo.Version version = new LibraryInfo.Version(Version.VERSION_MAJOR, Version.VERSION_MINOR, Version.VERSION_REVISION);
			return new LibraryInfo("LWJGL", version);
		}

		private static LibraryInfo glfw() {
			int[] maj = new int[1], min = new int[1], rev = new int[1];
			GLFW.glfwGetVersion(maj, min, rev);
			LibraryInfo.Version version = new LibraryInfo.Version(maj[0], min[0], rev[0]);
			String[] str = GLFW.glfwGetVersionString().split(" ");
			String[] attributes = new String[str.length - 1];
			for (int i = 1; i < str.length; i++) {
				attributes[i - 1] = str[i];
			}
			return new LibraryInfo("GLFW", version, attributes);
		}
	}
}
