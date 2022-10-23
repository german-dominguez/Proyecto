package com.tix.main;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tix.modelo.entidades.Analista;
import com.tix.modelo.entidades.Estudiante;
import com.tix.modelo.entidades.Usuario;
import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.UsuariosBeanRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		AnalistasBeanRemote analistaBeanRemote = (AnalistasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AnalistasBean!com.tix.modelo.servicios.AnalistasBeanRemote");

		EstudiantesBeanRemote estudiantesBeanRemote = (EstudiantesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/EstudiantesBean!com.tix.modelo.servicios.EstudiantesBeanRemote");

		UsuariosBeanRemote usuariosBeanRemote = (UsuariosBeanRemote) InitialContext
				.doLookup("ProyectoEJB/UsuariosBean!com.tix.modelo.servicios.UsuariosBeanRemote");

		Date date = new Date();
		
		Analista analista = new Analista();
		analista.setApellido1("Fumero");
		analista.setNombre1("Gisselle");
		analista.setContrasenia("Gisselle53642362");
		analista.setDocumento("123456789");
		analista.setEstado(0);
		analista.setMail("gisselle.fumero@utec.edu.uy");
		analista.setGenero("femenino");
		analista.setFechaNacimiento(date);
		analista.setNombreUsuario("gisselle.fumero");
		analista.setMailPersonal("gisselle.fumero@gmail.com");
		analista.setTelefono("091675877");

		analistaBeanRemote.crear(analista);

		Estudiante estudiante = new Estudiante();
		estudiante.setApellido1("Dominguez");
		estudiante.setNombre1("German");
		estudiante.setContrasenia("German53642362");
		estudiante.setDocumento("53642362");
		estudiante.setEstado(0);
		estudiante.setMail("german.dominguez@estudiantes.utec.edu.uy");
		estudiante.setGenero("masculino");
		estudiante.setFechaNacimiento(date);
		estudiante.setNombreUsuario("german.dominguez");
		estudiante.setMailPersonal("sdominguez.german@gmail.com");
		estudiante.setTelefono("091675877");

		estudiantesBeanRemote.crear(estudiante);

		System.out.println();
		for (Usuario usuario : usuariosBeanRemote.obtenerTodos()) {
			System.out.println(usuario.getNombre1() + " " + usuario.getApellido1());
		}

	}

}
