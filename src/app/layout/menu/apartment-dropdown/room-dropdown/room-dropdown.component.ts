import { Component, OnInit, Input } from '@angular/core';
import { RoomDTO } from 'src/app/dto/roomdto';
import { RoomService } from 'src/app/services/room.service';
import { ApartmentDTO } from 'src/app/dto/apartmentdto';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-room-dropdown',
  templateUrl: './room-dropdown.component.html',
  styleUrls: ['../../menu.component.css']
})
export class RoomDropdownComponent implements OnInit {

    @Input() apartment: ApartmentDTO;
    roomService: RoomService;
    rooms: RoomDTO[];
    insroom: RoomDTO;
    id: number;
    route: ActivatedRoute;
    dropdown: HTMLCollectionOf<Element>  = document.getElementsByClassName('dropdown-btn');
    array = new Array<Element>();


    constructor(roomService: RoomService, route: ActivatedRoute) {
        this. roomService =  roomService;
        this.route = route;
    }

 ngOnInit() {
      this.rooms = this.getAllBy();
      this.insroom = new RoomDTO();
      this.insroom.apartmentDTO = this.apartment;
      this.route.params.subscribe(
        () => this.rooms = this.getAllBy());
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


  onSelect(room: RoomDTO) {
      localStorage.setItem('currentApartment', JSON.stringify(room));
  }

  getAllBy(): RoomDTO[] {
        this.id = JSON.parse(localStorage.getItem('currentApartment')).id;
        this. roomService.getAllBy(this.id).subscribe( rooms => this. rooms =  rooms);
        return this. rooms;
    }

 insert() {
        this.roomService.insert(this.insroom).subscribe(() => this.getAllBy());
    }
}
