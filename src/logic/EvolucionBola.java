package logic;

public class EvolucionBola extends Thread{
	private Bola bola;

	private Evolucion evolucion;
	private boolean comenzar;
	private int tiempo;
	private int evolAntes;
	private int evolDespues;


	public EvolucionBola(Bola bola,byte opcion,int tiempo) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.tiempo=tiempo;
		if(opcion==1)
			this.evolucion=Evolucion.aleatorioEvolucion();
		else
			this.evolucion=Evolucion.NACE;
		addTam();
		this.comenzar=true;



	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	
		while(comenzar){
			try {

			
					Thread.sleep(tiempo);
					switch (evolucion) {
					case NACE:						
						evolucion=Evolucion.INFANCIA;	
						this.evolAntes=0;
						this.evolDespues=10;
						bola.setTama(bola.getTama()+5);	
						bola.setVelocidad(50);	
				
						break;	
					case INFANCIA:
						evolucion=Evolucion.ADOLECENCIA;	
						this.evolAntes=10;
						this.evolDespues=20;
						bola.setTama(bola.getTama()+10);	
						bola.setVelocidad(200);
					
						break;
					case ADOLECENCIA:
						evolucion=Evolucion.ADULTOS;
						this.evolAntes=20;
						this.evolDespues=40;
						bola.setTama(bola.getTama()+20);
						bola.setVelocidad(300);
						
						break;
					case ADULTOS:
						evolucion=Evolucion.VEJEZ;	
						this.evolAntes=40;
						this.evolDespues=60;
						bola.setTama(bola.getTama()+25);	
						bola.setVelocidad(100);
					
						break;
					case VEJEZ:						
						evolucion=Evolucion.MUERE;	
						this.evolAntes=60;
						this.evolDespues=0;
						bola.setTama(0);	
						bola.setVelocidad(0);
				
						break;
					case MUERE:				
						comenzar=false;
						break;
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

			this.evolAntes=0;
			this.evolDespues=10;
			bola.setTama(bola.getTama()+5);	
			bola.setVelocidad(50);	
			bola.getEdad().setEdad(0);
		
			break;	
		case INFANCIA:

			this.evolAntes=10;
			this.evolDespues=20;
			bola.setTama(bola.getTama()+10);	
			bola.setVelocidad(200);
			bola.getEdad().setEdad(10);
		
			break;
		case ADOLECENCIA:

			this.evolAntes=20;
			this.evolDespues=40;
			bola.setTama(bola.getTama()+20);
			bola.setVelocidad(300);
			bola.getEdad().setEdad(20);
			break;
		case ADULTOS:

			this.evolAntes=40;
			this.evolDespues=60;
			bola.setTama(bola.getTama()+25);	
			bola.setVelocidad(100);
			bola.getEdad().setEdad(40);
			break;
		case VEJEZ:						

			this.evolAntes=60;
			this.evolDespues=0;
			bola.setTama(0);	
			bola.setVelocidad(0);
			bola.getEdad().setEdad(60);
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

	public int getEvolAntes() {
		return evolAntes;
	}

	public void setEvolAntes(int evolAntes) {
		this.evolAntes = evolAntes;
	}

	public int getEvolDespues() {
		return evolDespues;
	}

	public void setEvolDespues(int evolDespues) {
		this.evolDespues = evolDespues;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}




}
