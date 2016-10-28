package logic;

public class Prueba extends Thread {
	private boolean activar;
	int numero=0;
	int otro=200;
	public Prueba() {
		// TODO Auto-generated constructor stub
		this.activar=true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			if(activar){
				try {
					if(0<otro){
					System.out.println("si");
					}else{
						activar=false;
					}
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}