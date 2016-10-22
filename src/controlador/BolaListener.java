package controlador;

import java.util.Random;

import gui.Ventana;

import javax.swing.JFrame;

import logic.Area;
import logic.Bola;
import logic.Coordenada;

public class BolaListener {
	private Ventana ventana;
	private Bola bola[];
	public BolaListener() {
		// TODO Auto-generated constructor stub
		Random random =new Random();
		this.bola=new Bola[1000];
		for (int i = 0; i < bola.length; i++) {
			bola[i]=new Bola(new Coordenada(random.nextDouble()*600,random.nextDouble()*400),random.nextInt(15)+5,Math.toRadians(random.nextDouble()*2*Math.PI),100+random.nextDouble()*400,new Area(800, 600, new Coordenada(0, 0)));
			bola[i].start();
		}
		ventana=new Ventana(bola);
		
	}
}
