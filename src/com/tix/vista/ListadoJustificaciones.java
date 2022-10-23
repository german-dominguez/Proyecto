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

public class ListadoJustificaciones extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListadoJustificaciones() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));
		
		
		String[] columnNames = {"Estado",
                "Fecha",
                "Usuario",
                "Nombres",
                "Evento",
                "Detalles"};
		Object[][] data = {
			    {"INGRESADO", "22/10/2022", 
			    "maria.martinez.p", "Martínez Perugorría, María Agustina", 
			    "Presencial", "Licencia Médica"},
			    {"FINALIZADO", "22/10/2022", 
			    "german.dominguez", "Domínguez Silva, Germán",
			    "Inglés", "Licencia Médica"},
			};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GREEN);
		scrollPane.setBounds(20, 60, 850, 580);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		
		JLabel lblJustificacionesDeInasistencias = new JLabel("JUSTIFICACIONES DE INASISTENCIAS");
		lblJustificacionesDeInasistencias.setForeground(Color.BLACK);
		lblJustificacionesDeInasistencias.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblJustificacionesDeInasistencias.setBounds(20, 12, 390, 41);
		add(lblJustificacionesDeInasistencias);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(15); 
		columnModel.getColumn(2).setPreferredWidth(150); 
		columnModel.getColumn(3).setPreferredWidth(180); 
		columnModel.getColumn(4).setPreferredWidth(10); 
		columnModel.getColumn(5).setPreferredWidth(50); 
		
	}
}
