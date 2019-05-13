package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Client;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ClientRepository extends MyRepository<Client, Long> {
	
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.tutor_id = ?1", nativeQuery = true)
	List<Client> findAllBy(Long id);
}
