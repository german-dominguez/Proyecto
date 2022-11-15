package com.tix.vista.estudiante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Area;
import com.tix.modelo.entidades.Departamento;
import com.tix.modelo.entidades.Itr;
import com.tix.modelo.entidades.Localidad;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AreasBeanRemote;
import com.tix.modelo.servicios.DepartamentosBeanRemote;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.LocalidadesBeanRemote;
import com.toedter.calendar.JDateChooser;

public class ModificarDatosPropios extends JPanel {
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
	private JComboBox<String> cmbGenero;
	private JComboBox<Localidad> cmbLocalidad;
	private JComboBox<Departamento> cmbDepartamento;
	private JComboBox<Itr> cmbITR;
	private JComboBox<Area> cmbArea;
	private JComboBox<String> cmbRol;
	private JComboBox<String> cmbTipoUsuario;
	private JButton btnModificar;

	private JDateChooser dateChooser;

	private Analista analista;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
	 */
	public ModificarDatosPropios() {

		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));

		lblDocumento = new JLabel("Documento *");
		lblDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDocumento.setBounds(267, 377, 136, 21);
		add(lblDocumento);

		lblReingreseContrasenia = new JLabel("Reingrese su contraseña *");
		lblReingreseContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblReingreseContrasenia.setBounds(630, 267, 190, 21);
		add(lblReingreseContrasenia);

		lblPrimerNombre = new JLabel("Primer nombre *");
		lblPrimerNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(104, 212, 135, 21);
		add(lblPrimerNombre);

		lblDatosAcadmicos = new JLabel("Datos académicos");
		lblDatosAcadmicos.setForeground(SystemColor.textHighlight);
		lblDatosAcadmicos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosAcadmicos.setBounds(467, 158, 299, 27);
		add(lblDatosAcadmicos);

		lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setForeground(SystemColor.textHighlight);
		lblDatosPersonales.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(104, 158, 299, 27);
		add(lblDatosPersonales);

		lblTelefono = new JLabel("Teléfono de contacto *");
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTelefono.setBounds(267, 322, 136, 21);
		add(lblTelefono);

		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoNombre.setBounds(267, 212, 135, 21);
		add(lblSegundoNombre);

		lblArea = new JLabel("Área *");
		lblArea.setVisible(false);
		lblArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblArea.setBounds(467, 377, 135, 21);
		add(lblArea);

		lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoApellido.setBounds(267, 267, 136, 21);
		add(lblSegundoApellido);

		JLabel lblGnero = new JLabel("Género *");
		lblGnero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGnero.setBounds(104, 377, 135, 21);
		add(lblGnero);

		lblTipoUsuario = new JLabel("Tipo de Usuario *");
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(467, 322, 135, 21);
		add(lblTipoUsuario);

		lblLocalidad = new JLabel("Localidad *");
		lblLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblLocalidad.setBounds(267, 432, 136, 21);
		add(lblLocalidad);

		lblPrimerApellido = new JLabel("Primer apellido *");
		lblPrimerApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerApellido.setBounds(104, 267, 135, 21);
		add(lblPrimerApellido);

		lblEmailInstitucional = new JLabel("Email institucional *");
		lblEmailInstitucional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmailInstitucional.setBounds(467, 212, 190, 21);
		add(lblEmailInstitucional);

		lblContrasenia = new JLabel("Contraseña *");
		lblContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContrasenia.setBounds(467, 267, 100, 21);
		add(lblContrasenia);

		lblFechaNacimiento = new JLabel("Fecha de nacimiento *");
		lblFechaNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaNacimiento.setBounds(104, 483, 135, 21);
		add(lblFechaNacimiento);

		lblEmailPersonal = new JLabel("Email personal *");
		lblEmailPersonal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmailPersonal.setBounds(104, 322, 135, 21);
		add(lblEmailPersonal);

		lblITR = new JLabel("ITR *");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(630, 212, 135, 21);
		add(lblITR);

		lblGeneracion = new JLabel("Generación *");
		lblGeneracion.setVisible(false);
		lblGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGeneracion.setBounds(630, 322, 111, 21);
		add(lblGeneracion);

		lblRol = new JLabel("Rol *");
		lblRol.setVisible(false);
		lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblRol.setBounds(630, 377, 135, 21);
		add(lblRol);

		lblDepartamento = new JLabel("Departamento *");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartamento.setBounds(104, 432, 135, 21);
		add(lblDepartamento);

		txtDocumento = new JTextField();
		txtDocumento.setForeground(Color.DARK_GRAY);
		txtDocumento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(267, 397, 140, 20);
		add(txtDocumento);

		txtPrimerNombre = new JTextField();
		txtPrimerNombre.setForeground(Color.DARK_GRAY);
		txtPrimerNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPrimerNombre.setColumns(10);
		txtPrimerNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrimerNombre.setBounds(104, 232, 140, 20);
		add(txtPrimerNombre);

		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setForeground(Color.DARK_GRAY);
		txtSegundoNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSegundoNombre.setColumns(10);
		txtSegundoNombre.setBorder(null);
		txtSegundoNombre.setBounds(267, 232, 140, 20);
		add(txtSegundoNombre);

		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setForeground(Color.DARK_GRAY);
		txtPrimerApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPrimerApellido.setColumns(10);
		txtPrimerApellido.setBorder(null);
		txtPrimerApellido.setBounds(104, 287, 140, 20);
		add(txtPrimerApellido);

		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setForeground(Color.DARK_GRAY);
		txtSegundoApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBorder(null);
		txtSegundoApellido.setBounds(267, 287, 140, 20);
		add(txtSegundoApellido);

		txtEmailInstitucional = new JTextField();
		txtEmailInstitucional.setEditable(false);
		txtEmailInstitucional.setForeground(Color.DARK_GRAY);
		txtEmailInstitucional.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmailInstitucional.setColumns(10);
		txtEmailInstitucional.setBorder(null);
		txtEmailInstitucional.setBounds(467, 232, 140, 20);
		add(txtEmailInstitucional);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setForeground(Color.DARK_GRAY);
		txtContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtContrasenia.setBounds(467, 287, 140, 20);
		add(txtContrasenia);

		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.DARK_GRAY);
		txtTelefono.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(267, 342, 140, 20);
		add(txtTelefono);

		txtEmailPersonal = new JTextField();
		txtEmailPersonal.setToolTipText("");
		txtEmailPersonal.setForeground(Color.DARK_GRAY);
		txtEmailPersonal.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmailPersonal.setColumns(10);
		txtEmailPersonal.setBorder(null);
		txtEmailPersonal.setBounds(104, 342, 140, 20);
		add(txtEmailPersonal);

		txtGeneracion = new JTextField();
		txtGeneracion.setVisible(false);
		txtGeneracion.setForeground(Color.DARK_GRAY);
		txtGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtGeneracion.setColumns(10);
		txtGeneracion.setBorder(null);
		txtGeneracion.setBounds(630, 342, 140, 20);
		add(txtGeneracion);

		txtReingreseContrasenia = new JPasswordField();
		txtReingreseContrasenia.setForeground(Color.DARK_GRAY);
		txtReingreseContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtReingreseContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtReingreseContrasenia.setBounds(630, 287, 140, 20);
		add(txtReingreseContrasenia);

		spDocumento = new JSeparator();
		spDocumento.setBackground(SystemColor.textHighlight);
		spDocumento.setBounds(267, 417, 140, 14);
		add(spDocumento);

		spRol = new JSeparator();
		spRol.setVisible(false);
		spRol.setBackground(SystemColor.textHighlight);
		spRol.setBounds(630, 417, 140, 14);
		add(spRol);

		spPrimerApellido = new JSeparator();
		spPrimerApellido.setBackground(SystemColor.textHighlight);
		spPrimerApellido.setBounds(104, 307, 140, 14);
		add(spPrimerApellido);

		spSegundoApellido = new JSeparator();
		spSegundoApellido.setBackground(SystemColor.textHighlight);
		spSegundoApellido.setBounds(267, 307, 140, 14);
		add(spSegundoApellido);

		spEmailInstitucional = new JSeparator();
		spEmailInstitucional.setBackground(SystemColor.textHighlight);
		spEmailInstitucional.setBounds(467, 252, 140, 14);
		add(spEmailInstitucional);

		spContrasenia = new JSeparator();
		spContrasenia.setBackground(SystemColor.textHighlight);
		spContrasenia.setBounds(467, 307, 140, 14);
		add(spContrasenia);

		spEmailPersonal = new JSeparator();
		spEmailPersonal.setBackground(SystemColor.textHighlight);
		spEmailPersonal.setBounds(104, 362, 140, 14);
		add(spEmailPersonal);

		spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(104, 472, 140, 14);
		add(spDepartamento);

		spLocalidad = new JSeparator();
		spLocalidad.setBackground(SystemColor.textHighlight);
		spLocalidad.setBounds(267, 472, 140, 14);
		add(spLocalidad);

		spTelefono = new JSeparator();
		spTelefono.setBackground(SystemColor.textHighlight);
		spTelefono.setBounds(267, 362, 140, 14);
		add(spTelefono);

		spFechaNacimiento = new JSeparator();
		spFechaNacimiento.setBackground(SystemColor.textHighlight);
		spFechaNacimiento.setBounds(104, 520, 140, 14);
		add(spFechaNacimiento);

		spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(104, 188, 299, 14);
		add(spDatosPersonales);

		spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(467, 188, 299, 14);
		add(spDatosAcademicos);

		spITR = new JSeparator();
		spITR.setBackground(SystemColor.textHighlight);
		spITR.setBounds(630, 252, 140, 14);
		add(spITR);

		spGeneracion = new JSeparator();
		spGeneracion.setVisible(false);
		spGeneracion.setBackground(SystemColor.textHighlight);
		spGeneracion.setBounds(630, 362, 140, 14);
		add(spGeneracion);

		spReintreseContrasenia = new JSeparator();
		spReintreseContrasenia.setBackground(SystemColor.textHighlight);
		spReintreseContrasenia.setBounds(630, 307, 140, 14);
		add(spReintreseContrasenia);

		spTipoUsuario = new JSeparator();
		spTipoUsuario.setBackground(SystemColor.textHighlight);
		spTipoUsuario.setBounds(467, 362, 140, 14);
		add(spTipoUsuario);

		spArea = new JSeparator();
		spArea.setVisible(false);
		spArea.setBackground(SystemColor.textHighlight);
		spArea.setBounds(467, 417, 140, 14);
		add(spArea);

		JSeparator spVertical = new JSeparator();
		spVertical.setOrientation(SwingConstants.VERTICAL);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setBounds(439, 200, 18, 286);
		add(spVertical);

		JSeparator spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(104, 252, 140, 14);
		add(spPrimerNombre);

		JSeparator spSegundoNombre = new JSeparator();
		spSegundoNombre.setBackground(SystemColor.textHighlight);
		spSegundoNombre.setBounds(267, 252, 140, 14);
		add(spSegundoNombre);

		JSeparator spGenero = new JSeparator();
		spGenero.setBackground(SystemColor.textHighlight);
		spGenero.setBounds(104, 417, 140, 14);
		add(spGenero);

		cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "Otro" }));
		cmbGenero.setForeground(Color.DARK_GRAY);
		cmbGenero.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGenero.setFocusable(false);
		cmbGenero.setBorder(null);
		cmbGenero.setBackground(Color.WHITE);
		cmbGenero.setBounds(104, 398, 140, 22);
		add(cmbGenero);

		cmbLocalidad = new JComboBox<Localidad>();
		for (Localidad localidad : DatabaseManager.getInstance().getLocalidadesBeanRemote().obtenerTodos()) {
			cmbLocalidad.addItem(localidad);
		}
		cmbLocalidad.setForeground(Color.DARK_GRAY);
		cmbLocalidad.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbLocalidad.setFocusable(false);
		cmbLocalidad.setBorder(null);
		cmbLocalidad.setBackground(Color.WHITE);
		cmbLocalidad.setBounds(267, 452, 140, 20);
		add(cmbLocalidad);

		cmbDepartamento = new JComboBox<Departamento>();
		for (Departamento departamento : DatabaseManager.getInstance().getDepartamentosBeanRemote().obtenerTodos()) {
			cmbDepartamento.addItem(departamento);
		}
		cmbDepartamento.setForeground(Color.DARK_GRAY);
		cmbDepartamento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbDepartamento.setFocusable(false);
		cmbDepartamento.setBorder(null);
		cmbDepartamento.setBackground(Color.WHITE);
		cmbDepartamento.setBounds(104, 452, 140, 20);
		add(cmbDepartamento);

		cmbITR = new JComboBox<Itr>();
		for (Itr itr : DatabaseManager.getInstance().getItrsBeanRemote().obtenerTodos()) {
			cmbITR.addItem(itr);
		}
		cmbITR.setForeground(Color.DARK_GRAY);
		cmbITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbITR.setFocusable(false);
		cmbITR.setBorder(null);
		cmbITR.setBackground(Color.WHITE);
		cmbITR.setBounds(630, 232, 140, 20);
		add(cmbITR);

		cmbArea = new JComboBox<Area>();
		for (Area area : DatabaseManager.getInstance().getAreasBeanRemote().obtenerTodos()) {
			cmbArea.addItem(area);
		}
		cmbArea.setVisible(false);
		cmbArea.setForeground(Color.DARK_GRAY);
		cmbArea.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbArea.setFocusable(false);
		cmbArea.setBorder(new EmptyBorder(0, 0, 0, 0));
		cmbArea.setBackground(Color.WHITE);
		cmbArea.setBounds(467, 397, 140, 20);
		add(cmbArea);

		cmbRol = new JComboBox<String>();
		cmbRol.setModel(new DefaultComboBoxModel(new String[] { "Encargado", "Tutor" }));
		cmbRol.setVisible(false);
		cmbRol.setForeground(Color.DARK_GRAY);
		cmbRol.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbRol.setFocusable(false);
		cmbRol.setBorder(null);
		cmbRol.setBackground(Color.WHITE);
		cmbRol.setBounds(630, 397, 140, 20);
		add(cmbRol);

		cmbTipoUsuario = new JComboBox<String>();
		cmbTipoUsuario.setForeground(Color.DARK_GRAY);
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] { "Analista", "Estudiante", "Tutor" }));
		cmbTipoUsuario.setSelectedIndex(0);
		cmbTipoUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbTipoUsuario.setFocusable(false);
		cmbTipoUsuario.setBorder(null);
		cmbTipoUsuario.setBackground(Color.WHITE);
		cmbTipoUsuario.setBounds(467, 342, 140, 20);
		add(cmbTipoUsuario);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModificar.setFocusable(false);
		btnModificar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModificar.setBackground(SystemColor.textHighlight);
		btnModificar.setActionCommand("");
		btnModificar.setBounds(505, 452, 223, 49);
		add(btnModificar);

		JLabel lblRegistroDeUsuario = new JLabel("REGISTRO DE USUARIO");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRegistroDeUsuario.setBounds(104, 104, 390, 41);
		add(lblRegistroDeUsuario);

		JLabel lblAviso = new JLabel("Los campos marcados con * son obligatorios.");
		lblAviso.setForeground(Color.DARK_GRAY);
		lblAviso.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		lblAviso.setBounds(104, 545, 230, 13);
		add(lblAviso);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(104, 504, 140, 19);
		add(dateChooser);

	}

	public void cargarDatos() {
		txtContrasenia.setText(analista.getContrasenia());
		txtDocumento.setText(analista.getDocumento());
		txtEmailInstitucional.setText(analista.getMail());
		txtEmailPersonal.setText(analista.getMailPersonal());
		txtPrimerApellido.setText(analista.getApellido1());
		txtPrimerNombre.setText(analista.getNombre1());
		txtReingreseContrasenia.setText(analista.getContrasenia());
		txtSegundoApellido.setText(analista.getApellido2());
		txtSegundoNombre.setText(analista.getNombre2());
		txtTelefono.setText(analista.getTelefono());
		dateChooser.setDate(analista.getFechaNacimiento());
	}

	public void editarAnalista() throws Exception {
		analista.setApellido1(getTxtPrimerApellido());
		analista.setApellido2(getTxtSegundoApellido());
		analista.setContrasenia(getTxtContrasenia());
		analista.setDocumento(getTxtDocumento());
		analista.setFechaNacimiento(getDateChooser());
		analista.setGenero(getCmbGenero());
		analista.setItr(getCmbITR());
		analista.setLocalidad(getCmbLocalidad());
		analista.setMailPersonal(getTxtEmailPersonal());
		analista.setNombre1(getTxtPrimerNombre());
		analista.setNombre2(getTxtSegundoNombre());

		DatabaseManager.getInstance().getAnalistasBeanRemote().editar(analista);
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public boolean validaCI(String ci) {
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

	public boolean validarContrasenia(String contrasenia) {

		Matcher m = null;

		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");

		m = pattern.matcher(contrasenia);

		if (m.find()) {
			return true;
		}

		return false;
	}

	public boolean validarEmail(String email, int tipo) {
		Matcher m = null;

		Pattern patternEstudianteUTEC = Pattern
				.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@estudiantes\\.utec\\.edu\\.uy");
		Pattern patternUTEC = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@utec\\.edu\\.uy");
		Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-]"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

		switch (tipo) {
			case 0:
				m = patternEstudianteUTEC.matcher(email);
				break;
			case 1:
				m = patternUTEC.matcher(email);
				break;
			case 2:
				m = pattern.matcher(email);
				break;
		}

		if (m.find()) {
			return true;
		}

		return false;
	}

	public boolean validarCamposIngresados() {
		String primerNombre = txtPrimerNombre.getText();
		// String segundoNombre = txtSegundoNombre.getText();
		String primerApellido = txtPrimerApellido.getText();
		// String segundoApellido = txtSegundoApellido.getText();
		String documento = txtDocumento.getText();
		String emailPersonal = txtEmailPersonal.getText();
		String telefono = txtTelefono.getText();
		// int localidad = cmbLocalidad.getSelectedIndex();
		// int departamento = cmbDepartamento.getSelectedIndex();
		String emailInstitucional = txtEmailInstitucional.getText();
		// String contrasenia = txtContrasenia.getText();
		// int ITR = cmbITR.getSelectedIndex();
		int tipoUsuario = cmbTipoUsuario.getSelectedIndex();
		String generacion = txtGeneracion.getText();

		// Verifico que haya ingresado todos los campos OBLIGATORIOS
		if (primerNombre.length() == 0 || primerApellido.length() == 0 || documento.length() == 0
				|| emailPersonal.length() == 0 || telefono.length() == 0 || emailInstitucional.length() == 0
				|| (tipoUsuario == 1 && generacion.length() == 0) || dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Los campos marcados con * son obligatorios", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);

			return false;

			// Verifico que el EMAIL PERSONAL tenga el formato correcto
		} else if (!validarEmail(emailPersonal, 2)) {
			JOptionPane.showMessageDialog(null, "El formato de su email personal es incorrecto", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);

			return false;

			// Verifico que el EMAIL INSTITUCIONAL tenga el formato correcto y pertenezc al
			// dominio UTEC
		} else if (!validarEmail(emailInstitucional, 1) && cmbTipoUsuario.getSelectedIndex() == 0
				|| cmbTipoUsuario.getSelectedIndex() == 2) {
			JOptionPane.showMessageDialog(null, "El email institucional debe pertenecer al dominio utec.edu.uy",
					"ATENCIÓN", JOptionPane.WARNING_MESSAGE);

			return false;

		} else if (!validarEmail(emailInstitucional, 0) && cmbTipoUsuario.getSelectedIndex() == 1) {

			JOptionPane.showMessageDialog(null,
					"El email institucional debe pertenecer al dominio estudiantes.utec.edu.uy", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);

			return false;

			// Verifico que la CÉDULA tenga el formato correcto
		} else if (!validaCI(documento)) {
			JOptionPane.showMessageDialog(null, "El documento que ingresó es incorrecto", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);

			return false;

		} else if (!validarContrasenia(new String(txtContrasenia.getPassword()))) {
			JOptionPane.showMessageDialog(null,
					"La contraseña debe contener al menos 8 caracteres entre números y letras.");

			return false;

		} else if (!(new String(txtContrasenia.getPassword())
				.equals(new String(txtReingreseContrasenia.getPassword())))) {
			JOptionPane.showMessageDialog(null, "Las contraseñas deben coincidir.");

			return false;
		}

		return true;
	}

	public void setCampos() {

		switch (cmbTipoUsuario.getSelectedIndex()) {
			case 0:
				txtGeneracion.setVisible(false);
				lblGeneracion.setVisible(false);
				spGeneracion.setVisible(false);

				cmbArea.setVisible(false);
				lblArea.setVisible(false);
				spArea.setVisible(false);

				cmbRol.setVisible(false);
				lblRol.setVisible(false);
				spRol.setVisible(false);
				break;
			case 1:
				txtGeneracion.setVisible(true);
				lblGeneracion.setVisible(true);
				spGeneracion.setVisible(true);

				cmbArea.setVisible(false);
				lblArea.setVisible(false);
				spArea.setVisible(false);

				cmbRol.setVisible(false);
				lblRol.setVisible(false);
				spRol.setVisible(false);
				break;
			case 2:
				txtGeneracion.setVisible(false);
				lblGeneracion.setVisible(false);
				spGeneracion.setVisible(false);

				cmbArea.setVisible(true);
				lblArea.setVisible(true);
				spArea.setVisible(true);

				cmbRol.setVisible(true);
				lblRol.setVisible(true);
				spRol.setVisible(true);
				break;
		}

	}

	public String getTxtDocumento() {
		return txtDocumento.getText();
	}

	public String getTxtPrimerNombre() {
		return txtPrimerNombre.getText();
	}

	public String getTxtSegundoNombre() {
		return txtSegundoNombre.getText();
	}

	public String getTxtPrimerApellido() {
		return txtPrimerApellido.getText();
	}

	public String getTxtSegundoApellido() {
		return txtSegundoApellido.getText();
	}

	public String getTxtEmailInstitucional() {
		return txtEmailInstitucional.getText();
	}

	public String getTxtContrasenia() {
		return new String(txtContrasenia.getPassword());
	}

	public String getTxtReingreseContrasenia() {
		return txtReingreseContrasenia.getPassword().toString();
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public String getTxtEmailPersonal() {
		return txtEmailPersonal.getText();
	}

	public int getTxtGeneracion() {
		return Integer.parseInt(txtGeneracion.getText());
	}

	public Localidad getCmbLocalidad() {
		return (Localidad) cmbLocalidad.getSelectedItem();
	}

	public void setCmbLocalidad(JComboBox<Localidad> cmbLocalidad) {
		this.cmbLocalidad = cmbLocalidad;
	}

	public Departamento getCmbDepartamento() {
		return (Departamento) cmbDepartamento.getSelectedItem();
	}

	public void setCmbDepartamento(JComboBox<Departamento> cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}

	public Itr getCmbITR() {
		return (Itr) cmbITR.getSelectedItem();
	}

	public void setCmbITR(JComboBox<Itr> cmbITR) {
		this.cmbITR = cmbITR;
	}

	public Area getCmbArea() {
		return (Area) cmbArea.getSelectedItem();
	}

	public void setCmbArea(JComboBox<Area> cmbArea) {
		this.cmbArea = cmbArea;
	}

	public String getCmbRol() {
		return (String) cmbRol.getSelectedItem();
	}

	public void setCmbRol(JComboBox<String> cmbRol) {
		this.cmbRol = cmbRol;
	}

	public JComboBox<String> getCmbTipoUsuario() {
		return cmbTipoUsuario;
	}

	public void setCmbTipoUsuario(JComboBox<String> cmbTipoUsuario) {
		this.cmbTipoUsuario = cmbTipoUsuario;
	}

	public String getCmbGenero() {
		return (String) cmbGenero.getSelectedItem();
	}

	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	public Date getDateChooser() {
		return dateChooser.getDate();
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

}
