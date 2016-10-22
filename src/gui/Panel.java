package gui;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.Bola;


@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {
	private ArrayList<Bola> bola;
	public Panel(ArrayList<Bola> bola) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		setBounds(0,0, 800, 600);
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub		
		g.clearRect(0,0,1000,1000);
		for (int i = 0; i < bola.size(); i++) {		
			Bola bol=bola.get(i);
			if(bol.murio())
				bola.remove(i);
			else{
				g.setColor(bol.getColor());
				g.fillOval((int)bol.getCoordenada().getX(),(int)bol.getCoordenada().getY(),bol.getTama(),bol.getTama());

			}

		}

	}
	@SuppressWarnings("unused")
	public void run() {

		Bola bola1=null;
		Bola bola2=null;
		while(true){
			try{
				for (int i = 0; i < bola.size(); i++) {
					bola1=bola.get(i);
					for (int j = 0; j < bola.size(); j++) {
						bola2=bola.get(j);
						//					if(bola1.colision(bola2) && i!=j)


					}
				}
				repaint();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}
}
