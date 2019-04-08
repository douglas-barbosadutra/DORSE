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

	public Ambiente readAmbiente(int buildingid, int ambienteid) {

		return this.ambienteDAO.readAmbiente(buildingid, ambienteid);
	}


	public boolean insertAmbiente(Ambiente ambiente) {
		return this.ambienteDAO.insertAmbiente(ambiente);

	}


	public boolean deleteAmbiente(int ambienteid) {
		return this.ambienteDAO.deleteAmbiente(ambienteid);

	}


	public boolean updateAmbiente(Ambiente ambienteToUpdate) {
		return this.ambienteDAO.updateAmbiente(ambienteToUpdate);

	}



}


