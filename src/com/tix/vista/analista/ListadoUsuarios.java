package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Component;
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
import com.tix.modelo.entidades.Tutor;

public class ListadoUsuarios extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private List<Analista> analistas = new ArrayList<>();
	private List<Estudiante> estudiantes = new ArrayList<>();
	private List<Tutor> tutores = new ArrayList<>();

	private TableRowSorter<TableModel> sorter;

	JComboBox<String> cmbEstado;
	JComboBox<String> cmbTipoUsuario;
	JComboBox<String> cmbITR;
	JComboBox<String> cmbGeneracion;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(20, 125, 850, 515);
		add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, },
						new String[] { "ID", "Estado", "Tipo de Usuario", "Nombres y Apellidos", "ITR",
								"Email Institucional", "Tel\u00E9fono", "Generaci\u00F3n", " " }) {
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
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		model = (DefaultTableModel) table.getModel();

		table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());

		sorter = new TableRowSorter<TableModel>(model);

		cargarTabla();

		JLabel lblTipoUsuario = new JLabel("Tipo de usuario");
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(340, 63, 111, 13);
		add(lblTipoUsuario);

		cmbTipoUsuario = new JComboBox<String>();
		cmbTipoUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtros();
			}
		});
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] { "Todos", "Analista", "Estudiante", "Tutor" }));
		cmbTipoUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbTipoUsuario.setBounds(340, 83, 140, 20);
		add(cmbTipoUsuario);

		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGeneracion.setBounds(500, 63, 111, 13);
		add(lblGeneracion);

		cmbGeneracion = new JComboBox<String>();
		cmbGeneracion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtros();
			}
		});
		cmbGeneracion.setModel(new DefaultComboBoxModel(new String[] { "Todos", "2010", "2011", "2012", "2013", "2014",
				"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
		cmbGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGeneracion.setBounds(500, 83, 140, 20);
		add(cmbGeneracion);

		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(180, 63, 111, 13);
		add(lblITR);

		cmbITR = new JComboBox<String>();
		cmbITR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtros();
			}
		});
		cmbITR.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		for (Itr itr : DatabaseManager.getInstance().getItrsBeanRemote().obtenerTodos()) {
			cmbITR.addItem(itr.getNombre());
		}

		cmbITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbITR.setBounds(180, 83, 140, 20);
		add(cmbITR);

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
				.setModel(new DefaultComboBoxModel(new String[] { "Todos", "Sin validar", "Validados", "Eliminados" }));
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setBounds(20, 83, 140, 20);
		add(cmbEstado);

	}

	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
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

		for (Analista analista : analistas) {
			model.addRow(new Object[] { analista.getIdUsuario(), analista.getEstado(),
					analista.getClass().getSimpleName(), analista.getNombre1() + " " + analista.getApellido1(),
					analista.getItr().getNombre(), analista.getMail(), analista.getTelefono(), null, "Modificar" });
		}

		for (Estudiante estudiante : estudiantes) {
			model.addRow(new Object[] { estudiante.getIdUsuario(), estudiante.getEstado(),
					estudiante.getClass().getSimpleName(), estudiante.getNombre1() + " " + estudiante.getApellido1(),
					estudiante.getItr().getNombre(), estudiante.getMail(), estudiante.getTelefono(),
					estudiante.getGeneracion(), "Modificar" });
		}

		for (Tutor tutor : tutores) {
			model.addRow(new Object[] { tutor.getIdUsuario(), tutor.getEstado(), tutor.getClass().getSimpleName(),
					tutor.getNombre1() + " " + tutor.getApellido1(), tutor.getItr().getNombre(), tutor.getMail(),
					tutor.getTelefono(), null, "Modificar" });
		}
	}

	public void actualizarListas() {

		analistas.clear();
		estudiantes.clear();
		tutores.clear();

		analistas.addAll(DatabaseManager.getInstance().getAnalistasBeanRemote().obtenerTodos());
		estudiantes.addAll(DatabaseManager.getInstance().getEstudiantesBeanRemote().obtenerTodos());
		tutores.addAll(DatabaseManager.getInstance().getTutoresBeanRemote().obtenerTodos());
	}

	public void filtros() {
		List<RowFilter<Object, Object>> filtros = new ArrayList<RowFilter<Object, Object>>();

		filtros.add(RowFilter.regexFilter(getCmbEstado()));
		filtros.add(RowFilter.regexFilter(getCmbTipoUsuario()));
		filtros.add(RowFilter.regexFilter(getCmbITR()));
		filtros.add(RowFilter.regexFilter(getCmbGeneracion()));
		RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);

		sorter.setRowFilter(rf);

		table.setRowSorter(sorter);
	}

	public void limpiarFiltros() {
		table.setRowSorter(null);
		cargarTabla();
		cmbEstado.setSelectedIndex(0);
		cmbGeneracion.setSelectedIndex(0);
		cmbITR.setSelectedIndex(0);
		cmbTipoUsuario.setSelectedIndex(0);
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

	public String getCmbTipoUsuario() {
		switch (cmbTipoUsuario.getSelectedIndex()) {
			case 1:
				return "Analista";
			case 2:
				return "Estudiante";
			case 3:
				return "Tutor";
		}
		return "";
	}

	public String getCmbITR() {
		if (cmbITR.getSelectedIndex() == 0) {
			return "";
		}
		return cmbITR.getSelectedItem().toString();
	}

	public void setCmbITR(JComboBox<String> cmbITR) {
		this.cmbITR = cmbITR;
	}

	public String getCmbGeneracion() {
		if (cmbGeneracion.getSelectedIndex() == 0) {
			return "";
		}
		return (String) cmbGeneracion.getSelectedItem();
	}

	public void setCmbGeneracion(JComboBox<String> cmbGeneracion) {
		this.cmbGeneracion = cmbGeneracion;
	}

	public void setCmbTipoUsuario(JComboBox<String> cmbTipoUsuario) {
		this.cmbTipoUsuario = cmbTipoUsuario;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
