package it.contrader.repository;

import it.contrader.domain.Testuser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Testuser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TestuserRepository extends JpaRepository<Testuser, Long> {

}
