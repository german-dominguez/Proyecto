package com.tix.vista.analista;

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

	private JLabel lblPrimerNombre;
	private JLabel lblSegundoNombre;
	private JLabel lblSegundoApellido;
	private JLabel lblDocumento;
	private JLabel lblReingreseContrasenia;
	private JLabel lblTelefono;
	private JLabel lblLocalidad;
	private JLabel lblDatosPersonales;
	private JLabel lblDatosAcadmicos;
	private JLabel lblPrimerApellido;
	private JLabel lblEmailInstitucional;
	private JLabel lblContrasenia;
	private JLabel lblFechaNacimiento;
	private JLabel lblEmailPersonal;
	private JLabel lblITR;
	private JLabel lblDepartamento;

	private JSeparator spDocumento;
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
	private JSeparator spReintreseContrasenia;
	private JComboBox<String> cmbGenero;
	private JComboBox<Localidad> cmbLocalidad;
	private JComboBox<Departamento> cmbDepartamento;
	private JComboBox<Itr> cmbITR;
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
		lblDocumento.setBounds(183, 283, 136, 21);
		add(lblDocumento);

		lblReingreseContrasenia = new JLabel("Reingrese su contraseña *");
		lblReingreseContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblReingreseContrasenia.setBounds(546, 173, 190, 21);
		add(lblReingreseContrasenia);

		lblPrimerNombre = new JLabel("Primer nombre *");
		lblPrimerNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(20, 118, 135, 21);
		add(lblPrimerNombre);

		lblDatosAcadmicos = new JLabel("Datos académicos");
		lblDatosAcadmicos.setForeground(SystemColor.textHighlight);
		lblDatosAcadmicos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosAcadmicos.setBounds(383, 64, 299, 27);
		add(lblDatosAcadmicos);

		lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setForeground(SystemColor.textHighlight);
		lblDatosPersonales.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(20, 64, 299, 27);
		add(lblDatosPersonales);

		lblTelefono = new JLabel("Teléfono de contacto *");
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTelefono.setBounds(183, 228, 136, 21);
		add(lblTelefono);

		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoNombre.setBounds(183, 118, 135, 21);
		add(lblSegundoNombre);

		lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoApellido.setBounds(183, 173, 136, 21);
		add(lblSegundoApellido);

		JLabel lblGnero = new JLabel("Género *");
		lblGnero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGnero.setBounds(20, 283, 135, 21);
		add(lblGnero);

		lblLocalidad = new JLabel("Localidad *");
		lblLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblLocalidad.setBounds(183, 338, 136, 21);
		add(lblLocalidad);

		lblPrimerApellido = new JLabel("Primer apellido *");
		lblPrimerApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerApellido.setBounds(20, 173, 135, 21);
		add(lblPrimerApellido);

		lblEmailInstitucional = new JLabel("Email institucional *");
		lblEmailInstitucional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmailInstitucional.setBounds(383, 118, 190, 21);
		add(lblEmailInstitucional);

		lblContrasenia = new JLabel("Contraseña *");
		lblContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContrasenia.setBounds(383, 173, 100, 21);
		add(lblContrasenia);

		lblFechaNacimiento = new JLabel("Fecha de nacimiento *");
		lblFechaNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaNacimiento.setBounds(20, 389, 135, 21);
		add(lblFechaNacimiento);

		lblEmailPersonal = new JLabel("Email personal *");
		lblEmailPersonal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmailPersonal.setBounds(20, 228, 135, 21);
		add(lblEmailPersonal);

		lblITR = new JLabel("ITR *");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(546, 118, 135, 21);
		add(lblITR);

		lblDepartamento = new JLabel("Departamento *");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartamento.setBounds(20, 338, 135, 21);
		add(lblDepartamento);

		txtDocumento = new JTextField();
		txtDocumento.setForeground(Color.DARK_GRAY);
		txtDocumento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(183, 303, 140, 20);
		add(txtDocumento);

		txtPrimerNombre = new JTextField();
		txtPrimerNombre.setForeground(Color.DARK_GRAY);
		txtPrimerNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPrimerNombre.setColumns(10);
		txtPrimerNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrimerNombre.setBounds(20, 138, 140, 20);
		add(txtPrimerNombre);

		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setForeground(Color.DARK_GRAY);
		txtSegundoNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSegundoNombre.setColumns(10);
		txtSegundoNombre.setBorder(null);
		txtSegundoNombre.setBounds(183, 138, 140, 20);
		add(txtSegundoNombre);

		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setForeground(Color.DARK_GRAY);
		txtPrimerApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPrimerApellido.setColumns(10);
		txtPrimerApellido.setBorder(null);
		txtPrimerApellido.setBounds(20, 193, 140, 20);
		add(txtPrimerApellido);

		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setForeground(Color.DARK_GRAY);
		txtSegundoApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBorder(null);
		txtSegundoApellido.setBounds(183, 193, 140, 20);
		add(txtSegundoApellido);

		txtEmailInstitucional = new JTextField();
		txtEmailInstitucional.setEditable(false);
		txtEmailInstitucional.setForeground(Color.DARK_GRAY);
		txtEmailInstitucional.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmailInstitucional.setColumns(10);
		txtEmailInstitucional.setBorder(null);
		txtEmailInstitucional.setBounds(383, 138, 140, 20);
		add(txtEmailInstitucional);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setForeground(Color.DARK_GRAY);
		txtContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtContrasenia.setBounds(383, 193, 140, 20);
		add(txtContrasenia);

		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.DARK_GRAY);
		txtTelefono.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(183, 248, 140, 20);
		add(txtTelefono);

		txtEmailPersonal = new JTextField();
		txtEmailPersonal.setToolTipText("");
		txtEmailPersonal.setForeground(Color.DARK_GRAY);
		txtEmailPersonal.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmailPersonal.setColumns(10);
		txtEmailPersonal.setBorder(null);
		txtEmailPersonal.setBounds(20, 248, 140, 20);
		add(txtEmailPersonal);

		txtReingreseContrasenia = new JPasswordField();
		txtReingreseContrasenia.setForeground(Color.DARK_GRAY);
		txtReingreseContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtReingreseContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtReingreseContrasenia.setBounds(546, 193, 140, 20);
		add(txtReingreseContrasenia);

		spDocumento = new JSeparator();
		spDocumento.setBackground(SystemColor.textHighlight);
		spDocumento.setBounds(183, 323, 140, 14);
		add(spDocumento);

		spPrimerApellido = new JSeparator();
		spPrimerApellido.setBackground(SystemColor.textHighlight);
		spPrimerApellido.setBounds(20, 213, 140, 14);
		add(spPrimerApellido);

		spSegundoApellido = new JSeparator();
		spSegundoApellido.setBackground(SystemColor.textHighlight);
		spSegundoApellido.setBounds(183, 213, 140, 14);
		add(spSegundoApellido);

		spEmailInstitucional = new JSeparator();
		spEmailInstitucional.setBackground(SystemColor.textHighlight);
		spEmailInstitucional.setBounds(383, 158, 140, 14);
		add(spEmailInstitucional);

		spContrasenia = new JSeparator();
		spContrasenia.setBackground(SystemColor.textHighlight);
		spContrasenia.setBounds(383, 213, 140, 14);
		add(spContrasenia);

		spEmailPersonal = new JSeparator();
		spEmailPersonal.setBackground(SystemColor.textHighlight);
		spEmailPersonal.setBounds(20, 268, 140, 14);
		add(spEmailPersonal);

		spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(20, 378, 140, 14);
		add(spDepartamento);

		spLocalidad = new JSeparator();
		spLocalidad.setBackground(SystemColor.textHighlight);
		spLocalidad.setBounds(183, 378, 140, 14);
		add(spLocalidad);

		spTelefono = new JSeparator();
		spTelefono.setBackground(SystemColor.textHighlight);
		spTelefono.setBounds(183, 268, 140, 14);
		add(spTelefono);

		spFechaNacimiento = new JSeparator();
		spFechaNacimiento.setBackground(SystemColor.textHighlight);
		spFechaNacimiento.setBounds(20, 426, 140, 14);
		add(spFechaNacimiento);

		spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(20, 94, 299, 14);
		add(spDatosPersonales);

		spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(383, 94, 299, 14);
		add(spDatosAcademicos);

		spITR = new JSeparator();
		spITR.setBackground(SystemColor.textHighlight);
		spITR.setBounds(546, 158, 140, 14);
		add(spITR);

		spReintreseContrasenia = new JSeparator();
		spReintreseContrasenia.setBackground(SystemColor.textHighlight);
		spReintreseContrasenia.setBounds(546, 213, 140, 14);
		add(spReintreseContrasenia);

		JSeparator spVertical = new JSeparator();
		spVertical.setOrientation(SwingConstants.VERTICAL);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setBounds(355, 106, 18, 286);
		add(spVertical);

		JSeparator spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(20, 158, 140, 14);
		add(spPrimerNombre);

		JSeparator spSegundoNombre = new JSeparator();
		spSegundoNombre.setBackground(SystemColor.textHighlight);
		spSegundoNombre.setBounds(183, 158, 140, 14);
		add(spSegundoNombre);

		JSeparator spGenero = new JSeparator();
		spGenero.setBackground(SystemColor.textHighlight);
		spGenero.setBounds(20, 323, 140, 14);
		add(spGenero);

		cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "Otro" }));
		cmbGenero.setForeground(Color.DARK_GRAY);
		cmbGenero.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGenero.setFocusable(false);
		cmbGenero.setBorder(null);
		cmbGenero.setBackground(Color.WHITE);
		cmbGenero.setBounds(20, 304, 140, 22);
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
		cmbLocalidad.setBounds(183, 358, 140, 20);
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
		cmbDepartamento.setBounds(20, 358, 140, 20);
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
		cmbITR.setBounds(546, 138, 140, 20);
		add(cmbITR);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModificar.setFocusable(false);
		btnModificar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModificar.setBackground(SystemColor.textHighlight);
		btnModificar.setActionCommand("");
		btnModificar.setBounds(421, 358, 223, 49);
		add(btnModificar);

		JLabel lblRegistroDeUsuario = new JLabel("MODIFICAR DATOS PROPIOS");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRegistroDeUsuario.setBounds(20, 10, 390, 41);
		add(lblRegistroDeUsuario);

		JLabel lblAviso = new JLabel("Los campos marcados con * son obligatorios.");
		lblAviso.setForeground(Color.DARK_GRAY);
		lblAviso.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		lblAviso.setBounds(20, 451, 230, 13);
		add(lblAviso);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(20, 410, 140, 19);
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
		cmbLocalidad.setSelectedItem(analista.getLocalidad());
		cmbDepartamento.setSelectedItem(analista.getLocalidad().getDepartamento());
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

		// Verifico que haya ingresado todos los campos OBLIGATORIOS
		if (primerNombre.length() == 0 || primerApellido.length() == 0 || documento.length() == 0
				|| emailPersonal.length() == 0 || telefono.length() == 0 || emailInstitucional.length() == 0
				|| dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Los campos marcados con * son obligatorios", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);

			return false;

			// Verifico que el EMAIL PERSONAL tenga el formato correcto
		} else if (!validarEmail(emailPersonal, 2)) {
			JOptionPane.showMessageDialog(null, "El formato de su email personal es incorrecto", "ATENCIÓN",
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
