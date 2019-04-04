package it.contrader.view.user;

import java.util.*;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dao.UserDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class UserUpdateView implements View {

	private UserController usersController;
	private Request request;

	public UserUpdateView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idtoupdate;
		String username, password, usertype;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona l'utente da modificare  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		User user = new User();

		System.out.println("Digita l'Id dell'utente da modificare:");
		try {
			idtoupdate = Integer.parseInt(getInput());
			if (idtoupdate != 0) {
				user.setUserId(idtoupdate);

				System.out.println("Digita la nuova username:");
				username = getInput();
				if (!username.equals(""))
					user.setUsername(username);

				System.out.println("Digita la nuova password:");
				password = getInput();
				if (!password.equals(""))
					user.setPassword(password);

				System.out.println("Digita il nuovo usertype:");
				usertype = getInput();
				if (!usertype.equals(""))
					user.setUsertype(usertype);
				
				usersController.updateUser(user, idtoupdate);
				
			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
		}
		System.out.println("OK!");
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
