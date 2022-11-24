package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.Itr;
import com.tix.vista.analista.DashboardAnalista.ItrsButtonEditor;
import com.tix.vista.analista.ListadoUsuarios.ButtonRenderer;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ListadoItrs extends JPanel {
	private JTable table;
	private List<Itr> itrs = new ArrayList<>();
	private DefaultTableModel model;
	JComboBox<String> cmbEstado;

	private TableRowSorter<TableModel> sorter;

	private JButton btnNuevoItr;

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
		scrollPane.setBounds(20, 125, 850, 515);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Estado", "Nombre", "Departamento", "" }));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		model = (DefaultTableModel) table.getModel();

		cargarTabla();

		table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());

		sorter = new TableRowSorter<TableModel>(model);

		JLabel lblItr = new JLabel("ITRS");
		lblItr.setForeground(Color.BLACK);
		lblItr.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblItr.setBounds(20, 12, 390, 41);
		add(lblItr);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(20, 64, 111, 13);
		add(lblEstado);

		cmbEstado = new JComboBox<String>();
		cmbEstado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtros();
			}
		});
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] { "Todos", "Sin Validar", "Validado", "Eliminado" }));
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setBounds(20, 84, 140, 20);
		add(cmbEstado);

		btnNuevoItr = new JButton("NUEVO ITR");
		btnNuevoItr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoItr.setForeground(Color.WHITE);
		btnNuevoItr.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNuevoItr.setFocusable(false);
		btnNuevoItr.setBorder(null);
		btnNuevoItr.setBackground(SystemColor.textHighlight);
		btnNuevoItr.setBounds(692, 59, 178, 45);
		add(btnNuevoItr);

	}

	public void cargarTabla() {

		itrs.clear();

		itrs = DatabaseManager.getInstance().getItrsBeanRemote().obtenerTodos();

		for (int i = table.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		for (Itr itr : itrs) {
			model.addRow(new Object[] { itr.getIdItr(), itr.getEstado(), itr.getDepartamento().getNombre(),
					itr.getNombre(), "Modificar" });
		}
	}

	public void filtros() {
		List<RowFilter<Object, Object>> filtros = new ArrayList<RowFilter<Object, Object>>();

		filtros.add(RowFilter.regexFilter(getCmbEstado()));
		RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);

		sorter.setRowFilter(rf);

		table.setRowSorter(sorter);
	}

	public void limpiarFiltros() {
		table.setRowSorter(null);
		cargarTabla();
		cmbEstado.setSelectedIndex(0);
	}

	public String getCmbEstado() {
		switch (cmbEstado.getSelectedIndex()) {
			case 1:
				return "Sin Validar";
			case 2:
				return "Validado";
			case 3:
				return "Eliminado";
		}
		return "";
	}

	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			setText((value == null) ? "" : value.toString());
			return this;
		}
	}

	public JButton getBtnNuevoItr() {
		return btnNuevoItr;
	}

	public void setBtnNuevoItr(JButton btnNuevoItr) {
		this.btnNuevoItr = btnNuevoItr;
	}

	public void setCmbEstado(JComboBox<String> cmbEstado) {
		this.cmbEstado = cmbEstado;
	}

	public void setButtonEditor(ItrsButtonEditor itrsButtonEditor) {
		table.getColumnModel().getColumn(4).setCellEditor(itrsButtonEditor);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
