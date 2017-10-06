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
package net.fantasticfantasy.oolwre.math;

import net.fantasticfantasy.oolwre.OOLWRE;

/**The <code>OOLWREMath</code> class contains all the mathematics
 * specific to the {@link OOLWRE} library.
 */
public final class OOLWREMath {
	
	/**@STATIC_MODULE_CLASS*/
	private OOLWREMath() {}
	
	/**Clamps <code>val</code> between <code>min</code> and <code>max</code>.
	 * 
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param val The value to be clamped
	 * 
	 * @return The result
	 */
	public static double clamp(double min, double max, double val) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
	
	/**Clamps <code>val</code> between <code>min</code> and <code>max</code>.
	 * 
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param val The value to be clamped
	 * 
	 * @return The result
	 */
	public static float clamp(float min, float max, float val) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
	
	/**Clamps <code>val</code> between <code>min</code> and <code>max</code>.
	 * 
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param val The value to be clamped
	 * 
	 * @return The result
	 */
	public static long clamp(long min, long max, long val) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
	
	/**Clamps <code>val</code> between <code>min</code> and <code>max</code>.
	 * 
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param val The value to be clamped
	 * 
	 * @return The result
	 */
	public static int clamp(int min, int max, int val) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
	
	/**Clamps <code>val</code> between <code>min</code> and <code>max</code>.
	 * 
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param val The value to be clamped
	 * 
	 * @return The result
	 */
	public static short clamp(short min, short max, short val) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
	
	/**Clamps <code>val</code> between <code>min</code> and <code>max</code>.
	 * 
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param val The value to be clamped
	 * 
	 * @return The result
	 */
	public static byte clamp(byte min, byte max, byte val) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
}
