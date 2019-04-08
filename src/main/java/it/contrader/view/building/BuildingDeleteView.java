package it.contrader.view.building;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class BuildingDeleteView extends AbstractView {

	int id;

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("La cancellazione è andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Building", null);
		}

	}

	@Override
	public void showOptions() {
		System.out.print("Inserire l'ID del building da eliminare:\n");
		id=Integer.parseInt(getInput());


	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("mode", "DELETE");
		request.put("id", id);
		MainDispatcher.getInstance().callAction("Building", "doControl", request);

	}

}
