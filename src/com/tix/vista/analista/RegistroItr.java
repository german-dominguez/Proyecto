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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroItr extends JPanel {
	private JTextField txtNombre;
	private JComboBox<Departamento> cmbDepartamento;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public RegistroItr() {
		setBackground(Color.WHITE);
		setSize(new Dimension(910, 700));
		setLayout(null);

		JLabel lblDepartamento = new JLabel("Departamento *");
		lblDepartamento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDepartamento.setBounds(314, 268, 140, 21);
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
		cmbDepartamento.setBounds(314, 288, 140, 20);
		add(cmbDepartamento);

		JSeparator spDepartamento = new JSeparator();
		spDepartamento.setBackground(SystemColor.textHighlight);
		spDepartamento.setBounds(314, 308, 140, 14);
		add(spDepartamento);

		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNombre.setBounds(314, 203, 140, 21);
		add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtNombre.setBounds(314, 223, 140, 20);
		add(txtNombre);

		JSeparator spPrimerNombre = new JSeparator();
		spPrimerNombre.setBackground(SystemColor.textHighlight);
		spPrimerNombre.setBounds(314, 243, 140, 14);
		add(spPrimerNombre);

		btnModificar = new JButton("REGISTRAR");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModificar.setFocusable(false);
		btnModificar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnModificar.setBackground(SystemColor.textHighlight);
		btnModificar.setActionCommand("");
		btnModificar.setBounds(277, 347, 223, 49);
		add(btnModificar);

	}

	public void cargarDatos(Itr itr) {
		txtNombre.setText(itr.getNombre());

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

	public void registrarItr() throws Exception {
		Itr itr = new Itr();
		itr.setDepartamento(getCmbDepartamento());
		itr.setNombre(getTxtNombre());

		DatabaseManager.getInstance().getItrsBeanRemote().registro(itr);
	}

	public boolean validarCamposIngresados() {
		if (txtNombre.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Los campos marcados con * son obligatorios", "ATENCIÓN",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void vaciarCampos() {
		cmbDepartamento.setSelectedIndex(0);
		txtNombre.setText("");
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

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
}
