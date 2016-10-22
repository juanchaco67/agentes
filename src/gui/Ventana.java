package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

import logic.Bola;


@SuppressWarnings("serial")
public class Ventana extends JFrame{
	private Panel panel;
	private Bola bola[];
	private Thread thread;
	public Ventana(Bola bola[]) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(int) Toolkit.getDefaultToolkit().getScreenSize().height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciar();
		this.setVisible(true);
	}
	public void iniciar(){
		panel = new Panel(bola);
		thread=new Thread(panel);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		thread.start();
	}
}
