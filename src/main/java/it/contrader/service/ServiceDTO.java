package it.contrader.service;

import java.util.List;

public interface ServiceDTO<Entity,DTO> {
	
	public List<DTO> getAll();

	public DTO read(long id);
	
	public Entity insert (DTO dto);
	
	public Entity update (DTO dto);
	
	public void delete (long id);
}