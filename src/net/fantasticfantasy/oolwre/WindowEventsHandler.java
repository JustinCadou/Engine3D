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

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import net.fantasticfantasy.oolwre.event.KeyboardListener;
import net.fantasticfantasy.oolwre.event.MouseButtonListener;
import net.fantasticfantasy.oolwre.event.ScrollListener;

/**The <code>WindowEventsHandler</code> class is used
 * to handle the events from a {@link Window}.<br>
 * Every {@link Window}s have a <code>WindowEventsHandler
 * </code> that can be queried by calling
 * {@link Window#getEventsHandler() getEventsHandler()}.
 */
public final class WindowEventsHandler {
	
	/**The owner {@link Window} of the {@link WindowEventsHandler}*/
	protected Window owner;
	
	private List<KeyboardListener> keys;
	private List<MouseButtonListener> mouses;
	private List<ScrollListener> scrolls;
	
	/**Constructor*/
	protected WindowEventsHandler(Window owner) {
		this.owner = owner;
		GLFW.glfwSetKeyCallback(this.owner.name, new Keyboard(this));
		GLFW.glfwSetMouseButtonCallback(this.owner.name, new Mouse(this));
		GLFW.glfwSetScrollCallback(this.owner.name, new Scroll(this));
		this.keys = new ArrayList<>();
		this.mouses = new ArrayList<>();
		this.scrolls = new ArrayList<>();
	}
	
	/**Adds the specified {@link KeyboardListener} to the
	 * list of key event listeners.
	 * 
	 * @param keyboardListener - The {@link KeyboardListener}
	 */
	public void addKeyboardListener(KeyboardListener keyboardListener) {
		this.keys.add(keyboardListener);
	}
	
	/**Adds the specified {@link MouseButtonListener} to the
	 * list of mouse event listeners.
	 * 
	 * @param mouseButtonListener - The {@link MouseButtonListener}
	 */
	public void addMouseButtonListener(MouseButtonListener mouseButtonListener) {
		this.mouses.add(mouseButtonListener);
	}
	
	/**Adds the specified {@link ScrollListener} to the
	 * list of scroll event listeners.
	 * 
	 * @param scrollListener - The {@link ScrollListener}
	 */
	public void addScrollListener(ScrollListener scrollListener) {
		this.scrolls.add(scrollListener);
	}
	
	/**Removes the specified {@link KeyboardListener} to the
	 * list of key event listeners.
	 * 
	 * @param keyboardListener - The {@link KeyboardListener}
	 */
	public void removeKeyboardListener(KeyboardListener keyboardListener) {
		this.keys.remove(keyboardListener);
	}
	
	/**Removes the specified {@link MouseButtonListener} to the
	 * list of mouse event listeners.
	 * 
	 * @param mouseButtonListener - The {@link MouseButtonListener}
	 */
	public void removeMouseButtonListener(MouseButtonListener mouseButtonListener) {
		this.mouses.remove(mouseButtonListener);
	}
	
	/**Removes the specified {@link MouseButtonListener} to the
	 * list of mouse event listeners.
	 * 
	 * @param mouseButtonListener - The {@link MouseButtonListener}
	 */
	public void removeScrollListener(ScrollListener scrollListener) {
		this.scrolls.remove(scrollListener);
	}
	
	private static class Keyboard extends GLFWKeyCallback {
		
		private WindowEventsHandler owner;
		
		private Keyboard(WindowEventsHandler owner) {
			this.owner = owner;
		}
		
		public void invoke(long window, int key, int scancode, int action, int mods) {
			for (int i = 0; i < this.owner.keys.size(); i++) {
				KeyboardListener listener = this.owner.keys.get(i);
				if (action == GLFW.GLFW_PRESS) {
					listener.keyPressed(key, scancode, mods);
				} else if (action == GLFW.GLFW_RELEASE) {
					listener.keyReleased(key, scancode, mods);
				} else if (action == GLFW.GLFW_REPEAT) {
					listener.keyRepeat(key, scancode, mods);
				}
			}
		}
	}
	
	private static class Mouse extends GLFWMouseButtonCallback {
		
		private WindowEventsHandler owner;
		
		private Mouse(WindowEventsHandler owner) {
			this.owner = owner;
		}
		
		public void invoke(long window, int button, int action, int mods) {
			for (int i = 0; i < this.owner.mouses.size(); i++) {
				MouseButtonListener listener = this.owner.mouses.get(i);
				if (action == GLFW.GLFW_PRESS) {
					listener.mousePressed(button, mods);
				} else if (action == GLFW.GLFW_RELEASE) {
					listener.mouseReleased(button, mods);
				}
			}
		}
	}
	
	private static class Scroll extends GLFWScrollCallback {
		
		private WindowEventsHandler owner;
		
		private Scroll(WindowEventsHandler owner) {
			this.owner = owner;
		}
		
		public void invoke(long window, double dx, double dy) {
			for (int i = 0; i < this.owner.scrolls.size(); i++) {
				ScrollListener listener = this.owner.scrolls.get(i);
				listener.scrollMoved(dx, dy);
			}
		}
	}
}
