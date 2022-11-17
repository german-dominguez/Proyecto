package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.tix.modelo.entidades.Analista;
import com.tix.vista.Principal;

public class PrincipalControlador {

	private Principal vista;

	public PrincipalControlador() {

		vista = new Principal();

		// Botón NUEVO USUARIO - Cambia a la vista de registro
		vista.getLoginPanel().getBtnNuevoUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getRegistroPanel());
				vista.setSize(750, 510);
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

				int a = vista.getLoginPanel().getCmbTipoUsuario().getSelectedIndex();

				try {
					if (vista.getLoginControlador().login(a)) {

						vista.setSize(1060, 700);
						vista.setLocationRelativeTo(null);

						switch (a) {
							case 0: {
								vista.getDashboardAnalista()
										.setUsuario((Analista) vista.getLoginControlador().getUsuario());
								vista.getDashboardAnalista()
										.setLblNombreUsuario(vista.getDashboardAnalista().getUsuario().getNombre1());
								vista.getDashboardAnalista().getListadoUsuarios().cargarTabla();
								vista.setContentPane(vista.getDashboardAnalista());
								break;
							}
							case 1: {
								vista.setContentPane(vista.getDashboardEstudiante());
								break;
							}
							case 2:
								vista.setContentPane(vista.getDashboardEstudiante());
								break;
						}

						vista.getLoginPanel().vaciarCampos();
					} else {
						JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña son incorrectos.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña son incorrectos.");
				}
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

	}

	public Principal getVista() {
		return vista;
	}

}
