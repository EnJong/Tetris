package ui;

import java.awt.Graphics;


public class WindowLayoutStart extends WindowLayout {

	
	protected WindowLayoutStart(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}

	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
//		g.drawImage(IMG_START, axisX+50, axisY+32, null);
//		g.drawImage(IMG_PAUSE, axisX+150, axisY+32, null);	

	}

}
