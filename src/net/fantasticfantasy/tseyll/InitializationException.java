package net.fantasticfantasy.tseyll;

/**The <code>InitializationException</code> class represents any
 * error that could have happened during the initialization.
 */
public class InitializationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**Constructs a {@link InitializationException} with the specified
	 * error message.
	 */
	public InitializationException(String message) {
		super(message);
	}
	
	/**Constructs a {@link InitializationException} with the specified
	 * cause and error message.
	 */
	public InitializationException(Throwable cause, String message) {
		super(message, cause);
	}
	
	/**Constructs a {@link InitializationException} with the specified
	 * cause.
	 */
	public InitializationException(Throwable cause) {
		super(cause);
	}
}
