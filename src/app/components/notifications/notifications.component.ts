import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/app/services/item.service';
import { interval } from 'rxjs';
import { startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  constructor(public service: ItemService) { }
    itemstatus: boolean;

  ngOnInit() {
interval(1000)
            .pipe(
                startWith(0),
                switchMap(() => this.service.read(1))
                )
                .subscribe(dto => this.itemstatus = dto.status);
  }

}
