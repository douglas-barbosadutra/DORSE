package it.contrader.service;

import it.contrader.converter.BuildingConverter;
import it.contrader.dao.BuildingDAO;
import it.contrader.dto.BuildingDTO;
import it.contrader.model.Building;

public class BuildingServiceDTO extends AbstractServiceDTO<Building,BuildingDTO> {
	
	public BuildingServiceDTO() {
		dao = new BuildingDAO();
		converter = new BuildingConverter();
	}
}
