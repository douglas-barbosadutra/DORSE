package it.contrader.view.building;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BuildingUpdateView extends AbstractView{
	
	private int idtoupdate;
	private Request request;
	private String indirizzotoupdate;
	private int useridtoupdate;
	
	@Override
	public void showResults(Request request) {
		
		
		
	}

	@Override
	public void showOptions() {
	System.out.println("Inserire l'ID del building da modificare:");
    idtoupdate=Integer.parseInt(getInput().toString());
    System.out.println("Inserire il nuovo indirizzo:");
    indirizzotoupdate=getInput().toString();
    System.out.println("Inserire il nuovo user ID");
    useridtoupdate=Integer.parseInt(getInput().toString());
	}

	@Override
	public void submit() {
		
		request = new Request();
		request.put("idtoupdate", idtoupdate);
		request.put("indirizzotoupdate", indirizzotoupdate);
		request.put("useridtoupdate", useridtoupdate);
		request.put("mode", "UPDATE");
		MainDispatcher.getInstance().callAction("Building", "doControl", request);
		

	}

}
