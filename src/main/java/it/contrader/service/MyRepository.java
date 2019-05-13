package it.contrader.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Apartment;

public interface MyRepository<Entity, ID> extends CrudRepository<Entity, ID> {

	List<Entity> findAllBy(ID id);
}
