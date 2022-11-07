package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;

import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Usuario;
import com.tix.vista.ModificarDatosPropios;
import com.tix.vista.analista.DashboardAnalista;
import com.tix.vista.analista.ListadoJustificacionesAnalista;
import com.tix.vista.analista.ListadoReclamosAnalista;
import com.tix.vista.analista.ListadoUsuariosAnalista;

public class DashboardAnalistaControlador {
	private DashboardAnalista vista;

	public DashboardAnalistaControlador() {
		vista = new DashboardAnalista();

		// Botón JUSTIFICACIONES del dashboard
		vista.getBtnJustificaciones().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(vista.getListadoJustificaciones());
			}
		});

		// Botón USUARIOS del dashboard
		vista.getBtnUsuarios().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(vista.getListadoUsuarios());
			}
		});

		// Botón RECLAMOS en el dashboard
		vista.getBtnReclamos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(vista.getListadoReclamos());
			}
		});

		vista.getLblEditarUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getModificarDatosPropios().setAnalista((Analista) vista.getUsuario());
				vista.getModificarDatosPropios().cargarDatos();
				vista.cambiarVista(vista.getModificarDatosPropios());
			}
		});

		vista.getModificarDatosPropios().getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					vista.getModificarDatosPropios().editarAnalista();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public DashboardAnalista getVista() {
		return vista;
	}

	public void setVista(DashboardAnalista vista) {
		this.vista = vista;
	}
}
