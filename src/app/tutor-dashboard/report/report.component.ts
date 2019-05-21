import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { EventDTO } from 'src/app/dto/eventdto';
import { EventService } from 'src/app/services/event.service';
import { ItemDTO } from 'src/app/dto/itemdto';
import { ItemService } from 'src/app/services/item.service';
import { DateDTO } from 'src/app/dto/datedto';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

    events: EventDTO[];
    items: ItemDTO[];
    eventCount: number[][];
    item: ItemDTO;

  constructor(private route: ActivatedRoute, private eventService: EventService, private itemService: ItemService) {
  }

  ngOnInit() {
      this.items = new Array<ItemDTO>();
      this.getAll();
}

  getAllByItemAndDate(id: number, date: Date): EventDTO[] {
    this.eventService.getAllByItemAndDate(id, date).subscribe(events => this.events = events);
    return this.events;
  }

  getAll() {
    this.itemService.getAll().subscribe(items => {
        this.items = items;
        this.buildMatrix()} );
  }

  buildMatrix() {
      const date: Date = new Date();
      const n: number = date.getDate();
      const w: number = date.getDay();
      for (let i = 0; i < this.items.length; i++) {;
          this.item = this.items[i];
          for (let j = 0; j < 7; j++) {
              // SETS the date considering today's date (n), today's weekday (w) and what day we want to display (j);
              date.setDate(n - ( ( w - j ) ) );
              this.eventCount[i][j] = this.getAllByItemAndDate(this.item.id, date ).length;
        }
  }


  }
}

