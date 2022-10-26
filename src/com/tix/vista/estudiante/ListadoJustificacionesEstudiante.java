package com.tix.vista.estudiante;

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
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;

public class ListadoJustificacionesEstudiante extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListadoJustificacionesEstudiante() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));
		
		
		String[] columnNames = {"Estado",
                "Fecha",
                "Evento",
                "Detalles"};
		Object[][] data = {
			    {"Ingresado", "22/10/2022", 
			    "Presencial", "Licencia Médica"},
			    {"Finalizado", "22/10/2022", 
			    "Inglés", "Licencia Médica"},
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
		
		JButton btnNuevaJustificacion = new JButton("NUEVA JUSTIFICACIÓN");
		btnNuevaJustificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevaJustificacion.setForeground(Color.WHITE);
		btnNuevaJustificacion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNuevaJustificacion.setFocusable(false);
		btnNuevaJustificacion.setBorder(null);
		btnNuevaJustificacion.setBackground(SystemColor.textHighlight);
		btnNuevaJustificacion.setBounds(692, 60, 178, 45);
		add(btnNuevaJustificacion);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(20); 
		columnModel.getColumn(2).setPreferredWidth(50); 
		columnModel.getColumn(3).setPreferredWidth(100); 
		
	}
}
