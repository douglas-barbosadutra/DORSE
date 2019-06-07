package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Apartment entity.
 */
public class ApartmentDTO implements Serializable {

    private Long id;

    private String address;

    private Long tutor;

    private Long client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTutor() {
        return tutor;
    }

    public void setTutor(Long tutor) {
        this.tutor = tutor;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ApartmentDTO apartmentDTO = (ApartmentDTO) o;
        if (apartmentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), apartmentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ApartmentDTO{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", tutor=" + getTutor() +
            ", client=" + getClient() +
            "}";
    }
}
