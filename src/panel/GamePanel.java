package panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import utils.Constants;

public class GamePanel extends JPanel {
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(
				Constants.SCREEN_WIDTH, 
				Constants.SCREEN_HEIGHT
		));

		/* set a layout to add multiple panel in the main panel*/
		this.setLayout(null);

		/* 
		 * topPanel : 1/3 of the screen size
		 * contentPanel: 2/3 of the screen size
		 * */
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 
				Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT / 8
		);
		topPanel.setBackground(Color.WHITE);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, Constants.SCREEN_HEIGHT / 8, 
				Constants.SCREEN_WIDTH, (Constants.SCREEN_HEIGHT * 7 / 8)
		);
		contentPanel.setBackground(Color.BLACK);
		
		this.add(topPanel);
		this.add(contentPanel);
		
		this.setFocusable(true);
	}
}
