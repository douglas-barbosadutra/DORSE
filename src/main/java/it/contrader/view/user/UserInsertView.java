package it.contrader.view.user;

import java.util.*;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dao.UserDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class UserInsertView implements View {

	private UserController usersController;
	private Request request;

	public UserInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String username, password, usertype;

		System.out.println("Inserisci i campi dell'utente:");
		System.out.println("Digita l'username: ");
		username = getInput();
		System.out.println("Digita la password: ");
		password = getInput();
		System.out.println("Inserisci la tipologia utente");
		usertype=getInput();
		User user= new User(username, password, usertype);
		UserDAO temp = new UserDAO();
		boolean temp2 = temp.insertUser(user);
		if (temp2 == true) {
			System.out.println("La richiesta di inserimento è andata a buon fine.");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
