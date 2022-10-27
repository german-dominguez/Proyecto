package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tix.modelo.entidades.Analista;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.LocalidadesBeanRemote;
import com.tix.vista.Registro;

public class RegistroControlador {
	private Registro vista = new Registro();

	private AnalistasBeanRemote analistasBeanRemote;
	private LocalidadesBeanRemote localidadesBeanRemote;
	private ItrsBeanRemote itrsBeanRemote;

	public RegistroControlador() throws NamingException {

		analistasBeanRemote = (AnalistasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AnalistasBean!com.tix.modelo.servicios.AnalistasBeanRemote");

		localidadesBeanRemote = (LocalidadesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/LocalidadesBean!com.tix.modelo.servicios.LocalidadesBeanRemote");

		itrsBeanRemote = (ItrsBeanRemote) InitialContext
				.doLookup("ProyectoEJB/ItrsBean!com.tix.modelo.servicios.ItrsBeanRemote");

		vista.getBtnRegistrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Analista analista = new Analista();

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

				analista.setFechaNacimiento(new Date(System.currentTimeMillis()));
				analista.setEstado(0);
				analista.setGenero("masculino");
				analista.setItr(itrsBeanRemote.obtenerItrPorId((long) 1));
				analista.setLocalidad(localidadesBeanRemote.obtenerLocalidadPorId((long) 1));
				analista.setNombreUsuario("german.dominguez");

				analistasBeanRemote.registro(analista);
			}
		});
	}

	public Registro getVista() {
		return vista;
	}

	public void setVista(Registro vista) {
		this.vista = vista;
	}
}
