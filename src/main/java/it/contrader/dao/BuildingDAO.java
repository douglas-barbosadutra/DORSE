package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Building;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;
public class BuildingDAO {

	private final String QUERY_ALL = "SELECT * FROM building";
	private final String QUERY_INSERT = "INSERT INTO building (indirizzo, user) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM building WHERE id=?";

	private final String QUERY_UPDATE = "UPDATE building SET indirizzo=?, user=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM building WHERE id=?";

	public BuildingDAO() {

	}

	public List<Building> getAllBuildings() {
		List<Building> buildings = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Building building;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String indirizzo = resultSet.getString("indirizzo");
				int userid = resultSet.getInt("user");
				building = new Building(indirizzo, userid);
				building.setId(id);

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
			preparedStatement.setInt(2, building.getUserId());
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
			building.setId(resultSet.getInt("id"));

			return building;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateBuilding(Building buildingToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (buildingToUpdate.getId() == 0)
			return false;

		Building userRead = readBuilding(buildingToUpdate.getId());
		if (!userRead.equals(buildingToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (buildingToUpdate.getIndirizzo() == null || buildingToUpdate.getIndirizzo().equals("")) {
					buildingToUpdate.setIndirizzo(userRead.getIndirizzo());
				}


				if (buildingToUpdate.getUserId() == 0 ) {
					buildingToUpdate.setUserId(userRead.getUserId());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, buildingToUpdate.getIndirizzo());
				preparedStatement.setInt(2, buildingToUpdate.getUserId());
				preparedStatement.setInt(3, buildingToUpdate.getId());
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

	public boolean deleteBuilding(Building building) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int id = building.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
