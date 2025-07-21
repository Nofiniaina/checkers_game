package panel;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Board;
import utils.Constants;



public class BoardPanel extends JPanel {
	
	Board board;
	
	public BoardPanel() {
		this.setBounds(0, Constants.SCREEN_HEIGHT / 8, 
				Constants.SCREEN_WIDTH, (Constants.SCREEN_HEIGHT * 7 / 8)
		);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
	}
	
	public void draw(Graphics2D g2) {
		
	}
}
