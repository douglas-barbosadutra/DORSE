import { Component, OnInit } from '@angular/core';
import { ApartmentDTO } from 'src/app/dto/apartmentdto';
import { RoomDTO } from 'src/app/dto/roomdto';
import { ActivatedRoute } from '@angular/router';
import { ApartmentService } from 'src/app/services/apartment.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-apartment-details',
  templateUrl: './apartment-details.component.html',
  styleUrls: ['./apartment-details.component.css']
})
export class ApartmentDetailsComponent implements OnInit {

    apartment = new ApartmentDTO();
    room = new RoomDTO();
    route: ActivatedRoute;
    apartmentService: ApartmentService;
    location: Location;

    constructor( route: ActivatedRoute, apartmentService: ApartmentService, location: Location) {
        this.apartmentService = apartmentService;
        this.route = route;
        this.location = location;
    }

    ngOnInit() {
        if ( +this.route.snapshot.paramMap.get('id') !== 0) {
            this.read();
        }
    }

     update(): void {
      this.apartment.roomsDTO.push(this.room);
      this.apartmentService.update(this.apartment).subscribe(apartment => this.apartment = apartment );
    }

    goBack(): void {
      this.location.back();
  }

    read(): ApartmentDTO {
      const id = +this.route.snapshot.paramMap.get('id');
      this.apartmentService.read(id).subscribe(apartment => this.apartment = apartment);
      return this.apartment;
  }

}
