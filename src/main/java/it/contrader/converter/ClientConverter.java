package it.contrader.converter;

import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

public class ClientConverter implements Converter<Client, ClientDTO> {

	@Override
	public Client toEntity(ClientDTO clientDTO) {

		Client client = new Client();
		if (clientDTO != null) {
			client.setId(clientDTO.getId());
			client.setName(clientDTO.getName());
			client.setSurname(clientDTO.getSurname());
			client.setApartment(clientDTO.getApartment());
			client.setBirthdate(clientDTO.getBirthdate());
			client.setTelnumber(clientDTO.getTelnumber());
			client.setTutor(clientDTO.getTutor());
			client.setDiseases(clientDTO.getDiseases());
		}
		return client;
	}

	@Override
	public ClientDTO toDTO(Client client) {

		ClientDTO clientDTO = new ClientDTO();
		if (client != null) {
			clientDTO.setId(client.getId());
			clientDTO.setName(client.getName());
			clientDTO.setSurname(client.getSurname());
			clientDTO.setApartment(client.getApartment());
			clientDTO.setBirthdate(client.getBirthdate());
			clientDTO.setTelnumber(client.getTelnumber());
			clientDTO.setTutor(client.getTutor());
			clientDTO.setDiseases(client.getDiseases());
		}

		return clientDTO;
	}

}
