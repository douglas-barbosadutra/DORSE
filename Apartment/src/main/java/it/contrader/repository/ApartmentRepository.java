package it.contrader.repository;

import it.contrader.domain.Apartment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Apartment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
