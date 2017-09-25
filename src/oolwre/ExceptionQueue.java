package oolwre;

import java.util.ArrayDeque;
import java.util.Queue;

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
