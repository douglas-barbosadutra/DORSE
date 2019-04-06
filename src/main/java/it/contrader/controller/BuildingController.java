package it.contrader.controller;

import java.util.List;

import it.contrader.main.MainDispatcher;
import it.contrader.model.Building;
import it.contrader.service.BuildingService;


public class BuildingController implements Controller {
	
	private static String sub_package = "building.";
	
	private BuildingService buildingService;

	public BuildingController() {
		this.buildingService = new BuildingService();
	}


	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		String indirizzo;
		int userid;
		Building building;
		
		switch (mode) {
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			building = buildingService.readBuilding(id);
			request.put("building", building);
			MainDispatcher.getInstance().callView(sub_package + "BuildingRead", request);
			break;
		case "INSERT":
			indirizzo = request.get("indirizzo").toString();
	        userid = Integer.parseInt(request.get("id").toString());
	        building = new Building(indirizzo, userid);
			boolean result=buildingService.insertBuilding(building);
			request.put("result", result);
			MainDispatcher.getInstance().callView(sub_package + "BuildingInsert", request);
			break;
		/*case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			userService.deleteUser(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
			break;
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			username = request.get("username").toString();
	        password = request.get("password").toString();
	        usertype = request.get("usertype").toString();
			userService.updateUser(id, username, password, usertype);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserUpdate", request);
			break;*/
		case "BUILDINGLIST":
			List<Building> buildings =buildingService.getAllBuilding();
			request = new Request();
			request.put("buildings", buildings);
			MainDispatcher.getInstance().callView("Building", request);
			break;
			
		case "GETCHOICE":
		
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "BuildingRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "BuildingInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "BuildingUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "BuildingDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			System.out.println("controller default \n");
			MainDispatcher.getInstance().callView("Login", request);
		}
		
	}


}
