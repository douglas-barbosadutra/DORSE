package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Ambiente;



public class AmbienteDAO {

	private final String QUERY_ALL = "SELECT * FROM ambiente WHERE building=?";
	private final String QUERY_INSERT = "INSERT INTO ambiente (tipo, building) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM ambiente WHERE building=? AND  id=?";
	private final String QUERY_UPDATE = "UPDATE ambiente SET tipo=?, building=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM ambiente WHERE id=?";



	public AmbienteDAO() {

	}

	public List<Ambiente> showAllAmbiente(int buildingid) {
		List<Ambiente> ambienti = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
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

	public boolean insertAmbiente(Ambiente ambiente) {
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

	public Ambiente readAmbiente(int buildingid, int ambienteid) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,buildingid);
			preparedStatement.setInt(2,ambienteid);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			String descrizione= resultSet.getString("tipo");
			buildingid = resultSet.getInt("building");

			Ambiente ambiente = new Ambiente (descrizione,buildingid);
			ambiente.setId(resultSet.getInt("id"));

			return ambiente;

		} 

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);

			return null;
		}

	}

	public boolean updateAmbiente(Ambiente ambienteToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, ambienteToUpdate.getDescrizione());
			preparedStatement.setInt(2, ambienteToUpdate.getBuildingid());
			preparedStatement.setInt(3, ambienteToUpdate.getId());
			preparedStatement.executeUpdate();
		} 

		catch (SQLException e) {
			System.out.println("qualcosa è andato storto...\n");
			return false;

		}

		return true;

	}		




	public boolean deleteAmbiente(int id) {
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
	}
}