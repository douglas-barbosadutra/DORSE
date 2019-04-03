package it.contrader.model;

import java.util.*;

public class Utente extends User {
	private List <String> malattie;
	private List <String> cure;
	
	public Utente() {
		
	}
	
	
	
	public Utente(List<String> malattie, List<String> cure) {
		super();
		this.malattie = malattie;
		this.cure = cure;
	}



	public List <String> getCure() {
		return cure;
	}
	public void setCure(List <String> cure) {
		this.cure = cure;
	}
	
	public List <String> getMalattie() {
		return malattie;
	}
	public void setMalattie(List <String> malattie) {
		this.malattie = malattie;
	}
	
	
}
