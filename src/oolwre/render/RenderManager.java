package oolwre.render;

import org.lwjgl.opengl.GL;

public class RenderManager {
	
	/**@STATIC_MODULE_CLASS*/
	private RenderManager() {}
	
	public static void init() {
		GL.createCapabilities();
	}
}
