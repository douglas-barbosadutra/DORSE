package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Testuser entity.
 */
public class TestuserDTO extends UserDTO {



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestuserDTO testuserDTO = (TestuserDTO) o;
        if (testuserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), testuserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TestuserDTO{" +
            "}";
    }
}
