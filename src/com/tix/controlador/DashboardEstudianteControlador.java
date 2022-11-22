package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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

		vista.getModificarDatosPropios().getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					vista.getModificarDatosPropios().editarEstudiante();
					JOptionPane.showMessageDialog(null, "El usuario ha sido actualizado con éxito");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al tratar de actualizar el usuario");
				}
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
