package com.tix.controlador;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.TutoresBeanRemote;
import com.tix.vista.Login;

public class LoginControlador {

	private Login vista = new Login();

	private AnalistasBeanRemote analistasBeanRemote;
	private EstudiantesBeanRemote estudiantesBeanRemote;
	private TutoresBeanRemote tutoresBeanRemote;

	public LoginControlador() throws NamingException {

		analistasBeanRemote = (AnalistasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AnalistasBean!com.tix.modelo.servicios.AnalistasBeanRemote");

		estudiantesBeanRemote = (EstudiantesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/EstudiantesBean!com.tix.modelo.servicios.EstudiantesBeanRemote");

		tutoresBeanRemote = (TutoresBeanRemote) InitialContext
				.doLookup("ProyectoEJB/TutoresBean!com.tix.modelo.servicios.TutoresBeanRemote");

	}

	public boolean login(int tipoUsuarioLogin) throws Exception {
		String nombreUsuario = vista.getTxtUsuario();

		Usuario usuario = null;

		switch (tipoUsuarioLogin) {
			case 0:
				usuario = analistasBeanRemote.obtenerAnalistaPorNombreUsuario(nombreUsuario).get(0);
				break;
			case 1:
				usuario = estudiantesBeanRemote.obtenerEstudiantePorNombreUsuario(nombreUsuario).get(0);
				break;
			case 2:
				usuario = tutoresBeanRemote.obtenerTutorPorNombreUsuario(nombreUsuario).get(0);
				break;
		}

		if (usuario.getContrasenia().equals(vista.getTxtContrasenia())) {
			return true;
		} else {
			return false;
		}
	}

	public Login getVista() {
		return vista;
	}

	public void setVista(Login vista) {
		this.vista = vista;
	}

}
