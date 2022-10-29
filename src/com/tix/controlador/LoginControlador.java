package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.TutoresBeanRemote;
import com.tix.modelo.servicios.UsuariosBeanRemote;
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

		vista.getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
	}

	public boolean login(int tipoUsuarioLogin) {
		String nombreUsuario = vista.getTxtUsuario();
		
		Usuario usuario = null;
		
		if (tipoUsuarioLogin == 0) { //Analista
			usuario = analistasBeanRemote.obtenerAnalistaPorNombreUsuario(nombreUsuario);
		} else if (tipoUsuarioLogin == 1) { //Estudiante
			usuario = estudiantesBeanRemote.obtenerEstudiantePorNombreUsuario(nombreUsuario);
		} else if (tipoUsuarioLogin == 2){ //Tutor
			usuario = tutoresBeanRemote.obtenerTutorPorNombreUsuario(nombreUsuario);
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
