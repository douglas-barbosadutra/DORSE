package it.contrader.service;

import java.util.List;

// T = entity, V = dto
public interface ServiceDTO<T,V> {
	
	public List<V> getAll();

	public V read(long id);
	
	public T insert (V v);
	
	public T update (V v);
	
	public void delete (V v);
}