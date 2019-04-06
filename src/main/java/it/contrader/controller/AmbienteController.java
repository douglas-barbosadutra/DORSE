package it.contrader.controller;

import java.util.List;

import it.contrader.controller.Controller;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ambiente;
import it.contrader.model.Building;
import it.contrader.service.AmbienteService;
import it.contrader.service.BuildingService;

public class AmbienteController implements Controller {
	
	
	private static String sub_package = "ambiente.";
	
	private  AmbienteService ambienteService;
	private Request request;
	
	
	
	
	public AmbienteController() {
		this.ambienteService = new AmbienteService();
	}
	
	
	@Override
	public void doControl(Request request) {
		int building;
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		building = Integer.parseInt(request.get("buildingid").toString());
	
		
		switch(mode.toUpperCase()) {
	/*case "READ":
		buildingid = Integer.parseInt(request.get("id").toString());
		Building building = buildingService.readBuilding(buildingid);
		request.put("building", building);
		request = new Request();
		request.put("building", building);
		MainDispatcher.getInstance().callView(sub_package + "BuildingRead", request);
	
		break;
	case "INSERT":
		String indirizzo = request.get("indirizzo").toString();
		int id = (int) request.get("id");
        buildingService.insertBuilding(indirizzo, id);
        request = new Request();
        request = null;
        MainDispatcher.getInstance().callView("Building", request);
     
		break;
	case "DELETE":
		id = Integer.parseInt(request.get("id").toString());
		buildingService.deleteUser(id);
		request = new Request();
        request = null;
        MainDispatcher.getInstance().callView("Building", request);
		break;
	case "UPDATE":
		userid = Integer.parseInt(request.get("useridtoupdate").toString());
		id = Integer.parseInt(request.get("idtoupdate").toString());
		indirizzo = (String) request.get("indirizzotoupdate");
		
		Building buildingToUpdate = new Building(indirizzo,userid);
		buildingToUpdate.setBuildingId(id);
        
        buildingService.updateBuilding(buildingToUpdate);
        
        request = null;
        MainDispatcher.getInstance().callView("Building", request);
		break;
		*/
	case "LISTAMBIENTE":
		int buildingid=Integer.parseInt(request.get("buildingid").toString());
		List<Ambiente> listambiente =  ambienteService.showAllAmbiente(buildingid);
		request.put("listambiente", listambiente);
		request.put("mode", "show");
		MainDispatcher.getInstance().callView("Ambiente", request);
		break;
		
	/*case "GETCHOICE":
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
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	default:
		MainDispatcher.getInstance().callView("Login", null);*/
		}
	}

}