package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import it.contrader.model.Apartment;

@NoRepositoryBean
public interface MyRepository<Entity, ID> extends CrudRepository<Entity, ID> {

	List<Entity> findAllBy(ID id);
}
