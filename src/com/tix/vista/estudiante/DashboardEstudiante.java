package com.tix.vista.estudiante;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import com.tix.database.DatabaseManager;
import com.tix.modelo.entidades.AccionJustificacion;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Justificacion;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;

public class DashboardEstudiante extends JPanel {

	private JButton btnJustificaciones;

	private JPanel emptyPanel;

	private JLabel lblCerrarSesion;
	private JLabel lblEditarUsuario;
	private JLabel lblNombreUsuario;
	private JLabel lblLogo;
	private JLabel lblTipoUsuario;
	private Justificacion justificacion;

	private JSeparator spHorizontal;
	private JSeparator spVertical;

	private Estudiante usuario;

	private ModificarDatosPropios modificarDatosPropios = new ModificarDatosPropios();
	private ListadoJustificacionesEstudiante listadoJustificaciones = new ListadoJustificacionesEstudiante();
	private IngresoJustificacionEstudiante ingresoJustificacionEstudiante = new IngresoJustificacionEstudiante();
	private ModificarJustificacionEstudiante modificarJustificacionEstudiante = new ModificarJustificacionEstudiante();

	/**
	 * Create the panel.
	 */
	public DashboardEstudiante() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(new Dimension(1060, 700));

		btnJustificaciones = new JButton("Justificaciones");
		btnJustificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJustificaciones.setForeground(Color.WHITE);
		btnJustificaciones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnJustificaciones.setFocusable(false);
		btnJustificaciones.setBorder(null);
		btnJustificaciones.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnJustificaciones.setBounds(10, 232, 127, 45);
		add(btnJustificaciones);

		lblNombreUsuario = new JLabel("");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNombreUsuario.setBounds(0, 90, 150, 32);
		add(lblNombreUsuario);

		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("resources\\utec2.png"));
		lblLogo.setBounds(42, 10, 70, 70);
		add(lblLogo);

		lblTipoUsuario = new JLabel("Estudiante");
		lblTipoUsuario.setForeground(Color.DARK_GRAY);
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTipoUsuario.setBounds(0, 110, 150, 56);
		add(lblTipoUsuario);

		lblCerrarSesion = new JLabel("");
		lblCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrarSesion.setToolTipText("Cerrar sesión");
		Image exit = new ImageIcon("resources\\logout.png").getImage();
		ImageIcon exitResized = new ImageIcon(exit.getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		lblCerrarSesion.setIcon(exitResized);
		lblCerrarSesion.setBounds(75, 166, 30, 32);
		add(lblCerrarSesion);

		lblEditarUsuario = new JLabel("");
		lblEditarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		spVertical.setBounds(148, 0, 13, 700);
		add(spVertical);
		spVertical.setBackground(SystemColor.textHighlight);
		spVertical.setOrientation(SwingConstants.VERTICAL);

		emptyPanel = new JPanel();
		emptyPanel.setBounds(150, 0, 910, 700);
		add(emptyPanel);
		emptyPanel.setLayout(new BorderLayout(0, 0));
		
		listadoJustificaciones.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (listadoJustificaciones.getTable().getSelectedColumn() == 5) {
					int fila = listadoJustificaciones.getTable().getSelectedRow();
					long id = (long) listadoJustificaciones.getTable().getValueAt(fila, 0);
					
					cambiarVista(modificarJustificacionEstudiante);
					justificacion = DatabaseManager.getInstance().getJustificacionesBeanRemote().obtenerJustificacionPorId(id);
					modificarJustificacionEstudiante.cargarDatos(justificacion);
					
				}
				
				if (listadoJustificaciones.getTable().getSelectedColumn() == 6) {
					int fila = listadoJustificaciones.getTable().getSelectedRow();
					long id = (long) listadoJustificaciones.getTable().getValueAt(fila, 0);
					
					justificacion = DatabaseManager.getInstance().getJustificacionesBeanRemote().obtenerJustificacionPorId(id);
					
					try {
						int resp = JOptionPane.showConfirmDialog(null, "Se eliminará la justificación del sistema. ¿Está seguro?", 
								"Alerta!", JOptionPane.YES_NO_OPTION);

						if (resp == 0) {
							
							if (!tieneAccion(justificacion)) {  
								JOptionPane.showMessageDialog(null, "No se puede eliminar la justificación porque tiene una acción asociada.", 
										"Información", JOptionPane.WARNING_MESSAGE);
							} else {
								DatabaseManager.getInstance().getJustificacionesBeanRemote().borrar(id);
								
								JOptionPane.showMessageDialog(null, "Se eliminó la justificación.", 
										"Información", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		ingresoJustificacionEstudiante.getBtnIngresar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ingresoJustificacionEstudiante.ingresarJustificacion();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		modificarJustificacionEstudiante.getBtnIngresar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarJustificacionEstudiante.modificarJustificacion(justificacion);
					JOptionPane.showMessageDialog(null, "Los datos de la Justificación se editaron con éxito");
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
			if (accionJustificacion.getIdAccJustificacion() == justificacion.getIdJustificacion()) {
				return false;
			}
			
		}
		return true;
	}

	public JButton getBtnJustificaciones() {
		return btnJustificaciones;
	}

	public void setBtnJustificaciones(JButton btnJustificaciones) {
		this.btnJustificaciones = btnJustificaciones;
	}

	public void cambiarVista(JPanel panel) {
		emptyPanel.removeAll();
		emptyPanel.add(panel);
		emptyPanel.repaint();
		emptyPanel.revalidate();
	}

	public void eliminarVista() {
		emptyPanel.removeAll();
		emptyPanel.repaint();
		emptyPanel.revalidate();
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

	public ModificarDatosPropios getModificarDatosPropios() {
		return modificarDatosPropios;
	}

	public void setModificarDatosPropios(ModificarDatosPropios modificarDatosPropios) {
		this.modificarDatosPropios = modificarDatosPropios;
	}

	public Estudiante getUsuario() {
		return usuario;
	}

	public void setUsuario(Estudiante usuario) {
		this.usuario = usuario;
	}

	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	public void setLblNombreUsuario(String nombreUsuario) {
		this.lblNombreUsuario.setText(nombreUsuario);
	}

	public ListadoJustificacionesEstudiante getListadoJustificaciones() {
		return listadoJustificaciones;
	}

	public void setListadoJustificaciones(ListadoJustificacionesEstudiante listadoJustificaciones) {
		this.listadoJustificaciones = listadoJustificaciones;
	}

	public IngresoJustificacionEstudiante getIngresoJustificacionEstudiante() {
		return ingresoJustificacionEstudiante;
	}

	public void setIngresoJustificacionEstudiante(IngresoJustificacionEstudiante ingresoJustificacionEstudiante) {
		this.ingresoJustificacionEstudiante = ingresoJustificacionEstudiante;
	}

	public JPanel getEmptyPanel() {
		return emptyPanel;
	}

	public void setEmptyPanel(JPanel emptyPanel) {
		this.emptyPanel = emptyPanel;
	}

	public ModificarJustificacionEstudiante getModificarJustificacionEstudiante() {
		return modificarJustificacionEstudiante;
	}

	public void setModificarJustificacionEstudiante(ModificarJustificacionEstudiante modificarJustificacionEstudiante) {
		this.modificarJustificacionEstudiante = modificarJustificacionEstudiante;
	}
	
	

}
