/**
 * Manage a Business Owner view
 */

package it.contrader.view;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
	private Request request;

    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in DORSE "+request.get("username").toString() + "\n");
    	}
    }


    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti   [B]uildings   [E]sci");
        choice = this.getInput();
    }

    public void submit() {    
    	request = new Request();
        switch (choice) {
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        case "b":
        	this.request.put("mode", "BUILDINGLIST");
        	MainDispatcher.getInstance().callAction("Building", "doControl", request);
        	break;
        case "e":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}
