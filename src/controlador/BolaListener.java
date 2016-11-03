package controlador;

import java.util.ArrayList;
import java.util.Random;

import logic.ThreadAlicanola;
import gui.VentanaDatos;
import logic.Alicanola;
import logic.Area;
import logic.Bola;
import logic.Coordenada;
import logic.Fisfirufa;
import logic.ThreadEnergia;

public class BolaListener {

	@SuppressWarnings("unused")
	private VentanaDatos ventana;
	private ArrayList<Bola> bola;
	private ArrayList<Alicanola>alicanolas;
	private ArrayList<Fisfirufa>fisfirufas;
	private Random random;
	private ThreadEnergia hiloEnergia;
	private ThreadAlicanola threadAlicanola;

	private int datos[];
	public BolaListener() {
		// TODO Auto-generated constructor stub
		this.random =new Random();
		this.bola=new ArrayList<Bola>();
		this.alicanolas=new ArrayList<Alicanola>();
		this.fisfirufas=new ArrayList<Fisfirufa>();
		this.datos=new int [6];
		this.ventana=new VentanaDatos(this);
		this.hiloEnergia=new ThreadEnergia(this);
		this.hiloEnergia.start();
		this.threadAlicanola=new ThreadAlicanola(this);
		
	}

	public void addDatos(int i,int dato){
		datos[i]=dato;
	}

	public void crearPispirispi(int opcion){
		Bola bol=new Bola(new Coordenada(random.nextDouble()*800,random.nextDouble()*750),5,Math.toRadians(random.nextDouble()*2*Math.PI),new Area(800, 750, new Coordenada(0, 0)),(byte)opcion,datos[4],datos[1],datos[5]);
		bol.start();
		bola.add(bol);		
	}

	public void  crearAlicanola(){
		Alicanola alicanola=new Alicanola(20+random.nextInt( (100+1) - 20),random.nextDouble()*2,new Coordenada(random.nextDouble()*800,random.nextDouble()*750));
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



	public ArrayList<Bola> getBola() {
		return bola;
	}

	public void setBola(ArrayList<Bola> bola) {
		this.bola = bola;
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

	public ThreadEnergia getHiloEnergia() {
		return hiloEnergia;
	}

	public void setHiloEnergia(ThreadEnergia hiloEnergia) {
		this.hiloEnergia = hiloEnergia;
	}

	public ThreadAlicanola getThreadAlicanola() {
		return threadAlicanola;
	}

	public void setThreadAlicanola(ThreadAlicanola threadAlicanola) {
		this.threadAlicanola = threadAlicanola;
	}




}