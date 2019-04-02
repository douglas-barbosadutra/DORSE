package it.contrader.main;

import java.util.Date;

import it.contrader.model.User;

import it.contrader.model.Item;

public class TestGeneric{

	public static void main (String[] args) {
		
		Item interruttore = new Item (1234, "accende e spegne");
		
		
		System.out.println(interruttore);
		interruttore.setCodice(4321);
		int codice = interruttore.getCodice();
		System.out.println(codice);
		System.out.println(interruttore);
	}
	
}
