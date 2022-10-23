package com.tix.vista;

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

public class DashboardAnalista extends JPanel {
	private final JSeparator spPrimerApellido = new JSeparator();
	private final JSeparator spPrimerApellido_1 = new JSeparator();
	
	private static DashboardAnalista vista = new DashboardAnalista();
	
	private JButton btnUsuarios;
	private JButton btnReclamos;
	private JButton btnJustificaciones;
	
	private JPanel emptyPanel;

	/**
	 * Create the panel.
	 */
	public DashboardAnalista() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(1060, 700));
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnUsuarios.setFocusable(false);
		btnUsuarios.setBorder(null);
		btnUsuarios.setBackground(SystemColor.textHighlight);
		btnUsuarios.setBounds(10, 298, 130, 45);
		add(btnUsuarios);
		
		btnReclamos = new JButton("Reclamos");
		btnReclamos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReclamos.setForeground(Color.WHITE);
		btnReclamos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnReclamos.setFocusable(false);
		btnReclamos.setBorder(null);
		btnReclamos.setBackground(SystemColor.textHighlight);
		btnReclamos.setBounds(10, 243, 130, 45);
		add(btnReclamos);
		
		btnJustificaciones = new JButton("Justificaciones");
		btnJustificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJustificaciones.setForeground(Color.WHITE);
		btnJustificaciones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnJustificaciones.setFocusable(false);
		btnJustificaciones.setBorder(null);
		btnJustificaciones.setBackground(SystemColor.textHighlight);
		btnJustificaciones.setBounds(10, 188, 130, 45);
		add(btnJustificaciones);
		
		JLabel lblNewLabel_1 = new JLabel("Juancito Pérez");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(0, 80, 150, 32);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon("img\\utecRedimensionado.png"));
		lblNewLabel_1_1.setBounds(42, 10, 70, 70);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Analista");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 110, 150, 56);
		add(lblNewLabel);
		spPrimerApellido.setBounds(10, 156, 127, 32);
		add(spPrimerApellido);
		spPrimerApellido.setBackground(SystemColor.textHighlight);
		spPrimerApellido_1.setOrientation(SwingConstants.VERTICAL);
		spPrimerApellido_1.setBounds(148, 0, 129, 700);
		add(spPrimerApellido_1);
		spPrimerApellido_1.setBackground(SystemColor.textHighlight);
		
		emptyPanel = new JPanel();
		emptyPanel.setBounds(150, 0, 910, 700);
		add(emptyPanel);
		emptyPanel.setLayout(new BorderLayout(0, 0));

	}

	public JButton getBtnUsuarios() {
		return btnUsuarios;
	}

	public void setBtnUsuarios(JButton btnUsuarios) {
		this.btnUsuarios = btnUsuarios;
	}

	public JButton getBtnReclamos() {
		return btnReclamos;
	}

	public void setBtnReclamos(JButton btnReclamos) {
		this.btnReclamos = btnReclamos;
	}

	public JButton getBtnJustificaciones() {
		return btnJustificaciones;
	}

	public void setBtnJustificaciones(JButton btnJustificaciones) {
		this.btnJustificaciones = btnJustificaciones;
	}
	
	public static DashboardAnalista getVista() {
		return vista;
	}
	
	public void cambiarVista(JPanel panel) {
		emptyPanel.removeAll();
		emptyPanel.add(panel);
		emptyPanel.repaint();
		emptyPanel.revalidate();
	}
}
