package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import logic.Alicanola;
import logic.Area;
import logic.Bola;
import logic.Clase;
import logic.Coordenada;
import logic.Evolucion;
import logic.Fisfirufa;
import logic.Genero;


@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {
	private ArrayList<Bola> bola;
	private ContextoAlicanola contextoAlicanola;
	private VistaVentana vista;
	private Random random;
	public Panel(ArrayList<Bola> bola,ArrayList<Alicanola>alicanolas,ArrayList<Fisfirufa>fisfirufas,VistaVentana vista) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		setBounds(0,0, 800, 600);
		this.contextoAlicanola=new ContextoAlicanola(bola, fisfirufas, alicanolas);
		this.contextoAlicanola.start();
		this.vista=vista;
		this.random=new Random();

	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub		
		g.clearRect(0,0,1000,1000);
		/**
		 * dibujar fisfirufas
		 */
		for (int i = 0; i < contextoAlicanola.getFisfirufas().size(); i++) {
			Fisfirufa fisfirufa=contextoAlicanola.getFisfirufas().get(i);
			g.setColor(Color.BLACK);
			g.fillOval((int)fisfirufa.getCoordenada().getX(),(int)fisfirufa.getCoordenada().getY(),fisfirufa.getTam(),fisfirufa.getTam());

		}
		/**
		 * dibujar alicanola
		 */
		for (int i = 0; i < contextoAlicanola.getAlicanolas().size(); i++) {
			Alicanola alicanola=contextoAlicanola.getAlicanolas().get(i);
			g.setColor(Color.ORANGE);
			g.fillOval((int)alicanola.getCoordenada().getX(),(int)alicanola.getCoordenada().getY(),(int)alicanola.getRadio()*2,(int)alicanola.getRadio()*2);

		}


		/**
		 * dibujar agentes
		 */
		vista.eliminarDatos();
		for (int i = 0; i < bola.size(); i++) {	

			Bola bol=bola.get(i);
			if(bol.murio()){				
				bola.remove(i);
			}else{
				if(bol.getGenero()==Genero.HEMBRA){
					vista.addTabla(bol);
					g.setColor(bol.getColor());
					g.fillOval((int)bol.getCoordenada().getX(),(int)bol.getCoordenada().getY(),bol.getTama(),bol.getTama());
				}else{
					vista.addTabla(bol);
					g.setColor(bol.getColor());
					g.fillRect((int)bol.getCoordenada().getX(),(int)bol.getCoordenada().getY(),bol.getTama(),bol.getTama());

				}
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
				for (int i = 0; i < bola.size(); i++) {
					bola1=bola.get(i);
					for (int j = 0; j < bola.size(); j++) {
						bola2=bola.get(j);

						if(colision((int)bola1.getCoordenada().getX(),(int)bola1.getCoordenada().getY(),(int)bola1.getTama(),
								getBounds((int)bola2.getCoordenada().getX(),(int)bola2.getCoordenada().getY(),(int)bola2.getTama())) && i!=j){
							/**
							 *Si son diferente genero  y de la misma clase y estan en estapa adulto
							 *generan un nuevo pisppirispi  de la misma clase
							 */							
							if(bola1.getGenero()!=bola2.getGenero() 
									&& bola1.getClase()==bola2.getClase() 
									&& bola1.getEvolucion().getEvolucion()==Evolucion.ADULTOS 
									&& bola2.getEvolucion().getEvolucion()==Evolucion.ADULTOS){
								crearPispirispi();
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
									bola.remove(i);
								else
									bola.remove(j);
							}
						}
					}
					/**
					 * colision bola-alicanola
					 */
					for (int h = 0; h < contextoAlicanola.getAlicanolas().size(); h++) {
						Alicanola alicanola=contextoAlicanola.getAlicanolas().get(h);
						if(colision((int)bola1.getCoordenada().getX(),(int)bola1.getCoordenada().getY(),bola1.getTama()
								,getBounds((int)alicanola.getCoordenada().getX(),(int) alicanola.getCoordenada().getY(),(int) (alicanola.getRadio())))){
							//aumentarla energia

							bola1.getEnergia().setActivar(true);							
							bola1.getEnergia().adicionarEnergia();
							contextoAlicanola.crearFIsfirufas();
							contextoAlicanola.eliminarALicanola(h);
						}
					}			
					/**
					 * colision bola-fisfirufas
					 */
					for (int j = 0; j < contextoAlicanola.getFisfirufas().size(); j++) {
						Fisfirufa fisfirufa=contextoAlicanola.getFisfirufas().get(j);
						if(colision((int)bola1.getCoordenada().getX(),(int)bola1.getCoordenada().getY(),(int)bola1.getTama(),
								getBounds((int)fisfirufa.getCoordenada().getX(),(int)fisfirufa.getCoordenada().getY(),(int)fisfirufa.getTam()))){
							//aqui toka disminuir la energia de la bola	
							bola1.getEnergia().disminuirEnergia();
							if(bola1.getClase()==Clase.INOPIOS && bola1.getEvolucion().getEvolucion()==Evolucion.ADULTOS)
								contextoAlicanola.eliminarFisfirifuna(j);							
						}
					}
					/**
					 * eliminar bola cunado tenga una energia de cero
					 */
					if(bola1.getEnergia().getCantidadInicial()<=0)
						bola.remove(i);					
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
	private void crearPispirispi(){
		Bola bol=new Bola(new Coordenada(random.nextDouble()*800,random.nextDouble()*750),5,Math.toRadians(random.nextDouble()*2*Math.PI),100+random.nextDouble()*400,new Area(800, 750, new Coordenada(0, 0)),(byte)0);
		bol.start();
		bola.add(bol);		
	}
	public ArrayList<Bola> getBola() {
		return bola;
	}
	public void setBola(ArrayList<Bola> bola) {
		this.bola = bola;
	}

	public ContextoAlicanola getContextoAlicanola() {
		return contextoAlicanola;
	}
	public void setContextoAlicanola(ContextoAlicanola contextoAlicanola) {
		this.contextoAlicanola = contextoAlicanola;
	}

}
