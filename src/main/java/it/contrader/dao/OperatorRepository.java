package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Operator;
import it.contrader.model.User;

@Repository
@Transactional
public interface OperatorRepository extends CrudRepository<Operator, Long>{

}
