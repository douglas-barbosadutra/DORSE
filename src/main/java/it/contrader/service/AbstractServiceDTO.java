package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.Converter;
import it.contrader.dao.DAO;

// T = entity, V = DTO
public class AbstractServiceDTO<T,V> implements ServiceDTO<V> {
	
	protected DAO<T> dao;
	protected Converter<T,V> converter;
	
	public AbstractServiceDTO() {
	}
	
	@Override
	public List<V> getAll() {
		List<T> list = dao.getAll();
		List<V> listDTO = new ArrayList<>();

		for (T t : list) {
			listDTO.add(converter.toDTO(t));
		}
		return listDTO;
	}
	
	@Override
	public List<V> getAllBy(Object o) {
		List<T> list = dao.getAllBy(o);
		List<V> listDTO = new ArrayList<>();

		for (T t : list) {
			listDTO.add(converter.toDTO(t));
		}
		return listDTO;
	}
	
	@Override
	public V read(int id) {
		return converter.toDTO(dao.read(id));
	}
	
	@Override
	public V read(String param1, String param2) {
		return converter.toDTO(dao.read(param1,param2));
	}

	@Override
	public boolean insert(V dto) {
		return dao.insert(converter.toEntity(dto));
	}

	@Override
	public boolean update(V dto) {
		return dao.update(converter.toEntity(dto));
	}

	@Override
	public boolean delete(V dto) {
		return dao.delete(converter.toEntity(dto));
	}
}
