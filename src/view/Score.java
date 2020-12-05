package view;

import processing.core.PApplet;

public class Score {

	private int score;
	PApplet app;
	
	public Score (int score, PApplet app) {
		this.score = score;
		this.app = app;
	}
	
	public void validateScore() {
		app.fill(0);
		app.textSize (25);
		app.text(this.score, 100, 30);
		app.textSize (20);
		app.text("Score:",30,30);
	}
}
