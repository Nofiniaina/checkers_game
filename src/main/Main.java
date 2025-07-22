package main;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.GamePanel;
import panel.MainPanel;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Checkers game");
		
		CardLayout cardlayout = new CardLayout();
		JPanel maincontainer = new JPanel(cardlayout);
		
		MainPanel mainpanel = new MainPanel(cardlayout, maincontainer);
		GamePanel gamepanel = new GamePanel();

		maincontainer.add(mainpanel, "menu");
		maincontainer.add(gamepanel, "game"); 
		
		window.add(maincontainer);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		cardlayout.show(maincontainer, "menu");
	
//		Board board = new Board();
//		board.printBoard();
	}

}
