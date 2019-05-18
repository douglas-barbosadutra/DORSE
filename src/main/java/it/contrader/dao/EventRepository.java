package it.contrader.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Event;

@Repository
@Transactional
public interface EventRepository extends MyRepository<Event, Long> {

	//Custom QUERY, gets all items depending on thing_id
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.item_id = ?1", nativeQuery = true)
	Iterable<Event> findAllBy(Long id);
	
	//Find all events by item and day
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.item_id = ?1 AND CONVERT(DATETIME, FLOOR(CONVERT(FLOAT, date))) = CONVERT(DATETIME, FLOOR(CONVERT(FLOAT, ?2))", nativeQuery = true)
	Iterable<Event> findAllByItemAndDate(Long id, Date date);
}
