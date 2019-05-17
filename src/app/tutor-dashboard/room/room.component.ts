import { Component, OnInit } from '@angular/core';
import { RoomDTO } from 'src/app/dto/roomdto';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RoomService } from 'src/app/services/room.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

    room = new RoomDTO();
    route: ActivatedRoute;
    roomService: RoomService;
    location: Location;

    constructor( route: ActivatedRoute, roomService: RoomService, location: Location) {
        this.roomService = roomService;
        this.route = route;
        this.location = location;
    }

    ngOnInit() {
        if ( +this.route.snapshot.paramMap.get('id') !== 0) {
            this.read();
        }
        this.route.params.subscribe(
        (params) => this.read());
    }

     update(): void {
      this.roomService.update(this.room).subscribe(room => this.room = room );
    }

    goBack(): void {
      this.location.back();
  }

    read(): RoomDTO {
      const id = +this.route.snapshot.paramMap.get('id');
      this.roomService.read(id).subscribe(room => this.room = room);
      return this.room;
  }

 delete() {
        this.roomService.delete(this.room.id).subscribe(() => this.location.back());
        this.location.back();
    }
}
