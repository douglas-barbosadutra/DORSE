package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.BuildingConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.BuildingDAO;
import it.contrader.dto.BuildingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Building;
import it.contrader.model.User;

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
	
	public BuildingDTO readUser(int id) {
		return BuildingConverter.toDTO(buildingDAO.readBuilding(id));
	}

	public boolean updateUser (BuildingDTO buildingDTO) {
		return this.buildingDAO.updateBuilding(BuildingConverter.toEntity(buildingDTO));
		
}
	
	public boolean deleteUser (BuildingDTO buildingDTO) {
		return this.buildingDAO.deleteBuilding(BuildingConverter.toEntity(buildingDTO));
		
}
	
	public boolean insertUser (BuildingDTO buildingDTO) {
		return this.buildingDAO.insertBuilding(BuildingConverter.toEntity(buildingDTO));
	
}
}
