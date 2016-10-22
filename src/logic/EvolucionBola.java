package logic;
public class EvolucionBola extends Thread{
	private Bola bola;
	private static final int TIEMPO=6000;
	private Evolucion evolucion;
	private boolean comenzar;
	public EvolucionBola(Bola bola) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.evolucion=Evolucion.NACE;
		this.comenzar=true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(comenzar){
			try {
				
				for (Evolucion evol:Evolucion.values()) {	
					switch (evol) {
					case NACE:
						evolucion=Evolucion.INFANCIA;
						break;	
					case INFANCIA:
						evolucion=Evolucion.ADOLECENCIA;
						break;
					case ADOLECENCIA:
						evolucion=Evolucion.ADULTOS;
						break;
					case ADULTOS:
						evolucion=Evolucion.VEJEZ;
						break;
					case VEJEZ:
						evolucion=Evolucion.MUERE;
						break;
					case MUERE:
						comenzar=false;
						break;
					}
					Thread.sleep(TIEMPO);
				}

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
	public Evolucion getEvolucion() {
		return evolucion;
	}
	public void setEvolucion(Evolucion evolucion) {
		this.evolucion = evolucion;
	}



}
