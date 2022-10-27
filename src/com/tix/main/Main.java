package com.tix.main;

import java.awt.EventQueue;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.tix.controlador.PrincipalControlador;
import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.UsuariosBeanRemote;

public class Main {

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

}
