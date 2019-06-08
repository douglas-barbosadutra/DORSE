package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;
import it.contrader.domain.enumeration.Itemtype;

/**
 * A DTO for the Item entity.
 */
public class ItemDTO implements Serializable {

    private Long id;

    private String description;

    private Itemtype type;

    private Long thingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Itemtype getType() {
        return type;
    }

    public void setType(Itemtype type) {
        this.type = type;
    }

    public Long getThingId() {
        return thingId;
    }

    public void setThingId(Long thingId) {
        this.thingId = thingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemDTO itemDTO = (ItemDTO) o;
        if (itemDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), itemDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            ", thing=" + getThingId() +
            "}";
    }
}
