package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.ClientDTO;
import it.contrader.model.Client;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDTO> {

}
