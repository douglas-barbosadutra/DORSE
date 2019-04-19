package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import it.contrader.model.Apartment;

@Repository
@Transactional
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {

}
