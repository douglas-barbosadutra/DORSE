package it.contrader.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String description;
	
	@OneToMany(mappedBy = "room")
	private List<Thing> things;
	
	@ManyToOne
	@JoinColumn(name = "apartment_id")
	private Apartment apartment;
}
