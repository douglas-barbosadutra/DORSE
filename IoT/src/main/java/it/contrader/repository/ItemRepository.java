package it.contrader.repository;

import it.contrader.domain.Item;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Item entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ItemRepository extends MyRepository<Item, Long> {
	
	@Override
	@Query(value = "SELECT * FROM item e WHERE e.thing_id = ?1", nativeQuery = true)
	List<Item> findAllBy(Long id);

}
