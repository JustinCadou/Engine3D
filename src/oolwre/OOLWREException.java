package oolwre;

public class OOLWREException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public final Thread thread;
	
	public OOLWREException(String message, Throwable cause) {
		super(message);
		if (cause != null) {
			super.initCause(cause);
		}
		this.thread = Thread.currentThread();
	}
}
