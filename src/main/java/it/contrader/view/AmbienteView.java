package it.contrader.view;

import java.util.List;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ambiente;

public class AmbienteView extends AbstractView {
	
	private String mode;
	private Request request;
	private String choice;
	
	@Override
	public void showResults(Request request) {
		
		if (request != null) {
			mode = (String) request.get("mode").toString();
			int building = (int) request.get("buildingid");
			System.out.println("\n------ Gestione Ambienti del building  " + building + "  -------\n");
			System.out.println("ID\tDescrizione\tBuilding ID");
			System.out.print("------------------------------------------------------\n");
			
			List<Ambiente> list = (List<Ambiente>) request.get("listambiente");
		 	
			for (Ambiente a : list) {
				System.out.println(a);
			    System.out.println();
			}
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
	}

	@Override
	public void submit() {
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Ambiente", "doControl", this.request);
		
	}

}
