import { Component, OnInit } from '@angular/core';
import { ApartmentDTO } from '../../dto/apartmentdto';
import { ApartmentService } from '../../services/apartment.service';
import { AbstractComponent } from '../abstract/abstract.component';
import { interval } from 'rxjs';
import { startWith, switchMap } from 'rxjs/operators';


@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.css']
})
export class ApartmentComponent extends AbstractComponent<ApartmentDTO> implements OnInit {

    constructor(service: ApartmentService) {
        super(service);
    }

    ngOnInit() {
        this.currentEntity = 'currentUser';
        this.dtolist = this.getAllBy();
        this.insdto = new ApartmentDTO();
        this.dto = new ApartmentDTO();
        this.insdto.tutorDTO = JSON.parse(localStorage.getItem(this.currentEntity));
    }

}
