package ui;

import java.awt.Graphics;
import java.awt.Image;
//import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;

import dto.GameDto;
import entity.ImageSource;

public abstract class WindowLayout extends ImageSource{
	
	private String windowID = null;
	/**
	 * 游戏窗口里面的窗口在JFrame里的左上角顶点坐标的x坐标
	 */
	protected int axisX;
	/**
	 * 游戏窗口里面的窗口在JFrame里的左上角顶点坐标的y坐标
	 */
	protected int axisY;
	/**
	 * 游戏数据
	 */
	protected GameDto dto = null;
	/**
	 * 游戏窗口里面的窗口
	 */
	private Map<String, Object> windowMap = new HashMap<String, Object>();
	
	protected WindowLayout(String windowID, int axisX, int axisY) {
		this.axisX = axisX;
		this.axisY = axisY;
		this.windowID = windowID;
		this.windowMap.put("databasewindow", IMG_DATABASE_WINDOW);
		this.windowMap.put("localrecordwindow", IMG_LOCALRECORD_WINDOW);
		this.windowMap.put("mainwindow", IMG_MAIN_WINDOW);
		this.windowMap.put("startwindow", IMG_START_WINDOW);
		this.windowMap.put("shapewindow", IMG_SHAPE_WINDOW);
		this.windowMap.put("levelwindow", IMG_LEVEL_WINDOW);
		this.windowMap.put("scorewindow", IMG_SCORE_WINDOW);
		this.windowMap.put("licensewindow", IMG_LICENSE_WINDOW);
		this.windowMap.put("rect", IMG_RECT);
	}
	
	protected void creatWindow(Graphics g) {
		if (windowMap.containsKey(windowID)) {
        	g.drawImage((Image)windowMap.get(windowID), axisX, axisY, null);		
		} else {
			System.out.println("没有找到： " + windowID);
		}
	}
	abstract public void paint(Graphics g);

	public void setDto(GameDto dto) {
		this.dto = dto;
	}
}