import { Component, OnInit, Input } from '@angular/core';
import { RoomDTO } from 'src/app/dto/roomdto';
import { ActivatedRoute } from '@angular/router';
import { RoomService } from 'src/app/services/room.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {

    @Input() room: RoomDTO;
  constructor(private route: ActivatedRoute,
              private roomService: RoomService,
              private location: Location) { }

  ngOnInit(): void {
       this.read();

  }

  read(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.roomService.read(id).subscribe(room => this.room = room);
}
  goBack(): void {
    this.location.back();

  }


  update(): void {
    this.roomService.update(this.room).subscribe(() => this.goBack());

  }
}
