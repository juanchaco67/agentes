package controlador;

import java.util.ArrayList;
import java.util.Random;

import gui.Ventana;
import logic.Alicanola;
import logic.Area;
import logic.Bola;
import logic.Coordenada;
import logic.Fisfirufa;

public class BolaListener {
	@SuppressWarnings("unused")
	private Ventana ventana;
	private ArrayList<Bola> bola;
	private ArrayList<Alicanola>alicanolas;
	private ArrayList<Fisfirufa>fisfirufas;
	public BolaListener() {
		// TODO Auto-generated constructor stub
		Random random =new Random();
		this.bola=new ArrayList<Bola>();
		this.alicanolas=new ArrayList<Alicanola>();
		this.fisfirufas=new ArrayList<Fisfirufa>();
		for (int i = 0; i < 100; i++) {
			bola.add(new Bola(new Coordenada(random.nextDouble()*600,random.nextDouble()*400),5,Math.toRadians(random.nextDouble()*2*Math.PI),100+random.nextDouble()*400,new Area(800, 600, new Coordenada(0, 0))));
			bola.get(i).start();
		}
		ventana=new Ventana(bola,alicanolas,fisfirufas);		
	}
}
