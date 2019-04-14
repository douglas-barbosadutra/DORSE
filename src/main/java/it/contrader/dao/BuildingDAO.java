package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Building;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class BuildingDAO implements DAO<Building> {

	private final String QUERY_ALL = "SELECT * FROM building";
	private final String QUERY_INSERT = "INSERT INTO building (address, user, operator) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM building WHERE id=?";
	private final String QUERY_BY = "SELECT * FROM building WHERE operator=?";
	private final String QUERY_UPDATE = "UPDATE building SET address=?, user=?, operator=? WHERE id=?";
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
				String indirizzo = resultSet.getString("address");
				int userid = resultSet.getInt("user");
				int operatorId = resultSet.getInt("operator");
				building = new Building(indirizzo, userid, operatorId);
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
		List<Building> buildings = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY);
			int operatorId = (Integer)o;
			preparedStatement.setInt(1, operatorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Building building;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String indirizzo = resultSet.getString("address");
				int userid = resultSet.getInt("user");
				building = new Building(indirizzo, userid, operatorId);
				building.setId(id);

				buildings.add(building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return buildings;
	}

	@Override
	public Building read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String indirizzo = resultSet.getString("address");
			int userid = resultSet.getInt("user");
			int operatorId = resultSet.getInt("operator");
			Building building = new Building(indirizzo, userid, operatorId);
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
			preparedStatement.setInt(3, building.getOperatorId());
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

		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, building.getIndirizzo());
			preparedStatement.setInt(2, building.getUserId());
			preparedStatement.setInt(3, building.getOperatorId());
			preparedStatement.setInt(4, building.getId());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			return false;
		}

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
		return null;
	}
}
