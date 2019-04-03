package it.contrader.model;

import java.util.*;

public class Building {

	private int id;
	private String indirizzo;
	private Utente utente;
	private List<Ambiente> ambienti;
	
	
	public Building() {
		
	}
	
	public Building(String indirizzo, Utente utente, List<Ambiente> ambienti) {
		this.indirizzo = indirizzo;
		this.utente = utente;
		this.ambienti = ambienti;
	}

	public int getBuildingId() {
		return id;
	}

	public void setBuildingId(int buildingId) {
		this.id = buildingId;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Ambiente> getAmbienti() {
		return ambienti;
	}

	public void setAmbienti(List<Ambiente> ambienti) {
		this.ambienti = ambienti;
	}

	
	
	@Override
	public String toString() {
		return "Building [buildingId=" + id + ", indirizzo=" + indirizzo + ", utente=" + utente + ", ambienti="
				+ ambienti + "]";
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Building other = (Building) obj;
		if (ambienti == null) {
			if (other.ambienti != null)
				return false;
		} else if (!ambienti.equals(other.ambienti))
			return false;
		if (id != other.id)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}
	
	
	
	
	
}
