package it.contrader.service.impl;

import it.contrader.service.AbstractService;
import it.contrader.domain.Item;

import it.contrader.service.dto.ItemDTO;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Item.
 */
@Service
@Transactional
public class ItemService extends AbstractService<Item, ItemDTO>{
	
}

   