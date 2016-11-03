package logic;

public class Edad extends Thread {
	private Bola bola;
	private int edad;
	private int tiempo;
	public Edad(Bola bola,int tiempo) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.tiempo=tiempo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){			
			try {
				edad+=1;
				bola.setTama(bola.getTama()+1);
				Thread.sleep(tiempo);
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
