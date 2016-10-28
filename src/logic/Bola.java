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


	public Bola(Coordenada coordenada, int tama, double direccion,
<<<<<<< HEAD
			double velocidad, Area area,byte opcion,int evolucionTiempo,int energiaInicial) {
=======
			double velocidad, Area area,byte opcion,int tiempoEvolucion,int cantidadEnergia) {
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38

		this.coordenada = coordenada;
		this.tama = tama;
		this.direccion = direccion; 
		this.velocidad = velocidad;
		this.area = area;
		this.genero=Genero.aleatorioGenero();
		this.clase=Clase.aleatorioClase();
		elegirColor();
<<<<<<< HEAD
		this.evolucion=new EvolucionBola(this,opcion,evolucionTiempo);
		this.edad=new Edad(this);
		this.energia=new Energia(energiaInicial,0);
=======
		this.evolucion=new EvolucionBola(this,opcion,tiempoEvolucion);
		this.edad=new Edad(this);
		this.energia=new Energia(cantidadEnergia,0);
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
		this.edad.start();
		this.evolucion.start();
		this.energia.start();
		
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
				
				coordenada.mover(DISTANCIA,direccion);
				if(!this.area.coordenadaAdentro(this)){//esta afuera
					
					this.direccion+=random.nextDouble()*Math.PI;					
					coordenada.mover(0,direccion);
				}		
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
<<<<<<< HEAD
	/**
	 * Metodo que comprueba si hubo colision entre dos agentes
	 * @param bola
	 * @return
	 */
	public boolean colision(Bola bola) {	
		return coordenada.getX()+tama>=bola.getCoordenada().getX() 
				&& coordenada.getX()+tama<=bola.getCoordenada().getX()+bola.getTama()
				&& coordenada.getY()+tama>=bola.getCoordenada().getY() 
				&& coordenada.getY()+tama<=bola.getCoordenada().getY()+bola.getTama();
	}
=======

>>>>>>> 1df22e6842f26450bb83d412c991984587712c38

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






}
