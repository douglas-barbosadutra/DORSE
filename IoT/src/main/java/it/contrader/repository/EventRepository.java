package it.contrader.repository;


import it.contrader.domain.Event;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Event entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EventRepository extends MyRepository<Event, Long> {
	
	@Override
	@Query(value = "SELECT * FROM event e WHERE e.item_id = ?1", nativeQuery = true)
	List<Event> findAllBy(Long id);

}
