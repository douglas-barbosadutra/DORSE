package it.contrader.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

	private long id;
	
	private Date date;
	
	private ItemDTO itemDTO;
}
