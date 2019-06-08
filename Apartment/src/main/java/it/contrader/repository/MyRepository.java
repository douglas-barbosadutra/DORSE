package it.contrader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyRepository<Entity, ID> extends JpaRepository<Entity, ID> {

	//Implemented in all repositories, invoked by AbstractService
	List<Entity> findAllBy(ID id);
}
