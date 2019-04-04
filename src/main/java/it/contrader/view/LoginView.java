package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView implements View {

	private String username;
	private String password;

	public void showResults(Request request) {
		
	}

	public void showOptions() {
		System.out.println("----- .:LOGIN:. ----");
		System.out.println("Nome utente:");
		this.username = getInput();
		System.out.println("Password:");
		this.password = getInput();
	}

	public void submit() {
		Request request = new Request();
		request.put("username", username);
		request.put("password", password);
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
		System.out.println(" login view, fin qui tutto bene...");
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
