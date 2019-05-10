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
        roomtoinsert: RoomDTO;

        constructor(private roomService: RoomService) { }

         ngOnInit() {
             this.getAll();
             this.roomtoinsert = new RoomDTO();
        }

        getAll(){
            this.roomService.getAll().subscribe(rooms => this.rooms = rooms);
        }

        delete(id: number ) {
        console.log('room.ts ok');
        this.roomService.delete(id).subscribe(room => this.getAll());

    }

    insert(newroom: string): void {
        this.roomtoinsert.description = newroom;
        this.roomService.insert(this.roomtoinsert).subscribe(room => this.getAll());

    }
}
