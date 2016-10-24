package logic;

import java.util.Random;

public class Energia extends Thread{
	private int cantidadInicial;
	private int cantidadAdicional;
	private Random random;
	private boolean activar;
	public Energia(int cantidadInicial, int cantidadCambiante) {
		super();
		this.cantidadInicial = cantidadInicial;
		this.random=new Random();
		this.activar=false;
		this.cantidadAdicional=0;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	
		while(true){
			if(activar){
				try {	
					if(0<cantidadAdicional){
						cantidadAdicional--;
						cantidadInicial--;
					}else{
						activar=false;
						cantidadAdicional=0;
					}				
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}


	}
	public void adicionarEnergia(){
		this.cantidadAdicional+=(20+random.nextInt( (100+1) - 20));
		cantidadInicial=cantidadInicial+cantidadAdicional;

	}
	public void disminuirEnergia(){
		this.cantidadInicial-=1;
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public int getCantidadAdicional() {
		return cantidadAdicional;
	}


	public void setCantidadAdicional(int cantidadAdicional) {
		this.cantidadAdicional = cantidadAdicional;
	}


	public boolean isActivar() {
		return activar;
	}

	public void setActivar(boolean activar) {
		this.activar = activar;
	}


}
