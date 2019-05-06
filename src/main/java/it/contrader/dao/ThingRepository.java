package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Thing;

@Repository
@Transactional
public interface ThingRepository extends CrudRepository<Thing, Long> {

}
