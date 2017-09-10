package net.fantasticfantasy.tseyll.event;

import org.lwjgl.glfw.GLFWScrollCallback;
import net.fantasticfantasy.tseyll.Window;

/**A <code>ScrollListener</code> is used to call
 * methods on the time a scroll event is triggered.<br>
 * <b>See</b> {@link GLFWScrollCallback}
 */
public interface ScrollListener {
	
	/**Called by all the owner {@link Window}s when any
	 * scroll event is triggered.
	 * 
	 * @param dx - The <code>x</code> movement
	 * @param dy - The <code>y</code> movement
	 */
	public void scrollMoved(double dx, double dy);
}
