package it.contrader.service;

import java.util.List;
import java.util.Optional;

public interface Service<DTO> {
	
	public List<DTO> findAll();
	
	public List<DTO> findAllBy(Long id);

	public Optional<DTO> findOne(Long id);
	
	public DTO save (DTO dto);
	
	public void delete (Long id);
}