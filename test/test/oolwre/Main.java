/*Copyright (c) 2017 Fantastic Fantasy All rights reserved.
 *
 * Permission to use, copy and/or modify is hereby granted, free of charge,
 * subject to the following conditions:
 *
 * - Redistribution of source code shall include the above copyright notice,
 *  this list of conditions and the following disclaimer.
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
package test.oolwre;

import java.io.IOException;
import java.io.InputStream;

import net.fantasticfantasy.oolwre.CapabilityProvider;
import net.fantasticfantasy.oolwre.ExceptionQueue;
import net.fantasticfantasy.oolwre.Monitor;
import net.fantasticfantasy.oolwre.OOLWRE;
import net.fantasticfantasy.oolwre.OOLWREException;
import net.fantasticfantasy.oolwre.Platform;
import net.fantasticfantasy.oolwre.Window;
import net.fantasticfantasy.oolwre.WindowEventsHandler;
import net.fantasticfantasy.oolwre.WindowHints;
import net.fantasticfantasy.oolwre.WindowIcon;
import net.fantasticfantasy.oolwre.event.KeyboardListener;
import net.fantasticfantasy.oolwre.image.Image;
import net.fantasticfantasy.oolwre.io.ImageIO;
import net.fantasticfantasy.oolwre.render.data.DataProvider;

public class Main {
	
	public static void main(String[] args) {
		//Print Platform info
		System.out.println(Platform.PLATFORM_OS);
		System.out.println("\t" + Platform.OS_NAME);
		System.out.println("\t" + Platform.OS_ARCH);
		
		//Print OOLWRE details
		System.out.println("OOLWRE " + OOLWRE.getVersionString());
		for (String attrib : OOLWRE.getDetailsOfLibraries()) {
			System.out.println("\t" + attrib);
		}
		
		//Initialize OOLWRE
		try {
			OOLWRE.init();
		} catch (OOLWREException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		//Create the Window
		Monitor monitor = Monitor.NULL;
		WindowHints hints = new WindowHints();
		hints.resizable = WindowHints.Boolean.FALSE;
		hints.autoIconify = WindowHints.Boolean.TRUE;
		hints.visible = WindowHints.Boolean.FALSE;
		Window window = new Window(hints, monitor);
		window.setTitle("OOLWRE Test Window");
		window.setBounds(300, 80, 800, 600);
		window.setVisible(true);
		window.makeContextCurrent();
		window.swapInterval(1);
		
		//Create the WindowIcon
		WindowIcon icon;
		try {
			InputStream in16 = createInputStream("icon16.png");
			InputStream in32 = createInputStream("icon32.png");
			Image ico16 = ImageIO.readImage(in16, 2048);
			Image ico32 = ImageIO.readImage(in32, 4096);
			icon = new WindowIcon(ico16, ico32);
		} catch (IOException ioe) {
			icon = null;
			ioe.printStackTrace();
			System.exit(-1);
		}
		window.setIcon(icon);
		
		//Create event handlers
		WindowEventsHandler eventHandler = window.getEventsHandler();
		eventHandler.addKeyboardListener(keyListener());
		
		//Create the CapabilityProvider
		CapabilityProvider provider = CapabilityProvider.create(true);
		DataProvider dataProvider = new DataProvider(provider);
		dataProvider.link();
		
		//Main game loop
		while (!window.shouldClose()) {
			try {
				ExceptionQueue.poll();
			} catch (OOLWREException e) {
				e.printStackTrace();
				break;
			}
			window.pollEvents();
			window.swapBuffers();
		}
		
		//Terminate OOLWRE
		provider.destroy();
		window.destroy();
		OOLWRE.terminate();
		System.out.println("Closing successfully!");
	}
	
	/**Creates the KeyboardListener*/
	public static KeyboardListener keyListener() {
		return new KeyboardListener() {
			
			public void keyRepeat(int key, int scancode, int mods) {
				System.out.println("Repeated " + KeyboardListener.Key.forGlfwValue(key));
			}
			
			public void keyReleased(int key, int scancode, int mods) {
				System.out.println("Released " + KeyboardListener.Key.forGlfwValue(key));
			}
			
			public void keyPressed(int key, int scancode, int mods) {
				System.out.println("Pressed " + KeyboardListener.Key.forGlfwValue(key));
			}
		};
	}
	
	/**Creates an InputStream with the specified source*/
	public static InputStream createInputStream(String src) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(src);
	}
}
