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
 * A Thing.
 */
@Entity
@Table(name = "thing")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Thing implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room")
    private Long room;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "thing")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Item> items = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoom() {
        return room;
    }

    public Thing room(Long room) {
        this.room = room;
        return this;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public Thing description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Item> getItems() {
        return items;
    }

    public Thing items(Set<Item> items) {
        this.items = items;
        return this;
    }

    public Thing addItem(Item item) {
        this.items.add(item);
        item.setThing(this);
        return this;
    }

    public Thing removeItem(Item item) {
        this.items.remove(item);
        item.setThing(null);
        return this;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
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
        Thing thing = (Thing) o;
        if (thing.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), thing.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Thing{" +
            "id=" + getId() +
            ", room=" + getRoom() +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
