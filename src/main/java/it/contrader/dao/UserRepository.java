package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface UserRepository extends MyRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
}
