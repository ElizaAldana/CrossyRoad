package view;

import processing.core.PApplet;

public class Score {

	private int score;
	PApplet app;
	
	public Score (int score, PApplet app) {
		this.score=score;
		this.app = app;
	}
	
	public void validateScore() {
		app.text(this.score, 442, 364);
	}
}
