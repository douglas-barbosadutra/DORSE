package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Building;

public class BuildingDAO {

	private final String QUERY_ALL = "SELECT * FROM building";
	private final String QUERY_INSERT = "INSERT INTO building (indirizzo, user) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM building WHERE id=?";

	//private final String QUERY_UPDATE = "UPDATE building SET username=?, password=?, usertype=? WHERE id=?";
	//private final String QUERY_DELETE = "DELETE FROM building WHERE id=?";

	public BuildingDAO() {

	}

	public List<Building> getAllBuilding() {
		List<Building> buildings = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Building building;
			while (resultSet.next()) {
				building = new Building();
				int id = resultSet.getInt("id");
				String indirizzo = resultSet.getString("indirizzo");
				int userid = resultSet.getInt("user");
				building = new Building(indirizzo, userid);
				building.setBuildingId(id);
				
				buildings.add(building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildings;
	}

	public boolean insertBuilding(Building building) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, building.getIndirizzo());
			preparedStatement.setInt(2, building.getUserid());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Building readBuilding(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int userid;
			String indirizzo;

			indirizzo = resultSet.getString("indirizzo");
			userid = resultSet.getInt("user");
			Building building = new Building(indirizzo, userid);
			building.setBuildingId(resultSet.getInt("id"));

			return building;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	/*public boolean updateUser(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = readBuilding(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}
				
				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(2, userToUpdate.getPassword());
				preparedStatement.setString(3, userToUpdate.getUsertype());
				preparedStatement.setInt(4, userToUpdate.getUserId());
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

	public boolean deleteUser(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}*/
}
