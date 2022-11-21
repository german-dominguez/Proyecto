package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Itr;
import com.tix.modelo.entidades.Localidad;
import com.tix.modelo.entidades.Tutor;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AreasBeanRemote;
import com.tix.modelo.servicios.DepartamentosBeanRemote;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.LocalidadesBeanRemote;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ModificarAnalista extends JPanel {
	private JTextField txtDocumento;
	private JTextField txtPrimerNombre;
	private JTextField txtSegundoNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private JTextField txtEmailInstitucional;
	private JTextField txtTelefono;
	private JTextField txtEmailPersonal;

	private JLabel lblPrimerNombre;
	private JLabel lblSegundoNombre;
	private JLabel lblSegundoApellido;
	private JLabel lblDocumento;
	private JLabel lblTelefono;
	private JLabel lblLocalidad;
	private JLabel lblDatosPersonales;
	private JLabel lblDatosAcadmicos;
	private JLabel lblPrimerApellido;
	private JLabel lblEmailInstitucional;
	private JLabel lblFechaNacimiento;
	private JLabel lblEmailPersonal;
	private JLabel lblITR;
	private JLabel lblDepartamento;
	JLabel lblEstado;

	private JSeparator spDocumento;
	private JSeparator spPrimerApellido;
	private JSeparator spSegundoApellido;
	private JSeparator spEmailInstitucional;
	private JSeparator spEmailPersonal;
	private JSeparator spDepartamento;
	private JSeparator spLocalidad;
	private JSeparator spTelefono;
	private JSeparator spFechaNacimiento;
	private JSeparator spDatosPersonales;
	private JSeparator spDatosAcademicos;
	private JSeparator spITR;
	JSeparator spEstado;

	private JComboBox<String> cmbGenero;
	private JComboBox<Localidad> cmbLocalidad;
	private JComboBox<Departamento> cmbDepartamento;
	private JComboBox<Itr> cmbITR;
	private JComboBox<String> cmbEstado;

	private JButton btnModificar;

	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
	 */
	public ModificarAnalista() {

		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));

		lblDocumento = new JLabel("Documento *");
		lblDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDocumento.setBounds(284, 389, 136, 21);
		add(lblDocumento);

		lblPrimerNombre = new JLabel("Primer nombre *");
		lblPrimerNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(121, 224, 135, 21);
		add(lblPrimerNombre);

		lblDatosAcadmicos = new JLabel("Datos académicos");
		lblDatosAcadmicos.setForeground(SystemColor.textHighlight);
		lblDatosAcadmicos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosAcadmicos.setBounds(484, 170, 299, 27);
		add(lblDatosAcadmicos);

		lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setForeground(SystemColor.textHighlight);
		lblDatosPersonales.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblDatosPersonales.setBounds(121, 170, 299, 27);
		add(lblDatosPersonales);

		lblTelefono = new JLabel("Teléfono de contacto *");
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTelefono.setBounds(284, 334, 136, 21);
		add(lblTelefono);

		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoNombre.setBounds(284, 224, 135, 21);
		add(lblSegundoNombre);

		lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoApellido.setBounds(284, 279, 136, 21);
		add(lblSegundoApellido);

		JLabel lblGnero = new JLabel("Género *");
		lblGnero.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGnero.setBounds(121, 389, 135, 21);
		add(lblGnero);

		lblLocalidad = new JLabel("Localidad *");
		lblLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblLocalidad.setBounds(284, 444, 136, 21);
		add(lblLocalidad);

		lblPrimerApellido = new JLabel("Primer apellido *");
		lblPrimerApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerApellido.setBounds(121, 279, 135, 21);
		add(lblPrimerApellido);

		lblEmailInstitucional = new JLabel("Email institucional *");
		lblEmailInstitucional.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmailInstitucional.setBounds(484, 224, 140, 21);
		add(lblEmailInstitucional);

		lblFechaNacimiento = new JLabel("Fecha de nacimiento *");
		lblFechaNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaNacimiento.setBounds(121, 495, 135, 21);
		add(lblFechaNacimiento);

		lblEmailPersonal = new JLabel("Email personal *");
		lblEmailPersonal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmailPersonal.setBounds(121, 334, 135, 21);
		add(lblEmailPersonal);

		lblITR = new JLabel("ITR *");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(647, 224, 136, 21);
		add(lblITR);

		lblDepartamento = new JLabel("Departamento *");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartamento.setBounds(121, 444, 135, 21);
		add(lblDepartamento);

		txtDocumento = new JTextField();
		txtDocumento.setForeground(Color.DARK_GRAY);
		txtDocumento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(284, 409, 140, 20);
		add(txtDocumento);

		txtPrimerNombre = new JTextField();
		txtPrimerNombre.setForeground(Color.DARK_GRAY);
		txtPrimerNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPrimerNombre.setColumns(10);
		txtPrimerNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPrimerNombre.setBounds(121, 244, 140, 20);
		add(txtPrimerNombre);

		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setForeground(Color.DARK_GRAY);
		txtSegundoNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSegundoNombre.setColumns(10);
		txtSegundoNombre.setBorder(null);
		txtSegundoNombre.setBounds(284, 244, 140, 20);
		add(txtSegundoNombre);

		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setForeground(Color.DARK_GRAY);
		txtPrimerApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtPrimerApellido.setColumns(10);
		txtPrimerApellido.setBorder(null);
		txtPrimerApellido.setBounds(121, 299, 140, 20);
		add(txtPrimerApellido);

		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setForeground(Color.DARK_GRAY);
		txtSegundoApellido.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBorder(null);
		txtSegundoApellido.setBounds(284, 299, 140, 20);
		add(txtSegundoApellido);

		txtEmailInstitucional = new JTextField();
		txtEmailInstitucional.setEnabled(false);
		txtEmailInstitucional.setEditable(false);
		txtEmailInstitucional.setForeground(Color.DARK_GRAY);
		txtEmailInstitucional.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmailInstitucional.setColumns(10);
		txtEmailInstitucional.setBorder(null);
		txtEmailInstitucional.setBounds(484, 244, 140, 20);
		add(txtEmailInstitucional);

		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.DARK_GRAY);
		txtTelefono.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(284, 354, 140, 20);
		add(txtTelefono);

		txtEmailPersonal = new JTextField();
		txtEmailPersonal.setToolTipText("");
		txtEmailPersonal.setForeground(Color.DARK_GRAY);
		txtEmailPersonal.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtEmailPersonal.setColumns(10);
		txtEmailPersonal.setBorder(null);
		txtEmailPersonal.setBounds(121, 354, 140, 20);
		add(txtEmailPersonal);

		spDocumento = new JSeparator();
		spDocumento.setBackground(SystemColor.textHighlight);
		spDocumento.setBounds(284, 429, 140, 14);
		add(spDocumento);

		spPrimerApellido = new JSeparator();
		spPrimerApellido.setBackground(SystemColor.textHighlight);
		spPrimerApellido.setBounds(121, 319, 140, 14);
		add(spPrimerApellido);

		spSegundoApellido = new JSeparator();
		spSegundoApellido.setBackground(SystemColor.textHighlight);
		spSegundoApellido.setBounds(284, 319, 140, 14);
		add(spSegundoApellido);

		spEmailInstitucional = new JSeparator();
		spEmailInstitucional.setBackground(SystemColor.textHighlight);
		spEmailInstitucional.setBounds(484, 264, 140, 14);
		add(spEmailInstitucional);

		spEmailPersonal = new JSeparator();
		spEmailPersonal.setBackground(SystemColor.textHighlight);
		spEmailPersonal.setBounds(121, 374, 140, 14);
		add(spEmailPersonal);

		spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(121, 484, 140, 14);
		add(spDepartamento);

		spLocalidad = new JSeparator();
		spLocalidad.setBackground(SystemColor.textHighlight);
		spLocalidad.setBounds(284, 484, 140, 14);
		add(spLocalidad);

		spTelefono = new JSeparator();
		spTelefono.setBackground(SystemColor.textHighlight);
		spTelefono.setBounds(284, 374, 140, 14);
		add(spTelefono);

		spFechaNacimiento = new JSeparator();
		spFechaNacimiento.setBackground(SystemColor.textHighlight);
		spFechaNacimiento.setBounds(121, 532, 140, 14);
		add(spFechaNacimiento);

		spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(121, 200, 299, 14);
		add(spDatosPersonales);

		spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(484, 200, 299, 14);
		add(spDatosAcademicos);

		spITR = new JSeparator();
		spITR.setBackground(SystemColor.textHighlight);
		spITR.setBounds(647, 264, 140, 14);
		add(spITR);

		JSeparator spVertical = new JSeparator();
		spVertical.setOrientation(SwingConstants.VERTICAL);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setBounds(456, 212, 18, 286);
		add(spVertical);

		JSeparator spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(121, 264, 140, 14);
		add(spPrimerNombre);

		JSeparator spSegundoNombre = new JSeparator();
		spSegundoNombre.setBackground(SystemColor.textHighlight);
		spSegundoNombre.setBounds(284, 264, 140, 14);
		add(spSegundoNombre);

		JSeparator spGenero = new JSeparator();
		spGenero.setBackground(SystemColor.textHighlight);
		spGenero.setBounds(121, 429, 140, 14);
		add(spGenero);

		cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "Otro" }));
		cmbGenero.setForeground(Color.DARK_GRAY);
		cmbGenero.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGenero.setFocusable(false);
		cmbGenero.setBorder(null);
		cmbGenero.setBackground(Color.WHITE);
		cmbGenero.setBounds(121, 410, 140, 22);
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
		cmbLocalidad.setBounds(284, 464, 140, 20);
		add(cmbLocalidad);

		cmbDepartamento = new JComboBox<Departamento>();
		cmbDepartamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cmbLocalidad.removeAllItems();
				for (Localidad localidad : DatabaseManager.getInstance().getLocalidadesBeanRemote().obtenerTodos()) {
					if (localidad.getDepartamento()
							.getIdDepartamento() == ((Departamento) cmbDepartamento.getSelectedItem())
									.getIdDepartamento()) {
						cmbLocalidad.addItem(localidad);
					}
				}
			}
		});

		for (Departamento departamento : DatabaseManager.getInstance().getDepartamentosBeanRemote().obtenerTodos()) {
			cmbDepartamento.addItem(departamento);
		}
		cmbDepartamento.setForeground(Color.DARK_GRAY);
		cmbDepartamento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbDepartamento.setFocusable(false);
		cmbDepartamento.setBorder(null);
		cmbDepartamento.setBackground(Color.WHITE);
		cmbDepartamento.setBounds(121, 464, 140, 20);
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
		cmbITR.setBounds(647, 244, 140, 20);
		add(cmbITR);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModificar.setFocusable(false);
		btnModificar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModificar.setBackground(SystemColor.textHighlight);
		btnModificar.setActionCommand("");
		btnModificar.setBounds(525, 415, 223, 49);
		add(btnModificar);

		JLabel lblRegistroDeUsuario = new JLabel("MODIFICAR DATOS DE USUARIO");
		lblRegistroDeUsuario.setForeground(Color.BLACK);
		lblRegistroDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblRegistroDeUsuario.setBounds(121, 116, 390, 41);
		add(lblRegistroDeUsuario);

		JLabel lblAviso = new JLabel("Los campos marcados con * son obligatorios.");
		lblAviso.setForeground(Color.DARK_GRAY);
		lblAviso.setFont(new Font("Segoe UI", Font.ITALIC, 10));
		lblAviso.setBounds(121, 557, 230, 13);
		add(lblAviso);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(121, 516, 140, 19);
		add(dateChooser);

		lblEstado = new JLabel("Estado *");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(484, 279, 136, 21);
		add(lblEstado);

		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] { "Sin Validar", "Validado", "Eliminado" }));
		cmbEstado.setForeground(Color.DARK_GRAY);
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setFocusable(false);
		cmbEstado.setBorder(null);
		cmbEstado.setBackground(Color.WHITE);
		cmbEstado.setBounds(484, 299, 140, 20);
		add(cmbEstado);

		spEstado = new JSeparator();
		spEstado.setBackground(SystemColor.textHighlight);
		spEstado.setBounds(484, 319, 140, 14);
		add(spEstado);

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
		String primerApellido = txtPrimerApellido.getText();
		String documento = txtDocumento.getText();
		String emailPersonal = txtEmailPersonal.getText();
		String telefono = txtTelefono.getText();
		String emailInstitucional = txtEmailInstitucional.getText();

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

		}
		return true;
	}

	public void cargarDatos(Analista analista) {
		txtDocumento.setText(analista.getDocumento());
		txtEmailInstitucional.setText(analista.getMail());
		txtEmailPersonal.setText(analista.getMailPersonal());
		txtPrimerApellido.setText(analista.getApellido1());
		txtPrimerNombre.setText(analista.getNombre1());
		txtSegundoApellido.setText(analista.getApellido2());
		txtSegundoNombre.setText(analista.getNombre2());
		txtTelefono.setText(analista.getTelefono());

		List<Localidad> localidades = new ArrayList<>();

		for (int i = 0; i < cmbLocalidad.getItemCount(); i++) {
			localidades.add(cmbLocalidad.getItemAt(i));
		}

		for (Localidad localidad : localidades) {
			if (localidad.getIdLocalidad() == analista.getLocalidad().getIdLocalidad()) {
				cmbLocalidad.setSelectedItem(localidad);
			}
		}

		List<Departamento> departamentos = new ArrayList<>();

		for (int i = 0; i < cmbDepartamento.getItemCount(); i++) {
			departamentos.add(cmbDepartamento.getItemAt(i));
		}

		for (Departamento departamento : departamentos) {
			if (departamento.getIdDepartamento() == analista.getLocalidad().getDepartamento().getIdDepartamento()) {
				cmbDepartamento.setSelectedItem(departamento);
			}
		}

		List<Itr> itrs = new ArrayList<>();

		for (int i = 0; i < cmbITR.getItemCount(); i++) {
			itrs.add(cmbITR.getItemAt(i));
		}

		for (Itr itr : itrs) {
			if (itr.getIdItr() == analista.getItr().getIdItr()) {
				cmbITR.setSelectedItem(itr);
			}
		}

		cmbGenero.setSelectedItem(analista.getGenero());
		cmbEstado.setSelectedItem(analista.getEstado());
		dateChooser.setDate(analista.getFechaNacimiento());
	}

	public void editarAnalista(Analista analista) throws Exception {
		analista.setApellido1(getTxtPrimerApellido());
		analista.setApellido2(getTxtSegundoApellido());
		analista.setDocumento(getTxtDocumento());
		analista.setFechaNacimiento(getDateChooser());
		analista.setGenero(getCmbGenero());
		analista.setItr(getCmbITR());
		analista.setLocalidad(getCmbLocalidad());
		analista.setMailPersonal(getTxtEmailPersonal());
		analista.setNombre1(getTxtPrimerNombre());
		analista.setNombre2(getTxtSegundoNombre());
		analista.setEstado(getCmbEstado());

		DatabaseManager.getInstance().getAnalistasBeanRemote().editar(analista);
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
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

	public String getCmbEstado() {
		return (String) cmbEstado.getSelectedItem();
	}

	public void setCmbEstado(JComboBox<String> cmbEstado) {
		this.cmbEstado = cmbEstado;
	}

	public Date getDateChooser() {
		return dateChooser.getDate();
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}
}
