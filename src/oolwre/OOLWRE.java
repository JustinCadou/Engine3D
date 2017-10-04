package oolwre;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;

public class OOLWRE {
	
	/**@STATIC_MODULE_CLASS*/
	private OOLWRE() {}
	
	static {
		System.setProperty("oolwre.version", "pre-alpha5");
		System.setProperty("oolwre.version.details", "LWJGL version:\t" + Version.getVersion() +
				";GLFW version:\t" + GLFW.glfwGetVersionString() + ";Java version:\t" +
				System.getProperty("java.version"));
	}
	
	/**Initializes OOLWRE and {@link GLFW}.
	 * 
	 * @throws OOLWREException - If any error occurs
	 */
	public static void init() throws OOLWREException {
		try {
			if (!GLFW.glfwInit()) {
				throw new InitializationException("Could not initialize GLFW!");
			}
		} catch (Throwable t) {
			terminate();
			throw new OOLWREException("Could not initialize OOLWRE!", t);
		}
		System.setProperty("oolwre.initialized", "true");
	}
	
	public static void terminate() {
		GLFW.glfwTerminate();
	}
	
	public static boolean isInitialized() {
		return Boolean.getBoolean("oolwre.initialized");
	}
	
	public static String getVersionString() {
		return System.getProperty("oolwre.version");
	}
	
	public static String[] getDetailsOfLibraries() {
		return System.getProperty("oolwre.version.details").split(";");
	}
}
