package it.contrader.view.user;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class UserDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public UserDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La cancellazione è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}


}
