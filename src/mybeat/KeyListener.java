package mybeat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (StartGames.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			StartGames.game.pressS();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			StartGames.game.pressD();
		}
		else if (e.getKeyCode() == KeyEvent.VK_F) {
			StartGames.game.pressF();
		}
		else if (e.getKeyCode() == KeyEvent.VK_G) {
			StartGames.game.pressG();
		}
		else if (e.getKeyCode() == KeyEvent.VK_H) {
			StartGames.game.pressH();
		}
		else if (e.getKeyCode() == KeyEvent.VK_J) {
			StartGames.game.pressJ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_K) {
			StartGames.game.pressK();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (StartGames.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			StartGames.game.releaseS();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D) {
			StartGames.game.releaseD();
		}
		else if (e.getKeyCode() == KeyEvent.VK_F) {
			StartGames.game.releaseF();
		}
		else if (e.getKeyCode() == KeyEvent.VK_G) {
			StartGames.game.releaseG();
		}
		else if (e.getKeyCode() == KeyEvent.VK_H) {
			StartGames.game.releaseH();
		}
		else if (e.getKeyCode() == KeyEvent.VK_J) {
			StartGames.game.releaseJ();
		}
		else if (e.getKeyCode() == KeyEvent.VK_K) {
			StartGames.game.releaseK();
		}
	}
}
