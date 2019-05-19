package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDTO {

	private long id;

	private String address;
	
	private List<RoomDTO> rooms;
	
	private TutorDTO tutor;
	
}
