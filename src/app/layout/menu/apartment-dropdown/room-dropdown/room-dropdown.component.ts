import { Component, OnInit, Input } from '@angular/core';
import { RoomDTO } from 'src/app/dto/roomdto';
import { RoomService } from 'src/app/services/room.service';
import { ApartmentDTO } from 'src/app/dto/apartmentdto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-room-dropdown',
  templateUrl: './room-dropdown.component.html',
  styleUrls: ['../../menu.component.css']
})
export class RoomDropdownComponent implements OnInit {

    @Input() apartment: ApartmentDTO;
    roomService: RoomService;
    rooms: RoomDTO[];
    insroom: RoomDTO;
    id: number;
    route: ActivatedRoute;
    selectedroom: RoomDTO;

    constructor(roomService: RoomService, route: ActivatedRoute) {
        this. roomService =  roomService;
        this.route = route;
    }

 ngOnInit() {
      this.getAllBy();
      this.insroom = new RoomDTO();
      this.insroom.apartment = this.apartment;
      this.route.params.subscribe(() =>  this.getAllBy());
  }

  getAllBy() {
        this.id = this.apartment.id;
        this. roomService.getAllBy(this.id).subscribe( rooms => this. rooms =  rooms);

    }

 insert() {
        this.roomService.insert(this.insroom).subscribe(() => this.getAllBy());
    }

    select(room: RoomDTO) {
        this.selectedroom = room;
        localStorage.setItem('currentRoom', JSON.stringify(room));
    }

}
