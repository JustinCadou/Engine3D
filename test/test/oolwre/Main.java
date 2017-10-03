package test.oolwre;

import oolwre.CapabilityProvider;
import oolwre.ExceptionQueue;
import oolwre.Monitor;
import oolwre.OOLWRE;
import oolwre.OOLWREException;
import oolwre.Platform;
import oolwre.Window;
import oolwre.WindowEventsHandler;
import oolwre.WindowHints;
import oolwre.event.KeyboardListener;
import oolwre.render.data.DataProvider;

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
}