package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.WindowLayoutConfig;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel{
	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	private GameControl gameControl = null;
	
	private static final long serialVersionUID = 1L;
	
	JButton btStart = new JButton(new ImageIcon("Graphics/game/start.png"));
	
//	private  ImageIcon IMG_SETTING = new ImageIcon("Graphics/game/exit.png");
	JButton btSetting = new JButton(new ImageIcon("Graphics/game/setting.png"));
	
	private ArrayList<WindowLayout> windowLayouts = null; 

	private GameDto dto;
	

	public JPanelGame(GameDto dto) {
		//获得游戏数据
		this.dto = dto;
		this.setLayout(null); 
		//初始化组件
		initComponent();	
		//层初始化
//		initLayer();		
		configInitLayer();
		//初始化按钮
		initJButton();
	}
	
	public void initJButton() {
		this.setLayout(null);
		//初始化开始按钮
//		btStart.setBackground(Color.gray);
		btStart.setSize(68, 35);
		btStart.setLocation(849, 55);
		this.add(btStart);
		btStart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gameControl.gameStart();
				}
				
		});	
		//初始化设置按钮
		btSetting.setSize(68, 35);
		btSetting.setLocation(949, 55);
		this.add(btSetting);
		btSetting.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameControl.showUserConfig();
			}
			
		});
	}

	public void setGameControl(PlayerControl control) {
		addKeyListener(control);
		requestFocus();
	}
	
	/**
	 * 
	 */
	public void initComponent() {
		

	}
	
	/**
	 * 硬编码初始化界面
	 */
	public void initLayer() {
//		windowLayouts = new WindowLayout[] {			
//			new WindowLayoutDatabase("databasewindow", 50, 25),								//尽量避免硬编码，尽量写入配置文件
//			new WindowLayoutLocalRecord("localrecordwindow", 50, 333),
//			new WindowLayoutMain("mainwindow", 400,25),
//			new WindowLayoutStart("startwindow", 800, 25),
//			new WindowLayoutNextShape("shapewindow", 800, 128),
//			new WindowLayoutLevel("levelwindow", 980, 128),
//			new WindowLayoutScore("scorewindow", 800, 300),
//			new WindowLayoutLicense("licensewindow", 800, 470),				
//		};
	}
	
	/**
	 * 通过dome４j解析XML文件，获取数据，初始化游戏界面
	 */
	public void configInitLayer() {
		try {
			//获得游戏配置
			GameConfig<Object> gameConfig = ConfigFactory.getGameConfig();
			//获得游戏配置
			java.util.List<WindowLayoutConfig> windowLayoutsGameConfig = gameConfig.getWindowLayoutsConfig();
			//获得层对象
			windowLayouts = new ArrayList<WindowLayout>(windowLayoutsGameConfig.size());
			
			for (WindowLayoutConfig windowLayoutGameConfig : windowLayoutsGameConfig) {
				//获得类对象
				Class<?> cls = Class.forName(windowLayoutGameConfig.getClassname());
				//获得构造函数
//				Constructor<?> ctr = cls.getConstructor(String.class, int.class, int.class);
				Constructor<?> ctr = cls.getDeclaredConstructor(String.class, int.class, int.class);
				//调用构造函数创建对象
				WindowLayout windowLayout = (WindowLayout)ctr.newInstance(
						windowLayoutGameConfig.getObjectname(),
						windowLayoutGameConfig.getAxisX(),
						windowLayoutGameConfig.getAxisY()
						);
				//设置游戏数据对象
				windowLayout.setDto(dto);
				//将创建的各个游戏独立窗口放进集合
				windowLayouts.add(windowLayout);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//调用基类方法
		super.paintComponent(g);
//		g.drawImage(new ImageIcon("Graphics/background/avenger.jpg").getImage(), 0, 0, null);
		g.drawImage(new ImageIcon("Graphics/background/background.jpeg").getImage(), 0, 0, null);
		//循环刷新游戏界面
		for(int i = 0; i < windowLayouts.size(); i++) {
		//刷新层窗口
			windowLayouts.get(i).paint(g);
		}
		this.requestFocus();
		
	}
}



/**
 * //////////////////////////////////////////////
 * 配置文件，暂时战败           2018.2.24
 * XML文件学习完毕　，已解决　　　　　　2018.2.25
 */

/*public JPanelGame() {

	try {
		GameConfig<Object> gameConfig = ConfigFactory.getGameConfig();
		java.util.List<WindowLayoutConfig> windowLayoutsGameConfig = gameConfig.getWindowLayoutsConfig();
		windowLayouts = new WindowLayout[windowLayoutsGameConfig.size()];
		for (WindowLayoutConfig windowLayoutGameConfig : windowLayoutsGameConfig) {
			//获得类对象
			Class<?> cls = Class.forName(windowLayoutGameConfig.getClassname());
			//获得构造函数
			Constructor<?>[] ctr = cls.getConstructors();
			
		}
	} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
		System.out.println(windowLayoutGameConfig.getClassname());
		System.out.println(windowLayoutGameConfig.getAxisX());
		System.out.println(windowLayoutGameConfig.getAxisY());
	}

	
}
*/