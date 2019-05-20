import { Component, OnInit, Input } from '@angular/core';
import { ThingDTO } from 'src/app/dto/thingdto';
import { ItemDTO } from 'src/app/dto/itemdto';
import { ItemService } from 'src/app/services/item.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

    @Input() thing: ThingDTO;
    item: ItemDTO;
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
      this.item = new ItemDTO();
      this.item = this.read();
      this.route.params.subscribe(() => this.item = this.read());

  }

  read(): ItemDTO {
    this.id = +this.route.snapshot.paramMap.get('id');
    this. itemService.read(this.id).subscribe( item => this.item =  item);
    return this.item;
  }

}
