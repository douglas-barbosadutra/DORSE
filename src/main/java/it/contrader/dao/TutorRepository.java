package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Tutor;


@Repository
@Transactional
public interface TutorRepository extends CrudRepository<Tutor, Long> {

}
