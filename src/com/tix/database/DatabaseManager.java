package com.tix.database;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tix.modelo.servicios.AnalistasBeanRemote;
import com.tix.modelo.servicios.AreasBeanRemote;
import com.tix.modelo.servicios.DepartamentosBeanRemote;
import com.tix.modelo.servicios.EstudiantesBeanRemote;
import com.tix.modelo.servicios.ItrsBeanRemote;
import com.tix.modelo.servicios.LocalidadesBeanRemote;
import com.tix.modelo.servicios.TutoresBeanRemote;

public class DatabaseManager {

	private static DatabaseManager instance;

	static {
		try {
			instance = new DatabaseManager();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private AnalistasBeanRemote analistasBeanRemote;
	private EstudiantesBeanRemote estudiantesBeanRemote;
	private TutoresBeanRemote tutoresBeanRemote;
	private ItrsBeanRemote itrsBeanRemote;
	private LocalidadesBeanRemote localidadesBeanRemote;
	private DepartamentosBeanRemote departamentosBeanRemote;
	private AreasBeanRemote areasBeanRemote;

	public DatabaseManager() throws NamingException {

		analistasBeanRemote = (AnalistasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AnalistasBean!com.tix.modelo.servicios.AnalistasBeanRemote");

		estudiantesBeanRemote = (EstudiantesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/EstudiantesBean!com.tix.modelo.servicios.EstudiantesBeanRemote");

		tutoresBeanRemote = (TutoresBeanRemote) InitialContext
				.doLookup("ProyectoEJB/TutoresBean!com.tix.modelo.servicios.TutoresBeanRemote");

		itrsBeanRemote = (ItrsBeanRemote) InitialContext
				.doLookup("ProyectoEJB/ItrsBean!com.tix.modelo.servicios.ItrsBeanRemote");

		localidadesBeanRemote = (LocalidadesBeanRemote) InitialContext
				.doLookup("ProyectoEJB/LocalidadesBean!com.tix.modelo.servicios.LocalidadesBeanRemote");

		departamentosBeanRemote = (DepartamentosBeanRemote) InitialContext
				.doLookup("ProyectoEJB/DepartamentosBean!com.tix.modelo.servicios.DepartamentosBeanRemote");

		areasBeanRemote = (AreasBeanRemote) InitialContext
				.doLookup("ProyectoEJB/AreasBean!com.tix.modelo.servicios.AreasBeanRemote");
	}

	public static DatabaseManager getInstance() {
		return instance;
	}

	public static void setInstance(DatabaseManager instance) {
		DatabaseManager.instance = instance;
	}

	public AnalistasBeanRemote getAnalistasBeanRemote() {
		return analistasBeanRemote;
	}

	public void setAnalistasBeanRemote(AnalistasBeanRemote analistasBeanRemote) {
		this.analistasBeanRemote = analistasBeanRemote;
	}

	public EstudiantesBeanRemote getEstudiantesBeanRemote() {
		return estudiantesBeanRemote;
	}

	public void setEstudiantesBeanRemote(EstudiantesBeanRemote estudiantesBeanRemote) {
		this.estudiantesBeanRemote = estudiantesBeanRemote;
	}

	public TutoresBeanRemote getTutoresBeanRemote() {
		return tutoresBeanRemote;
	}

	public void setTutoresBeanRemote(TutoresBeanRemote tutoresBeanRemote) {
		this.tutoresBeanRemote = tutoresBeanRemote;
	}

	public ItrsBeanRemote getItrsBeanRemote() {
		return itrsBeanRemote;
	}

	public void setItrsBeanRemote(ItrsBeanRemote itrsBeanRemote) {
		this.itrsBeanRemote = itrsBeanRemote;
	}

	public LocalidadesBeanRemote getLocalidadesBeanRemote() {
		return localidadesBeanRemote;
	}

	public void setLocalidadesBeanRemote(LocalidadesBeanRemote localidadesBeanRemote) {
		this.localidadesBeanRemote = localidadesBeanRemote;
	}

	public DepartamentosBeanRemote getDepartamentosBeanRemote() {
		return departamentosBeanRemote;
	}

	public void setDepartamentosBeanRemote(DepartamentosBeanRemote departamentosBeanRemote) {
		this.departamentosBeanRemote = departamentosBeanRemote;
	}

	public AreasBeanRemote getAreasBeanRemote() {
		return areasBeanRemote;
	}

	public void setAreasBeanRemote(AreasBeanRemote areasBeanRemote) {
		this.areasBeanRemote = areasBeanRemote;
	}

}
