package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class UserView extends AbstractView {

	private Request request;
	private String choice;

	public UserView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
			System.out.println("ID\tUsername\tPassword\tTipo Utente");
			System.out.println("----------------------------------------------------\n");
			List<User> users = (List<User>) request.get("users");
			for (User u: users)
				System.out.println(u);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}

}
