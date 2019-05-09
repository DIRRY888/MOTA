package Prsentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean battle;
	private boolean start;
	private boolean newGame;
	private boolean undo;
	private boolean exit;
	private boolean menu;
	private boolean pause;
	private boolean about;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			battle = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			battle = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_S) {
			start = true;
		} else if (e.getExtendedKeyCode() == KeyEvent.VK_U) {
			undo = true;
		} else if (e.getExtendedKeyCode() == KeyEvent.VK_X) {
			exit = true;
		} else if (e.getExtendedKeyCode() == KeyEvent.VK_M) {
			menu = true;
		} else if (e.getExtendedKeyCode() == KeyEvent.VK_N) {
			newGame = true;
		} else if (e.getExtendedKeyCode() == KeyEvent.VK_P) {
			pause = true;
		}else if (e.getExtendedKeyCode() == KeyEvent.VK_A) {
			about = true;
		}
	}
	
	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isBattle() {
		return battle;
	}
	
	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isStart() {
		if (start) {
			start = false;
			return true;
		}
		return false;
	}

	public boolean isUndo() {
		if (undo) {
			undo = false;
			return true;
		}
		return false;
	}

	public boolean isExit() {
		if (exit) {
			exit = false;
			return true;
		}
		return false;
	}

	public boolean isMenu() {
		if (menu) {
			menu = false;
			return true;
		}
		return false;
	}

	public boolean isNew() {
		if (newGame) {
			newGame = false;
			return true;
		}
		return false;
	}

	public boolean isPlayPause() {
		if (pause) {
			pause = false;
			return true;
		}
		return false;
	}

	public boolean isAbout() {
		if (about) {
			about = false;
			return true;
		}
		return false;
	}
	
	public void reset() {
		left = false;
		right = false;
		battle = false;
		start = false;
		undo = false;
		exit = false;
		menu = false;
		newGame = false;
	}
}
