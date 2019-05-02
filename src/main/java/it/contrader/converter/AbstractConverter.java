package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

//T = entity, V = DTO
public abstract class AbstractConverter<T,V> implements Converter<T,V> {

	public List<T> toEntityList (List<V> listDTO) {
		List<T> list = new ArrayList<T>();

		if(listDTO != null) {
			for (V dto:listDTO) {
				T entity = toEntity(dto);
				list.add(entity);
			}
		}
		return list;
	}
	
	public List<V> toDTOList (List<T> listEntity) {
		List<V> list = new ArrayList<V>();

		if(listEntity != null) {
			for (T entity:listEntity) {
				V dto = toDTO(entity);
				list.add(dto);
			}
		}
		return list;
	}
}
