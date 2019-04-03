package it.contrader.main;

import java.util.*;
import it.contrader.model.*;
public class testKatia {

	public static void main(String[] args) {
		Date compleanno = new Date (1000000); 
		List<String> malattieKatia = new ArrayList<String> ();
		malattieKatia.add("diabete");
		malattieKatia.add("pressione alta");
		List<String> cureKatia = new ArrayList<String> ();
		cureKatia.add("insulina");
		cureKatia.add("pillola");
		Utente katia = new Utente ("Katia","Scarola","Cscarola","123",compleanno,"234567890", malattieKatia, cureKatia);
		System.out.println(katia);
		
	}
	
	
	
	

}
