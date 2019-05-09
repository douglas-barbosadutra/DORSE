import { Component, OnInit, Input } from '@angular/core';
import { ApartmentDTO } from 'src/app/dto/apartmentdto';
import { ApartmentService } from 'src/app/services/apartment.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-apartment-details',
  templateUrl: './apartment-details.component.html',
  styleUrls: ['./apartment-details.component.css']
})
export class ApartmentDetailsComponent implements OnInit {
    
  @Input() apartment: ApartmentDTO;

  constructor(private route: ActivatedRoute, private apartmentService: ApartmentService, private location: Location) {
      
  }

  ngOnInit() {
      this.getApartment();
  }
  
  getApartment(): void {
      const id = +this.route.snapshot.paramMap.get('id');
      this.apartmentService.getApartment(id).subscribe(apartment => this.apartment = apartment);
  }
  
  save(): void {
      this.apartmentService.update(this.apartment).subscribe(() => this.goBack());
  }
  
  goBack(): void {
      this.location.back();
  }
}
