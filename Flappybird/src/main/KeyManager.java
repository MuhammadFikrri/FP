package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean keyPressed[];
	public boolean jump;
	private Main game;
	
	public KeyManager(Main game) {
		keyPressed = new boolean[256];
		this.game = game;
	}
	
	public void tick() {
		jump = keyPressed[KeyEvent.VK_SPACE];
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() > keyPressed.length || e.getKeyCode() < 0) {
			return;
		}else {
			keyPressed[e.getKeyCode()] = true;
		}
		if(!game.isRunning() && e.getKeyCode() == KeyEvent.VK_SPACE) {	
			game.restart();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() > keyPressed.length || e.getKeyCode() < 0) {
			return;
		}else {
			keyPressed[e.getKeyCode()] = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
