package com.tix.vista;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import com.tix.principal.Principal;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JButton btnNuevoUsuario;
	private JButton btnIniciarSesion;
	private static LoginPanel vista = new LoginPanel();


	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBackground(Color.WHITE);
		setSize(new Dimension(400, 500));
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
		btnIniciarSesion.setBounds(110, 350, 180, 45);
		add(btnIniciarSesion);
		
		btnNuevoUsuario = new JButton("¿Aún no tienes usuario? Regístrate");
		btnNuevoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoUsuario.setForeground(SystemColor.textHighlight);
		btnNuevoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNuevoUsuario.setFocusable(false);
		btnNuevoUsuario.setBorder(null);
		btnNuevoUsuario.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		btnNuevoUsuario.setBounds(86, 405, 233, 23);
		add(btnNuevoUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtUsuario.setBounds(110, 190, 180, 25);
		add(txtUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblUsuario.setBounds(110, 160, 180, 21);
		add(lblUsuario);
		
		JSeparator spUsuario = new JSeparator();
		spUsuario.setBackground(SystemColor.textHighlight);
		spUsuario.setBounds(110, 215, 180, 14);
		add(spUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		lblContrasenia.setBounds(110, 235, 180, 21);
		add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasenia.setForeground(Color.DARK_GRAY);
		txtContrasenia.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		txtContrasenia.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtContrasenia.setBounds(110, 265, 180, 25);
		add(txtContrasenia);
		
		JSeparator spContrasenia = new JSeparator();
		spContrasenia.setBackground(SystemColor.textHighlight);
		spContrasenia.setBounds(110, 290, 180, 14);
		add(spContrasenia);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("img\\utec2.png"));
		lblNewLabel_1.setBounds(148, 26, 104, 95);
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

	public static LoginPanel getVista() {
		return vista;
	}
	
}
