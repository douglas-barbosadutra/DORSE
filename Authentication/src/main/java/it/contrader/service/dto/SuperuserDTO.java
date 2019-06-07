package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Superuser entity.
 */
public class SuperuserDTO extends UserDTO {


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SuperuserDTO superuserDTO = (SuperuserDTO) o;
        if (superuserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), superuserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SuperuserDTO{" +
            "}";
    }
}
