package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WindowLayoutLocalRecord extends WindowLayout {
	
	private static Image IMG_RECORD = new ImageIcon("Graphics/game/localrecord.png").getImage();
	protected WindowLayoutLocalRecord(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
	}
	
	public void paint(Graphics g) {
		this.creatWindow(g);
		g.drawImage(IMG_RECORD, 75, 360, null);
		g.setColor(Color.black);
		g.fillRect(75, 85 + 310, 260, 32);
		g.fillRect(75, 130 + 310, 260, 32);
		g.fillRect(75, 175 + 310, 260, 32);
		g.fillRect(75, 220 + 310, 260, 32);
		g.fillRect(75, 265 + 310, 260, 32);
		
		//显示排名
		g.setColor(Color.white);
		g.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		g.drawString("鲁迅　　老手　　　      999999", 85, 107 + 310);
		g.drawString("老舍　　业余玩家　      888888", 85, 152 + 310);
		g.drawString("曹雪芹　职业玩家　      777777", 85, 197 + 310);
		g.drawString("朱自清　业余玩家　      666666", 85, 245 + 310);
		g.drawString("钱学森　菜鸟　　　      555555", 85, 287 + 310);
	}

}
