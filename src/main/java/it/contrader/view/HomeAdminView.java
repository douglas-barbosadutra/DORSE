/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
	private Request request;

    public void showResults(Request request) {
    	System.out.println("Benvenuto in DORSE "+request.get("username").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti, [B]uildings, [E]sci");
        this.choice = this.getInput();
    }

    public void submit() {    
    	request = new Request();
        switch (choice) {
        case "u":
        	//MainDispatcher.getInstance().callView("User", null);
        	request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        case "b":
        	MainDispatcher.getInstance().callView("Building", null);
        	break;
        case "l":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        default:
        	Request request = new Request();
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}
