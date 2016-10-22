package gui;
import java.awt.Graphics;
import javax.swing.JPanel;
import logic.Bola;

@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {
	private Bola bola[];
	public Panel(Bola bola[]) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		setBounds(0,0, 800, 600);
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub		
		g.clearRect(0,0,1000,1000);
		for (int i = 0; i < bola.length; i++) {		
			g.setColor(bola[i].getColor());
			g.fillOval((int)bola[i].getCoordenada().getX(),(int)bola[i].getCoordenada().getY(),bola[i].getTama(),bola[i].getTama());
		}

	}
	@SuppressWarnings("unused")
	public void run() {

		Bola bola1=null;
		Bola bola2=null;
		while(true){
			for (int i = 0; i < bola.length; i++) {
				bola1=bola[i];
				for (int j = 0; j < bola.length; j++) {
					bola2=bola[j];
//					if(bola1.colision(bola2) && i!=j)
						
				}
			}
			repaint();	
		}		
	}
}
