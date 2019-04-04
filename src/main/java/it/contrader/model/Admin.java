package it.contrader.model;

import java.util.*;

public class Admin extends User{
	int id;
	List<Utente> utenti;
	List<Operatore> operatori;
	List<Building> buildings;
	
	public Admin () {
		
	}

	public Admin( String username, String password, String usertype) {
	    super();
		
	}


	
	public int getAdminId() {
		return id;
	}

	public void setAdminId(int adminId) {
		this.id = adminId;
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
	
	
	

	@Override
	public String toString() {
		return "Admin [adminId=" + id + ", utenti=" + utenti + ", operatori=" + operatori + ", buildings="
				+ buildings + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (id != other.id)
			return false;
		if (buildings == null) {
			if (other.buildings != null)
				return false;
		} else if (!buildings.equals(other.buildings))
			return false;
		if (operatori == null) {
			if (other.operatori != null)
				return false;
		} else if (!operatori.equals(other.operatori))
			return false;
		if (operatori == null) {
			if (other.operatori != null)
				return false;
		} else if (!operatori.equals(other.operatori))
			return false;
		if (utenti == null) {
			if (other.utenti != null)
				return false;
		} else if (!utenti.equals(other.utenti))
			return false;
		return true;
	}

	
	
}
