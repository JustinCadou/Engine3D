package oolwre.event;

import org.lwjgl.glfw.GLFWKeyCallback;

import oolwre.Window;

/**A <code>KeyboardListener</code> is used to call
 * methods on the time a key event is triggered.<br>
	 * <b>See</b> {@link GLFWKeyCallback}
 */
public interface KeyboardListener {
	
	/**Called by all the owner {@link Window}s when any
	 * key press event is triggered.<br>
	 * <b>See</b> {@link GLFWKeyCallback}
	 * 
	 * @param key - The key code
	 * @param scancode - The scancode
	 * @param mods - The modifiers
	 */
	void keyPressed(int key, int scancode, int mods);

	/**Called by all the owner {@link Window}s when any
	 * key release event is triggered.<br>
	 * <b>See</b> {@link GLFWKeyCallback}
	 * 
	 * @param key - The key code
	 * @param scancode - The scancode
	 * @param mods - The modifiers
	 */
	void keyReleased(int key, int scancode, int mods);

	/**Called by all the owner {@link Window}s when any
	 * key repeat event is triggered.<br>
	 * <b>See</b> {@link GLFWKeyCallback}
	 * 
	 * @param key - The key code
	 * @param scancode - The scancode
	 * @param mods - The modifiers
	 */
	void keyRepeat(int key, int scancode, int mods);
}
