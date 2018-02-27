package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	
	private List<Player> dbRcord;
	
	private List<Player> diskRecord;
	
	private boolean[][] gameMap;
	
	private boolean pause;
	
	private boolean gameThreadStart = true;
	
	public boolean isGameThreadStart() {
		return gameThreadStart;
	}

	public void setGameThreadStart(boolean gameThreadStart) {
		this.gameThreadStart = !this.gameThreadStart;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = !this.pause;
	}

	private GameAct gameAct;
	
	private int next;
	
	private int level;
	
	private int nowPoint;
	
	private int nowRemoveLine;
	
	
	public GameDto() {
		dtoInit();
	}

	public void dtoInit() {
		this.gameMap = new boolean[18][10];
		//TODO 初始化所有游戏对象
	}
	public List<Player> getDbRcord() {
		return dbRcord;
	}

	public void setDbRcord(List<Player> dbRcord) {
		this.dbRcord = dbRcord;
	}

	public List<Player> getDiskRecord() {
		return diskRecord;
	}

	public void setDiskRecord(List<Player> diskRecord) {
		this.diskRecord = diskRecord;
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}


}
