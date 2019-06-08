package it.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import it.contrader.domain.enumeration.Itemtype;

/**
 * A Item.
 */
@Entity
@Table(name = "item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private Itemtype type;

    @ManyToOne
    @JsonIgnoreProperties("items")
    private Thing thing;

    @OneToMany(mappedBy = "item")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Event> events = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Item description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Itemtype getType() {
        return type;
    }

    public Item type(Itemtype type) {
        this.type = type;
        return this;
    }

    public void setType(Itemtype type) {
        this.type = type;
    }

    public Thing getThing() {
        return thing;
    }

    public Item thing(Thing thing) {
        this.thing = thing;
        return this;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Item events(Set<Event> events) {
        this.events = events;
        return this;
    }

    public Item addEvent(Event event) {
        this.events.add(event);
        event.setItem(this);
        return this;
    }

    public Item removeEvent(Event event) {
        this.events.remove(event);
        event.setItem(null);
        return this;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
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
        Item item = (Item) o;
        if (item.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
