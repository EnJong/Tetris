package ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class WindowLayoutLevel extends WindowLayout {
	
	private static Image IMG_LEVEL = new ImageIcon("Graphics/game/level.png").getImage();
	public WindowLayoutLevel(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}

	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
		g.drawImage(IMG_LEVEL, 998, 145, null);
	}

}
