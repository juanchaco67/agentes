package gui;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import logic.Alicanola;
import logic.Bola;
import logic.Fisfirufa;


@SuppressWarnings("serial")
public class Ventana extends JFrame implements VistaVentana{
	private Panel panel;
	private ArrayList<Bola> bola;
	private ArrayList<Alicanola>alicanolas;
	private ArrayList<Fisfirufa>fisfirufas;
	private Thread thread;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabla;
	private DefaultTableModel modelo;
	public Ventana(ArrayList<Bola> bola,ArrayList<Alicanola>alicanolas,ArrayList<Fisfirufa>fisfirufas) {
		// TODO Auto-generated constructor stub
		this.bola=bola;
		this.fisfirufas=fisfirufas;
		this.alicanolas=alicanolas;
		setTitle("SIMULACION DE AGENTES");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(int) Toolkit.getDefaultToolkit().getScreenSize().height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciar();
		this.setVisible(true);
	}
	public void iniciar(){
		panel = new Panel(bola,alicanolas,fisfirufas,this);
		jScrollPane1 = new javax.swing.JScrollPane();
		tabla = new javax.swing.JTable();
		modelo=new DefaultTableModel();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

		panel.setPreferredSize(new java.awt.Dimension(800, 800));
		panel.setRequestFocusEnabled(false);

		javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
		panel.setLayout(panelLayout);
		panelLayout.setHorizontalGroup(
				panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
				);
		panelLayout.setVerticalGroup(
				panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				);

		getContentPane().add(panel);	
		modelo.addColumn("EDAD");
		modelo.addColumn("ENERGIA(100e)");
		modelo.addColumn("GENERO");
		modelo.addColumn("CLASE");	
		modelo.addColumn("EVOLUCION");	
		
		tabla.setModel(modelo);
		tabla.setPreferredSize(new java.awt.Dimension(100,Toolkit.getDefaultToolkit().getScreenSize().height));
		jScrollPane1.setViewportView(tabla);

		getContentPane().add(jScrollPane1);
		thread=new Thread(panel);	
		thread.start();

	}
	@Override
	public void addTabla(Bola bola) {
		// TODO Auto-generated method stub
		Object dato[]={
				bola.getEdad().getEdad(),
				bola.getEnergia().getCantidadTotal(),
				bola.getGenero(),
				bola.getClase(),
				bola.getEvolucion().getEvolucion()
		};
		modelo.addRow(dato);
	}
	@Override
	public void eliminarDatos() {
		// TODO Auto-generated method stub
	       int filas=tabla.getRowCount();
           for (int i = 0;filas>i; i++) {
        	   
               modelo.removeRow(0);
           }
	}
}
