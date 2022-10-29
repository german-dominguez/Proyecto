package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.tix.utilities.RenderTablas;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ListadoUsuariosAnalista extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListadoUsuariosAnalista() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));
		
		JLabel lblListadoDeUsuarios = new JLabel("LISTADO DE USUARIOS");
		lblListadoDeUsuarios.setForeground(Color.BLACK);
		lblListadoDeUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblListadoDeUsuarios.setBounds(20, 12, 296, 41);
		add(lblListadoDeUsuarios);
		
		
		String[] columnNames = {"Estado", 
				"Tipo de Usuario",
                "Nombres y Apellidos",
                "ITR",
                "Email Institucional",
                "Teléfono"};
		Object[][] data = {
			    {"Validado", "Estudiante", "Martínez, María", 
			    "ITRCS - Durazno", "maria.martinez.p@estudiantes.utec.edu.uy", "096121113"},
			    {"Sin validar", "Analista", "Domínguez, Germán",
			     "ITRCS - Durazno", "ana.perez@estudiantes.utec.edu.uy", "099663322"},
			    {"Validado", "Estudiante", "Pérez, Ana",
				     "ITRCS - Durazno", "german.dominguez@estudiantes.utec.edu.uy", "095665522"},
			    {"Validado", "Tutor", "Suárez, Esteban",
					     "ITRCS - Durazno", "esteban.suarez@estudiantes.utec.edu.uy", "098556677"},
			    {"Eliminado", "Estudiante", "González, Adrián",
						     "ITRCS - Durazno", "adrian.gonzalez@estudiantes.utec.edu.uy", "095668877"},
			};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(20, 125, 850, 515);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		
		this.table.setDefaultRenderer(Object.class, new RenderTablas());
		
		JLabel lblTipoUsuario = new JLabel("Tipo de usuario");
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(340, 63, 111, 13);
		add(lblTipoUsuario);
		
		JComboBox cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Analista", "Estudiante", "Tutor"}));
		cmbTipoUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbTipoUsuario.setBounds(340, 83, 140, 20);
		add(cmbTipoUsuario);
		
		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGeneracion.setBounds(500, 63, 111, 13);
		add(lblGeneracion);
		
		JComboBox cmbGeneracion = new JComboBox();
		cmbGeneracion.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		cmbGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGeneracion.setBounds(500, 83, 140, 20);
		add(cmbGeneracion);
		
		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(180, 63, 111, 13);
		add(lblITR);
		
		JComboBox cmbITR = new JComboBox();
		cmbITR.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		cmbITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbITR.setBounds(180, 83, 140, 20);
		add(cmbITR);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(20, 63, 111, 13);
		add(lblEstado);
		
		JComboBox cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Sin validar", "Validados", "Eliminados"}));
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setBounds(20, 83, 140, 20);
		add(cmbEstado);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10); //Estado
		columnModel.getColumn(1).setPreferredWidth(15); //Tipo usuario
		columnModel.getColumn(2).setPreferredWidth(100); //Nombres
		columnModel.getColumn(3).setPreferredWidth(10); //ITR
		columnModel.getColumn(4).setPreferredWidth(180); //Email
		columnModel.getColumn(5).setPreferredWidth(10); //Teléfono
		
	}
}
