package it.contrader.converter;

import it.contrader.dto.BuildingDTO;
import it.contrader.model.Building;

public class BuildingConverter implements Converter<Building,BuildingDTO> {

	public Building toEntity(BuildingDTO buildingDTO) {

		Building building = null;
		if (buildingDTO != null) {
			building = new Building(buildingDTO.getIndirizzo(), buildingDTO.getUserId(), buildingDTO.getOperatorId());
			
		}
		Integer id = buildingDTO.getId();
		if(id != null) {
			building.setId(id);
		}

		return building;
	}



	public BuildingDTO toDTO(Building building) {

		BuildingDTO buildingDTO = null;
		if (building != null) {
			buildingDTO = new BuildingDTO(building.getId(), building.getIndirizzo(), building.getUserId(), building.getOperatorId());
		}

		return buildingDTO;
	}
}