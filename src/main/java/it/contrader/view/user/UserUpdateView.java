package it.contrader.view.user;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class UserUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String username;
	private String password;
	private String usertype;
	private final String mode = "UPDATE";

	public UserUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La modifica è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci username dell'utente:");
			username = getInput();
			System.out.println("Inserisci password dell'utente:");
			password = getInput();
			System.out.println("Inserisci tipo dell'utente:");
			usertype = getInput();
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("username", username);
		request.put("password", password);
		request.put("usertype", usertype);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
