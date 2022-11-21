package com.tix.vista.estudiante;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import com.tix.modelo.entidades.Estudiante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;

public class DashboardEstudiante extends JPanel {

	private JButton btnJustificaciones;

	private JPanel emptyPanel;

	private JLabel lblCerrarSesion;
	private JLabel lblEditarUsuario;
	private JLabel lblNombreUsuario;
	private JLabel lblLogo;
	private JLabel lblTipoUsuario;

	private JSeparator spHorizontal;
	private JSeparator spVertical;

	private Estudiante usuario;

	private ModificarDatosPropios modificarDatosPropios = new ModificarDatosPropios();

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
		Image exit = new ImageIcon("resources\\logout.png").getImage();
		ImageIcon exitResized = new ImageIcon(exit.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		lblCerrarSesion.setIcon(exitResized);
		lblCerrarSesion.setBounds(75, 166, 30, 32);
		add(lblCerrarSesion);

		lblEditarUsuario = new JLabel("");
		lblEditarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEditarUsuario.setToolTipText("Modificar datos de usuario");
		Image img = new ImageIcon("resources\\edit.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		lblEditarUsuario.setIcon(img2);
		lblEditarUsuario.setBounds(40, 166, 30, 32);
		add(lblEditarUsuario);

		spHorizontal = new JSeparator();
		spHorizontal.setBounds(10, 211, 127, 32);
		add(spHorizontal);
		spHorizontal.setBackground(SystemColor.textHighlight);

		spVertical = new JSeparator();
		spVertical.setBounds(148, 0, 13, 700);
		add(spVertical);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setOrientation(SwingConstants.VERTICAL);

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

	public void cambiarVista(JPanel panel) {
		emptyPanel.removeAll();
		emptyPanel.add(panel);
		emptyPanel.repaint();
		emptyPanel.revalidate();
	}

	public JLabel getLblCerrarSesion() {
		return lblCerrarSesion;
	}

	public void setLblCerrarSesion(JLabel lblCerrarSesion) {
		this.lblCerrarSesion = lblCerrarSesion;
	}

	public JLabel getLblEditarUsuario() {
		return lblEditarUsuario;
	}

	public void setLblEditarUsuario(JLabel lblEditarUsuario) {
		this.lblEditarUsuario = lblEditarUsuario;
	}

	public ModificarDatosPropios getModificarDatosPropios() {
		return modificarDatosPropios;
	}

	public void setModificarDatosPropios(ModificarDatosPropios modificarDatosPropios) {
		this.modificarDatosPropios = modificarDatosPropios;
	}

	public Estudiante getUsuario() {
		return usuario;
	}

	public void setUsuario(Estudiante usuario) {
		this.usuario = usuario;
	}
}
