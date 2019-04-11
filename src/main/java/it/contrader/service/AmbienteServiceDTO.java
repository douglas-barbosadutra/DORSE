package it.contrader.service;

import it.contrader.converter.AmbienteConverter;
import it.contrader.dao.AmbienteDAO;
import it.contrader.dto.AmbienteDTO;
import it.contrader.model.Ambiente;


public class AmbienteServiceDTO extends AbstractServiceDTO<Ambiente,AmbienteDTO> {

	public AmbienteServiceDTO() {
		dao = new AmbienteDAO();
		converter = new AmbienteConverter();
	}

}
