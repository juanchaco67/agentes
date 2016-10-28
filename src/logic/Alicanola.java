package logic;

import java.util.Random;

public class Alicanola extends Thread{
	private int energia;
	private double radio;
	private Coordenada coordenada;
	private double velocidad;//pixel /segundos
	private static final double DISTANCIA=1;
	private Random random;

	public Alicanola(int energia, double radio, Coordenada coordenada) {
		super();
		this.random=new Random();
		this.velocidad=100+random.nextDouble()*400;
		this.energia = energia;
		this.radio= radio;
	
		this.coordenada = coordenada;
		
	}	
	@Override
	public void run() {
		// TODO Auto-generated method stub	
<<<<<<< HEAD
=======
		
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
		super.run();
		while(true){
			
			try {
				radio+=(velocidad/velocidadAngular());
				Thread.sleep((long) tiempo());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double velocidadAngular(){
		return velocidad/radio;
	}
	public double tiempo(){
		return (DISTANCIA*1000/velocidad)*1000;
	}
	
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	
}
