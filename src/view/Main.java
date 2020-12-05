package view;

import controller.Control;
import processing.core.PApplet;

public class Main extends PApplet{
	
	Control controller;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		this.controller = new Control(this);
	}
	
	public void draw() {
		background(255);
		
	}
	
}
