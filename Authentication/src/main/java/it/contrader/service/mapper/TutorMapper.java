package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.TutorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tutor and its DTO TutorDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TutorMapper extends EntityMapper<TutorDTO, Tutor> {



    default Tutor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tutor tutor = new Tutor();
        tutor.setId(id);
        return tutor;
    }
}
