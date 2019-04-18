package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.contrader.converter.OperatorConverter;
import it.contrader.dto.OperatorDTO;
import it.contrader.model.Operator;

@Service
public class OperatorService extends AbstractService<Operator,OperatorDTO> {

	@Autowired
	public OperatorService(CrudRepository<Operator,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new OperatorConverter();
	}
}
