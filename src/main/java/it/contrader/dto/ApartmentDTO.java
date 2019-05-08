package it.contrader.dto;

import java.util.List;
import lombok.Data;

@Data
public class ApartmentDTO {

	private long id;

	private String address;
	
	private List<RoomDTO> roomsDTO;
	
	private TutorDTO tutorDTO;
	
}
