package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.ThingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Thing and its DTO ThingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ThingMapper extends EntityMapper<ThingDTO, Thing> {


    @Mapping(target = "items", ignore = true)
    Thing toEntity(ThingDTO thingDTO);

    default Thing fromId(Long id) {
        if (id == null) {
            return null;
        }
        Thing thing = new Thing();
        thing.setId(id);
        return thing;
    }
}
