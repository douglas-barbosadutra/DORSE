package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import it.contrader.converter.Converter;
import it.contrader.dao.MyRepository;

@Service
public abstract class AbstractService<Entity,DTO> implements ServiceDTO<Entity,DTO> {
	
	@Autowired
	protected MyRepository<Entity,Long> myRepository;
	@Autowired
	protected Converter<Entity,DTO> converter;
	
	@Override
	public Entity insert(DTO dto) {
		return myRepository.save(converter.toEntity(dto));
	}

	@Override
	public List<DTO> getAll() {
		Iterable<Entity> iter = myRepository.findAll();
		List<DTO> list = new ArrayList<>();
		for (Entity item : iter) {
	        list.add(converter.toDTO(item));
	    }
		return list;
	}
	
	@Override
	public List<DTO> getAllBy(long id) {
		List<Entity> iter = myRepository.findAllBy(id);
		List<DTO> list = new ArrayList<>();
		for (Entity item : iter) {
	        list.add(converter.toDTO(item));
	    }
		return list;
	}

	@Override
	public DTO read(long id) {
		return converter.toDTO(myRepository.findById(id).get());
	}

	@Override
	public Entity update(DTO dto) {
		return myRepository.save(converter.toEntity(dto));
	}

	@Override
	public void delete(long id) {
		myRepository.deleteById(id);
	}
}