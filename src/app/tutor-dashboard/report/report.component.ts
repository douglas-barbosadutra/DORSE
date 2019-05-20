import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  constructor(route: ActivatedRoute, itemService: ItemService, location: Location) {
      
  }

  ngOnInit() {
  }

}
