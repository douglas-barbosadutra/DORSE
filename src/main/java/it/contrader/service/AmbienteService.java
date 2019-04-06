package it.contrader.service;

import java.util.List;

import it.contrader.model.Ambiente;
import it.contrader.dao.AmbienteDAO;


public class AmbienteService {

	private AmbienteDAO ambienteDAO;	
	
	
	public AmbienteService() {
		 this.ambienteDAO = new AmbienteDAO();
	}


	public List<Ambiente> showAllAmbiente(int id) {
		return this.ambienteDAO.showAllAmbiente(id);
		
	}

	
	
}


