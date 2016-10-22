package logic;


public class Area {
	private int ancho;
	private int alto;
	private Coordenada coordenadaInicial;
	public Area(int ancho, int alto, Coordenada coordenadaInicial) {

		this.ancho = ancho;
		this.alto = alto;
		this.coordenadaInicial = coordenadaInicial;
	}
	public boolean coordenadaAdentro(Coordenada coordenada, Bola bola){
		
		return (coordenada.getX()>this.coordenadaInicial.getX()) &&
				(coordenada.getX()+bola.getTama()<this.coordenadaInicial.getX()+ancho) &&
				(coordenada.getY()>this.coordenadaInicial.getY()) &&
				(coordenada.getY()+(bola.getTama())<this.coordenadaInicial.getY()+alto) ;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public Coordenada getCoordenadaInicial() {
		return coordenadaInicial;
	}
	public void setCoordenadaInicial(Coordenada coordenadaInicial) {
		this.coordenadaInicial = coordenadaInicial;
	}
	
	
}
