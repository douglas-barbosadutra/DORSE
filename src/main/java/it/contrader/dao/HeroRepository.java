package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsernameAndPassword(String username,String password);
}
