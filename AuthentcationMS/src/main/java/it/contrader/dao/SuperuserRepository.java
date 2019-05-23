package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.Superuser;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface SuperuserRepository extends MyRepository<Superuser, Long> {

	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName}", nativeQuery = true)
	Iterable<Superuser> findAllBy(Long id);
}
