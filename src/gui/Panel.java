package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controlador.BolaListener;
import logic.Alicanola;
import logic.Bola;
import logic.Clase;
import logic.Evolucion;
import logic.Fisfirufa;
import logic.Genero;




@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {	
	private VistaVentana vista;
	private BolaListener bolaListener;
	private int cantMuertes;
	private int cantNacimientos;
	private int cantAlicanolas;
	private int cantFisfirufas;

	public Panel(BolaListener bolaListener,VistaVentana vista) {
		// TODO Auto-generated constructor stub
		this.bolaListener=bolaListener;
		setSize(bolaListener.getBola().get(0).getArea().getAncho()-50,bolaListener.getBola().get(0).getArea().getAlto());
		setPreferredSize(getSize());
		this.vista=vista;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub	

		g.clearRect(0,0,1000,1000);
		g.fillRect(0,0,800,750);
		cantAlicanolas=0;
		cantFisfirufas=0;		
		/**
		 * dibujar fisfirufas
		 */
		for (int i = 0; i < bolaListener.getFisfirufas().size(); i++) {
			cantFisfirufas++;
			Fisfirufa fisfirufa=bolaListener.getFisfirufas().get(i);
			g.setColor(Color.RED);
			g.fillOval((int)fisfirufa.getCoordenada().getX(),(int)fisfirufa.getCoordenada().getY(),fisfirufa.getTam(),fisfirufa.getTam());
		}
		/**
		 * dibujar alicanola
		 */
		for (int i = 0; i < bolaListener.getAlicanolas().size(); i++) {
			cantAlicanolas++;
			Alicanola alicanola=bolaListener.getAlicanolas().get(i);
			g.setColor(Color.ORANGE);
			g.fillOval((int)alicanola.getCoordenada().getX(),(int)alicanola.getCoordenada().getY(),(int)alicanola.getRadio()*2,(int)alicanola.getRadio()*2);

		}


		/**
		 * dibujar agentes
		 */
		vista.eliminarDatos();
		for (int i = 0; i < bolaListener.getBola().size(); i++) {	

			Bola bol=bolaListener.getBola().get(i);
			if(bol.murio()){			
				bol.getEdad().stop();
				bol.getEnergia().stop();
				bol.getEvolucion().stop();
				bol.stop();	
				bolaListener.getBola().remove(i);
				cantMuertes++;
			}else{
					if(bol.getGenero()==Genero.HEMBRA){						
						g.setColor(bol.getColor());
						g.fillOval((int)bol.getCoordenada().getX(),(int)bol.getCoordenada().getY(),bol.getTama(),bol.getTama());
					}else{						
						g.setColor(bol.getColor());
						g.fillRect((int)bol.getCoordenada().getX(),(int)bol.getCoordenada().getY(),bol.getTama(),bol.getTama());
					}
					if(i==0)
						vista.addTabla(bol,0);
					else
						vista.addTabla(bol,1);
			}
		}



	}
	/**
	 * el hilo ejecuta todas las colisiones para hacer algo
	 */

	public void run() {

		Bola bola1=null;
		Bola bola2=null;
		while(true){
			try{
				/**
				 * colision entre bolas
				 */
				for (int i = 0; i < bolaListener.getBola().size(); i++) {
					bola1=bolaListener.getBola().get(i);
					for (int j = 0; j < bolaListener.getBola().size(); j++) {
						bola2=bolaListener.getBola().get(j);

					
						
						if(colision((int)bola1.getCoordenada().getX(),(int)bola1.getCoordenada().getY(),(int)bola1.getTama(),
								getBounds((int)bola2.getCoordenada().getX(),(int)bola2.getCoordenada().getY(),(int)bola2.getTama())) && i!=j){
							/**
							 * pispirispi de menor dedad y de clase diferente 
							 */
							if(bola1.getEdad().getEdad()<bola2.getEdad().getEdad()
									&& bola1.getClase()!=bola2.getClase()){
//								bola1.getEvolucion().setPasa(true);
							}
						
							
							/**
							 *Si son diferente genero  y de la misma clase y estan en estapa adulto
							 *generan un nuevo pisppirispi  de la misma clase
							 */							
							if(bola1.getGenero()!=bola2.getGenero() 
									&& bola1.getClase()==bola2.getClase() 
									&& bola1.getEvolucion().getEvolucion()==Evolucion.ADULTOS 
									&& bola2.getEvolucion().getEvolucion()==Evolucion.ADULTOS){
								bolaListener.crearPispirispi(0);
								this.cantNacimientos++;
							}
							/**
							 * si son adolecentes y de igual  genero y diferente clase,morira el que 
							 * tenga menos energia
							 */							
							if(bola1.getEvolucion().getEvolucion()==Evolucion.ADOLECENCIA
									&& bola2.getEvolucion().getEvolucion()==Evolucion.ADOLECENCIA
									&& bola1.getGenero()==bola2.getGenero()
									&& bola1.getClase()!=bola2.getClase()){
								if(bola1.getEnergia().getCantidadInicial()<bola2.getEnergia().getCantidadInicial())
								{
									bola1.getEdad().stop();
									bola1.getEnergia().stop();
									bola1.getEvolucion().stop();
									bola1.stop();									
									bolaListener.getBola().remove(i);
									
								}else{
									bola2.getEdad().stop();
									bola2.getEnergia().stop();
									bola2.getEvolucion().stop();
									bola2.stop();	
									bolaListener.getBola().remove(j);
								}
							}
						}
					}
					/**
					 * colision bola-alicanola
					 */
					for (int h = 0; h < bolaListener.getAlicanolas().size(); h++) {
						Alicanola alicanola=bolaListener.getAlicanolas().get(h);
						if(colision((int)bola1.getCoordenada().getX(),(int)bola1.getCoordenada().getY(),bola1.getTama()
								,getBounds((int)alicanola.getCoordenada().getX(),(int) alicanola.getCoordenada().getY(),(int) (alicanola.getRadio())))){
							//aumentarla energia

							bola1.getEnergia().setActivar(true);							
							bola1.getEnergia().adicionarEnergia();
							bolaListener.crearFIsfirufas();
							bolaListener.eliminarALicanola(h);
							this.cantAlicanolas--;
						}
					}			
					/**
					 * colision bola-fisfirufas
					 */
					for (int j = 0; j < bolaListener.getFisfirufas().size(); j++) {
						Fisfirufa fisfirufa=bolaListener.getFisfirufas().get(j);
						if(colision((int)bola1.getCoordenada().getX(),(int)bola1.getCoordenada().getY(),(int)bola1.getTama(),
								getBounds((int)fisfirufa.getCoordenada().getX(),(int)fisfirufa.getCoordenada().getY(),(int)fisfirufa.getTam()))){
							//aqui toka disminuir la energia de la bola	
							bola1.getEnergia().disminuirEnergia();
							if(bola1.getClase()==Clase.INOPIOS && bola1.getEvolucion().getEvolucion()==Evolucion.ADULTOS){
								bolaListener.eliminarFisfirifuna(j);
								this.cantFisfirufas--;
							}
						}
					}
					/**
					 * eliminar bola cunado tenga una energia de cero
					 */
					if(bola1.getEnergia().getCantidadInicial()<=0){
						bola1.getEdad().stop();
						bola1.getEnergia().stop();
						bola1.getEvolucion().stop();
						bola1.stop();	
						bolaListener.getBola().remove(i);			
					}
				}
				repaint();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}
	private Rectangle getBounds(int x , int y,int diametro){
		return new Rectangle(x,y,diametro,diametro);
	}

	private  boolean colision(int x,int y ,int diametro,Rectangle r){
		return getBounds(x, y, diametro).intersects(r);
	}

	public int getCantMuertes() {
		return cantMuertes;
	}

	public void setCantMuertes(int cantMuertes) {
		this.cantMuertes = cantMuertes;
	}

	public int getCantNacimientos() {
		return cantNacimientos;
	}

	public void setCantNacimientos(int cantNacimientos) {
		this.cantNacimientos = cantNacimientos;
	}

	public int getCantAlicanolas() {
		return cantAlicanolas;
	}

	public void setCantAlicanolas(int cantAlicanolas) {
		this.cantAlicanolas = cantAlicanolas;
	}

	public int getCantFisfirufas() {
		return cantFisfirufas;
	}

	public void setCantFisfirufas(int cantFisfirufas) {
		this.cantFisfirufas = cantFisfirufas;
	}


}