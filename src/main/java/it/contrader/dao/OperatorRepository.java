package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Operator;

@Repository
@Transactional
public interface OperatorRepository extends CrudRepository<Operator, Long>{

}
