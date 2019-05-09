package it.contrader.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@OnDelete(action = OnDeleteAction.CASCADE)
public class User {
	
	public enum UserType {
		SUPERUSER,
		OPERATOR,
		TUTOR
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private UserType userType;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String address;
	
	private String telnumber;
	
	private Date birthdate;
	
	private String ccc;
	
	@Column(columnDefinition = "boolean default false")
	private boolean paymentStatus;
}
