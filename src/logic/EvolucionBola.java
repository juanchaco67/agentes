package logic;

public class EvolucionBola extends Thread{
	private Bola bola;

	private Evolucion evolucion;
	private boolean comenzar;
	private int tiempo;
	public EvolucionBola(Bola bola,byte opcion,int tiempo) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.tiempo=tiempo;
		if(opcion==1)
			this.evolucion=Evolucion.aleatorioEvolucion();
		else
			this.evolucion=Evolucion.NACE;
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
					Thread.sleep(tiempo);
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
			bola.getEdad().setEdad(1);
			bola.setTama(bola.getTama()+5);			
			break;	
		case INFANCIA:
			bola.getEdad().setEdad(10);
			bola.setTama(bola.getTama()+10);		
			break;
		case ADOLECENCIA:
			bola.getEdad().setEdad(20);
			bola.setTama(bola.getTama()+15);		
			break;
		case ADULTOS:
			bola.getEdad().setEdad(30);
			bola.setTama(bola.getTama()+20);			
			break;
		case VEJEZ:
			bola.getEdad().setEdad(40);
			bola.setTama(bola.getTama()+25);		
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
