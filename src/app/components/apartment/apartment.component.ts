import { Component, OnInit } from '@angular/core';
import { ApartmentDTO } from '../../dto/apartmentdto';
import { ApartmentService } from '../../services/apartment.service';
import { TutorDTO } from 'src/app/dto/tutordto';

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
      this.getAllBy(JSON.parse(localStorage.getItem('currentuser')));
  }

  getAll(): void {
      this.apartmentService.getAll().subscribe(apartments => this.apartments = apartments);
  }

  getAllBy(tutorDTO: TutorDTO) {
       this.apartmentService.getAllBy(tutorDTO).subscribe(apartments => this.apartments = apartments);

  }



  delete(id: number ) {
      this.apartmentService.delete(id).subscribe(apartment => this.getAllBy(JSON.parse(localStorage.getItem('currentuser'))));
  }

  insert(address: string): void {
      this.apartment = new ApartmentDTO();
      this.apartment.address = address;
      this.apartment.tutorDTO = JSON.parse(localStorage.getItem('currentuser'));
      this.apartmentService.insert(this.apartment).subscribe(apartment => this.getAllBy(JSON.parse(localStorage.getItem('currentuser'))));
  }

}
