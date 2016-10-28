package logic;


import java.util.Random;

import controlador.BolaListener;

public class ThreadAlicanola extends Thread{
	private BolaListener bolaListener;
	private Random random;
	private boolean activar;
	public ThreadAlicanola(BolaListener bolaListener) {
		super();
		this.bolaListener=bolaListener;
		this.random=new Random();
		this.activar=false;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){		
			if(activar){
				System.out.println("entro");
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
	public boolean isActivar() {
		return activar;
	}
	public void setActivar(boolean activar) {
		this.activar = activar;
	}




}