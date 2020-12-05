package view;

import controller.Control;
import processing.core.PApplet;
import view.Score;

public class Main extends PApplet{
	
	Control controller;
	Score score;
	int time, second, timer, scoreGame, screen;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		this.controller = new Control(this);
		this.screen = 0;
		//visualize time
		time=0;
		second=0;
		timer = 0;
			
		//visualize score
		scoreGame =0;
		score = new Score(scoreGame,this);
	}
	
	public void draw() {
		background(255);
		this.controller.dibujar();
		
		switch(screen) {
		case 0:
			background(255);
			fill(0);
			textSize(50);
			text("Crossy Road",20,100);
			textSize(40);
			if(mouseX > width/2-40 && mouseX <= width/2+45 && mouseY >height-250 && mouseY <= height-200) {
				fill(0);
			}
			text("Play",width/2-40, height-200);
			fill(0);
			if(mouseX > width/2-40 && mouseX <= width/2+40 && mouseY > height-150 && mouseY <= height-100) {
				fill(0);
			}
			text("Exit", width/2-40,height-100);
		break;
		case 1:
			
			score.validateScore();
		break;
		case 2:
			textSize (30);
			text(scoreGame,157,60);
	}
	
}
}