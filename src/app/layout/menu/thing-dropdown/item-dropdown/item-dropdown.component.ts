import { Component, OnInit, Input } from '@angular/core';
import { ThingDTO } from 'src/app/dto/thingdto';
import { ItemDTO } from 'src/app/dto/itemdto';
import { ItemService } from 'src/app/services/item.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-item-dropdown',
  templateUrl: './item-dropdown.component.html',
  styleUrls: ['../../menu.component.css']
})
export class ItemDropdownComponent implements OnInit {

    @Input() thing: ThingDTO;
    items: ItemDTO[];
    itemService: ItemService;
    route: ActivatedRoute;
    location: Location;
    id: number;

  constructor( route: ActivatedRoute, itemService: ItemService, location: Location) {
        this.itemService = itemService;
        this.route = route;
        this.location = location;
    }
  ngOnInit() {
      this.items = new Array<ItemDTO>();
      this.items = this.getAllBy();
      this.route.params.subscribe(() => this.items = this.getAllBy());

  }

  getAllBy(): ItemDTO[] {
        this.id = this.thing.id;
        this. itemService.getAllBy(this.id).subscribe( items => this. items =  items);
        return this.items;
    }
}
