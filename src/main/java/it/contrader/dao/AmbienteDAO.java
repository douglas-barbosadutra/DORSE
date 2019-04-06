package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Ambiente;
import it.contrader.model.Building;


public class AmbienteDAO {

	private final String QUERY_ALL = "SELECT * FROM ambiente WHERE building=?";
	private final String QUERY_INSERT = "INSERT INTO ambiente (indirizzo, user) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM ambiente WHERE id=?";

	private final String QUERY_UPDATE = "UPDATE ambiente SET indirizzo=?, user=? WHERE id=?";
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
			
			
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				buildingid = resultSet.getInt("building");
				String descrizione = resultSet.getString("tipo");

				Ambiente ambiente = new Ambiente();
				ambiente.setId(id);
				ambiente.setDescrizione(descrizione);
				ambiente.setBuilding(buildingid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ambienti;
	}

	public boolean insertBuilding(Building building,int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, building.getIndirizzo());
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Building readBuilding(int buildingid) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,buildingid);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String indirizzo;
			int userid;
			
			indirizzo = resultSet.getString("indirizzo");
			userid = resultSet.getInt("user");
			
			Building building = new Building (indirizzo,userid);
			building.setBuildingId(resultSet.getInt("id"));
		
			return building;
	
		} 
		
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			
			return null;
		}

	}

	public boolean updateBuilding(Building buildingToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
       
			try {
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, buildingToUpdate.getIndirizzo());
				preparedStatement.setInt(2, buildingToUpdate.getIduser());
				preparedStatement.setInt(3, buildingToUpdate.getBuildingId());
				
				preparedStatement.executeUpdate();
				} 
			catch (SQLException e) {
				return false;
			}
			
					return true;
			
	}		
			
	



	public boolean deleteBuilding(Integer id) {
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