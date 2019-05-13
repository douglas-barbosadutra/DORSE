package it.contrader.dao;

import javax.transaction.Transactional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Superuser;
import it.contrader.model.Testuser;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface TestuserRepository extends MyRepository<Testuser, Long> {

}
