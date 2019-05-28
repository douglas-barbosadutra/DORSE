package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Event;

@Repository
@Transactional
public interface EventRepository extends MyRepository<Event, Long> {

	//Custom QUERY, gets all items depending on thing_id
	@Override
	@Query(value = "SELECT * FROM event e WHERE e.item_id = ?1", nativeQuery = true)
	Iterable<Event> findAllBy(Long id);
	
	//Find all events by item and day
	@Query(value = "SELECT * FROM event e WHERE e.item_id = ?1 AND DATE(e.date) = DATE(?2)", nativeQuery = true)
	Iterable<Event> findAllByItemAndDate(Long id, String date);
}
