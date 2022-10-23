package com.tix.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	
	//Paneles de login y registro
	private LoginPanel loginPanel = new LoginPanel();
	private RegistroPanel registroPanel = new RegistroPanel();
	
	//Dashboards
	private DashboardAnalista dashboardAnalista = new DashboardAnalista();
	
	//Paneles principales
	private ListadoUsuarios listadoUsuarios = new ListadoUsuarios();
	private ListadoJustificaciones listadoJustificaciones = new ListadoJustificaciones();
	
	//EmptyPanel
	private EmptyPanel emptyPanel = new EmptyPanel();

	private static Principal vista = new Principal();

	public Principal() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		getContentPane().setLayout(null);
	}

	public static Principal getVista() {
		return vista;
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public RegistroPanel getRegistroPanel() {
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
	
	
	public EmptyPanel getEmptyPanel() {
		return emptyPanel;
	}
	
	
}
