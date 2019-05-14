package it.contrader.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import it.contrader.model.Apartment;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface ApartmentRepository extends MyRepository<Apartment, Long> {
	
	//Custom QUERY, gets all apartments depending on tutor_id
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.tutor_id = ?1", nativeQuery = true)
	List<Apartment> findAllBy(Long id);
}