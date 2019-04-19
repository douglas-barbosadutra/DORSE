package it.contrader.dto;

import java.util.List;
import it.contrader.model.Room;
import it.contrader.model.Tutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDTO {

	private long id;

	private String address;
	
	private List<Room> rooms;
	
	private Tutor tutor;
	
}
