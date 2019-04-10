package it.contrader.service;

import java.util.ArrayList;

import java.util.List;

import it.contrader.converter.AmbienteConverter;
import it.contrader.converter.BuildingConverter;
import it.contrader.dao.AmbienteDAO;
import it.contrader.dao.BuildingDAO;
import it.contrader.dto.AmbienteDTO;
import it.contrader.dto.BuildingDTO;
import it.contrader.model.Ambiente;
import it.contrader.model.Building;


public class AmbienteServiceDTO extends AbstractServiceDTO<Ambiente,AmbienteDTO> {

	public AmbienteServiceDTO() {
		dao = new AmbienteDAO();
		converter = new AmbienteConverter();
	}

	/*public List<AmbienteDTO> getAllAmbientebyBuilding(int buildingid) {

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
	*/
}
