package model;

import processing.core.PApplet;

public class Person extends Objects implements Runnable {

	public Person(int posX, int posY, int dirX, PApplet app) {
		super(posX, posY, dirX, app);
	}

	public void draw() {
		this.app.fill(64,224,208);
		this.app.ellipse(posX, posY, tam, tam);
	}

	public void moveR() {
			this.posX += posX+dirX*4;
		}
	
	public void moveL() {
			this.posX += posX+dirX*-4;
	}
			
	public void moveD() {
			this.posY += posY+dirX*4;
	}
		
	public void run() {
		moveL();
		moveR();
		moveD();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
