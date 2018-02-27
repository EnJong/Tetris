package entity;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class ImageSource {
	//窗口边框图片
	protected static final Image IMG_DATABASE_WINDOW = new ImageIcon("Graphics/window/databasewindow.png").getImage();
	protected static final Image IMG_LOCALRECORD_WINDOW = new ImageIcon("Graphics/window/databasewindow.png").getImage();
	protected static final Image IMG_MAIN_WINDOW = new ImageIcon("Graphics/window/gamewindow.png").getImage();
	protected static final Image IMG_START_WINDOW = new ImageIcon("Graphics/window/startwindow.png").getImage();
	protected static final Image IMG_SHAPE_WINDOW = new ImageIcon("Graphics/window/shapewindow.png").getImage();
	protected static final Image IMG_LEVEL_WINDOW = new ImageIcon("Graphics/window/levelwindow.png").getImage();
	protected static final Image IMG_SCORE_WINDOW = new ImageIcon("Graphics/window/scorewindow.png").getImage();
	protected static final Image IMG_LICENSE_WINDOW = new ImageIcon("Graphics/window/scorewindow.png").getImage();
	protected static final Image IMG_RECT = new ImageIcon("Graphics/game/rect.png").getImage();
	
	//窗口内部图片
	protected static final Image IMG_RECT_SOURCE = new ImageIcon("Graphics/game/rect.png").getImage();
//	protected static final Image IMG_START = new ImageIcon("Graphics/game/start.png").getImage();
	protected static final Image IMG_PAUSE = new ImageIcon("Graphics/game/pause300.png").getImage();
	protected static final Image IMG_ACCOUNT = new ImageIcon("Graphics/game/account.png").getImage();
	protected static final Image IMG_ACCOUNTSCORE = new ImageIcon("Graphics/game/accountscore.png").getImage();
	protected static final Image IMG_setting = new ImageIcon("Graphics/game/setting.png").getImage();
	protected static final Image IMG_GLOBALRAND = new ImageIcon("Graphics/game/globalrand.png").getImage();
	public ImageIcon IMG_START = new ImageIcon("Graphics/game/start.png");
}
