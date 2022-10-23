package com.tix.vista.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.tix.vista.RegistroPanel;

public class Principal extends JFrame {

	private JPanel contentPane;
	JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(new RegistroPanel());
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(225, 11, 559, 550);
		panel.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel);

		ListadoUsuarios listadoUsuarios = new ListadoUsuarios();
		showView(listadoUsuarios);

	}

	private void showView(JPanel view) {
		panel.removeAll();
		panel.add(view);
		panel.repaint();
		panel.revalidate();
	}
}
