package it.contrader.repository;

import it.contrader.domain.Thing;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Thing entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ThingRepository extends JpaRepository<Thing, Long> {

}
