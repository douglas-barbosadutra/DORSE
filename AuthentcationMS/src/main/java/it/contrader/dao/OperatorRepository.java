package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.Operator;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface OperatorRepository extends MyRepository<Operator, Long>{

	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e", nativeQuery = true)
	Iterable<Operator> findAllBy(Long id);
}
