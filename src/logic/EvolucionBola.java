package logic;

public class EvolucionBola extends Thread{
	private Bola bola;
	private static final int TIEMPO=10000;
	private Evolucion evolucion;
	private boolean comenzar;
	public EvolucionBola(Bola bola) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.evolucion=Evolucion.aleatorioEvolucion();

		this.comenzar=true;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(comenzar){
			try {

				for (Evolucion evol:Evolucion.values()) {
					addTam();
					Thread.sleep(TIEMPO);
					switch (evolucion) {
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
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * este metodo fuerza a cambiar de evolucion
	 * @param evolucion
	 */

	@SuppressWarnings("incomplete-switch")
	private void addTam(){
		switch (evolucion) {
		case NACE:
			bola.setTama(5);			
			break;	
		case INFANCIA:
			bola.setTama(15);		
			break;
		case ADOLECENCIA:
			bola.setTama(25);		
			break;
		case ADULTOS:
			bola.setTama(35);			
			break;
		case VEJEZ:
			bola.setTama(45);		
			break;		
		}
	}
	public void cambioEvolucion(Evolucion evolucion){
		this.evolucion=evolucion;
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
