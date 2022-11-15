package com.tix.controlador;

import javax.naming.NamingException;

import com.tix.vista.analista.ModificarDatosPropios;

public class ModificarDatosPropiosControlador {
	private ModificarDatosPropios vista;

	public ModificarDatosPropiosControlador(){
		vista = new ModificarDatosPropios();
	}

	public ModificarDatosPropios getVista() {
		return vista;
	}

	public void setVista(ModificarDatosPropios vista) {
		this.vista = vista;
	}

}
