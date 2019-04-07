package it.contrader.controller;

import java.util.List;


import it.contrader.controller.Controller;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ambiente;
import it.contrader.service.AmbienteService;



public class AmbienteController implements Controller {


	private static String sub_package = "ambiente.";

	private  AmbienteService ambienteService;


	private int buildingid;

	private int ambienteid;

	private String descrizione;

	int id;


	public AmbienteController() {
		this.ambienteService = new AmbienteService();
	}


	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");




		switch(mode.toUpperCase()) {
		case "READ":
			buildingid = Integer.parseInt(request.get("buildingid").toString());
			ambienteid =Integer.parseInt(request.get("ambienteid").toString());
			Ambiente ambiente = ambienteService.readAmbiente(buildingid,ambienteid);
			request = new Request();
			request.put("ambiente", ambiente);
			MainDispatcher.getInstance().callView(sub_package + "AmbienteRead", request);

			break;
		case "INSERT":
			buildingid = Integer.parseInt(request.get("buildingid").toString());
			descrizione = request.get("descrizione").toString();
			Ambiente ambienteToInsert = new Ambiente(descrizione,buildingid);
			ambienteService.insertAmbiente(ambienteToInsert);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "AmbienteInsert", request);

			break;
		case "DELETE":
			ambienteid = Integer.parseInt(request.get("ambienteid").toString());
			ambienteService.deleteAmbiente(ambienteid);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package + "AmbienteDelete", request);
			break;

		case "UPDATE":
			buildingid = Integer.parseInt(request.get("buildingid").toString());
			id = Integer.parseInt(request.get("id").toString());
			descrizione = (String) request.get("descrizione");
			Ambiente ambienteToUpdate = new Ambiente(descrizione,buildingid);
			ambienteToUpdate.setId(id);
			ambienteService.updateAmbiente(ambienteToUpdate);
			request = new Request();
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView(sub_package +  "AmbienteUpdate", request);
			break;

		case "LISTAMBIENTE":
			buildingid=Integer.parseInt(request.get("buildingid").toString());
			List<Ambiente> listambiente =  ambienteService.showAllAmbiente(buildingid);
			request.put("listambiente", listambiente);
			request.put("mode", "ok");
			MainDispatcher.getInstance().callView("Ambiente", request);
			break;

		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "AmbienteDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeOperatore", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}

}