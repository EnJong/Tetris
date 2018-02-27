package ui.cfg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import control.GameControl;
import util.FrameUtil;

public class FrameConfig extends JFrame{

	private static final long serialVersionUID = 1L;

	private JButton btOk = new JButton("确定");
	
	private JButton btCancel = new JButton("取消");
	
	private JButton btApply = new JButton("应用");
	
	private GameControl gameControl;

//	private JTextField test = new TextControl(0,0,50,30);
	
	private final static Image IMG_PSP = new ImageIcon("Graphics/background/avenger.jpg").getImage();
			
	public FrameConfig(GameControl gameControl) {
		//设置布局管理器
		this.setLayout(new BorderLayout());
		this.setSize(500, 300);
		//添加主面板
		this.add(createMainPanel(), BorderLayout.CENTER);
		//添加按钮面板
		this.add(this.createButtonPanel(), BorderLayout.SOUTH);
		//设置位置
		FrameUtil.setFrameCenter(this);
		
		this.gameControl = gameControl;
//		
//		this.setDefaultCloseOperation(3);
//		this.setVisible(true);
	}

	/**
	 * 创建按钮面板
	 * @return
	 */
	private JPanel createButtonPanel() {
		//创建
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(this.btOk);
		jp.add(this.btCancel);
		jp.add(this.btApply);
		btOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (/*设置完数据*/true) {
					setVisible(false);
					gameControl.setOver();
				}
				
			}
			
		});
		return jp;
	}

	/**
	 * 创建主面板
	 * @return
	 */
	private JTabbedPane createMainPanel() {
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("控制设置", this.createControlPanel());
		jtp.addTab("控制设置", new JLabel("控制"));
		return jtp;
	}
	/**
	 * 玩家控制设置面板
	 * @return
	 */
	private JPanel createControlPanel() {
		JPanel jp = new JPanel() {
			{
				setBounds(0,0,500,300);
				add(new JTextField("Iron Man!"));
			}
			private static final long serialVersionUID = 1;
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(
						IMG_PSP, 
						0, 0, 500,300,
						300,300,800,600, 
						null);
			}	
		};
		return jp;
	}

//	public static void main (String[] args) {
//		new FrameConfig();
//	}
}
