import { Component, OnInit } from '@angular/core';
import { AbstractComponent } from '../../abstract/abstract.component';
import { ItemDTO } from 'src/app/dto/itemdto';
import { ItemService } from 'src/app/services/item.service';



@Component({
  selector: 'app-testuser-dashboard',
  templateUrl: './testuser-dashboard.component.html',
  styleUrls: ['./testuser-dashboard.component.css']
})
export class TestuserDashboardComponent extends AbstractComponent<ItemDTO> implements OnInit {

  constructor(service: ItemService) {
      super(service);
  }

  ngOnInit() {
    this.getAll();
  }

}
