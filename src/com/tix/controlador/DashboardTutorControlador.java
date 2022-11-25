package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.tix.database.DatabaseManager;
import com.tix.vista.tutor.DashboardTutor;

public class DashboardTutorControlador {

	private DashboardTutor vista = new DashboardTutor();

	public DashboardTutorControlador() {
		vista.getLblEditarUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getModificarDatosPropios().setTutor(DatabaseManager.getInstance().getTutoresBeanRemote()
						.obtenerTutorPorId(vista.getUsuario().getIdUsuario()));
				vista.getModificarDatosPropios().cargarDatos();
				vista.cambiarVista(vista.getModificarDatosPropios());
			}
		});

		vista.getModificarDatosPropios().getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					vista.getModificarDatosPropios().editarTutor();
					JOptionPane.showMessageDialog(null, "El usuario ha sido actualizado con éxito");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al tratar de actualizar el usuario");
				}
			}
		});

		vista.getBtnReportes().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(vista.getReportes());
			}
		});
	}

	public DashboardTutor getVista() {
		return vista;
	}

	public void setVista(DashboardTutor vista) {
		this.vista = vista;
	}

}
