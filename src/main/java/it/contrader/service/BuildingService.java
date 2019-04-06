package it.contrader.service;

import java.util.List;

import it.contrader.dao.BuildingDAO;
import it.contrader.model.Building;


public class BuildingService {

public BuildingDAO buildingDAO;

public BuildingService() {
	this.buildingDAO= new BuildingDAO();
}


	public List<Building> getAllBuilding() {
		return this.buildingDAO.getAllBuilding();
	}


	public Building readBuilding(int id) {
		return this.buildingDAO.readBuilding(id);
	}


	public boolean insertBuilding(Building building) {
		return this.buildingDAO.insertBuilding(building);
		
	}
}
