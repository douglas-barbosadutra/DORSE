package it.contrader.model;

import javax.persistence.Entity;
import org.hibernate.annotations.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Tutor extends User {

}
