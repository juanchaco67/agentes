package logic;


import java.util.Random;

import controlador.BolaListener;

public class ThreadAlicanola extends Thread{
	private BolaListener bolaListener;
	private Random random;

	public ThreadAlicanola(BolaListener bolaListener) {
		super();
		this.bolaListener=bolaListener;
		this.random=new Random();
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){		
			if(bolaListener.getDatos()[3]>0 && bolaListener.getDatos()[2]>0){
				try {
					Thread.sleep(bolaListener.getDatos()[2]);
					for (int i = 0; i <random.nextInt(bolaListener.getDatos()[3])+1; i++) {
						bolaListener.crearAlicanola();
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}




}