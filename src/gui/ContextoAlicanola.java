package gui;

import java.util.ArrayList;
import java.util.Random;
import logic.Alicanola;
import logic.Bola;
import logic.Coordenada;
import logic.Fisfirufa;

public class ContextoAlicanola extends Thread{
	private ArrayList<Bola>bolas;
	private ArrayList<Fisfirufa>fisfirufas;
	private ArrayList<Alicanola>alicanolas;
	private Random random;
	private static final int TIMEPO_APARECER=6000;
	public ContextoAlicanola(ArrayList<Bola> bolas,
			ArrayList<logic.Fisfirufa> fisfirufas,
			ArrayList<logic.Alicanola> alicanolas) {
		super();
		this.bolas = bolas;
		this.fisfirufas = fisfirufas;
		this.alicanolas = alicanolas;
		this.random=new Random();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){			
			try {
				Thread.sleep(TIMEPO_APARECER);
				for (int i = 0; i <random.nextInt(4)+1; i++) {
					Alicanola alicanola=new Alicanola(20+random.nextInt( (100+1) - 20),random.nextDouble()*2.0+0.8,new Coordenada(random.nextDouble()*600,random.nextDouble()*400));
					alicanolas.add(alicanola);
					alicanola.start();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void eliminarALicanola(int posicion){
		alicanolas.remove(posicion);
	}
	public void eliminarFisfirifuna(int posicion){
		fisfirufas.remove(posicion);
	}
	public void crearFIsfirufas(Alicanola alicanola){
		fisfirufas.add(new Fisfirufa(5,new Coordenada(alicanola.getCoordenada().getX(),alicanola.getCoordenada().getY())));
	}

	public ArrayList<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(ArrayList<Bola> bolas) {
		this.bolas = bolas;
	}
	public ArrayList<Fisfirufa> getFisfirufas() {
		return fisfirufas;
	}
	public void setFisfirufas(ArrayList<Fisfirufa> fisfirufas) {
		this.fisfirufas = fisfirufas;
	}
	public ArrayList<Alicanola> getAlicanolas() {
		return alicanolas;
	}
	public void setAlicanolas(ArrayList<Alicanola> alicanolas) {
		this.alicanolas = alicanolas;
	}



}
