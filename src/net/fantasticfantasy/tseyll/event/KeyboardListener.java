package net.fantasticfantasy.tseyll.event;

public interface KeyboardListener {
	
	void keyPressed(int key, int scancode, int mods);
	
	void keyReleased(int key, int scancode, int mods);
	
	void keyRepeat(int key, int scancode, int mods);
}
