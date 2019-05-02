package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Item;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findByThing_id(long id);
}
