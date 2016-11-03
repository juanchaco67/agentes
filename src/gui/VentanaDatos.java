package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controlador.BolaListener;

@SuppressWarnings("serial")
public class VentanaDatos extends JDialog implements ActionListener{
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnIniciar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;

	private javax.swing.JTextField txtCantidadAlicanola;
	private javax.swing.JTextField txtEnergia;
	private javax.swing.JTextField txtPoblacion;
	private javax.swing.JTextField txtTiempoAlicanola;

	private javax.swing.JTextField txtTiempoEvolucion;
	private BolaListener bolaListener;

	public VentanaDatos(BolaListener bolaListener) {
		// TODO Auto-generated constructor stub
		setTitle("DATOS PARA LA SIMULACION");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width,(int) Toolkit.getDefaultToolkit().getScreenSize().height);
		setLocationRelativeTo(null);
		this.bolaListener=bolaListener;
		iniciar();
		this.setVisible(true);
	}
	public void iniciar(){

		jLabel1 = new javax.swing.JLabel();
		txtPoblacion = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtEnergia = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtTiempoAlicanola = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtCantidadAlicanola = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtTiempoEvolucion = new javax.swing.JTextField();

		btnCancelar = new javax.swing.JButton();
		btnIniciar = new javax.swing.JButton();


		getContentPane().setLayout(new java.awt.GridLayout(7, 2));

		jLabel1.setText("CANTIDAD DE LA POBLACION (int)");
		getContentPane().add(jLabel1);

		txtPoblacion.setText("1000");

		getContentPane().add(txtPoblacion);

		jLabel2.setText("CANTIDAD DE ENERGIA  INICIAL > 0 (int)");
		getContentPane().add(jLabel2);

		txtEnergia.setText("100");
		getContentPane().add(txtEnergia);

		jLabel3.setText("TIEMPO PARA APARECER ALICANOLA (int)(milisegundos)");
		getContentPane().add(jLabel3);

		txtTiempoAlicanola.setText("3000");
		getContentPane().add(txtTiempoAlicanola);

		jLabel4.setText("CANTIDAD DE ALICANOLA EN UN  TIEMPO (int)");
		getContentPane().add(jLabel4);

		txtCantidadAlicanola.setText("4");
		getContentPane().add(txtCantidadAlicanola);

		jLabel5.setText("TIEMPO EVOLUCION POR ETAPAS (int)(milisegundos)");
		getContentPane().add(jLabel5);

		txtTiempoEvolucion.setText("30000");
		getContentPane().add(txtTiempoEvolucion);


		btnCancelar.setText("CANCELAR");
		getContentPane().add(btnCancelar);

		btnIniciar.setText("INICIAR SIMULACION");

		getContentPane().add(btnIniciar);

		btnIniciar.addActionListener(this);
		btnCancelar.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnIniciar){
			bolaListener.addDatos(0,Integer.parseInt(txtPoblacion.getText()));
			bolaListener.addDatos(1,Integer.parseInt(txtEnergia.getText()));
			bolaListener.addDatos(2,Integer.parseInt(txtTiempoAlicanola.getText()));
			bolaListener.addDatos(3,Integer.parseInt(txtCantidadAlicanola.getText()));	
			bolaListener.addDatos(4,Integer.parseInt(txtTiempoEvolucion.getText()));
		
			if(bolaListener.getDatos()[1]>0){
				for (int i = 0; i < bolaListener.getDatos()[0]; i++) {
					bolaListener.crearPispirispi(1);
				}
			bolaListener.getThreadAlicanola().start();
			new Ventana(bolaListener);	
			this.setVisible(false);
			}else
				JOptionPane.showMessageDialog(null, "INGRESE UNA ENERGIA MAYOR QUE CERO (ENERGIA > 0)");
				

		}else{
			System.exit(0);
		}

	}
}
