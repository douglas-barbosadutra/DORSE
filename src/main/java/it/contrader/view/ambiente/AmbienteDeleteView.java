package it.contrader.view.ambiente;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AmbienteDeleteView extends AbstractView {

	private int ambienteid;
	private Request request;
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La cancellazione è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Ambiente", null);
		}
	}

	@Override
	public void showOptions() {

		System.out.print("Inserire l'ID dell'ambiente da eliminare:\n");
		ambienteid=Integer.parseInt(getInput());

	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode","DELETE" );
		request.put("ambienteid", ambienteid);
		MainDispatcher.getInstance().callAction("Ambiente", "doControl", request);
	}

}
