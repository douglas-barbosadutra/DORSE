import { Component, OnInit } from '@angular/core';
import {RoomDTO} from 'src/app/dto/roomdto';
import { RoomService } from 'src/app/services/room.service';


@Component({
        selector: 'app-room',
        templateUrl: './room.component.html',
        styleUrls: ['./room.component.css']
        })
        export class RoomComponent implements OnInit {

        rooms: RoomDTO[];

         selectedRoom: RoomDTO;

       onSelect(room: RoomDTO): void {
            this.selectedRoom = room;
        }

        constructor(private roomService: RoomService) { }

         ngOnInit() {
             this.getRooms();
        }
// tslint:disable-next-line: one-line
        getRooms(){
            this.roomService.getRooms().subscribe(rooms => this.rooms = rooms);
        }

        delete(id: number ) {
        console.log('room.ts ok');
        this.roomService.delete(id);

    }
}
