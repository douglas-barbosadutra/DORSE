package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Operator extends User {

	@ManyToOne
	private Category category;
	
	private boolean availability;
}
