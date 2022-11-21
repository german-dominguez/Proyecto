package com.tix.controlador;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.Usuario;
import com.tix.vista.Login;

public class LoginControlador {

	private Login vista = new Login();

	private Usuario usuario = null;

	public LoginControlador() {

	}

	public boolean login(int tipoUsuarioLogin) throws Exception {
		String nombreUsuario = vista.getTxtUsuario();

		switch (tipoUsuarioLogin) {
			case 0:
				usuario = DatabaseManager.getInstance().getAnalistasBeanRemote()
						.obtenerAnalistaPorNombreUsuario(nombreUsuario).get(0);
				break;
			case 1:
				usuario = DatabaseManager.getInstance().getEstudiantesBeanRemote()
						.obtenerEstudiantePorNombreUsuario(nombreUsuario).get(0);
				break;
			case 2:
				usuario = DatabaseManager.getInstance().getTutoresBeanRemote()
						.obtenerTutorPorNombreUsuario(nombreUsuario).get(0);
				break;
		}

		if (usuario.getEstado() == "Sin Validar" || usuario.getEstado() == "Eliminado") {
			return false;
		}

		if (usuario.getContrasenia().equals(vista.getTxtContrasenia())) {
			return true;
		} else {
			return false;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Login getVista() {
		return vista;
	}

	public void setVista(Login vista) {
		this.vista = vista;
	}

}
