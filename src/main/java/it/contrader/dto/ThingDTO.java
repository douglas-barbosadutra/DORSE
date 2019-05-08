package it.contrader.dto;

import java.util.List;
import lombok.Data;

@Data
public class ThingDTO {

	private long id;
	
	private String description;
	
	private List<ItemDTO> itemsDTO;
	
}
