package com.tix.utilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTablas extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		String valor = (String) table.getValueAt(row, 1);

		setForeground(Color.black);

		// Para ListadoUsuariosAnalista
		if (valor == "Validado") {
			setBackground(Color.white);
		} else if (valor == "Sin validar") {
			setBackground(new Color(227, 227, 227));
		} else if (valor == "Eliminado") {
			setBackground(new Color(180, 180, 180));

			// Para ListadoJustificacionesAnalista y ListadoJustificacionesEstudiante
		} else if (valor == "Ingresado") {
			setBackground(Color.white);
		} else if (valor == "En proceso") {
			setBackground(new Color(215, 228, 242));
		} else if (valor == "Finalizado") {
			setBackground(new Color(227, 227, 227));
		}

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

}
