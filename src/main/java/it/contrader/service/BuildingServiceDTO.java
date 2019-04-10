package it.contrader.service;

import java.util.ArrayList;

import java.util.List;

import it.contrader.converter.BuildingConverter;
import it.contrader.dao.BuildingDAO;
import it.contrader.dto.BuildingDTO;
import it.contrader.model.Building;

public class BuildingServiceDTO {

	private final BuildingDAO buildingDAO;
	
	public BuildingServiceDTO() {
		this.buildingDAO = new BuildingDAO();
	}
	
	public List<BuildingDTO> getAllBuildings() {

		List<Building> list = buildingDAO.getAllBuildings();
		List<BuildingDTO> listDTO = new ArrayList<>();

		for (Building building : list) {
			listDTO.add(BuildingConverter.toDTO(building));
		}

		return listDTO;
	}
	
	public BuildingDTO readBuilding(int id) {
		return BuildingConverter.toDTO(buildingDAO.readBuilding(id));
		
		
	}

	public boolean updateBuilding (BuildingDTO buildingDTO) {
		return this.buildingDAO.updateBuilding(BuildingConverter.toEntity(buildingDTO));
		
}
	
	public boolean deleteBuilding (int id) {
		return this.buildingDAO.deleteBuilding(id);
		
}
	
	public boolean insertBuilding (BuildingDTO buildingDTO) {
		return this.buildingDAO.insertBuilding(BuildingConverter.toEntityNoId(buildingDTO));
	
}
}