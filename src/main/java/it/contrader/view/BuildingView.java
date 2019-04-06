package it.contrader.view;

import java.util.*;

import it.contrader.controller.BuildingController;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Building;

public class BuildingView extends AbstractView {
	private Request request;
	private String choice;
	private BuildingController buildingController;
	
	public BuildingView() {
		this.buildingController = new BuildingController();
	}

	@Override
	public void showResults(Request request) {
		
		if(request!= null) {
		
		System.out.println("\n------ Gestione building -------\n");
		System.out.println("ID\tIndirizzo\t ID Utente");
		System.out.print("------------------------------------------------------\n");
		List<Building> buildings = (List<Building>) request.get("buildings");
		System.out.println();
			for (Building b : buildings) {
			System.out.println(b);
		    System.out.println();
			}
		}
		
	}

	@Override
	public void showOptions() {
	
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
	}

	@Override
	public void submit() {
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Building", "doControl", this.request);
	}

	
}
