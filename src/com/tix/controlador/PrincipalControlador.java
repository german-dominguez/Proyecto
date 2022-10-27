package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;

import com.tix.vista.Principal;

public class PrincipalControlador {

	private Principal vista;

	public PrincipalControlador() throws NamingException {
		
		vista = new Principal();

		// Botón NUEVO USUARIO - Cambia a la vista de registro
		vista.getLoginPanel().getBtnNuevoUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getRegistroPanel());
				vista.setSize(750, 500);
				vista.setLocationRelativeTo(null);
			}
		});

		// Botón REGISTRARSE - Cambia a la vista de login
		vista.getRegistroPanel().getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getLoginPanel());
				vista.setSize(350, 500);
				vista.setLocationRelativeTo(null);
			}
		});

		// Botón INICIAR SESIÓN - Cambia a la vista de dashboard
		vista.getLoginPanel().getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getDashboardAnalista());
				vista.setSize(1060, 700);
				vista.setLocationRelativeTo(null);
			}
		});

		// Botón CERRAR SESIÓN en el dashboard - Cambia a la vista de login
		vista.getDashboardAnalista().getLblCerrarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getLoginPanel());
				vista.setSize(350, 500);
				vista.setLocationRelativeTo(null);
			}
		});

		// Botón EDITAR DATOS PROPIOS en el dashboard
		vista.getDashboardAnalista().getLblEditarUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getModificarDatosPropios());
				vista.setSize(750, 500);
				vista.setLocationRelativeTo(null);
			}
		});

	}

	public Principal getVista() {
		return vista;
	}

}
