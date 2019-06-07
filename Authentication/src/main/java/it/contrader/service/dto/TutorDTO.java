package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Tutor entity.
 */
public class TutorDTO extends UserDTO {


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TutorDTO tutorDTO = (TutorDTO) o;
        if (tutorDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tutorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TutorDTO{" +
            "}";
    }
}
