package it.contrader.view.building;
import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;


public class BuildingInsertView implements View {

		private Request request;
		private String indirizzo;
		private int id;
		
		private  final String mode = "INSERT";

		public BuildingInsertView() {
		}
		
		@Override
		public void showResults(Request request) {
			if (request!=null) {
				System.out.println("L'inserimento è andato a buon fine.");
				MainDispatcher.getInstance().callView("Building", null);
				}
			
		}

		@Override
		public void showOptions() {
			try {
				System.out.println("Inserisci l'indirizzo del building:");
				 indirizzo= getInput();
				System.out.println("Inserisci l'id dell'utente del building");
				id = Integer.parseInt(getInput());
			} catch (Exception e) {
				
			}
		}
		
		@Override
		public void submit() {
			request = new Request();
			request.put("indirizzo", indirizzo);
			request.put("id", id);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("Building", "doControl", request);
		}
		
		public String getInput() {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine().trim();
		}

}
