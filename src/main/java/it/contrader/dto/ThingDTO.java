package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThingDTO {

	private long id;
	
	private String description;
	
	private List<ItemDTO> items;
	
}
