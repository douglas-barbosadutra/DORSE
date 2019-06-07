package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ApartmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Apartment and its DTO ApartmentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ApartmentMapper extends EntityMapper<ApartmentDTO, Apartment> {


    @Mapping(target = "rooms", ignore = true)
    Apartment toEntity(ApartmentDTO apartmentDTO);

    default Apartment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Apartment apartment = new Apartment();
        apartment.setId(id);
        return apartment;
    }
}
