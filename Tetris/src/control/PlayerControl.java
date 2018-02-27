package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter{

	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_UP:
			gameControl.upMove();
			break;
		case KeyEvent.VK_DOWN:
			gameControl.downMove();
			break;
		case KeyEvent.VK_LEFT:
			gameControl.leftMove();
			break;
		case KeyEvent.VK_RIGHT:
			gameControl.rightMove();
			break;
		case KeyEvent.VK_SPACE:
			gameControl.gamePause();
		default :
			break;
		}
	}
}
