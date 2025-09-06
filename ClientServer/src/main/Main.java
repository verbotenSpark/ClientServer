package main;
import javax.swing.JFrame;
public class Main {
	//meow meow edit
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Communication");
		CommPanel commPanel = new CommPanel();
		window.add(commPanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		commPanel.setupGame();
		commPanel.startGameThread();
	}

}
