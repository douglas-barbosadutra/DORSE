package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDTO> {

	@Autowired
	private ApartmentConverter apartmentConverter;
	@Autowired
	private TutorConverter tutorConverter;
	
	public ClientConverter() {
	}
	
	@Override
	public Client toEntity(ClientDTO clientDTO) {

		Client client = new Client();
		if (clientDTO != null) {
			client.setId(clientDTO.getId());
			client.setName(clientDTO.getName());
			client.setSurname(clientDTO.getSurname());
			client.setApartment(apartmentConverter.toEntity(clientDTO.getApartmentDTO()));
			client.setTutor(tutorConverter.toEntity(clientDTO.getTutorDTO()));
			client.setBirthdate(clientDTO.getBirthdate());
			client.setTelnumber(clientDTO.getTelnumber());
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
			clientDTO.setApartmentDTO(apartmentConverter.toDTO(client.getApartment()));
			clientDTO.setTutorDTO(tutorConverter.toDTO(client.getTutor()));
			clientDTO.setBirthdate(client.getBirthdate());
			clientDTO.setTelnumber(client.getTelnumber());
			clientDTO.setDiseases(client.getDiseases());
		}

		return clientDTO;
	}
}
