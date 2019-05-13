package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import it.contrader.model.Apartment;
import it.contrader.model.Client;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ApartmentRepository extends MyRepository<Apartment, Long> {
	
	@Override
	@Query("SELECT e FROM #{#entityName} e WHERE e.tutor = ?1")
	List<Apartment> findAllBy(Long id);
}