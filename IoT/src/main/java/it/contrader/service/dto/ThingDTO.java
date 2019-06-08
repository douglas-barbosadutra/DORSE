package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Thing entity.
 */
public class ThingDTO implements Serializable {

    private Long id;

    private Long room;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ThingDTO thingDTO = (ThingDTO) o;
        if (thingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), thingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ThingDTO{" +
            "id=" + getId() +
            ", room=" + getRoom() +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
