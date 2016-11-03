package gui;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import controlador.BolaListener;
import logic.Bola;



@SuppressWarnings("serial")
public class Ventana extends JFrame implements VistaVentana{
	private Panel panel;

	private Thread thread;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabla;
	private DefaultTableModel modelo;
	private BolaListener  bolaListener;
	public Ventana(BolaListener bolaListener) {
		// TODO Auto-generated constructor stub
		this.bolaListener=bolaListener;
		setTitle("SIMULACION DE AGENTES");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(int) Toolkit.getDefaultToolkit().getScreenSize().height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciar();
		this.setVisible(true);
	}
	public void iniciar(){
		panel = new Panel(this.bolaListener,this);
		jScrollPane1 = new javax.swing.JScrollPane();
		tabla = new javax.swing.JTable();
		modelo=new DefaultTableModel();	
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));
		panel.setLayout(null);
		getContentPane().add(panel);	
		modelo.addColumn("EDAD");
		modelo.addColumn("ENERGIA(100e)");
		modelo.addColumn("GENERO");
		modelo.addColumn("CLASE");	
		modelo.addColumn("EVOLUCION");	
		modelo.addColumn("NACIMIENTOS");
		modelo.addColumn("MUERTOS");
		modelo.addColumn("ALICANOLAS");
		modelo.addColumn("FISFIRUFAS");


		tabla.setModel(modelo);
		tabla.setPreferredSize(new java.awt.Dimension(100,Toolkit.getDefaultToolkit().getScreenSize().height));
		jScrollPane1.setViewportView(tabla);

		getContentPane().add(jScrollPane1);
		thread=new Thread(panel);	
		thread.start();

	}
	@Override
	public void addTabla(Bola bola,int i) {
		// TODO Auto-generated method stub
		if(i==1){
			Object dato[]={
					bola.getEdad().getEdad(),
					bola.getEnergia().getCantidadInicial(),
					bola.getGenero(),
					bola.getClase(),
					bola.getEvolucion().getEvolucion(),
					"",
					"",
					"",
					""

			};
			modelo.addRow(dato);
		}else{
			Object dato[]={
				bola.getEdad().getEdad(),
				bola.getEnergia().getCantidadInicial(),
				bola.getGenero(),
				bola.getClase(),
				bola.getEvolucion().getEvolucion(),
				panel.getCantNacimientos(),
				panel.getCantMuertes(),
				panel.getCantAlicanolas(),
				panel.getCantFisfirufas()

		};
		modelo.addRow(dato);
	}
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