package it.contrader.view.ambiente;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class AmbienteInsertView extends AbstractView {

		private Request request;
		private String descrizione;
		private int buildingid;
		
		private  final String mode = "INSERT";

		public AmbienteInsertView() {
		}
		
		@Override
		public void showResults(Request request) {
			if (request!=null) {
				System.out.println("L'inserimento è andato a buon fine.");
				MainDispatcher.getInstance().callView("Ambiente", null);
				}
			
		}

		@Override
		public void showOptions() {
			try {
				System.out.println("Inserisci l'ID building");
				buildingid = Integer.parseInt(getInput());
				System.out.println("Inserisci il tipo di ambiente");
				 descrizione= getInput();
			} catch (Exception e) {
				
			}
		}
		
		@Override
		public void submit() {
			request = new Request();
			request.put("buildingid", buildingid);
			request.put("descrizione", descrizione);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("Ambiente", "doControl", request);
		}

}
