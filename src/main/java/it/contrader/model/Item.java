package it.contrader.model;

public class Item {
	int id;
	String description;
	String itemType;

	public Item() {

	}

	public Item(int id, String description, String itemType) {
		this.id = id;
		this.description = description;
		this.itemType = itemType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
}

