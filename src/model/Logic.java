package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	public PApplet app;
	private ArrayList<Cars>malos;
	private Person prota;
	String[] info;
	
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
			String[] partir = info[i].split(" ");
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
				this.malos.add(new Cars(posX,posY,dirX,app));
			}
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
//		for (int i = 0; i < 30; i++) {
//			this.malos.get(i).draw(); 
//		}
		this.prota.draw();
		
	}
}
