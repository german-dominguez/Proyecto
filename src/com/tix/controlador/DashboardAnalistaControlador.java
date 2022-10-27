package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tix.vista.analista.DashboardAnalista;
import com.tix.vista.analista.ListadoJustificacionesAnalista;
import com.tix.vista.analista.ListadoReclamosAnalista;
import com.tix.vista.analista.ListadoUsuariosAnalista;

public class DashboardAnalistaControlador {
	private DashboardAnalista vista = new DashboardAnalista();
	private ListadoUsuariosAnalista listadoUsuarios = new ListadoUsuariosAnalista();
	private ListadoJustificacionesAnalista listadoJustificaciones = new ListadoJustificacionesAnalista();
	private ListadoReclamosAnalista listadoReclamos = new ListadoReclamosAnalista();

	public DashboardAnalistaControlador() {

		// Botón JUSTIFICACIONES del dashboard
		vista.getBtnJustificaciones().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(listadoUsuarios);
			}
		});

		// Botón USUARIOS del dashboard
		vista.getBtnUsuarios().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(listadoJustificaciones);
			}
		});

		// Botón RECLAMOS en el dashboard
		vista.getBtnReclamos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(listadoReclamos);
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
