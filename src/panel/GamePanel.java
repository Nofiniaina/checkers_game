package panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.Constants;

public class GamePanel extends JPanel {
	
	private JPanel topPanel;
	private BoardPanel boardPanel;
	
	public GamePanel(CardLayout layout, JPanel parent) {
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
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 
				Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT / 8
		);
		topPanel.setBackground(Color.WHITE);
		
		JButton reset = new JButton("Reset game");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boardPanel.getBoard().init();
				boardPanel.repaint();
			}
		});		
		JButton backToMenu = new JButton("Menu");
		backToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(parent, "menu");
			}
		});
		
		topPanel.add(backToMenu);
		topPanel.add(reset);
		
		boardPanel = new BoardPanel();
		boardPanel.setBounds(0, Constants.SCREEN_HEIGHT / 8, 
				Constants.SCREEN_WIDTH, (Constants.SCREEN_HEIGHT * 7 / 8)
		);
		
		this.add(topPanel);
		this.add(boardPanel);
		
		this.setFocusable(true);
	}
}
