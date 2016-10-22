package logic;

import java.util.Random;

public class Bola extends Thread {
	private Coordenada coordenada;
	private int tama;
	private double direccion;//radianes
	private double velocidad;//pixel /segundos
	private Area area;
	private static final int DISTANCIA=2;
	
	
	public Bola(Coordenada coordenada, int tama, double direccion,
			double velocidad, Area area) {
	
		this.coordenada = coordenada;
		this.tama = tama;
		this.direccion = direccion;
		this.velocidad = velocidad;
		this.area = area;
	}
	public void run() {
		Random random=new Random();
		while(true){
			try {
				Thread.sleep((long)(DISTANCIA*1000/velocidad));
				coordenada.mover(DISTANCIA,direccion);
				if(!this.area.coordenadaAdentro(coordenada,this)){//esta afuera
					this.direccion+=random.nextDouble()*Math.PI;			
				}
//				System.out.println(coordenada.getX()+" "+coordenada.getY());
		
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		
		}
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	public int getTama() {
		return tama;
	}
	public void setTama(int tama) {
		this.tama = tama;
	}
	public double getDireccion() {
		return direccion;
	}
	public void setDireccion(double direccion) {
		this.direccion = direccion;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	


	
	
}
