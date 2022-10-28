package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.UsuariosBeanRemote;
import com.tix.vista.Login;

public class LoginControlador {

	private Login vista = new Login();

	private UsuariosBeanRemote usuariosBeanRemote;

	public LoginControlador() throws NamingException {

		usuariosBeanRemote = (UsuariosBeanRemote) InitialContext
				.doLookup("ProyectoEJB/UsuariosBean!com.tix.modelo.servicios.UsuariosBeanRemote");

		vista.getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (login()) {
					System.out.println("jeje");
				} else {
					System.out.println("efe");
				}
			}
		});
	}

	public boolean login() {
		String nombreUsuario = vista.getTxtUsuario();
		Usuario usuario = usuariosBeanRemote.obtenerPorNombreUsuario(nombreUsuario);

		if (usuario.getContrasenia() == vista.getTxtContrasenia()) {
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
