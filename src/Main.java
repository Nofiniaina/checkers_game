import javax.swing.JFrame;

import panel.GamePanel;
import panel.MainPanel;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Checkers game");
		
//		MainPanel mainpanel = new MainPanel();
//		window.add(mainpanel);
		GamePanel gamepanel = new GamePanel();
		window.add(gamepanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}

}
