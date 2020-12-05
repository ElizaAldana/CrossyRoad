package model;

import processing.core.PApplet;

public class Cars extends Objects implements Runnable {
	

	public Cars(int posX, int posY, int dirX, PApplet app) {
		super(posX, posY, dirX, app);
	}

	
	
	public void draw() {
		this.app.fill(64,224,208);
		this.app.rect(posX, posY, tam, tam);
	}

	public void move() {
		this.posX = this.posX+dirX;
		if(posX > 800 || posX < 0) {
			
		}
	}
	public void run() {
		move();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
