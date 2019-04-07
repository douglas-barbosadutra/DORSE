package it.contrader.model;

import java.util.*;

public class Building {

	private int id;
	private String indirizzo;
	private Utente utente;
	private List<Ambiente> ambienti;
	private String user;
	private int userid;

	public Building() {

	}

	public Building(String indirizzo, int userid) {
		this.indirizzo = indirizzo;
		this.userid = userid;

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
		return  id + "\t\t" + indirizzo + "\t\t" + userid ;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}





}
