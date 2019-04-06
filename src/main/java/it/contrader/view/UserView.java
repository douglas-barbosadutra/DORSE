package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class UserView extends AbstractView {

	private UserController usersController;
	private Request request;
	private String choice;
	
	public UserView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------ Gestione utenti -------\n");
			System.out.println("ID\tUsername\tPassword\tTipoUtente");
			System.out.print("------------------------------------------------------\n");
			List<User> users = (List<User>) request.get("users");
			for (User u: users)
				System.out.println(u);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
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
