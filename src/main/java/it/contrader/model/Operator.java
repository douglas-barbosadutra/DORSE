package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity

@OnDelete(action = OnDeleteAction.CASCADE)
public class Operator extends User {

	@ManyToOne
	private Category category;
	
	private boolean availability;
}
