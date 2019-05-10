package it.contrader.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ServiceDTO<Entity,DTO> {
	
	public List<DTO> getAll();
	
	public List<DTO> getAllBy(Object o);

	public DTO read(long id);
	
	public Entity insert (DTO dto);
	
	public Entity update (DTO dto);
	
	public void delete (long id);
}