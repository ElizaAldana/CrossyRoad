package model;

import processing.core.PApplet;

public class Person extends Objects {

	public Person(int posX, int posY, int dirX, PApplet app) {
		super(posX, posY, dirX, app);
	}

	public void draw() {
		this.app.fill(64,224,208);
		this.app.rect(posX, posY, tam, tam);
	}

	public void move() {
		
	}
}
