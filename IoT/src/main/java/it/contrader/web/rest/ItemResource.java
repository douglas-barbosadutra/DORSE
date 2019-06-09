package it.contrader.web.rest;


import it.contrader.service.dto.ItemDTO;

import org.springframework.web.bind.annotation.*;



/**
 * REST controller for managing Item.
 */
@RestController
@RequestMapping("/api/item")
public class ItemResource extends AbstractResource<ItemDTO>{

}  