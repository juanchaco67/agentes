package gui;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import logic.Alicanola;
import logic.Bola;
import logic.Fisfirufa;


@SuppressWarnings("serial")
public class Ventana extends JFrame{
	private Panel panel;
	private ArrayList<Bola> bola;
	private ArrayList<Alicanola>alicanolas;
	private ArrayList<Fisfirufa>fisfirufas;
	private Thread thread;
	public Ventana(ArrayList<Bola> bola,ArrayList<Alicanola>alicanolas,ArrayList<Fisfirufa>fisfirufas) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.fisfirufas=fisfirufas;
		this.alicanolas=alicanolas;
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(int) Toolkit.getDefaultToolkit().getScreenSize().height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciar();
		this.setVisible(true);
	}
	public void iniciar(){
		panel = new Panel(bola,alicanolas,fisfirufas);
		thread=new Thread(panel);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		thread.start();
	}
}
