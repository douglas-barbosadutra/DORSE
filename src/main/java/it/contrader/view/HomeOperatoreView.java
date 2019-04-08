package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

import it.contrader.view.AbstractView;


public class HomeOperatoreView extends AbstractView {

	private String choice;
	private int buildingid;


	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n Benvenuto in DORSE "+request.get("username").toString() + "\n");
		}
	}

	@Override
	public void showOptions() {
		System.out.println("\n------------MENU------------\n");
		System.out.println("Seleziona cosa vuoi gestire:");
		System.out.println("    [A]mbienti    [E]sci");
		choice = this.getInput();

		switch (choice) {
		case "a":
			System.out.println("Seleziona il building:");
			this.buildingid = Integer.parseInt(getInput());
			break;
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default : MainDispatcher.getInstance().callAction("Login", "doControl", null);
		break;
		}


	}

	@Override
	public void submit() {

		switch (choice) {
		case "a":
			Request request = new Request();
			request.put("mode", "LISTAMBIENTE");
			request.put("buildingid", buildingid);
			MainDispatcher.getInstance().callAction("Ambiente", "doControl", request);
			break;

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		}

	}

}
