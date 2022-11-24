package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Usuario;
import com.tix.vista.analista.DashboardAnalista;
import com.tix.vista.analista.ListadoJustificaciones;
import com.tix.vista.analista.ReportesAnalista;
import com.tix.vista.analista.ListadoUsuarios;
import com.tix.vista.analista.ModificarDatosPropios;

public class DashboardAnalistaControlador {
	private DashboardAnalista vista;

	public DashboardAnalistaControlador() {
		vista = new DashboardAnalista();

		// Botón JUSTIFICACIONES del dashboard
		vista.getBtnJustificaciones().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(vista.getListadoJustificaciones());
				vista.getListadoJustificaciones().cargarTabla();
			}
		});

		// Botón USUARIOS del dashboard
		vista.getBtnUsuarios().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getListadoUsuarios().limpiarFiltros();
				vista.cambiarVista(vista.getListadoUsuarios());
				vista.getListadoUsuarios().cargarTabla();
			}
		});

		// Botón RECLAMOS en el dashboard
		vista.getBtnReclamos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.cambiarVista(vista.getListadoReclamos());
			}
		});

		// Botón ITR en el dashboard
		vista.getBtnItr().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getListadoItrs().limpiarFiltros();
				vista.cambiarVista(vista.getListadoItrs());
				vista.getListadoItrs().setButtonEditor(vista.new ItrsButtonEditor(new JCheckBox()));
				vista.getListadoItrs().cargarTabla();
			}
		});

		vista.getLblEditarUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getModificarDatosPropios().setAnalista(vista.getUsuario());
				vista.getModificarDatosPropios().cargarDatos();
				vista.cambiarVista(vista.getModificarDatosPropios());
			}
		});

		vista.getModificarDatosPropios().getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					vista.getModificarDatosPropios().editarAnalista();
					JOptionPane.showMessageDialog(null, "El usuario ha sido actualizado con éxito");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al tratar de actualizar el usuario");
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
