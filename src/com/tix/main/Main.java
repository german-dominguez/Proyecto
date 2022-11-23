package com.tix.main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.tix.controlador.PrincipalControlador;
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
