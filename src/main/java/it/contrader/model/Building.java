package it.contrader.model;

import java.util.*;

public class Building {

	private int id;
	private String indirizzo;
	private List<Ambiente> ambienti;
	private int userId;
	private int operatorId;

	public Building() {

	}

	public Building(String indirizzo, int userId, int operatorId) {
		this.indirizzo = indirizzo;
		this.userId = userId;
		this.operatorId = operatorId;
	}
	
	public Building(int id, String indirizzo, int userId, int operatorId) {
		this.id = id;
		this.indirizzo = indirizzo;
		this.userId = userId;
		this.operatorId = operatorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int buildingId) {
		this.id = buildingId;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Ambiente> getAmbienti() {
		return ambienti;
	}

	public void setAmbienti(List<Ambiente> ambienti) {
		this.ambienti = ambienti;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	@Override
	public String toString() {
		return  id + "\t\t" + indirizzo + "\t\t" + userId ;
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
		return false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}





}
