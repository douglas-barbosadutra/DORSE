package it.contrader.model;

import java.util.*;

public class Operatore extends User{
	private String  contatto;
	private List<Utente> utenti;
	private List<Building> buildings;
	private boolean disponibile;
	
public Operatore() {
		
	}

public String getContatto() {
	return contatto;
}

public void setContatto(String contatto) {
	this.contatto = contatto;
}

public List<Utente> getUtenti() {
	return utenti;
}

public void setUtenti(List<Utente> utenti) {
	this.utenti = utenti;
}

public List<Building> getBuildings() {
	return buildings;
}

public void setBuildings(List<Building> buildings) {
	this.buildings = buildings;
}

public boolean isDisponibile() {
	return disponibile;
}

public void setDisponibile(boolean disponibile) {
	this.disponibile = disponibile;
}



@Override
public String toString() {
	return "Operatore [contatto=" + contatto + ", utenti=" + utenti + ", buildings=" + buildings + ", disponibile="
			+ disponibile + "]";
}

public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Operatore other = (Operatore) obj;
	if (buildings == null) {
		if (other.buildings != null)
			return false;
	} else if (!buildings.equals(other.buildings))
		return false;
	if (contatto == null) {
		if (other.contatto != null)
			return false;
	} else if (!contatto.equals(other.contatto))
		return false;
	if (disponibile != other.disponibile)
		return false;
	if (utenti == null) {
		if (other.utenti != null)
			return false;
	} else if (!utenti.equals(other.utenti))
		return false;
	return true;
}


}
