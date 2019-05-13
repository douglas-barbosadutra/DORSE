package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Superuser;
import it.contrader.model.User;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface SuperuserRepository extends MyRepository<Superuser, Long> {

	// TODO This should be not necessary
	@Override
	@Query("SELECT e FROM #{#entityName} e")
	List<Superuser> findAllBy(Long id);
}
