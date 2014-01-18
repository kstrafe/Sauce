// Hvis du f�r errorer, s� m� du legge inn pathene til lwjgl manuelt
// bare klikk p� properties p� prosjektet, java build path, og s� add external libary
// marker s� de tre filene i lib/jars og OK, deretter �pne pilen vedsidena lwjgl.jar og native libary location
// s� edit og velg mappa lib/natives-win

// Dette er ikke final, kun en test s� du kan se hvordan lwjgl settes opp i forhold til den andre metoden
// Selv er jeg usikker p� hvem som er best, du f�r bed�mme, det andre setupet er i sauce, selv fikk jeg det ikke til
// � virke, er det noen bibloteker jeg ikke har?
// Om noe skrewer seg opp, legger jeg dette oppsettet i en annen branch s� det er bare � hoppe over til den forrige :)

// Jeg har fulgt denne tutorialen, virket ganske grei: http://www.youtube.com/watch?v=0v56I5UWrYY

package game;

// Standard import
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.jsfml.graphics.*;
import org.jsfml.window.*;

public class Main
{
	
	public static RenderWindow wnd = new RenderWindow(new VideoMode(800, 600, 32), "Sauce");
	// Constructor
//	public static int screen_width;
//	public static int screen_height;
//	public static String game_title;
	public static states game_state;
	
	public enum states
	{
		menu, tutorial, surface, core, game, scoreboard;
	}
	
	private void init()
	{	
		game_state = states.menu;
	}
	
	private void run()
	{
		
		// Run program until close
		while (wnd.isOpen())
		{
			
			// Initialize and run a state in the game
			switch (game_state)
			{
				case menu:
					Menu menu = new Menu();
					menu.run();
					break;
				case tutorial:
					break;
				case surface:
					break;
				case core:
					break;
				case game:
					break;
				case scoreboard:
					break;
				default:
					return;
			}
		}
	}
	
	private void dispose() {
		// Remove the window
		Display.destroy();
		
		// Exit the system
		System.exit(0);
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.init();
		main.run();
		main.dispose();
	}
}
