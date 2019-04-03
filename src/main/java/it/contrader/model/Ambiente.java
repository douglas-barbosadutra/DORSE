package it.contrader.model;

import java.util.*;

public class Ambiente {
	private List <Item> items;
	
    public Ambiente() {
		
	}
	
	public Ambiente(List <Item> items) {
		this.items = items;
		
	}
	
	
	

	public List <Item> getItems() {
		return items;
	}

	public void setItems(List <Item> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Ambiente [items=" + items + "]";
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ambiente other = (Ambiente) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
	
	
}
