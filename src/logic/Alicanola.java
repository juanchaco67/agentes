package logic;

public class Alicanola extends Thread{
	private int energia;
	private double radio;
	private Coordenada coordenada;

	public Alicanola(int energia, double radio, Coordenada coordenada) {
		super();
		this.energia = energia;
		this.radio= radio;
		this.coordenada = coordenada;
		
	}
	/**
	 * Metodo que comprueba si hubo colision entre dos agentes
	 * @param bola
	 * @return
	 */
	public boolean colision(Bola bola) {	
		return coordenada.getX()+crecimiento()>=bola.getCoordenada().getX() 
				&& coordenada.getX()+crecimiento()<=bola.getCoordenada().getX()+bola.getTama()
				&& coordenada.getY()+crecimiento()>=bola.getCoordenada().getY() 
				&& coordenada.getY()+crecimiento()<=bola.getCoordenada().getY()+bola.getTama();
	}
	/**
	 * este  metodo cambia el tamaño de la alicanola radialmente
	 */
	public double crecimiento(){
		return Math.PI+this.radio;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			
			try {
				radio+=0.5;
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	
}
