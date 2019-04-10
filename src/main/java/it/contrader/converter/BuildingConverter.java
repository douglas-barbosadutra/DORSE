package it.contrader.converter;

import it.contrader.dto.BuildingDTO;
import it.contrader.model.Building;


public class BuildingConverter {


	public static Building toEntityNoId(BuildingDTO buildingDTO) {

		Building building = null;
		if (buildingDTO != null) {
			building = new Building(buildingDTO.getIndirizzo(), buildingDTO.getUserId());
		}

		return building;
	}

	public static Building toEntity(BuildingDTO buildingDTO) {

		Building building = null;
		if (buildingDTO != null) {
			building = new Building(buildingDTO.getId(),buildingDTO.getIndirizzo(), buildingDTO.getUserId());
		}

		return building;
	}
	
	
	public static BuildingDTO toDTO(Building building) {

		BuildingDTO buildingDTO = null;
		if (building != null) {
			buildingDTO = new BuildingDTO(building.getId(), building.getIndirizzo(), building.getUserId());
		}

		return buildingDTO;
	}
}