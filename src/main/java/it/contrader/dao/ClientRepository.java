package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Client;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client, Long> {
	List<Client> findByTutor_id(long id);
}
