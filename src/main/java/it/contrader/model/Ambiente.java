package it.contrader.model;

import java.util.*;

public class Ambiente {
	private int id;
	private String descrizione;
	private List<Item> items;
	private int buildingid;
	
    public Ambiente() {
		
	}
	
	public Ambiente(String descrizione, int buildingid) {
		super ();
		this.descrizione = descrizione;
		this.buildingid = buildingid;
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List <Item> getItems() {
		return items;
	}

	public void setItems(List <Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Ambiente [id=" + id + ", descrizione=" + descrizione + ", ID building=" + buildingid + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ambiente other = (Ambiente) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

	public int getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(int buildingid) {
		this.buildingid = buildingid;
	}
	

	
}
