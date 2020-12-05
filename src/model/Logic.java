package model;

import static processing.core.PConstants.LEFT;
import static processing.core.PConstants.RIGHT;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	public PApplet app;
	private ArrayList<Cars>malos;
	private Person prota;
	String[] info;
	private int screen;
	
	public Logic(PApplet app) {
		this.app = app;
		this.malos = new ArrayList<Cars>();

		
		//new Thread().start(); 
		loadStrings();
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
			this.malos.add(new Cars(50+(j*130),120,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*130),520,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*130),280,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(70+(j*130),360,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(50+(j*130),440,-1,app));
		}
		for (int j = 0; j < 6; j++) {
			this.malos.add(new Cars(70+(j*130),200,-1,app));
		}
	}
//	public void run() {
//		loadStrings();
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
	public void dibujar() {
		app.fill(0);
		for (int i = 0; i < 6; i++) {
			app.rect(0, 110+(i*80), 800, 50);
		}
		
		for (int i = 0; i < this.malos.size(); i++) {
			this.malos.get(i).draw(); 
		}
		this.prota.draw();
		
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
}
