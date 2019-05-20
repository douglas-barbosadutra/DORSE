import { Component, OnInit } from '@angular/core';
import { RoomDTO } from 'src/app/dto/roomdto';
import { ThingService } from 'src/app/services/thing.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ThingDTO } from 'src/app/dto/thingdto';
import { ItemDTO } from 'src/app/dto/itemdto';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-thing',
  templateUrl: './thing.component.html',
  styleUrls: ['./thing.component.css']
})
export class ThingComponent implements OnInit {

    room: RoomDTO;
    things: ThingDTO[];
    thingService: ThingService;
    itemService: ItemService;
    route: ActivatedRoute;
    location: Location;
    id: number;
    selectedthing: ThingDTO;
    insitem: ItemDTO;

  constructor( route: ActivatedRoute, thingService: ThingService, location: Location, itemService: ItemService) {
        this.thingService = thingService;
        this.itemService = itemService;
        this.route = route;
        this.location = location;
    }
  ngOnInit() {
      this.insitem = new ItemDTO();
      this.insitem.thingDTO = JSON.parse(localStorage.getItem('currentThing'));
      this.things = new Array<ThingDTO>();
      this.things = this.getAllBy();
      console.log(this.things);
      this.route.params.subscribe(() => this.things = this.getAllBy());

  }

  getAllBy(): ThingDTO[] {
        this.id = JSON.parse(localStorage.getItem('currentRoom')).id;
        this. thingService.getAllBy(this.id).subscribe( things => this. things =  things);
        return this.things;
    }

    select(thing: ThingDTO) {
        this.selectedthing = thing;
    }

    insert() {
        this.itemService.insert(this.insitem).subscribe();
    }
}
