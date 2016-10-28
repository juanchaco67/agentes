package controlador;

import java.util.ArrayList;
import java.util.Random;
<<<<<<< HEAD

=======
import gui.Ventana;
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
import gui.VentanaDatos;
import logic.Alicanola;
import logic.Area;
import logic.Bola;
import logic.Coordenada;
import logic.Fisfirufa;

public class BolaListener {

<<<<<<< HEAD
	@SuppressWarnings("unused")
	private VentanaDatos ventana;
=======
	private Ventana ventana;
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
	private ArrayList<Bola> bola;
	private ArrayList<Alicanola>alicanolas;
	private ArrayList<Fisfirufa>fisfirufas;
	private Random random;
<<<<<<< HEAD
	private ThreadEnergia hiloEnergia;

=======
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
	private int datos[];
	public BolaListener() {
		// TODO Auto-generated constructor stub
		this.random =new Random();
		this.bola=new ArrayList<Bola>();
		this.alicanolas=new ArrayList<Alicanola>();
		this.fisfirufas=new ArrayList<Fisfirufa>();
<<<<<<< HEAD
		this.datos=new int [6];
		this.ventana=new VentanaDatos(this);
		this.hiloEnergia=new ThreadEnergia(this);
		this.hiloEnergia.start();

	}

	public void addDatos(int i,int dato){
		datos[i]=dato;
	}

=======
		this.datos=new int[6];
		new VentanaDatos(this);
	}
	
	public void addDatos(int i,int dato){
		datos[i]=dato;
	}
	
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
	public void crearPispirispi(int opcion){
		Bola bol=new Bola(new Coordenada(random.nextDouble()*800,random.nextDouble()*750),5,Math.toRadians(random.nextDouble()*2*Math.PI),100+random.nextDouble()*400,new Area(800, 750, new Coordenada(0, 0)),(byte)opcion,datos[4],datos[1]);
		bol.start();
		bola.add(bol);		
	}

	public void  crearAlicanola(){
		Alicanola alicanola=new Alicanola(20+random.nextInt( (100+1) - 20),random.nextDouble(),new Coordenada(random.nextDouble()*800,random.nextDouble()*750));
		alicanolas.add(alicanola);
		alicanola.start();
	}
	public void crearFIsfirufas(){
		fisfirufas.add(new Fisfirufa(10,new Coordenada(random.nextDouble()*800,random.nextDouble()*750)));
	}
	public void eliminarALicanola(int posicion){
		alicanolas.remove(posicion);
	}
	public void eliminarFisfirifuna(int posicion){
		fisfirufas.remove(posicion);
	}


<<<<<<< HEAD
=======
	public Ventana getVentana() {
		return ventana;
	}

	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38

	public ArrayList<Bola> getBola() {
		return bola;
	}

	public void setBola(ArrayList<Bola> bola) {
		this.bola = bola;
<<<<<<< HEAD
	}

	public ArrayList<Alicanola> getAlicanolas() {
		return alicanolas;
	}

	public void setAlicanolas(ArrayList<Alicanola> alicanolas) {
		this.alicanolas = alicanolas;
	}

	public ArrayList<Fisfirufa> getFisfirufas() {
		return fisfirufas;
	}

	public void setFisfirufas(ArrayList<Fisfirufa> fisfirufas) {
		this.fisfirufas = fisfirufas;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datos) {
		this.datos = datos;
	}


}
=======
	}

	public ArrayList<Alicanola> getAlicanolas() {
		return alicanolas;
	}

	public void setAlicanolas(ArrayList<Alicanola> alicanolas) {
		this.alicanolas = alicanolas;
	}

	public ArrayList<Fisfirufa> getFisfirufas() {
		return fisfirufas;
	}

	public void setFisfirufas(ArrayList<Fisfirufa> fisfirufas) {
		this.fisfirufas = fisfirufas;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datos) {
		this.datos = datos;
	}
	
	
}
>>>>>>> 1df22e6842f26450bb83d412c991984587712c38
