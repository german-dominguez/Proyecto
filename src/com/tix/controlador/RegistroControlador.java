package com.tix.controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

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

public class RegistroControlador {
	private Registro vista = new Registro();

	private AnalistasBeanRemote analistasBeanRemote;
	private EstudiantesBeanRemote estudiantesBeanRemote;
	private TutoresBeanRemote tutoresBeanRemote;
	private LocalidadesBeanRemote localidadesBeanRemote;
	private ItrsBeanRemote itrsBeanRemote;

	public RegistroControlador() throws NamingException {

		analistasBeanRemote = (AnalistasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AnalistasBean!com.tix.modelo.servicios.AnalistasBeanRemote");

		estudiantesBeanRemote = (EstudiantesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/EstudiantesBean!com.tix.modelo.servicios.EstudiantesBeanRemote");

		tutoresBeanRemote = (TutoresBeanRemote) InitialContext
				.doLookup("ProyectoEJB/TutoresBean!com.tix.modelo.servicios.TutoresBeanRemote");

		localidadesBeanRemote = (LocalidadesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/LocalidadesBean!com.tix.modelo.servicios.LocalidadesBeanRemote");

		itrsBeanRemote = (ItrsBeanRemote) InitialContext
				.doLookup("ProyectoEJB/ItrsBean!com.tix.modelo.servicios.ItrsBeanRemote");

		vista.getBtnRegistrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				vista.validarCamposIngresados();

				switch (vista.getCmbTipoUsuario().getSelectedIndex()) {
					case 0:
						registrarAnalista();
						break;
					case 1:
						registrarEstudiante();
						break;
					case 2:
						registrarTutor();
						break;
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

	public void registrarAnalista() {
		
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
		analista.setMail(vista.getTxtEmailInstitucional());
		analista.setContrasenia(vista.getTxtContrasenia());
		analista.setNombreUsuario(nombreUsuario);

		analista.setFechaNacimiento(new Date(System.currentTimeMillis()));
		analista.setEstado(0);
		analista.setGenero("masculino");
		analista.setItr(itrsBeanRemote.obtenerItrPorId((long) 1));
		analista.setLocalidad(localidadesBeanRemote.obtenerLocalidadPorId((long) 1));

		analistasBeanRemote.registro((Analista) analista);
	}

	public void registrarEstudiante() {
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
		estudiante.setMail(vista.getTxtEmailInstitucional());
		estudiante.setContrasenia(vista.getTxtContrasenia());
		estudiante.setNombreUsuario(nombreUsuario);
		estudiante.setGeneracion(vista.getTxtGeneracion());

		estudiante.setFechaNacimiento(new Date(System.currentTimeMillis()));
		estudiante.setEstado(0);
		estudiante.setGenero("masculino");
		estudiante.setItr(itrsBeanRemote.obtenerItrPorId((long) 1));
		System.out.println(itrsBeanRemote.obtenerItrPorId((long) 1).getNombre());
		estudiante.setLocalidad(localidadesBeanRemote.obtenerLocalidadPorId((long) 1));

		estudiantesBeanRemote.registro(estudiante);
	}

	public void registrarTutor() {
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
		tutor.setMail(vista.getTxtEmailInstitucional());
		tutor.setContrasenia(vista.getTxtContrasenia());
		tutor.setNombreUsuario(nombreUsuario);
		tutor.setTipo(vista.getCmbRol().getSelectedItem().toString());
		tutor.setArea((Area) vista.getCmbArea().getSelectedItem());

		tutor.setFechaNacimiento(new Date(System.currentTimeMillis()));
		tutor.setEstado(0);
		tutor.setGenero("masculino");
		tutor.setItr(itrsBeanRemote.obtenerItrPorId((long) 1));
		tutor.setLocalidad(localidadesBeanRemote.obtenerLocalidadPorId((long) 1));

		tutoresBeanRemote.registro(tutor);
	}

}
