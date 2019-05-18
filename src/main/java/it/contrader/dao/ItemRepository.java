package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.Item;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ItemRepository extends MyRepository<Item, Long> {
	
	//Custom QUERY, gets all items depending on thing_id
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.thing_id = ?1", nativeQuery = true)
	Iterable<Item> findAllBy(Long id);
}
