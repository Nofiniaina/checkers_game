package panel;

import java.awt.Color;

import javax.swing.JPanel;

import utils.Constants;

public class BoardPanel extends JPanel {
	
	public BoardPanel() {
		this.setBounds(0, Constants.SCREEN_HEIGHT / 8, 
				Constants.SCREEN_WIDTH, (Constants.SCREEN_HEIGHT * 7 / 8)
		);
		this.setBackground(Color.BLACK);
	}
}
