package it.contrader.view.ambiente;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ambiente;
import it.contrader.view.AbstractView;

public class AmbienteReadView extends AbstractView  {

	private int buildingid;
	private int ambienteid;
	private Request request;

	@Override
	public void showResults(Request request) {
		if (request != null) {
			Ambiente ambiente = (Ambiente) request.get("ambiente");
			System.out.println(ambiente);
			MainDispatcher.getInstance().callView("Ambiente", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del building:");
		buildingid = Integer.parseInt(getInput());
		System.out.println("Inserisci l'ID dell'ambiente");
		ambienteid = Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("buildingid", buildingid);
		request.put("ambienteid", ambienteid);
		request.put("mode", "READ");
		MainDispatcher.getInstance().callAction("Ambiente", "doControl", request);
		
	}

}
