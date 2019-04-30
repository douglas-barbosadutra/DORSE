package it.contrader.dto;

import java.util.List;

import it.contrader.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApartmentDTO {

	private long id;

	private String address;
	
	private List<Room> rooms;
	
	private TutorDTO tutorDTO;
	
	//private List<ClientDTO> clientsDTO;
	
}
