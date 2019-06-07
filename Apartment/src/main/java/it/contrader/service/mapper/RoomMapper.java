package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.RoomDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Room and its DTO RoomDTO.
 */
@Mapper(componentModel = "spring", uses = {ApartmentMapper.class})
public interface RoomMapper extends EntityMapper<RoomDTO, Room> {

    @Mapping(source = "apartment.id", target = "apartmentId")
    RoomDTO toDto(Room room);

    @Mapping(source = "apartmentId", target = "apartment")
    Room toEntity(RoomDTO roomDTO);

    default Room fromId(Long id) {
        if (id == null) {
            return null;
        }
        Room room = new Room();
        room.setId(id);
        return room;
    }
}
