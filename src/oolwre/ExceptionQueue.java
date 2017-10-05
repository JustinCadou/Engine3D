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

import java.util.ArrayDeque;
import java.util.Queue;

/**The <code>ExceptionQueue</code> is used to post and poll {@link Throwable}s.
 */
public class ExceptionQueue {
	
	private static Queue<OOLWREException> queue;
	
	static {
		queue = new ArrayDeque<>();
	}
	
	/**Throws and remove the next element from the {@link ExceptionQueue},
	 * if any.
	 * 
	 * @throws OOLWREException
	 */
	public static void poll() throws OOLWREException {
		if (!queue.isEmpty()) {
			throw queue.poll();
		}
	}
	
	/**Returns and removes the next element from the {@link ExceptionQueue}.
	 */
	public static OOLWREException get() {
		return queue.poll();
	}
	
	/**Returns the next element from the {@link ExceptionQueue}, without
	 * actually removing it.
	 */
	public static OOLWREException peek() {
		return queue.peek();
	}
	
	/**Posts <code>t</code> to the {@link ExceptionQueue} with the specified
	 * <code>message</code>.
	 * 
	 * @param t - The {@link Throwable} to be posted
	 * @param message - The error message
	 */
	public static void post(Throwable t, String message) {
		queue.offer(new OOLWREException(message, t));
	}
	
	/**Posts <code>t</code> to the {@link ExceptionQueue}.
	 * 
	 * @param t - The {@link Throwable} to be posted
	 */
	public static void post(Throwable t) {
		queue.offer(new OOLWREException(t.getMessage(), t));
	}
	
	/**Returns the number of element in the {@link ExceptionQueue}.
	 */
	public static int count() {
		return queue.size();
	}
	
	/**Returns whether or not the {@link ExceptionQueue} is empty.
	 */
	public static boolean isEmpty() {
		return queue.isEmpty();
	}
}
