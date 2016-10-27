package gui;


import java.util.Random;

import controlador.BolaListener;

public class ContextoAlicanola extends Thread{
	private BolaListener bolaListener;
	private Random random;
	public ContextoAlicanola(BolaListener bolaListener) {
		super();
		this.bolaListener=bolaListener;
		this.random=new Random();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){			
			try {
				Thread.sleep(2000);
				for (int i = 0; i <random.nextInt(4)+1; i++) {
					bolaListener.crearAlicanola();
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	



}