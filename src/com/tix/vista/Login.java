package com.tix.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JButton btnNuevoUsuario;
	private JButton btnIniciarSesion;
	private static Login vista = new Login();


	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setSize(new Dimension(350, 500));
		setLayout(null);
		
		btnIniciarSesion = new JButton("INICIAR SESIÓN");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnIniciarSesion.setBounds(100, 348, 150, 45);
		add(btnIniciarSesion);
		
		btnNuevoUsuario = new JButton("¿Aún no tienes usuario? Regístrate");
		btnNuevoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoUsuario.setForeground(SystemColor.textHighlight);
		btnNuevoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNuevoUsuario.setFocusable(false);
		btnNuevoUsuario.setBorder(null);
		btnNuevoUsuario.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		btnNuevoUsuario.setBounds(81, 403, 188, 23);
		add(btnNuevoUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtUsuario.setBounds(100, 167, 150, 25);
		add(txtUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblUsuario.setBounds(100, 144, 150, 21);
		add(lblUsuario);
		
		JSeparator spUsuario = new JSeparator();
		spUsuario.setBackground(SystemColor.textHighlight);
		spUsuario.setBounds(100, 192, 150, 14);
		add(spUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContrasenia.setBounds(100, 233, 150, 21);
		add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasenia.setForeground(Color.DARK_GRAY);
		txtContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtContrasenia.setBounds(100, 255, 150, 25);
		add(txtContrasenia);
		
		JSeparator spContrasenia = new JSeparator();
		spContrasenia.setBackground(SystemColor.textHighlight);
		spContrasenia.setBounds(100, 280, 150, 14);
		add(spContrasenia);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("resources\\utec2.png"));
		lblNewLabel_1.setBounds(142, 28, 75, 75);
		add(lblNewLabel_1);

	}
	
	public JButton getBtnNuevoUsuario() {
		return btnNuevoUsuario;
	}

	public void setBtnNuevoUsuario(JButton btnNuevoUsuario) {
		this.btnNuevoUsuario = btnNuevoUsuario;
	}
	
	
	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public static Login getVista() {
		return vista;
	}
	
}
