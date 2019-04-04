package it.contrader.controller;

import java.util.List;

import it.contrader.model.Building;

public class BuildingController implements Controller {
	
	private BuildingController buildingService;

	public BuildingController(BuildingController buildingService) {
		this.buildingService = buildingService;
	}

	public List<Building> getAllBuildings() {
		return buildingService.getAllBuildings();
	}

	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		
	}
}
