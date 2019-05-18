package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.Converter;
import it.contrader.dao.MyRepository;

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
	public Iterable<DTO> getAll() {
		return converter.toDTOList(myRepository.findAll());
	}
	
	//GETS all entities depending on id of a parameter, see (Entity)Repository
	@Override
	public Iterable<DTO> getAllBy(long id) {
		return converter.toDTOList(myRepository.findAllBy(id));
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