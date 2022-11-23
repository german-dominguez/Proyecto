package com.tix.vista.analista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.AsistEstEvto;
import com.tix.modelo.entidades.Departamento;
import com.tix.modelo.entidades.EstadoRecConJus;
import com.tix.modelo.entidades.Evento;
import com.tix.modelo.entidades.Justificacion;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.entidades.Itr;

public class AccionJustificacionAnalista extends JPanel {
	private static AccionJustificacionAnalista vista = new AccionJustificacionAnalista();
	JButton btnConfirmar;
	JLabel lblInformacionAdicional;
	JTextArea txtInfoAdjunta;
	
	private Usuario usuario;
	private JLabel lblEstudiante_1;
	private JTextField txtEstudiante;
	private JSeparator spPrimerNombre;
	private JLabel lblEstudiante;
	private JTextField txtEvento;
	private JSeparator spPrimerNombre_1;
	private JLabel lblDetalleAccin;
	private JTextArea txtInfoAdjunta_1;
	private JComboBox<Itr> cmbITR;
	private JSeparator spITR;
	private JLabel lblEstado_1;
	private JLabel lblFechaYHora;
	private JTextField textField;
	private JSeparator spPrimerNombre_2;
	private JLabel lblDatosDeLa;
	private JSeparator spDatosPersonales;
	private JLabel lblAccionesSobreLa;
	private JSeparator spDatosAcademicos;
	private JSeparator spVertical;
	/**
	 * Create the panel.
	 */
	public AccionJustificacionAnalista() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));
		
		JLabel lblRegistroDeUsuario = new JLabel("ACCIÓN SOBRE JUSTIFICACIÓN DE INASISTENCIA");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRegistroDeUsuario.setBounds(20, 12, 472, 41);
		add(lblRegistroDeUsuario);
		
		txtInfoAdjunta = new JTextArea();
		txtInfoAdjunta.setEnabled(false);
		txtInfoAdjunta.setEditable(false);
		txtInfoAdjunta.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtInfoAdjunta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtInfoAdjunta.setBounds(20, 260, 299, 100);
		add(txtInfoAdjunta);
		
		lblInformacionAdicional = new JLabel("Información adjunta");
		lblInformacionAdicional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInformacionAdicional.setBounds(20, 239, 119, 21);
		add(lblInformacionAdicional);
		
		btnConfirmar = new JButton("CONFIRMAR");
		
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBorder(null);
		btnConfirmar.setBackground(SystemColor.textHighlight);
		btnConfirmar.setBounds(443, 389, 178, 45);
		add(btnConfirmar);
		
		lblEstudiante_1 = new JLabel("Estudiante");
		lblEstudiante_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstudiante_1.setBounds(20, 122, 63, 21);
		add(lblEstudiante_1);
		
		txtEstudiante = new JTextField();
		txtEstudiante.setEnabled(false);
		txtEstudiante.setEditable(false);
		txtEstudiante.setForeground(Color.DARK_GRAY);
		txtEstudiante.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEstudiante.setColumns(10);
		txtEstudiante.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEstudiante.setBounds(20, 143, 299, 20);
		add(txtEstudiante);
		
		spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(20, 163, 299, 14);
		add(spPrimerNombre);
		
		lblEstudiante = new JLabel("Evento");
		lblEstudiante.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstudiante.setBounds(20, 173, 44, 21);
		add(lblEstudiante);
		
		txtEvento = new JTextField();
		txtEvento.setEditable(false);
		txtEvento.setEnabled(false);
		txtEvento.setForeground(Color.DARK_GRAY);
		txtEvento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEvento.setColumns(10);
		txtEvento.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtEvento.setBounds(20, 192, 299, 20);
		add(txtEvento);
		
		spPrimerNombre_1 = new JSeparator();
		spPrimerNombre_1.setBackground(SystemColor.textHighlight);
		spPrimerNombre_1.setBounds(20, 212, 299, 14);
		add(spPrimerNombre_1);
		
		lblDetalleAccin = new JLabel("Detalle acción");
		lblDetalleAccin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDetalleAccin.setBounds(383, 239, 84, 21);
		add(lblDetalleAccin);
		
		txtInfoAdjunta_1 = new JTextArea();
		txtInfoAdjunta_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtInfoAdjunta_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtInfoAdjunta_1.setBounds(383, 260, 299, 100);
		add(txtInfoAdjunta_1);
		
		cmbITR = new JComboBox<Itr>();
		cmbITR.setForeground(Color.DARK_GRAY);
		cmbITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbITR.setFocusable(false);
		cmbITR.setBorder(null);
		cmbITR.setBackground(Color.WHITE);
		cmbITR.setBounds(383, 142, 299, 20);
		add(cmbITR);
		
		spITR = new JSeparator();
		spITR.setBackground(SystemColor.textHighlight);
		spITR.setBounds(383, 162, 299, 14);
		add(spITR);
		
		lblEstado_1 = new JLabel("Estado");
		lblEstado_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado_1.setBounds(383, 122, 44, 21);
		add(lblEstado_1);
		
		lblFechaYHora = new JLabel("Fecha y hora última acción");
		lblFechaYHora.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaYHora.setBounds(383, 173, 191, 21);
		add(lblFechaYHora);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBounds(383, 204, 299, 20);
		add(textField);
		
		spPrimerNombre_2 = new JSeparator();
		spPrimerNombre_2.setBackground(SystemColor.textHighlight);
		spPrimerNombre_2.setBounds(383, 224, 299, 14);
		add(spPrimerNombre_2);
		
		lblDatosDeLa = new JLabel("Datos de la justificación");
		lblDatosDeLa.setForeground(SystemColor.textHighlight);
		lblDatosDeLa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosDeLa.setBounds(20, 79, 299, 27);
		add(lblDatosDeLa);
		
		spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(20, 109, 299, 14);
		add(spDatosPersonales);
		
		lblAccionesSobreLa = new JLabel("Acciones sobre la justificación");
		lblAccionesSobreLa.setForeground(SystemColor.textHighlight);
		lblAccionesSobreLa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblAccionesSobreLa.setBounds(383, 79, 299, 27);
		add(lblAccionesSobreLa);
		
		spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(383, 109, 299, 14);
		add(spDatosAcademicos);
		
		spVertical = new JSeparator();
		spVertical.setOrientation(SwingConstants.VERTICAL);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setBounds(355, 121, 18, 286);
		add(spVertical);
		
	}
	
	public void cargarDatos(Justificacion justificacion) {
		txtEstudiante.setText(justificacion.getEstudiante().getNombre1() + " " + justificacion.getEstudiante().getNombre1());
		txtEvento.setText(justificacion.getEvento().getTitulo());
		txtInfoAdjunta.setText(justificacion.getInfoAdjunta());
		
	}
	
	
	public static AccionJustificacionAnalista getVista() {
		return vista;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public JTextArea getTxtInfoAdjunta() {
		return txtInfoAdjunta;
	}

	public void setTxtInfoAdjunta(JTextArea txtInfoAdjunta) {
		this.txtInfoAdjunta = txtInfoAdjunta;
	}

	public JButton getBtnIngresar() {
		return btnConfirmar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnConfirmar = btnIngresar;
	}
	
	
}