package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.contrader.converter.ApartmentConverter;
import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;

@Service
public class ApartmentService extends AbstractService<Apartment, ApartmentDTO> {

	@Autowired
	public ApartmentService(CrudRepository<Apartment,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new ApartmentConverter();
	}
}
