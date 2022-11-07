package com.tix.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.tix.controlador.DashboardAnalistaControlador;
import com.tix.controlador.DashboardEstudianteControlador;
import com.tix.controlador.LoginControlador;
import com.tix.controlador.ModificarDatosPropiosControlador;
import com.tix.controlador.RegistroControlador;
import com.tix.vista.analista.DashboardAnalista;
import com.tix.vista.analista.ListadoJustificacionesAnalista;
import com.tix.vista.analista.ListadoReclamosAnalista;
import com.tix.vista.analista.ListadoUsuariosAnalista;
import com.tix.vista.estudiante.DashboardEstudiante;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	JPanel panel;

	// Paneles de login y registro
	private LoginControlador loginControlador = new LoginControlador();
	private Login loginPanel = loginControlador.getVista();

	private Registro registroPanel;

	private ModificarDatosPropios modificarDatosPropiosPanel = new ModificarDatosPropiosControlador().getVista();

	// Dashboards
	private DashboardAnalista dashboardAnalista = new DashboardAnalistaControlador().getVista();
	private DashboardEstudiante dashboardEstudiante = new DashboardEstudianteControlador().getVista();

	// Paneles principales
	private ListadoUsuariosAnalista listadoUsuarios = new ListadoUsuariosAnalista();
	private ListadoJustificacionesAnalista listadoJustificaciones = new ListadoJustificacionesAnalista();
	private ListadoReclamosAnalista listadoReclamos = new ListadoReclamosAnalista();

	public Principal() {
		registroPanel = new RegistroControlador().getVista();
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		getContentPane().setLayout(null);
	}

	public Login getLoginPanel() {
		return loginPanel;
	}

	public Registro getRegistroPanel() {
		return registroPanel;
	}

	public DashboardAnalista getDashboardAnalista() {
		return dashboardAnalista;
	}

	public ListadoUsuariosAnalista getListadoUsuarios() {
		return listadoUsuarios;
	}

	public ListadoJustificacionesAnalista getListadoJustificaciones() {
		return listadoJustificaciones;
	}

	public ListadoReclamosAnalista getListadoReclamos() {
		return listadoReclamos;
	}

	public ModificarDatosPropios getModificarDatosPropios() {
		return modificarDatosPropiosPanel;
	}

	public LoginControlador getLoginControlador() {
		return loginControlador;
	}

	public void setLoginControlador(LoginControlador loginControlador) {
		this.loginControlador = loginControlador;
	}

	public DashboardEstudiante getDashboardEstudiante() {
		return dashboardEstudiante;
	}

	public void setDashboardEstudiante(DashboardEstudiante dashboardEstudiante) {
		this.dashboardEstudiante = dashboardEstudiante;
	}

}
