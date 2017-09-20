package oolwre;

/**The <code>Platform</code> class represents the user's
 * current {@link OS}.
 */
public class Platform {
	
	/** The name of the {@link OS} */
	public static final String OS_NAME = System.getProperty("os.name");
	
	/** The user's {@link OS} */
	public static final OS PLATFORM_OS;
	
	static {
		if (OS_NAME.toLowerCase().contains("win")) {
			PLATFORM_OS = OS.WINDOWS;
		} else if (OS_NAME.toLowerCase().contains("mac")) {
			PLATFORM_OS = OS.MAC;
		} else if (OS_NAME.toLowerCase().contains("linux")) {
			PLATFORM_OS = OS.LINUX;
		} else {
			PLATFORM_OS = OS.OTHER;
		}
	}
	
	/**@STATIC_MODULE_CLASS*/
	private Platform() {}
	
	/**Returns whether or not {@link #PLATFORM_OS} equals {@link OS#WINDOWS}.
	 * 
	 * @return Whether or not the user's {@link OS} is Windows
	 */
	public static boolean isWindows() {
		return PLATFORM_OS == OS.WINDOWS;
	}
	
	/**Returns whether or not {@link #PLATFORM_OS} equals {@link OS#MAC}.
	 * 
	 * @return Whether or not the user's {@link OS} is Mac
	 */
	public static boolean isMac() {
		return PLATFORM_OS == OS.MAC;
	}
	
	/**Returns whether or not {@link #PLATFORM_OS} equals {@link OS#LINUX}.
	 * 
	 * @return Whether or not the user's {@link OS} is Linux
	 */
	public static boolean isLinux() {
		return PLATFORM_OS == OS.LINUX;
	}
	
	/**The possible OS<br><br>
	 * {@link #LINUX}<br>
	 * {@link #MAC}<br>
	 * {@link #WINDOWS}<br>
	 * {@link #OTHER}
	 */
	public static enum OS {
		LINUX,
		MAC,
		WINDOWS,
		OTHER;
	}
}
