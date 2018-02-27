package ui;

import java.awt.Graphics;
import java.awt.Point;

import entity.GameAct;

public class WindowLayoutNextShape extends WindowLayout {

	private static final int RECT_CELL_SIZE = 32;

	public WindowLayoutNextShape(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}

	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
		this.dto.getGameAct();
		Point[] points = GameAct.TYPE_CONFIG.get(this.dto.getNext());
		int offsetX = 0;
		int offsetY = 0;
		
		//打印方块	
		if (this.dto.getNext() == 0) {
			offsetX = 75;
			offsetY = 70;
		} else if (this.dto.getNext() == 4) {
			offsetX = 42;
			offsetY = 55;
		} else {
			offsetX = 58;
			offsetY = 55;
		}
		for (Point point : points) {
			g.drawImage(
					IMG_RECT_SOURCE, 
					this.axisX - offsetX + point.x*RECT_CELL_SIZE, this.axisY + offsetY + point.y*RECT_CELL_SIZE, 
					this.axisX -offsetX + point.x*(RECT_CELL_SIZE) + RECT_CELL_SIZE, this.axisY + offsetY + point.y*RECT_CELL_SIZE + RECT_CELL_SIZE,
					(this.dto.getNext()+1)*RECT_CELL_SIZE, 0, 
					(this.dto.getNext()+1)*RECT_CELL_SIZE + RECT_CELL_SIZE, RECT_CELL_SIZE, 
			null);			
		}
	}

}
