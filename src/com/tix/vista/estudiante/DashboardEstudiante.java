package com.tix.vista.estudiante;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;

public class DashboardEstudiante extends JPanel {	
	private static DashboardEstudiante vista = new DashboardEstudiante();
	
	private JButton btnJustificaciones;
	
	private JPanel emptyPanel;
	
	private JLabel lblCerrarSesion;
	private JLabel lblEditarUsuario;
	private JLabel lblNombreUsuario;
	private JLabel lblLogo;
	private JLabel lblTipoUsuario;
	
	private JSeparator spHorizontal;
	private JSeparator spVertical;

	/**
	 * Create the panel.
	 */
	public DashboardEstudiante() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(1060, 700));
		
		btnJustificaciones = new JButton("Justificaciones");
		btnJustificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJustificaciones.setForeground(Color.WHITE);
		btnJustificaciones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnJustificaciones.setFocusable(false);
		btnJustificaciones.setBorder(null);
		btnJustificaciones.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnJustificaciones.setBounds(10, 232, 127, 45);
		add(btnJustificaciones);
		
		lblNombreUsuario = new JLabel("Anita González");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNombreUsuario.setBounds(0, 90, 150, 32);
		add(lblNombreUsuario);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("img\\utec2.png"));
		lblLogo.setBounds(42, 10, 70, 70);
		add(lblLogo);
		
		lblTipoUsuario = new JLabel("Estudiante");
		lblTipoUsuario.setForeground(Color.DARK_GRAY);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTipoUsuario.setBounds(0, 110, 150, 56);
		add(lblTipoUsuario);
		
		lblCerrarSesion = new JLabel("");
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.setToolTipText("Cerrar sesión");
		lblCerrarSesion.setIcon(new ImageIcon("C:\\Users\\agust\\Downloads\\noun-exit-5256135 (3).png"));
		lblCerrarSesion.setBounds(75, 166, 30, 32);
		add(lblCerrarSesion);
		
		lblEditarUsuario = new JLabel("");
		lblEditarUsuario.setToolTipText("Modificar datos de usuario");
		lblEditarUsuario.setIcon(new ImageIcon("C:\\Users\\agust\\Downloads\\noun-edit-3956597 (1).png"));
		lblEditarUsuario.setBounds(40, 166, 30, 32);
		add(lblEditarUsuario);
		
		spHorizontal.setBounds(10, 211, 127, 32);
		add(spHorizontal);
		spHorizontal.setBackground(SystemColor.textHighlight);
		spVertical.setOrientation(SwingConstants.VERTICAL);
		
		spVertical.setBounds(148, 0, 13, 700);
		add(spVertical);
		spVertical.setBackground(SystemColor.textHighlight);
		
		emptyPanel = new JPanel();
		emptyPanel.setBounds(150, 0, 910, 700);
		add(emptyPanel);
		emptyPanel.setLayout(new BorderLayout(0, 0));

	}

	public JButton getBtnJustificaciones() {
		return btnJustificaciones;
	}

	public void setBtnJustificaciones(JButton btnJustificaciones) {
		this.btnJustificaciones = btnJustificaciones;
	}
	
	public static DashboardEstudiante getVista() {
		return vista;
	}
	
	public void cambiarVista(JPanel panel) {
		emptyPanel.removeAll();
		emptyPanel.add(panel);
		emptyPanel.repaint();
		emptyPanel.revalidate();
	}
}
