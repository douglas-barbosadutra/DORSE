package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dao.ClientRepository;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;
import it.contrader.model.Tutor;

@Service
public class ClientService extends AbstractService<Client, ClientDTO> {
	
	@Override
	public List<ClientDTO> getAllBy(Object o) {
		return converter.toDTOList(((ClientRepository)crudRepository).findByTutor_id(((Tutor)o).getId()));
	}
}
