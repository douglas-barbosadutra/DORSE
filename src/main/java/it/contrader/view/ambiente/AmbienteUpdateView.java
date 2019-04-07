package it.contrader.view.ambiente;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AmbienteUpdateView extends AbstractView {

	private int idtoupdate;
	private String descrizionetoupdate;
	private int buildingidtoupdate;
	private Request request;

	@Override
	public void showResults(Request request) {

		if (request!=null) {
			System.out.println("La modifica è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Ambiente", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire l'ID dell'ambiente da modificare:");
		idtoupdate=Integer.parseInt(getInput().toString());
		System.out.println("Inserire la nuova decrizione:");
		descrizionetoupdate=getInput().toString();
		System.out.println("Inserire il nuovo building ID");
		buildingidtoupdate=Integer.parseInt(getInput().toString());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", idtoupdate);
		request.put("descrizione", descrizionetoupdate);
		request.put("buildingid", buildingidtoupdate);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("Ambiente", "doControl", request);


	}

}
