package com.tix.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRAR NUEVO USUARIO");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setBounds(39, 27, 299, 27);
		contentPane.add(lblTitulo);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDocumento.setBounds(49, 75, 86, 21);
		contentPane.add(lblDocumento);
		
		textField = new JTextField();
		textField.setForeground(SystemColor.textInactiveText);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(49, 99, 273, 27);
		contentPane.add(textField);
		
		JSeparator separatorDocumento = new JSeparator();
		separatorDocumento.setBackground(SystemColor.textHighlight);
		separatorDocumento.setBounds(49, 125, 273, 14);
		contentPane.add(separatorDocumento);
		
		JLabel lblPrimerNombre = new JLabel("Primer nombre");
		lblPrimerNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerNombre.setBounds(49, 157, 100, 21);
		contentPane.add(lblPrimerNombre);
		
		textField_1 = new JTextField();
		textField_1.setForeground(SystemColor.textInactiveText);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(49, 181, 273, 27);
		contentPane.add(textField_1);
		
		JSeparator separatorPrimerNombre = new JSeparator();
		separatorPrimerNombre.setBackground(SystemColor.textHighlight);
		separatorPrimerNombre.setBounds(49, 207, 273, 14);
		contentPane.add(separatorPrimerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoNombre.setBounds(49, 232, 111, 21);
		contentPane.add(lblSegundoNombre);
		
		textField_2 = new JTextField();
		textField_2.setForeground(SystemColor.textInactiveText);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(49, 256, 273, 27);
		contentPane.add(textField_2);
		
		JSeparator separatorSegundoNombre = new JSeparator();
		separatorSegundoNombre.setBackground(SystemColor.textHighlight);
		separatorSegundoNombre.setBounds(49, 282, 273, 14);
		contentPane.add(separatorSegundoNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblPrimerApellido.setBounds(49, 307, 111, 21);
		contentPane.add(lblPrimerApellido);
		
		textField_3 = new JTextField();
		textField_3.setForeground(SystemColor.textInactiveText);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(49, 331, 273, 27);
		contentPane.add(textField_3);
		
		JSeparator separatorPrimerApellido = new JSeparator();
		separatorPrimerApellido.setBackground(SystemColor.textHighlight);
		separatorPrimerApellido.setBounds(49, 357, 273, 14);
		contentPane.add(separatorPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSegundoApellido.setBounds(49, 382, 111, 21);
		contentPane.add(lblSegundoApellido);
		
		textField_4 = new JTextField();
		textField_4.setForeground(SystemColor.textInactiveText);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBounds(49, 406, 273, 27);
		contentPane.add(textField_4);
		
		JSeparator separatorSegundoApellido = new JSeparator();
		separatorSegundoApellido.setBackground(SystemColor.textHighlight);
		separatorSegundoApellido.setBounds(49, 432, 273, 14);
		contentPane.add(separatorSegundoApellido);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(397, 75, 15, 371);
		contentPane.add(separator);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEmail.setBounds(463, 75, 86, 21);
		contentPane.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setForeground(SystemColor.textInactiveText);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBounds(463, 99, 273, 27);
		contentPane.add(textField_5);
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setBackground(SystemColor.textHighlight);
		separatorEmail.setBounds(463, 125, 273, 14);
		contentPane.add(separatorEmail);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContrasenia.setBounds(463, 157, 100, 21);
		contentPane.add(lblContrasenia);
		
		JSeparator separatorContrasenia = new JSeparator();
		separatorContrasenia.setBackground(SystemColor.textHighlight);
		separatorContrasenia.setBounds(463, 207, 273, 14);
		contentPane.add(separatorContrasenia);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.textInactiveText);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		passwordField.setBorder(new EmptyBorder(0, 0, 0, 0));
		passwordField.setBounds(463, 181, 273, 27);
		contentPane.add(passwordField);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaNacimiento.setBounds(463, 236, 135, 21);
		contentPane.add(lblFechaNacimiento);
		
		JComboBox<Integer> comboBoxDia = new JComboBox<Integer>();
		comboBoxDia.setFocusable(false);
		comboBoxDia.setBorder(null);
		comboBoxDia.setBackground(Color.WHITE);
		comboBoxDia.setBounds(463, 261, 60, 22);
		contentPane.add(comboBoxDia);
		
		JComboBox<Integer> comboBoxMes = new JComboBox<Integer>();
		comboBoxMes.setFocusable(false);
		comboBoxMes.setBorder(null);
		comboBoxMes.setBackground(Color.WHITE);
		comboBoxMes.setBounds(533, 261, 60, 22);
		contentPane.add(comboBoxMes);
		
		JComboBox<Integer> comboBoxAño = new JComboBox<Integer>();
		comboBoxAño.setFocusable(false);
		comboBoxAño.setBorder(null);
		comboBoxAño.setBackground(Color.WHITE);
		comboBoxAño.setBounds(603, 261, 70, 22);
		contentPane.add(comboBoxAño);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblRol.setBounds(463, 311, 135, 21);
		contentPane.add(lblRol);
		
		JComboBox<String> comboBoxRol = new JComboBox<String>();
		comboBoxRol.setFocusable(false);
		comboBoxRol.setBorder(null);
		comboBoxRol.setBackground(Color.WHITE);
		comboBoxRol.setBounds(463, 333, 210, 22);
		contentPane.add(comboBoxRol);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnRegistrar.setFocusable(false);
		btnRegistrar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRegistrar.setBackground(SystemColor.textHighlight);
		btnRegistrar.setActionCommand("");
		btnRegistrar.setBounds(463, 390, 273, 49);
		contentPane.add(btnRegistrar);
		
		JButton btnIniciarSesion = new JButton("¿iniciar sesion?");
		btnIniciarSesion.setForeground(SystemColor.textHighlight);
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBackground(Color.WHITE);
		btnIniciarSesion.setBounds(463, 441, 273, 23);
		contentPane.add(btnIniciarSesion);
	}
}
