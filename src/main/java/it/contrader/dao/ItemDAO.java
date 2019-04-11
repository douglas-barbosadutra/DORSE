package it.contrader.dao;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;
import it.contrader.model.Item;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class ItemDAO implements DAO<Item> {

	public ItemDAO() {

	}

	private final String QUERY_ALL = "SELECT * FROM item";
	private final String QUERY_BY_AMBIENT = "SELECT * FROM item WHERE ambient=?";
	private final String QUERY_READ = "SELECT * FROM item WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE item SET itemtype=?, description=? WHERE id=?";
	private final String QUERY_INSERT = "INSERT INTO item (itemType, description,ambient) VALUES (?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM item WHERE id=?";

	@Override
	public List<Item> getAll() {
		List<Item> itemList = new ArrayList<Item>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Item item;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String itemType = resultSet.getString("itemtype");
				String description = resultSet.getString("description");
				int ambientId = resultSet.getInt("ambient");
				item = new Item(id, description, itemType, ambientId);
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	@Override
	public List<Item> getAllBy(Object o) {
		List<Item> items = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY_AMBIENT);
			int ambientId = (Integer)o;
			preparedStatement.setInt(1, ambientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String itemType = resultSet.getString("itemtype");
				String description = resultSet.getString("description");
				int ambient = resultSet.getInt("ambient");
				Item item = new Item(id, description, itemType, ambient);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String itemType = resultSet.getString("itemtype");
			String description = resultSet.getString("description");
			int ambientId = resultSet.getInt("ambient");
			Item item = new Item(id, description, itemType, ambientId);
			return item;
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	@Override
	public boolean insert(Item item) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, item.getItemType());
			preparedStatement.setString(2, item.getDescription());
			preparedStatement.setInt(3, item.getAmbientId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	@Override
	public boolean update(Item item) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, item.getItemType());
			preparedStatement.setString(2, item.getDescription());
			preparedStatement.setInt(3, item.getId());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			return false;
		}
		return true;
	}
		

	@Override
	public boolean delete(Item item) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			int id = item.getId();
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
			return false;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}


	}

	@Override
	public Item read(String param1, String param2) {
		// TODO Auto-generated method stub
		return null;
	}
}
