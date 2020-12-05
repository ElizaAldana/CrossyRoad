package model;

import java.util.ArrayList;

import processing.core.PApplet;
import view.Score;

public class Logic {
	
	public PApplet app;
	private ArrayList<Cars>malos;
	Person prota;
	String[] info;
	Score score;
	private int time, second, timer, scoreGame, screen;
	
	public Logic(PApplet app) {
		this.app = app;
		this.malos = new ArrayList<Cars>();
		loadStrings();
		
		this.screen = 0;
		
		//visualize time
		time=0;
		second=0;
		timer = 0;
			
		//visualize score
		scoreGame = 0;
		score = new Score(scoreGame,app);
	}

	public void loadStrings() {
		//Cargar textos
		info = app.loadStrings("../txt/txtcr.txt");
		
		for (int i = 0; i < info.length; i++) {
			String[] partir = info[i].split(",");
			if(partir[0].equals("personaje")) {
				int dirX = Integer.parseInt(partir[1]);
				int posX = Integer.parseInt(partir[2]);
				int posY = Integer.parseInt(partir[3]);
				this.prota = new Person(posX,posY,dirX,app);
			}
			if(partir[0].equals("carro")) {
				int dirX = Integer.parseInt(partir[1]);
				int posX = Integer.parseInt(partir[2]);
				int posY = Integer.parseInt(partir[3]);
				for (int j = 0; j < 5; j++) {
					this.malos.add(new Cars(posX,posY,dirX,app));
				}
			}
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*200),120,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*200),520,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*250),280,2,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(70+(j*200),360,-3,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*200),440,1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(70+(j*200),200,-2,app));
		}
	}
	
	public void dibujar() {
		app.fill(0);
		for (int i = 0; i < 6; i++) {
			app.rect(0, 110+(i*80), 800, 50);
		}
		
		for (int i = 0; i < this.malos.size(); i++) {
			this.malos.get(i).draw(); 
			new Thread(this.malos.get(i)).start();
		}
		this.prota.draw();
	}
	
	public void pantallas() {
		switch(screen) {
		case 0:
			app.background(255);
			app.fill(0);
			app.textSize(35);
			app.text("Crossy Road",300,100);
			app.textSize(25);
			if(app.mouseX > app.width/2-40 && app.mouseX <= app.width/2+45 && app.mouseY >app.height-250 && app.mouseY <= app.height-200) {
				app.fill(0);
			}
			app.text("Play",app.width/2-40, app.height-200);
			app.fill(0);
			if(app.mouseX > app.width/2-40 && app.mouseX <= app.width/2+40 && app.mouseY > app.height-150 && app.mouseY <= app.height-100) {
				app.fill(0);
			}
			app.text("Exit", app.width/2-40,app.height-100);
		break;
		case 1:
			dibujar();
			score.validateScore();
			app.fill(0);
			app.textSize (25);
			app.text(time,100,60);
			app.textSize (20);
			app.text("Time:",30,60);
			this.second = this.second + 1;
			if (this.second == 10) {
				this.second = 0;
			}
			if (this.screen == 2 && this.second == 9) {
				this.time=this.time + 1;
			}
			validarChoque();
			validarGanar();
			app.text("Para moverse: A-S-D", 30, 80 );
		break;
		case 2:
			app.text(scoreGame,157,60);
			app.fill(255,0,0);
			app.textSize(40);
			app.text("Game Over :(", 200, 200);
		break;
		case 3:
			app.fill(0,255,0);
			app.textSize(40);
			app.text("¡Ganaste :D!", 300, 200);
	}
	}
	
	public void keyPressed() {
		switch(screen) {
		case 1:
			if(app.key == 'A' || app.key == 'a' ) {
				prota.moveL();
			}
			if(app.key == 'D' || app.key == 'd' ) {
				prota.moveR();
			}
			if(app.key == 'S' || app.key == 's' ) {
				prota.moveD();
			}
			break;
		}
			
	}
	
	public void validarChoque() {
		switch(screen) {
		case 1:
			for (int j = 0; j <malos.size(); j++) {
				float validarChoque = PApplet.dist(prota.getPosX(),prota.getPosY(),malos.get(j).getPosX(),malos.get(j).getPosY());
				if(validarChoque < 20) {
					screen = 2;
					System.out.println("Me choque");
				}
			}
			break;
		}
		
		
	}
	
	public void mouseClicked() {
		switch(screen) {
		case 0:
			if(app.mouseX > app.width/2-30 && app.mouseX <= app.width/2+45 && app.mouseY > app.height-250 && app.mouseY <= app.height-200) {
				screen = 1;
			}
			if(app.mouseX > app.width/2-30 && app.mouseX <= app.width/2+30 && app.mouseY > app.height-150 && app.mouseY <= app.height-100) {
				app.exit();
			}
			break;
		case 1:
			break;
			
		}
	}
	
	public void validarGanar() {
		if(prota.posY >= 600 - 30) {
			screen = 3;
		}
	}
	
}
