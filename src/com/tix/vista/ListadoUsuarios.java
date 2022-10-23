package com.tix.vista;

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
import javax.swing.border.LineBorder;

public class ListadoUsuarios extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListadoUsuarios() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));
		
		JLabel lblListadoDeUsuarios = new JLabel("LISTADO DE USUARIOS");
		lblListadoDeUsuarios.setForeground(Color.BLACK);
		lblListadoDeUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblListadoDeUsuarios.setBounds(20, 12, 296, 41);
		add(lblListadoDeUsuarios);
		
		
		String[] columnNames = {"Tipo de Usuario",
                "Nombres y Apellidos",
                "ITR",
                "Email Institucional",
                "Teléfono"};
		Object[][] data = {
			    {"Analista", "Martínez Perugorría, María Agustina", 
			    "ITRCS - Durazno", "maria.martinez.p@estudiantes.utec.edu.uy", "096121113"},
			    {"Analista", "Domínguez Silva, Germán",
			     "ITRCS - Durazno", "german.dominguez@estudiantes.utec.edu.uy", "099663322"},
			};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(21, 59, 849, 582);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10); //Tipo usuario
		columnModel.getColumn(1).setPreferredWidth(180); //Nombres
		columnModel.getColumn(2).setPreferredWidth(10); //ITR
		columnModel.getColumn(3).setPreferredWidth(180); //Email
		columnModel.getColumn(4).setPreferredWidth(10); //Teléfono
		
	}
}
