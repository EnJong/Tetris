package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	private Point[] actPoints;
	private int typeCode;

	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	public static List<Point[]> TYPE_CONFIG = new ArrayList<Point[]>(7);
	
	static {
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(6, 0)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(3, 1), new Point(5, 0)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(4, 1), new Point(3, 1), new Point(5, 0)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(3, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(5, 1)});
	}
	public GameAct(int typeCode) {
		init(typeCode);
	}
	public void init(int typeCode) {
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x, points[i].y);	
		}
		
	}
	
	/**
	 * 得到代表方块的数组的编号
	 * @return
	 */
	public int getActCode() {
		return typeCode;
	}
	
	/**
	 * 得到代表方块的点的数组
	 * @return
	 */
	public Point[] getActPoints() {
		return actPoints;
	}
	
	/**
	 * 方块移动的x轴偏移量
	 * 方块移动的y轴偏移量
	 * @param moveX
	 * @param moveY
	 */
	public boolean move(int moveX, int moveY, boolean[][] gameMap) {
//		public void move(int moveX, int moveY) {
		//边界判定
		//移动处理
		for(Point point:actPoints) {
			int newX = point.x + moveX;
			int newY = point.y + moveY;
			if(isOverRange(newX, newY, gameMap)) {
				return false;
			}
		}
		for(int i =0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		return true;
	}
	
	/**
	 * 使方块旋转
	 * 顺时针：
	 * Ax = 0y + 0x - By
	 * Ay = 0y - 0x + Bx
	 */
	public void rotate(boolean[][] gameMap) {
		if(this.typeCode == 4)   return;
		for(Point point:actPoints) {
			int newX = actPoints[0].y + actPoints[0].x - point.y;
			int newY = actPoints[0].y - actPoints[0].x + point.x;
			//判断是否可以旋转
			if(isOverRange(newX, newY, gameMap)) return;
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[i].y = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}
	
	/**
	 * 判断方块的每个点是否超出边界
	 * @param newX
	 * @param newY
	 * @param gameMap
	 * @return
	 */
	public boolean isOverRange(int newX, int newY, boolean[][] gameMap) {
		return newX < MIN_X || newX > MAX_X || newY < MIN_Y || newY > MAX_Y || gameMap[newY][newX];
	}
}

