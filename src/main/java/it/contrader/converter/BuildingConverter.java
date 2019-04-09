package it.contrader.converter;

import it.contrader.dto.BuildingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Building;
import it.contrader.model.User;

public class BuildingConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Building toEntity(BuildingDTO buildingDTO) {

		Building building = null;
		if (buildingDTO != null) {
			building = new Building(buildingDTO.getId(), buildingDTO.getIndirizzo(), buildingDTO.getUserId());
		}

		return building;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */
	public static BuildingDTO toDTO(Building building) {

		BuildingDTO buildingDTO = null;
		if (building != null) {
			buildingDTO = new BuildingDTO(building.getId(), building.getIndirizzo(), building.getUserId());
		}

		return buildingDTO;
	}
}
