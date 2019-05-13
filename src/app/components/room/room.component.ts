import { Component, OnInit } from '@angular/core';
import {RoomDTO} from 'src/app/dto/roomdto';
import { RoomService } from 'src/app/services/room.service';
import { AbstractComponent } from '../abstract/abstract.component';


@Component({
        selector: 'app-room',
        templateUrl: './room.component.html',
        styleUrls: ['./room.component.css']
        })
        export class RoomComponent extends AbstractComponent<RoomDTO> implements OnInit {


        constructor(service: RoomService) {
            super(service);
        }

         ngOnInit() {
             this.currentEntity = 'currentApartment'
             this.getAll();
             this.dto = new RoomDTO();
        }


}
