package it.contrader.dao;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;
import it.contrader.model.Ambiente;

public class AmbienteDAO implements DAO<Ambiente> {

	private final String QUERY_ALL = "SELECT * FROM ambiente WHERE building=?";
	private final String QUERY_INSERT = "INSERT INTO ambiente (tipo, building) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM ambiente WHERE building=? AND  id=?";
	private final String QUERY_UPDATE = "UPDATE ambiente SET tipo=?, building=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM ambiente WHERE id=?";

	public AmbienteDAO() {

	}

	@Override
	public List<Ambiente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Ambiente> getAllBy(Object o) {
		List<Ambiente> ambienti = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			int buildingid = (Integer)o;
			preparedStatement.setInt(1, buildingid);
			ResultSet resultSet = preparedStatement.executeQuery();
			Ambiente ambiente;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String descrizione = resultSet.getString("tipo");
				int building = resultSet.getInt("building");
				ambiente = new Ambiente(descrizione, building);
				ambiente.setId(id);
				ambienti.add(ambiente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ambienti;
	}

	@Override
	public Ambiente read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String descrizione= resultSet.getString("tipo");
			int buildingid = resultSet.getInt("building");
			Ambiente ambiente = new Ambiente (descrizione,buildingid);
			ambiente.setId(resultSet.getInt("id"));
			return ambiente;
		} 
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;
		}
	}

	@Override
	public boolean insert(Ambiente ambiente) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, ambiente.getDescrizione());
			preparedStatement.setInt(2, ambiente.getBuildingid());
			preparedStatement.execute();

			return true;

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	@Override
	public boolean update(Ambiente ambiente) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, ambiente.getDescrizione());
			preparedStatement.setInt(2, ambiente.getBuildingid());
			preparedStatement.setInt(3, ambiente.getId());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("qualcosa è andato storto...\n");
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Ambiente ambiente) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int id = ambiente.getId();
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public Ambiente read(String param1, String param2) {
		// TODO Auto-generated method stub
		return null;
	}
}