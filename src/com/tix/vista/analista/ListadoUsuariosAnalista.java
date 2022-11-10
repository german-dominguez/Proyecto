package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Tutor;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.TutoresBeanRemote;
import com.tix.utilities.RenderTablas;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ListadoUsuariosAnalista extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 * 
	 * @throws NamingException
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(20, 125, 850, 515);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Estado", "Tipo de Usuario",
				"Nombres y Apellidos", "ITR", "Email Institucional", "Tel\u00E9fono", " ", " " }));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(null);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		List<Analista> analistas = new ArrayList<>();
		List<Estudiante> estudiantes = new ArrayList<>();
		List<Tutor> tutores = new ArrayList<>();

		analistas.addAll(DatabaseManager.getInstance().getAnalistasBeanRemote().obtenerTodos());
		estudiantes.addAll(DatabaseManager.getInstance().getEstudiantesBeanRemote().obtenerTodos());
		tutores.addAll(DatabaseManager.getInstance().getTutoresBeanRemote().obtenerTodos());

		for (Analista analista : analistas) {
			model.addRow(new Object[] { analista.getEstado(), analista.getClass().getSimpleName(),
					analista.getNombre1() + " " + analista.getApellido1(), analista.getItr().getNombre(),
					analista.getMail(), analista.getTelefono(), "Editar", "Eliminar" });
		}

		for (Estudiante estudiante : estudiantes) {
			model.addRow(new Object[] { estudiante.getEstado(), estudiante.getClass().getSimpleName(),
					estudiante.getNombre1() + " " + estudiante.getApellido1(), estudiante.getItr().getNombre(),
					estudiante.getMail(), estudiante.getTelefono(), "Editar", "Eliminar" });
		}

		for (Tutor tutor : tutores) {
			model.addRow(new Object[] { tutor.getEstado(), tutor.getClass().getSimpleName(),
					tutor.getNombre1() + " " + tutor.getApellido1(), tutor.getItr().getNombre(), tutor.getMail(),
					tutor.getTelefono(), "Editar", "Eliminar" });
		}

		this.table.setDefaultRenderer(Object.class, new RenderTablas());

		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(7).setCellEditor(new EliminarButtonEditor(new JCheckBox()));

		JLabel lblTipoUsuario = new JLabel("Tipo de usuario");
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(340, 63, 111, 13);
		add(lblTipoUsuario);

		JComboBox cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] { "Todos", "Analista", "Estudiante", "Tutor" }));
		cmbTipoUsuario.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbTipoUsuario.setBounds(340, 83, 140, 20);
		add(cmbTipoUsuario);

		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGeneracion.setBounds(500, 63, 111, 13);
		add(lblGeneracion);

		JComboBox cmbGeneracion = new JComboBox();
		cmbGeneracion.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		cmbGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGeneracion.setBounds(500, 83, 140, 20);
		add(cmbGeneracion);

		JLabel lblITR = new JLabel("ITR");
		lblITR.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblITR.setBounds(180, 63, 111, 13);
		add(lblITR);

		JComboBox cmbITR = new JComboBox();
		cmbITR.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		cmbITR.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbITR.setBounds(180, 83, 140, 20);
		add(cmbITR);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(20, 63, 111, 13);
		add(lblEstado);

		JComboBox cmbEstado = new JComboBox();
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

	class ButtonEditor extends DefaultCellEditor {

		protected JButton button;
		private String label;
		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			if (isPushed) {
				JOptionPane.showMessageDialog(button, label + ": Ouch!");
			}
			isPushed = false;
			return label;
		}

		@Override
		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}
	}

	class EliminarButtonEditor extends DefaultCellEditor {

		protected JButton button;
		private String label;
		private boolean isPushed;

		public EliminarButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			if (isPushed) {
				JOptionPane.showMessageDialog(null, "Chill");
			}
			isPushed = false;
			return label;
		}

		@Override
		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}
	}

	public void setButtonEditor(com.tix.vista.analista.DashboardAnalista.ButtonEditor buttonEditor) {
		table.getColumnModel().getColumn(6).setCellEditor(buttonEditor);
	}
}
