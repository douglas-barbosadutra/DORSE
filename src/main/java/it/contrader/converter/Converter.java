package it.contrader.converter;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface Converter<Entity,DTO> {

	public Entity toEntity(DTO dto);
	
	public DTO toDTO(Entity entity);
	
	public List<DTO> toDTOList(List<Entity> listEntity);
	
	public List<Entity> toEntityList(List<DTO> listDTO);
}