package it.contrader.service;

import java.util.List;

public interface ServiceDTO<T> {
	
	public List<T> getAll();
	
	public List<T> getAllBy(Object o);

	public T read(int id);
	
	public T read(String param1, String param2);
	
	public boolean insert (T t);
	
	public boolean update (T t);
	
	public boolean delete (T t);
}
