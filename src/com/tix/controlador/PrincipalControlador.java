package com.tix.controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.tix.vista.ListadoJustificaciones;
import com.tix.vista.ListadoUsuarios;
import com.tix.vista.Principal;

public class PrincipalControlador {

	private Principal vista = new Principal();

	public PrincipalControlador() {
		
		//Botón NUEVO USUARIO
		vista.getLoginPanel().getBtnNuevoUsuario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getRegistroPanel());
				vista.setSize(1060, 700);
				vista.setLocationRelativeTo(null);
			}
		});
		
		//Botón REGISTRARSE
		vista.getRegistroPanel().getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getLoginPanel());
				vista.setSize(400, 500);
				vista.setLocationRelativeTo(null);
			}
		});
		
		//Botón INICIAR SESIÓN
		vista.getLoginPanel().getBtnIniciarSesion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.setContentPane(vista.getDashboardAnalista()); 	
				
				vista.setSize(1060, 700);
				vista.setLocationRelativeTo(null);
			}
		});
		
		//Botón JUSTIFICACIONES del dashboard
		vista.getDashboardAnalista().getBtnJustificaciones().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getDashboardAnalista().cambiarVista(new ListadoJustificaciones());
			}
		});
		
		//Botón USUARIOS del dashboard
		vista.getDashboardAnalista().getBtnUsuarios().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vista.getDashboardAnalista().cambiarVista(new ListadoUsuarios());
			}
		});
		
		
		
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalControlador principalControlador = new PrincipalControlador();
					principalControlador.getVista().setContentPane(principalControlador.getVista().getLoginPanel());
					principalControlador.getVista().setVisible(true);
					principalControlador.getVista().setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal getVista() {
		return vista;
	}

}
