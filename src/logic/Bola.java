package logic;

import java.awt.Color;
import java.util.Random;

public class Bola extends Thread {
	private Coordenada coordenada;
	private int tama;
	private double direccion;//radianes
	private double velocidad;//pixel /segundos
	private Area area;
	private static final int DISTANCIA=2;
	private Genero genero;
	private Clase clase;
	private Color color;
	private EvolucionBola evolucion;
	private Edad edad;
	private Energia energia;
	private boolean colisionFisfirifuna;

	private boolean colision;


	public Bola(Coordenada coordenada, int tama, double direccion
			, Area area,byte opcion,int evolucionTiempo,int energiaInicial) {
		this.colision=false;
		this.colisionFisfirifuna=false;

		this.coordenada = coordenada;
		this.tama = tama;
		this.direccion = direccion;
		this.area = area;
		this.genero=Genero.aleatorioGenero();
		this.clase=Clase.aleatorioClase();
		elegirColor();
		this.edad=new Edad(this);
		this.evolucion=new EvolucionBola(this,opcion,evolucionTiempo);
		this.energia=new Energia(energiaInicial,0);

		this.evolucion.start();	
		this.energia.start();
		this.edad.start();





	}
	private void  elegirColor(){
		switch (clase) {
		case TROPUS:
			color=Color.YELLOW;
			break;

		case INOPIOS:
			color=Color.GREEN;
			break;
		}
	}
	public void run() {
		Random random=new Random();
		while(!murio()){
			try {
				Thread.sleep((long)(DISTANCIA*1000/velocidad));
				/**
				 * esta afuera
				 */
				if(!this.area.coordenadaAdentro(coordenada,this))	
					this.direccion+=random.nextDouble()*2*Math.PI;	
				coordenada.mover(DISTANCIA,direccion);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}




	public boolean murio(){
		return evolucion.getEvolucion()==Evolucion.MUERE;
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
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public EvolucionBola getEvolucion() {
		return evolucion;
	}
	public void setEvolucion(EvolucionBola evolucion) {
		this.evolucion = evolucion;
	}
	public Edad getEdad() {
		return edad;
	}
	public void setEdad(Edad edad) {
		this.edad = edad;
	}
	public Energia getEnergia() {
		return energia;
	}
	public void setEnergia(Energia energia) {
		this.energia = energia;
	}

	public boolean isColision() {
		return colision;
	}
	public void setColision(boolean colision) {
		this.colision = colision;
	}
	public boolean isColisionFisfirifuna() {
		return colisionFisfirifuna;
	}
	public void setColisionFisfirifuna(boolean colisionFisfirifuna) {
		this.colisionFisfirifuna = colisionFisfirifuna;
	}





}
