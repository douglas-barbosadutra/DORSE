package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Item;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {

}
