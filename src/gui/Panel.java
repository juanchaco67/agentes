package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import logic.Bola;

public class Panel extends JPanel implements Runnable {
	private Bola bola[];
	public Panel(Bola bola[]) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		setBounds(0,0, 800, 600);
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paint(g);	
		g.clearRect(0,0,1000,1000);
		for (int i = 0; i < bola.length; i++) {
			g.fillOval((int)bola[i].getCoordenada().getX(),(int)bola[i].getCoordenada().getY(),bola[i].getTama(),bola[i].getTama());
		}
	
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			repaint();
		
		}
		
	}
}
