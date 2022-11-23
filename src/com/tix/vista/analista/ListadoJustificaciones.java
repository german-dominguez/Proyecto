package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Itr;
import com.tix.modelo.entidades.Justificacion;
import com.tix.modelo.entidades.Tutor;

public class ListadoJustificaciones extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	
	private List<Justificacion> justificaciones = new ArrayList<>();

	private TableRowSorter<TableModel> sorter;
	
	
	JComboBox<String> cmbEstado;
	JComboBox<String> cmbUsuario;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
	 */
	public ListadoJustificaciones() {

		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));

		JLabel lblListadoDeUsuarios = new JLabel("LISTADO DE JUSTIFICACIONES");
		lblListadoDeUsuarios.setForeground(Color.BLACK);
		lblListadoDeUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblListadoDeUsuarios.setBounds(20, 12, 296, 41);
		add(lblListadoDeUsuarios);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(20, 125, 850, 515);
		add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, },
						new String[] { "ID", "Estado", "Usuario", "Nombres y Apellidos", "Fecha Ingreso", "Detalle", " "}) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false,
							false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		model = (DefaultTableModel) table.getModel();

		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());

		sorter = new TableRowSorter<TableModel>(model);

		cargarTabla();

		JLabel lblITR = new JLabel("Usuario");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(180, 63, 111, 13);
		add(lblITR);

		cmbUsuario = new JComboBox<String>();
		cmbUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtros();
			}
		});
		cmbUsuario.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		for (Estudiante estudiante : DatabaseManager.getInstance().getEstudiantesBeanRemote().obtenerTodos()) {
			cmbUsuario.addItem(estudiante.getNombreUsuario());
		}

		cmbUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbUsuario.setBounds(180, 83, 140, 20);
		add(cmbUsuario);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(20, 63, 111, 13);
		add(lblEstado);

		cmbEstado = new JComboBox<String>();
		cmbEstado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtros();
			}
		});
		cmbEstado
				.setModel(new DefaultComboBoxModel(new String[] { "Ingresado", "En proceso", "Finalizado" }));
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setBounds(20, 83, 140, 20);
		add(cmbEstado);

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

	public void cargarTabla() {

		actualizarListas();

		for (int i = table.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		for (Justificacion justificacion : justificaciones) {

			model.addRow(new Object[] { justificacion.getIdJustificacion(), justificacion.getEstadoRecConJus(), 
					justificacion.getEstudiante().getNombreUsuario(), justificacion.getEstudiante().getNombre1() + " " + 
							justificacion.getEstudiante().getApellido1(),
					justificacion.getFechahora(), justificacion.getDetalle(), "Ver ficha" });
		}

	}

	public void actualizarListas() {

		justificaciones.clear();

		justificaciones.addAll(DatabaseManager.getInstance().getJustificacionesBeanRemote().obtenerTodos());
	}

	public void filtros() {
		List<RowFilter<Object, Object>> filtros = new ArrayList<RowFilter<Object, Object>>();

		filtros.add(RowFilter.regexFilter(getCmbEstado()));
		filtros.add(RowFilter.regexFilter(cmbUsuario()));
		RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);

		sorter.setRowFilter(rf);

		table.setRowSorter(sorter);
	}

	public void limpiarFiltros() {
		table.setRowSorter(null);
		cargarTabla();
		cmbEstado.setSelectedIndex(0);
		cmbUsuario.setSelectedIndex(0);
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

	public void setCmbEstado(JComboBox<String> cmbEstado) {
		this.cmbEstado = cmbEstado;
	}

	public String cmbUsuario() {
		if (cmbUsuario.getSelectedIndex() == 0) {
			return "";
		}
		return cmbUsuario.getSelectedItem().toString();
	}

	public void cmbUsuario(JComboBox<String> cmbITR) {
		this.cmbUsuario = cmbITR;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
