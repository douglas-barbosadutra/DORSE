package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.RoomDTO;
import it.contrader.model.Room;

@Component
public class RoomConverter extends AbstractConverter<Room, RoomDTO> {
	
	@Autowired
	private ThingConverter thingConverter;
	@Autowired
	private ApartmentConverter apartmentConverter;
	
	public Room toEntity(RoomDTO roomDTO) {
		Room room = new Room();
		if(roomDTO!=null) {
			room.setId(roomDTO.getId());
			room.setDescription(roomDTO.getDescription());
			room.setThings(thingConverter.toEntityList(roomDTO.getThingsDTO()));
			room.setApartment(apartmentConverter.toEntity(roomDTO.getApartmentDTO()));
		}
		return room;
	}
	
	public RoomDTO toDTO (Room room) {
		RoomDTO roomDTO = new RoomDTO();
		if(room!=null) {
			roomDTO.setId(room.getId());
			roomDTO.setDescription(room.getDescription());
			roomDTO.setThingsDTO(thingConverter.toDTOList(room.getThings()));
			roomDTO.setApartmentDTO(apartmentConverter.toDTO(room.getApartment()));
			
		}
		return roomDTO;
	}
	
}
