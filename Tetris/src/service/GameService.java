package service;

import java.awt.Point;
import java.util.Random;

//import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	private GameDto dto;
	private int NowRemoveLine;
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct(new Random().nextInt(6));
		dto.setGameAct(act);
	}
	
	/**
	 * 控制器方向键(up)
	 */
	public void upMove() {
			
			dto.getGameAct().rotate(dto.getGameMap());
	}

	/**
	 * 控制器方向键(down)
	 */
	public void downMove() {
		if(dto.getGameAct().move(0, 1, this.dto.getGameMap())) return;
		//获得游戏地图对象
		boolean[][] map = dto.getGameMap();
		Point[] act = this.dto.getGameAct().getActPoints();
		int clear[] = new int[map.length];

		for(int i = 0; i < act.length; i++) {
			map[act[i].y][act[i].x] = true;
		}
		//TODO 判断是否可以消行
		for (int mapAxisX = 0; mapAxisX < map.length; mapAxisX++) {
			for(int mapAxisY = 0; mapAxisY < map[mapAxisX].length; mapAxisY ++) {
				if (map[mapAxisX][mapAxisY] == true) {
					clear[mapAxisX] ++;
				}
			}
		}
		//TODO  消行操作
		for(int clearAxisX = 0; clearAxisX < clear.length; clearAxisX++ ) {
			if(clear[clearAxisX] == 10 ) {
				dto.setNowPoint(dto.getNowPoint()+1);
				NowRemoveLine ++;
				for(int mapAxisX = clearAxisX-1; mapAxisX > 0 ; mapAxisX--) {
					map[mapAxisX + 1] = map[mapAxisX];				
				}
				for(int mapAxisY = 0; mapAxisY < map[clearAxisX].length; mapAxisY ++) {
					map[0][mapAxisY] = false;
				}
			}
		}
		dto.setNowRemoveLine(NowRemoveLine);
		NowRemoveLine = 0;
		//算分操作
		//TODO　判断是否可以升级
		//TODO      升级
		//  刷新一个新的方块
//		int random = 0;
//		do{
//			BigDecimal randomNumber = new BigDecimal(Math.random()*1000);
//			random = randomNumber.setScale(0, RoundingMode.HALF_EVEN).intValue()/100;			
//		} while(random > 6);	
		this.dto.getGameAct().init(this.dto.getNext());
		this.dto.setNext(new Random().nextInt(6));
//		System.out.println(random) ;
	}

	/**
	 * 控制器方向键(left)
	 */
	public void leftMove() {
//		if(this.moveComfirm(-1, 0)) {
			this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
//		}
	}

	/**
	 * 控制器方向键(right)
	 */
	public void rightMove() {
//		if(this.moveComfirm(1, 0)) {
			this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
//		}
	}

	/**
	 * 控制器空格键
	 */
	public void gamePause() {
		System.out.println("设置前：" + dto.isPause());
		dto.setPause(true);
		System.out.println("设置后：" + dto.isPause());
		
	}
	public void gameStart() {
		
		Thread gameStartThread = new Thread(new GameStart());
		gameStartThread.start();
		
	}
	class GameStart implements Runnable {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				downMove();	
			}
			
		}
	}
	

}

