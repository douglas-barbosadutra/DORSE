package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

public class ClientConverter implements Converter<Client, ClientDTO> {

	@Autowired
	private ApartmentConverter apartmentConverter;
	@Autowired
	private TutorConverter tutorConverter;
	
	@Override
	public Client toEntity(ClientDTO clientDTO) {

		Client client = new Client();
		if (clientDTO != null) {
			client.setId(clientDTO.getId());
			client.setName(clientDTO.getName());
			client.setSurname(clientDTO.getSurname());
			client.setApartment(apartmentConverter.toEntity(clientDTO.getApartmentDTO()));
			client.setBirthdate(clientDTO.getBirthdate());
			client.setTelnumber(clientDTO.getTelnumber());
			client.setTutor(tutorConverter.toEntity(clientDTO.getTutorDTO()));
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
			clientDTO.setBirthdate(client.getBirthdate());
			clientDTO.setTelnumber(client.getTelnumber());
			clientDTO.setTutorDTO(tutorConverter.toDTO(client.getTutor()));
			clientDTO.setDiseases(client.getDiseases());
		}

		return clientDTO;
	}

	public List<Client> toEntityList (List<ClientDTO> listDTO){
		List<Client> list = new ArrayList<Client>();

		if(listDTO != null) {
			for (ClientDTO cDTO:listDTO) {
				Client c = toEntity(cDTO);
				list.add(c);
			}
		}
		return list;
	}

	public List<ClientDTO> toDTOList(List<Client> list){

		List<ClientDTO> listDTO = new ArrayList<ClientDTO>();
		if(listDTO != null) {
			for (Client c:list) {
				ClientDTO cDTO = toDTO(c);
				listDTO.add(cDTO);
			}
		}
		return listDTO;
	}
}
