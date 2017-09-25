package oolwre;

import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;

public class CapabilityProvider {
	
	private static Map<Thread, CapabilityProvider> threads;
	
	static {
		threads = new HashMap<>();
	}
	
	private GLCapabilities caps;
	private Thread thread;
	
	private boolean[] openGL;
	
	private CapabilityProvider(GLCapabilities caps, Thread thread) {
		this.caps = caps;
		this.thread = thread;
		threads.put(thread, this);
	}
	
	public GLCapabilities getCapabilities() {
		return this.caps;
	}
	
	public boolean isOpenGLVersionSupported(int version) {
		if (version < 10 || version >= this.openGL.length) {
			throw new IllegalArgumentException("version (" + version + ") < 10 || >= " + this.openGL.length);
		}
		return this.openGL[version];
	}
	
	public void destroy() {
		threads.remove(this.thread);
	}
	
	public static CapabilityProvider get(Thread thread) {
		return threads.get(thread);
	}
	
	public static CapabilityProvider get() {
		return threads.get(Thread.currentThread());
	}
	
	public static CapabilityProvider create(boolean forwardCompat) {
		Thread thread = Thread.currentThread();
		if (threads.containsKey(thread)) {
			return threads.get(thread);
		}
		GLCapabilities caps = GL.createCapabilities(forwardCompat);
		boolean[] openGL = new boolean[46];
		try {
			openGL[11] = caps.OpenGL11;
			openGL[12] = caps.OpenGL12;
			openGL[13] = caps.OpenGL13;
			openGL[14] = caps.OpenGL14;
			openGL[15] = caps.OpenGL15;
			openGL[20] = caps.OpenGL20;
			openGL[21] = caps.OpenGL21;
			openGL[30] = caps.OpenGL30;
			openGL[31] = caps.OpenGL31;
			openGL[32] = caps.OpenGL32;
			openGL[33] = caps.OpenGL33;
			openGL[40] = caps.OpenGL40;
			openGL[41] = caps.OpenGL41;
			openGL[42] = caps.OpenGL42;
			openGL[43] = caps.OpenGL43;
			openGL[44] = caps.OpenGL44;
			openGL[45] = caps.OpenGL45;
		} catch (NoSuchFieldError e) {
			//Used if user has a lower LWJGL that does not have that much fields
		}
		CapabilityProvider provider = new CapabilityProvider(caps, thread);
		provider.openGL = openGL;
		return provider;
	}
}
