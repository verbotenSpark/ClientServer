package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CommPanel extends JPanel implements Runnable {
	final int originalTileSize = 16; // 16X16 pixel individual tile size
	final int scale = 3; // scales the tile size by a constant to fit the size requirements
	public int tileSize = originalTileSize * scale; // Tile size changes to 48X48
	public int maxScreenCol = 20;// max no of tiles that can be present across the width of the screen
	public int maxScreenRow = 12;// same but tiles across height of screen
	
	// total no of pixels across the width of the screen
	public int screenWidth = tileSize * maxScreenCol;

	// total no of pixels across the height of the screen
	public int screenHeight = tileSize * maxScreenRow;

	//FULLSCREEN VARIABLES
	int screenWidth2 = screenWidth;
	int screenHeight2 = screenHeight;
	BufferedImage tempScreen;
	Graphics2D g2;
		
		
	Thread gameThread;
	int FPS = 60;
	public void startGameThread() {
		gameThread = new Thread(this);  // Instantiating gameThread // this = GamePanel to Thread
		gameThread.start(); // starts the in-game time or game Thread
	}
	public void setupGame() {
		
	}
	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
//		long timer = 0;
//		int drawCount = 0;
		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += ((currentTime - lastTime) / drawInterval);
//			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if (delta >= 1) {
				delta--;
//				repaint();
//				drawCount++;
			}
//			if (timer >= 1000000000) { System.out.println("FPS: " + drawCount); drawCount = 0; timer = 0; }
		}
	}

}
