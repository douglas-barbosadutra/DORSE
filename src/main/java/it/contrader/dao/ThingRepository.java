package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;
import it.contrader.model.Thing;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ThingRepository extends MyRepository<Thing, Long> {

	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.room_id = ?1", nativeQuery = true)
	List<Thing> findAllBy(Long id);
}
