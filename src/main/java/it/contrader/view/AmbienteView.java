package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ambiente;
import it.contrader.model.Building;

public class AmbienteView extends AbstractView {
	
	String mode;
	
	@Override
	public void showResults(Request request) {
		mode = (String) request.get("mode").toString();
		
		switch (mode) {
		
		case "show":
			int building = (int) request.get("buildingid");
			System.out.println("\n------ Gestione Ambienti del building  " + building + "  -------\n");
			System.out.println("ID\tDescrizione\t");
			System.out.print("------------------------------------------------------\n");
			
			List<Ambiente> list = (List<Ambiente>) request.get("listambiente");
		 	
			for (Ambiente a : list) {
				System.out.println(a);
			    System.out.println();
			    }
		break;
		
		default: break;
		}
		
		
	}

	@Override
	public void showOptions() {
		System.out.println("Che cosa vuoi fare ora?");

	}

	@Override
	public void submit() {
		
		MainDispatcher.getInstance().callAction("Ambiente", "doControl", null);
	}

}
