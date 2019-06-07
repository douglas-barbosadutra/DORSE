package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Operator.
 */
@Entity
@Table(name = "operator")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Operator extends User {

    private static final long serialVersionUID = 1L;

    @Column(name = "availability")
    private Boolean availability;

    @Column(name = "cathegory")
    private Long cathegory;

    public Boolean isAvailability() {
        return availability;
    }

    public Operator availability(Boolean availability) {
        this.availability = availability;
        return this;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Long getCathegory() {
        return cathegory;
    }

    public Operator cathegory(Long cathegory) {
        this.cathegory = cathegory;
        return this;
    }

    public void setCathegory(Long cathegory) {
        this.cathegory = cathegory;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator operator = (Operator) o;
        if (operator.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), operator.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Operator{" +
            "id=" + getId() +
            ", availability='" + isAvailability() + "'" +
            ", cathegory=" + getCathegory() +
            "}";
    }
}
