package com.tix.principal;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.tix.vista.Registro;
import com.tix.vista.RegistroPanel;

public class Principal {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		/* Set Look And Feel Theme */
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}