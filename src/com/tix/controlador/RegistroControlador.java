package com.tix.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tix.vista.Registro;

public class RegistroControlador {
	private Registro vista = new Registro();

	public RegistroControlador() {
		vista.getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}

	public Registro getVista() {
		return vista;
	}

	public void setVista(Registro vista) {
		this.vista = vista;
	}

}
