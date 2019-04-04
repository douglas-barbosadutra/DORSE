package it.contrader.service;

import java.util.List;

import it.contrader.dao.UserDAO;
import it.contrader.model.User;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}
	
	public List<User> getUserList() {
		return this.userDAO.getAllUser();
	}
	
	public User readUser(int id) {
		return this.userDAO.readUser(id);
	}
	
	public boolean deleteUser(int userId) {
		return userDAO.deleteUser(userId);
	}
	
	public boolean insertUser(String username, String password, String usertype) {
		User newUser = new User(username, password, usertype);
		return userDAO.insertUser(newUser);
	}
	
	public boolean updateUser(int id, String username, String password, String usertype) {
		User newUser = new User(username, password, usertype);
		return userDAO.updateUser(newUser);
	}
	
	
}
