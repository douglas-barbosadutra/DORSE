package it.contrader.view.user;

//import java.sql.SQLException;
import java.util.*;


import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dao.UserDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class UserReadView implements View {

	private UserController usersController;
	private Request request;

	public UserReadView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int userIdToRead;

		System.out.println("Inserisci l'ID dell'utente:");

		try {
			userIdToRead = Integer.parseInt(getInput());
			 User userDB = readUser(userIdToRead);

			System.out.println("Id: " + userDB.getUserId());
			System.out.println("Username: " + userDB.getUsername());
			System.out.println("Password: " + userDB.getPassword());
			System.out.println("User type: " + userDB.getUsertype());
			
			//Wait user to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
		}

	}

	public User readUser(int userIdToRead) {
		UserDAO user = new UserDAO();
		User temp=user.readUser(userIdToRead);	
		return temp;
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
