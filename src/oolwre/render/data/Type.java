package oolwre.render.data;

import org.lwjgl.opengl.GL11;

public enum Type {
	
	BYTE(GL11.GL_BYTE),
	UNSIGNED_BYTE(GL11.GL_UNSIGNED_BYTE),
	SHORT(GL11.GL_SHORT),
	UNSIGNED_SHORT(GL11.GL_UNSIGNED_SHORT),
	INT(GL11.GL_INT),
	UNSIGNED_INT(GL11.GL_UNSIGNED_INT),
	FLOAT(GL11.GL_FLOAT),
	DOUBLE(GL11.GL_DOUBLE);
	
	private int value;
	
	Type(int value) {
		this.value = value;
	}
	
	public int glValue() {
		return this.value;
	}
	
	public static Type forGlValue(int val) {
		for (Type type : values()) {
			if (type.value == val) {
				return type;
			}
		}
		return null;
	}
}
