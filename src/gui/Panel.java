package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Alicanola;
import logic.Bola;
import logic.Fisfirufa;
import logic.Genero;


@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {
	private ArrayList<Bola> bola;
	private ContextoAlicanola contextoAlicanola;


	public Panel(ArrayList<Bola> bola,ArrayList<Alicanola>alicanolas,ArrayList<Fisfirufa>fisfirufas) {
		// TODO Auto-generated constructor stub
		this.bola=bola;

		setBounds(0,0, 800, 600);
		this.contextoAlicanola=new ContextoAlicanola(bola, fisfirufas, alicanolas);
		this.contextoAlicanola.start();

	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub		
		g.clearRect(0,0,1000,1000);
		/**
		 * dibujar alicanola
		 */
		for (int i = 0; i < contextoAlicanola.getAlicanolas().size(); i++) {
			Alicanola alicanola=contextoAlicanola.getAlicanolas().get(i);
			g.setColor(Color.ORANGE);
			g.fillOval((int)alicanola.getCoordenada().getX(),(int)alicanola.getCoordenada().getY(),(int)alicanola.crecimiento(),(int)alicanola.crecimiento());

		}
		/**
		 * dibujar fisfirufas
		 */
		for (int i = 0; i < contextoAlicanola.getFisfirufas().size(); i++) {
			Fisfirufa fisfirufa=contextoAlicanola.getFisfirufas().get(i);
			g.setColor(Color.PINK);
			g.fillOval((int)fisfirufa.getCoordenada().getX(),(int)fisfirufa.getCoordenada().getY(),fisfirufa.getTam(),fisfirufa.getTam());

		}

		/**
		 * dibujar agentes
		 */
		for (int i = 0; i < bola.size(); i++) {		
			Bola bol=bola.get(i);
			if(bol.murio())
				bola.remove(i);
			else{
				if(bol.getGenero()==Genero.HEMBRA){
					g.setColor(bol.getColor());
					g.fillOval((int)bol.getCoordenada().getX(),(int)bol.getCoordenada().getY(),bol.getTama(),bol.getTama());
				}else{
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
				for (int i = 0; i < bola.size(); i++) {
					bola1=bola.get(i);
					for (int j = 0; j < bola.size(); j++) {
						bola2=bola.get(j);
						if(bola1.colision(bola2) && i!=j){

						}
					}
					for (int h = 0; h < contextoAlicanola.getAlicanolas().size(); h++) {
						Alicanola alicanola=contextoAlicanola.getAlicanolas().get(h);
						if(alicanola.colision(bola1)){
							contextoAlicanola.crearFIsfirufas(alicanola);
							contextoAlicanola.eliminarALicanola(h);
						}
					}
					for (int j = 0; j < contextoAlicanola.getFisfirufas().size(); j++) {
						Fisfirufa fisfirufa=contextoAlicanola.getFisfirufas().get(j);
						if(fisfirufa.colision(bola1)){
							//aqui toka disminuir la energia de la bola
							contextoAlicanola.eliminarFisfirifuna(j);
						}
					}
				}

				repaint();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}		
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
