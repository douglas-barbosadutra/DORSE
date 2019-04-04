package it.contrader.view.user;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserUpdateView implements View {
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
	
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}
}
