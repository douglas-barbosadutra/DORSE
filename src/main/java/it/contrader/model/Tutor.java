package it.contrader.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Tutor extends User {

	@OneToMany(mappedBy = "tutor")
	private List<Client> clients;
	
	@OneToMany (mappedBy= "tutor")
	private List<Apartment> apartments;
}
