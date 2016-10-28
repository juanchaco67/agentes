package logic;

import logic.Bola;
import controlador.BolaListener;

public class ThreadEnergia extends Thread{
private BolaListener bolaListener;
	public ThreadEnergia(BolaListener bolaListener) {
		// TODO Auto-generated constructor stub
		this.bolaListener=bolaListener;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			for (int i = 0; i < bolaListener.getBola().size(); i++) {
				Bola bola=bolaListener.getBola().get(i);
				bola.getEnergia().run();
			}
		}
	}
}
