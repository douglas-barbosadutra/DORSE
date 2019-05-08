package it.contrader.dto;

import lombok.Data;


@Data
public class ItemDTO {
	
	private long id;

	private String description;
	
	private String type;
	
	private boolean status;
	
	private ThingDTO thingDTO;
}
