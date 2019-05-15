package it.contrader.dto;

import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

	private long id;
	
	private Time time;
	
	private ItemDTO itemDTO;
}
