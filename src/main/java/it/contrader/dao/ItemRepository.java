package it.contrader.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Client;
import it.contrader.model.Item;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ItemRepository extends MyRepository<Item, Long> {
	
	@Override
	@Query("SELECT e FROM #{#entityName} e WHERE e.thing = ?1")
	List<Item> findAllBy(Long id);
}
