package logic;

public class Energia extends Thread{
	private int cantidadInicial;
	private int cantidadCambiante;
	private int cantidadTotal;
	public Energia(int cantidadInicial, int cantidadCambiante) {
		super();
		this.cantidadInicial = cantidadInicial;
		this.cantidadCambiante = cantidadCambiante;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int aux=0;
		while(true){
			cantidadTotal=cantidadInicial+cantidadCambiante;
			if(cantidadInicial<cantidadTotal){
				cantidadTotal--;				
				try {
					
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public int getCantidadCambiante() {
		return cantidadCambiante;
	}

	public void setCantidadCambiante(int cantidadCambiante) {
		this.cantidadCambiante = cantidadCambiante;
	}

	public int getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	
	
}
