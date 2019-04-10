package it.contrader.dto;

public class ItemDTO implements DTO {
	int id;
	String description;
	String itemType;
	
	public ItemDTO(int id, String description, String itemType) {
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
