package panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.Constants;

public class MainPanel extends JPanel {
	
	public MainPanel() {
		this.setPreferredSize(new Dimension(
				Constants.SCREEN_WIDTH, 
				Constants.SCREEN_HEIGHT
		));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		
	}
}
