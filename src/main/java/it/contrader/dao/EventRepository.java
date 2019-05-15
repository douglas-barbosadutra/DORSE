package it.contrader.dao;

import java.util.List;

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
	List<Event> findAllBy(Long id);
}
