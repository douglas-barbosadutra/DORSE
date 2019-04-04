package it.contrader.view.user;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.AbstractView;

public class UserReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public UserReadView() {
		new UserController();
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			User user = (User) request.get("user");
			System.out.println(user);
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
		id = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
