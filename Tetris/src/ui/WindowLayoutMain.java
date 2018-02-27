package ui;

import java.awt.Graphics;
import java.awt.Point;


public class WindowLayoutMain extends WindowLayout {
	
	private static int RECT_CELL_SIZE = 32;

	protected WindowLayoutMain(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}

	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
		Point[] points = this.dto.getGameAct().getActPoints();
		//打印方块
		for (Point point : points) {
			g.drawImage(
					IMG_RECT_SOURCE, 
					this.axisX + 22 + point.x*RECT_CELL_SIZE, this.axisY + 20 + point.y*RECT_CELL_SIZE, 
					this.axisX + 22 + point.x*(RECT_CELL_SIZE) + RECT_CELL_SIZE, this.axisY + 20 + point.y*RECT_CELL_SIZE + RECT_CELL_SIZE,
					(this.dto.getGameAct().getActCode()+1)*RECT_CELL_SIZE, 0, 
					(this.dto.getGameAct().getActCode()+1)*RECT_CELL_SIZE + RECT_CELL_SIZE, RECT_CELL_SIZE, 
			null);			
		}
		
		//打印地图
		boolean[][] map = this.dto.getGameMap();
		for (int mapAxisX = 0; mapAxisX < map.length; mapAxisX++) {
			for (int mapAxisY = 0; mapAxisY < map[mapAxisX].length; mapAxisY++) {
				if(map[mapAxisX][mapAxisY]) {
					g.drawImage(
							IMG_RECT_SOURCE, 
							 this.axisX + 22 + mapAxisY*RECT_CELL_SIZE, this.axisY + 20 + mapAxisX*RECT_CELL_SIZE,
							 this.axisX + 22 + mapAxisY*RECT_CELL_SIZE + RECT_CELL_SIZE, this.axisY + 20 + mapAxisX*RECT_CELL_SIZE + RECT_CELL_SIZE,
							RECT_CELL_SIZE*0, 0, 
							RECT_CELL_SIZE*1, RECT_CELL_SIZE,
					null);
				}
			}
		}	
		
		//暂停
		
		if(dto.isPause()) {
			g.drawImage(IMG_PAUSE, 430, 210, null);
		}
	}

}
