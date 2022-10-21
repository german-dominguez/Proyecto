package com.tix.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class RegistroPanel extends JPanel {
	private JTextField txtDocumento;
	private JTextField txtPrimerNombre;
	private JTextField txtSegundoNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private JTextField txtEmailInstitucional;
	private JPasswordField txtContrasenia;
	private JPasswordField txtReingreseContrasenia;
	private JTextField txtTelefono;
	private JTextField txtEmailPersonal;
	private JTextField txtGeneracion;
	
	private JLabel lblPrimerNombre;
	private JLabel lblSegundoNombre;
	private JLabel lblSegundoApellido;
	private JLabel lblDocumento;
	private JLabel lblReingreseContrasenia;
	private JLabel lblTelefono;
	private JLabel lblArea;
	private JLabel lblTipoUsuario;
	private JLabel lblLocalidad;
	private JLabel lblDatosPersonales;
	private JLabel lblDatosAcadmicos;
	private JLabel lblPrimerApellido;
	private JLabel lblEmailInstitucional;
	private JLabel lblContrasenia;
	private JLabel lblFechaNacimiento;
	private JLabel lblEmailPersonal;
	private JLabel lblITR;
	private JLabel lblGeneracion;
	private JLabel lblRol;
	private JLabel lblDepartamento;
	
	private JSeparator spDocumento;
	private JSeparator spPrimerNombre;
	private JSeparator spSegundoNombre;
	private JSeparator spRol;
	private JSeparator spPrimerApellido;
	private JSeparator spSegundoApellido;
	private JSeparator spCentral;
	private JSeparator spEmailInstitucional;
	private JSeparator spContrasenia;
	private JSeparator spEmailPersonal;
	private JSeparator spDepartamento;
	private JSeparator spLocalidad;
	private JSeparator spTelefono;
	private JSeparator spFechaNacimiento;
	private JSeparator spDatosPersonales;
	private JSeparator spDatosAcademicos;
	private JSeparator spITR;
	private JSeparator spGeneracion;
	private JSeparator spReintreseContrasenia;
	private JSeparator spTipoUsuario;
	private JSeparator spArea;
	
	private JComboBox<Integer> comboBoxDia;
	private JComboBox<Integer> comboBoxMes;
	private JComboBox<Integer> comboBoxAño;
	private JComboBox<String> cmbLocalidad;
	private JComboBox<String> cmbDepartamento;
	private JComboBox<String> cmbITR;
	private JComboBox<String> cmbArea; 
	private JComboBox<String> cmbRol;
	private JComboBox<String> cmbTipoUsuario;
	private JButton btnRegistrar;
	private JButton btnIniciarSesion;
	
	/**
	 * Create the panel.
	 */
	public RegistroPanel() {
		setLayout(null);
		setSize(new Dimension(1060, 700));
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDocumento.setBounds(290, 347, 86, 21);
		add(lblDocumento);
		
		lblReingreseContrasenia = new JLabel("Reingrese su contraseña");
		lblReingreseContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblReingreseContrasenia.setBounds(740, 227, 164, 21);
		add(lblReingreseContrasenia);
		
		lblPrimerNombre = new JLabel("Primer nombre");
		lblPrimerNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPrimerNombre.setBounds(90, 167, 114, 21);
		add(lblPrimerNombre);
		
		lblDatosAcadmicos = new JLabel("Datos académicos");
		lblDatosAcadmicos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosAcadmicos.setBounds(540, 97, 299, 27);
		add(lblDatosAcadmicos);
		
		lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(90, 97, 299, 27);
		add(lblDatosPersonales);
		
		lblTelefono = new JLabel("Teléfono de contacto");
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTelefono.setBounds(290, 287, 150, 21);
		add(lblTelefono);
		
		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSegundoNombre.setBounds(290, 167, 135, 21);
		add(lblSegundoNombre);
		
		lblArea = new JLabel("Área");
		lblArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblArea.setBounds(540, 347, 135, 21);
		add(lblArea);
		
		lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSegundoApellido.setBounds(290, 227, 124, 21);
		add(lblSegundoApellido);
		
		lblTipoUsuario = new JLabel("Tipo de Usuario");
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTipoUsuario.setBounds(540, 287, 135, 21);
		add(lblTipoUsuario);
		
		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLocalidad.setBounds(290, 407, 135, 21);
		add(lblLocalidad);
		
		lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPrimerApellido.setBounds(90, 227, 111, 21);
		add(lblPrimerApellido);
		
		lblEmailInstitucional = new JLabel("Email institucional");
		lblEmailInstitucional.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEmailInstitucional.setBounds(540, 167, 135, 21);
		add(lblEmailInstitucional);
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblContrasenia.setBounds(540, 227, 100, 21);
		add(lblContrasenia);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblFechaNacimiento.setBounds(90, 347, 150, 21);
		add(lblFechaNacimiento);
		
		lblEmailPersonal = new JLabel("Email personal");
		lblEmailPersonal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEmailPersonal.setBounds(90, 287, 111, 21);
		add(lblEmailPersonal);
		
		lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblITR.setBounds(740, 167, 135, 21);
		add(lblITR);
		
		lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGeneracion.setBounds(740, 287, 111, 21);
		add(lblGeneracion);
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRol.setBounds(740, 347, 135, 21);
		add(lblRol);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDepartamento.setBounds(90, 407, 135, 21);
		add(lblDepartamento);
		
		txtDocumento = new JTextField();
		txtDocumento.setForeground(SystemColor.textInactiveText);
		txtDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(290, 367, 150, 20);
		add(txtDocumento);
		
		txtPrimerNombre = new JTextField();
		txtPrimerNombre.setForeground(SystemColor.textInactiveText);
		txtPrimerNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtPrimerNombre.setColumns(10);
		txtPrimerNombre.setBorder(null);
		txtPrimerNombre.setBounds(90, 187, 150, 20);
		add(txtPrimerNombre);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setForeground(SystemColor.textInactiveText);
		txtSegundoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSegundoNombre.setColumns(10);
		txtSegundoNombre.setBorder(null);
		txtSegundoNombre.setBounds(290, 187, 150, 20);
		add(txtSegundoNombre);
		
		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setForeground(SystemColor.textInactiveText);
		txtPrimerApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtPrimerApellido.setColumns(10);
		txtPrimerApellido.setBorder(null);
		txtPrimerApellido.setBounds(90, 247, 150, 20);
		add(txtPrimerApellido);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setForeground(SystemColor.textInactiveText);
		txtSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBorder(null);
		txtSegundoApellido.setBounds(290, 247, 150, 20);
		add(txtSegundoApellido);
		
		txtEmailInstitucional = new JTextField();
		txtEmailInstitucional.setForeground(SystemColor.textInactiveText);
		txtEmailInstitucional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtEmailInstitucional.setColumns(10);
		txtEmailInstitucional.setBorder(null);
		txtEmailInstitucional.setBounds(540, 187, 150, 20);
		add(txtEmailInstitucional);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setForeground(SystemColor.textInactiveText);
		txtContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtContrasenia.setBounds(540, 247, 150, 20);
		add(txtContrasenia);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(SystemColor.textInactiveText);
		txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(290, 307, 150, 20);
		add(txtTelefono);
		
		txtEmailPersonal = new JTextField();
		txtEmailPersonal.setToolTipText("");
		txtEmailPersonal.setForeground(SystemColor.textInactiveText);
		txtEmailPersonal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtEmailPersonal.setColumns(10);
		txtEmailPersonal.setBorder(null);
		txtEmailPersonal.setBounds(90, 307, 150, 20);
		add(txtEmailPersonal);
		
		txtGeneracion = new JTextField();
		txtGeneracion.setForeground(SystemColor.textInactiveText);
		txtGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtGeneracion.setColumns(10);
		txtGeneracion.setBorder(null);
		txtGeneracion.setBounds(740, 307, 150, 20);
		add(txtGeneracion);
		
		txtReingreseContrasenia = new JPasswordField();
		txtReingreseContrasenia.setForeground(SystemColor.textInactiveText);
		txtReingreseContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtReingreseContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtReingreseContrasenia.setBounds(740, 247, 150, 20);
		add(txtReingreseContrasenia);
		
		spDocumento = new JSeparator();
		spDocumento.setBackground(SystemColor.textHighlight);
		spDocumento.setBounds(290, 387, 150, 14);
		add(spDocumento);
		
		spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(90, 207, 150, 14);
		add(spPrimerNombre);
		
		spSegundoNombre = new JSeparator();
		spSegundoNombre.setBackground(SystemColor.textHighlight);
		spSegundoNombre.setBounds(290, 207, 150, 14);
		add(spSegundoNombre);
		
		spRol = new JSeparator();
		spRol.setBackground(SystemColor.textHighlight);
		spRol.setBounds(740, 387, 150, 14);
		add(spRol);
		
		spPrimerApellido = new JSeparator();
		spPrimerApellido.setBackground(SystemColor.textHighlight);
		spPrimerApellido.setBounds(90, 267, 150, 14);
		add(spPrimerApellido);
		
		spSegundoApellido = new JSeparator();
		spSegundoApellido.setBackground(SystemColor.textHighlight);
		spSegundoApellido.setBounds(290, 267, 150, 14);
		add(spSegundoApellido);
		
		spCentral = new JSeparator();
		spCentral.setOrientation(SwingConstants.VERTICAL);
		spCentral.setBackground(Color.DARK_GRAY);
		spCentral.setBounds(498, 127, 15, 374);
		add(spCentral);
		
		spEmailInstitucional = new JSeparator();
		spEmailInstitucional.setBackground(SystemColor.textHighlight);
		spEmailInstitucional.setBounds(540, 207, 150, 14);
		add(spEmailInstitucional);
		
		spContrasenia = new JSeparator();
		spContrasenia.setBackground(SystemColor.textHighlight);
		spContrasenia.setBounds(540, 267, 150, 14);
		add(spContrasenia);
		
		spEmailPersonal = new JSeparator();
		spEmailPersonal.setBackground(SystemColor.textHighlight);
		spEmailPersonal.setBounds(90, 327, 150, 14);
		add(spEmailPersonal);
		
		spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(90, 447, 150, 14);
		add(spDepartamento);
		
		spLocalidad = new JSeparator();
		spLocalidad.setBackground(SystemColor.textHighlight);
		spLocalidad.setBounds(290, 447, 150, 14);
		add(spLocalidad);
		
		spTelefono = new JSeparator();
		spTelefono.setBackground(SystemColor.textHighlight);
		spTelefono.setBounds(290, 327, 150, 14);
		add(spTelefono);
		
		spFechaNacimiento = new JSeparator();
		spFechaNacimiento.setBackground(SystemColor.textHighlight);
		spFechaNacimiento.setBounds(90, 387, 150, 14);
		add(spFechaNacimiento);
		
		spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(90, 127, 364, 14);
		add(spDatosPersonales);
		
		spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(540, 127, 364, 14);
		add(spDatosAcademicos);
		
		spITR = new JSeparator();
		spITR.setBackground(SystemColor.textHighlight);
		spITR.setBounds(740, 207, 150, 14);
		add(spITR);
		
		spGeneracion = new JSeparator();
		spGeneracion.setBackground(SystemColor.textHighlight);
		spGeneracion.setBounds(740, 327, 150, 14);
		add(spGeneracion);
		
		spReintreseContrasenia = new JSeparator();
		spReintreseContrasenia.setBackground(SystemColor.textHighlight);
		spReintreseContrasenia.setBounds(740, 267, 150, 14);
		add(spReintreseContrasenia);
		
		spTipoUsuario = new JSeparator();
		spTipoUsuario.setBackground(SystemColor.textHighlight);
		spTipoUsuario.setBounds(540, 327, 150, 14);
		add(spTipoUsuario);
		
		spArea = new JSeparator();
		spArea.setBackground(SystemColor.textHighlight);
		spArea.setBounds(540, 387, 150, 14);
		add(spArea);
		
		comboBoxDia = new JComboBox<Integer>();
		comboBoxDia.setFocusable(false);
		comboBoxDia.setBorder(null);
		comboBoxDia.setBackground(Color.WHITE);
		comboBoxDia.setBounds(90, 367, 45, 20);
		add(comboBoxDia);
		
		comboBoxMes = new JComboBox<Integer>();
		comboBoxMes.setFocusable(false);
		comboBoxMes.setBorder(null);
		comboBoxMes.setBackground(Color.WHITE);
		comboBoxMes.setBounds(135, 367, 45, 20);
		add(comboBoxMes);
		
		comboBoxAño = new JComboBox<Integer>();
		comboBoxAño.setFocusable(false);
		comboBoxAño.setBorder(null);
		comboBoxAño.setBackground(Color.WHITE);
		comboBoxAño.setBounds(180, 367, 60, 20);
		add(comboBoxAño);
		
		cmbLocalidad = new JComboBox<String>();
		cmbLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbLocalidad.setFocusable(false);
		cmbLocalidad.setBorder(null);
		cmbLocalidad.setBackground(Color.WHITE);
		cmbLocalidad.setBounds(290, 427, 150, 20);
		add(cmbLocalidad);
		
		cmbDepartamento = new JComboBox<String>();
		cmbDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbDepartamento.setFocusable(false);
		cmbDepartamento.setBorder(null);
		cmbDepartamento.setBackground(Color.WHITE);
		cmbDepartamento.setBounds(90, 427, 150, 20);
		add(cmbDepartamento);
		
		cmbITR = new JComboBox<String>();
		cmbITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbITR.setFocusable(false);
		cmbITR.setBorder(null);
		cmbITR.setBackground(Color.WHITE);
		cmbITR.setBounds(740, 187, 150, 20);
		add(cmbITR);
		
		cmbArea = new JComboBox<String>();
		cmbArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbArea.setFocusable(false);
		cmbArea.setBorder(null);
		cmbArea.setBackground(Color.WHITE);
		cmbArea.setBounds(540, 367, 150, 20);
		add(cmbArea);
		
		cmbRol = new JComboBox<String>();
		cmbRol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbRol.setFocusable(false);
		cmbRol.setBorder(null);
		cmbRol.setBackground(Color.WHITE);
		cmbRol.setBounds(740, 367, 150, 20);
		add(cmbRol);
		
		cmbTipoUsuario = new JComboBox<String>();
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Analista", "Estudiante", "Tutor"}));
		cmbTipoUsuario.setSelectedIndex(0);
		cmbTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cmbTipoUsuario.setFocusable(false);
		cmbTipoUsuario.setBorder(null);
		cmbTipoUsuario.setBackground(Color.WHITE);
		cmbTipoUsuario.setBounds(540, 307, 150, 20);
		add(cmbTipoUsuario);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnRegistrar.setFocusable(false);
		btnRegistrar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRegistrar.setBackground(SystemColor.textHighlight);
		btnRegistrar.setActionCommand("");
		btnRegistrar.setBounds(709, 411, 273, 49);
		add(btnRegistrar);
		
		btnIniciarSesion = new JButton("¿Ya está registrado? Iniciar sesión");
		btnIniciarSesion.setForeground(SystemColor.textHighlight);
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.setBounds(578, 506, 273, 23);
		add(btnIniciarSesion);
		
	}
	
	public static boolean validaCI(String ci) {
		if (ci.length() != 7 && ci.length() != 8) {
			return false;
		} else {
			try {
				Integer.parseInt(ci);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		int digVerificador = Integer.parseInt((ci.charAt(ci.length() - 1)) + "");
		int[] factores;
		if (ci.length() == 7) { // CI viejas
			factores = new int[] { 9, 8, 7, 6, 3, 4 };
		} else {
			factores = new int[] { 2, 9, 8, 7, 6, 3, 4 };
		}

		int suma = 0;
		for (int i = 0; i < factores.length; i++) {
			int digitoVerificador = Integer.parseInt(ci.charAt(i) + "");
			suma += digitoVerificador * factores[i];
		}
		int resto = suma % 10;
		int checkDigitoVerificador = 10 - resto;

		if (checkDigitoVerificador == 10) {
			return (digVerificador == 0);
		} else {
			return (checkDigitoVerificador == digVerificador);
		}
	}
	
	public void soloNumeros(KeyEvent e) {
		int key = e.getKeyChar();
	    boolean numeros = key >= 48 && key <= 57;
	    if (!numeros) {
	        e.consume();
	    }
	}
	
	public void soloLetras(KeyEvent e) {
		int key = e.getKeyChar();

	    boolean mayusculas = key >= 65 && key <= 90;
	    boolean minusculas = key >= 97 && key <= 122;
	    boolean espacio = key == 32;
	            
	     if (!(minusculas || mayusculas || espacio))
	    {
	        e.consume();
	    }
	}
	
	public void validarCampos() {
	}
}
