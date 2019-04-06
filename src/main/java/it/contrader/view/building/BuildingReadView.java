package it.contrader.view.building;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Building;
import it.contrader.view.AbstractView;

public class BuildingReadView  extends AbstractView{
	
	private int id;
	private Request request;
	private final String mode = "READ";

	@Override
	public void showResults(Request request) {
		if (request != null) {
			Building building = (Building) request.get("building");
			System.out.println(building);
			
			MainDispatcher.getInstance().callView("Building", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del building:");
		id = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Building", "doControl", request);
		
	}
}
