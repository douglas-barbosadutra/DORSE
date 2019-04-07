package it.contrader.view;

import java.util.Scanner;

public abstract class AbstractView implements View {

	private Scanner scanner;

	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
