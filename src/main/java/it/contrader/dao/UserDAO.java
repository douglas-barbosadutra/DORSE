package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;
import it.contrader.model.Building;
import it.contrader.model.User;

public class UserDAO implements DAO<User> {

	private final String QUERY_ALL = "SELECT * FROM user";
	private final String QUERY_BY_USERTYPE = "SELECT * FROM user WHERE usertype=?";
	private final String QUERY_INSERT = "INSERT INTO user (username, password, usertype) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM user WHERE idUser=?";
	private final String QUERY_READ_UP = "SELECT * FROM user WHERE username=? AND password=?";
	private final String QUERY_UPDATE = "UPDATE user SET username=?, password=?, usertype=? WHERE idUser=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE idUser=?";

	public UserDAO() {

	}

	public List<User> getAll() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("idUser");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String usertype = resultSet.getString("usertype");
				user = new User(username, password, usertype);
				user.setId(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	@Override
	public List<User> getAllBy(Object o) {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY_USERTYPE);
			String usertype = (String)o;
			preparedStatement.setString(1, usertype);
			ResultSet resultSet = preparedStatement.executeQuery();
			User user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("idUser");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				user = new User(username, password, usertype);
				user.setId(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersList;
	}

	@Override
	public User read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;
			username = resultSet.getString("username");
			password = resultSet.getString("password");
			usertype = resultSet.getString("usertype");
			User user = new User(username, password, usertype);
			user.setId(resultSet.getInt("idUser"));
			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	@Override
	public User read(String username, String password) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_UP);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int id = resultSet.getInt("idUser");
			String usertype = resultSet.getString("usertype");
			User user = new User(id, username, password, usertype);
			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	@Override
	public boolean insert(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUsertype());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (user.getId() == 0)
			return false;

		User userRead = read(user.getId());
		if (!userRead.equals(user)) {
			try {
				// Fill the userToUpdate object
				if (user.getUsername() == null || user.getUsername().equals("")) {
					user.setUsername(userRead.getUsername());
				}
				if (user.getPassword() == null || user.getPassword().equals("")) {
					user.setPassword(userRead.getPassword());
				}
				if (user.getUsertype() == null || user.getUsertype().equals("")) {
					user.setUsertype(userRead.getUsertype());
				}
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getUsertype());
				preparedStatement.setInt(4, user.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else 
					return false;
				

			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int id = user.getId();
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}
