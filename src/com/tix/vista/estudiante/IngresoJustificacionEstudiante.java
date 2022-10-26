package com.tix.vista.estudiante;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
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

public class IngresoJustificacionEstudiante extends JPanel {
	
	private JLabel lblEvento;
	private JButton btnIngresar;
	private static IngresoJustificacionEstudiante vista = new IngresoJustificacionEstudiante();
	private JComboBox<String> cmbEvento;
	/**
	 * Create the panel.
	 */
	public IngresoJustificacionEstudiante() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(520, 500));
		
		lblEvento = new JLabel("Evento");
		lblEvento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEvento.setBounds(240, 85, 43, 21);
		add(lblEvento);
		
		JSeparator spEvento = new JSeparator();
		spEvento.setBackground(SystemColor.textHighlight);
		spEvento.setBounds(150, 125, 223, 14);
		add(spEvento);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnIngresar.setFocusable(false);
		btnIngresar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnIngresar.setBackground(SystemColor.textHighlight);
		btnIngresar.setActionCommand("");
		btnIngresar.setBounds(150, 357, 223, 49);
		add(btnIngresar);
		
		JLabel lblRegistroDeUsuario = new JLabel("INGRESO DE JUSTIFICACIÓN DE INASISTENCIA");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRegistroDeUsuario.setBounds(40, 12, 443, 41);
		add(lblRegistroDeUsuario);
		
		cmbEvento = new JComboBox<String>();
		cmbEvento.setForeground(Color.DARK_GRAY);
		cmbEvento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEvento.setFocusable(false);
		cmbEvento.setBorder(null);
		cmbEvento.setBackground(Color.WHITE);
		cmbEvento.setBounds(150, 107, 223, 20);
		add(cmbEvento);
		
		JTextArea txtAInformacionAdicional = new JTextArea();
		txtAInformacionAdicional.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtAInformacionAdicional.setBounds(150, 205, 223, 92);
		add(txtAInformacionAdicional);
		
		JLabel lblInformacionAdicional = new JLabel("Información adicional");
		lblInformacionAdicional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblInformacionAdicional.setBounds(197, 174, 128, 21);
		add(lblInformacionAdicional);
		
	}
	
	public static IngresoJustificacionEstudiante getVista() {
		return vista;
	}

	public JButton getBtnRegistrar() {
		return btnIngresar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnIngresar = btnRegistrar;
	}
	
}
