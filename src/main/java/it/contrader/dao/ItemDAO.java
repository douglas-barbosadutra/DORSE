package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Ambiente;
import it.contrader.model.Item;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class ItemDAO {

	public ItemDAO() {
		
	}
	
	private final String QUERY_ALL = "SELECT * FROM item";
	private final String QUERY_BY_AMBIENT = "SELECT * FROM item JOIN ambient ON item.ambient = ambient.id AND ambient.id=?";
	private final String QUERY_READ = "SELECT * FROM item WHERE item.id=?";
	private final String QUERY_INSERT = "INSERT INTO item (itemType, description) VALUES (?,?)";
	private final String QUERY_DELETE = "DELETE FROM item WHERE id=?";
	
	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Item item;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String itemType = resultSet.getString("itemType");
				String description = resultSet.getString("description");
				item = new Item(id, description, itemType);
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	public List<Item> getByAmbient(Ambiente ambient) {
		List<Item> itemList = new ArrayList();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_BY_AMBIENT);
			preparedStatement.setInt(1, ambient.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			Item item;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String itemType = resultSet.getString("itemType");
				String description = resultSet.getString("description");
				item = new Item(id, description, itemType);
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	public Item readItem(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String itemType = resultSet.getString("itemType");
			String description = resultSet.getString("description");
			Item item = new Item(id, description, itemType);
			return item;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	public boolean insertItem(Item item) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, item.getItemType());
			preparedStatement.setString(2, item.getDescription());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean deleteItem(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
