package control;

import dto.GameDto;
import service.GameService;
import ui.JPanelGame;
import ui.cfg.FrameConfig;

/**
 * 接受玩家按键事件
 * 控制画面
 * 控制游戏逻辑
 * 
 * @author enjong
 *
 */
public class GameControl {
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	
	/**
	 * 游戏设置窗口
	 */
	private FrameConfig frameConfig;
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;

	private GameDto dto;
	Thread gameStartThread = new Thread(new GameStart());
	
	public GameControl(JPanelGame jPanelGame, GameService gameService, GameDto dto) {
		this.dto = dto;
		this.panelGame = jPanelGame;
		this.gameService = gameService;
		this.frameConfig = new FrameConfig(this);
	}
	
	/**
	 * 控制器方向键(up)
	 * 
	 * 用线程来控制
	 */
	public void upMove() {
		
		this.gameService.upMove();
		this.panelGame.repaint();
	}

	/**
	 * 控制器方向键(down)
	 */
	public void downMove() {
//		System.out.println("设置前：" + dto.isPause());
//		System.out.println("设置后：" + dto.isPause());
		this.gameService.downMove();
		this.panelGame.repaint();
	}
	
	/**
	 * 控制器方向键(left)
	 */
	public void leftMove() {
		this.gameService.leftMove();;
		this.panelGame.repaint();
	}

	/**
	 * 控制器方向键(right)
	 */
	public void rightMove() {
		this.gameService.rightMove();;
		this.panelGame.repaint();
	}

	/**
	 * 显示窗口对象
	 */
	public void showUserConfig() {
		frameConfig.setVisible(true);
		
	}

	public void setOver() {
//		this.panelGame
		
	}

	public void gamePause() {
		gameService.gamePause();
		
	}

	public void gameStart() {
		gameStartThread.start();	
	}
	
	class GameStart implements Runnable {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					if(dto.isPause()) {
					panelGame.repaint();
					continue;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				downMove();	
			}
			
		}
	}
}
