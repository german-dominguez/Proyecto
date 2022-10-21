package com.tix.vista;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBackground(Color.WHITE);
		setSize(new Dimension(1060, 700));
		setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblIniciarSesion.setBounds(70, 118, 170, 32);
		add(lblIniciarSesion);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(72, 206, 65, 14);
		add(lblUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(70, 231, 202, 20);
		add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(70, 252, 202, 20);
		add(separator);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblContraseña.setBounds(72, 278, 65, 14);
		add(lblContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(72, 296, 202, 20);
		add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(72, 316, 202, 7);
		add(separator_1);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBackground(SystemColor.textHighlight);
		btnIniciarSesion.setBounds(70, 334, 202, 45);
		add(btnIniciarSesion);
		
		JButton btnNuevoUsuario = new JButton("¿nuevo usuario?");
		btnNuevoUsuario.setForeground(SystemColor.textHighlight);
		btnNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNuevoUsuario.setFocusable(false);
		btnNuevoUsuario.setBorder(null);
		btnNuevoUsuario.setBackground(Color.WHITE);
		btnNuevoUsuario.setBounds(70, 382, 202, 23);
		add(btnNuevoUsuario);

	}
}
