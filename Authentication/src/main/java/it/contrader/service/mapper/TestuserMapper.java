package it.contrader.service.mapper;

import it.contrader.domain.*;
import it.contrader.service.dto.TestuserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Testuser and its DTO TestuserDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TestuserMapper extends EntityMapper<TestuserDTO, Testuser> {



    default Testuser fromId(Long id) {
        if (id == null) {
            return null;
        }
        Testuser testuser = new Testuser();
        testuser.setId(id);
        return testuser;
    }
}
