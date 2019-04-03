package it.contrader.main;

import java.util.*;

import it.contrader.model.*;




public class TestGeneric{
	
	
	public static void main (String[] args) {
		
		
	
	Utente tizio = new Utente();
	Operatore caio = new Operatore();
	Building nowhere = new Building ();
	
	List <Utente> listautenti = new ArrayList<Utente> ();
	List <Operatore> listaoperatori = new ArrayList<Operatore> ();
	List <Building> listabuilding = new ArrayList<Building> ();
	
	listautenti.add(tizio);
	listaoperatori.add(caio);
	listabuilding.add(nowhere);
	
		Admin sabatino = new Admin ( listautenti, listaoperatori, listabuilding);
		
		
		System.out.println(sabatino);
		
	}
	
	
	
}
