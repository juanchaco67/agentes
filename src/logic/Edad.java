package logic;

public class Edad extends Thread {
	private Bola bola;
	private int edad;

	public Edad(Bola bola) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){			
			try {
				edad+=1;
				bola.setTama(bola.getTama()+1);
				Thread.sleep((bola.getEvolucion().getTiempo())/(Math.abs((bola.getEvolucion().getEvolDespues()-bola.getEvolucion().getEvolAntes()))));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Bola getBola() {
		return bola;
	}
	public void setBola(Bola bola) {
		this.bola = bola;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
