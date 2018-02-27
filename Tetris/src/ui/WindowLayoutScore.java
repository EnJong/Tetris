package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class WindowLayoutScore extends WindowLayout {
	private static final Image IMG_SCORE = new ImageIcon("Graphics/game/score.png").getImage();
	private static final Image IMG_CLEARLINE = new ImageIcon("Graphics/game/clear.png").getImage();
	private static final Image IMG_NUMBER_SOURCE = new ImageIcon("Graphics/game/number.png").getImage();
	
	private static final int OFFSET = 14;
	private  int NUMBER_OFFSET = 99;

	protected WindowLayoutScore(String windowID, int axisX, int axisY) {
		super(windowID, axisX, axisY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		this.creatWindow(g);
		//显示分数图标
		g.drawImage(IMG_SCORE, axisX + (OFFSET<<1), axisY + (OFFSET<<1), null);
		//显示消行图标
		g.drawImage(IMG_CLEARLINE, axisX + (OFFSET<<1), axisY + (OFFSET*5), null);
		//显示分数
		//得到数字的每个位
		g.setColor(Color.black);
		g.fillRect(
				axisX + (OFFSET<<2)+41, axisY + (OFFSET<<1), 
				159, 32);
		g.setColor(Color.yellow);
		g.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 16));
//		g.drawString(Integer.toString(dto.getNowPoint()*100), axisX + (OFFSET<<2)+43, axisY + (OFFSET<<1)+22);
		this.drawScore(dto.getNowPoint()*100, g, 0);
		//消行数字显示
		g.setColor(Color.black);
		g.fillRect(
				axisX + (OFFSET<<2)+41, axisY + (OFFSET*5), 
				159, 32);
		g.setColor(Color.yellow);
		g.setFont(new Font("Tahoma", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		this.drawScore(dto.getNowRemoveLine(), g, 42);
		
		//槽值
		g.setColor(Color.black);
		g.fillRect(
				axisX + (OFFSET<<1), axisY + (OFFSET*8), 
				axisX + (OFFSET<<2)+200-(axisX + (OFFSET<<1)), 32);
		
	}
	/**
	 * 方法实现的功能：
	 * 		传入一个数字，就把该数字对应的图片显示
	 * 		显示的时候按单个数字显示
	 * 		先取出每一位数字，然后算出该数字在图片中的位置xs,ys,ws,hs，
	 * 		然后计算它该放在的位置　xd,yd,wd,hd.
	 */
	public void drawScore(int score, Graphics g, int NUMBER_YAXIS_OFFSET) {
//		public void drawScore(int score) {
		//得到数字的长度
		char[] numberCharArray = Integer.toString(score).toCharArray();
		Map<Character,Integer[]> numberImagePosition = new HashMap<Character,Integer[]>();
		Map<Integer,Integer[]> numberAxisPosition = new HashMap<Integer,Integer[]>();
		//创建装数字在图片中位置的一个HashMap
		numberImagePosition.put('0', new Integer[]{19*0, 0, 19*1, 32});
		numberImagePosition.put('1', new Integer[]{19*1, 0, 19*2, 32});
		numberImagePosition.put('2', new Integer[]{19*2, 0, 19*3, 32});
		numberImagePosition.put('3', new Integer[]{19*3, 0, 19*4, 32});
		numberImagePosition.put('4', new Integer[]{19*4, 0, 19*5, 32});
		numberImagePosition.put('5', new Integer[]{19*5, 0, 19*6, 32});
		numberImagePosition.put('6', new Integer[]{19*6, 0, 19*7, 32});
		numberImagePosition.put('7', new Integer[]{19*7, 0, 19*8, 32});
		numberImagePosition.put('8', new Integer[]{19*8, 0, 19*9, 32});
		numberImagePosition.put('9', new Integer[]{19*9, 0, 19*10, 32});
		
		//
		numberAxisPosition.put(0, new Integer[]{axisX + NUMBER_OFFSET + 19*0, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*1, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(1, new Integer[]{axisX + NUMBER_OFFSET + 19*1, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*2, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(2, new Integer[]{axisX + NUMBER_OFFSET + 19*2, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*3, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(3, new Integer[]{axisX + NUMBER_OFFSET + 19*3, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*4, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(4, new Integer[]{axisX + NUMBER_OFFSET + 19*4, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*5, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(5, new Integer[]{axisX + NUMBER_OFFSET + 19*5, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*6, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(6, new Integer[]{axisX + NUMBER_OFFSET + 19*6, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*7, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		numberAxisPosition.put(7, new Integer[]{axisX + NUMBER_OFFSET + 19*7, axisY + (OFFSET<<1) + NUMBER_YAXIS_OFFSET, axisX + NUMBER_OFFSET + 19*8, axisY + (OFFSET<<1)+32 + NUMBER_YAXIS_OFFSET, });
		
		//
		for(int i = 0; i < numberCharArray.length; i++) {
			g.drawImage(IMG_NUMBER_SOURCE, 
					numberAxisPosition.get(i)[0], 
					numberAxisPosition.get(i)[1], 
					numberAxisPosition.get(i)[2], 
					numberAxisPosition.get(i)[3], 
					numberImagePosition.get(numberCharArray[i])[0],
					numberImagePosition.get(numberCharArray[i])[1],
					numberImagePosition.get(numberCharArray[i])[2],
					numberImagePosition.get(numberCharArray[i])[3],
					null);		
		}
	}
}






















