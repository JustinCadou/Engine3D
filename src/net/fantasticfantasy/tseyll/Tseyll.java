package net.fantasticfantasy.tseyll;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;

/**The main class of the Tseyll library.
 */
public class Tseyll {
	
	/**@STATIC_MODULE_CLASS*/
	private Tseyll() {}
	
	/**Whether or not Tseyll is initialized
	 */
	private static boolean init;
	
	/**Initializes Tseyll and the required libraries.
	 * 
	 * @throws InitializationException - If any error occurs
	 * while initializing
	 */
	public static void init() throws InitializationException {
		if (init) {
			throw new IllegalStateException("Tseyll is already initialized!");
		}
		if (!GLFW.glfwInit()) {
			throw new InitializationException("Could not initialize GLFW!");
		}
		Monitor.init();
		init = true;
	}
	
	/**Terminates the execution of {@link Tseyll} and the libraries
	 * initialized on the invocation of {@link #init()}.
	 */
	public static void terminate() {
		if (!init) {
			throw new IllegalStateException("Tseyll is not initialized!");
		}
		GLFW.glfwTerminate();
		init = false;
	}
	
	/**<b>T</b>erribly <b>S</b>imple <b>E</b>xecuted in <b>Y</b>octoseconds
	 * <b>L</b>oveable <b>L</b>ibrary
	 * 
	 * @return TSEYLL acronym meaning
	 */
	public static final String getTseyllMeaning() {
		return "Terribly Simple Executed in Yoctosecond Loveable Library";
	}
	
	/**Contains all the libraries used by {@link Tseyll}
	 */
	public static class Libraries {
		
		/**The {@link Tseyll} library*/
		public static final LibraryInfo tseyll = tseyll();
		
		/**The <code>LWJGL</code> library*/
		public static final LibraryInfo lwjgl = lwjgl();
		
		/**The {@link GLFW} library*/
		public static final LibraryInfo glfw = glfw();
		
		/**@STATIC_MODULE_CLASS*/
		private Libraries() {}
		
		private static LibraryInfo tseyll() {
			LibraryInfo.Version version = new LibraryInfo.Version(0, 0, 0, 1);
			return new LibraryInfo("Tseyll", version, "java-8");
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
