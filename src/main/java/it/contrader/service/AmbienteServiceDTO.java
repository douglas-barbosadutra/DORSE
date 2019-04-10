package it.contrader.service;

import java.util.ArrayList;

import java.util.List;

import it.contrader.converter.AmbienteConverter;
import it.contrader.dao.AmbienteDAO;
import it.contrader.dto.AmbienteDTO;
import it.contrader.model.Ambiente;


public class AmbienteServiceDTO {

	private final AmbienteDAO ambienteDAO;

	public AmbienteServiceDTO() {
		this.ambienteDAO = new AmbienteDAO();
	}

	public List<AmbienteDTO> getAllAmbientebyBuilding(int buildingid) {

		List<Ambiente> list = ambienteDAO.getAllAmbientebyBuilding(buildingid);
		List<AmbienteDTO> listDTO = new ArrayList<>();

		for (Ambiente a : list) {
			listDTO.add(AmbienteConverter.toDTO(a));
		}

		return listDTO;
	}
	
	public AmbienteDTO readAmbiente(int buildingid, int ambienteid) {
		return AmbienteConverter.toDTO(ambienteDAO.readAmbiente(buildingid,ambienteid));
	}
	

	public boolean updateAmbiente(AmbienteDTO ambienteDTO) {
		return this.ambienteDAO.updateAmbiente(AmbienteConverter.toEntity(ambienteDTO));
		
}
	
	public boolean deleteAmbiente (int id) {
		return this.ambienteDAO.deleteAmbiente(id);
		
}
	
	public boolean insertAmbiente (AmbienteDTO ambienteDTO) {
		return this.ambienteDAO.insertAmbiente(AmbienteConverter.toEntity(ambienteDTO));
	
}
		
	
	
	
}
