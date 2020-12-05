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
}

