package ui;

import java.awt.Graphics;

public class WindowLayoutLicense extends WindowLayout {

	public WindowLayoutLicense(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}

	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
		g.drawImage(IMG_ACCOUNT, 828, 328+165, null);
		g.drawImage(IMG_ACCOUNTSCORE, 828, 328+210, null);
	}

}
