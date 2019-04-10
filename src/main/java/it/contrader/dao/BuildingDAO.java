package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.contrader.model.Ambiente;
import it.contrader.model.Building;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;
public class BuildingDAO implements DAO<Building> {

	private final String QUERY_ALL = "SELECT * FROM building";
	private final String QUERY_INSERT = "INSERT INTO building (indirizzo, user) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM building WHERE id=?";

	private final String QUERY_UPDATE = "UPDATE building SET indirizzo=?, user=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM building WHERE id=?";

	public BuildingDAO() {

	}

	@Override
	public List<Building> getAll() {
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
	
	@Override
	public List<Building> getAllBy(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Building read(int id) {
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

	@Override
	public boolean insert(Building building) {
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

	@Override
	public boolean update(Building building) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (building.getId() == 0)
			return false;

		Building userRead = (Building)read(building.getId());
		if (!userRead.equals(building)) {
			try {
				// Fill the userToUpdate object
				if (building.getIndirizzo() == null || building.getIndirizzo().equals("")) {
					building.setIndirizzo(userRead.getIndirizzo());
				}


				if (building.getUserId() == 0 ) {
					building.setUserId(userRead.getUserId());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, building.getIndirizzo());
				preparedStatement.setInt(2, building.getUserId());
				preparedStatement.setInt(3, building.getId());
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
	public boolean delete(Building building) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int id = building.getId();
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public Building read(String param1, String param2) {
		// TODO Auto-generated method stub
		return null;
	}
}
