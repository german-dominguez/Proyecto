package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tix.vista.analista.DashboardAnalista;
import com.tix.vista.analista.ListadoJustificaciones;
import com.tix.vista.analista.ListadoReclamos;
import com.tix.vista.analista.ListadoUsuarios;
import com.tix.vista.estudiante.DashboardEstudiante;
import com.tix.vista.estudiante.ListadoJustificacionesEstudiante;

public class DashboardEstudianteControlador {
	private DashboardEstudiante vista = new DashboardEstudiante();
	private ListadoJustificacionesEstudiante listadoJustificaciones = new ListadoJustificacionesEstudiante();
	// private ListadoReclamosAnalista listadoReclamos = new
	// ListadoReclamosAnalista();

	public DashboardEstudianteControlador() {

		// Botón USUARIOS del dashboard
		vista.getBtnJustificaciones().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(listadoJustificaciones);
			}
		});

		vista.getLblEditarUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getModificarDatosPropios().setEstudiante((vista.getUsuario()));
				vista.getModificarDatosPropios().cargarDatos();
				vista.cambiarVista(vista.getModificarDatosPropios());
			}
		});

	}

	public DashboardEstudiante getVista() {
		return vista;
	}

	public void setVista(DashboardEstudiante vista) {
		this.vista = vista;
	}
}
