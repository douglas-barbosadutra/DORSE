package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Tutor;
import it.contrader.model.User;
import it.contrader.dao.MyRepository;


@Repository
@Transactional
public interface TutorRepository extends MyRepository<Tutor, Long> {

	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e", nativeQuery = true)
	List<Tutor>findAllBy(Long id);
}
