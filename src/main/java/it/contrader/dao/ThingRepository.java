package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;
import it.contrader.model.Thing;
import it.contrader.service.MyRepository;

@Repository
@Transactional
public interface ThingRepository extends MyRepository<Thing, Long> {

	@Override
	@Query("SELECT e FROM #{#entityName} e WHERE e.room = ?1")
	List<Thing> findAllBy(Long id);
}
