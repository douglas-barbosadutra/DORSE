package it.contrader.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface MyRepository<Entity, ID> extends CrudRepository<Entity, ID> {

	//Implemented in all repositories, invoked by AbstractService
	List<Entity> findAllBy(ID id);
}
