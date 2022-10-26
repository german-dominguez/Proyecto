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
import javax.swing.DefaultComboBoxModel;

public class ListadoJustificacionesAnalista extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListadoJustificacionesAnalista() {
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
			    {"Ingresado", "22/10/2022", 
			    "maria.martinez.p", "Martínez Perugorría, María Agustina", 
			    "Presencial", "Licencia Médica"},
			    {"Finalizado", "22/10/2022", 
			    "german.dominguez", "Domínguez Silva, Germán",
			    "Inglés", "Licencia Médica"},
			    {"En proceso", "26/10/2022", 
				    "ana.suarez", "Suárez, Ana",
				    "Chino", "Viaje al Exterior"},
			};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GREEN);
		scrollPane.setBounds(20, 125, 850, 515);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		
		this.table.setDefaultRenderer(Object.class, new RenderTablas());
		
		JLabel lblJustificacionesDeInasistencias = new JLabel("JUSTIFICACIONES DE INASISTENCIAS");
		lblJustificacionesDeInasistencias.setForeground(Color.BLACK);
		lblJustificacionesDeInasistencias.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblJustificacionesDeInasistencias.setBounds(20, 12, 390, 41);
		add(lblJustificacionesDeInasistencias);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(20, 63, 111, 13);
		add(lblEstado);
		
		JComboBox cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Ingresado", "En proceso", "Finalizado"}));
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setBounds(20, 83, 140, 20);
		add(cmbEstado);
		
		JComboBox cmbUsuario = new JComboBox();
		cmbUsuario.setModel(new DefaultComboBoxModel(new String[] {"Todos", "maria.martinez.p", "german.dominguez", "ana.suarez"}));
		cmbUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbUsuario.setBounds(180, 83, 140, 20);
		add(cmbUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblUsuario.setBounds(180, 63, 111, 13);
		add(lblUsuario);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(15); 
		columnModel.getColumn(2).setPreferredWidth(150); 
		columnModel.getColumn(3).setPreferredWidth(180); 
		columnModel.getColumn(4).setPreferredWidth(10); 
		columnModel.getColumn(5).setPreferredWidth(50); 
		
	}
}
