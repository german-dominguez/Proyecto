package com.tix.vista.analista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.Departamento;
import com.tix.modelo.entidades.Itr;

public class ModificarItr extends JPanel {
	private JTextField txtNombre;
	private JComboBox<Departamento> cmbDepartamento;
	private JComboBox<String> cmbEstado;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public ModificarItr() {
		setBackground(Color.WHITE);
		setSize(new Dimension(910, 700));
		setLayout(null);

		JLabel lblDepartamento = new JLabel("Departamento *");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartamento.setBounds(114, 186, 98, 21);
		add(lblDepartamento);

		cmbDepartamento = new JComboBox<Departamento>();
		for (Departamento departamento : DatabaseManager.getInstance().getDepartamentosBeanRemote().obtenerTodos()) {
			cmbDepartamento.addItem(departamento);
		}
		cmbDepartamento.setForeground(Color.DARK_GRAY);
		cmbDepartamento.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbDepartamento.setFocusable(false);
		cmbDepartamento.setBorder(null);
		cmbDepartamento.setBackground(Color.WHITE);
		cmbDepartamento.setBounds(61, 208, 207, 20);
		add(cmbDepartamento);

		JSeparator spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(61, 228, 207, 14);
		add(spDepartamento);

		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNombre.setBounds(132, 100, 63, 21);
		add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(61, 120, 207, 20);
		add(txtNombre);

		JSeparator spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(61, 140, 207, 14);
		add(spPrimerNombre);

		JLabel lblEstado = new JLabel("Estado *");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEstado.setBounds(138, 274, 52, 21);
		add(lblEstado);

		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] { "Sin Validar", "Validado", "Eliminado" }));
		cmbEstado.setForeground(Color.DARK_GRAY);
		cmbEstado.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cmbEstado.setFocusable(false);
		cmbEstado.setBorder(null);
		cmbEstado.setBackground(Color.WHITE);
		cmbEstado.setBounds(61, 294, 207, 20);
		add(cmbEstado);

		JSeparator spEstado = new JSeparator();
		spEstado.setBackground(SystemColor.textHighlight);
		spEstado.setBounds(61, 314, 207, 14);
		add(spEstado);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModificar.setFocusable(false);
		btnModificar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModificar.setBackground(SystemColor.textHighlight);
		btnModificar.setActionCommand("");
		btnModificar.setBounds(61, 382, 207, 49);
		add(btnModificar);
		
		JLabel lblModificarItr = new JLabel("MODIFICAR ITR");
		lblModificarItr.setForeground(Color.BLACK);
		lblModificarItr.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblModificarItr.setBounds(94, 30, 156, 41);
		add(lblModificarItr);

	}

	public void cargarDatos(Itr itr) {
		txtNombre.setText(itr.getNombre());
		cmbEstado.setSelectedItem(itr.getEstado());

		List<Departamento> departamentos = new ArrayList<>();

		for (int i = 0; i < cmbDepartamento.getItemCount(); i++) {
			departamentos.add(cmbDepartamento.getItemAt(i));
		}

		for (Departamento departamento : departamentos) {
			if (departamento.getIdDepartamento() == itr.getDepartamento().getIdDepartamento()) {
				cmbDepartamento.setSelectedItem(departamento);
			}
		}
	}

	public void editarItr(Itr itr) {
		itr.setDepartamento(getCmbDepartamento());
		itr.setNombre(getTxtNombre());
		itr.setEstado(getCmbEstado());
		
		DatabaseManager.getInstance().getItrsBeanRemote().editar(itr);
	}

	public boolean validarCamposIngresados() {
		if (txtNombre.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Los campos marcados con * son obligatorios", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public Departamento getCmbDepartamento() {
		return (Departamento) cmbDepartamento.getSelectedItem();
	}

	public void setCmbDepartamento(JComboBox<Departamento> cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}

	public int getCmbEstado() {
		return cmbEstado.getSelectedIndex();
	}

	public void setCmbEstado(JComboBox<String> cmbEstado) {
		this.cmbEstado = cmbEstado;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
}
