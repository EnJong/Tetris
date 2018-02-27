package ui;

import javax.swing.*;

import config.ConfigFactory;
import util.FrameUtil;

public class JFrameGame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JFrameGame(JPanelGame panelGame) {
		//设置标题
		this.setTitle("俄罗斯方块");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(ConfigFactory.getGameConfig().getWidth(), ConfigFactory.getGameConfig().getHeight());
		this.setResizable(false);
		FrameUtil.setFrameCenter(this);
		this.add(panelGame); 
		
		this.setVisible(true);
	}
	public void lanch() {
		
	}
//	public static void main(String[] args){
//		JFrameGame frameGameTest = new JFrameGame();
//		frameGameTest.lanch();
//	}
}
