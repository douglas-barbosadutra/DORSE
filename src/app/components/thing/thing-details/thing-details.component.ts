import { Component, OnInit } from '@angular/core';
 import { ThingDTO } from 'src/app/dto/thingdto';
    import { ActivatedRoute } from '@angular/router';
    import { Location } from '@angular/common';
    import { ThingService } from 'src/app/services/thing.service';
@Component({
  selector: 'app-thing-details',
  templateUrl: './thing-details.component.html',
  styleUrls: ['./thing-details.component.css']
})
export class ThingDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
