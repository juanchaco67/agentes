package logic;

import java.util.Random;

public class Energia extends Thread{
	private int cantidadInicial;
	private int cantidadTotal;
	private Random random;
	private boolean activar;
	public Energia(int cantidadInicial, int cantidadCambiante) {
		super();
		this.cantidadInicial = cantidadInicial;
		this.random=new Random();
		this.activar=false;
		this.cantidadTotal=cantidadInicial+cantidadCambiante;

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	
		while(true){

			try {
				if(cantidadInicial<cantidadTotal)
					cantidadTotal-=1;	
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public void adicionarEnergia(){
		this.cantidadTotal=cantidadInicial+(20+random.nextInt( (100+1) - 20));
	}
	public void disminuirEnergia(){
		this.cantidadInicial-=5;
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public boolean isActivar() {
		return activar;
	}

	public void setActivar(boolean activar) {
		this.activar = activar;
	}


}
