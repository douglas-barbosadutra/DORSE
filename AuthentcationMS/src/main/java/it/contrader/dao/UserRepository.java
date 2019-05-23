package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface UserRepository extends MyRepository<User, Long>{
	
	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e", nativeQuery = true)
	Iterable<User> findAllBy(Long id);
	
	User findByUsernameAndPassword(String username, String password);
}
