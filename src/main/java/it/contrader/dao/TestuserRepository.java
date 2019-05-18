package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.Testuser;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface TestuserRepository extends MyRepository<Testuser, Long> {

	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e", nativeQuery = true)
	Iterable<Testuser> findAllBy(Long id);
}
