package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Thing;

@Repository
@Transactional
public interface ThingRepository extends CrudRepository<Thing, Long> {
	List<Thing> findByRoom_id(long id);
}
