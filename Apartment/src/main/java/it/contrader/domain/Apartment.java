package it.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Apartment.
 */
@Entity
@Table(name = "apartment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Apartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "tutor")
    private Long tutor;

    @Column(name = "client")
    private Long client;

    @OneToMany(mappedBy = "apartment")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Room> rooms = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public Apartment address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTutor() {
        return tutor;
    }

    public Apartment tutor(Long tutor) {
        this.tutor = tutor;
        return this;
    }

    public void setTutor(Long tutor) {
        this.tutor = tutor;
    }

    public Long getClient() {
        return client;
    }

    public Apartment client(Long client) {
        this.client = client;
        return this;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public Apartment rooms(Set<Room> rooms) {
        this.rooms = rooms;
        return this;
    }

    public Apartment addRooms(Room room) {
        this.rooms.add(room);
        room.setApartment(this);
        return this;
    }

    public Apartment removeRooms(Room room) {
        this.rooms.remove(room);
        room.setApartment(null);
        return this;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
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
        Apartment apartment = (Apartment) o;
        if (apartment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), apartment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Apartment{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", tutor=" + getTutor() +
            ", client=" + getClient() +
            "}";
    }
}
