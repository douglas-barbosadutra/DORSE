package it.contrader.dto;

import java.util.Date;
import java.util.List;

import it.contrader.model.Disease;
import it.contrader.model.Thing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemDTO {
	
	private long id;

	private String description;
	
	private String type;
	
	private boolean status;
	
	private ThingDTO thingDTO;
}
