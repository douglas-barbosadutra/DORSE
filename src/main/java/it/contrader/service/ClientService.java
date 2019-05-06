package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.contrader.converter.ClientConverter;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

@Service
public class ClientService extends AbstractService<Client, ClientDTO> {
	
	@Autowired
	public ClientService(CrudRepository<Client,Long> crudRepository) {
		this.crudRepository = crudRepository;
		converter = new ClientConverter();
	}
	
}
