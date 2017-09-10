package net.fantasticfantasy.tseyll.event;

import org.lwjgl.glfw.GLFWMouseButtonCallback;
import net.fantasticfantasy.tseyll.Window;

/**A <code>MouseButtonListener</code> is used to call
 * methods on the time a mouse event is triggered.<br>
 * <b>See</b> {@link GLFWMouseButtonCallback}
 */
public interface MouseButtonListener {

	/**Called by all the owner {@link Window}s when any
	 * mouse press event is triggered.<br>
	 * <b>See</b> {@link GLFWMouseButtonCallback}
	 * 
	 * @param key - The key code
	 * @param scancode - The scancode
	 * @param mods - The modifiers
	 */
	void mousePressed(int button, int mods);

	/**Called by all the owner {@link Window}s when any
	 * mouse release event is triggered.<br>
	 * <b>See</b> {@link GLFWMouseButtonCallback}
	 * 
	 * @param key - The key code
	 * @param scancode - The scancode
	 * @param mods - The modifiers
	 */
	void mouseReleased(int button, int mods);
}
