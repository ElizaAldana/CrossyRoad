package controller;

import model.Logic;
import processing.core.PApplet;


public class Control {
	PApplet app;
	private Logic logic;
	
	public Control(PApplet app) {
		this.app = app;
		this.logic = new Logic(app);
	}
	
	public void dibujar() {
		this.logic.dibujar();
	}
	public void keyPressed() {
		this.logic.keyPressed();
	}
	public void validarChoque() {
		this.logic.validarChoque();
	}
	
	public void pantallas() {
		this.logic.pantallas();
	}
	
	public void mouseClicked() {
		this.logic.mouseClicked();
	}
}

