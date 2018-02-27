package ui.cfg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextControl extends JTextField{
	private static final long serialVersionUID = 1L;

	public TextControl(int x, int y, int w, int h) {
		this.setBounds(x, y, w, h);
		this.setText(null);
		this.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent arg0) {
				setText(Integer.toString(arg0.getKeyCode()));
			}

			@Override
			public void keyPressed(KeyEvent arg0) {}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			
		});
	}
}
