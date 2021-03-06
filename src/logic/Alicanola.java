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
	/**
	 * Metodo que comprueba si hubo colision entre dos agentes
	 * @param bola
	 * @return
	 */
	public boolean colision(Bola bola) {	
		return coordenada.getX()+radio*2>bola.getCoordenada().getX() 
				&& coordenada.getX()+radio*2<bola.getCoordenada().getX()+bola.getTama()
				&& coordenada.getY()+radio*2>bola.getCoordenada().getY() 
				&& coordenada.getY()+radio*2<bola.getCoordenada().getY()+bola.getTama();
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub	
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
