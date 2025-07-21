package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.Constants;

public class MainPanel extends JPanel {
	
	public MainPanel(CardLayout layout, JPanel parent) {
		this.setPreferredSize(new Dimension(
				Constants.SCREEN_WIDTH, 
				Constants.SCREEN_HEIGHT
		));
		
		JButton start = new JButton("Start game");
		JButton exit = new JButton("Exit");
		
		start.addActionListener(e->layout.show(parent, "game"));
		exit.addActionListener(e->System.exit(0));
		
		this.add(start);
		this.add(exit);
		
		this.setFocusable(true);
		
	}
}
