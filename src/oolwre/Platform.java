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
package oolwre;

/**The <code>Platform</code> class represents the user's
 * current {@link OS}.
 */
public class Platform {
	
	/** The name of the {@link OS} */
	public static final String OS_NAME = System.getProperty("os.name");
	
	/** The architecture of the {@link OS} */
	public static final String OS_ARCH = System.getProperty("os.arch");
	
	public static final boolean IS_64_BIT;
	
	/** The user's {@link OS} */
	public static final OS PLATFORM_OS;
	
	static {
		String os = OS_NAME.toLowerCase();
		if (os.contains("win")) {
			PLATFORM_OS = OS.WINDOWS;
		} else if (os.contains("mac")) {
			PLATFORM_OS = OS.MAC;
		} else if (os.contains("linux")) {
			PLATFORM_OS = OS.LINUX;
		} else if (os.contains("sun") || os.contains("solar")) {
			PLATFORM_OS = OS.SOLARIS;
		} else {
			PLATFORM_OS = OS.OTHER;
		}
		String arch = OS_ARCH.toLowerCase();
		if (isWindows()) {
			String winArch = System.getenv("PROCESSOR_ARCHITECTURE");
			String winWArch = System.getenv("PROCESSOR_ARCHITEW6432");
			IS_64_BIT = (winArch != null && winArch.endsWith("64")) ||
					(winWArch != null && winWArch.endsWith("64")); 
		} else {
			IS_64_BIT = arch.endsWith("64");
		}
	}
	
	/**@STATIC_MODULE_CLASS*/
	private Platform() {}
	
	/**Returns whether or not the {@link OS} is 64 bit.
	 * 
	 * @return Whether or not the user's {@link OS} is 64 bit
	 */
	public static boolean is64Bit() {
		return IS_64_BIT;
	}
	
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
	
	/**Returns whether or not {@link #PLATFORM_OS} equals {@link OS#SOLARIS}.
	 * 
	 * @return Whether or not the user's {@link OS} is Solaris
	 */
	public static boolean isSolaris() {
		return PLATFORM_OS == OS.SOLARIS;
	}
	
	/**Returns whether or not the {@link OS} is of type {@link OS#UNIX}.
	 * 
	 * @return Whether or not the user's {@link OS} is Unix
	 */
	public static boolean isUnix() {
		return PLATFORM_OS == OS.UNIX || isLinux() || isMac() || isSolaris();
	}
	
	/**The possible OS<br><br>
	 * {@link #LINUX}<br>
	 * {@link #MAC}<br>
	 * {@link #WINDOWS}<br>
	 * {@link #SOLARIS}<br>
	 * {@link #UNIX}<br>
	 * {@link #OTHER}
	 */
	public static enum OS {
		LINUX,
		MAC,
		WINDOWS,
		SOLARIS,
		UNIX,
		OTHER;
	}
}
