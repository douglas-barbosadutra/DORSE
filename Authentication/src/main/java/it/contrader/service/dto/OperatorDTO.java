package it.contrader.service.dto;

import java.util.Objects;

/**
 * A DTO for the Operator entity.
 */
public class OperatorDTO extends UserDTO {

    private Boolean availability;

    private Long cathegory;


    public Boolean isAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Long getCathegory() {
        return cathegory;
    }

    public void setCathegory(Long cathegory) {
        this.cathegory = cathegory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OperatorDTO operatorDTO = (OperatorDTO) o;
        if (operatorDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), operatorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OperatorDTO{" +
            ", availability='" + isAvailability() + "'" +
            ", cathegory=" + getCathegory() +
            "}";
    }
}
