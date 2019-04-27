package it.contrader.converter;


//T = entity, V = DTO
public interface Converter<T,V> {

	public T toEntity(V v);
	
	public V toDTO(T t);

}