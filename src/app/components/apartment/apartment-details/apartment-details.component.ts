import { Component, OnInit } from '@angular/core';
import { ApartmentDTO } from 'src/app/dto/apartmentdto';
import { ApartmentService } from 'src/app/services/apartment.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { AbstractDetailsComponent } from '../../abstract/abstract-details/abstract-details.component';
import { RoomDTO } from 'src/app/dto/roomdto';

@Component({
  selector: 'app-apartment-details',
  templateUrl: './apartment-details.component.html',
  styleUrls: ['./apartment-details.component.css']
})
export class ApartmentDetailsComponent extends AbstractDetailsComponent<ApartmentDTO, RoomDTO> implements OnInit {


    constructor( route: ActivatedRoute, service: ApartmentService, location: Location) {
      super(route, service, location);
    }

    ngOnInit() {
        this.dto = new ApartmentDTO();
        this.subdto = new RoomDTO();
        this.dto = this.read();
    }

}
