package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.AccionJustificacion;
import com.tix.modelo.entidades.Itr;
import com.tix.modelo.entidades.Justificacion;
import com.tix.modelo.entidades.Reclamo;
import com.tix.utilities.RenderTablas;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportesAnalista extends JPanel {
	private DefaultTableModel model;

	private TableRowSorter<TableModel> sorter;

	private JComboBox<String> cmbItr;
	private JComboBox<String> cmbGeneracion;
	private JComboBox<String> cmbMes;
	private JComboBox<String> cmbTipo;
	
	private JLabel lblCantReclamos;
	private JLabel lblFiltreParaVisualizar;
	private JLabel lblReclamos;
	private JLabel lblSeEncontraron;
	
	private JButton btnLimpiarFiltros;
	private JButton btnFiltrar;
	private JButton btnImprimir;
	private JLabel lblNoSeEncontraron;

	/**
	 * Create the panel.
	 */
	public ReportesAnalista() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(910, 700));

		sorter = new TableRowSorter<TableModel>(model);

		JLabel lblJustificacionesDeInasistencias = new JLabel("LISTADO ANALÍTICO DE RECLAMOS");
		lblJustificacionesDeInasistencias.setForeground(Color.BLACK);
		lblJustificacionesDeInasistencias.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblJustificacionesDeInasistencias.setBounds(20, 12, 390, 41);
		add(lblJustificacionesDeInasistencias);

		JLabel lblItr = new JLabel("ITR");
		lblItr.setHorizontalAlignment(SwingConstants.CENTER);
		lblItr.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblItr.setBounds(20, 138, 140, 13);
		add(lblItr);

		cmbItr = new JComboBox<String>();
		cmbItr.addItem("Todos");
		for (Itr itr : DatabaseManager.getInstance().getItrsBeanRemote().obtenerTodos()) {
			cmbItr.addItem(itr.getNombre());
		}
		cmbItr.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbItr.setBounds(20, 158, 140, 20);
		add(cmbItr);

		cmbGeneracion = new JComboBox();
		cmbGeneracion.setModel(new DefaultComboBoxModel(new String[] { "Todos", "2010", "2011", "2012", "2013", "2014",
				"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
		cmbGeneracion.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbGeneracion.setBounds(179, 158, 140, 20);
		add(cmbGeneracion);

		JLabel lblGeneracion = new JLabel("Generación");
		lblGeneracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneracion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblGeneracion.setBounds(179, 138, 140, 13);
		add(lblGeneracion);

		cmbMes = new JComboBox();
		cmbMes.setModel(new DefaultComboBoxModel(new String[] { "Todos", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		cmbMes.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbMes.setBounds(20, 219, 140, 20);
		add(cmbMes);

		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblMes.setBounds(20, 199, 140, 13);
		add(lblMes);

		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] { "Todos", "VME", "APE", "Optativas", "Otros" }));
		cmbTipo.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbTipo.setBounds(179, 219, 140, 20);
		add(cmbTipo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTipo.setBounds(179, 199, 140, 13);
		add(lblTipo);

		btnImprimir = new JButton("IMPRIMIR INFORME");
		btnImprimir.setEnabled(false);
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnImprimir.setFocusable(false);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(SystemColor.textHighlight);
		btnImprimir.setBounds(443, 338, 178, 45);
		add(btnImprimir);

		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setForeground(SystemColor.textHighlight);
		lblFiltros.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblFiltros.setBounds(20, 79, 299, 27);
		add(lblFiltros);

		JSeparator spDatosPersonales = new JSeparator();
		spDatosPersonales.setBackground(SystemColor.textHighlight);
		spDatosPersonales.setBounds(20, 109, 299, 14);
		add(spDatosPersonales);

		JSeparator spVertical = new JSeparator();
		spVertical.setOrientation(SwingConstants.VERTICAL);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setBounds(355, 121, 18, 286);
		add(spVertical);

		JLabel lblResultado = new JLabel("Resultado informe");
		lblResultado.setForeground(SystemColor.textHighlight);
		lblResultado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblResultado.setBounds(383, 79, 299, 27);
		add(lblResultado);

		JSeparator spDatosAcademicos = new JSeparator();
		spDatosAcademicos.setBackground(SystemColor.textHighlight);
		spDatosAcademicos.setBounds(383, 109, 299, 14);
		add(spDatosAcademicos);

		btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos("Filtrar");
			}
		});
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnFiltrar.setFocusable(false);
		btnFiltrar.setBorder(null);
		btnFiltrar.setBackground(SystemColor.textHighlight);
		btnFiltrar.setBounds(80, 283, 178, 45);
		add(btnFiltrar);

		lblFiltreParaVisualizar = new JLabel("Filtre para visualizar los reclamos");
		lblFiltreParaVisualizar.setForeground(Color.LIGHT_GRAY);
		lblFiltreParaVisualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltreParaVisualizar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblFiltreParaVisualizar.setBounds(383, 158, 299, 33);
		add(lblFiltreParaVisualizar);

		lblCantReclamos = new JLabel("0");
		lblCantReclamos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantReclamos.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblCantReclamos.setBounds(383, 199, 299, 33);
		add(lblCantReclamos);
		lblCantReclamos.setVisible(false);

		lblReclamos = new JLabel("reclamos");
		lblReclamos.setHorizontalAlignment(SwingConstants.CENTER);
		lblReclamos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblReclamos.setBounds(383, 238, 299, 33);
		add(lblReclamos);
		lblReclamos.setVisible(false);
		
		lblSeEncontraron = new JLabel("Se encontraron");
		lblSeEncontraron.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeEncontraron.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSeEncontraron.setBounds(383, 158, 299, 33);
		add(lblSeEncontraron);
		lblSeEncontraron.setVisible(false);
		
		btnLimpiarFiltros = new JButton("LIMPIAR FILTROS");
		btnLimpiarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCampos("Limpiar");
			}
		});
		btnLimpiarFiltros.setForeground(Color.WHITE);
		btnLimpiarFiltros.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLimpiarFiltros.setFocusable(false);
		btnLimpiarFiltros.setBorder(null);
		btnLimpiarFiltros.setBackground(SystemColor.textHighlight);
		btnLimpiarFiltros.setBounds(80, 350, 178, 33);
		add(btnLimpiarFiltros);
		
		lblNoSeEncontraron = new JLabel("No se encontraron reclamos");
		lblNoSeEncontraron.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoSeEncontraron.setForeground(Color.BLACK);
		lblNoSeEncontraron.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNoSeEncontraron.setBounds(383, 158, 299, 33);
		add(lblNoSeEncontraron);
		lblNoSeEncontraron.setVisible(false);

	}

	private int contarReclamos() {

		List<Reclamo> reclamos = new ArrayList<>();

		reclamos = DatabaseManager.getInstance().getReclamosBeanRemote().obtenerTodos();

		List<Reclamo> filteredReclamos = reclamos.stream()
				.filter(r -> r.getEstudiante().getItr().getNombre().contains(getCmbItr()))
				.filter(r -> String.valueOf(r.getEstudiante().getGeneracion()).contains(getCmbGeneracion()))
				.filter(r -> String.valueOf(LocalDate.parse(r.getFecha().toString()).getMonthValue())
						.contains(getCmbMes()))
				.filter(r -> r.getTipoRecl().contains(getCmbTipo())).collect(Collectors.toList());

		return filteredReclamos.size();
	} 
	
	private void setCampos(String accion) {
		if (accion.equals("Filtrar")) {
			
			if (contarReclamos() == 0) {
				lblFiltreParaVisualizar.setVisible(false);
				lblNoSeEncontraron.setVisible(true);
				lblSeEncontraron.setVisible(false);
				lblCantReclamos.setVisible(false);
				lblReclamos.setVisible(false);
				btnImprimir.setEnabled(false);
			} else {
				lblFiltreParaVisualizar.setVisible(false);
				lblSeEncontraron.setVisible(true);
				lblCantReclamos.setText(String.valueOf(contarReclamos()));
				lblCantReclamos.setVisible(true);
				lblReclamos.setVisible(true);
				lblNoSeEncontraron.setVisible(false);
				btnImprimir.setEnabled(true);
			}
		} else if (accion.equals("Limpiar")) {
			cmbItr.setSelectedIndex(0);
			cmbGeneracion.setSelectedIndex(0);
			cmbMes.setSelectedIndex(0);
			cmbTipo.setSelectedIndex(0);
			
			lblFiltreParaVisualizar.setVisible(true);
			lblSeEncontraron.setVisible(false);
			lblCantReclamos.setVisible(false);
			lblReclamos.setVisible(false);
			
			btnImprimir.setEnabled(false);
		}
	}

	public String getCmbItr() {
		if (cmbItr.getSelectedIndex() == 0) {
			return "";
		}
		return cmbItr.getSelectedItem().toString();
	}

	public void setCmbItr(JComboBox<String> cmbItr) {
		this.cmbItr = cmbItr;
	}

	public String getCmbGeneracion() {
		if (cmbGeneracion.getSelectedItem().toString().equals("Todos")) {
			return "";
		}
		return cmbGeneracion.getSelectedItem().toString();
	}

	public void setCmbGeneracion(JComboBox<String> cmbGeneracion) {
		this.cmbGeneracion = cmbGeneracion;
	}

	public String getCmbMes() {
		if (cmbMes.getSelectedItem().toString().equals("Todos")) {
			return "";
		}
		return String.valueOf(cmbMes.getSelectedIndex());
	}

	public void setCmbMes(JComboBox<String> cmbMes) {
		this.cmbMes = cmbMes;
	}

	public String getCmbTipo() {
		if (cmbTipo.getSelectedItem().toString().equals("Todos")) {
			return "";
		}
		return cmbTipo.getSelectedItem().toString();
	}

	public void setCmbTipo(JComboBox<String> cmbTipo) {
		this.cmbTipo = cmbTipo;
	}
}
