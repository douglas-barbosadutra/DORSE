package it.contrader.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Disease {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@OneToMany
	private List<Category> categories;
	
	@OneToMany (mappedBy = "disease")
	private List<Therapy> therapies;
	
	@OneToMany
	@JoinColumn
	private List<Client> clients;
}
