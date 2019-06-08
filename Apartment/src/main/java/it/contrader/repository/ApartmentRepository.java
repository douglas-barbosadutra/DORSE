package it.contrader.repository;

import it.contrader.domain.Apartment;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Apartment entity.
 */
@Repository
public interface ApartmentRepository extends MyRepository<Apartment, Long> {

	//Custom QUERY, gets all apartments depending on tutor_id
	@Override
	@Query(value = "SELECT * FROM apartment e WHERE e.tutor = ?1", nativeQuery = true)
	List<Apartment> findAllBy(Long id);
	
}
