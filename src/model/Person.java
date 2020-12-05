package model;

import processing.core.PApplet;

public class Person extends Objects {

	public Person(int posX, int posY, int dirX, PApplet app) {
		super(posX, posY, dirX, app);
	}

	public void draw() {
		this.app.fill(64,224,208);
		this.app.ellipse(posX, posY, tam, tam);
	}

	public void move() {
		
	}
	public void moveR() {
		this.posX += posX+dirX*4; 
	}
	public void moveL() {
		this.posX += posX+dirX*-4; 
	}
	public void moveD() { //ESTE NO ESTÁ BIEN AUN EL MOV HACIA ABAJO
		this.posX += posX+dirX*-4; 
	}
}
