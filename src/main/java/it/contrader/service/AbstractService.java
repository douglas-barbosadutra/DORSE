package it.contrader.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;

//T = entity, V = DTO
@Service
public abstract class AbstractService<T,V> implements ServiceDTO<T,V> {
	
	protected CrudRepository<T,Long> crudRepository;
	protected Converter<T,V> converter;
	
	public AbstractService() {
	}

	@Override
	public T insert(V v) {
		return crudRepository.save(converter.toEntity(v));
	}

	@Override
	public List<V> getAll() {
		Iterable<T> iter = crudRepository.findAll();
		List<V> list = new ArrayList<>();
		for (T item : iter) {
	        list.add(converter.toDTO(item));
	    }
		return list;
	}

	@Override
	public V read(long id) {
		return converter.toDTO(crudRepository.findById(id).get());
	}

	@Override
	public T update(V v) {
		return crudRepository.save(converter.toEntity(v));
	}

	@Override
	public void delete(V v) {
		crudRepository.delete(converter.toEntity(v));
	}
}