package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tix.vista.Login;

public class LoginControlador {

	private Login vista = new Login();

	public LoginControlador() {
		vista.getBtnNuevoUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

	public Login getVista() {
		return vista;
	}

	public void setVista(Login vista) {
		this.vista = vista;
	}

}
