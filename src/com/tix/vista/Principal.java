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
import com.tix.controlador.DashboardTutorControlador;
import com.tix.controlador.LoginControlador;
import com.tix.controlador.ModificarDatosPropiosControlador;
import com.tix.controlador.RegistroControlador;
import com.tix.vista.analista.DashboardAnalista;
import com.tix.vista.analista.ListadoJustificaciones;
import com.tix.vista.analista.ListadoReclamos;
import com.tix.vista.analista.ListadoUsuarios;
import com.tix.vista.estudiante.DashboardEstudiante;
import com.tix.vista.tutor.DashboardTutor;

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
	private DashboardTutor dashboardTutor = new DashboardTutorControlador().getVista();

	// Paneles principales
	private ListadoUsuarios listadoUsuarios = new ListadoUsuarios();
	private ListadoJustificaciones listadoJustificaciones = new ListadoJustificaciones();
	private ListadoReclamos listadoReclamos = new ListadoReclamos();

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

	public ListadoUsuarios getListadoUsuarios() {
		return listadoUsuarios;
	}

	public ListadoJustificaciones getListadoJustificaciones() {
		return listadoJustificaciones;
	}

	public ListadoReclamos getListadoReclamos() {
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
