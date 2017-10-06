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
package net.fantasticfantasy.oolwre;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;

public class OOLWRE {
	
	public static final long CURRENT_SERIAL_VERSION_UID = 0x1000005L;
	
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
