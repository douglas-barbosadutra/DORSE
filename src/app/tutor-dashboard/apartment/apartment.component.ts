import { Component, OnInit } from '@angular/core';
import { ApartmentDTO } from '../../dto/apartmentdto';
import { ApartmentService } from '../../services/apartment.service';
import { RoomDTO } from 'src/app/dto/roomdto';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.css']
})
export class ApartmentComponent implements OnInit {

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
        this.route.params.subscribe(
        (params) => this.read());
    }

     update(): void {
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

 delete() {
        this.apartmentService.delete(this.apartment.id).subscribe(() => this.location.back());
        this.location.back();
    }


}
