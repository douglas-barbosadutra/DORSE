package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	private long id;

	private String description;
	
	private String type;
	
	private boolean status;
	
	private ThingDTO thing;
}
