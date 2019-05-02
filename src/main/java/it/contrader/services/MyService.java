package it.contrader.services;

import java.util.List;

public interface MyService<Entity,DTO> {
	
	public List<DTO> getAll();

	public DTO read(long id);
	
	public Entity insert (DTO dto);
	
	public Entity update (DTO dto);
	
	public void delete (DTO dto);
}