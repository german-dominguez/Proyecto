package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.Itr;
import com.tix.utilities.RenderTablas;
import com.tix.vista.analista.DashboardAnalista.ItrsButtonEditor;

public class ListadoItrs extends JPanel {
	private JTable table;
	private List<Itr> itrs = new ArrayList<>();
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ListadoItrs() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 626));

		itrs = DatabaseManager.getInstance().getItrsBeanRemote().obtenerTodos();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GREEN);
		scrollPane.setBounds(20, 64, 850, 534);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Estado", "Nombre", "" }));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		model = (DefaultTableModel) table.getModel();

		cargarTabla();

		JLabel lblItr = new JLabel("ITRS");
		lblItr.setForeground(Color.BLACK);
		lblItr.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblItr.setBounds(20, 12, 390, 41);
		add(lblItr);

	}

	public void cargarTabla() {
		for (int i = table.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		for (Itr itr : itrs) {
			model.addRow(new Object[] { itr.getIdItr(), itr.getEstado(), itr.getNombre(), "Modificar" });
		}
	}

	public void setButtonEditor(ItrsButtonEditor itrsButtonEditor) {
		System.out.println(1);
		table.getColumnModel().getColumn(3).setCellEditor(itrsButtonEditor);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
