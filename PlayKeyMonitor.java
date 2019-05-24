import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayKeyMonitor extends KeyAdapter {

	private boolean settingsMenu = false;
	private boolean Start = false;
	private boolean startMenu = true;
	private boolean scoreMenu = false;
	
	private Window window = new Window();
	private Start_menu menu = new Start_menu();
	private Score_menu score_menu = new Score_menu();

	public void keyPressed(KeyEvent e) {
		
		int index = e.getKeyCode();
		// press N to enter the game
		if (index == e.VK_N && startMenu) {
			scoreMenu = false;
			startMenu = false;
			Start = true;
		}

		// press H to view score list
		if (index == e.VK_H && startMenu) {
			scoreMenu = true;
			startMenu = false;
		}

		// press C to the sittings
		if (index == e.VK_C && startMenu) {
			settingsMenu = true;
			startMenu = false;
		}

		// press M to return the start menu
		if (index == e.VK_M && (scoreMenu || settingsMenu)) {
			settingsMenu = false;
			scoreMenu = false;
			startMenu = true;
		}
		if (index == e.VK_M && Start) {
			Start = false;
			startMenu = true;
		}
	}
	
	public void changeInterface() {
		if (isStartMenu() ) {
			window.setVisible(true);
		}
	}

	public boolean isStart() {
		return Start;
	}

	public boolean isStartMenu() {
		return startMenu;
	}

	public boolean isScoreMenu() {
		return scoreMenu;
	}

	public boolean isStartInfoMenu() {
		return settingsMenu;
	}

}
