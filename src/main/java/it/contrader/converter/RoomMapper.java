package it.contrader.converter;

import org.mapstruct.Mapper;
import it.contrader.dto.RoomDTO;
import it.contrader.model.Room;

@Mapper( componentModel="spring" )
public interface RoomMapper extends GenericMapper<Room, RoomDTO> {

}
