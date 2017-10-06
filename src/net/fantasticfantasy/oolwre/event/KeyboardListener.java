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
package net.fantasticfantasy.oolwre.event;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import net.fantasticfantasy.oolwre.Window;

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
	
	/**Enumeration of the keys.<br><br>
	 * {@link #KEY_UNKNOWN UNKNOWN}<br><br>
	 * {@link #KEY_SPACE SPACE}<br>
	 * {@link #KEY_APOSTROPHE APOSTROPHE}<br>
	 * {@link #KEY_COMMA COMMA}<br>
	 * {@link #KEY_MINUS MINUS}<br>
	 * {@link #KEY_PERIOD PERIOD}<br>
	 * {@link #KEY_SLASH SLASH}<br><br>
	 * Numbers:
	 * {@link #KEY_0 0}
	 * {@link #KEY_1 1}
	 * {@link #KEY_2 2}
	 * {@link #KEY_3 3}
	 * {@link #KEY_4 4}
	 * {@link #KEY_5 5}
	 * {@link #KEY_6 6}
	 * {@link #KEY_7 7}
	 * {@link #KEY_8 8}
	 * {@link #KEY_9 9}<br><br>
	 * {@link #KEY_SEMICOLON}<br>
	 * {@link #KEY_EQUAL}<br><br>
	 * Letters:
	 * {@link #KEY_A A}
	 * {@link #KEY_B B}
	 * {@link #KEY_C C}
	 * {@link #KEY_D D}
	 * {@link #KEY_E E}
	 * {@link #KEY_F F}
	 * {@link #KEY_G G}
	 * {@link #KEY_H H}
	 * {@link #KEY_I I}
	 * {@link #KEY_J J}
	 * {@link #KEY_K K}
	 * {@link #KEY_L L}
	 * {@link #KEY_M M}
	 * {@link #KEY_N N}
	 * {@link #KEY_O O}
	 * {@link #KEY_P P}
	 * {@link #KEY_Q Q}
	 * {@link #KEY_R R}
	 * {@link #KEY_S S}
	 * {@link #KEY_T T}
	 * {@link #KEY_U U}
	 * {@link #KEY_V V}
	 * {@link #KEY_W W}
	 * {@link #KEY_X X}
	 * {@link #KEY_Y Y}
	 * {@link #KEY_Z Z}<br><br>
	 * {@link #KEY_LEFT_BRACKET LEFT_BRACKET}<br>
	 * {@link #KEY_BACKSLASH BACKSLASH}<br>
	 * {@link #KEY_RIGHT_BRACKET RIGHT_BRACKET}<br>
	 * {@link #KEY_GRAVE_ACCENT}<br>
	 * {@link #KEY_WORLD_1 WORLD_1}<br>
	 * {@link #KEY_WORLD_2 WORLD_2}<br>
	 * {@link #KEY_ESCAPE ESCAPE}<br>
	 * {@link #KEY_ENTER ENTER}<br>
	 * {@link #KEY_TAB TAB}<br>
	 * {@link #KEY_BACKSPACE BACKSPACE}<br>
	 * {@link #KEY_INSERT INSERT}<br>
	 * {@link #KEY_DELETE DELETE}<br><br>
	 * Arrow keys:
	 * {@link #KEY_RIGHT RIGHT}
	 * {@link #KEY_LEFT LEFT}
	 * {@link #KEY_DOWN DOWN}
	 * {@link #KEY_UP UP}<br><br>
	 * Page movements:
	 * {@link #KEY_PAGE_UP PAGE_UP}
	 * {@link #KEY_PAGE_DOWN PAGE_DOWN}
	 * {@link #KEY_HOME HOME}
	 * {@link #KEY_END END}<br><br>
	 * Locks:
	 * {@link #KEY_CAPS_LOCK CAPS}
	 * {@link #KEY_SCROLL_LOCK SCROLL}
	 * {@link #KEY_NUM_LOCK NUM}<br><br>
	 * {@link #KEY_PRINT_SCREEN PRINT_SCREEN}<br>
	 * {@link #KEY_PAUSE PAUSE}<br><br>
	 * Function keys:
	 * {@link #KEY_F1 F1}
	 * {@link #KEY_F1 F2}
	 * {@link #KEY_F1 F3}
	 * {@link #KEY_F1 F4}
	 * {@link #KEY_F1 F5}
	 * {@link #KEY_F1 F6}
	 * {@link #KEY_F1 F7}
	 * {@link #KEY_F1 F8}
	 * {@link #KEY_F1 F9}
	 * {@link #KEY_F1 F10}
	 * {@link #KEY_F1 F11}
	 * {@link #KEY_F1 F12}
	 * {@link #KEY_F1 F13}
	 * {@link #KEY_F1 F14}
	 * {@link #KEY_F1 F15}
	 * {@link #KEY_F1 F16}
	 * {@link #KEY_F1 F17}
	 * {@link #KEY_F1 F18}
	 * {@link #KEY_F1 F19}
	 * {@link #KEY_F1 F20}
	 * {@link #KEY_F1 F21}
	 * {@link #KEY_F1 F22}
	 * {@link #KEY_F1 F23}
	 * {@link #KEY_F1 F24}
	 * {@link #KEY_F1 F25}<br><br>
	 * Keypad:
	 * {@link #KEY_KP_0 0}
	 * {@link #KEY_KP_1 1}
	 * {@link #KEY_KP_2 2}
	 * {@link #KEY_KP_3 3}
	 * {@link #KEY_KP_4 4}
	 * {@link #KEY_KP_5 5}
	 * {@link #KEY_KP_6 6}
	 * {@link #KEY_KP_7 7}
	 * {@link #KEY_KP_8 8}
	 * {@link #KEY_KP_9 9}
	 * {@link #KEY_KP_DOT .}
	 * {@link #KEY_KP_DIV /}
	 * {@link #KEY_KP_MUL *}
	 * {@link #KEY_KP_SUB -}
	 * {@link #KEY_KP_ADD +}
	 * {@link #KEY_KP_ENTER ENTER}<br><br>
	 * Modifiers:<br>
	 * {@link #KEY_LEFT_SHIFT LEFT_SHIFT}<br>
	 * {@link #KEY_LEFT_CONTROL LEFT_CONTROL}<br>
	 * {@link #KEY_LEFT_ALT LEFT_ALT}<br>
	 * {@link #KEY_LEFT_SUPER LEFT_SUPER}<br>
	 * {@link #KEY_RIGHT_SHIFT RIGHT_SHIFT}<br>
	 * {@link #KEY_RIGHT_CONTROL RIGHT_CONTROL}<br>
	 * {@link #KEY_RIGHT_ALT RIGHT_ALT}<br>
	 * {@link #KEY_RIGHT_SUPER RIGHT_SUPER}<br><br>
	 * {@link #KEY_MENU MENU}
	 */
	public static enum Key {
		KEY_UNKNOWN(GLFW.GLFW_KEY_UNKNOWN),
		KEY_SPACE(GLFW.GLFW_KEY_SPACE),
		KEY_APOSTROPHE(GLFW.GLFW_KEY_APOSTROPHE),
		KEY_COMMA(GLFW.GLFW_KEY_COMMA),
		KEY_MINUS(GLFW.GLFW_KEY_MINUS),
		KEY_PERIOD(GLFW.GLFW_KEY_PERIOD),
		KEY_SLASH(GLFW.GLFW_KEY_SLASH),
		KEY_0(GLFW.GLFW_KEY_0),
		KEY_1(GLFW.GLFW_KEY_1),
		KEY_2(GLFW.GLFW_KEY_2),
		KEY_3(GLFW.GLFW_KEY_3),
		KEY_4(GLFW.GLFW_KEY_4),
		KEY_5(GLFW.GLFW_KEY_5),
		KEY_6(GLFW.GLFW_KEY_6),
		KEY_7(GLFW.GLFW_KEY_7),
		KEY_8(GLFW.GLFW_KEY_8),
		KEY_9(GLFW.GLFW_KEY_9),
		KEY_SEMICOLON(GLFW.GLFW_KEY_SEMICOLON),
		KEY_EQUAL(GLFW.GLFW_KEY_EQUAL),
		KEY_A(GLFW.GLFW_KEY_A),
		KEY_B(GLFW.GLFW_KEY_B),
		KEY_C(GLFW.GLFW_KEY_C),
		KEY_D(GLFW.GLFW_KEY_D),
		KEY_E(GLFW.GLFW_KEY_E),
		KEY_F(GLFW.GLFW_KEY_F),
		KEY_G(GLFW.GLFW_KEY_G),
		KEY_H(GLFW.GLFW_KEY_H),
		KEY_I(GLFW.GLFW_KEY_I),
		KEY_J(GLFW.GLFW_KEY_J),
		KEY_K(GLFW.GLFW_KEY_K),
		KEY_L(GLFW.GLFW_KEY_L),
		KEY_M(GLFW.GLFW_KEY_M),
		KEY_N(GLFW.GLFW_KEY_N),
		KEY_O(GLFW.GLFW_KEY_O),
		KEY_P(GLFW.GLFW_KEY_P),
		KEY_Q(GLFW.GLFW_KEY_Q),
		KEY_R(GLFW.GLFW_KEY_R),
		KEY_S(GLFW.GLFW_KEY_S),
		KEY_T(GLFW.GLFW_KEY_T),
		KEY_U(GLFW.GLFW_KEY_U),
		KEY_V(GLFW.GLFW_KEY_V),
		KEY_W(GLFW.GLFW_KEY_W),
		KEY_X(GLFW.GLFW_KEY_X),
		KEY_Y(GLFW.GLFW_KEY_Y),
		KEY_Z(GLFW.GLFW_KEY_Z),
		KEY_LEFT_BRACKET(GLFW.GLFW_KEY_LEFT_BRACKET),
		KEY_BACKSLASH(GLFW.GLFW_KEY_BACKSLASH),
		KEY_RIGHT_BRACKET(GLFW.GLFW_KEY_RIGHT_BRACKET),
		KEY_GRAVE_ACCENT(GLFW.GLFW_KEY_GRAVE_ACCENT),
		KEY_WORLD_1(GLFW.GLFW_KEY_WORLD_1),
		KEY_WORLD_2(GLFW.GLFW_KEY_WORLD_2),
		KEY_ESCAPE(GLFW.GLFW_KEY_ESCAPE),
		KEY_ENTER(GLFW.GLFW_KEY_ENTER),
		KEY_TAB(GLFW.GLFW_KEY_TAB),
		KEY_BACKSPACE(GLFW.GLFW_KEY_BACKSPACE),
		KEY_INSERT(GLFW.GLFW_KEY_INSERT),
		KEY_DELETE(GLFW.GLFW_KEY_DELETE),
		KEY_RIGHT(GLFW.GLFW_KEY_RIGHT),
		KEY_LEFT(GLFW.GLFW_KEY_LEFT),
		KEY_DOWN(GLFW.GLFW_KEY_DOWN),
		KEY_UP(GLFW.GLFW_KEY_UP),
		KEY_PAGE_UP(GLFW.GLFW_KEY_PAGE_UP),
		KEY_PAGE_DOWN(GLFW.GLFW_KEY_PAGE_DOWN),
		KEY_HOME(GLFW.GLFW_KEY_HOME),
		KEY_END(GLFW.GLFW_KEY_END),
		KEY_CAPS_LOCK(GLFW.GLFW_KEY_CAPS_LOCK),
		KEY_SCROLL_LOCK(GLFW.GLFW_KEY_SCROLL_LOCK),
		KEY_NUM_LOCK(GLFW.GLFW_KEY_NUM_LOCK),
		KEY_PRINT_SCREEN(GLFW.GLFW_KEY_PRINT_SCREEN),
		KEY_PAUSE(GLFW.GLFW_KEY_PAUSE),
		KEY_F1(GLFW.GLFW_KEY_F1),
		KEY_F2(GLFW.GLFW_KEY_F2),
		KEY_F3(GLFW.GLFW_KEY_F3),
		KEY_F4(GLFW.GLFW_KEY_F4),
		KEY_F5(GLFW.GLFW_KEY_F5),
		KEY_F6(GLFW.GLFW_KEY_F6),
		KEY_F7(GLFW.GLFW_KEY_F7),
		KEY_F8(GLFW.GLFW_KEY_F8),
		KEY_F9(GLFW.GLFW_KEY_F9),
		KEY_F10(GLFW.GLFW_KEY_F10),
		KEY_F11(GLFW.GLFW_KEY_F11),
		KEY_F12(GLFW.GLFW_KEY_F12),
		KEY_F13(GLFW.GLFW_KEY_F13),
		KEY_F14(GLFW.GLFW_KEY_F14),
		KEY_F15(GLFW.GLFW_KEY_F15),
		KEY_F16(GLFW.GLFW_KEY_F16),
		KEY_F17(GLFW.GLFW_KEY_F17),
		KEY_F18(GLFW.GLFW_KEY_F18),
		KEY_F19(GLFW.GLFW_KEY_F19),
		KEY_F20(GLFW.GLFW_KEY_F20),
		KEY_F21(GLFW.GLFW_KEY_F21),
		KEY_F22(GLFW.GLFW_KEY_F22),
		KEY_F23(GLFW.GLFW_KEY_F23),
		KEY_F24(GLFW.GLFW_KEY_F24),
		KEY_F25(GLFW.GLFW_KEY_F25),
		KEY_KP_0(GLFW.GLFW_KEY_KP_0),
		KEY_KP_1(GLFW.GLFW_KEY_KP_1),
		KEY_KP_2(GLFW.GLFW_KEY_KP_2),
		KEY_KP_3(GLFW.GLFW_KEY_KP_3),
		KEY_KP_4(GLFW.GLFW_KEY_KP_4),
		KEY_KP_5(GLFW.GLFW_KEY_KP_5),
		KEY_KP_6(GLFW.GLFW_KEY_KP_6),
		KEY_KP_7(GLFW.GLFW_KEY_KP_7),
		KEY_KP_8(GLFW.GLFW_KEY_KP_8),
		KEY_KP_9(GLFW.GLFW_KEY_KP_9),
		KEY_KP_DOT(GLFW.GLFW_KEY_KP_DECIMAL),
		KEY_KP_DIV(GLFW.GLFW_KEY_KP_DIVIDE),
		KEY_KP_MUL(GLFW.GLFW_KEY_KP_MULTIPLY),
		KEY_KP_SUB(GLFW.GLFW_KEY_KP_SUBTRACT),
		KEY_KP_ADD(GLFW.GLFW_KEY_KP_ADD),
		KEY_KP_ENTER(GLFW.GLFW_KEY_KP_ENTER),
		KEY_LEFT_SHIFT(GLFW.GLFW_KEY_LEFT_SHIFT),
		KEY_LEFT_CONTROL(GLFW.GLFW_KEY_LEFT_CONTROL),
		KEY_LEFT_ALT(GLFW.GLFW_KEY_LEFT_ALT),
		KEY_LEFT_SUPER(GLFW.GLFW_KEY_LEFT_SUPER),
		KEY_RIGHT_SHIFT(GLFW.GLFW_KEY_RIGHT_SHIFT),
		KEY_RIGHT_CONTROL(GLFW.GLFW_KEY_RIGHT_CONTROL),
		KEY_RIGHT_ALT(GLFW.GLFW_KEY_RIGHT_ALT),
		KEY_RIGHT_SUPER(GLFW.GLFW_KEY_RIGHT_SUPER),
		KEY_LAST(GLFW.GLFW_KEY_LAST),
		KEY_MENU(GLFW.GLFW_KEY_MENU),;
		
		private int value;
		
		Key(int value) {
			this.value = value;
		}
		
		/**Returns the {@link GLFW} value represented by the {@link KeyboardListener}.
		 */
		public int glfwValue() {
			return this.value;
		}
		
		/**Returns the {@link KeyboardListener} represented by the {@link GLFW} value.
		 * 
		 * @param val - The {@link GLFW} value
		 */
		public static Key forGlfwValue(int val) {
			for (Key key : values()) {
				if (key.value == val) {
					return key;
				}
			}
			return null;
		}
	}
}
