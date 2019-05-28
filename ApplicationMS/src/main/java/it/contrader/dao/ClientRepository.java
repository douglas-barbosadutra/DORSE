package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.Client;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ClientRepository extends MyRepository<Client, Long> {
	
	//Custom QUERY, gets all clients depending on tutor_id
	@Override
	@Query(value = "SELECT * FROM client e WHERE e.tutor_id = ?1", nativeQuery = true)
	Iterable<Client> findAllBy(Long id);
}
