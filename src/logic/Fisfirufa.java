package logic;

public class Fisfirufa {
	private int tam;
	private Coordenada coordenada;

	public Fisfirufa(int tam, Coordenada coordenada) {
		super();
		this.tam = tam;
		this.coordenada = coordenada;
	}
	/**
	 * Metodo que comprueba si hubo colision entre dos agentes
	 * @param bola
	 * @return
	 */
	public boolean colision(Bola bola) {	
		return coordenada.getX()+tam>=bola.getCoordenada().getX() 
				&& coordenada.getX()+tam<=bola.getCoordenada().getX()+bola.getTama()
				&& coordenada.getY()+tam>=bola.getCoordenada().getY() 
				&& coordenada.getY()+tam<=bola.getCoordenada().getY()+bola.getTama();
	}
	public int getTam() {
		return tam;
	}
	public void setTam(int tam) {
		this.tam = tam;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
}
