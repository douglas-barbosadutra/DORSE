import { Component, OnInit } from '@angular/core';
import { ApartmentDTO } from '../../dto/apartmentdto';
import { ApartmentService } from '../../services/apartment.service';

@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.css']
})
export class ApartmentComponent implements OnInit {

  apartments: ApartmentDTO[];
  apartment: ApartmentDTO;

  constructor(private apartmentService: ApartmentService) { }

  ngOnInit() {
      this.getAll();
  }

  getAll(): void {
      this.apartmentService.getAll().subscribe(apartments => this.apartments = apartments);
  }

  delete(id: number ) {
      this.apartmentService.delete(id).subscribe(apartment => this.getAll());
  }

  insert(address: string): void {
      this.apartment = new ApartmentDTO();
      this.apartment.address = address;
      this.apartment.tutorDTO = JSON.parse(localStorage.getItem('currentuser'));
      this.apartmentService.insert(this.apartment).subscribe(apartment => this.getAll());
  }

}
