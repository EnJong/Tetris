package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WindowLayoutDatabase extends WindowLayout {
	
	
//	private static String DRIVER;
//	
//	private static String DB_URI;
//	
//	private static String USER;
//	
//	private static String DB_PWD;
	
	public WindowLayoutDatabase(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}
	
	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
		g.drawImage(IMG_GLOBALRAND, 75, 50, null);
		g.setColor(Color.black);
		g.fillRect(75, 85, 260, 32);
		g.fillRect(75, 130, 260, 32);
		g.fillRect(75, 175, 260, 32);
		g.fillRect(75, 220, 260, 32);
		g.fillRect(75, 265, 260, 32);
		
		//显示排名
		g.setColor(Color.white);
		g.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		g.drawString("鲁迅　　职业玩家　999999999999", 85, 107);
		g.drawString("老舍　　业余玩家　888888888888", 85, 152);
		g.drawString("曹雪芹　职业玩家　777777777777", 85, 197);
		g.drawString("朱自清　业余玩家　666666666666", 85, 245);
		g.drawString("钱学森　业余玩家　555555555555", 85, 287);
		
	}
}
