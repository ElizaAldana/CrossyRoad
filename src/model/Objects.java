package model;

import processing.core.PApplet;

public abstract class Objects  {

	
	PApplet app;
	protected int posX, posY, tam, dirX;
	
	public Objects(int posX, int posY, int dirX, PApplet app) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.dirX = dirX;
		this.tam =30;
	}
	
	public abstract void draw();


	
	//Getters & Setters
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	
}

