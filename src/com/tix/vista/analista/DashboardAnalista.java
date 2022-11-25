package com.tix.vista.analista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.hamcrest.core.IsNull;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.AccionJustificacion;
import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Itr;
import com.tix.modelo.entidades.Justificacion;
import com.tix.modelo.entidades.Tutor;
import com.tix.vista.Reportes;

public class DashboardAnalista extends JPanel {

	private ListadoUsuarios listadoUsuarios = new ListadoUsuarios();
	private ListadoJustificaciones listadoJustificaciones = new ListadoJustificaciones();
	private Reportes listadoReclamos = new Reportes();
	private ListadoItrs listadoItrs = new ListadoItrs();
	private ModificarDatosPropios modificarDatosPropios = new ModificarDatosPropios();
	private ModificarAnalista modificarAnalista = new ModificarAnalista();
	private ModificarEstudiante modificarEstudiante = new ModificarEstudiante();
	private ModificarTutor modificarTutor = new ModificarTutor();
	private ModificarItr modificarItr = new ModificarItr();
	private RegistroItr registroItr = new RegistroItr();
	private AccionJustificacionAnalista accionJustificacionAnalista = new AccionJustificacionAnalista();

	private JButton btnUsuarios;
	private JButton btnReportes;
	private JButton btnJustificaciones;
	private JButton btnItr;

	private JPanel emptyPanel;

	private JLabel lblCerrarSesion;
	private JLabel lblEditarUsuario;
	private JLabel lblNombreUsuario;
	private JLabel lblLogo;
	private JLabel lblTipoUsuario;

	private JSeparator spHorizontal;
	private JSeparator spVertical;

	private Analista usuario;
	private Analista analista;
	private Estudiante estudiante;
	private Tutor tutor;
	private Itr itr;
	private AccionJustificacion accionJustificacion;

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
				setColoresBotones("Usuarios");
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnUsuarios.setFocusable(false);
		btnUsuarios.setBorder(null);
		btnUsuarios.setBackground(UIManager.getColor("activeCaption"));
		btnUsuarios.setBounds(10, 292, 127, 45);
		add(btnUsuarios);

		btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColoresBotones("Reclamos");
			}
		});
		btnReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnReportes.setFocusable(false);
		btnReportes.setBorder(null);
		btnReportes.setBackground(UIManager.getColor("activeCaption"));
		btnReportes.setBounds(10, 412, 127, 45);
		add(btnReportes);

		btnJustificaciones = new JButton("Justificaciones");
		btnJustificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColoresBotones("Justificaciones");
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
		lblLogo.setIcon(new ImageIcon("resources\\utec2.png"));
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

		btnItr = new JButton("ITRs");
		btnItr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColoresBotones("ITR");
			}
		});
		btnItr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnItr.setForeground(Color.WHITE);
		btnItr.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnItr.setFocusable(false);
		btnItr.setBorder(null);
		btnItr.setBackground(SystemColor.activeCaption);
		btnItr.setBounds(10, 352, 127, 45);
		add(btnItr);

		listadoUsuarios.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (listadoUsuarios.getTable().getSelectedColumn() == 8) {
					int fila = listadoUsuarios.getTable().getSelectedRow();
					long id = (long) listadoUsuarios.getTable().getValueAt(fila, 0);
					String tipoUsuario = (String) listadoUsuarios.getTable().getValueAt(fila, 2);

					if (tipoUsuario.equals("Analista")) {
						cambiarVista(modificarAnalista);
						analista = DatabaseManager.getInstance().getAnalistasBeanRemote().obtenerAnalistaPorId(id);
						modificarAnalista.cargarDatos(analista);
					}
					if (tipoUsuario.equals("Estudiante")) {
						cambiarVista(modificarEstudiante);
						estudiante = DatabaseManager.getInstance().getEstudiantesBeanRemote()
								.obtenerEstudiantePorId(id);
						modificarEstudiante.cargarDatos(estudiante);
					}
					if (tipoUsuario.equals("Tutor")) {
						cambiarVista(modificarTutor);
						tutor = DatabaseManager.getInstance().getTutoresBeanRemote().obtenerTutorPorId(id);
						modificarTutor.cargarDatos(tutor);
					}
				}
			}
		});

		listadoJustificaciones.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (listadoJustificaciones.getTable().getSelectedColumn() == 6) {
					int fila = listadoJustificaciones.getTable().getSelectedRow();
					long id = (long) listadoJustificaciones.getTable().getValueAt(fila, 0);

					cambiarVista(accionJustificacionAnalista);
					accionJustificacionAnalista.setUsuario(usuario);
					accionJustificacionAnalista.setJustificacion(
							DatabaseManager.getInstance().getJustificacionesBeanRemote().obtenerJustificacionPorId(id));
					accionJustificacionAnalista.cargarDatos(
							DatabaseManager.getInstance().getJustificacionesBeanRemote().obtenerJustificacionPorId(id));
				}
			}
		});

		listadoItrs.getBtnNuevoItr().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambiarVista(registroItr);
			}
		});

		modificarAnalista.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (modificarAnalista.validarCamposIngresados()) {
					try {
						modificarAnalista.editarAnalista(analista);
						JOptionPane.showMessageDialog(null, "Los datos del usuario se editaron con éxito");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error al tratar de editar los datos del usuario");
					}
				}
			}
		});

		modificarEstudiante.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (modificarEstudiante.validarCamposIngresados()) {
					try {
						modificarEstudiante.editarEstudiante(estudiante);
						JOptionPane.showMessageDialog(null, "Los datos del usuario se editaron con éxito");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error al tratar de editar los datos del usuario");
					}
				}
			}
		});

		modificarTutor.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (modificarTutor.validarCamposIngresados()) {
					try {
						modificarTutor.editarTutor(tutor);
						JOptionPane.showMessageDialog(null, "Los datos del usuario se editaron con éxito");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error al tratar de editar los datos del usuario");
					}
				}
			}
		});

		modificarItr.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (modificarItr.validarCamposIngresados()) {
					try {
						modificarItr.editarItr(itr);
						JOptionPane.showMessageDialog(null, "Los datos del ITR se editaron con éxito");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error al tratar de editar los datos del ITR");
						e1.printStackTrace();
					}
				}
			}
		});

		registroItr.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (registroItr.validarCamposIngresados()) {
					try {
						registroItr.registrarItr();
						JOptionPane.showMessageDialog(null, "El ITR se ha registrado con éxito");
						registroItr.vaciarCampos();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error al tratar de registrar el ITR");
					}
				}
			}
		});

		accionJustificacionAnalista.getBtnConfirmar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea continuar?");

					if (confirmacion == 0) {
						if (tieneAccion(accionJustificacionAnalista.getJustificacion())) {
							accionJustificacionAnalista
									.modificarAccionJustificacion(accionJustificacionAnalista.getJustificacion());

						} else {
							accionJustificacionAnalista.ingresarAccionJustificacion();
						}

						JOptionPane.showMessageDialog(null, "Los datos de la Justificación se editaron con éxito");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al tratar de editar los datos de la Justificación");
					e1.printStackTrace();
				}

			}
		});

	}

	public boolean tieneAccion(Justificacion justificacion) {
		for (AccionJustificacion accionJustificacion : DatabaseManager.getInstance()
				.getAccionJustificacionesBeanRemote().obtenerTodos()) {
			if (accionJustificacion.getJustificacion().getIdJustificacion() == justificacion.getIdJustificacion()) {
				return true;
			}

		}
		return false;
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
			btnReportes.setBackground(btnNoSeleccionado);
			btnUsuarios.setBackground(btnNoSeleccionado);
			btnItr.setBackground(btnNoSeleccionado);
			btnJustificaciones.setBackground(btnSeleccionado);
		} else if (btnNombre == "Reclamos") {
			btnReportes.setBackground(btnSeleccionado);
			btnUsuarios.setBackground(btnNoSeleccionado);
			btnItr.setBackground(btnNoSeleccionado);
			btnJustificaciones.setBackground(btnNoSeleccionado);
		} else if (btnNombre == "Usuarios") {
			btnReportes.setBackground(btnNoSeleccionado);
			btnUsuarios.setBackground(btnSeleccionado);
			btnItr.setBackground(btnNoSeleccionado);
			btnJustificaciones.setBackground(btnNoSeleccionado);
		} else if (btnNombre == "ITR") {
			btnReportes.setBackground(btnNoSeleccionado);
			btnUsuarios.setBackground(btnNoSeleccionado);
			btnJustificaciones.setBackground(btnNoSeleccionado);
			btnItr.setBackground(btnSeleccionado);
		}
	}

	public class ItrsButtonEditor extends DefaultCellEditor {

		protected JButton button;
		private String label;
		private boolean isPushed;

		public ItrsButtonEditor(JCheckBox checkBox) {
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
				int fila = listadoItrs.getTable().getSelectedRow();
				long id = (long) listadoItrs.getTable().getValueAt(fila, 0);

				cambiarVista(modificarItr);
				itr = DatabaseManager.getInstance().getItrsBeanRemote().obtenerItrPorId(id);
				modificarItr.cargarDatos(itr);
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

	public Analista getUsuario() {
		return usuario;
	}

	public void setUsuario(Analista usuario) {
		this.usuario = usuario;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public JButton getBtnUsuarios() {
		return btnUsuarios;
	}

	public void setBtnUsuarios(JButton btnUsuarios) {
		this.btnUsuarios = btnUsuarios;
	}

	public JButton getBtnReclamos() {
		return btnReportes;
	}

	public ListadoItrs getListadoItrs() {
		return listadoItrs;
	}

	public void setListadoItrs(ListadoItrs listadoItrs) {
		this.listadoItrs = listadoItrs;
	}

	public void setBtnReclamos(JButton btnReclamos) {
		this.btnReportes = btnReclamos;
	}

	public JButton getBtnItr() {
		return btnItr;
	}

	public void setBtnItr(JButton btnItr) {
		this.btnItr = btnItr;
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

	public ListadoUsuarios getListadoUsuarios() {
		return listadoUsuarios;
	}

	public void setListadoUsuarios(ListadoUsuarios listadoUsuarios) {
		this.listadoUsuarios = listadoUsuarios;
	}

	public ListadoJustificaciones getListadoJustificaciones() {
		return listadoJustificaciones;
	}

	public void setListadoJustificaciones(ListadoJustificaciones listadoJustificaciones) {
		this.listadoJustificaciones = listadoJustificaciones;
	}

	public Reportes getListadoReclamos() {
		return listadoReclamos;
	}

	public void setListadoReclamos(Reportes listadoReclamos) {
		this.listadoReclamos = listadoReclamos;
	}

	public ModificarDatosPropios getModificarDatosPropios() {
		return modificarDatosPropios;
	}

	public void setModificarDatosPropios(ModificarDatosPropios modificarDatosPropios) {
		this.modificarDatosPropios = modificarDatosPropios;
	}

	public RegistroItr getRegistroItr() {
		return registroItr;
	}

	public void setRegistroItr(RegistroItr registroItr) {
		this.registroItr = registroItr;
	}

	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	public void setLblNombreUsuario(String nombreUsuario) {
		this.lblNombreUsuario.setText(nombreUsuario);
	}
}
