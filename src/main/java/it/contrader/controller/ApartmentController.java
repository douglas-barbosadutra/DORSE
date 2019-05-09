package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ApartmentDTO;
import it.contrader.model.Apartment;


@RestController
@RequestMapping("/apartment")
@CrossOrigin(origins = "http://localhost:4200")
public class ApartmentController extends AbstractController<Apartment, ApartmentDTO> {

}
