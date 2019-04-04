package it.contrader.service;

import java.util.List;

import it.contrader.model.Building;
import it.contrader.model.User;

public class BuildingService {

	public List<Building> getAllBuildings() {
		return this.buildingDAO.getAllBuildings();
	}
}
