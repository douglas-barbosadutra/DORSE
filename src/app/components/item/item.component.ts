import { Component, OnInit } from '@angular/core';
import { AbstractComponent } from '../abstract/abstract.component';
import { ItemDTO } from 'src/app/dto/itemdto';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent extends AbstractComponent<ItemDTO> implements OnInit {

  constructor(service: ItemService) {
      super(service);
  }

  ngOnInit() {
    this.getAll();
  }

}
