package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<Entity,DTO> implements Converter<Entity,DTO>{

	public List<Entity> toEntityList(List<DTO> dtoList) {
		List<Entity> entityList = new ArrayList<>();
		for (DTO dto : dtoList) {
			entityList.add(toEntity(dto));
		}
		return entityList;
	}
	
	public List<DTO> toDTOList(List<Entity> entityList) {
		List<DTO> dtoList = new ArrayList<>();
		for (Entity entity : entityList) {
			dtoList.add(toDTO(entity));
		}
		return dtoList;
	}
}
