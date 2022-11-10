package com.tix.vista.analista;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.tix.modelo.entidades.Usuario;
import com.tix.vista.ModificarDatosPropios;
import com.tix.vista.ModificarUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;

public class DashboardAnalista extends JPanel {

	private ListadoUsuariosAnalista listadoUsuarios = new ListadoUsuariosAnalista();
	private ListadoJustificacionesAnalista listadoJustificaciones = new ListadoJustificacionesAnalista();
	private ListadoReclamosAnalista listadoReclamos = new ListadoReclamosAnalista();
	private ModificarDatosPropios modificarDatosPropios = new ModificarDatosPropios();
	private ModificarUsuarios modificarUsuarios = new ModificarUsuarios();

	private JButton btnUsuarios;
	private JButton btnReclamos;
	private JButton btnJustificaciones;

	private JPanel emptyPanel;

	private JLabel lblCerrarSesion;
	private JLabel lblEditarUsuario;
	private JLabel lblNombreUsuario;
	private JLabel lblLogo;
	private JLabel lblTipoUsuario;

	private JSeparator spHorizontal;
	private JSeparator spVertical;

	private Usuario usuario;

	/**
	 * Create the panel.
	 */
	public DashboardAnalista() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(1060, 700));

		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnNombre = e.getActionCommand(); // Obtengo el nombre del botón
				setColoresBotones(btnNombre);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnUsuarios.setFocusable(false);
		btnUsuarios.setBorder(null);
		btnUsuarios.setBackground(UIManager.getColor("activeCaption"));
		btnUsuarios.setBounds(10, 342, 127, 45);
		add(btnUsuarios);

		btnReclamos = new JButton("Reclamos");
		btnReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnNombre = e.getActionCommand(); // Obtengo el nombre del botón
				setColoresBotones(btnNombre);
			}
		});
		btnReclamos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReclamos.setForeground(Color.WHITE);
		btnReclamos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnReclamos.setFocusable(false);
		btnReclamos.setBorder(null);
		btnReclamos.setBackground(UIManager.getColor("activeCaption"));
		btnReclamos.setBounds(10, 287, 127, 45);
		add(btnReclamos);

		btnJustificaciones = new JButton("Justificaciones");
		btnJustificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnNombre = e.getActionCommand(); // Obtengo el nombre del botón
				setColoresBotones(btnNombre);
			}
		});
		btnJustificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJustificaciones.setForeground(Color.WHITE);
		btnJustificaciones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnJustificaciones.setFocusable(false);
		btnJustificaciones.setBorder(null);
		btnJustificaciones.setBackground(UIManager.getColor("activeCaption"));
		btnJustificaciones.setBounds(10, 232, 127, 45);
		add(btnJustificaciones);

		lblNombreUsuario = new JLabel("Juancito Pérez");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNombreUsuario.setBounds(0, 90, 150, 32);
		add(lblNombreUsuario);

		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("img\\utec2.png"));
		lblLogo.setBounds(42, 10, 70, 70);
		add(lblLogo);

		lblTipoUsuario = new JLabel("Analista");
		lblTipoUsuario.setForeground(Color.DARK_GRAY);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTipoUsuario.setBounds(0, 110, 150, 56);
		add(lblTipoUsuario);

		lblCerrarSesion = new JLabel("");
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.setToolTipText("Cerrar sesión");

		Image exit = new ImageIcon("resources\\logout.png").getImage();
		ImageIcon exitResized = new ImageIcon(exit.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		lblCerrarSesion.setIcon(exitResized);
		lblCerrarSesion.setBounds(75, 166, 30, 32);
		add(lblCerrarSesion);

		lblEditarUsuario = new JLabel("");
		lblEditarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEditarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarUsuario.setToolTipText("Modificar datos de usuario");
		Image img = new ImageIcon("resources\\edit.png").getImage();
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		lblEditarUsuario.setIcon(img2);
		lblEditarUsuario.setBounds(40, 166, 30, 32);
		add(lblEditarUsuario);

		spHorizontal = new JSeparator();
		spHorizontal.setBounds(10, 211, 127, 32);
		add(spHorizontal);
		spHorizontal.setBackground(SystemColor.textHighlight);

		spVertical = new JSeparator();
		spVertical.setOrientation(SwingConstants.VERTICAL);
		spVertical.setBounds(148, 0, 13, 700);
		add(spVertical);
		spVertical.setBackground(SystemColor.textHighlight);

		emptyPanel = new JPanel();
		emptyPanel.setBounds(150, 0, 910, 700);
		add(emptyPanel);
		emptyPanel.setLayout(new BorderLayout(0, 0));

	}

	public void cambiarVista(JPanel panel) {
		emptyPanel.removeAll();
		emptyPanel.add(panel);
		emptyPanel.repaint();
		emptyPanel.revalidate();
	}

	// Seteo los colores de los botones del dashboard
	public void setColoresBotones(String btnNombre) {
		Color btnNoSeleccionado = new Color(153, 180, 209);
		Color btnSeleccionado = new Color(0, 120, 215);

		if (btnNombre == "Justificaciones") {
			btnReclamos.setBackground(btnNoSeleccionado);
			btnUsuarios.setBackground(btnNoSeleccionado);
			btnJustificaciones.setBackground(btnSeleccionado);
		} else if (btnNombre == "Reclamos") {
			btnReclamos.setBackground(btnSeleccionado);
			btnUsuarios.setBackground(btnNoSeleccionado);
			btnJustificaciones.setBackground(btnNoSeleccionado);
		} else if (btnNombre == "Usuarios") {
			btnReclamos.setBackground(btnNoSeleccionado);
			btnUsuarios.setBackground(btnSeleccionado);
			btnJustificaciones.setBackground(btnNoSeleccionado);
		}
	}

	public class ButtonEditor extends DefaultCellEditor {

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
				cambiarVista(modificarUsuarios);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		lblNombreUsuario.setText(usuario.getNombre1());
		this.usuario = usuario;
	}

	public JButton getBtnUsuarios() {
		return btnUsuarios;
	}

	public void setBtnUsuarios(JButton btnUsuarios) {
		this.btnUsuarios = btnUsuarios;
	}

	public JButton getBtnReclamos() {
		return btnReclamos;
	}

	public void setBtnReclamos(JButton btnReclamos) {
		this.btnReclamos = btnReclamos;
	}

	public JButton getBtnJustificaciones() {
		return btnJustificaciones;
	}

	public void setBtnJustificaciones(JButton btnJustificaciones) {
		this.btnJustificaciones = btnJustificaciones;
	}

	public JLabel getLblCerrarSesion() {
		return lblCerrarSesion;
	}

	public void setLblCerrarSesion(JLabel lblCerrarSesion) {
		this.lblCerrarSesion = lblCerrarSesion;
	}

	public JLabel getLblEditarUsuario() {
		return lblEditarUsuario;
	}

	public void setLblEditarUsuario(JLabel lblEditarUsuario) {
		this.lblEditarUsuario = lblEditarUsuario;
	}

	public ListadoUsuariosAnalista getListadoUsuarios() {
		return listadoUsuarios;
	}

	public void setListadoUsuarios(ListadoUsuariosAnalista listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}

	public ListadoJustificacionesAnalista getListadoJustificaciones() {
		return listadoJustificaciones;
	}

	public void setListadoJustificaciones(ListadoJustificacionesAnalista listadoJustificaciones) {
		this.listadoJustificaciones = listadoJustificaciones;
	}

	public ListadoReclamosAnalista getListadoReclamos() {
		return listadoReclamos;
	}

	public void setListadoReclamos(ListadoReclamosAnalista listadoReclamos) {
		this.listadoReclamos = listadoReclamos;
	}

	public ModificarDatosPropios getModificarDatosPropios() {
		return modificarDatosPropios;
	}

	public void setModificarDatosPropios(ModificarDatosPropios modificarDatosPropios) {
		this.modificarDatosPropios = modificarDatosPropios;
	}
}
