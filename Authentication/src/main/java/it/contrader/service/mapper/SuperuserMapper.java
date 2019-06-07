package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.SuperuserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Superuser and its DTO SuperuserDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SuperuserMapper extends EntityMapper<SuperuserDTO, Superuser> {



    default Superuser fromId(Long id) {
        if (id == null) {
            return null;
        }
        Superuser superuser = new Superuser();
        superuser.setId(id);
        return superuser;
    }
}
