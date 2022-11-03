package com.tix.controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Area;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Tutor;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.LocalidadesBeanRemote;
import com.tix.modelo.servicios.TutoresBeanRemote;
import com.tix.vista.Registro;

import org.apache.commons.collections.functors.IfClosure;

public class RegistroControlador {
	private Registro vista = new Registro();

	private AnalistasBeanRemote analistasBeanRemote;
	private EstudiantesBeanRemote estudiantesBeanRemote;
	private TutoresBeanRemote tutoresBeanRemote;

	public RegistroControlador() throws NamingException {

		analistasBeanRemote = (AnalistasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AnalistasBean!com.tix.modelo.servicios.AnalistasBeanRemote");

		estudiantesBeanRemote = (EstudiantesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/EstudiantesBean!com.tix.modelo.servicios.EstudiantesBeanRemote");

		tutoresBeanRemote = (TutoresBeanRemote) InitialContext
				.doLookup("ProyectoEJB/TutoresBean!com.tix.modelo.servicios.TutoresBeanRemote");

		vista.getBtnRegistrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (vista.validarCamposIngresados()) {
					switch (vista.getCmbTipoUsuario().getSelectedIndex()) {
						case 0:
							try {
								registrarAnalista();
								JOptionPane.showMessageDialog(null,
										"Su solicitud de registro se procesó correctamente y será revisada antes de estar activa.",
										"Registro de usuario", JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"El usuario que está tratando de registrar ya existe.");
							}
							break;
						case 1:
							try {
								registrarEstudiante();
								JOptionPane.showMessageDialog(null,
										"Su solicitud de registro se procesó correctamente y será revisada antes de estar activa.",
										"Registro de usuario", JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"El usuario que está tratando de registrar ya existe.");
							}
							break;
						case 2:
							try {
								registrarTutor();
								JOptionPane.showMessageDialog(null,
										"Su solicitud de registro se procesó correctamente y será revisada antes de estar activa.",
										"Registro de usuario", JOptionPane.INFORMATION_MESSAGE);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"El usuario que está tratando de registrar ya existe.");
							}
							break;
					}
				}
			}

		});

		vista.getCmbTipoUsuario().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				vista.setCampos();
			}
		});
	}

	public Registro getVista() {
		return vista;
	}

	public void setVista(Registro vista) {
		this.vista = vista;
	}

	public void registrarAnalista() throws Exception {

		Analista analista = new Analista();

		String emailInstitucional = vista.getTxtEmailInstitucional();
		String nombreUsuario = emailInstitucional.substring(0, emailInstitucional.indexOf('@'));

		analista.setApellido1(vista.getTxtPrimerApellido());
		analista.setApellido2(vista.getTxtSegundoApellido());
		analista.setNombre1(vista.getTxtPrimerNombre());
		analista.setNombre2(vista.getTxtSegundoNombre());
		analista.setMailPersonal(vista.getTxtEmailPersonal());
		analista.setTelefono(vista.getTxtTelefono());
		analista.setFechaNacimiento(new Date(0));
		analista.setDocumento(vista.getTxtDocumento());
		analista.setGenero(vista.getCmbGenero());
		analista.setMail(vista.getTxtEmailInstitucional());
		analista.setContrasenia(vista.getTxtContrasenia());
		analista.setNombreUsuario(nombreUsuario);
		analista.setFechaNacimiento(vista.getDateChooser());
		analista.setItr(vista.getCmbITR());
		analista.setLocalidad(vista.getCmbLocalidad());
		analista.setEstado(0);

		analistasBeanRemote.registro((Analista) analista);
	}

	public void registrarEstudiante() throws Exception {
		Estudiante estudiante = new Estudiante();

		String emailInstitucional = vista.getTxtEmailInstitucional();
		String nombreUsuario = emailInstitucional.substring(0, emailInstitucional.indexOf('@'));

		estudiante.setApellido1(vista.getTxtPrimerApellido());
		estudiante.setApellido2(vista.getTxtSegundoApellido());
		estudiante.setNombre1(vista.getTxtPrimerNombre());
		estudiante.setNombre2(vista.getTxtSegundoNombre());
		estudiante.setMailPersonal(vista.getTxtEmailPersonal());
		estudiante.setTelefono(vista.getTxtTelefono());
		estudiante.setFechaNacimiento(new Date(0));
		estudiante.setDocumento(vista.getTxtDocumento());
		estudiante.setGenero(vista.getCmbGenero());
		estudiante.setMail(vista.getTxtEmailInstitucional());
		estudiante.setContrasenia(vista.getTxtContrasenia());
		estudiante.setNombreUsuario(nombreUsuario);
		estudiante.setGeneracion(vista.getTxtGeneracion());
		estudiante.setFechaNacimiento(vista.getDateChooser());
		estudiante.setItr(vista.getCmbITR());
		estudiante.setLocalidad(vista.getCmbLocalidad());
		estudiante.setEstado(0);

		estudiantesBeanRemote.registro(estudiante);
	}

	public void registrarTutor() throws Exception {
		Tutor tutor = new Tutor();

		String emailInstitucional = vista.getTxtEmailInstitucional();
		String nombreUsuario = emailInstitucional.substring(0, emailInstitucional.indexOf('@'));

		tutor.setApellido1(vista.getTxtPrimerApellido());
		tutor.setApellido2(vista.getTxtSegundoApellido());
		tutor.setNombre1(vista.getTxtPrimerNombre());
		tutor.setNombre2(vista.getTxtSegundoNombre());
		tutor.setMailPersonal(vista.getTxtEmailPersonal());
		tutor.setTelefono(vista.getTxtTelefono());
		tutor.setFechaNacimiento(new Date(0));
		tutor.setDocumento(vista.getTxtDocumento());
		tutor.setGenero(vista.getCmbGenero());
		tutor.setMail(vista.getTxtEmailInstitucional());
		tutor.setContrasenia(vista.getTxtContrasenia());
		tutor.setNombreUsuario(nombreUsuario);
		tutor.setTipo(vista.getCmbRol());
		tutor.setArea((Area) vista.getCmbArea());
		tutor.setFechaNacimiento(vista.getDateChooser());
		tutor.setItr(vista.getCmbITR());
		tutor.setLocalidad(vista.getCmbLocalidad());

		tutor.setEstado(0);

		tutoresBeanRemote.registro(tutor);
	}

}
