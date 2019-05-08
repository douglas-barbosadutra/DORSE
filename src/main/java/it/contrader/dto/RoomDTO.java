package it.contrader.dto;

import java.util.List;
import lombok.Data;

@Data
public class RoomDTO {

	private long id;

	private String description;
	
	private List<ThingDTO> thingsDTO;
	
	private ApartmentDTO apartmentDTO;
}
