package it.contrader.repository;


import it.contrader.domain.Thing;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Thing entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ThingRepository extends MyRepository<Thing, Long> {
	
	@Override
	@Query(value = "SELECT * FROM thing e WHERE e.room = ?1", nativeQuery = true)
	List<Thing> findAllBy(Long id);

}
