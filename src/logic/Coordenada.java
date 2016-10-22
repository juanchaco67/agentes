package logic;

public class Coordenada {
private double x;
private double y;

public Coordenada(double x, double y) {
	super();
	this.x = x;
	this.y = y;
}
public Coordenada() {
	super();
	this.x = 0.0;
	this.y = 0.0;
}
public void mover(double distancia,double angulo){
	this.x=this.x+distancia*Math.sin(angulo);
	this.y=this.y+distancia*Math.cos(angulo);
}
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}


}
