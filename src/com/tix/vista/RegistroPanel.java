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
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTabbedPane;

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
	private JComboBox<String> cmbLocalidad;
	private JComboBox<String> cmbDepartamento;
	private JComboBox<String> cmbITR;
	private JComboBox<String> cmbArea; 
	private JComboBox<String> cmbRol;
	private JComboBox<String> cmbTipoUsuario;
	private JButton btnRegistrar;
	private JButton btnIniciarSesion;
	private static RegistroPanel vista = new RegistroPanel();
	/**
	 * Create the panel.
	 */
	public RegistroPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(1060, 700));
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblDocumento.setBounds(287, 436, 190, 21);
		add(lblDocumento);
		
		lblReingreseContrasenia = new JLabel("Reingrese su contraseña");
		lblReingreseContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblReingreseContrasenia.setBounds(787, 296, 190, 21);
		add(lblReingreseContrasenia);
		
		lblPrimerNombre = new JLabel("Primer nombre");
		lblPrimerNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblPrimerNombre.setBounds(77, 216, 135, 21);
		add(lblPrimerNombre);
		
		lblDatosAcadmicos = new JLabel("Datos académicos");
		lblDatosAcadmicos.setForeground(SystemColor.textHighlight);
		lblDatosAcadmicos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		lblDatosAcadmicos.setBounds(577, 146, 299, 27);
		add(lblDatosAcadmicos);
		
		lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setForeground(SystemColor.textHighlight);
		lblDatosPersonales.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		lblDatosPersonales.setBounds(77, 146, 299, 27);
		add(lblDatosPersonales);
		
		lblTelefono = new JLabel("Teléfono de contacto");
		lblTelefono.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblTelefono.setBounds(287, 366, 190, 21);
		add(lblTelefono);
		
		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblSegundoNombre.setBounds(287, 216, 135, 21);
		add(lblSegundoNombre);
		
		lblArea = new JLabel("Área");
		lblArea.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblArea.setBounds(577, 436, 135, 21);
		add(lblArea);
		
		lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblSegundoApellido.setBounds(287, 296, 190, 21);
		add(lblSegundoApellido);
		
		lblTipoUsuario = new JLabel("Tipo de Usuario");
		lblTipoUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblTipoUsuario.setBounds(577, 366, 135, 21);
		add(lblTipoUsuario);
		
		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblLocalidad.setBounds(287, 506, 135, 21);
		add(lblLocalidad);
		
		lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblPrimerApellido.setBounds(77, 296, 135, 21);
		add(lblPrimerApellido);
		
		lblEmailInstitucional = new JLabel("Email institucional");
		lblEmailInstitucional.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblEmailInstitucional.setBounds(577, 216, 190, 21);
		add(lblEmailInstitucional);
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblContrasenia.setBounds(577, 296, 100, 21);
		add(lblContrasenia);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblFechaNacimiento.setBounds(77, 436, 190, 21);
		add(lblFechaNacimiento);
		
		lblEmailPersonal = new JLabel("Email personal");
		lblEmailPersonal.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblEmailPersonal.setBounds(77, 366, 135, 21);
		add(lblEmailPersonal);
		
		lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblITR.setBounds(787, 216, 135, 21);
		add(lblITR);
		
		lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblGeneracion.setBounds(787, 366, 111, 21);
		add(lblGeneracion);
		
		lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblRol.setBounds(787, 436, 135, 21);
		add(lblRol);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblDepartamento.setBounds(77, 506, 135, 21);
		add(lblDepartamento);
		
		txtDocumento = new JTextField();
		txtDocumento.setForeground(Color.DARK_GRAY);
		txtDocumento.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(287, 461, 180, 20);
		add(txtDocumento);
		
		txtPrimerNombre = new JTextField();
		txtPrimerNombre.setForeground(Color.DARK_GRAY);
		txtPrimerNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtPrimerNombre.setColumns(10);
		txtPrimerNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrimerNombre.setBounds(77, 241, 180, 20);
		add(txtPrimerNombre);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setForeground(Color.DARK_GRAY);
		txtSegundoNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtSegundoNombre.setColumns(10);
		txtSegundoNombre.setBorder(null);
		txtSegundoNombre.setBounds(287, 241, 180, 20);
		add(txtSegundoNombre);
		
		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setForeground(Color.DARK_GRAY);
		txtPrimerApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtPrimerApellido.setColumns(10);
		txtPrimerApellido.setBorder(null);
		txtPrimerApellido.setBounds(77, 321, 180, 20);
		add(txtPrimerApellido);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setForeground(Color.DARK_GRAY);
		txtSegundoApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBorder(null);
		txtSegundoApellido.setBounds(287, 321, 180, 20);
		add(txtSegundoApellido);
		
		txtEmailInstitucional = new JTextField();
		txtEmailInstitucional.setForeground(Color.DARK_GRAY);
		txtEmailInstitucional.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtEmailInstitucional.setColumns(10);
		txtEmailInstitucional.setBorder(null);
		txtEmailInstitucional.setBounds(577, 241, 180, 20);
		add(txtEmailInstitucional);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setForeground(Color.DARK_GRAY);
		txtContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtContrasenia.setBounds(577, 321, 180, 20);
		add(txtContrasenia);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.DARK_GRAY);
		txtTelefono.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(287, 391, 180, 20);
		add(txtTelefono);
		
		txtEmailPersonal = new JTextField();
		txtEmailPersonal.setToolTipText("");
		txtEmailPersonal.setForeground(Color.DARK_GRAY);
		txtEmailPersonal.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtEmailPersonal.setColumns(10);
		txtEmailPersonal.setBorder(null);
		txtEmailPersonal.setBounds(77, 391, 180, 20);
		add(txtEmailPersonal);
		
		txtGeneracion = new JTextField();
		txtGeneracion.setForeground(Color.DARK_GRAY);
		txtGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtGeneracion.setColumns(10);
		txtGeneracion.setBorder(null);
		txtGeneracion.setBounds(787, 391, 180, 20);
		add(txtGeneracion);
		
		txtReingreseContrasenia = new JPasswordField();
		txtReingreseContrasenia.setForeground(Color.DARK_GRAY);
		txtReingreseContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtReingreseContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtReingreseContrasenia.setBounds(787, 321, 180, 20);
		add(txtReingreseContrasenia);
		
		spDocumento = new JSeparator();
		spDocumento.setBackground(SystemColor.textHighlight);
		spDocumento.setBounds(287, 481, 180, 14);
		add(spDocumento);
		
		spRol = new JSeparator();
		spRol.setBackground(SystemColor.textHighlight);
		spRol.setBounds(787, 481, 180, 14);
		add(spRol);
		
		spPrimerApellido = new JSeparator();
		spPrimerApellido.setBackground(SystemColor.textHighlight);
		spPrimerApellido.setBounds(77, 341, 180, 14);
		add(spPrimerApellido);
		
		spSegundoApellido = new JSeparator();
		spSegundoApellido.setBackground(SystemColor.textHighlight);
		spSegundoApellido.setBounds(287, 341, 180, 14);
		add(spSegundoApellido);
		
		spCentral = new JSeparator();
		spCentral.setOrientation(SwingConstants.VERTICAL);
		spCentral.setBackground(Color.DARK_GRAY);
		spCentral.setBounds(523, 176, 15, 374);
		add(spCentral);
		
		spEmailInstitucional = new JSeparator();
		spEmailInstitucional.setBackground(SystemColor.textHighlight);
		spEmailInstitucional.setBounds(577, 261, 180, 14);
		add(spEmailInstitucional);
		
		spContrasenia = new JSeparator();
		spContrasenia.setBackground(SystemColor.textHighlight);
		spContrasenia.setBounds(577, 341, 180, 14);
		add(spContrasenia);
		
		spEmailPersonal = new JSeparator();
		spEmailPersonal.setBackground(SystemColor.textHighlight);
		spEmailPersonal.setBounds(77, 411, 180, 14);
		add(spEmailPersonal);
		
		spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(77, 551, 180, 14);
		add(spDepartamento);
		
		spLocalidad = new JSeparator();
		spLocalidad.setBackground(SystemColor.textHighlight);
		spLocalidad.setBounds(287, 551, 180, 14);
		add(spLocalidad);
		
		spTelefono = new JSeparator();
		spTelefono.setBackground(SystemColor.textHighlight);
		spTelefono.setBounds(287, 411, 180, 14);
		add(spTelefono);
		
		spFechaNacimiento = new JSeparator();
		spFechaNacimiento.setBackground(SystemColor.textHighlight);
		spFechaNacimiento.setBounds(77, 481, 180, 14);
		add(spFechaNacimiento);
		
		spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(77, 176, 364, 14);
		add(spDatosPersonales);
		
		spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(577, 176, 364, 14);
		add(spDatosAcademicos);
		
		spITR = new JSeparator();
		spITR.setBackground(SystemColor.textHighlight);
		spITR.setBounds(787, 261, 180, 14);
		add(spITR);
		
		spGeneracion = new JSeparator();
		spGeneracion.setBackground(SystemColor.textHighlight);
		spGeneracion.setBounds(787, 411, 180, 14);
		add(spGeneracion);
		
		spReintreseContrasenia = new JSeparator();
		spReintreseContrasenia.setBackground(SystemColor.textHighlight);
		spReintreseContrasenia.setBounds(787, 341, 180, 14);
		add(spReintreseContrasenia);
		
		spTipoUsuario = new JSeparator();
		spTipoUsuario.setBackground(SystemColor.textHighlight);
		spTipoUsuario.setBounds(577, 411, 180, 14);
		add(spTipoUsuario);
		
		spArea = new JSeparator();
		spArea.setBackground(SystemColor.textHighlight);
		spArea.setBounds(577, 481, 180, 14);
		add(spArea);
		
		cmbLocalidad = new JComboBox<String>();
		cmbLocalidad.setForeground(Color.DARK_GRAY);
		cmbLocalidad.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cmbLocalidad.setFocusable(false);
		cmbLocalidad.setBorder(null);
		cmbLocalidad.setBackground(Color.WHITE);
		cmbLocalidad.setBounds(287, 531, 180, 20);
		add(cmbLocalidad);
		
		cmbDepartamento = new JComboBox<String>();
		cmbDepartamento.setForeground(Color.DARK_GRAY);
		cmbDepartamento.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cmbDepartamento.setFocusable(false);
		cmbDepartamento.setBorder(null);
		cmbDepartamento.setBackground(Color.WHITE);
		cmbDepartamento.setBounds(77, 531, 180, 20);
		add(cmbDepartamento);
		
		cmbITR = new JComboBox<String>();
		cmbITR.setForeground(Color.DARK_GRAY);
		cmbITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cmbITR.setFocusable(false);
		cmbITR.setBorder(null);
		cmbITR.setBackground(Color.WHITE);
		cmbITR.setBounds(787, 241, 180, 20);
		add(cmbITR);
		
		cmbArea = new JComboBox<String>();
		cmbArea.setForeground(Color.DARK_GRAY);
		cmbArea.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cmbArea.setFocusable(false);
		cmbArea.setBorder(new EmptyBorder(0, 0, 0, 0));
		cmbArea.setBackground(Color.WHITE);
		cmbArea.setBounds(577, 461, 180, 20);
		add(cmbArea);
		
		cmbRol = new JComboBox<String>();
		cmbRol.setForeground(Color.DARK_GRAY);
		cmbRol.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cmbRol.setFocusable(false);
		cmbRol.setBorder(null);
		cmbRol.setBackground(Color.WHITE);
		cmbRol.setBounds(787, 461, 180, 20);
		add(cmbRol);
		
		cmbTipoUsuario = new JComboBox<String>();
		cmbTipoUsuario.setForeground(Color.DARK_GRAY);
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Analista", "Estudiante", "Tutor"}));
		cmbTipoUsuario.setSelectedIndex(0);
		cmbTipoUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		cmbTipoUsuario.setFocusable(false);
		cmbTipoUsuario.setBorder(null);
		cmbTipoUsuario.setBackground(Color.WHITE);
		cmbTipoUsuario.setBounds(577, 391, 180, 20);
		add(cmbTipoUsuario);
		
		btnRegistrar = new JButton("REGISTRARSE");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRegistrar.setFocusable(false);
		btnRegistrar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRegistrar.setBackground(SystemColor.textHighlight);
		btnRegistrar.setActionCommand("");
		btnRegistrar.setBounds(653, 531, 223, 49);
		add(btnRegistrar);
		
		btnIniciarSesion = new JButton("¿Ya está registrado? Iniciar sesión");
		btnIniciarSesion.setForeground(SystemColor.textHighlight);
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		btnIniciarSesion.setBounds(653, 590, 223, 23);
		add(btnIniciarSesion);
		
		JSeparator spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(77, 261, 180, 14);
		add(spPrimerNombre);
		
		JSeparator spSegundoNombre = new JSeparator();
		spSegundoNombre.setBackground(SystemColor.textHighlight);
		spSegundoNombre.setBounds(287, 261, 180, 14);
		add(spSegundoNombre);
		
		JLabel lblRegistroDeUsuario = new JLabel("Registro de usuario");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Gabriola", Font.PLAIN, 50));
		lblRegistroDeUsuario.setBounds(77, 51, 389, 85);
		add(lblRegistroDeUsuario);
		
	}
	
	public static RegistroPanel getVista() {
		return vista;
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
	
	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
}
