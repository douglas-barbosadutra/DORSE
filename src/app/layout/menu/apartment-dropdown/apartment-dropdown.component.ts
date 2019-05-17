import { Component, OnInit } from '@angular/core';
import { ApartmentService } from 'src/app/services/apartment.service';
import { ApartmentDTO } from 'src/app/dto/apartmentdto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-apartment-dropdown',
  templateUrl: './apartment-dropdown.component.html',
  styleUrls: ['../menu.component.css']
})
export class ApartmentDropdownComponent implements OnInit {

    apartmentService: ApartmentService;
    apartments: ApartmentDTO[];
    insapartment: ApartmentDTO;
    id: number;
    route: ActivatedRoute;
    dropdown: HTMLCollectionOf<Element>  = document.getElementsByClassName('dropdown-btn');
    array = new Array<Element>();
    selectedapt: ApartmentDTO;

    constructor(apartmentService: ApartmentService, route: ActivatedRoute) {
        this.apartmentService = apartmentService;
        this.route = route;
    }


 ngOnInit() {
      this.apartments = this.getAllBy();
      this.insapartment = new ApartmentDTO();
      this.insapartment.tutorDTO = JSON.parse(localStorage.getItem('currentUser'));
      this.route.params.subscribe(() => this.getAllBy());
      this.pippo();
  }

    pippo() {
        this.array = Array.from(this.dropdown);
        for (const element of this.array) {
            element.addEventListener('click', function() {
                this.classList.toggle('active');
                const dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === 'block') {
                    dropdownContent.style.display = 'none';
                } else {
                    dropdownContent.style.display = 'block';
                }
            });
        }
        this.route.params.subscribe(() => this.getAllBy());
    }


  onSelect(apartment: ApartmentDTO) {
      this.selectedapt = apartment;
      localStorage.setItem('currentApartment', JSON.stringify(apartment));
      console.log(localStorage.getItem('currentApartment'));
  }

  getAllBy(): ApartmentDTO[] {
        this.id = JSON.parse(localStorage.getItem('currentUser')).id;
        this.apartmentService.getAllBy(this.id).subscribe(apartments => this.apartments = apartments);
        return this.apartments;
    }

 insert() {
        this.apartmentService.insert(this.insapartment).subscribe(() => this.getAllBy());
    }
}
