package oolwre.data;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public enum ValueType {
	BYTE(GL11.GL_BYTE),
	UNSIGNED_BYTE(GL11.GL_UNSIGNED_BYTE),
	SHORT(GL11.GL_SHORT),
	UNSIGNED_SHORT(GL11.GL_UNSIGNED_SHORT),
	INT(GL11.GL_INT),
	UNSIGNED_INT(GL11.GL_UNSIGNED_INT),
	HALF_FLOAT(GL30.GL_HALF_FLOAT),
	FLOAT(GL11.GL_FLOAT),
	DOUBLE(GL11.GL_DOUBLE);
	
	private int value;
	
	ValueType(int value) {
		this.value = value;
	}
	
	public int glValue() {
		return this.value;
	}
}
