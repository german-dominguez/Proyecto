package com.tix.vista.estudiante;

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

public class IngresoJustificacionEstudiante extends JPanel {
	
	private JLabel lblEvento;
	private static IngresoJustificacionEstudiante vista = new IngresoJustificacionEstudiante();
	private JComboBox<Evento> cmbEvento;
	JButton btnIngresar;
	JLabel lblInformacionAdicional;
	JTextArea txtInfoAdjunta;
	
	private Usuario usuario;
	/**
	 * Create the panel.
	 */
	public IngresoJustificacionEstudiante() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));
		
		lblEvento = new JLabel("Evento");
		lblEvento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEvento.setBounds(220, 83, 43, 21);
		add(lblEvento);
		
		JSeparator spEvento = new JSeparator();
		spEvento.setBackground(SystemColor.textHighlight);
		spEvento.setBounds(75, 133, 333, 14);
		add(spEvento);
		
		JLabel lblRegistroDeUsuario = new JLabel("INGRESO DE JUSTIFICACIÓN DE INASISTENCIA");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRegistroDeUsuario.setBounds(20, 12, 443, 41);
		add(lblRegistroDeUsuario);
		
		cmbEvento = new JComboBox<Evento>();		
		cmbEvento.setForeground(Color.DARK_GRAY);
		cmbEvento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEvento.setFocusable(false);
		cmbEvento.setBorder(null);
		cmbEvento.setBackground(Color.WHITE);
		cmbEvento.setBounds(75, 113, 333, 20);
		add(cmbEvento);
		
		txtInfoAdjunta = new JTextArea();
		txtInfoAdjunta.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtInfoAdjunta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtInfoAdjunta.setBounds(75, 201, 333, 100);
		add(txtInfoAdjunta);
		
		lblInformacionAdicional = new JLabel("Información adjunta (enlaces)");
		lblInformacionAdicional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInformacionAdicional.setBounds(152, 171, 178, 21);
		add(lblInformacionAdicional);
		
		btnIngresar = new JButton("INGRESAR");
		
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnIngresar.setFocusable(false);
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(SystemColor.textHighlight);
		btnIngresar.setBounds(152, 354, 178, 45);
		add(btnIngresar);
		
	}
	
	public void cargarEventos() {
		cmbEvento.removeAllItems();
		for (AsistEstEvto asistEstEvto : DatabaseManager.getInstance().getAsistEstEvtosBeanRemote().obtenerPorAsistencia("Ausencia")) {
			if (asistEstEvto.getEstudiante().getIdUsuario() == usuario.getIdUsuario()) {
				cmbEvento.addItem(DatabaseManager.getInstance().getEventosBeanRemote().obtenerEventoPorId(asistEstEvto.getEvento().getIdEvento()));
			}
		}
	}
	
	public void ingresarJustificacion() throws Exception {
		Justificacion justificacion = new Justificacion();
		justificacion.setInfoAdjunta(getTxtInfoAdjunta().getText());
		justificacion.setEstadoRecConJus(DatabaseManager.getInstance().getEstadosRecConJusBeanRemote().obtenerEstadoRecConJusPorId((1l)));
		justificacion.setEstudiante(DatabaseManager.getInstance().getEstudiantesBeanRemote().obtenerEstudiantePorId(usuario.getIdUsuario()));
		justificacion.setEvento(getCmbEvento());
		justificacion.setFechahora(new java.sql.Timestamp(System.currentTimeMillis()));
		
		DatabaseManager.getInstance().getJustificacionesBeanRemote().registro(justificacion);
	}
	
	public static IngresoJustificacionEstudiante getVista() {
		return vista;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getCmbEvento() {
		return (Evento) cmbEvento.getSelectedItem();
	}

	public void setCmbEvento(JComboBox<Evento> cmbEvento) {
		this.cmbEvento = cmbEvento;
	}

	public JTextArea getTxtInfoAdjunta() {
		return txtInfoAdjunta;
	}

	public void setTxtInfoAdjunta(JTextArea txtInfoAdjunta) {
		this.txtInfoAdjunta = txtInfoAdjunta;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}
	
	
}
